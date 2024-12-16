package Metier;

import Entités.Client;
import Entités.Hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientManager {

    static ArrayList<Client> listedeClient=new ArrayList<>();
    public  void ajouterClient(Client client){

        listedeClient.add(client);

    }
    public static Client getClientByName(String nom){
        for(Client c:listedeClient){
            if(c.getNom().equals(nom))
                return c;


        }

        return  null;


    }
    public  static Client  RechercheClient    (String nom){
        for(Client c:listedeClient){
            if(c.getNom().equals(nom))
                return c;


        }

        return  null;



    }
    public  static Client  RechercheClient   (int id ) {
        for (Client c : listedeClient) {
            if (c.getId() == id)
                return c;


        }
        return  null;
    }





        public double noterHotel(Client c, Hotel h1){
            Scanner sc=new Scanner(System.in);
            double note=0.0;
            if(h1.verifClient(c.getNom())){
                System.out.println("Donner Une Note / 10");
                note=sc.nextDouble();
            /*
            h1.avisDesUtilisateurs.add(note);
 //h1.calculerAvis();//-->Mais il est tres lourd  recalculer toute la moyenne à partir de zéro à chaque fois.

*/
                h1.AjouterNote(note);



            }


            return note;






        }



}
