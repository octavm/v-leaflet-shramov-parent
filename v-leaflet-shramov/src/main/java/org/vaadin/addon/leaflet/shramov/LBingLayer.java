package org.vaadin.addon.leaflet.shramov;

import org.vaadin.addon.leaflet.LTileLayer;
import org.vaadin.addon.leaflet.shramov.client.LeafletBingLayerState;

public class LBingLayer extends LTileLayer {

    public enum Type {
        Road, Aerial, AerialWithLabels, CanvasDark, CanvasLight, CanvasGray
    }

	public LBingLayer(String key) {
		this(key, Type.Road);
	}

	public LBingLayer(String key, Type type) {
		getState().key = key;
		getState().layerType = type.toString();
	}

    public Type getType() {
        return Type.valueOf(getState().layerType);
    }

    public void setType(Type type) {
        getState().layerType = type.toString();
        markAsDirty();
    }

	@Override
	protected LeafletBingLayerState getState() {
		return (LeafletBingLayerState) super.getState();
	}
}
