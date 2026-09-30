/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.device.IDeviceManager;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.dsi.carlife.DSICarlifeDefaultListener;
import de.audi.app.terminalmode.smartphone.TMRequestModeChangeCallback;
import de.audi.app.terminalmode.smartphone.carlife.ApplicationUpdate;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeListenerDistributor;
import de.audi.app.terminalmode.smartphone.carlife.ResourceUpdate;
import de.audi.app.terminalmode.smartphone.carlife.UpdateCarlifeModes;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateChange;
import de.audi.app.terminalmode.statemachine.IStateChangeAction;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.ResourceOwnerChange;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.generics.GCopyOnWriteList;
import de.audi.atip.utils.generics.GMap;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.reactive.observables.Observables;
import de.audi.tghu.command.CommandList;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.Job;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.DSICarlifeListener;
import org.dsi.ifc.carlife.Resource;

public class CarlifeDSIAppNotInstalledManager
extends DSICarlifeDefaultListener
implements ITerminalModeComponent {
    private static final String LOGCLASS = "CarlifeDSIAppNotInstalledManager";
    private final LogChannel logger;
    private final DispatcherBase dispatcher;
    private final IStateHandler stateHandler;
    private final IContext context;
    private volatile Job timerJob;
    private volatile boolean onceVideoWasAvailable;
    private static final int CARLIFE_APP_IN_BACKGROUND = 3;

    public CarlifeDSIAppNotInstalledManager(LogChannel logChannel, CarlifeListenerDistributor carlifeListenerDistributor, DispatcherBase dispatcherBase, IStateHandler iStateHandler, IContext iContext, IDeviceManager iDeviceManager) {
        this.logger = logChannel;
        carlifeListenerDistributor.addListener(new DSICarlifeListener[]{this});
        this.dispatcher = dispatcherBase;
        this.stateHandler = iStateHandler;
        this.onceVideoWasAvailable = false;
        this.context = iContext;
        Observables.combineLatest(iStateHandler.getServiceStartedProperty(), iStateHandler.getStateResourceProperty(de.audi.app.terminalmode.statemachine.Resource.SCREEN), iDeviceManager.getProperties().activeDevice(), iStateHandler.getStateResourceProperty(de.audi.app.terminalmode.statemachine.Resource.NOTIFICATION)).using(new Observables.Combinator4<Boolean, ResourceOwner, TMDevice, ResourceOwner, Boolean>(){

            @Override
            public Boolean combine(Boolean bl, ResourceOwner resourceOwner, TMDevice tMDevice, ResourceOwner resourceOwner2) {
                if (!tMDevice.isCarlifeDevice()) {
                    return new Boolean(false);
                }
                boolean bl2 = bl != false && ResourceOwner.DEVICE.is(resourceOwner) && null == CarlifeDSIAppNotInstalledManager.this.timerJob && ResourceOwner.MAINUNIT.isNot(resourceOwner2) && !CarlifeDSIAppNotInstalledManager.this.onceVideoWasAvailable;
                CarlifeDSIAppNotInstalledManager.this.logger.log(1000000, "[%1.combine] %2", (Object)CarlifeDSIAppNotInstalledManager.LOGCLASS, (Object)new Boolean(bl2));
                if (!bl.booleanValue()) {
                    CarlifeDSIAppNotInstalledManager.this.onceVideoWasAvailable = false;
                }
                return new Boolean(bl2);
            }

            @Override
            public /* synthetic */ Object combine(Object object, Object object2, Object object3, Object object4) {
                return this.combine((Boolean)object, (ResourceOwner)object2, (TMDevice)object3, (ResourceOwner)object4);
            }
        }).subscribe(new Consumer<Boolean>(){

            @Override
            public void accept(Boolean bl) {
                if (bl.booleanValue()) {
                    CarlifeDSIAppNotInstalledManager.this.timerJob = CarlifeDSIAppNotInstalledManager.this.dispatcher.execute(new AbstractDispatcherRunnable("CarlifeDSIAppNotInstalledManager.screen"){

                        public void run() {
                            GCopyOnWriteList<ResourceUpdate> gCopyOnWriteList = Generics.newCopyOnWriteArrayList();
                            gCopyOnWriteList.add(new ResourceUpdate(de.audi.app.terminalmode.statemachine.Resource.NOTIFICATION, ResourceOwner.MAINUNIT));
                            GCopyOnWriteList<ApplicationUpdate> gCopyOnWriteList2 = Generics.newCopyOnWriteArrayList();
                            CarlifeDSIAppNotInstalledManager.this.context.getCommandListHelper().create().addSingle(new UpdateCarlifeModes(CarlifeDSIAppNotInstalledManager.this.context, gCopyOnWriteList, gCopyOnWriteList2, CarlifeDSIAppNotInstalledManager.this.stateHandler, new TMRequestModeChangeCallback(){

                                public void modeChanged(TMState tMState) {
                                }
                            })).execute("CarlifeDSIAppNotInstalledManager.updateCarlifeModes");
                            CarlifeDSIAppNotInstalledManager.this.timerJob = null;
                        }
                    }, 3000L);
                }
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((Boolean)object);
            }
        });
        Observables.combineLatest(iStateHandler.getServiceStartedProperty(), iStateHandler.getStateResourceProperty(de.audi.app.terminalmode.statemachine.Resource.SCREEN), iStateHandler.getStateResourceProperty(de.audi.app.terminalmode.statemachine.Resource.NOTIFICATION)).using(new Observables.Combinator3<Boolean, ResourceOwner, ResourceOwner, Boolean>(){

            @Override
            public Boolean combine(Boolean bl, ResourceOwner resourceOwner, ResourceOwner resourceOwner2) {
                CarlifeDSIAppNotInstalledManager.this.logger.log(100000, "[%1.combine]", (Object)CarlifeDSIAppNotInstalledManager.LOGCLASS);
                return new Boolean(bl != false && ResourceOwner.MAINUNIT.is(resourceOwner) && ResourceOwner.MAINUNIT.is(resourceOwner2));
            }

            @Override
            public /* synthetic */ Object combine(Object object, Object object2, Object object3) {
                return this.combine((Boolean)object, (ResourceOwner)object2, (ResourceOwner)object3);
            }
        }).distinctUntilChanged().subscribe(new Consumer<Boolean>(){

            @Override
            public void accept(Boolean bl) {
                if (bl.booleanValue()) {
                    GCopyOnWriteList<ResourceUpdate> gCopyOnWriteList = Generics.newCopyOnWriteArrayList();
                    gCopyOnWriteList.add(new ResourceUpdate(de.audi.app.terminalmode.statemachine.Resource.NOTIFICATION, ResourceOwner.DEVICE));
                    GCopyOnWriteList<ApplicationUpdate> gCopyOnWriteList2 = Generics.newCopyOnWriteArrayList();
                    CarlifeDSIAppNotInstalledManager.this.context.getCommandListHelper().create().addSingle(new UpdateCarlifeModes(CarlifeDSIAppNotInstalledManager.this.context, gCopyOnWriteList, gCopyOnWriteList2, CarlifeDSIAppNotInstalledManager.this.stateHandler, new TMRequestModeChangeCallback(){

                        public void modeChanged(TMState tMState) {
                        }
                    })).execute("CarlifeDSIAppNotInstalledManager.updateCarlifeModes");
                }
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((Boolean)object);
            }
        });
    }

    public void init() {
    }

    public void deinit() {
    }

    public void requestModeChange(Resource[] resourceArray, AppState[] appStateArray) {
        Resource resource = null;
        for (int i2 = 0; i2 < resourceArray.length; ++i2) {
            if (resourceArray[i2] == null || resourceArray[i2].getResourceID() != 0) continue;
            resource = resourceArray[i2];
            break;
        }
        if (resource != null && resource.getOwner() == 2) {
            if (null != this.timerJob) {
                this.logger.log(100000000, "[%1.requestModeChange] cancel times", (Object)LOGCLASS);
                this.timerJob.cancel();
            }
            this.logger.log(100000000, "[%1.requestModeChange] Video available", (Object)LOGCLASS);
            GMap<IStateChange, IStateChangeAction.IStateChangeActionOverride> gMap = Generics.newHashMap();
            gMap.put(new ResourceOwnerChange(de.audi.app.terminalmode.statemachine.Resource.NOTIFICATION, ResourceOwner.DEVICE, ResourceOwner.MAINUNIT), new IStateChangeAction.AbstractStateChangeActionOverride(){

                public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
                    CarlifeDSIAppNotInstalledManager.this.logger.log(1000000, "[%1.changeState] Notification: MU", (Object)CarlifeDSIAppNotInstalledManager.LOGCLASS);
                    CarlifeDSIAppNotInstalledManager.this.context.getChoiceModel(3200012).setValue(3);
                }
            });
            this.stateHandler.addStateChangeActions(gMap);
            this.onceVideoWasAvailable = true;
        }
    }
}

