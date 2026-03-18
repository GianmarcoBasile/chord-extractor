import { Input } from "./ui/input";

const Header = () => {
  return (
    <>
      <header className="bg-teal-700 h-11 flex items-center">
        <span className="font-bold text-xl mx-20">ChordExtractor</span>
        <Input
          className="w-72 bg-white mx-20"
          placeholder="Cerca una canzone"
        />
      </header>
    </>
  );
};

export default Header;
