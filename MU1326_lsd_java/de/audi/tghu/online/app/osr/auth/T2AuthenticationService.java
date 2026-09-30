/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.PortalAuthenticationService;
import de.audi.atip.interapp.PortalAuthenticationServiceCallbackListener;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.IOsrUserCacheInformation;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationSubsystem;
import de.audi.tghu.online.app.osr.auth.AuthenticationHMIListener;
import de.audi.tghu.online.app.osr.auth.AuthenticationModelManager;
import de.audi.tghu.online.app.osr.auth.AuthenticationStates;
import de.audi.tghu.online.app.osr.auth.UpdateStates;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import de.audi.tghu.online.app.osr.command.OSRCommandList;
import de.audi.tghu.online.app.osr.command.OSRGetProfileFolderCommand;
import de.audi.tghu.online.app.osr.command.auth.CheckPasswordCommand;
import de.audi.tghu.online.app.osr.command.auth.CreateNewUserCommand;
import de.audi.tghu.online.app.osr.command.auth.GetUsersCommand;
import de.audi.tghu.online.app.osr.command.auth.LoginCommand;
import de.audi.tghu.online.app.osr.command.auth.LogoutAllUsersCommand;
import de.audi.tghu.online.app.osr.command.auth.LogoutCommand;
import de.audi.tghu.online.app.osr.command.auth.OSRDeleteUserCommand;
import de.audi.tghu.online.app.osr.command.auth.PerformPortalRegistrationCommand;
import de.audi.tghu.online.app.osr.command.auth.SetAutoLoginCommand;
import de.audi.tghu.online.app.osr.command.auth.SetPrivacyCommand;
import de.audi.tghu.online.app.osr.command.auth.ValidateCredentialsCommand;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRUser;

