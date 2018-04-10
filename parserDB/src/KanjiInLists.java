
public class KanjiInLists {
	int Id_kanjiInList;
	int id_List;
	int id_kanji;
	
	KanjiInLists(int _Id_kanjiInList, int _id_List, int _id_kanji){
		Id_kanjiInList = _Id_kanjiInList;
		id_List = _id_List;
		id_kanji = _id_kanji;
	}
	
	public void setKanjiInList(int _Id_kanjiInList) {
		Id_kanjiInList = _Id_kanjiInList;
	}
	
	public int getKanjiInList() {
		return Id_kanjiInList;
	}
	
	public void setList(int _id_List) {
		id_List = _id_List;
	}
	
	public int getList() {
		return id_List;
	}
	
	public void setKanji(int _id_kanji) {
		id_kanji = _id_kanji;
	}
	
	public int getKanji() {
		return id_kanji;
	}
	
	@Override
	public String toString() {
		return String.format("ID: %s | List: %s | Kanji: %s | ",this.Id_kanjiInList, this.id_List, 
				this.id_kanji);
	}
	
}
