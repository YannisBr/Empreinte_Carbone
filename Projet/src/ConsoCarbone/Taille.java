package ConsoCarbone;

/**
 * Taille est une énumeration avec deux instances P et G correspondant à “petite voiture” et ”grosse voiture”. 
 * La production d’une petite voiture émet 4.2tCO2eq et celle d’une grosse voiture 19tCO2eq.
 * @author Yannis & Mounirou
 *
 */
public enum Taille {
    P("petite voiture", 4.2),G("grande voiture", 19);

    private String taille;
    private double ges;

    private Taille(String t, double g){
        this.taille = t;
        this.ges = g;
    }

    public String getTaille(){
        return this.taille;
    }
    public double getGes(){
        return this.ges;
    }
}
