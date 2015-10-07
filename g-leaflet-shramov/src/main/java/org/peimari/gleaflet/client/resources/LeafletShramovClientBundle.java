package org.peimari.gleaflet.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface LeafletShramovClientBundle extends ClientBundle {
 
    @Source("Google.js")
    TextResource google();

    @Source("Bing.js")
    TextResource bing();
    
}
