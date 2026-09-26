/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.connectivity.BaseOnlineComponentDiag
 *  de.mib.swdiagnosis.connectivity.IDiagComponent
 */
package de.audi.app.data.core.online;

import de.audi.app.data.core.AbstractDataConnectionComponent;
import de.audi.app.data.core.IDataApplication;
import de.audi.app.data.core.online.AbstractErrorHandler;
import de.audi.app.data.core.online.IOnline;
import de.audi.app.data.core.online.OnlineApplicationState;
import de.audi.app.data.core.online.OnlineErrorState;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.IConnectivityNaviStateListener;
import de.audi.atip.interapp.IConnectivitySimUsageListener;
import de.mib.swdiagnosis.connectivity.BaseOnlineComponentDiag;
import de.mib.swdiagnosis.connectivity.IDiagComponent;
import org.dsi.ifc.bluetooth.ReconnectInfo;
import org.osgi.framework.ServiceRegistration;

public class BaseOnlineComponent
extends AbstractDataConnectionComponent
implements IOnline,
IConnectivityNaviStateListener,
IConnectivitySimUsageListener {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[]{4};
    private final ChoiceModelApp onlineCheckApplicationChoice;
    private final AbstractErrorHandler errorHandler;
    private final OnlineErrorState onlineErrorState;
    private final OnlineApplicationState applicationState;
    private ServiceRegistration serviceRegistration1;
    private ServiceRegistration serviceRegistration2;
    private ServiceRegistration serviceRegistration3;
    static /* synthetic */ Class class$de$audi$app$data$core$online$IOnline;
    static /* synthetic */ Class class$de$audi$atip$interapp$IConnectivityNaviStateListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$IConnectivitySimUsageListener;

    public BaseOnlineComponent(IDataApplication iDataApplication, AbstractErrorHandler abstractErrorHandler) {
        super(iDataApplication);
        this.errorHandler = abstractErrorHandler;
        this.onlineErrorState = new OnlineErrorState(this.log, iDataApplication.getFramework().getHmiServiceApp(), abstractErrorHandler);
        this.applicationState = new OnlineApplicationState(this.log, abstractErrorHandler);
        this.onlineCheckApplicationChoice = this.getChoiceModel(2049320448);
    }

    @Override
    protected int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    @Override
    public void notifyLocalNetMode() {
        this.log.log(1078071040, "BaseOnlineComponent#notifyLocalNetMode(): Local net mode is active");
        this.onlineErrorState.updateLocalNetMode();
    }

    @Override
    public void updateSimState(int n, boolean bl, boolean bl2, boolean bl3) {
        this.log.log(-2137614336, "BaseOnlineComponent#updateSimState(): simState=%2, isNadModeDataOnly=%1", bl, (long)n);
        this.applicationState.updatePhone(bl);
        this.onlineErrorState.updateSimState(n, bl, bl2, bl3);
    }

    @Override
    public void updateProfileState(int n) {
        this.log.log(-2137614336, "BaseOnlineComponent#updateProfileState(): profileState=%1", (long)n);
        this.onlineErrorState.updateProfileState(n);
    }

    @Override
    public void updatePermissionGeneral(int n) {
        this.log.log(-2137614336, "BaseOnlineComponent#updatePermissionGeneral(): permissionState=%1", (long)n);
        this.onlineErrorState.updatePermissionGeneral(n);
    }

    @Override
    public void updatePermission(int n, int n2) {
        this.log.log(-2137614336, "BaseOnlineComponent#updatePermission(): permissionState=%1", (long)n2);
        this.onlineErrorState.updatePermission(n, n2);
    }

    @Override
    public void updatePermissionRoaming(int n) {
        this.log.log(-2137614336, "BaseOnlineComponent#updatePermissionRoaming(): permissionState=%1", (long)n);
        this.onlineErrorState.updatePermissionRoaming(n);
    }

    @Override
    public void roamingSettingDeactivatedByUser() {
        this.log.log(-2137614336, "BaseOnlineComponent#roamingSettingDeactivatedByUser()");
        this.errorHandler.roamingSettingDeactivatedByUser();
    }

    @Override
    public void onlineAppEntered() {
        this.log.log(1078071040, "BaseOnlineComponent#onlineAppEntered()");
        this.applicationState.updateRedApp(true);
    }

    @Override
    public void onlineAppLeft() {
        this.log.log(1078071040, "BaseOnlineComponent#onlineAppLeft()");
        this.applicationState.updateRedApp(false);
    }

    @Override
    public void wlanHotspotActive(boolean bl) {
        this.log.log(-2137614336, "BaseOnlineComponent#wlanHotspotActive(): %1", bl);
        this.applicationState.updateWlan(bl);
    }

    @Override
    public void onlineCheckEntered() {
        this.log.log(-2137614336, "BaseOnlineComponent#onlineCheckEntered()");
        this.applicationState.updateCheck(true);
        this.errorHandler.errorShown(true);
    }

    @Override
    public void onlineCheckLeft() {
        this.log.log(-2137614336, "BaseOnlineComponent#onlineCheckLeft()");
        this.errorHandler.errorShown(false);
        this.applicationState.updateCheck(false);
    }

    @Override
    public void onlinePopupEntered() {
        this.log.log(-2137614336, "BaseOnlineComponent#onlinePopupEntered()");
    }

    @Override
    public void onlinePopupLeft() {
        this.log.log(-2137614336, "BaseOnlineComponent#onlinePopupLeft()");
    }

    @Override
    public void onlinePopupRemoved() {
        this.log.log(-2137614336, "BaseOnlineComponent#onlinePopupRemoved()");
        this.onlineCheckApplicationChoice.setValue(0);
    }

    @Override
    public void onlineRequestEntered(int n) {
        this.log.log(-2137614336, "BaseOnlineComponent#onlineRequestEntered(): %1", (long)n);
        this.errorHandler.notifyErrorShown(n, 14);
    }

    @Override
    public void telAppEntered() {
        this.log.log(1078071040, "BaseOnlineComponent#telAppEntered()");
        this.errorHandler.telAppEntered();
    }

    @Override
    public void telAppLeft() {
        this.log.log(1078071040, "BaseOnlineComponent#telAppLeft()");
        this.errorHandler.telAppLeft();
    }

    @Override
    public void telUnlockEntered() {
        this.log.log(1078071040, "BaseOnlineComponent#telUnlockEntered()");
        this.applicationState.updateTelUnlock(true);
    }

    @Override
    public void telUnlockLeft() {
        this.log.log(1078071040, "BaseOnlineComponent#telUnlockLeft()");
        this.applicationState.updateTelUnlock(false);
    }

    @Override
    public void hkTelPressed() {
        this.log.log(1078071040, "BaseOnlineComponent#hkTelPressed()");
        this.errorHandler.hkTelPressed();
    }

    @Override
    public void updateReconnectInfo(ReconnectInfo reconnectInfo) {
        this.errorHandler.updateReconnectInfo(reconnectInfo);
    }

    @Override
    public void updateWlanMode(boolean bl, boolean bl2) {
        this.log.log(1078071040, "BaseOnlineComponent#updateWlanMode(): is on=%1, client mode=%2", bl, bl2);
        this.errorHandler.updateWlanMode(bl, bl2);
    }

    @Override
    public void updateTrustedNetworks(boolean bl) {
        this.log.log(1078071040, "BaseOnlineComponent#updateTrustedNetworks(): %1", bl);
        this.errorHandler.updateTrustedNetworks(bl);
    }

    @Override
    public void onlineMapEntered() {
        this.log.log(1078071040, "BaseOnlineComponent#onlineMapEntered()");
        this.applicationState.updateMap(true);
    }

    @Override
    public void onlineMapLeft() {
        this.log.log(1078071040, "BaseOnlineComponent#onlineMapLeft()");
        this.applicationState.updateMap(false);
    }

    @Override
    public void enableOnlineDataConfiguration() {
    }

    @Override
    public void disableOnlineDataConfiguration() {
    }

    @Override
    public void connectivityDataOnlineCheckEntered() {
    }

    @Override
    public void connectivityDataOnlineCheckLeft() {
    }

    OnlineErrorState getErrorState() {
        return this.onlineErrorState;
    }

    @Override
    public void updateRoamingState(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        this.log.log(1078071040, "BaseOnlineComponent#updateRoamingState(): %1", (long)n);
        boolean bl = n == 11;
        this.onlineErrorState.updateRoamingState(bl);
    }

    @Override
    public void updateSimUsageToBeShown(boolean bl) {
        this.onlineErrorState.updateSimUsageToBeShown(bl);
    }

    @Override
    public void init() {
        super.init();
        this.serviceRegistration1 = this.dataApplication.getBundleContext().registerService((class$de$audi$app$data$core$online$IOnline == null ? (class$de$audi$app$data$core$online$IOnline = BaseOnlineComponent.class$("de.audi.app.data.core.online.IOnline")) : class$de$audi$app$data$core$online$IOnline).getName(), (Object)this, null);
        this.serviceRegistration2 = this.dataApplication.getBundleContext().registerService((class$de$audi$atip$interapp$IConnectivityNaviStateListener == null ? (class$de$audi$atip$interapp$IConnectivityNaviStateListener = BaseOnlineComponent.class$("de.audi.atip.interapp.IConnectivityNaviStateListener")) : class$de$audi$atip$interapp$IConnectivityNaviStateListener).getName(), (Object)this, null);
        this.serviceRegistration3 = this.dataApplication.getBundleContext().registerService((class$de$audi$atip$interapp$IConnectivitySimUsageListener == null ? (class$de$audi$atip$interapp$IConnectivitySimUsageListener = BaseOnlineComponent.class$("de.audi.atip.interapp.IConnectivitySimUsageListener")) : class$de$audi$atip$interapp$IConnectivitySimUsageListener).getName(), (Object)this, null);
        this.dataApplication.getDiag().addDiagnosisComponent((IDiagComponent)new BaseOnlineComponentDiag(this));
    }

    @Override
    public void deinit() {
        this.serviceRegistration1.unregister();
        this.serviceRegistration1 = null;
        this.serviceRegistration2.unregister();
        this.serviceRegistration2 = null;
        this.serviceRegistration3.unregister();
        this.serviceRegistration3 = null;
        super.deinit();
    }

    public String toString() {
        return new StringBuffer().append(this.onlineErrorState).append(";\n").append(this.applicationState).toString();
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

