/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command;

import de.audi.tghu.command.Command;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationSubsystem;
import de.audi.tghu.online.app.osr.command.OSRCommandList;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
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

public abstract class AbstractOSRCommand
extends Command
implements DSIOnlineServiceRegistrationListener {
    protected final long COMMAND_TIMEOUT_HIGHER;
    protected OnlineServiceRegistrationSubsystem application;

    public AbstractOSRCommand() {
        this((String)null);
    }

    public AbstractOSRCommand(String string) {
        super(null, string);
        this.COMMAND_TIMEOUT_HIGHER = 65000L;
    }

    protected DSIOnlineServiceRegistration getDSI() {
        return this.application.getDsi();
    }

    private void init(OnlineServiceRegistrationSubsystem onlineServiceRegistrationSubsystem) {
        this.logger = onlineServiceRegistrationSubsystem.getLogChannel();
        this.application = onlineServiceRegistrationSubsystem;
    }

    protected OnlineServiceRegistrationSubsystem getApplication() {
        return this.application;
    }

    public void setCommandList(ICommandList iCommandList) {
        super.setCommandList(iCommandList);
        if (!(iCommandList instanceof OSRCommandList)) {
            throw new ClassCastException("Expected ORSCommandList!");
        }
        this.init(((OSRCommandList)iCommandList).getApplication());
    }

    public void getOnlineApplicationListResponse(OSRApplication[] oSRApplicationArray) {
        this.application.getDefaultListener().getOnlineApplicationListResponse(oSRApplicationArray);
    }

    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
        this.application.getDefaultListener().getOnlineApplicationResponse(oSRApplication);
    }

    public void activateLicenseResponse(OSRLicense oSRLicense, int n) {
        this.application.getDefaultListener().activateLicenseResponse(oSRLicense, n);
    }

    public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray, int n) {
        this.application.getDefaultListener().updateApplicationState(oSRNotifyPropertiesArray, n);
    }

    public void getServiceListResponse(int n) {
        this.application.getDefaultListener().getServiceListResponse(n);
    }

    public void setCredentialResponse(String string, int n) {
        this.application.getDefaultListener().setCredentialResponse(string, n);
    }

    public void validatePairingCodeResponse(String string, int n) {
        this.application.getDefaultListener().validatePairingCodeResponse(string, n);
    }

    public void checkValidCredentialResponse(String string, int n) {
        this.application.getDefaultListener().checkValidCredentialResponse(string, n);
    }

    public void resetToFactorySettingsResponse(String string, int n) {
        this.application.getDefaultListener().resetToFactorySettingsResponse(string, n);
    }

    public void updateProfileInfo(int n, String string, String string2, int n2, int n3) {
        this.application.getDefaultListener().updateProfileInfo(n, string, string2, n2, n3);
    }

    public void validateOwnerResponse(int n) {
        this.application.getDefaultListener().validateOwnerResponse(n);
    }

    public void checkOwnersVerificationResponse(int n) {
        this.application.getDefaultListener().checkOwnersVerificationResponse(n);
    }

    public void validatePortalUserResponse(int n, String string, String string2, String string3, String string4, int n2) {
        this.application.getDefaultListener().validatePortalUserResponse(n, string, string2, string3, string4, n2);
    }

    public void setAccountStateResponse(int n, String string, String string2, int n2) {
        this.application.getDefaultListener().setAccountStateResponse(n, string, string2, n2);
    }

    public void performPortalRegistrationResponse(String string, int n) {
        this.application.getDefaultListener().performPortalRegistrationResponse(string, n);
    }

    public void setActiveProfileResponse(int n, int n2, String string, String string2) {
        this.application.getDefaultListener().setActiveProfileResponse(n, n2, string, string2);
    }

    public void getUsersResponse(OSRUser[] oSRUserArray) {
        this.application.getDefaultListener().getUsersResponse(oSRUserArray);
    }

    public void createUserWithPairingCodeResponse(String string, OSRUser oSRUser, int n) {
        this.application.getDefaultListener().createUserWithPairingCodeResponse(string, oSRUser, n);
    }

    public void createUserWithUserPasswordResponse(String string, OSRUser oSRUser, int n) {
        this.application.getDefaultListener().createUserWithUserPasswordResponse(string, oSRUser, n);
    }

    public void checkPasswordResponse(OSRUser oSRUser, int n) {
        this.application.getDefaultListener().checkPasswordResponse(oSRUser, n);
    }

    public void checkPairingCodeResponse(OSRUser oSRUser, int n) {
        this.application.getDefaultListener().checkPairingCodeResponse(oSRUser, n);
    }

    public void setPrivacyFlagsResponse(OSRUser oSRUser) {
        this.application.getDefaultListener().setPrivacyFlagsResponse(oSRUser);
    }

    public void setAutoLoginResponse(OSRUser oSRUser, OSRDevice[] oSRDeviceArray, int[] nArray) {
        this.application.getDefaultListener().setAutoLoginResponse(oSRUser, oSRDeviceArray, nArray);
    }

    public void loginResponse(OSRUser oSRUser, int n) {
        this.application.getDefaultListener().loginResponse(oSRUser, n);
    }

    public void logoutResponse(OSRUser oSRUser, int n) {
        this.application.getDefaultListener().logoutResponse(oSRUser, n);
    }

    public void logoutAuthSchemeResult(String string, OSRUser[] oSRUserArray, int[] nArray) {
        this.application.getDefaultListener().logoutAuthSchemeResult(string, oSRUserArray, nArray);
    }

    public void removeUserResponse(OSRUser oSRUser, int n) {
        this.application.getDefaultListener().removeUserResponse(oSRUser, n);
    }

    public void getLicenseResponse(int n, OSRLicense oSRLicense) {
        this.application.getDefaultListener().getLicenseResponse(n, oSRLicense);
    }

    public void getLicensesResponse(int n, boolean bl, boolean bl2, OSRLicense[] oSRLicenseArray) {
        this.application.getDefaultListener().getLicensesResponse(n, bl, bl2, oSRLicenseArray);
    }

    public void getProfileFolderResponse(int n, String string, OSRUser oSRUser, String string2) {
        this.application.getDefaultListener().getProfileFolderResponse(n, string, oSRUser, string2);
    }

    public void updateCoreProfileInfo(OSRUser oSRUser, int n, int n2) {
        this.application.getDefaultListener().updateCoreProfileInfo(oSRUser, n, n2);
    }

    public void updateExternalProfileInfo(String string, OSRUser oSRUser, int n, int n2) {
        this.application.getDefaultListener().updateExternalProfileInfo(string, oSRUser, n, n2);
    }

    public void updateDeviceEnumerator(OSRDevice oSRDevice, int n, int n2) {
        this.application.getDefaultListener().updateDeviceEnumerator(oSRDevice, n, n2);
    }

    public void getCredentialsFromHeaderResponse(int n, int n2, int n3, String string, String string2, String string3) {
        this.application.getDefaultListener().getCredentialsFromHeaderResponse(n, n2, n3, string, string2, string3);
    }

    public void getCredentialsFromAuthSchemeResponse(int n, int n2, String string, String string2, String string3) {
        this.application.getDefaultListener().getCredentialsFromAuthSchemeResponse(n, n2, string, string2, string3);
    }

    public void getServiceURLResponse(int n, String string, String string2) {
        this.application.getDefaultListener().getServiceURLResponse(n, string, string2);
    }

    public AbstractOSRCommand cancelCommand() {
        return null;
    }

    public void updateServiceState(int n, int n2) {
        this.application.getDefaultListener().updateServiceState(n, n2);
    }

    public void precheckOnlineServiceServiceIDResponse(String string, OSRServiceState oSRServiceState) {
        this.application.getDefaultListener().precheckOnlineServiceServiceIDResponse(string, oSRServiceState);
    }

    public void precheckOnlineServiceSymbolicNameResponse(String string, OSRServiceState oSRServiceState) {
        this.application.getDefaultListener().precheckOnlineServiceSymbolicNameResponse(string, oSRServiceState);
    }

    public void precheckOnlineServiceResponse(String string, OSRServiceState[] oSRServiceStateArray) {
        this.application.getDefaultListener().precheckOnlineServiceResponse(string, oSRServiceStateArray);
    }

    public void downloadRawResponse(String string, String string2, String string3, ResourceLocator resourceLocator, int n) {
        this.application.getDefaultListener().downloadRawResponse(string, string2, string3, resourceLocator, n);
    }

    public void updateServices(OSRNotifyPropertiesSL[] oSRNotifyPropertiesSLArray, int n) {
        this.application.getDefaultListener().updateServices(oSRNotifyPropertiesSLArray, n);
    }

    public void updateServiceList(OSRServiceListEntry[] oSRServiceListEntryArray, int n) {
        this.application.getDefaultListener().updateServiceList(oSRServiceListEntryArray, n);
    }

    public void updateServiceRegistration(String string, OSRServiceRegistration oSRServiceRegistration, int n, int n2) {
        this.application.getDefaultListener().updateServiceRegistration(string, oSRServiceRegistration, n, n2);
    }

    public void setServiceStateResponse(OSRServiceState oSRServiceState) {
        this.application.getDefaultListener().setServiceStateResponse(oSRServiceState);
    }

    public void setDemandStateServiceIDResponse(String string, int n) {
        this.application.getDefaultListener().setDemandStateServiceIDResponse(string, n);
    }

    public void setServiceStateSymbolicNameResponse(OSRServiceState oSRServiceState) {
        this.application.getDefaultListener().setServiceStateSymbolicNameResponse(oSRServiceState);
    }

    public void setActivePrivacyCategoryMaskResponse(int n) {
        this.application.getDefaultListener().setActivePrivacyCategoryMaskResponse(n);
    }

    public void submitServiceStateChangesToBackendResponse(int n) {
        this.application.getDefaultListener().submitServiceStateChangesToBackendResponse(n);
    }

    public void updateProfileState(int n, int n2, int n3) {
        this.application.getDefaultListener().updateProfileState(n, n2, n3);
    }

    public void profileChanged(int n, int n2) {
        this.application.getDefaultListener().profileChanged(n, n2);
    }

    public void profileCopied(int n, int n2, int n3) {
        this.application.getDefaultListener().profileCopied(n, n2, n3);
    }

    public void profileReset(int n, int n2) {
        this.application.getDefaultListener().profileReset(n, n2);
    }

    public void profileResetAll(int n) {
        this.application.getDefaultListener().profileResetAll(n);
    }

    public void setGPSUseModeResponse(int n) {
        this.application.getDefaultListener().setGPSUseModeResponse(n);
    }

    public void setInventoryFinishedResponse(int n) {
        this.application.getDefaultListener().setInventoryFinishedResponse(n);
    }

    public abstract void execute();

    public void updateSPINRequired(String string, String string2, int n) {
        this.application.getDefaultListener().updateSPINRequired(string, string2, n);
    }

    public void setSPINResponse(String string, String string2, int n, int n2) {
        this.application.getDefaultListener().setSPINResponse(string, string2, n, n2);
    }

    public void getSPINHashResult(String string, String string2, int n, String string3, String string4, int n2) {
        this.application.getDefaultListener().getSPINHashResult(string, string2, n, string3, string4, n2);
    }

    public void downloadResponse(String string, String string2, String string3, int n) {
        this.application.getDefaultListener().downloadResponse(string, string2, string3, n);
    }
}

