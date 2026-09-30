/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.SmartphoneManager;
import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.IAudioManager;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.device.IActiveDeviceStateListener;
import de.audi.app.terminalmode.device.IDeviceListListener;
import de.audi.app.terminalmode.device.IDeviceManager;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.device.TMDeviceID;
import de.audi.app.terminalmode.events.CallStateChangedEvent;
import de.audi.app.terminalmode.events.DefaultEventListener;
import de.audi.app.terminalmode.logging.Arrays2;
import de.audi.app.terminalmode.osgi.IServiceTracker;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.ITMStateListener;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.atip.interapp.terminalmode.CallStateChanged;
import de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener;
import de.audi.atip.interapp.terminalmode.ITerminalModeUpdateService;
import de.audi.atip.interapp.terminalmode.TerminalModeAppState;
import de.audi.atip.interapp.terminalmode.TerminalModeAudioUsage;
import de.audi.atip.interapp.terminalmode.TerminalModeDevice;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.generics.Function;
import de.audi.atip.utils.generics.GComparator;
import de.audi.atip.utils.generics.GCopyOnWriteList;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.reactive.observables.Observables;
import de.audi.atip.utils.reactive.observables.Subscription;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Hashtable;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TMInterAppHandler
extends DefaultEventListener
implements IDeviceListListener,
ITMStateListener,
ITerminalModeUpdateService,
ITerminalModeComponent {
    private static final String LOGCLASS = "TMInterAppHandler";
    private final LogChannel logger;
    private final IContext context;
    private final IStateHandler stateHandler;
    private final GCopyOnWriteList<ITerminalModeUpdateListener> terminalModeListenerList;
    private final ActiveDeviceStateListener deviceStateListener;
    private final IDeviceManager deviceManager;
    private final IAudioManager audioManager;
    private volatile IServiceTracker createServiceTracker;
    private volatile TerminalModeDevice[] notifiedTMDeviceList;
    private volatile TerminalModeAppState[] notifiedTMAppState;
    private volatile ServiceRegistration registeredService;
    private volatile Subscription phoneSubscription;
    private volatile Subscription ringtoneSubscription;
    private static final TerminalModeDevice[] EMPTY = new TerminalModeDevice[0];
    static /* synthetic */ Class class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateService;

    public TMInterAppHandler(IContext iContext, IStateHandler iStateHandler, IAudioManager iAudioManager) {
        this.context = iContext;
        this.stateHandler = iStateHandler;
        this.logger = iContext.getLogger().hmi();
        this.deviceManager = iContext.getDeviceManager();
        this.terminalModeListenerList = Generics.newCopyOnWriteArrayList();
        this.deviceStateListener = new ActiveDeviceStateListener();
        this.audioManager = iAudioManager;
    }

    @Override
    public void init() {
        this.logger.log(100000000, "[%1.init]", (Object)LOGCLASS);
        this.createServiceTracker = this.context.getServiceManager().createServiceTracker(class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener == null ? (class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener = TMInterAppHandler.class$("de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener")) : class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener, new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
                TMInterAppHandler.this.logger.log(1000000, "[%1.removedService]", (Object)TMInterAppHandler.LOGCLASS);
                if (object instanceof ITerminalModeUpdateListener) {
                    TMInterAppHandler.this.logger.log(1000000, "[%1.removedService] removed service", (Object)TMInterAppHandler.LOGCLASS);
                    TMInterAppHandler.this.terminalModeListenerList.remove((ITerminalModeUpdateListener)object);
                }
                TMInterAppHandler.this.context.getServiceManager().releaseService(serviceReference);
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public Object addingService(ServiceReference serviceReference) {
                Object object = TMInterAppHandler.this.context.getServiceManager().getService(serviceReference);
                if (!(object instanceof ITerminalModeUpdateListener)) {
                    TMInterAppHandler.this.logger.log(100000000, "[%1.addingService] unwanted service", (Object)TMInterAppHandler.LOGCLASS);
                    TMInterAppHandler.this.context.getServiceManager().releaseService(serviceReference);
                    return object;
                }
                ITerminalModeUpdateListener iTerminalModeUpdateListener = (ITerminalModeUpdateListener)object;
                TMInterAppHandler.this.terminalModeListenerList.add(iTerminalModeUpdateListener);
                GList<ITerminalModeUpdateListener> gList = Generics.newArrayList(new ITerminalModeUpdateListener[]{iTerminalModeUpdateListener});
                if (null != TMInterAppHandler.this.notifiedTMDeviceList) {
                    TMInterAppHandler.this.notifyDeviceList(gList, TMInterAppHandler.this.notifiedTMDeviceList);
                }
                if (null != TMInterAppHandler.this.notifiedTMAppState) {
                    TMInterAppHandler.this.notifyStateUpdate(gList, TMInterAppHandler.this.notifiedTMAppState);
                }
                iTerminalModeUpdateListener.updateActiveDeviceState(TMInterAppHandler.this.deviceStateListener.activeDevice);
                return iTerminalModeUpdateListener;
            }
        });
        this.createServiceTracker.open();
        this.context.getDeviceManager().addDeviceListListener(this);
        this.context.getDeviceManager().addActiveDeviceListener(this.deviceStateListener);
        this.stateHandler.addStateListener(this);
        this.registeredService = this.context.getServiceManager().registerService(class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateService == null ? (class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateService = TMInterAppHandler.class$("de.audi.atip.interapp.terminalmode.ITerminalModeUpdateService")) : class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateService, this, new Hashtable(0));
        this.context.getEventBus().registerListener(this);
        this.phoneSubscription = this.audioManager.getAudioObservableForAudioConnection(TMAudioConnection.PHONE).observe().combineWith(this.audioManager.getAudioObservableForAudioConnection(TMAudioConnection.PHONE_INPUT).observe()).using(new Observables.Combinator<AudioConnectionState, AudioConnectionState, Boolean>(){

            @Override
            public Boolean combine(AudioConnectionState audioConnectionState, AudioConnectionState audioConnectionState2) {
                return new Boolean(audioConnectionState.isAudible() || audioConnectionState2.isAudible());
            }

            @Override
            public /* synthetic */ Object combine(Object object, Object object2) {
                return this.combine((AudioConnectionState)object, (AudioConnectionState)object2);
            }
        }).distinctUntilChanged().log(this.logger, "PhoneAC inUse").redirectTo(new Consumer<Boolean>(){

            @Override
            public void accept(Boolean bl) {
                TMInterAppHandler.this.notifyAudioUsage(TMInterAppHandler.this.terminalModeListenerList, new TerminalModeAudioUsage(2, bl));
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((Boolean)object);
            }
        });
        this.ringtoneSubscription = this.audioManager.getAudioObservableForAudioConnection(TMAudioConnection.RINGTONE).observe().map(new Function<AudioConnectionState, Boolean>(){

            @Override
            public Boolean apply(AudioConnectionState audioConnectionState) {
                return new Boolean(audioConnectionState.isAudible());
            }

            @Override
            public /* synthetic */ Object apply(Object object) {
                return this.apply((AudioConnectionState)object);
            }
        }).distinctUntilChanged().log(this.logger, "RingtoneAC inUse").redirectTo(new Consumer<Boolean>(){

            @Override
            public void accept(Boolean bl) {
                TMInterAppHandler.this.notifyAudioUsage(TMInterAppHandler.this.terminalModeListenerList, new TerminalModeAudioUsage(1, bl));
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((Boolean)object);
            }
        });
    }

    @Override
    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.context.getServiceManager().unregisterService(this.registeredService);
        this.stateHandler.removeStateListener(this);
        this.context.getDeviceManager().removeDeviceListListener(this);
        this.context.getDeviceManager().removeActiveDeviceListener(this.deviceStateListener);
        this.phoneSubscription.cancel();
        this.ringtoneSubscription.cancel();
        this.createServiceTracker.close();
        this.context.getEventBus().unregisterListener(this);
    }

    @Override
    public void updateState(TMState tMState) {
        Object[] objectArray = this.createTMAppState(tMState);
        if (Arrays.equals(this.notifiedTMAppState, objectArray)) {
            this.logger.log(10000000, "[%1.updateState] Already notified.", (Object)LOGCLASS);
            return;
        }
        this.notifyStateUpdate(this.terminalModeListenerList, (TerminalModeAppState[])objectArray);
        this.notifiedTMAppState = objectArray;
    }

    private void notifyStateUpdate(GList<ITerminalModeUpdateListener> gList, TerminalModeAppState[] terminalModeAppStateArray) {
        this.logger.log(100000000, "[%1.notifyStateUpdate]", (Object)LOGCLASS);
        GIterator<ITerminalModeUpdateListener> gIterator = gList.iterator();
        while (gIterator.hasNext()) {
            try {
                gIterator.next().updateAppStates(terminalModeAppStateArray);
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.notifyStateUpdate]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    private TerminalModeAppState[] createTMAppState(TMState tMState) {
        this.logger.log(100000000, "[%1.createTMAppState]", (Object)LOGCLASS);
        TerminalModeAppState[] terminalModeAppStateArray = new TerminalModeAppState[]{new TerminalModeAppState(3, tMState.isAppOwnerDevice(Application.SPEECH)), new TerminalModeAppState(1, tMState.isAppOwnerDevice(Application.NAVI)), new TerminalModeAppState(2, tMState.isAppOwnerDevice(Application.PHONE))};
        return terminalModeAppStateArray;
    }

    protected void notifyAudioUsage(GList<ITerminalModeUpdateListener> gList, TerminalModeAudioUsage terminalModeAudioUsage) {
        this.logger.log(100000000, "[%1.notifyAudioUsage] %2", (Object)LOGCLASS, (Object)terminalModeAudioUsage);
        GIterator<ITerminalModeUpdateListener> gIterator = gList.iterator();
        while (gIterator.hasNext()) {
            try {
                gIterator.next().updateAudioConnectionUsage(terminalModeAudioUsage);
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.notifyAudioUsage]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    @Override
    public void updateDeviceList(GList<TMDevice> gList) {
        TerminalModeDevice[] terminalModeDeviceArray = this.createTMDeviceList(gList);
        this.notifyDeviceList(this.terminalModeListenerList, terminalModeDeviceArray);
        this.notifiedTMDeviceList = terminalModeDeviceArray;
    }

    private void notifyDeviceList(GList<ITerminalModeUpdateListener> gList, TerminalModeDevice[] terminalModeDeviceArray) {
        this.logger.log(1000000, "->> [%1.notifyDeviceList] %2", (Object)LOGCLASS, (Object)Arrays2.toString(terminalModeDeviceArray));
        GIterator<ITerminalModeUpdateListener> gIterator = gList.iterator();
        while (gIterator.hasNext()) {
            try {
                gIterator.next().updateDeviceList(terminalModeDeviceArray);
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.notifyDeviceList]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    private TerminalModeDevice[] createTMDeviceList(GList<TMDevice> gList) {
        return gList.fluent().filter(new Predicate<TMDevice>(){

            @Override
            public boolean apply(TMDevice tMDevice) {
                return tMDevice.smartphoneType().isNot(SmartphoneManager.SmartphoneType.UNKNOWN);
            }

            @Override
            public /* synthetic */ boolean apply(Object object) {
                return this.apply((TMDevice)object);
            }
        }).sort(new GComparator<TMDevice>(){

            @Override
            public int compare(TMDevice tMDevice, TMDevice tMDevice2) {
                return new Long(tMDevice2.getAttachTime()).compareTo(new Long(tMDevice.getAttachTime()));
            }

            @Override
            public /* synthetic */ int compare(Object object, Object object2) {
                return this.compare((TMDevice)object, (TMDevice)object2);
            }
        }).sort(new GComparator<TMDevice>(){

            @Override
            public int compare(TMDevice tMDevice, TMDevice tMDevice2) {
                boolean bl;
                boolean bl2 = tMDevice.connectionState().isOneOf(TMDevice.ConnectionState.ATTACHED, TMDevice.ConnectionState.ACTIVATING, TMDevice.ConnectionState.ACTIVE);
                return bl2 == (bl = tMDevice2.connectionState().isOneOf(TMDevice.ConnectionState.ATTACHED, TMDevice.ConnectionState.ACTIVATING, TMDevice.ConnectionState.ACTIVE)) ? 0 : (bl2 ? -1 : 1);
            }

            @Override
            public /* synthetic */ int compare(Object object, Object object2) {
                return this.compare((TMDevice)object, (TMDevice)object2);
            }
        }).map(new Function<TMDevice, TerminalModeDevice>(){

            @Override
            public TerminalModeDevice apply(TMDevice tMDevice) {
                return TMInterAppHandler.createTerminalModeDeviceFromTMDevice(tMDevice);
            }

            @Override
            public /* synthetic */ Object apply(Object object) {
                return this.apply((TMDevice)object);
            }
        }).toArray((TerminalModeDevice[])EMPTY);
    }

    private static TerminalModeDevice createTerminalModeDeviceFromTMDevice(TMDevice tMDevice) {
        int n = 0;
        if (tMDevice.isCarplayDevice()) {
            n = 1;
        } else if (tMDevice.isAndroidAutoDevice()) {
            n = 2;
        } else if (tMDevice.smartphoneType().is(SmartphoneManager.SmartphoneType.CARLIFE)) {
            n = 3;
        } else if (!TMDevice.INVALID.equals(tMDevice)) {
            throw new InvalidParameterException();
        }
        return new TerminalModeDevice(tMDevice.getUniqueID(), tMDevice.getDevicename(), n, tMDevice.isSelected(), tMDevice.userAcceptState().isOneOf(TMDevice.UserAcceptState.TM_SELECTED, TMDevice.UserAcceptState.DISCLAIMER_ACCEPTED), tMDevice.connectionState().isNot(TMDevice.ConnectionState.NOT_ATTACHED));
    }

    @Override
    public void activateDevice(TerminalModeDevice terminalModeDevice) {
        if (null == terminalModeDevice) {
            this.logger.log(1000000, "<<- [%1.activateDevice] pDevice = null. Ignore.", (Object)LOGCLASS);
            return;
        }
        this.logger.log(1000000, "<<- [%1.activateDevice] %2", (Object)LOGCLASS, (Object)terminalModeDevice);
        this.tryToActivateDevice(terminalModeDevice);
    }

    @Override
    public void deactivateDevice(TerminalModeDevice terminalModeDevice) {
        if (null == terminalModeDevice) {
            this.logger.log(1000000, "<<- [%1.deactivateDevice] pDevice = null. Ignore.", (Object)LOGCLASS);
            return;
        }
        this.logger.log(1000000, "<<- [%1.deactivateDevice] %2", (Object)LOGCLASS, (Object)terminalModeDevice);
        this.deviceManager.control((TMDeviceID)terminalModeDevice.getToken()).setUserAcceptState(TMDevice.UserAcceptState.NATIVE_SELECTED).deactivateDevice();
    }

    @Override
    public void enableTerminalModeForDevice(TerminalModeDevice terminalModeDevice) {
        if (null == terminalModeDevice) {
            this.logger.log(1000000, "<<- [%1.enableTerminalModeForDevice] pDevice = null. Ignore.", (Object)LOGCLASS);
            return;
        }
        this.logger.log(1000000, "<<- [%1.enableTerminalModeForDevice] %2", (Object)LOGCLASS, (Object)terminalModeDevice);
        this.tryToActivateDevice(terminalModeDevice);
    }

    @Override
    public void disableTerminalModeForDevice(TerminalModeDevice terminalModeDevice) {
        if (null == terminalModeDevice) {
            this.logger.log(1000000, "<<- [%1.disableTerminalModeForDevice] pDevice = null. Ignore.", (Object)LOGCLASS);
            return;
        }
        this.logger.log(1000000, "<<- [%1.disableTerminalModeForDevice] %2", (Object)LOGCLASS, (Object)terminalModeDevice);
        this.deviceManager.control((TMDeviceID)terminalModeDevice.getToken()).setUserAcceptState(TMDevice.UserAcceptState.NATIVE_SELECTED).deactivateDevice();
    }

    @Override
    public void deleteDeviceFromPersistence(TerminalModeDevice terminalModeDevice) {
        if (null == terminalModeDevice) {
            this.logger.log(1000000, "<<- [%1.deleteDeviceFromPersistence] pDevice = null. Ignore.", (Object)LOGCLASS);
            return;
        }
        this.logger.log(1000000, "<<- [%1.deleteDeviceFromPersistence] %2", (Object)LOGCLASS, (Object)terminalModeDevice);
        this.deviceManager.control((TMDeviceID)terminalModeDevice.getToken()).deleteFromPersistence();
    }

    private void tryToActivateDevice(TerminalModeDevice terminalModeDevice) {
        TMDeviceControl tMDeviceControl = this.deviceManager.control((TMDeviceID)terminalModeDevice.getToken());
        if (tMDeviceControl.getTmDevice().wasDisclaimerPreviouslyAccepted() || !this.context.getConfiguration().shouldShowDisclaimerAtLeastOnce()) {
            tMDeviceControl.setUserAcceptState(TMDevice.UserAcceptState.DISCLAIMER_ACCEPTED).activateDevice();
        } else {
            this.context.getEventBus().requestUserDecision(tMDeviceControl.getTmDevice());
        }
    }

    @Override
    public void updateCallState(GList<CallStateChangedEvent> gList) {
        this.notifyUpdateCallState(gList, this.terminalModeListenerList);
    }

    public void notifyUpdateCallState(GList<CallStateChangedEvent> gList, GList<ITerminalModeUpdateListener> gList2) {
        this.logger.log(1000000, "<<- [%1.updateCallState] CallState = %2", (Object)LOGCLASS, (Object)gList.toString());
        CallStateChanged[] callStateChangedArray = new CallStateChanged[gList.size()];
        int n = 0;
        GIterator<Object> gIterator = gList.iterator();
        while (gIterator.hasNext()) {
            CallStateChangedEvent callStateChangedEvent = gIterator.next();
            callStateChangedArray[n] = new CallStateChanged(callStateChangedEvent.getPhoneNumber(), callStateChangedEvent.getCallerName(), callStateChangedEvent.getStatus(), callStateChangedEvent.getDirection(), callStateChangedEvent.getUniqueCallID());
            ++n;
        }
        gIterator = gList2.iterator();
        while (gIterator.hasNext()) {
            try {
                ((ITerminalModeUpdateListener)gIterator.next()).updateCallState(callStateChangedArray);
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.updateCallState]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    @Override
    public void callNumberViaTM(String string) {
        this.logger.log(1000000, "-> [%1.callNumberViaTM] %2", (Object)LOGCLASS, (Object)string);
        this.context.getEventBus().callNumber(string);
    }

    @Override
    public void endCallViaTM() {
        this.logger.log(1000000, "-> [%1.endTMCallViaTM]", (Object)LOGCLASS);
        this.context.getEventBus().endCall();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private final class ActiveDeviceStateListener
    implements IActiveDeviceStateListener {
        private volatile TerminalModeDevice activeDevice = TMInterAppHandler.access$1000(TMDevice.INVALID);

        private ActiveDeviceStateListener() {
        }

        public void updateActiveDeviceState(TMDevice tMDevice) {
            this.activeDevice = TMInterAppHandler.createTerminalModeDeviceFromTMDevice(tMDevice);
            TMInterAppHandler.this.logger.log(1000000, "-> [%1.updateActiveDeviceState] %2", (Object)TMInterAppHandler.LOGCLASS, (Object)this.activeDevice);
            GIterator gIterator = TMInterAppHandler.this.terminalModeListenerList.iterator();
            while (gIterator.hasNext()) {
                try {
                    ((ITerminalModeUpdateListener)gIterator.next()).updateActiveDeviceState(this.activeDevice);
                }
                catch (Exception exception) {
                    TMInterAppHandler.this.logger.log(100000, "[%1.notifyDeviceList]", (Object)TMInterAppHandler.LOGCLASS, (Throwable)exception);
                }
            }
        }
    }
}

