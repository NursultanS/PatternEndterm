
import java.util.List;

public class MaillingObject implements Subject, Mailling {

    private final List<Observer>observers;
    private String desc;
    private final String subjectDetails;

    public MaillingObject(List<Observer>observers, String subjectDetails){
        this.observers = observers;
        this.subjectDetails = subjectDetails;
    }
    public void subscribeObserver(Observer observer) {
        observers.add(observer);
    }

    public void unSubscribeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        observers.remove(index);

    }

    public void notifyObservers() {
        System.out.println();
        for(Observer observer : observers){
            observer.update(desc);
        }

    }

    public void setDesc(String desc) {
        this.desc = desc;
        notifyObservers();
    }
    public String subjectDetails() {
        return subjectDetails;
    }

}