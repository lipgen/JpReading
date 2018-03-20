// данный класс представляет собой объект таблицы vocabulary
// данная таблица содержит в себе словарь слов
public class vocab {
		private int id_vocab;
		private String word;
		private String reading;
		private String translate;
		private int jlptlvl;
		private int learnStat;
		
		public vocab(int _id_vocab, String _word,
				String _reading, String _translate,
				int _jlptlvl, int _learnStat) {
			id_vocab = _id_vocab;
			word = _word;
			reading = _reading;
			translate = _translate;
			jlptlvl = _jlptlvl;
			learnStat = _learnStat;
		}
		
		public int getIdVocab(){
			return id_vocab;
		}
		
		public void setWord(String _word){
			word = _word;
		}
		
		public String getWord(){
			return word;
		}
		
		public void setReading(String _reading){
			reading=_reading;
		}
		
		public String getReading(){
			return reading;
		}
		
		public void setTranslate(String _translate){
			translate=_translate;
		}
		
		public String getTranslate(){
			return translate;
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
			return String.format("ID: %s | Word: %s | Reading: %s | Translate: %s "
					+ "| JLPT lvl: %s ",this.id_vocab, this.word, 
					this.reading, this.translate, this.jlptlvl);
		}
		
}
