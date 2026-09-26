/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.online.EvoOnlineDiag
 *  de.mib.swdiagnosis.online.OnlineDiag
 */
package de.audi.app.online;

import de.audi.app.online.evo.OnlineActionProxyStd;
import de.audi.app.online.evo.OnlineEvoActionProxyImpl;
import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.app.online.evo.mobilekey.MobileKeyPopupController;
import de.audi.app.online.evo.mobilekey.MobileKeyStatusDisplayController;
import de.audi.app.online.evo.mobilekey.MobileKeyStatusDisplayModelAccess;
import de.audi.app.online.evo.mobilekey.MobileKeyStatusDisplayStorageAccess;
import de.audi.app.online.evo.mobilekey.MobileKeyVTANController;
import de.audi.app.online.privacysettings.GPSPopupController;
import de.audi.app.online.privacysettings.PrivacySettingsController;
import de.audi.app.online.privacysettings.PrivacySettingsModelAccess;
import de.audi.app.online.privacysettings.PrivacySettingsServiceListener;
import de.audi.app.online.privacysettings.PrivacySettingsStorageAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.view.IPopupManager;
import de.audi.atip.interapp.FactResetService;
import de.audi.atip.interapp.eni.ENIServiceOnline;
import de.audi.atip.interapp.online.MobileKeyStatusDisplayService;
import de.audi.atip.phone.ITelServiceConnectivity;
import de.audi.atip.statemachine.ap.OnlineActionProxy;
import de.audi.tghu.online.app.AbstractOnlineActivator;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationSubsystem;
import de.audi.tghu.online.app.osr.license.LicenseCollectionServiceEvo;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.standard.IStandardController;
import de.audi.tghu.online.app.standard.SimpleServiceRegistrationListener;
import de.mib.swdiagnosis.online.EvoOnlineDiag;
import de.mib.swdiagnosis.online.OnlineDiag;
import java.lang.reflect.Field;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.osgi.framework.BundleContext;

