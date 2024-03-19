import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.file;
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
        File csv = new File("database.csv");
        Scanner read = new Scanner(csv);

        while(csv.hasNextLine()){
            List<String> row = new ArrayList<String>();
            Scanner rowScanner = new Scanner(read.nextLine());
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                row.add(rowScanner.next());
            }
            if(row.contains(user) && row.contains(pw)){
                return true;
            }
        }
        return false;
    }
}