public class T2AuthenticationService
implements PortalAuthenticationService {
    private int popupDeleteUserOk = -1;
    private static final String LOGCLASS = "T2AuthenticationService";
    protected final LogChannel log;
    protected AuthenticationHMIListener hmiHandler;
    protected AuthenticationModelManager modelManager;
    private OnlineServiceRegistrationSubsystem orsApplication;
    private List updateProfileInfoListeners = new ArrayList(1);
    private boolean blockEvents = false;
    private boolean pendingEvent = false;
    private IOsrUserCacheInformation pendingCacheInfos;
    private OSRCommandList currentCommandList;
    public static Map authenticationStates = new AuthenticationStates();
    private List loginStateListeners = new ArrayList();
    public static Map updateStates = new UpdateStates();

    public void addLoginStateListener(PortalAuthenticationService.ILoginStateListener iLoginStateListener) {
        this.loginStateListeners.add(iLoginStateListener);
    }

    private void updateLoginState(int n) {
        for (int i2 = 0; i2 < this.loginStateListeners.size(); ++i2) {
            ((PortalAuthenticationService.ILoginStateListener)this.loginStateListeners.get(i2)).updateState(n);
        }
    }

    public T2AuthenticationService(LogChannel logChannel, OnlineServiceRegistrationSubsystem onlineServiceRegistrationSubsystem) {
        this.log = logChannel;
        this.orsApplication = onlineServiceRegistrationSubsystem;
        logChannel.log(100000000, "[%1#<init>]", (Object)LOGCLASS);
        this.modelManager = new AuthenticationModelManager(onlineServiceRegistrationSubsystem.getFramework().getHMIService(), logChannel);
        this.hmiHandler = new AuthenticationHMIListener(logChannel, this);
        this.hmiHandler.setModelManager(this.modelManager);
    }

    public void destroy() {
        this.hmiHandler.deinit();
        this.hmiHandler = null;
        this.modelManager = null;
    }

    private void determineDrawerCetegory() {
        this.modelManager.setDrawerCategory(this.orsApplication.getDrawerCategory());
    }

    public void setPopupIds(int n, int n2) {
        this.popupDeleteUserOk = n;
    }

    public void updateCoreProfileInfo(OSRUser oSRUser, int n, int n2) {
        this.log.log(1000000, "%1#updateCoreProfileInfo: user: %2 update: %3", (Object)LOGCLASS, (Object)oSRUser, (long)n);
        if (n2 == 2) {
            this.log.log(10000, "%1#updateCoreProfileInfo: updateCoreProfileInfo with invalid-flag set. Setting current user to null", (Object)LOGCLASS);
            this.modelManager.setCurrentUser(null);
            return;
        }
        if (n == 0) {
            this.modelManager.setCurrentUser(oSRUser);
            this.modelManager.updateAuthStatus(0);
            this.updateProfileListeners(true, oSRUser, "persCache");
        } else if (n == 1) {
            this.modelManager.updateAuthStatus(1);
            this.indicateUserLoggedOut(this.modelManager.getOsrContainer(oSRUser));
            this.modelManager.setCurrentUser(null);
        } else if (n == 3 && oSRUser == null) {
            this.modelManager.setCurrentUser(null);
            this.updateProfileListeners(false, oSRUser, "persCache");
        }
    }

    private void indicateUserLoggedOut(AuthenticationModelManager.OsrUserContainer osrUserContainer) {
        if (osrUserContainer == null) {
            this.log.log(100000, "%1#indicateLoggedOutUser no valid user container found", (Object)LOGCLASS);
            return;
        }
        IOsrUserCacheInformation iOsrUserCacheInformation = osrUserContainer.getCacheInfo();
        if (iOsrUserCacheInformation == null) {
            this.log.log(100000, "%1#indicateLoggedOutUser no valid cache info for user", (Object)LOGCLASS);
            return;
        }
        iOsrUserCacheInformation.setAuthenticated(false);
        this.sendCoreProfileUpdateEvent(iOsrUserCacheInformation);
        this.updateLoginState(4);
    }

    public void updateExternalProfileInfo(String string, OSRUser oSRUser, int n, int n2) {
        this.log.log(1000000, "%1#updateExternalProfileInfo: appID: %2 user: %3 update: %4", (Object)LOGCLASS, (Object)string, (Object)oSRUser, updateStates.get(new Integer(n)));
        if (n == 3 && n2 == 1) {
            this.modelManager.setCoreServicesReady();
        }
        if (oSRUser == null) {
            this.log.log(10000, "%1#updateExternalProfileInfo: updateExternalProfileInfo without valid user: NULL", (Object)LOGCLASS);
            return;
        }
        if (n2 == 2) {
            this.log.log(100000, "%1#updateExternalProfileInfo: updateExternalProfileInfo with invalid-flag set", (Object)LOGCLASS);
            return;
        }
        if (n == 0) {
            this.log.log(1000000, "%1#updateExternalProfileInfo: adding active user", (Object)LOGCLASS);
            this.modelManager.addNewUser(oSRUser, string);
        } else if (n == 1) {
            this.log.log(1000000, "%1#updateExternalProfileInfo: removing active user", (Object)LOGCLASS);
            this.modelManager.removeUser(oSRUser);
        } else if (n == 3) {
            this.modelManager.clearUsersList();
        } else if (n == 2) {
            this.modelManager.replaceUser(oSRUser);
        }
        this.modelManager.setCoreServicesReady();
    }

    public void updateDeviceEnumerator(OSRDevice oSRDevice, int n, int n2) {
        if (n2 == 2) {
            this.log.log(100000, "%1#updateDeviceEnumerator: updateDeviceEnumerator: with invalid-flag set", (Object)LOGCLASS);
            return;
        }
        if (oSRDevice == null) {
            this.log.log(100000, "%1#updateDeviceEnumerator: device is null", (Object)LOGCLASS);
            return;
        }
        this.log.log(1000000, "%1#updateDeviceEnumerator: device %2 updateControl %3", (Object)LOGCLASS, (Object)oSRDevice.getName(), updateStates.get(new Integer(n)));
        if (n == 0) {
            this.modelManager.addDevice(oSRDevice);
        } else if (n == 1) {
            this.modelManager.removeDevice(oSRDevice);
        } else if (n == 2) {
            this.modelManager.updateDevice(oSRDevice);
        }
        this.updateDeviceListeners(this.modelManager.getAvailableDevices());
    }

    public void init() {
        this.currentCommandList = null;
        this.determineDrawerCetegory();
        this.modelManager.initializeAuthentication();
        this.modelManager.setSyncModelsWaiting();
        this.blockEvents = true;
    }

    public void handleCredentialsFromSpeller(String string, String string2) {
        boolean bl = this.modelManager.isCreateNewUser();
        this.log.log(1000000, "[%1#handleCredentialsFromSpeller] name: %2 pwd: %3", (Object)LOGCLASS, (Object)string, (Object)string2);
        CreateNewUserCommand createNewUserCommand = null;
        if (bl) {
            this.log.log(1000000, "[%1#handleCredentialsFromSpeller] and create a new user", (Object)LOGCLASS);
            createNewUserCommand = new CreateNewUserCommand(string, string2, new CreateNewUserCommand.CreateNewUserCommandResponseListener(){

                public void createNewUserResponse(OSRUser oSRUser, int n) {
                    T2AuthenticationService.this.handleCreateNewUserResponse(oSRUser, n);
                }
            });
        }
        if (string2 == null || string2.length() == 0 || string == null || string.length() == 0) {
            this.log.log(100000, "[%1#handleCredentialsFromSpeller] invalid username or password", (Object)LOGCLASS);
            return;
        }
        this.checkPasswordOrParingCode(createNewUserCommand, string2, false);
    }

    private void handleCreateNewUserResponse(OSRUser oSRUser, int n) {
        if (n != 0) {
            this.log.log(1000000, "T2AuthenticationService#handleCreateNewUserResponse: could not create a new User response: %1", (long)n);
            this.modelManager.updateAuthStatus(n);
            this.updateLoginState(this.mapLoginResultToHMICode(n));
            if (n == 1) {
                this.modelManager.getChoiceModel(2301612).setValue(1);
                this.modelManager.clearSpellermodel(2300923);
            }
            return;
        }
        if (oSRUser == null) {
            this.log.log(1000000, "T2AuthenticationService#handleCreateNewUserResponse: could not create a new User (null)");
            return;
        }
        this.log.log(10000000, "T2AuthenticationService#handleCreateNewUserResponse: user %1 result: %2", (Object)oSRUser.getName(), (long)n);
        this.modelManager.setCurrentUser(oSRUser);
    }

    protected int convertLegacyResultCode(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            default: {
                n2 = 3004;
            }
        }
        return n2;
    }

    public static int convertDsiToHmiStates(int n) {
        Integer n2 = (Integer)authenticationStates.get(new Integer(n));
        if (n2 == null) {
            return 3;
        }
        return n2;
    }

    public void registerUpdateProfileInfoListener(PortalAuthenticationService.UpdateProfileInfoListener updateProfileInfoListener) {
        this.updateProfileInfoListeners.add(updateProfileInfoListener);
    }

    private void updateProfileListeners(boolean bl, OSRUser oSRUser, String string) {
        this.log.log(1000000, "%1#updateProfileListeners queueing command ORSGetProfileFolderCommand", (Object)LOGCLASS);
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        ((CommandList)oSRCommandList).add(new OSRGetProfileFolderCommand(oSRUser, string, bl, new OSRGetProfileFolderCommand.ORSGetProfileFolderCommandListener(){

            public void getProfileFolderResponse(int n, String string, OSRUser oSRUser, String string2, boolean bl) {
                T2AuthenticationService.this.log.log(1000000, "%1#getProfileFolderResponse result: %4 path:%2 user: %3", (Object)T2AuthenticationService.LOGCLASS, (Object)string, (Object)(oSRUser != null ? oSRUser.getPortalUser() : "null"), (long)n);
                if (n != 0) {
                    return;
                }
                T2AuthenticationService.this.pendingCacheInfos = new CacheInfos(oSRUser, string, string2, bl);
                T2AuthenticationService.this.modelManager.storeCacheInfosForUser(oSRUser, T2AuthenticationService.this.pendingCacheInfos);
                T2AuthenticationService.this.checkAndSendPendingProfileInfos();
            }
        }));
        oSRCommandList.execute("get-Profile-Folder");
    }

    private void checkAndSendPendingProfileInfos() {
        if (this.orsApplication.isLoginCancelable() && this.blockEvents) {
            this.log.log(1000000, "%1#getProfileFolderResponse Events are blocked atm. Adding to pending event");
            this.pendingEvent = true;
            return;
        }
        this.pendingEvent = false;
        this.sendCoreProfileUpdateEvent();
    }

    private void sendCoreProfileUpdateEvent() {
        this.log.log(1000000, "%1#sendCoreProfileUpdateEvent authentication finished: sending update (pending)", (Object)LOGCLASS);
        this.sendCoreProfileUpdateEvent(this.pendingCacheInfos);
    }

    private void sendCoreProfileUpdateEvent(IOsrUserCacheInformation iOsrUserCacheInformation) {
        this.log.log(1000000, "%1#sendCoreProfileUpdateEvent authentication finished: sending update", (Object)LOGCLASS);
        Iterator iterator = this.updateProfileInfoListeners.iterator();
        while (iterator.hasNext()) {
            PortalAuthenticationService.UpdateProfileInfoListener updateProfileInfoListener = (PortalAuthenticationService.UpdateProfileInfoListener)iterator.next();
            updateProfileInfoListener.updateProfileInfo(iOsrUserCacheInformation);
        }
    }

    private void updateDeviceListeners(OSRDevice[] oSRDeviceArray) {
        Iterator iterator = this.updateProfileInfoListeners.iterator();
        while (iterator.hasNext()) {
            PortalAuthenticationService.UpdateProfileInfoListener updateProfileInfoListener = (PortalAuthenticationService.UpdateProfileInfoListener)iterator.next();
            updateProfileInfoListener.updateDeviceInfo(oSRDeviceArray);
        }
    }

    public void logoutCurrentUser() {
        OSRCommandList oSRCommandList;
        this.updateLoginState(2);
        this.blockEvents = true;
        this.currentCommandList = oSRCommandList = this.orsApplication.createCommandList();
        this.log.log(1000000, "%1#logoutCurrentUser creating command LogoutCommand", (Object)LOGCLASS);
        oSRCommandList.setErrorCommand(new AbstractOSRCommand(){

            public void execute() {
                T2AuthenticationService.this.log.log(1000000, "%1#logout current User command list errorCommand execute", (Object)T2AuthenticationService.LOGCLASS);
                int n = 10;
                T2AuthenticationService.this.modelManager.updateAuthStatus(n);
                this.getCommandList().commandFinished();
            }
        });
        oSRCommandList.add(new LogoutCommand(this.modelManager.getCurrentUser(), new LogoutCommand.LogoutCommandResponseListener(){

            public void logoutCommandResponse(OSRUser oSRUser, int n) {
                T2AuthenticationService.this.log.log(1000000, "%1#logoutCommandResponse response: %2", (Object)T2AuthenticationService.LOGCLASS, (long)n);
                if (n == 0) {
                    T2AuthenticationService.this.modelManager.setCurrentUser(null);
                    T2AuthenticationService.this.modelManager.updateAuthStatus(13);
                    T2AuthenticationService.this.orsApplication.restoreScreenTypeAfterAuthentication();
                    T2AuthenticationService.this.modelManager.releaseLogoutModel();
                    T2AuthenticationService.this.updateLoginState(4);
                }
            }
        }));
        oSRCommandList.execute("logout-current-user");
    }

    public void logoutAllUsers() {
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        oSRCommandList.setErrorCommand(new AbstractOSRCommand(){

            public void execute() {
                T2AuthenticationService.this.log.log(1000000, "%1#logout command list errorCommand execute");
                int n = 10;
                T2AuthenticationService.this.modelManager.updateAuthStatus(n);
                this.getCommandList().commandFinished();
            }
        });
        oSRCommandList.add(new LogoutAllUsersCommand(new LogoutAllUsersCommand.LogoutAllUsersCommandResponseListener(){

            public void logoutAllUsersCommandResponse(OSRUser[] oSRUserArray, int[] nArray) {
                T2AuthenticationService.this.log.log(1000000, "%1#logoutAllUsersCommandResponse");
                T2AuthenticationService.this.modelManager.setCurrentUser(null);
                T2AuthenticationService.this.modelManager.updateAuthStatus(13);
                T2AuthenticationService.this.modelManager.releaseLogoutModel();
            }
        }));
        oSRCommandList.execute(this.getClass().getName());
    }

    public void loginUserWithSavedCredentials() {
        OSRUser oSRUser = this.modelManager.getCurrentUser();
        if (oSRUser == null) {
            this.log.log(100000, "T2AuthenticationService#loginUserWithSavedCredentials: no user selected (null)");
            return;
        }
        this.log.log(1000000, "T2AuthenticationService#loginUserWithSavedCredentials: try to login user %1", (Object)oSRUser.getName());
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        this.login(oSRCommandList, new AuthCallbackListenerHelper());
    }

    public void checkPasswordOrParingCode(AbstractOSRCommand abstractOSRCommand, String string, boolean bl) {
        this.log.log(1000000, "%1#checkPasswordOrParingCode Precondition: %2, pwd: %3", (Object)LOGCLASS, (Object)abstractOSRCommand, (Object)string);
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        if (abstractOSRCommand != null) {
            oSRCommandList.add(abstractOSRCommand);
        }
        this.log.log(1000000, "%1#checkPasswordOrParingCode adding Command >l with pairingCode: %2", (Object)LOGCLASS, (Object)Boolean.toString(bl));
        oSRCommandList.add(new CheckPasswordCommand(string, this.modelManager.isBackendVerficationNeccessary(), bl, new CheckPasswordCommand.CheckPasswordCommandResponseListener(){

            public void checkPasswordCommandResponse(OSRUser oSRUser, int n) {
                T2AuthenticationService.this.log.log(1000000, "%1#checkPasswordCommandResponse response:%2", (Object)T2AuthenticationService.LOGCLASS, (long)n);
                T2AuthenticationService.this.modelManager.updateAuthStatus(n);
                int n2 = T2AuthenticationService.this.mapLoginResultToHMICode(n);
                if (n2 == 3 && T2AuthenticationService.this.modelManager.isCreateNewUser()) {
                    n2 = 10;
                }
                T2AuthenticationService.this.updateLoginState(n2);
                if (n != 0) {
                    if (n == 1) {
                        T2AuthenticationService.this.modelManager.getChoiceModel(2301612).setValue(1);
                    }
                    T2AuthenticationService.this.modelManager.clearSpellermodel(2300923);
                    T2AuthenticationService.this.modelManager.clearSpellermodel(2300931);
                    T2AuthenticationService.this.modelManager.clearTextFieldModel(2301129);
                }
            }
        }));
        this.login(oSRCommandList, new AuthCallbackListenerHelper());
    }

    public void storePrivacySettings(boolean bl) {
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        if (bl) {
            oSRCommandList.add(new SetPrivacyCommand(this.modelManager.getCurrentUser(), 20));
            oSRCommandList.add(new SetAutoLoginCommand(this.modelManager.getCurrentUser(), this.modelManager.getLoginDevices(), new SetAutoLoginCommand.SetAutoLoginCommandResponseListener(){

                public void setAutoLoginResponse(OSRUser oSRUser, int[] nArray) {
                }
            }));
        } else {
            oSRCommandList.add(new SetPrivacyCommand(this.modelManager.getCurrentUser(), 4 | this.modelManager.getPrivacySettings()));
        }
        oSRCommandList.execute("storePrivacySettings");
    }

    private void login(OSRCommandList oSRCommandList, final PortalAuthenticationServiceCallbackListener portalAuthenticationServiceCallbackListener) {
        this.modelManager.setSyncModelsWaiting();
        oSRCommandList.setErrorCommand(new AbstractOSRCommand(){

            public void execute() {
                int n = ((CommandList)this.getCommandList()).getStatus();
                T2AuthenticationService.this.log.log(10000, "%1#login CommandList execute ErrorCommand. reason: %2", (Object)T2AuthenticationService.LOGCLASS, (long)n);
                if (n != 1) {
                    int n2 = 10;
                    T2AuthenticationService.this.modelManager.updateAuthStatus(n2);
                    T2AuthenticationService.this.updateLoginState(T2AuthenticationService.this.mapLoginResultToHMICode(n2));
                }
                this.getCommandList().commandAborted("login Command List was aborted");
                this.getCommandList().commandFinished();
            }
        });
        LoginCommand loginCommand = new LoginCommand(new LoginCommand.LoginCommandResponseListener(){

            public void loginCommandResponse(OSRUser oSRUser, int n) {
                T2AuthenticationService.this.log.log(1000000, "%1#loginCommandResponse result: %2", (Object)T2AuthenticationService.LOGCLASS, (long)n);
                T2AuthenticationService.this.modelManager.updateAuthStatus(n);
                int n2 = T2AuthenticationService.this.mapLoginResultToHMICode(n);
                T2AuthenticationService.this.log.log(10000000, "%1#loginCommandResponse AUTHENTICATION_CREDENTIALS_AVAILABLE_CHOICE: %2", (Object)T2AuthenticationService.LOGCLASS, (Object)Integer.toString(T2AuthenticationService.this.modelManager.getChoiceModel(2300928).getValue()));
                if (n2 == 3 && T2AuthenticationService.this.modelManager.getChoiceModel(2300928).getValue() == 0) {
                    if (T2AuthenticationService.this.modelManager.isCreateNewUser()) {
                        n2 = 10;
                    } else {
                        ChoiceModelApp choiceModelApp = T2AuthenticationService.this.modelManager.getChoiceModel(2301731);
                        choiceModelApp.setValue(choiceModelApp.getValue() ^ 1);
                    }
                }
                T2AuthenticationService.this.updateLoginState(n2);
                if (n != 0) {
                    if (n == 1) {
                        T2AuthenticationService.this.modelManager.getChoiceModel(2301612).setValue(1);
                    }
                    T2AuthenticationService.this.modelManager.clearSpellermodel(2300923);
                }
                if (portalAuthenticationServiceCallbackListener != null) {
                    portalAuthenticationServiceCallbackListener.loginResult(n);
                }
            }
        });
        this.currentCommandList = oSRCommandList;
        oSRCommandList.add(loginCommand);
        oSRCommandList.execute(this.getClass().getName());
    }

    private int mapLoginResultToHMICode(int n) {
        switch (n) {
            case 0: {
                return 3;
            }
            case 2: {
                return 7;
            }
            case 1: {
                return 5;
            }
            case 20: {
                return 8;
            }
            case 10: {
                return 7;
            }
        }
        return 6;
    }

    public boolean isAuthenticated() {
        return this.modelManager.isAuthenticated();
    }

    public AuthenticationModelManager getModelManager() {
        return this.modelManager;
    }

    public void indicateAuthenticationDialogFinsihed() {
        this.currentCommandList = null;
        this.blockEvents = false;
        this.orsApplication.restoreScreenTypeAfterAuthentication();
        if (this.pendingEvent) {
            this.log.log(1000000, "%1#indicateAuthenticationDialogFinsihed sending pending request", (Object)LOGCLASS);
            this.sendCoreProfileUpdateEvent();
        }
    }

    public void indicateLogoutDialogFinsihed() {
        this.currentCommandList = null;
        this.blockEvents = false;
        if (this.pendingEvent) {
            this.log.log(1000000, "%1#indicateLogoutDialogFinsihed sending pending request", (Object)LOGCLASS);
            this.sendCoreProfileUpdateEvent();
        }
    }

    public void deleteFocusedUser() {
        this.log.log(1000000, "%1#deleteFocusedUser() queue in command", (Object)LOGCLASS);
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        oSRCommandList.add(new OSRDeleteUserCommand(this.modelManager.getFocusedUser(), new OSRDeleteUserCommand.IDeleteUserCommandResponseListener(){

            public void removeUserResponse(OSRUser oSRUser, int n) {
                T2AuthenticationService.this.modelManager.showPopup(T2AuthenticationService.this.popupDeleteUserOk);
            }
        }));
        oSRCommandList.execute("deleteUser");
    }

    public void cancelActiveCommand() {
        this.log.log(1000000, "%1#cancelActiveCommand", (Object)LOGCLASS);
        if (this.currentCommandList == null) {
            this.log.log(1000000, "%1#cancelActiveCommand no active commandList", (Object)LOGCLASS);
            return;
        }
        CommandList commandList = this.currentCommandList.cancelCurrentCommand();
        commandList.execute("cancel-current-command-List");
    }

    public void startPortalRegistration(String string) {
        this.modelManager.setRegistrationModelsWaiting();
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        oSRCommandList.setErrorCommand(new AbstractOSRCommand(){

            public void execute() {
                T2AuthenticationService.this.modelManager.setRegistrationModelsResult(10);
                this.getCommandList().commandFinished();
            }
        });
        oSRCommandList.add(new PerformPortalRegistrationCommand(string, new PerformPortalRegistrationCommand.PerformPortalRegistrationCommandResponseListener(){

            public void performPortalRegistrationResponse(String string, int n) {
                T2AuthenticationService.this.modelManager.setRegistrationModelsResult(n);
            }
        }));
        oSRCommandList.execute(this.getClass().getName());
    }

    public void validatePairingCode(String string, PortalAuthenticationServiceCallbackListener portalAuthenticationServiceCallbackListener) {
    }

    public void requestUsersList() {
        this.log.log(1000000, "%1requestUsersList", (Object)LOGCLASS);
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        oSRCommandList.setErrorCommand(new AbstractOSRCommand(){

            public void execute() {
                T2AuthenticationService.this.log.log(1000000, "%1#Request Users CommandList execute error command", (Object)T2AuthenticationService.LOGCLASS);
                int n = 10;
                T2AuthenticationService.this.modelManager.updateAuthStatus(n);
                this.getCommandList().commandFinished();
            }
        });
        GetUsersCommand getUsersCommand = new GetUsersCommand(new GetUsersCommand.GetUsersCommandListener(){

            public void getUsersResponse(OSRUser[] oSRUserArray) {
                if (oSRUserArray == null) {
                    T2AuthenticationService.this.log.log(1000000, "%1#GetUsersCommandListener: response Received empty user list");
                } else {
                    T2AuthenticationService.this.log.log(1000000, "%1#GetUsersCommandListener: response Received usersList-length: %2", (Object)T2AuthenticationService.LOGCLASS, (long)oSRUserArray.length);
                }
            }
        });
        oSRCommandList.add(getUsersCommand);
        oSRCommandList.execute(LOGCLASS);
    }

    public void handlePairingCodeFromSpeller(String string) {
        this.updateLoginState(string.length() > 0 ? 1 : 9);
        boolean bl = this.modelManager.isCreateNewUser();
        this.log.log(1000000, "%1#handlePairingCodeFromSpeller: pairingCode: %2 createnewUser: %3", (Object)LOGCLASS, (Object)string, (Object)Boolean.toString(bl));
        CreateNewUserCommand createNewUserCommand = null;
        if (bl) {
            createNewUserCommand = new CreateNewUserCommand(string, new CreateNewUserCommand.CreateNewUserCommandResponseListener(){

                public void createNewUserResponse(OSRUser oSRUser, int n) {
                    T2AuthenticationService.this.handleCreateNewUserResponse(oSRUser, n);
                }
            });
        }
        if (string == null || string.length() < 1) {
            this.log.log(100000, "%1#handlePairingCodeFromSpeller: invalid pairingcode!: %2", (Object)LOGCLASS, (Object)string);
            return;
        }
        this.checkPasswordOrParingCode(createNewUserCommand, string, true);
    }

    public void validateCredentials(String string, String string2, final PortalAuthenticationServiceCallbackListener portalAuthenticationServiceCallbackListener) {
        this.log.log(1000000, "%1validateCredentials", (Object)LOGCLASS);
        this.modelManager.setSyncModelsWaiting();
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        oSRCommandList.setErrorCommand(new AbstractOSRCommand(){

            public void execute() {
                T2AuthenticationService.this.log.log(1000000, "%1#validateCredentials command List execute Error Command", (Object)T2AuthenticationService.LOGCLASS);
                int n = 10;
                int n2 = T2AuthenticationService.this.convertLegacyResultCode(n);
                T2AuthenticationService.this.modelManager.updateAuthStatus(n);
                if (portalAuthenticationServiceCallbackListener != null) {
                    portalAuthenticationServiceCallbackListener.validateCredentialsResult(false, n, n2);
                }
                this.getCommandList().commandFinished();
            }
        });
        ValidateCredentialsCommand validateCredentialsCommand = new ValidateCredentialsCommand(string, string2, new ValidateCredentialsCommand.ValidateCredentialsCommandListener(){

            public void validateCredentialsCommandResponse(int n) {
                T2AuthenticationService.this.log.log(1000000, "%1#validateCredentialsCommandResponse [Result:%2", (Object)T2AuthenticationService.LOGCLASS, (long)n);
                int n2 = n;
                T2AuthenticationService.this.modelManager.updateAuthStatus(n);
                if (portalAuthenticationServiceCallbackListener != null) {
                    portalAuthenticationServiceCallbackListener.validateCredentialsResult(n2 == 0, n, n2);
                }
            }
        });
        oSRCommandList.add(validateCredentialsCommand);
        oSRCommandList.execute(this.getClass().getName());
    }

    public void deleteCurrentUser() {
        OSRUser oSRUser = this.modelManager.getCurrentUser();
        this.log.log(1000000, "%1#deleteCurrentUser user: %2", (Object)LOGCLASS, (Object)oSRUser);
        if (oSRUser == null) {
            return;
        }
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        oSRCommandList.add(new OSRDeleteUserCommand(oSRUser, new OSRDeleteUserCommand.IDeleteUserCommandResponseListener(){

            public void removeUserResponse(OSRUser oSRUser, int n) {
                T2AuthenticationService.this.log.log(1000000, "%1#deleteCurrentUserResponse user: %1 deleted successfully", (Object)T2AuthenticationService.LOGCLASS, (Object)oSRUser);
            }
        }));
        oSRCommandList.execute("deleteCurrentUser");
    }

    public class CacheInfos
    implements IOsrUserCacheInformation {
        OSRUser user;
        String path;
        String domain;
        boolean authenticated;

        public CacheInfos(OSRUser oSRUser, String string, String string2, boolean bl) {
            this.user = oSRUser;
            this.path = string;
            this.domain = string2;
            this.authenticated = bl;
        }

        public void setAuthenticated(boolean bl) {
            this.authenticated = bl;
        }

        public Object getUser() {
            return this.user;
        }

        public String getProfilePath() {
            return this.path;
        }

        public boolean isAuthenticated() {
            return this.authenticated;
        }

        public String getDomain() {
            return this.domain;
        }
    }

    class AuthCallbackListenerHelper
    implements PortalAuthenticationServiceCallbackListener {
        AuthCallbackListenerHelper() {
        }

        public void validatePairingCodeResult(boolean bl, int n, int n2) {
            if (!bl) {
                T2AuthenticationService.this.modelManager.clearSpellermodel(2300923);
            }
        }

        public void validateCredentialsResult(boolean bl, int n, int n2) {
            if (!bl) {
                T2AuthenticationService.this.modelManager.clearSpellermodel(2300931);
            }
        }

        public void loginResult(int n) {
            T2AuthenticationService.this.log.log(1000000, "%1AuthCallbackListenerHelper#loginResult %2 updateProfileInfoListeners", (Object)T2AuthenticationService.LOGCLASS, (long)n);
            if (n == 1) {
                T2AuthenticationService.this.modelManager.setBackendVerificationNeccessary(true);
                return;
            }
        }
    }
}

