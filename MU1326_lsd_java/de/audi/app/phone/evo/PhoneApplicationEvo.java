/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo;

import de.audi.app.phone.core.AbstractPhoneApplication;
import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ITelTextFactory;
import de.audi.app.phone.core.Tel3WaySettingHandler;
import de.audi.app.phone.core.TelRestoreFactorySettingsHandler;
import de.audi.app.phone.core.adb.ITelADBHandler;
import de.audi.app.phone.core.adb.TelADBDownloadInquiryHandler;
import de.audi.app.phone.core.adb.TelADBHandler;
import de.audi.app.phone.core.as.TelActivationStateHandler;
import de.audi.app.phone.core.audio.ITelAudio;
import de.audi.app.phone.core.bap.TelBAPManager;
import de.audi.app.phone.core.bluetooth.ITelBluetoothHandler;
import de.audi.app.phone.core.bluetooth.TelBluetoothHandler;
import de.audi.app.phone.core.callcontrol.ITelCallControl;
import de.audi.app.phone.core.dsi.ITelDSIResponseErrorHandler;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.emergency.IEmergencyTextFactory;
import de.audi.app.phone.core.emergency.TelAutomaticEmergencyCallHandler;
import de.audi.app.phone.core.epm.ITelEPMHandler;
import de.audi.app.phone.core.errormanagement.TelDumpInfoProvider;
import de.audi.app.phone.core.interapp.TelAbortSDSHandler;
import de.audi.app.phone.core.interapp.TelCarPhoneServiceHandler;
import de.audi.app.phone.core.interapp.TelMessagingDeviceRoleServiceHandler;
import de.audi.app.phone.core.interapp.TelOnlinePhoneStateUpdater;
import de.audi.app.phone.core.interapp.TelServiceConnectivityImpl;
import de.audi.app.phone.core.interapp.TelServiceEcallImpl;
import de.audi.app.phone.core.interapp.TelStateDispatcher;
import de.audi.app.phone.core.nad.TelModulePowerHandler;
import de.audi.app.phone.core.nad.TelOptimizationModeHandler;
import de.audi.app.phone.core.network.NetworkStateHandler;
import de.audi.app.phone.core.search.cmd.TelDummyDSISearchAccess;
import de.audi.app.phone.core.sim.TelPINEntryActivationHandler;
import de.audi.app.phone.core.sim.TelPinChangeHandler;
import de.audi.app.phone.core.sim.TelSIMModeSwitchHandler;
import de.audi.app.phone.core.suppservices.ITelDialSuppServiceHandler;
import de.audi.app.phone.core.suppservices.TelCallWaitingHandler;
import de.audi.app.phone.core.suppservices.TellCallCallerIdHandler;
import de.audi.app.phone.core.terminalmode.TelTerminalModeHandler;
import de.audi.app.phone.evo.ChinaSOSCallSpellerHandler;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.KoreaSOSCallSpellerHandler;
import de.audi.app.phone.evo.PhoneNumberSpellerHandler;
import de.audi.app.phone.evo.PhoneStatusIconHandler;
import de.audi.app.phone.evo.TelEvoSAPUpgradeHandler;
import de.audi.app.phone.evo.TelEvoTextFactory;
import de.audi.app.phone.evo.TelLeftDrawerContextHandler;
import de.audi.app.phone.evo.as.TelInitPhoneNotFuncAssociatedHandler;
import de.audi.app.phone.evo.audio.TelEvoAudioScenarioHandler;
import de.audi.app.phone.evo.audio.TelEvoRingtoneManager;
import de.audi.app.phone.evo.battery.TelEvoBatteryHandler;
import de.audi.app.phone.evo.callcontrol.TelEvoCallControl;
import de.audi.app.phone.evo.callcontrol.TelEvoMFLKeyHandler;
import de.audi.app.phone.evo.calllist.TelConferenceMemberListHandler;
import de.audi.app.phone.evo.callstacks.TelEvoCallStackSearchProvider;
import de.audi.app.phone.evo.dsi.TelEvoDSIResponseErrorHandler;
import de.audi.app.phone.evo.dtmf.TelEvoDTMFHandler;
import de.audi.app.phone.evo.entertainmentdrawer.EntertainmentDrawerControllerG24Impl;
import de.audi.app.phone.evo.entertainmentdrawer.EntertainmentDrawerControllerImplNew;
import de.audi.app.phone.evo.entertainmentdrawer.EntertainmentDrawerHandlerNew;
import de.audi.app.phone.evo.entertainmentdrawer.IEntertainmentDrawerControllerNew;
import de.audi.app.phone.evo.epm.TelEPMHandler;
import de.audi.app.phone.evo.favorite.ITelFavoriteHandler;
import de.audi.app.phone.evo.favorite.TelFavoriteHandler;
import de.audi.app.phone.evo.intellicall.ITelIntellicallHandler;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler;
import de.audi.app.phone.evo.interapp.PhoneServiceImpl;
import de.audi.app.phone.evo.interapp.TelConnectivityHandlerEvo;
import de.audi.app.phone.evo.interapp.TelEvoServiceMessaging;
import de.audi.app.phone.evo.interapp.TelServiceADBImpl;
import de.audi.app.phone.evo.mailbox.TelEvoMailboxHandler;
import de.audi.app.phone.evo.network.TelEvoNetworkSetupHandler;
import de.audi.app.phone.evo.preset.TelPresetHandler;
import de.audi.app.phone.evo.proxy.PhoneActionProxyImpl;
import de.audi.app.phone.evo.search.TelEvoDSISearchManager;
import de.audi.app.phone.evo.service.TelEvoAudiServiceHandler;
import de.audi.app.phone.evo.sim.PhoneEvoLockStateHandler;
import de.audi.app.phone.evo.sim.TelEvoAssociatedUnlockHandler;
import de.audi.app.phone.evo.suppservices.TelEvoCallForwardHandler;
import de.audi.app.phone.evo.suppservices.TelEvoSuppServiceDialHandler;
import de.audi.app.phone.evo.util.EvoKoreaEmergencyTextFactory;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;

