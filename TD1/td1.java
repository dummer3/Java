class td1
{
    public static class Instant{
        private int heures;
        private int minutes;
        private int secondes;
        private int total;

        public Instant (int h,int m,int s)
        {
            if (h >= 0 && h < 25)
                {
                    this.heures = h;
                }
            else
                {
                    throw new IllegalArgumentException("ERROR JOUR INCORRECT");
                }
            if (m >= 0 && m < 61)
                {
                    this.minutes = m;
                }
            else
                {
                    throw new IllegalArgumentException("ERROR MOIS INCORRECT");
                }
            if (s >= 0 && s<=60)
                {
                    this.secondes = s;
                }
            else
                {
                    throw new IllegalArgumentException("ERROR ANNEE INCORRECT");
                }
            this.total =  h*3600+m*60+s;
        }
        public Instant (int t)
        {
            if (t <= 24*3600+59*60+59)
                {
                    this.total = t;
                    this.heures = t/3600;
                    this.minutes = (t%3600)/60;
                    this .secondes = t%60;
                }
             else
                {
                    throw new IllegalArgumentException("ERROR DATE INCORRECT");
                }
        }

        public String toString ()
        {
            return String.format("----------\n|%d/%2d/%2d|\n----------",heures,minutes,secondes);
        }
	
        public int valeurEnSecondes()
        {
            return total;
        }

        public int compareTo(Instant t)
        {
            if(t == null)
                {
                    throw new IllegalArgumentException("ERROR INSTANT NULL");
                }
            if (this.equals(t) == 0)
                {
                    return 0;
                }
            else if (this.valeurEnSecondes() < t.valeurEnSecondes())
                {
                    return -1;
                }
            else
                {
                    return 1;
                }
           
        }
        public int equals(Instant t)
        {
               if(t == null)
                {
                    throw new IllegalArgumentException("ERROR INSTANT NULL");
                }
            if (this.valeurEnSecondes() == t.valeurEnSecondes())
                {
                    return 0;
                }
            else
                {
                    return 1;
                }
        }
    }

    
    public static void main(String[] args){
        Instant[] tab = new Instant[3];
        tab[0] = new Instant(23,59,59);
        tab[1] = new Instant(8,30,15);
        tab[2] = new Instant(10,10,10);

	for(int i = 0; i < 3;i++)
	    {
		for(int j = i+1; j<3;j++)
		    {
			System.out.printf("\n Il y a %s entre\n",minus(tab[i],tab[j]).toString());
                        System.out.println(tab[i].toString());
			System.out.println("\n");
                        System.out.println(tab[j].toString());
	
			System.out.printf("\n On obtient %d avec\n",tab[i].compareTo(tab[j]));
                        System.out.println(tab[i].toString());
			System.out.println("\n");
                        System.out.println(tab[j].toString());
		    }
	    }
	System.out.println("\n");

	
	System.out.printf("Le plus petit instant dans tab qui est supérieur à 9 h est :\n");
        System.out.printf(question6(tab,3,new Instant(9,0,0)).toString());

	for(int i = 0; i < 3;i++)
	    {
		System.out.printf("\n A la case %d, on a l'instant :\n",i);
		System.out.println(tab[i].toString());
	    }

	System.out.println("Après trie:\n");
	Instant[] nTab = question7(tab,3);
	
        for(int i = 0; i < 3;i++)
	    {
		System.out.printf("\n A la case %d, on a l'instant :\n",i);
		System.out.println(nTab[i].toString());
	    }


	
	
    }
    
 

    static Instant minus(Instant t1, Instant t2)
    {
	return new Instant(Math.abs(t1.valeurEnSecondes()-t2.valeurEnSecondes()));
    }

    static Instant question6 (Instant[] tab,int taille,Instant t)
    {
	Instant resultat = tab[0];
	for (int i = 1; i < taille;i++)
	    {
		if (tab[i].compareTo(t) == 1 && resultat.compareTo(tab[i]) ==1)
		    {
			resultat = tab[i];
		    }
	    }
	return resultat;
    }
    
    static Instant[] question7 (Instant[] tab,int taille)
    {
        Instant[] nTab = new Instant[taille];
	Instant plusPetit = new Instant(0,0,0);
	for (int i = 0; i < taille;i++)
	    {
		nTab[i] = question6(tab,taille,plusPetit);
		plusPetit = nTab[i];
	    }
        return nTab;
    }

}
