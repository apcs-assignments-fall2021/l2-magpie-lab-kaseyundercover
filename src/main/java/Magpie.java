/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement) {

        String response = "";
        if (findWord(statement, "no") >= 0) {
            response = "Why so negative?";
        } else if (findWord(statement, "mother") >= 0
                || findWord(statement, "father") >= 0
                || findWord(statement, "sister") >= 0
                || findWord(statement, "brother") >= 0) {
            response = "Tell me more about your family.";
        } else if (findWord(statement, "dog") >= 0
                || findWord(statement, "cat") >= 0) {
            response = "Tell me more about your pets";
        } else if (findWord(statement, "Mr.") >= 0
                || findWord(statement, "mr.") >= 0
                || findWord(statement, "mrs.") >= 0
                || findWord(statement, "Mrs.") >= 0) {
            response = "Your teacher seems quite elegant";
        } else if (statement.trim().equals("")) {
            response = "Say something, please.";
        } else if (findWord(statement, "friend") >= 0) {
            response = "Wanna be friends?";
        } else if (findWord(statement, "live") >= 0) {
            response = "I live in Danville";
        } else if (findWord(statement, "I think") >= 0) {
            response = Ithink(statement);
        } else if (findWord(statement, "look like") >= 0) {
            response = "I have a mustache and I'm tall";
        } else if (findWord(statement, "I want to") >= 0) {
            response = transformIWantToStatement(statement);
        } else if (findWord(statement, "I want") >= 0) {
            response = transformIWantStatement(statement);
        } else if (findWord(statement, "i want") >= 0) {
            response = transformIWantStatement(statement);
        } else if (findWord(statement, "I") >= 0 && findWord(statement, "you") >= 0 && findWord(statement, "you") > findWord(statement, "I")) {
            response = transformIYouStatement(statement);
        } else if (findWord(statement, "you") >= 0 && findWord(statement, "me") >= 0 && findWord(statement, "me") > findWord(statement, "you")) {
            response = transformYouMeStatement(statement);
        } else if (findWord(statement, "red") >= 0
                || findWord(statement, "blue") >= 0
                || findWord(statement, "green") >= 0
                || findWord(statement, "orange") >= 0) {
            response = "That is my favorite color!";
        }
        else if (findWord(statement, "sport") >= 0) {
            response = "I love baseball!";}
     else if (findWord(statement, "I like") >= 0) {
    response = ilike(statement);}
     else if (findWord(statement, "Do you") >= 0
         || (findWord(statement, "do you") >= 0)) {
         response = "I most certainly do!" ;}
        else if (findWord(statement, "Can you") >= 0
                || (findWord(statement, "can you") >= 0)) {
            response = "I don't know, can I?" ;}
        else if (findWord(statement, "name") >= 0) {
            response = "My name is Magpie.";}
        else if (findWord(statement, "I feel") >= 0) {
            response = Ifeel(statement);}



    else
        {
            response = getRandomResponse();
        }
        return response;
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    public String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 4;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
    
        return response;
    }

    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that 
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization 
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise. 
    public int findWord(String str, String word) {
    str=str.toLowerCase();
        word=word.toLowerCase();
        int index=str.indexOf(word);
        if (index==-1){
        return -1;}
        else if (index == 0 && str.charAt(word.length()) == ' '){
            return index;}

        else if(index + word.length()==str.length() && str.charAt(index-1) == ' '){
             return index;}

        else if (str.charAt(index-1) == ' ' && str.charAt(word.length()+index) == ' '){
            return index;}

       else return -1;
    }



    
    // We will work on the following methods later!

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement)
    {
        String updatedwant=(statement.replace("I want", ""));
        String wantstatement="Would you really be happy if you had" + updatedwant + "?";
        return wantstatement;
    }

    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement)
    {
        String sub=(statement.substring(2, statement.length()-4));
        String youstatement="Why do you " + sub + " me?";
        return youstatement;
    }

    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement)
    {
        String sub=(statement.substring(7, statement.length()));
        String youstatement="What would it mean " + sub + "?";
        return youstatement;
    }




    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
        statement = statement.trim();
        String p = statement.substring(statement.length() - 1);
        if (p.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        int x = findWord(statement, "you");
        int y = findWord(statement, "me");
        String sub = statement.substring(x + 3, y).trim();
        return "What makes you think that I " + sub + " you?";



    }


public String Ithink(String statement){
    String sub=(statement.substring(7, statement.length()));
    String think="Are you sure that" + sub + "?";
    return think;
}
    public String ilike(String statement)
    {
        String sub=(statement.substring(6, statement.length()));
        String youstatement="I really don't like" + sub + "!";
        return youstatement;
    }


    public String Ifeel(String statement)
    {
        String sub=(statement.substring(6, statement.length()));
        String youstatement="Why do you feel" + sub + "?";
        return youstatement;
    }
}

