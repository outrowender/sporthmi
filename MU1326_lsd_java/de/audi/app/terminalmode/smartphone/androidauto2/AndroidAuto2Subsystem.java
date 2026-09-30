/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.androidauto2;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITMDeviceSubsystem;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.SmartphoneManager;
import de.audi.app.terminalmode.dsi.IDSIControllerStateListener;
import de.audi.app.terminalmode.dsi.androidauto2.DSIAndroidAuto2DSIController;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent;
import de.audi.app.terminalmode.keyevents.ITerminalModeDSIKeyEventsController;
import de.audi.app.terminalmode.keyevents.TMKeyEventsHandler;
import de.audi.app.terminalmode.smartphone.androidauto2.AndroidAuto2DSIManager;
import de.audi.app.terminalmode.smartphone.androidauto2.AndroidAuto2EventListener;
import de.audi.app.terminalmode.smartphone.androidauto2.AndroidAuto2ListenerDistributor;
import de.audi.app.terminalmode.smartphone.androidauto2.AndroidAuto2RequestHandler;
import de.audi.app.terminalmode.smartphone.androidauto2.audio.AndroidAuto2AudioHandler;
import de.audi.app.terminalmode.smartphone.androidauto2.mic.AndroidAuto2MicHandler;
import de.audi.app.terminalmode.smartphone.androidauto2.nav.AndroidAuto2NavHandler;
import de.audi.app.terminalmode.smartphone.androidauto2.video.AndroidAuto2VideoHandler;
import de.audi.app.terminalmode.smartphone.androidauto2.voice.AndroidAuto2VoiceSessionHandler;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.app.terminalmode.statemachine.ApplicationStateChange;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateChange;
import de.audi.app.terminalmode.statemachine.IStateChangeAction;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.ResourceOwnerChange;
import de.audi.app.terminalmode.statemachine.ResourceState;
import de.audi.app.terminalmode.statemachine.ResourceStateChange;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.RequestModeChange;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.ReflectionUtils;
import de.audi.atip.utils.generics.GMap;
import de.audi.atip.utils.generics.Generics;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.androidauto2.DSIAndroidAuto2;
import org.dsi.ifc.androidauto2.DSIAndroidAuto2Listener;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class AndroidAuto2Subsystem
implements ITMDeviceSubsystem,
ITerminalModeComponent,
IDSIControllerStateListener {
    private static final String LOGCLASS = ReflectionUtils.getSimpleName(class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2Subsystem == null ? (class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2Subsystem = AndroidAuto2Subsystem.class$("de.audi.app.terminalmode.smartphone.androidauto2.AndroidAuto2Subsystem")) : class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2Subsystem);
    private final ITerminalModeDSIKeyEventsController keyEventController;
    private final DSIAndroidAuto2DSIController dsiController;
    private final LogChannel logger;
    private final TMKeyEventsHandler keyEventsHandler;
    private final IContext context;
    private final AndroidAuto2DSIManager androidAuto2DSIManager;
    private final SmartphoneManager smartphoneManagerListener;
    private volatile boolean active;
    private volatile boolean dsiAvailable;
    private final IStateHandler stateHandler;
    private final DSIAndroidAuto2 dsiAndroidAuto2;
    private final IEventBus eventBus;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2Subsystem;

    public AndroidAuto2Subsystem(ITerminalModeDSIKeyEventsController iTerminalModeDSIKeyEventsController, DSIAndroidAuto2DSIController dSIAndroidAuto2DSIController, LogChannel logChannel, IContext iContext, SmartphoneManager smartphoneManager, AndroidAuto2ListenerDistributor androidAuto2ListenerDistributor, AndroidAuto2RequestHandler androidAuto2RequestHandler, AndroidAuto2EventListener androidAuto2EventListener, IStateHandler iStateHandler, AndroidAuto2AudioHandler androidAuto2AudioHandler, AndroidAuto2MicHandler androidAuto2MicHandler, AndroidAuto2NavHandler androidAuto2NavHandler, AndroidAuto2VideoHandler androidAuto2VideoHandler, AndroidAuto2VoiceSessionHandler androidAuto2VoiceSessionHandler, AndroidAuto2DSIManager androidAuto2DSIManager, IEventBus iEventBus, DSIAndroidAuto2 dSIAndroidAuto2) {
        this.keyEventController = iTerminalModeDSIKeyEventsController;
        this.dsiController = dSIAndroidAuto2DSIController;
        this.logger = logChannel;
        this.context = iContext;
        this.smartphoneManagerListener = smartphoneManager;
        this.keyEventsHandler = iContext.getKeyEventsHandler();
        this.eventBus = iEventBus;
        this.dsiAndroidAuto2 = dSIAndroidAuto2;
        this.androidAuto2DSIManager = androidAuto2DSIManager;
        androidAuto2ListenerDistributor.addListener(new DSIAndroidAuto2Listener[]{androidAuto2RequestHandler, androidAuto2EventListener, androidAuto2AudioHandler, androidAuto2MicHandler, androidAuto2NavHandler, androidAuto2VideoHandler, androidAuto2VoiceSessionHandler});
        this.stateHandler = iStateHandler;
    }

    @Override
    public void init() {
        this.dsiController.init();
        this.dsiController.setStateListener(this);
    }

    @Override
    public void deinit() {
        this.dsiController.deinit();
    }

    @Override
    public void activate() {
        if (this.active) {
            this.logger.log(1000000, "[%1.activate] Already active.", (Object)LOGCLASS);
            return;
        }
        this.active = true;
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
        this.keyEventsHandler.setDSIKeyEventController(this.keyEventController);
        this.context.getTMKeyEventController().setDSIKeyEventController(this.keyEventController);
        if (this.isDsiAvailable()) {
            this.smartphoneManagerListener.updateDSIState(true);
        }
        this.androidAuto2DSIManager.activate();
        GMap<IStateChange, IStateChangeAction.IStateChangeActionOverride> gMap = Generics.newHashMap();
        gMap.put(new ResourceOwnerChange(Resource.NOTIFICATION, ResourceOwner.DEVICE, ResourceOwner.MAINUNIT), new IStateChangeAction.AbstractStateChangeActionOverride(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                AndroidAuto2Subsystem.this.logger.log(1000000, "[%1.changeState] Notification: MU", (Object)LOGCLASS);
                AndroidAuto2Subsystem.this.context.getChoiceModel(3200012).setValue(1);
            }
        });
        gMap.put(new ResourceOwnerChange(Resource.NOTIFICATION, ResourceOwner.MAINUNIT, ResourceOwner.DEVICE), new IStateChangeAction.AbstractStateChangeActionOverride(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                AndroidAuto2Subsystem.this.logger.log(1000000, "[%1.changeState] Notification: Device", (Object)LOGCLASS);
                AndroidAuto2Subsystem.this.context.getChoiceModel(3200012).setValue(0);
            }
        });
        gMap.put(new ResourceStateChange(Resource.AUDIO_MEDIA, ResourceState.NORMAL, ResourceState.PAUSED), new IStateChangeAction.AbstractStateChangeActionOverride(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                AndroidAuto2Subsystem.this.logger.log(1000000, "[%1.changeState] Audio_Media: Normal -> Paused", (Object)LOGCLASS);
                AndroidAuto2Subsystem.this.dsiAndroidAuto2.postButtonEvent(127, 0);
                AndroidAuto2Subsystem.this.dsiAndroidAuto2.postButtonEvent(127, 1);
                AndroidAuto2Subsystem.this.stateHandler.setStateForResource(Resource.AUDIO_MEDIA, ResourceState.PAUSED);
                AndroidAuto2Subsystem.this.eventBus.updatePlaybackInfo(new PlaybackInfoChangedEvent(PlaybackInfoChangedEvent.PlaybackState.PAUSED));
            }
        });
        gMap.put(new ResourceStateChange(Resource.AUDIO_MEDIA, ResourceState.NORMAL, ResourceState.PAUSED_BY_MUTE), new IStateChangeAction.AbstractStateChangeActionOverride(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                AndroidAuto2Subsystem.this.logger.log(1000000, "[%1.changeState] Audio_Media: Normal -> Paused by mute", (Object)LOGCLASS);
                AndroidAuto2Subsystem.this.dsiAndroidAuto2.postButtonEvent(127, 0);
                AndroidAuto2Subsystem.this.dsiAndroidAuto2.postButtonEvent(127, 1);
                AndroidAuto2Subsystem.this.stateHandler.setStateForResource(Resource.AUDIO_MEDIA, ResourceState.PAUSED_BY_MUTE);
                AndroidAuto2Subsystem.this.eventBus.updatePlaybackInfo(new PlaybackInfoChangedEvent(PlaybackInfoChangedEvent.PlaybackState.PAUSED));
            }
        });
        gMap.put(new ResourceStateChange(Resource.AUDIO_MEDIA, ResourceState.PAUSED, ResourceState.NORMAL), new IStateChangeAction.AbstractStateChangeActionOverride(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                AndroidAuto2Subsystem.this.logger.log(1000000, "[%1.changeState] Audio_Media: Paused -> Normal", (Object)LOGCLASS);
                AndroidAuto2Subsystem.this.stateHandler.setStateForResource(Resource.AUDIO_MEDIA, ResourceState.NORMAL);
                if (tMState.isResourceOwnerDevice(Resource.AUDIO_MEDIA)) {
                    AndroidAuto2Subsystem.this.dsiAndroidAuto2.postButtonEvent(126, 0);
                    AndroidAuto2Subsystem.this.dsiAndroidAuto2.postButtonEvent(126, 1);
                    AndroidAuto2Subsystem.this.eventBus.updatePlaybackInfo(new PlaybackInfoChangedEvent(PlaybackInfoChangedEvent.PlaybackState.PLAYING));
                }
            }
        });
        gMap.put(new ResourceStateChange(Resource.AUDIO_MEDIA, ResourceState.PAUSED_BY_MUTE, ResourceState.NORMAL), new IStateChangeAction.AbstractStateChangeActionOverride(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                AndroidAuto2Subsystem.this.logger.log(1000000, "[%1.changeState] Audio_Media: Paused_by_mute -> Normal", (Object)LOGCLASS);
                AndroidAuto2Subsystem.this.stateHandler.setStateForResource(Resource.AUDIO_MEDIA, ResourceState.NORMAL);
                if (tMState.isResourceOwnerDevice(Resource.AUDIO_MEDIA)) {
                    AndroidAuto2Subsystem.this.dsiAndroidAuto2.postButtonEvent(126, 0);
                    AndroidAuto2Subsystem.this.dsiAndroidAuto2.postButtonEvent(126, 1);
                    AndroidAuto2Subsystem.this.eventBus.updatePlaybackInfo(new PlaybackInfoChangedEvent(PlaybackInfoChangedEvent.PlaybackState.PLAYING));
                }
            }
        });
        this.addRequestModeChanges(gMap);
        this.stateHandler.addStateChangeActions(gMap);
    }

    private void addRequestModeChanges(GMap<IStateChange, IStateChangeAction.IStateChangeActionOverride> gMap) {
        gMap.put(new ResourceOwnerChange(Resource.SCREEN, ResourceOwner.MAINUNIT, ResourceOwner.DEVICE), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                AndroidAuto2Subsystem.this.logger.log(1000000, "[%1.changeState] Screen: MU -> Device", (Object)LOGCLASS);
                if (IRequestor.DEVICE.isNot(iRequestor)) {
                    commandList.add(new RequestModeChange(AndroidAuto2Subsystem.this.context, tMState, l, AndroidAuto2Subsystem.this.stateHandler));
                }
            }
        });
        gMap.put(new ResourceOwnerChange(Resource.SCREEN, ResourceOwner.DEVICE, ResourceOwner.MAINUNIT), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                AndroidAuto2Subsystem.this.logger.log(1000000, "[%1.changeState] Screen: Device -> MU", (Object)LOGCLASS);
                if (!iRequestor.isOneOf(IRequestor.DEVICE, IRequestor.DEVICE_WHILE_DISCONNECTING) && !AndroidAuto2Subsystem.this.stateHandler.getCurrentState().isAccessRestricted(Resource.SCREEN)) {
                    commandList.add(new RequestModeChange(AndroidAuto2Subsystem.this.context, tMState, l, AndroidAuto2Subsystem.this.stateHandler));
                }
            }
        });
        gMap.put(new ResourceOwnerChange(Resource.AUDIO_MEDIA, ResourceOwner.DEVICE, ResourceOwner.MAINUNIT), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                AndroidAuto2Subsystem.this.logger.log(1000000, "[%1.changeState] audio media: device -> MU", (Object)LOGCLASS);
                if (iRequestor.is(IRequestor.MAINUNIT)) {
                    commandList.add(new RequestModeChange(AndroidAuto2Subsystem.this.context, tMState, l, AndroidAuto2Subsystem.this.stateHandler));
                }
            }
        });
        gMap.put(new ApplicationStateChange(Application.SPEECH, ApplicationOwner.DEVICE, ApplicationOwner.NOBODY), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                AndroidAuto2Subsystem.this.logger.log(1000000, "[%1.changeState] speech: device -> nobody", (Object)LOGCLASS);
                if (iRequestor.is(IRequestor.MAINUNIT)) {
                    commandList.add(new RequestModeChange(AndroidAuto2Subsystem.this.context, tMState, -1L, AndroidAuto2Subsystem.this.stateHandler));
                }
            }
        });
        gMap.put(new ApplicationStateChange(Application.SPEECH, ApplicationOwner.NOBODY, ApplicationOwner.MAINUNIT), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                AndroidAuto2Subsystem.this.logger.log(1000000, "[%1.changeState] speech: nobody -> mainunit", (Object)LOGCLASS);
                if (iRequestor.is(IRequestor.MAINUNIT)) {
                    commandList.add(new RequestModeChange(AndroidAuto2Subsystem.this.context, tMState, l, AndroidAuto2Subsystem.this.stateHandler));
                }
            }
        });
        gMap.put(new ApplicationStateChange(Application.SPEECH, ApplicationOwner.MAINUNIT, ApplicationOwner.NOBODY), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                AndroidAuto2Subsystem.this.logger.log(1000000, "[%1.changeState] speech: mainunit -> nobody", (Object)LOGCLASS);
                if (iRequestor.is(IRequestor.MAINUNIT)) {
                    commandList.add(new RequestModeChange(AndroidAuto2Subsystem.this.context, tMState, l, AndroidAuto2Subsystem.this.stateHandler));
                }
            }
        });
        gMap.put(new ApplicationStateChange(Application.NAVI, ApplicationOwner.DEVICE, ApplicationOwner.MAINUNIT), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                AndroidAuto2Subsystem.this.logger.log(1000000, "[%1.changeState] Navi: Device -> MU", (Object)LOGCLASS);
                if (iRequestor.is(IRequestor.MAINUNIT)) {
                    commandList.add(new RequestModeChange(AndroidAuto2Subsystem.this.context, tMState, l, AndroidAuto2Subsystem.this.stateHandler));
                }
            }
        });
        gMap.put(new ApplicationStateChange(Application.NAVI, ApplicationOwner.NOBODY, ApplicationOwner.MAINUNIT), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                AndroidAuto2Subsystem.this.logger.log(1000000, "[%1.changeState] Navi: Nobody -> MU", (Object)LOGCLASS);
                if (iRequestor.is(IRequestor.MAINUNIT)) {
                    commandList.add(new RequestModeChange(AndroidAuto2Subsystem.this.context, tMState, l, AndroidAuto2Subsystem.this.stateHandler));
                }
            }
        });
        gMap.put(new ApplicationStateChange(Application.NAVI, ApplicationOwner.MAINUNIT, ApplicationOwner.NOBODY), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                AndroidAuto2Subsystem.this.logger.log(1000000, "[%1.changeState] Navi: Mainunit -> Nobody", (Object)LOGCLASS);
                if (IRequestor.MAINUNIT == iRequestor) {
                    commandList.add(new RequestModeChange(AndroidAuto2Subsystem.this.context, tMState, l, AndroidAuto2Subsystem.this.stateHandler));
                }
            }
        });
    }

    @Override
    public void deactivate() {
        if (!this.active) {
            this.logger.log(1000000, "[%1.deactivate] Mgr is not active.", (Object)LOGCLASS);
            return;
        }
        this.logger.log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.stateHandler.removeStateChangeActions();
        this.androidAuto2DSIManager.deactivate();
        this.active = false;
        this.smartphoneManagerListener.updateDSIState(false);
    }

    @Override
    public final void dsiUnavailable() {
        this.logger.log(1000000, "[%1.dsiUnavailable]", (Object)LOGCLASS);
        this.dsiAvailable = false;
        this.smartphoneManagerListener.updateDSIState(false);
    }

    @Override
    public final void dsiAvailable() {
        this.logger.log(1000000, "[%1.dsiAvailable]", (Object)LOGCLASS);
        this.dsiAvailable = true;
        if (this.active) {
            this.smartphoneManagerListener.updateDSIState(true);
        }
    }

    protected final boolean isDsiAvailable() {
        return this.dsiAvailable;
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

