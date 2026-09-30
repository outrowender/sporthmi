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
import de.audi.tghu.navi.app.map.gui.SimpleButtonListener;
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
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    protected IOnlineService service;
    public static final String SERVICE_ID_ONLINE_TRAFFIC = "service_dsi_onlinetraffic";
    private final IFrameworkAccess framework;
    private OnlineTrafficPersistanceHelper onlineTrafficPersistanceHelper;
    public static final int ONLINETRAFFIC_CHECKBOX_ON = 0;
    public static final int ONLINETRAFFIC_CHECKBOX_OFF = 1;
    public static final int ONLINETRAFFIC_STATUS_VISIBLE = 0;
    public static final int ONLINETRAFFIC_STATUS_INVISIBLE = 1;
    public static final int ONLINETRAFFIC_STATUS_DISABLED = 2;
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
        this.env.getChoiceModel(400594).setChoiceListener(this);
        this.env.getChoiceModel(400594).setValue(1);
        this.env.getChoiceModel(400596).setChoiceListener(this);
        this.env.getButtonModel(400593).setButtonListener(this);
        this.env.getButtonModel(400597).setButtonListener(this);
        this.env.getButtonModel(400881).setButtonListener(this);
        this.env.getButtonModel(400882).setButtonListener(this);
        this.env.getChoiceModel(400600).setValue(-1);
        this.initOnlineContentPopupListener();
    }

    private void initOnlineContentPopupListener() {
        new OnlineContentPopupListener(this.env);
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logChannel.log(1000000, "[OnlineTrafficHandler#itemSelected] model:%1, itemID: %2", (long)n, (long)n2);
        switch (n) {
            case 400594: {
                if (this.service != null) {
                    if (n2 == 0) {
                        this.enableOnlineTrafficSequence(this, true);
                        break;
                    }
                    if (n2 == 1) {
                        this.logChannel.log(1000000, "[OnlineTrafficHandler#itemSelected] changing off > calling setOnlineApplicationState(%1)", 0L);
                        this.disableOnlineTrafficSequence(this);
                        break;
                    }
                    this.logChannel.log(100000, "[OnlineTrafficHandler#itemSelected] unsupported item selected: %1", (long)n2);
                    return;
                }
                this.logChannel.log(10000, "[OnlineTrafficHandler#itemSelected] no IOnlineService set");
                this.setStatus(false);
                break;
            }
            default: {
                this.logChannel.log(100000, "[OnlineTrafficHandler#itemSelected] unknown model:%1", (long)n);
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public final void setStatus(boolean bl) {
        ChoiceModelApp choiceModelApp;
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "[%1#setStatus] activation status: %2 ", (Object)this.CLASS_NAME, (Object)bl);
        }
        if ((choiceModelApp = this.env.getChoiceModel(400594)) != null) {
            int n = choiceModelApp.getStatus();
            int n2 = bl ? 0 : 2;
            this.logChannel.log(1000000, "[%1#setStatus] old status: %1, new status: %2 ", (Object)this.CLASS_NAME, (long)n, (long)n2);
            choiceModelApp.setStatus(n2);
        } else {
            this.logChannel.log(10000, "[%1#setStatus] model is null! ", (Object)this.CLASS_NAME);
        }
    }

    public final void setOnlineTrafficCheckBoxState(boolean bl, boolean bl2) {
        this.logChannel.log(1000000, "[OnlineTrafficHandler#setState] enable status: %1, persist: %2 ", bl, bl2);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(400594);
        if (choiceModelApp != null) {
            choiceModelApp.setValue(bl ? 0 : 1);
        }
        if (bl2) {
            this.onlineTrafficPersistanceHelper.persistState(bl);
        }
    }

    private boolean getState() {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(400594);
        if (choiceModelApp != null) {
            return choiceModelApp.getValue() == 0;
        }
        return false;
    }

    public final void setReminderStatus(int n) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "[OnlineTrafficHandler#setReminderStatus] status: %1", (long)n);
        }
        this.env.getChoiceModel(400596).setValue(n == 0 ? 1 : 0);
    }

    public IOnlineService getService() {
        return this.service;
    }

    public void setService(IOnlineService iOnlineService) {
        this.logChannel.log(10000000, "[OnlineTrafficHandler#setService] %1", (Object)iOnlineService);
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
                this.logChannel.log(10000000, "[OnlineTrafficHandler#setService] ERROR=%1", (Throwable)exception);
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
                this.logChannel.log(1000000, "[%1#getOnlineApplicationResponse] state: %2 jumpToInclude:%3", (Object)this.CLASS_NAME, (Object)Integer.toString(oSRApplication.getState()), (Object)Boolean.toString(bl));
                boolean bl2 = this.matchAppState(oSRApplication.getState());
                this.setOnlineTrafficCheckBoxState(bl2, true);
                this.setStatus(true);
                if (bl) {
                    this.env.fireModelEvent(this.getOnlineTrafficChoiceModel(), 0);
                }
            } else {
                this.logChannel.log(100000, "[%1#getOnlineApplicationResponse] app is null!", (Object)this.CLASS_NAME);
            }
        }
    }

    public void activateLicenseResponse(int n) {
        this.logChannel.log(10000000, "[%1#getOnlineApplicationResponse] state: %2", (Object)this.CLASS_NAME, (long)n);
        int n2 = this.matchLicenseActivationState(n);
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "[%1#getOnlineApplicationResponse] matched state %2", (Object)this.CLASS_NAME, (long)n2);
        }
        this.env.getChoiceModel(400598).setValue(n2);
    }

    public void getLicenseInformationResult(OSRLicense[] oSRLicenseArray) {
        this.logChannel.log(10000000, "[OnlineTrafficHandler#getLicenceInformation] got %1 licences", oSRLicenseArray == null ? 0L : (long)oSRLicenseArray.length);
    }

    public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray) {
        this.logChannel.log(1000000, "[%1#updateApplicationState] props.length: %2 ", (Object)this.CLASS_NAME, (long)(oSRNotifyPropertiesArray != null ? oSRNotifyPropertiesArray.length : -1));
        if (oSRNotifyPropertiesArray != null && this.logChannel.isDebug()) {
            for (int i2 = 0; i2 < oSRNotifyPropertiesArray.length; ++i2) {
                this.logChannel.log(10000000, "[%1#updateApplicationState] props[%2] - priority: %3 reason: %4 ", (Object)this.CLASS_NAME, (Object)(i2 + ""), (Object)(oSRNotifyPropertiesArray[i2].getPriority() + ""), (long)oSRNotifyPropertiesArray[i2].getReason());
            }
        }
    }

    protected void disableService() {
        this.setOnlineTrafficCheckBoxState(false, true);
        if (this.service != null) {
            this.logChannel.log(1000000, "%1#disableService() - changing off > calling setOnlineApplicationState(%2) ", (Object)this.CLASS_NAME, 0L);
            this.disableOnlineTrafficSequence(this);
        } else {
            this.logChannel.log(10000, "OnlineTrafficHandler#disableService() - no IOnlineService set");
        }
    }

    public void getReminderStatusResult(int n) {
        this.logChannel.log(10000000, "[%1#getReminderStatusResult] reminderStatus: %1", (Object)this.CLASS_NAME, (long)n);
        this.setReminderStatus(n);
    }

    public void setReminderStateResponse(int n) {
        this.logChannel.log(10000000, "[%1#getReminderStatusResult] reminderStatus: %2", (Object)this.CLASS_NAME, (long)n);
        this.setReminderStatus(n);
    }

    public void updateLicenceActive() {
        this.logChannel.log(1000000, "[OnlineTrafficHandler#updateLicenceActive] ");
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
            this.logChannel.log(100000, "[%1#resetSettings] no IOnlineService set", (Object)this.CLASS_NAME);
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
        this.logChannel.log(1000000, "%1#setOnlineTraffic ( %2 )", (Object)this.CLASS_NAME, (Object)bl);
        if (Util.isOnlineTrafficAlwaysActive(this.env.getFramework())) {
            this.logChannel.log(1000000, "OnlineTrafficHandler#setOnlineTraffic - always on: do nothing");
            return;
        }
        if (bl == this.getState()) {
            this.logChannel.log(10000000, "%1#setOnlineTraffic - no state change needed, is still %2", (Object)this.CLASS_NAME, (Object)bl);
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
            this.logChannel.log(1000000, "%1#enableOnlineTrafficSequence jumpToInclude=%2", (Object)this.CLASS_NAME, (Object)(bl + ""));
            if (this.service != null) {
                try {
                    this.service.setOnlineApplicationState(1, new OnlineServiceListenerWrapper(this, bl));
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
        return 400594;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void disableOnlineTrafficSequence(IOnlineServiceListener iOnlineServiceListener) {
        Object object = this.mutex;
        synchronized (object) {
            if (!this.getState()) {
                this.logChannel.log(1000000, "[%1#disableOnlineTrafficSequence] service disabled - ignore ", (Object)this.CLASS_NAME);
                return;
            }
            this.logChannel.log(10000000, "%1#disableOnlineTrafficSequence", (Object)this.CLASS_NAME);
            if (this.service != null) {
                try {
                    this.service.setOnlineApplicationState(0, new OnlineServiceListenerWrapper(this, false));
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

    public void getPreCheckResult(OSRServiceState oSRServiceState) {
    }

    public void updateServiceState(OnlineServiceListState onlineServiceListState) {
    }

    private class OnlineContentPopupListener
    extends SimpleButtonListener {
        private NavigationEnv env;
        private final int ONLINE_OK_BUTTON_ID;
        private final int ONLINE_CANCEL_BUTTON_ID;
        private final int ONLINE_SHOWED_CHOICE_ID;

        public OnlineContentPopupListener(NavigationEnv navigationEnv) {
            this.ONLINE_OK_BUTTON_ID = 402008;
            this.ONLINE_CANCEL_BUTTON_ID = 402010;
            this.ONLINE_SHOWED_CHOICE_ID = 402030;
            this.env = navigationEnv;
            navigationEnv.getButtonModel(402008).setButtonListener(this);
            navigationEnv.getButtonModel(402010).setButtonListener(this);
        }

        public void keyPressed(int n, int n2, int n3) {
            OnlineTrafficHandler.this.logChannel.log(10000000, "%1 -- OnlineContentPopupListener#keyPressed(%2, %3, %4)", (Object)OnlineTrafficHandler.this.CLASS_NAME, (Object)new StringBuffer().append(n).append("").toString(), (Object)new StringBuffer().append(n2).append("").toString(), (long)n3);
            if (n == 402008) {
                this.env.getChoiceModel(402030).setValue(1);
                this.env.fireModelEvent(n, n3);
            } else if (n == 402010) {
                this.env.getChoiceModel(402030).setValue(0);
                OnlineTrafficHandler.this.setOnlineTrafficCheckBoxState(false, true);
                this.env.fireModelEvent(n, n3);
            }
        }
    }

    private class OnlineServiceListenerWrapper
    implements IOnlineServiceListener {
        private OnlineTrafficHandler handler;
        boolean jumpToInclude = false;

        public OnlineServiceListenerWrapper(OnlineTrafficHandler onlineTrafficHandler2, boolean bl) {
            this.handler = onlineTrafficHandler2;
            this.jumpToInclude = bl;
        }

        public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
            this.handler.getOnlineApplicationResponse(oSRApplication, this.jumpToInclude);
        }

        public void activateLicenseResponse(int n) {
        }

        public void getLicenseInformationResult(OSRLicense[] oSRLicenseArray) {
        }

        public void getReminderStatusResult(int n) {
        }

        public void setReminderStateResponse(int n) {
        }

        public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray) {
        }

        public void getPreCheckResult(OSRServiceState oSRServiceState) {
        }

        public void updateServiceState(OnlineServiceListState onlineServiceListState) {
        }
    }
}

