/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.SmartphoneManager;
import de.audi.app.terminalmode.device.IActiveDeviceStateListener;
import de.audi.app.terminalmode.device.IDeviceListListener;
import de.audi.app.terminalmode.device.IDeviceManager;
import de.audi.app.terminalmode.device.PhysicalDevice;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.device.TMDeviceFactory;
import de.audi.app.terminalmode.device.TMDeviceID;
import de.audi.app.terminalmode.diagnosis.IDiagnosisDataProvider;
import de.audi.app.terminalmode.dsi.smartphoneintegration.ISMIDSIControllerListener;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.util.IStreamableStorageContainer;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.generics.FluentCollection;
import de.audi.atip.utils.generics.Function;
import de.audi.atip.utils.generics.GCopyOnWriteList;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.GMap;
import de.audi.atip.utils.generics.GSet;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.reactive.properties.Property;
import de.audi.atip.utils.reactive.properties.PropertyFactory;
import de.audi.atip.utils.reactive.properties.ReadOnlyProperty;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.smartphoneintegration.Device;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class DeviceManager
implements IDeviceManager,
IDiagnosisDataProvider,
ITerminalModeComponent {
    private static final String LOGCLASS = "DeviceManager";
    private static final TMDevice INVALID_DEVICE = TMDevice.INVALID;
    private final LogChannel logger;
    private final IContext context;
    private final GCopyOnWriteList<IDeviceListListener> deviceListListener;
    private final GCopyOnWriteList<IActiveDeviceStateListener> activeDeviceStateListener;
    private volatile TMDevice currentActiveDevice = INVALID_DEVICE;
    private final IStateHandler stateHandler;
    private final TMDeviceFactory deviceFactory;
    private final TMDeviceControl.IDeviceControlToDeviceManager deviceControlToDeviceManagerCallback;
    private final DeviceMappings deviceMappings;
    private final GMap<Integer, String> idsToUniqueIds = Generics.newHashMap();
    private final Property<TMDevice> activeDevice;
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$TMDeviceFactory;
    static /* synthetic */ Class class$de$audi$app$terminalmode$util$IStreamableStorageContainer;

    public DeviceManager(IContext iContext, IStateHandler iStateHandler, PropertyFactory propertyFactory) {
        this.context = iContext;
        this.logger = iContext.getLogger().main();
        this.deviceFactory = (TMDeviceFactory)iContext.get(class$de$audi$app$terminalmode$device$TMDeviceFactory == null ? (class$de$audi$app$terminalmode$device$TMDeviceFactory = DeviceManager.class$("de.audi.app.terminalmode.device.TMDeviceFactory")) : class$de$audi$app$terminalmode$device$TMDeviceFactory);
        this.deviceListListener = Generics.newCopyOnWriteArrayList();
        this.activeDeviceStateListener = Generics.newCopyOnWriteArrayList();
        iContext.getDiagnosisManager().addDataProvider(-1, this);
        this.deviceMappings = new DeviceMappings();
        this.deviceControlToDeviceManagerCallback = new DeviceActivationRequestHandler();
        this.stateHandler = iStateHandler;
        this.activeDevice = propertyFactory.createProperty("ActiveDevice");
    }

    @Override
    public void init() {
        this.logger.log(100000000, "[%1.init]", (Object)LOGCLASS);
        this.readAndInitDevicesFromStorage();
    }

    private void readAndInitDevicesFromStorage() {
        IStreamableStorageContainer iStreamableStorageContainer = (IStreamableStorageContainer)this.context.get(class$de$audi$app$terminalmode$util$IStreamableStorageContainer == null ? (class$de$audi$app$terminalmode$util$IStreamableStorageContainer = DeviceManager.class$("de.audi.app.terminalmode.util.IStreamableStorageContainer")) : class$de$audi$app$terminalmode$util$IStreamableStorageContainer);
        GList gList = ((FluentCollection)((FluentCollection)FluentCollection.from(iStreamableStorageContainer.readListFromStorage(TMDevice.CREATOR)).filter((Predicate)new Predicate<TMDevice>(){

            @Override
            public boolean apply(TMDevice tMDevice) {
                return tMDevice.smartphoneType().isNot(SmartphoneManager.SmartphoneType.UNKNOWN);
            }

            @Override
            public /* synthetic */ boolean apply(Object object) {
                return this.apply((TMDevice)object);
            }
        })).forEach((Consumer)new Consumer<TMDevice>(){

            @Override
            public void accept(TMDevice tMDevice) {
                tMDevice.setConnectionState(TMDevice.ConnectionState.INVALID);
                DeviceManager.this.deviceMappings.addTmDevice(tMDevice, null);
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((TMDevice)object);
            }
        })).toList();
        this.logger.log(10000000, "<!> [DeviceManager.readAndInitDevicesFromStorage] %1", gList);
    }

    public ISMIDSIControllerListener createSMDControllerListener() {
        return new SMIControllerListener();
    }

    @Override
    public void deinit() {
        this.deviceMappings.clear();
    }

    @Override
    public void addDeviceListListener(IDeviceListListener iDeviceListListener) {
        if (this.deviceListListener.addIfAbsent(iDeviceListListener)) {
            this.logger.log(100000000, "[%1.addDeviceListListener] notify %2 on add - %3", (Object)LOGCLASS, (Object)iDeviceListListener, (Object)this.formatDeviceListLog(this.getDeviceList()));
            iDeviceListListener.updateDeviceList(this.getDeviceList());
        }
    }

    @Override
    public void addActiveDeviceListener(IActiveDeviceStateListener iActiveDeviceStateListener) {
        if (this.activeDeviceStateListener.addIfAbsent(iActiveDeviceStateListener)) {
            this.logger.log(100000000, "[%1.addActiveDeviceListener] notify %2 on add - %3", (Object)LOGCLASS, (Object)iActiveDeviceStateListener, (Object)this.currentActiveDevice);
            iActiveDeviceStateListener.updateActiveDeviceState(this.currentActiveDevice);
        }
    }

    @Override
    public void removeDeviceListListener(IDeviceListListener iDeviceListListener) {
        this.deviceListListener.remove(iDeviceListListener);
    }

    @Override
    public void removeActiveDeviceListener(IActiveDeviceStateListener iActiveDeviceStateListener) {
        this.activeDeviceStateListener.remove(iActiveDeviceStateListener);
    }

    @Override
    public TMDevice getActiveDevice() {
        return this.currentActiveDevice;
    }

    private void notifyDeviceListChanged(GList<IDeviceListListener> gList, GList<TMDevice> gList2, String string) {
        this.logger.log(10000000, "<*> [%1.notifyDeviceListChanged] %2 - %3", (Object)LOGCLASS, (Object)string, (Object)this.formatDeviceListLog(gList2));
        GIterator<IDeviceListListener> gIterator = gList.iterator();
        while (gIterator.hasNext()) {
            try {
                gIterator.next().updateDeviceList(gList2);
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.notifyDeviceListChanged]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    private String formatDeviceListLog(GList<TMDevice> gList) {
        Buffer buffer = new Buffer(100);
        GIterator<TMDevice> gIterator = gList.iterator();
        while (gIterator.hasNext()) {
            buffer.append("\n(");
            buffer.append(gIterator.next());
            buffer.append(")");
        }
        return buffer.toString();
    }

    private void notifyActiveDeviceStateChanged(GList<IActiveDeviceStateListener> gList, TMDevice tMDevice, String string) {
        this.logger.log(10000000, "<*> [%1.notifyActiveDeviceStateChanged] %2 - %3", (Object)LOGCLASS, (Object)string, (Object)tMDevice);
        GIterator<IActiveDeviceStateListener> gIterator = gList.iterator();
        while (gIterator.hasNext()) {
            try {
                gIterator.next().updateActiveDeviceState(tMDevice);
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.notifyActiveDeviceStateChanged]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
        this.activeDevice.accept(tMDevice);
    }

    private GList<TMDevice> getDeviceList() {
        return this.deviceMappings.getDeviceList();
    }

    public static GList<SmartphoneManager.SmartphoneType> getSmarphoneTypes(Device device) {
        return DeviceManager.getSmartphoneTypes(device.connectionMethod);
    }

    private static GList<SmartphoneManager.SmartphoneType> getSmartphoneTypes(int n) {
        GList<SmartphoneManager.SmartphoneType> gList = Generics.newArrayList();
        if ((n & 6) > 0) {
            gList.add(SmartphoneManager.SmartphoneType.CARPLAY);
        }
        if ((n & 8) > 0) {
            gList.add(SmartphoneManager.SmartphoneType.ANDROIDAUTO2);
        }
        if ((n & 0x20) > 0) {
            gList.add(SmartphoneManager.SmartphoneType.CARLIFE);
        }
        return gList;
    }

    @Override
    public String getDiagKey() {
        return "getDeviceList";
    }

    @Override
    public String getDiagValue() {
        Buffer buffer = new Buffer(100);
        GIterator<TMDevice> gIterator = this.getDeviceList().iterator();
        while (gIterator.hasNext()) {
            buffer.append(gIterator.next().toString());
            buffer.append('\n');
        }
        return buffer.toString();
    }

    @Override
    public TMDeviceControl control(TMDevice tMDevice) {
        return this.deviceMappings.getControlFor(tMDevice.getUniqueID());
    }

    @Override
    public TMDeviceControl control(TMDeviceID tMDeviceID) {
        return this.deviceMappings.getControlFor(tMDeviceID);
    }

    @Override
    public IDeviceManager.IDeviceManagerProperties getProperties() {
        return new DeviceManagerProperties();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private class DeviceMappings {
        private final GMap<TMDeviceID, TMDeviceControl> addressesToControls = Generics.newHashMap();
        private final GCopyOnWriteList<TMDevice> tmDevicesList = Generics.newCopyOnWriteArrayList();

        private DeviceMappings() {
        }

        public synchronized GList<TMDevice> getDeviceList() {
            return this.tmDevicesList;
        }

        public synchronized void addTmDevice(TMDevice tMDevice, PhysicalDevice physicalDevice) {
            TMDeviceControl tMDeviceControl = DeviceManager.this.deviceFactory.createTMDeviceControl(tMDevice, DeviceManager.this.deviceControlToDeviceManagerCallback);
            if (null != physicalDevice) {
                physicalDevice.addTMDeviceControl(tMDeviceControl);
            }
            this.addressesToControls.put(tMDevice.getUniqueID(), tMDeviceControl);
            this.tmDevicesList.add(tMDevice);
        }

        public synchronized TMDeviceControl getControlFor(TMDeviceID tMDeviceID) {
            TMDeviceControl tMDeviceControl = this.addressesToControls.get(tMDeviceID);
            Preconditions.checkNotNull((Object)tMDeviceControl, new StringBuffer().append("Could not resolve ").append(tMDeviceID).toString());
            return tMDeviceControl;
        }

        public synchronized GSet<TMDeviceID> getAddresses() {
            return Generics.newHashSet(this.addressesToControls.keySet());
        }

        public synchronized void deleteDeviceFromPersistence(TMDeviceControl tMDeviceControl) {
            TMDevice tMDevice = tMDeviceControl.getTmDevice();
            this.addressesToControls.remove(tMDevice.getUniqueID());
            this.tmDevicesList.remove(tMDevice);
        }

        public synchronized void clear() {
            this.addressesToControls.clear();
            this.tmDevicesList.clear();
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private class SMIControllerListener
    implements ISMIDSIControllerListener {
        private SMIControllerListener() {
        }

        @Override
        public void updateDiscoveredDevices(GList<Device> gList) {
            Object object;
            Object object2 = gList.iterator();
            while (object2.hasNext()) {
                object = object2.next();
                DeviceManager.this.idsToUniqueIds.put(new Integer(((Device)object).getDeviceID()), ((Device)object).getDeviceAddress());
            }
            object2 = Generics.newArrayListWithCapacity(gList.size() * 2);
            object = gList.iterator();
            while (object.hasNext()) {
                Device device = (Device)object.next();
                PhysicalDevice physicalDevice = new PhysicalDevice(device, DeviceManager.this.context.getSMIDSIController());
                GIterator<SmartphoneManager.SmartphoneType> gIterator = DeviceManager.getSmarphoneTypes(device).iterator();
                while (gIterator.hasNext()) {
                    object2.add(new DiscoveredDevice(new TMDeviceID(device.deviceAddress, gIterator.next()), physicalDevice));
                }
            }
            this.checkForNewDevices((GList<DiscoveredDevice>)object2);
            this.notifyDiscoveredTMDeviceControls((GList<DiscoveredDevice>)object2);
            this.checkDeviceRemovals((GList<DiscoveredDevice>)object2);
        }

        private void checkForNewDevices(GList<DiscoveredDevice> gList) {
            ((FluentCollection)FluentCollection.from(gList).filter((Predicate)new Predicate<DiscoveredDevice>(){

                @Override
                public boolean apply(DiscoveredDevice discoveredDevice) {
                    return !DeviceManager.this.deviceMappings.getAddresses().contains(discoveredDevice.tmDeviceID);
                }

                @Override
                public /* synthetic */ boolean apply(Object object) {
                    return this.apply((DiscoveredDevice)object);
                }
            })).forEach((Consumer)new Consumer<DiscoveredDevice>(){

                @Override
                public void accept(DiscoveredDevice discoveredDevice) {
                    DeviceManager.this.deviceMappings.addTmDevice(new TMDevice(discoveredDevice.tmDeviceID), discoveredDevice.device);
                }

                @Override
                public /* synthetic */ void accept(Object object) {
                    this.accept((DiscoveredDevice)object);
                }
            });
        }

        private void notifyDiscoveredTMDeviceControls(GList<DiscoveredDevice> gList) {
            TMDeviceControl tMDeviceControl;
            DiscoveredDevice discoveredDevice;
            GIterator<DiscoveredDevice> gIterator = gList.iterator();
            while (gIterator.hasNext()) {
                discoveredDevice = gIterator.next();
                tMDeviceControl = DeviceManager.this.deviceMappings.getControlFor(discoveredDevice.tmDeviceID);
                discoveredDevice.device.addTMDeviceControl(tMDeviceControl);
            }
            gIterator = gList.iterator();
            while (gIterator.hasNext()) {
                discoveredDevice = gIterator.next();
                tMDeviceControl = DeviceManager.this.deviceMappings.getControlFor(discoveredDevice.tmDeviceID);
                boolean bl = ((ApplicationOwner)DeviceManager.this.stateHandler.getStateApplicationProperty(Application.PHONE).get()).is(ApplicationOwner.MAINUNIT);
                if (bl && DeviceManager.this.context.getConfiguration().isOnHoldWhenPhoneCallActive()) {
                    tMDeviceControl.deviceDiscoveredPhoneCallActive(discoveredDevice.device);
                    continue;
                }
                tMDeviceControl.deviceDiscovered(discoveredDevice.device);
            }
        }

        private void checkDeviceRemovals(GList<DiscoveredDevice> gList) {
            final GList<TMDeviceID> gList2 = FluentCollection.from(gList).transform(new Function<DiscoveredDevice, TMDeviceID>(){

                @Override
                public TMDeviceID apply(DiscoveredDevice discoveredDevice) {
                    return discoveredDevice.tmDeviceID;
                }

                @Override
                public /* synthetic */ Object apply(Object object) {
                    return this.apply((DiscoveredDevice)object);
                }
            }).toList();
            ((FluentCollection)FluentCollection.from(DeviceManager.this.deviceMappings.getAddresses()).filter((Predicate)new Predicate<TMDeviceID>(){

                @Override
                public boolean apply(TMDeviceID tMDeviceID) {
                    return !gList2.contains(tMDeviceID);
                }

                @Override
                public /* synthetic */ boolean apply(Object object) {
                    return this.apply((TMDeviceID)object);
                }
            })).forEach((Consumer)new Consumer<TMDeviceID>(){

                @Override
                public void accept(TMDeviceID tMDeviceID) {
                    DeviceManager.this.deviceMappings.getControlFor(tMDeviceID).deviceIsNotDiscovered();
                }

                @Override
                public /* synthetic */ void accept(Object object) {
                    this.accept((TMDeviceID)object);
                }
            });
        }

        @Override
        public void updateDeviceConnectionState(int n, final int n2, int n3) {
            final GList gList = DeviceManager.getSmartphoneTypes(n3);
            if (gList.isEmpty()) {
                gList.add(SmartphoneManager.SmartphoneType.CARPLAY);
                gList.add(SmartphoneManager.SmartphoneType.ANDROIDAUTO2);
                gList.add(SmartphoneManager.SmartphoneType.CARLIFE);
            }
            final String string = (String)DeviceManager.this.idsToUniqueIds.get(new Integer(n));
            ((FluentCollection)FluentCollection.from(DeviceManager.this.deviceMappings.getAddresses()).filter((Predicate)new Predicate<TMDeviceID>(){

                @Override
                public boolean apply(TMDeviceID tMDeviceID) {
                    return tMDeviceID.address.equals(string) && gList.contains(tMDeviceID.smartphoneType);
                }

                @Override
                public /* synthetic */ boolean apply(Object object) {
                    return this.apply((TMDeviceID)object);
                }
            })).forEach((Consumer)new Consumer<TMDeviceID>(){

                @Override
                public void accept(TMDeviceID tMDeviceID) {
                    DeviceManager.this.deviceMappings.getControlFor(tMDeviceID).setConnectionStateByDSIState(n2);
                }

                @Override
                public /* synthetic */ void accept(Object object) {
                    this.accept((TMDeviceID)object);
                }
            });
        }

        @Override
        public void connectDeviceFailed(int n, final SmartphoneIntegrationDSILifecycleController.ErrorCode errorCode) {
            final String string = (String)DeviceManager.this.idsToUniqueIds.get(new Integer(n));
            ((FluentCollection)FluentCollection.from(DeviceManager.this.deviceMappings.getAddresses()).filter((Predicate)new Predicate<TMDeviceID>(){

                @Override
                public boolean apply(TMDeviceID tMDeviceID) {
                    return tMDeviceID.address.equals(string);
                }

                @Override
                public /* synthetic */ boolean apply(Object object) {
                    return this.apply((TMDeviceID)object);
                }
            })).forEach((Consumer)new Consumer<TMDeviceID>(){

                @Override
                public void accept(TMDeviceID tMDeviceID) {
                    DeviceManager.this.deviceMappings.getControlFor(tMDeviceID).connectDeviceFailed(errorCode);
                }

                @Override
                public /* synthetic */ void accept(Object object) {
                    this.accept((TMDeviceID)object);
                }
            });
        }

        @Override
        public void responseFactorySettings(boolean bl) {
        }

        private class DiscoveredDevice {
            public final TMDeviceID tmDeviceID;
            public final PhysicalDevice device;

            public DiscoveredDevice(TMDeviceID tMDeviceID, PhysicalDevice physicalDevice) {
                this.tmDeviceID = tMDeviceID;
                this.device = physicalDevice;
            }
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public class DeviceManagerProperties
    implements IDeviceManager.IDeviceManagerProperties {
        @Override
        public ReadOnlyProperty<TMDevice> activeDevice() {
            return DeviceManager.this.activeDevice;
        }
    }

    private class DeviceActivationRequestHandler
    implements TMDeviceControl.IDeviceControlToDeviceManager {
        private static final String LOGCLASS = "DeviceManager.DeviceActivationRequestHandler";
        private TMDeviceControl runningActivationRequest = null;

        private DeviceActivationRequestHandler() {
        }

        public void requestActivation(TMDeviceControl tMDeviceControl) {
            if (tMDeviceControl.equals(DeviceManager.this.currentActiveDevice) && DeviceManager.this.currentActiveDevice.isActive()) {
                DeviceManager.this.logger.log(1000000, "<!> [%1.requestActivation] NOP because already active - %2.", (Object)LOGCLASS, (Object)DeviceManager.this.currentActiveDevice);
            } else {
                this.moveSelectionMarker(tMDeviceControl.getTmDevice());
                if (INVALID_DEVICE.equals(DeviceManager.this.currentActiveDevice)) {
                    DeviceManager.this.logger.log(1000000, "<!> [%1.requestActivation] nothing active, activation confirmed for %2", (Object)LOGCLASS, (Object)tMDeviceControl.getTmDevice());
                    this.confirmActivation(tMDeviceControl);
                } else {
                    DeviceManager.this.logger.log(1000000, "<!> [%1.requestActivation] activation postponed because already active - %2", (Object)LOGCLASS, (Object)DeviceManager.this.currentActiveDevice);
                    DeviceManager.this.logger.log(1000000, "<!> [%1.requestActivation] saving request - %2", (Object)LOGCLASS, (Object)tMDeviceControl.getTmDevice());
                    this.runningActivationRequest = tMDeviceControl;
                    DeviceManager.this.control(DeviceManager.this.currentActiveDevice).deactivationConfirmed();
                }
            }
        }

        public void requestOtherModeActivation(TMDeviceControl tMDeviceControl) {
            DeviceManager.this.logger.log(1000000, "<!> [%1.requestOtherModeActivation] deviceToBeDeactivated: %2", (Object)LOGCLASS, (Object)tMDeviceControl);
            GIterator<TMDevice> gIterator = DeviceManager.this.deviceMappings.getDeviceList().iterator();
            while (gIterator.hasNext()) {
                TMDevice tMDevice = gIterator.next();
                DeviceManager.this.logger.log(1000000, "<!> [%1.requestOtherModeActivation] deviceToBeChecked: %2", (Object)LOGCLASS, (Object)tMDevice);
                if (!tMDevice.getUniqueID().address.equals(((DeviceManager)DeviceManager.this).currentActiveDevice.getUniqueID().address) || !tMDevice.smartphoneType().isNot(DeviceManager.this.currentActiveDevice.smartphoneType())) continue;
                if (tMDevice.wasDisclaimerPreviouslyAccepted() || !DeviceManager.this.context.getConfiguration().shouldShowDisclaimerAtLeastOnce()) {
                    DeviceManager.this.logger.log(1000000, "<!> [%1.requestOtherModeActivation] requestActivation for device: id: %2 - uniqueid: %3", (Object)LOGCLASS, (Object)new Integer(tMDevice.getDeviceId()), (Object)tMDevice.getUniqueID());
                    this.requestActivation(DeviceManager.this.control(tMDevice));
                    break;
                }
                DeviceManager.this.context.getEventBus().requestUserDecision(tMDevice);
                break;
            }
        }

        public void requestDeactivation(TMDeviceControl tMDeviceControl) {
            tMDeviceControl.getTmDevice().setSelected(false);
            DeviceManager.this.notifyDeviceListChanged(DeviceManager.this.deviceListListener, DeviceManager.this.getDeviceList(), "requestDeactivation");
            tMDeviceControl.deactivationConfirmed();
        }

        private void moveSelectionMarker(TMDevice tMDevice) {
            GIterator<TMDevice> gIterator = DeviceManager.this.deviceMappings.getDeviceList().iterator();
            while (gIterator.hasNext()) {
                gIterator.next().setSelected(false);
            }
            tMDevice.setSelected(true);
            DeviceManager.this.notifyDeviceListChanged(DeviceManager.this.deviceListListener, DeviceManager.this.getDeviceList(), "moveSelectionMarker");
        }

        private void confirmActivation(TMDeviceControl tMDeviceControl) {
            DeviceManager.this.currentActiveDevice = tMDeviceControl.getTmDevice();
            DeviceManager.this.notifyActiveDeviceStateChanged(DeviceManager.this.activeDeviceStateListener, DeviceManager.this.currentActiveDevice, "confirmActivation");
            tMDeviceControl.activationConfirmed();
        }

        public void notifyAboutChange(TMDevice tMDevice, String string) {
            boolean bl = tMDevice.getUniqueID().equals(DeviceManager.this.currentActiveDevice.getUniqueID());
            boolean bl2 = DeviceManager.this.currentActiveDevice.connectionState().isOneOf(TMDevice.ConnectionState.ATTACHED, TMDevice.ConnectionState.NOT_ATTACHED);
            if (bl && bl2) {
                if (this.runningActivationRequest != null) {
                    DeviceManager.this.logger.log(1000000, "<!> [%1.notifyAboutChange] activating pending request %2", (Object)LOGCLASS, (Object)this.runningActivationRequest.getTmDevice());
                    this.confirmActivation(this.runningActivationRequest);
                    this.runningActivationRequest.getTmDevice().setSelected(true);
                    this.runningActivationRequest = null;
                } else {
                    DeviceManager.this.logger.log(1000000, "[%1.notifyAboutChange] no pending requests present", (Object)LOGCLASS);
                    DeviceManager.this.currentActiveDevice.setSelected(false);
                    DeviceManager.this.currentActiveDevice = INVALID_DEVICE;
                    DeviceManager.this.notifyActiveDeviceStateChanged(DeviceManager.this.activeDeviceStateListener, DeviceManager.this.currentActiveDevice, "active device deactivated");
                }
            }
            if (bl && !bl2) {
                DeviceManager.this.notifyActiveDeviceStateChanged(DeviceManager.this.activeDeviceStateListener, DeviceManager.this.currentActiveDevice, "active device changed");
            }
            if (!bl && tMDevice.isActive()) {
                DeviceManager.this.logger.log(1000000, "[%1.notifyAboutChange] setting active device as selected", (Object)LOGCLASS);
                DeviceManager.this.currentActiveDevice = tMDevice;
                DeviceManager.this.currentActiveDevice.setSelected(true);
                this.runningActivationRequest = null;
                DeviceManager.this.notifyActiveDeviceStateChanged(DeviceManager.this.activeDeviceStateListener, DeviceManager.this.currentActiveDevice, "active device selected");
            }
            DeviceManager.this.notifyDeviceListChanged(DeviceManager.this.deviceListListener, DeviceManager.this.getDeviceList(), string);
        }

        public void deleteMe(TMDeviceControl tMDeviceControl) {
            DeviceManager.this.deviceMappings.deleteDeviceFromPersistence(tMDeviceControl);
            if (tMDeviceControl.getTmDevice().equals(DeviceManager.this.currentActiveDevice)) {
                DeviceManager.this.currentActiveDevice = INVALID_DEVICE;
            }
            this.notifyAboutChange(INVALID_DEVICE, "deleted");
        }
    }
}

