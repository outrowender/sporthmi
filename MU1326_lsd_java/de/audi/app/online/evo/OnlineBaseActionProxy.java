/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.mobilekey.MobileKeyStatusDisplayController;
import de.audi.app.online.privacysettings.GPSPopupController;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.ap.OnlineActionProxy;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;

public class OnlineBaseActionProxy
implements OnlineActionProxy {
    public static final int REMOTE_HMI_COLOR_BLUE;
    public static final int REMOTE_HMI_COLOR_ORANGE;
    public static final int REMOTE_HMI_COLOR_RED;
    public static final int REMOTE_HMI_COLOR_WHITE;
    public static final int REMOTE_HMI_COLOR_GREEN;
    public static final int INCLUDE_STATE_CONNECTIVITY_MANAGER_ID;
    public static final int INCLUDE_STATE_NAVIGATION_ID;
    protected final LogChannel log;
    protected final OnlineModelBankAccess modelBankAccess;
    protected GPSPopupController gpsPopupController;
    protected MobileKeyStatusDisplayController mobileKeyStatusDisplayController;

    public OnlineBaseActionProxy(LogChannel logChannel, OnlineModelBankAccess onlineModelBankAccess) {
        this.log = logChannel;
        this.modelBankAccess = onlineModelBankAccess;
    }

    public void setGpsPopupController(GPSPopupController gPSPopupController) {
        this.log.log(1078071040, "OnlineBaseActionProxy#setGpsPopupController: %1", (Object)gPSPopupController);
        this.gpsPopupController = gPSPopupController;
    }

    public void setMobileKeyStatusDisplayController(MobileKeyStatusDisplayController mobileKeyStatusDisplayController) {
        this.log.log(1078071040, "OnlineBaseActionProxy#setMobileKeyStatusDisplayController: %1", (Object)mobileKeyStatusDisplayController);
        this.mobileKeyStatusDisplayController = mobileKeyStatusDisplayController;
    }

    @Override
    public void gpsPopupAcknowledged(int n) {
        this.log.log(1078071040, "OnlineBaseActionProxy#gpsPopupAcknowledged: Called.");
        if (this.gpsPopupController != null) {
            this.gpsPopupController.gpsPopupAcknowledged(n);
        } else {
            this.log.log(1078071040, "OnlineBaseActionProxy#gpsPopupAcknowledged: gpsPopupController is null, ignoring the action; please check the OnlineActivator.start(BundleContext) method");
        }
    }

    @Override
    public void requestMobileDeviceKeyCount(int n) {
        this.log.log(1078071040, "OnlineBaseActionProxy#requestMobileDeviceKeyCount: Called.");
        if (this.mobileKeyStatusDisplayController != null) {
            this.mobileKeyStatusDisplayController.requestMobileDeviceKeyCount();
        } else {
            this.log.log(1078071040, "OnlineBaseActionProxy#requestMobileDeviceKeyCount: mobileKeyStatusDisplayController is null, ignoring the action; please check the OnlineActivator.start(BundleContext) method");
        }
    }

    public void releasePresetScreenOverride(int n) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#releasePresetScreenOverride is not used anymore ans is not implemented!");
    }

    @Override
    public void remoteHmiEnterInMap(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHmiEnterInMap is not implemented.");
    }

    @Override
    public void exitConnectivityCheck(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#exitConnectivityCheck is not implemented.");
    }

    @Override
    public void remoteHmiHkReturn(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHmiHkReturn is not implemented.");
    }

    @Override
    public void remoteHmiEnter(int n, int n2) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHmiEnter is not implemented.");
    }

    @Override
    public void remoteHmiExit(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHmiExit is not implemented.");
    }

    @Override
    public void remoteHmiBrowserEntered(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHmiBrowserEntered is not implemented.");
    }

    @Override
    public void remoteHmiBrowserLeft(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHmiBrowserLeft is not implemented.");
    }

    @Override
    public void destOnlineStartDestinationImport(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#destOnlineStartDestinationImport is not implemented.");
    }

    @Override
    public void remoteHmiSetEntryPoint(int n, int n2) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHmiSetEntryPoint is not implemented.");
    }

    @Override
    public void remoteHmiClosedViaOptionDrawer(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHmiClosedViaOptionDrawer is not implemented.");
    }

    @Override
    public void remoteHmiLogOff(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHmiLogOff is not implemented.");
    }

    @Override
    public void remoteHMIAuthenticationInit(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHMIAuthenticationInit is not implemented.");
    }

    @Override
    public void remoteHMIStartKnownLogin(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHMIStartKnownLogin is not implemented.");
    }

    @Override
    public void enterRemoteHMIResultMap(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#enterRemoteHMIResultMap is not implemented.");
    }

    @Override
    public void remoteHMINavDestFormExit(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHMINavDestFormExit is not implemented.");
    }

    @Override
    public void remoteHmiMapExit(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHmiMapExit is not implemented.");
    }

    @Override
    public void licenseCheckEntered(int n, String string, String string2) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#licenseCheckEntered is not implemented.");
    }

    @Override
    public void remoteHmiLayoutConstants(int n, int n2, int n3, int n4) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHmiLayoutConstants is not implemented.");
    }

    @Override
    public void myAudiAuthContext(int n, int n2) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#myAudiAuthContext is not implemented.");
    }

    @Override
    public void myAudiAuthScreenType(int n, int n2) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#myAudiAuthScreenType is not implemented.");
    }

    @Override
    public void remoteHmiMiniAppErrorExit(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHmiMiniAppErrorExit is not implemented.");
    }

    @Override
    public void rhmiAuthenticationFinished(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#rhmiAuthenticationFinished is not implemented.");
    }

    @Override
    public void startOperatorCall(int n, int n2) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#startOperatorCall is not implemented.");
    }

    @Override
    public void remoteHmiHkReturnFromInclude(int n, int n2) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHmiHkReturnFromInclude is not implemented.");
    }

    @Override
    public void remoteHmiEnterInclude(int n, int n2) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHmiEnterInclude is not implemented.");
    }

    @Override
    public void remoteHmiHkReturnFromSelectionDrawer(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHmiHkReturnFromSelectionDrawer is not implemented.");
    }

    @Override
    public void remoteHmiMarkForTopLevel(int n, int n2) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHmiMarkForTopLevel is not implemented.");
    }

    @Override
    public void leaveCallcenterCall(int n, int n2) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#leaveCallcenterCall is not implemented.");
    }

    @Override
    public void remoteHmiListEnter(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHmiListEnter is not implemented.");
    }

    @Override
    public void remoteHmiListExit(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHmiListExit is not implemented.");
    }

    @Override
    public void authenticationLogoutFinished(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#authenticationLogoutFinished is not implemented.");
    }

    @Override
    public void remoteHmiOverrideNextAnimation(int n, int n2) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHmiOverrideNextAnimation is not implemented.");
    }

    @Override
    public void operatorCallChecksSuccessful(int n, int n2) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#operatorCallChecksSuccessful is not implemented.");
    }

    @Override
    public void operatorCallCenterLeft(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#operatorCallCenterLeft is not implemented.");
    }

    @Override
    public void operatorEndMsgLeft(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#operatorEndMsgLeft is not implemented.");
    }

    @Override
    public void operatorUpdateDetailInfo(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#operatorUpdateDetailInfo is not implemented.");
    }

    @Override
    public void connGatewayLeft(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#connGatewayLeft is not implemented.");
    }

    @Override
    public void remoteHmiToggleInclude(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHmiToggleInclude is not implemented.");
    }

    @Override
    public void remoteHMICallWifiPlayer(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHMICallWifiPlayer is not implemented.");
    }

    @Override
    public void remotehmiOnlineTrafficEntered(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remotehmiOnlineTrafficEntered is not implemented.");
    }

    @Override
    public void remotehmiEmailEntered(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remotehmiEmailEntered is not implemented.");
    }

    @Override
    public void remotehmiSmsEntered(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remotehmiSmsEntered is not implemented.");
    }

    @Override
    public void operatorCallCallActiveShown(int n, int n2) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#operatorCallCallActiveShown is not implemented.");
    }

    @Override
    public void remoteHmiPrepare(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHmiPrepare is not implemented.");
    }

    @Override
    public void operatorCallResultListEntered(int n, int n2) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#operatorCallResultListEntered is not implemented.");
    }

    @Override
    public void operatorCallResultListLeft(int n, int n2) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#operatorCallResultListLeft is not implemented.");
    }

    @Override
    public void licenseOverviewEntered(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#licenseOverviewEntered is not implemented.");
    }

    @Override
    public void licenseOverviewExited(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#licenseOverviewExited is not implemented.");
    }

    @Override
    public void remotehmiGoogleEarthEntered(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remotehmiGoogleEarthEntered is not implemented.");
    }

    @Override
    public void trafficLightEntered(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#trafficLightEntered is not implemented.");
    }

    @Override
    public void changePrivacySettingsScreenMode(int n, int n2) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#changePrivacySettingsScreenMode is not implemented.");
    }

    @Override
    public void remoteHMICallMediaApp(int n) {
        this.log.log(-2137614336, "OnlineBaseActionProxy#remoteHMICallMediaApp is not implemented.");
    }
}

