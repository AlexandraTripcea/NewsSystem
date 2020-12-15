import com.google.common.eventbus.EventBus;

import events.EventContainer;
import listener.Editor;
import listener.EventListener;
import listener.Reader;
import logic.Action;
import logic.EventBusManager;

public class Main {

	public static void main(String[] args) {
		EventBus eventBus = EventBusManager.getInstance();

	    Reader codrin = new Reader("sport", Action.MODIFY);
	    Editor ale = new Editor();

	    eventBus.register(codrin);
	    eventBus.register(ale);
	    
	    ale.createArticle();
	    ale.modifyArticle("About sport");

//	    
//	    Reader walter = new Reader("sport", Action.READ);
//	    Reader mihai = new Reader("sport", Action.READ);
//	    
//	    eventBus.register(walter);
//	    eventBus.register(mihai);

//	    walter.read("About sport");
//	    mihai.read("About sport");
//	    
	}
}
