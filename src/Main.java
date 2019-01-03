public class Main {
    //I want to simulate a meteo station
    public static void main(String[] args) throws InterruptedException {
        StazioneMeteo stazione = new StazioneMeteo();
        Thread threadStazione = new Thread(stazione);

        CentralinaElaborazione c1 = new CentralinaElaborazione(stazione);

        threadStazione.start();

        CentralinaElaborazione c2 = new CentralinaElaborazione(stazione);

        threadStazione.join();

        c1.print();
        c2.print();

    }
}
