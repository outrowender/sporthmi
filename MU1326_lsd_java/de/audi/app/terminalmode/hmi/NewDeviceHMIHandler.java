/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.hmi;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.SmartphoneManager;
import de.audi.app.terminalmode.actionproxy.IActionProxyListener;
import de.audi.app.terminalmode.device.IDeviceListListener;
import de.audi.app.terminalmode.device.IDeviceManager;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.events.DefaultEventListener;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.collections.Optional;
import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.dispatching.DispatcherBaseAdapter;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.generics.IFluentCollection;
import de.audi.atip.utils.generics.Matcher;
import de.audi.atip.utils.reactive.bindings.ModelBindings;
import de.audi.atip.utils.reactive.bindings.SilentModelBindings;
import de.audi.atip.utils.reactive.observables.Subscription;
import de.audi.atip.utils.reactive.properties.LoggingPropertyFactory;
import de.audi.atip.utils.reactive.properties.Property;
import java.util.Map;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class NewDeviceHMIHandler
extends DefaultEventListener
implements ITerminalModeComponent,
IActionProxyListener {
    private static final String LOGCLASS = "NewDeviceHMIHandler";
    private static final int VALUE_NO = 0;
    private static final int VALUE_YES = 1;
    public static final int DEBOUNCING_TIME = 70;
    private final LogChannel logger;
    private final IContext context;
    IDeviceManager deviceManager;
    private final IDeviceListListener deviceListListener;
    private final GList<TMDevice> newDevicesToBeActivated = Generics.newArrayList();
    private volatile TMDevice disclaimerDevice;
    private IShowScreenStrategy showScreenStrategy;
    private GList<Subscription> buttonListeners = Generics.newArrayList();
    private final IDispatcher dispatcher;
    private final Property<TMDevice> readyForActivation;

    public NewDeviceHMIHandler(final IContext iContext, final int n) {
        this(iContext, new IShowScreenStrategy(){

            public void showScreen() {
                iContext.getFramework().getHmiServiceApp().showPartialPopup(0, n);
            }

            public void removePartialPopup() {
                iContext.getLogger().hmi().log(100000000, "[%1.removePartialPopup]", (Object)NewDeviceHMIHandler.LOGCLASS);
                iContext.getFramework().getHmiServiceApp().removePartialPopup(0, n);
            }
        });
    }

    public NewDeviceHMIHandler(final IContext iContext) {
        this(iContext, new IShowScreenStrategy(){

            public void showScreen() {
                iContext.getChoiceModel(4384).setValue(1);
            }

            public void removePartialPopup() {
            }
        });
    }

    private NewDeviceHMIHandler(IContext iContext, IShowScreenStrategy iShowScreenStrategy) {
        this.context = iContext;
        this.deviceManager = this.context.getDeviceManager();
        this.logger = this.context.getLogger().hmi();
        this.showScreenStrategy = Preconditions.checkNotNull(iShowScreenStrategy);
        this.readyForActivation = LoggingPropertyFactory.create().createProperty("readyForActivation");
        this.dispatcher = new DispatcherBaseAdapter(iContext.getDispatcher());
        this.deviceListListener = new IDeviceListListener(){

            @Override
            public void updateDeviceList(GList<TMDevice> gList) {
                this.checkForDeviceRemovals(gList);
            }

            private void checkForDeviceRemovals(GList<TMDevice> gList) {
                GList<TMDevice> gList2;
                if (!NewDeviceHMIHandler.this.newDevicesToBeActivated.isEmpty() && !(gList2 = gList.fluent().filter(new Predicate<TMDevice>(){

                    @Override
                    public boolean apply(TMDevice tMDevice) {
                        return tMDevice.connectionState().isNot(TMDevice.ConnectionState.ATTACHED);
                    }

                    @Override
                    public /* synthetic */ boolean apply(Object object) {
                        return this.apply((TMDevice)object);
                    }
                }).retainAll(NewDeviceHMIHandler.this.newDevicesToBeActivated, new Matcher<TMDevice, TMDevice>(){

                    @Override
                    public boolean matches(TMDevice tMDevice, TMDevice tMDevice2) {
                        return tMDevice.getUniqueID().equals(tMDevice2.getUniqueID());
                    }

                    @Override
                    public /* synthetic */ boolean matches(Object object, Object object2) {
                        return this.matches((TMDevice)object, (TMDevice)object2);
                    }
                }).toList()).isEmpty()) {
                    NewDeviceHMIHandler.this.logger.log(1000000, "[%1.checkForDeviceRemovals] removed device, hiding popup screen - %2", (Object)NewDeviceHMIHandler.LOGCLASS, gList2);
                    NewDeviceHMIHandler.this.hideScreen("device removed");
                }
            }
        };
    }

    @Override
    public void init() {
        this.logger.log(100000000, "[%1.init]", (Object)LOGCLASS);
        this.readyForActivation.observeNonSticky().filter(new Predicate<TMDevice>(){

            @Override
            public boolean apply(TMDevice tMDevice) {
                return tMDevice.userAcceptState().is(TMDevice.UserAcceptState.INITIAL);
            }

            @Override
            public /* synthetic */ boolean apply(Object object) {
                return this.apply((TMDevice)object);
            }
        }).buffer(70, this.dispatcher).log(this.logger, ": buffered").redirectTo(new Consumer<GList<TMDevice>>(){

            @Override
            public void accept(GList<TMDevice> gList) {
                NewDeviceHMIHandler.this.showScreen(gList, "new device ready");
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((GList)object);
            }
        });
        ModelBindings modelBindings = SilentModelBindings.create();
        modelBindings.from(this.context.getButtonModel(3200040)).keyTyped().redirectTo(new Consumer<ButtonModelApp>(){

            @Override
            public void accept(ButtonModelApp buttonModelApp) {
                NewDeviceHMIHandler.this.logger.log(1000000, "<<- [%1.keyTyped] Smartphone button", (Object)NewDeviceHMIHandler.LOGCLASS);
                NewDeviceHMIHandler.this.onSmarthphoneModeButtonClicked(new Predicate<TMDevice>(){

                    @Override
                    public boolean apply(TMDevice tMDevice) {
                        return tMDevice.smartphoneType().isOneOf(SmartphoneManager.SmartphoneType.ANDROIDAUTO2, SmartphoneManager.SmartphoneType.CARPLAY);
                    }

                    @Override
                    public /* synthetic */ boolean apply(Object object) {
                        return this.apply((TMDevice)object);
                    }
                });
                buttonModelApp.fireEvent(0);
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((ButtonModelApp)object);
            }
        }).addTo(this.buttonListeners);
        modelBindings.from(this.context.getButtonModel(3200065)).keyTyped().redirectTo(new Consumer<ButtonModelApp>(){

            @Override
            public void accept(ButtonModelApp buttonModelApp) {
                NewDeviceHMIHandler.this.logger.log(1000000, "<<- [%1.keyTyped] Carlife button", (Object)NewDeviceHMIHandler.LOGCLASS);
                NewDeviceHMIHandler.this.onSmarthphoneModeButtonClicked(new Predicate<TMDevice>(){

                    @Override
                    public boolean apply(TMDevice tMDevice) {
                        return tMDevice.smartphoneType().is(SmartphoneManager.SmartphoneType.CARLIFE);
                    }

                    @Override
                    public /* synthetic */ boolean apply(Object object) {
                        return this.apply((TMDevice)object);
                    }
                });
                buttonModelApp.fireEvent(0);
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((ButtonModelApp)object);
            }
        }).addTo(this.buttonListeners);
        modelBindings.from(this.context.getButtonModel(3200069)).keyTyped().redirectTo(new Consumer<ButtonModelApp>(){

            @Override
            public void accept(ButtonModelApp buttonModelApp) {
                NewDeviceHMIHandler.this.logger.log(1000000, "<<- [%1.keyTyped] Same device change mode button", (Object)NewDeviceHMIHandler.LOGCLASS);
                NewDeviceHMIHandler.this.onSmarthphoneModeChangeButtonClicked(new Predicate<TMDevice>(){

                    @Override
                    public boolean apply(TMDevice tMDevice) {
                        return tMDevice.smartphoneType().isOneOf(SmartphoneManager.SmartphoneType.ANDROIDAUTO2, SmartphoneManager.SmartphoneType.CARPLAY);
                    }

                    @Override
                    public /* synthetic */ boolean apply(Object object) {
                        return this.apply((TMDevice)object);
                    }
                });
                buttonModelApp.fireEvent(0);
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((ButtonModelApp)object);
            }
        }).addTo(this.buttonListeners);
        modelBindings.from(this.context.getButtonModel(3200032)).keyTyped().redirectTo(new Consumer<ButtonModelApp>(){

            @Override
            public void accept(ButtonModelApp buttonModelApp) {
                NewDeviceHMIHandler.this.logger.log(1000000, "<<- [%1.keyTyped] Native button", (Object)NewDeviceHMIHandler.LOGCLASS);
                GIterator gIterator = NewDeviceHMIHandler.this.newDevicesToBeActivated.iterator();
                while (gIterator.hasNext()) {
                    NewDeviceHMIHandler.this.deviceManager.control((TMDevice)gIterator.next()).setUserAcceptState(TMDevice.UserAcceptState.NATIVE_SELECTED).setStoreUserAcceptState(NewDeviceHMIHandler.this.storeAcceptSelection()).deactivateDevice();
                }
                NewDeviceHMIHandler.this.context.getChoiceModel(4552).setValue(0);
                NewDeviceHMIHandler.this.context.getChoiceModel(4553).resetListener();
                NewDeviceHMIHandler.this.removePartialPopup();
                buttonModelApp.fireEvent(0);
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((ButtonModelApp)object);
            }
        }).addTo(this.buttonListeners);
        modelBindings.from(this.context.getButtonModel(3200041)).keyTyped().redirectTo(new Consumer<ButtonModelApp>(){

            @Override
            public void accept(ButtonModelApp buttonModelApp) {
                NewDeviceHMIHandler.this.logger.log(1000000, "<<- [%1.keyTyped] Accept disclaimer.", (Object)NewDeviceHMIHandler.LOGCLASS);
                NewDeviceHMIHandler.this.deviceManager.control(NewDeviceHMIHandler.this.disclaimerDevice).setUserAcceptState(TMDevice.UserAcceptState.DISCLAIMER_ACCEPTED, NewDeviceHMIHandler.this.storeAcceptSelection()).setStoreUserAcceptState(NewDeviceHMIHandler.this.storeAcceptSelection()).activateDevice();
                NewDeviceHMIHandler.this.hideScreen("ACCEPT BUTTON");
                buttonModelApp.fireEvent(0);
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((ButtonModelApp)object);
            }
        }).addTo(this.buttonListeners);
        modelBindings.from(this.context.getButtonModel(3200042)).keyTyped().redirectTo(new Consumer<ButtonModelApp>(){

            @Override
            public void accept(ButtonModelApp buttonModelApp) {
                NewDeviceHMIHandler.this.logger.log(1000000, "<<- [%1.keyTyped] Disclaimer Decline", (Object)NewDeviceHMIHandler.LOGCLASS);
                NewDeviceHMIHandler.this.deviceManager.control(NewDeviceHMIHandler.this.disclaimerDevice).setUserAcceptState(TMDevice.UserAcceptState.NATIVE).deactivateDevice();
                NewDeviceHMIHandler.this.context.getChoiceModel(4552).setValue(0);
                NewDeviceHMIHandler.this.context.getChoiceModel(4553).resetListener();
                buttonModelApp.fireEvent(0);
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((ButtonModelApp)object);
            }
        }).addTo(this.buttonListeners);
        final ChoiceModelApp choiceModelApp = this.context.getChoiceModel(3200034);
        choiceModelApp.setChoiceListener(new DefaultChoiceListener(){

            public void itemSelected(int n, int n2, int n3, int n4) {
                choiceModelApp.setValue(choiceModelApp.getValue() == 0 ? 1 : 0);
                NewDeviceHMIHandler.this.logger.log(1000000, "<<- [%1.itemSelected] checked=%2", (Object)NewDeviceHMIHandler.LOGCLASS, (Object)String.valueOf(choiceModelApp.getValue() == 1));
                NewDeviceHMIHandler.this.context.fireEventOnModel(n);
            }
        });
        this.context.getDeviceManager().addDeviceListListener(this.deviceListListener);
        this.context.addActionProxyListener(1003, this);
        this.context.getEventBus().registerListener(this);
    }

    @Override
    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        GIterator<Subscription> gIterator = this.buttonListeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().cancel();
        }
        this.buttonListeners.clear();
        this.context.getChoiceModel(3200034).resetListener();
        this.context.getDeviceManager().removeDeviceListListener(this.deviceListListener);
        this.context.removeActionProxyListener(this);
        this.context.getEventBus().unregisterListener(this);
    }

    private void onSmarthphoneModeChangeButtonClicked(Predicate<TMDevice> predicate) {
        TMDeviceControl tMDeviceControl = this.deviceManager.control(this.deviceManager.getActiveDevice());
        this.logger.log(10000000, "[%1.onSmarthphoneModeChangeButtonClicked]", (Object)LOGCLASS);
        if (tMDeviceControl.getTmDevice().isCarlifeDevice() && tMDeviceControl.getTmDevice().isActive()) {
            this.logger.log(10000000, "[%1.onSmarthphoneModeChangeButtonClicked] deactivate device and set to initial.", (Object)LOGCLASS);
            this.logger.log(10000000, "[%1.onSmarthphoneModeChangeButtonClicked] predicate: %2.", (Object)LOGCLASS, (Object)tMDeviceControl);
            tMDeviceControl.activateOtherModeforDevice();
        }
    }

    private void onSmarthphoneModeButtonClicked(Predicate<TMDevice> predicate) {
        IFluentCollection.PartitionResult<TMDevice> partitionResult = this.newDevicesToBeActivated.fluent().partition(predicate);
        Optional<TMDevice> optional = partitionResult.applied().fluent().first();
        optional.ifExists(new Consumer<TMDevice>(){

            @Override
            public void accept(TMDevice tMDevice) {
                if (tMDevice.wasDisclaimerPreviouslyAccepted()) {
                    NewDeviceHMIHandler.this.context.getChoiceModel(3200050).setValue(1);
                    NewDeviceHMIHandler.this.deviceManager.control(tMDevice).setUserAcceptState(TMDevice.UserAcceptState.DISCLAIMER_ACCEPTED, NewDeviceHMIHandler.this.storeAcceptSelection()).setStoreUserAcceptState(NewDeviceHMIHandler.this.storeAcceptSelection()).activateDevice();
                } else {
                    NewDeviceHMIHandler.this.deviceManager.control(tMDevice).setUserAcceptState(TMDevice.UserAcceptState.TM_SELECTED);
                    NewDeviceHMIHandler.this.setDisclaimerDevice(tMDevice);
                }
                NewDeviceHMIHandler.this.context.getChoiceModel(4552).setValue(tMDevice.isCarplayDevice() ? 1 : 2);
                NewDeviceHMIHandler.this.context.getChoiceModel(4553).resetListener();
                NewDeviceHMIHandler.this.removePartialPopup();
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((TMDevice)object);
            }
        });
        GList<TMDevice> gList = partitionResult.rejected();
        gList.fluent().forEach(new Consumer<TMDevice>(){

            @Override
            public void accept(TMDevice tMDevice) {
                NewDeviceHMIHandler.this.logger.log(10000000, "[%1.keyTyped] Smartphone button, deactivating carlife", (Object)NewDeviceHMIHandler.LOGCLASS);
                NewDeviceHMIHandler.this.deviceManager.control(tMDevice).setUserAcceptState(TMDevice.UserAcceptState.NATIVE_SELECTED).setStoreUserAcceptState(NewDeviceHMIHandler.this.storeAcceptSelection()).deactivateDevice();
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((TMDevice)object);
            }
        });
    }

    private boolean storeAcceptSelection() {
        return this.context.getConfiguration().getStoreUserAcceptState() || this.context.getChoiceModel(3200034).getValue() == 1;
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        if (1003 == n) {
            this.hideScreen("AP_METHOD_RESET_NEW_DEVICE_DETECTION");
        }
    }

    @Override
    public void requestUserDecision(TMDevice tMDevice) {
        if (!tMDevice.wasDisclaimerPreviouslyAccepted() && tMDevice.userAcceptState().isNot(TMDevice.UserAcceptState.DISCLAIMER_ACCEPTED) && tMDevice.connectionState().isNot(TMDevice.ConnectionState.NOT_ATTACHED)) {
            this.showDisclaimerScreen(tMDevice, "requestUserDecision");
        }
    }

    public void setDisclaimerDevice(TMDevice tMDevice) {
        this.disclaimerDevice = tMDevice;
        this.context.getChoiceModel(3200044).setValue(DisclaimerDeviceTypeChoice.getModelValueFor(tMDevice));
    }

    @Override
    public void readyForActivation(TMDevice tMDevice) {
        this.readyForActivation.accept(tMDevice);
    }

    private synchronized void showScreen(GList<TMDevice> gList, String string) {
        if (!this.isPopupAlreadyShowing(string)) {
            this.newDevicesToBeActivated.addAll(gList);
            this.context.getChoiceModel(3200050).setValue(0);
            this.context.getChoiceModel(3200045).setValue(NewDeviceTypeChoice.getModelValueFor(this.newDevicesToBeActivated));
            this.logger.log(1000000, "->> [%1.showScreen] showing native/smartphone for %2 because %3", (Object)LOGCLASS, gList, (Object)string);
            this.showScreenStrategy.showScreen();
            this.context.getChoiceModel(4553).setChoiceListener(new DefaultChoiceListener(){

                public void keyTyped(int n, int n2, int n3) {
                    NewDeviceHMIHandler.this.logger.log(1000000, "<<- [%1.keyTyped] SMARTPHONE_CONNECT_POPUP_CLOSED_CHOICE", (Object)NewDeviceHMIHandler.LOGCLASS);
                    NewDeviceHMIHandler.this.hideScreen("POPUP CLOSED");
                    GIterator gIterator = NewDeviceHMIHandler.this.newDevicesToBeActivated.iterator();
                    while (gIterator.hasNext()) {
                        NewDeviceHMIHandler.this.deviceManager.control((TMDevice)gIterator.next()).setUserAcceptState(TMDevice.UserAcceptState.NATIVE).deactivateDevice();
                    }
                    NewDeviceHMIHandler.this.context.getChoiceModel(4552).setValue(0);
                    NewDeviceHMIHandler.this.context.getChoiceModel(4553).resetListener();
                }
            });
        } else {
            this.logger.log(1000000, "[%1.showScreen] already showing for %2, request for %3 because of %4 is ignored", (Object)LOGCLASS, this.newDevicesToBeActivated, gList, (Object)string);
        }
    }

    private synchronized void showDisclaimerScreen(TMDevice tMDevice, String string) {
        if (!this.isPopupAlreadyShowing(string)) {
            this.setDisclaimerDevice(tMDevice);
            this.newDevicesToBeActivated.add(tMDevice);
            this.context.getChoiceModel(3200045).setValue(NewDeviceTypeChoice.getModelValueFor(this.newDevicesToBeActivated));
            this.logger.log(1000000, "->> [%1.showScreen] jumping to disclaimer for %2 because %3", (Object)LOGCLASS, (Object)tMDevice, (Object)string);
            this.context.getChoiceModel(4384).setValue(3);
        }
    }

    private synchronized boolean isPopupAlreadyShowing(String string) {
        if (this.disclaimerDevice != null) {
            this.logger.log(1000000, "[%1.isPopupAlreadyShowing] already showing disclaimer for %2, request for %3 is ignored", (Object)LOGCLASS, (Object)this.disclaimerDevice, (Object)string);
            return true;
        }
        if (!this.newDevicesToBeActivated.isEmpty()) {
            this.logger.log(1000000, "[%1.isPopupAlreadyShowing] already showing for %2, request for %3 is ignored", (Object)LOGCLASS, this.newDevicesToBeActivated, (Object)string);
            return true;
        }
        return false;
    }

    private synchronized void hideScreen(String string) {
        this.logger.log(1000000, "->> [%1.hideScreen] because %2, was showing %3", (Object)LOGCLASS, (Object)string, this.newDevicesToBeActivated);
        this.context.getChoiceModel(4384).setValue(0);
        this.context.getChoiceModel(3200034).setValue(0);
        this.removePartialPopup();
        this.newDevicesToBeActivated.clear();
        this.disclaimerDevice = null;
    }

    private void removePartialPopup() {
        this.showScreenStrategy.removePartialPopup();
    }

    private static interface IShowScreenStrategy {
        public void showScreen();

        public void removePartialPopup();
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static final class NewDeviceTypeChoice {
        public static final int CARPLAY = 0;
        public static final int ANDROID = 1;
        public static final int CARLIFE = 2;
        public static final int CARPLAY_AND_CARLIFE = 3;
        public static final int ANDROID_AND_CARLIFE = 4;

        public static int getModelValueFor(GList<TMDevice> gList) {
            if (gList.size() > 1) {
                Optional<TMDevice> optional = gList.fluent().tryFind(new Predicate<TMDevice>(){

                    @Override
                    public boolean apply(TMDevice tMDevice) {
                        return tMDevice.smartphoneType().is(SmartphoneManager.SmartphoneType.CARLIFE);
                    }

                    @Override
                    public /* synthetic */ boolean apply(Object object) {
                        return this.apply((TMDevice)object);
                    }
                });
                Optional<TMDevice> optional2 = gList.fluent().tryFind(new Predicate<TMDevice>(){

                    @Override
                    public boolean apply(TMDevice tMDevice) {
                        return tMDevice.smartphoneType().is(SmartphoneManager.SmartphoneType.CARPLAY);
                    }

                    @Override
                    public /* synthetic */ boolean apply(Object object) {
                        return this.apply((TMDevice)object);
                    }
                });
                Optional<TMDevice> optional3 = gList.fluent().tryFind(new Predicate<TMDevice>(){

                    @Override
                    public boolean apply(TMDevice tMDevice) {
                        return tMDevice.smartphoneType().is(SmartphoneManager.SmartphoneType.ANDROIDAUTO2);
                    }

                    @Override
                    public /* synthetic */ boolean apply(Object object) {
                        return this.apply((TMDevice)object);
                    }
                });
                if (optional.exists()) {
                    if (optional3.exists()) {
                        return 4;
                    }
                    if (optional2.exists()) {
                        return 3;
                    }
                    return 2;
                }
                return optional3.exists() ? 1 : 0;
            }
            SmartphoneManager.SmartphoneType smartphoneType = gList.get(0).smartphoneType();
            return smartphoneType.is(SmartphoneManager.SmartphoneType.ANDROIDAUTO2) ? 1 : (smartphoneType.is(SmartphoneManager.SmartphoneType.CARPLAY) ? 0 : 2);
        }
    }

    public static final class NewDeviceDetectedChoice {
        public static final int NONE = 0;
        public static final int NATIVE_OR_SMARTPHONE_CARPLAY = 1;
        public static final int NATIVE_OR_SMARTPHONE_ANDROID = 2;
        public static final int DATA_DISCLAIMER = 3;
    }

    public static final class DisclaimerDeviceTypeChoice {
        public static final int CARPLAY = 1;
        public static final int ANDROID = 2;
        public static final int CARLIFE = 3;

        public static int getModelValueFor(TMDevice tMDevice) {
            SmartphoneManager.SmartphoneType smartphoneType = tMDevice.smartphoneType();
            return smartphoneType.is(SmartphoneManager.SmartphoneType.ANDROIDAUTO2) ? 2 : (smartphoneType.is(SmartphoneManager.SmartphoneType.CARPLAY) ? 1 : 3);
        }
    }

    public static final class SmartphoneTabbarTypeChoice {
        public static final int EMPTY = 0;
        public static final int CARPLAY = 1;
        public static final int ANDROID = 2;
    }
}

