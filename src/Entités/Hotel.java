package Entités;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import Enum.TypeDeChambre;

public class Hotel {
    static  int count;
    int id;
    String nom;

    public void setListeDeRéservation(ArrayList<Réservation> listeDeRéservation) {
        this.listeDeRéservation = listeDeRéservation;
    }

    String Adresse;
    LocalDateTime dernierMiseAJour;
    ArrayList<Double> avisDesUtilisateurs;
    ArrayList<Chambre> listeDeChambres;

    public void setListeDeChambres(ArrayList<Chambre> listeDeChambres) {
        this.listeDeChambres = listeDeChambres;
    }

    public void setListeDeClients(ArrayList<Client> listeDeClients) {
        this.listeDeClients = listeDeClients;
    }

    ArrayList<Client> listeDeClients;
    ArrayList<Réservation> listeDeRéservation;
    private int nombreDeNotes;
    //public  double AverageNote;
    public double AverageNote;


    public LocalDateTime getDernierMiseAJour() {
        return dernierMiseAJour;
    }

    public void setDernierMiseAJour(LocalDateTime dernierMiseAJour) {
        this.dernierMiseAJour = dernierMiseAJour;
    }


    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getAverageNote() {
        return AverageNote;
    }

    public Hotel(String nom, String adresse) {
        this.id = ++count;
        this.nom = nom;
        Adresse = adresse;
        this.listeDeChambres=new ArrayList<>();
        this.listeDeClients=new ArrayList<>();
        this.listeDeRéservation=new ArrayList<>();
        this.avisDesUtilisateurs=new ArrayList<>();
        this.dernierMiseAJour=LocalDateTime.now();



    }
    /*
     public  void ajouterChambre(){



         Chambre c1=new Chambre(TypeDeChambre.SIMPLE,true);
         Chambre c2=new Chambre(TypeDeChambre.Double,true);
         Chambre c3=new Chambre(TypeDeChambre.Triple,true);
         Chambre c4=new Chambre(TypeDeChambre.Triple,true);

       listeDeChambres.add(c1);
       listeDeChambres.add(c2);
         listeDeChambres.add(c3);
         listeDeChambres.add(c4);








     }
     */
     public boolean verifClient(String nom){

        for(Client c:listeDeClients){
            if(c.getNom().equals(nom))
                return true;


        }
       return  false;


     }

    public void ajouterCLient(Client c ){
       /* boolean quitter=false;
String nom=" ",email= " ",réponse=" ";

        Scanner sc=new Scanner(System.in);
        while (quitter==false) {

            System.out.println("donner le nom de client");
               nom = sc.nextLine();
            System.out.println("donner l'email de client ");
               email = sc.nextLine();
            listeDeClients.add(new Client(nom,email));
            System.out.println("Vous vouler ajouter des aitres clients Yes,No");
               réponse=sc.nextLine();
            if(réponse.equals("No")) {

              quitter=true;
            }
            else
                continue;




        }*/









listeDeClients.add(c);
    }
public  Client getClientByName(String nom){
    for(Client c:listeDeClients){
        if(c.getNom().equals(nom))
            return c;


    }

        return  null;


}
    /*public void ajouterReservation(String nom ,Réservation r1  ){

       if (verifClient(nom)) {
           r1.client = this.getClientByName(nom);
          if( verifdispo(r1)) {

              listeDeRéservation.add(r1);
              getClientByName(nom).ajouterReservation(r1); //TODO Cannot resolve method 'ajouterReservation' in 'Client'
          }


          }else
           System.out.println("client n'existe pas dans notre BD");


        }





*/




     public void supprimerClientByid (int id ){
        int etat=0;

     for(Client c:listeDeClients ){
         if(c.id==id) {
             listeDeClients.remove(id-1);
             System.out.println("client supprimer avec suucés");
             etat=1;
             break;
         }


     }
       if(etat==0){

           System.out.println("client n'existe pas " +

                   " ");
       }

    }
    public  Chambre choixChambreAléatoirement( ){
        Random random = new Random();

        int nombre =random.nextInt(listeDeChambres.size()-1);
        return listeDeChambres.get(nombre);







    }
public boolean verifdispo(Réservation r1){
    DateTimeFormatter f=DateTimeFormatter.ofPattern("dd MMMM,yyyy,hh:mm");
        for(Réservation r:listeDeRéservation) {

            if(r.chambre.getNumero()==r1.chambre.getNumero()&&r.dateDebut==r1.dateDebut&&r1.dateFin==r1.dateFin)
                System.out.println("Chambre non disponible dans cette période  "+r1.dateDebut.format(f)+" "+r1.dateFin.format(f)+"  pour "+r1.client.getNom());
            return  false;


        }
        return  true;

}

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }


    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public ArrayList<Chambre> getListeDeChambres() {
        return listeDeChambres;
    }

    public ArrayList<Client> getListeDeClients() {

        return listeDeClients;
    }

    public ArrayList<Réservation> getListeDeRéservation() {
        return listeDeRéservation;
    }

    public ArrayList<Double> getAvisDesUtilisateurs() {
        return avisDesUtilisateurs;
    }

    public void setAvisDesUtilisateurs(ArrayList<Double> avisDesUtilisateurs) {
        this.avisDesUtilisateurs = avisDesUtilisateurs;
    }
  /*  public double  calculerAvis(){
      return AverageNote= avisDesUtilisateurs.stream().mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0); // Si la liste est vide, retourner 0.0




    }
*/
    public  void AjouterNote(double note){

        avisDesUtilisateurs.add(note);

        // Mise à jour incrémentale de la moyenne
        AverageNote = ((AverageNote * nombreDeNotes) + note) / (nombreDeNotes + 1);
        nombreDeNotes++;



    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", Adresse='" + Adresse + '\'' +
                ", avisDesUtilisateurs=" + avisDesUtilisateurs +
                "Average=    "+AverageNote+
                ", listeDeChambres=" + listeDeChambres +
                ", listeDeClients=" + listeDeClients +
                ", listeDeRéservation=" + listeDeRéservation +
                '}';
    }

    public static void main(String[] args) {




    }


}
