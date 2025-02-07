import java.util.*;

class UserManager {

    private static HashMap<Integer, User> users;
    private static HashMap<Integer, String> pwords;

    /**
     * Gets users and pwords from FileManager
     * */
    private static void getData(){
        users = new HashMap<>();
        pwords = new HashMap<>();
        HashMap<User, String> userData = UserFileManager.getObjects();
        for(User user : userData.keySet()){
            int id = user.getID();
            users.put(id, user);
            pwords.put(id, pwords.get(user));
        }

    }

    /**
     * Sends current users and pwords to FileManager to be stored in file
     * */
    private static void sendData(){
        HashMap<User, String> usersAndPwords = new HashMap<>();
        for(Integer id : users.keySet()){
            usersAndPwords.put(users.get(id), pwords.get(id));
        }
        UserFileManager.stoObjects(usersAndPwords);
        getData();
    }

    //Mutators

    public static void addUser(User user, String pword){
        if(users == null){
            getData();
        }
        users.put(user.getID(), user);
        pwords.put(user.getID(), pword);
        sendData();
    }

    public static void removeUser(int id){
        if(users == null){
            getData();
        }
        users.remove(id);
        pwords.remove(id);
        sendData();
    }

    public static void removeUser(User user){
        if(users == null){
            getData();
        }
        users.remove(user.getID());
        pwords.remove(user.getID());
        sendData();
    }

    //Accessors
    
    /**
     * Returns unique ID for the purposes of creating a new user
     * */
    public static int getNewID(){
        return users.size() + 10001;
    }
   
    /**
     * Returns user assigned to input id, else null
     * */
    public static User getUser(int id){
        if(users == null){
            getData();
        }
        return users.get(id);
    }

    /**
     * Returns user with input uname, else null
     * */
    public static User getUser(String uname){
        if(users == null){
            getData();
        }
        for(User user : users.values()){
            if(user.getUname().equals(uname)){
                return user;
            }
        }
        return null;
    }

    /**
     * Returns ArrayList containing all users
     * */
    public static ArrayList<User> getUsers(){
        if(users == null){
            getData();
        }
        ArrayList<User> allUsers = new ArrayList<>();
        for(User user : users.values()){
            allUsers.add(user);
        }
        return allUsers;
    }

    /**
     * Returns ArrayList containing all users of input type
     * */
    public static ArrayList<User> getUsers(UserType type){
        if(users == null){
            getData();
        }
        ArrayList<User> targetUsers = new ArrayList<>();
        for(User user : users.values()){
            if(user.getType().equals(type)){
                targetUsers.add(user);
            }
        }
        return targetUsers;
    }

    /**
     * Verifies if input pword matches that of user assigned to input id
     * @return boolean
     **/
    public static boolean checkPword(int id, String pword){
        if(pwords == null){
            getData();
        }
        return pword.equals(pwords.get(id));
    }


}
