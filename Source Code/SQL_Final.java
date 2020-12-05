/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nikhil
 */
import java.sql.*;
public class SQL_Final {
    String toCategory,user;
    SQL_Final(String s1,String s2){
        toCategory=s1;
        user=s2;
    }
    SQL_Final(String s1){
    toCategory=s1;
    }
    
    public String[] getResult()
    {
        String[] result=new String[6];
        String Query2 = null;
             
        //result[5]=user;
        if("Games"==toCategory)
        {
            //Query1="Select APP_ID From Game_Ratings Order by"+user+"desc";
            Query2="SELECT APP_NAME.ANAME FROM APP_NAME INNER JOIN GAME_RATINGS ON APP_NAME.AID=GAME_RATINGS.APP_ID ORDER BY "+user+" DESC";
        }
        else if("Social"==toCategory)
        {
            //Query1="Select App_ID From Social_Ratings Order by"+user+"desc";
            Query2="SELECT APP_NAME.ANAME FROM APP_NAME INNER JOIN Social_RATINGS ON APP_NAME.AID=SOCIAL_RATINGS.APP_ID ORDER BY "+user+" DESC";
        }
        else if("Entertainment"==toCategory)
        {
            //Query1="Select APP_ID From Entertainment_Ratings Order by"+user+"desc";
            Query2="SELECT APP_NAME.ANAME FROM APP_NAME INNER JOIN Entertainment_RATINGS ON APP_NAME.AID=Entertainment_RATINGS.APP_ID ORDER BY "+user+" DESC";
        }
        else if("Music"==toCategory)
        {
            //Query1="Select APP_ID From Music_Ratings Order by"+user+"desc";
            Query2="SELECT APP_NAME.ANAME FROM APP_NAME INNER JOIN Music_RATINGS ON APP_NAME.AID=Music_RATINGS.APP_ID ORDER BY "+user+" DESC";
        }
        else if("Shopping"==toCategory)
        {
            //Query1="Select APP_ID From Shopping_Ratings Order by"+user+"desc";
            Query2="SELECT APP_NAME.ANAME FROM APP_NAME INNER JOIN Shopping_RATINGS ON APP_NAME.AID=Shopping_RATINGS.APP_ID ORDER BY "+user+" DESC";
        }
        else if("Education"==toCategory)
        {
            //Query1="Select APP_ID From Education_Ratings Order by"+user+"desc";
            Query2="SELECT APP_NAME.ANAME FROM APP_NAME INNER JOIN Education_RATINGS ON APP_NAME.AID=Education_RATINGS.APP_ID ORDER BY "+user+" DESC";
        }
        
        
        
        
        try{
        
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Recommendation_System","root","nikhil");
        Statement st=conn.createStatement();
        
        ResultSet rs=st.executeQuery(Query2);
        
        for(int i=0;i<5&&rs.next();i++)
        {
            result[i]=rs.getString("Aname");
        }
        
        }
        catch(SQLException E)
        {
            E.printStackTrace();
        }
        
        
        
        
        
        
        
        
        return result;
    }
     
    public String[] popularResult()
    {
        String[] result=new String[5];
        String Query2 = null;
             
        
        if("Games"==toCategory)
        {
            //Query1="Select APP_ID From Game_Ratings Order by"+user+"desc";
            Query2="SELECT APP_NAME.ANAME FROM APP_NAME INNER JOIN GAME_RATINGS ON APP_NAME.AID=GAME_RATINGS.APP_ID ORDER BY Total DESC";
        }
        else if("Social"==toCategory)
        {
            //Query1="Select App_ID From Social_Ratings Order by"+user+"desc";
            Query2="SELECT APP_NAME.ANAME FROM APP_NAME INNER JOIN Social_RATINGS ON APP_NAME.AID=SOCIAL_RATINGS.APP_ID ORDER BY Total DESC";
        }
        else if("Entertainment"==toCategory)
        {
            //Query1="Select APP_ID From Entertainment_Ratings Order by"+user+"desc";
            Query2="SELECT APP_NAME.ANAME FROM APP_NAME INNER JOIN Entertainment_RATINGS ON APP_NAME.AID=Entertainment_RATINGS.APP_ID ORDER BY Total DESC";
        }
        else if("Music"==toCategory)
        {
            //Query1="Select APP_ID From Music_Ratings Order by"+user+"desc";
            Query2="SELECT APP_NAME.ANAME FROM APP_NAME INNER JOIN Music_RATINGS ON APP_NAME.AID=Music_RATINGS.APP_ID ORDER BY Total DESC";
        }
        else if("Shopping"==toCategory)
        {
            //Query1="Select APP_ID From Shopping_Ratings Order by"+user+"desc";
            Query2="SELECT APP_NAME.ANAME FROM APP_NAME INNER JOIN Shopping_RATINGS ON APP_NAME.AID=Shopping_RATINGS.APP_ID ORDER BY Total DESC";
        }
        else if("Education"==toCategory)
        {
            //Query1="Select APP_ID From Education_Ratings Order by"+user+"desc";
            Query2="SELECT APP_NAME.ANAME FROM APP_NAME INNER JOIN Education_RATINGS ON APP_NAME.AID=Education_RATINGS.APP_ID ORDER BY Total DESC";
        }
        
        
        
        
        try{
        
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Recommendation_System","root","nikhil");
        Statement st=conn.createStatement();
        
        ResultSet rs=st.executeQuery(Query2);
        
        for(int i=0;i<5&&rs.next();i++)
        {
            result[i]=rs.getString("Aname");
        }
        
        }
        catch(SQLException E)
        {
            E.printStackTrace();
        }
        
        
        
        
        
        
        
        
        return result;
    }
    
    
    
    
    
}
