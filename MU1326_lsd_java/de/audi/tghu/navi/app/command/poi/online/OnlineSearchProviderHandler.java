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
import de.audi.tghu.navi.app.PersistentState;
import de.audi.tghu.navi.app.util.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class OnlineSearchProviderHandler {
    private final String LOGO_MAP_QNX;
    private final String LOGO_MENU_QNX;
    private final String LOGO_SPEECH_QNX;
    private static final String DEFAULT_POI_ONLINE_PROVIDER = "Google";
    private static final String CHINA_POI_ONLINE_PROVIDER = "AutoNavi";
    private static final String DEFAULT_BASE_PATH = "/eso/hmi/lsd/images/AppNavi/";
    private static final String LOGO_MAP_QNX_PERSIST = "/var/app/ols/providericons/logo_map.png";
    private static final String LOGO_MENU_QNX_PERSIST = "/var/app/ols/providericons/logo_menu.png";
    private static final String LOGO_SPEECH_QNX_PERSIST = "/var/app/ols/providericons/logo_speech.png";
    private final NavigationEnv env;
    private OnlineLogoItem logoMenu;
    private OnlineLogoItem logoMap;
    private OnlineLogoItem logoSpeech;
    private final LogChannel logChannel;

    public OnlineSearchProviderHandler(LogChannel logChannel, NavigationEnv navigationEnv, String string) {
        this.logChannel = logChannel;
        this.env = navigationEnv;
        if (!StringUtilities.isNullOrEmpty(string)) {
            this.LOGO_MAP_QNX = string + "logo_map.png";
            this.LOGO_MENU_QNX = string + "logo_menu.png";
            this.LOGO_SPEECH_QNX = string + "logo_speech.png";
        } else if (Util.isHURegionCN()) {
            logChannel.log(10000000, "OnlineSearchProviderHandler#OnlineSearchProviderHandler(): found chinese head unit. Using empty provider logos until the correct ones are downloaded.");
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
        LabelModelApp labelModelApp = this.env.getLabelModel(400590);
        ResourceLocatorModelApp resourceLocatorModelApp = this.env.getResourceLocatorModel(3839);
        LabelModelApp labelModelApp2 = this.env.getLabelModel(400592);
        String string = this.LOGO_MENU_QNX;
        String string2 = this.LOGO_MAP_QNX;
        String string3 = this.LOGO_SPEECH_QNX;
        this.logoMenu = new OnlineLogoItem(this.logChannel, resourceLocatorModelApp, LOGO_MENU_QNX_PERSIST, string, this.env.getFramework());
        this.logoMap = new OnlineLogoItem(this.logChannel, labelModelApp, LOGO_MAP_QNX_PERSIST, string2, this.env.getFramework());
        this.logoSpeech = new OnlineLogoItem(this.logChannel, labelModelApp2, LOGO_SPEECH_QNX_PERSIST, string3, this.env.getFramework());
    }

    private void initProviderName() {
        IStorageAccess iStorageAccess;
        this.logChannel.log(1000000, "OnlineSearchProviderHandler#initProviderName: initializing provider name");
        String string = DEFAULT_POI_ONLINE_PROVIDER;
        if (Util.isHURegionCN()) {
            string = CHINA_POI_ONLINE_PROVIDER;
        }
        if ((iStorageAccess = this.env.getFramework().getStorageMgr()) != null) {
            State state = new State(iStorageAccess, this.logChannel);
            state.readAndDeserialize();
            string = state.getPoiOnlineProvider();
        }
        this.logChannel.log(1000000, "OnlineSearchProviderHandler#initProviderName: provider is '%1' and Region is '%2'. StorageAccess was %3.", (Object)string, (Object)(Util.isHURegionCN() ? "CN" : "Not CN"), (Object)(iStorageAccess == null ? "null" : "not null"));
        this.env.getLabelModel(400627).setText(string);
    }

    public void updateLogos(int n, String string, String string2, String string3, String string4, String string5, String string6) {
        this.logChannel.log(10000000, "OnlineSearchProviderHandler#updateLogos: images are imgUrl %1, mapUrl %2, speechUrl %3", (Object)string, (Object)string3, (Object)string5);
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
        String string2 = this.env.getLabelModel(400627).getText();
        if (string != null && !string.equals(string2)) {
            this.env.getLabelModel(400627).setText(string);
            IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
            if (iStorageAccess != null) {
                State state = new State(iStorageAccess, this.logChannel);
                state.setPoiOnlineProvider(string);
                state.serializeAndWrite();
            }
        }
    }

    public void updateVisibility(int n) {
        this.logChannel.log(1000000, "OnlineSearchProviderHandler#updateVisibility - called to change visibility based on gotoWhere = '%1'", (long)n);
        ResourceLocatorModelApp resourceLocatorModelApp = this.env.getResourceLocatorModel(3839);
        int n2 = resourceLocatorModelApp.getStatus();
        if (n == 0) {
            if (n2 == 2) {
                this.logChannel.log(10000000, "OnlineSearchProviderHandler#updateVisibility - already invisible so doing nothing");
                return;
            }
            this.logoMenu.setVisible(false);
        } else {
            if (n2 == 0) {
                this.logChannel.log(10000000, "OnlineSearchProviderHandler#updateVisibility - already visible so doing nothing");
                return;
            }
            this.logoMenu.setVisible(true);
        }
    }

    public static class State
    extends PersistentState {
        public static final int VERSION = 1;
        public static final int KEY = 890;
        private String poiOnlineProvider;

        public State(IStorageAccess iStorageAccess, LogChannel logChannel) {
            super(iStorageAccess, 1, 1004, 890, logChannel);
        }

        protected void initWithDefaultValues() {
            this.poiOnlineProvider = OnlineSearchProviderHandler.DEFAULT_POI_ONLINE_PROVIDER;
            if (Util.isHURegionCN()) {
                this.poiOnlineProvider = OnlineSearchProviderHandler.CHINA_POI_ONLINE_PROVIDER;
            }
        }

        protected void initFromOldKeys(IStorageAccess iStorageAccess) {
            String string = OnlineSearchProviderHandler.DEFAULT_POI_ONLINE_PROVIDER;
            if (Util.isHURegionCN()) {
                string = OnlineSearchProviderHandler.CHINA_POI_ONLINE_PROVIDER;
            }
            this.poiOnlineProvider = iStorageAccess.getString(1004, 800, string);
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeUTF(this.poiOnlineProvider);
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            this.poiOnlineProvider = dataInputStream.readUTF();
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
            this.getLogChannel().log(10000000, "OnlineSearchService.State#convertContainer( %1, %2 )", (long)n, (long)n2);
            this.initWithDefaultValues();
            try {
                if (n > 0) {
                    this.poiOnlineProvider = dataInputStream.readUTF();
                }
            }
            catch (IOException iOException) {
                this.getLogChannel().log(10000, "OnlineSearchService.State#convertContainer - error on converting the persistent state format", (Throwable)iOException);
            }
        }

        public String getPoiOnlineProvider() {
            return this.poiOnlineProvider;
        }

        public void setPoiOnlineProvider(String string) {
            this.poiOnlineProvider = string;
        }
    }
}

