package org.peimari.gleaflet.client.shramov;

import org.peimari.gleaflet.client.Layer;
import org.peimari.gleaflet.client.resources.LeafletShramovResourceInjector;

/**
 * Note, that to use this feature, one must somehow add Google Maps scripts to 
 * the host page.
 * 
 * @author mattitahvonen
 */
public class GoogleLayer extends Layer {
    
    static {
        LeafletShramovResourceInjector.ensureInjected();
    }
    
    public enum Type {
        SATELLITE, ROADMAP, HYBRID, TERRAIN
    }

    protected GoogleLayer() {
    }

    public static GoogleLayer create(Type type, GoogleLayerOptions options) {
        return create(type.toString(), options);
    }

    public static native GoogleLayer create(String type, GoogleLayerOptions options) /*-{
     return new $wnd.L.Google(type, options);
    }-*/;

}
