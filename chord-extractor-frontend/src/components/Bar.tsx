import type { ReactNode } from "react";

interface Props {
  children: ReactNode;
}

export const Bar = ({ children }: Props) => {
  return (
    <>
      <div className="flex flex-row">{children}</div>
      <div className="h-14 min-w-0.5 bg-black ml-0.5"></div>
    </>
  );
};
