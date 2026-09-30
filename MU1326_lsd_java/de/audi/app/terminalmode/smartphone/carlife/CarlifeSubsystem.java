/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITMDeviceSubsystem;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.SmartphoneManager;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.dsi.IDSIControllerStateListener;
import de.audi.app.terminalmode.dsi.carlife.CarlifeDSIController;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent;
import de.audi.app.terminalmode.keyevents.ITerminalModeDSIKeyEventsController;
import de.audi.app.terminalmode.keyevents.TMKeyEventsHandler;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIManager;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeEventListener;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeListenerDistributor;
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
import de.audi.app.terminalmode.statemachine.commands.ReleaseAudioConnection;
import de.audi.app.terminalmode.statemachine.commands.RequestAudioConnectionWithDuration;
import de.audi.app.terminalmode.statemachine.commands.RequestModeChange;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.generics.GMap;
import de.audi.atip.utils.generics.Generics;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.carlife.DSICarlife;
import org.dsi.ifc.carlife.DSICarlifeListener;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class CarlifeSubsystem
implements ITMDeviceSubsystem,
ITerminalModeComponent,
IDSIControllerStateListener {
    private static final String LOGCLASS = "CarlifeSubsystem";
    private static final int CARLIFE_APP_NOT_INSTALLED = 2;
    protected static final int LOWERING_DURATION = 500;
    private final ITerminalModeDSIKeyEventsController keyEventController;
    private final CarlifeDSIController dsiController;
    private final LogChannel logger;
    private final TMKeyEventsHandler keyEventsHandler;
    private final IContext context;
    private final CarlifeDSIManager carlifeDSIManager;
    private final SmartphoneManager smartphoneManagerListener;
    private volatile boolean active;
    private volatile boolean dsiAvailable;
    private final IStateHandler stateHandler;
    private final DSICarlife dsiCarlife;
    private final IEventBus eventBus;

    public CarlifeSubsystem(ITerminalModeDSIKeyEventsController iTerminalModeDSIKeyEventsController, CarlifeDSIController carlifeDSIController, LogChannel logChannel, IContext iContext, SmartphoneManager smartphoneManager, CarlifeListenerDistributor carlifeListenerDistributor, CarlifeEventListener carlifeEventListener, IStateHandler iStateHandler, CarlifeDSIManager carlifeDSIManager, IEventBus iEventBus, DSICarlife dSICarlife) {
        this.keyEventController = iTerminalModeDSIKeyEventsController;
        this.dsiController = carlifeDSIController;
        this.logger = logChannel;
        this.context = iContext;
        this.smartphoneManagerListener = smartphoneManager;
        this.keyEventsHandler = this.context.getKeyEventsHandler();
        this.eventBus = iEventBus;
        this.dsiCarlife = dSICarlife;
        this.carlifeDSIManager = carlifeDSIManager;
        this.stateHandler = iStateHandler;
        carlifeListenerDistributor.addListener(new DSICarlifeListener[]{carlifeEventListener});
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
        this.carlifeDSIManager.activate();
        GMap<IStateChange, IStateChangeAction.IStateChangeActionOverride> gMap = Generics.newHashMap();
        gMap.put(new ResourceOwnerChange(Resource.NOTIFICATION, ResourceOwner.DEVICE, ResourceOwner.MAINUNIT), new IStateChangeAction.AbstractStateChangeActionOverride(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarlifeSubsystem.this.logger.log(1000000, "[%1.changeState] Notification: MU", (Object)CarlifeSubsystem.LOGCLASS);
                CarlifeSubsystem.this.context.getChoiceModel(3200012).setValue(2);
            }
        });
        gMap.put(new ResourceOwnerChange(Resource.NOTIFICATION, ResourceOwner.MAINUNIT, ResourceOwner.DEVICE), new IStateChangeAction.AbstractStateChangeActionOverride(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarlifeSubsystem.this.logger.log(1000000, "[%1.changeState] Notification: Device", (Object)CarlifeSubsystem.LOGCLASS);
                CarlifeSubsystem.this.context.getChoiceModel(3200012).setValue(0);
            }
        });
        gMap.put(new ResourceStateChange(Resource.AUDIO_MEDIA, ResourceState.NORMAL, ResourceState.PAUSED), new IStateChangeAction.AbstractStateChangeActionOverride(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarlifeSubsystem.this.logger.log(1000000, "[%1.changeState] Audio_Media: Normal -> Paused", (Object)CarlifeSubsystem.LOGCLASS);
                CarlifeSubsystem.this.dsiCarlife.postButtonEvent(19, 0);
                CarlifeSubsystem.this.dsiCarlife.postButtonEvent(19, 1);
                CarlifeSubsystem.this.stateHandler.setStateForResource(Resource.AUDIO_MEDIA, ResourceState.PAUSED);
                CarlifeSubsystem.this.eventBus.updatePlaybackInfo(new PlaybackInfoChangedEvent(PlaybackInfoChangedEvent.PlaybackState.PAUSED));
            }
        });
        gMap.put(new ResourceStateChange(Resource.AUDIO_MEDIA, ResourceState.NORMAL, ResourceState.PAUSED_BY_MUTE), new IStateChangeAction.AbstractStateChangeActionOverride(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarlifeSubsystem.this.logger.log(1000000, "[%1.changeState] Audio_Media: Normal -> Paused by mute", (Object)CarlifeSubsystem.LOGCLASS);
                CarlifeSubsystem.this.dsiCarlife.postButtonEvent(19, 0);
                CarlifeSubsystem.this.dsiCarlife.postButtonEvent(19, 1);
                CarlifeSubsystem.this.stateHandler.setStateForResource(Resource.AUDIO_MEDIA, ResourceState.PAUSED_BY_MUTE);
                CarlifeSubsystem.this.eventBus.updatePlaybackInfo(new PlaybackInfoChangedEvent(PlaybackInfoChangedEvent.PlaybackState.PAUSED));
            }
        });
        gMap.put(new ResourceStateChange(Resource.AUDIO_MEDIA, ResourceState.PAUSED, ResourceState.NORMAL), new IStateChangeAction.AbstractStateChangeActionOverride(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarlifeSubsystem.this.logger.log(1000000, "[%1.changeState] Audio_Media: Paused -> Normal", (Object)CarlifeSubsystem.LOGCLASS);
                if (tMState.getOwnerForResource(Resource.AUDIO_MEDIA).is(ResourceOwner.DEVICE)) {
                    CarlifeSubsystem.this.dsiCarlife.postButtonEvent(18, 0);
                    CarlifeSubsystem.this.dsiCarlife.postButtonEvent(18, 1);
                    CarlifeSubsystem.this.stateHandler.setStateForResource(Resource.AUDIO_MEDIA, ResourceState.NORMAL);
                    CarlifeSubsystem.this.eventBus.updatePlaybackInfo(new PlaybackInfoChangedEvent(PlaybackInfoChangedEvent.PlaybackState.PLAYING));
                }
            }
        });
        gMap.put(new ResourceStateChange(Resource.AUDIO_MEDIA, ResourceState.PAUSED_BY_MUTE, ResourceState.NORMAL), new IStateChangeAction.AbstractStateChangeActionOverride(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarlifeSubsystem.this.logger.log(1000000, "[%1.changeState] Audio_Media: Paused_by_mute -> Normal", (Object)CarlifeSubsystem.LOGCLASS);
                if (tMState.getOwnerForResource(Resource.AUDIO_MEDIA).is(ResourceOwner.DEVICE)) {
                    CarlifeSubsystem.this.dsiCarlife.postButtonEvent(18, 0);
                    CarlifeSubsystem.this.dsiCarlife.postButtonEvent(18, 1);
                    CarlifeSubsystem.this.stateHandler.setStateForResource(Resource.AUDIO_MEDIA, ResourceState.NORMAL);
                    CarlifeSubsystem.this.eventBus.updatePlaybackInfo(new PlaybackInfoChangedEvent(PlaybackInfoChangedEvent.PlaybackState.PLAYING));
                }
            }
        });
        this.addRequestModeChanges(gMap);
        this.stateHandler.addStateChangeActions(gMap);
    }

    private void addRequestModeChanges(GMap<IStateChange, IStateChangeAction.IStateChangeActionOverride> gMap) {
        gMap.put(new ResourceOwnerChange(Resource.SCREEN, ResourceOwner.MAINUNIT, ResourceOwner.DEVICE), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarlifeSubsystem.this.logger.log(1000000, "[%1.changeState] Screen: MU -> Device", (Object)CarlifeSubsystem.LOGCLASS);
                if (IRequestor.DEVICE.isNot(iRequestor)) {
                    commandList.add(new RequestModeChange(CarlifeSubsystem.this.context, tMState, l, CarlifeSubsystem.this.stateHandler));
                }
            }
        });
        gMap.put(new ResourceOwnerChange(Resource.SCREEN, ResourceOwner.DEVICE, ResourceOwner.MAINUNIT), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarlifeSubsystem.this.logger.log(1000000, "[%1.changeState] Screen: Device -> MU", (Object)CarlifeSubsystem.LOGCLASS);
                if (!iRequestor.isOneOf(IRequestor.DEVICE, IRequestor.DEVICE_WHILE_DISCONNECTING) && !CarlifeSubsystem.this.stateHandler.getCurrentState().isAccessRestricted(Resource.SCREEN)) {
                    commandList.add(new RequestModeChange(CarlifeSubsystem.this.context, tMState, l, CarlifeSubsystem.this.stateHandler));
                }
            }
        });
        gMap.put(new ResourceOwnerChange(Resource.AUDIO_MEDIA, ResourceOwner.DEVICE, ResourceOwner.MAINUNIT), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarlifeSubsystem.this.logger.log(1000000, "[%1.changeState] audio media: device -> MU", (Object)CarlifeSubsystem.LOGCLASS);
                if (iRequestor.is(IRequestor.MAINUNIT)) {
                    commandList.add(new RequestModeChange(CarlifeSubsystem.this.context, tMState, l, CarlifeSubsystem.this.stateHandler));
                }
                CarlifeSubsystem.this.eventBus.updatePlaybackInfo(new PlaybackInfoChangedEvent(PlaybackInfoChangedEvent.PlaybackState.PAUSED));
            }
        });
        gMap.put(new ResourceOwnerChange(Resource.AUDIO_MEDIA, ResourceOwner.MAINUNIT, ResourceOwner.DEVICE), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarlifeSubsystem.this.logger.log(1000000, "[%1.changeState] audio media: device -> MU", (Object)CarlifeSubsystem.LOGCLASS);
                if (iRequestor.is(IRequestor.MAINUNIT)) {
                    commandList.add(new RequestModeChange(CarlifeSubsystem.this.context, tMState, l, CarlifeSubsystem.this.stateHandler));
                }
                CarlifeSubsystem.this.eventBus.updatePlaybackInfo(new PlaybackInfoChangedEvent(PlaybackInfoChangedEvent.PlaybackState.PLAYING));
            }
        });
        gMap.put(new ResourceOwnerChange(Resource.AUDIO_GUIDANCE, ResourceOwner.DEVICE, ResourceOwner.MAINUNIT), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarlifeSubsystem.this.logger.log(1000000, "[%1.changeState] audio guidance: device -> MU", (Object)CarlifeSubsystem.LOGCLASS);
                commandList.add(new ReleaseAudioConnection(TMAudioConnection.LOWERING, CarlifeSubsystem.this.context));
            }
        });
        gMap.put(new ResourceOwnerChange(Resource.AUDIO_GUIDANCE, ResourceOwner.MAINUNIT, ResourceOwner.DEVICE), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarlifeSubsystem.this.logger.log(1000000, "[%1.changeState] audio guidance: MU -> device", (Object)CarlifeSubsystem.LOGCLASS);
                commandList.add(new RequestAudioConnectionWithDuration(TMAudioConnection.LOWERING, CarlifeSubsystem.this.context, 500));
            }
        });
        gMap.put(new ApplicationStateChange(Application.SPEECH, ApplicationOwner.DEVICE, ApplicationOwner.NOBODY), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarlifeSubsystem.this.logger.log(1000000, "[%1.changeState] speech: device -> nobody", (Object)CarlifeSubsystem.LOGCLASS);
                if (iRequestor.is(IRequestor.MAINUNIT)) {
                    commandList.add(new RequestModeChange(CarlifeSubsystem.this.context, tMState, -1L, CarlifeSubsystem.this.stateHandler));
                }
            }
        });
        gMap.put(new ApplicationStateChange(Application.SPEECH, ApplicationOwner.NOBODY, ApplicationOwner.MAINUNIT), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarlifeSubsystem.this.logger.log(1000000, "[%1.changeState] speech: nobody -> mainunit", (Object)CarlifeSubsystem.LOGCLASS);
                if (iRequestor.is(IRequestor.MAINUNIT)) {
                    commandList.add(new RequestModeChange(CarlifeSubsystem.this.context, tMState, l, CarlifeSubsystem.this.stateHandler));
                }
            }
        });
        gMap.put(new ApplicationStateChange(Application.SPEECH, ApplicationOwner.MAINUNIT, ApplicationOwner.NOBODY), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarlifeSubsystem.this.logger.log(1000000, "[%1.changeState] speech: mainunit -> nobody", (Object)CarlifeSubsystem.LOGCLASS);
                if (iRequestor.is(IRequestor.MAINUNIT)) {
                    commandList.add(new RequestModeChange(CarlifeSubsystem.this.context, tMState, l, CarlifeSubsystem.this.stateHandler));
                }
            }
        });
        gMap.put(new ApplicationStateChange(Application.NAVI, ApplicationOwner.DEVICE, ApplicationOwner.MAINUNIT), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarlifeSubsystem.this.logger.log(1000000, "[%1.changeState] Navi: Device -> MU", (Object)CarlifeSubsystem.LOGCLASS);
                if (iRequestor.is(IRequestor.MAINUNIT)) {
                    commandList.add(new RequestModeChange(CarlifeSubsystem.this.context, tMState, l, CarlifeSubsystem.this.stateHandler));
                }
            }
        });
        gMap.put(new ApplicationStateChange(Application.NAVI, ApplicationOwner.NOBODY, ApplicationOwner.MAINUNIT), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarlifeSubsystem.this.logger.log(1000000, "[%1.changeState] Navi: Nobody -> MU", (Object)CarlifeSubsystem.LOGCLASS);
                if (iRequestor.is(IRequestor.MAINUNIT)) {
                    commandList.add(new RequestModeChange(CarlifeSubsystem.this.context, tMState, l, CarlifeSubsystem.this.stateHandler));
                }
            }
        });
        gMap.put(new ApplicationStateChange(Application.NAVI, ApplicationOwner.MAINUNIT, ApplicationOwner.NOBODY), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarlifeSubsystem.this.logger.log(1000000, "[%1.changeState] Navi: Mainunit -> Nobody", (Object)CarlifeSubsystem.LOGCLASS);
                if (IRequestor.MAINUNIT == iRequestor) {
                    commandList.add(new RequestModeChange(CarlifeSubsystem.this.context, tMState, l, CarlifeSubsystem.this.stateHandler));
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
        this.carlifeDSIManager.deactivate();
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
}

