/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.atip.interapp.PortalAuthenticationService;
import de.audi.atip.interapp.PortalAuthenticationService$ILoginStateListener;
import de.audi.atip.interapp.PortalAuthenticationService$UpdateProfileInfoListener;
import de.audi.atip.interapp.PortalAuthenticationServiceCallbackListener;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.IOsrUserCacheInformation;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationSubsystem;
import de.audi.tghu.online.app.osr.auth.AuthenticationHMIListener;
import de.audi.tghu.online.app.osr.auth.AuthenticationModelManager;
import de.audi.tghu.online.app.osr.auth.AuthenticationModelManager$OsrUserContainer;
import de.audi.tghu.online.app.osr.auth.AuthenticationStates;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService$1;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService$10;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService$11;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService$12;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService$13;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService$14;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService$15;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService$16;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService$17;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService$18;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService$19;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService$2;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService$3;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService$4;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService$5;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService$6;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService$7;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService$8;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService$9;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService$AuthCallbackListenerHelper;
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
    private static final String LOGCLASS;
    protected final LogChannel log;
    protected AuthenticationHMIListener hmiHandler;
    protected AuthenticationModelManager modelManager;
    private OnlineServiceRegistrationSubsystem orsApplication;
    private List updateProfileInfoListeners = new ArrayList(1);
    private boolean blockEvents = false;
    private boolean pendingEvent = false;
    private IOsrUserCacheInformation pendingCacheInfos;
    private OSRCommandList currentCommandList;
    public static Map authenticationStates;
    private List loginStateListeners = new ArrayList();
    public static Map updateStates;

    @Override
    public void addLoginStateListener(PortalAuthenticationService$ILoginStateListener portalAuthenticationService$ILoginStateListener) {
        this.loginStateListeners.add(portalAuthenticationService$ILoginStateListener);
    }

    private void updateLoginState(int n) {
        for (int i2 = 0; i2 < this.loginStateListeners.size(); ++i2) {
            ((PortalAuthenticationService$ILoginStateListener)this.loginStateListeners.get(i2)).updateState(n);
        }
    }

    public T2AuthenticationService(LogChannel logChannel, OnlineServiceRegistrationSubsystem onlineServiceRegistrationSubsystem) {
        this.log = logChannel;
        this.orsApplication = onlineServiceRegistrationSubsystem;
        logChannel.log(14808325, "[%1#<init>]", (Object)"T2AuthenticationService");
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
        this.log.log(1078071040, "%1#updateCoreProfileInfo: user: %2 update: %3", (Object)"T2AuthenticationService", (Object)oSRUser, (long)n);
        if (n2 == 2) {
            this.log.log(10000, "%1#updateCoreProfileInfo: updateCoreProfileInfo with invalid-flag set. Setting current user to null", (Object)"T2AuthenticationService");
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

    private void indicateUserLoggedOut(AuthenticationModelManager$OsrUserContainer authenticationModelManager$OsrUserContainer) {
        if (authenticationModelManager$OsrUserContainer == null) {
            this.log.log(-1601830656, "%1#indicateLoggedOutUser no valid user container found", (Object)"T2AuthenticationService");
            return;
        }
        IOsrUserCacheInformation iOsrUserCacheInformation = authenticationModelManager$OsrUserContainer.getCacheInfo();
        if (iOsrUserCacheInformation == null) {
            this.log.log(-1601830656, "%1#indicateLoggedOutUser no valid cache info for user", (Object)"T2AuthenticationService");
            return;
        }
        iOsrUserCacheInformation.setAuthenticated(false);
        this.sendCoreProfileUpdateEvent(iOsrUserCacheInformation);
        this.updateLoginState(4);
    }

    public void updateExternalProfileInfo(String string, OSRUser oSRUser, int n, int n2) {
        this.log.log(1078071040, "%1#updateExternalProfileInfo: appID: %2 user: %3 update: %4", (Object)"T2AuthenticationService", (Object)string, (Object)oSRUser, updateStates.get(new Integer(n)));
        if (n == 3 && n2 == 1) {
            this.modelManager.setCoreServicesReady();
        }
        if (oSRUser == null) {
            this.log.log(10000, "%1#updateExternalProfileInfo: updateExternalProfileInfo without valid user: NULL", (Object)"T2AuthenticationService");
            return;
        }
        if (n2 == 2) {
            this.log.log(-1601830656, "%1#updateExternalProfileInfo: updateExternalProfileInfo with invalid-flag set", (Object)"T2AuthenticationService");
            return;
        }
        if (n == 0) {
            this.log.log(1078071040, "%1#updateExternalProfileInfo: adding active user", (Object)"T2AuthenticationService");
            this.modelManager.addNewUser(oSRUser, string);
        } else if (n == 1) {
            this.log.log(1078071040, "%1#updateExternalProfileInfo: removing active user", (Object)"T2AuthenticationService");
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
            this.log.log(-1601830656, "%1#updateDeviceEnumerator: updateDeviceEnumerator: with invalid-flag set", (Object)"T2AuthenticationService");
            return;
        }
        if (oSRDevice == null) {
            this.log.log(-1601830656, "%1#updateDeviceEnumerator: device is null", (Object)"T2AuthenticationService");
            return;
        }
        this.log.log(1078071040, "%1#updateDeviceEnumerator: device %2 updateControl %3", (Object)"T2AuthenticationService", (Object)oSRDevice.getName(), updateStates.get(new Integer(n)));
        if (n == 0) {
            this.modelManager.addDevice(oSRDevice);
        } else if (n == 1) {
            this.modelManager.removeDevice(oSRDevice);
        } else if (n == 2) {
            this.modelManager.updateDevice(oSRDevice);
        }
        this.updateDeviceListeners(this.modelManager.getAvailableDevices());
    }

    @Override
    public void init() {
        this.currentCommandList = null;
        this.determineDrawerCetegory();
        this.modelManager.initializeAuthentication();
        this.modelManager.setSyncModelsWaiting();
        this.blockEvents = true;
    }

    public void handleCredentialsFromSpeller(String string, String string2) {
        boolean bl = this.modelManager.isCreateNewUser();
        this.log.log(1078071040, "[%1#handleCredentialsFromSpeller] name: %2 pwd: %3", (Object)"T2AuthenticationService", (Object)string, (Object)string2);
        CreateNewUserCommand createNewUserCommand = null;
        if (bl) {
            this.log.log(1078071040, "[%1#handleCredentialsFromSpeller] and create a new user", (Object)"T2AuthenticationService");
            createNewUserCommand = new CreateNewUserCommand(string, string2, new T2AuthenticationService$1(this));
        }
        if (string2 == null || string2.length() == 0 || string == null || string.length() == 0) {
            this.log.log(-1601830656, "[%1#handleCredentialsFromSpeller] invalid username or password", (Object)"T2AuthenticationService");
            return;
        }
        this.checkPasswordOrParingCode(createNewUserCommand, string2, false);
    }

    private void handleCreateNewUserResponse(OSRUser oSRUser, int n) {
        if (n != 0) {
            this.log.log(1078071040, "T2AuthenticationService#handleCreateNewUserResponse: could not create a new User response: %1", (long)n);
            this.modelManager.updateAuthStatus(n);
            this.updateLoginState(this.mapLoginResultToHMICode(n));
            if (n == 1) {
                this.modelManager.getChoiceModel(-1407311104).setValue(1);
                this.modelManager.clearSpellermodel(-82107648);
            }
            return;
        }
        if (oSRUser == null) {
            this.log.log(1078071040, "T2AuthenticationService#handleCreateNewUserResponse: could not create a new User (null)");
            return;
        }
        this.log.log(-2137614336, "T2AuthenticationService#handleCreateNewUserResponse: user %1 result: %2", (Object)oSRUser.getName(), (long)n);
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

    @Override
    public void registerUpdateProfileInfoListener(PortalAuthenticationService$UpdateProfileInfoListener portalAuthenticationService$UpdateProfileInfoListener) {
        this.updateProfileInfoListeners.add(portalAuthenticationService$UpdateProfileInfoListener);
    }

    private void updateProfileListeners(boolean bl, OSRUser oSRUser, String string) {
        this.log.log(1078071040, "%1#updateProfileListeners queueing command ORSGetProfileFolderCommand", (Object)"T2AuthenticationService");
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        ((CommandList)oSRCommandList).add(new OSRGetProfileFolderCommand(oSRUser, string, bl, new T2AuthenticationService$2(this)));
        oSRCommandList.execute("get-Profile-Folder");
    }

    private void checkAndSendPendingProfileInfos() {
        if (this.orsApplication.isLoginCancelable() && this.blockEvents) {
            this.log.log(1078071040, "%1#getProfileFolderResponse Events are blocked atm. Adding to pending event");
            this.pendingEvent = true;
            return;
        }
        this.pendingEvent = false;
        this.sendCoreProfileUpdateEvent();
    }

    private void sendCoreProfileUpdateEvent() {
        this.log.log(1078071040, "%1#sendCoreProfileUpdateEvent authentication finished: sending update (pending)", (Object)"T2AuthenticationService");
        this.sendCoreProfileUpdateEvent(this.pendingCacheInfos);
    }

    private void sendCoreProfileUpdateEvent(IOsrUserCacheInformation iOsrUserCacheInformation) {
        this.log.log(1078071040, "%1#sendCoreProfileUpdateEvent authentication finished: sending update", (Object)"T2AuthenticationService");
        Iterator iterator = this.updateProfileInfoListeners.iterator();
        while (iterator.hasNext()) {
            PortalAuthenticationService$UpdateProfileInfoListener portalAuthenticationService$UpdateProfileInfoListener = (PortalAuthenticationService$UpdateProfileInfoListener)iterator.next();
            portalAuthenticationService$UpdateProfileInfoListener.updateProfileInfo(iOsrUserCacheInformation);
        }
    }

    private void updateDeviceListeners(OSRDevice[] oSRDeviceArray) {
        Iterator iterator = this.updateProfileInfoListeners.iterator();
        while (iterator.hasNext()) {
            PortalAuthenticationService$UpdateProfileInfoListener portalAuthenticationService$UpdateProfileInfoListener = (PortalAuthenticationService$UpdateProfileInfoListener)iterator.next();
            portalAuthenticationService$UpdateProfileInfoListener.updateDeviceInfo(oSRDeviceArray);
        }
    }

    @Override
    public void logoutCurrentUser() {
        OSRCommandList oSRCommandList;
        this.updateLoginState(2);
        this.blockEvents = true;
        this.currentCommandList = oSRCommandList = this.orsApplication.createCommandList();
        this.log.log(1078071040, "%1#logoutCurrentUser creating command LogoutCommand", (Object)"T2AuthenticationService");
        oSRCommandList.setErrorCommand(new T2AuthenticationService$3(this));
        oSRCommandList.add(new LogoutCommand(this.modelManager.getCurrentUser(), new T2AuthenticationService$4(this)));
        oSRCommandList.execute("logout-current-user");
    }

    @Override
    public void logoutAllUsers() {
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        oSRCommandList.setErrorCommand(new T2AuthenticationService$5(this));
        oSRCommandList.add(new LogoutAllUsersCommand(new T2AuthenticationService$6(this)));
        oSRCommandList.execute(super.getClass().getName());
    }

    @Override
    public void loginUserWithSavedCredentials() {
        OSRUser oSRUser = this.modelManager.getCurrentUser();
        if (oSRUser == null) {
            this.log.log(-1601830656, "T2AuthenticationService#loginUserWithSavedCredentials: no user selected (null)");
            return;
        }
        this.log.log(1078071040, "T2AuthenticationService#loginUserWithSavedCredentials: try to login user %1", (Object)oSRUser.getName());
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        this.login(oSRCommandList, new T2AuthenticationService$AuthCallbackListenerHelper(this));
    }

    public void checkPasswordOrParingCode(AbstractOSRCommand abstractOSRCommand, String string, boolean bl) {
        this.log.log(1078071040, "%1#checkPasswordOrParingCode Precondition: %2, pwd: %3", (Object)"T2AuthenticationService", (Object)abstractOSRCommand, (Object)string);
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        if (abstractOSRCommand != null) {
            oSRCommandList.add(abstractOSRCommand);
        }
        this.log.log(1078071040, "%1#checkPasswordOrParingCode adding Command >l with pairingCode: %2", (Object)"T2AuthenticationService", (Object)Boolean.toString(bl));
        oSRCommandList.add(new CheckPasswordCommand(string, this.modelManager.isBackendVerficationNeccessary(), bl, new T2AuthenticationService$7(this)));
        this.login(oSRCommandList, new T2AuthenticationService$AuthCallbackListenerHelper(this));
    }

    public void storePrivacySettings(boolean bl) {
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        if (bl) {
            oSRCommandList.add(new SetPrivacyCommand(this.modelManager.getCurrentUser(), 20));
            oSRCommandList.add(new SetAutoLoginCommand(this.modelManager.getCurrentUser(), this.modelManager.getLoginDevices(), new T2AuthenticationService$8(this)));
        } else {
            oSRCommandList.add(new SetPrivacyCommand(this.modelManager.getCurrentUser(), 4 | this.modelManager.getPrivacySettings()));
        }
        oSRCommandList.execute("storePrivacySettings");
    }

    private void login(OSRCommandList oSRCommandList, PortalAuthenticationServiceCallbackListener portalAuthenticationServiceCallbackListener) {
        this.modelManager.setSyncModelsWaiting();
        oSRCommandList.setErrorCommand(new T2AuthenticationService$9(this));
        LoginCommand loginCommand = new LoginCommand(new T2AuthenticationService$10(this, portalAuthenticationServiceCallbackListener));
        this.currentCommandList = oSRCommandList;
        oSRCommandList.add(loginCommand);
        oSRCommandList.execute(super.getClass().getName());
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

    @Override
    public boolean isAuthenticated() {
        return this.modelManager.isAuthenticated();
    }

    public AuthenticationModelManager getModelManager() {
        return this.modelManager;
    }

    @Override
    public void indicateAuthenticationDialogFinsihed() {
        this.currentCommandList = null;
        this.blockEvents = false;
        this.orsApplication.restoreScreenTypeAfterAuthentication();
        if (this.pendingEvent) {
            this.log.log(1078071040, "%1#indicateAuthenticationDialogFinsihed sending pending request", (Object)"T2AuthenticationService");
            this.sendCoreProfileUpdateEvent();
        }
    }

    @Override
    public void indicateLogoutDialogFinsihed() {
        this.currentCommandList = null;
        this.blockEvents = false;
        if (this.pendingEvent) {
            this.log.log(1078071040, "%1#indicateLogoutDialogFinsihed sending pending request", (Object)"T2AuthenticationService");
            this.sendCoreProfileUpdateEvent();
        }
    }

    public void deleteFocusedUser() {
        this.log.log(1078071040, "%1#deleteFocusedUser() queue in command", (Object)"T2AuthenticationService");
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        oSRCommandList.add(new OSRDeleteUserCommand(this.modelManager.getFocusedUser(), new T2AuthenticationService$11(this)));
        oSRCommandList.execute("deleteUser");
    }

    public void cancelActiveCommand() {
        this.log.log(1078071040, "%1#cancelActiveCommand", (Object)"T2AuthenticationService");
        if (this.currentCommandList == null) {
            this.log.log(1078071040, "%1#cancelActiveCommand no active commandList", (Object)"T2AuthenticationService");
            return;
        }
        CommandList commandList = this.currentCommandList.cancelCurrentCommand();
        commandList.execute("cancel-current-command-List");
    }

    public void startPortalRegistration(String string) {
        this.modelManager.setRegistrationModelsWaiting();
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        oSRCommandList.setErrorCommand(new T2AuthenticationService$12(this));
        oSRCommandList.add(new PerformPortalRegistrationCommand(string, new T2AuthenticationService$13(this)));
        oSRCommandList.execute(super.getClass().getName());
    }

    public void validatePairingCode(String string, PortalAuthenticationServiceCallbackListener portalAuthenticationServiceCallbackListener) {
    }

    @Override
    public void requestUsersList() {
        this.log.log(1078071040, "%1requestUsersList", (Object)"T2AuthenticationService");
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        oSRCommandList.setErrorCommand(new T2AuthenticationService$14(this));
        GetUsersCommand getUsersCommand = new GetUsersCommand(new T2AuthenticationService$15(this));
        oSRCommandList.add(getUsersCommand);
        oSRCommandList.execute("T2AuthenticationService");
    }

    public void handlePairingCodeFromSpeller(String string) {
        this.updateLoginState(string.length() > 0 ? 1 : 9);
        boolean bl = this.modelManager.isCreateNewUser();
        this.log.log(1078071040, "%1#handlePairingCodeFromSpeller: pairingCode: %2 createnewUser: %3", (Object)"T2AuthenticationService", (Object)string, (Object)Boolean.toString(bl));
        CreateNewUserCommand createNewUserCommand = null;
        if (bl) {
            createNewUserCommand = new CreateNewUserCommand(string, new T2AuthenticationService$16(this));
        }
        if (string == null || string.length() < 1) {
            this.log.log(-1601830656, "%1#handlePairingCodeFromSpeller: invalid pairingcode!: %2", (Object)"T2AuthenticationService", (Object)string);
            return;
        }
        this.checkPasswordOrParingCode(createNewUserCommand, string, true);
    }

    public void validateCredentials(String string, String string2, PortalAuthenticationServiceCallbackListener portalAuthenticationServiceCallbackListener) {
        this.log.log(1078071040, "%1validateCredentials", (Object)"T2AuthenticationService");
        this.modelManager.setSyncModelsWaiting();
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        oSRCommandList.setErrorCommand(new T2AuthenticationService$17(this, portalAuthenticationServiceCallbackListener));
        ValidateCredentialsCommand validateCredentialsCommand = new ValidateCredentialsCommand(string, string2, new T2AuthenticationService$18(this, portalAuthenticationServiceCallbackListener));
        oSRCommandList.add(validateCredentialsCommand);
        oSRCommandList.execute(super.getClass().getName());
    }

    public void deleteCurrentUser() {
        OSRUser oSRUser = this.modelManager.getCurrentUser();
        this.log.log(1078071040, "%1#deleteCurrentUser user: %2", (Object)"T2AuthenticationService", (Object)oSRUser);
        if (oSRUser == null) {
            return;
        }
        OSRCommandList oSRCommandList = this.orsApplication.createCommandList();
        oSRCommandList.add(new OSRDeleteUserCommand(oSRUser, new T2AuthenticationService$19(this)));
        oSRCommandList.execute("deleteCurrentUser");
    }

    static /* synthetic */ void access$000(T2AuthenticationService t2AuthenticationService, OSRUser oSRUser, int n) {
        t2AuthenticationService.handleCreateNewUserResponse(oSRUser, n);
    }

    static /* synthetic */ IOsrUserCacheInformation access$102(T2AuthenticationService t2AuthenticationService, IOsrUserCacheInformation iOsrUserCacheInformation) {
        t2AuthenticationService.pendingCacheInfos = iOsrUserCacheInformation;
        return t2AuthenticationService.pendingCacheInfos;
    }

    static /* synthetic */ IOsrUserCacheInformation access$100(T2AuthenticationService t2AuthenticationService) {
        return t2AuthenticationService.pendingCacheInfos;
    }

    static /* synthetic */ void access$200(T2AuthenticationService t2AuthenticationService) {
        t2AuthenticationService.checkAndSendPendingProfileInfos();
    }

    static /* synthetic */ OnlineServiceRegistrationSubsystem access$300(T2AuthenticationService t2AuthenticationService) {
        return t2AuthenticationService.orsApplication;
    }

    static /* synthetic */ void access$400(T2AuthenticationService t2AuthenticationService, int n) {
        t2AuthenticationService.updateLoginState(n);
    }

    static /* synthetic */ int access$500(T2AuthenticationService t2AuthenticationService, int n) {
        return t2AuthenticationService.mapLoginResultToHMICode(n);
    }

    static /* synthetic */ int access$600(T2AuthenticationService t2AuthenticationService) {
        return t2AuthenticationService.popupDeleteUserOk;
    }

    static {
        authenticationStates = new AuthenticationStates();
        updateStates = new UpdateStates();
    }
}

