// данный класс представляет собой объект таблицы kanji
// данная таблица содержит в себе список kanji
public class kanji {
		private int id_kanji;
		private String kanji;
		private String reading;
		private String meaning;
		private int jlptlvl;
		private int learnStat;
		
		public kanji(int _id_kanji, String _kanji,
				String _reading, String _meaning,
				int _jlptlvl, int _learnStat) {
			id_kanji = _id_kanji;
			kanji = _kanji;
			reading = _reading;
			meaning = _meaning;
			jlptlvl = _jlptlvl;
			learnStat = _learnStat;
		}
		
		public int getIdKanji(){
			return id_kanji;
		}
		
		public void setKanji(String _kanji){
			kanji = _kanji;
		}
		
		public String getKanji(){
			return kanji;
		}
		
		public void setReading(String _reading){
			reading=_reading;
		}
		
		public String getReading(){
			return reading;
		}
		
		public void setMeaning(String _meaning){
			meaning=_meaning;
		}
		
		public String getMeaning(){
			return meaning;
		}
		
		public void setJlptlvl(int _jlptlvl){
			jlptlvl = _jlptlvl;
		}
		
		public int getJlptlvl(){
			return jlptlvl;
		}
		
		public void setLearnStat(int _learnStat){
			learnStat = _learnStat;
		}
		
		public int getLearnStat(){
			return learnStat;
		}
		
		@Override
		public String toString() {
			return String.format("ID: %s | Kanji: %s | Reading: %s | Meaning: %s "
					+ "| JLPT lvl: %s ",this.id_kanji, this.kanji, 
					this.reading, this.meaning, this.jlptlvl);
		}
		
}
