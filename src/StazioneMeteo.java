import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

//Stazione meteo è l'observable
public class StazioneMeteo implements Runnable, Subject{
    int updateNumber = 0;
    String lastState;
    ArrayList<Observer> observersList = new ArrayList<Observer>();
    public String getLastState(){ return lastState; }
    @Override
    public void run() {
        Random r = new Random();
        while(updateNumber < 5){
            try{
                sleep(2+r.nextInt(5000));
            } catch (InterruptedException e){}
            lastState = "New update! Update no. " + updateNumber + "-->" + r.nextInt(10000);
            notifyChange();
            System.out.println(lastState);
            updateNumber++;
        }
    }

    @Override
    public boolean attach(Observer o) {
        observersList.add(o);
        return true;
    }

    @Override
    public boolean detach() {
        return true;
    }

    @Override
    public void notifyChange(){
        for(Observer observer:observersList){
            observer.update();
        }
    }

}
