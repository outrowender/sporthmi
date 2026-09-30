/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface OnlineActionProxy
extends ActionProxy {
    public void remoteHmiEnterInMap(int var1);

    public void exitConnectivityCheck(int var1);

    public void remoteHmiHkReturn(int var1);

    public void remoteHmiEnter(int var1, int var2);

    public void remoteHmiExit(int var1);

    public void remoteHmiBrowserEntered(int var1);

    public void remoteHmiBrowserLeft(int var1);

    public void destOnlineStartDestinationImport(int var1);

    public void remoteHmiSetEntryPoint(int var1, int var2);

    public void remoteHmiClosedViaOptionDrawer(int var1);

    public void remoteHmiLogOff(int var1);

    public void remoteHMIAuthenticationInit(int var1);

    public void remoteHMIStartKnownLogin(int var1);

    public void enterRemoteHMIResultMap(int var1);

    public void remoteHMINavDestFormExit(int var1);

    public void remoteHmiMapExit(int var1);

    public void licenseCheckEntered(int var1, String var2, String var3);

    public void remoteHmiLayoutConstants(int var1, int var2, int var3, int var4);

    public void myAudiAuthContext(int var1, int var2);

    public void remoteHmiMiniAppErrorExit(int var1);

    public void rhmiAuthenticationFinished(int var1);

    public void startOperatorCall(int var1, int var2);

    public void remoteHmiHkReturnFromInclude(int var1, int var2);

    public void remoteHmiEnterInclude(int var1, int var2);

    public void remoteHmiHkReturnFromSelectionDrawer(int var1);

    public void remoteHmiMarkForTopLevel(int var1, int var2);

    public void leaveCallcenterCall(int var1, int var2);

    public void remoteHmiListEnter(int var1);

    public void remoteHmiListExit(int var1);

    public void authenticationLogoutFinished(int var1);

    public void remoteHmiOverrideNextAnimation(int var1, int var2);

    public void operatorCallChecksSuccessful(int var1, int var2);

    public void operatorCallCenterLeft(int var1);

    public void operatorEndMsgLeft(int var1);

    public void operatorUpdateDetailInfo(int var1);

    public void connGatewayLeft(int var1);

    public void remoteHmiToggleInclude(int var1);

    public void remoteHMICallWifiPlayer(int var1);

    public void remotehmiOnlineTrafficEntered(int var1);

    public void remotehmiEmailEntered(int var1);

    public void remotehmiSmsEntered(int var1);

    public void operatorCallCallActiveShown(int var1, int var2);

    public void remoteHmiPrepare(int var1);

    public void operatorCallResultListEntered(int var1, int var2);

    public void operatorCallResultListLeft(int var1, int var2);

    public void licenseOverviewEntered(int var1);

    public void licenseOverviewExited(int var1);

    public void remotehmiGoogleEarthEntered(int var1);

    public void trafficLightEntered(int var1);

    public void gpsPopupAcknowledged(int var1);

    public void changePrivacySettingsScreenMode(int var1, int var2);

    public void myAudiAuthScreenType(int var1, int var2);

    public void requestMobileDeviceKeyCount(int var1);

    public void remoteHMICallMediaApp(int var1);
}

