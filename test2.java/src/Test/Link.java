package Test;

public class Link {

    public String bookName;
    public int millionsSold;

    public Link next;

    public Link(String bookName, int millionsSold) {
        this.bookName =bookName;
        this.millionsSold = millionsSold;
    }

    public void display() {
        System.out.println(bookName + " : " + millionsSold + " 000,000");
    }
    public String toString() {
        return bookName;
    }
    public static void main(String[] args) {
    }    
}

class LinkList {
    public Link firstLink;    
    LinkList() {
        firstLink = null;
    }
    public boolean isEmpty() {
        return (firstLink == null);
    }
    public void insertFirstLink(String bookName, int millionsSold) {
        Link newLink = new Link(bookName, millionsSold );
        newLink.next = firstLink;
        firstLink = newLink;
    }
    public Link removeFirst() {
        Link linkReferance = firstLink;
        if(!isEmpty()) {
            firstLink = firstLink.next;
        }
        else {
            System.out.println("Empty Linked list");
        }
        return linkReferance;
    }
    public void display() {
        Link theLink = firstLink;
        while(theLink != null) {

            theLink.display();
            System.out.println(" Next Link: " + theLink.next);
            theLink = theLink.next;
            System.out.println();
        }
    }
    public Link find(String bookmane) {
        Link theLink = firstLink;
        if(!isEmpty()) {
            while(theLink.bookName != bookmane) {
                if(theLink.next == null) {
                    return null;
                }
                else {
                    theLink = theLink.next;
                }
            }
        }
        else {
            System.out.println(" Empty Linked List");
        }
        return theLink;

    }
    public Link removeLink() {
        Link currentLink = firstLink;
        Link previousLink = firstLink;        
        //while(currentLink.bookName != bookName) {

        //}
        return previousLink;
    }

}