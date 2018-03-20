package org.peimari.gleaflet.client.shramov;

import org.peimari.gleaflet.client.TileLayerOptions;

public class BingLayerOptions extends TileLayerOptions {

    protected BingLayerOptions() {
    }

    public static native BingLayerOptions create()
	/*-{
		return {};
	}-*/;

    public native final void setType(String type)
    /*-{
		this.type = type;
	}-*/;
}
