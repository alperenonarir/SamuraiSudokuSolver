


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class grafik extends JPanel {
     ArrayList<Integer> besliGrafikVerileri2 = new ArrayList<Integer>();
     ArrayList<Integer> onluGrafikVerileri2 = new ArrayList<Integer>();
     double besRekOrtIslemSuresi;
      double onRekOrtIslemSuresi;
     double zamanAraligiNormal=0;
     int tur=1; // tür 0 sa rekrüsif grafik çizer
    
      public grafik(ArrayList<Integer> besliGrafikVerileri2,ArrayList<Integer> onluGrafikVerileri2) {
      this.besliGrafikVerileri2=besliGrafikVerileri2;
      this.onluGrafikVerileri2=onluGrafikVerileri2;
      
      }
     
     
 
      
    public void paint(Graphics g){
      
           super.paint(g);
           
           g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
         int ilkX=50;
         int ilkY=500;
         int ilkXislem=50;
         int ilkYislem=500;
         
         
         int x=ilkX;
         int y = ilkY;
          
          // kordinat sistemi çizgileri
         

           
           
           
           
             for(int i =0; i<6; i++){  // dikey centikler ve degerleri yazdırma bulunan kare sayısı 
               
               ilkYislem-=50;
               g.setColor(Color.gray);             
               g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
               g.drawString(String.valueOf((1+i)*50), ilkXislem-45, ilkYislem);
               g.drawLine(ilkXislem-5,ilkYislem,ilkXislem+5,ilkYislem);
           }
           
           ilkYislem=ilkY;
           
           
           g.setColor(Color.black);
           g.drawLine(ilkX,ilkY,ilkY*2,ilkY);
           g.drawLine(ilkX,ilkY,ilkX,ilkX);
         
           g.drawString("bulunan cozum sayisi  ", 25, 45);     
           g.drawString("zaman ", 950, 520);
           
           g.setColor(Color.CYAN);            // 369 yazısı ve çizgisi
           g.drawLine(ilkX,ilkY-369,ilkY*2,ilkY-369);
           g.drawString("369 ", 15, ilkY-369);
           
           
           g.setColor(Color.red);
           g.drawString("Besli Thread Cozumu ", 1000, 40);
           
           g.setColor(Color.blue);
           g.drawString("Onlu Thread Cozumu ", 1000, 70);
         
           
           
      
         
         
         if(this.tur==0){ // birleşimli grafik çizimi rekrüsif sonuc için
             
                      
         
            for(int i =0; i<this.onluGrafikVerileri2.size(); i++){ // veriler birbirinin ucuna eklenerek çizilir
         
         x+=15;
         y= y-this.onluGrafikVerileri2.get(i);
               g.setColor(Color.blue);
               g.drawLine(ilkXislem,ilkYislem,x,y);
          ilkYislem=y;
          ilkXislem=x;
         }
            
                     x=ilkXislem=ilkX;
                     y=ilkYislem=ilkY;
                     
         
            for(int i =0; i<this.besliGrafikVerileri2.size(); i++){
         
         x+=15;
         y= y-this.besliGrafikVerileri2.get(i);
               g.setColor(Color.red);
               g.drawLine(ilkXislem,ilkYislem,x,y);
          ilkYislem=y ;
          ilkXislem=x;
         }
         
             
            x=ilkXislem=ilkX;
            y=ilkYislem=ilkY;
       
            for(int i =0; i<this.onluGrafikVerileri2.size(); i++){ // yatay centikler ve total zaman onlu
               
               ilkXislem+=15;
               g.setColor(Color.blue);
               g.drawLine(ilkXislem,ilkY-5,ilkXislem,ilkY);
           }
           String  ms3 = String.format("%.4f",(this.onRekOrtIslemSuresi)*onluGrafikVerileri2.size()/1000); 
           g.drawString(ms3, ilkXislem-4, ilkY+23);
          
            
           
            x=ilkXislem=ilkX;
            y=ilkYislem=ilkY;
       
            for(int i =0; i<this.besliGrafikVerileri2.size(); i++){ // yatay centikler ve total zaman onlu
               
               ilkXislem+=15;
               g.setColor(Color.red);
               g.drawLine(ilkXislem,ilkY,ilkXislem,ilkY+5);
           }
            String  ms4 = String.format("%.4f",(this.besRekOrtIslemSuresi)*besliGrafikVerileri2.size()/1000); 
            g.drawString(ms4, ilkXislem-4, ilkY+37);
           ilkXislem=ilkX;
            
            
            
            
            
            
             
         }
         else{  // grafik ms
                
             x=ilkXislem=ilkX;
             y=ilkYislem=ilkY;
             
         for(int i =0; i<this.besliGrafikVerileri2.size(); i++){
         
       if(besliGrafikVerileri2.get(i)==0 && i%4!=0){continue;} 
       
       
       ilkXislem+=14;
       
         y= y-this.besliGrafikVerileri2.get(i);
               g.setColor(Color.red);
               g.drawLine(ilkXislem,ilkYislem,ilkXislem,y);
          y = ilkYislem;
         }
         
         
         
         x=ilkXislem=ilkX;
         y=ilkYislem=ilkY;
             
           for(int i =0; i<this.onluGrafikVerileri2.size(); i++){
          if(onluGrafikVerileri2.get(i)==0 && i%4!=0){continue;} 
         ilkXislem+=15;
         y= y-this.onluGrafikVerileri2.get(i);
               g.setColor(Color.blue);
               g.drawLine(ilkXislem,ilkYislem,ilkXislem,y);
          y = ilkYislem;
         }
         
           
           
           
           g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
           
             x=ilkXislem=ilkX;
            y=ilkYislem=ilkY;
       
            for(int i =0; i<this.onluGrafikVerileri2.size(); i++){ // yatay centikler ve total zaman onlu
               if(onluGrafikVerileri2.get(i)==0 && i%4!=0){continue;} 
               ilkXislem+=15;
               g.setColor(Color.blue);
               g.drawLine(ilkXislem,ilkY-5,ilkXislem,ilkY);
               
             
               
           }
           
             String  ms2 = String.format("%.4f",this.zamanAraligiNormal*onluGrafikVerileri2.size());
           g.drawString(ms2, ilkXislem-4, ilkY+23);
            
           
            x=ilkXislem=ilkX;
            y=ilkYislem=ilkY;
       
            for(int i =0; i<this.besliGrafikVerileri2.size(); i++){ // yatay centikler ve total zaman onlu
               if(besliGrafikVerileri2.get(i)==0 && i%4!=0){continue;} 
              ilkXislem+=15;
               g.setColor(Color.red);
               g.drawLine(ilkXislem,ilkY,ilkXislem,ilkY+5);
               
            
           }
            
           
           String  ms = String.format("%.4f",this.zamanAraligiNormal*besliGrafikVerileri2.size());
           g.setColor(Color.red);
           g.drawString(ms, ilkXislem-4, ilkY+37);
             
           
           
           
           
           
           
           
           
           
             
             
         }

         
     
              
              
              //g.drawLine(,,,,);
             // g.draw
            //  g.drawLine(x,y+i*side,x+col*side,y+i*side);
          //    System.out.print( " "+this.besliGrafikVerileri2.get(i));
          
          
          
           
           
           
           
           
           
           
       /*    
           
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
            */
            

             
    }

   
    
    
    
    
    
    
    
    
}
