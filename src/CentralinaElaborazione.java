import java.util.ArrayList;


public class CentralinaElaborazione implements Observer {
    private static int ID = 0;
    private int id;
    ArrayList<String> updates = new ArrayList<String>();
    StazioneMeteo stazione; //FIXME se metto Subject stazione poi mi viene errore dopo  in "get last state (linea 19), perchè? Non "defeat" the purpose di aver fatto l'interfaccia?

    public CentralinaElaborazione(StazioneMeteo stazione){
        this.id = ID;
        ID++;
        this.stazione = stazione;
        stazione.attach(this);
    }

    //this is the pull way of doing the observer
    public void update(){
        updates.add(stazione.getLastState());
    }

    public void print(){
        for(String update:updates){
            System.out.println("By centralina " + id + " " + update);
        }
    }

}
