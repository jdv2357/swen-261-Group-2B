enum UserType {

    ROOT,
    ADMIN,
    CONTRIBUTOR,
    ORGANIZATION,
    VOLUNTEER,
    ERROR;

    /**
     * Return UserType that corresponds to input 'str' as per UserType format
     * */
    public static UserType fromString(String str){
        switch(str){
            case "r":
                return ROOT;
            case "a":
                return ADMIN;
            case "c":
                return CONTRIBUTOR;
            case "o":
                return ORGANIZATION;
            case "v":
                return VOLUNTEER;
            default:
                return ERROR;
        }
    }

    /**
     * Return String that corresponds to type as per UserType format
     * */
    public String toString(){
        switch(this){
            case ROOT:
                return "r";
            case ADMIN:
                return "a";
            case CONTRIBUTOR:
                return "c";
            case ORGANIZATION:
                return "o";
            case VOLUNTEER:
                return "v";
           default:
                return "0";
        }
    }

}
