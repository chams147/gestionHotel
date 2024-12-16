package Repository;

import Entités.Chambre;
import Entités.Hotel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HotelRepo {
   List<Hotel> hotels = new ArrayList<>();
    public int  findIndexHotel(Hotel hotel){

            return hotels.indexOf(hotel);




    }
    public void updateHotele(Hotel hotel){


        if(findIndexHotel(hotel)!=-1) {
            //hotel.setDernierMiseAJour(LocalDateTime.now());



            hotels.get(findIndexHotel(hotel)).setNom("new hotel 1");
          hotels.get(findIndexHotel(hotel)).setAdresse("new hotel 1");

        }
    }

    // Méthode pour sauvegarder l'hôtel dans un fichier texte
    /*
    public void saveHotelToFile(Hotel hotel) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(hotel.getNom() + ".txt"))) {
            writer.write("Nom de l'hôtel: " + hotel.getNom() + "\n");
            writer.write("Chambres:\n");
            for (Chambre chambre : hotel.getListeDeChambres()) {
                writer.write(" - Chambre " + chambre.getNumero() + ": " + chambre.TypedeChambre + "\n");
            }
            System.out.println("L'hôtel a été sauvegardé dans le fichier " + hotel.getNom() + ".txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
    public void ajouterHotel(Hotel hotel) {
        hotels.add(hotel);
    }
    public void SupprimerHotel(Hotel hotel){

        hotels.remove( hotel);

    }


    public List<Hotel> getHotels() {
        return hotels;
    }




}
