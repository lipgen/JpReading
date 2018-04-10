import java.sql.SQLException;

import java.util.*;

import org.sqlite.JDBC;

import java.sql.*;

public class VocabDbHandler {
	private static final String DB_PATH = "jdbc:sqlite:D:/vocab.db";
	
	private static VocabDbHandler instance = null;
	
	public static synchronized VocabDbHandler getInstance() throws SQLException{
		if (instance == null)
			instance = new VocabDbHandler();
		
		return instance;
	}
	
	private Connection connection;
	
	private VocabDbHandler() throws SQLException{
		DriverManager.registerDriver(new JDBC());
		this.connection = DriverManager.getConnection(DB_PATH);
	}
	
	//работа с таблицей vocabulary
	public List<vocab> getAllWords(){
		try (Statement statement = this.connection.createStatement()){
			List<vocab> words = new ArrayList<>();
			ResultSet resultSet = statement.executeQuery("SELECT id_voc, word, reading,"
					+ "translate, jlptlvl, learnStat FROM vocabulary");
			while(resultSet.next()) {
				words.add(new vocab(
						resultSet.getInt("id_voc"),
						resultSet.getString("word"),
						resultSet.getString("reading"),
						resultSet.getString("translate"),
						resultSet.getInt("jlptlvl"),
						resultSet.getInt("learnStat")));
			}
			return words;
		}catch(SQLException e){
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	public void addWord(vocab word) {
		try (PreparedStatement statement = this.connection.prepareStatement("INSERT INTO vocabulary"
				+ "(`word`, `reading`,`translate`, `jlptlvl`, `learnStat`)"
				+ " VALUES(?,?,?,?,?)")){
			statement.setObject(1, word.getWord());
			statement.setObject(2, word.getReading());
			statement.setObject(3, word.getTranslate());
			statement.setObject(4, word.getJlptlvl());
			statement.setObject(5, word.getLearnStat());
			statement.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void updateWord(vocab word) {
		try (PreparedStatement statement = this.connection.prepareStatement("UPDATE vocabulary "
				+ "SET `word` = ?, `reading` = ?,`translate` = ?, `jlptlvl` = ?, `learnStat` = ?"
				+ " WHERE id_voc = ? ")){
			statement.setObject(1, word.getWord());
			statement.setObject(2, word.getReading());
			statement.setObject(3, word.getTranslate());
			statement.setObject(4, word.getJlptlvl());
			statement.setObject(5, word.getLearnStat());
			statement.setObject(6, word.getIdVocab());
			statement.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void deleteWord(int id) {
		try(PreparedStatement statement = this.connection.prepareStatement(
				"DELETE FROM vocabulary WHERE id_voc = ?")){
			statement.setObject(1, id);
			statement.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//работа с таблицей kanji
	public List<kanji> getAllKanjis(){
		try (Statement statement = this.connection.createStatement()){
			List<kanji> kanjis = new ArrayList<>();
			ResultSet resultSet = statement.executeQuery("SELECT id_kanji, kanji, Meaning,"
					+ "Reading, jlptlvl, learnStat FROM kanji");
			while(resultSet.next()) {
				kanjis.add(new kanji(
						resultSet.getInt("id_kanji"),
						resultSet.getString("kanji"),
						resultSet.getString("Reading"),
						resultSet.getString("Meaning"),
						resultSet.getInt("jlptlvl"),
						resultSet.getInt("learnStat")));
			}
			return kanjis;
		}catch(SQLException e){
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	public void addKanji(kanji word) {
		try (PreparedStatement statement = this.connection.prepareStatement("INSERT INTO kanji"
				+ "(`kanji`, `Meaning`,`Reading`, `jlptlvl`, `learnStat`)"
				+ " VALUES(?,?,?,?,?)")){
			statement.setObject(1, word.getKanji());
			statement.setObject(2, word.getMeaning());
			statement.setObject(3, word.getReading());
			statement.setObject(4, word.getJlptlvl());
			statement.setObject(5, word.getLearnStat());
			statement.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void updateKanji(kanji word) {
		try (PreparedStatement statement = this.connection.prepareStatement("UPDATE kanji "
				+ "SET `kanji` = ?, `Meaning` = ?,`Reading` = ?, `jlptlvl` = ?, `learnStat` = ?"
				+ " WHERE id_kanji = ? ")){
			statement.setObject(1, word.getKanji());
			statement.setObject(2, word.getMeaning());
			statement.setObject(3, word.getReading());
			statement.setObject(4, word.getJlptlvl());
			statement.setObject(5, word.getLearnStat());
			statement.setObject(6, word.getIdKanji());
			statement.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void deleteKanji(int id) {
		try(PreparedStatement statement = this.connection.prepareStatement(
				"DELETE FROM kanji WHERE id_kanji = ?")){
			statement.setObject(1, id);
			statement.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//работа с таблицей KanjiInLists
	public List<KanjiInLists> getAllKanjiInList(){
		try (Statement statement = this.connection.createStatement()){
			List<KanjiInLists> kanjis = new ArrayList<>();
			ResultSet resultSet = statement.executeQuery("SELECT Id_kanjiInList, id_List, id_kanji FROM KanjiInLists");
			while(resultSet.next()) {
				kanjis.add(new KanjiInLists(
						resultSet.getInt("Id_kanjiInList"),
						resultSet.getInt("id_List"),
						resultSet.getInt("id_kanji")));
			}
			return kanjis;
		}catch(SQLException e){
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	public void addKanjiInLists(int idList, int idKanji) {
		try (PreparedStatement statement = this.connection.prepareStatement("INSERT INTO KanjiInLists"
				+ "(`id_List`, `id_kanji`)"
				+ " VALUES(?,?)")){
			statement.setObject(1, idList);
			statement.setObject(2, idKanji);
			statement.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void updateKanjiInLists(KanjiInLists word) {
		try (PreparedStatement statement = this.connection.prepareStatement("UPDATE KanjiInLists "
				+ "SET `id_List` = ?, `id_kanji` = ?"
				+ " WHERE Id_kanjiInList = ? ")){
			statement.setObject(1, word.getList());
			statement.setObject(2, word.getKanji());
			statement.setObject(3, word.getKanjiInList());
			statement.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void deleteKanjiInList(int id) {
		try(PreparedStatement statement = this.connection.prepareStatement(
				"DELETE FROM KanjiInLists WHERE Id_kanjiInList = ?")){
			statement.setObject(1, id);
			statement.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
