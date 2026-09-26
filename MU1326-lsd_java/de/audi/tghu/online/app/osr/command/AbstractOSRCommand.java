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
        this.COMMAND_TIMEOUT_HIGHER = 0;
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

    @Override
    public void setCommandList(ICommandList iCommandList) {
        super.setCommandList(iCommandList);
        if (!(iCommandList instanceof OSRCommandList)) {
            throw new ClassCastException("Expected ORSCommandList!");
        }
        this.init(((OSRCommandList)iCommandList).getApplication());
    }

    @Override
    public void getOnlineApplicationListResponse(OSRApplication[] oSRApplicationArray) {
        this.application.getDefaultListener().getOnlineApplicationListResponse(oSRApplicationArray);
    }

    @Override
    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
        this.application.getDefaultListener().getOnlineApplicationResponse(oSRApplication);
    }

    @Override
    public void activateLicenseResponse(OSRLicense oSRLicense, int n) {
        this.application.getDefaultListener().activateLicenseResponse(oSRLicense, n);
    }

    @Override
    public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray, int n) {
        this.application.getDefaultListener().updateApplicationState(oSRNotifyPropertiesArray, n);
    }

    public void getServiceListResponse(int n) {
        this.application.getDefaultListener().getServiceListResponse(n);
    }

    @Override
    public void setCredentialResponse(String string, int n) {
        this.application.getDefaultListener().setCredentialResponse(string, n);
    }

    public void validatePairingCodeResponse(String string, int n) {
        this.application.getDefaultListener().validatePairingCodeResponse(string, n);
    }

    public void checkValidCredentialResponse(String string, int n) {
        this.application.getDefaultListener().checkValidCredentialResponse(string, n);
    }

    @Override
    public void resetToFactorySettingsResponse(String string, int n) {
        this.application.getDefaultListener().resetToFactorySettingsResponse(string, n);
    }

    public void updateProfileInfo(int n, String string, String string2, int n2, int n3) {
        this.application.getDefaultListener().updateProfileInfo(n, string, string2, n2, n3);
    }

    @Override
    public void validateOwnerResponse(int n) {
        this.application.getDefaultListener().validateOwnerResponse(n);
    }

    @Override
    public void checkOwnersVerificationResponse(int n) {
        this.application.getDefaultListener().checkOwnersVerificationResponse(n);
    }

    public void validatePortalUserResponse(int n, String string, String string2, String string3, String string4, int n2) {
        this.application.getDefaultListener().validatePortalUserResponse(n, string, string2, string3, string4, n2);
    }

    public void setAccountStateResponse(int n, String string, String string2, int n2) {
        this.application.getDefaultListener().setAccountStateResponse(n, string, string2, n2);
    }

    @Override
    public void performPortalRegistrationResponse(String string, int n) {
        this.application.getDefaultListener().performPortalRegistrationResponse(string, n);
    }

    public void setActiveProfileResponse(int n, int n2, String string, String string2) {
        this.application.getDefaultListener().setActiveProfileResponse(n, n2, string, string2);
    }

    @Override
    public void getUsersResponse(OSRUser[] oSRUserArray) {
        this.application.getDefaultListener().getUsersResponse(oSRUserArray);
    }

    @Override
    public void createUserWithPairingCodeResponse(String string, OSRUser oSRUser, int n) {
        this.application.getDefaultListener().createUserWithPairingCodeResponse(string, oSRUser, n);
    }

    @Override
    public void createUserWithUserPasswordResponse(String string, OSRUser oSRUser, int n) {
        this.application.getDefaultListener().createUserWithUserPasswordResponse(string, oSRUser, n);
    }

    @Override
    public void checkPasswordResponse(OSRUser oSRUser, int n) {
        this.application.getDefaultListener().checkPasswordResponse(oSRUser, n);
    }

    @Override
    public void checkPairingCodeResponse(OSRUser oSRUser, int n) {
        this.application.getDefaultListener().checkPairingCodeResponse(oSRUser, n);
    }

    @Override
    public void setPrivacyFlagsResponse(OSRUser oSRUser) {
        this.application.getDefaultListener().setPrivacyFlagsResponse(oSRUser);
    }

    @Override
    public void setAutoLoginResponse(OSRUser oSRUser, OSRDevice[] oSRDeviceArray, int[] nArray) {
        this.application.getDefaultListener().setAutoLoginResponse(oSRUser, oSRDeviceArray, nArray);
    }

    @Override
    public void loginResponse(OSRUser oSRUser, int n) {
        this.application.getDefaultListener().loginResponse(oSRUser, n);
    }

    @Override
    public void logoutResponse(OSRUser oSRUser, int n) {
        this.application.getDefaultListener().logoutResponse(oSRUser, n);
    }

    @Override
    public void logoutAuthSchemeResult(String string, OSRUser[] oSRUserArray, int[] nArray) {
        this.application.getDefaultListener().logoutAuthSchemeResult(string, oSRUserArray, nArray);
    }

    @Override
    public void removeUserResponse(OSRUser oSRUser, int n) {
        this.application.getDefaultListener().removeUserResponse(oSRUser, n);
    }

    @Override
    public void getLicenseResponse(int n, OSRLicense oSRLicense) {
        this.application.getDefaultListener().getLicenseResponse(n, oSRLicense);
    }

    @Override
    public void getLicensesResponse(int n, boolean bl, boolean bl2, OSRLicense[] oSRLicenseArray) {
        this.application.getDefaultListener().getLicensesResponse(n, bl, bl2, oSRLicenseArray);
    }

    @Override
    public void getProfileFolderResponse(int n, String string, OSRUser oSRUser, String string2) {
        this.application.getDefaultListener().getProfileFolderResponse(n, string, oSRUser, string2);
    }

    @Override
    public void updateCoreProfileInfo(OSRUser oSRUser, int n, int n2) {
        this.application.getDefaultListener().updateCoreProfileInfo(oSRUser, n, n2);
    }

    @Override
    public void updateExternalProfileInfo(String string, OSRUser oSRUser, int n, int n2) {
        this.application.getDefaultListener().updateExternalProfileInfo(string, oSRUser, n, n2);
    }

    @Override
    public void updateDeviceEnumerator(OSRDevice oSRDevice, int n, int n2) {
        this.application.getDefaultListener().updateDeviceEnumerator(oSRDevice, n, n2);
    }

    @Override
    public void getCredentialsFromHeaderResponse(int n, int n2, int n3, String string, String string2, String string3) {
        this.application.getDefaultListener().getCredentialsFromHeaderResponse(n, n2, n3, string, string2, string3);
    }

    @Override
    public void getCredentialsFromAuthSchemeResponse(int n, int n2, String string, String string2, String string3) {
        this.application.getDefaultListener().getCredentialsFromAuthSchemeResponse(n, n2, string, string2, string3);
    }

    @Override
    public void getServiceURLResponse(int n, String string, String string2) {
        this.application.getDefaultListener().getServiceURLResponse(n, string, string2);
    }

    public AbstractOSRCommand cancelCommand() {
        return null;
    }

    @Override
    public void updateServiceState(int n, int n2) {
        this.application.getDefaultListener().updateServiceState(n, n2);
    }

    @Override
    public void precheckOnlineServiceServiceIDResponse(String string, OSRServiceState oSRServiceState) {
        this.application.getDefaultListener().precheckOnlineServiceServiceIDResponse(string, oSRServiceState);
    }

    @Override
    public void precheckOnlineServiceSymbolicNameResponse(String string, OSRServiceState oSRServiceState) {
        this.application.getDefaultListener().precheckOnlineServiceSymbolicNameResponse(string, oSRServiceState);
    }

    @Override
    public void precheckOnlineServiceResponse(String string, OSRServiceState[] oSRServiceStateArray) {
        this.application.getDefaultListener().precheckOnlineServiceResponse(string, oSRServiceStateArray);
    }

    @Override
    public void downloadRawResponse(String string, String string2, String string3, ResourceLocator resourceLocator, int n) {
        this.application.getDefaultListener().downloadRawResponse(string, string2, string3, resourceLocator, n);
    }

    @Override
    public void updateServices(OSRNotifyPropertiesSL[] oSRNotifyPropertiesSLArray, int n) {
        this.application.getDefaultListener().updateServices(oSRNotifyPropertiesSLArray, n);
    }

    @Override
    public void updateServiceList(OSRServiceListEntry[] oSRServiceListEntryArray, int n) {
        this.application.getDefaultListener().updateServiceList(oSRServiceListEntryArray, n);
    }

    @Override
    public void updateServiceRegistration(String string, OSRServiceRegistration oSRServiceRegistration, int n, int n2) {
        this.application.getDefaultListener().updateServiceRegistration(string, oSRServiceRegistration, n, n2);
    }

    @Override
    public void setServiceStateResponse(OSRServiceState oSRServiceState) {
        this.application.getDefaultListener().setServiceStateResponse(oSRServiceState);
    }

    @Override
    public void setDemandStateServiceIDResponse(String string, int n) {
        this.application.getDefaultListener().setDemandStateServiceIDResponse(string, n);
    }

    @Override
    public void setServiceStateSymbolicNameResponse(OSRServiceState oSRServiceState) {
        this.application.getDefaultListener().setServiceStateSymbolicNameResponse(oSRServiceState);
    }

    @Override
    public void setActivePrivacyCategoryMaskResponse(int n) {
        this.application.getDefaultListener().setActivePrivacyCategoryMaskResponse(n);
    }

    @Override
    public void submitServiceStateChangesToBackendResponse(int n) {
        this.application.getDefaultListener().submitServiceStateChangesToBackendResponse(n);
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
        this.application.getDefaultListener().updateProfileState(n, n2, n3);
    }

    @Override
    public void profileChanged(int n, int n2) {
        this.application.getDefaultListener().profileChanged(n, n2);
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
        this.application.getDefaultListener().profileCopied(n, n2, n3);
    }

    @Override
    public void profileReset(int n, int n2) {
        this.application.getDefaultListener().profileReset(n, n2);
    }

    @Override
    public void profileResetAll(int n) {
        this.application.getDefaultListener().profileResetAll(n);
    }

    @Override
    public void setGPSUseModeResponse(int n) {
        this.application.getDefaultListener().setGPSUseModeResponse(n);
    }

    @Override
    public void setInventoryFinishedResponse(int n) {
        this.application.getDefaultListener().setInventoryFinishedResponse(n);
    }

    @Override
    public abstract void execute() {
    }

    @Override
    public void updateSPINRequired(String string, String string2, int n) {
        this.application.getDefaultListener().updateSPINRequired(string, string2, n);
    }

    @Override
    public void setSPINResponse(String string, String string2, int n, int n2) {
        this.application.getDefaultListener().setSPINResponse(string, string2, n, n2);
    }

    @Override
    public void getSPINHashResult(String string, String string2, int n, String string3, String string4, int n2) {
        this.application.getDefaultListener().getSPINHashResult(string, string2, n, string3, string4, n2);
    }

    @Override
    public void downloadResponse(String string, String string2, String string3, int n) {
        this.application.getDefaultListener().downloadResponse(string, string2, string3, n);
    }
}

