/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRNotifyPropertiesSL;
import org.dsi.ifc.online.OSRServiceListEntry;
import org.dsi.ifc.online.OSRServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public interface DSIOnlineServiceRegistrationListener
extends DSIListener {
    public void getOnlineApplicationListResponse(OSRApplication[] var1);

    public void getOnlineApplicationResponse(OSRApplication var1);

    public void activateLicenseResponse(OSRLicense var1, int var2);

    public void setCredentialResponse(String var1, int var2);

    public void downloadResponse(String var1, String var2, String var3, int var4);

    public void downloadRawResponse(String var1, String var2, String var3, ResourceLocator var4, int var5);

    public void validateOwnerResponse(int var1);

    public void checkOwnersVerificationResponse(int var1);

    public void createUserWithPairingCodeResponse(String var1, OSRUser var2, int var3);

    public void createUserWithUserPasswordResponse(String var1, OSRUser var2, int var3);

    public void checkPasswordResponse(OSRUser var1, int var2);

    public void checkPairingCodeResponse(OSRUser var1, int var2);

    public void setPrivacyFlagsResponse(OSRUser var1);

    public void setAutoLoginResponse(OSRUser var1, OSRDevice[] var2, int[] var3);

    public void loginResponse(OSRUser var1, int var2);

    public void logoutResponse(OSRUser var1, int var2);

    public void logoutAuthSchemeResult(String var1, OSRUser[] var2, int[] var3);

    public void getUsersResponse(OSRUser[] var1);

    public void removeUserResponse(OSRUser var1, int var2);

    public void performPortalRegistrationResponse(String var1, int var2);

    public void precheckOnlineServiceServiceIDResponse(String var1, OSRServiceState var2);

    public void precheckOnlineServiceSymbolicNameResponse(String var1, OSRServiceState var2);

    public void precheckOnlineServiceResponse(String var1, OSRServiceState[] var2);

    public void getLicenseResponse(int var1, OSRLicense var2);

    public void getLicensesResponse(int var1, boolean var2, boolean var3, OSRLicense[] var4);

    public void getProfileFolderResponse(int var1, String var2, OSRUser var3, String var4);

    public void getCredentialsFromHeaderResponse(int var1, int var2, int var3, String var4, String var5, String var6);

    public void getCredentialsFromAuthSchemeResponse(int var1, int var2, String var3, String var4, String var5);

    public void getServiceURLResponse(int var1, String var2, String var3);

    public void resetToFactorySettingsResponse(String var1, int var2);

    public void updateApplicationState(OSRNotifyProperties[] var1, int var2);

    public void updateServices(OSRNotifyPropertiesSL[] var1, int var2);

    public void updateCoreProfileInfo(OSRUser var1, int var2, int var3);

    public void updateExternalProfileInfo(String var1, OSRUser var2, int var3, int var4);

    public void updateDeviceEnumerator(OSRDevice var1, int var2, int var3);

    public void updateServiceState(int var1, int var2);

    public void updateServiceList(OSRServiceListEntry[] var1, int var2);

    public void updateServiceRegistration(String var1, OSRServiceRegistration var2, int var3, int var4);

    public void setServiceStateResponse(OSRServiceState var1);

    public void setDemandStateServiceIDResponse(String var1, int var2);

    public void setServiceStateSymbolicNameResponse(OSRServiceState var1);

    public void setActivePrivacyCategoryMaskResponse(int var1);

    public void submitServiceStateChangesToBackendResponse(int var1);

    public void updateProfileState(int var1, int var2, int var3);

    public void profileChanged(int var1, int var2);

    public void profileCopied(int var1, int var2, int var3);

    public void profileReset(int var1, int var2);

    public void profileResetAll(int var1);

    public void setGPSUseModeResponse(int var1);

    public void setInventoryFinishedResponse(int var1);

    public void updateSPINRequired(String var1, String var2, int var3);

    public void setSPINResponse(String var1, String var2, int var3, int var4);

    public void getSPINHashResult(String var1, String var2, int var3, String var4, String var5, int var6);
}

