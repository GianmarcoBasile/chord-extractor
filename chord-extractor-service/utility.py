from chord_extractor import ChordChange
from typing import List, Tuple

sharpScale:List[str] = ["C","C#","D","D#","E","F","F#","G","G#","A", "A#","B"]
flatScale:List[str] = ["C","Db","D","Eb","E","F","Gb","G","Ab","A", "Bb","B"]

def swapChords(oldChord: str, newComputedChord: str) -> str:
  if len(oldChord) > 1 and (oldChord[1] == "#" or oldChord[1] == 'b'):
    newComputedChord = newComputedChord + oldChord[2:]
  else:
    newComputedChord = newComputedChord + oldChord[1:]
  return newComputedChord

def computeTransposedChord(chord:str, value:int, scale:str) -> str:
  parts = chord.split("/")
  oldChord:str = parts[0]
  bassOldChord:str = ""
  if len(parts) > 1:
    bassOldChord = parts[1]

  if scale == '#':
    if(len(bassOldChord) > 0):
      return swapChords(oldChord, sharpScale[(sharpScale.index(oldChord[:1]) + value)%len(sharpScale)]) + "/" + sharpScale[(sharpScale.index(bassOldChord) + value)%len(sharpScale)]
    else:
      return swapChords(oldChord, sharpScale[(sharpScale.index(oldChord[:1]) + value)%len(sharpScale)])
  elif scale == 'b':
    if(len(bassOldChord) > 0):
      return swapChords(oldChord, flatScale[(flatScale.index(oldChord[:1]) + value)%len(flatScale)]) + "/" + flatScale[(flatScale.index(bassOldChord) + value)%len(flatScale)]
    else:
      return swapChords(oldChord, flatScale[(flatScale.index(oldChord[:1]) + value)%len(flatScale)])

def transpose(chords: List[ChordChange], value:int) -> List[ChordChange]:
  transposedChords:List[ChordChange] = []
  for c in chords:
    if c.chord != "N":
      if c.chord.find("#") != -1 or value > 0:
        newChord:str = computeTransposedChord(c.chord, value, "#")
        transposedChords.append(ChordChange(newChord, c.timestamp))
      else:
        newChord:str = computeTransposedChord(c.chord, value, "b")
        transposedChords.append(ChordChange(newChord, c.timestamp))
    else:
      transposedChords.append(ChordChange(c.chord, c.timestamp))
  return transposedChords