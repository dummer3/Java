class Personne{
    private String prenom;
    private String nom;
    private Date dateDeNaissance;
    private Date dateDeMariage;
    private Personne pere;
    private Personne mere;

    public Personne(String n,String p,Date d)
    {
	this.nom = n;
	this.prenom = p;
	this.dateDeNaissance = d;
    }

    public Personne(String n,String p,Date d,Personne pa,Personne m)
    {
	this(n,p,d);
	this.mere = m;
	this.pere = pa;
    }

    public void setNom(String n)
    {
	this.nom = n;
    }
    public void setDateM(Date d)
    {
	this.dateDeMariage = d;
    }

    public Date getDateDeNaissance()
    {
	return this.dateDeNaissance;
    }

    public void seMarieA(Personne p,Date d)
    {
	if(d.CompareTo(this.getDateDeNaissance()) == 1 && d.CompareTo(p.getDateDeNaissance()) == 1)
	    {
		this.setDateM(d);
		p.setDateM(d);
	    }
	else
	    {
		throw new IllegalArgumentException("ERROR DATE INCORRECT");
	    }
    }

    public int estMarie()
    {
	if( dateDeMariage != null)
	    {
		return 1;
	    }
	else
	    {
		return 0;
	    }
    }

    public Personne getPere()
    {
	return this.pere;
    }
    public int estFrereOuSoeur(Personne p)
    {
	if (p.getPere() == this.getPere())
	    {
		return 1;
	    }
	else
	    {
		return 0;
	    }
    }
	
}

