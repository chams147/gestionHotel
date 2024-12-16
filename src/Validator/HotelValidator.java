package Validator;

import Entités.Hotel;

import java.util.List;

public class HotelValidator {
    private  static boolean isInvalidString(String value) {
        return value == null || value.isBlank();
    }
    public static  boolean ControledeSaisie(Hotel h){

        if(h==null){
            return false;

        }

       /* if(h.getNom().isEmpty()||h.getAdresse().isEmpty()||h.getAdresse()==null||h.getNom()==null){ //ancien

            return false;

        }*/

        if(isInvalidString(h.getNom())||isInvalidString(h.getAdresse()))
            return false;
        return  true;

    }

    public boolean hotelExisteDéja(Hotel h, List<Hotel> hotels){
        for(Hotel hotel:hotels)
            if(hotel.getAdresse().equals(h.getAdresse())&&hotel.getNom().equals(h.getNom())){

                return false;



        }
        return true;


    }


}
