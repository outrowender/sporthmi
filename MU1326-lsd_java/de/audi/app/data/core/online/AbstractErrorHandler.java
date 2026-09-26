/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.online;

import de.audi.app.data.core.AbstractDataConfigurationComponent;
import de.audi.app.data.core.IDataApplication;
import de.audi.app.data.core.online.AbstractApplicationErrorHandler;
import de.audi.app.data.core.online.AnnoyingOrange;
import de.audi.app.data.core.online.ApplicationErrorHandlerForeground;
import de.audi.app.data.core.online.ApplicationErrorHandlerHotspot;
import de.audi.app.data.core.online.ApplicationErrorHandlerMap;
import de.audi.app.data.core.online.ApplicationErrorHandlerPhone;
import de.audi.app.data.core.online.CommandAcceptDataRequest;
import de.audi.app.data.core.online.IErrorHandler;
import de.audi.app.data.core.online.OnlineErrorState;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.INaviConnectivityStateListener;
import org.dsi.ifc.bluetooth.ReconnectInfo;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractErrorHandler
extends AbstractDataConfigurationComponent
implements IErrorHandler {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[]{6};
    protected static final int AUDI_CONNECT;
    protected static final int WLAN;
    private ServiceTracker serviceTracker;
    private ServiceRegistration serviceRegistration;
    private final Object stateLock = new Object();
    private final AnnoyingOrange errorTimerHandler = new AnnoyingOrange(this);
    private final AbstractApplicationErrorHandler foregroundApplicationHandler = new ApplicationErrorHandlerForeground();
    private final ApplicationErrorHandlerMap map = new ApplicationErrorHandlerMap(this.errorTimerHandler);
    private final ApplicationErrorHandlerHotspot hotspot = new ApplicationErrorHandlerHotspot(this.errorTimerHandler);
    private final ApplicationErrorHandlerPhone phone = new ApplicationErrorHandlerPhone();
    private volatile int errorMmi = 0;
    private volatile int errorWlan = 0;
    private volatile int context = 0;
    private volatile boolean wlan = false;
    private volatile boolean dataOnly = false;
    private volatile boolean requestPopupShown = false;
    private final ChoiceModelApp changeMediator = this.getChoiceModel(4097);
    private final ChoiceModelApp onlineCheckApplicationChoice = this.getChoiceModel(2049320448);
    private INaviConnectivityStateListener navigation;
    static /* synthetic */ Class class$de$audi$atip$interapp$INaviConnectivityStateListener;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;

    protected AbstractErrorHandler(IDataApplication iDataApplication) {
        super(iDataApplication);
    }

    @Override
    protected int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void updateErrorState(int n, int n2) {
        int n3;
        int n4;
        int n5;
        this.log.log(1078071040, "AbstractErrorHandler#updateErrorState() MMI: %1, WLAN: %2", (Object)OnlineErrorState.ERROR_NAMES[n], (Object)OnlineErrorState.ERROR_NAMES[n2]);
        Object object = this.stateLock;
        synchronized (object) {
            n5 = this.errorMmi;
            n4 = this.errorWlan;
            n3 = this.context;
            this.errorMmi = n;
            this.errorWlan = n2;
        }
        if (n5 != n) {
            this.foregroundApplicationHandler.updateErrorState(n, n2);
            this.map.updateErrorState(n, n2);
            this.phone.updateErrorState(n, n2);
            if (n3 != 3) {
                if (this.map.errorSuppressed(n)) {
                    this.log.log(1078071040, "AbstractErrorHandler#updateErrorState(): Activating navi bypass to suppress error hint");
                    this.activateNaviBypass();
                } else if (n == 22 || n == 21) {
                    this.log.log(1078071040, "AbstractErrorHandler#updateErrorState(): Not deactivating Navi Bypass for %1", (Object)OnlineErrorState.ERROR_NAMES[n]);
                } else {
                    this.deactivateNaviBypass();
                }
            }
        }
        if (n4 != n2) {
            this.hotspot.updateErrorState(n, n2);
        }
        this.action();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void updateApplicationState(int n, boolean bl, boolean bl2) {
        boolean bl3;
        boolean bl4;
        int n2;
        this.log.log(1078071040, "AbstractErrorHandler#updateApplicationState(): %3, wlan=%1, dataOnly=%2", (Object)bl, (Object)bl2, (long)n);
        Object object = this.stateLock;
        synchronized (object) {
            n2 = this.context;
            bl4 = this.wlan;
            bl3 = this.dataOnly;
            this.context = n;
            this.wlan = bl;
            this.dataOnly = bl2;
        }
        this.foregroundApplicationHandler.updateApplicationState(n, bl, bl2);
        this.map.updateApplicationState(n, bl, bl2);
        this.hotspot.updateApplicationState(n, bl, bl2);
        this.phone.updateApplicationState(n, bl, bl2);
        if (n2 != n || bl4 != bl || bl3 != bl2) {
            this.action();
        }
    }

    void telAppEntered() {
        this.log.log(-2137614336, "AbstractErrorHandler#telAppEntered()");
        this.phone.telAppEntered();
        this.checkPhoneUnlockPopup();
    }

    void telAppLeft() {
        this.log.log(-2137614336, "AbstractErrorHandler#telAppLeft()");
        this.phone.telAppLeft();
    }

    void hkTelPressed() {
        this.log.log(-2137614336, "AbstractErrorHandler#hkTelPressed()");
        this.phone.hkTelPressed();
        this.checkPhoneUnlockPopup();
    }

    private void checkPhoneUnlockPopup() {
        if (this.phone.isActionRequired()) {
            this.log.log(1078071040, "AbstractErrorHandler#checkPhoneUnlockPopup(): showing UNLOCK popup");
            this.showUnlockPopup();
            this.phone.notifyErrorShown(0, this.errorMmi);
        }
    }

    void updateReconnectInfo(ReconnectInfo reconnectInfo) {
        boolean bl = AbstractErrorHandler.isRsapReconnect(reconnectInfo);
        this.log.log(1078071040, "AbstractErrorHandler#updateReconnectInfo(): isRsapReconnect=%1", bl);
        this.errorTimerHandler.updateReconnectInfo(bl);
        if (this.map.isReconnectBlocking()) {
            this.log.log(1078071040, "AbstractErrorHandler#updateReconnectInfo(): Activating Navi bypass");
            this.activateNaviBypass();
        }
    }

    private static final boolean isRsapReconnect(ReconnectInfo reconnectInfo) {
        return (reconnectInfo.getReconnectIndicator() & 4) > 0;
    }

    void updateWlanMode(boolean bl, boolean bl2) {
        this.errorTimerHandler.updateWlanMode(bl, bl2);
    }

    void updateTrustedNetworks(boolean bl) {
        this.errorTimerHandler.updateTrustedNetworks(bl);
    }

    void reaction() {
        this.log.log(1078071040, "AbstractErrorHandler#reaction(): Retriggering error presentation");
        this.action();
    }

    private void action() {
        boolean bl = this.foregroundApplicationHandler.isActionRequired();
        boolean bl2 = this.map.isActionRequired();
        boolean bl3 = this.hotspot.isActionRequired();
        boolean bl4 = this.phone.isActionRequired();
        this.log.log(1078071040, "AbstractErrorHandler#action(): red=%1, map=%2, wlan=%3, phone=%4", (Object)bl, (Object)bl2, (Object)bl3, (Object)bl4);
        if (bl) {
            this.log.log(1078071040, "AbstractErrorHandler#action(): Show RED");
            this.enterOnlineCheck();
            this.notifyErrorShown(0, this.errorMmi);
        } else if (bl2) {
            this.log.log(1078071040, "AbstractErrorHandler#action(): Show Map");
            this.deactivateNaviBypass();
            this.enterOnlineCheck();
            this.notifyErrorShown(0, this.errorMmi);
        } else {
            this.leaveOnlineCheck();
            if (bl3) {
                this.log.log(1078071040, "AbstractErrorHandler#action(): Show WLAN");
                this.showPopup(1);
                this.notifyErrorShown(1, this.errorWlan);
            } else {
                this.hidePopup(this.context == 0 ? this.errorMmi : this.errorWlan, 1);
                if (bl4) {
                    this.log.log(1078071040, "AbstractErrorHandler#action(): Show phone");
                    this.showUnlockPopup();
                    this.phone.notifyErrorShown(0, this.errorMmi);
                }
            }
        }
    }

    private void deactivateNaviBypass() {
        if (this.navigation != null) {
            this.navigation.onlineStateChanged();
        }
    }

    private void activateNaviBypass() {
        if (this.navigation != null) {
            this.navigation.onlineErrorShown();
        }
    }

    void errorShown(boolean bl) {
        if (!bl) {
            this.activateNaviBypass();
        }
        this.notifyErrorShown(0, this.errorMmi);
    }

    void notifyErrorShown(int n, int n2) {
        this.foregroundApplicationHandler.notifyErrorShown(n, n2);
        this.map.notifyErrorShown(n, n2);
        this.hotspot.notifyErrorShown(n, n2);
        this.phone.notifyErrorShown(n, n2);
    }

    void roamingSettingDeactivatedByUser() {
        this.map.roamingSettingDeactivatedByUser();
        this.hotspot.roamingSettingDeactivatedByUser();
    }

    protected void enterOnlineCheck() {
        this.enterOnlineCheckContext();
        this.onlineCheckApplicationChoice.setValue(0);
        this.changeMediator.setValue(~this.changeMediator.getValue());
    }

    protected void leaveOnlineCheck() {
    }

    private void showPopup(int n) {
        this.enterOnlineCheckContext();
        this.onlineCheckApplicationChoice.setValue(n);
        this.showPopup(n == 0 ? this.errorMmi : this.errorWlan, n);
    }

    private void enterOnlineCheckContext() {
        this.context = 3;
    }

    @Override
    public abstract void showPopup(int n, int n2) {
    }

    protected void hidePopup(int n, int n2) {
    }

    @Override
    public abstract void showUnlockPopup() {
    }

    @Override
    public void updateDataRequest(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        this.log.log(1078071040, "AbstractErrorHandler#updateDataRequest(): service=%1", (long)n);
        if (n == 8) {
            this.handleUpdateDataRequest();
        } else if (n == 6 && AbstractErrorHandler.silentAccept(this.errorWlan)) {
            this.log.log(1078071040, "AbstractErrorHandler#updateDataRequest(): Silently accepting WLAN data request");
            this.acceptDataRequest(6);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleUpdateDataRequest() {
        int n;
        int n2;
        Object object = this.stateLock;
        synchronized (object) {
            n2 = this.errorMmi;
            n = this.context;
        }
        if (AbstractErrorHandler.silentAccept(n2)) {
            this.log.log(1078071040, "AbstractErrorHandler#handleUpdateDataRequest(): Silently accepting MMI data request");
            this.acceptDataRequest(8);
        } else if (!(n2 != 14 && n2 != 12 && n2 != 13 || n != 0 || this.requestPopupShown)) {
            this.log.log(1078071040, "AbstractErrorHandler#handleUpdateDataRequest(): Showing pop up for udpateDataRequest!");
            this.requestPopupShown = true;
            this.showPopup(0);
        }
    }

    private static boolean silentAccept(int n) {
        return n == 20 || n == 16 || n == 19 || n == 0;
    }

    protected final void acceptDataRequest(int n) {
        CommandAcceptDataRequest.schedule(this.dataApplication, this.dsiDataConfiguration, n, true);
    }

    void signalProfileLoss() {
        this.requestPopupShown = false;
    }

    public int getErrorMmi() {
        return this.errorMmi;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof INaviConnectivityStateListener) {
            this.navigation = (INaviConnectivityStateListener)object;
            return object;
        }
        return super.addingService(serviceReference);
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof INaviConnectivityStateListener) {
            this.navigation = null;
            this.bundleContext.ungetService(serviceReference);
        }
        super.removedService(serviceReference, object);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof INaviConnectivityStateListener) {
            this.navigation = (INaviConnectivityStateListener)object;
        }
        super.modifiedService(serviceReference, object);
    }

    @Override
    public void init() {
        super.init();
        this.serviceTracker = new ServiceTracker(this.bundleContext, new String[]{(class$de$audi$atip$interapp$INaviConnectivityStateListener == null ? (class$de$audi$atip$interapp$INaviConnectivityStateListener = AbstractErrorHandler.class$("de.audi.atip.interapp.INaviConnectivityStateListener")) : class$de$audi$atip$interapp$INaviConnectivityStateListener).getName()}, (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
        this.serviceRegistration = this.bundleContext.registerService((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = AbstractErrorHandler.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), (Object)this.errorTimerHandler, null);
    }

    @Override
    public void deinit() {
        this.serviceRegistration.unregister();
        this.serviceRegistration = null;
        this.serviceTracker.close();
        this.serviceTracker = null;
        super.deinit();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

