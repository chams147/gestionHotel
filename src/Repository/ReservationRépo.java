package Repository;

import Entités.Hotel;
import Entités.Réservation;

import java.util.ArrayList;
import java.util.List;

public class

ReservationRépo {

    public void ajouterRéservation(Réservation réservation,Hotel hotel){
        if(hotel.getListeDeRéservation()==null){

            hotel.setListeDeRéservation(new ArrayList<>());

        }

        ArrayList<Réservation> réservations=hotel.getListeDeRéservation();
        réservations.add(réservation);
       // réservation.getChambre().setEstDisponible(false);



    }
public  void suppRéservation(Réservation réservation,Hotel hotel){
    List<Réservation> réservations=hotel.getListeDeRéservation();

        if(réservation!=null&&réservations.contains(réservation))

        hotel.getListeDeRéservation().remove(réservation);


}
}
