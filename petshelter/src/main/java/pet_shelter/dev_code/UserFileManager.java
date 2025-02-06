import java.io.*;
import java.util.*;

class UserFileManager{

    private static int numDataPoints = 4; //id, pword, uname, type
    private static String path = "../../../resources/data/UserData.txt";

    private static File file = new File(path); //File containing user data
    private static ArrayList<String[]> data = new ArrayList<>(); //List of user data as String arrs
    private static Map<User, String> users; //List of users as User/pword pairs
    private static FileWriter writer;
    private static FileWriter screenClearer;
    private static Scanner scan;

    /**
     * Helper method for generateObjects
     * Gets data from file and stores it in an arraylist of String arrays as user data
     * */
    private static void getData(){
        try{
            scan = new Scanner(file);
        } catch (FileNotFoundException e){
            System.out.println("Error in UserFileManager.getData()");
        }
        while(scan.hasNextLine()){
            String[] userData = new String[numDataPoints];
            String line = scan.nextLine();
            if(!line.equals("")){
                userData = line.split("/");
                data.add(userData);
            }
        }
        scan.close();
    }

    /**
     * Helper method for stoObjects
     * Stores user data from data arraylist to UserData file
     * */
    private static void stoData() throws IOException {
        writer = new FileWriter(file, true);
        String dataString = "";
        for(String[] userData : data){
            for(String str : userData){
                dataString += str + "/";
            }
            dataString += "\n";
        }
        screenClearer = new FileWriter(file, false);
        screenClearer.close();
        writer.write(dataString);
        writer.close();
    }

    /**
     * Uses getData() to populate data and uses to generate User/pword HashMap users
     * Returns users
     * */
    public static HashMap<User, String> getObjects(){
        getData();
        users = new HashMap<>();
        for(String[] userData : data){
            users.put(new User(Integer.parseInt(userData[0]), userData[2], UserType.fromString(userData[3])), userData[1]);
        }
        return users;
    }

    public static void stoObjects(HashMap<User, String> usersIn){
        
    }

    public static void main(String[] args) throws IOException, FileNotFoundException {

        

    }


}
