


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
//import java.util.logging.Level;
//import java.util.logging.Logger;

//import java.awt.*;
//import java.awt.Graphics;
import java.io.File;
import java.text.DecimalFormat;



import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JPanel;





public class main extends JPanel {
    
    
    
    static int zamanAraligiRek=25;  // 1. metot için timer ile grafik bulma 1  ms
    static double zamanAraligiNormal=0.025000; // kac ms de bir veri toqlayacagız, ister 3 için , x ekseni 0.025000;
    static int ekranYenilemeMs=1;
    
    static int toplamBulunanBesli=0; 
    static int toplamBulunanOnlu=0;
    
    static String[] okunanTxt2 = new String[21];
   static ArrayList<Integer> besliGrafikVerileri2 = new ArrayList<Integer>();
   static ArrayList<Integer> onluGrafikVerileri2 = new ArrayList<Integer>();
   public static ArrayList<kare> SiraliListeBes = new ArrayList<kare>();
   public static ArrayList<kare> SiraliListeOn = new ArrayList<kare>();
   
     public static void main(String[] args) throws FileNotFoundException {
      
         
         
         
         kare[][] board = new kare[21][21]; // sudoku karelerinin detaylı bilgisi için
         int[][] board2 = new int[21][21];
         SudokuCozucu s1 = new SudokuCozucu(); // sudoku cozucu objesi, bu obje ile tabloyu gonderecegiz          
         ArrayList<Integer> besliGrafikVerileri = new ArrayList<Integer>();
         // her x ms de bir buraya o andakı bulunan kareyı ekleyecegız
         ArrayList<Integer> onluGrafikVerileri = new ArrayList<Integer>();
      //   onluGrafikVerileri.add(0);besliGrafikVerileri.add(0);
         Scanner input2 = new Scanner(System.in); 
         
           // tablo kısmı soyle 5 tablomuz var samurai sudokuda, threadlere hangi tabloyu calısacaklarını dagıtıyoruz, tablo baslangıc bitis verileri burada
   tablo t1 = new tablo(0,9,0,9,1); // tablo 1 sol ust tablosu
   tablo t2 = new tablo(0,9,12,21,2); // tablo 2 sag ust
   tablo t3 = new tablo(6,15,6,15,3); //  tablo3 orta tablo
   tablo t4 = new tablo(12,21,0,9,4); // tablo4 sol alt
   tablo t5 = new tablo(12,21,12,21,5);// tablo5 sag alt
   
   
   
         
         
                // threadlere tabloları attık, cozucu objesi attık, thread numarası attık
 
                // TABLO - SUDOKU NESNESİ - THREAD NO - START X - START Y
            threadd th1 = new threadd(t1,s1,1,6,8); 
            threadd th2 = new threadd(t2,s1,2,7,12);
            threadd th3 = new threadd(t3,s1,3,8,6);
            threadd th4 = new threadd(t4,s1,4,12,6);
            threadd th5 = new threadd(t5,s1,5,13,12);
            
            threadd th6 = new threadd(t1,s1,11,6,6);
            threadd th7 = new threadd(t2,s1,21,7,12);
            threadd th8 = new threadd(t3,s1,31,8,6);
            threadd th9 = new threadd(t4,s1,42,12,6);
            threadd th10 = new threadd(t5,s1,51,13,12);
            
            threadd th11 = new threadd(t1,s1,12,7,7);
            threadd th12 = new threadd(t2,s1,22,6,13);
            threadd th13 = new threadd(t3,s1,32,7,10);
            threadd th14 = new threadd(t4,s1,42,12,8);
            threadd th15 = new threadd(t5,s1,52,12,14);
         
         
            
            
            
            
    
            
            
            
      /*
        
        
 int[][] board3 = {
            
            {0, 0, 0,  0, 0, 0,  0, 2, 0,     0, 0, 0,     0, 0, 9,  6, 0, 0,  0, 2, 0},//**57***2* **96***2*
            {4, 9, 0,  0, 6, 0,  0, 1, 0,     0, 0, 0,     1, 4, 0,  0, 5, 0,  0, 0, 0},//49**6**1* 14**5**3*
            {0, 0, 7,  0, 0, 0,  9, 0, 6,     0, 0, 0,     0, 0, 2,  0, 0, 1,  0, 0, 8},//**7**49*6 **2**17*8
            
            {0, 0, 6,  0, 0, 0,  0, 0, 8,     0, 0, 0,     0, 0, 0,  0, 0, 0,  0, 0, 0},//**6*****8 **3*****2
            {0, 7, 0,  0, 0, 0,  0, 9, 0,     0, 0, 0,     0, 0, 0,  0, 0, 0,  0, 6, 0},//*7*****9* *5*****6*
            {2, 0, 0,  0, 0, 0,  0, 0, 0,     0, 0, 0,     4, 0, 0,  0, 0, 0,  0, 0, 0},//2*****3** 4*****5**
            
            {5, 0, 8,  0, 0, 0,  7, 0, 0,     0, 0, 0,     6, 0, 5,  8, 0, 0,  0, 0, 0},//5*89**7** ***6*58**2**
            {0, 0, 0,  0, 0, 0,  0, 0, 5,     0, 0, 0,     0, 1, 0,  0, 0, 0,  0, 0, 6},//*1**3**85 ****1**7**86
            {0, 0, 0,  0, 0, 0,  0, 0, 0,     0, 1, 0,     0, 0, 0,  0, 0, 4,  0, 0, 0},//*2***56** *1**2***43**
            /////////////////////////////////////////////////////////////////////////////
            {0, 0, 0,  0, 0, 0,  0, 0, 0,     0, 0, 0,     0, 0, 0,  0, 0, 0,  0, 0, 0},
            {0, 0, 0,  0, 0, 0,  0, 0, 0,     0, 0, 0,     0, 0, 0,  0, 0, 0,  0, 0, 0},
            {0, 0, 0,  0, 0, 0,  0, 0, 0,     0, 0, 0,     0, 0, 0,  0, 0, 0,  0, 0, 0},
           ///////////////////////////////////////////////////////////////////////////// 
            {0, 0, 8,  0, 0, 0,  0, 2, 0,     0, 0, 0,     0, 0, 8,  9, 0, 0,  0, 6, 0},   // **85***2* *3***89***6*
            {0, 2, 0,  0, 4, 0,  0, 0, 0,     0, 0, 0,     9, 0, 0,  0, 2, 0,  0, 5, 0},   // 62**4**5* ***96**2**5*
            {0, 0, 7,  0, 0, 8,  9, 0, 3,     0, 0, 0,     0, 0, 2,  0, 0, 8,  1, 0, 9},   // **7**89*3 *****2**81*9
            
            {0, 0, 0,  0, 0, 0,  0, 0, 2,     0, 0, 0,     0, 0, 0,  0, 0, 0,  0, 0, 6},  //**6*****2 **1*****6
            {0, 0, 0,  0, 0, 0,  0, 0, 0,     0, 0, 0,     0, 0, 0,  0, 0, 0,  0, 2, 0},  //*5*****4* *8*****2*
            {0, 0, 0,  0, 0, 0,  0, 0, 0,     0, 0, 0,     0, 0, 0,  0, 0, 0,  0, 0, 0},  //8*****3** 7*****5*
            
            {1, 0, 5,  9, 0, 0,  0, 0, 0,     0, 0, 0,     0, 0, 0,  7, 0, 0,  4, 0, 0},  //1*59**2** 2*67**4**
            {0, 3, 0,  0, 0, 0,  0, 0, 0,     0, 0, 0,     0, 0, 0,  0, 9, 0,  0, 7, 8},  //*3**6**71 *3**9**78
            {9, 6, 0,  0, 0, 3,  5, 0, 0,     0, 0, 0,     0, 9, 0,  0, 0, 4,  2, 0, 0}};   //*6***35** *9***42**
 
 
 */
 
 
 

                  try {
            Scanner input = new Scanner(new File("C:\\Users\\ALPEREN\\Documents\\Projeler\\SamuraiSudokuSolver\\sudoku.txt"));
        
            while (input.hasNext()) {
            for (int i = 0; i < 21; i++) {
         
                   try{//    System.out.println("number is ");
                    okunanTxt2[i] = input.next();
                     
                    }
                   catch (java.util.NoSuchElementException e) {
                       
                    }
                }
            }       
        
     
    } catch (Exception e) {
        e.printStackTrace();
    }
                  
                  
                  
                  
                  
                  
     
                  
                  
      
      
      
      
      
      
      
      
        
       for(int satirNo=0; satirNo<21; satirNo++){
           
           int sayac=0;
           int kolonNo=0;
           
           for(int i=0; i<okunanTxt2[satirNo].length(); i++){
           
       if(satirNo<6 && sayac==9){kolonNo+=3;}
       else if(satirNo > 8 && satirNo < 12 ) {kolonNo=i+6;}
       else if(satirNo > 14 && sayac==9){kolonNo+=3;}
               
                  
                  if(okunanTxt2[satirNo].charAt(i)=='*'){ board2[satirNo][kolonNo]=0;  }
                  else{board2[satirNo][kolonNo]= Integer.parseInt(String.valueOf(okunanTxt2[satirNo].charAt(i)));   
                  
                  }
                  
          sayac++;
          kolonNo++;}
                
       }
        
       giris(board,board2,s1);
     
      
      
 
 
      
                        
               JFrame frame=new JFrame("sudoku");
               
               
        frame.setSize(800, 800);
        
     SudokuCozucu brd = new SudokuCozucu();
     frame.add(brd);
     
   
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
          frame.setVisible(true);
          
          
   
       
            
      
       
       
 
 
 
 
 
          


         Timer  BesliTimer = new Timer();
         Timer  OnluTimer = new Timer();
         Timer  EkranTimer = new Timer();

     TimerTask BesliTask = new TimerTask() {
             @Override
             public synchronized void run() {
          //       System.out.println("Besli Task calıstı  ");
                 int bulunanKare=0;
                for(int satirNo=0; satirNo<21 ; satirNo++){
                  for(int kolonNo=0; kolonNo<21; kolonNo++){
                 
           if(SudokuCozucu.board[satirNo][kolonNo].deger!=0  ){bulunanKare++;  }
         //  System.out.print(board[satirNo][kolonNo].deger + " ");
                
            
            
             }
           //    System.out.println(); 
                }
              
        int y= bulunanKare- toplamBulunanBesli;toplamBulunanBesli+=y;
        besliGrafikVerileri.add(y); 
        if(bulunanKare==369){ BesliTimer.cancel();BesliTimer.purge();
        //System.out.println("Besli Task durdu  ");
        } 
            } };
     
   
   
          TimerTask OnluTask = new TimerTask() {
             @Override
             public synchronized void run() {
              //   System.out.println("Onlu Task calıstı  ");
                 int bulunanKare=0;
                for(int satirNo=0; satirNo<21 ; satirNo++){
                  for(int kolonNo=0; kolonNo<21; kolonNo++){
                 
           if(SudokuCozucu.board[satirNo][kolonNo].deger!=0  ){bulunanKare++;  }
        //   System.out.print(board[satirNo][kolonNo].deger + " ");
                
            
            
             }
           //    System.out.println(); 
                }
              
        int y= bulunanKare- toplamBulunanOnlu;toplamBulunanOnlu+=y;
        onluGrafikVerileri.add(y); 
        if(bulunanKare==369){ OnluTimer.cancel();OnluTimer.purge();
        //System.out.println("Onlu Task durdu  ");
        } 
            } };
          

      
   
   TimerTask gorev3 = new TimerTask() {
             @Override
             public synchronized void run() {
                 frame.repaint();
             }    };
        
     

     
     
       
       
        
        EkranTimer.schedule(gorev3, 0, ekranYenilemeMs);
        
        
        
        
         int sayi2 = input2.nextInt();
         if(sayi2==0){
         besliThreadIleCoz(BesliTimer,BesliTask,s1,board,board2,th1,th2,th3,th4,th5);
         }
         
         
         
         
         
        
        
         
         int sayi3 = input2.nextInt();
         if(sayi3==0){
             SiraliListeBes=SudokuCozucu.SiraliListe;
             grafikIslemi(SiraliListeBes,besliGrafikVerileri2);
             giris(board,board2,s1); 
             
         }
         
        
        
           
        int sayi1 = input2.nextInt();
        if(sayi1==0){onluThreadIleCoz(OnluTimer,OnluTask,s1,board,board2,th6,th7,th8,th9,th10,th11,th12,th13,th14,th15);}
      
       
        
       
        
        sayi1 = input2.nextInt();
        if(sayi1==0){
         
         
         
         SiraliListeOn=SudokuCozucu.SiraliListe;
         grafikIslemi(SiraliListeOn,onluGrafikVerileri2);
        grafikCiz(besliGrafikVerileri,onluGrafikVerileri);}
        
        
        double d = besliGrafikVerileri2.size()*zamanAraligiNormal;
        double d2 = onluGrafikVerileri2.size()*zamanAraligiNormal;
       
        
        
    
        
         System.out.println();
         System.out.println(   "  GRAFİK 2   "+ zamanAraligiNormal+" ms aralıklarında bulunan kare sayisi  ");
         System.out.print("BESLİ TOTAL ZAMAN "+String.format("%.4f",d) +" ");
          for(int i =0; i<besliGrafikVerileri2.size(); i++){System.out.print( " "+besliGrafikVerileri2.get(i));}
          System.out.println();
          System.out.print("ONLU TOTAL ZAMAN "+String.format("%.4f",d2) +" ");
          for(int i =0; i<onluGrafikVerileri2.size(); i++){System.out.print( " "+onluGrafikVerileri2.get(i));}
        
        
   JFrame rekrusifFrame=new JFrame("Grafik rekrüsif");
   JFrame normalGrafikFrame=new JFrame("Grafik ms");
   
   
   // threadlerin islem suresi grafikte bozulmaya sebep oldugu için ort bir süre hesaplayıp gönderiyoruz
   double besRekOrtIslemSuresi = (besliGrafikVerileri2.size()*zamanAraligiNormal*1000)/besliGrafikVerileri.size();
   double onRekOrtIslemSuresi = (onluGrafikVerileri2.size()*zamanAraligiNormal*1000)/onluGrafikVerileri.size();
   System.out.println();System.out.println(" sapma 5 = "+(besRekOrtIslemSuresi-zamanAraligiRek)+" sapma 10 = "+(onRekOrtIslemSuresi-zamanAraligiRek));
   
   grafik grafikRekrusif= new grafik(besliGrafikVerileri,onluGrafikVerileri);
   grafikRekrusif.tur=0;grafikRekrusif.besRekOrtIslemSuresi=besRekOrtIslemSuresi;grafikRekrusif.onRekOrtIslemSuresi=onRekOrtIslemSuresi;
   rekrusifFrame.add(grafikRekrusif);
   
   
   grafik grafikNormal= new grafik(besliGrafikVerileri2,onluGrafikVerileri2);
   grafikNormal.tur=1;grafikNormal.zamanAraligiNormal=zamanAraligiNormal;
   normalGrafikFrame.add(grafikNormal);
  
   rekrusifFrame.setSize(800, 800);
   rekrusifFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   rekrusifFrame.setVisible(true);
   
   normalGrafikFrame.setSize(800, 800);
   normalGrafikFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   normalGrafikFrame.setVisible(true);
          
          
          
        
        // maim sonu
        }
     
          
                
                 
                
               
         
