/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.reactive.observables.Observable
 *  de.audi.atip.utils.reactive.observables.Observables
 */
package de.audi.app.terminalmode.interapp;

import de.audi.app.terminalmode.CommandListHelper;
import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.terminalmode.diagnosis.IDiagnosisManager;
import de.audi.app.terminalmode.interapp.HighPriorityResourceTracker$1;
import de.audi.app.terminalmode.interapp.HighPriorityResourceTracker$2;
import de.audi.app.terminalmode.interapp.HighPriorityResourceTracker$3;
import de.audi.app.terminalmode.interapp.HighPriorityResourceTracker$4;
import de.audi.app.terminalmode.interapp.HighPriorityResourceTracker$5;
import de.audi.app.terminalmode.interapp.HighPriorityResourceTracker$6;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager$ISmartphoneProperties;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.phone.IEcallState;
import de.audi.atip.interapp.phone.ITelEcallStateListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.power.DefaultPowerEventListener;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.observables.Observable;
import de.audi.atip.utils.reactive.observables.Observables;
import de.audi.atip.utils.reactive.properties.Property;
import de.audi.atip.utils.reactive.properties.PropertyFactory;

public class HighPriorityResourceTracker
extends DefaultPowerEventListener
implements ITerminalModeComponent,
ITelEcallStateListener,
MsgListener {
    private final Property eCallActive;
    private final Property clampSOff;
    private final Property rvcActive;
    private final IServiceManager serviceManager;
    private final CommandListHelper commandListHelper;
    private final IContext context;
    private final LogChannel lc;
    private final IDiagnosisManager diagnosisManager;
    private final IDiagnosisCommandProvider diagnosisCommandProvider;
    private final IStateHandler stateHandler;
    private final IDSISmartphoneManager$ISmartphoneProperties smartphoneProperties;
    public static final int SCREEN_NOT_BLOCKED;
    public static final int SCREEN_BLOCKED_CARPLAY_BY_ECALL;
    public static final int SCREEN_BLOCKED_ANDROIDAUTO_BY_ECALL;
    public static final int SCREEN_BLOCKED_CARPLAY_BY_RVC;
    public static final int SCREEN_BLOCKED_ANDROIDAUTO_BY_RVC;
    public static final int SCREEN_BLOCKED_CARLIFE_BY_ECALL;
    public static final int SCREEN_BLOCKED_CARLIFE_BY_RVC;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelEcallStateListener;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;

    public HighPriorityResourceTracker(IServiceManager iServiceManager, LogChannel logChannel, CommandListHelper commandListHelper, IContext iContext, IDiagnosisManager iDiagnosisManager, IStateHandler iStateHandler, PropertyFactory propertyFactory, IDSISmartphoneManager$ISmartphoneProperties iDSISmartphoneManager$ISmartphoneProperties) {
        this.serviceManager = iServiceManager;
        this.commandListHelper = commandListHelper;
        this.lc = logChannel;
        this.context = iContext;
        this.diagnosisManager = iDiagnosisManager;
        this.stateHandler = iStateHandler;
        this.smartphoneProperties = iDSISmartphoneManager$ISmartphoneProperties;
        this.eCallActive = propertyFactory.createProperty("eCallActive", new Boolean(false));
        this.clampSOff = propertyFactory.createProperty("clampSOff", new Boolean(false));
        this.rvcActive = propertyFactory.createProperty("rvcActive", new Boolean(false));
        this.diagnosisCommandProvider = new HighPriorityResourceTracker$1(this);
    }

    @Override
    public void init() {
        this.serviceManager.registerService(class$de$audi$atip$interapp$phone$ITelEcallStateListener == null ? (class$de$audi$atip$interapp$phone$ITelEcallStateListener = HighPriorityResourceTracker.class$("de.audi.atip.interapp.phone.ITelEcallStateListener")) : class$de$audi$atip$interapp$phone$ITelEcallStateListener, this, IServiceManager.EMPTY_PARAMETERS);
        this.serviceManager.registerService(class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = HighPriorityResourceTracker.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener, this, IServiceManager.EMPTY_PARAMETERS);
        this.serviceManager.registerService(class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = HighPriorityResourceTracker.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener, this, IServiceManager.EMPTY_PARAMETERS);
        this.diagnosisManager.addCommandProvider(0, this.diagnosisCommandProvider);
        this.context.getDeviceManager().getProperties().activeDevice().subscribe(new HighPriorityResourceTracker$2(this));
        Observables.combineLatest((Observable)this.eCallActive, (Observable)this.clampSOff, (Observable)this.rvcActive).using(new HighPriorityResourceTracker$4(this)).distinctUntilChanged().redirectTo((Consumer)new HighPriorityResourceTracker$3(this));
    }

    @Override
    public void deinit() {
    }

    @Override
    public void updateEcallState(int n, IEcallState iEcallState) {
        this.eCallActive.accept(new Boolean(iEcallState.hasActiveCall()));
        if (iEcallState.hasActiveCall()) {
            this.acquireHighPriorityResources(Resource.AUDIO_MEDIA);
            this.context.getChoiceModel(835989504).setValue(this.context.getDeviceManager().getActiveDevice().isCarplayDevice() ? 1 : 2);
        } else {
            this.releaseHighPriorityResources(Resource.AUDIO_MEDIA);
            this.context.getChoiceModel(835989504).setValue(0);
        }
    }

    @Override
    public void processMsg(int n) {
        if (n == 108) {
            if (this.context.getDeviceManager().getActiveDevice().isCarplayDevice()) {
                ChoiceModelApp choiceModelApp;
                choiceModelApp.setValue((choiceModelApp = this.context.getChoiceModel(785657856)).getValue() == 0 ? 1 : 0);
                this.context.getChoiceModel(835989504).setValue(this.context.getDeviceManager().getActiveDevice().isCarplayDevice() ? 3 : 4);
                this.rvcActive.accept(new Boolean(true));
            } else {
                this.context.getChoiceModel(835989504).setValue(this.context.getDeviceManager().getActiveDevice().isCarplayDevice() ? 3 : 4);
                this.rvcActive.accept(new Boolean(true));
            }
            this.smartphoneProperties.getPropertyMURVCActive().accept(new Boolean(true));
        } else if (n == 107) {
            this.rvcActive.accept(new Boolean(false));
            this.context.getChoiceModel(835989504).setValue(0);
            this.smartphoneProperties.getPropertyMURVCActive().accept(new Boolean(false));
        }
    }

    @Override
    public void notifyPowerListenerOnEnterState(int n, int n2) {
        if (n == 0) {
            this.clampSOff.accept(new Boolean(false));
        }
    }

    @Override
    public void notifyPowerListenerOnExitState(int n, int n2) {
        if (n == 0) {
            this.clampSOff.accept(new Boolean(true));
        }
    }

    private void acquireHighPriorityResources(Resource resource) {
        this.commandListHelper.create().addSingle(new HighPriorityResourceTracker$5(this, this.lc, new StringBuffer().append("HighPriorityResourceTracker$Acquire ").append(resource).toString(), this.context, resource)).execute("HighPriorityResourceTracker.acquireHighPriorityResources");
    }

    private void releaseHighPriorityResources(Resource resource) {
        this.commandListHelper.create().addSingle(new HighPriorityResourceTracker$6(this, this.lc, new StringBuffer().append("HighPriorityResourceTracker$Release ").append(resource).toString(), this.context, resource)).execute("HighPriorityResourceTracker.releaseHiPrioResources");
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ Property access$000(HighPriorityResourceTracker highPriorityResourceTracker) {
        return highPriorityResourceTracker.eCallActive;
    }

    static /* synthetic */ LogChannel access$100(HighPriorityResourceTracker highPriorityResourceTracker) {
        return highPriorityResourceTracker.lc;
    }

    static /* synthetic */ IContext access$200(HighPriorityResourceTracker highPriorityResourceTracker) {
        return highPriorityResourceTracker.context;
    }

    static /* synthetic */ Property access$300(HighPriorityResourceTracker highPriorityResourceTracker) {
        return highPriorityResourceTracker.rvcActive;
    }

    static /* synthetic */ void access$400(HighPriorityResourceTracker highPriorityResourceTracker, Resource resource) {
        highPriorityResourceTracker.acquireHighPriorityResources(resource);
    }

    static /* synthetic */ void access$500(HighPriorityResourceTracker highPriorityResourceTracker, Resource resource) {
        highPriorityResourceTracker.releaseHighPriorityResources(resource);
    }

    static /* synthetic */ IStateHandler access$600(HighPriorityResourceTracker highPriorityResourceTracker) {
        return highPriorityResourceTracker.stateHandler;
    }
}

