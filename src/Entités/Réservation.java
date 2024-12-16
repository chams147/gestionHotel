package Entités;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import  Enum.TypeDeChambre;
import Validator.ValidationGlobale.DateFormat;

public class Réservation {

  static DateFormat dateFormat=new DateFormat();
    int id;
    static int count;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    Hotel hotel;
    Client client;
    Chambre chambre;

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    LocalDateTime dateDebut;
    LocalDateTime dateFin;

    public Réservation(Client client, Chambre chambre, Hotel hotel, LocalDateTime dateDebut, LocalDateTime dateFin) {

        this.id = ++count;

        this.client = client;

        this.chambre = chambre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.hotel = hotel;


    }

    public Réservation( Hotel hotel  ,Chambre chambre, LocalDateTime dateDebut, LocalDateTime dateFin) {
        this.id = ++count;
        this.hotel = hotel;

        this.chambre = chambre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

   /* public Client newClient(Client c1)  {
        try {


            if (c1.isExist == true) {
                c1.isExist = false;
                return c1;


            }
        } catch (Exception e) {
            System.out.println(e.getMessage());


        }

 return null;
    }*/
    public Réservation(  Chambre  chambre, LocalDateTime dateDebut, LocalDateTime dateFin) {
        this.id = ++count;


        this.chambre = chambre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;

    }


    public  int longeurDuMois(LocalDateTime date){


        int longeurDeMois=-1;
        switch (date.getMonthValue()){

            case 1,3,5,7,8,10,12: {
                longeurDeMois=31;
                break;
            }
            case 2:{

                longeurDeMois=28;
                break;


            }
            case 4,6,9,11:{

                longeurDeMois=30;
                break;


            }





        }





return longeurDeMois;



    }
    public int  dureeDeSéjour(){

        int longeurDateDeDebut=longeurDuMois(dateDebut);
        int longeurDatefin=longeurDuMois(dateFin);

            if(dateDebut.getMonthValue()!=dateFin.getMonthValue())
        return longeurDateDeDebut-dateDebut.getDayOfMonth()+dateFin.getDayOfMonth();
            else
                return dateFin.getDayOfMonth()-dateDebut.getDayOfMonth();



    }

    @Override
    public String toString() {
        DateTimeFormatter f=DateTimeFormatter.ofPattern("MMMM dd,yyyy,hh:mm");

        return "Réservation{" +
                "id=" + id +
                ", client=" + client.getNom() +
                ", chambre=" + chambre.getNumero()+//" prix par nuité  "+chambre.getPrixParUnité()+ " prixTotal: "+ chambre.prixParUnité*dureeDeSéjour()+
                ", dateDebut=" + dateDebut.format(f)+
                ", dateFin=" + dateFin.format(f) +
                '}';
    }

    public static void main(String[] args) {
        //DateTimeFormatter f=DateTimeFormatter.ofPattern("MMMM dd,yyyy,hh:mm");
        LocalDateTime dateDebut0=LocalDateTime.now();
        LocalDateTime dateFin0=dateDebut0.plusDays(4);
  Chambre c=new Chambre(TypeDeChambre.SIMPLE,true);
        Réservation r1=new Réservation(c,dateDebut0,dateFin0);
        System.out.println(r1.dateDebut.format(dateFormat.getFormatMoisJourAnneeHeureMinute())+" "+r1.dateFin.format(dateFormat.getFormatMoisJourAnneeHeureMinute()));
        System.out.println(r1.dureeDeSéjour());

    }
}
