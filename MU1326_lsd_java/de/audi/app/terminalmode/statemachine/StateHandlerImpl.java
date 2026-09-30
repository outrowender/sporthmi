/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.audio.IAudioConnectionHandle;
import de.audi.app.terminalmode.audio.IAudioManager;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.terminalmode.diagnosis.IDiagnosisDataProvider;
import de.audi.app.terminalmode.dsi.IAppState;
import de.audi.app.terminalmode.dsi.IResource;
import de.audi.app.terminalmode.statemachine.AbstractStateChange;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.app.terminalmode.statemachine.ApplicationStateChange;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateChange;
import de.audi.app.terminalmode.statemachine.IStateChangeAction;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.ITMStateListener;
import de.audi.app.terminalmode.statemachine.LogOldAndNewState;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.ResourceOwnerChange;
import de.audi.app.terminalmode.statemachine.ResourceState;
import de.audi.app.terminalmode.statemachine.ResourceStateChange;
import de.audi.app.terminalmode.statemachine.SpeechMode;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.ReleaseAudioConnection;
import de.audi.app.terminalmode.statemachine.commands.ReleaseAudioFocus;
import de.audi.app.terminalmode.statemachine.commands.RequestAudioFocus;
import de.audi.app.terminalmode.statemachine.commands.RequestConstraintsChange;
import de.audi.app.terminalmode.statemachine.commands.RestoreHMIScreen;
import de.audi.app.terminalmode.statemachine.commands.ScreenChange;
import de.audi.app.terminalmode.statemachine.commands.StopNaviRouteGuidance;
import de.audi.app.terminalmode.statemachine.commands.UpdateMainunitState;
import de.audi.app.terminalmode.statemachine.commands.UpdatePhoneHMI;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.generics.GCopyOnWriteList;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.GMap;
import de.audi.atip.utils.generics.GSet;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.reactive.properties.LoggingPropertyFactory;
import de.audi.atip.utils.reactive.properties.Property;
import de.audi.atip.utils.reactive.properties.ReadOnlyProperty;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.esolutions.fw.util.commons.Buffer;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class StateHandlerImpl
implements IStateHandler,
IDiagnosisDataProvider,
IDiagnosisCommandProvider,
ITerminalModeComponent {
    private static final String LOGCLASS = "StateHandlerImpl";
    private final LogChannel logger;
    private final IContext context;
    private final TMState currentState;
    private final GCopyOnWriteList<ITMStateListener> stateUpdateListener;
    private final IAudioManager audioManager;
    private final Property<Boolean> serviceStarted;
    private final GMap<IStateChange, IStateChangeAction> stateChangeMap;
    private final GMap<IStateChange, IStateChangeAction.IStateChangeActionOverride> stateChangeMapOverride;
    private final LoggingPropertyFactory statePropertyFactory;
    private static final byte STATE_DUMP_MODE_OFF = 0;
    private static final byte STATE_DUMP_MODE_AFTER_COMMAND = 1;
    private static final byte STATE_DUMP_MODE_BEGIN_END_LIST = 2;
    private volatile int stateDumpMode = 0;
    private boolean lastScreenWasEntertainment;
    private static final String KEY_ADDSTATEDUMP = "addStateDump(int - 1-after each command - 2-at the begin and end of commandlist)";

    public StateHandlerImpl(IContext iContext) {
        this.logger = iContext.getLogger().hmi();
        this.context = iContext;
        this.currentState = new TMState();
        this.stateChangeMap = Generics.newHashMap();
        this.stateChangeMapOverride = Generics.newHashMap();
        this.stateUpdateListener = Generics.newCopyOnWriteArrayList();
        iContext.getDiagnosisManager().addDataProvider(0, this);
        this.statePropertyFactory = LoggingPropertyFactory.create();
        this.serviceStarted = this.statePropertyFactory.createProperty("SERVICE_STARTED");
        this.serviceStarted.accept(new Boolean(false));
        this.audioManager = iContext.getAudioManager();
        iContext.getDiagnosisManager().addDataProvider(0, new IDiagnosisDataProvider(){

            @Override
            public String getDiagValue() {
                Buffer buffer = new Buffer(1000);
                buffer.append("default states:\n");
                buffer = this.dumpMap(buffer, StateHandlerImpl.this.stateChangeMap.keySet());
                buffer.append("\n override states:\n");
                buffer = this.dumpMap(buffer, StateHandlerImpl.this.stateChangeMapOverride.keySet());
                return buffer.toString();
            }

            @Override
            public String getDiagKey() {
                return "changeActionDump";
            }

            private Buffer dumpMap(Buffer buffer, GSet<IStateChange> gSet) {
                GIterator<IStateChange> gIterator = gSet.iterator();
                while (gIterator.hasNext()) {
                    buffer.append(gIterator.next().toString());
                    buffer.append('\n');
                }
                return buffer;
            }
        });
    }

    @Override
    public void init() {
        this.logger.log(100000000, "[%1.init]", (Object)LOGCLASS);
        this.context.getDiagnosisManager().addCommandProvider(0, this);
        this.setDefaultStateChangeActions();
    }

    @Override
    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.stateUpdateListener.clear();
    }

    @Override
    public void updateStates(IAppState[] iAppStateArray, IResource[] iResourceArray) {
        this.logger.log(1000000, "[%1.updateStates]", (Object)LOGCLASS);
        this.currentState.updateCurrentAppState(iAppStateArray);
        this.currentState.updateCurrentResourceState(iResourceArray);
        this.notifyStateChanged(this.stateUpdateListener, this.getCurrentState());
    }

    @Override
    public TMState getCurrentState() {
        return new TMState(this.currentState);
    }

    @Override
    public void setOwnerForApplication(Application application, ApplicationOwner applicationOwner) {
        this.currentState.setOwnerForApplication(application, applicationOwner);
        this.notifyStateChanged(this.stateUpdateListener, this.getCurrentState());
    }

    @Override
    public void setSpeechMode(SpeechMode speechMode) {
        this.currentState.setSpeechMode(speechMode);
        this.notifyStateChanged(this.stateUpdateListener, this.getCurrentState());
    }

    @Override
    public void setOwnerForResource(Resource resource, ResourceOwner resourceOwner) {
        this.currentState.setOwnerForResource(resource, resourceOwner);
        this.notifyStateChanged(this.stateUpdateListener, this.getCurrentState());
    }

    @Override
    public void setStateForResource(Resource resource, ResourceState resourceState) {
        this.currentState.setStateForResource(resource, resourceState);
        this.notifyStateChanged(this.stateUpdateListener, this.getCurrentState());
    }

    @Override
    public CommandList changeState(TMState tMState, IRequestor iRequestor) {
        return this.changeState(tMState, iRequestor, -1L);
    }

    @Override
    public CommandList changeState(TMState tMState, IRequestor iRequestor, long l) {
        Object object;
        AbstractStateChange abstractStateChange;
        int n;
        CommandList commandList = new CommandList(this.context.getCommandListManager());
        if (2 == this.stateDumpMode && this.context.getLogger().state().isDebug()) {
            commandList.add(new LogOldAndNewState(this.context, tMState, this));
        }
        this.changeStateHighPriorityResources(tMState, iRequestor, commandList);
        if (!((Boolean)this.serviceStarted.get()).booleanValue()) {
            this.logger.log(1000000, "[%1.changeState] Service not started.", (Object)LOGCLASS);
            commandList.add(new UpdateMainunitState(tMState, this.context, this));
            return commandList;
        }
        Resource[] resourceArray = Resource.values();
        for (n = 0; n < resourceArray.length; ++n) {
            if (this.currentState.getOwnerForResource(resourceArray[n]) == tMState.getOwnerForResource(resourceArray[n])) continue;
            abstractStateChange = new ResourceOwnerChange(resourceArray[n], this.currentState.getOwnerForResource(resourceArray[n]), tMState.getOwnerForResource(resourceArray[n]));
            object = this.stateChangeMapOverride.get(abstractStateChange);
            if (null != object) {
                if (object.executeSuperAction()) {
                    this.executeDefaultAction(tMState, iRequestor, l, commandList, (ResourceOwnerChange)abstractStateChange);
                }
                object.execute(commandList, tMState, iRequestor, l);
                continue;
            }
            this.executeDefaultAction(tMState, iRequestor, l, commandList, (ResourceOwnerChange)abstractStateChange);
        }
        for (n = 0; n < resourceArray.length; ++n) {
            if (this.currentState.getStateForResource(resourceArray[n]) == tMState.getStateForResource(resourceArray[n])) continue;
            abstractStateChange = new ResourceStateChange(resourceArray[n], this.currentState.getStateForResource(resourceArray[n]), tMState.getStateForResource(resourceArray[n]));
            object = this.stateChangeMapOverride.get(abstractStateChange);
            if (null != object) {
                object.execute(commandList, tMState, iRequestor, l);
                continue;
            }
            object = this.stateChangeMap.get(abstractStateChange);
            if (null == object) continue;
            object.execute(commandList, tMState, iRequestor, l);
        }
        Application[] applicationArray = Application.values();
        for (int i2 = 0; i2 < applicationArray.length; ++i2) {
            if (this.currentState.getOwnerForApplication(applicationArray[i2]) == tMState.getOwnerForApplication(applicationArray[i2])) continue;
            object = new ApplicationStateChange(applicationArray[i2], this.currentState.getOwnerForApplication(applicationArray[i2]), tMState.getOwnerForApplication(applicationArray[i2]));
            IStateChangeAction iStateChangeAction = this.stateChangeMapOverride.get((IStateChange)object);
            if (null != iStateChangeAction) {
                iStateChangeAction.execute(commandList, tMState, iRequestor, l);
                continue;
            }
            iStateChangeAction = this.stateChangeMap.get((IStateChange)object);
            if (null == iStateChangeAction) continue;
            iStateChangeAction.execute(commandList, tMState, iRequestor, l);
        }
        return commandList;
    }

    private void executeDefaultAction(TMState tMState, IRequestor iRequestor, long l, CommandList commandList, ResourceOwnerChange resourceOwnerChange) {
        IStateChangeAction iStateChangeAction = this.stateChangeMap.get(resourceOwnerChange);
        if (null != iStateChangeAction) {
            iStateChangeAction.execute(commandList, tMState, iRequestor, l);
        }
    }

    private void setDefaultStateChangeActions() {
        this.stateChangeMap.put(new ResourceOwnerChange(Resource.AUDIO_MEDIA, ResourceOwner.MAINUNIT, ResourceOwner.DEVICE), new IStateChangeAction(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                StateHandlerImpl.this.logger.log(1000000, "[%1.changeState] audio media: MU -> Device", (Object)StateHandlerImpl.LOGCLASS);
                StateHandlerImpl.this.addCommandToCommandList(commandList, new RequestAudioFocus(StateHandlerImpl.this.context, StateHandlerImpl.this), false);
                StateHandlerImpl.this.addCommandToCommandList(commandList, StateHandlerImpl.this.audioManager.createAudioConnectionRequest(TMAudioConnection.MEDIA, true), false);
            }
        });
        this.stateChangeMap.put(new ResourceOwnerChange(Resource.AUDIO_MEDIA, ResourceOwner.DEVICE, ResourceOwner.MAINUNIT), new IStateChangeAction(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                StateHandlerImpl.this.logger.log(1000000, "[%1.changeState] audio media: device -> MU", (Object)StateHandlerImpl.LOGCLASS);
                StateHandlerImpl.this.addCommandToCommandList(commandList, new ReleaseAudioFocus(StateHandlerImpl.this.context), true);
                StateHandlerImpl.this.addCommandToCommandList(commandList, new ReleaseAudioConnection(TMAudioConnection.MEDIA, StateHandlerImpl.this.context), true);
            }
        });
        this.stateChangeMap.put(new ResourceOwnerChange(Resource.AUDIO_PHONE, ResourceOwner.MAINUNIT, ResourceOwner.DEVICE), new IStateChangeAction(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                StateHandlerImpl.this.logger.log(1000000, "[%1.changeState] audio phone: MU -> Device", (Object)StateHandlerImpl.LOGCLASS);
                StateHandlerImpl.this.addCommandToCommandList(commandList, StateHandlerImpl.this.audioManager.createAudioConnectionRequest(TMAudioConnection.PHONE_INPUT, false), false);
                StateHandlerImpl.this.addCommandToCommandList(commandList, StateHandlerImpl.this.audioManager.createAudioConnectionRequest(TMAudioConnection.PHONE, false), false);
            }
        });
        this.stateChangeMap.put(new ResourceOwnerChange(Resource.AUDIO_PHONE, ResourceOwner.DEVICE, ResourceOwner.MAINUNIT), new IStateChangeAction(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                StateHandlerImpl.this.logger.log(1000000, "[%1.changeState] audio phone: device -> MU", (Object)StateHandlerImpl.LOGCLASS);
                StateHandlerImpl.this.addCommandToCommandList(commandList, new ReleaseAudioConnection(TMAudioConnection.PHONE_INPUT, StateHandlerImpl.this.context), true);
                StateHandlerImpl.this.addCommandToCommandList(commandList, new ReleaseAudioConnection(TMAudioConnection.PHONE, StateHandlerImpl.this.context), true);
            }
        });
        this.stateChangeMap.put(new ResourceOwnerChange(Resource.AUDIO_SPEECH, ResourceOwner.MAINUNIT, ResourceOwner.DEVICE), new IStateChangeAction(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                StateHandlerImpl.this.logger.log(1000000, "[%1.changeState] audio speech: MU -> Device", (Object)StateHandlerImpl.LOGCLASS);
                StateHandlerImpl.this.addCommandToCommandList(commandList, StateHandlerImpl.this.audioManager.createAudioConnectionRequest(TMAudioConnection.SPEECH, false), false);
                StateHandlerImpl.this.addCommandToCommandList(commandList, StateHandlerImpl.this.audioManager.createAudioConnectionRequest(TMAudioConnection.SPEECH_INPUT, false), false);
            }
        });
        this.stateChangeMap.put(new ResourceOwnerChange(Resource.AUDIO_SPEECH, ResourceOwner.DEVICE, ResourceOwner.MAINUNIT), new IStateChangeAction(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                StateHandlerImpl.this.logger.log(1000000, "[%1.changeState] audio speech: device -> MU", (Object)StateHandlerImpl.LOGCLASS);
                StateHandlerImpl.this.addCommandToCommandList(commandList, new ReleaseAudioConnection(TMAudioConnection.SPEECH, StateHandlerImpl.this.context), true);
                StateHandlerImpl.this.addCommandToCommandList(commandList, new ReleaseAudioConnection(TMAudioConnection.SPEECH_INPUT, StateHandlerImpl.this.context), true);
            }
        });
        this.stateChangeMap.put(new ResourceOwnerChange(Resource.AUDIO_RINGTONE, ResourceOwner.MAINUNIT, ResourceOwner.DEVICE), new IStateChangeAction(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                StateHandlerImpl.this.logger.log(1000000, "[%1.addRingtoneCommands] audio ringtone: MU -> Device", (Object)StateHandlerImpl.LOGCLASS);
                IAudioConnectionHandle iAudioConnectionHandle = StateHandlerImpl.this.audioManager.createAudioConnectionHandle(TMAudioConnection.RINGTONE);
                StateHandlerImpl.this.addCommandToCommandList(commandList, iAudioConnectionHandle.createRequestCommand(false), false);
            }
        });
        this.stateChangeMap.put(new ResourceOwnerChange(Resource.AUDIO_RINGTONE, ResourceOwner.DEVICE, ResourceOwner.MAINUNIT), new IStateChangeAction(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                StateHandlerImpl.this.logger.log(1000000, "[%1.addRingtoneCommands] audio ringtone: device -> MU", (Object)StateHandlerImpl.LOGCLASS);
                IAudioConnectionHandle iAudioConnectionHandle = StateHandlerImpl.this.audioManager.createAudioConnectionHandle(TMAudioConnection.RINGTONE);
                StateHandlerImpl.this.addCommandToCommandList(commandList, iAudioConnectionHandle.createReleaseCommand(), true);
            }
        });
        this.stateChangeMap.put(new ApplicationStateChange(Application.NAVI, ApplicationOwner.MAINUNIT, ApplicationOwner.DEVICE), new IStateChangeAction(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                StateHandlerImpl.this.logger.log(1000000, "[%1.changeState] Navi: MU -> Device", (Object)StateHandlerImpl.LOGCLASS);
                StateHandlerImpl.this.addCommandToCommandList(commandList, new StopNaviRouteGuidance(StateHandlerImpl.this.context), false);
                StateHandlerImpl.this.addCommandToCommandList(commandList, StateHandlerImpl.this.audioManager.createAudioConnectionRequest(TMAudioConnection.ANNOUNCEMENT, false), false);
            }
        });
        this.stateChangeMap.put(new ApplicationStateChange(Application.NAVI, ApplicationOwner.NOBODY, ApplicationOwner.DEVICE), new IStateChangeAction(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                StateHandlerImpl.this.logger.log(1000000, "[%1.changeState] Navi: Nobody -> Device", (Object)StateHandlerImpl.LOGCLASS);
                StateHandlerImpl.this.addCommandToCommandList(commandList, new StopNaviRouteGuidance(StateHandlerImpl.this.context), false);
                StateHandlerImpl.this.addCommandToCommandList(commandList, StateHandlerImpl.this.audioManager.createAudioConnectionRequest(TMAudioConnection.ANNOUNCEMENT, false), false);
            }
        });
        this.stateChangeMap.put(new ApplicationStateChange(Application.NAVI, ApplicationOwner.DEVICE, ApplicationOwner.NOBODY), new IStateChangeAction(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                StateHandlerImpl.this.logger.log(1000000, "[%1.changeState] Navi: Device -> Nobody", (Object)StateHandlerImpl.LOGCLASS);
            }
        });
        this.stateChangeMap.put(new ApplicationStateChange(Application.PHONE, ApplicationOwner.NOBODY, ApplicationOwner.DEVICE), new IStateChangeAction(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                StateHandlerImpl.this.logger.log(1000000, "[%1.changeState] Phone: Nobody -> Device", (Object)StateHandlerImpl.LOGCLASS);
            }
        });
        this.stateChangeMap.put(new ApplicationStateChange(Application.PHONE, ApplicationOwner.DEVICE, ApplicationOwner.NOBODY), new IStateChangeAction(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                StateHandlerImpl.this.logger.log(1000000, "[%1.changeState] Phone: Device -> Nobody", (Object)StateHandlerImpl.LOGCLASS);
            }
        });
        this.stateChangeMap.put(new ApplicationStateChange(Application.PHONE, ApplicationOwner.MAINUNIT, ApplicationOwner.DEVICE), new IStateChangeAction(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                StateHandlerImpl.this.logger.log(1000000, "[%1.changeState] Phone: MU -> Device", (Object)StateHandlerImpl.LOGCLASS);
            }
        });
        this.stateChangeMap.put(new ApplicationStateChange(Application.PHONE, ApplicationOwner.DEVICE, ApplicationOwner.MAINUNIT), new IStateChangeAction(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                StateHandlerImpl.this.logger.log(1000000, "[%1.changeState] Phone: Device -> MU", (Object)StateHandlerImpl.LOGCLASS);
            }
        });
        this.stateChangeMap.put(new ApplicationStateChange(Application.PHONE, ApplicationOwner.MAINUNIT, ApplicationOwner.NOBODY), new IStateChangeAction(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                StateHandlerImpl.this.logger.log(1000000, "[%1.changeState] Phone: MU -> Nobody", (Object)StateHandlerImpl.LOGCLASS);
            }
        });
        this.stateChangeMap.put(new ApplicationStateChange(Application.PHONE, ApplicationOwner.NOBODY, ApplicationOwner.MAINUNIT), new IStateChangeAction(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                StateHandlerImpl.this.logger.log(1000000, "[%1.changeState] Phone: Nobody -> MU", (Object)StateHandlerImpl.LOGCLASS);
            }
        });
        this.stateChangeMap.put(new ApplicationStateChange(Application.SPEECH, ApplicationOwner.NOBODY, ApplicationOwner.DEVICE), new IStateChangeAction(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                StateHandlerImpl.this.logger.log(1000000, "[%1.changeState] speech: nobody -> device", (Object)StateHandlerImpl.LOGCLASS);
            }
        });
        this.stateChangeMap.put(new ApplicationStateChange(Application.SPEECH, ApplicationOwner.MAINUNIT, ApplicationOwner.DEVICE), new IStateChangeAction(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                StateHandlerImpl.this.logger.log(1000000, "[%1.changeState] speech: mainunit -> device", (Object)StateHandlerImpl.LOGCLASS);
            }
        });
        this.stateChangeMap.put(new ApplicationStateChange(Application.SPEECH, ApplicationOwner.DEVICE, ApplicationOwner.MAINUNIT), new IStateChangeAction(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                StateHandlerImpl.this.logger.log(1000000, "[%1.changeState] speech: device -> mainunit", (Object)StateHandlerImpl.LOGCLASS);
            }
        });
        this.stateChangeMap.put(new ResourceOwnerChange(Resource.SCREEN, ResourceOwner.MAINUNIT, ResourceOwner.DEVICE), new IStateChangeAction(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                StateHandlerImpl.this.logger.log(1000000, "[%1.changeState] Screen: MU -> Device", (Object)StateHandlerImpl.LOGCLASS);
                if (IRequestor.DEVICE == iRequestor) {
                    StateHandlerImpl.this.addCommandToCommandList(commandList, new ScreenChange(StateHandlerImpl.this.context, StateHandlerImpl.this), false);
                }
                StateHandlerImpl.this.addCommandToCommandList(commandList, new UpdatePhoneHMI(StateHandlerImpl.this.context, true), false);
            }
        });
        this.stateChangeMap.put(new ResourceOwnerChange(Resource.SCREEN, ResourceOwner.DEVICE, ResourceOwner.MAINUNIT), new IStateChangeAction(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                StateHandlerImpl.this.logger.log(1000000, "[%1.changeState] Screen: Device -> MU", (Object)StateHandlerImpl.LOGCLASS);
                if (IRequestor.DEVICE == iRequestor) {
                    StateHandlerImpl.this.addCommandToCommandList(commandList, new RestoreHMIScreen(StateHandlerImpl.this.context, StateHandlerImpl.this), false);
                } else if (IRequestor.DEVICE_WHILE_DISCONNECTING.equals(iRequestor)) {
                    StateHandlerImpl.this.logger.log(10000000, "[%1.changeState] Screen: Device -> MU, DEVICE_WHILE_DISCONNECTING, no RestoreHMIScreen command", (Object)StateHandlerImpl.LOGCLASS);
                }
                StateHandlerImpl.this.addCommandToCommandList(commandList, new UpdatePhoneHMI(StateHandlerImpl.this.context, false), false);
            }
        });
    }

    @Override
    public void addStateChangeActions(GMap<IStateChange, IStateChangeAction.IStateChangeActionOverride> gMap) {
        this.stateChangeMapOverride.putAll(gMap);
    }

    @Override
    public void removeStateChangeActions() {
        this.stateChangeMapOverride.clear();
    }

    private void changeStateHighPriorityResources(TMState tMState, IRequestor iRequestor, CommandList commandList) {
        boolean bl;
        if (this.currentState.isAccessRestricted(Resource.SCREEN) != tMState.isAccessRestricted(Resource.SCREEN)) {
            bl = tMState.isAccessRestricted(Resource.SCREEN);
            this.logger.log(1000000, "[%1.changeStateHighPriorityResources] SCREEN %2", (Object)LOGCLASS, (Object)(bl ? "Acquired" : "Released"));
            this.currentState.setAccessRestricted(Resource.SCREEN, bl);
            this.addCommandToCommandList(commandList, new RequestConstraintsChange(this.context, this.currentState, Resource.SCREEN, bl), false);
        }
        if (this.currentState.isAccessRestricted(Resource.AUDIO_MEDIA) != tMState.isAccessRestricted(Resource.AUDIO_MEDIA)) {
            bl = tMState.isAccessRestricted(Resource.AUDIO_MEDIA);
            this.logger.log(1000000, "[%1.changeStateHighPriorityResources] AUDIO_MEDIA %2", (Object)LOGCLASS, (Object)(bl ? "Acquired" : "Released"));
            this.currentState.setAccessRestricted(Resource.AUDIO_MEDIA, bl);
            this.addCommandToCommandList(commandList, new RequestConstraintsChange(this.context, this.currentState, Resource.AUDIO_MEDIA, bl), false);
        }
    }

    private void addCommandToCommandList(CommandList commandList, Command command, boolean bl) {
        if (bl) {
            commandList.add(0, command);
        } else {
            commandList.add(command);
        }
    }

    @Override
    public String getDiagKey() {
        return "getCurrentState";
    }

    @Override
    public String getDiagValue() {
        return this.currentState.toString();
    }

    @Override
    public void setServiceStatus(boolean bl) {
        this.logger.log(1000000, "[%1.setServiceStatus] %2", (Object)LOGCLASS, (Object)(bl ? "started" : "not started"));
        this.serviceStarted.accept(new Boolean(bl));
    }

    @Override
    public ReadOnlyProperty<Boolean> getServiceStartedProperty() {
        return this.serviceStarted;
    }

    @Override
    public void updateState(TMState tMState) {
        this.logger.log(1000000, "[%1.updateState] new state=%2", (Object)LOGCLASS, (Object)tMState);
        this.currentState.update(tMState);
        this.notifyStateChanged(this.stateUpdateListener, this.getCurrentState());
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{KEY_ADDSTATEDUMP};
    }

    @Override
    public void executeDiagCommand(String string, String[] stringArray) {
        if (KEY_ADDSTATEDUMP.equals(string) && stringArray.length > 0) {
            try {
                this.stateDumpMode = Integer.valueOf(stringArray[0]);
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.executeDiagCommand] %2", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    @Override
    public void addStateListener(ITMStateListener iTMStateListener) {
        if (null == iTMStateListener) {
            return;
        }
        if (this.stateUpdateListener.addIfAbsent(iTMStateListener)) {
            this.notifyStateChanged(Generics.newArrayList(new ITMStateListener[]{iTMStateListener}), this.getCurrentState());
        }
    }

    @Override
    public void removeStateListener(ITMStateListener iTMStateListener) {
        this.stateUpdateListener.remove(iTMStateListener);
    }

    public void notifyStateChanged(GList<ITMStateListener> gList, TMState tMState) {
        this.logger.log(100000000, "[%1.notifyStateChanged] %2", (Object)LOGCLASS, (Object)tMState);
        GIterator<ITMStateListener> gIterator = gList.iterator();
        while (gIterator.hasNext()) {
            try {
                gIterator.next().updateState(tMState);
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.notifyStateChanged]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    @Override
    public ReadOnlyProperty<ApplicationOwner> getStateApplicationProperty(Application application) {
        return this.currentState.getApplicationProperty(application);
    }

    @Override
    public ReadOnlyProperty<ResourceOwner> getStateResourceProperty(Resource resource) {
        return this.currentState.getResourceProperty(resource);
    }

    @Override
    public void setLastScreenWasEntertainment(boolean bl) {
        this.lastScreenWasEntertainment = bl;
    }

    @Override
    public boolean getLastScreenWasEntertainment() {
        return this.lastScreenWasEntertainment;
    }
}

