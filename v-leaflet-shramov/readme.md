# Shramov Leaflet plugin wrappers for Vaadin

This module provides Vaadin wrappers for "Shramov" Leaflet extensions. Depends on v-leaflet project.

[Leaflet plugins by Pavel Shramov](https://github.com/shramov/leaflet-plugins/)

Currently this wrapper only supports Google maps layer. To use it, you'll need to provide Google Maps JS api to your host page. In it you also must pass in your Google Maps API key. Thus, it is not injected automatically, but you should provide it with e.g. BootstrapListener like this: 

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
