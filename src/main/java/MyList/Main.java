package MyList;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        CustomLinkedList myList = new CustomLinkedList();
        myList.add("engineer");
        myList.add("tractor driver");
        myList.add("truck driver");
        myList.add("combine harvester");
        myList.add("crane operator");
        for (Object item: myList) {
            System.out.println(item);
        }

    }
}