public abstract class AbstractOnlineEvoActivator
extends AbstractOnlineActivator {
    private OnlineActionProxy onlineActionProxy;
    private OnlineDiag onlineDiag;
    private MobileKeyVTANController mobileKeyController;
    private MobileKeyStatusDisplayController mobileKeyStatusDisplayController;
    private PrivacySettingsController privacySettingsController;
    private GPSPopupController gpsPopupController;
    private HMIService hmiService;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$eni$ENIMobileKeyListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$eni$ENIMobileKeyStatusDisplayListener;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;
    static /* synthetic */ Class class$de$audi$atip$statemachine$ActionProxy;
    static /* synthetic */ Class class$de$audi$atip$hmi$app$AppOnlineTextConstants;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.hmiService = this.framework.getHMIService();
        this.registerOnlineI18NHandler();
        this.initENI();
    }

    @Override
    protected void finalizeStart() {
        try {
            this.registerOnlineEvoActionProxy();
        }
        catch (NullPointerException nullPointerException) {
            this.logChannel.log(10000, new StringBuffer().append("AbstractOnlineEvoActivator#finalizeStart: registerOnlineEvoActionProxy failed! ").append(nullPointerException.getMessage()).toString());
        }
        this.initLicenseCollectionService();
        this.initPrivacySettingsComponents();
        this.initMobileKeyComponents();
        super.finalizeStart();
    }

    protected final void initMobileKeyComponents() {
        MobileKeyStatusDisplayService mobileKeyStatusDisplayService;
        RemoteHMIService remoteHMIService;
        MobileKeyPopupController mobileKeyPopupController = new MobileKeyPopupController(this.hmiService, this.logChannel);
        this.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = AbstractOnlineEvoActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)mobileKeyPopupController, (Dictionary)AbstractOnlineEvoActivator.createServiceProperties());
        this.mobileKeyController = new MobileKeyVTANController(this.logChannel, this.hmiService, this.getFramework());
        this.registerService((class$de$audi$atip$interapp$eni$ENIMobileKeyListener == null ? (class$de$audi$atip$interapp$eni$ENIMobileKeyListener = AbstractOnlineEvoActivator.class$("de.audi.atip.interapp.eni.ENIMobileKeyListener")) : class$de$audi$atip$interapp$eni$ENIMobileKeyListener).getName(), (Object)this.mobileKeyController, (Dictionary)AbstractOnlineEvoActivator.createServiceProperties());
        MobileKeyStatusDisplayModelAccess mobileKeyStatusDisplayModelAccess = new MobileKeyStatusDisplayModelAccess(this.logChannel);
        mobileKeyStatusDisplayModelAccess.setServiceActiveChoice(this.hmiService.getChoiceModel(1730093824));
        mobileKeyStatusDisplayModelAccess.setServiceActiveStateCanBeModifiedChoice(this.hmiService.getChoiceModel(1931420416));
        mobileKeyStatusDisplayModelAccess.setServiceActivateButton(this.hmiService.getButtonModel(1813979904));
        mobileKeyStatusDisplayModelAccess.setServiceDeactivateButton(this.hmiService.getButtonModel(1830757120));
        mobileKeyStatusDisplayModelAccess.setServiceResetButton(this.hmiService.getButtonModel(1948197632));
        mobileKeyStatusDisplayModelAccess.setFleetModeActiveChoice(this.hmiService.getChoiceModel(1713316608));
        mobileKeyStatusDisplayModelAccess.setBackendStateChoice(this.hmiService.getChoiceModel(1746871040));
        mobileKeyStatusDisplayModelAccess.setKeyCountChoice(this.hmiService.getChoiceModel(1780425472));
        mobileKeyStatusDisplayModelAccess.setKeyCountLabel(this.hmiService.getLabelModel(1763648256));
        mobileKeyStatusDisplayModelAccess.setSmartCardEnabledChoice(this.hmiService.getChoiceModel(1864311552));
        mobileKeyStatusDisplayModelAccess.setCarKeyTypeChoice(this.hmiService.getChoiceModel(1998529280));
        mobileKeyStatusDisplayModelAccess.checkConfig();
        MobileKeyStatusDisplayStorageAccess mobileKeyStatusDisplayStorageAccess = new MobileKeyStatusDisplayStorageAccess(this.framework.getStorageMgr(), this.logChannel);
        this.mobileKeyStatusDisplayController = new MobileKeyStatusDisplayController(mobileKeyStatusDisplayModelAccess, mobileKeyStatusDisplayStorageAccess, this.hmiService, this.framework, this.logChannel, this.useEni);
        this.setMobileKeyLicenseListener(this.mobileKeyStatusDisplayController);
        this.mobileKeyStatusDisplayController.setMobileKeyPopupController(mobileKeyPopupController);
        FactResetService factResetService = this.getFactResetService();
        if (factResetService != null) {
            this.mobileKeyStatusDisplayController.setFactResetService(factResetService);
        }
        if ((remoteHMIService = this.getRemoteHmiService()) instanceof RemoteHMIServiceEvo) {
            this.mobileKeyStatusDisplayController.setRemoteHmiService((RemoteHMIServiceEvo)remoteHMIService);
        }
        if ((mobileKeyStatusDisplayService = this.getMobileKeyStatusDisplayService()) != null) {
            this.mobileKeyStatusDisplayController.setDisplayService(mobileKeyStatusDisplayService);
        }
        if (this.onlineDiag instanceof EvoOnlineDiag) {
            ((EvoOnlineDiag)this.onlineDiag).setMobileKeyController(this.mobileKeyStatusDisplayController);
        }
        if (this.onlineActionProxy instanceof OnlineEvoActionProxyImpl) {
            ((OnlineEvoActionProxyImpl)this.onlineActionProxy).setMobileKeyStatusDisplayController(this.mobileKeyStatusDisplayController);
        } else if (this.onlineActionProxy instanceof OnlineActionProxyStd) {
            ((OnlineActionProxyStd)this.onlineActionProxy).setMobileKeyStatusDisplayController(this.mobileKeyStatusDisplayController);
        } else {
            this.logChannel.log(1078071040, "AbstractOnlineEvoActivator#initENI onlineActionProxy not available to relay mobile key events; RHMI is probably not coded in");
        }
        this.registerService((class$de$audi$atip$interapp$eni$ENIMobileKeyStatusDisplayListener == null ? (class$de$audi$atip$interapp$eni$ENIMobileKeyStatusDisplayListener = AbstractOnlineEvoActivator.class$("de.audi.atip.interapp.eni.ENIMobileKeyStatusDisplayListener")) : class$de$audi$atip$interapp$eni$ENIMobileKeyStatusDisplayListener).getName(), (Object)this.mobileKeyStatusDisplayController, (Dictionary)AbstractOnlineEvoActivator.createServiceProperties());
    }

    protected final void initENI() {
        if (this.useEni) {
            IStandardController iStandardController = this.createStandardController(this.hmiService);
            iStandardController.setPrivacyModeFeatureAvailable(this.privacyModeFeatureAvailable, this.getPrivacyFeatureStorageAccess());
            iStandardController.init();
            this.setStandardController(iStandardController);
        }
    }

    protected final void initPrivacySettingsController() {
        ButtonModelApp buttonModelApp = this.hmiService.getButtonModel(1260331776);
        buttonModelApp.setStatus(0);
        ButtonModelApp buttonModelApp2 = this.hmiService.getButtonModel(1679762176);
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(5582);
        PrivacySettingsModelAccess privacySettingsModelAccess = new PrivacySettingsModelAccess(buttonModelApp, buttonModelApp2, choiceModelApp);
        PrivacySettingsStorageAccess privacySettingsStorageAccess = new PrivacySettingsStorageAccess(this.framework.getStorageMgr(), this.logChannel);
        boolean bl = this.framework.getSysConstManager().getSysConst(463) == 1;
        boolean bl2 = this.useEni && !this.useRemoteHmi;
        this.privacySettingsController = new PrivacySettingsController(privacySettingsModelAccess, privacySettingsStorageAccess, bl, bl2, this.logChannel);
        this.privacySettingsController.setPrivacyModeFeatureAvailable(this.privacyModeFeatureAvailable);
        this.privacySettingsController.setOnlineEvoStandardController(this.getStandardController());
        this.privacySettingsController.setRemoteHMIService(this.getRemoteHmiService());
        this.privacySettingsController.setOnlineServiceRegistrationSubsystem(this.getOnlineServiceRegistrationSubsystem());
        this.privacySettingsController.initFromPersistence();
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppOnline");
        hashtable.put("moduleID", new Integer(23));
        this.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = AbstractOnlineEvoActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.privacySettingsController, (Dictionary)hashtable);
    }

    protected final void initGPSPopupController() {
        IPopupManager iPopupManager = this.hmiService.getPopupManager(0);
        int n = -1473960448;
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(1629430528);
        boolean bl = this.framework.getSysConstManager().getSysConst(5614) == 1;
        this.gpsPopupController = new GPSPopupController(iPopupManager, n, choiceModelApp, bl, this.logChannel);
        this.registerService((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = AbstractOnlineEvoActivator.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), (Object)this.gpsPopupController, null);
        if (this.onlineActionProxy instanceof OnlineEvoActionProxyImpl) {
            ((OnlineEvoActionProxyImpl)this.onlineActionProxy).setGpsPopupController(this.gpsPopupController);
        } else if (this.onlineActionProxy instanceof OnlineActionProxyStd) {
            ((OnlineActionProxyStd)this.onlineActionProxy).setGpsPopupController(this.gpsPopupController);
        } else {
            this.logChannel.log(1078071040, "AbstractOnlineEvoActivator#initGPSPopupController onlineActionProxy not available to monitor user reaction to the GPS warning popup; RHMI is probably not coded in");
        }
    }

    protected final void initPrivacySettingsComponents() {
        this.initPrivacySettingsController();
        this.initGPSPopupController();
        this.initPrivacySettingsServiceListener();
    }

    protected final void initPrivacySettingsServiceListener() {
        PrivacySettingsServiceListener privacySettingsServiceListener = new PrivacySettingsServiceListener(this.gpsPopupController, this.logChannel);
        this.setSimpleServiceRegistrationListener(new SimpleServiceRegistrationListener(privacySettingsServiceListener, this.logChannel));
        if (this.useEni) {
            IStandardController iStandardController = this.getStandardController();
            if (iStandardController != null) {
                iStandardController.setServiceListenerDelegate(privacySettingsServiceListener);
            } else {
                this.logChannel.log(-1601830656, "AbstractOnlineEvoActivator#initPrivacySettingsServiceListener standardController is null!");
            }
        }
    }

    protected final void initLicenseCollectionService() {
        LicenseCollectionServiceEvo licenseCollectionServiceEvo = new LicenseCollectionServiceEvo(this.logChannel, this.getFramework().getHMIService(), this.getRemoteHmiService(), this.getTextConstantsConverter(), true);
        this.setLicenseCollectionService(licenseCollectionServiceEvo);
    }

    @Override
    protected final void readPrivacyModeFeatureCoding() {
        this.readPrivacyModeFeatureCodingCore();
        this.logChannel.log(1078071040, "AbstractOnlineEvoActivator#readPrivacyModeFeatureCoding: privacy feature available: %1", this.privacyModeFeatureAvailable);
        ChoiceModelApp choiceModelApp = this.getFramework().getHMIService().getChoiceModel(5625);
        if (choiceModelApp != null) {
            choiceModelApp.setValue(this.privacyModeFeatureAvailable ? 0 : 1);
        } else {
            this.logChannel.log(10000, "AbstractOnlineEvoActivator#readPrivacyModeFeatureCoding: PRIVACY_MODE_AVAILABLE_CHOICE is null!");
        }
    }

    @Override
    protected final void setTelServiceConnectivityVariant(ITelServiceConnectivity iTelServiceConnectivity) {
        this.logChannel.log(-2137614336, "AbstractOnlineEvoActivator#addingService: Tel Service: %1", (Object)iTelServiceConnectivity);
        if (this.privacySettingsController != null) {
            this.privacySettingsController.setTelService(iTelServiceConnectivity);
        }
    }

    @Override
    protected final void setDsiOnlineServiceRegistrationVariant(DSIOnlineServiceRegistration dSIOnlineServiceRegistration) {
        if (this.gpsPopupController != null) {
            this.gpsPopupController.setDsi(dSIOnlineServiceRegistration);
        }
    }

    @Override
    protected final void setEniServiceOnlineVariant(ENIServiceOnline eNIServiceOnline) {
        if (this.mobileKeyController != null) {
            this.mobileKeyController.setENIServiceOnline(eNIServiceOnline);
        }
        if (this.mobileKeyStatusDisplayController != null) {
            this.mobileKeyStatusDisplayController.setEniServiceOnline(eNIServiceOnline);
        }
    }

    @Override
    protected final void setMobileKeyStatusDisplayServiceVariant(MobileKeyStatusDisplayService mobileKeyStatusDisplayService) {
        if (this.mobileKeyStatusDisplayController != null) {
            this.mobileKeyStatusDisplayController.setDisplayService(mobileKeyStatusDisplayService);
        }
    }

    @Override
    protected final void setFactResetServiceVariant(FactResetService factResetService) {
        if (this.mobileKeyStatusDisplayController != null) {
            this.mobileKeyStatusDisplayController.setFactResetService(factResetService);
            OnlineServiceRegistrationSubsystem onlineServiceRegistrationSubsystem = this.getOnlineServiceRegistrationSubsystem();
            if (onlineServiceRegistrationSubsystem != null) {
                onlineServiceRegistrationSubsystem.setFactoryResetState(this.mobileKeyStatusDisplayController);
            }
        }
    }

    private void registerOnlineEvoActionProxy() {
        this.onlineActionProxy = this.createOnlineActionProxy();
        if (this.onlineActionProxy != null) {
            Hashtable hashtable = new Hashtable();
            hashtable.put("moduleID", new Integer(11));
            this.registerService((class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = AbstractOnlineEvoActivator.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy).getName(), (Object)this.onlineActionProxy, (Dictionary)hashtable);
        }
    }

    @Override
    protected final OnlineDiag getOnlineDiag() {
        if (this.onlineDiag == null) {
            this.onlineDiag = this.createOnlineDiag();
        }
        return this.onlineDiag;
    }

    @Override
    protected final void registerServices() {
        this.registerOnlineServices();
        this.registerAdbListener();
        this.registerLogoProviderService();
        this.registerOnlineRoamingService();
        this.registerENIListener();
        this.registerPowerManagerListener();
        this.registerMsgListener();
        this.registerServicesVariant();
    }

    @Override
    public final Field[] getI18NTextFields() {
        return (class$de$audi$atip$hmi$app$AppOnlineTextConstants == null ? (class$de$audi$atip$hmi$app$AppOnlineTextConstants = AbstractOnlineEvoActivator.class$("de.audi.atip.hmi.app.AppOnlineTextConstants")) : class$de$audi$atip$hmi$app$AppOnlineTextConstants).getFields();
    }

    @Override
    protected final int getShutdownPopupId() {
        return 41;
    }

    protected abstract void registerServicesVariant() {
    }

    protected abstract OnlineActionProxy createOnlineActionProxy() {
    }

    protected abstract IStandardController createStandardController(HMIService hMIService) {
    }

    protected abstract OnlineDiag createOnlineDiag() {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

