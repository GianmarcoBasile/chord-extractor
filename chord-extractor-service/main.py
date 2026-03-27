import sys
from typing import List
from chord_extractor import ChordChange
from chord_extractor.extractors import Chordino
from utility import transpose
import librosa

def extract_chords(file_path:str):
  chordino = Chordino(roll_on=1)
  chords = chordino.extract(file_path)
  return chords

def parse_chords(extracted_chords:List[ChordChange]):
  print(" - ".join(e.chord for e in extracted_chords))

def get_song_bpm(file_path: str):
  song = librosa.load(file_path)
  y,sr = song
  tempo, beat_frames = librosa.beat.beat_track(y=y, sr=sr)
  return tempo

def main():
  if len(sys.argv[1:]) < 1:
    print('The correct syntax is my_chord_extractor <file_path>')
    return
  file_path = sys.argv[1]
  transpose_value = 0
  if len(sys.argv[1:]) > 1:
    transpose_value = int(sys.argv[2])
  print(transpose(extract_chords(file_path), transpose_value))
  print("BPM:", get_song_bpm(file_path))
  

if __name__ == "__main__":
  main()

    