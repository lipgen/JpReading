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
	
}
