package org.vaadin.addon.leaflet.demoandtestapp;

import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import org.vaadin.addon.leaflet.AbstractLeafletLayer;
import org.vaadin.addon.leaflet.LMap;
import org.vaadin.addon.leaflet.LMarker;
import org.vaadin.addon.leaflet.LeafletClickEvent;
import org.vaadin.addon.leaflet.LeafletClickListener;
import org.vaadin.addon.leaflet.LeafletMoveEndEvent;
import org.vaadin.addon.leaflet.LeafletMoveEndListener;
import org.vaadin.addon.leaflet.demoandtestapp.util.AbstractTest;
import org.vaadin.addon.leaflet.shared.Bounds;
import org.vaadin.addon.leaflet.shramov.LBingLayer;

// 
public class BasicTestWithBingLayer extends AbstractTest {

	@Override
	public String getDescription() {
		return "A simple test for Bing map layer";
	}

	LeafletClickListener listener = new LeafletClickListener() {

		@Override
		public void onClick(LeafletClickEvent event) {
			if (event.getPoint() != null) {
				Notification.show(String.format("Clicked %s @ %.4f,%.4f", event
						.getConnector().getClass().getSimpleName(), event
						.getPoint().getLat(), event.getPoint().getLon()));

			} else {
				Notification.show(String.format("Clicked %s", event
						.getConnector().getClass().getSimpleName()));
			}
		}
	};
	private LMap leafletMap;

	@Override
	public Component getTestComponent() {
		leafletMap = new LMap();
		leafletMap.setCenter(60.4525, 22.301);
		leafletMap.setZoomLevel(15);

        leafletMap.addBaseLayer(new LBingLayer("your-own-api-key-here"), "Bing maps layer");
  
		leafletMap.addClickListener(listener);

		leafletMap.addMoveEndListener(new LeafletMoveEndListener() {
			@Override
			public void onMoveEnd(LeafletMoveEndEvent event) {
				Bounds b = event.getBounds();
				Notification.show(
						String.format("New viewport (%.4f,%.4f ; %.4f,%.4f)",
								b.getSouthWestLat(), b.getSouthWestLon(),
								b.getNorthEastLat(), b.getNorthEastLon()),
						Type.TRAY_NOTIFICATION);
			}
		});

		return leafletMap;
	}

}
