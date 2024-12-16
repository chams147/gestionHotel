package Entités;

public class Client {
    static  int count;
    int id;
    String nom;
    String Email;

    public boolean isExist() {
        return isExist;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }


    boolean isExist =true;

    public int getId() {
        return id;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return Email;
    }





    public Client(String nom, String email) {
        this.id=++count;
        this.nom = nom;
        Email = email;


    }


    @Override
    public String toString() {
        return "Client{" +
                "id="+id+ '\''+
                "nom='" + nom + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }

    public static void main(String[] args) {

    }
}
