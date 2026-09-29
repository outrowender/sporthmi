/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.generics.GList
 *  de.audi.atip.utils.generics.Generics
 *  de.audi.atip.utils.reactive.observables.Observable
 *  de.audi.atip.utils.reactive.observables.Observables
 */
package de.audi.app.terminalmode.smartphone.carplay;

import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController;
import de.audi.app.terminalmode.dsi.carplay.ICarplayDSIController;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager$ISmartphoneProperties;
import de.audi.app.terminalmode.smartphone.carplay.CarplaySmartphoneProperties$1;
import de.audi.app.terminalmode.smartphone.carplay.CarplaySmartphoneProperties$2;
import de.audi.app.terminalmode.smartphone.carplay.CarplaySmartphoneProperties$3;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.reactive.observables.Observable;
import de.audi.atip.utils.reactive.observables.Observables;
import de.audi.atip.utils.reactive.observables.Subscription;

public class CarplaySmartphoneProperties
implements ITerminalModeComponent {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final GList subscriptionList;
    private final ICarplayDSIController dsiController;
    private final IDSISmartphoneManager$ISmartphoneProperties smartphoneProperties;
    private volatile Subscription subscribe;

    public IDSISmartphoneManager$ISmartphoneProperties getSmartphoneProperties() {
        return this.smartphoneProperties;
    }

    public CarplaySmartphoneProperties(CarplayDSILifecycleController carplayDSILifecycleController, LogChannel logChannel, IDSISmartphoneManager$ISmartphoneProperties iDSISmartphoneManager$ISmartphoneProperties) {
        this.logger = logChannel;
        this.smartphoneProperties = iDSISmartphoneManager$ISmartphoneProperties;
        this.subscriptionList = Generics.newArrayList();
        this.dsiController = carplayDSILifecycleController.getDioDsiController();
    }

    @Override
    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"CarplaySmartphoneProperties");
        this.subscribe = this.smartphoneProperties.getPropertyMUPhonecallActive().distinctUntilChanged().subscribe((Consumer)new CarplaySmartphoneProperties$1(this));
    }

    public void activate() {
        this.logger.log(1078071040, "[%1.activate]", (Object)"CarplaySmartphoneProperties");
        Observables.combineLatest((Observable)this.smartphoneProperties.getPropertyBluetooth(), (Observable)this.smartphoneProperties.getPropertyMUHFPPhonecallActive(), (Observable)this.smartphoneProperties.getPropertySPIServiceState()).subscribe(new CarplaySmartphoneProperties$2(this)).addTo(this.subscriptionList);
        Observables.combineLatest((Observable)this.smartphoneProperties.getPropertyMURVCActive(), (Observable)this.smartphoneProperties.getPropertySPIServiceState()).subscribe(new CarplaySmartphoneProperties$3(this)).addTo(this.subscriptionList);
    }

    @Override
    public void deinit() {
        this.subscribe.cancel();
    }

    public void deactivate() {
        GIterator gIterator = this.subscriptionList.iterator();
        while (gIterator.hasNext()) {
            this.cancelSubscription((Subscription)gIterator.next());
        }
    }

    private void cancelSubscription(Subscription subscription) {
        if (null != subscription) {
            subscription.cancel();
        }
    }

    static /* synthetic */ ICarplayDSIController access$000(CarplaySmartphoneProperties carplaySmartphoneProperties) {
        return carplaySmartphoneProperties.dsiController;
    }
}

