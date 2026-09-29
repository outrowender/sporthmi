/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.audio.IAudioManager
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.androidauto2;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.INightDayModeHandler;
import de.audi.app.terminalmode.ITerminalModeConfiguration;
import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.audio.IAudioManager;
import de.audi.app.terminalmode.audio.IAudioStateListener;
import de.audi.app.terminalmode.device.IActiveDeviceStateListener;
import de.audi.app.terminalmode.device.IDeviceManager;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.device.TMDevice$ConnectionState;
import de.audi.app.terminalmode.dsi.IDSIAppState;
import de.audi.app.terminalmode.dsi.androidauto2.IDSIAndroidAuto2TransferObjectFactory;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.app.terminalmode.events.IEventListener;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent$PlaybackState;
import de.audi.app.terminalmode.smartphone.AbstractDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.AbstractDSISmartphoneManager$MediaChannelState;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager$ISmartphoneProperties;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager$RequestModeChangeCallback;
import de.audi.app.terminalmode.smartphone.IPhoneCallController;
import de.audi.app.terminalmode.smartphone.IPlayerModificationListener;
import de.audi.app.terminalmode.smartphone.ISpeechRequestHandler;
import de.audi.app.terminalmode.smartphone.androidauto2.AndroidAuto2DSIManager$1;
import de.audi.app.terminalmode.smartphone.androidauto2.AndroidAuto2DSIManager$2;
import de.audi.app.terminalmode.smartphone.androidauto2.AndroidAuto2DSIManager$AndroidAuto2EventListener;
import de.audi.app.terminalmode.smartphone.androidauto2.AndroidAuto2DSIManager$AudioStateListener;
import de.audi.app.terminalmode.smartphone.androidauto2.IAndroidAuto2RequestHandler;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.androidauto2.DSIAndroidAuto2;
import org.dsi.ifc.androidauto2.ServiceConfiguration;

