package Repository;

import Entités.Client;
import Entités.Hotel;

import java.util.ArrayList;

public class ClienttRepo {

    public void ajouterClient(Hotel hotel, Client client){
// Vérifier si l'hôtel a une liste de clients, sinon l'initialiser
        if (hotel.getListeDeClients() == null) {
            hotel.setListeDeClients(new ArrayList<>());
        }



        ArrayList<Client> clients=hotel.getListeDeClients();


        if(!clients.contains(client))
            clients.add(client);

    }
    public void supprimerClient(Hotel hotel,Client client){

      ArrayList<Client> clients=hotel.getListeDeClients();
      if(client!=null&&clients.contains(client)){

          clients.remove(client);

      }else
          System.out.println("client n'existe pas dans notre base de donnés");




    }


}
