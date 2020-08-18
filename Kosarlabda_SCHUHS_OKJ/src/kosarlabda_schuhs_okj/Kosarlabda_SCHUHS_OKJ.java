/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kosarlabda_schuhs_okj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Soma
 */
public class Kosarlabda_SCHUHS_OKJ 
{
    static ArrayList <KosarAdatok> KosarList=new ArrayList<>();
    static ArrayList<String> Helyszinek=new ArrayList<>();
    static Map<String, Integer> Statisztika= new HashMap<String, Integer>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Feladat2();System.out.println("\n--------------------------------\n");
        Feladat3();System.out.println("\n--------------------------------\n");
        Feladat4();System.out.println("\n--------------------------------\n");
        Feladat5();System.out.println("\n--------------------------------\n");
        Feladat6();System.out.println("\n--------------------------------\n");
        Feladat7();System.out.println("\n--------------------------------\n");
        
    }

    private static void Feladat2() 
    {
        System.out.println("Feladat2: Adatok beolvasása");
        int db=0;
        try
        {
            System.setProperty("file.encoding", "UTF8");
            FileReader fajl=new FileReader("eredmenyek.csv");
            try(BufferedReader br=new BufferedReader(fajl))
            {
                int i=0;
                String sor=null;
                while((sor=br.readLine())!=null)
                {
                    String []dbok=sor.split(";");
                    String Hazai=dbok[0];
                    String Idegen=dbok[1];
                    int HazaiPont=Integer.parseInt(dbok[2]);
                    int IdegenPont=Integer.parseInt(dbok[3]);
                    String Helyszin=dbok[4];
                    String Idopont=dbok[5];
                    KosarAdatok KA=new KosarAdatok(Hazai, Idegen, HazaiPont, IdegenPont, Helyszin, Idopont);
                    KosarList.add(KA);
                    db++;
                }
            }
            if(0<db)
            {
                System.out.println("\tSikeres beolvasás, beolvasott sorok száma: "+db);
            }
        }
        catch (IOException | NumberFormatException e) 
        {
            System.out.println("Hiba: "+e);
        }
    }

    private static void Feladat3()
    {
        System.out.println("Feladat3: Real Madrid mérkőzéseinek száma");
        int Hazai=0;
        int dbRMIdegen=0;        
        for (int i = 0; i < KosarList.size(); i++) 
        {   
            if(KosarList.get(i).Hazai.contains("Real Madrid"))
            {
              Hazai++;
            }
           if(KosarList.get(i).Idegen.contains("Real Madrid"))
           {
               dbRMIdegen++;
           }
        }
        System.out.println("\tA Real Madrid hazai játékainak száma: "+Hazai+"\n\tA Real Madrid idegen játékainak száma: "+dbRMIdegen);
    }

    private static void Feladat4()    
    {
        System.out.println("Feladat4: Volt-e döntetlen mérközés?");
        int db=0;
        for (int i = 0; i < KosarList.size(); i++)
        {
            if(KosarList.get(i).HazaiPont==KosarList.get(i).IdegenPont)
            {
                db++;
            }
        }
        if(db>0)
        {
            System.out.println("\tVolt döntetlen mérkőzés");
        }
        else
        {
            System.out.println("\tNem volt döntetlen mérkőzés");
        }
    }

    private static void Feladat5()
    {
        System.out.println("Feladat5: Mi a barcelonai csapat pontos neve");
        String CsapatNeve=" ";
        for (int i = 0; i < KosarList.size(); i++)
        {
            if(KosarList.get(i).Hazai.toLowerCase().contains("barcelona"))
            {
                CsapatNeve=KosarList.get(i).Hazai;
            }
        }
        System.out.println("\tA barcelonai csapat teljes neve: "+CsapatNeve);
    }

    private static void Feladat6()
    {
        System.out.println("Feladat6: Mely csapatok játszottak 2004-11-21-én");
        for (KosarAdatok kosarAdatok : KosarList)
        {
            if(kosarAdatok.Idopont.contains("2004-11-21"))
            {
                System.out.println("\t"+kosarAdatok.Hazai+" - "+kosarAdatok.Idegen+" -> "+kosarAdatok.HazaiPont+ " : "+kosarAdatok.IdegenPont);
            }
        }
    }

    private static void Feladat7() 
    {
        System.out.println("Feladat7: melyek azok a stadionok, amelyek 20-nál több alkalommal voltak kosárlabdamérkőzések helyszíne");
        for (KosarAdatok kosarAdatok : KosarList)
        {
          if(!Helyszinek.contains(kosarAdatok.Helyszin))
          {
              Helyszinek.add(kosarAdatok.Helyszin);
          }
        }
        for (int i = 0; i < Helyszinek.size(); i++)
        {
           int db=0;
           for (int j = 0; j < KosarList.size(); j++)
            {
                if(Helyszinek.get(i).contains(KosarList.get(j).Helyszin))
                {
                    db++;
                }                
            }
            Statisztika.put(Helyszinek.get(i),db);
        }
        for (Map.Entry<String, Integer> e : Statisztika.entrySet())
        {
           String key = e.getKey();
           Integer value = e.getValue();
           if(20<=e.getValue())
           {
              System.out.println("\t"+e.getKey()+" : "+e.getValue()); 
           }
           
        }
        
    }
    
}
