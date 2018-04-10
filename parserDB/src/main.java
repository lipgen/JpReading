import java.sql.SQLException;
import java.util.List;

public class main {
	private static VocabDbHandler dbHandler;
	private static List<vocab> words;
	private static List<kanji> kanjis;
	private static List<KanjiInLists> kLists;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			dbHandler = VocabDbHandler.getInstance();
			//words = dbHandler.getAllWords();
			//kanjis = dbHandler.getAllKanjis();
			
			/*for(kanji record: kanjis) {
				dbHandler.addKanjiInLists(1, record.getIdKanji());
			}*/
			kLists = dbHandler.getAllKanjiInList();
			
			//printAllKanjis();
			printAllKanjiInLists();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void printWord(int id) {
		vocab word = words.get(id);
		System.out.println(word.toString());
	}
	
	private static void printAllWords() {
		for(vocab word: words) {
			System.out.println(word.toString());
		}
	}
	
	private static void printAllKanjis() {
		for(kanji record: kanjis) {
			System.out.println(record.toString());
		}
	}
	
	private static void printAllKanjiInLists() {
		for(KanjiInLists record: kLists) {
			System.out.println(record.toString());
		}
	}

}
