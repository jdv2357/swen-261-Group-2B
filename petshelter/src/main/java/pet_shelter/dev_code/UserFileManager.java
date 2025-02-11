import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class UserFileManager{

    private static int numDataPoints = 4; //id, pword, uname, type
    private static String path = "../../../resources/data/UserData.txt";
    private static String separatorOne = "\n";
    private static String separatorTwo = "~";

    private static File file = new File(path); //File containing user data
    private static FileWriter writer;
    private static FileWriter screenClearer;
    private static Scanner scan;

    /**
     * Helper method for generateObjects
     * Gets data from file and stores it in an arraylist of String arrays as user data
     * @return ArrayList of of data in user data file.
     */
    private static ArrayList<String[]> getData(){
        ArrayList<String[]> data = new ArrayList<>();
        String dataStr = "";
        try{
            scan = new Scanner(file);
        } catch (FileNotFoundException e){
            System.out.println("Error in UserFileManager.getData()");
        }
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            if(!line.equals("")){
                dataStr += line + separatorOne;
            }
        }
        for(String line : dataStr.split(separatorOne)){
            String[] arr = line.split(separatorTwo);
            for(int i = 0; i < arr.length; i++){
                arr[i] = PasswordSecurityManager.decrypt(arr[i]);
            }
            data.add(arr);
        }
        scan.close();
        return data;
    }

    /**
     * Helper method for stoObjects
     * Stores user data from data arraylist to UserData file
     * @param data data to be stored in the UserData file
     */
    private static void stoData(ArrayList<String[]> data) {
        try {
            writer = new FileWriter(file, true);
            String dataString = "";
            for(String[] userData : data){
                for(String str : userData){
                    dataString += PasswordSecurityManager.encrypt(str) + separatorTwo;
                }
                dataString += separatorOne;
            }
            screenClearer = new FileWriter(file, false);
            screenClearer.close();
            writer.write(dataString);
            writer.close();
        } catch (IOException e){
            System.out.println("Error detected in UserFileManager.stoData()");
        }
    }

    /**
     * Uses getData() to populate data and uses to generate User/pword HashMap users
     * @return HashMap containing Users as keys and pwords as values
     */
    public static HashMap<User, String> getObjects(){
        ArrayList<String[]> data = getData();
        HashMap<User, String> users = new HashMap<>();
        for(String[] userData : data){
            users.put(new User(Integer.parseInt(userData[0]), userData[2], UserType.fromString(userData[3])), userData[1]);
        }
        return users;
    }

    /** 
     * Deconstructs User objects and packages them into data arraylist, stores to file.
     * @param HashMap containing Users as keys and pwords as values
     */
    public static void stoObjects(HashMap<User, String> usersIn){
       ArrayList<String[]> data = new ArrayList<>(); 
       for(User user : usersIn.keySet()){
          String[] uData = new String[numDataPoints];
          uData[0] = user.getID() + "";
          uData[1] = usersIn.get(user);
          uData[2] = user.getUname();
          uData[3] = user.getType().toString();
          data.add(uData);
       } 
       stoData(data);
    }

    /**
     * main function for the UserFileManager
     * @param args command line arguments
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws IOException, FileNotFoundException {

        HashMap<User, String> test = new HashMap<>();
        test.put(new User(10001, "Cameron", UserType.VOLUNTEER), "12345");
        test.put(new User(10002, "Shameron", UserType.ROOT), "qwerty");
        stoObjects(test);
        //System.out.println(Arrays.toString(getData().get(0)));
        Scanner buffer = new Scanner(System.in);
        buffer.nextLine();
        System.out.println(getObjects());

    }


}
