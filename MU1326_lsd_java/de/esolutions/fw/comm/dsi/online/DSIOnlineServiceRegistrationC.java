/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.online.OSRApplicationProperties;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRUser;

public interface DSIOnlineServiceRegistrationC {
    public void getOnlineApplicationList() throws MethodException;

    public void getOnlineApplication(String var1) throws MethodException;

    public void setOnlineApplicationState(String var1, int var2) throws MethodException;

    public void activateLicense(OSRLicense var1) throws MethodException;

    public void setDemandState(String var1, boolean var2) throws MethodException;

    public void setDemandStateServiceID(String var1, boolean var2) throws MethodException;

    public void setApplicationProperties(String var1, OSRApplicationProperties[] var2) throws MethodException;

    public void addOrUpdateApplicationProperty(String var1, OSRApplicationProperties var2) throws MethodException;

    public void setCredential(String var1, String var2, String var3) throws MethodException;

    public void download(String var1, String var2, String var3, long var4, long var6) throws MethodException;

    public void downloadRaw(String var1, String var2, String var3, long var4, long var6) throws MethodException;

    public void validateOwner(String var1) throws MethodException;

    public void validateOwnerForce(boolean var1) throws MethodException;

    public void checkOwnersVerification() throws MethodException;

    public void createUserWithPairingCode(String var1, String var2) throws MethodException;

    public void createUserWithUserPassword(String var1, String var2, String var3) throws MethodException;

    public void checkPassword(OSRUser var1, String var2, boolean var3) throws MethodException;

    public void checkPairingCode(OSRUser var1, String var2, boolean var3) throws MethodException;

    public void setPrivacyFlags(OSRUser var1, int var2) throws MethodException;

    public void setAutoLogin(OSRUser var1, OSRDevice[] var2) throws MethodException;

    public void login(OSRUser var1) throws MethodException;

    public void logout(OSRUser var1) throws MethodException;

    public void logoutAuthScheme(String var1) throws MethodException;

    public void getUsers(String var1) throws MethodException;

    public void removeUser(OSRUser var1) throws MethodException;

    public void performPortalRegistration(String var1) throws MethodException;

    public void getLicense(String var1) throws MethodException;

    public void getLicenses(boolean var1, boolean var2) throws MethodException;

    public void precheckOnlineServiceServiceID(String var1, String var2) throws MethodException;

    public void precheckOnlineServiceSymbolicName(String var1, String var2) throws MethodException;

    public void precheckOnlineService(String var1) throws MethodException;

    public void getProfileFolder(OSRUser var1, String var2) throws MethodException;

    public void getCredentialsFromHeader(int var1, String[] var2) throws MethodException;

    public void getCredentialsFromAuthScheme(int var1) throws MethodException;

    public void getServiceURL(String var1) throws MethodException;

    public void resetToFactorySettings(String var1) throws MethodException;

    public void setLanguage(String var1) throws MethodException;

    public void setServiceState(String var1, int var2) throws MethodException;

    public void setServiceStateSymbolicName(String var1, int var2) throws MethodException;

    public void setActivePrivacyCategoryMask(int var1) throws MethodException;

    public void submitServiceStateChangesToBackend() throws MethodException;

    public void profileChange(int var1) throws MethodException;

    public void profileCopy(int var1, int var2) throws MethodException;

    public void profileReset(int var1) throws MethodException;

    public void profileResetAll() throws MethodException;

    public void setGPSUseMode(int var1) throws MethodException;

    public void setInventoryFinished(boolean var1) throws MethodException;

    public void setSPIN(String var1, String var2, String var3) throws MethodException;

    public void getSPINHash(String var1, String var2, int var3, String var4) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

