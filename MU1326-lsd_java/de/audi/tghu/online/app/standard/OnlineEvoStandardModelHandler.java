/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.standard;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.bap.eni.data.Service;
import de.audi.atip.interapp.bap.eni.data.User;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.IOnlineLanguageChangeListener;
import de.audi.tghu.online.app.osr.auth.AbstractModelManager;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.sds.HMISpeechASRListener;
import de.audi.tghu.online.app.standard.OnlineI18NHandler;

public class OnlineEvoStandardModelHandler
extends AbstractModelManager
implements IOnlineLanguageChangeListener {
    private LogChannel log;
    private Service[] serviceList;
    private int currentServiceModelValue;
    private Service currentService;
    private int listState = 0;
    private EvoListRow[] secondaryUsersList;
    private EvoListRow basicListRowCollapsed;
    private EvoListRow basicListRowExpanded;
    private User[] availableUsers = new User[0];
    public static final int SERVICE_CAR_FINDER;
    public static final int SERVICE_HEATER;
    public static final int SERVICE_UNKNOWN;
    public static final int SERVICE_ALERT;
    public static final int SERVICE_USERMGMT;
    public static final int SERVICE_MOBILE_KEY;
    private static final int COLLAPSED;
    private static final int MINIMUM_CAR_CODE_LENGTH;
    private OnlineI18NHandler i18nHandler;
    private RemoteHMIService remoteHmiService;
    static final int TRAVEL_INFO_BADGE;
    static final int CAR_FINDER_BADGE;
    static final int ALERT_SERVICES_BADGE;
    static final int CAR_REMOTE_BADGE;
    static final int BADGE_ICON;
    static final int TEXT;
    static final int SERVICE_ID;
    static final int COLUMN_COUNT;
    static final String CAR_FINDER;
    static final String REMOTE_HEATING;
    static final String VALET_ALERT;
    static final String SPEED_ALERT;
    static final String GEO_FENCE;
    static final String MOBILE_KEY;

    public static boolean isAlertService(String string) {
        return string.equals("geofence_v1") || string.equals("speedalert_v1") || string.equals("valetalert_v1");
    }

    protected IFrameworkAccess getFrameworkAccess() {
        return this.remoteHmiService.getFrameworkAccess();
    }

    public OnlineEvoStandardModelHandler(HMIService hMIService, LogChannel logChannel, OnlineI18NHandler onlineI18NHandler) {
        super(hMIService);
        this.log = logChannel;
        this.i18nHandler = onlineI18NHandler;
    }

    public void init() {
        this.updateUserList(new User[0]);
        this.initModels();
    }

    private void initModels() {
        this.hmiService.getBaseListModel(488448768).setStatus(0);
        this.hmiService.getSpellerModel(605889280).setMinLength(10);
    }

    public Service[] getServiceList() {
        return this.serviceList;
    }

    public void updateServiceList(Service[] serviceArray) {
        int n;
        this.serviceList = serviceArray;
        this.log.log(1078071040, "OnlineEvoStandardModelHandler#updateServiceList and CurrentService: %1", (Object)this.currentService);
        BaseListModelApp baseListModelApp = this.hmiService.getBaseListModel(169681664);
        baseListModelApp.removeAll();
        boolean bl = false;
        int n2 = serviceArray.length;
        for (n = 0; n < n2; ++n) {
            this.log.log(1078071040, "OnlineEvoStandardModelHandler#updateServiceList processing Service %1", (Object)serviceArray[n]);
            boolean bl2 = this.createListModelRow(serviceArray[n], baseListModelApp, bl);
            if (bl2) {
                bl = true;
            }
            if (this.currentService == null || !serviceArray[n].getId().equals(this.currentService.getId())) continue;
            boolean bl3 = serviceArray[n].isEnabledByUser();
            this.log.log(-2137614336, "OnlineEvoStandardModelHandler#updateServiceList setting CheckBox according to AppByUser-State %1", bl3);
            this.getChoiceModel(236790528).setValue(bl3 ? 1 : 0);
        }
        n = "UNKNOWN".hashCode();
        baseListModelApp.append(new EvoListRow(n, 4).setInteger(1, 0).setText(2, this.i18nHandler.getText("TEXT_CONST_RHMI_DISTR_USER_MANAGEMENT")).setText(3, "userSettings_service"));
    }

    private boolean createListModelRow(Service service, BaseListModelApp baseListModelApp, boolean bl) {
        String string = service == null ? "" : service.getId();
        boolean bl2 = OnlineEvoStandardModelHandler.isAlertService(string);
        if (bl2 && bl) {
            this.log.log(-2137614336, "OnlineEvoStandardModelHandler#createListModelRow skipping alert service ='%1' for service='%2'", (Object)string, (Object)service);
            return false;
        }
        EvoListRow evoListRow = new EvoListRow(service.hashCode(), 4);
        if (string.equals("carfinder_v1")) {
            evoListRow.setInteger(1, 1);
            evoListRow.setText(2, this.i18nHandler.getText("TEXT_CONST_RHMI_DISTR_CAR_FINDER_MAIN"));
            evoListRow.setText(3, string);
            this.getChoiceModel(236790528).setValue(service.isEnabledByUser() ? 1 : 0);
            baseListModelApp.append(evoListRow);
        } else if (string.equals("rheating_v1")) {
            evoListRow.setInteger(1, 0);
            evoListRow.setText(2, this.i18nHandler.getText("TEXT_CONST_RHMI_DISTR_REMOTE_HEATING_MAIN"));
            evoListRow.setText(3, string);
            baseListModelApp.append(evoListRow);
        } else if (bl2) {
            evoListRow.setInteger(1, 2);
            evoListRow.setText(2, this.i18nHandler.getText("TEXT_CONST_RHMI_DISTR_ALERT_SERVICES_MAIN"));
            evoListRow.setText(3, "alert_service");
            baseListModelApp.append(evoListRow);
        } else {
            this.log.log(-1601830656, "OnlineEvoStandardModelHandler#createListModelRow unhandled serviceId='%1' for service='%2'", (Object)string, (Object)service);
        }
        return bl2;
    }

    public void selectService(int n) {
        BaseListModelApp baseListModelApp = this.hmiService.getBaseListModel(169681664);
        if (baseListModelApp == null) {
            this.log.log(10000, "OnlineEvoStandardModelHandler#selectService serviceList is null!");
            return;
        }
        if (n < 0 || n >= baseListModelApp.getLength()) {
            this.log.log(10000, "OnlineEvoStandardModelHandler#selectService index out of range: %1", (long)n);
            return;
        }
        EvoListRow evoListRow = baseListModelApp.getRow(n);
        this.log.log(-2137614336, "OnlineEvoStandardModelHandler#selectService index row: %1, Text: %2", (Object)evoListRow, (Object)evoListRow.getText(3));
        this.handleSelectedServcieStd(baseListModelApp.getRow(n).getText(3));
    }

    private void handleMobileKeyNoList() {
        int n;
        this.currentService = null;
        this.log.log(1078071040, "OnlineEvoStandardModelHandler#handleMobileKeyNoList");
        this.currentServiceModelValue = n = this.mapServiceNameToModelStatus("mobilekey_sales_v1");
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(203236096);
        this.log.log(1078071040, "OnlineEvoStandardModelHandler#handleMobileKeyNoList modelStatus %1", (long)n);
        choiceModelApp.setValue(n);
        ChoiceModelApp choiceModelApp2 = this.hmiService.getChoiceModel(672998144);
        if (choiceModelApp2 != null) {
            choiceModelApp2.setValue(choiceModelApp2.getValue() ^ 1);
        } else {
            this.log.log(10000, "OnlineEvoStandardModelHandler#handleMobileKeyNoList model REMOTE_HMI_SELECTED_SERVICE_CHANGED_CHOICE is null!");
        }
    }

    private void handleSelectedServcieStd(String string) {
        int n;
        if (string != "alert_service" || string != "userSettings_service") {
            this.currentService = this.getServiceById(string);
        }
        this.currentServiceModelValue = n = this.mapServiceNameToModelStatus(string);
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(203236096);
        this.log.log(1078071040, "OnlineEvoStandardModelHandler#handleSelectedService Service %1 with modelStatus %2", (Object)string, (long)n);
        choiceModelApp.setValue(n);
        ChoiceModelApp choiceModelApp2 = this.hmiService.getChoiceModel(672998144);
        choiceModelApp2.setValue(choiceModelApp2.getValue() ^ 1);
    }

    private void handleSelectedService(Service service) {
        int n;
        this.currentService = service;
        this.log.log(1078071040, "OnlineEvoStandardModelHandler#handleSelectedService Service %1", (Object)service);
        this.hmiService.getChoiceModel(236790528).setValue(service.isEnabledByUser() ? 1 : 0);
        this.currentServiceModelValue = n = this.mapServiceNameToModelStatus(service.getId());
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(203236096);
        this.log.log(1078071040, "OnlineEvoStandardModelHandler#handleSelectedService Service %1 with modelStatus %2", (Object)service.getId(), (long)n);
        choiceModelApp.setValue(n);
        int n2 = -1;
        switch (choiceModelApp.getValue()) {
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                this.log.log(1078071040, "OnlineEvoStandardModelHandler#handleSelectedService Service %1 is GreyService.", (long)choiceModelApp.getValue());
                n2 = 2294;
                break;
            }
            default: {
                this.log.log(1078071040, "OnlineEvoStandardModelHandler#handleSelectedService Service %1 is not GreyService.", (long)choiceModelApp.getValue());
            }
        }
        ChoiceModelApp choiceModelApp2 = this.hmiService.getChoiceModel(672998144);
        if (choiceModelApp2 != null) {
            choiceModelApp2.setValue(choiceModelApp2.getValue() ^ 1);
        } else {
            this.log.log(10000, "OnlineEvoStandardModelHandler#handleSelectedService model REMOTE_HMI_SELECTED_SERVICE_CHANGED_CHOICE is null!");
        }
        if (n2 != -1) {
            if (this.remoteHmiService != null) {
                HMISpeechASRListener hMISpeechASRListener = this.remoteHmiService.getASR();
                if (hMISpeechASRListener != null) {
                    hMISpeechASRListener.setDistributedServiceMoveType(n2);
                } else {
                    this.log.log(-1601830656, "OnlineEvoStandardModelHandler#handleSelectedService speechListener is null!");
                }
            } else {
                this.log.log(10000, "OnlineEvoStandardModelHandler#handleSelectedService remoteHmiService is null!");
            }
            this.triggerSMSpeechEvent(choiceModelApp.getValue(), n2);
        }
    }

    private void triggerSMSpeechEvent(int n, int n2) {
        if (n2 != -1) {
            this.log.log(1078071040, "OnlineEvoStandardModelHandler#triggerSMSpeechEvent - GreyServices: hmiState is %1, firing event %2", (long)n, (long)n2);
            this.getFrameworkAccess().getHMIService().fireSMEvent(6, n2);
        } else {
            this.log.log(10000, "OnlineEvoStandardModelHandler#triggerSMSpeechEvent - GreyServices: invalid parameter");
        }
    }

    public boolean handleSelectedService(String string) {
        Service service = this.getServiceById(string);
        if (service == null) {
            if ("mobilekey_sales_v1".equals(string)) {
                this.log.log(1078071040, "OnlineEvoStandardModelHandler#handleSelectedService Special handling for mobile key without service list.");
                this.handleMobileKeyNoList();
            } else {
                this.log.log(-1601830656, "OnlineEvoStandardModelHandler#handleSelectedService Service with  ID %1 does not exist", (Object)string);
                return false;
            }
        }
        this.handleSelectedService(service);
        return true;
    }

    private Service getServiceById(String string) {
        if (this.serviceList == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.serviceList.length; ++i2) {
            if (!this.serviceList[i2].getId().equals(string)) continue;
            return this.serviceList[i2];
        }
        this.log.log(-1601830656, "OnlineEvoStandardModelHandler#getServiceById Service with  ID %1 notfound in ServiceList", (Object)string);
        return null;
    }

    private int mapServiceNameToModelStatus(String string) {
        if ("carfinder_v1".equals(string)) {
            return 0;
        }
        if ("rheating_v1".equals(string)) {
            return 1;
        }
        if ("alert_service".equals(string)) {
            return 2;
        }
        if ("userSettings_service".equals(string)) {
            return 3;
        }
        if (string.equals("mobilekey_sales_v1")) {
            return 4;
        }
        return -1;
    }

    public int getCurrentApplicationRepresentation() {
        return this.currentServiceModelValue;
    }

    public Service getCurrentApplication() {
        return this.currentService;
    }

    public void updateUserList(User[] userArray) {
        this.log.log(1078071040, "OnlineEvoStandardModelHandler#updateUserList %1 (%2)", (Object)userArray, userArray != null ? (long)userArray.length : -1L);
        if (userArray == null) {
            this.log.log(1078071040, "OnlineEvoStandardModelHandler#updateUserList list is null");
            return;
        }
        this.availableUsers = userArray;
        User user = this.getMainUser(userArray);
        int n = userArray.length;
        if (user != null) {
            --n;
        }
        String string = user == null ? "" : user.getLogin();
        this.log.log(1078071040, "OnlineEvoStandardModelHandler#updateUserList main user is: %1", (Object)string);
        this.hmiService.getLabelModel(505225984).setText(string);
        this.basicListRowCollapsed = this.getFirstRow(0, n);
        this.basicListRowExpanded = this.getFirstRow(1, n);
        this.storeSecUsersListRows(userArray, n);
        if (this.listState == 0) {
            this.collapseList();
        } else {
            this.expandList();
        }
    }

    private void storeSecUsersListRows(User[] userArray, int n) {
        this.secondaryUsersList = new EvoListRow[n];
        int n2 = 0;
        for (int i2 = 0; i2 < userArray.length; ++i2) {
            User user = userArray[i2];
            if (user.isMainUser()) continue;
            EvoListRow evoListRow = new EvoListRow(i2 + 1, 6);
            evoListRow.setInteger(1, 1);
            evoListRow.setText(5, user.getLogin());
            this.secondaryUsersList[n2++] = evoListRow;
        }
    }

    private void updateUserListModel(EvoListRow evoListRow, EvoListRow[] evoListRowArray) {
        BaseListModelApp baseListModelApp = this.hmiService.getBaseListModel(488448768);
        baseListModelApp.removeAll();
        baseListModelApp.append(evoListRow);
        baseListModelApp.append(evoListRowArray);
    }

    public void expandOrCollapseUserListModel() {
        if (this.listState == 0 && this.availableUsers.length > 0) {
            this.expandList();
        } else {
            this.collapseList();
        }
        this.listState ^= 1;
    }

    private void collapseList() {
        this.updateUserListModel(this.basicListRowCollapsed, new EvoListRow[0]);
    }

    private void expandList() {
        this.updateUserListModel(this.basicListRowExpanded, this.secondaryUsersList);
    }

    private EvoListRow getFirstRow(int n, int n2) {
        EvoListRow evoListRow = new EvoListRow(0L, 5);
        evoListRow.setInteger(1, 0);
        evoListRow.setInteger(2, n);
        evoListRow.setText(4, String.valueOf(n2));
        return evoListRow;
    }

    private User getMainUser(User[] userArray) {
        for (int i2 = 0; i2 < userArray.length; ++i2) {
            this.log.log(1078071040, "OnlineEvoStandardModelHandler#getMainUser: user: %1", (Object)userArray[i2]);
            if (!userArray[i2].isMainUser()) continue;
            return userArray[i2];
        }
        return null;
    }

    public void resetUserResponse(int n) {
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(823993088);
        choiceModelApp.setValue(n);
        choiceModelApp.setStatus(1);
    }

    public void resetLoginModels() {
        this.hmiService.getChoiceModel(840770304).setStatus(0);
    }

    public void resetLogoutModels() {
        this.hmiService.getChoiceModel(823993088).setStatus(0);
    }

    public void setMainUserResponse(int n, int n2) {
        this.log.log(1078071040, "OnlineEvoStandardModelHandler#setMainUserResponse result: %1 remaining attempts: %2", (long)n, (long)n2);
        this.hmiService.getLabelModel(555557632).setText(String.valueOf(n2));
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(840770304);
        if (n == 1 && n2 == 0) {
            n = 3;
        }
        choiceModelApp.setValue(n);
        choiceModelApp.setStatus(1);
        this.clearPinInput();
    }

    private void clearPinInput() {
        this.hmiService.getSpellerModel(605889280).clear();
        this.hmiService.getTextfieldModel(572334848).setText1("");
    }

    public void clearAuthentication() {
        this.hmiService.getSpellerModel(605889280).clear();
        this.hmiService.getSpellerModel(639443712).clear();
        this.hmiService.getTextfieldModel(572334848).setText1("");
        this.hmiService.getTextfieldModel(656220928).setText1("");
    }

    public void setCgwUserListStatus(boolean bl) {
        BaseListModelApp baseListModelApp = this.hmiService.getBaseListModel(488448768);
        this.log.log(1078071040, "OnlineEvoStandardModelHandler#setCgwUserListStatus setting 'CONN_GATEWAY_USERS_BASE_LIST' to %1", bl ? 1L : 0L);
        baseListModelApp.setStatus(bl ? 1 : 0);
    }

    public void updateAlertServices(int n, int n2, int n3) {
        this.setAlertServices(n, n2, n3);
    }

    private void setAlertServices(int n, int n2, int n3) {
        this.log.log(1078071040, "OnlineEvoStandardModelHandler#setAlertServices setting geo %1, speed %2, valet %3, curfew %4", (Object)new Integer(n), (Object)new Integer(n2), (Object)new Integer(n3));
        this.hmiService.getChoiceModel(-316857600).setValue(n);
        this.hmiService.getChoiceModel(-350412032).setValue(n2);
        this.hmiService.getChoiceModel(-300080384).setValue(n3);
    }

    @Override
    public void languageChanged() {
        this.updateServiceList(this.serviceList);
    }

    public void setAlertServicesPrivacyDisclaimerTextVisibleChoice(boolean bl) {
        this.hmiService.getChoiceModel(1646207744).setValue(bl ? 1 : 0);
    }

    public void setRemoteHmiService(RemoteHMIService remoteHMIService) {
        this.remoteHmiService = remoteHMIService;
    }
}

