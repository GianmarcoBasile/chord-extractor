from chord_extractor import ChordChange
from typing import Dict, List, TypedDict, Tuple
import re

class ChordDict(TypedDict):
    chord: str
    timestamp: float

NOTE_TO_INDEX:Dict[str,int] = {
    "C": 0, "C#": 1, "Db": 1,
    "D": 2, "D#": 3, "Eb": 3,
    "E": 4,
    "F": 5, "F#": 6, "Gb": 6,
    "G": 7, "G#": 8, "Ab": 8,
    "A": 9, "A#": 10, "Bb": 10,
    "B": 11
}

INDEX_TO_NOTE_SHARP = ["C","C#","D","D#","E","F","F#","G","G#","A","A#","B"]
INDEX_TO_NOTE_FLAT  = ["C","Db","D","Eb","E","F","Gb","G","Ab","A","Bb","B"]

def split_chord(chord: str) -> Tuple[str, str]:
    """
    Divide l'accordo in root (es. C, F#) e suffisso (es. m7, maj7)
    """
    match = re.match(r"([A-G][#b]?)(.*)", chord)
    if match:
        return match.group(1), match.group(2)
    return chord, ""

def transpose_root(root: str, value: int, prefer_sharp: bool = True) -> str:
    # Ottieni indice logico
    idx = NOTE_TO_INDEX[root]
    new_idx = (idx + value) % 12

    # Scegli notazione finale
    if prefer_sharp:
        return INDEX_TO_NOTE_SHARP[new_idx]
    else:
        return INDEX_TO_NOTE_FLAT[new_idx]

def compute_transposed_chord(chord: str, value: int, prefer_sharp: bool = True) -> str:
    """
    Traspone un accordo completo, root, suffisso e basso incluso
    """
    parts = chord.split("/")
    root, suffix = split_chord(parts[0])
    new_root = transpose_root(root, value, prefer_sharp)

    if len(parts) > 1:
        bass_root, bass_suffix = split_chord(parts[1])
        new_bass = transpose_root(bass_root, value, prefer_sharp)
        return f"{new_root}{suffix}/{new_bass}{bass_suffix}"
    else:
        return f"{new_root}{suffix}"

def transpose(chords: List[ChordChange], value: int, prefer_sharp: bool = True) -> List[ChordChange]:
    """
    Traspone una lista di ChordChange di `value` semitoni
    """
    transposed: List[ChordChange] = []
    for c in chords:
        if c.chord != "N":
            new_chord = compute_transposed_chord(c.chord, value, prefer_sharp)
            transposed.append(ChordChange(new_chord, c.timestamp))
        else:
            transposed.append(ChordChange(c.chord, c.timestamp))
    return transposed

def parse_chords(chords: List[ChordChange])->List[ChordDict]:
    return [{"chord": c.chord, "timestamp": c.timestamp} for c in chords]