class Exo2{
    public static void main(String[] args)
    {

	Personne bruno = new Personne("bruno","cliquot",new Date(27,2,1969));
	Personne sophie = new Personne("theo","cliquot",new Date(14,9,1969));
	Personne moi = new Personne("theo","cliquot",new Date(14,10,2001),bruno,sophie);
	Personne fanny = new Personne("theo","cliquot",new Date(19,12,1997),bruno,sophie);
	System.out.println(moi.getDateDeNaissance().toString());
	bruno.seMarieA(sophie,new Date(17,9,1989));
	System.out.println(bruno.estMarie());
	System.out.println(moi.estFrereOuSoeur(fanny));
    }




    
}
