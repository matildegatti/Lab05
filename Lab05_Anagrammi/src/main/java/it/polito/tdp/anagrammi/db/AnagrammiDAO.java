package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AnagrammiDAO {

	public boolean isCorrect(String anagramma){
		String sql="SELECT * FROM parola WHERE nome=?";
		
	
		
		try {
			Connection conn=DBConnect.getConnection();
			PreparedStatement st=conn.prepareStatement(sql); 
			
			st.setString(1, anagramma);
			
			ResultSet rs=st.executeQuery();
			
			if(rs.next()){
				st.close();
				rs.close();
				conn.close();
				return true;
			}
			else{
				st.close();
				rs.close();
				conn.close();
				return false;
			}
		
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
