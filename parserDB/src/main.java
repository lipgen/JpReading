import java.sql.SQLException;
import java.util.List;

public class main {
	private static VocabDbHandler dbHandler;
	private static List<vocab> words;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			dbHandler = VocabDbHandler.getInstance();
			words = dbHandler.getAllWords();
			
			/*for(vocab word: words) {
				if(word.getWord()!=null) {
						word.setWord(word.getWord().trim());
						System.out.println("trim - "+word.getIdVocab());
						dbHandler.updateWord(word);
					
				}
			}
			
			words = dbHandler.getAllWords();*/
			printAllWords();
			
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
	

}
