package in.JDBC.clob;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.File;

import in.JDBC.util.*;

public class clobInserstionApp {

	public static void main(String[] args) throws SQLException, IOException {
		Connection connection=null;
		PreparedStatement pstm=null;
		String username="sonu";
		String pdfLoc="C:\\Users\\HIMANSHU\\eclipse-workspace\\JDBCClobOperations\\history_copied.txt";
		
		connection=jdbcUtil.getConnection();
		if(connection !=null)
		{
			String Query="insert into user1 (`username`,`his`)values(?,?)";
			pstm=connection.prepareStatement(Query);
		}
		if(pstm!=null)
		{
			pstm.setString(1, username);
			pstm.setCharacterStream(2, new FileReader(new File(pdfLoc)));
			int RowAffect=pstm.executeUpdate();	
			
			System.out.println("total row affected is"+RowAffect);
		}
		jdbcUtil.clenUp(connection, pstm, null);
		
	}
		

	}


