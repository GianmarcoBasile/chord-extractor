import type { ChordChange } from "@/types";
import React, { useEffect, useRef, useState, type MouseEvent } from "react";
import { Button } from "./ui/button";
import { Bar } from "./Bar";
import { Beat } from "./Beat";

interface Props {
  chords: ChordChange[];
  songDuration: number;
  bpm: number;
}

const SongScrollbox = ({ chords, songDuration: songDuration, bpm }: Props) => {
  const beats: React.ReactNode[] = [];
  const chordMap: Map<number, string> = new Map<number, string>();
  const totalBeats: number = Math.ceil((songDuration * bpm) / 60);
  const beatsPerBar = 4;
  const quarterDuration = 60 / bpm;
  const focusRef = useRef<HTMLDivElement>(null);
  const [selected, setSelected] = useState<number>(0);
  const [play, setPlay] = useState<boolean>(false);

  chords.forEach((chord) => {
    const beat_index = Math.round(chord.timestamp / quarterDuration);
    chordMap.set(beat_index, chord.chord);
  });

  for (let i = 0; i < totalBeats; i += beatsPerBar) {
    const barBeats: React.ReactNode[] = [];

    for (let j = 0; j < beatsPerBar; j++) {
      const currentChord = i + j;
      barBeats.push(
        <Beat
          key={`bar-${currentChord}`}
          chord={chordMap.get(currentChord)}
          selected={selected == currentChord}
          ref={selected == currentChord ? focusRef : null}
        />,
      );
    }
    beats.push(
      <React.Fragment key={`group-${i / 4}`}>
        <Bar key={`bar-${i / 4}`}>{barBeats}</Bar>
      </React.Fragment>,
    );
  }

  const handlePlay = (e: MouseEvent) => {
    e.preventDefault;
    setPlay(!play);
  };

  useEffect(() => {
    if (!play) return;
    const interval = setInterval(() => {
      setSelected((prev) => prev + 1);
    }, quarterDuration * 1000);
    return () => clearInterval(interval);
  }, [play]);

  useEffect(() => {
    focusRef.current?.scrollIntoView();
  }, [selected]);

  return (
    <>
      <Button onClick={handlePlay}>Play</Button>
      <div
        className="flex flex-row max-w-7/12 overflow-x-auto mx-auto my-20"
        style={{
          scrollbarWidth: "thin",
          scrollbarColor: "rgba(0,0,0,0.3) transparent",
        }}
      >
        {beats}
      </div>
    </>
  );
};

export default SongScrollbox;
