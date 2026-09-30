/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.online;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storagecache.CacheEventListener;
import de.audi.atip.storagecache.CacheHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;

public class ServiceListHandler
implements CacheEventListener {
    private static final String[] SERVICES = new String[]{"UpdateOverTheAir", "online_metadata_service_app", ServiceListHandler.getSatMapsAppIDForVariant(), "service_dsi_onlinetraffic", "weatherinmaponlineservice", "service_dsi_operatorcall", "service_dsi_destimport", "service_dsi_poi", "dictation"};
    private NavigationEnv env;
    private LogChannel logChannel;
    private CacheHandler cacheHandler;
    private static final int HIDE_SERVICE = 0;
    private static final int SHOW_SERVICE = 1;
    protected static final int LICENSE_STATE_UNKNOWN = -1;

    private static String getSatMapsAppIDForVariant() {
        if (Util.isHURegionJP()) {
            return "awnavicore";
        }
        if (!Util.isHURegionAsia()) {
            return "ebnav";
        }
        return "ebnav";
    }

    public ServiceListHandler(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getMapMainLogChannel();
        this.initModels();
        this.cacheHandler = navigationEnv.getFramework().getCacheHandler();
    }

    private void initModels() {
        this.logChannel.log(1000000, "ServiceListHandler#initModels");
        for (int i2 = 0; i2 < SERVICES.length; ++i2) {
            String[] stringArray = this.getTokens(SERVICES[i2]);
            if (stringArray == null) continue;
            for (int i3 = 0; i3 < stringArray.length; ++i3) {
                this.logChannel.log(1000000, "ServiceListHandler#initModels setting intial visibility of %1:%2 to invisible", (Object)SERVICES[i2], (Object)stringArray[i3]);
                ChoiceModelApp choiceModelApp = this.mapServiceIdToVisibilityModel(SERVICES[i2], stringArray[i3]);
                if (choiceModelApp == null) {
                    this.logChannel.log(10000, "ServiceListHandler#initModels no model for service %1:%2", (Object)SERVICES[i2], (Object)stringArray[i3]);
                    continue;
                }
                choiceModelApp.setValue(0);
                choiceModelApp.setStatus(-1);
            }
        }
    }

    public void init() {
        if (this.cacheHandler != null) {
            this.cacheHandler.addListener(this);
        }
    }

    public String[] getServiceIDs() {
        return SERVICES;
    }

    public final String[] getTokens(String string) {
        if (string.equals("UpdateOverTheAir")) {
            return new String[]{"lic_uota_ppoi", "lic_uota_nav"};
        }
        if (string.equals("service_dsi_operatorcall")) {
            return new String[]{"poicall"};
        }
        if (string.equals("service_dsi_poi")) {
            return new String[]{"poi_haptic"};
        }
        if (string.equals("service_dsi_destimport")) {
            return new String[]{"zieleinspeisung"};
        }
        if (string.equals("service_dsi_onlinetraffic")) {
            return new String[]{"lic_traffic"};
        }
        if (string.equals("service_dsi_satellitemaps")) {
            return new String[]{"satellitemaps"};
        }
        if (string.equals("ebnav")) {
            return new String[]{"satellitemaps_eb"};
        }
        if (string.equals("awnavicore")) {
            return new String[]{"satellitemaps"};
        }
        if (string.equals("weatherinmaponlineservice")) {
            return new String[]{"weatherGrid"};
        }
        if (string.equals("online_metadata_service_app")) {
            return new String[]{"gracenote"};
        }
        if (string.equals("dictation")) {
            return new String[]{"dictation"};
        }
        return null;
    }

    public void updateToken(String string, String string2, Object object) {
        ChoiceModelApp choiceModelApp;
        this.logChannel.log(10000000, "ServiceListHandler#updateToken(%1, %2, %3)", (Object)string, (Object)string2, (Object)object.toString());
        int n = -1;
        if (string == null || string2 == null) {
            this.logChannel.log(1000000, "ServiceListHandler#updateToken() - serviceID or token is NULL -> Ignore Update");
            return;
        }
        if (object != null) {
            try {
                n = (Integer)object;
            }
            catch (ClassCastException classCastException) {
                this.logChannel.log(100000, "ServiceListHandler#updateToken() - Can not cast newValue to int! I'll set it to -1");
            }
        }
        if ((choiceModelApp = this.mapServiceIdToVisibilityModel(string, string2)) == null) {
            this.logChannel.log(100000, "ServiceListHandler#updateToken cannot map service %1 to a visibility model");
            return;
        }
        choiceModelApp.setStatus(n);
        if (n == 3 || n == -1) {
            choiceModelApp.setValue(0);
            this.forceServiceShutDown(string);
        } else {
            choiceModelApp.setValue(1);
        }
        this.notifyGEVisibility(string);
    }

    private ChoiceModelApp mapServiceIdToVisibilityModel(String string, String string2) {
        ChoiceModelApp choiceModelApp;
        if (string.equals("service_dsi_satellitemaps") && string2.equals("satellitemaps")) {
            choiceModelApp = this.env.getChoiceModel(402127);
        } else if (string.equals("ebnav") && string2.equals("satellitemaps_eb")) {
            choiceModelApp = this.env.getChoiceModel(402127);
        } else if (string.equals("service_dsi_onlinetraffic") && string2.equals("lic_traffic")) {
            choiceModelApp = this.env.getChoiceModel(402128);
        } else if (string.equals("weatherinmaponlineservice") && string2.equals("weatherGrid")) {
            choiceModelApp = this.env.getChoiceModel(402129);
        } else if (string.equals("service_dsi_operatorcall") && string2.equals("poicall")) {
            choiceModelApp = this.env.getChoiceModel(402313);
        } else if (string.equals("awnavicore") && string2.equals("satellitemaps")) {
            choiceModelApp = this.env.getChoiceModel(402127);
        } else if (string.equals("service_dsi_destimport") && string2.equals("zieleinspeisung")) {
            choiceModelApp = this.env.getChoiceModel(402314);
        } else if (string.equals("service_trafficlight") && string2.equals("trafficlightsinfo_v1")) {
            choiceModelApp = this.env.getChoiceModel(402455);
        } else if (string.equals("service_dsi_poi") && string2.equals("poi_haptic")) {
            choiceModelApp = this.env.getChoiceModel(401632);
        } else if (string.equals("online_metadata_service_app") && string2.equals("gracenote")) {
            choiceModelApp = this.env.getChoiceModel(4655);
        } else if (string.equals("UpdateOverTheAir")) {
            if (string2.equals("lic_uota_ppoi")) {
                choiceModelApp = this.env.getChoiceModel(4656);
            } else if (string2.equals("lic_uota_nav")) {
                choiceModelApp = this.env.getChoiceModel(4657);
            } else {
                this.logChannel.log(10000, "ServiceListHandler#mapServiceIdToVisibilityModel no defining token given for appID UOTA");
                choiceModelApp = null;
            }
        } else {
            choiceModelApp = string.equals("dictation") && string2.equals("dictation") ? this.env.getChoiceModel(5557) : null;
        }
        return choiceModelApp;
    }

    protected void forceServiceShutDown(String string) {
    }

    protected void notifyGEVisibility(String string) {
    }

    public boolean isGEVisibile() {
        return this.env.getChoiceModel(402127).getValue() == 1;
    }
}

