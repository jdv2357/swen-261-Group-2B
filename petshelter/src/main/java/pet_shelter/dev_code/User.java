class User {
 
    //Vars
   
    private int id;
    private String uname;
    private UserType type;
    
    //Constructors

    public User(int id, String uname, UserType type){
        this.id = id;
        this.uname = uname;
        this.type = type;
    }

    //Accessors

    public int getID(){
        return this.id;
    }

    public String getUname(){
        return this.uname;
    }

    public UserType getType (){
        return this.type;
    }

    public String toString(){
        return this.id + this.type.toString() + " / " + this.uname;
    }
}
