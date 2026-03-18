import sys
from chord_extractor.extractors import Chordino

def extractChords(file_path):
  chordino = Chordino(roll_on=1)
  chords = chordino.extract(file_path)
  return chords

def parseChords(extractedChords):
  print(" - ".join(e.chord for e in extractedChords))

def main():
  if len(sys.argv[1:]) != 1:
    print('The correct syntax is my_chord_extractor <file_path>')
    return
  file_path = sys.argv[1]
  # print(extractChords(file_path))
  parseChords(extractChords(file_path))

if __name__ == "__main__":
  main()

    