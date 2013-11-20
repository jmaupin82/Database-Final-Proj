package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DBModel 
{
    /** List of registered ActionListeners. */
    private ArrayList<ActionListener> actionListenerList = new ArrayList<ActionListener>();
    
    
    public DBModel()
    {
	
    }
    
    
    
    /**
     * Adds a new ActionListener for notifying views
     * 
     * @param al
     */
    public void addActionListener( ActionListener al ) {
	if (actionListenerList == null)
	    actionListenerList = new ArrayList<ActionListener>();
	actionListenerList.add( al );
    }

    /**
     * Removes the <code>al</code> from the listener list
     * 
     * @param al
     */
    public void removeActionListener( ActionListener al ) {
	if (actionListenerList != null && actionListenerList.contains( al ))
	    actionListenerList.remove( al );
    }

    /**
     * ProcessEvent to notify the registered views 
     * @param e
     */
    @SuppressWarnings("unused")
    private void processEvent( ActionEvent e ) {
	ArrayList<ActionListener> list;

	synchronized (this) {
	    if (actionListenerList == null)
		return;
	    list = new ArrayList<ActionListener>();
	    list.addAll( actionListenerList );
	}

	for (int i = 0; i < list.size(); i++) {
	    ActionListener listener = list.get( i );
	    listener.actionPerformed( e );
	}
    }

}
