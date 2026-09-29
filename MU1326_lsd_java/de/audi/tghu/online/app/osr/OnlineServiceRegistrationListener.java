/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationDefaultListener;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$1;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$10;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$11;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$12;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$13;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$14;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$15;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$16;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$17;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$18;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$19;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$2;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$20;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$21;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$22;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$23;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$24;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$3;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$4;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$5;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$6;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$7;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$8;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener$9;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.online.DSIOnlineServiceRegistrationListener;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRNotifyPropertiesSL;
import org.dsi.ifc.online.OSRServiceListEntry;
import org.dsi.ifc.online.OSRServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public class OnlineServiceRegistrationListener
implements DSIOnlineServiceRegistrationListener,
ICommandResponseSupplier {
    private LogChannel logCh;
    private OnlineServiceRegistrationDefaultListener defaultListener;
    private CommandListManager cmdListMgr;

    public OnlineServiceRegistrationListener(LogChannel logChannel, CommandListManager commandListManager, OnlineServiceRegistrationDefaultListener onlineServiceRegistrationDefaultListener) {
        this.logCh = logChannel;
        this.defaultListener = onlineServiceRegistrationDefaultListener;
        this.logCh.log(-2137614336, "[OnlineServiceRegistrationListener#ctor] Called.");
        this.cmdListMgr = commandListManager;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logCh.log(-1601830656, "[OnlineServiceRegistrationListener#asyncException] Called, errorCode: %2, requestType: %3, errorMsg: %1", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void getOnlineApplicationListResponse(OSRApplication[] oSRApplicationArray) {
        this.logCh.log(14808325, "[OnlineServiceRegistrationListener#getOnlineApplicationListResponse]");
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$1(this, oSRApplicationArray));
    }

    @Override
    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
        this.logCh.log(14808325, "[OnlineServiceRegistrationListener#getOnlineApplicationResponse]");
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$2(this, oSRApplication));
    }

    @Override
    public void activateLicenseResponse(OSRLicense oSRLicense, int n) {
        this.logCh.log(14808325, "[OnlineServiceRegistrationListener#activateLicenseResponse]");
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$3(this, oSRLicense, n));
    }

    @Override
    public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray, int n) {
        this.logCh.log(14808325, "[OnlineServiceRegistrationListener#updateApplicationState] props.length=%1, valid: %2", (long)(oSRNotifyPropertiesArray == null ? 0 : oSRNotifyPropertiesArray.length), (long)n);
        if (this.logCh.isDebug2() && oSRNotifyPropertiesArray != null) {
            for (int i2 = 0; i2 < oSRNotifyPropertiesArray.length; ++i2) {
                this.logCh.log(14808325, "[OnlineServiceRegistrationListener#updateApplicationState] props[%2]: %1", (Object)oSRNotifyPropertiesArray[i2], (long)i2);
            }
        }
        if (n == 1 && oSRNotifyPropertiesArray != null) {
            CommandResponse.execute(this, new OnlineServiceRegistrationListener$4(this, oSRNotifyPropertiesArray, n));
        }
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return this.defaultListener;
    }

    @Override
    public CommandList getActiveCommandList() {
        return this.cmdListMgr.getActiveCommandList();
    }

    @Override
    public LogChannel getLogChannel() {
        return this.logCh;
    }

    @Override
    public String getHandlerName() {
        return super.getClass().getName();
    }

    @Override
    public void setCredentialResponse(String string, int n) {
        this.logCh.log(14808325, "[OnlineServiceRegistrationListener#setCredentialResponse]");
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$5(this, string, n));
    }

    @Override
    public void downloadResponse(String string, String string2, String string3, int n) {
        this.logCh.log(14808325, "[OnlineServiceRegistrationListener#downloadResponse]");
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$6(this, string, string2, string3, n));
    }

    @Override
    public void resetToFactorySettingsResponse(String string, int n) {
    }

    public void updateProfileInfo(int n, String string, String string2, int n2, int n3) {
        this.defaultListener.updateProfileInfo(n, string, string2, n2, n3);
    }

    @Override
    public void validateOwnerResponse(int n) {
    }

    @Override
    public void checkOwnersVerificationResponse(int n) {
    }

    public void validatePortalUserResponse(int n, String string, String string2, String string3, String string4, int n2) {
    }

    public void setAccountStateResponse(int n, String string, String string2, int n2) {
    }

    @Override
    public void performPortalRegistrationResponse(String string, int n) {
        this.logCh.log(14808325, "[OnlineServiceRegistrationListener#getUsersResponse()]");
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$7(this, string, n));
    }

    public void setActiveProfileResponse(int n, int n2, String string, String string2) {
    }

    @Override
    public void getUsersResponse(OSRUser[] oSRUserArray) {
        this.logCh.log(14808325, "[OnlineServiceRegistrationListener#getUsersResponse()]");
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$8(this, oSRUserArray));
    }

    @Override
    public void createUserWithPairingCodeResponse(String string, OSRUser oSRUser, int n) {
        this.logCh.log(14808325, "[OnlineServiceRegistrationListener#createUserWithPairingCodeResponse()]");
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$9(this, string, oSRUser, n));
    }

    @Override
    public void createUserWithUserPasswordResponse(String string, OSRUser oSRUser, int n) {
        this.logCh.log(14808325, "[OnlineServiceRegistrationListener#createUserWithUserPasswordResponse()]");
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$10(this, string, oSRUser, n));
    }

    @Override
    public void checkPasswordResponse(OSRUser oSRUser, int n) {
        this.logCh.log(14808325, "[OnlineServiceRegistrationListener#checkPasswordResponse()]");
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$11(this, oSRUser, n));
    }

    @Override
    public void checkPairingCodeResponse(OSRUser oSRUser, int n) {
        this.logCh.log(14808325, "[OnlineServiceRegistrationListener#checkPairingCodeResponse()]");
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$12(this, oSRUser, n));
    }

    @Override
    public void setPrivacyFlagsResponse(OSRUser oSRUser) {
        this.logCh.log(14808325, "[OnlineServiceRegistrationListener#setPrivacyFlagsResponse()]");
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$13(this, oSRUser));
    }

    @Override
    public void setAutoLoginResponse(OSRUser oSRUser, OSRDevice[] oSRDeviceArray, int[] nArray) {
        this.logCh.log(14808325, "[OnlineServiceRegistrationListener#setAutoLoginResponse()]");
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$14(this, oSRUser, oSRDeviceArray, nArray));
    }

    @Override
    public void loginResponse(OSRUser oSRUser, int n) {
        this.logCh.log(14808325, "[OnlineServiceRegistrationListener#loginResponse()]");
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$15(this, oSRUser, n));
    }

    @Override
    public void logoutResponse(OSRUser oSRUser, int n) {
        this.logCh.log(14808325, "[OnlineServiceRegistrationListener#logoutResponse()]");
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$16(this, oSRUser, n));
    }

    @Override
    public void logoutAuthSchemeResult(String string, OSRUser[] oSRUserArray, int[] nArray) {
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$17(this, string, oSRUserArray, nArray));
    }

    @Override
    public void removeUserResponse(OSRUser oSRUser, int n) {
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$18(this, oSRUser, n));
    }

    @Override
    public void getLicenseResponse(int n, OSRLicense oSRLicense) {
        this.logCh.log(14808325, "[OnlineServiceRegistrationListener#getLicenseResponse()]");
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$19(this, n, oSRLicense));
    }

    @Override
    public void getLicensesResponse(int n, boolean bl, boolean bl2, OSRLicense[] oSRLicenseArray) {
        this.logCh.log(14808325, "[OnlineServiceRegistrationListener#getLicensesResponse()]");
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$20(this, n, bl, bl2, oSRLicenseArray));
    }

    @Override
    public void getProfileFolderResponse(int n, String string, OSRUser oSRUser, String string2) {
        this.logCh.log(14808325, "[OnlineServiceRegistrationListener#getProfileFolderResponse()]");
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$21(this, n, string, oSRUser, string2));
    }

    @Override
    public void updateCoreProfileInfo(OSRUser oSRUser, int n, int n2) {
        this.logCh.log(1078071040, "OnlineServiceRegistrationListener#updateCoreProfileInfo passing forward to defaultListener");
        this.defaultListener.updateCoreProfileInfo(oSRUser, n, n2);
    }

    @Override
    public void updateExternalProfileInfo(String string, OSRUser oSRUser, int n, int n2) {
        this.logCh.log(1078071040, "OnlineServiceRegistrationListener#updateExternalProfileInfo passing forward to defaultListener");
        this.defaultListener.updateExternalProfileInfo(string, oSRUser, n, n2);
    }

    @Override
    public void updateDeviceEnumerator(OSRDevice oSRDevice, int n, int n2) {
        this.defaultListener.updateDeviceEnumerator(oSRDevice, n, n2);
    }

    @Override
    public void getCredentialsFromHeaderResponse(int n, int n2, int n3, String string, String string2, String string3) {
    }

    @Override
    public void getCredentialsFromAuthSchemeResponse(int n, int n2, String string, String string2, String string3) {
    }

    @Override
    public void getServiceURLResponse(int n, String string, String string2) {
    }

    @Override
    public void precheckOnlineServiceServiceIDResponse(String string, OSRServiceState oSRServiceState) {
        this.logCh.log(14808325, "[OnlineServiceRegistrationListener#precheckOnlineServiceServiceIDResponse()]");
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$22(this, string, oSRServiceState));
    }

    @Override
    public void precheckOnlineServiceSymbolicNameResponse(String string, OSRServiceState oSRServiceState) {
        this.logCh.log(14808325, "[OnlineServiceRegistrationListener#precheckOnlineServiceSymbolicNameResponse()]");
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$23(this, string, oSRServiceState));
    }

    @Override
    public void precheckOnlineServiceResponse(String string, OSRServiceState[] oSRServiceStateArray) {
        this.logCh.log(14808325, "[OnlineServiceRegistrationListener#precheckOnlineServiceResponse()]");
        CommandResponse.execute(this, new OnlineServiceRegistrationListener$24(this, string, oSRServiceStateArray));
    }

    @Override
    public void updateServiceState(int n, int n2) {
        this.defaultListener.updateServiceState(n, n2);
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }

    @Override
    public void downloadRawResponse(String string, String string2, String string3, ResourceLocator resourceLocator, int n) {
    }

    @Override
    public void updateServices(OSRNotifyPropertiesSL[] oSRNotifyPropertiesSLArray, int n) {
    }

    @Override
    public void updateServiceList(OSRServiceListEntry[] oSRServiceListEntryArray, int n) {
    }

    @Override
    public void updateServiceRegistration(String string, OSRServiceRegistration oSRServiceRegistration, int n, int n2) {
    }

    @Override
    public void setServiceStateResponse(OSRServiceState oSRServiceState) {
    }

    @Override
    public void setDemandStateServiceIDResponse(String string, int n) {
    }

    @Override
    public void setServiceStateSymbolicNameResponse(OSRServiceState oSRServiceState) {
    }

    @Override
    public void setActivePrivacyCategoryMaskResponse(int n) {
    }

    @Override
    public void submitServiceStateChangesToBackendResponse(int n) {
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
    }

    @Override
    public void profileChanged(int n, int n2) {
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
    }

    @Override
    public void profileReset(int n, int n2) {
    }

    @Override
    public void profileResetAll(int n) {
    }

    @Override
    public void setGPSUseModeResponse(int n) {
    }

    @Override
    public void setInventoryFinishedResponse(int n) {
    }

    @Override
    public void updateSPINRequired(String string, String string2, int n) {
    }

    @Override
    public void setSPINResponse(String string, String string2, int n, int n2) {
    }

    @Override
    public void getSPINHashResult(String string, String string2, int n, String string3, String string4, int n2) {
    }
}

