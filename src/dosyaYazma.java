
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class dosyaYazma {

    
    String name;
    ArrayList<kare> SiraliListe;
    
    static boolean besYazdim=false;
    static boolean onYazdim=false;
    
    
    public synchronized void dosyaYazmaIslemi(ArrayList<kare> SiraliListe, String name ) {
    System.out.println("dosya islemine girdiiiii");
    File file = new File(name+".txt");
    try(BufferedWriter br = new BufferedWriter(new FileWriter(file))){
        
       for(int i =0; i<SiraliListe.size(); i++){
           double d = SiraliListe.get(i).bulunduguMs;
           String ms = String.format("%.4f",d);
           String s = String.valueOf(i+1)+". kare  "+ SiraliListe.get(i).bulanTheadNo +" nolu thread tarafından "+ ms + " ms de bulundu kordinatları = "+ SiraliListe.get(i).kordX
               +" " +SiraliListe.get(i).kordY  + "  DEGERİ = "+SiraliListe.get(i).deger; 
           br.write(s);
           br.newLine();
           
           
       }
                
 
    
    
} catch (IOException e) {
    System.out.println("Unable to read file " +file.toString());
} 
    
    
    
    
    }

    public dosyaYazma( ArrayList<kare> SiraliListe,String name) {
        this.name = name;
        this.SiraliListe = SiraliListe;
        dosyaYazmaIslemi(SiraliListe,name);
        if(name=="5" && besYazdim==false){besYazdim=true;dosyaYazmaIslemi(SiraliListe,name) ;}
        if(name=="10" && onYazdim==false){onYazdim=true;dosyaYazmaIslemi(SiraliListe,name) ;}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
