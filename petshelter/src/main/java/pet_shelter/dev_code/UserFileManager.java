import java.io.*;
import java.util.*;

class UserFileManager{

    private static int numDataPoints = 4; //id, pword, uname, type
    private static String path = "../../../resources/data/UserData.txt";

    private static File file = new File(path);
    private static ArrayList<String[]> data = new ArrayList<>();
    private static FileWriter writer;
    private static Scanner scan;

    public static void getData(){
        while(scan.hasNextLine()){
            String[] userData = new String[numDataPoints];
            String line = scan.nextLine();
            userData = line.split("/");
            data.add(userData);
        }
    }

    public static void stoData() throws IOException {
        for(String[] userData : data){
            for(String str : userData){
                writer.write(str + "/");
            }
            writer.write("\b\n");
        }
    }

    public static void main(String[] args) throws IOException, FileNotFoundException {

        writer = new FileWriter(file, true);
        scan = new Scanner(file);

        Scanner conscan = new Scanner(System.in);

        getData();
        System.out.print(data.get(1)[2]);
        conscan.nextLine();
        stoData();
        conscan.close();

        writer.close();
        scan.close();

    }


}
