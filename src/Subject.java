public interface Subject {
    public boolean attach(Observer o);
    public boolean detach();
    public void notifyChange();
}
