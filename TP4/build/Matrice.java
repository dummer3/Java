import java.util.*;

public class Matrice{
    private int[] mat;
    private int n,m;
    private boolean estTriangulaire = false;

    public Matrice(int[] mat,int n,int m)
    {
        this.mat = mat;
        this.n = n;
        this.m = m;
    }

    public int[] getMat()
    {
        return mat.clone();
    }
       public int getM()
    {
        return m;
    }
       public int getN()
    {
        return n;
    }

    public int getElement(int index)
    {
        return 0;
    }
    
    public Matrice ajouter(Matrice m2)
    {
        if(this.n != m2.getN() || this.m != m2.getM())
            {
                System.out.println("IMPOSSIBLE D'ADDITIONNER 2 MATRICES DE TAILLE DIFFERENTES");
                return this;
            }
        for (int i = 0; i < n;i++)
            {
                for (int j = 0; j < m;j++)
                    {
                        mat[i*n+m] += m2.getMat()[i*n+m];
                    }
            }
        return this;
    }    
}
