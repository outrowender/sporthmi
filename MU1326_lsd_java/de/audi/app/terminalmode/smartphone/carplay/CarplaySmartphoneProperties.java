/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carplay;

import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.dsi.DSIResource;
import de.audi.app.terminalmode.dsi.IDSIAppState;
import de.audi.app.terminalmode.dsi.IDSIResource;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController;
import de.audi.app.terminalmode.dsi.carplay.ICarplayDSIController;
import de.audi.app.terminalmode.smartphone.BTState;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.SPIServiceState;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.reactive.observables.Observables;
import de.audi.atip.utils.reactive.observables.Subscription;

public class CarplaySmartphoneProperties
implements ITerminalModeComponent {
    private static final String LOGCLASS = "CarplaySmartphoneProperties";
    private final LogChannel logger;
    private final GList<Subscription> subscriptionList;
    private final ICarplayDSIController dsiController;
    private final IDSISmartphoneManager.ISmartphoneProperties smartphoneProperties;
    private volatile Subscription subscribe;

    public IDSISmartphoneManager.ISmartphoneProperties getSmartphoneProperties() {
        return this.smartphoneProperties;
    }

    public CarplaySmartphoneProperties(CarplayDSILifecycleController carplayDSILifecycleController, LogChannel logChannel, IDSISmartphoneManager.ISmartphoneProperties iSmartphoneProperties) {
        this.logger = logChannel;
        this.smartphoneProperties = iSmartphoneProperties;
        this.subscriptionList = Generics.newArrayList();
        this.dsiController = carplayDSILifecycleController.getDioDsiController();
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.subscribe = this.smartphoneProperties.getPropertyMUPhonecallActive().distinctUntilChanged().subscribe(new Consumer<Boolean>(){

            @Override
            public void accept(Boolean bl) {
                if (bl.booleanValue()) {
                    CarplaySmartphoneProperties.this.dsiController.requestModeChange(new IDSIAppState[]{new IDSIAppState(){

                        public int getAppStateId() {
                            return 1;
                        }

                        public int getOwner() {
                            return 1;
                        }

                        public int getSpeechMode() {
                            return 0;
                        }

                        public int getDSIAppStateId() {
                            return 1;
                        }

                        public int getDSIOwner() {
                            return 1;
                        }

                        public int getDSISpeechMode() {
                            return 0;
                        }
                    }}, new IDSIResource[]{new DSIResource.Builder().setpOwner(1).setpResourceId(1).setDsiResourceId(2).setDsiResourceOwner(1).setDsiTakeType(3).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(3).build(), new DSIResource.Builder().setpOwner(1).setpResourceId(3).setDsiResourceId(1).setDsiResourceOwner(1).setDsiTakeType(3).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(3).build()}, "mainunit call active");
                } else {
                    CarplaySmartphoneProperties.this.dsiController.requestModeChange(new IDSIAppState[]{new IDSIAppState(){

                        public int getAppStateId() {
                            return 1;
                        }

                        public int getOwner() {
                            return 3;
                        }

                        public int getSpeechMode() {
                            return 0;
                        }

                        public int getDSIAppStateId() {
                            return 1;
                        }

                        public int getDSIOwner() {
                            return 0;
                        }

                        public int getDSISpeechMode() {
                            return 0;
                        }
                    }}, new IDSIResource[]{new DSIResource.Builder().setpOwner(1).setpResourceId(1).setDsiResourceId(2).setDsiResourceOwner(1).setDsiTakeType(4).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(0).build(), new DSIResource.Builder().setpOwner(1).setpResourceId(3).setDsiResourceId(1).setDsiResourceOwner(1).setDsiTakeType(4).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(0).build()}, "mainunit call inactive");
                }
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((Boolean)object);
            }
        });
    }

    public void activate() {
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
        Observables.combineLatest(this.smartphoneProperties.getPropertyBluetooth(), this.smartphoneProperties.getPropertyMUHFPPhonecallActive(), this.smartphoneProperties.getPropertySPIServiceState()).subscribe(new Observables.Consumer3<BTState, Boolean, SPIServiceState>(){

            @Override
            public void accept(BTState bTState, Boolean bl, SPIServiceState sPIServiceState) {
                if (bl.booleanValue() && sPIServiceState.is(SPIServiceState.STARTED)) {
                    CarplaySmartphoneProperties.this.dsiController.requestModeChange(new IDSIAppState[0], new IDSIResource[]{new DSIResource.Builder().setpOwner(1).setpResourceId(1).setDsiResourceId(2).setDsiResourceOwner(1).setDsiTakeType(4).setDSITransferPriority(0).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(0).build(), new DSIResource.Builder().setpOwner(1).setpResourceId(2).setDsiResourceId(1).setDsiResourceOwner(1).setDsiTakeType(4).setDSITransferPriority(0).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(0).build()}, "unborrow after activating while call active");
                }
            }

            @Override
            public /* synthetic */ void accept(Object object, Object object2, Object object3) {
                this.accept((BTState)object, (Boolean)object2, (SPIServiceState)object3);
            }
        }).addTo(this.subscriptionList);
        Observables.combineLatest(this.smartphoneProperties.getPropertyMURVCActive(), this.smartphoneProperties.getPropertySPIServiceState()).subscribe(new Observables.Consumer2<Boolean, SPIServiceState>(){
            private boolean previousState = false;

            @Override
            public void accept(Boolean bl, SPIServiceState sPIServiceState) {
                if (SPIServiceState.STARTED.is(sPIServiceState)) {
                    if (this.previousState && !bl.booleanValue()) {
                        CarplaySmartphoneProperties.this.dsiController.requestModeChange(new IDSIAppState[0], new IDSIResource[]{new DSIResource.Builder().setpOwner(1).setpResourceId(1).setDsiResourceId(2).setDsiResourceOwner(1).setDsiTakeType(4).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(0).setDSITransferPriority(0).build()}, "rvc off");
                        this.previousState = false;
                    }
                } else {
                    this.previousState = bl;
                }
            }

            @Override
            public /* synthetic */ void accept(Object object, Object object2) {
                this.accept((Boolean)object, (SPIServiceState)object2);
            }
        }).addTo(this.subscriptionList);
    }

    public void deinit() {
        this.subscribe.cancel();
    }

    public void deactivate() {
        GIterator<Subscription> gIterator = this.subscriptionList.iterator();
        while (gIterator.hasNext()) {
            this.cancelSubscription(gIterator.next());
        }
    }

    private void cancelSubscription(Subscription subscription) {
        if (null != subscription) {
            subscription.cancel();
        }
    }
}

