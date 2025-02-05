enum UserType {

    root,
    admin,
    contributor,
    organization,
    volunteer,
    error;

    /**
     * Return UserType that corresponds to input 'str' as per UserType format
     * */
    public static UserType fromString(String str){
        switch(str){
            case "r":
                return root;
            case "a":
                return admin;
            case "c":
                return contributor;
            case "o":
                return organization;
            case "v":
                return volunteer;
            default:
                return error;
        }
    }

    /**
     * Return String that corresponds to type as per UserType format
     * */
    public String toString(){
        switch(this){
            case root:
                return "r";
            case admin:
                return "a";
            case contrubutor:
                return "c";
            case organization:
                return "o";
            case volunteer:
                return "v";
           default:
                return "0";
        }
    }

}
