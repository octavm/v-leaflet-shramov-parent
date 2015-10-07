package org.peimari.gleaflet.client.shramov;

import com.google.gwt.core.client.JavaScriptObject;

public class BingLayerOptions extends JavaScriptObject {

    protected BingLayerOptions() {
    }

    public static native BingLayerOptions create(String type) /*-{
        return {
            type: type
        };
    }-*/;
}