public class PhoneApplicationEvo
extends AbstractPhoneApplication
implements ITelEvoApplication {
    private final PhoneActionProxyImpl actionProxy;
    private final ITelDSIResponseListener defaultDSIResponseListener;
    private final TelEPMHandler enhancedPrivacyModeHandler;
    private final TelFavoriteHandler favoriteHandler;
    private final TelADBHandler adbHandler;
    private final TelEvoCallControl callControl;
    private final TelEvoTextFactory textFactory;
    private final EvoKoreaEmergencyTextFactory koreaEmergencyTextFactory;
    private final TelEvoSuppServiceDialHandler dialSuppServiceHandler;
    private final ITelAudio audio;
    private final TelIntellicallHandler intellicallHandler;
    private volatile IEntertainmentDrawerControllerNew newEntertainmentDrawerController;
    private final TelEvoDSISearchManager dsiSearchManager;
    private final TelBluetoothHandler bluetoothHandler;
    private final TelEvoDSIResponseErrorHandler dsiResponseErrorHandler;

    public PhoneApplicationEvo(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext) {
        super(iFrameworkAccess, bundleContext, "App.Phone.Main");
        Integer n = Integer.getInteger("INTELLICALL_MODE");
        int n2 = n != null ? n : 0;
        iFrameworkAccess.getHmiServiceApp().getChoiceModel(300686).setValue(n2);
        if (Boolean.getBoolean("TEL_DEVELOPMENT")) {
            iFrameworkAccess.getHmiServiceApp().getChoiceModel(300676).setValue(1);
        }
        this.dsiSearchManager = iFrameworkAccess.getSysConst(523) == 1 ? new TelEvoDSISearchManager(this) : null;
        this.intellicallHandler = this.dsiSearchManager != null ? new TelIntellicallHandler((ITelEvoApplication)this, this.dsiSearchManager) : new TelIntellicallHandler((ITelEvoApplication)this, new TelDummyDSISearchAccess(this));
        this.newEntertainmentDrawerController = this.isG24() ? new EntertainmentDrawerControllerG24Impl(this) : new EntertainmentDrawerControllerImplNew(this);
        this.enhancedPrivacyModeHandler = new TelEPMHandler(this);
        this.favoriteHandler = new TelFavoriteHandler((ITelEvoApplication)this, this.dsiSearchManager);
        this.adbHandler = new TelADBHandler(this);
        this.callControl = new TelEvoCallControl(this);
        this.textFactory = new TelEvoTextFactory(this);
        this.koreaEmergencyTextFactory = new EvoKoreaEmergencyTextFactory(this);
        this.dialSuppServiceHandler = new TelEvoSuppServiceDialHandler(this);
        this.audio = new TelEvoAudioScenarioHandler((ITelApplication)this, new TelEvoRingtoneManager(this));
        this.actionProxy = new PhoneActionProxyImpl(this.getFrameworkAccess(), this.getBundleContext(), this.actionProxyDispatcher);
        this.defaultDSIResponseListener = new TelDefaultDSIResponseListener();
        this.bluetoothHandler = new TelBluetoothHandler(this);
        this.dsiResponseErrorHandler = new TelEvoDSIResponseErrorHandler(this);
    }

    public void init() {
        super.init();
        this.actionProxy.init();
    }

    public void deinit() {
        super.deinit();
        this.actionProxy.deinit();
    }

    private boolean isG24() {
        return this.getFrameworkAccess().getScreenRes() == 4;
    }

    protected void addComponents() {
        this.addPhoneComponent(this.intellicallHandler);
        this.addPhoneComponent(new TelInitPhoneNotFuncAssociatedHandler(this));
        this.addPhoneComponent(new TelRestoreFactorySettingsHandler(this));
        this.addPhoneComponent(new TelSIMModeSwitchHandler(this));
        this.addPhoneComponent(new TelActivationStateHandler(this));
        this.addPhoneComponent(this.audio);
        this.addPhoneComponent(new TelConnectivityHandlerEvo(this));
        this.addPhoneComponent(new TelEvoAssociatedUnlockHandler(this));
        this.addPhoneComponent(new PhoneEvoLockStateHandler(this));
        this.addPhoneComponent((AbstractPhoneComponent)((Object)this.newEntertainmentDrawerController));
        if (!this.isG24()) {
            this.addPhoneComponent(new EntertainmentDrawerHandlerNew(this));
        }
        if (this.getFrameworkAccess().getSysConst(523) == 1) {
            this.addPhoneComponent(this.dsiSearchManager);
            this.addPhoneComponent(new TelEvoCallStackSearchProvider(this));
        }
        this.addPhoneComponent(new TelBAPManager(this));
        this.addPhoneComponent(new TelOptimizationModeHandler(this));
        this.addPhoneComponent(new TelMessagingDeviceRoleServiceHandler(this));
        this.addPhoneComponent(new PhoneNumberSpellerHandler(this));
        this.addPhoneComponent(new ChinaSOSCallSpellerHandler(this));
        this.addPhoneComponent(new KoreaSOSCallSpellerHandler(this));
        this.addPhoneComponent(new PhoneServiceImpl(this, "App.Phone.Main"));
        this.addPhoneComponent(new NetworkStateHandler(this, "App.Phone.Main"));
        this.addPhoneComponent(new TelModulePowerHandler(this));
        this.addPhoneComponent(new TelEvoCallForwardHandler((ITelApplication)this, this.dsiSearchManager));
        this.addPhoneComponent(new TelEvoMailboxHandler(this));
        this.addPhoneComponent(new TelCallWaitingHandler(this));
        this.addPhoneComponent(new TelEvoNetworkSetupHandler(this));
        this.addPhoneComponent(new TellCallCallerIdHandler(this));
        this.addPhoneComponent(new TelPinChangeHandler(this));
        this.addPhoneComponent(new TelAutomaticEmergencyCallHandler(this));
        this.addPhoneComponent(new TelEvoBatteryHandler(this));
        this.addPhoneComponent(new TelCarPhoneServiceHandler(this));
        this.addPhoneComponent(this.enhancedPrivacyModeHandler);
        this.addPhoneComponent(new TelEvoServiceMessaging(this));
        this.addPhoneComponent(this.favoriteHandler);
        this.addPhoneComponent(new TelDumpInfoProvider(this));
        this.addPhoneComponent(new PhoneStatusIconHandler(this));
        this.addPhoneComponent(this.adbHandler);
        this.addPhoneComponent(new TelServiceADBImpl(this));
        this.addPhoneComponent(this.callControl);
        this.addPhoneComponent(new TelEvoMFLKeyHandler(this));
        this.addPhoneComponent(new TelLeftDrawerContextHandler(this));
        this.addPhoneComponent(this.dialSuppServiceHandler);
        this.addPhoneComponent(new TelEvoSAPUpgradeHandler(this));
        this.addPhoneComponent(new TelEvoDTMFHandler(this));
        this.addPhoneComponent(new TelPINEntryActivationHandler(this));
        this.addPhoneComponent(new TelServiceConnectivityImpl(this));
        this.addPhoneComponent(new TelServiceEcallImpl(this));
        this.addPhoneComponent(new TelPresetHandler(this));
        this.addPhoneComponent(new TelEvoAudiServiceHandler(this));
        this.addPhoneComponent(new Tel3WaySettingHandler(this));
        this.addPhoneComponent(new TelAbortSDSHandler(this));
        this.addPhoneComponent(new TelOnlinePhoneStateUpdater(this));
        this.addPhoneComponent(new TelADBDownloadInquiryHandler(this));
        this.addPhoneComponent(this.bluetoothHandler);
        this.addPhoneComponent(new TelStateDispatcher(this));
        this.addPhoneComponent(new TelConferenceMemberListHandler(this));
        this.addPhoneComponent(new TelTerminalModeHandler(this));
    }

    public ITelDSIResponseListener getDefaultListener() {
        return this.defaultDSIResponseListener;
    }

    public ITelFavoriteHandler getFavoriteHandler() {
        return this.favoriteHandler;
    }

    public ITelADBHandler getADBHandler() {
        return this.adbHandler;
    }

    public ITelCallControl getCallControl() {
        return this.callControl;
    }

    public ITelTextFactory getTextFactory() {
        return this.textFactory;
    }

    public IEmergencyTextFactory geEmergencyTextFactory() {
        return this.koreaEmergencyTextFactory;
    }

    public ITelDialSuppServiceHandler getDialSuppServiceHandler() {
        return this.dialSuppServiceHandler;
    }

    public ITelAudio getAudio() {
        return this.audio;
    }

    public ITelEPMHandler getEPMHandler() {
        return this.enhancedPrivacyModeHandler.getResponseListener();
    }

    public ITelIntellicallHandler getIntellicallHandler() {
        return this.intellicallHandler;
    }

    public ITelBluetoothHandler getBluetoothHandler() {
        return this.bluetoothHandler;
    }

    public ITelDSIResponseErrorHandler getDSIDefaultResponseErrorHandler() {
        return this.dsiResponseErrorHandler;
    }

    public LogChannel getLogChannel(String string) {
        return this.getFrameworkAccess().getLogChannel(string);
    }

    public IEntertainmentDrawerControllerNew getNewEntertainmentDrawerController() {
        return this.newEntertainmentDrawerController;
    }
}

