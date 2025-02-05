class User {

    private static int numUsers = 0;
    
    private String uname;
    private int id;
    private UserType type;
    
    public User (String uname, UserType type){
        this.id = numUsers;
        numUsers++;
    }

}
