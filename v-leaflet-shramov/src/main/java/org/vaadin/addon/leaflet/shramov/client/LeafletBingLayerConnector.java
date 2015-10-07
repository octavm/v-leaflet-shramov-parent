package org.vaadin.addon.leaflet.shramov.client;

import com.vaadin.shared.ui.*;
import org.peimari.gleaflet.client.*;
import org.peimari.gleaflet.client.shramov.BingLayer;
import org.peimari.gleaflet.client.shramov.BingLayerOptions;
import org.vaadin.addon.leaflet.client.AbstractLeafletLayerConnector;
import org.vaadin.addon.leaflet.shramov.LBingLayer;


@Connect(LBingLayer.class)
public class LeafletBingLayerConnector extends AbstractLeafletLayerConnector<BingLayerOptions> {

    public Layer layer;

    @Override
    public LeafletBingLayerState getState() {
        return (LeafletBingLayerState) super.getState();
    }

    @Override
    protected BingLayerOptions createOptions() {
        return BingLayerOptions.create(getState().layertype);
    }

    @Override
    protected void update() {
        if (layer != null) {
            removeLayerFromParent();
        } else {
            BingLayerOptions o = createOptions();
            layer = BingLayer.create(getState().key, o);
        }

        addToParent(layer);
    }

    @Override
    public Layer getLayer() {
        return layer;
    }
}
