import type { ChordChange } from "@/types";

interface Props {
  chords: ChordChange[];
}

const SongScrollbox = ({ ...props }: Props) => {
  const divs: React.ReactNode[] = [];
  for (let i = 0; i < props.chords.length; i++) {
    i % 4 == 0
      ? divs.push(
          <>
            <div className="border-l-2 border-black"></div>
            <div className="border border-black rounded bg-neutral-100 min-w-12 min-h-12 flex items-center justify-center">
              <span>{props.chords[i].chord}</span>
            </div>
          </>,
        )
      : divs.push(
          <div className="border border-black rounded bg-neutral-100 min-w-12 min-h-12 flex items-center justify-center">
            <span>{props.chords[i].chord}</span>
          </div>,
        );
  }
  return (
    <div className="flex flex-row max-w-7/12 overflow-x-auto mx-auto my-20">
      {divs}
    </div>
  );
};

export default SongScrollbox;
