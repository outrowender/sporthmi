/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import de.esolutions.fw.comm.core.method.MethodException;
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

public interface DSIOnlineServiceRegistrationReply {
    public static final String IPL_COMM_UUID = "ceacf065-fc29-5dbb-a102-cb462ad790ed";
    public static final String IPL_COMM_INTERFACE_KEY = "64105737-fd86-5dee-835d-34e9cf4b373f";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.42";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.42";

    public void getOnlineApplicationListResponse(OSRApplication[] var1) throws MethodException;

    public void getOnlineApplicationResponse(OSRApplication var1) throws MethodException;

    public void activateLicenseResponse(OSRLicense var1, int var2) throws MethodException;

    public void setCredentialResponse(String var1, int var2) throws MethodException;

    public void downloadResponse(String var1, String var2, String var3, int var4) throws MethodException;

    public void downloadRawResponse(String var1, String var2, String var3, ResourceLocator var4, int var5) throws MethodException;

    public void validateOwnerResponse(int var1) throws MethodException;

    public void checkOwnersVerificationResponse(int var1) throws MethodException;

    public void createUserWithPairingCodeResponse(String var1, OSRUser var2, int var3) throws MethodException;

    public void createUserWithUserPasswordResponse(String var1, OSRUser var2, int var3) throws MethodException;

    public void checkPasswordResponse(OSRUser var1, int var2) throws MethodException;

    public void checkPairingCodeResponse(OSRUser var1, int var2) throws MethodException;

    public void setPrivacyFlagsResponse(OSRUser var1) throws MethodException;

    public void setAutoLoginResponse(OSRUser var1, OSRDevice[] var2, int[] var3) throws MethodException;

    public void loginResponse(OSRUser var1, int var2) throws MethodException;

    public void logoutResponse(OSRUser var1, int var2) throws MethodException;

    public void logoutAuthSchemeResult(String var1, OSRUser[] var2, int[] var3) throws MethodException;

    public void getUsersResponse(OSRUser[] var1) throws MethodException;

    public void removeUserResponse(OSRUser var1, int var2) throws MethodException;

    public void performPortalRegistrationResponse(String var1, int var2) throws MethodException;

    public void precheckOnlineServiceServiceIDResponse(String var1, OSRServiceState var2) throws MethodException;

    public void precheckOnlineServiceSymbolicNameResponse(String var1, OSRServiceState var2) throws MethodException;

    public void precheckOnlineServiceResponse(String var1, OSRServiceState[] var2) throws MethodException;

    public void getLicenseResponse(int var1, OSRLicense var2) throws MethodException;

    public void getLicensesResponse(int var1, boolean var2, boolean var3, OSRLicense[] var4) throws MethodException;

    public void getProfileFolderResponse(int var1, String var2, OSRUser var3, String var4) throws MethodException;

    public void getCredentialsFromHeaderResponse(int var1, int var2, int var3, String var4, String var5, String var6) throws MethodException;

    public void getCredentialsFromAuthSchemeResponse(int var1, int var2, String var3, String var4, String var5) throws MethodException;

    public void getServiceURLResponse(int var1, String var2, String var3) throws MethodException;

    public void resetToFactorySettingsResponse(String var1, int var2) throws MethodException;

    public void updateApplicationState(OSRNotifyProperties[] var1, int var2) throws MethodException;

    public void updateServices(OSRNotifyPropertiesSL[] var1, int var2) throws MethodException;

    public void updateCoreProfileInfo(OSRUser var1, int var2, int var3) throws MethodException;

    public void updateExternalProfileInfo(String var1, OSRUser var2, int var3, int var4) throws MethodException;

    public void updateDeviceEnumerator(OSRDevice var1, int var2, int var3) throws MethodException;

    public void updateServiceState(int var1, int var2) throws MethodException;

    public void updateServiceList(OSRServiceListEntry[] var1, int var2) throws MethodException;

    public void updateServiceRegistration(String var1, OSRServiceRegistration var2, int var3, int var4) throws MethodException;

    public void setServiceStateResponse(OSRServiceState var1) throws MethodException;

    public void setDemandStateServiceIDResponse(String var1, int var2) throws MethodException;

    public void setServiceStateSymbolicNameResponse(OSRServiceState var1) throws MethodException;

    public void setActivePrivacyCategoryMaskResponse(int var1) throws MethodException;

    public void submitServiceStateChangesToBackendResponse(int var1) throws MethodException;

    public void updateProfileState(int var1, int var2, int var3) throws MethodException;

    public void profileChanged(int var1, int var2) throws MethodException;

    public void profileCopied(int var1, int var2, int var3) throws MethodException;

    public void profileReset(int var1, int var2) throws MethodException;

    public void profileResetAll(int var1) throws MethodException;

    public void setGPSUseModeResponse(int var1) throws MethodException;

    public void setInventoryFinishedResponse(int var1) throws MethodException;

    public void updateSPINRequired(String var1, String var2, int var3) throws MethodException;

    public void setSPINResponse(String var1, String var2, int var3, int var4) throws MethodException;

    public void getSPINHashResult(String var1, String var2, int var3, String var4, String var5, int var6) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

