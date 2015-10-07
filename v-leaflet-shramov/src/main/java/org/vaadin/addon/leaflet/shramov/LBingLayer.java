package org.vaadin.addon.leaflet.shramov;

import com.vividsolutions.jts.geom.Geometry;
import org.vaadin.addon.leaflet.AbstractLeafletLayer;
import org.vaadin.addon.leaflet.shramov.client.LeafletBingLayerState;

public class LBingLayer extends AbstractLeafletLayer {

    public enum Type {
        AERIAL, ROAD, BIRDSEYE, AERIALWITHLABELS
    }

    private Type type = Type.ROAD;
    private String key;

	public LBingLayer(String key) {
		this.key = key;
	}

	public LBingLayer(String key, Type type) {
		this(key);
        this.type = type;
	}

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
        markAsDirty();
    }

    @Override
    public void beforeClientResponse(boolean initial) {
        getState().layertype = type.toString();
        getState().key = key;
        super.beforeClientResponse(initial);
    }
	@Override
	protected LeafletBingLayerState getState() {
		return (LeafletBingLayerState) super.getState();
	}

	@Override
	public Geometry getGeometry() {		
		return null;
	}
}
