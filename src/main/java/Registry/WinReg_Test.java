package Registry;

import com.sun.deploy.util.WinRegistry;
import java.io.File;

public class WinReg_Test {
    public static File temp;
    public static File signage;

    public static void main(String[] args) {
//        temp = new File("C:\\signage\\temp");
//        temp.mkdir();
//        File[] listOfTemps = temp.listFiles();
//        signage = new File("C:\\Computer\\HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Run");
//        File[] listOfSignage = signage.listFiles();
//        System.out.println(listOfSignage.length);

//        String value = WinRegistry.getString (
//                WinRegistry.HKEY_CURRENT_USER,                             //HKEY
//                "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\RUN",           //Key
//                "SIGNAGE_RMS");                                              //ValueName
//        System.out.println("Windows Distribution = " + value);


       boolean s = WinRegistry.deleteKey(WinRegistry.HKEY_CURRENT_USER,
                "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\RUN1");
        System.out.println(s);

//        if(listOfSignage != null && listOfTemps != null){
//            for (int i = 0; i < listOfSignage.length; i++) {
//                if (listOfTemps[i].getName().equals(listOfSignage[i].getName())) {
//                    System.out.println("Directory " + listOfSignage[i].getName());
//                    File dir = new File("C:\\signage\\" + listOfSignage[i].getName());
//                    File[] dirList = dir.listFiles();
//                    if (dirList != null){
//                        for (File f : dirList)
//                            f.delete();
//                    }
//                    dir.delete();
//                }
//            }
//        }
    }
}


