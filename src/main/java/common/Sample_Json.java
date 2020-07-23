package common;

import java.io.FileWriter;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sample_Json {


    public static void main(String[] args) {
        String imei = "";
        String KioskIp ="";
        FileWriter file = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://172.16.4.107:3306/digitalsignage", "root", "lipimysql");
            Statement st =  c.createStatement();

            String datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            datetime = "\"" + datetime + "\"";

            Timestamp stamp = new Timestamp(System.currentTimeMillis());
            Date currentDate = new Date(stamp.getTime());
            System.out.println(currentDate);

            ResultSet r = st.executeQuery("select * from kiosk_master");
            while (r.next()) {
                imei = r.getString("KioskID");
                imei = imei.replaceAll("Lipi", "");
                imei =  "\"" + imei + "\"";
                KioskIp = r.getString("KioskIP");
                KioskIp = "\"" + KioskIp + "\"";
                Timestamp timestamp =r.getTimestamp("RegisterDT");
                Date kioskDate = new Date(timestamp.getTime());

                long diff = currentDate.getTime() - kioskDate.getTime();
                long diffMinutes = diff / (60 * 1000) % 60;
                if(diffMinutes>= 5){
                     String status = "0";
                }
            }

//                String s =   "{\n"
//                        +"\"deviceHealth\":{\n"
//                        +"\"imei\":"+imei+",\n"
//                        +"\"dateTime\":"+datetime+",\n"
//                        +"\"status\":" +"\"1\",\n"
//                        +"\"additional\":{\n"
//                        +"\"KioskIP\":"+KioskIp+"\n"
//                        +"  }\n }\n}";
//
//                file.write(s+"\n");
//				System.out.println(s);

            } catch (SQLException | ClassNotFoundException ioException) {
            ioException.printStackTrace();
        }
    }

}
