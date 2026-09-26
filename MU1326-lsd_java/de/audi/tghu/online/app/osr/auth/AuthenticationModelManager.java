/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.IOsrUserCacheInformation;
import de.audi.tghu.online.app.osr.auth.AbstractModelManager;
import de.audi.tghu.online.app.osr.auth.AuthenticationModelManager$OsrUserContainer;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRUser;

public class AuthenticationModelManager
extends AbstractModelManager {
    private static final int COLUMN_CHECKBOX;
    private static final int COLUMN_USER_IMAGE;
    private static final int COLUMN_USER_NAME;
    private static final int COLUMN_PROPERTY;
    public static final int CREDENTIALS_AVAILABLE;
    public static final int CREDENTIALS_NOT_AVAILABLE;
    public static final int USER_TYPE_SIM;
    public static final int USER_TYPE_SMARTPHONE;
    private int drawerCategory = -1;
    private ArrayList userList;
    private List availableDevices = new ArrayList();
    private boolean createNewUser = true;
    private boolean backendVerificationNeccessary = false;
    private OSRUser currentUser;
    private boolean authenticated;
    private LogChannel log;
    private OSRUser focusedUser;
    private AuthenticationModelManager$OsrUserContainer currentUsrContainer;

    public AuthenticationModelManager(HMIService hMIService, LogChannel logChannel) {
        super(hMIService);
        this.log = logChannel;
        this.userList = new ArrayList(0);
        this.hmiService.getChoiceModel(-501538048).setValue(6);
        this.hmiService.getBaseListModel(152838912).setStatus(0);
    }

    public void setDrawerCategory(int n) {
        if (this.drawerCategory == n) {
            return;
        }
        this.drawerCategory = n;
        this.updateUsersListModel();
    }

    public void updateAuthStatus(int n) {
        this.log.log(1078071040, "AuthenticationModelManager#updateAuthStatus dsiValue: %1", (long)n);
        int n2 = T2AuthenticationService.convertDsiToHmiStates(n);
        this.log.log(1078071040, "AuthenticationModelManager#updateAuthStatus hmiValue: %1", (long)n2);
        this.hmiService.getChoiceModel(-501538048).setValue(n2);
        this.hmiService.getChoiceModel(-501538048).setStatus(1);
        this.authenticated = n == 0;
    }

    public void storeCacheInfosForUser(OSRUser oSRUser, IOsrUserCacheInformation iOsrUserCacheInformation) {
        AuthenticationModelManager$OsrUserContainer authenticationModelManager$OsrUserContainer = this.getOsrContainer(oSRUser);
        if (authenticationModelManager$OsrUserContainer == null) {
            this.log.log(-1601830656, "AuthenticationModelManager#storeCacheInfosForUser no userContainer found");
            return;
        }
        authenticationModelManager$OsrUserContainer.setCacheInfo(iOsrUserCacheInformation);
    }

    public AuthenticationModelManager$OsrUserContainer getOsrContainer(OSRUser oSRUser) {
        Iterator iterator = this.userList.iterator();
        while (iterator.hasNext()) {
            AuthenticationModelManager$OsrUserContainer authenticationModelManager$OsrUserContainer = (AuthenticationModelManager$OsrUserContainer)iterator.next();
            if (!authenticationModelManager$OsrUserContainer.equals(new AuthenticationModelManager$OsrUserContainer(this, oSRUser, "doesntMatter"))) continue;
            return authenticationModelManager$OsrUserContainer;
        }
        if (this.currentUsrContainer == null) {
            return null;
        }
        if (this.currentUsrContainer.equals(new AuthenticationModelManager$OsrUserContainer(this, oSRUser, ""))) {
            return this.currentUsrContainer;
        }
        return null;
    }

    public void setSyncModelsWaiting() {
        this.hmiService.getChoiceModel(-501538048).setStatus(0);
    }

    public void clearSpellermodel(int n) {
        this.hmiService.getSpellerModel(n).clear();
    }

    public void clearTextFieldModel(int n) {
        this.hmiService.getTextfieldModel(n).setText1("");
    }

    public void updateUsersListModel() {
        BaseListModelApp baseListModelApp = this.hmiService.getBaseListModel(152838912);
        baseListModelApp.removeAll();
        if (this.userList != null) {
            int n = this.userList.size();
            for (int i2 = 0; i2 < n; ++i2) {
                AuthenticationModelManager$OsrUserContainer authenticationModelManager$OsrUserContainer = (AuthenticationModelManager$OsrUserContainer)this.userList.get(i2);
                OSRUser oSRUser = authenticationModelManager$OsrUserContainer.user;
                int n2 = this.determineUserIcon(oSRUser);
                this.log.log(1078071040, "AuthenticationModelManager#updateUsersListModel: current size: %1, iconId: %2", (long)baseListModelApp.getLength(), (long)n2);
                EvoListRow evoListRow = new EvoListRow(i2, 10);
                evoListRow.setText(2, oSRUser.getName());
                evoListRow.setInteger(1, n2);
                evoListRow.setPropertyCell(4, new PropertyListCell(this.drawerCategory, new int[0]));
                baseListModelApp.append(evoListRow);
            }
        }
        this.log.log(1078071040, "AuthenticationModelManager#updateUsersListModel: current size: %1", (long)baseListModelApp.getLength());
    }

    private int determineUserIcon(OSRUser oSRUser) {
        boolean bl;
        int n = oSRUser.getPrivacyFlag();
        int n2 = -1;
        OSRDevice[] oSRDeviceArray = oSRUser.getDevicesForAutologin();
        if (oSRDeviceArray != null && oSRDeviceArray.length > 0) {
            OSRDevice oSRDevice = oSRDeviceArray[0];
            n2 = oSRDevice.getPIdentifier().pType;
        }
        this.log.log(1078071040, "AuthenticationModelManager#determineUserIcon: privacyFlags: %1, deviceType: %2 Username: %3", (Object)new Integer(n), (Object)new Integer(n2), (Object)oSRUser.getName());
        boolean bl2 = (n & 8) == 8;
        boolean bl3 = bl = (n & 0x10) == 16;
        if (bl2) {
            return 1;
        }
        if (bl) {
            if (n2 == 1) {
                return 2;
            }
            return 3;
        }
        return 0;
    }

    public void checkCredentialsForSelectedUser(int n) {
        this.log.log(1078071040, "AuthenticationModelManager#checkCredentialForSelectedUser: index: %1", (long)n);
        if (n >= this.userList.size()) {
            this.log.log(10000, "AuthenticationModelManager#checkCredentialForSelectedUser: index out of bounds. list length is %1", (long)this.userList.size());
            this.hmiService.getChoiceModel(1843968).setValue(0);
            return;
        }
        this.currentUser = ((AuthenticationModelManager$OsrUserContainer)this.userList.get((int)n)).user;
        int n2 = this.currentUser.getPrivacyFlag();
        this.log.log(1078071040, "AuthenticationModelManager#checkCredentialForSelectedUser: user %1 with credentials %2", (Object)this.currentUser.getName(), (long)n2);
        boolean bl = this.isCredentialsAvailable(n2);
        this.setPrivacyCheckboxes(n2);
        this.setLoginSettings(this.currentUser);
        if (bl) {
            this.hmiService.getChoiceModel(1843968).setValue(1);
        } else {
            this.getSpellerModel(136061696).setText(this.currentUser.getPortalUser());
            this.setTextFieldText(-904125696, this.currentUser.getPortalUser());
            this.hmiService.getChoiceModel(1843968).setValue(0);
        }
        this.setCreateNewUser(false);
        this.setUserSelectedFromUcl();
    }

    private boolean isCredentialsAvailable(int n) {
        boolean bl = (n & 2) == 2;
        boolean bl2 = (n & 0x10) == 16;
        boolean bl3 = (n & 8) == 8;
        return bl || bl2 || bl3;
    }

    private void setPrivacyCheckboxes(int n) {
        boolean bl;
        boolean bl2 = (n & 2) == 2;
        boolean bl3 = bl = (n & 1) == 1;
        if (bl2) {
            this.hmiService.getChoiceModel(68952832).setValue(1);
            this.hmiService.getChoiceModel(119284480).setValue(0);
        } else if (bl) {
            this.hmiService.getChoiceModel(119284480).setValue(1);
            this.hmiService.getChoiceModel(68952832).setValue(0);
        } else {
            this.hmiService.getChoiceModel(68952832).setValue(0);
            this.hmiService.getChoiceModel(119284480).setValue(0);
        }
    }

    private void setLoginSettings(OSRUser oSRUser) {
        boolean bl;
        int n = oSRUser != null ? oSRUser.privacyFlag : 0;
        boolean bl2 = bl = (n & 2) == 2;
        if (bl) {
            this.hmiService.getChoiceModel(-1658969344).setValue(1);
            this.hmiService.getChoiceModel(-987880704).setValue(0);
            this.hmiService.getChoiceModel(-1692523776).setValue(0);
        } else {
            this.hmiService.getChoiceModel(-1658969344).setValue(0);
            this.hmiService.getChoiceModel(-987880704).setValue(1);
            this.hmiService.getChoiceModel(-1692523776).setValue(0);
        }
        if (oSRUser != null && oSRUser.getDevicesForAutologin() != null && oSRUser.getDevicesForAutologin().length != 0) {
            this.hmiService.getChoiceModel(-1658969344).setValue(0);
            this.hmiService.getChoiceModel(-987880704).setValue(0);
            this.hmiService.getChoiceModel(-1692523776).setValue(1);
        }
    }

    public void clearUsersList() {
        this.userList.clear();
        this.updateUsersListModel();
    }

    public void setCreateNewUser(boolean bl) {
        this.log.log(1078071040, "AuthenticationModelManager#setCreateNewUser %1", (Object)Boolean.toString(bl));
        this.createNewUser = bl;
        int n = bl ? 1 : 0;
        this.hmiService.getChoiceModel(840704768).setValue(n);
        this.hmiService.getChoiceModel(840704768).setStatus(0);
    }

    public boolean isCreateNewUser() {
        return this.createNewUser;
    }

    public void releaseCreateUserSyncModel(int n) {
        this.hmiService.getChoiceModel(840704768).setStatus(1);
    }

    public void setCreateUserModelWaiting() {
        this.hmiService.getChoiceModel(840704768).setValue(1);
        this.hmiService.getChoiceModel(840704768).setStatus(0);
    }

    public void addDevice(OSRDevice oSRDevice) {
        int n;
        if (this.availableDevices == null) {
            this.availableDevices = new ArrayList(1);
        }
        if ((n = this.getDeviceIndex(oSRDevice)) < 0) {
            this.availableDevices.add(oSRDevice);
        } else {
            this.updateDevice(oSRDevice);
        }
        this.refreshDeviceListModel();
    }

    public void removeDevice(OSRDevice oSRDevice) {
        int n = this.getDeviceIndex(oSRDevice);
        if (n != -1) {
            this.log.log(1078071040, "AuthenticationModelManager#removeDevice %1 deleted from list [PId: %2]", (Object)oSRDevice.getName(), (Object)oSRDevice.getPIdentifier().getPIdentifier());
            this.availableDevices.remove(n);
            this.refreshDeviceListModel();
        }
    }

    public void updateDevice(OSRDevice oSRDevice) {
        int n = this.getDeviceIndex(oSRDevice);
        if (n != -1) {
            this.log.log(1078071040, "AuthenticationModelManager#updateDevice %1: [PId: %2]", (Object)oSRDevice.getName(), (Object)oSRDevice.getPIdentifier().getPIdentifier());
            this.availableDevices.set(n, oSRDevice);
            this.refreshDeviceListModel();
        }
    }

    private int getDeviceIndex(OSRDevice oSRDevice) {
        if (this.availableDevices == null || oSRDevice == null) {
            return -1;
        }
        int n = 0;
        Iterator iterator = this.availableDevices.iterator();
        while (iterator.hasNext()) {
            OSRDevice oSRDevice2 = (OSRDevice)iterator.next();
            if (oSRDevice2.getPIdentifier().getPIdentifier().equals(oSRDevice.getPIdentifier().getPIdentifier())) {
                return n;
            }
            ++n;
        }
        return -1;
    }

    private void refreshDeviceListModel() {
        if (this.availableDevices == null) {
            return;
        }
        BaseListModelApp baseListModelApp = this.hmiService.getBaseListModel(18621184);
        baseListModelApp.removeAll();
        Iterator iterator = this.availableDevices.iterator();
        while (iterator.hasNext()) {
            OSRDevice oSRDevice = (OSRDevice)iterator.next();
            this.log.log(1078071040, "AuthenticationModelManager#refreshDeviceList()device: name: %1 id: %2", (Object)oSRDevice.getName(), (Object)oSRDevice.getPIdentifier());
            EvoListRow evoListRow = new EvoListRow(oSRDevice.hashCode(), 4);
            evoListRow.setText(1, oSRDevice.getName());
            evoListRow.setInteger(2, 0);
            baseListModelApp.append(evoListRow);
        }
        this.log.log(1078071040, "AuthenticationModelManager#refreshDeviceList() listlength: %1", (long)baseListModelApp.getLength());
    }

    public OSRUser getCurrentUser() {
        return this.currentUser;
    }

    public int getPrivacySettings() {
        if (this.hmiService.getChoiceModel(68952832).getValue() == 1) {
            return 3;
        }
        if (this.hmiService.getChoiceModel(119284480).getValue() == 1) {
            return 1;
        }
        return 0;
    }

    public void setBackendVerificationNeccessary(boolean bl) {
        this.backendVerificationNeccessary = bl;
    }

    public boolean isBackendVerficationNeccessary() {
        return this.backendVerificationNeccessary;
    }

    public OSRDevice[] getLoginDevices() {
        BaseListModelApp baseListModelApp = this.hmiService.getBaseListModel(18621184);
        ArrayList arrayList = new ArrayList(1);
        int n = baseListModelApp.getLength();
        for (int i2 = 0; i2 < n; ++i2) {
            EvoListRow evoListRow = baseListModelApp.getRow(i2);
            int n2 = evoListRow.getInteger(2);
            if (n2 != 1) continue;
            if (i2 >= this.availableDevices.size()) {
                throw new ArrayIndexOutOfBoundsException(new StringBuffer().append("base List model index ").append(i2).append(". availableDevices.size: ").append(n).toString());
            }
            arrayList.add(this.availableDevices.get(i2));
        }
        return (OSRDevice[])arrayList.toArray(new OSRDevice[arrayList.size()]);
    }

    public OSRDevice[] getAvailableDevices() {
        return (OSRDevice[])this.availableDevices.toArray(new OSRDevice[this.availableDevices.size()]);
    }

    public void initializeAuthentication() {
        this.setCreateNewUser(true);
        this.clearSpellers();
        this.clearTextFieldModels();
        this.clearLabelModel(-1071897856);
        this.setPrivacyCheckboxes(0);
        this.determineTitleLabels();
        this.getChoiceModel(-1407311104).setValue(0);
        this.log.log(-2137614336, "AuthenticationModelManager#initializeAuthentication(): Resetting AUTHENTICATION_CREDENTIALS_AVAILABLE_CHOICE to CREDENTIALS_NOT_AVAILABLE");
        this.hmiService.getChoiceModel(1843968).setValue(0);
    }

    private void determineTitleLabels() {
        if (this.userList.isEmpty()) {
            this.setEmptyUcl();
        } else {
            this.setOtherUser();
        }
    }

    public void setCurrentUser(OSRUser oSRUser) {
        this.currentUser = oSRUser;
        this.currentUsrContainer = new AuthenticationModelManager$OsrUserContainer(this, oSRUser, "");
        String string = this.currentUser != null ? this.currentUser.getName() : "";
        String string2 = this.currentUser != null ? this.currentUser.getPortalUser() : "";
        this.hmiService.getLabelModel(-1675877632).setText(string);
        this.hmiService.getTextfieldModel(656220928).setText1(string2);
        this.hmiService.getSpellerModel(639443712).setText(string2);
        this.setLoginSettings(this.currentUser);
    }

    public void clearSpellers() {
        this.clearSpellermodel(52175616);
        this.clearSpellermodel(136061696);
        this.clearSpellermodel(-82107648);
    }

    public void clearTextFieldModels() {
        this.log.log(1078071040, "AuthenticationModelManager#clearTextFieldModels() called.");
        this.clearTextFieldModel(-904125696);
        this.clearTextFieldModel(-920902912);
    }

    public void clearLabelModel(int n) {
        this.hmiService.getLabelModel(n).setText("");
    }

    public void setRegistrationModelsWaiting() {
        this.getChoiceModel(874259200).setStatus(0);
    }

    public void setRegistrationModelsResult(int n) {
        int n2 = n == 0 ? 0 : 1;
        this.getChoiceModel(874259200).setValue(n2);
        this.getChoiceModel(874259200).setStatus(1);
    }

    public void releaseLogoutModel() {
        ChoiceModelApp choiceModelApp = this.getChoiceModel(1427907328);
        choiceModelApp.setValue(choiceModelApp.getValue() ^ 1);
    }

    public boolean isAuthenticated() {
        return this.authenticated;
    }

    public void addNewUser(OSRUser oSRUser, String string) {
        AuthenticationModelManager$OsrUserContainer authenticationModelManager$OsrUserContainer = new AuthenticationModelManager$OsrUserContainer(this, oSRUser, string);
        if (!this.userList.contains(authenticationModelManager$OsrUserContainer)) {
            this.userList.add(authenticationModelManager$OsrUserContainer);
            this.updateUsersListModel();
            this.log.log(1078071040, "AuthenticationModelManager#addNewUser user %1", (Object)oSRUser.personalIdentifier.getPIdentifier());
            return;
        }
        this.log.log(1078071040, "AuthenticationModelManager#addNewUser user %1 already exists. not added", (Object)oSRUser.personalIdentifier.getPIdentifier());
    }

    public void removeUser(OSRUser oSRUser) {
        this.userList.remove(new AuthenticationModelManager$OsrUserContainer(this, oSRUser, "doesntMatter"));
        this.updateUsersListModel();
    }

    public ArrayList getUsers() {
        return this.userList;
    }

    public void setFocusedUser(int n) {
        this.log.log(1078071040, "AuthenticationModelManager#setFocusedUser: index: %1", (long)n);
        if (n >= this.userList.size()) {
            this.log.log(10000, "AuthenticationModelManager#setFocusedUser: index out of bounds. list length is %1", (long)this.userList.size());
            return;
        }
        AuthenticationModelManager$OsrUserContainer authenticationModelManager$OsrUserContainer = (AuthenticationModelManager$OsrUserContainer)this.userList.get(n);
        this.focusedUser = authenticationModelManager$OsrUserContainer.user;
        int n2 = this.focusedUser.devicesForAutologin == null || this.focusedUser.devicesForAutologin.length == 0 ? 0 : 1;
        this.hmiService.getLabelModel(-1675877632).setText(this.focusedUser.getName());
        this.hmiService.getChoiceModel(-1625545984).setValue(n2);
        this.log.log(1078071040, "AuthenticationModelManager#setFocusedUser: focused user is: %1", (Object)this.focusedUser.getName());
    }

    public OSRUser getFocusedUser() {
        return this.focusedUser;
    }

    public void showPopup(int n) {
        this.hmiService.removePopup(this.hmiService.getCurrentPopup());
        this.hmiService.showPopup(n);
    }

    public int getDeletionMode() {
        return this.hmiService.getChoiceModel(-1625545984).getValue();
    }

    public OSRDevice[] getActiveDevicesForUser(OSRUser oSRUser) {
        ArrayList arrayList = new ArrayList(1);
        OSRDevice[] oSRDeviceArray = oSRUser.getDevicesForAutologin();
        for (int i2 = 0; i2 < oSRDeviceArray.length; ++i2) {
            OSRDevice oSRDevice = oSRDeviceArray[i2];
            if (!this.availableDevices.contains(oSRDevice)) continue;
            arrayList.add(oSRDevice);
        }
        return (OSRDevice[])arrayList.toArray(new OSRDevice[this.availableDevices.size()]);
    }

    public void setCoreServicesReady() {
        this.log.log(1078071040, "AuthenticationModelManager#setCoreServicesReady");
        this.determineTitleLabels();
        this.hmiService.getBaseListModel(152838912).setStatus(1);
    }

    public void replaceUser(OSRUser oSRUser) {
        int n = 0;
        Iterator iterator = this.userList.iterator();
        while (iterator.hasNext()) {
            AuthenticationModelManager$OsrUserContainer authenticationModelManager$OsrUserContainer = (AuthenticationModelManager$OsrUserContainer)iterator.next();
            AuthenticationModelManager$OsrUserContainer authenticationModelManager$OsrUserContainer2 = new AuthenticationModelManager$OsrUserContainer(this, oSRUser, "doesntMatter");
            if (authenticationModelManager$OsrUserContainer.equals(new AuthenticationModelManager$OsrUserContainer(this, oSRUser, "doesntMatter"))) {
                this.userList.set(n, authenticationModelManager$OsrUserContainer2);
            }
            ++n;
        }
        this.updateUsersListModel();
    }

    public void setEmptyUcl() {
        this.getChoiceModel(404562688).setValue(0);
        this.getChoiceModel(421339904).setValue(0);
    }

    public void setUserSelectedFromUcl() {
        this.getChoiceModel(404562688).setValue(1);
        this.getChoiceModel(421339904).setValue(1);
    }

    public void setOtherUser() {
        this.getChoiceModel(404562688).setValue(2);
        this.getChoiceModel(421339904).setValue(2);
    }
}

