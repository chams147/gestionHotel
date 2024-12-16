package Repository;

import Entités.Chambre;
import Entités.Hotel;
import Validator.ChambreValidator;

import java.util.ArrayList;
import java.util.List;

public class ChambreRepo {
/*
    public void  ajouterChambre(Hotel hotel, Chambre chambre){ //ma méthode

        ArrayList<Chambre> chambres=hotel.getListeDeChambres();
        chambres.add(chambre);


    }

 */
    public void ajouterChambre(Hotel hotel, Chambre chambre) { // version amelioré
        // Vérifier si l'hôtel a une liste de chambres, sinon l'initialiser
        if (hotel.getListeDeChambres() == null) {
            hotel.setListeDeChambres(new ArrayList<>());
        }

        // Obtenir la liste des chambres de l'hôtel
        List<Chambre> chambres = hotel.getListeDeChambres();

        // Vérifier si la chambre existe déjà dans la liste (pour éviter les doublons)
        if (!chambres.contains(chambre)) {
            chambres.add(chambre);
        } else {
            System.out.println("La chambre existe déjà dans la liste.");
        }
    }
    public void supprimerChambre(Hotel hotel,Chambre chambre){


        List<Chambre> chambres = hotel.getListeDeChambres();
        if(chambre!=null&&chambres.contains(chambre))//Todo reviens ici quand j'apprend le thread
        chambres.remove(chambre);



    }
}


