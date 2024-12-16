package Présentation;

import Entités.Hotel;
import Entités.Chambre;
import Entités.Client;
import Entités.Réservation;

import java.awt.desktop.SystemSleepEvent;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Metier.ChambreManager;
import Metier.ClientManager;
import Metier.HotelManager;
import Repository.ChambreRepo;
import Repository.ClienttRepo;
import Repository.HotelRepo;
import Enum.TypeDeChambre;
import Repository.ReservationRépo;
import Validator.ChambreValidator;
import Validator.ClientValidator;
import Validator.HotelValidator;
import Validator.RéservationValidator;
import Validator.ValidationGlobale.DateFormat;

public class Main {
    public static void main(String[] args) {
        Hotel[] hotels = new Hotel[3];
        hotels[0] = new Hotel("El Mouradi", "Monastir");
        hotels[1] = new Hotel("El palmier", "Monastir");
        hotels[2] = new Hotel("El Habib", "Monastir");

        /**creations des chambres avec aggregation faible**/
        /*
        Chambre c1=new Chambre("Simple",90);
        Chambre c2=new Chambre("Simple",70);
        Chambre c3=new Chambre("Double",100);
        Chambre c4=new Chambre("Double",120);

         */
        Client cl1 = new Client("chams", "chams-ca@hotmail.com");
        Client cl2 = new Client("ahmed", "ahmed-ca@hotmail.com");
        Client cl3 = new Client("ines", "ines-ca@hotmail.com");
        Client cl4 = new Client("amira", "amira-ca@hotmail.com");
        /**ajoute des chambres ave aggregation fiable **/
        /*
        h1.ajouterChambre(c1);
        h1.ajouterChambre(c2);
        h1.ajouterChambre(c3);
        h1.ajouterChambre(c4);
        */

        /** ajouter des clients** avant agregation faibe **/
        // h1.ajouterCLient(cl1);
        //h1.ajouterCLient(cl2);
        /**ajouter client avec aggregation forte**/
        // h1.ajouterCLient();
/**affichage client**/
        //    System.out.println(h1.getListeDeClients());
        //h1.supprimerClientByid(3);
        // System.out.println("Aprés suppression");
        //System.out.println(h1.getListeDeClients());
        /*ajout des chambre avec agrégarion forte**/
        /** ajout des chambres avec aggregation forte**/
        //  hotels[0].ajouterChambre();
       // ChambreManager cm1 = new ChambreManager();
        //HotelManager hm = new HotelManager();
       /* hm.ajouterChambre(hotels[0]);
        System.out.println("liste des chambres ");
        System.out.println(hotels[0].getListeDeChambres());
        System.out.println(cm1.calculerPrixDeChambre(hotels[1].getListeDeChambres().get(3)));

*/
        /**affichage avant réseervation*/
        /*
        // System.out.println(h1);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd,yyyy,hh:mm");
        LocalDateTime dateDebut = LocalDateTime.now();
        LocalDateTime dateFin = dateDebut.plusDays(3);
        //System.out.println(dateDebut.format(f));
        LocalDateTime dateDebut1 = LocalDateTime.now();
        LocalDateTime dateFin1 = dateDebut.plusDays(4);
        */


        /**reservation **/

      /*  Réservation r1=new Réservation(cl1,c1,h1,dateDebut,dateFin);
        Réservation r2=new Réservation(cl2,c1,h1,dateDebut1,dateFin1);
        Réservation r3=new Réservation(cl1,c3,h1,dateDebut,dateFin);
        Réservation r4=new Réservation(cl2,c1,h1,dateDebut,dateFin);
      h1.ajouterReservation(r1);
      h1.ajouterReservation(r2);
      h1.ajouterReservation(r4);
      h1.supprimerClient(cl1);*/
        //   System.out.println(h1.getListeDeRéservation())

        // System.out.println(r1);
        //System.out.println(cl1);
        /**ajout de client par hotel puis client va ajouter une reservation par agreggation fort**/
        /*
        hotels[0].ajouterCLient(cl1);
        hotels[0].ajouterCLient(cl2);
        System.out.println("Liste des clients");
        System.out.println(hotels[0].getListeDeClients());
        System.out.println("ajouter Réserveration");
        LocalDateTime dateDebut0 = LocalDateTime.now();
        LocalDateTime dateFin0 = dateDebut.plusDays(4);
        Chambre c = hotels[0].choixChambreAléatoirement();
        Réservation r1 = new Réservation(c, dateDebut0, dateFin0);
        Réservation r2 = new Réservation(c, dateDebut0, dateFin0);
        */

        // hotels[0].ajouterReservation("chams",r1); //TODO Cannot resolve method 'ajouterReservation' in 'Client'
        // h1.ajouterReservation("ahmed",r2);
        /**Creer client manager afin d'appliquer  single responsabilité**/
        /*
        ClientManager clm1 = new ClientManager();
        /**note hotel1**/
        /*
        hotels[0].ajouterCLient(cl3);
        hotels[0].ajouterCLient(cl4);
        clm1.noterHotel(cl1,hotels[0]);
        clm1.noterHotel(cl2,hotels[0]);

        clm1.noterHotel(cl3,hotels[0]);
        clm1.noterHotel(cl4,hotels[0]);

        System.out.println(hotels[0].getAvisDesUtilisateurs());
      //  System.out.println(h1);
        System.out.println(hotels[0].AverageNote) ;


       // System.out.println(h1.calculerAvis());
       */

        /** notes hotel 2**/
        /*
     hotels[1].ajouterCLient(cl1);
        hotels[1].ajouterCLient(cl2);
        hotels[1].ajouterCLient(cl3);
        hotels[1].ajouterCLient(cl4);
        clm1.noterHotel(cl1,hotels[1]);
        clm1.noterHotel(cl2, hotels[1]);
        clm1.noterHotel(cl3, hotels[1]);
        clm1.noterHotel( cl4,hotels[1]);
        System.out.println( hotels[1].getAvisDesUtilisateurs());
        System.out.println( hotels[1].AverageNote);
*/
        /**notes hotel3**/
        /*
        hotels[2].ajouterCLient(cl1);

        hotels[2].ajouterCLient(cl2);
        hotels[2].ajouterCLient(cl3);
        hotels[2].ajouterCLient(cl4);
        clm1.noterHotel(cl1,hotels[2]);
        clm1.noterHotel(cl2,hotels[2]);
        clm1.noterHotel(cl3,hotels[2]);
        clm1.noterHotel(cl4,hotels[2]);
        System.out.println(hotels[2].getAvisDesUtilisateurs());
        System.out.println(hotels[2].AverageNote);
        */

/**Trier Hotels selon avis des Utilmisateurs et afficher le nom de meilleur hotel**/
/*
        ArrayList<Hotel> listeDesHotélsTriés=new ArrayList<>();
        /*
        double max= hotels[0].AverageNote;
        int pos=0;
for(int i=1;i<hotels.length;i++){
if(max<hotels[i].AverageNote){
    max=hotels[i].AverageNote;
    pos=i;




}



}
        System.out.println(hotels[pos].getNom());

for (int i=0;i<hotels.length;i++){


    listeDesHotélsTriés.add(hotels[i]);

}

listeDesHotélsTriés.sort((h2,h1)->Double.compare(h1.AverageNote, h2.AverageNote));

        //  System.out.println(cl1.getListedeRéservation());
     //  System.out.println(cl2.getListedeRéservation());

for(Hotel i:listeDesHotélsTriés)
    System.out.println(i.getNom());


    }
    */

        /**utiliser les bonnnes pratiques de conception **/
        /**        ajout des chambres dans un hotel**/
        DateFormat dateFormat=new DateFormat();
      //  System.out.println("listedeschambres");
        Chambre c1=new Chambre(TypeDeChambre.SIMPLE,true);
        Chambre c2=new Chambre(TypeDeChambre.Double,true);
        Chambre c3=new Chambre(TypeDeChambre.Triple,true);
        Chambre c4=new Chambre(TypeDeChambre.Triple,true);
        Chambre c5=new Chambre();
        ReservationRépo reservationRépo=new ReservationRépo();
        RéservationValidator réservationValidator=new RéservationValidator();
        ClientValidator clientValidator=new ClientValidator();
        ClienttRepo clienttRepo=new ClienttRepo();
        ChambreValidator chambreValidator=new ChambreValidator();
        ChambreRepo chambreRepo=new ChambreRepo();
        HotelRepo hotelRepo=new HotelRepo();
        HotelValidator hotelValidator=new HotelValidator();
        HotelManager hm=new HotelManager(hotelRepo,hotelValidator,chambreRepo,chambreValidator,clientValidator,clienttRepo,réservationValidator,reservationRépo);
        /**Add Hotel**/
        //hm.ajouterChambre(hotels[0],c1);
       // hm.ajouterChambre(hotels[0],c4);
        hm.ajouterHotel(hotels[0]);
        hm.ajouterHotel(hotels[1]);
        hm.ajouterHotel(hotels[2]);
        //System.out.println(hotelRepo.getHotels());
        /**pause de 5 secondes après la création des hôtels**/
      /*  try {
            System.out.println("Pause de 5 secondes après la création des hôtels...");
            Thread.sleep(4900);  // 5000 millisecondes = 5 secondes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
/**supp hotel**/
        // System.out.println("apres suppression de hotel");
       // hm.SupprimerHotel(hotels[2]);
        /**update hotel+add chambre**/
      /*  System.out.println("apres modification de l'hotel");
        hm.updateHotel(hotels[2]);*/


        hm.ajouterChambre(hotels[0],c1);
        hm.ajouterChambre(hotels[0],c3);
        System.out.println(hotelRepo.getHotels());
        /**supp chambre**/
        //hm.supprimerChambre(hotels[0],c3);


        try {
            System.out.println("Pause de 3 seconde aprés la supression du chambre ...");
            Thread.sleep(3000);  // 5000 millisecondes = 5 secondes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       // System.out.println(hotelRepo.getHotels());

        /**ajouter un client dans un hotel **/
        hm.ajouterClient(hotels[0],cl1);
        hm.ajouterClient(hotels[0],cl2);
        hm.ajouterClient(hotels[0],cl3);
        hm.ajouterClient(hotels[0],cl4);
        System.out.println(hotelRepo.getHotels());
        try {
            System.out.println("Pause de 5 seconde aprés la supression du client...");
            Thread.sleep(5000);  // 5000 millisecondes = 5 secondes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    //    hm.supprimerClient(hotels[0],cl1);
      //  hm.supprimerClient(hotels[0],cl4);
        System.out.println(hotelRepo.getHotels());
        try {
            System.out.println("Pause de 5 seconde aprés la ajout de réservation ...");
            Thread.sleep(5000);  // 5000 millisecondes = 5 secondes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Réservation r1=new Réservation(cl3,c1,hotels[0],LocalDateTime.now(),LocalDateTime.now().plusDays(2));
        Réservation r2=new Réservation(cl2,c1,hotels[0],LocalDateTime.now().plusDays(6),LocalDateTime.now().plusDays(8));
        Réservation r3=new Réservation(cl1,c1,hotels[0],LocalDateTime.now().plusDays(9),LocalDateTime.now().plusDays(10));
        Réservation r4=new Réservation(cl4,c1,hotels[0],LocalDateTime.now().plusDays(1),LocalDateTime.now().plusDays(2));

        hm.ajouterRéservation(r1);
        hm.ajouterRéservation(r2);
        hm.ajouterRéservation(r3);
        hm.ajouterRéservation(r4);
        System.out.println(hotelRepo.getHotels().get(0).getListeDeRéservation());
        /**supp réservation**/
       // hm.supprimerRéservation(r1,hotels[0]);
        //System.out.println("Aprés supp");

        //System.out.println(hotelRepo.getHotels().get(0).getListeDeRéservation());
        /**Date la plus proche dispo**/
        hm.infoRéservationsEffectuer();












  }


  }


