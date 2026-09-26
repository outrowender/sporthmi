/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.standard;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.standard.IDSIServiceListener;
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

public class SimpleServiceRegistrationListener
implements DSIOnlineServiceRegistrationListener {
    private IDSIServiceListener delegate;
    private LogChannel logChannel;

    public SimpleServiceRegistrationListener(IDSIServiceListener iDSIServiceListener, LogChannel logChannel) {
        this.delegate = iDSIServiceListener;
        this.logChannel = logChannel;
    }

    @Override
    public void updateServiceState(int n, int n2) {
        this.logChannel.log(1078071040, "SimpleServiceRegistrationListener#updateServiceState serviceState: %1, validFlag: %2", (long)n, (long)n2);
        this.delegate.updateServiceState(n, n2);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void getOnlineApplicationListResponse(OSRApplication[] oSRApplicationArray) {
    }

    @Override
    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
    }

    @Override
    public void activateLicenseResponse(OSRLicense oSRLicense, int n) {
    }

    @Override
    public void setCredentialResponse(String string, int n) {
    }

    @Override
    public void downloadResponse(String string, String string2, String string3, int n) {
    }

    @Override
    public void downloadRawResponse(String string, String string2, String string3, ResourceLocator resourceLocator, int n) {
    }

    @Override
    public void validateOwnerResponse(int n) {
    }

    @Override
    public void checkOwnersVerificationResponse(int n) {
    }

    @Override
    public void createUserWithPairingCodeResponse(String string, OSRUser oSRUser, int n) {
    }

    @Override
    public void createUserWithUserPasswordResponse(String string, OSRUser oSRUser, int n) {
    }

    @Override
    public void checkPasswordResponse(OSRUser oSRUser, int n) {
    }

    @Override
    public void checkPairingCodeResponse(OSRUser oSRUser, int n) {
    }

    @Override
    public void setPrivacyFlagsResponse(OSRUser oSRUser) {
    }

    @Override
    public void setAutoLoginResponse(OSRUser oSRUser, OSRDevice[] oSRDeviceArray, int[] nArray) {
    }

    @Override
    public void loginResponse(OSRUser oSRUser, int n) {
    }

    @Override
    public void logoutResponse(OSRUser oSRUser, int n) {
    }

    @Override
    public void logoutAuthSchemeResult(String string, OSRUser[] oSRUserArray, int[] nArray) {
    }

    @Override
    public void getUsersResponse(OSRUser[] oSRUserArray) {
    }

    @Override
    public void removeUserResponse(OSRUser oSRUser, int n) {
    }

    @Override
    public void performPortalRegistrationResponse(String string, int n) {
    }

    @Override
    public void precheckOnlineServiceServiceIDResponse(String string, OSRServiceState oSRServiceState) {
    }

    @Override
    public void precheckOnlineServiceSymbolicNameResponse(String string, OSRServiceState oSRServiceState) {
    }

    @Override
    public void precheckOnlineServiceResponse(String string, OSRServiceState[] oSRServiceStateArray) {
    }

    @Override
    public void getLicenseResponse(int n, OSRLicense oSRLicense) {
    }

    @Override
    public void getLicensesResponse(int n, boolean bl, boolean bl2, OSRLicense[] oSRLicenseArray) {
    }

    @Override
    public void getProfileFolderResponse(int n, String string, OSRUser oSRUser, String string2) {
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
    public void resetToFactorySettingsResponse(String string, int n) {
    }

    @Override
    public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray, int n) {
    }

    @Override
    public void updateServices(OSRNotifyPropertiesSL[] oSRNotifyPropertiesSLArray, int n) {
    }

    @Override
    public void updateCoreProfileInfo(OSRUser oSRUser, int n, int n2) {
    }

    @Override
    public void updateExternalProfileInfo(String string, OSRUser oSRUser, int n, int n2) {
    }

    @Override
    public void updateDeviceEnumerator(OSRDevice oSRDevice, int n, int n2) {
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

