package org.vaadin.addon.leaflet.shramov.client;

import com.vaadin.shared.ui.*;
import org.peimari.gleaflet.client.*;
import org.peimari.gleaflet.client.shramov.BingLayer;
import org.peimari.gleaflet.client.shramov.BingLayerOptions;
import org.vaadin.addon.leaflet.client.LeafletTileLayerConnector;
import org.vaadin.addon.leaflet.shramov.LBingLayer;

@Connect(LBingLayer.class)
public class LeafletBingLayerConnector extends LeafletTileLayerConnector {

    @Override
    public LeafletBingLayerState getState() {
        return (LeafletBingLayerState) super.getState();
    }

    @Override
    protected BingLayerOptions createOptions() {
        BingLayerOptions o = super.createOptions().cast();
        LeafletBingLayerState s = getState();
        if (s.layerType != null) {
            o.setType(s.layerType);
        }
        return o;
    }

    @Override
    protected BingLayer createGridLayer(GridLayerOptions o) {
        return BingLayer.create(getState().key, (BingLayerOptions) o);
    }

}
