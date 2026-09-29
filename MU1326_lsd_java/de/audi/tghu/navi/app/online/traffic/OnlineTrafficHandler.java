/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.online.traffic;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.online.IOnlineService;
import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.atip.interapp.online.OnlineServiceListState;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.online.traffic.OnlineTrafficHandler$OnlineContentPopupListener;
import de.audi.tghu.navi.app.online.traffic.OnlineTrafficHandler$OnlineServiceListenerWrapper;
import de.audi.tghu.navi.app.online.traffic.OnlineTrafficPersistanceHelper;
import de.audi.tghu.navi.app.online.traffic.TrafficOnlineServiceHandler;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRServiceState;

public class OnlineTrafficHandler
implements ButtonListener,
ChoiceListener,
IOnlineServiceListener {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    protected IOnlineService service;
    public static final String SERVICE_ID_ONLINE_TRAFFIC;
    private final IFrameworkAccess framework;
    private OnlineTrafficPersistanceHelper onlineTrafficPersistanceHelper;
    public static final int ONLINETRAFFIC_CHECKBOX_ON;
    public static final int ONLINETRAFFIC_CHECKBOX_OFF;
    public static final int ONLINETRAFFIC_STATUS_VISIBLE;
    public static final int ONLINETRAFFIC_STATUS_INVISIBLE;
    public static final int ONLINETRAFFIC_STATUS_DISABLED;
    private TrafficOnlineServiceHandler vzoLgiTrackerHandler;
    private TrafficOnlineServiceHandler vzoLgiDownloadHandler;
    private final Object mutex;

    public OnlineTrafficHandler(NavigationEnv navigationEnv, LogChannel logChannel) {
        this.env = navigationEnv;
        this.logChannel = logChannel;
        this.framework = navigationEnv.getFramework();
        this.onlineTrafficPersistanceHelper = new OnlineTrafficPersistanceHelper(navigationEnv, 985, logChannel);
        this.mutex = new Object();
        this.init();
        this.vzoLgiTrackerHandler = new TrafficOnlineServiceHandler("ncfstracker", logChannel);
        this.vzoLgiDownloadHandler = new TrafficOnlineServiceHandler("ncfsdownload", logChannel);
        this.setOnlineTrafficCheckBoxState(this.onlineTrafficPersistanceHelper.loadState(), false);
        this.setStatus(false);
    }

    private void init() {
        this.env.getChoiceModel(-769915392).setChoiceListener(this);
        this.env.getChoiceModel(-769915392).setValue(1);
        this.env.getChoiceModel(-736360960).setChoiceListener(this);
        this.env.getButtonModel(-786692608).setButtonListener(this);
        this.env.getButtonModel(-719583744).setButtonListener(this);
        this.env.getButtonModel(-249756160).setButtonListener(this);
        this.env.getButtonModel(-232978944).setButtonListener(this);
        this.env.getChoiceModel(-669252096).setValue(-1);
        this.initOnlineContentPopupListener();
    }

    private void initOnlineContentPopupListener() {
        new OnlineTrafficHandler$OnlineContentPopupListener(this, this.env);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logChannel.log(1078071040, "[OnlineTrafficHandler#itemSelected] model:%1, itemID: %2", (long)n, (long)n2);
        switch (n) {
            case 400594: {
                if (this.service != null) {
                    if (n2 == 0) {
                        this.enableOnlineTrafficSequence(this, true);
                        break;
                    }
                    if (n2 == 1) {
                        this.logChannel.log(1078071040, "[OnlineTrafficHandler#itemSelected] changing off > calling setOnlineApplicationState(%1)", 0L);
                        this.disableOnlineTrafficSequence(this);
                        break;
                    }
                    this.logChannel.log(-1601830656, "[OnlineTrafficHandler#itemSelected] unsupported item selected: %1", (long)n2);
                    return;
                }
                this.logChannel.log(10000, "[OnlineTrafficHandler#itemSelected] no IOnlineService set");
                this.setStatus(false);
                break;
            }
            default: {
                this.logChannel.log(-1601830656, "[OnlineTrafficHandler#itemSelected] unknown model:%1", (long)n);
            }
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    public final void setStatus(boolean bl) {
        ChoiceModelApp choiceModelApp;
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "[%1#setStatus] activation status: %2 ", (Object)this.CLASS_NAME, (Object)bl);
        }
        if ((choiceModelApp = this.env.getChoiceModel(-769915392)) != null) {
            int n = choiceModelApp.getStatus();
            int n2 = bl ? 0 : 2;
            this.logChannel.log(1078071040, "[%1#setStatus] old status: %1, new status: %2 ", (Object)this.CLASS_NAME, (long)n, (long)n2);
            choiceModelApp.setStatus(n2);
        } else {
            this.logChannel.log(10000, "[%1#setStatus] model is null! ", (Object)this.CLASS_NAME);
        }
    }

    public final void setOnlineTrafficCheckBoxState(boolean bl, boolean bl2) {
        this.logChannel.log(1078071040, "[OnlineTrafficHandler#setState] enable status: %1, persist: %2 ", bl, bl2);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(-769915392);
        if (choiceModelApp != null) {
            choiceModelApp.setValue(bl ? 0 : 1);
        }
        if (bl2) {
            this.onlineTrafficPersistanceHelper.persistState(bl);
        }
    }

    private boolean getState() {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(-769915392);
        if (choiceModelApp != null) {
            return choiceModelApp.getValue() == 0;
        }
        return false;
    }

    public final void setReminderStatus(int n) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "[OnlineTrafficHandler#setReminderStatus] status: %1", (long)n);
        }
        this.env.getChoiceModel(-736360960).setValue(n == 0 ? 1 : 0);
    }

    public IOnlineService getService() {
        return this.service;
    }

    public void setService(IOnlineService iOnlineService) {
        this.logChannel.log(-2137614336, "[OnlineTrafficHandler#setService] %1", (Object)iOnlineService);
        this.service = iOnlineService;
        if (iOnlineService != null) {
            try {
                boolean bl;
                boolean bl2 = this.getState();
                iOnlineService.addCallBackListener(this);
                boolean bl3 = bl2 && !this.getState();
                boolean bl4 = bl = !bl2 && this.getState();
                if (Util.isOnlineTrafficAlwaysActive(this.env.getFramework()) || bl3) {
                    this.enableOnlineTrafficSequence(this, false);
                } else if (bl) {
                    this.disableOnlineTrafficSequence(this);
                }
            }
            catch (Exception exception) {
                this.logChannel.log(-2137614336, "[OnlineTrafficHandler#setService] ERROR=%1", (Throwable)exception);
            }
        } else {
            this.setStatus(false);
        }
    }

    public String toString() {
        Buffer buffer = new Buffer("Online Traffic Status");
        boolean bl = this.framework.getSysConst(488) == 1;
        boolean bl2 = this.service != null;
        buffer.append("\nEOL:").append(bl);
        buffer.append("\nDSI:").append(bl2);
        return buffer.toString();
    }

    @Override
    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
        this.getOnlineApplicationResponse(oSRApplication, false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void getOnlineApplicationResponse(OSRApplication oSRApplication, boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            if (oSRApplication != null) {
                this.logChannel.log(1078071040, "[%1#getOnlineApplicationResponse] state: %2 jumpToInclude:%3", (Object)this.CLASS_NAME, (Object)Integer.toString(oSRApplication.getState()), (Object)Boolean.toString(bl));
                boolean bl2 = this.matchAppState(oSRApplication.getState());
                this.setOnlineTrafficCheckBoxState(bl2, true);
                this.setStatus(true);
                if (bl) {
                    this.env.fireModelEvent(this.getOnlineTrafficChoiceModel(), 0);
                }
            } else {
                this.logChannel.log(-1601830656, "[%1#getOnlineApplicationResponse] app is null!", (Object)this.CLASS_NAME);
            }
        }
    }

    @Override
    public void activateLicenseResponse(int n) {
        this.logChannel.log(-2137614336, "[%1#getOnlineApplicationResponse] state: %2", (Object)this.CLASS_NAME, (long)n);
        int n2 = this.matchLicenseActivationState(n);
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "[%1#getOnlineApplicationResponse] matched state %2", (Object)this.CLASS_NAME, (long)n2);
        }
        this.env.getChoiceModel(-702806528).setValue(n2);
    }

    @Override
    public void getLicenseInformationResult(OSRLicense[] oSRLicenseArray) {
        this.logChannel.log(-2137614336, "[OnlineTrafficHandler#getLicenceInformation] got %1 licences", oSRLicenseArray == null ? 0L : (long)oSRLicenseArray.length);
    }

    @Override
    public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray) {
        this.logChannel.log(1078071040, "[%1#updateApplicationState] props.length: %2 ", (Object)this.CLASS_NAME, (long)(oSRNotifyPropertiesArray != null ? oSRNotifyPropertiesArray.length : -1));
        if (oSRNotifyPropertiesArray != null && this.logChannel.isDebug()) {
            for (int i2 = 0; i2 < oSRNotifyPropertiesArray.length; ++i2) {
                this.logChannel.log(-2137614336, "[%1#updateApplicationState] props[%2] - priority: %3 reason: %4 ", (Object)this.CLASS_NAME, (Object)new StringBuffer().append(i2).append("").toString(), (Object)new StringBuffer().append(oSRNotifyPropertiesArray[i2].getPriority()).append("").toString(), (long)oSRNotifyPropertiesArray[i2].getReason());
            }
        }
    }

    protected void disableService() {
        this.setOnlineTrafficCheckBoxState(false, true);
        if (this.service != null) {
            this.logChannel.log(1078071040, "%1#disableService() - changing off > calling setOnlineApplicationState(%2) ", (Object)this.CLASS_NAME, 0L);
            this.disableOnlineTrafficSequence(this);
        } else {
            this.logChannel.log(10000, "OnlineTrafficHandler#disableService() - no IOnlineService set");
        }
    }

    @Override
    public void getReminderStatusResult(int n) {
        this.logChannel.log(-2137614336, "[%1#getReminderStatusResult] reminderStatus: %1", (Object)this.CLASS_NAME, (long)n);
        this.setReminderStatus(n);
    }

    @Override
    public void setReminderStateResponse(int n) {
        this.logChannel.log(-2137614336, "[%1#getReminderStatusResult] reminderStatus: %2", (Object)this.CLASS_NAME, (long)n);
        this.setReminderStatus(n);
    }

    public void updateLicenceActive() {
        this.logChannel.log(1078071040, "[OnlineTrafficHandler#updateLicenceActive] ");
    }

    private boolean matchAppState(int n) {
        return (n & 1) != 0;
    }

    private int matchLicenseActivationState(int n) {
        int n2 = 1;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 2;
                break;
            }
            case 2: 
            case 3: {
                n2 = 3;
                break;
            }
        }
        return n2;
    }

    public void resetSettings() {
        if (this.service == null) {
            this.logChannel.log(-1601830656, "[%1#resetSettings] no IOnlineService set", (Object)this.CLASS_NAME);
            this.setStatus(false);
            this.setOnlineTrafficCheckBoxState(!Util.isHURegionCN(), true);
            return;
        }
        if (Util.isHURegionCN()) {
            this.disableOnlineTrafficSequence(this);
        } else {
            this.enableOnlineTrafficSequence(this, false);
        }
    }

    public void setOnlineTraffic(boolean bl) {
        this.logChannel.log(1078071040, "%1#setOnlineTraffic ( %2 )", (Object)this.CLASS_NAME, (Object)bl);
        if (Util.isOnlineTrafficAlwaysActive(this.env.getFramework())) {
            this.logChannel.log(1078071040, "OnlineTrafficHandler#setOnlineTraffic - always on: do nothing");
            return;
        }
        if (bl == this.getState()) {
            this.logChannel.log(-2137614336, "%1#setOnlineTraffic - no state change needed, is still %2", (Object)this.CLASS_NAME, (Object)bl);
            return;
        }
        if (bl) {
            this.enableOnlineTrafficSequence(this, false);
        } else {
            this.disableOnlineTrafficSequence(this);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void enableOnlineTrafficSequence(IOnlineServiceListener iOnlineServiceListener, boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            this.logChannel.log(1078071040, "%1#enableOnlineTrafficSequence jumpToInclude=%2", (Object)this.CLASS_NAME, (Object)new StringBuffer().append(bl).append("").toString());
            if (this.service != null) {
                try {
                    this.service.setOnlineApplicationState(1, new OnlineTrafficHandler$OnlineServiceListenerWrapper(this, this, bl));
                    this.vzoLgiDownloadHandler.setState(1);
                    this.vzoLgiTrackerHandler.setState(1);
                    this.setOnlineTrafficCheckBoxState(true, true);
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "%1#enableOnlineTrafficSequence#execute - ERROR=%2", (Object)this.CLASS_NAME, (Throwable)exception);
                }
            } else {
                this.logChannel.log(10000, "%1#enableOnlineTrafficSequence#execute - no service", (Object)this.CLASS_NAME);
            }
        }
    }

    protected int getOnlineTrafficChoiceModel() {
        return -769915392;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void disableOnlineTrafficSequence(IOnlineServiceListener iOnlineServiceListener) {
        Object object = this.mutex;
        synchronized (object) {
            if (!this.getState()) {
                this.logChannel.log(1078071040, "[%1#disableOnlineTrafficSequence] service disabled - ignore ", (Object)this.CLASS_NAME);
                return;
            }
            this.logChannel.log(-2137614336, "%1#disableOnlineTrafficSequence", (Object)this.CLASS_NAME);
            if (this.service != null) {
                try {
                    this.service.setOnlineApplicationState(0, new OnlineTrafficHandler$OnlineServiceListenerWrapper(this, this, false));
                    this.vzoLgiDownloadHandler.setState(0);
                    this.vzoLgiTrackerHandler.setState(0);
                    this.setOnlineTrafficCheckBoxState(false, true);
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "%1#disableOnlineTrafficSequence- ERROR=%2", (Object)this.CLASS_NAME, (Throwable)exception);
                }
            } else {
                this.logChannel.log(10000, "%1#disableOnlineTrafficSequence - no service", (Object)this.CLASS_NAME);
            }
        }
    }

    public void setTrafficOnlineService(String string, IOnlineService iOnlineService) {
        int n;
        int n2 = n = this.getState() ? 1 : 0;
        if ("ncfsdownload".equals(string)) {
            this.vzoLgiDownloadHandler.setService(iOnlineService, n);
        } else if ("ncfstracker".equals(string)) {
            this.vzoLgiTrackerHandler.setService(iOnlineService, n);
        }
    }

    @Override
    public void getPreCheckResult(OSRServiceState oSRServiceState) {
    }

    @Override
    public void updateServiceState(OnlineServiceListState onlineServiceListState) {
    }
}

