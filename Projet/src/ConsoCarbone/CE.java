package ConsoCarbone;

/**
 * CE est une Enumeration avec 7 instances nommées {A, B, C, D, E, F, G} représentant les différentes classes énergétiques possibles d’un logement.
 * @author Yannis & Mounirou
 *
 */
public enum CE{
    A("A",0.005),B("B",0.01),C("C",0.02),D("D",0.035),E("E",0.055),F("F",0.08),G("G",0.1);
    private String ce;
    private double alpha;
    private CE(String c, double a){
        this.ce = c;
        this.alpha = a;
    }

    /**
     * Méthode permettant l'accès en lecture à l'attribut alpha.
     * @return La valeur de l'attribut alpha associé à la classe énergetique de l'instance courante.
     * @author Yannis & Mounirou
     */
    
    public double getAlpha(){
        return this.alpha;
    }
    
    /**
     * Méthode permettant l'accès en lecture à l'attribut ce représentant la classe énergetique de l'instance courante.
     * @return La classe énergetique de l'instance courante.
     * @author Yannis & Mounirou
     */
    
    public String getCe(){
        return this.ce;
    }
}