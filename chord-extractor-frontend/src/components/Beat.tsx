import type { Ref } from "react";

interface Props {
  chord: string | undefined;
  selected: boolean;
  ref: Ref<HTMLDivElement>;
}

export const Beat = ({ chord, selected, ref }: Props) => {
  return (
    <>
      <div
        ref={ref}
        className={`border border-black ml-0.5 rounded bg-neutral-100 min-w-14 min-h-14 flex items-center justify-center ${selected ? "bg-neutral-700" : ""}`}
      >
        {chord ?? ""}
      </div>
    </>
  );
};
