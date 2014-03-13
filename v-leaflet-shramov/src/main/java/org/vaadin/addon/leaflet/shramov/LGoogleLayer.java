package org.vaadin.addon.leaflet.shramov;

import com.vividsolutions.jts.geom.Geometry;
import org.vaadin.addon.leaflet.AbstractLeafletLayer;
import org.vaadin.addon.leaflet.shramov.client.LeafletGoogleLayerState;

/**
 * Provides Google Maps layers.
 * 
 * Note, that to use the add-on, one must also add google maps API (v3) to the 
 * "host page". A simple method to achieve this is using @JavaScript annotation.
 * Default is not added to this component as you should provide your own API key
 * to the url. See Google maps docs for more details.
 * 
 * Example (without API key, for local testing)
 * @JavaScript("http://maps.google.com/maps/api/js?v=3.2&amp;sensor=false")
 * 
 * @author mattitahvonenitmill
 */
public class LGoogleLayer extends AbstractLeafletLayer {
    public enum Type {
        SATELLITE, ROADMAP, HYBRID, TERRAIN
    }

    private Type type = Type.ROADMAP;

	public LGoogleLayer() {
	}

	public LGoogleLayer(Type type) {
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
        super.beforeClientResponse(initial);
    }
	@Override
	protected LeafletGoogleLayerState getState() {
		return (LeafletGoogleLayerState) super.getState();
	}

	@Override
	public Geometry getGeometry() {
		return null;
	}
}
