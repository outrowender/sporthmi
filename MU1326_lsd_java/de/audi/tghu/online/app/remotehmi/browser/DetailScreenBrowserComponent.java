/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.browser;

import de.audi.atip.browser.IBrowserHandler;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.operatorcall.handler.DetailBrowserCallbackHandler;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.browser.RemoteHMIBrowserComponent;

public class DetailScreenBrowserComponent
extends RemoteHMIBrowserComponent {
    public static final String URL_PREFIX = "file://";
    public static final String EXTURL_PREFIX = "http://";
    public static final String EXTURL_PREFIX_SECURE = "https://";
    private boolean visible;
    private IBrowserHandler browserPOIHandler;
    private String poiUrl;
    private boolean deleteCache;
    private boolean browsersSuspended;
    private boolean initialized;

    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        logChannel.log(1000000, "DetailScreenBrowser#init()");
        super.init(logChannel, remoteHMIService);
        this.initialized = true;
    }

    public boolean isInited() {
        return this.initialized;
    }

    public void setBrowserHandler(IBrowserHandler iBrowserHandler) {
        ChoiceModelApp choiceModelApp;
        ChoiceModelApp choiceModelApp2;
        ChoiceModelApp choiceModelApp3;
        VirtualButtonModelApp virtualButtonModelApp;
        int n;
        if (iBrowserHandler != null) {
            this.logChannel.log(10000000, "DetailScreenBrowser#setBrowserHandler() INSTANCE_REMOTEHMI");
            n = 7;
            virtualButtonModelApp = this.getModelBank().getVirtualButtonModel(402752);
            choiceModelApp3 = this.getModelBank().getChoiceModel(402755);
            choiceModelApp2 = this.getModelBank().getChoiceModel(402757);
            choiceModelApp = this.getModelBank().getChoiceModel(402754);
            if (choiceModelApp != null) {
                choiceModelApp.setValue(1);
            }
        } else {
            this.logChannel.log(100000, "DetailScreenBrowser#setBrowserHandler() - unknown instance: %1", (Object)iBrowserHandler);
            this.browserPOIHandler = null;
            return;
        }
        this.browserPOIHandler = iBrowserHandler;
        this.browserPOIHandler.setBrowserCallbackHandler(new DetailBrowserCallbackHandler(this.remoteHmiService, this.logChannel));
        this.browserPOIHandler.initialize(virtualButtonModelApp, choiceModelApp3, choiceModelApp2, choiceModelApp, null, n);
        this.browserPOIHandler.setBrowserSyncModel(choiceModelApp2);
    }

    public boolean loadURL(int n, String string, boolean bl) {
        if (n != 5) {
            this.logChannel.log(100000, "DetailScreenBrowser#loadURL( %1 ) Instance %2 is not processed by detail screen browser", (Object)string, (long)n);
        }
        this.logChannel.log(10000000, "DetailScreenBrowser#loadURL( %1 ) Instance %2", (Object)string, (long)n);
        this.poiUrl = string;
        this.logChannel.log(10000000, "DetailScreenBrowser#loadURL bufferedURL:  %1 ", (Object)this.poiUrl);
        this.deleteCache = bl;
        if (this.browserPOIHandler == null) {
            this.logChannel.log(10000, "DetailScreenBrowser#loadURL() - browser not ready [browserHandler[%1] == null]!", (long)n);
            return false;
        }
        this.browserVisible(true);
        this.browserPOIHandler.getBrowserCallBackHandler().updateBrowserStateBusy(true);
        return true;
    }

    public void browserVisible(boolean bl) {
        this.logChannel.log(10000000, "DetailScreenBrowser#browserVisible( %1)", bl);
        if (this.browserPOIHandler == null) {
            this.logChannel.log(10000, "DetailScreenBrowser#browserVisible() - POI detail browser not ready [browserHandler == null]!");
            return;
        }
        this.visible = bl;
        if (bl) {
            if (this.browsersSuspended) {
                this.logChannel.log(10000000, "DetailScreenBrowser#browserVisible() - resuming POI detail browser");
                this.browserPOIHandler.resumeBrowser();
                this.browsersSuspended = false;
                if (this.poiUrl != null && this.poiUrl.length() != 0) {
                    this.browserPOIHandler.loadUrl(this.poiUrl, this.deleteCache);
                    this.poiUrl = null;
                } else if (this.browserPOIHandler.getBrowserSyncModel() != null) {
                    String string = this.browserPOIHandler.getLastActiveUrl();
                    if (this.browserPOIHandler.getBrowserSyncModel().getStatus() == 2 && string != null && string.length() > 0) {
                        this.logChannel.log(10000000, "DetailScreenBrowser#browserVisible() - last state was error, loading last URL again. %1", (Object)string);
                        this.browserPOIHandler.loadUrl(string, false);
                    }
                }
            } else {
                if (this.poiUrl != null && this.poiUrl.length() != 0) {
                    this.logChannel.log(10000000, "DetailScreenBrowser#browserVisible() - startBrowser( %1 ) - buffer set", (Object)this.poiUrl);
                    this.browserPOIHandler.loadUrl(this.poiUrl, this.deleteCache);
                    this.poiUrl = null;
                } else {
                    this.logChannel.log(10000000, "DetailScreenBrowser#browserVisible() - startBrowser( ) - enter by history");
                    this.browserPOIHandler.loadUrl(null, false);
                }
                this.deleteCache = false;
            }
        } else {
            this.logChannel.log(10000000, "DetailScreenBrowser#browserVisible() - stopBrowser() ");
            this.browserPOIHandler.suspendBrowser();
            this.browsersSuspended = true;
        }
    }

    public void onExit() {
        this.logChannel.log(10000000, "DetailScreenBrowser#onExit() called set empty page on browser and suspend it.");
        this.loadURL(5, null, true);
        this.browserVisible(false);
    }
}

