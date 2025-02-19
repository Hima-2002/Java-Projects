/*
        Create a library management system which is capable of issuing books to the students.
        Book should have info like:
        1. Book name
        2. Book Author
        3. Issued to
        4. Issued on
        User should be able to add books, return issued books, issue books
        Assume that all the users are registered with their names in the central database
*/
import java.util.ArrayList;
import java.util.Scanner;

class book{
    private String bookName,author;

    public book(String bookName,String author) {
        this.bookName=bookName;
        this.author=author;
       
    }
    @Override
    public String toString() {
        
        return ("Book: ->\n Book Name :\t"+bookName+"\n Book Author :\t"+author);
    }

}
class library{
    ArrayList<book> bookList=new ArrayList<>();
    ArrayList<book> issuedBookList=new ArrayList<>();
    

    library(){
        // Books In library
    book b1=new book("Ikigai", "Gracia");
    bookList.add(b1);
    book b2=new book("Yoga", "Vivekananda");
    bookList.add(b2);
    book b3=new book("The Autobiography of a Yogi", "Pramahamsa Yogananda");
    bookList.add(b3);
    book b4=new book("Ramayanam", "Valmiki");
    bookList.add(b4);
    
    }
    void addBooks(String bName,String bAuthor){
        bookList.add(new book(bName, bAuthor));
    }
    book issueBooksToStudent(int index){

        if(index >= 0 && index < bookList.size()){
            book b=bookList.get(index);
            issuedBookList.add(b);
            bookList.remove(index);
            return b;
        }else{
            System.out.println("Index Error...");
            return null;
        }
        
    }
    boolean returnBooksFromStudent(int index){
        if(index >= 0 && index < issuedBookList.size()){
            bookList.add(issuedBookList.get(index));
            issuedBookList.remove(index);
            return true;
        }else{
            System.out.println("Index Error...");
            return false;
        }
        
    }

    public void printBookInLib(){
        // for(book b: bookList){
        //     System.out.println(b);
        // }
        boolean isEmpty=bookList.isEmpty();
        if(isEmpty){
            System.out.println(" EMPTY !");
        }
        else{
            System.out.println("Library Books List: --->>>\n");
            for(int i=0;i<bookList.size();i++){
                System.out.println(i+"->"+bookList.get(i));
    
            }
        }
        
    }
    public void printBookIssed(){
        boolean isEmpty=issuedBookList.isEmpty();
        if(isEmpty){
            System.out.println(" EMPTY ...\nNo Issued Books Found!");
        }
        else{
            for(int i=0;i<issuedBookList.size();i++){
                System.out.println("Issued Books List: --->>>\n"+i+"->"+issuedBookList.get(i));
    
            }
        }
    }

    
}
public class LMSystem{
    Scanner scan=new Scanner(System.in);
    library l=new library();
    void addNewBooks(){
        try {
            System.out.println("Enter how many no.of books you want to add ...");
        int n=scan.nextInt();
        scan.nextLine();

        for(int i=0;i<n;i++){
            System.out.println("Enter Book Name: ");
            String bName=scan.nextLine();
            System.out.println("Enter Author Name: ");
            String bAuthor=scan.nextLine();
            l.addBooks(bName, bAuthor);
            System.out.println(l.bookList.getLast()+"\nBook Added SUCCESSFULLY!");
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       
    }
    void issueBooks(){
        
        try {System.out.println("Enter book Index :");
        int index=scan.nextInt();
        scan.nextLine();
        System.out.println("Enter Name of student : ");
        String name=scan.nextLine();
       
        book b=l.issueBooksToStudent(index); 
        if(b!=null)
        {
        System.out.println("The Book: "+b+" is issued SUCCESSFULLY! :) to ->"+name);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void returnBooks(){
        try {
            System.out.println("Enter Book index: ");
        int index=scan.nextInt();
        scan.nextLine();
        System.out.println("Enter Your name: ");
        String name=scan.nextLine();
        boolean isReturned=l.returnBooksFromStudent(index);
        if(isReturned){
            System.out.println("Books returned from "+name);
        }else{
            System.out.println("Error!- Book not Returned! :(");
        }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    public static void main(String[] args){
        LMSystem manager=new LMSystem();
        Scanner scan=new Scanner(System.in);
        try {
            boolean b=true;
            while (b) { 
                System.out.println("+++++++++++++++++++++++++++++++");
                System.out.println("+ 1 - See Books in Library.   +");
                System.out.println("+ 2 - Add books to library.   +");
                System.out.println("+ 3 - Issue book from library.+");
                System.out.println("+ 4 - Return book to library. +");
                System.out.println("+ 5 - See Issed Books.        +");
                System.out.println("+ 6 - Exit()                  +");
                System.out.println("+++++++++++++++++++++++++++++++");
                System.out.println("  Enter your choice....        ");
            
            
                    int ch=scan.nextInt();
                scan.nextLine();
                switch (ch) {
                    case 1:
                        manager.l.printBookInLib();
                        break;
                    case 2:
                        manager.addNewBooks();
                        break;
                    case 3:
                        manager.issueBooks();
                        break;
                    case 4:
                        manager.returnBooks();
                        break;
                    case 5:
                        manager.l.printBookIssed();;
                        break;
                    case 6:
                        System.out.println("Have A Good Day!");
                        b=false;
                        break;
                    default:
                        System.out.println("Invalid Choice ...");
                        break;
                    }
                }
    
            }
            catch(Exception e){
                System.out.println(e);
                
            }
   
        
    }
}
