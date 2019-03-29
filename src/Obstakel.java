public class Obstakel {
    private int waarde;

    public Obstakel(int waarde){
        this.waarde = waarde;
    }

    public int getWaarde(){
        return waarde;
    }

    public boolean removeObstakel(Hoofdpersoon persoon){
        if(persoon.hasKeys()){
            for(Schaar schaar : persoon.getAantalSleutels()){
                if(schaar.getWaarde() == this.waarde){
                    return true;
                }
            }
        }
        return false;
    }

}
