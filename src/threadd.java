

public class threadd extends Thread {
      SudokuCozucu s1 ; // sudoku cozucu objesi, bu obje ile tabloyu gonderecegiz
      tablo tablo;
      int threadNo;
      boolean aktifMi=true;
      int startX;
      int startY;

    public threadd(tablo tablo,SudokuCozucu s1, int threadNo,int startX, int startY) {
        this.tablo = tablo;
        this.s1 =s1;
        this.threadNo=threadNo;
        this.startX=startX;
        this.startY=startY;
    }

    public boolean isAktifMi() {return aktifMi;}
    public void setAktifMi(boolean aktifMi) {this.aktifMi = aktifMi;}

      @Override
    public void run() {
       
     
         SudokuCozucu.aktifThreadMatrisi[tablo.tabloNo-1]=true;
         while((s1.tabloyuCoz(tablo,threadNo,startX,startY))==false){}
           SudokuCozucu.aktifThreadMatrisi[tablo.tabloNo-1]=false;
        //   System.out.println(this.tablo.tabloNo +" numaralı tablo bitti" +false);
        s1.printBoard3(this.threadNo);
      //  s1.printBoard(threadNo,tablo);
    }

}