   // ORTAK ALANLARI VE BOSLUKLARI ISARETLER KARE MATRİSİ HAZIRLAR
     
     public static synchronized kare[][] BoardHazirla(kare[][] board,int[][] board2){
         System.out.println("SAMURAI SUDOKU BASLANGIC");
         
         
               for(int satirNo=0; satirNo<21 ; satirNo++){
                  for(int kolonNo=0; kolonNo<21; kolonNo++){
                      board[satirNo][kolonNo] = new kare();
                      
                            // aralık alanları kapsayan yerlerde ise bos isaretlenir
                 if(  ((satirNo<12 && satirNo>8) && (kolonNo<6 || kolonNo>14))  || ((kolonNo<12 && kolonNo>8) && (satirNo<6 || satirNo>14))      ) 
                 {
                     board[satirNo][kolonNo].setBoslukMu(true);
                     board[satirNo][kolonNo].bulanTheadNo=-1;
                     board[satirNo][kolonNo].bulunduguMs=-1;
                     
               //  System.out.println(satirNo+ "ve  " + kolonNo+"  BOŞLUKTUR" );
                     
                 }
                      
                    // ortak alanı kapsayan yerde ise ortak isaretlenir
                //1. bolge ortak kareler
                 if(   ( (satirNo<9 && satirNo>5) &&  ( ((kolonNo<9 && kolonNo>5))  ||  ((kolonNo<15 && kolonNo>11))  ) ) )
                 {board[satirNo][kolonNo].setOrtakMi(true);board[satirNo][kolonNo].bolge=1;// System.out.println(satirNo+ "ve  " + kolonNo+"  ortaktır ve 1. bölge" )
                         ;}
                     // 0. bolge ortak kareler
                  if(    ( (satirNo<15 && satirNo>11) &&  ( ((kolonNo<9 && kolonNo>5))  ||  ((kolonNo<15 && kolonNo>11))  ) ) )     
                     {board[satirNo][kolonNo].setOrtakMi(true);board[satirNo][kolonNo].bolge=0;//System.out.println(satirNo+ "ve  " + kolonNo+"  ortaktır ve 0. bölge" )
                             ;}
                       
                      
                  
                      board[satirNo][kolonNo].isaretliMi=false;
                      board[satirNo][kolonNo].deger=0;
                      board[satirNo][kolonNo].kordX=satirNo;board[satirNo][kolonNo].kordY=kolonNo;
                      board[satirNo][kolonNo].setDeger(board2[satirNo][kolonNo]);
                      if(board2[satirNo][kolonNo]!=0)   {board[satirNo][kolonNo].isaretliMi=true;}
                      
                
                 
              System.out.print(board[satirNo][kolonNo].deger + " ");
                
            }
            System.out.println();
        }
               
               
         return board;
     }
     
     
     public static synchronized void besliThreadIleCoz(Timer  BesliTimer,TimerTask BesliTask,SudokuCozucu s1,kare[][] board,int[][] board2,threadd th1,threadd th2,threadd th3,threadd th4,threadd th5){
       
         System.out.println("besli thread basladı");
         
          board=BoardHazirla(board,board2); // bosluk ve ortak alanları isaretledik 
          
          s1.setBoard(board); // cozucuye tabloyu attık tek tablo üstünde threadler calısacak
          SudokuCozucu.tabloYazdirildiMi=false;
          SudokuCozucu.besMiOnMu=5;
          SudokuCozucu.denemeSayisi=0;
          SudokuCozucu.startTimeGuncelle();
          BesliTimer.schedule(BesliTask, 0, zamanAraligiRek);
          
          th3.start();
          th1.start();
          th2.start();
          th4.start();
          th5.start();
          
          
        
         
     }
     
     
          public static synchronized void onluThreadIleCoz(Timer  OnluTimer,TimerTask OnluTask,SudokuCozucu s1,kare[][] board,int[][] board2,threadd th1,threadd th2,threadd th3,threadd th4,threadd th5,threadd th6,threadd th7,threadd th8,threadd th9,threadd th10){
         
              System.out.println("onlu thread basladı ");
              
          board=BoardHazirla(board,board2); // bosluk ve ortak alanları isaretledik 
          
          s1.setBoard(board); // cozucuye tabloyu attık tek tablo üstünde threadler calısacak
          SudokuCozucu.tabloYazdirildiMi=false;
          SudokuCozucu.denemeSayisi=0;
      //    SudokuCozucu.aktifThreadMatrisi[0]=false;SudokuCozucu.aktifThreadMatrisi[1]=false;SudokuCozucu.aktifThreadMatrisi[2]=false;SudokuCozucu.aktifThreadMatrisi[3]=false;SudokuCozucu.aktifThreadMatrisi[4]=false;
          SudokuCozucu.startTimeGuncelle();
          SudokuCozucu.besMiOnMu=10;
          SudokuCozucu.derinlik=6;
          
          OnluTimer.schedule(OnluTask, 0, zamanAraligiRek);
          
          th5.start();
          th6.start();
          th1.start();
          th2.start();
          th3.start();
          th4.start();
          th7.start();
          th8.start();
          th9.start();
          th10.start();
          
          
          
         
     }
     
