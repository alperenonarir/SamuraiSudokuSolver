


public class kare {
  
   
  public int kordX;
  public int kordY;
  public int deger; 
  public int bolge=2; // o alt 1 üst ,,ortak alanları bulurken yardımcı olması ıcın dusunuldu
  public double bulunduguMs=0;
  public int bulanTheadNo;
  public boolean boslukMu=false;
  public boolean isleniyorMu=false;
  public boolean ortakMi;
  public boolean isaretliMi=false;
 

    

    public kare(int kordX, int kordY, int deger, boolean boslukMu, boolean isleniyorMu) {
        this.kordX = kordX;
        this.kordY = kordY;
        this.deger = deger;
        this.boslukMu = boslukMu;
        this.isleniyorMu = isleniyorMu;
    }
    public kare(){}

  

   

    
    public void setKordX(int kordX) {this.kordX = kordX;}
    public int getKordY() {return kordY;}
    public void setKordY(int kordY) {this.kordY = kordY;}
    public int getDeger() {return deger;}
    public void setDeger(int deger) {this.deger = deger;}
    public boolean isBoslukMu() {return boslukMu;}
    public void setBoslukMu(boolean boslukMu) {this.boslukMu = boslukMu;}
    public boolean isIsleniyorMu() {return isleniyorMu;}
    public void setIsleniyorMu(boolean isleniyorMu) {this.isleniyorMu = isleniyorMu;}
    public boolean isOrtakMi() {return ortakMi;}
    public void setOrtakMi(boolean ortakMi) {this.ortakMi = ortakMi;}
    public int getBolge() {return bolge;}
    public void setBolge(int bolge) { this.bolge = bolge;}
    public double getBulunduguMs() {return bulunduguMs;}
    public void setBulunduguMs(int bulunduguMs) {this.bulunduguMs = bulunduguMs;}
    public int getBulanTheadNo() {return bulanTheadNo;}
    public void setBulanTheadNo(int bulanTheadNo) {this.bulanTheadNo = bulanTheadNo;}
    public boolean isIsaretliMi() {return isaretliMi;}
    public void setIsaretliMi(boolean isaretliMi) {this.isaretliMi = isaretliMi;}
    
    
}
