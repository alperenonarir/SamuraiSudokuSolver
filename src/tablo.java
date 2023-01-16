
public class tablo {

    int baslangicSatir;
    int bitisSatir;
    int baslangicKolon;
    int bitisKolon;
    int tabloNo;
    
    
    public tablo(int baslangicSatir, int bitisSatir, int baslangicKolon, int bitisKolon, int tabloNo) {
        this.baslangicSatir = baslangicSatir;
        this.bitisSatir = bitisSatir;
        this.baslangicKolon = baslangicKolon;
        this.bitisKolon = bitisKolon;
        this.tabloNo = tabloNo;
    }

    public tablo(){}
    
    public int getTabloNo() {return tabloNo;}
    public void setTabloNo(int tabloNo) {this.tabloNo = tabloNo;}
    public int getBaslangicSatir() {return baslangicSatir;}
    public void setBaslangicSatir(int baslangicSatir) {this.baslangicSatir = baslangicSatir;}
    public int getBitisSatir() {return bitisSatir;}
    public void setBitisSatir(int bitisSatir) {this.bitisSatir = bitisSatir;}
    public int getBaslangicKolon() {return baslangicKolon;}
    public void setBaslangicKolon(int baslangicKolon) {this.baslangicKolon = baslangicKolon;}
    public int getBitisKolon() {return bitisKolon;}
    public void setBitisKolon(int bitisKolon) {this.bitisKolon = bitisKolon;}
    
}
