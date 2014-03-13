package org.vaadin.addon.leaflet.shramov.client;

import com.google.gwt.core.client.EntryPoint;
import org.peimari.gleaflet.client.resources.LeafletShramovResourceInjector;

public class EagerShramovLoader implements EntryPoint {

    @Override
    public void onModuleLoad() {
        LeafletShramovResourceInjector.ensureInjected();
    }

}
