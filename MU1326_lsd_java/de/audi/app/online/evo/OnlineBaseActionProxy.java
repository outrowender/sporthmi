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
    public static final int REMOTE_HMI_COLOR_BLUE = 1;
    public static final int REMOTE_HMI_COLOR_ORANGE = 2;
    public static final int REMOTE_HMI_COLOR_RED = 3;
    public static final int REMOTE_HMI_COLOR_WHITE = 4;
    public static final int REMOTE_HMI_COLOR_GREEN = 5;
    public static final int INCLUDE_STATE_CONNECTIVITY_MANAGER_ID = 1;
    public static final int INCLUDE_STATE_NAVIGATION_ID = 2;
    protected final LogChannel log;
    protected final OnlineModelBankAccess modelBankAccess;
    protected GPSPopupController gpsPopupController;
    protected MobileKeyStatusDisplayController mobileKeyStatusDisplayController;

    public OnlineBaseActionProxy(LogChannel logChannel, OnlineModelBankAccess onlineModelBankAccess) {
        this.log = logChannel;
        this.modelBankAccess = onlineModelBankAccess;
    }

    public void setGpsPopupController(GPSPopupController gPSPopupController) {
        this.log.log(1000000, "OnlineBaseActionProxy#setGpsPopupController: %1", (Object)gPSPopupController);
        this.gpsPopupController = gPSPopupController;
    }

    public void setMobileKeyStatusDisplayController(MobileKeyStatusDisplayController mobileKeyStatusDisplayController) {
        this.log.log(1000000, "OnlineBaseActionProxy#setMobileKeyStatusDisplayController: %1", (Object)mobileKeyStatusDisplayController);
        this.mobileKeyStatusDisplayController = mobileKeyStatusDisplayController;
    }

    public void gpsPopupAcknowledged(int n) {
        this.log.log(1000000, "OnlineBaseActionProxy#gpsPopupAcknowledged: Called.");
        if (this.gpsPopupController != null) {
            this.gpsPopupController.gpsPopupAcknowledged(n);
        } else {
            this.log.log(1000000, "OnlineBaseActionProxy#gpsPopupAcknowledged: gpsPopupController is null, ignoring the action; please check the OnlineActivator.start(BundleContext) method");
        }
    }

    public void requestMobileDeviceKeyCount(int n) {
        this.log.log(1000000, "OnlineBaseActionProxy#requestMobileDeviceKeyCount: Called.");
        if (this.mobileKeyStatusDisplayController != null) {
            this.mobileKeyStatusDisplayController.requestMobileDeviceKeyCount();
        } else {
            this.log.log(1000000, "OnlineBaseActionProxy#requestMobileDeviceKeyCount: mobileKeyStatusDisplayController is null, ignoring the action; please check the OnlineActivator.start(BundleContext) method");
        }
    }

    public void releasePresetScreenOverride(int n) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#releasePresetScreenOverride is not used anymore ans is not implemented!");
    }

    public void remoteHmiEnterInMap(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHmiEnterInMap is not implemented.");
    }

    public void exitConnectivityCheck(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#exitConnectivityCheck is not implemented.");
    }

    public void remoteHmiHkReturn(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHmiHkReturn is not implemented.");
    }

    public void remoteHmiEnter(int n, int n2) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHmiEnter is not implemented.");
    }

    public void remoteHmiExit(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHmiExit is not implemented.");
    }

    public void remoteHmiBrowserEntered(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHmiBrowserEntered is not implemented.");
    }

    public void remoteHmiBrowserLeft(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHmiBrowserLeft is not implemented.");
    }

    public void destOnlineStartDestinationImport(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#destOnlineStartDestinationImport is not implemented.");
    }

    public void remoteHmiSetEntryPoint(int n, int n2) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHmiSetEntryPoint is not implemented.");
    }

    public void remoteHmiClosedViaOptionDrawer(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHmiClosedViaOptionDrawer is not implemented.");
    }

    public void remoteHmiLogOff(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHmiLogOff is not implemented.");
    }

    public void remoteHMIAuthenticationInit(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHMIAuthenticationInit is not implemented.");
    }

    public void remoteHMIStartKnownLogin(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHMIStartKnownLogin is not implemented.");
    }

    public void enterRemoteHMIResultMap(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#enterRemoteHMIResultMap is not implemented.");
    }

    public void remoteHMINavDestFormExit(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHMINavDestFormExit is not implemented.");
    }

    public void remoteHmiMapExit(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHmiMapExit is not implemented.");
    }

    public void licenseCheckEntered(int n, String string, String string2) {
        this.log.log(10000000, "OnlineBaseActionProxy#licenseCheckEntered is not implemented.");
    }

    public void remoteHmiLayoutConstants(int n, int n2, int n3, int n4) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHmiLayoutConstants is not implemented.");
    }

    public void myAudiAuthContext(int n, int n2) {
        this.log.log(10000000, "OnlineBaseActionProxy#myAudiAuthContext is not implemented.");
    }

    public void myAudiAuthScreenType(int n, int n2) {
        this.log.log(10000000, "OnlineBaseActionProxy#myAudiAuthScreenType is not implemented.");
    }

    public void remoteHmiMiniAppErrorExit(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHmiMiniAppErrorExit is not implemented.");
    }

    public void rhmiAuthenticationFinished(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#rhmiAuthenticationFinished is not implemented.");
    }

    public void startOperatorCall(int n, int n2) {
        this.log.log(10000000, "OnlineBaseActionProxy#startOperatorCall is not implemented.");
    }

    public void remoteHmiHkReturnFromInclude(int n, int n2) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHmiHkReturnFromInclude is not implemented.");
    }

    public void remoteHmiEnterInclude(int n, int n2) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHmiEnterInclude is not implemented.");
    }

    public void remoteHmiHkReturnFromSelectionDrawer(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHmiHkReturnFromSelectionDrawer is not implemented.");
    }

    public void remoteHmiMarkForTopLevel(int n, int n2) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHmiMarkForTopLevel is not implemented.");
    }

    public void leaveCallcenterCall(int n, int n2) {
        this.log.log(10000000, "OnlineBaseActionProxy#leaveCallcenterCall is not implemented.");
    }

    public void remoteHmiListEnter(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHmiListEnter is not implemented.");
    }

    public void remoteHmiListExit(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHmiListExit is not implemented.");
    }

    public void authenticationLogoutFinished(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#authenticationLogoutFinished is not implemented.");
    }

    public void remoteHmiOverrideNextAnimation(int n, int n2) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHmiOverrideNextAnimation is not implemented.");
    }

    public void operatorCallChecksSuccessful(int n, int n2) {
        this.log.log(10000000, "OnlineBaseActionProxy#operatorCallChecksSuccessful is not implemented.");
    }

    public void operatorCallCenterLeft(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#operatorCallCenterLeft is not implemented.");
    }

    public void operatorEndMsgLeft(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#operatorEndMsgLeft is not implemented.");
    }

    public void operatorUpdateDetailInfo(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#operatorUpdateDetailInfo is not implemented.");
    }

    public void connGatewayLeft(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#connGatewayLeft is not implemented.");
    }

    public void remoteHmiToggleInclude(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHmiToggleInclude is not implemented.");
    }

    public void remoteHMICallWifiPlayer(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHMICallWifiPlayer is not implemented.");
    }

    public void remotehmiOnlineTrafficEntered(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remotehmiOnlineTrafficEntered is not implemented.");
    }

    public void remotehmiEmailEntered(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remotehmiEmailEntered is not implemented.");
    }

    public void remotehmiSmsEntered(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remotehmiSmsEntered is not implemented.");
    }

    public void operatorCallCallActiveShown(int n, int n2) {
        this.log.log(10000000, "OnlineBaseActionProxy#operatorCallCallActiveShown is not implemented.");
    }

    public void remoteHmiPrepare(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHmiPrepare is not implemented.");
    }

    public void operatorCallResultListEntered(int n, int n2) {
        this.log.log(10000000, "OnlineBaseActionProxy#operatorCallResultListEntered is not implemented.");
    }

    public void operatorCallResultListLeft(int n, int n2) {
        this.log.log(10000000, "OnlineBaseActionProxy#operatorCallResultListLeft is not implemented.");
    }

    public void licenseOverviewEntered(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#licenseOverviewEntered is not implemented.");
    }

    public void licenseOverviewExited(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#licenseOverviewExited is not implemented.");
    }

    public void remotehmiGoogleEarthEntered(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remotehmiGoogleEarthEntered is not implemented.");
    }

    public void trafficLightEntered(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#trafficLightEntered is not implemented.");
    }

    public void changePrivacySettingsScreenMode(int n, int n2) {
        this.log.log(10000000, "OnlineBaseActionProxy#changePrivacySettingsScreenMode is not implemented.");
    }

    public void remoteHMICallMediaApp(int n) {
        this.log.log(10000000, "OnlineBaseActionProxy#remoteHMICallMediaApp is not implemented.");
    }
}

