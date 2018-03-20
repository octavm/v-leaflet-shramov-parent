package org.peimari.gleaflet.client.shramov;

import org.peimari.gleaflet.client.TileLayer;
import org.peimari.gleaflet.client.resources.LeafletShramovResourceInjector;

public class BingLayer extends TileLayer {

    static {
        LeafletShramovResourceInjector.ensureInjected();
    }

    public enum Type {
        AERIAL, ROAD, BIRDSEYE
    }

    protected BingLayer() {
    }

    public static native BingLayer create(String key, BingLayerOptions options) /*-{
        return new $wnd.L.BingLayer(key, options);
    }-*/;
}
