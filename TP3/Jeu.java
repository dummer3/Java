public class Jeu
{
    private Joueur joueur1 = new Humain("joueur");
    private Joueur joueur2 = new Ordinateur("ORDI");
    private Paquet paquetDuJeu = new Paquet();

    
    private Joueur jouerCoup()
    {
        Carte c1 = joueur1.jouer();
        Carte c2 = joueur2.jouer();

        System.out.printf("\nLe joueur 1 à posé le %s\n",c1.toString());
        System.out.printf("Le joueur 2 à posé le %s\n",c2.toString());
        
        if(c1.compare(c2) == 1)
            {
                joueur1.recupererCarte(c2);
                joueur2.perdreCarte(c2);
                return joueur1;
            }
        joueur2.recupererCarte(c1);
        joueur1.perdreCarte(c1);
        return joueur2;
    }

    private void creerNouveauPaquet()
    {
        for (int i = 1; i <= 13;i++)
            {
                paquetDuJeu.ajouterCarte(new Carte(i,Carte.Couleur.PIQUE));
                paquetDuJeu.ajouterCarte(new Carte(i,Carte.Couleur.COEUR));
                paquetDuJeu.ajouterCarte(new Carte(i,Carte.Couleur.CARREAU));
                paquetDuJeu.ajouterCarte(new Carte(i,Carte.Couleur.TREFLE));
            }
    }

    private void distribuerPaquet()
    {
        paquetDuJeu.melanger();
        for (int i = 0; i < paquetDuJeu.getNombresCartes();i++)
            {
                joueur1.recupererCarte(paquetDuJeu.getCarte(i));
                i++;
                joueur2.recupererCarte(paquetDuJeu.getCarte(i));
            }
    }

    private void jouerPartie()
    {
        this.creerNouveauPaquet();
        this.distribuerPaquet();

        String joueurAyantGagneLeRound = "nobody";
        
        while (!joueur1.aPerdu() && !joueur2.aPerdu())
            {
                joueurAyantGagneLeRound = jouerCoup().toString();
                System.out.printf("\nLe gagnant de ce round est le %s\n\n",joueurAyantGagneLeRound);
            }
        System.out.printf("\n\nLe vainqueur est le %s\n\n",joueurAyantGagneLeRound);
    }

    public static void main (String[] args)
    {
        Jeu jeu = new Jeu();
        jeu.jouerPartie();
    }
}
