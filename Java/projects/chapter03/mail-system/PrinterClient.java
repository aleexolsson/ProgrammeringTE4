
/**
 * Write a description of class PrinterClient here.
 *
 * @author Alex Olsson
 * @version 2022.12.13
 */
public class PrinterClient
{
    // The server used for sending and receiving.
    private DocServer server;
    // The user running this client.
    //private String user;

    /**
     * Constructor for objects of class PrinterClient
     */
    public PrinterClient(DocServer server)//, String user)
    {
        this.server = server;
        //this.user = user;
    }

    /**
     * Return the next doc item (if any) for this user.
     */
    public DocItem getNextDocItem()
    {
        return server.getNextDocItem();//user);
    }
    
    /**
     * Print the next doc item (if any) for this user to the text 
     * terminal.
     */
    public void printNextDocItem()
    {
        DocItem item = server.getNextDocItem();
        if(item == null) {
            System.out.println("No new document");
        }
        else {
            item.print();
        }
    }
    
    
}
