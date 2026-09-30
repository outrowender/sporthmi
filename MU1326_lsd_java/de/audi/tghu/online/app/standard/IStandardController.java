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
    public void init();

    public void initiateHmiJump();

    public void changeApplicationState(boolean var1);

    public void setEniServiceOnline(ENIServiceOnline var1);

    public ENIServiceOnlineListener getEniServiceListener();

    public void setRemoteHmiService(RemoteHMIService var1);

    public void onServiceList(Service[] var1);

    public void onUserList(User[] var1);

    public void onMonitorings(int var1, int var2, int var3);

    public void triggerMainUserSetUsingVehiclePINResponse(int var1, int var2);

    public void triggerMainUserResetResponse(boolean var1);

    public void triggerUpdateUserListResponse(boolean var1);

    public void setMainUser(String var1, String var2);

    public void resetMainUser();

    public void setLicenseCollectionService(LicenseCollectionService var1);

    public void setServiceListenerDelegate(IBAPServiceListener var1);

    public Object getPowerManagerListener();

    public void triggerUpdateUserlist();

    public void triggerPrivacyMode(boolean var1);

    public void triggerSubmitChangesToBackend();

    public void clearAuthentication();

    public LicenseCollectionService getLicenseCollectionService();

    public void setPrivacyModeFeatureAvailable(boolean var1, PrivacyFeatureStorageAccess var2);

    public void setMobileKeyLicenseListener(IMobileKeyLicenseListener var1);
}

