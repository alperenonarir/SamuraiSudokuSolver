

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class SudokuCozucu extends JPanel{
  
    
    static final int col=21;
    static final int row=21;
        
    final static int x=50,y=50,side=30;
    
    
    
    public static kare[][] board = new kare[21][21];
    public static int[][] ilkboard = new int[21][21];
    public static ArrayList<kare> SiraliListe = new ArrayList<kare>();
    public static ArrayList<kare> SiraliListeBes = new ArrayList<kare>();
    public static ArrayList<kare> SiraliListeOn = new ArrayList<kare>();
  
   //ideal deneme sınırı 500000
    static int besMiOnMu;
    static int vv=0; // duraklatma ms si ekranı yavaslatır  0 yaparsan en hızlı 
    static long  denemeSayisi=0;static int denemeSiniri=1500000;static int derinlik=6;static int derinlikArtım=2; static int derinlikSinir=10;
    
    static boolean tabloYazdirildiMi=false; static boolean atildiMi=false;
    static boolean aktifThreadMatrisi[]= {false,false,false,false,false};
    static long startTime = System.nanoTime(); 
   
    public SudokuCozucu() { }
  
    

    
    
    @Override
    public void paint(Graphics g){
      
           super.paint(g);
           
           g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
           
           
           
  // değerleri yazdırma
            for (int satirNo = 0; satirNo < 21; satirNo++) {
                 for (int kolonNo = 0; kolonNo < 21; kolonNo++) {
        
                     
                     if(ilkboard[satirNo][kolonNo]==0){g.setColor(Color.red);}
                     else{g.setColor(Color.DARK_GRAY);}
                   g.drawString(String.valueOf(board[satirNo][kolonNo].deger),y+(side*kolonNo)+19 ,x+(side*satirNo)+19 );
                   
                  
                 }
            }
            
           
            
        // satır kolon cizme ve renklendirme
            for(int i=0;i<row+1;i++){
                
                if(i%3==0){g.setColor(Color.black);}
                else{g.setColor(Color.LIGHT_GRAY);}
                g.drawLine(x,y+i*side,x+col*side,y+i*side);
            }
            
            
            for(int j=0;j<col+1;j++){
                if(j%3==0){g.setColor(Color.black);}
                else{g.setColor(Color.LIGHT_GRAY);}
                g.drawLine(x+j*side,y,x+j*side,y+row*side);}
            
            
            
            
            
            
            
            // boslukları beyaz yapma
            
            for(int t=0;t<6;t++)
            {for(int s=9;s<12;s++){
                    g.setColor(Color.lightGray);
                    
                    g.fillRect(x+1+s*side, y+t*side, side-1, side); //ust kisim
                    g.fillRect(x+1+s*side, y+2+(t+15)*side, side-1, side); //alt kisim
                    
                    
                }}
            
            
            for(int t=9;t<12;t++)
            {
                for(int s=0;s<6;s++){
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillRect(x+s*side, y+1+t*side, side, side-1); //sol kisim
                    g.fillRect(x+1+(s+15)*side, y+1+t*side, side, side-1); //sag kisim
                }
                
            }
             
    }
    
    
  
    public static  void startTimeGuncelle() {startTime = System.nanoTime();}
    
  public static int bittiMi(){
      int sayac=0;
      
       for(int i=0;i<5;i++){
          if(aktifThreadMatrisi[i]==false) {sayac++; }}
       
      return sayac;
  }
    
  public static synchronized void printBoard2() {for(int i=0;i<5;i++){ System.out.println( aktifThreadMatrisi[i]+" ");}}
  
  
  //
    public  synchronized void printBoard3(int threadNo) {
        int sayac=0;
      for (int row = 0; row < 21; row++) {
           for (int column = 0; column < 21; column++) {
          if(board[row][column].deger!=0 ){sayac++;  }
       
                                                       }
                                        }
      
      for(int i=0; i<= threadNo*5000; i++){
          
          int a=100; 
          int b= a*17;
          int c= b*99;
      }
      
      if(sayac==369 && tabloYazdirildiMi==false){
           tabloYazdirildiMi=true;
           SudokuCozucu.SiraliListe.clear();
           
           System.out.println("islem bitti bulunan kare "+sayac);
           
          
           
            for (int row = 0; row < 21; row++){for (int column = 0; column < 21; column++){
                if(board[row][column].boslukMu==false){
                   SiraliListe.add(board[row][column]); 
                }

        
        }}
            int n = SiraliListe.size();
           quickSort(SiraliListe, 0, n - 1);
           
           String s= String.valueOf(besMiOnMu) ;
           System.out.println(s);
           dosyaYazma d= new dosyaYazma(SiraliListe,s);
          
             
                  
            for (int i = 0; i<SiraliListe.size(); i++){
                
                
                    
       System.out.println(i+1 + ". kare  "+ SiraliListe.get(i).bulanTheadNo +" nolu thread tarafından " + SiraliListe.get(i).bulunduguMs + " ms de bulundu kordinatları = "+ SiraliListe.get(i).kordX
               +" " +SiraliListe.get(i).kordY  + "  DEGERİ = "+SiraliListe.get(i).deger );
       
       
               
       
        }
            
            if(besMiOnMu==5 && atildiMi==false){SiraliListeBes=SiraliListe;System.out.println(" "+ besMiOnMu);atildiMi=true;}
            else if(besMiOnMu==10){SiraliListeOn=SiraliListe;System.out.println(" "+ besMiOnMu);}
      
      }}
    


      
        
        // orn 16 satırda 13 2o kolonları arası bu degerden varmı
    //synchronized
  private static  boolean satirKontrol(int sorgulananDeger, int satirNo, int baslangicKolon, int bitisKolon) {
    for (int i = baslangicKolon; i < bitisKolon; i++) {
      if (board[satirNo][i].deger == sorgulananDeger) {return true;}}return false;
  }
  
//synchronized
  private static  boolean kolonKontrol(int sorgulananDeger, int kolonNo,int baslangicSatir, int bitisSatir ) {
    for (int i = baslangicSatir; i < bitisSatir; i++) {
      if (board[i][kolonNo].deger == sorgulananDeger) {return true;}}return false;
  }
  
  
 // bulundugu kutuda bu numara varsa true dondur
  private static boolean kutuKontrol( int sorgulananDeger, int satirNo, int kolonNo) {
    int kutuSatirBaslangic = satirNo - satirNo % 3;
    int kutuKolonBaslangic = kolonNo - kolonNo % 3;
    
    for (int i = kutuSatirBaslangic; i < kutuSatirBaslangic + 3; i++) {
      for (int j = kutuKolonBaslangic; j < kutuKolonBaslangic + 3; j++) {
        if (board[i][j].deger == sorgulananDeger) {return true;}}
    }
    return false;
  }
  

  
  
  
  // EGER KESİSİM NOKTASINDA İSE OZEL OLARAK CALISIR
    private static  boolean ortakKontrol(tablo tablo, int sorgulananDeger, int satirNo, int kolonNo) {
        
    int baslangicSatir;int bitisSatir;int baslangicKolon;int bitisKolon;
    
    if(board[satirNo][kolonNo].isOrtakMi()==true){
      
           if(tablo.tabloNo==3){
        


        //3. tablo da ise baglı oldugu 2. tablosunda satır kolon kontrolu yaptır  
        
              if(board[satirNo][kolonNo].bolge==0){ // ortak ve alt bölgede
                     if( kolonNo<10){baslangicSatir=12;bitisSatir=21;baslangicKolon=0;bitisKolon=9;} //4. tablo
                     else           {baslangicSatir=12;bitisSatir=21;baslangicKolon=12;bitisKolon=21;} // 5. tablo
                                                  }
              else { // ortak ve üst bölgede
                     if( kolonNo<10){baslangicSatir=0;bitisSatir=9;baslangicKolon=0;bitisKolon=9;} // 1.tablo
                      else          {baslangicSatir=0;bitisSatir=9;baslangicKolon=12;bitisKolon=21;} // 2.tablo
                                                        }
        
        
              
              if(satirKontrol(sorgulananDeger, satirNo,baslangicKolon,bitisKolon)==false && kolonKontrol( sorgulananDeger, kolonNo,baslangicSatir,bitisSatir)==false)
            {return false;}
            else {return true;}
  
       
        }
        else{
         //  3. tablo degil ise 3. tablo standartlarında satır kolon kontrolu yaptır   
          if(satirKontrol(sorgulananDeger, satirNo,6,15)==false && kolonKontrol( sorgulananDeger, kolonNo,6,15)==false)
            {return false;}
            else {return true;}
         
            
        }}else{return false; } 
    
      }
    
    
  
  
  
// uygunsa kontrollerden false döner 
  // synchronized
  private   boolean buDegeruygunMu(tablo tablo, int sorgulananDeger, int satirNo, int kolonNo) {
 
      if(satirKontrol(sorgulananDeger, satirNo,tablo.baslangicKolon,tablo.bitisKolon)==false &&
         kolonKontrol( sorgulananDeger, kolonNo,tablo.baslangicSatir,tablo.bitisSatir)==false &&
         kutuKontrol(sorgulananDeger, satirNo, kolonNo) ==false && 
         ortakKontrol(tablo,sorgulananDeger,satirNo,kolonNo) ==false     
              )
      {return true;}
      else{return false;}
 
  }

    
    
 
  
  
  
  //
  public   boolean tabloyuCoz(tablo tablo,int threadNo, int startX, int startY) {
   
     
   
   denemeSayisi++;
   if(denemeSayisi>denemeSiniri){denemeSayisi=0;tabloyuSifirla();}
      
      
   // BASLANGIC NOKTASINI OZEL OLARAK KONTROL ETMEK ICIN NOKTA ISARETSİZSE NORMAL DÖNGUDEN DEVAM EDIYOR. DAHA PRATİGİNI BULAMADIM
      
           if (board[startX][startY].deger == 0  ) {
         
   
            
          for (int sorgulananDeger = 1; sorgulananDeger <= 9; sorgulananDeger++) {
              
               
                     if (buDegeruygunMu(tablo ,sorgulananDeger, startX, startY)) {
                         
                         
                                board[startX][startY].deger = sorgulananDeger; // repaint yapılacak yer
                                board[startX][startY].isleniyorMu=true;
                                board[startX][startY].isaretliMi=true;
                                long endTime = System.nanoTime(); 
                                long estimatedTime = endTime - startTime; // Geçen süreyi nanosaniye cinsinden elde ediyoruz
                                double seconds = (double)estimatedTime/1000000000; // saniyeye çevirmek için milyar'a bölüyoruz.
                                board[startX][startY].bulunduguMs=seconds;
                                board[startX][startY].bulanTheadNo=threadNo;
                                
                     
  
 

                                 
                
                
                  if (tabloyuCoz(tablo,threadNo,startX,startY)) {return true;}
                  else {   board[startX][startY].deger = 0;
                           board[startX][startY].isleniyorMu=false;
                           board[startX][startY].isaretliMi=false;
                           board[startX][startY].bulunduguMs=-2;
                           board[startX][startY].bulanTheadNo=-2;
     
                
                }}
          
          }
          return false;
        }
      
            
           
   // 
      // ASIL FONKSİYON BURDA TABLODAN GELEN ARALIK DEGERLERİ İÇİNDE GEZER VE NUMARALARI TEK TEK DENER
    for (int satirNo = tablo.baslangicSatir; satirNo < tablo.bitisSatir; satirNo++) {
      for (int kolonNo = tablo.baslangicKolon; kolonNo < tablo.bitisKolon; kolonNo++) {
        if (board[satirNo][kolonNo].deger == 0  ) {

            
          for (int sorgulananDeger = 1; sorgulananDeger <= 9; sorgulananDeger++) {
              
               
                     if (buDegeruygunMu(tablo ,sorgulananDeger, satirNo, kolonNo)) {
                         
                         
                                board[satirNo][kolonNo].deger = sorgulananDeger; // repaint yapılacak yer
                                board[satirNo][kolonNo].isleniyorMu=false;
                                board[satirNo][kolonNo].isaretliMi=true;
                                long endTime = System.nanoTime(); 
                                long estimatedTime = endTime - startTime; // Geçen süreyi nanosaniye cinsinden elde ediyoruz
                                double seconds = (double)estimatedTime/1000000000; // saniyeye çevirmek için milyar'a bölüyoruz.
                                board[satirNo][kolonNo].bulunduguMs=seconds;
                                board[satirNo][kolonNo].bulanTheadNo=threadNo;

                                // islemi yavaslatıp 5 tredin aynı anda caşlıstıgını göstermek için assagıdaki kodu ac
                /*       try {
                             Thread.sleep(vv);
                         } catch (InterruptedException ex) {
                             Logger.getLogger(SudokuCozucu.class.getName()).log(Level.SEVERE, null, ex);
                         }
 */

                                 
                
                
                  if (tabloyuCoz(tablo,threadNo,startX,startY)) {return true;}
                  else {   board[satirNo][kolonNo].deger = 0;
                           board[satirNo][kolonNo].isleniyorMu=false;
                           board[satirNo][kolonNo].isaretliMi=false;
                           board[satirNo][kolonNo].bulunduguMs=-2;
                           board[satirNo][kolonNo].bulanTheadNo=-2;
                           
               
  
                }}
          
          }
          return false;
        }
      }
    }
    
    
    return true;
   
  }
  //
   public synchronized  void tabloyuSifirla() {
         
      System.out.println("TIKANDI silinen derinlik   "  + derinlik  ); 
                            
             
      
      
       SudokuCozucu s1 = new SudokuCozucu(); s1.setBoard(board);
        tablo t1 = new tablo(0,9,0,9,1); // tablo 1 sol ust tablosu
        tablo t2 = new tablo(0,9,12,21,2); // tablo 2 sag ust
        tablo t3 = new tablo(6,15,6,15,3); //  tablo3 orta tablo
        tablo t4 = new tablo(12,21,0,9,4); // tablo4 sol alt
        tablo t5 = new tablo(12,21,12,21,5);// tablo5 sag alt
   
    int i,j;
 
       if(derinlik>derinlikSinir){derinlik=6;}
       
       
       // satır silme
       
       for( i=0;i<derinlik;i++){for(j=0; j<21;j++){
           if(ilkboard[i][j]==0){board[i][j].deger = 0;}else{board[i][j].deger=ilkboard[i][j] ;}
           
           
                           board[i][j].isleniyorMu=false;
                           board[i][j].isaretliMi=false;
                          
       
       
       }}
       for( i=20;i>20-derinlik;i--){for(j=0; j<21;j++){
          if(ilkboard[i][j]==0){board[i][j].deger = 0;}else{board[i][j].deger=ilkboard[i][j] ;}
       
                           board[i][j].isleniyorMu=false;
                           board[i][j].isaretliMi=false;
                          
       
       
       
       
       }}
       
       
       
       
       
       //kolon silme
       
       for( i=0;i<derinlik;i++){for(j=0; j<21;j++){
           if(ilkboard[j][i]==0){board[j][i].deger = 0;}else{board[j][i].deger=ilkboard[j][i] ;}
       
                           board[j][i].isleniyorMu=false;
                           board[j][i].isaretliMi=false;
                           
                           
       
       }}
       for( i=20;i>20-derinlik;i--){for(j=0; j<21;j++){
          if(ilkboard[j][i]==0){board[j][i].deger = 0;}else{board[j][i].deger=ilkboard[j][i] ;}
       
       
                           board[j][i].isleniyorMu=false;
                           board[j][i].isaretliMi=false;
                          
                           
       
       
       
       }}
       
       derinlik=derinlik+derinlikArtım;
    
    if(besMiOnMu==5){
if(aktifThreadMatrisi[0]==false){threadd newThread1 = new threadd(t1,s1,1,t1.baslangicSatir,t1.baslangicKolon);newThread1.start();}
if(aktifThreadMatrisi[1]==false){threadd newThread2 = new threadd(t2,s1,2,t2.baslangicSatir,t2.baslangicKolon);newThread2.start();}
if(aktifThreadMatrisi[2]==false){threadd newThread3 = new threadd(t3,s1,3,t3.baslangicSatir,t3.baslangicKolon);newThread3.start();}
if(aktifThreadMatrisi[3]==false){threadd newThread4 = new threadd(t4,s1,4,t4.baslangicSatir,t4.baslangicKolon);newThread4.start();}
if(aktifThreadMatrisi[4]==false){threadd newThread5 = new threadd(t5,s1,5,t5.baslangicSatir,t5.baslangicKolon);newThread5.start();}
     
        
        
        
    }
    else if(besMiOnMu==10){
        
if(aktifThreadMatrisi[0]==false){
    threadd newThread11 = new threadd(t1,s1,11,t1.baslangicSatir,t1.baslangicKolon);newThread11.start();
    threadd newThread12 = new threadd(t1,s1,12,t1.baslangicSatir,t1.baslangicKolon);newThread12.start();}
if(aktifThreadMatrisi[1]==false){
    threadd newThread21 = new threadd(t2,s1,21,t2.baslangicSatir,t2.baslangicKolon);newThread21.start();
    threadd newThread22 = new threadd(t2,s1,22,t2.baslangicSatir,t2.baslangicKolon);newThread22.start();}
if(aktifThreadMatrisi[2]==false){
    threadd newThread31 = new threadd(t3,s1,31,t3.baslangicSatir,t3.baslangicKolon);newThread31.start();
    threadd newThread32 = new threadd(t3,s1,32,t3.baslangicSatir,t3.baslangicKolon);newThread32.start();}
if(aktifThreadMatrisi[3]==false){
    threadd newThread41 = new threadd(t4,s1,41,t4.baslangicSatir,t4.baslangicKolon);newThread41.start();
    threadd newThread42 = new threadd(t4,s1,42,t4.baslangicSatir,t4.baslangicKolon);newThread42.start();}
if(aktifThreadMatrisi[4]==false){
    threadd newThread51 = new threadd(t5,s1,51,t5.baslangicSatir,t5.baslangicKolon);newThread51.start();
    threadd newThread52 = new threadd(t5,s1,52,t5.baslangicSatir,t5.baslangicKolon);newThread52.start();}

   
        
        
        
        
        
    }
     
       
       
  
          
   
   }
   
   
   
    public  kare[][] getBoard() {return board;}
    public  void setBoard(kare[][] board) {SudokuCozucu.board = board; }
    
    
    static void swap(ArrayList<kare> arr, int i, int j){Collections.swap(arr, i, j);}
    
    static int partition(ArrayList<kare> arr, int low, int high){double pivot = arr.get(high).bulunduguMs; int i = (low - 1); for(int j = low; j <= high - 1; j++){if (arr.get(j).bulunduguMs < pivot) {i++;swap(arr, i, j);}}
    swap(arr, i + 1, high);return (i + 1);}
    
    static void quickSort(ArrayList<kare> arr, int low, int high){if (low < high){int pi = partition(arr, low, high);quickSort(arr, low, pi - 1);quickSort(arr, pi + 1, high);}}

  
  
   

    
}


