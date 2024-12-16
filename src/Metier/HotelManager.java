package Metier;

import Entités.Chambre;
import Entités.Client;
import Entités.Hotel;
import Entités.Réservation;
import Enum.TypeDeChambre;
import Repository.ChambreRepo;
import Repository.ClienttRepo;
import Repository.HotelRepo;
import Repository.ReservationRépo;
import Validator.ChambreValidator;
import Validator.ClientValidator;
import Validator.HotelValidator;
import Validator.RéservationValidator;
import Validator.ValidationGlobale.DateFormat;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class HotelManager {
    ArrayList<Integer> listeDeReserVationEffectuer=new ArrayList<>();
    DateFormat dateFormat;
HotelRepo hotelRepo;
HotelValidator hotelValidator;
ChambreRepo chambreRepo;
ChambreValidator chambreValidator;
ClientValidator clientValidator;
ClienttRepo clienttRepo;
RéservationValidator réservationValidator;
ReservationRépo reservationRépo;

    public HotelManager(HotelRepo hotelRepo ,HotelValidator hotelValidator ,ChambreRepo chambreRepo,ChambreValidator chambreValidator,ClientValidator clientValidator,ClienttRepo clienttRepo,RéservationValidator réservationValidator,ReservationRépo reservationRépo) {
        this.hotelRepo = hotelRepo;
        this.hotelValidator=hotelValidator;
        this.chambreRepo=chambreRepo;
        this.chambreValidator=chambreValidator;
        this.clientValidator=clientValidator;
        this.clienttRepo=clienttRepo;
        this.réservationValidator=réservationValidator;
        this.reservationRépo=reservationRépo;
    }
    public void  ajouterHotel(Hotel hotel){
        if(hotelValidator.ControledeSaisie(hotel)) {
            if (hotelValidator.hotelExisteDéja(hotel, hotelRepo.getHotels())) {
                hotelRepo.ajouterHotel(hotel);
                System.out.println("Hotel est bien effectuer dans Notre  BD");
            }else
                System.out.println("hotel  existe déja  dans notre base de donnés ");
        }
       else
           System.out.println("Verifier les donnés");


    }

    public boolean isSupA5Secondes(Hotel hotel){


        LocalDateTime derniereMiseAJour=hotel.getDernierMiseAJour();
        LocalDateTime maintenant=LocalDateTime.now();

        // Calcul du temps écoulé depuis la dernière mise à jour en secondes
        long diffEnSecondes = Duration.between(derniereMiseAJour, maintenant).toSeconds();
        // Vérification du délai de 5 secondes

        return  diffEnSecondes >= 5 ;



    }
    public void updateHotel(Hotel hotel){




        if(!hotelValidator.hotelExisteDéja(hotel, hotelRepo.getHotels())){

            if (isSupA5Secondes(hotel) ){
                hotelRepo.updateHotele(hotel);
                System.out.println("Hôtel mis à jour avec succès.");
            } else {
                System.out.println("L'hôtel ne peut pas être modifié avant 5 Secondes");
            }




        }





    }

    public void SupprimerHotel(Hotel hotel){

        if(!hotelValidator.hotelExisteDéja(hotel,  hotelRepo.getHotels())){
            hotelRepo.SupprimerHotel(hotel);
            System.out.println("hotel a éte supprimer corecctement ");


        }

    }
/*
// ancien version de ajout de chambre ici on réspecte pas SRP
    public void ajouterChambre(Hotel hotel, Chambre chambre) {
            if (chambre != null && !hotel.getListeDeChambres().contains(chambre)) {
                hotel.getListeDeChambres().add(chambre);
                System.out.println("Chambre ajoutée à l'hôtel " + hotel.getNom());
            } else {
                throw new IllegalArgumentException("Chambre invalide ou déjà présente.");
            }
        }

*/

    public void ajouterChambre(Hotel hotel,Chambre chambre){
        if(hotelValidator.ControledeSaisie(hotel)){
            if(chambreValidator.ControledeSaisieChambre(chambre)) {
                chambreRepo.ajouterChambre(hotel, chambre);

            } else System.out.println("chambre non valide");

        } else System.out.println("hotel  nom valide");



    }
    public void supprimerChambre(Hotel hotel, Chambre c){
        if(chambreValidator.chambreExiste(hotel,c)){

            chambreRepo.supprimerChambre(hotel,c);

        }else
            System.out.println("Chambre invalide");







    }
    public void ajouterClient(Hotel hotel, Client client){


        if(clientValidator.controledeSaisieClient(client)){
            clienttRepo.ajouterClient(hotel,client);




        }






    }
    public void supprimerClient(Hotel hotel,Client client){

        if(clientValidator.clientExist(client,hotel)){

            clienttRepo.supprimerClient(hotel,client);

        }

    }
    public boolean verifDispoChambre( Hotel hotel,Réservation r) {
        if (hotel.getListeDeRéservation().size() == 0)
            return true;

        for (Réservation réservation : hotel.getListeDeRéservation()) {

            if (réservation.getChambre() == r.getChambre()) {



                if(r.getDateDebut().getDayOfMonth()>=réservation.getDateDebut().getDayOfMonth()&&r.getDateDebut().getDayOfMonth()<=réservation.getDateFin().getDayOfMonth()){

                    return false;

                }


            }





        }
        return true;

    }
public void ajouterRéservation(Réservation réservation){

        if(réservationValidator.controleDeSaisie(réservation)){

            if(verifDispoChambre(réservation.getHotel(),réservation)) {

                reservationRépo.ajouterRéservation(réservation, réservation.getHotel());

                listeDeReserVationEffectuer.add(réservation.getDateDebut().getDayOfMonth());
                listeDeReserVationEffectuer.add(réservation.getDateFin().getDayOfMonth());
            }

        }




}
public void infoRéservationsEffectuer(){

    System.out.println(listeDeReserVationEffectuer);

}
public void periodePlusProcheDispo(){
        int i=1;
        while(i< listeDeReserVationEffectuer.size()-2){

            if((listeDeReserVationEffectuer.get(i)+1)==listeDeReserVationEffectuer.get(i+1)){

                i=i+2;

            }else
                System.out.println("la periode plus proche Dispo est"+listeDeReserVationEffectuer.get((i)));




        }


}
public void supprimerRéservation(Réservation réservation,Hotel hotel){
        if(réservationValidator.résevationExist(réservation,hotel)){
            reservationRépo.suppRéservation(réservation,hotel);





        }








}



}
