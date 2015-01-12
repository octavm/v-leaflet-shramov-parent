# Shramov Leaflet plugin wrappers for Vaadin & GWT

This module provides both client (GWT) and server side API for the popular [Shramvov Leaflet extensions](https://github.com/shramov/leaflet-plugins).

Currently the only Google layers are the only implemented features, but more can be easily added. In case you need more features supported, but don't have time or skills to do it, [Vaadin Ltd.](https://vaadin.com) can provide them for you as sponsored development.

Vaadin module depends on [v-leaflet](https://github.com/mstahv/v-leaflet) Vaadin add-on, GWT module depends on [g-leaflet](https://github.com/mstahv/g-leaflet).

Releases can be downloaded via [Vaadin Directory](https://vaadin.com/directory).

### Usage

To use it, you'll need to provide Google Maps JS api to your host page. In it you also must pass in your Google Maps API key. Thus, it is not injected automatically, but you should provide it with e.g. BootstrapListener like this:

```java
@Override
protected void servletInitialized() throws ServletException {
    getService().addSessionInitListener(new SessionInitListener() {
        @Override
        public void sessionInit(SessionInitEvent event)
                throws ServiceException {
            event.getSession().addBootstrapListener(new BootstrapListener() {

                @Override
                public void modifyBootstrapFragment(BootstrapFragmentResponse response) {
                }

                @Override
                public void modifyBootstrapPage(BootstrapPageResponse response) {
                    Element script = response.getDocument().createElement("script");
                    // FOR NON LOCAL TESTING, ADD API KEY!!
                    // script.attr("src", "http://maps.google.com/maps/api/js?key=YOUR-API-KEY-HERE&sensor=false");
                    script.attr("src", "http://maps.google.com/maps/api/js?sensor=false");
                    response.getDocument().getElementsByTag("head").get(0).appendChild(script);
                }
            });

```


### License

Apache 2, but not that the underlaying JS library is licensed with BSD derivative. In any ways, couldn't be more open source than this.

