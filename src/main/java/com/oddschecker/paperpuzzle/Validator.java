package com.oddschecker.paperpuzzle;
/**
 * Singleton class for ensuring there is only one Validator instance.
 * It contains validation methods for different types of fields for safely inserting into database.
 * @author bturny
 * @version 1.0
 */
public class Validator {
    private static Validator instance;

    static {
        // static constructor
        instance = (instance == null) ? new Validator() : instance;
    }

    private Validator() {
        // prevents from creating instances of this class from outside of this class
    }

    public static Validator getInstance() {
        return instance;
    }


    /**
     * checks if it is a valid string
     * @param s - String
     * @return - true or false
     */
    public Boolean isValidString(String s){
        if(s!=null && !s.equals("")){
            return true;
        }
        return false;

    }

    /**
     * This method checks if a String value is an Enum of the Type of Enum passed as argument
     * @param value - the value of the String
     * @param enumClass - the Class of the Enum we are checking for
     * @return true if it is valid or false if not.
     */

    public  <E extends Enum<E>> boolean isInEnum(String value, Class<E> enumClass) {
        for (E e : enumClass.getEnumConstants()) {
            if (e.name().equals(value)) {
                return true;
            }
        }
        return false;
    }



    /**
     * Check is arguments have been supplied and the correct number
     * @param args:Array<String> - the array of arguments
     * @param expectedNoOfArgs:Int - the number of arguments we are expecting.
     */
    public Boolean isValidArgs( String[] args, int expectedNoOfArgs){
        if(args.length == expectedNoOfArgs){
            for(int i = 0; i< expectedNoOfArgs; i++){
                if(!isValidString(args[i])){
                    throw new IllegalArgumentException("One or more arguments is not a valid string.");
                }
            }
            return true;
        }
        else{
            throw new IllegalArgumentException("Invalid arguments supplied. Expected number of arguments are: "+expectedNoOfArgs);
        }

    }


}




