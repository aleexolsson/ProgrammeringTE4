
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A simple model of a doc server. The server is able to receive
 * doc items for storage, and deliver them to clients on demand.
 *
 * @author Alex Olsson
 * @version 2022.12.13
 */
public class DocServer
{
    // Storage for the arbitrary number of doc items to be stored
    // on the server.
    private List<DocItem> items;

    /**
     * Construct a doc server.
     */
    public DocServer()
    {
        items = new ArrayList<>();
    }

    /**
     * Return how many doc items are waiting for a user.
     * @param who The user to check for.
     * @return How many items are waiting.
     */
    public int howManyDocItems(String who)
    {
        int count = 0;
        for(DocItem item : items) {
            if(item.getTo().equals(who)) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Return the next doc item for a user or null if there
     * are none.
     * @param who The user requesting their next item.
     * @return The user's next item.
     */
    public DocItem getNextDocItem()
    {
        if (items.size() > 0)
        {
            DocItem item = items.remove(0);
            return item;
        }
        return null;
    }
    
    /**
     * Add the given doc item to the message list.
     * @param item The doc item to be stored on the server.
     */
    public void post(DocItem item)
    {
        items.add(item);
    }
}
