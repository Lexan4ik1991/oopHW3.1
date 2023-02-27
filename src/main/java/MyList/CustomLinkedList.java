package MyList;
import java.util.Iterator;
public class CustomLinkedList implements Iterable {

    private User head ;
    private User tail;
    private int count = 0;

    @Override
    public Iterator iterator() {
        return  new Iterator<Object>() {
            User user0 = new User("0");
            {
                user0.setNext(head);
            }
            User currentUser = user0;

            @Override
            public boolean hasNext() {
                return currentUser.getNext() != null;
            }

            @Override
            public Object next() {
                currentUser = currentUser.getNext();
                return currentUser.getUserData();
            }
        };
    }

    public int size() {
        return count;
    }

    private User getUser(int index){
        if (index >= count){
            throw new IndexOutOfBoundsException();
        }

        User result = head;
        for (int i = 1; i <= index; i++){
            result = result.getNext();
        }
        return result;
    }

    public Object get(int index){

        User user = getUser(index);

        return user.getUserData();
    }

    public void remove(int index){

        User currentUser = getUser(index);
        User nextUser = currentUser.getNext();
        User previousUser = currentUser.getPrevious();

        if (index == 0){
            head = nextUser;
            if (tail == currentUser){
                tail = null;
            }
        }

        if (index == count - 1){
            tail = previousUser;
            if (head == currentUser){
                head = null;
            }
        }

        count--;

        if (nextUser != null){
            nextUser.setPrevious(previousUser);
        }

        if (previousUser != null){
            previousUser.setNext(nextUser);
        }

    }

    public void add(int index, Object worker ){
        if (count == index){
            add(worker);
            return;
        }
        count++;

        User currentUser  = new User(worker);

        if (index == 0){
            head = currentUser;
        }

        User nextUser = getUser(index);
        User previousUser = nextUser.getPrevious();

        currentUser.setNext(nextUser);
        currentUser.setPrevious(previousUser);

        if (previousUser != null) {
            previousUser.setNext(currentUser);
        }

    }

    public void add(Object worker){
        count++;
        User workUser = new User(worker);
        if (head == null){
            head = workUser;
            tail = workUser;
            return;
        } else if (tail == null) {
            tail = workUser;
            return;
        }

        tail.setNext(workUser);
        workUser.setPrevious(tail);
        tail = workUser;
    }

}