/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.standard;

import de.audi.atip.interapp.bap.eni.data.Service;
import de.audi.atip.interapp.bap.eni.data.User;
import de.audi.atip.interapp.eni.ENIServiceOnline;
import de.audi.atip.interapp.eni.ENIServiceOnlineListener;
import de.audi.tghu.online.app.osr.license.LicenseCollectionService;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.standard.IBAPServiceListener;
import de.audi.tghu.online.app.standard.IMobileKeyLicenseListener;
import de.audi.tghu.online.app.standard.PrivacyFeatureStorageAccess;

public interface IStandardController {
    default public void init() {
    }

    default public void initiateHmiJump() {
    }

    default public void changeApplicationState(boolean bl) {
    }

    default public void setEniServiceOnline(ENIServiceOnline eNIServiceOnline) {
    }

    default public ENIServiceOnlineListener getEniServiceListener() {
    }

    default public void setRemoteHmiService(RemoteHMIService remoteHMIService) {
    }

    default public void onServiceList(Service[] serviceArray) {
    }

    default public void onUserList(User[] userArray) {
    }

    default public void onMonitorings(int n, int n2, int n3) {
    }

    default public void triggerMainUserSetUsingVehiclePINResponse(int n, int n2) {
    }

    default public void triggerMainUserResetResponse(boolean bl) {
    }

    default public void triggerUpdateUserListResponse(boolean bl) {
    }

    default public void setMainUser(String string, String string2) {
    }

    default public void resetMainUser() {
    }

    default public void setLicenseCollectionService(LicenseCollectionService licenseCollectionService) {
    }

    default public void setServiceListenerDelegate(IBAPServiceListener iBAPServiceListener) {
    }

    default public Object getPowerManagerListener() {
    }

    default public void triggerUpdateUserlist() {
    }

    default public void triggerPrivacyMode(boolean bl) {
    }

    default public void triggerSubmitChangesToBackend() {
    }

    default public void clearAuthentication() {
    }

    default public LicenseCollectionService getLicenseCollectionService() {
    }

    default public void setPrivacyModeFeatureAvailable(boolean bl, PrivacyFeatureStorageAccess privacyFeatureStorageAccess) {
    }

    default public void setMobileKeyLicenseListener(IMobileKeyLicenseListener iMobileKeyLicenseListener) {
    }
}

