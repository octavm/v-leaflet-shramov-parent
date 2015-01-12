package org.vaadin.addon.leaflet.shramov;

import com.vividsolutions.jts.geom.Geometry;
import org.vaadin.addon.leaflet.AbstractLeafletLayer;
import org.vaadin.addon.leaflet.shramov.client.LeafletGoogleLayerState;

/**
 * Provides Google Maps layers.
 * 
 * To use this addon, you'll need to provide Google Maps JS api to your host page. 
 * In it you also must pass in your Google Maps API key. 
 * Thus, it is not injected automatically, but you should provide it with the BootstrapListener 
 * (see readme file for more an example)
 * 
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
