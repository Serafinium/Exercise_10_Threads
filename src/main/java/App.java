import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SERAFIM on 19.11.2017.
 */
public class App {
    public static void main(String[] args) {
       writeTextInFile( methohAudit( read() ) );
    }

    public static List<String> read(){

        List<String> array = new ArrayList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader( new FileReader("file1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = new String();

        try {
            while( ( line = reader.readLine() )  != null) {
                array.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return array;
    }

    public static void writeTextInFile(String text){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter("file2.txt", false));
            bufferedWriter.write(text);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  static String methohAudit (List<String> str){
        String respons = "";
        System.out.println("number of lines is: " + str.size());

        respons += ("Number of lines is: " + str.size() + "\n");



        int max = str.get(0).length();
        int row = 0;
        for(int i=0; i<str.size(); i++){
            if( max < str.get(i).length() ){
                max = str.get(i).length();
                row = i;
            }
        }
        System.out.println("Max row is:  " + (row + 1) + "  contane:  " + max + " symbols. \n" + "value row is:  " + str.get(row));
        respons += ("Max row is:  " + (row + 1) + "  contane:  " + max + " symbols. \n" + "value row is:  " + str.get(row) +"\n");


        String s = str.get(0);
        System.out.println("Name is: " + s.substring(0, s.indexOf(" ")) + "\n");
        respons += ("Name is: " + s.substring(0, s.indexOf(" ")) + "\n");

        return respons;

    }
}
