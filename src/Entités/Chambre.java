package Entités;

import Enum.TypeDeChambre;

public class Chambre {
    static int count;
    int numero;
    public Enum TypedeChambre;

    public  boolean estDisponible;


    public Enum getTypedeChambre() {
        return TypedeChambre;
    }

    public void setTypedeChambre(Enum typedeChambre) {
        TypedeChambre = typedeChambre;
    }

    public boolean isEstDisponible() {
        return estDisponible;
    }

    public void setEstDisponible(boolean estDisponible) {
        this.estDisponible = estDisponible;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


/*
    public double getPrixParUnité() {
        return prixParUnité;
    }


    public void setPrixParUnité(double prixParUnité) {
        this.prixParUnité = prixParUnité;
    }
    */

    public Chambre() {
    }

    public Chambre(Enum TypeDeChambre, boolean estDisponible ) {

        this.numero = ++count;
        this.TypedeChambre = TypeDeChambre;
        this.estDisponible = estDisponible;


    }
/*
private  double calculerPrixDeChambre(){
        if (this.TypedeChambre.equals(TypeDeChambre.SIMPLE)) {
           prixDeChambre=prixDeChambre;
        } else if (this.TypedeChambre.equals(TypeDeChambre.Double)) {
            prixDeChambre+=prixDeChambre*0.75;
        } else if (this.TypedeChambre.equals(TypeDeChambre.Triple)) {
           prixDeChambre+=prixDeChambre*0.5;
        } else {
            System.out.println("erreur");
        }

return prixDeChambre;


    }
*/


    @Override
    public String toString() {
        return "Chambre{" +
                "numero=" + numero +
                ", TypedeChambre=" + TypedeChambre +
                ", estDisponible=" + estDisponible +

                '}';
    }
}
