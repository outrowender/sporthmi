/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.standard;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.interapp.bap.eni.data.License;
import de.audi.atip.interapp.bap.eni.data.PrivacySetup;
import de.audi.atip.interapp.bap.eni.data.Service;
import de.audi.atip.interapp.bap.eni.data.User;
import de.audi.atip.interapp.eni.ENIServiceOnline;
import de.audi.atip.interapp.eni.ENIServiceOnlineListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.osr.license.LicenseCollectionService;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.standard.IBAPServiceListener;
import de.audi.tghu.online.app.standard.IMobileKeyLicenseListener;
import de.audi.tghu.online.app.standard.IStandardController;
import de.audi.tghu.online.app.standard.OnlineEvoStandardHmiListener;
import de.audi.tghu.online.app.standard.OnlineEvoStandardModelHandler;
import de.audi.tghu.online.app.standard.OnlineI18NHandler;
import de.audi.tghu.online.app.standard.OnlinePowerManagerListener;
import de.audi.tghu.online.app.standard.PrivacyFeatureStorageAccess;
import de.esolutions.fw.util.commons.Buffer;

public abstract class AbstractStandardController
implements ENIServiceOnlineListener,
IStandardController {
    protected LogChannel log;
    protected ENIServiceOnline eniService;
    protected HMIService hmiService;
    protected OnlineEvoStandardHmiListener hmiListener;
    protected OnlineEvoStandardModelHandler modelHandler;
    protected OnlineI18NHandler i18nHandler;
    protected RemoteHMIService remoteHmiService;
    protected LicenseCollectionService licenseCollectionService;
    private IBAPServiceListener serviceListenerDelegate;
    private IMobileKeyLicenseListener mobileKeyLicenseListener = null;
    private boolean mobileKeyLicenseValid = true;
    private Service[] services;
    protected OnlinePowerManagerListener powerManager;
    private int shutdownPopupId;
    private boolean privacyModeIsActive;
    private boolean initialPrivacyModePending = false;
    protected IFrameworkAccess framework;
    private boolean hasNadModuleFeedback;
    private boolean needsCgwSync = false;
    private boolean privacyModeFeatureAvailable = true;
    private boolean privacyFeatureStateChanged = false;
    private PrivacyFeatureStorageAccess privacyFeatureStorageAccess;

    public AbstractStandardController(LogChannel logChannel, HMIService hMIService, int n, OnlineI18NHandler onlineI18NHandler, IFrameworkAccess iFrameworkAccess) {
        this.log = logChannel;
        this.hmiService = hMIService;
        this.shutdownPopupId = n;
        this.i18nHandler = onlineI18NHandler;
        this.framework = iFrameworkAccess;
        this.hasNadModuleFeedback = iFrameworkAccess.getSysConstManager().getSysConst(463) == 0;
    }

    public void init() {
        this.hmiListener = new OnlineEvoStandardHmiListener(this.log, this);
        this.modelHandler = new OnlineEvoStandardModelHandler(this.hmiService, this.log, this.i18nHandler);
        this.i18nHandler.addLanguageChangedListener(this.modelHandler);
        this.hmiListener.setModelManager(this.modelHandler);
        this.modelHandler.init();
        this.powerManager = new OnlinePowerManagerListener(this.hmiService, this.log, this.shutdownPopupId, this.framework.getPowerMgr());
        this.powerManager.setPrivacyMode(this.privacyModeIsActive);
        this.log.log(1000000, "AbstractStandardController#init finished");
    }

    public void setMobileKeyLicenseListener(IMobileKeyLicenseListener iMobileKeyLicenseListener) {
        this.mobileKeyLicenseListener = iMobileKeyLicenseListener;
        iMobileKeyLicenseListener.updateMobileKeyLicense(this.mobileKeyLicenseValid);
    }

    private void extractMobileKeyLicence(Service[] serviceArray) {
        Object object;
        boolean bl;
        this.log.log(10000000, "GreyServiceHighController#extractMobileKeyLicence called.");
        Service service = null;
        for (bl = false; bl < serviceArray.length; bl += 1) {
            if (!"mobilekey_sales_v1".equals(serviceArray[bl].getId())) continue;
            this.log.log(1000000, "GreyServiceHighController#extractMobileKeyLicence: found mobile key entry.");
            service = serviceArray[bl];
            break;
        }
        bl = true;
        if (service != null && (object = service.getLicense()) != null) {
            int n = ((License)object).getState();
            bl = n == 2 || n == 4;
        }
        this.log.log(1000000, "GreyServiceHighController#extractMobileKeyLicence: licensed: %1", bl);
        this.mobileKeyLicenseValid = bl;
        if (this.mobileKeyLicenseListener != null) {
            this.mobileKeyLicenseListener.updateMobileKeyLicense(bl);
        } else {
            this.log.log(1000000, "GreyServiceHighController#extractMobileKeyLicence: mobileKeyStatusDisplayController is null!");
        }
        object = this.hmiService.getChoiceModel(2301816);
        if (object != null) {
            object.setValue(bl ? 0 : 1);
        } else {
            this.log.log(100000, "GreyServiceHighController#extractMobileKeyLicence: license model is null!");
        }
    }

    public void setPrivacyModeFeatureAvailable(boolean bl, PrivacyFeatureStorageAccess privacyFeatureStorageAccess) {
        this.log.log(1000000, "AbstractStandardController#setPrivacyModeFeatureAvailable: %1", bl);
        this.privacyModeFeatureAvailable = bl;
        this.privacyFeatureStorageAccess = privacyFeatureStorageAccess;
        if (this.eniService != null) {
            this.eniService.setPrivacyModeFeatureAvailable(bl);
        }
    }

    public void initiateHmiJump() {
    }

    public void changeApplicationState(boolean bl) {
        Service service = this.modelHandler.getCurrentApplication();
        if (service == null) {
            this.log.log(1000000, "AbstractStandardController#changeApplicationState invalidApplication (null)");
            return;
        }
        this.log.log(1000000, "AbstractStandardController#changeApplicationState %1 with ID %2 to %3", (Object)service.getName(), (Object)service.getId(), (Object)bl);
        if (this.eniService == null) {
            this.log.log(10000, "AbstractStandardController#changeApplicationState no eniService available");
            return;
        }
        if (bl) {
            this.eniService.enableService(service);
        } else {
            this.eniService.disableService(service);
        }
    }

    public void setEniServiceOnline(ENIServiceOnline eNIServiceOnline) {
        this.log.log(1000000, "AbstractStandardController#setEniServiceOnline eniService set: %1", (Object)eNIServiceOnline);
        this.eniService = eNIServiceOnline;
        eNIServiceOnline.setPrivacyModeFeatureAvailable(this.privacyModeFeatureAvailable);
        if (this.initialPrivacyModePending) {
            this.initialPrivacyModePending = false;
            this.triggerPrivacyMode(this.privacyModeIsActive);
        }
    }

    public ENIServiceOnlineListener getEniServiceListener() {
        return this;
    }

    public void setRemoteHmiService(RemoteHMIService remoteHMIService) {
        this.remoteHmiService = remoteHMIService;
        this.modelHandler.setRemoteHmiService(remoteHMIService);
    }

    public void onServiceList(Service[] serviceArray) {
        this.log.log(10000000, "AbstractStandardController#onServiceList: getting CGW services %1", (long)serviceArray.length);
        this.modelHandler.updateServiceList(serviceArray);
        this.services = serviceArray;
        if (this.licenseCollectionService != null) {
            this.licenseCollectionService.setLicensesFromCGW(serviceArray);
        }
        if (this.serviceListenerDelegate != null) {
            this.serviceListenerDelegate.onServiceList(serviceArray);
        }
        this.sendCGWServicesToBEM(serviceArray);
        this.extractMobileKeyLicence(serviceArray);
    }

    private void sendCGWServicesToBEM(Service[] serviceArray) {
        Buffer buffer = new Buffer();
        Buffer buffer2 = new Buffer();
        Buffer buffer3 = new Buffer();
        Buffer buffer4 = new Buffer();
        if (serviceArray == null) {
            this.log.log(10000000, "AbstractStandardController#sendCGWServicesToBEM: given Services are NULL!");
        }
        buffer.append(serviceArray.length);
        buffer.append(" received: ");
        for (int i2 = 0; i2 < serviceArray.length; ++i2) {
            Service service = serviceArray[i2];
            if (service == null) continue;
            buffer.append(service.getId());
            buffer.append("; ");
            this.printLicenceDataforBEM(service, i2, buffer, buffer2, buffer3, buffer4);
        }
        if (this.remoteHmiService != null && this.remoteHmiService.getDiagnosisComponent() != null) {
            this.remoteHmiService.getDiagnosisComponent().update(buffer.toString(), 9);
            this.remoteHmiService.getDiagnosisComponent().update(buffer2.toString(), 10);
            this.remoteHmiService.getDiagnosisComponent().update(buffer3.toString(), 11);
            this.remoteHmiService.getDiagnosisComponent().update(buffer4.toString(), 12);
        }
    }

    private void sendCGWUserInfoToBEM(User[] userArray) {
        Buffer buffer = new Buffer();
        if (userArray != null) {
            buffer.append(userArray.length);
            buffer.append(" received; ");
            for (int i2 = 0; i2 < userArray.length; ++i2) {
                User user = userArray[i2];
                if (user == null) continue;
                buffer.append("[ ");
                buffer.append(user.getLogin());
                buffer.append("|");
                buffer.append(user.isMainUser() ? "HNu" : "NNu");
                buffer.append(" ]");
            }
            if (this.remoteHmiService != null && this.remoteHmiService.getDiagnosisComponent() != null) {
                this.remoteHmiService.getDiagnosisComponent().update(buffer.toString(), 13);
            }
        } else {
            this.log.log(10000000, "AbstractStandardController#sendCGWUserInfoToBEM: given Users are NULL!");
        }
    }

    private void printLicenceDataforBEM(Service service, int n, Buffer buffer, Buffer buffer2, Buffer buffer3, Buffer buffer4) {
        if (n < 6) {
            buffer2.append("[");
            buffer2.append(service.getId());
            buffer2.append("|");
            buffer2.append(service.hasExpirationWarning() ? "ExpW" : "noExpW");
            if (service.getLicense() != null) {
                buffer2.append("|");
                buffer2.append(service.getLicense().getState());
            }
            buffer2.append("]; ");
        } else if (n >= 6 && n < 12) {
            buffer3.append("[");
            buffer3.append(service.getId());
            buffer3.append("|");
            buffer3.append(service.hasExpirationWarning() ? "ExpW" : "noExpW");
            if (service.getLicense() != null) {
                buffer3.append("|");
                buffer3.append(service.getLicense().getState());
            }
            buffer3.append("]; ");
        } else if (n >= 12 && n < 16) {
            buffer4.append("[");
            buffer4.append(service.getId());
            buffer4.append("|");
            buffer4.append(service.hasExpirationWarning() ? "ExpW" : "noExpW");
            if (service.getLicense() != null) {
                buffer4.append("|");
                buffer4.append(service.getLicense().getState());
            }
            buffer4.append("]; ");
        }
    }

    public void onUserList(User[] userArray) {
        this.modelHandler.setCgwUserListStatus(true);
        this.modelHandler.updateUserList(userArray);
        this.sendCGWUserInfoToBEM(userArray);
        this.powerManager.indicateUsersAvailable(userArray != null && userArray.length > 0);
    }

    public void onMonitorings(int n, int n2, int n3) {
        this.modelHandler.updateAlertServices(n, n2, n3);
    }

    public void triggerMainUserSetUsingVehiclePINResponse(int n, int n2) {
        this.modelHandler.setMainUserResponse(n, n2);
    }

    public void triggerMainUserResetResponse(boolean bl) {
        int n = bl ? 0 : 1;
        this.modelHandler.resetUserResponse(n);
    }

    public void triggerUpdateUserListResponse(boolean bl) {
        this.modelHandler.setCgwUserListStatus(bl);
    }

    public void setMainUser(String string, String string2) {
        this.log.log(1000000, "AbstractStandardController#setMainUser %1 with pwd: %2", (Object)string, (Object)string2);
        this.modelHandler.resetLoginModels();
        if (this.eniService == null) {
            this.log.log(1000000, "AbstractStandardController#setMainUser no eniService! aborting");
            return;
        }
        this.eniService.triggerPairMainUserUsingVehiclePIN(string, string2);
    }

    public void resetMainUser() {
        this.log.log(1000000, "AbstractStandardController#resetMainUser");
        this.modelHandler.resetLogoutModels();
        if (this.eniService == null) {
            this.log.log(1000000, "AbstractStandardController#resetMainUser no eniService! aborting");
            return;
        }
        this.eniService.triggerMainUserReset();
    }

    public void setLicenseCollectionService(LicenseCollectionService licenseCollectionService) {
        this.log.log(1000000, "AbstractStandardController#setLicenseCollectionService: Called");
        this.licenseCollectionService = licenseCollectionService;
        if (licenseCollectionService != null && this.services != null) {
            licenseCollectionService.setLicensesFromCGW(this.services);
        }
    }

    public void setServiceListenerDelegate(IBAPServiceListener iBAPServiceListener) {
        this.log.log(1000000, "AbstractStandardController#setServiceListenerDelegate: Called");
        this.serviceListenerDelegate = iBAPServiceListener;
        if (this.serviceListenerDelegate != null && this.services != null) {
            this.serviceListenerDelegate.onServiceList(this.services);
        }
    }

    public Object getPowerManagerListener() {
        return this.powerManager;
    }

    public void triggerUpdateUserlist() {
        if (this.eniService != null) {
            this.log.log(1000000, "AbstractStandardController#triggerUpDateUserlist");
            this.eniService.triggerUpdateUserList();
        }
    }

    public void triggerPrivacyMode(boolean bl) {
        if (!this.privacyModeFeatureAvailable) {
            this.log.log(100000, "AbstractStandardController#triggerPrivacyMode: Privacy mode feature is not available! Call is ignored.");
            return;
        }
        this.privacyModeIsActive = bl;
        if (this.eniService != null) {
            this.log.log(1000000, "AbstractStandardController#triggerPrivacyMode");
            this.hmiService.getChoiceModel(5619).setValue(1);
            this.eniService.triggerPrivacyMode(bl);
            this.needsCgwSync = false;
        } else {
            this.initialPrivacyModePending = true;
        }
        this.powerManager.setPrivacyMode(bl);
    }

    public void triggerSubmitChangesToBackend() {
        if (this.eniService != null) {
            this.log.log(1000000, "AbstractStandardController#triggerSubmitChangesToBackend");
            this.eniService.triggerSubmitChangesToBackend();
        }
    }

    public void clearAuthentication() {
        this.modelHandler.clearAuthentication();
    }

    public LicenseCollectionService getLicenseCollectionService() {
        return this.licenseCollectionService;
    }

    public void setAlertServicesPrivacyDisclaimerTextVisible(boolean bl) {
        this.modelHandler.setAlertServicesPrivacyDisclaimerTextVisibleChoice(bl);
    }

    public void reportNadModuleFeedback() {
        this.hasNadModuleFeedback = true;
    }

    public void onPrivacySetup(PrivacySetup privacySetup) {
        boolean bl = this.needsCgwSync = privacySetup.isPrivacyModeOn() != this.privacyModeIsActive;
        if (this.needsCgwSync && this.hasNadModuleFeedback) {
            this.triggerPrivacyMode(this.privacyModeIsActive);
        }
    }

    public void triggerCgwSync(boolean bl) {
        if (this.needsCgwSync) {
            this.triggerPrivacyMode(bl);
        }
    }

    public void onRemoteProcessPrivacyModeReturnedToIdle() {
        if (this.privacyFeatureStateChanged) {
            this.log.log(1000000, "AbstractStandardController#onRemoteProcessPrivacyModeReturnedToIdle: Idle ignored because of privacy feature!");
            return;
        }
        this.hmiService.getChoiceModel(5619).setValue(0);
    }

    public void updatePrivacyModeFeatureAvailable(boolean bl) {
        if (bl == this.privacyModeFeatureAvailable) {
            this.log.log(1000000, "AbstractStandardController#updatePrivacyModeFeatureAvailable: nothing changed.");
            return;
        }
        this.privacyFeatureStateChanged = true;
        this.hmiService.getChoiceModel(5619).setValue(1);
        if (this.privacyFeatureStorageAccess != null) {
            this.privacyFeatureStorageAccess.setStorageValue(bl);
        } else {
            this.log.log(10000, "AbstractStandardController#updatePrivacyModeFeatureAvailable: storage access is null!");
        }
    }
}

