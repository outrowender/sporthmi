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

    public void updateServiceState(int n, int n2) {
        this.logChannel.log(1000000, "SimpleServiceRegistrationListener#updateServiceState serviceState: %1, validFlag: %2", (long)n, (long)n2);
        this.delegate.updateServiceState(n, n2);
    }

    public void asyncException(int n, String string, int n2) {
    }

    public void getOnlineApplicationListResponse(OSRApplication[] oSRApplicationArray) {
    }

    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
    }

    public void activateLicenseResponse(OSRLicense oSRLicense, int n) {
    }

    public void setCredentialResponse(String string, int n) {
    }

    public void downloadResponse(String string, String string2, String string3, int n) {
    }

    public void downloadRawResponse(String string, String string2, String string3, ResourceLocator resourceLocator, int n) {
    }

    public void validateOwnerResponse(int n) {
    }

    public void checkOwnersVerificationResponse(int n) {
    }

    public void createUserWithPairingCodeResponse(String string, OSRUser oSRUser, int n) {
    }

    public void createUserWithUserPasswordResponse(String string, OSRUser oSRUser, int n) {
    }

    public void checkPasswordResponse(OSRUser oSRUser, int n) {
    }

    public void checkPairingCodeResponse(OSRUser oSRUser, int n) {
    }

    public void setPrivacyFlagsResponse(OSRUser oSRUser) {
    }

    public void setAutoLoginResponse(OSRUser oSRUser, OSRDevice[] oSRDeviceArray, int[] nArray) {
    }

    public void loginResponse(OSRUser oSRUser, int n) {
    }

    public void logoutResponse(OSRUser oSRUser, int n) {
    }

    public void logoutAuthSchemeResult(String string, OSRUser[] oSRUserArray, int[] nArray) {
    }

    public void getUsersResponse(OSRUser[] oSRUserArray) {
    }

    public void removeUserResponse(OSRUser oSRUser, int n) {
    }

    public void performPortalRegistrationResponse(String string, int n) {
    }

    public void precheckOnlineServiceServiceIDResponse(String string, OSRServiceState oSRServiceState) {
    }

    public void precheckOnlineServiceSymbolicNameResponse(String string, OSRServiceState oSRServiceState) {
    }

    public void precheckOnlineServiceResponse(String string, OSRServiceState[] oSRServiceStateArray) {
    }

    public void getLicenseResponse(int n, OSRLicense oSRLicense) {
    }

    public void getLicensesResponse(int n, boolean bl, boolean bl2, OSRLicense[] oSRLicenseArray) {
    }

    public void getProfileFolderResponse(int n, String string, OSRUser oSRUser, String string2) {
    }

    public void getCredentialsFromHeaderResponse(int n, int n2, int n3, String string, String string2, String string3) {
    }

    public void getCredentialsFromAuthSchemeResponse(int n, int n2, String string, String string2, String string3) {
    }

    public void getServiceURLResponse(int n, String string, String string2) {
    }

    public void resetToFactorySettingsResponse(String string, int n) {
    }

    public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray, int n) {
    }

    public void updateServices(OSRNotifyPropertiesSL[] oSRNotifyPropertiesSLArray, int n) {
    }

    public void updateCoreProfileInfo(OSRUser oSRUser, int n, int n2) {
    }

    public void updateExternalProfileInfo(String string, OSRUser oSRUser, int n, int n2) {
    }

    public void updateDeviceEnumerator(OSRDevice oSRDevice, int n, int n2) {
    }

    public void updateServiceList(OSRServiceListEntry[] oSRServiceListEntryArray, int n) {
    }

    public void updateServiceRegistration(String string, OSRServiceRegistration oSRServiceRegistration, int n, int n2) {
    }

    public void setServiceStateResponse(OSRServiceState oSRServiceState) {
    }

    public void setDemandStateServiceIDResponse(String string, int n) {
    }

    public void setServiceStateSymbolicNameResponse(OSRServiceState oSRServiceState) {
    }

    public void setActivePrivacyCategoryMaskResponse(int n) {
    }

    public void submitServiceStateChangesToBackendResponse(int n) {
    }

    public void updateProfileState(int n, int n2, int n3) {
    }

    public void profileChanged(int n, int n2) {
    }

    public void profileCopied(int n, int n2, int n3) {
    }

    public void profileReset(int n, int n2) {
    }

    public void profileResetAll(int n) {
    }

    public void setGPSUseModeResponse(int n) {
    }

    public void setInventoryFinishedResponse(int n) {
    }

    public void updateSPINRequired(String string, String string2, int n) {
    }

    public void setSPINResponse(String string, String string2, int n, int n2) {
    }

    public void getSPINHashResult(String string, String string2, int n, String string3, String string4, int n2) {
    }
}

