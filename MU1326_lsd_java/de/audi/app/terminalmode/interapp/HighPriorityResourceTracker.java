/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.interapp;

import de.audi.app.terminalmode.CommandListHelper;
import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.terminalmode.diagnosis.IDiagnosisManager;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.bap.ecall.data.EmergencyNumber;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;
import de.audi.atip.interapp.phone.IEcallState;
import de.audi.atip.interapp.phone.ITelEcallStateListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.power.DefaultPowerEventListener;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.observables.Observables;
import de.audi.atip.utils.reactive.properties.Property;
import de.audi.atip.utils.reactive.properties.PropertyFactory;
import de.audi.tghu.command.CommandList;
import de.esolutions.fw.util.commons.Buffer;

public class HighPriorityResourceTracker
extends DefaultPowerEventListener
implements ITerminalModeComponent,
ITelEcallStateListener,
MsgListener {
    private final Property<Boolean> eCallActive;
    private final Property<Boolean> clampSOff;
    private final Property<Boolean> rvcActive;
    private final IServiceManager serviceManager;
    private final CommandListHelper commandListHelper;
    private final IContext context;
    private final LogChannel lc;
    private final IDiagnosisManager diagnosisManager;
    private final IDiagnosisCommandProvider diagnosisCommandProvider;
    private final IStateHandler stateHandler;
    private final IDSISmartphoneManager.ISmartphoneProperties smartphoneProperties;
    public static final int SCREEN_NOT_BLOCKED = 0;
    public static final int SCREEN_BLOCKED_CARPLAY_BY_ECALL = 1;
    public static final int SCREEN_BLOCKED_ANDROIDAUTO_BY_ECALL = 2;
    public static final int SCREEN_BLOCKED_CARPLAY_BY_RVC = 3;
    public static final int SCREEN_BLOCKED_ANDROIDAUTO_BY_RVC = 4;
    public static final int SCREEN_BLOCKED_CARLIFE_BY_ECALL = 5;
    public static final int SCREEN_BLOCKED_CARLIFE_BY_RVC = 6;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelEcallStateListener;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;

    public HighPriorityResourceTracker(IServiceManager iServiceManager, LogChannel logChannel, CommandListHelper commandListHelper, IContext iContext, IDiagnosisManager iDiagnosisManager, IStateHandler iStateHandler, PropertyFactory propertyFactory, IDSISmartphoneManager.ISmartphoneProperties iSmartphoneProperties) {
        this.serviceManager = iServiceManager;
        this.commandListHelper = commandListHelper;
        this.lc = logChannel;
        this.context = iContext;
        this.diagnosisManager = iDiagnosisManager;
        this.stateHandler = iStateHandler;
        this.smartphoneProperties = iSmartphoneProperties;
        this.eCallActive = propertyFactory.createProperty("eCallActive", new Boolean(false));
        this.clampSOff = propertyFactory.createProperty("clampSOff", new Boolean(false));
        this.rvcActive = propertyFactory.createProperty("rvcActive", new Boolean(false));
        this.diagnosisCommandProvider = new IDiagnosisCommandProvider(){

            public String[] getDiagKeys() {
                return new String[]{"HighPriorityResourceTracker enable RVC", "HighPriorityResourceTracker disable RVC", "HighPriorityResourceTracker enable eCall", "HighPriorityResourceTracker disable eCall"};
            }

            public void executeDiagCommand(String string, String[] stringArray) {
                if ("HighPriorityResourceTracker enable RVC".equals(string)) {
                    HighPriorityResourceTracker.this.processMsg(108);
                } else if ("HighPriorityResourceTracker disable RVC".equals(string)) {
                    HighPriorityResourceTracker.this.processMsg(107);
                } else if ("HighPriorityResourceTracker enable eCall".equals(string)) {
                    HighPriorityResourceTracker.this.updateEcallState(0, new DiagECallState(true));
                } else if ("HighPriorityResourceTracker disable eCall".equals(string)) {
                    HighPriorityResourceTracker.this.updateEcallState(0, new DiagECallState(false));
                }
            }
        };
    }

    public void init() {
        this.serviceManager.registerService(class$de$audi$atip$interapp$phone$ITelEcallStateListener == null ? (class$de$audi$atip$interapp$phone$ITelEcallStateListener = HighPriorityResourceTracker.class$("de.audi.atip.interapp.phone.ITelEcallStateListener")) : class$de$audi$atip$interapp$phone$ITelEcallStateListener, this, IServiceManager.EMPTY_PARAMETERS);
        this.serviceManager.registerService(class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = HighPriorityResourceTracker.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener, this, IServiceManager.EMPTY_PARAMETERS);
        this.serviceManager.registerService(class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = HighPriorityResourceTracker.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener, this, IServiceManager.EMPTY_PARAMETERS);
        this.diagnosisManager.addCommandProvider(0, this.diagnosisCommandProvider);
        this.context.getDeviceManager().getProperties().activeDevice().subscribe(new Consumer<TMDevice>(){

            @Override
            public void accept(TMDevice tMDevice) {
                if (((Boolean)HighPriorityResourceTracker.this.eCallActive.get()).booleanValue()) {
                    HighPriorityResourceTracker.this.lc.log(1000000, "[HighPriorityResourceTracker] ECall Lockscreenchanges");
                    HighPriorityResourceTracker.this.context.getChoiceModel(3200049).setValue(tMDevice.isCarplayDevice() ? 1 : (tMDevice.isAndroidAutoDevice() ? 2 : 5));
                } else if (((Boolean)HighPriorityResourceTracker.this.rvcActive.get()).booleanValue()) {
                    HighPriorityResourceTracker.this.lc.log(1000000, "[HighPriorityResourceTracker] RVC Lockscreenchanges");
                    HighPriorityResourceTracker.this.context.getChoiceModel(3200049).setValue(tMDevice.isCarplayDevice() ? 3 : (tMDevice.isAndroidAutoDevice() ? 4 : 6));
                }
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((TMDevice)object);
            }
        });
        Observables.combineLatest(this.eCallActive, this.clampSOff, this.rvcActive).using(new Observables.Combinator3<Boolean, Boolean, Boolean, Boolean>(){

            @Override
            public Boolean combine(Boolean bl, Boolean bl2, Boolean bl3) {
                boolean bl4;
                boolean bl5 = bl4 = bl != false || bl2 != false || bl3 != false;
                String string = !bl4 ? "not blocked" : new Buffer().append(bl != false ? "eCallActive" : "").append(bl2 != false ? "clampSOff" : "").append(bl3 != false ? "rvcActive" : "").toString();
                HighPriorityResourceTracker.this.lc.log(1000000, "[HighPriorityResourceTracker.combine] %1 ", (Object)string);
                return new Boolean(bl4);
            }

            @Override
            public /* synthetic */ Object combine(Object object, Object object2, Object object3) {
                return this.combine((Boolean)object, (Boolean)object2, (Boolean)object3);
            }
        }).distinctUntilChanged().redirectTo(new Consumer<Boolean>(){

            @Override
            public void accept(Boolean bl) {
                if (bl.booleanValue()) {
                    HighPriorityResourceTracker.this.acquireHighPriorityResources(Resource.SCREEN);
                } else {
                    HighPriorityResourceTracker.this.releaseHighPriorityResources(Resource.SCREEN);
                }
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((Boolean)object);
            }
        });
    }

    public void deinit() {
    }

    public void updateEcallState(int n, IEcallState iEcallState) {
        this.eCallActive.accept(new Boolean(iEcallState.hasActiveCall()));
        if (iEcallState.hasActiveCall()) {
            this.acquireHighPriorityResources(Resource.AUDIO_MEDIA);
            this.context.getChoiceModel(3200049).setValue(this.context.getDeviceManager().getActiveDevice().isCarplayDevice() ? 1 : 2);
        } else {
            this.releaseHighPriorityResources(Resource.AUDIO_MEDIA);
            this.context.getChoiceModel(3200049).setValue(0);
        }
    }

    public void processMsg(int n) {
        if (n == 108) {
            if (this.context.getDeviceManager().getActiveDevice().isCarplayDevice()) {
                ChoiceModelApp choiceModelApp;
                choiceModelApp.setValue((choiceModelApp = this.context.getChoiceModel(3200046)).getValue() == 0 ? 1 : 0);
                this.context.getChoiceModel(3200049).setValue(this.context.getDeviceManager().getActiveDevice().isCarplayDevice() ? 3 : 4);
                this.rvcActive.accept(new Boolean(true));
            } else {
                this.context.getChoiceModel(3200049).setValue(this.context.getDeviceManager().getActiveDevice().isCarplayDevice() ? 3 : 4);
                this.rvcActive.accept(new Boolean(true));
            }
            this.smartphoneProperties.getPropertyMURVCActive().accept(new Boolean(true));
        } else if (n == 107) {
            this.rvcActive.accept(new Boolean(false));
            this.context.getChoiceModel(3200049).setValue(0);
            this.smartphoneProperties.getPropertyMURVCActive().accept(new Boolean(false));
        }
    }

    public void notifyPowerListenerOnEnterState(int n, int n2) {
        if (n == 0) {
            this.clampSOff.accept(new Boolean(false));
        }
    }

    public void notifyPowerListenerOnExitState(int n, int n2) {
        if (n == 0) {
            this.clampSOff.accept(new Boolean(true));
        }
    }

    private void acquireHighPriorityResources(final Resource resource) {
        this.commandListHelper.create().addSingle(new AbstractCommand(this.lc, new StringBuffer().append("HighPriorityResourceTracker$Acquire ").append(resource).toString(), this.context){

            public void execute() {
                TMState tMState = HighPriorityResourceTracker.this.stateHandler.getCurrentState();
                tMState.restrictAccessTo(resource);
                CommandList commandList = HighPriorityResourceTracker.this.stateHandler.changeState(tMState, IRequestor.MAINUNIT, -1L);
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        }).execute("HighPriorityResourceTracker.acquireHighPriorityResources");
    }

    private void releaseHighPriorityResources(final Resource resource) {
        this.commandListHelper.create().addSingle(new AbstractCommand(this.lc, new StringBuffer().append("HighPriorityResourceTracker$Release ").append(resource).toString(), this.context){

            public void execute() {
                TMState tMState = HighPriorityResourceTracker.this.stateHandler.getCurrentState();
                tMState.allowAccessTo(resource);
                CommandList commandList = HighPriorityResourceTracker.this.stateHandler.changeState(tMState, IRequestor.MAINUNIT, -1L);
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        }).execute("HighPriorityResourceTracker.releaseHiPrioResources");
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class DiagECallState
    implements IEcallState {
        private final boolean serviceActive;

        public DiagECallState(boolean bl) {
            this.serviceActive = bl;
        }

        public boolean hasActiveCall() {
            return this.serviceActive;
        }

        public boolean isServiceActive() {
            return this.serviceActive;
        }

        public int getServiceKind() {
            return 0;
        }

        public PhoneCall getCall() {
            return null;
        }

        public boolean isEmergencyCallType() {
            return false;
        }

        public boolean isCustomerCallNotAllowed() {
            return false;
        }

        public boolean isCustomerCallAllowed() {
            return false;
        }

        public boolean isLowPrioritySOSEmergencyCallType() {
            return false;
        }

        public EmergencyNumber[] getAllowedEmergencyNumbers() {
            return new EmergencyNumber[0];
        }

        public String getEmergencyNumberToBeDialed() {
            return null;
        }
    }
}

