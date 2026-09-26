/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.generics.GMap
 *  de.audi.atip.utils.generics.Generics
 *  de.audi.atip.utils.reactive.observables.Observable
 *  de.audi.atip.utils.reactive.observables.Observables
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.device.IDeviceManager;
import de.audi.app.terminalmode.dsi.carlife.DSICarlifeDefaultListener;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIAppNotInstalledManager$1;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIAppNotInstalledManager$2;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIAppNotInstalledManager$3;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIAppNotInstalledManager$4;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIAppNotInstalledManager$5;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeListenerDistributor;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.ResourceOwnerChange;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.generics.GMap;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.reactive.observables.Observable;
import de.audi.atip.utils.reactive.observables.Observables;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.Job;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.DSICarlifeListener;
import org.dsi.ifc.carlife.Resource;

public class CarlifeDSIAppNotInstalledManager
extends DSICarlifeDefaultListener
implements ITerminalModeComponent {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final DispatcherBase dispatcher;
    private final IStateHandler stateHandler;
    private final IContext context;
    private volatile Job timerJob;
    private volatile boolean onceVideoWasAvailable;
    private static final int CARLIFE_APP_IN_BACKGROUND;

    public CarlifeDSIAppNotInstalledManager(LogChannel logChannel, CarlifeListenerDistributor carlifeListenerDistributor, DispatcherBase dispatcherBase, IStateHandler iStateHandler, IContext iContext, IDeviceManager iDeviceManager) {
        this.logger = logChannel;
        carlifeListenerDistributor.addListener(new DSICarlifeListener[]{this});
        this.dispatcher = dispatcherBase;
        this.stateHandler = iStateHandler;
        this.onceVideoWasAvailable = false;
        this.context = iContext;
        Observables.combineLatest((Observable)iStateHandler.getServiceStartedProperty(), (Observable)iStateHandler.getStateResourceProperty(de.audi.app.terminalmode.statemachine.Resource.SCREEN), (Observable)iDeviceManager.getProperties().activeDevice(), (Observable)iStateHandler.getStateResourceProperty(de.audi.app.terminalmode.statemachine.Resource.NOTIFICATION)).using(new CarlifeDSIAppNotInstalledManager$2(this)).subscribe((Consumer)new CarlifeDSIAppNotInstalledManager$1(this));
        Observables.combineLatest((Observable)iStateHandler.getServiceStartedProperty(), (Observable)iStateHandler.getStateResourceProperty(de.audi.app.terminalmode.statemachine.Resource.SCREEN), (Observable)iStateHandler.getStateResourceProperty(de.audi.app.terminalmode.statemachine.Resource.NOTIFICATION)).using(new CarlifeDSIAppNotInstalledManager$4(this)).distinctUntilChanged().subscribe((Consumer)new CarlifeDSIAppNotInstalledManager$3(this));
    }

    @Override
    public void init() {
    }

    @Override
    public void deinit() {
    }

    @Override
    public void requestModeChange(Resource[] resourceArray, AppState[] appStateArray) {
        Resource resource = null;
        for (int i2 = 0; i2 < resourceArray.length; ++i2) {
            if (resourceArray[i2] == null || resourceArray[i2].getResourceID() != 0) continue;
            resource = resourceArray[i2];
            break;
        }
        if (resource != null && resource.getOwner() == 2) {
            if (null != this.timerJob) {
                this.logger.log(14808325, "[%1.requestModeChange] cancel times", (Object)"CarlifeDSIAppNotInstalledManager");
                this.timerJob.cancel();
            }
            this.logger.log(14808325, "[%1.requestModeChange] Video available", (Object)"CarlifeDSIAppNotInstalledManager");
            GMap gMap = Generics.newHashMap();
            gMap.put((Object)new ResourceOwnerChange(de.audi.app.terminalmode.statemachine.Resource.NOTIFICATION, ResourceOwner.DEVICE, ResourceOwner.MAINUNIT), (Object)new CarlifeDSIAppNotInstalledManager$5(this));
            this.stateHandler.addStateChangeActions(gMap);
            this.onceVideoWasAvailable = true;
        }
    }

    static /* synthetic */ Job access$002(CarlifeDSIAppNotInstalledManager carlifeDSIAppNotInstalledManager, Job job) {
        carlifeDSIAppNotInstalledManager.timerJob = job;
        return carlifeDSIAppNotInstalledManager.timerJob;
    }

    static /* synthetic */ IContext access$200(CarlifeDSIAppNotInstalledManager carlifeDSIAppNotInstalledManager) {
        return carlifeDSIAppNotInstalledManager.context;
    }

    static /* synthetic */ IStateHandler access$300(CarlifeDSIAppNotInstalledManager carlifeDSIAppNotInstalledManager) {
        return carlifeDSIAppNotInstalledManager.stateHandler;
    }

    static /* synthetic */ DispatcherBase access$400(CarlifeDSIAppNotInstalledManager carlifeDSIAppNotInstalledManager) {
        return carlifeDSIAppNotInstalledManager.dispatcher;
    }

    static /* synthetic */ Job access$000(CarlifeDSIAppNotInstalledManager carlifeDSIAppNotInstalledManager) {
        return carlifeDSIAppNotInstalledManager.timerJob;
    }

    static /* synthetic */ boolean access$500(CarlifeDSIAppNotInstalledManager carlifeDSIAppNotInstalledManager) {
        return carlifeDSIAppNotInstalledManager.onceVideoWasAvailable;
    }

    static /* synthetic */ LogChannel access$600(CarlifeDSIAppNotInstalledManager carlifeDSIAppNotInstalledManager) {
        return carlifeDSIAppNotInstalledManager.logger;
    }

    static /* synthetic */ boolean access$502(CarlifeDSIAppNotInstalledManager carlifeDSIAppNotInstalledManager, boolean bl) {
        carlifeDSIAppNotInstalledManager.onceVideoWasAvailable = bl;
        return carlifeDSIAppNotInstalledManager.onceVideoWasAvailable;
    }
}

