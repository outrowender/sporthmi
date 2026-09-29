/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.onlinelogo.OnlineLogoItem;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.util.StringUtilities;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.poi.online.OnlineSearchProviderHandler$State;
import de.audi.tghu.navi.app.util.Util;

public class OnlineSearchProviderHandler {
    private final String LOGO_MAP_QNX;
    private final String LOGO_MENU_QNX;
    private final String LOGO_SPEECH_QNX;
    private static final String DEFAULT_POI_ONLINE_PROVIDER;
    private static final String CHINA_POI_ONLINE_PROVIDER;
    private static final String DEFAULT_BASE_PATH;
    private static final String LOGO_MAP_QNX_PERSIST;
    private static final String LOGO_MENU_QNX_PERSIST;
    private static final String LOGO_SPEECH_QNX_PERSIST;
    private final NavigationEnv env;
    private OnlineLogoItem logoMenu;
    private OnlineLogoItem logoMap;
    private OnlineLogoItem logoSpeech;
    private final LogChannel logChannel;

    public OnlineSearchProviderHandler(LogChannel logChannel, NavigationEnv navigationEnv, String string) {
        this.logChannel = logChannel;
        this.env = navigationEnv;
        if (!StringUtilities.isNullOrEmpty(string)) {
            this.LOGO_MAP_QNX = new StringBuffer().append(string).append("logo_map.png").toString();
            this.LOGO_MENU_QNX = new StringBuffer().append(string).append("logo_menu.png").toString();
            this.LOGO_SPEECH_QNX = new StringBuffer().append(string).append("logo_speech.png").toString();
        } else if (Util.isHURegionCN()) {
            logChannel.log(-2137614336, "OnlineSearchProviderHandler#OnlineSearchProviderHandler(): found chinese head unit. Using empty provider logos until the correct ones are downloaded.");
            this.LOGO_MAP_QNX = "";
            this.LOGO_MENU_QNX = "";
            this.LOGO_SPEECH_QNX = "";
        } else {
            this.LOGO_MAP_QNX = "/eso/hmi/lsd/images/AppNavi/logo_map.png";
            this.LOGO_MENU_QNX = "/eso/hmi/lsd/images/AppNavi/logo_menu.png";
            this.LOGO_SPEECH_QNX = "/eso/hmi/lsd/images/AppNavi/logo_speech.png";
        }
        this.initLogos();
        this.initProviderName();
    }

    private void initLogos() {
        LabelModelApp labelModelApp = this.env.getLabelModel(-837024256);
        ResourceLocatorModelApp resourceLocatorModelApp = this.env.getResourceLocatorModel(3839);
        LabelModelApp labelModelApp2 = this.env.getLabelModel(-803469824);
        String string = this.LOGO_MENU_QNX;
        String string2 = this.LOGO_MAP_QNX;
        String string3 = this.LOGO_SPEECH_QNX;
        this.logoMenu = new OnlineLogoItem(this.logChannel, resourceLocatorModelApp, "/var/app/ols/providericons/logo_menu.png", string, this.env.getFramework());
        this.logoMap = new OnlineLogoItem(this.logChannel, labelModelApp, "/var/app/ols/providericons/logo_map.png", string2, this.env.getFramework());
        this.logoSpeech = new OnlineLogoItem(this.logChannel, labelModelApp2, "/var/app/ols/providericons/logo_speech.png", string3, this.env.getFramework());
    }

    private void initProviderName() {
        IStorageAccess iStorageAccess;
        this.logChannel.log(1078071040, "OnlineSearchProviderHandler#initProviderName: initializing provider name");
        String string = "Google";
        if (Util.isHURegionCN()) {
            string = "AutoNavi";
        }
        if ((iStorageAccess = this.env.getFramework().getStorageMgr()) != null) {
            OnlineSearchProviderHandler$State onlineSearchProviderHandler$State = new OnlineSearchProviderHandler$State(iStorageAccess, this.logChannel);
            onlineSearchProviderHandler$State.readAndDeserialize();
            string = onlineSearchProviderHandler$State.getPoiOnlineProvider();
        }
        this.logChannel.log(1078071040, "OnlineSearchProviderHandler#initProviderName: provider is '%1' and Region is '%2'. StorageAccess was %3.", (Object)string, (Object)(Util.isHURegionCN() ? "CN" : "Not CN"), (Object)(iStorageAccess == null ? "null" : "not null"));
        this.env.getLabelModel(-216267264).setText(string);
    }

    public void updateLogos(int n, String string, String string2, String string3, String string4, String string5, String string6) {
        this.logChannel.log(-2137614336, "OnlineSearchProviderHandler#updateLogos: images are imgUrl %1, mapUrl %2, speechUrl %3", (Object)string, (Object)string3, (Object)string5);
        if (n == 0) {
            if (this.logoMenu != null) {
                this.logoMenu.update(string, string2);
            }
            if (this.logoMap != null) {
                this.logoMap.update(string3, string4);
            }
        } else if (n == 1 && this.logoSpeech != null) {
            this.logoSpeech.update(string5, string6);
        }
    }

    public void updateProviderName(String string) {
        String string2 = this.env.getLabelModel(-216267264).getText();
        if (string != null && !string.equals(string2)) {
            this.env.getLabelModel(-216267264).setText(string);
            IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
            if (iStorageAccess != null) {
                OnlineSearchProviderHandler$State onlineSearchProviderHandler$State = new OnlineSearchProviderHandler$State(iStorageAccess, this.logChannel);
                onlineSearchProviderHandler$State.setPoiOnlineProvider(string);
                onlineSearchProviderHandler$State.serializeAndWrite();
            }
        }
    }

    public void updateVisibility(int n) {
        this.logChannel.log(1078071040, "OnlineSearchProviderHandler#updateVisibility - called to change visibility based on gotoWhere = '%1'", (long)n);
        ResourceLocatorModelApp resourceLocatorModelApp = this.env.getResourceLocatorModel(3839);
        int n2 = resourceLocatorModelApp.getStatus();
        if (n == 0) {
            if (n2 == 2) {
                this.logChannel.log(-2137614336, "OnlineSearchProviderHandler#updateVisibility - already invisible so doing nothing");
                return;
            }
            this.logoMenu.setVisible(false);
        } else {
            if (n2 == 0) {
                this.logChannel.log(-2137614336, "OnlineSearchProviderHandler#updateVisibility - already visible so doing nothing");
                return;
            }
            this.logoMenu.setVisible(true);
        }
    }
}

