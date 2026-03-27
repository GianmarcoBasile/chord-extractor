import type { Ref } from "react";
import type React from "react";

interface Props {
  beats: React.ReactNode[];
  scrollbarRef: Ref<HTMLDivElement>;
}

const SongScrollbox = ({ beats, scrollbarRef }: Props) => {
  return (
    <>
      <div
        ref={scrollbarRef}
        className="flex flex-row max-w-7/12 overflow-x-auto mx-auto my-5"
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
