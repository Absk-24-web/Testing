package common.Sorted;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Sorted_Value_Db {
    public Db db = new Db();
    public List<String> a = new ArrayList<String>();

    public static void main(String[] args) throws SQLException {
        Sorted_Value_Db sorted = new Sorted_Value_Db();
        sorted.GetItem();
    }


    public void GetItem() throws SQLException {
        ResultSet r = db.st.executeQuery("select * from player");
        while (r.next()) {
            int id = r.getInt("id");
            String name = r.getString("name");
            String amount = r.getString("amount");
            a.add(name);
        }
          a = Sorted(a);
            for(int i = 0; i == a.size(); i++){

            }

        System.out.println(a.toString());
    }


    public List<String> Sorted(List<String> a) {
        Collections.sort(this.a);
        return a;
    }

}
