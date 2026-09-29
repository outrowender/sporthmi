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

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logCh.log(-2137614336, "[OnlineServiceRegistrationDataContainer#asyncException] - not implemented");
    }

    @Override
    public void getOnlineApplicationListResponse(OSRApplication[] oSRApplicationArray) {
        this.logCh.log(-2137614336, "[OnlineServiceRegistrationDataContainer#getOnlineApplicationListResponse] - not implemented");
    }

    @Override
    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
        this.logCh.log(-2137614336, "[OnlineServiceRegistrationDataContainer#getOnlineApplicationResponse] applicationId:%1 ", (Object)oSRApplication.getId());
        this.application.getContainer().addOrUpdateOnlineApplication(oSRApplication, this.application);
    }

    @Override
    public void activateLicenseResponse(OSRLicense oSRLicense, int n) {
        this.logCh.log(-2137614336, "[OnlineServiceRegistrationDataContainer#activateLicenseResponse] - not implemented");
    }

    @Override
    public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray, int n) {
        this.application.getContainer().sendApplicationStatus(oSRNotifyPropertiesArray);
    }

    public void getServiceListResponse(int n) {
        this.logCh.log(-2137614336, "[OnlineServiceRegistrationDataContainer#getServiceListResponse] - result of serviceList request: %1", (long)n);
    }

    @Override
    public void setCredentialResponse(String string, int n) {
        this.logCh.log(-2137614336, "[OnlineServiceRegistrationDataContainer#setCredentialResponse] - not implemented");
    }

    public void validatePairingCodeResponse(String string, int n) {
        this.logCh.log(-2137614336, "[OnlineServiceRegistrationDataContainer#validatePairingCodeResponse] - not implemented");
    }

    public void checkValidCredentialResponse(String string, int n) {
        this.logCh.log(-2137614336, "[OnlineServiceRegistrationDataContainer#checkValidCredentialResponse] - not implemented");
    }

    @Override
    public void downloadResponse(String string, String string2, String string3, int n) {
        this.logCh.log(-2137614336, "[OnlineServiceRegistrationDataContainer#downloadResponse] - not implemented");
    }

    @Override
    public void resetToFactorySettingsResponse(String string, int n) {
    }

    public void updateProfileInfo(int n, String string, String string2, int n2, int n3) {
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
    }

    public void setActiveProfileResponse(int n, int n2, String string, String string2) {
    }

    @Override
    public void getUsersResponse(OSRUser[] oSRUserArray) {
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
    public void removeUserResponse(OSRUser oSRUser, int n) {
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
    public void updateCoreProfileInfo(OSRUser oSRUser, int n, int n2) {
        this.logCh.log(1078071040, "OnlineServiceRegistrationDataContainer#updateCoreProfileInfo passing forward");
        this.application.getAuthenticationController().updateCoreProfileInfo(oSRUser, n, n2);
    }

    @Override
    public void updateExternalProfileInfo(String string, OSRUser oSRUser, int n, int n2) {
        this.logCh.log(1078071040, "OnlineServiceRegistrationDataContainer#updateExternalProfileInfo passing forward");
        this.application.getAuthenticationController().updateExternalProfileInfo(string, oSRUser, n, n2);
    }

    @Override
    public void updateDeviceEnumerator(OSRDevice oSRDevice, int n, int n2) {
        this.application.getAuthenticationController().updateDeviceEnumerator(oSRDevice, n, n2);
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
        this.logCh.log(-2137614336, "[OnlineServiceRegistrationDataContainer#precheckOnlineServiceServiceIDResponse] - not implemented");
    }

    @Override
    public void precheckOnlineServiceSymbolicNameResponse(String string, OSRServiceState oSRServiceState) {
        this.logCh.log(-2137614336, "[OnlineServiceRegistrationDataContainer#precheckOnlineServiceSymbolicNameResponse] - not implemented");
    }

    @Override
    public void precheckOnlineServiceResponse(String string, OSRServiceState[] oSRServiceStateArray) {
        this.logCh.log(-2137614336, "[OnlineServiceRegistrationDataContainer#precheckOnlineServiceResponse] - not implemented");
    }

    @Override
    public void updateServiceState(int n, int n2) {
        OnlineServiceListState onlineServiceListState = new OnlineServiceListState(n, n2);
        this.logCh.log(1078071040, "OnlineServiceRegistrationDataContainer#updateServiceState called, new SL state: %1", (Object)onlineServiceListState);
        this.informLicenseListener(onlineServiceListState);
        this.informOnlineServiceListener(onlineServiceListState);
    }

    private void informLicenseListener(OnlineServiceListState onlineServiceListState) {
        LicenseCollectionService licenseCollectionService = this.application.getLicenseListener();
        if (licenseCollectionService != null) {
            this.logCh.log(1078071040, "OnlineServiceRegistrationDataContainer#updateServiceState passing forward!");
            licenseCollectionService.updateServiceState(onlineServiceListState);
        } else {
            this.logCh.log(-1601830656, "OnlineServiceRegistrationDataContainer#updateServiceState no License listener available. aborting");
        }
    }

    private void informOnlineServiceListener(OnlineServiceListState onlineServiceListState) {
        this.logCh.log(1078071040, "OnlineServiceRegistrationDataContainer#informOnlineServiceListener");
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

