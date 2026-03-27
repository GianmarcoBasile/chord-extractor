import type { ChordChange } from "./types";

export function getSongLengthFromChords(cg: ChordChange[]): number {
  const [secondsStr, millisecondsStr] = cg[cg.length - 1].timestamp
    .toString()
    .split(".");
  const seconds = parseInt(secondsStr);
  const milliseconds = parseInt(millisecondsStr[0] || "0");
  return seconds + (milliseconds > 5 ? 1 : 0);
}
