package common.Sorted;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Db {
        public static Statement st;
        public static Connection c;
        public static PreparedStatement checkUser,insertUser,getUserLike,
                updateUser,deleteUser;
        static {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                c=DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ludo","root","lipi123");
                st=c.createStatement();
                checkUser=c.prepareStatement("select * from admin_login where aid=? and pass=?");
                getUserLike=c.prepareStatement("select * from candidates_info where name like ?");
                insertUser=c.prepareStatement(
                        "insert into new_table (player1,player2,amount) values(?,?,?)");
                insertUser=c.prepareStatement(
                        "insert into player (name,amount) values(?,?)");
                updateUser=c.prepareStatement(
                        "update candidates_info set name=?,gen=?,dob=?,country=?,skills=?,adr=? where cid=?");
                deleteUser=c.prepareStatement(
                        "delete from candidates_info where cid=?");
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
}
