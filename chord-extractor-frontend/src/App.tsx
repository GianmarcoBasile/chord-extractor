import Header from "./components/Header";
import Song from "./components/Song";

const App = () => {
  return (
    <div>
      <Header />
      <Song
        chords={[
          { chord: "N", timestamp: 0.371519274 },
          { chord: "Cm", timestamp: 0.464399092 },
          { chord: "Fm", timestamp: 2.4148752829999998 },
          { chord: "E", timestamp: 6.315827664 },
          { chord: "Dmaj7", timestamp: 10.495419501 },
          { chord: "Fm7", timestamp: 14.396371882 },
          { chord: "Cm", timestamp: 18.390204081 },
          { chord: "D", timestamp: 22.476916099 },
          { chord: "Fm7", timestamp: 26.563628117 },
          { chord: "Fm", timestamp: 27.863945578 },
          { chord: "Bm", timestamp: 30.557460317 },
          { chord: "Cm", timestamp: 34.551292517 },
          { chord: "D6", timestamp: 38.545124716 },
          { chord: "A/E", timestamp: 42.538956916 },
          { chord: "C", timestamp: 45.046712018 },
          { chord: "Bm", timestamp: 46.347029478 },
          { chord: "E6", timestamp: 49.50494331 },
          { chord: "Fm7", timestamp: 58.978684807 },
          { chord: "Bm7", timestamp: 62.786757369 },
          { chord: "A/B", timestamp: 65.294512471 },
          { chord: "D/E", timestamp: 66.966349206 },
          { chord: "E", timestamp: 67.709387755 },
          { chord: "Fm7", timestamp: 70.495782312 },
          { chord: "D", timestamp: 79.040725623 },
          { chord: "Fm", timestamp: 81.548480725 },
          { chord: "Cm", timestamp: 86.563990929 },
          { chord: "A", timestamp: 87.121269841 },
          { chord: "B6", timestamp: 89.536145124 },
          { chord: "Bm", timestamp: 90.46494331 },
          { chord: "Fm", timestamp: 94.551655328 },
          { chord: "Cm", timestamp: 98.266848072 },
          { chord: "Am", timestamp: 102.446439909 },
          { chord: "D6", timestamp: 106.440272108 },
          { chord: "Dmaj7", timestamp: 108.576507936 },
          { chord: "Bm", timestamp: 112.570340136 },
          { chord: "Fm", timestamp: 115.635374149 },
          { chord: "E7", timestamp: 116.564172335 },
          { chord: "Cm7", timestamp: 120.743764172 },
          { chord: "Bm", timestamp: 123.994557823 },
          { chord: "Fm7", timestamp: 124.923356009 },
          { chord: "Bm7", timestamp: 128.731428571 },
          { chord: "A/B", timestamp: 131.332063492 },
          { chord: "E7", timestamp: 133.096780045 },
          { chord: "Fm7", timestamp: 136.626213151 },
          { chord: "Gmaj7", timestamp: 145.171156462 },
          { chord: "Fm", timestamp: 148.421950113 },
          { chord: "Bm", timestamp: 149.25786848 },
          { chord: "Dm", timestamp: 153.158820861 },
          { chord: "Amaj7", timestamp: 156.595374149 },
          { chord: "Bm7", timestamp: 161.610884353 },
          { chord: "A/E", timestamp: 166.626394557 },
          { chord: "Cm7", timestamp: 170.620226757 },
          { chord: "A/C#", timestamp: 173.871020408 },
          { chord: "Dmaj7", timestamp: 174.521179138 },
          { chord: "Bm7", timestamp: 178.3292517 },
          { chord: "E7", timestamp: 182.137324263 },
          { chord: "Fm7", timestamp: 186.409795918 },
          { chord: "C", timestamp: 193.004263038 },
          { chord: "Bm", timestamp: 194.490340136 },
          { chord: "E", timestamp: 198.391292517 },
          { chord: "Amaj7", timestamp: 199.041451247 },
          { chord: "F", timestamp: 201.920725623 },
          { chord: "N", timestamp: 206.657596371 },
        ]}
        songDuration={207}
        bpm={117}
      />
    </div>
  );
};

export default App;