      public static synchronized void grafikCiz(ArrayList<Integer> besliGrafikVerileri,ArrayList<Integer> onluGrafikVerileri){
          
          System.out.println();
          System.out.println("GRAFİK VERİLERİ   ");
          System.out.println();
          System.out.print("5li tread her "+ zamanAraligiRek+" ms de bulunan kare sayısı  ");
          for(int i =0; i<besliGrafikVerileri.size(); i++){
            //  if(besliGrafikVerileri.get(i)==null)continue;
              //else
              System.out.print(" "+besliGrafikVerileri.get(i));
          }
          System.out.println();
           System.out.print("10li tread her "+ zamanAraligiRek+" ms de bulunan kare sayısı  ");
          for(int i =0; i<onluGrafikVerileri.size(); i++){
           //   if(onluGrafikVerileri.get(i)==null)continue;
              //else
              System.out.print( " "+onluGrafikVerileri.get(i));
          }}
  
  public static synchronized void giris(kare[][] board,int[][] board2 ,SudokuCozucu s1){
      
        SudokuCozucu.ilkboard=board2;
       board=BoardHazirla(board,board2); // bosluk ve ortak alanları isaretledik 
        s1.setBoard(board);
      
  }
      public static synchronized void grafikIslemi(ArrayList<kare> SiraliListe,ArrayList<Integer> GrafikVerileri){
         
          
          
                
          //  for (int i = 0; i<SiraliListe.size(); i++){ System.out.println(i+1 + ". kare  "+ SiraliListe.get(i).bulanTheadNo +" nolu thread tarafından " + SiraliListe.get(i).bulunduguMs + " ms de bulundu kordinatları = "+SiraliListe.get(i).kordX
          //     +" " +SiraliListe.get(i).kordY  + "  DEGERİ = "+SiraliListe.get(i).deger );}
          
          
          
 
          
          int sayac=0;
          double altSinir=0;
          double temp = zamanAraligiNormal;
          int flag=0;int artık=0;
          
          
          
         
          System.out.println();
          
          
    
      
 
          for(int j =0; j<SiraliListeBes.size(); j++){
              
              
            if( SiraliListe.get(j).bulunduguMs>=altSinir  
                && SiraliListe.get(j).bulunduguMs<zamanAraligiNormal){sayac++;flag++;}
            
            else{  artık++;    if(flag==0){sayac=0;GrafikVerileri.add(sayac);  } 
                               else { sayac+=artık; GrafikVerileri.add(sayac); sayac=0; flag=0;artık=0;}
                  
                  altSinir =zamanAraligiNormal; zamanAraligiNormal= zamanAraligiNormal+temp;}
            
            }
            
            
            
                   GrafikVerileri.add(sayac+artık);
          
                  
         //   for(int i =0; i<GrafikVerileri.size(); i++){System.out.print( " "+GrafikVerileri.get(i));}
        
        
            
            
            
            
            
            
            
                      System.out.println();zamanAraligiNormal=temp;
                             
        /* 
          zamanAraligi2=temp;
    
          System.out.println ("10li tread her "+ zamanAraligi2 +" ms de bulunan kare sayısı  ");  
          
            for(int j =0; j<SudokuCozucu.SiraliListeOn.size(); j++){
                  if( SudokuCozucu.SiraliListeOn.get(j).bulunduguMs>=altSinir2  && SudokuCozucu.SiraliListeOn.get(j).bulunduguMs<zamanAraligi2) {sayacOn++;}
                  else{ onluGrafikVerileri2.add(sayacOn); sayacOn=1; altSinir2 =zamanAraligi2; zamanAraligi2= zamanAraligi2+temp;}
            
            }
                   onluGrafikVerileri2.add(sayacOn);
          
                  
            for(int i =0; i<onluGrafikVerileri2.size(); i++){ System.out.print( " "+onluGrafikVerileri2.get(i));}
        
        */ 
            
            
       
              
                  
                  
          
      }
}


             

    

  