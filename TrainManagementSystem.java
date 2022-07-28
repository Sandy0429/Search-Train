    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.sql.PreparedStatement;
    import java.util.ArrayList;
    import java.sql.*;
    
    public class TrainManagementSystem {
    	
    	public ArrayList <Train> viewTrain (String coachType, String source, String destination)
    	{
    	    ArrayList<Train> train = new ArrayList<Train>(); 
    	    try{
    	        DB db = new DB();
    	        Connection con = db.getConnection();
    	        PreparedStatement pst = con.prepareStatement("SELECT * FROM train WHERE source = ? AND destination = ? AND "+coachType.toLowerCase()+">0 ORDER BY train_number; ");
    	        pst.setString(1,source);
    	        pst.setString(2, destination);
    	        
    	        ResultSet rst =pst.executeQuery();
    	        
    	        while(rst.next())
    	        {
    	            int trainNumber = rst.getInt(1);
    	            String trainName = rst.getString(2);
    	            String src = rst.getString(3);
    	            String dest = rst.getString(4);
    	            int ac1 = rst.getInt(5);
    	            int ac2 = rst.getInt(6);
    	            int ac3 = rst.getInt(7);
    	            int sleeper = rst.getInt(8);
    	            int seater = rst.getInt(9);
    	            train.add(new Train(trainNumber, trainName, src, dest, ac1, ac2, ac3, sleeper, seater));
    	        }
    	       
    	    }catch(Exception e)
    	    {
    	        System.out.println(e);
    	    }
    	    
      		return train;
    		
    	}
    
    }
