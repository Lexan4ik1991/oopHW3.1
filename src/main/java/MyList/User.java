package MyList;

public class User {

    Object worker;
    private User next;
    private User previous;

    public User(Object worker) {
        this.worker = worker;
    }

    public Object getUserData() {
        return worker;
    }

    public void setUserData(String worker) {
        this.worker = worker;
    }

    public User getNext() {
        return next;
    }

    void setNext(User user){
        next = user;
    }

    void setPrevious(User user){
        previous = user;
    }

    public User getPrevious() {
        return previous;
    }
}