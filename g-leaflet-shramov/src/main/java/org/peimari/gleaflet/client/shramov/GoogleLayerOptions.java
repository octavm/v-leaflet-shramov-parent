package org.peimari.gleaflet.client.shramov;

import com.google.gwt.core.client.JavaScriptObject;

public class GoogleLayerOptions extends JavaScriptObject {

// TODO
//    	options: {
//		minZoom: 0,
//		maxZoom: 18,
//		tileSize: 256,
//		subdomains: 'abc',
//		errorTileUrl: '',
//		attribution: '',
//		opacity: 1,
//		continuousWorld: false,
//		noWrap: false,
//		mapOptions: {
//			backgroundColor: '#dddddd'
//		}
//	}

    protected GoogleLayerOptions() {
    }

    public static GoogleLayerOptions create(){
        return (GoogleLayerOptions) JavaScriptObject.createObject();
    };

}