public class AndroidAuto2DSIManager
extends AbstractDSISmartphoneManager
implements IDSISmartphoneManager,
IPlayerModificationListener,
IActiveDeviceStateListener {
    private static final String LOGCLASS;
    private final DSIAndroidAuto2 dsi;
    private final ISpeechRequestHandler speechRequestHandler;
    private final AndroidAuto2DSIManager$AudioStateListener audioStateListener;
    private final IDSIAndroidAuto2TransferObjectFactory transferObjectFactory;
    private final ITerminalModeConfiguration configuration;
    private final INightDayModeHandler nightModeHandler;
    private final IPhoneCallController phoneCallController;
    private final IAndroidAuto2RequestHandler requestHandler;
    private final LogChannel lc;
    private final SmartphoneManager$SmartphoneType smartphoneType;
    protected volatile AbstractDSISmartphoneManager$MediaChannelState mediaState;
    private final IAudioManager audioMananger;
    private final IStateHandler stateHandler;
    private final IEventBus eventBus;
    private final IEventListener eventListener;
    private final IDeviceManager deviceManager;
    private volatile TMState currentState;
    static /* synthetic */ Class class$de$audi$app$terminalmode$statemachine$IStateHandler;

    public AndroidAuto2DSIManager(DSIAndroidAuto2 dSIAndroidAuto2, IDSIAndroidAuto2TransferObjectFactory iDSIAndroidAuto2TransferObjectFactory, ITerminalModeConfiguration iTerminalModeConfiguration, INightDayModeHandler iNightDayModeHandler, IAndroidAuto2RequestHandler iAndroidAuto2RequestHandler, SmartphoneManager$SmartphoneType smartphoneManager$SmartphoneType, IAudioManager iAudioManager, LogChannel logChannel, IContext iContext, IEventBus iEventBus, IDeviceManager iDeviceManager) {
        super(iContext, smartphoneManager$SmartphoneType);
        this.dsi = dSIAndroidAuto2;
        this.transferObjectFactory = iDSIAndroidAuto2TransferObjectFactory;
        this.configuration = iTerminalModeConfiguration;
        this.nightModeHandler = iNightDayModeHandler;
        this.requestHandler = iAndroidAuto2RequestHandler;
        this.smartphoneType = smartphoneManager$SmartphoneType;
        this.audioMananger = iAudioManager;
        this.deviceManager = iDeviceManager;
        this.stateHandler = (IStateHandler)iContext.get(class$de$audi$app$terminalmode$statemachine$IStateHandler == null ? (class$de$audi$app$terminalmode$statemachine$IStateHandler = AndroidAuto2DSIManager.class$("de.audi.app.terminalmode.statemachine.IStateHandler")) : class$de$audi$app$terminalmode$statemachine$IStateHandler);
        this.eventListener = new AndroidAuto2DSIManager$AndroidAuto2EventListener(this, null);
        this.lc = logChannel;
        this.eventBus = iEventBus;
        this.speechRequestHandler = new AndroidAuto2DSIManager$1(this);
        this.phoneCallController = new AndroidAuto2DSIManager$2(this);
        this.audioStateListener = new AndroidAuto2DSIManager$AudioStateListener(this, null);
        this.mediaState = this.NORMAL;
    }

    @Override
    public void activate() {
        this.logger.log(1078071040, "[%1.activate]", (Object)"AndroidAuto2DSIManager");
        this.audioMananger.addAudioContextListener((IAudioStateListener)this.audioStateListener);
        this.eventBus.registerListener(this.eventListener);
    }

    @Override
    public void deactivate() {
        this.audioMananger.removeAudioContextListener((IAudioStateListener)this.audioStateListener);
        this.eventBus.unregisterListener(this.eventListener);
    }

    @Override
    public void startService(TMState tMState) {
        ServiceConfiguration serviceConfiguration = this.transferObjectFactory.createServiceConfiguration();
        serviceConfiguration.displayResolutionX = this.configuration.getScreenResolutionX();
        serviceConfiguration.displayResolutionY = this.configuration.getScreenResolutionY();
        serviceConfiguration.driverPosition = this.configuration.isRightHandDrive() ? 1 : 0;
        serviceConfiguration.touchpadAvailable = this.configuration.hasTouchpad();
        serviceConfiguration.touchpadResolutionX = this.configuration.getTouchPadResolutionX();
        serviceConfiguration.touchpadResolutionY = this.configuration.getTouchPadResolutionY();
        serviceConfiguration.touchscreenAvailable = this.configuration.hasTouchscreen();
        serviceConfiguration.touchscreenResolutionX = this.configuration.getScreenResolutionX();
        serviceConfiguration.touchscreenResolutionY = this.configuration.getScreenResolutionY();
        serviceConfiguration.physicalDisplayHeight = this.configuration.getPhysicalDisplayHeight();
        serviceConfiguration.physicalDisplayWidth = this.configuration.getPhysicalDisplayWidth();
        serviceConfiguration.rotaryControllerAvailable = this.configuration.hasKnob();
        serviceConfiguration.externalBluetoothPairing = false;
        serviceConfiguration.pairingAnnoncement = this.transferObjectFactory.createBluetoothServiceAnnouncement();
        if (this.configuration.getScreenOffsetX() != 0 || this.configuration.getScreenOffsetY() != 0) {
            serviceConfiguration.windowOffsetX = this.configuration.getScreenOffsetX();
            serviceConfiguration.windowOffsetY = this.configuration.getScreenOffsetY();
            serviceConfiguration.windowResolutionX = this.configuration.getWindowResolutionX();
            serviceConfiguration.windowResolutionY = this.configuration.getWindowResolutionY();
        }
        this.dsi.startService(serviceConfiguration);
        this.currentState = tMState;
        this.deviceManager.addActiveDeviceListener(this);
    }

    @Override
    public void updateActiveDeviceState(TMDevice tMDevice) {
        if (TMDevice$ConnectionState.ACTIVE.is(tMDevice.connectionState())) {
            this.logger.log(1078071040, "[%1.updateActiveDeviceState] Update the night flag", (Object)"AndroidAuto2DSIManager");
            this.dsi.setNightMode(this.nightModeHandler.getRequestedNightMode());
            this.requestModeChange(this.currentState, "startService", null);
            this.deviceManager.removeActiveDeviceListener(this);
        }
    }

    @Override
    public void skip(boolean bl, int n) {
        for (int i2 = 0; i2 < n; ++i2) {
            this.toggleButton(bl ? 87 : 88);
        }
    }

    @Override
    public void seek(boolean bl, boolean bl2) {
        int n = bl ? 90 : 89;
        int n2 = bl2 ? 0 : 1;
        this.dsi.postButtonEvent(n, n2);
    }

    @Override
    public void resume() {
        if (this.mediaState.is(new AbstractDSISmartphoneManager$MediaChannelState[]{this.PAUSE, this.PAUSED_BY_MUTE})) {
            this.toggleButton(126);
            this.mediaState = this.NORMAL;
            this.eventBus.updatePlaybackInfo(new PlaybackInfoChangedEvent(PlaybackInfoChangedEvent$PlaybackState.PLAYING));
        }
    }

    @Override
    public void pause(boolean bl) {
        this.toggleButton(127);
        this.mediaState = bl ? this.PAUSED_BY_MUTE : this.PAUSE;
        this.eventBus.updatePlaybackInfo(new PlaybackInfoChangedEvent(PlaybackInfoChangedEvent$PlaybackState.PAUSED));
    }

    @Override
    public void requestNightMode(boolean bl) {
        this.dsi.setNightMode(bl);
    }

    @Override
    public void responseUpdateMode(TMState tMState, long l) {
        this.requestHandler.responseUpdateMode(tMState, l);
    }

    @Override
    public void requestModeChange(TMState tMState, String string, IDSISmartphoneManager$RequestModeChangeCallback iDSISmartphoneManager$RequestModeChangeCallback) {
        this.requestHandler.requestModeChange(tMState, string, iDSISmartphoneManager$RequestModeChangeCallback);
    }

    @Override
    public ISpeechRequestHandler getSpeechRequestHandler() {
        return this.speechRequestHandler;
    }

    @Override
    public IPhoneCallController getPhoneCallController() {
        return this.phoneCallController;
    }

    private void toggleButton(int n) {
        this.dsi.postButtonEvent(n, 0);
        this.dsi.postButtonEvent(n, 1);
    }

    @Override
    public IDSISmartphoneManager$ISmartphoneProperties getSmartphoneProperties() {
        return null;
    }

    @Override
    public void requestConstraintsChange(TMState tMState, Resource resource, boolean bl) {
    }

    @Override
    protected IDSIAppState createAppState(int n, int n2, int n3) {
        return null;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ void access$100(AndroidAuto2DSIManager androidAuto2DSIManager, int n) {
        androidAuto2DSIManager.toggleButton(n);
    }

    static /* synthetic */ LogChannel access$300(AndroidAuto2DSIManager androidAuto2DSIManager) {
        return androidAuto2DSIManager.lc;
    }

    static /* synthetic */ AbstractDSISmartphoneManager$MediaChannelState access$400(AndroidAuto2DSIManager androidAuto2DSIManager) {
        return androidAuto2DSIManager.NORMAL;
    }

    static /* synthetic */ IStateHandler access$500(AndroidAuto2DSIManager androidAuto2DSIManager) {
        return androidAuto2DSIManager.stateHandler;
    }

    static /* synthetic */ IAudioManager access$600(AndroidAuto2DSIManager androidAuto2DSIManager) {
        return androidAuto2DSIManager.audioMananger;
    }

    static /* synthetic */ IEventBus access$700(AndroidAuto2DSIManager androidAuto2DSIManager) {
        return androidAuto2DSIManager.eventBus;
    }
}

