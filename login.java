package proj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class login {
    private String user;
    private String pw;
    login(String u, String pw){
        this.user = u;
        this.pw = pw;
    }
    public boolean attemptLogin(){
        try{

            Scanner read = new Scanner(new File("C:\\Users\\delta\\OneDrive\\Desktop\\College\\EECS Proj\\proj\\logins.csv"));
    
            while(read.hasNextLine()){
                List<String> row = new ArrayList<String>();
                Scanner rowScanner = new Scanner(read.nextLine());
                rowScanner.useDelimiter(",");
                while (rowScanner.hasNext()) {
                    row.add(rowScanner.next());
                }
                if(row.contains(user) && row.contains(pw)){
                    rowScanner.close();
                    return true;
                }
                if(!rowScanner.hasNext()){
                    rowScanner.close();
                }
            }
            
            read.close();

        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }
}
