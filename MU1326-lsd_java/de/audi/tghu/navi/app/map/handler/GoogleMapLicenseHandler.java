/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.online.IOnlineService;
import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.atip.interapp.online.OnlineServiceListState;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.IGoogleMapLicenseService;
import de.audi.tghu.navi.app.map.handler.GoogleMapLicensePersistenceHelper;
import de.audi.tghu.navi.app.map.handler.ISetupHandler;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRServiceState;

public class GoogleMapLicenseHandler
implements IOnlineServiceListener {
    public static final String SERVICE_ID_SATELLITE_MAPS = Util.isHURegionJP() ? "awnavicore" : "ebnav";
    public static final int GE_LICENSE_STATE_UNKNOWN;
    public static final int GE_LICENSE_STATE_INVALID;
    public static final int GE_LICENSE_STATE_VALID;
    public static final int APP_STATE_UNKNOWN;
    public static final int APP_STATE_DISABLED;
    public static final int APP_STATE_ENABLED;
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    private IOnlineService service;
    protected final IFrameworkAccess framework;
    private int persistedLicenseState;
    private GoogleMapLicensePersistenceHelper googleMapLicensePersistenceHelper;
    private IGoogleMapLicenseService googleMapService;
    private int appState = -1;
    private int desiredState = -1;
    private final ISetupHandler setupHandler;

    public static boolean isValidGoogleMapLicenseState(int n) {
        switch (n) {
            case -1: 
            case 0: 
            case 1: {
                return true;
            }
        }
        return false;
    }

    public GoogleMapLicenseHandler(NavigationEnv navigationEnv, IGoogleMapLicenseService iGoogleMapLicenseService, LogChannel logChannel, ISetupHandler iSetupHandler) {
        this.env = navigationEnv;
        this.logChannel = logChannel;
        this.framework = navigationEnv.getFramework();
        this.googleMapService = iGoogleMapLicenseService;
        this.googleMapLicensePersistenceHelper = new GoogleMapLicensePersistenceHelper(navigationEnv, 987, logChannel);
        this.setupHandler = iSetupHandler;
        this.init();
    }

    private void init() {
        int n = this.googleMapLicensePersistenceHelper.loadState();
        this.setPersistedLicenseState(n, false);
    }

    public void setService(IOnlineService iOnlineService) {
        this.logChannel.log(-2137614336, "GoogleMapLicenseHandler#setService() - %1", (Object)iOnlineService);
        this.service = iOnlineService;
        this.appState = -1;
        if (iOnlineService != null) {
            try {
                iOnlineService.addCallBackListener(this);
            }
            catch (Exception exception) {
                this.logChannel.log(-2137614336, "GoogleMapLicenseHandler#setService() - ERROR=%1", (Throwable)exception);
            }
            if (this.desiredState == 1) {
                this.logChannel.log(-2137614336, "GoogleMapLicenseHandler#setService() - service was not available, desiredState was %1 - setting app active", (long)this.desiredState);
                this.setGoogleMapActive(true);
                this.desiredState = -1;
            } else if (this.desiredState == 0) {
                this.logChannel.log(-2137614336, "GoogleMapLicenseHandler#setService() - service was not available, desiredState was %1 - setting app inactive", (long)this.desiredState);
                this.setGoogleMapActive(false);
                this.desiredState = -1;
            } else {
                this.logChannel.log(-2137614336, "GoogleMapLicenseHandler#setService() - prevoius app state undefined - do nothing");
                if (this.setupHandler.getMapRepresentation() == 1) {
                    this.setGoogleMapActive(true);
                } else {
                    this.setGoogleMapActive(false);
                }
            }
        }
    }

    public int getPersistedLicenseState() {
        return this.persistedLicenseState;
    }

    private boolean getSkipLicenseCheckFlag() {
        return Boolean.getBoolean("SkipLicenseCheck") || Boolean.getBoolean(new StringBuffer().append("SkipLicenseCheck.").append(SERVICE_ID_SATELLITE_MAPS).toString());
    }

    private void setPersistedLicenseState(int n, boolean bl) {
        boolean bl2 = this.getSkipLicenseCheckFlag();
        this.logChannel.log(-2137614336, "GoogleMapLicenseHandler#setPersistedLicenseState( %2 ) - skipLicenseCheck: %1 ", bl2, (long)n);
        if (GoogleMapLicenseHandler.isValidGoogleMapLicenseState(n)) {
            if (bl2) {
                n = 1;
            }
            this.persistedLicenseState = n;
            if (bl) {
                this.googleMapLicensePersistenceHelper.persistState(n);
            }
            if (n == 1) {
                this.env.getChoiceModel(119604736).setValue(1);
            } else {
                this.env.getChoiceModel(119604736).setValue(0);
            }
        } else {
            this.logChannel.log(10000, "GoogleMapLicenseHandler#setPersistedLicenseState() - invalid state: %1, ignore ", (long)n);
        }
    }

    public void setGoogleMapLicenseValid() {
        this.logChannel.log(-2137614336, "GoogleMapLicenseHandler#setGoogleMapLicenseValid() ");
        this.setPersistedLicenseState(1, true);
    }

    public void setGoogleMapActive(boolean bl) {
        int n;
        this.logChannel.log(-2137614336, "GoogleMapLicenseHandler#setGoogleMapActive(%1) - current appState: %2 ", bl, (long)this.appState);
        if (!bl && this.appState == 0) {
            return;
        }
        int n2 = n = bl ? 1 : 0;
        if (this.service != null) {
            this.logChannel.log(-2137614336, "GoogleMapLicenseHandler#setGoogleMapActive() - setting state > calling setOnlineApplicationState(%1) ", (long)n);
            try {
                this.service.setOnlineApplicationState(n, this);
            }
            catch (Exception exception) {
                this.logChannel.log(-2137614336, "GoogleMapLicenseHandler#setGoogleMapActive() - ERROR=%1", (Throwable)exception);
            }
        } else {
            this.logChannel.log(10000, "GoogleMapLicenseHandler#setGoogleMapActive() - no IOnlineService set - setting desired appstate to %1 ", (long)this.desiredState);
        }
    }

    @Override
    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
        if (oSRApplication != null) {
            int n = oSRApplication.getState();
            this.logChannel.log(-2137614336, "GoogleMapLicenseHandler#getOnlineApplicationResponse() - state: %1 ", (long)n);
            this.appState = (n & 1) != 0 ? 1 : 0;
        } else {
            this.logChannel.log(-1601830656, "GoogleMapLicenseHandler#getOnlineApplicationResponse() - app is null! ");
        }
    }

    @Override
    public void activateLicenseResponse(int n) {
        this.logChannel.log(-2137614336, "GoogleMapLicenseHandler#activateLicenseResponse() - not implemented ");
    }

    @Override
    public void getLicenseInformationResult(OSRLicense[] oSRLicenseArray) {
        this.logChannel.log(-2137614336, "GoogleMapLicenseHandler#getLicenseInformationResult() - got %1 licenses ", oSRLicenseArray == null ? 0L : (long)oSRLicenseArray.length);
    }

    @Override
    public void getReminderStatusResult(int n) {
        this.logChannel.log(-2137614336, "GoogleMapLicenseHandler#getReminderStatusResult() - not implemented ");
    }

    @Override
    public void setReminderStateResponse(int n) {
        this.logChannel.log(-2137614336, "GoogleMapLicenseHandler#setReminderStateResponse() - not implemented ");
    }

    @Override
    public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray) {
        this.logChannel.log(1078071040, "GoogleMapLicenseHandler#updateApplicationState() - props.length: %1 ", (long)(oSRNotifyPropertiesArray != null ? oSRNotifyPropertiesArray.length : -1));
        if (oSRNotifyPropertiesArray != null) {
            for (int i2 = 0; i2 < oSRNotifyPropertiesArray.length; ++i2) {
                this.updateApplicationState(oSRNotifyPropertiesArray[i2].getPriority(), oSRNotifyPropertiesArray[i2].getReason());
            }
        }
    }

    public void updateApplicationState(int n, int n2) {
        boolean bl;
        this.logChannel.log(1078071040, "GoogleMapLicenseHandler#updateApplicationState() - priority: %1 reason: %2", (long)n, (long)n2);
        if (n == 2) {
            switch (n2) {
                case 1: 
                case 2: {
                    this.logChannel.log(1078071040, "GoogleMapLicenseHandler#updateApplicationState() - no disable reason - ignore ");
                    bl = false;
                    break;
                }
                default: {
                    this.logChannel.log(1078071040, "GoogleMapLicenseHandler#updateApplicationState() - unknown reason - ignore ");
                    bl = false;
                    break;
                }
            }
        } else if (n == 3) {
            switch (n2) {
                case 1: 
                case 2: 
                case 3: {
                    this.logChannel.log(1078071040, "GoogleMapLicenseHandler#updateApplicationState() - disable service ");
                    bl = true;
                    break;
                }
                default: {
                    this.logChannel.log(1078071040, "GoogleMapLicenseHandler#updateApplicationState() - unknown reason - ignore ");
                    bl = false;
                    break;
                }
            }
        } else if (n == 1) {
            switch (n2) {
                case 1: 
                case 2: 
                case 3: {
                    this.logChannel.log(1078071040, "GoogleMapLicenseHandler#updateApplicationState() - no disable reason - ignore ");
                    bl = false;
                    break;
                }
                default: {
                    this.logChannel.log(1078071040, "GoogleMapLicenseHandler#updateApplicationState() - unknown reason - ignore ");
                    bl = false;
                    break;
                }
            }
        } else if (n == 4) {
            this.logChannel.log(1078071040, "GoogleMapLicenseHandler#updateApplicationState() - disable service ");
            bl = true;
        } else {
            this.logChannel.log(1078071040, "GoogleMapLicenseHandler#updateApplicationState() - unknown priority - ignore ");
            bl = false;
        }
        if (bl) {
            this.disableGoogleMap();
        }
    }

    private void disableGoogleMap() {
        boolean bl = this.googleMapService.isGoogleMapActive();
        this.logChannel.log(1078071040, "GoogleMapLicenseHandler#disableGoogleMap() - googleMapActive: %1", bl);
        if (this.getSkipLicenseCheckFlag()) {
            this.logChannel.log(-1601830656, "GoogleMapLicenseHandler#disableGoogleMap() - skipLicenseCheck: true - ignore! ");
            return;
        }
        try {
            this.googleMapService.disableGoogleMap();
        }
        catch (Exception exception) {
            this.logChannel.log(1078071040, "GoogleMapLicenseHandler#disableGoogleMap() - ERROR=%1 ", (Throwable)exception);
        }
        if (bl) {
            this.setGoogleMapActive(false);
        } else {
            this.logChannel.log(-2137614336, "GoogleMapLicenseHandler#disableGoogleMap() - google map not active - only persist state ");
        }
        this.setPersistedLicenseState(0, true);
    }

    public void resetMemorySettings() {
        this.logChannel.log(1078071040, "GoogleMapLicenseHandler#resetMemorySettings() ");
        this.setPersistedLicenseState(-1, true);
    }

    @Override
    public void updateServiceState(OnlineServiceListState onlineServiceListState) {
    }

    @Override
    public void getPreCheckResult(OSRServiceState oSRServiceState) {
    }
}

