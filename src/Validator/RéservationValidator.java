package Validator;

import Entités.Chambre;
import Entités.Client;
import Entités.Hotel;
import Entités.Réservation;

import java.time.LocalDateTime;

import static  Validator.ClientValidator.controledeSaisieClient;
import static Validator.HotelValidator.ControledeSaisie;

public class RéservationValidator {


/**Façon optimisée**/
public boolean controleDeSaisie(Réservation reservation){

    if(reservation==null){

        return  false;

    }
    if(!isValidDate(reservation.getDateDebut(),reservation.getDateFin())){
        System.out.println("Date Invalide ");
        return false;



    }
    if(!isValidChambre(reservation.getChambre(),reservation.getHotel())){
        System.out.println("chambre invalide");
        return  false;


    }
    if(!isValidClient(reservation.getClient(),reservation.getHotel())){

        System.out.println("client invalide");
        return  false;


    }
    if(!isValidHotel(reservation.getHotel())){

        System.out.println("hotel invalide");
        return false;


    }


    return true;
}
    public boolean isValidChambre(Chambre chambre ,Hotel hotel){
      //  vous vérifiez la nullité de chambre à la fin. Cette vérification doit être faite en premier,
        //  car s'il est null, vous évitez de vérifier les autres champs.
/** 1**/
    /*    if(chambre.TypedeChambre==null)
            return false;

        if(chambre.estDisponible==false)
            return false;

        return chambre!=null;
*/
//Dans la méthode isValidChambre, vous accédez aux champs de l'objet directement (ex. chambre.TypedeChambre). Si possible,
//TODO  il est préférable d'utiliser des getters pour accéder aux propriétés d'un objet. Cela permet d'assurer une meilleure encapsulation.
/*
        if (chambre == null) return false;
        if (chambre.TypedeChambre == null) return false;
        if (!chambre.estDisponible) return false;

        return true;

*/

       return (hotel.getListeDeChambres().contains(chambre)&&chambre!=null&&chambre.TypedeChambre!=null&&chambre.estDisponible==true) ;

    }
public boolean isValidClient(Client client,Hotel hotel){

  return (hotel.getListeDeClients().contains(client)&&controledeSaisieClient(client));
    /*if(!controledeSaisieClient(client)){// ToDo a revenier ici a la fin de formation oca

        return false;

    }

    return  true;
*/
}
public boolean isValidHotel(Hotel hotel){
    return (ControledeSaisie(hotel)); //mieux que précedente return false,true;


}
public boolean isValidDate(LocalDateTime dateDébut, LocalDateTime dateFin){
    return(dateDébut!=null&&dateFin!=null);




}
public boolean résevationExist(Réservation réservation,Hotel hotel){
    if (réservation == null || hotel == null || hotel.getListeDeRéservation() == null) {
        return false;
    }
    return(hotel.getListeDeRéservation().contains(réservation));



}



 /* ma focon d'ecriré
    public boolean controleDeSaisie(Réservation réservation){
        if(réservation==null)
            return false;
        if(réservation.getChambre()==null||réservation.getHotel()==null||réservation.getClient()==null){

            return  false;

        }


return  true;

    }
*/
 public static void main(String[] args) {
     Réservation r=new Réservation(null,null,null);
     RéservationValidator réservationValidator=new RéservationValidator();
     System.out.println(réservationValidator.controleDeSaisie(r));
 }

}
