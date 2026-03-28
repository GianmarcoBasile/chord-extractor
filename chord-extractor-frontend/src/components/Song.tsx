import type { ChordChange } from "@/types";
import React, { useEffect, useRef, useState, type MouseEvent } from "react";
import { Button } from "./ui/button";
import { Bar } from "./Bar";
import { Beat } from "./Beat";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faBackwardStep,
  faPause,
  faPlay,
} from "@fortawesome/free-solid-svg-icons";
import SongScrollbox from "./SongScrollbox";

interface Props {
  chords: ChordChange[];
  songDuration: number;
  bpm: number;
}

const Song = ({ chords, songDuration: songDuration, bpm }: Props) => {
  const beats: React.ReactNode[] = [];
  const chordMap: Map<number, string> = new Map<number, string>();
  const totalBeats: number = Math.ceil((songDuration * bpm) / 60);
  const beatsPerBar = 4;
  const quarterDuration = 60 / bpm;
  const beatRef = useRef<HTMLDivElement>(null);
  const scrollbarRef = useRef<HTMLDivElement>(null);
  const [selected, setSelected] = useState<number>(0);
  const [play, setPlay] = useState<boolean>(false);

  const SCROLL_WIDTH = 60;

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
          ref={selected == currentChord ? beatRef : null}
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

  const handleBack = (e: MouseEvent) => {
    e.preventDefault;
    setSelected(0);
  };

  useEffect(() => {
    if (!play) return;
    const interval = setInterval(() => {
      setSelected((prev) => {
        if (prev < totalBeats) return prev + 1;
        clearInterval(interval);
        return prev;
      });
    }, quarterDuration * 1000);
    return () => clearInterval(interval);
  }, [play]);

  useEffect(() => {
    beatRef.current?.scrollIntoView();
    if (selected > 5) {
      scrollbarRef.current?.scrollBy({
        top: 0,
        left: SCROLL_WIDTH,
        behavior: "smooth",
      });
    }
  }, [selected]);

  return (
    <>
      <div className="flex flex-col items-center my-20">
        <div className="flex flex-row space-x-2">
          <Button
            onClick={handleBack}
            className="rounded-full h-14 w-14 cursor-pointer bg-gray-500"
          >
            <FontAwesomeIcon icon={faBackwardStep} size="xl" />
          </Button>
          <Button
            onClick={handlePlay}
            className={`rounded-full h-14 w-14 cursor-pointer ${play ? "bg-red-800" : "bg-blue-800"}`}
          >
            {play ? (
              <FontAwesomeIcon icon={faPause} size="xl" />
            ) : (
              <FontAwesomeIcon icon={faPlay} size="xl" />
            )}
          </Button>
          <div className="h-14 w-14"></div>
        </div>
        <SongScrollbox beats={beats} scrollbarRef={scrollbarRef} />
      </div>
    </>
  );
};

export default Song;
