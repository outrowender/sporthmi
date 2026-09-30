/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.atip.interapp.online.OnlineServiceListState;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.osr.OnlineService;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationSubsystem;
import de.audi.tghu.online.app.osr.license.LicenseCollectionService;
import java.util.Collection;
import java.util.Iterator;
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

public class OnlineServiceRegistrationDefaultListener
implements DSIOnlineServiceRegistrationListener {
    private LogChannel logCh;
    private final OnlineServiceRegistrationSubsystem application;

    public OnlineServiceRegistrationDefaultListener(OnlineServiceRegistrationSubsystem onlineServiceRegistrationSubsystem) {
        this.application = onlineServiceRegistrationSubsystem;
        this.logCh = onlineServiceRegistrationSubsystem.getLogChannel();
    }

    public void asyncException(int n, String string, int n2) {
        this.logCh.log(10000000, "[OnlineServiceRegistrationDataContainer#asyncException] - not implemented");
    }

    public void getOnlineApplicationListResponse(OSRApplication[] oSRApplicationArray) {
        this.logCh.log(10000000, "[OnlineServiceRegistrationDataContainer#getOnlineApplicationListResponse] - not implemented");
    }

    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
        this.logCh.log(10000000, "[OnlineServiceRegistrationDataContainer#getOnlineApplicationResponse] applicationId:%1 ", (Object)oSRApplication.getId());
        this.application.getContainer().addOrUpdateOnlineApplication(oSRApplication, this.application);
    }

    public void activateLicenseResponse(OSRLicense oSRLicense, int n) {
        this.logCh.log(10000000, "[OnlineServiceRegistrationDataContainer#activateLicenseResponse] - not implemented");
    }

    public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray, int n) {
        this.application.getContainer().sendApplicationStatus(oSRNotifyPropertiesArray);
    }

    public void getServiceListResponse(int n) {
        this.logCh.log(10000000, "[OnlineServiceRegistrationDataContainer#getServiceListResponse] - result of serviceList request: %1", (long)n);
    }

    public void setCredentialResponse(String string, int n) {
        this.logCh.log(10000000, "[OnlineServiceRegistrationDataContainer#setCredentialResponse] - not implemented");
    }

    public void validatePairingCodeResponse(String string, int n) {
        this.logCh.log(10000000, "[OnlineServiceRegistrationDataContainer#validatePairingCodeResponse] - not implemented");
    }

    public void checkValidCredentialResponse(String string, int n) {
        this.logCh.log(10000000, "[OnlineServiceRegistrationDataContainer#checkValidCredentialResponse] - not implemented");
    }

    public void downloadResponse(String string, String string2, String string3, int n) {
        this.logCh.log(10000000, "[OnlineServiceRegistrationDataContainer#downloadResponse] - not implemented");
    }

    public void resetToFactorySettingsResponse(String string, int n) {
    }

    public void updateProfileInfo(int n, String string, String string2, int n2, int n3) {
    }

    public void validateOwnerResponse(int n) {
    }

    public void checkOwnersVerificationResponse(int n) {
    }

    public void validatePortalUserResponse(int n, String string, String string2, String string3, String string4, int n2) {
    }

    public void setAccountStateResponse(int n, String string, String string2, int n2) {
    }

    public void performPortalRegistrationResponse(String string, int n) {
    }

    public void setActiveProfileResponse(int n, int n2, String string, String string2) {
    }

    public void getUsersResponse(OSRUser[] oSRUserArray) {
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

    public void removeUserResponse(OSRUser oSRUser, int n) {
    }

    public void getLicenseResponse(int n, OSRLicense oSRLicense) {
    }

    public void getLicensesResponse(int n, boolean bl, boolean bl2, OSRLicense[] oSRLicenseArray) {
    }

    public void getProfileFolderResponse(int n, String string, OSRUser oSRUser, String string2) {
    }

    public void updateCoreProfileInfo(OSRUser oSRUser, int n, int n2) {
        this.logCh.log(1000000, "OnlineServiceRegistrationDataContainer#updateCoreProfileInfo passing forward");
        this.application.getAuthenticationController().updateCoreProfileInfo(oSRUser, n, n2);
    }

    public void updateExternalProfileInfo(String string, OSRUser oSRUser, int n, int n2) {
        this.logCh.log(1000000, "OnlineServiceRegistrationDataContainer#updateExternalProfileInfo passing forward");
        this.application.getAuthenticationController().updateExternalProfileInfo(string, oSRUser, n, n2);
    }

    public void updateDeviceEnumerator(OSRDevice oSRDevice, int n, int n2) {
        this.application.getAuthenticationController().updateDeviceEnumerator(oSRDevice, n, n2);
    }

    public void getCredentialsFromHeaderResponse(int n, int n2, int n3, String string, String string2, String string3) {
    }

    public void getCredentialsFromAuthSchemeResponse(int n, int n2, String string, String string2, String string3) {
    }

    public void getServiceURLResponse(int n, String string, String string2) {
    }

    public void precheckOnlineServiceServiceIDResponse(String string, OSRServiceState oSRServiceState) {
        this.logCh.log(10000000, "[OnlineServiceRegistrationDataContainer#precheckOnlineServiceServiceIDResponse] - not implemented");
    }

    public void precheckOnlineServiceSymbolicNameResponse(String string, OSRServiceState oSRServiceState) {
        this.logCh.log(10000000, "[OnlineServiceRegistrationDataContainer#precheckOnlineServiceSymbolicNameResponse] - not implemented");
    }

    public void precheckOnlineServiceResponse(String string, OSRServiceState[] oSRServiceStateArray) {
        this.logCh.log(10000000, "[OnlineServiceRegistrationDataContainer#precheckOnlineServiceResponse] - not implemented");
    }

    public void updateServiceState(int n, int n2) {
        OnlineServiceListState onlineServiceListState = new OnlineServiceListState(n, n2);
        this.logCh.log(1000000, "OnlineServiceRegistrationDataContainer#updateServiceState called, new SL state: %1", (Object)onlineServiceListState);
        this.informLicenseListener(onlineServiceListState);
        this.informOnlineServiceListener(onlineServiceListState);
    }

    private void informLicenseListener(OnlineServiceListState onlineServiceListState) {
        LicenseCollectionService licenseCollectionService = this.application.getLicenseListener();
        if (licenseCollectionService != null) {
            this.logCh.log(1000000, "OnlineServiceRegistrationDataContainer#updateServiceState passing forward!");
            licenseCollectionService.updateServiceState(onlineServiceListState);
        } else {
            this.logCh.log(100000, "OnlineServiceRegistrationDataContainer#updateServiceState no License listener available. aborting");
        }
    }

    private void informOnlineServiceListener(OnlineServiceListState onlineServiceListState) {
        this.logCh.log(1000000, "OnlineServiceRegistrationDataContainer#informOnlineServiceListener");
        Collection collection = this.application.getContainer().getApplications();
        Iterator iterator = collection.iterator();
        if (iterator != null) {
            while (iterator.hasNext()) {
                OnlineService onlineService = (OnlineService)iterator.next();
                onlineService.updateServiceState(onlineServiceListState);
            }
        }
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }

    public void downloadRawResponse(String string, String string2, String string3, ResourceLocator resourceLocator, int n) {
    }

    public void updateServices(OSRNotifyPropertiesSL[] oSRNotifyPropertiesSLArray, int n) {
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

