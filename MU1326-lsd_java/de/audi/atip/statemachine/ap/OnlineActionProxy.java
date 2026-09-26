/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface OnlineActionProxy
extends ActionProxy {
    default public void remoteHmiEnterInMap(int n) {
    }

    default public void exitConnectivityCheck(int n) {
    }

    default public void remoteHmiHkReturn(int n) {
    }

    default public void remoteHmiEnter(int n, int n2) {
    }

    default public void remoteHmiExit(int n) {
    }

    default public void remoteHmiBrowserEntered(int n) {
    }

    default public void remoteHmiBrowserLeft(int n) {
    }

    default public void destOnlineStartDestinationImport(int n) {
    }

    default public void remoteHmiSetEntryPoint(int n, int n2) {
    }

    default public void remoteHmiClosedViaOptionDrawer(int n) {
    }

    default public void remoteHmiLogOff(int n) {
    }

    default public void remoteHMIAuthenticationInit(int n) {
    }

    default public void remoteHMIStartKnownLogin(int n) {
    }

    default public void enterRemoteHMIResultMap(int n) {
    }

    default public void remoteHMINavDestFormExit(int n) {
    }

    default public void remoteHmiMapExit(int n) {
    }

    default public void licenseCheckEntered(int n, String string, String string2) {
    }

    default public void remoteHmiLayoutConstants(int n, int n2, int n3, int n4) {
    }

    default public void myAudiAuthContext(int n, int n2) {
    }

    default public void remoteHmiMiniAppErrorExit(int n) {
    }

    default public void rhmiAuthenticationFinished(int n) {
    }

    default public void startOperatorCall(int n, int n2) {
    }

    default public void remoteHmiHkReturnFromInclude(int n, int n2) {
    }

    default public void remoteHmiEnterInclude(int n, int n2) {
    }

    default public void remoteHmiHkReturnFromSelectionDrawer(int n) {
    }

    default public void remoteHmiMarkForTopLevel(int n, int n2) {
    }

    default public void leaveCallcenterCall(int n, int n2) {
    }

    default public void remoteHmiListEnter(int n) {
    }

    default public void remoteHmiListExit(int n) {
    }

    default public void authenticationLogoutFinished(int n) {
    }

    default public void remoteHmiOverrideNextAnimation(int n, int n2) {
    }

    default public void operatorCallChecksSuccessful(int n, int n2) {
    }

    default public void operatorCallCenterLeft(int n) {
    }

    default public void operatorEndMsgLeft(int n) {
    }

    default public void operatorUpdateDetailInfo(int n) {
    }

    default public void connGatewayLeft(int n) {
    }

    default public void remoteHmiToggleInclude(int n) {
    }

    default public void remoteHMICallWifiPlayer(int n) {
    }

    default public void remotehmiOnlineTrafficEntered(int n) {
    }

    default public void remotehmiEmailEntered(int n) {
    }

    default public void remotehmiSmsEntered(int n) {
    }

    default public void operatorCallCallActiveShown(int n, int n2) {
    }

    default public void remoteHmiPrepare(int n) {
    }

    default public void operatorCallResultListEntered(int n, int n2) {
    }

    default public void operatorCallResultListLeft(int n, int n2) {
    }

    default public void licenseOverviewEntered(int n) {
    }

    default public void licenseOverviewExited(int n) {
    }

    default public void remotehmiGoogleEarthEntered(int n) {
    }

    default public void trafficLightEntered(int n) {
    }

    default public void gpsPopupAcknowledged(int n) {
    }

    default public void changePrivacySettingsScreenMode(int n, int n2) {
    }

    default public void myAudiAuthScreenType(int n, int n2) {
    }

    default public void requestMobileDeviceKeyCount(int n) {
    }

    default public void remoteHMICallMediaApp(int n) {
    }
}

