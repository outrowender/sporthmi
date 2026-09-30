/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationDefaultListener;
import org.dsi.ifc.base.DSIListener;
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

public class OnlineServiceRegistrationListener
implements DSIOnlineServiceRegistrationListener,
ICommandResponseSupplier {
    private LogChannel logCh;
    private OnlineServiceRegistrationDefaultListener defaultListener;
    private CommandListManager cmdListMgr;

    public OnlineServiceRegistrationListener(LogChannel logChannel, CommandListManager commandListManager, OnlineServiceRegistrationDefaultListener onlineServiceRegistrationDefaultListener) {
        this.logCh = logChannel;
        this.defaultListener = onlineServiceRegistrationDefaultListener;
        this.logCh.log(10000000, "[OnlineServiceRegistrationListener#ctor] Called.");
        this.cmdListMgr = commandListManager;
    }

    public void asyncException(int n, String string, int n2) {
        this.logCh.log(100000, "[OnlineServiceRegistrationListener#asyncException] Called, errorCode: %2, requestType: %3, errorMsg: %1", (Object)string, (long)n, (long)n2);
    }

    public void getOnlineApplicationListResponse(final OSRApplication[] oSRApplicationArray) {
        this.logCh.log(100000000, "[OnlineServiceRegistrationListener#getOnlineApplicationListResponse]");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).getOnlineApplicationListResponse(oSRApplicationArray);
            }
        });
    }

    public void getOnlineApplicationResponse(final OSRApplication oSRApplication) {
        this.logCh.log(100000000, "[OnlineServiceRegistrationListener#getOnlineApplicationResponse]");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).getOnlineApplicationResponse(oSRApplication);
            }
        });
    }

    public void activateLicenseResponse(final OSRLicense oSRLicense, final int n) {
        this.logCh.log(100000000, "[OnlineServiceRegistrationListener#activateLicenseResponse]");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).activateLicenseResponse(oSRLicense, n);
            }
        });
    }

    public void updateApplicationState(final OSRNotifyProperties[] oSRNotifyPropertiesArray, final int n) {
        this.logCh.log(100000000, "[OnlineServiceRegistrationListener#updateApplicationState] props.length=%1, valid: %2", (long)(oSRNotifyPropertiesArray == null ? 0 : oSRNotifyPropertiesArray.length), (long)n);
        if (this.logCh.isDebug2() && oSRNotifyPropertiesArray != null) {
            for (int i2 = 0; i2 < oSRNotifyPropertiesArray.length; ++i2) {
                this.logCh.log(100000000, "[OnlineServiceRegistrationListener#updateApplicationState] props[%2]: %1", (Object)oSRNotifyPropertiesArray[i2], (long)i2);
            }
        }
        if (n == 1 && oSRNotifyPropertiesArray != null) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    ((DSIOnlineServiceRegistrationListener)dSIListener).updateApplicationState(oSRNotifyPropertiesArray, n);
                }
            });
        }
    }

    public DSIListener getDSIDefaultHandler() {
        return this.defaultListener;
    }

    public CommandList getActiveCommandList() {
        return this.cmdListMgr.getActiveCommandList();
    }

    public LogChannel getLogChannel() {
        return this.logCh;
    }

    public String getHandlerName() {
        return this.getClass().getName();
    }

    public void setCredentialResponse(final String string, final int n) {
        this.logCh.log(100000000, "[OnlineServiceRegistrationListener#setCredentialResponse]");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).setCredentialResponse(string, n);
            }
        });
    }

    public void downloadResponse(final String string, final String string2, final String string3, final int n) {
        this.logCh.log(100000000, "[OnlineServiceRegistrationListener#downloadResponse]");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).downloadResponse(string, string2, string3, n);
            }
        });
    }

    public void resetToFactorySettingsResponse(String string, int n) {
    }

    public void updateProfileInfo(int n, String string, String string2, int n2, int n3) {
        this.defaultListener.updateProfileInfo(n, string, string2, n2, n3);
    }

    public void validateOwnerResponse(int n) {
    }

    public void checkOwnersVerificationResponse(int n) {
    }

    public void validatePortalUserResponse(int n, String string, String string2, String string3, String string4, int n2) {
    }

    public void setAccountStateResponse(int n, String string, String string2, int n2) {
    }

    public void performPortalRegistrationResponse(final String string, final int n) {
        this.logCh.log(100000000, "[OnlineServiceRegistrationListener#getUsersResponse()]");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).performPortalRegistrationResponse(string, n);
            }
        });
    }

    public void setActiveProfileResponse(int n, int n2, String string, String string2) {
    }

    public void getUsersResponse(final OSRUser[] oSRUserArray) {
        this.logCh.log(100000000, "[OnlineServiceRegistrationListener#getUsersResponse()]");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).getUsersResponse(oSRUserArray);
            }
        });
    }

    public void createUserWithPairingCodeResponse(final String string, final OSRUser oSRUser, final int n) {
        this.logCh.log(100000000, "[OnlineServiceRegistrationListener#createUserWithPairingCodeResponse()]");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).createUserWithPairingCodeResponse(string, oSRUser, n);
            }
        });
    }

    public void createUserWithUserPasswordResponse(final String string, final OSRUser oSRUser, final int n) {
        this.logCh.log(100000000, "[OnlineServiceRegistrationListener#createUserWithUserPasswordResponse()]");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).createUserWithUserPasswordResponse(string, oSRUser, n);
            }
        });
    }

    public void checkPasswordResponse(final OSRUser oSRUser, final int n) {
        this.logCh.log(100000000, "[OnlineServiceRegistrationListener#checkPasswordResponse()]");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).checkPasswordResponse(oSRUser, n);
            }
        });
    }

    public void checkPairingCodeResponse(final OSRUser oSRUser, final int n) {
        this.logCh.log(100000000, "[OnlineServiceRegistrationListener#checkPairingCodeResponse()]");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).checkPairingCodeResponse(oSRUser, n);
            }
        });
    }

    public void setPrivacyFlagsResponse(final OSRUser oSRUser) {
        this.logCh.log(100000000, "[OnlineServiceRegistrationListener#setPrivacyFlagsResponse()]");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).setPrivacyFlagsResponse(oSRUser);
            }
        });
    }

    public void setAutoLoginResponse(final OSRUser oSRUser, final OSRDevice[] oSRDeviceArray, final int[] nArray) {
        this.logCh.log(100000000, "[OnlineServiceRegistrationListener#setAutoLoginResponse()]");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).setAutoLoginResponse(oSRUser, oSRDeviceArray, nArray);
            }
        });
    }

    public void loginResponse(final OSRUser oSRUser, final int n) {
        this.logCh.log(100000000, "[OnlineServiceRegistrationListener#loginResponse()]");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).loginResponse(oSRUser, n);
            }
        });
    }

    public void logoutResponse(final OSRUser oSRUser, final int n) {
        this.logCh.log(100000000, "[OnlineServiceRegistrationListener#logoutResponse()]");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).logoutResponse(oSRUser, n);
            }
        });
    }

    public void logoutAuthSchemeResult(final String string, final OSRUser[] oSRUserArray, final int[] nArray) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).logoutAuthSchemeResult(string, oSRUserArray, nArray);
            }
        });
    }

    public void removeUserResponse(final OSRUser oSRUser, final int n) {
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).removeUserResponse(oSRUser, n);
            }
        });
    }

    public void getLicenseResponse(final int n, final OSRLicense oSRLicense) {
        this.logCh.log(100000000, "[OnlineServiceRegistrationListener#getLicenseResponse()]");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).getLicenseResponse(n, oSRLicense);
            }
        });
    }

    public void getLicensesResponse(final int n, final boolean bl, final boolean bl2, final OSRLicense[] oSRLicenseArray) {
        this.logCh.log(100000000, "[OnlineServiceRegistrationListener#getLicensesResponse()]");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).getLicensesResponse(n, bl, bl2, oSRLicenseArray);
            }
        });
    }

    public void getProfileFolderResponse(final int n, final String string, final OSRUser oSRUser, final String string2) {
        this.logCh.log(100000000, "[OnlineServiceRegistrationListener#getProfileFolderResponse()]");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).getProfileFolderResponse(n, string, oSRUser, string2);
            }
        });
    }

    public void updateCoreProfileInfo(OSRUser oSRUser, int n, int n2) {
        this.logCh.log(1000000, "OnlineServiceRegistrationListener#updateCoreProfileInfo passing forward to defaultListener");
        this.defaultListener.updateCoreProfileInfo(oSRUser, n, n2);
    }

    public void updateExternalProfileInfo(String string, OSRUser oSRUser, int n, int n2) {
        this.logCh.log(1000000, "OnlineServiceRegistrationListener#updateExternalProfileInfo passing forward to defaultListener");
        this.defaultListener.updateExternalProfileInfo(string, oSRUser, n, n2);
    }

    public void updateDeviceEnumerator(OSRDevice oSRDevice, int n, int n2) {
        this.defaultListener.updateDeviceEnumerator(oSRDevice, n, n2);
    }

    public void getCredentialsFromHeaderResponse(int n, int n2, int n3, String string, String string2, String string3) {
    }

    public void getCredentialsFromAuthSchemeResponse(int n, int n2, String string, String string2, String string3) {
    }

    public void getServiceURLResponse(int n, String string, String string2) {
    }

    public void precheckOnlineServiceServiceIDResponse(final String string, final OSRServiceState oSRServiceState) {
        this.logCh.log(100000000, "[OnlineServiceRegistrationListener#precheckOnlineServiceServiceIDResponse()]");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).precheckOnlineServiceServiceIDResponse(string, oSRServiceState);
            }
        });
    }

    public void precheckOnlineServiceSymbolicNameResponse(final String string, final OSRServiceState oSRServiceState) {
        this.logCh.log(100000000, "[OnlineServiceRegistrationListener#precheckOnlineServiceSymbolicNameResponse()]");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).precheckOnlineServiceSymbolicNameResponse(string, oSRServiceState);
            }
        });
    }

    public void precheckOnlineServiceResponse(final String string, final OSRServiceState[] oSRServiceStateArray) {
        this.logCh.log(100000000, "[OnlineServiceRegistrationListener#precheckOnlineServiceResponse()]");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIOnlineServiceRegistrationListener)dSIListener).precheckOnlineServiceResponse(string, oSRServiceStateArray);
            }
        });
    }

    public void updateServiceState(int n, int n2) {
        this.defaultListener.updateServiceState(n, n2);
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

