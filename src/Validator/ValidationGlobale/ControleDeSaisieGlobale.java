package Validator.ValidationGlobale;


import java.util.regex.Pattern;

public class ControleDeSaisieGlobale {
public static boolean isAllDigit(String numtel){

    char []verifDegit= numtel.toCharArray();
    for(char c:verifDegit){
        if(!(Character.isDigit(c))){
            return  false;

        }


    }
    return true;
}
    public static boolean verifNumTélephone(String numtel){
        if(numtel==null)
            return false;

        if(numtel.isEmpty()||numtel.isBlank())
            return false;
  if(isAllDigit(numtel)&&numtel.length()==8&&(numtel.startsWith("2")||numtel.startsWith("4")||numtel.startsWith("9")||numtel.startsWith("5")))
      return true;


  return false;





    }


    public static boolean isValidEmail(String email) {
        final String EMAIL_REGEX =
                "^[a-zA-Z0-9_+-.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
         if(Pattern.matches(EMAIL_REGEX, email))
             return true;
         else
             return false;
    }


    public static void main(String[] args) {
       // System.out.println(verifNumTélephone("23654325"));
        System.out.println(isValidEmail("chamsca@hotmail.com"));
    }

}
