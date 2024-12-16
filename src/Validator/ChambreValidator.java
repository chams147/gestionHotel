package Validator;

import Entités.Chambre;
import Entités.Hotel;

public class ChambreValidator {
    public boolean ControledeSaisieChambre(Chambre chambre){
    if(chambre==null)
        return false;
    if(chambre.TypedeChambre==null)
        return false;
   return true;



    }
    public boolean chambreExiste(Hotel hotel ,Chambre chambre){
        if(hotel.getListeDeChambres().contains(chambre))
            return true;
        else
            return  false;




    }


}
