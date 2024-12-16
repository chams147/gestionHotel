package Validator;

import Entités.Client;
import Entités.Hotel;
import Validator.ValidationGlobale.ControleDeSaisieGlobale;

import java.util.ArrayList;

import static Validator.ValidationGlobale.ControleDeSaisieGlobale.isValidEmail;

public class ClientValidator {
        private  static boolean isInvalidString(String value) {
                return value == null || value.isBlank();
        }


        public static boolean controledeSaisieClient(Client c){

                if(c==null){
                        return false;

                }
                if(isInvalidString(c.getNom())||isInvalidString(c.getEmail())){

                        return false;

                }
                if(!isValidEmail(c.getEmail())){

                        return false;

                }



                return  true;

        }
        public boolean clientExist(Client client ,Hotel hotel){



                if(hotel.getListeDeClients().contains(client)){

                        return true;

                }



                return  false;

        }

        public static void main(String[] args) {
                Client cl1 = new Client("  ch ", "chamsca@hotmail.com");
                ClientValidator cv=new ClientValidator();
                System.out.println(cv.controledeSaisieClient(cl1));

        }






        }
