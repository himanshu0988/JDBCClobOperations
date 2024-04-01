package in.JDBC.clob;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.JDBC.util.jdbcUtil;
import org.apache.commons.io.IOUtils;

public class Reterival {

	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement pstm=null;
		ResultSet resultset=null;
		String username="sonu";
		
		
		connection=jdbcUtil.getConnection();
		if(connection !=null)
		{
			String Query="Select his from user1 where username=?";
			pstm=connection.prepareStatement(Query);
		}
		if(pstm!=null)
		{
			pstm.setString(1, username);
			resultset=pstm.executeQuery();			
		}
		if(resultset!=null)
		{
			Reader reader=resultset.getCharacterStream(2);
			File file = new File("history_copied.txt");
			FileWriter fi=new FileWriter(file);
			
			IOUtils.copy(reader, fi);

			writer.close();
		}

}
