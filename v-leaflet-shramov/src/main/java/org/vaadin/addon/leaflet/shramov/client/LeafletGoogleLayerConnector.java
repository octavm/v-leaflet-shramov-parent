package org.vaadin.addon.leaflet.shramov.client;

import com.vaadin.shared.ui.Connect;
import org.peimari.gleaflet.client.Layer;
import org.peimari.gleaflet.client.shramov.GoogleLayer;
import org.peimari.gleaflet.client.shramov.GoogleLayerOptions;
import org.vaadin.addon.leaflet.client.AbstractLeafletLayerConnector;

@Connect(org.vaadin.addon.leaflet.shramov.LGoogleLayer.class)
public class LeafletGoogleLayerConnector extends
		AbstractLeafletLayerConnector<GoogleLayerOptions> {

	protected Layer layer;

	@Override
	public LeafletGoogleLayerState getState() {
		return (LeafletGoogleLayerState) super.getState();
	}

	@Override
	protected GoogleLayerOptions createOptions() {
		GoogleLayerOptions o = GoogleLayerOptions.create();
		LeafletGoogleLayerState s = getState();
        // TODO add config
		return o;
	}

	@Override
	protected void update() {
		if (layer != null) {
			removeLayerFromParent();
		} else {
			GoogleLayerOptions o = createOptions();
			layer = GoogleLayer.create(getState().layertype, o);
		}
		
		addToParent(layer);
	}

	@Override
	public Layer getLayer() {
		return layer;
	}
}
