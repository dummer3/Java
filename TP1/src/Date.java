class Date
{
    private int jour;
    private int mois;
    private int annee;
    private int total;

    public Date (int j,int m,int a)
    {
	if (j > 0 && j < 32)
	    {
		this.jour = j;
	    }
	else
	    {
		throw new IllegalArgumentException("ERROR JOUR INCORRECT");
	    }
	if (m > 0 && m < 13)
	    {
		this.mois = m;
	    }
		else
	    {
		throw new IllegalArgumentException("ERROR MOIS INCORRECT");
	    }
	if (a >= 0)
	    {
		this.annee = a;
	    }
		else
	    {
		throw new IllegalArgumentException("ERROR ANNEE INCORRECT");
	    }
	total = jour+mois*31+annee*12*31;
	
    }

    public String toString()
    {
	return String.format("%s/%s/%s",jour,mois,annee);
    }

    public int CompareTo(Date d)
    {
	if (this.total > d.total)
	    {
		return 1;
	    }
	else if (this.total < d.total)
	    {
		return -1;
	    }
	else
	    {
		return 0;
	    }
    }
}
