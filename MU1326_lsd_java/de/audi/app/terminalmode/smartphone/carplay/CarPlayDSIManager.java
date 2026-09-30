/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carplay;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.SmartphoneManager;
import de.audi.app.terminalmode.TerminalModeUtils;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.terminalmode.diagnosis.IDiagnosisDataProvider;
import de.audi.app.terminalmode.dsi.DSIResource;
import de.audi.app.terminalmode.dsi.IAppState;
import de.audi.app.terminalmode.dsi.IDSIAppState;
import de.audi.app.terminalmode.dsi.IDSIResource;
import de.audi.app.terminalmode.dsi.IResource;
import de.audi.app.terminalmode.dsi.carplay.CarPlayAppState;
import de.audi.app.terminalmode.dsi.carplay.CarPlayResource;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController;
import de.audi.app.terminalmode.dsi.carplay.CarplayUtils;
import de.audi.app.terminalmode.dsi.carplay.ICarplayDSIController;
import de.audi.app.terminalmode.dsi.carplay.ICarplayDSIControllerListener;
import de.audi.app.terminalmode.smartphone.AbstractDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.IPhoneCallController;
import de.audi.app.terminalmode.smartphone.ISpeechRequestHandler;
import de.audi.app.terminalmode.smartphone.carplay.AbstractRequestModeChangeAudio;
import de.audi.app.terminalmode.smartphone.carplay.CarPlaySpeechRequestHandler;
import de.audi.app.terminalmode.smartphone.carplay.CarplayRequest;
import de.audi.app.terminalmode.smartphone.carplay.CarplaySmartphoneProperties;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.app.terminalmode.statemachine.ApplicationStateChange;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateChange;
import de.audi.app.terminalmode.statemachine.IStateChangeAction;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.ITMStateListener;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.ResourceOwnerChange;
import de.audi.app.terminalmode.statemachine.ResourceState;
import de.audi.app.terminalmode.statemachine.ResourceStateChange;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractDSICommand;
import de.audi.app.terminalmode.statemachine.commands.SendResponseModeChanged;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.util.Util;
import de.audi.atip.utils.generics.GMap;
import de.audi.atip.utils.generics.Generics;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class CarPlayDSIManager
extends AbstractDSISmartphoneManager
implements ICarplayDSIControllerListener,
ITMStateListener,
IDiagnosisDataProvider,
IDiagnosisCommandProvider {
    private static final String LOGCLASS = "CarPlayDSIManager";
    private final CarplayDSILifecycleController carPlayDSILifecycleController;
    private final Map messageMap;
    private volatile CarPlayResource currentActiveResource;
    private volatile int activeApplications;
    private final TMState currentState;
    private final ISpeechRequestHandler speechRequestHandler;
    private final IPhoneCallController phoneCallController;
    private final ICarplayDSIController carPlayDSIController;
    private final IStateHandler stateHandler;
    private final CarplaySmartphoneProperties carplaySmartphoneProperties;
    private volatile boolean waitForAudioType;
    private final String DIAG_UPDATE_TEXTINPUT;

    public CarPlayDSIManager(IContext iContext, CarplayDSILifecycleController carplayDSILifecycleController, IStateHandler iStateHandler, CarplaySmartphoneProperties carplaySmartphoneProperties) {
        super(iContext, SmartphoneManager.SmartphoneType.CARPLAY);
        this.DIAG_UPDATE_TEXTINPUT = "textInput(boolean)";
        this.carPlayDSILifecycleController = carplayDSILifecycleController;
        this.messageMap = new HashMap();
        this.stateHandler = iStateHandler;
        this.currentState = iStateHandler.getCurrentState();
        this.carPlayDSIController = this.carPlayDSILifecycleController.getDioDsiController();
        this.speechRequestHandler = new CarPlaySpeechRequestHandler(iContext, this.carPlayDSIController);
        this.carplaySmartphoneProperties = carplaySmartphoneProperties;
        this.phoneCallController = new IPhoneCallController(){

            public void hook(boolean bl) {
                CarPlayDSIManager.this.carPlayDSIController.postDSICarplayButtonEvent(13, bl ? 1 : 0);
            }

            public void hangup(boolean bl) {
                CarPlayDSIManager.this.carPlayDSIController.postDSICarplayButtonEvent(14, bl ? 1 : 0);
            }

            public void flash(boolean bl) {
                CarPlayDSIManager.this.carPlayDSIController.postDSICarplayButtonEvent(20, bl ? 1 : 0);
            }
        };
    }

    @Override
    public void init() {
        super.init();
        this.carPlayDSILifecycleController.init();
        this.carPlayDSILifecycleController.setStateListener(this);
        this.stateHandler.addStateListener(this);
        this.context.getDiagnosisManager().addDataProvider(-1, this);
        this.context.getDiagnosisManager().addCommandProvider(-1, this);
    }

    @Override
    public void deinit() {
        this.stateHandler.removeStateListener(this);
        this.carPlayDSILifecycleController.deinit();
        super.deinit();
    }

    public ICarplayDSIControllerListener createICarplayDSIControllerListener() {
        return this;
    }

    @Override
    public void activate() {
        if (this.active) {
            this.logger.log(1000000, "[%1.activate] Already active.", (Object)LOGCLASS);
            return;
        }
        this.active = true;
        super.activate();
        this.carplaySmartphoneProperties.activate();
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
        this.keyEventsHandler.setDSIKeyEventController(this.carPlayDSILifecycleController.getKeyEventController());
        this.context.getTMKeyEventController().setDSIKeyEventController(this.carPlayDSILifecycleController.getKeyEventController());
        if (this.isDsiAvailable()) {
            this.smartphoneManagerListener.updateDSIState(true);
        }
        GMap<IStateChange, IStateChangeAction.IStateChangeActionOverride> gMap = Generics.newHashMap();
        gMap.put(new ResourceStateChange(Resource.AUDIO_MEDIA, ResourceState.NORMAL, ResourceState.PAUSED), new IStateChangeAction.AbstractStateChangeActionOverride(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarPlayDSIManager.this.logger.log(1000000, "[%1.changeState] Audio_Media: Normal -> Paused", (Object)CarPlayDSIManager.LOGCLASS);
                if (ResourceOwner.DEVICE.is(tMState.getOwnerForResource(Resource.AUDIO_PHONE)) || ResourceOwner.DEVICE.is(tMState.getOwnerForResource(Resource.AUDIO_SPEECH)) || ResourceOwner.DEVICE.is(tMState.getOwnerForResource(Resource.AUDIO_RINGTONE))) {
                    return;
                }
                commandList.add(new AbstractRequestModeChangeAudio(CarPlayDSIManager.this.logger, CarPlayDSIManager.this.context, CarPlayDSIManager.this, tMState, CarPlayDSIManager.this.stateHandler){

                    public void execute() {
                        this.logger.log(1000000, "[%1.execute]", (Object)CarPlayDSIManager.LOGCLASS);
                        CarPlayDSIManager.this.carPlayDSIController.requestModeChange(new IDSIAppState[0], new IDSIResource[]{new DSIResource.Builder().setpOwner(1).setpResourceId(2).setDsiResourceId(1).setDsiResourceOwner(1).setDsiTakeType(3).setDSITransferPriority(1).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(2).build()}, "audio paused");
                        TMState tMState = CarPlayDSIManager.this.stateHandler.getCurrentState();
                        tMState.setStateForResource(Resource.AUDIO_MEDIA, ResourceState.PAUSED);
                        CarPlayDSIManager.this.stateHandler.updateState(tMState);
                    }

                    public boolean updateStates(IAppState[] iAppStateArray, IResource[] iResourceArray, long l) {
                        TMState tMState = CarPlayDSIManager.this.stateHandler.getCurrentState();
                        tMState.updateCurrentAppState(iAppStateArray);
                        tMState.updateCurrentResourceState(iResourceArray);
                        tMState.setOwnerForResource(Resource.AUDIO_MEDIA, ResourceOwner.DEVICE);
                        boolean bl = TerminalModeUtils.compareTMStateAfterDSIUpdate(this.newState, tMState);
                        this.getCommandList().commandFinished();
                        return bl;
                    }

                    public long getTimeout() {
                        return 200L;
                    }
                });
            }
        });
        gMap.put(new ResourceStateChange(Resource.AUDIO_MEDIA, ResourceState.NORMAL, ResourceState.PAUSED_BY_MUTE), new IStateChangeAction.AbstractStateChangeActionOverride(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarPlayDSIManager.this.logger.log(1000000, "[%1.changeState] Audio_Media: Normal -> Paused by mute", (Object)CarPlayDSIManager.LOGCLASS);
                if (ResourceOwner.DEVICE.is(tMState.getOwnerForResource(Resource.AUDIO_PHONE)) || ResourceOwner.DEVICE.is(tMState.getOwnerForResource(Resource.AUDIO_SPEECH)) || ResourceOwner.DEVICE.is(tMState.getOwnerForResource(Resource.AUDIO_RINGTONE))) {
                    return;
                }
                commandList.add(new AbstractRequestModeChangeAudio(CarPlayDSIManager.this.logger, CarPlayDSIManager.this.context, CarPlayDSIManager.this, tMState, CarPlayDSIManager.this.stateHandler){

                    public void execute() {
                        this.logger.log(1000000, "[%1.execute]", (Object)CarPlayDSIManager.LOGCLASS);
                        CarPlayDSIManager.this.carPlayDSIController.requestModeChange(new IDSIAppState[0], new IDSIResource[]{new DSIResource.Builder().setpOwner(1).setpResourceId(2).setDsiResourceId(1).setDsiResourceOwner(1).setDsiTakeType(3).setDSITransferPriority(1).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(1).build()}, "audio paused by mute");
                        TMState tMState = CarPlayDSIManager.this.stateHandler.getCurrentState();
                        tMState.setStateForResource(Resource.AUDIO_MEDIA, ResourceState.PAUSED_BY_MUTE);
                        CarPlayDSIManager.this.stateHandler.updateState(tMState);
                    }

                    public boolean updateStates(IAppState[] iAppStateArray, IResource[] iResourceArray, long l) {
                        TMState tMState = CarPlayDSIManager.this.stateHandler.getCurrentState();
                        tMState.updateCurrentAppState(iAppStateArray);
                        tMState.updateCurrentResourceState(iResourceArray);
                        tMState.setOwnerForResource(Resource.AUDIO_MEDIA, ResourceOwner.DEVICE);
                        boolean bl = TerminalModeUtils.compareTMStateAfterDSIUpdate(this.newState, tMState);
                        this.getCommandList().commandFinished();
                        return bl;
                    }

                    public long getTimeout() {
                        return 200L;
                    }
                });
            }
        });
        gMap.put(new ResourceStateChange(Resource.AUDIO_MEDIA, ResourceState.PAUSED, ResourceState.NORMAL), new IStateChangeAction.AbstractStateChangeActionOverride(){

            public void execute(CommandList commandList, final TMState tMState, IRequestor iRequestor, long l) {
                CarPlayDSIManager.this.logger.log(1000000, "[%1.changeState] Audio_Media: Paused -> Normal", (Object)CarPlayDSIManager.LOGCLASS);
                commandList.add(new AbstractRequestModeChangeAudio(CarPlayDSIManager.this.logger, CarPlayDSIManager.this.context, CarPlayDSIManager.this, tMState, CarPlayDSIManager.this.stateHandler){

                    public void execute() {
                        this.logger.log(1000000, "[%1.execute]", (Object)CarPlayDSIManager.LOGCLASS);
                        if (!tMState.isResourceOwnerMainUnit(Resource.AUDIO_MEDIA)) {
                            CarPlayDSIManager.this.carPlayDSIController.requestModeChange(new IDSIAppState[0], new IDSIResource[]{new DSIResource.Builder().setpOwner(2).setpResourceId(2).setDsiResourceId(1).setDsiResourceOwner(2).setDsiTakeType(4).setDSITransferPriority(1).setDsiBorrowConstraint(1).setDsiTakeConstraint(0).setDsiUnborrowConstraint(1).build()}, "audio play");
                        }
                        TMState tMState2 = CarPlayDSIManager.this.stateHandler.getCurrentState();
                        tMState2.setStateForResource(Resource.AUDIO_MEDIA, ResourceState.NORMAL);
                        CarPlayDSIManager.this.stateHandler.updateState(tMState2);
                        this.getCommandList().commandFinished();
                    }
                });
            }
        });
        gMap.put(new ResourceStateChange(Resource.AUDIO_MEDIA, ResourceState.PAUSED_BY_MUTE, ResourceState.NORMAL), new IStateChangeAction.AbstractStateChangeActionOverride(){

            public void execute(CommandList commandList, final TMState tMState, IRequestor iRequestor, long l) {
                CarPlayDSIManager.this.logger.log(1000000, "[%1.changeState] Audio_Media: Paused_by_mute -> Normal", (Object)CarPlayDSIManager.LOGCLASS);
                if (IRequestor.MAINUNIT == iRequestor) {
                    commandList.add(new AbstractRequestModeChangeAudio(CarPlayDSIManager.this.logger, CarPlayDSIManager.this.context, CarPlayDSIManager.this, tMState, CarPlayDSIManager.this.stateHandler){

                        public void execute() {
                            this.logger.log(1000000, "[%1.execute]", (Object)CarPlayDSIManager.LOGCLASS);
                            if (!tMState.isResourceOwnerMainUnit(Resource.AUDIO_MEDIA)) {
                                CarPlayDSIManager.this.carPlayDSIController.requestModeChange(new IDSIAppState[0], new IDSIResource[]{new DSIResource.Builder().setpOwner(2).setpResourceId(2).setDsiResourceId(1).setDsiResourceOwner(2).setDsiTakeType(4).setDSITransferPriority(1).setDsiBorrowConstraint(1).setDsiTakeConstraint(0).setDsiUnborrowConstraint(1).build()}, "audio play after mute");
                            }
                            TMState tMState2 = CarPlayDSIManager.this.stateHandler.getCurrentState();
                            tMState2.setStateForResource(Resource.AUDIO_MEDIA, ResourceState.NORMAL);
                            CarPlayDSIManager.this.stateHandler.updateState(tMState2);
                            this.getCommandList().commandFinished();
                        }
                    });
                }
            }
        });
        gMap.put(new ResourceStateChange(Resource.AUDIO_MEDIA, ResourceState.PAUSED, ResourceState.PAUSED_BY_MUTE), new IStateChangeAction.AbstractStateChangeActionOverride(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarPlayDSIManager.this.logger.log(1000000, "[%1.changeState] Audio_Media: Paused -> Paused by mute", (Object)CarPlayDSIManager.LOGCLASS);
                commandList.add(new AbstractRequestModeChangeAudio(CarPlayDSIManager.this.logger, CarPlayDSIManager.this.context, CarPlayDSIManager.this, tMState, CarPlayDSIManager.this.stateHandler){

                    public void execute() {
                        this.logger.log(1000000, "[%1.execute]", (Object)CarPlayDSIManager.LOGCLASS);
                        CarPlayDSIManager.this.carPlayDSIController.requestModeChange(new IDSIAppState[0], new IDSIResource[]{new DSIResource.Builder().setpOwner(1).setpResourceId(2).setDsiResourceId(1).setDsiResourceOwner(1).setDsiTakeType(3).setDSITransferPriority(1).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(1).build()}, "Audio_Media: Paused -> Paused by mute");
                        CarPlayDSIManager.this.carPlayDSIController.requestModeChange(new IDSIAppState[0], new IDSIResource[]{new DSIResource.Builder().setpOwner(1).setpResourceId(2).setDsiResourceId(1).setDsiResourceOwner(1).setDsiTakeType(4).setDSITransferPriority(1).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(0).build()}, "Audio_Media: Borrow -> Unborrow");
                        TMState tMState = CarPlayDSIManager.this.stateHandler.getCurrentState();
                        tMState.setStateForResource(Resource.AUDIO_MEDIA, ResourceState.PAUSED_BY_MUTE);
                        CarPlayDSIManager.this.stateHandler.updateState(tMState);
                        this.getCommandList().commandFinished();
                    }

                    public boolean updateStates(IAppState[] iAppStateArray, IResource[] iResourceArray, long l) {
                        return false;
                    }
                });
            }
        });
        this.addRequestModeChanges(gMap);
        this.stateHandler.addStateChangeActions(gMap);
    }

    private void addRequestModeChanges(GMap<IStateChange, IStateChangeAction.IStateChangeActionOverride> gMap) {
        gMap.put(new ResourceOwnerChange(Resource.SCREEN, ResourceOwner.MAINUNIT, ResourceOwner.DEVICE), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarPlayDSIManager.this.logger.log(1000000, "[%1.changeState] Screen: MU -> Device", (Object)CarPlayDSIManager.LOGCLASS);
                if (IRequestor.DEVICE.isNot(iRequestor)) {
                    commandList.add(new RequestModeChangeCarPlay(CarPlayDSIManager.this.context, tMState, CarPlayDSIManager.this.stateHandler));
                }
            }
        });
        gMap.put(new ResourceOwnerChange(Resource.SCREEN, ResourceOwner.DEVICE, ResourceOwner.MAINUNIT), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarPlayDSIManager.this.logger.log(1000000, "[%1.changeState] Screen: Device -> MU", (Object)CarPlayDSIManager.LOGCLASS);
                if (!iRequestor.isOneOf(IRequestor.DEVICE, IRequestor.DEVICE_WHILE_DISCONNECTING) && !CarPlayDSIManager.this.currentState.isAccessRestricted(Resource.SCREEN)) {
                    commandList.add(new RequestModeChangeCarPlay(CarPlayDSIManager.this.context, tMState, CarPlayDSIManager.this.stateHandler));
                }
            }
        });
        gMap.put(new ResourceOwnerChange(Resource.AUDIO_MEDIA, ResourceOwner.DEVICE, ResourceOwner.MAINUNIT), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarPlayDSIManager.this.logger.log(1000000, "[%1.changeState] audio media: device -> MU", (Object)CarPlayDSIManager.LOGCLASS);
                if (iRequestor.is(IRequestor.MAINUNIT)) {
                    commandList.add(new RequestModeChangeCarPlay(CarPlayDSIManager.this.context, tMState, CarPlayDSIManager.this.stateHandler));
                }
                commandList.add(new AbstractDSICommand(CarPlayDSIManager.this.logger, "Special Phone use case: Set Audio_Media to MU", CarPlayDSIManager.this.context, CarPlayDSIManager.this){

                    public void execute() {
                        this.logger.log(1000000, "[%1.Special Phone use case] Set Audio_Media to MU", (Object)CarPlayDSIManager.LOGCLASS);
                        if ((CarPlayDSIManager.this.stateHandler.getCurrentState().getOwnerForResource(Resource.AUDIO_PHONE).is(ResourceOwner.DEVICE) || CarPlayDSIManager.this.stateHandler.getCurrentState().getOwnerForResource(Resource.AUDIO_RINGTONE).is(ResourceOwner.DEVICE)) && CarPlayDSIManager.this.stateHandler.getCurrentState().getOwnerForApplication(Application.PHONE).is(ApplicationOwner.DEVICE)) {
                            CarPlayDSIManager.this.stateHandler.setOwnerForResource(Resource.AUDIO_MEDIA, ResourceOwner.MAINUNIT);
                        }
                        this.commandList.commandFinished();
                    }
                });
            }
        });
        gMap.put(new ApplicationStateChange(Application.SPEECH, ApplicationOwner.DEVICE, ApplicationOwner.NOBODY), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarPlayDSIManager.this.logger.log(1000000, "[%1.changeState] speech: device -> nobody", (Object)CarPlayDSIManager.LOGCLASS);
                if (iRequestor.is(IRequestor.MAINUNIT)) {
                    commandList.add(new RequestModeChangeCarPlay(CarPlayDSIManager.this.context, tMState, CarPlayDSIManager.this.stateHandler));
                }
            }
        });
        gMap.put(new ApplicationStateChange(Application.SPEECH, ApplicationOwner.NOBODY, ApplicationOwner.MAINUNIT), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarPlayDSIManager.this.logger.log(1000000, "[%1.changeState] speech: nobody -> mainunit", (Object)CarPlayDSIManager.LOGCLASS);
                if (iRequestor.is(IRequestor.MAINUNIT)) {
                    commandList.add(new RequestModeChangeCarPlay(CarPlayDSIManager.this.context, tMState, CarPlayDSIManager.this.stateHandler));
                }
            }
        });
        gMap.put(new ApplicationStateChange(Application.SPEECH, ApplicationOwner.MAINUNIT, ApplicationOwner.NOBODY), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarPlayDSIManager.this.logger.log(1000000, "[%1.changeState] speech: mainunit -> nobody", (Object)CarPlayDSIManager.LOGCLASS);
                if (iRequestor.is(IRequestor.MAINUNIT)) {
                    commandList.add(new RequestModeChangeCarPlay(CarPlayDSIManager.this.context, tMState, CarPlayDSIManager.this.stateHandler));
                }
            }
        });
        gMap.put(new ApplicationStateChange(Application.NAVI, ApplicationOwner.DEVICE, ApplicationOwner.MAINUNIT), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarPlayDSIManager.this.logger.log(1000000, "[%1.changeState] Navi: Device -> MU", (Object)CarPlayDSIManager.LOGCLASS);
                if (iRequestor.is(IRequestor.MAINUNIT)) {
                    commandList.add(new RequestModeChangeCarPlay(CarPlayDSIManager.this.context, tMState, CarPlayDSIManager.this.stateHandler));
                }
            }
        });
        gMap.put(new ApplicationStateChange(Application.NAVI, ApplicationOwner.NOBODY, ApplicationOwner.MAINUNIT), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarPlayDSIManager.this.logger.log(1000000, "[%1.changeState] Navi: Nobody -> MU", (Object)CarPlayDSIManager.LOGCLASS);
                if (iRequestor.is(IRequestor.MAINUNIT)) {
                    commandList.add(new RequestModeChangeCarPlay(CarPlayDSIManager.this.context, tMState, CarPlayDSIManager.this.stateHandler));
                }
            }
        });
        gMap.put(new ApplicationStateChange(Application.NAVI, ApplicationOwner.MAINUNIT, ApplicationOwner.NOBODY), new IStateChangeAction.AbstractStateChangeActionHook(){

            public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                CarPlayDSIManager.this.logger.log(1000000, "[%1.changeState] Navi: Mainunit -> Nobody", (Object)CarPlayDSIManager.LOGCLASS);
                if (IRequestor.MAINUNIT == iRequestor) {
                    commandList.add(new RequestModeChangeCarPlay(CarPlayDSIManager.this.context, tMState, CarPlayDSIManager.this.stateHandler));
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
        this.carplaySmartphoneProperties.deactivate();
        this.stateHandler.removeStateChangeActions();
        super.deactivate();
        this.active = false;
        this.smartphoneManagerListener.updateDSIState(false);
    }

    @Override
    public void startService(TMState tMState) {
        this.updateActiveApplications(tMState);
        this.waitForAudioType = false;
        this.logger.log(10000000, "[%1.startService.waitForAudioType set to] %2 ", (Object)LOGCLASS, (Object)new Boolean(this.waitForAudioType));
        this.carPlayDSIController.startService(this.getAppStates(tMState), this.filterAudioResources(this.getResources(tMState, true)));
    }

    @Override
    public void responseUpdateMode(TMState tMState, long l) {
        this.updateActiveApplications(tMState);
        CarplayRequest carplayRequest = (CarplayRequest)this.messageMap.get(Util.createLong(l));
        this.logger.log(1000000, "[%1.responseUpdateMode] msgId=%2", (Object)LOGCLASS, l);
        if (null != carplayRequest && 2 == carplayRequest.getType()) {
            this.carPlayDSIController.responseUpdateMainAudioType((Integer)carplayRequest.getParameter("AUDIOTYPE"));
        } else if (-1L != l) {
            this.carPlayDSIController.responseUpdateMode(this.filterAudioResources(this.getResources(tMState, true)), this.getAppStates(tMState));
        }
    }

    @Override
    public void requestModeChange(TMState tMState, String string, IDSISmartphoneManager.RequestModeChangeCallback requestModeChangeCallback) {
        throw new UnsupportedOperationException("CarPlay will access this directly. Method to be removed from the interface!");
    }

    @Override
    public void requestConstraintsChange(TMState tMState, Resource resource, boolean bl) {
        this.logger.log(1000000, "[%1.requestConstraintsChange] %2 %3", (Object)LOGCLASS, (Object)(bl ? "restricted" : "allowed"), (Object)resource);
        this.updateActiveApplications(tMState);
        this.carPlayDSIController.requestModeChange(this.getAppStates(tMState), this.getResourcesForContraintsChange(resource, bl), "requestConstraintsChange");
        if (!bl && Resource.SCREEN.is(resource) && ResourceOwner.DEVICE.is(tMState.getOwnerForResource(Resource.SCREEN))) {
            this.requestUI(0);
        }
    }

    @Override
    public IDSISmartphoneManager.ISmartphoneProperties getSmartphoneProperties() {
        return this.carplaySmartphoneProperties.getSmartphoneProperties();
    }

    private IDSIResource[] getResourcesForContraintsChange(Resource resource, boolean bl) {
        if (resource.is(Resource.SCREEN)) {
            if (bl) {
                return new IDSIResource[]{new DSIResource.Builder().setpOwner(1).setpResourceId(1).setDsiResourceId(2).setDsiResourceOwner(1).setDsiTakeType(3).setDSITransferPriority(1).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(3).build()};
            }
            return new IDSIResource[]{new DSIResource.Builder().setpOwner(1).setpResourceId(1).setDsiResourceId(2).setDsiResourceOwner(0).setDsiTakeType(4).setDSITransferPriority(1).setDsiBorrowConstraint(1).setDsiTakeConstraint(0).setDsiUnborrowConstraint(1).build()};
        }
        if (resource.is(Resource.AUDIO_MEDIA)) {
            if (bl) {
                return new IDSIResource[]{new DSIResource.Builder().setpOwner(1).setpResourceId(3).setDsiResourceId(1).setDsiResourceOwner(1).setDsiTakeType(3).setDSITransferPriority(1).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(3).build()};
            }
            return new IDSIResource[]{new DSIResource.Builder().setpOwner(1).setpResourceId(3).setDsiResourceId(1).setDsiResourceOwner(0).setDsiTakeType(4).setDSITransferPriority(1).setDsiBorrowConstraint(1).setDsiTakeConstraint(0).setDsiUnborrowConstraint(1).build()};
        }
        return new IDSIResource[0];
    }

    private IDSIResource[] filterAudioResources(IDSIResource[] iDSIResourceArray) {
        return this.filterAudioResources(iDSIResourceArray, true);
    }

    private IDSIResource[] filterAudioResources(IDSIResource[] iDSIResourceArray, boolean bl) {
        IDSIResource[] iDSIResourceArray2 = new IDSIResource[2];
        for (int i2 = 0; i2 < iDSIResourceArray.length; ++i2) {
            if (3 == iDSIResourceArray[i2].getResourceId()) {
                if (this.waitForAudioType && iDSIResourceArray[i2].getOwner() != 2) {
                    iDSIResourceArray2[1] = this.createResource(3, 2, bl);
                    continue;
                }
                iDSIResourceArray2[1] = iDSIResourceArray[i2];
                continue;
            }
            if (1 != iDSIResourceArray[i2].getResourceId()) continue;
            iDSIResourceArray2[0] = iDSIResourceArray[i2];
        }
        return iDSIResourceArray2;
    }

    private IDSIResource[] getResources(TMState tMState, boolean bl) {
        IDSIResource[] iDSIResourceArray = new IDSIResource[]{tMState.getStateForResource(Resource.AUDIO_MEDIA).is(ResourceState.PAUSED_BY_MUTE) ? new DSIResource.Builder().setpOwner(1).setpResourceId(3).setDsiResourceId(1).setDsiResourceOwner(1).setDsiTakeType(3).setDSITransferPriority(1).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(1).build() : (tMState.getStateForResource(Resource.AUDIO_MEDIA).is(ResourceState.PAUSED) ? new DSIResource.Builder().setpOwner(1).setpResourceId(3).setDsiResourceId(1).setDsiResourceOwner(1).setDsiTakeType(3).setDSITransferPriority(1).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(2).build() : this.createResource(3, tMState.isResourceOwnerMainUnit(Resource.AUDIO_MEDIA) || tMState.getStateForResource(Resource.AUDIO_MEDIA).is((T[])new ResourceState[]{ResourceState.PAUSED, ResourceState.PAUSED_BY_MUTE}) ? 1 : 2, bl)), this.createResource(4, tMState.isResourceOwnerMainUnit(Resource.AUDIO_PHONE) ? 1 : 2, bl), this.createResource(5, tMState.isResourceOwnerMainUnit(Resource.AUDIO_SPEECH) ? 1 : 2, bl), this.createResource(7, tMState.isResourceOwnerMainUnit(Resource.AUDIO_RINGTONE) ? 1 : 2, bl), this.createResource(1, tMState.isResourceOwnerMainUnit(Resource.SCREEN) ? 1 : 2, bl)};
        return iDSIResourceArray;
    }

    private void requestUI(int n) {
        this.carPlayDSIController.requestUI(n);
    }

    @Override
    protected IDSIAppState createAppState(int n, int n2, int n3) {
        return new CarPlayAppState(n, n2, n3);
    }

    private IDSIResource createResource(int n, int n2, boolean bl) {
        return new CarPlayResource(n, n2, bl ? this.getActiveApplications() : this.activeApplications);
    }

    private int getActiveApplications() {
        return this.activeApplications + this.context.getConfiguration().applicationOffset();
    }

    private void updateActiveApplications(TMState tMState) {
        this.activeApplications = tMState.isAppOwnerMainUnit(Application.SPEECH) ? (this.activeApplications |= 0x10) : (this.activeApplications &= 0xFFFFFFEF);
        this.activeApplications = tMState.isAppOwnerMainUnit(Application.PHONE) ? (this.activeApplications |= 2) : (this.activeApplications &= 0xFFFFFFFD);
        this.activeApplications = tMState.isAppOwnerMainUnit(Application.NAVI) ? (this.activeApplications |= 8) : (this.activeApplications &= 0xFFFFFFF7);
        this.activeApplications = tMState.isResourceOwnerMainUnit(Resource.AUDIO_MEDIA) ? (this.activeApplications |= 4) : (this.activeApplications &= 0xFFFFFFFB);
        this.activeApplications = tMState.isAccessRestricted(Resource.SCREEN) ? (this.activeApplications |= 1) : (this.activeApplications &= 0xFFFFFFFE);
        this.logger.log(1000000, "[%1.updateActiveApplications] %2", (Object)LOGCLASS, (long)this.activeApplications);
    }

    @Override
    public void updateMode(IAppState[] iAppStateArray, IResource[] iResourceArray) {
        ArrayList arrayList = new ArrayList(iResourceArray.length);
        for (int i2 = 0; i2 < iResourceArray.length; ++i2) {
            if (iResourceArray[i2].getResourceId() == 2) {
                if (iResourceArray[i2].getOwner() != 1) {
                    if (iResourceArray[i2].getOwner() != 2) continue;
                    this.waitForAudioType = true;
                    this.logger.log(10000000, "[%1.updateMode.waitForAudioType set to] %2 ", (Object)LOGCLASS, (Object)new Boolean(this.waitForAudioType));
                    continue;
                }
                arrayList.add(new CarPlayResource(3, 1, this.getActiveApplications()));
                arrayList.add(new CarPlayResource(4, 1, this.getActiveApplications()));
                arrayList.add(new CarPlayResource(5, 1, this.getActiveApplications()));
                arrayList.add(new CarPlayResource(7, 1, this.getActiveApplications()));
                this.currentActiveResource = null;
                this.waitForAudioType = false;
                this.logger.log(10000000, "[%1.updateMode.waitForAudioType set to] %2 ", (Object)LOGCLASS, (Object)new Boolean(this.waitForAudioType));
                continue;
            }
            arrayList.add(iResourceArray[i2]);
        }
        CarplayRequest carplayRequest = new CarplayRequest(++this.messageIdCounter, 1);
        this.messageMap.put(Util.createLong(carplayRequest.getMessageId()), carplayRequest);
        this.smartphoneManagerListener.updateMode(carplayRequest.getMessageId(), iAppStateArray, (IResource[])arrayList.toArray(new IResource[arrayList.size()]));
    }

    @Override
    public void updateTextInputState(boolean bl) {
        this.smartphoneManagerListener.updateTextInputState(bl);
    }

    @Override
    public void duckAudio(int n, double d2) {
        this.logger.log(1000000, "[%1.duckAudio] dur=%2 vol=%3", (Object)LOGCLASS, (Object)String.valueOf(n), (Object)String.valueOf(d2));
        this.smartphoneManagerListener.duckAudio(n, d2);
    }

    @Override
    public void unduckAudio(int n) {
        this.logger.log(1000000, "[%1.unduckAudio] dur=%2", (Object)LOGCLASS, (long)n);
        this.smartphoneManagerListener.unduckAudio(n);
    }

    @Override
    public void updateMainAudioType(int n) {
        this.logger.log(1000000, "[%1.updateMainAudioType] %2", (Object)LOGCLASS, (Object)TerminalModeUtils.logAudioType(n));
        this.waitForAudioType = false;
        int n2 = 0;
        switch (n) {
            case 1: {
                n2 = 7;
                break;
            }
            case 2: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 5;
                break;
            }
            case 3: {
                n2 = 4;
                break;
            }
        }
        CarplayRequest carplayRequest = new CarplayRequest(++this.messageIdCounter, 2);
        carplayRequest.addParameter("AUDIOTYPE", Util.createInteger(n));
        this.messageMap.put(Util.createLong(carplayRequest.getMessageId()), carplayRequest);
        CarPlayResource carPlayResource = this.currentActiveResource;
        this.currentActiveResource = 0 != n2 ? new CarPlayResource(n2, 2, this.getActiveApplications()) : null;
        if (null != carPlayResource && (carPlayResource.getResourceId() != 3 || null == this.currentActiveResource)) {
            CarPlayResource carPlayResource2 = new CarPlayResource(carPlayResource.getResourceId(), 1, this.getActiveApplications());
            if (null != this.currentActiveResource) {
                this.smartphoneManagerListener.updateMode(carplayRequest.getMessageId(), new IAppState[0], new IResource[]{carPlayResource2, this.currentActiveResource});
            } else {
                this.smartphoneManagerListener.updateMode(carplayRequest.getMessageId(), new IAppState[0], new IResource[]{carPlayResource2});
            }
        } else {
            this.smartphoneManagerListener.updateMode(carplayRequest.getMessageId(), new IAppState[0], new IResource[]{this.currentActiveResource});
        }
    }

    @Override
    public void seek(boolean bl, boolean bl2) {
        if (bl2) {
            this.carPlayDSIController.postButtonEvent(bl ? 4 : 5, 1);
        } else {
            this.carPlayDSIController.postButtonEvent(bl ? 4 : 5, 2);
        }
    }

    @Override
    public void skip(boolean bl, int n) {
        for (int i2 = 0; i2 < n; ++i2) {
            this.carPlayDSIController.postButtonEvent(bl ? 2 : 3, 1);
            this.carPlayDSIController.postButtonEvent(bl ? 2 : 3, 2);
        }
    }

    @Override
    public void resume() {
        if (this.mediaState.is(this.PAUSE)) {
            this.carPlayDSIController.postButtonEvent(6, 1);
            this.carPlayDSIController.postButtonEvent(6, 2);
            this.mediaState = this.NORMAL;
        }
    }

    @Override
    public void pause(boolean bl) {
        this.carPlayDSIController.postButtonEvent(7, 1);
        this.carPlayDSIController.postButtonEvent(7, 2);
        this.mediaState = this.PAUSE;
    }

    @Override
    public void oemAppSelected() {
        this.logger.log(1000000, "[%1.oemAppSelected]", (Object)LOGCLASS);
        ChoiceModelApp choiceModelApp = this.context.getChoiceModel(3200046);
        choiceModelApp.setValue(choiceModelApp.getValue() == 0 ? 1 : 0);
    }

    @Override
    public void updateState(TMState tMState) {
        this.currentState.update(tMState);
    }

    @Override
    public String getDiagKey() {
        return "getActiveConstraints";
    }

    @Override
    public String getDiagValue() {
        Buffer buffer = new Buffer(200);
        int n = this.getActiveApplications();
        buffer.append("Active apps: ");
        buffer.append(n);
        buffer.append("\nScreen\n transfer type: ");
        buffer.append(CarplayUtils.logTransferType(CarplayUtils.getDsiTransferType(n, true, false)));
        buffer.append("\ntake constraint: ");
        buffer.append(CarplayUtils.logResourceSharingPolicy(CarplayUtils.getDsiTakeConstraint(n, true, false)));
        buffer.append("\nborrow constraint: ");
        buffer.append(CarplayUtils.logResourceSharingPolicy(CarplayUtils.getDsiBorrowConstraint(n, true, false)));
        buffer.append("\nAudio\n transfer type: ");
        buffer.append(CarplayUtils.logTransferType(CarplayUtils.getDsiTransferType(n, false, false)));
        buffer.append("\n take constraint: ");
        buffer.append(CarplayUtils.logResourceSharingPolicy(CarplayUtils.getDsiTakeConstraint(n, false, false)));
        buffer.append("\n borrow constraint: ");
        buffer.append(CarplayUtils.logResourceSharingPolicy(CarplayUtils.getDsiBorrowConstraint(n, false, false)));
        return buffer.toString();
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{"textInput(boolean)"};
    }

    @Override
    public void executeDiagCommand(String string, String[] stringArray) {
        if ("textInput(boolean)".equals(string) && null != stringArray && stringArray.length >= 1) {
            this.updateTextInputState(Boolean.valueOf(stringArray[0]));
        }
    }

    @Override
    public void requestNightMode(boolean bl) {
        this.carPlayDSIController.requestNightMode(bl);
    }

    @Override
    public ISpeechRequestHandler getSpeechRequestHandler() {
        return this.speechRequestHandler;
    }

    @Override
    public IPhoneCallController getPhoneCallController() {
        return this.phoneCallController;
    }

    private class RequestModeChangeCarPlay
    extends AbstractDSICommand {
        private static final String LOGCLASS = "RequestModeChangeCarPlay";
        private final TMState newState;
        private final IStateHandler stateHandler;

        public RequestModeChangeCarPlay(IContext iContext, TMState tMState, IStateHandler iStateHandler) {
            super(iContext.getLogger().main(), LOGCLASS, iContext, iContext.getSmartphoneDSIManager());
            this.newState = tMState;
            this.stateHandler = iStateHandler;
        }

        public long getTimeout() {
            return 500L;
        }

        public void execute() {
            this.logger.log(1000000, "[%1.execute]", (Object)LOGCLASS);
            TMDevice tMDevice = this.context.getDeviceManager().getActiveDevice();
            if (null == tMDevice || tMDevice.connectionState().is(TMDevice.ConnectionState.NOT_ATTACHED)) {
                this.stateHandler.updateState(this.newState);
                this.getCommandList().commandFinished();
            }
            this.requestModeChangeCP(this.newState, "user action");
        }

        public boolean updateStates(IAppState[] iAppStateArray, IResource[] iResourceArray, long l) {
            this.logger.log(1000000, "[%1.updateStates]", (Object)LOGCLASS);
            TMState tMState = this.stateHandler.getCurrentState();
            tMState.updateCurrentAppState(iAppStateArray);
            tMState.updateCurrentResourceState(iResourceArray);
            boolean bl = TerminalModeUtils.compareTMStateAfterDSIUpdate(this.newState, tMState);
            if (bl) {
                this.stateHandler.updateState(this.newState);
                if (-1L != l) {
                    this.getCommandList().commandFinishedWithPostCommand(new SendResponseModeChanged(this.context, this.dsiSmartphoneManager, iAppStateArray, iResourceArray, l, this.stateHandler));
                } else {
                    this.getCommandList().commandFinished();
                }
            } else {
                this.getCommandList().commandFinished();
            }
            return bl;
        }

        protected Command canceled() {
            this.logger.log(100000, "[RequestModeChangeCarPlay.canceled] no response");
            return new Command(this.logger){

                public void execute() {
                    RequestModeChangeCarPlay.this.stateHandler.updateState(RequestModeChangeCarPlay.this.newState);
                    this.getCommandList().commandFinished();
                }

                public String getName() {
                    return "RequestModeChangeCarPlay.canceled -> Continue CommandList";
                }
            };
        }

        private void requestModeChangeCP(TMState tMState, String string) {
            CarPlayDSIManager.this.updateActiveApplications(tMState);
            if (TerminalModeUtils.equalsResourcesOwner(CarPlayDSIManager.this.currentState.getResourceOwner(), tMState.getResourceOwner())) {
                CarPlayDSIManager.this.carPlayDSIController.requestModeChange(CarPlayDSIManager.this.getAppStates(tMState), new IDSIResource[0], string);
                CarPlayDSIManager.this.smartphoneManagerListener.updateMode(-1L, CarPlayDSIManager.this.getAppStates(tMState), CarPlayDSIManager.this.getResources(tMState, true));
                return;
            }
            if (CarPlayDSIManager.this.currentState.isResourceOwnerMainUnit(Resource.SCREEN) && tMState.isResourceOwnerDevice(Resource.SCREEN)) {
                if (this.context.getConfiguration().applicationOffset() > 0) {
                    CarPlayDSIManager.this.carPlayDSIController.requestModeChange(CarPlayDSIManager.this.getAppStates(tMState), CarPlayDSIManager.this.filterAudioResources(CarPlayDSIManager.this.getResources(tMState, false), false), string);
                }
                CarPlayDSIManager.this.requestUI(0);
                if (CarPlayDSIManager.this.currentState.getOwnerForResource(Resource.AUDIO_MEDIA) == tMState.getOwnerForResource(Resource.AUDIO_MEDIA)) {
                    CarPlayDSIManager.this.smartphoneManagerListener.updateMode(-1L, CarPlayDSIManager.this.getAppStates(tMState), CarPlayDSIManager.this.getResources(tMState, true));
                    return;
                }
            }
            if (CarPlayDSIManager.this.currentState.isResourceStatePausedByMute(Resource.AUDIO_MEDIA) && tMState.isResourceOwnerMainUnit(Resource.AUDIO_MEDIA)) {
                CarPlayDSIManager.this.smartphoneManagerListener.updateMode(-1L, CarPlayDSIManager.this.getAppStates(tMState), CarPlayDSIManager.this.getResources(tMState, true));
                return;
            }
            CarPlayDSIManager.this.waitForAudioType = tMState.getOwnerForResource(Resource.AUDIO_MEDIA).isNot(ResourceOwner.MAINUNIT) && tMState.getStateForResource(Resource.AUDIO_MEDIA).is(ResourceState.NORMAL);
            this.logger.log(10000000, "[%1.requestModeChangeCP.waitForAudioType set to] %2 ", (Object)LOGCLASS, (Object)new Boolean(CarPlayDSIManager.this.waitForAudioType));
            IDSIResource[] iDSIResourceArray = CarPlayDSIManager.this.filterAudioResources(CarPlayDSIManager.this.getResources(tMState, true));
            if (CarPlayDSIManager.this.currentState.getOwnerForResource(Resource.AUDIO_MEDIA) == tMState.getOwnerForResource(Resource.AUDIO_MEDIA) && CarPlayDSIManager.this.currentState.getStateForResource(Resource.AUDIO_MEDIA) == CarPlayDSIManager.this.currentState.getStateForResource(Resource.AUDIO_MEDIA)) {
                iDSIResourceArray = new IDSIResource[]{iDSIResourceArray[0]};
            }
            if (CarPlayDSIManager.this.currentState.getOwnerForResource(Resource.SCREEN) == tMState.getOwnerForResource(Resource.SCREEN)) {
                iDSIResourceArray = new IDSIResource[]{iDSIResourceArray[1]};
            }
            CarPlayDSIManager.this.carPlayDSIController.requestModeChange(CarPlayDSIManager.this.getAppStates(tMState), iDSIResourceArray, string);
        }
    }
}

