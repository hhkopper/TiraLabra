package pacman.alusta;

/**
 * Peliruutu tietää kaiken tärkeän tiedon mitä ruudussa tapahtuu ja ketä ja mitä
 * se sisältää.
 *
 * @author hhkopper
 */
public class Peliruutu implements Comparable<Peliruutu>{

    /**
     * Ruudun X koordinaatti.
     */
    private int x;
    /**
     * Ruudun Y koordinaatti.
     */
    private int y;
    /**
     * Kertoo ruudun tyypin, 0 jos seinä, 1 jos käytävä, 2 jos ekstrapallon paikka ja 3 jos vaikka jonne ei laiteta mitään.
     */
    private int ruudunTyyppi;
      /**
     * Kertoo onko Man ruudussa, true, jos on ja false, jos ei.
     */
    private boolean onkoMan;
      /**
     * Kertoo onko Haamu ruudussa, true, jos on ja false, jos ei.
     */
    private boolean onkoHaamu;
      /**
     * Kertoo onko pistepallo ruudussa vai ei, true, jos on ja false, jos ei.
     */
    private boolean onkoPallo;
      /**
     * Kertoo onko ekstra pistepallo ruudussa, true, jos on ja false, jos ei.
     */
    private boolean onkoExtraPallo;
    
    /**
     * Kertoo etäisyyden alkuun.
     */
    private int etaisyysAlkuun;
    /**
     * Kertoo etäisyyden maaliin.
     */
    private int etaisyysMaaliin;
    /**
     * Kertoo edellisen peliruudun.
     */
    private Peliruutu edellinen;

    /**
     * Konstruktorissa annetaan arvot koordinaateille.
     *
     * @param x koordinaatti X
     * @param y koordinaatti Y
     */
    public Peliruutu(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Peliruutu getEdellinen() {
        return this.edellinen;
    }
    
    public void setEdellinen(Peliruutu ruutu) {
        this.edellinen = ruutu;
    }
    
    public int getEtaisyysAlkuun() {
        return this.etaisyysAlkuun;
    }
    
    public int getEtaisyysMaaliin() {
        return this.etaisyysMaaliin;
    }
    
    public void setEtaisyysAlkuun(int luku) {
        this.etaisyysAlkuun = luku;
    }
    
    public void setEtaisyysMaaliin(int luku) {
        this.etaisyysMaaliin = luku;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setRuudunTyyppi(int uusiTyyppi) {
        this.ruudunTyyppi = uusiTyyppi;
    }

    public int getRuudunTyyppi() {
        return this.ruudunTyyppi;
    }

    public void setOnkoMan(boolean arvo) {
        this.onkoMan = arvo;
    }

    public boolean getOnkoMan() {
        return this.onkoMan;
    }

    public void setOnkoHaamu(boolean arvo) {
        this.onkoHaamu = arvo;
    }

    public boolean getOnkoHaamu() {
        return this.onkoHaamu;
    }

    public void setOnkoPallo(boolean arvo) {
        this.onkoPallo = arvo;
    }

    public boolean getOnkoPallo() {
        return this.onkoPallo;
    }

    public void setOnkoExtraPallo(boolean arvo) {
        this.onkoExtraPallo = arvo;
    }

    public boolean getOnkoExtraPallo() {
        return this.onkoExtraPallo;
    }
    
    /**
     * Equals metodi peliruuduille.
     * @param olio
     * @return 
     */
    @Override
    public boolean equals(Object olio) {
        if(olio == null) {
            return false;
        }
        if(getClass() != olio.getClass()) {
            return false;
        }
        
        Peliruutu verrattava = (Peliruutu) olio;
        
        if(this.x != verrattava.getX() || this.y != verrattava.getY()) {
            return false;
        }
        
        return true;
    }

    /**
     * Peliruudulle lasketaan oman hajautusarvon.
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        if(this.x < 0 || this.y < 0) {
            return hash;
        }
        
        return this.x*19+this.y;
    }
    
    @Override
    public int compareTo(Peliruutu ruutu) {

        return (this.etaisyysMaaliin+this.etaisyysAlkuun) - (ruutu.getEtaisyysMaaliin()+ruutu.getEtaisyysAlkuun());
    }
    
    @Override
    public String toString() {
        return "("+this.x+","+this.y+")";
    }
}
