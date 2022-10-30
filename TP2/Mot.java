public class Mot
{
    private String m;

    public Mot(String s)
    {
        this.m = s;
    }

    public String toString()
    {
        return String.format("|| MOT :: %s ||",m);
    }

    public String getM()
    {
        return m;
    }

    private void setM(String s)
    {
        this.m = s;
    }
    
    public void afficheVoyelles()
    {
        String retour = "";
        for (char c : m.toCharArray())
            {
                if(c == 'a' || c == 'e' || c == 'y' || c == 'u' || c == 'i' || c == 'o')
                    {
                        retour += c;
                    }
            }
        System.out.println(retour);
        
    }

    public boolean estPalindrome()
    {
        for (int i = 0; i < m.length(); i++)
            {
                if (m.charAt(i) != m.charAt(m.length()-i-1))
                    {
                        return false;
                    }
            }
        return true;
    }

    public boolean estContenu (Mot m1)
    {
        int i = m.indexOf(m1.getM());
        if (i == -1)
            {
                return false;
            }
        else
            {
                return true;
            }
    }

    public void trie ()
    {
        String result = m;
        for(int i = 0; i < m.length()-1;i++)
            {
                int indiceCharPlusPetit = i;
                
                for(int j = i+1; j < m.length();j++)
                    {
                        if (m.charAt(indiceCharPlusPetit) > m.charAt(j))
                            {
                                indiceCharPlusPetit = j;
                            }
                    }
                String tempo = m.substring(i+1).replaceFirst(String.valueOf(m.charAt(indiceCharPlusPetit)),String.valueOf(m.charAt(i)));
                result = m.substring(0,i) + m.charAt(indiceCharPlusPetit) + tempo ;
                this.setM(result);
            }

        System.out.println(this.toString());
    }
}
