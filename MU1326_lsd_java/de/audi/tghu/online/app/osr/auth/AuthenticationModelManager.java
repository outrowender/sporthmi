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
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRUser;

public class AuthenticationModelManager
extends AbstractModelManager {
    private static final int COLUMN_CHECKBOX = 2;
    private static final int COLUMN_USER_IMAGE = 1;
    private static final int COLUMN_USER_NAME = 2;
    private static final int COLUMN_PROPERTY = 4;
    public static final int CREDENTIALS_AVAILABLE = 1;
    public static final int CREDENTIALS_NOT_AVAILABLE = 0;
    public static final int USER_TYPE_SIM = 0;
    public static final int USER_TYPE_SMARTPHONE = 1;
    private int drawerCategory = -1;
    private ArrayList userList;
    private List availableDevices = new ArrayList();
    private boolean createNewUser = true;
    private boolean backendVerificationNeccessary = false;
    private OSRUser currentUser;
    private boolean authenticated;
    private LogChannel log;
    private OSRUser focusedUser;
    private OsrUserContainer currentUsrContainer;

    public AuthenticationModelManager(HMIService hMIService, LogChannel logChannel) {
        super(hMIService);
        this.log = logChannel;
        this.userList = new ArrayList(0);
        this.hmiService.getChoiceModel(2300898).setValue(6);
        this.hmiService.getBaseListModel(2300937).setStatus(0);
    }

    public void setDrawerCategory(int n) {
        if (this.drawerCategory == n) {
            return;
        }
        this.drawerCategory = n;
        this.updateUsersListModel();
    }

    public void updateAuthStatus(int n) {
        this.log.log(1000000, "AuthenticationModelManager#updateAuthStatus dsiValue: %1", (long)n);
        int n2 = T2AuthenticationService.convertDsiToHmiStates(n);
        this.log.log(1000000, "AuthenticationModelManager#updateAuthStatus hmiValue: %1", (long)n2);
        this.hmiService.getChoiceModel(2300898).setValue(n2);
        this.hmiService.getChoiceModel(2300898).setStatus(1);
        this.authenticated = n == 0;
    }

    public void storeCacheInfosForUser(OSRUser oSRUser, IOsrUserCacheInformation iOsrUserCacheInformation) {
        OsrUserContainer osrUserContainer = this.getOsrContainer(oSRUser);
        if (osrUserContainer == null) {
            this.log.log(100000, "AuthenticationModelManager#storeCacheInfosForUser no userContainer found");
            return;
        }
        osrUserContainer.setCacheInfo(iOsrUserCacheInformation);
    }

    public OsrUserContainer getOsrContainer(OSRUser oSRUser) {
        Iterator iterator = this.userList.iterator();
        while (iterator.hasNext()) {
            OsrUserContainer osrUserContainer = (OsrUserContainer)iterator.next();
            if (!osrUserContainer.equals(new OsrUserContainer(oSRUser, "doesntMatter"))) continue;
            return osrUserContainer;
        }
        if (this.currentUsrContainer == null) {
            return null;
        }
        if (this.currentUsrContainer.equals(new OsrUserContainer(oSRUser, ""))) {
            return this.currentUsrContainer;
        }
        return null;
    }

    public void setSyncModelsWaiting() {
        this.hmiService.getChoiceModel(2300898).setStatus(0);
    }

    public void clearSpellermodel(int n) {
        this.hmiService.getSpellerModel(n).clear();
    }

    public void clearTextFieldModel(int n) {
        this.hmiService.getTextfieldModel(n).setText1("");
    }

    public void updateUsersListModel() {
        BaseListModelApp baseListModelApp = this.hmiService.getBaseListModel(2300937);
        baseListModelApp.removeAll();
        if (this.userList != null) {
            int n = this.userList.size();
            for (int i2 = 0; i2 < n; ++i2) {
                OsrUserContainer osrUserContainer = (OsrUserContainer)this.userList.get(i2);
                OSRUser oSRUser = osrUserContainer.user;
                int n2 = this.determineUserIcon(oSRUser);
                this.log.log(1000000, "AuthenticationModelManager#updateUsersListModel: current size: %1, iconId: %2", (long)baseListModelApp.getLength(), (long)n2);
                EvoListRow evoListRow = new EvoListRow(i2, 10);
                evoListRow.setText(2, oSRUser.getName());
                evoListRow.setInteger(1, n2);
                evoListRow.setPropertyCell(4, new PropertyListCell(this.drawerCategory, new int[0]));
                baseListModelApp.append(evoListRow);
            }
        }
        this.log.log(1000000, "AuthenticationModelManager#updateUsersListModel: current size: %1", (long)baseListModelApp.getLength());
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
        this.log.log(1000000, "AuthenticationModelManager#determineUserIcon: privacyFlags: %1, deviceType: %2 Username: %3", (Object)new Integer(n), (Object)new Integer(n2), (Object)oSRUser.getName());
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
        this.log.log(1000000, "AuthenticationModelManager#checkCredentialForSelectedUser: index: %1", (long)n);
        if (n >= this.userList.size()) {
            this.log.log(10000, "AuthenticationModelManager#checkCredentialForSelectedUser: index out of bounds. list length is %1", (long)this.userList.size());
            this.hmiService.getChoiceModel(2300928).setValue(0);
            return;
        }
        this.currentUser = ((OsrUserContainer)this.userList.get((int)n)).user;
        int n2 = this.currentUser.getPrivacyFlag();
        this.log.log(1000000, "AuthenticationModelManager#checkCredentialForSelectedUser: user %1 with credentials %2", (Object)this.currentUser.getName(), (long)n2);
        boolean bl = this.isCredentialsAvailable(n2);
        this.setPrivacyCheckboxes(n2);
        this.setLoginSettings(this.currentUser);
        if (bl) {
            this.hmiService.getChoiceModel(2300928).setValue(1);
        } else {
            this.getSpellerModel(2300936).setText(this.currentUser.getPortalUser());
            this.setTextFieldText(2301130, this.currentUser.getPortalUser());
            this.hmiService.getChoiceModel(2300928).setValue(0);
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
            this.hmiService.getChoiceModel(2300932).setValue(1);
            this.hmiService.getChoiceModel(2300935).setValue(0);
        } else if (bl) {
            this.hmiService.getChoiceModel(2300935).setValue(1);
            this.hmiService.getChoiceModel(2300932).setValue(0);
        } else {
            this.hmiService.getChoiceModel(2300932).setValue(0);
            this.hmiService.getChoiceModel(2300935).setValue(0);
        }
    }

    private void setLoginSettings(OSRUser oSRUser) {
        boolean bl;
        int n = oSRUser != null ? oSRUser.privacyFlag : 0;
        boolean bl2 = bl = (n & 2) == 2;
        if (bl) {
            this.hmiService.getChoiceModel(2301597).setValue(1);
            this.hmiService.getChoiceModel(2301637).setValue(0);
            this.hmiService.getChoiceModel(2301595).setValue(0);
        } else {
            this.hmiService.getChoiceModel(2301597).setValue(0);
            this.hmiService.getChoiceModel(2301637).setValue(1);
            this.hmiService.getChoiceModel(2301595).setValue(0);
        }
        if (oSRUser != null && oSRUser.getDevicesForAutologin() != null && oSRUser.getDevicesForAutologin().length != 0) {
            this.hmiService.getChoiceModel(2301597).setValue(0);
            this.hmiService.getChoiceModel(2301637).setValue(0);
            this.hmiService.getChoiceModel(2301595).setValue(1);
        }
    }

    public void clearUsersList() {
        this.userList.clear();
        this.updateUsersListModel();
    }

    public void setCreateNewUser(boolean bl) {
        this.log.log(1000000, "AuthenticationModelManager#setCreateNewUser %1", (Object)Boolean.toString(bl));
        this.createNewUser = bl;
        int n = bl ? 1 : 0;
        this.hmiService.getChoiceModel(2300978).setValue(n);
        this.hmiService.getChoiceModel(2300978).setStatus(0);
    }

    public boolean isCreateNewUser() {
        return this.createNewUser;
    }

    public void releaseCreateUserSyncModel(int n) {
        this.hmiService.getChoiceModel(2300978).setStatus(1);
    }

    public void setCreateUserModelWaiting() {
        this.hmiService.getChoiceModel(2300978).setValue(1);
        this.hmiService.getChoiceModel(2300978).setStatus(0);
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
            this.log.log(1000000, "AuthenticationModelManager#removeDevice %1 deleted from list [PId: %2]", (Object)oSRDevice.getName(), (Object)oSRDevice.getPIdentifier().getPIdentifier());
            this.availableDevices.remove(n);
            this.refreshDeviceListModel();
        }
    }

    public void updateDevice(OSRDevice oSRDevice) {
        int n = this.getDeviceIndex(oSRDevice);
        if (n != -1) {
            this.log.log(1000000, "AuthenticationModelManager#updateDevice %1: [PId: %2]", (Object)oSRDevice.getName(), (Object)oSRDevice.getPIdentifier().getPIdentifier());
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
        BaseListModelApp baseListModelApp = this.hmiService.getBaseListModel(2300929);
        baseListModelApp.removeAll();
        Iterator iterator = this.availableDevices.iterator();
        while (iterator.hasNext()) {
            OSRDevice oSRDevice = (OSRDevice)iterator.next();
            this.log.log(1000000, "AuthenticationModelManager#refreshDeviceList()device: name: %1 id: %2", (Object)oSRDevice.getName(), (Object)oSRDevice.getPIdentifier());
            EvoListRow evoListRow = new EvoListRow(oSRDevice.hashCode(), 4);
            evoListRow.setText(1, oSRDevice.getName());
            evoListRow.setInteger(2, 0);
            baseListModelApp.append(evoListRow);
        }
        this.log.log(1000000, "AuthenticationModelManager#refreshDeviceList() listlength: %1", (long)baseListModelApp.getLength());
    }

    public OSRUser getCurrentUser() {
        return this.currentUser;
    }

    public int getPrivacySettings() {
        if (this.hmiService.getChoiceModel(2300932).getValue() == 1) {
            return 3;
        }
        if (this.hmiService.getChoiceModel(2300935).getValue() == 1) {
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
        BaseListModelApp baseListModelApp = this.hmiService.getBaseListModel(2300929);
        ArrayList arrayList = new ArrayList(1);
        int n = baseListModelApp.getLength();
        for (int i2 = 0; i2 < n; ++i2) {
            EvoListRow evoListRow = baseListModelApp.getRow(i2);
            int n2 = evoListRow.getInteger(2);
            if (n2 != 1) continue;
            if (i2 >= this.availableDevices.size()) {
                throw new ArrayIndexOutOfBoundsException("base List model index " + i2 + ". availableDevices.size: " + n);
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
        this.clearLabelModel(2301120);
        this.setPrivacyCheckboxes(0);
        this.determineTitleLabels();
        this.getChoiceModel(2301612).setValue(0);
        this.log.log(10000000, "AuthenticationModelManager#initializeAuthentication(): Resetting AUTHENTICATION_CREDENTIALS_AVAILABLE_CHOICE to CREDENTIALS_NOT_AVAILABLE");
        this.hmiService.getChoiceModel(2300928).setValue(0);
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
        this.currentUsrContainer = new OsrUserContainer(oSRUser, "");
        String string = this.currentUser != null ? this.currentUser.getName() : "";
        String string2 = this.currentUser != null ? this.currentUser.getPortalUser() : "";
        this.hmiService.getLabelModel(2301084).setText(string);
        this.hmiService.getTextfieldModel(2301223).setText1(string2);
        this.hmiService.getSpellerModel(2301222).setText(string2);
        this.setLoginSettings(this.currentUser);
    }

    public void clearSpellers() {
        this.clearSpellermodel(2300931);
        this.clearSpellermodel(2300936);
        this.clearSpellermodel(2300923);
    }

    public void clearTextFieldModels() {
        this.log.log(1000000, "AuthenticationModelManager#clearTextFieldModels() called.");
        this.clearTextFieldModel(2301130);
        this.clearTextFieldModel(2301129);
    }

    public void clearLabelModel(int n) {
        this.hmiService.getLabelModel(n).setText("");
    }

    public void setRegistrationModelsWaiting() {
        this.getChoiceModel(2300980).setStatus(0);
    }

    public void setRegistrationModelsResult(int n) {
        int n2 = n == 0 ? 0 : 1;
        this.getChoiceModel(2300980).setValue(n2);
        this.getChoiceModel(2300980).setStatus(1);
    }

    public void releaseLogoutModel() {
        ChoiceModelApp choiceModelApp = this.getChoiceModel(2301013);
        choiceModelApp.setValue(choiceModelApp.getValue() ^ 1);
    }

    public boolean isAuthenticated() {
        return this.authenticated;
    }

    public void addNewUser(OSRUser oSRUser, String string) {
        OsrUserContainer osrUserContainer = new OsrUserContainer(oSRUser, string);
        if (!this.userList.contains(osrUserContainer)) {
            this.userList.add(osrUserContainer);
            this.updateUsersListModel();
            this.log.log(1000000, "AuthenticationModelManager#addNewUser user %1", (Object)oSRUser.personalIdentifier.getPIdentifier());
            return;
        }
        this.log.log(1000000, "AuthenticationModelManager#addNewUser user %1 already exists. not added", (Object)oSRUser.personalIdentifier.getPIdentifier());
    }

    public void removeUser(OSRUser oSRUser) {
        this.userList.remove(new OsrUserContainer(oSRUser, "doesntMatter"));
        this.updateUsersListModel();
    }

    public ArrayList getUsers() {
        return this.userList;
    }

    public void setFocusedUser(int n) {
        this.log.log(1000000, "AuthenticationModelManager#setFocusedUser: index: %1", (long)n);
        if (n >= this.userList.size()) {
            this.log.log(10000, "AuthenticationModelManager#setFocusedUser: index out of bounds. list length is %1", (long)this.userList.size());
            return;
        }
        OsrUserContainer osrUserContainer = (OsrUserContainer)this.userList.get(n);
        this.focusedUser = osrUserContainer.user;
        int n2 = this.focusedUser.devicesForAutologin == null || this.focusedUser.devicesForAutologin.length == 0 ? 0 : 1;
        this.hmiService.getLabelModel(2301084).setText(this.focusedUser.getName());
        this.hmiService.getChoiceModel(2301087).setValue(n2);
        this.log.log(1000000, "AuthenticationModelManager#setFocusedUser: focused user is: %1", (Object)this.focusedUser.getName());
    }

    public OSRUser getFocusedUser() {
        return this.focusedUser;
    }

    public void showPopup(int n) {
        this.hmiService.removePopup(this.hmiService.getCurrentPopup());
        this.hmiService.showPopup(n);
    }

    public int getDeletionMode() {
        return this.hmiService.getChoiceModel(2301087).getValue();
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
        this.log.log(1000000, "AuthenticationModelManager#setCoreServicesReady");
        this.determineTitleLabels();
        this.hmiService.getBaseListModel(2300937).setStatus(1);
    }

    public void replaceUser(OSRUser oSRUser) {
        int n = 0;
        Iterator iterator = this.userList.iterator();
        while (iterator.hasNext()) {
            OsrUserContainer osrUserContainer = (OsrUserContainer)iterator.next();
            OsrUserContainer osrUserContainer2 = new OsrUserContainer(oSRUser, "doesntMatter");
            if (osrUserContainer.equals(new OsrUserContainer(oSRUser, "doesntMatter"))) {
                this.userList.set(n, osrUserContainer2);
            }
            ++n;
        }
        this.updateUsersListModel();
    }

    public void setEmptyUcl() {
        this.getChoiceModel(2301208).setValue(0);
        this.getChoiceModel(2301209).setValue(0);
    }

    public void setUserSelectedFromUcl() {
        this.getChoiceModel(2301208).setValue(1);
        this.getChoiceModel(2301209).setValue(1);
    }

    public void setOtherUser() {
        this.getChoiceModel(2301208).setValue(2);
        this.getChoiceModel(2301209).setValue(2);
    }

    public static class TitleHelper {
        public static final int BC_OPTIONEN = 0;
        public static final int BC_LOGIN = 1;
        public static final int BC_LIST = 2;
        public static final int TITLE_LOGIN = 0;
        public static final int TITLE_USERDATA = 1;
        public static final int TITLE_OTHER = 2;
    }

    public class OsrUserContainer {
        OSRUser user;
        String source;
        IOsrUserCacheInformation cacheInfo;

        public OsrUserContainer(OSRUser oSRUser, String string) {
            this.user = oSRUser;
            this.source = string;
        }

        public void setCacheInfo(IOsrUserCacheInformation iOsrUserCacheInformation) {
            this.cacheInfo = iOsrUserCacheInformation;
        }

        public IOsrUserCacheInformation getCacheInfo() {
            return this.cacheInfo;
        }

        public boolean equals(Object object) {
            OsrUserContainer osrUserContainer = (OsrUserContainer)object;
            if (osrUserContainer == null) {
                return false;
            }
            if (this.user == null && osrUserContainer.user == null) {
                return true;
            }
            if (this.user == null || osrUserContainer.user == null) {
                return false;
            }
            return this.user.portalUser.equals(osrUserContainer.user.portalUser) && this.user.authIdentifier.equals(osrUserContainer.user.authIdentifier);
        }

        public int hashCode() {
            return 0;
        }
    }
}

