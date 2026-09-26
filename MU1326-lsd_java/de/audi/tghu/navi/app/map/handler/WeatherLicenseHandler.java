/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.online.IOnlineService;
import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.atip.interapp.online.OnlineServiceListState;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.IMapContent;
import de.audi.tghu.navi.app.map.handler.WeatherLicenseHandler$1;
import de.audi.tghu.navi.app.map.handler.WeatherLicenseHandler$2;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRServiceState;

public class WeatherLicenseHandler
implements IOnlineServiceListener {
    public static final String SERVICE_ID_WEATHER_IN_MAP;
    public static final int APP_STATE_UNKNOWN;
    public static final int APP_STATE_DISABLED;
    public static final int APP_STATE_ENABLED;
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    protected IOnlineService service;
    protected final IFrameworkAccess framework;
    private ICommandListFactory commandListFactory;
    protected int appState = -1;
    protected IMapContent mapContentHandlerMain;
    private IMapContent mapContentHandlerKombi;

    public WeatherLicenseHandler(NavigationEnv navigationEnv, IMapContent iMapContent, IMapContent iMapContent2, ICommandListFactory iCommandListFactory, LogChannel logChannel) {
        this.env = navigationEnv;
        this.logChannel = logChannel;
        this.framework = navigationEnv.getFramework();
        this.mapContentHandlerMain = iMapContent;
        this.mapContentHandlerKombi = iMapContent2;
        this.commandListFactory = iCommandListFactory;
        this.init();
    }

    private void init() {
        this.setMapContentStatus(false);
    }

    @Override
    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
        if (oSRApplication != null) {
            int n = oSRApplication.getState();
            this.logChannel.log(-2137614336, "WeatherLicenseHandler#getOnlineApplicationResponse() - state: %1 ", (long)n);
            boolean bl = this.matchAppState(n);
            this.setMapContentStatus(true);
            if (bl) {
                this.appState = 1;
                try {
                    boolean bl2 = this.mapContentHandlerMain.isWeatherInMapSelected();
                    boolean bl3 = this.mapContentHandlerKombi.isWeatherInMapSelected();
                    if (!bl2 && !bl3) {
                        this.logChannel.log(-1601830656, "WeatherLicenseHandler#getOnlineApplicationResponse() - app state enabled but all weather checkboxes are unchecked => disable service ");
                        this.disableWeatherInMapApp();
                    }
                }
                catch (Exception exception) {
                    this.logChannel.log(-2137614336, "WeatherLicenseHandler#getOnlineApplicationResponse() - ERROR=%1", (Throwable)exception);
                }
            } else {
                this.appState = 0;
                this.disableWeatherInMapContentItems();
            }
        } else {
            this.logChannel.log(-1601830656, "WeatherLicenseHandler#getOnlineApplicationResponse() - app is null! ");
        }
    }

    @Override
    public void activateLicenseResponse(int n) {
        this.logChannel.log(-2137614336, "WeatherLicenseHandler#activateLicenseResponse() - not implemented ");
    }

    @Override
    public void getLicenseInformationResult(OSRLicense[] oSRLicenseArray) {
        this.logChannel.log(-2137614336, "WeatherLicenseHandler#getLicenseInformationResult() - got %1 licenses ", oSRLicenseArray == null ? 0L : (long)oSRLicenseArray.length);
    }

    @Override
    public void getReminderStatusResult(int n) {
        this.logChannel.log(-2137614336, "WeatherLicenseHandler#getReminderStatusResult() - not implemented ");
    }

    @Override
    public void setReminderStateResponse(int n) {
        this.logChannel.log(-2137614336, "WeatherLicenseHandler#setReminderStateResponse() - not implemented ");
    }

    @Override
    public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray) {
        this.logChannel.log(1078071040, "WeatherLicenseHandler#updateApplicationState() - props.length: %1 ", (long)(oSRNotifyPropertiesArray != null ? oSRNotifyPropertiesArray.length : -1));
        if (oSRNotifyPropertiesArray != null && this.logChannel.isDebug()) {
            for (int i2 = 0; i2 < oSRNotifyPropertiesArray.length; ++i2) {
                this.logChannel.log(-2137614336, "WeatherLicenseHandler#updateApplicationState() - props[%1] - priority: %2 reason: %3 ", (long)i2, (long)oSRNotifyPropertiesArray[i2].getPriority(), (long)oSRNotifyPropertiesArray[i2].getReason());
            }
        }
    }

    public void updateApplicationState(int n, int n2) {
        boolean bl;
        this.logChannel.log(1078071040, "WeatherLicenseHandler#updateApplicationState() - priority: %1 reason: %2", (long)n, (long)n2);
        if (n == 2) {
            switch (n2) {
                case 1: 
                case 2: {
                    this.logChannel.log(1078071040, "WeatherLicenseHandler#updateApplicationState() - no disable reason - ignore ");
                    bl = false;
                    break;
                }
                default: {
                    this.logChannel.log(1078071040, "WeatherLicenseHandler#updateApplicationState() - unknown reason - ignore ");
                    bl = false;
                    break;
                }
            }
        } else if (n == 3) {
            switch (n2) {
                case 1: 
                case 2: 
                case 3: {
                    this.logChannel.log(1078071040, "WeatherLicenseHandler#updateApplicationState() - no disable reason - ignore ");
                    bl = false;
                    break;
                }
                default: {
                    this.logChannel.log(1078071040, "WeatherLicenseHandler#updateApplicationState() - unknown reason - ignore ");
                    bl = false;
                    break;
                }
            }
        } else if (n == 1) {
            switch (n2) {
                case 1: 
                case 2: 
                case 3: {
                    this.logChannel.log(1078071040, "WeatherLicenseHandler#updateApplicationState() - no disable reason - ignore ");
                    bl = false;
                    break;
                }
                default: {
                    this.logChannel.log(1078071040, "WeatherLicenseHandler#updateApplicationState() - unknown reason - ignore ");
                    bl = false;
                    break;
                }
            }
        } else if (n == 4) {
            this.logChannel.log(1078071040, "WeatherLicenseHandler#updateApplicationState() - no disable reason - ignore ");
            bl = false;
        } else {
            this.logChannel.log(1078071040, "WeatherLicenseHandler#updateApplicationState() - unknown priority - ignore ");
            bl = false;
        }
        if (bl) {
            this.disableWeatherInMapApp();
            this.disableWeatherInMapContentItems();
        }
    }

    public void disableWeatherInMapApp() {
        this.logChannel.log(1078071040, "WeatherLicenseHandler#disableWeatherInMapApp() ");
        if (this.service != null) {
            this.logChannel.log(-2137614336, "WeatherLicenseHandler#disableWeatherInMapApp() changing off > calling setOnlineApplicationState(%1) ", 0L);
            try {
                this.disableWeatherSequence(this);
            }
            catch (Exception exception) {
                this.logChannel.log(-2137614336, "WeatherLicenseHandler#disableWeatherInMapApp() - ERROR=%1", (Throwable)exception);
            }
        } else {
            this.logChannel.log(10000, "WeatherLicenseHandler#disableWeatherInMapApp() - no IOnlineService set");
        }
    }

    protected void disableWeatherInMapContentItems() {
        this.logChannel.log(1078071040, "WeatherLicenseHandler#disableWeatherInMapContentItems() ");
        try {
            if (this.mapContentHandlerMain.isWeatherInMapSelected()) {
                this.mapContentHandlerMain.checkWeatherInMap(false, true, true);
            } else {
                this.logChannel.log(-2137614336, "WeatherLicenseHandler#disableWeatherInMapContentItems() - weather in main map not active ");
            }
        }
        catch (Exception exception) {
            this.logChannel.log(1078071040, "WeatherLicenseHandler#disableWeatherInMapContentItems() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.mapContentHandlerKombi.isWeatherInMapSelected()) {
                this.mapContentHandlerKombi.checkWeatherInMap(false, true, true);
            } else {
                this.logChannel.log(-2137614336, "WeatherLicenseHandler#disableWeatherInMapContentItems() - weather in Kombi map not active ");
            }
        }
        catch (Exception exception) {
            this.logChannel.log(1078071040, "WeatherLicenseHandler#disableWeatherInMapContentItems() - ERROR=%1 ", (Throwable)exception);
        }
    }

    public void setService(IOnlineService iOnlineService) {
        this.logChannel.log(-2137614336, "WeatherLicenseHandler#setService() - %1", (Object)iOnlineService);
        this.service = iOnlineService;
        this.appState = -1;
        if (iOnlineService != null) {
            try {
                iOnlineService.addCallBackListener(this);
            }
            catch (Exception exception) {
                this.logChannel.log(-2137614336, "WeatherLicenseHandler#setService() - ERROR=%1", (Throwable)exception);
            }
        } else {
            this.setMapContentStatus(false);
        }
    }

    public void updateLicenceActiveMainMap() {
        this.logChannel.log(1078071040, "WeatherLicenseHandler#updateLicenceActiveMainMap() ");
        this.updateLicenceActive(this.mapContentHandlerMain);
    }

    public void updateLicenceActiveKombiMap() {
        this.logChannel.log(1078071040, "WeatherLicenseHandler#updateLicenceActiveKombiMap() ");
        this.updateLicenceActive(this.mapContentHandlerKombi);
    }

    private void updateLicenceActive(IMapContent iMapContent) {
        this.logChannel.log(1078071040, "WeatherLicenseHandler#updateLicenceActive( %1 ) ", (Object)(iMapContent != null ? iMapContent.getName() : "null"));
    }

    public void deactivateWeather() {
        try {
            boolean bl = this.mapContentHandlerMain.isWeatherInMapSelected();
            boolean bl2 = this.mapContentHandlerKombi.isWeatherInMapSelected();
            this.logChannel.log(1078071040, "WeatherLicenseHandler#deactivateWeather() - isMainSelected: %1, isKombiSelected: %2 ", bl, bl2);
            if (bl || bl2) {
                return;
            }
            this.logChannel.log(1078071040, "WeatherLicenseHandler#deactivateWeather() - changing off > calling setOnlineApplicationState(%1)", 0L);
            this.disableWeatherSequence(this);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "WeatherLicenseHandler#deactivateWeather() - ERROR=%1", (Throwable)exception);
        }
    }

    protected void setMapContentStatus(boolean bl) {
        boolean bl2;
        try {
            bl2 = this.mapContentHandlerMain.isWeatherInMapSelected();
            this.mapContentHandlerMain.checkWeatherInMap(bl2, bl, false);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "WeatherLicenseHandler#setMapContentStatus() - ERROR=%1", (Throwable)exception);
        }
        try {
            bl2 = this.mapContentHandlerKombi.isWeatherInMapSelected();
            this.mapContentHandlerKombi.checkWeatherInMap(bl2, bl, false);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "WeatherLicenseHandler#setMapContentStatus() - ERROR=%1", (Throwable)exception);
        }
    }

    private boolean matchAppState(int n) {
        return (n & 1) != 0;
    }

    public void onWeatherCheckboxSelected(IMapContent iMapContent) {
        this.logChannel.log(1078071040, "WeatherLicenseHandler#onWeatherCheckboxSelected( %1 ) ", (Object)(iMapContent != null ? iMapContent.getName() : "null"));
        try {
            iMapContent.checkWeatherInMap(true, true, true);
        }
        catch (Exception exception) {
            this.logChannel.log(1078071040, "WeatherLicenseHandler#onWeatherCheckboxSelected() - ERROR=%1 ", (Throwable)exception);
        }
        if (this.service != null) {
            this.logChannel.log(-2137614336, "WeatherLicenseHandler#onWeatherCheckboxSelected() - changing on > calling setOnlineApplicationState(%1) ", 1L);
            this.enableWeatherSequence(this, iMapContent, true);
        } else {
            this.logChannel.log(10000, "WeatherLicenseHandler#onWeatherCheckboxSelected() - no IOnlineService set");
        }
    }

    private void enableWeatherSequence(IOnlineServiceListener iOnlineServiceListener, IMapContent iMapContent, boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new WeatherLicenseHandler$1(this, this, "enableWeatherSequence", iOnlineServiceListener, bl, iMapContent));
        commandList.execute("WeatherLicenseHandler#enableWeatherSequence");
    }

    private void disableWeatherSequence(IOnlineServiceListener iOnlineServiceListener) {
        this.logChannel.log(-2137614336, "WeatherLicenseHandler#disableWeatherSequence() - current appState: %1 ", (long)this.appState);
        if (this.appState == 0) {
            return;
        }
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new WeatherLicenseHandler$2(this, this, "disableWeatherSequence", iOnlineServiceListener));
        commandList.execute("WeatherLicenseHandler#disableWeatherSequence");
    }

    @Override
    public void updateServiceState(OnlineServiceListState onlineServiceListState) {
    }

    @Override
    public void getPreCheckResult(OSRServiceState oSRServiceState) {
    }
}

