/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.browser.EfiUrlHandler;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationBrowser;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class NaviMapConnector
implements EfiUrlHandler {
    private final NavigationEnv env;
    private LogChannel logChannel;
    private NavLocation mapDestination;
    private String url;
    private NavigationBrowser browser;
    private int browserInstance;
    private boolean mapFreeze;
    private final MapInterface mapInterface;

    public NaviMapConnector(NavigationEnv navigationEnv, NavigationBrowser navigationBrowser, MapInterface mapInterface) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
        this.browser = navigationBrowser;
        this.mapInterface = mapInterface;
        navigationBrowser.registerEfiUrlHandler(this, 4);
    }

    public void showMapDestination(NavLocation navLocation, String string) {
        int n;
        this.logChannel.log(10000000, "NaviMapConnector#showMapDestination( %1, %2 )", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)string);
        this.mapDestination = navLocation;
        if (Util.isEmpty(string)) {
            this.url = LocationFormatter.getURLAddress(navLocation);
            this.browserInstance = 2;
            n = Util.isEmpty(this.url) ? 0 : 1;
        } else {
            this.url = string;
            this.browserInstance = 4;
            n = 1;
        }
        Util.setModelStatus(this.env.getButtonModel(400466), n);
        if (n == 1) {
            this.browser.loadURL(this.browserInstance, this.url, true);
        }
    }

    public NavLocation getMapDestination() {
        return this.mapDestination;
    }

    public void setMapFreeze(boolean bl) {
        this.mapFreeze = bl;
    }

    public boolean isMapFrozen() {
        return this.mapFreeze;
    }

    public boolean goBack() {
        this.logChannel.log(10000000, "NaviMapConnector#()goBack");
        return true;
    }

    public boolean goForward() {
        this.logChannel.log(10000000, "NaviMapConnector#goForward()");
        return true;
    }

    public void gotoHomeURL() {
    }

    public void showSpeller(String string, String string2, String string3, boolean bl, short s) {
    }

    public void updateActiveUrl(String string) {
    }

    public byte updateEfiUrl(String string) {
        return 1;
    }
}

