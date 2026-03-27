from chord_extractor import ChordChange
from typing import List, Tuple

sharp_scale:List[str] = ["C","C#","D","D#","E","F","F#","G","G#","A", "A#","B"]
flat_scale:List[str] = ["C","Db","D","Eb","E","F","Gb","G","Ab","A", "Bb","B"]

def swap_chords(old_chord: str, new_computed_chord: str) -> str:
  if len(old_chord) > 1 and (old_chord[1] == "#" or old_chord[1] == 'b'):
    new_computed_chord = new_computed_chord + old_chord[2:]
  else:
    new_computed_chord = new_computed_chord + old_chord[1:]
  return new_computed_chord

def compute_transposed_chord(chord:str, value:int, scale:str) -> str:
  parts = chord.split("/")
  old_chord:str = parts[0]
  bass_old_chord:str = ""
  if len(parts) > 1:
    bass_old_chord = parts[1]

  if scale == '#':
    if(len(bass_old_chord) > 0):
      return swap_chords(old_chord, sharp_scale[(sharp_scale.index(old_chord[:1]) + value)%len(sharp_scale)]) + "/" + sharp_scale[(sharp_scale.index(bass_old_chord) + value)%len(sharp_scale)]
    else:
      return swap_chords(old_chord, sharp_scale[(sharp_scale.index(old_chord[:1]) + value)%len(sharp_scale)])
  elif scale == 'b':
    if(len(bass_old_chord) > 0):
      return swap_chords(old_chord, flat_scale[(flat_scale.index(old_chord[:1]) + value)%len(flat_scale)]) + "/" + flat_scale[(flat_scale.index(bass_old_chord) + value)%len(flat_scale)]
    else:
      return swap_chords(old_chord, flat_scale[(flat_scale.index(old_chord[:1]) + value)%len(flat_scale)])

def transpose(chords: List[ChordChange], value:int) -> List[ChordChange]:
  transposed_chords:List[ChordChange] = []
  for c in chords:
    if c.chord != "N":
      if c.chord.find("#") != -1 or value > 0:
        new_chord:str = compute_transposed_chord(c.chord, value, "#")
        transposed_chords.append(ChordChange(new_chord, c.timestamp))
      else:
        new_chord:str = compute_transposed_chord(c.chord, value, "b")
        transposed_chords.append(ChordChange(new_chord, c.timestamp))
    else:
      transposed_chords.append(ChordChange(c.chord, c.timestamp))
  return transposed_chords