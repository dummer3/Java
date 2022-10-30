// Question 1 : list.add([1,2,3]) et list.get ...

public class Listes<A>
{
    private A[] l;
    private int size;

    public Listes(int taille)
    {
        this.l = (A[]) (new Object[taille]);
        size = 0;
    }

    public boolean add(A val)
    {
        l[size] = val;
        size++;
        return true;
    }

    public int size()
    {
        return size;
    }

    public boolean remove(int index)
    {
        if(index < 0)
            {
                throw new IllegalArgumentException("ERREUR INDEX NEGATIFS");
            }
        if(index > size)
            {
                throw new IllegalArgumentException("ERREUR INDEX HORS DE LA LISTE");         
            }
        
        A obj = l[index];
        for (int i = index+1; i <size;i++)
            {
                l[i-1] = l[i];
            }
        
        size--;
        
        return true;
    }

    public boolean contains(A val)
    {
        for (int i = 0; i< size;i++)
            {
                if(l[i] == val)
                    {
                        return true;
                    }
            }
        return false;
    }

    public void reverse()
    {
        for (int i = 0; i < size/2;i++)
            {
                l[i] = l[size-i];
            }
    }

    
} 
