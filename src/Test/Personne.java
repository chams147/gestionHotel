package Test;

public class Personne {
    Profil profil;

    public Personne(Profil profil) {
        this.profil = profil;
    }


    public static void main(String[] args) {


        Personne p1=new Personne(new Profil());
        System.out.println(p1.profil);
    }
}



