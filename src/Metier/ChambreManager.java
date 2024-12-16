package Metier;

import Entités.Chambre;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Entités.Hotel;
import Entités.Réservation;
import Enum.TypeDeChambre;
public class ChambreManager {
    ArrayList<Chambre> listeDeChambres = new ArrayList<>();
    double prixDeChambre=45;


    public double calculerPrixDeChambre(Chambre c) {

        if (c.TypedeChambre.equals(TypeDeChambre.SIMPLE)) {
           prixDeChambre=prixDeChambre;

        } else if (c.TypedeChambre.equals(TypeDeChambre.Double)) {
            prixDeChambre+=prixDeChambre*0.75;
        } else if (c.TypedeChambre.equals(TypeDeChambre.Triple)) {
          prixDeChambre+=prixDeChambre*0.5;
        } else {
            System.out.println("erreur");
        }
        return prixDeChambre;


    }

    public static void main(String[] args) {
        Hotel[] hotels=new Hotel[3];
        hotels[0] =new Hotel("El Mouradi","Monastir");
        hotels[1]=new Hotel("El palmier","Monastir");
        hotels[2] =new Hotel("El Habib","Monastir");
        ChambreManager cm1=new ChambreManager();
        //cm1.ajouterChambre(hotels[0]);
        System.out.println(cm1.calculerPrixDeChambre(hotels[0].getListeDeChambres().get(3)));
    }


}
