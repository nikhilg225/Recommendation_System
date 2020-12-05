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
public class SQL {
        String stringTo,stringFrom;
        int r1, r2, r3, r4, r5;
        int a1,a2,a3,a4,a5;
        double max,temp;
        String userRelated;
        SQL(){}
        // Constructor for Collaborative Filtering
        SQL(String s1,String s2,int v1,int v2,int v3,int v4,int v5){
        
        stringTo=s1;
        stringFrom=s2;
        r1=v1;
        r2=v2;
        r3=v3;
        r4=v4;
        r5=v5;       
        }
        
        public String rn()
        {   String[][] table=new String[6][12];
            table[0][0]="APP_ID";
            table[0][1]="U1";
            table[0][2]="U2";
            table[0][3]="U3";
            table[0][4]="U4";
            table[0][5]="U5";
            table[0][6]="U6";
            table[0][7]="U7";
            table[0][8]="U8";
            table[0][9]="U9";
            table[0][10]="U10";
            table[0][11]="TOTAL";
            
            String Query = null;
            if(stringFrom=="Games")
            {
                Query="Select * From Game_ratings";
            }
            else if(stringFrom=="Social")
            {
                Query="Select * From Social_ratings";
            }
            else if(stringFrom=="Entertainment")
            {
                Query="Select * From Entertainment_ratings";
            }
            else if(stringFrom=="Music")
            {
                Query="Select * From Music_ratings";
            }
            else if(stringFrom=="Shopping")
            {
                Query="Select * From Shopping_ratings";
            }
            else if(stringFrom=="Education")
            {
                Query="Select * From Education_Ratings";
            }
            
            
            
            
            
            try{
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Recommendation_System","root","nikhil");
            Statement mystat=conn.createStatement();
            ResultSet rs;
            rs = mystat.executeQuery(Query);
            
            for(int i=1;i<6&&rs.next();i++)
            {
                table[i][0]=rs.getString("APP_ID");
                table[i][1]=rs.getString("U1");
                table[i][2]=rs.getString("U2");
                table[i][3]=rs.getString("U3");
                table[i][4]=rs.getString("U4");
                table[i][5]=rs.getString("U5");
                table[i][6]=rs.getString("U6");
                table[i][7]=rs.getString("U7");
                table[i][8]=rs.getString("U8");
                table[i][9]=rs.getString("U9");
                table[i][10]=rs.getString("U10");
                table[i][11]=rs.getString("TOTAL");
            }
            
            
            
            /*for(int i=0;i<6;i++)
            {
                for(int j=0;j<12;j++)
                {
                    System.out.print(table[i][j]+",");
                }
                System.out.println(" ");
            }*/
            max=0;
            for(int i=1;i<11;i++)
            {
                
                a1=Integer.parseInt(table[1][i]);
                a2=Integer.parseInt(table[2][i]);
                a3=Integer.parseInt(table[3][i]);
                a4=Integer.parseInt(table[4][i]);
                a5=Integer.parseInt(table[5][i]);
                
                temp=(a1*r1+a2*r2+a3*r3+a4*r4+a5*r5)/(Math.sqrt(a1*a1+a2*a2+a3*a3+a4*a4+a5*a5)*Math.sqrt(r1*r1+r2*r2+r3*r3+r4*r4+r5*r5));   //Cosine Similarity
                if(temp>max)
                {
                    max=temp;
                    userRelated=table[0][i];
                }
            }
                
                  
            
            
            
            conn.close();
            
            }
            catch(SQLException E)
            {
             E.printStackTrace();
            }
            
            finally{
                return userRelated;
            }
            
            
            
                        
        
            
            
           // System.out.println(stringTo+","+stringFrom+","+r1+","+r2+","+r3+","+r4+","+r5);
        }
        


 
    
    
    
    
}
