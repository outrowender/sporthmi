/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeConfiguration;
import de.audi.app.terminalmode.SmartphoneManager;
import de.audi.app.terminalmode.TerminalModeUtils;
import de.audi.app.terminalmode.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.terminalmode.dsi.AbstractDSIController;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.dsi.IAppState;
import de.audi.app.terminalmode.dsi.IDSIAppState;
import de.audi.app.terminalmode.dsi.IDSIResource;
import de.audi.app.terminalmode.dsi.IResource;
import de.audi.app.terminalmode.dsi.carplay.CarPlayAppState;
import de.audi.app.terminalmode.dsi.carplay.CarPlayResource;
import de.audi.app.terminalmode.dsi.carplay.CarplayUtils;
import de.audi.app.terminalmode.dsi.carplay.DSICarplaySafe;
import de.audi.app.terminalmode.dsi.carplay.DSICarplaySafeProxy;
import de.audi.app.terminalmode.dsi.carplay.ICarplayDSIController;
import de.audi.app.terminalmode.dsi.carplay.ICarplayDSIControllerListener;
import de.audi.app.terminalmode.dsi.carplay.IDSICarplayTransferObjectFactory;
import de.audi.app.terminalmode.dsi.carplay.SiriAction;
import de.audi.app.terminalmode.events.CallStateChangedEvent;
import de.audi.app.terminalmode.events.DefaultEventListener;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.app.terminalmode.events.PhoneStateChangedEvent;
import de.audi.app.terminalmode.events.PlayPositionEvent;
import de.audi.app.terminalmode.events.PlayPositionLogEvent;
import de.audi.app.terminalmode.events.PlayPositionLogger;
import de.audi.app.terminalmode.events.PlayPositionLoggerConfiguration;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent;
import de.audi.app.terminalmode.events.TrackDataChangedEvent;
import de.audi.app.terminalmode.events.TrackPlayPositionEvent;
import de.audi.app.terminalmode.keyevents.ITerminalModeDSIKeyEventsController;
import de.audi.app.terminalmode.keyevents.Key;
import de.audi.app.terminalmode.keyevents.KeyState;
import de.audi.app.terminalmode.keyevents.TouchEvent;
import de.audi.app.terminalmode.logging.Arrays2;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.CallState;
import org.dsi.ifc.carplay.DSICarplay;
import org.dsi.ifc.carplay.DSICarplayListener;
import org.dsi.ifc.carplay.DeviceInfo;
import org.dsi.ifc.carplay.PlaybackInfo;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.ResourceRequest;
import org.dsi.ifc.carplay.ServiceConfiguration;
import org.dsi.ifc.carplay.TelephonyState;
import org.dsi.ifc.carplay.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public class CarplayDSILifecycleController
extends AbstractDSIController
implements IDiagnosisCommandProvider {
    private final DSICarplaySafeProxy dsiCarplayProxy;
    private final DSICarplaySafe dsiCarplaySafe;
    private final ITerminalModeConfiguration configuration;
    private final DSICarplayListenerImpl dsiCarPlayListener;
    private volatile Key lastJoystickkey;
    private final CarplayDSIController carPlayDsiController;
    private final ITerminalModeDSIKeyEventsController keyEventController;
    private final IFrameworkAccess fw;
    private final IContext tmManager;
    private final IDSICarplayTransferObjectFactory transferObjectFactory;
    private volatile org.dsi.ifc.carplay.TouchEvent[] lastFingers;
    private static final String postButton = "postButton(CarplayId)";
    private static final String requestUI = "requestUI";
    static /* synthetic */ Class class$org$dsi$ifc$carplay$DSICarplay;
    static /* synthetic */ Class class$org$dsi$ifc$carplay$DSICarplayListener;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$carplay$ICarplayDSIControllerListener;

    public CarplayDSILifecycleController(IContext iContext, IDSICarplayTransferObjectFactory iDSICarplayTransferObjectFactory, DSICarplaySafe dSICarplaySafe, DSICarplayListenerImpl dSICarplayListenerImpl, DSICarplaySafeProxy dSICarplaySafeProxy) {
        super(0, iContext.getServiceManager(), iContext.getFramework(), iContext.getDispatcher(), true, iContext.getLogger().dsi());
        this.dsiCarplaySafe = dSICarplaySafe;
        this.dsiCarplayProxy = dSICarplaySafeProxy;
        this.dsiCarPlayListener = dSICarplayListenerImpl;
        this.carPlayDsiController = new CarplayDSIController();
        this.configuration = iContext.getConfiguration();
        this.keyEventController = new TerminalModeDSIKeyEventsController();
        this.fw = iContext.getFramework();
        this.tmManager = iContext;
        iContext.getDiagnosisManager().addCommandProvider(0, this);
        this.transferObjectFactory = iDSICarplayTransferObjectFactory;
    }

    public void init() {
        super.init();
        this.startDSI();
        this.dsiCarPlayListener.init();
        this.carPlayDsiController.init();
    }

    public void deinit() {
        super.deinit();
        this.carPlayDsiController.deinit();
    }

    public ICarplayDSIController getDioDsiController() {
        return this.carPlayDsiController;
    }

    public ITerminalModeDSIKeyEventsController getKeyEventController() {
        return this.keyEventController;
    }

    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$carplay$DSICarplay == null ? (class$org$dsi$ifc$carplay$DSICarplay = CarplayDSILifecycleController.class$("org.dsi.ifc.carplay.DSICarplay")) : class$org$dsi$ifc$carplay$DSICarplay;
    }

    protected DSIListener getDSIListener() {
        return this.dsiCarPlayListener;
    }

    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$carplay$DSICarplayListener == null ? (class$org$dsi$ifc$carplay$DSICarplayListener = CarplayDSILifecycleController.class$("org.dsi.ifc.carplay.DSICarplayListener")) : class$org$dsi$ifc$carplay$DSICarplayListener;
    }

    protected void addDSIService(DSIBase dSIBase) {
        this.dsiCarplayProxy.addDSIService((DSICarplay)dSIBase);
    }

    protected void removeDSIService() {
        this.dsiCarplayProxy.removeDSIService();
    }

    public String[] getDiagKeys() {
        return new String[]{postButton, requestUI};
    }

    public void executeDiagCommand(String string, String[] stringArray) {
        if (postButton.equals(string) && stringArray.length > 0) {
            int n = Integer.parseInt(stringArray[0]);
            this.dsiCarplaySafe.postButtonEvent(n, 0);
            this.dsiCarplaySafe.postButtonEvent(n, 1);
        } else if (requestUI.equals(string)) {
            this.dsiCarplaySafe.requestUI(0);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ org.dsi.ifc.carplay.TouchEvent[] access$3402(CarplayDSILifecycleController carplayDSILifecycleController, org.dsi.ifc.carplay.TouchEvent[] touchEventArray) {
        carplayDSILifecycleController.lastFingers = touchEventArray;
        return touchEventArray;
    }

    private class CarplayDSIController
    extends DefaultEventListener
    implements ICarplayDSIController {
        private static final String DSI_TEL_IDENTIFIER = "tel:";
        private static final String LOGCLASS = "CarplayDSIController";

        private CarplayDSIController() {
        }

        public void responseUpdateMainAudioType(int n) {
            CarplayDSILifecycleController.this.logger.log(1000000, "[%1.responseUpdateMainAudioType]", (Object)LOGCLASS);
            CarplayDSILifecycleController.this.dsiCarplaySafe.responseUpdateMainAudioType(n);
        }

        public void deinit() {
            CarplayDSILifecycleController.this.tmManager.getEventBus().unregisterListener(this);
        }

        public void init() {
            CarplayDSILifecycleController.this.tmManager.getEventBus().registerListener(this);
        }

        public void startService(IDSIAppState[] iDSIAppStateArray, IDSIResource[] iDSIResourceArray) {
            CarplayDSILifecycleController.this.logger.log(1000000, "[%1.startService] %2 %3", (Object)LOGCLASS, (Object)TerminalModeUtils.logAppStates(iDSIAppStateArray), (Object)TerminalModeUtils.logResources(iDSIResourceArray));
            ResourceRequest[] resourceRequestArray = this.convertResource2DSIResourceRequest(iDSIResourceArray, true);
            AppStateRequest[] appStateRequestArray = this.convertAppState2DSIAppStateRequest(iDSIAppStateArray);
            int n = 0;
            if (CarplayDSILifecycleController.this.configuration.hasKnob()) {
                n |= 1;
            }
            if (CarplayDSILifecycleController.this.configuration.hasTouchpad()) {
                n |= 8;
            }
            if (CarplayDSILifecycleController.this.configuration.hasTouchscreenHigh()) {
                n |= 4;
            }
            if (CarplayDSILifecycleController.this.configuration.hasTouchscreenLow()) {
                n |= 2;
            }
            ServiceConfiguration serviceConfiguration = new ServiceConfiguration();
            serviceConfiguration.initialAppState = appStateRequestArray;
            serviceConfiguration.initialResources = resourceRequestArray;
            serviceConfiguration.screenResolution = CarplayDSILifecycleController.this.configuration.getDSICarPlayScreenResolution();
            serviceConfiguration.xOffset = CarplayDSILifecycleController.this.configuration.getScreenOffsetX();
            serviceConfiguration.yOffset = CarplayDSILifecycleController.this.configuration.getScreenOffsetY();
            serviceConfiguration.displayName = CarplayDSILifecycleController.this.configuration.getScreenName();
            serviceConfiguration.useRightHandDrive = CarplayDSILifecycleController.this.configuration.isRightHandDrive();
            serviceConfiguration.touchpadXResolution = CarplayDSILifecycleController.this.configuration.getTouchPadResolutionX();
            serviceConfiguration.touchpadYResolution = CarplayDSILifecycleController.this.configuration.getTouchPadResolutionY();
            serviceConfiguration.bluetoothIdentities = new String[0];
            serviceConfiguration.startInNightMode = CarplayDSILifecycleController.this.tmManager.getNightDayModeHandler().getRequestedNightMode();
            serviceConfiguration.physicalDisplayHeight = CarplayDSILifecycleController.this.configuration.getCarPlayPhysicalDisplayHeight();
            serviceConfiguration.physicalDisplayWidth = CarplayDSILifecycleController.this.configuration.getCarPlayPhysicalDisplayWidth();
            serviceConfiguration.inputFeatures = n;
            if (3 == CarplayDSILifecycleController.this.configuration.getDSICarPlayScreenResolution()) {
                serviceConfiguration.xResolution = CarplayDSILifecycleController.this.configuration.getWindowResolutionX();
                serviceConfiguration.yResolution = CarplayDSILifecycleController.this.configuration.getWindowResolutionY();
            }
            CarplayDSILifecycleController.this.dsiCarplaySafe.startService(serviceConfiguration);
            if (CarplayDSILifecycleController.this.logger.isDebug2()) {
                CarplayDSILifecycleController.this.logger.log(100000000, "[%1.startService] %3 -- %2", (Object)LOGCLASS, (Object)CarplayUtils.logModeRequest(resourceRequestArray, appStateRequestArray), (Object)serviceConfiguration);
            }
        }

        public void stopService() {
            CarplayDSILifecycleController.this.logger.log(1000000, "[%1.stopService]", (Object)LOGCLASS);
        }

        public void postButtonEvent(int n, int n2) {
            CarplayDSILifecycleController.this.logger.log(1000000, "[%1.requestButtonEvent] %2 %3", (Object)LOGCLASS, (long)n, (long)n2);
            CarplayDSILifecycleController.this.dsiCarplaySafe.postButtonEvent(this.mapButtonId(n), this.mapButtonState(n2));
        }

        public void postDSICarplayButtonEvent(int n, int n2) {
            CarplayDSILifecycleController.this.dsiCarplaySafe.postButtonEvent(n, n2);
        }

        public void responseBTDeactivation() {
            CarplayDSILifecycleController.this.logger.log(1000000, "[%1.responseBTDeactivation]", (Object)LOGCLASS);
            CarplayDSILifecycleController.this.dsiCarplaySafe.responseBTDeactivation();
        }

        public void requestUI(int n) {
            CarplayDSILifecycleController.this.logger.log(1000000, "[%1.requestUI]", (Object)LOGCLASS);
            CarplayDSILifecycleController.this.dsiCarplaySafe.requestUI(this.mapUIId(n));
        }

        public void requestModeChange(IDSIAppState[] iDSIAppStateArray, IDSIResource[] iDSIResourceArray, String string) {
            CarplayDSILifecycleController.this.logger.log(1000000, "[%1.requestModeChange] %2 %3", (Object)LOGCLASS, (Object)TerminalModeUtils.logAppStates(iDSIAppStateArray), (Object)TerminalModeUtils.logResources(iDSIResourceArray));
            ResourceRequest[] resourceRequestArray = this.convertResource2DSIResourceRequest(iDSIResourceArray, false);
            AppStateRequest[] appStateRequestArray = this.convertAppState2DSIAppStateRequest(iDSIAppStateArray);
            CarplayDSILifecycleController.this.dsiCarplaySafe.requestModeChange(resourceRequestArray, appStateRequestArray, string);
            if (CarplayDSILifecycleController.this.logger.isDebug2()) {
                CarplayDSILifecycleController.this.logger.log(100000000, "[%1.requestModeChange] %2", (Object)LOGCLASS, (Object)CarplayUtils.logModeRequest(resourceRequestArray, appStateRequestArray));
            }
        }

        public void responseUpdateMode(IDSIResource[] iDSIResourceArray, IDSIAppState[] iDSIAppStateArray) {
            CarplayDSILifecycleController.this.logger.log(1000000, "[%1.responseModeChange] %2 %3", (Object)LOGCLASS, (Object)TerminalModeUtils.logAppStates(iDSIAppStateArray), (Object)TerminalModeUtils.logResources(iDSIResourceArray));
            CarplayDSILifecycleController.this.dsiCarplaySafe.responseUpdateMode(this.convertResource2DSI(iDSIResourceArray), this.convertAppState2DSI(iDSIAppStateArray));
        }

        public void requestSIRIAction(SiriAction siriAction) {
            CarplayDSILifecycleController.this.logger.log(1000000, "[%1.requestSIRIAction] %2", (Object)LOGCLASS, (Object)siriAction);
            CarplayDSILifecycleController.this.dsiCarplaySafe.requestSIRIAction(siriAction);
        }

        public void requestNightMode(boolean bl) {
            CarplayDSILifecycleController.this.logger.log(1000000, "[%1.requestNightMode] %2", (Object)LOGCLASS, (Object)Boolean.toString(bl));
            CarplayDSILifecycleController.this.dsiCarplaySafe.requestNightMode(bl);
        }

        private AppState[] convertAppState2DSI(IDSIAppState[] iDSIAppStateArray) {
            CarplayDSILifecycleController.this.logger.log(10000000, "[%1.convertAppState2DSI]", (Object)LOGCLASS);
            AppState[] appStateArray = new AppState[iDSIAppStateArray.length];
            for (int i2 = 0; i2 < iDSIAppStateArray.length; ++i2) {
                appStateArray[i2] = CarplayDSILifecycleController.this.transferObjectFactory.createAppState(iDSIAppStateArray[i2].getDSIAppStateId(), iDSIAppStateArray[i2].getDSIOwner(), iDSIAppStateArray[i2].getDSISpeechMode());
            }
            return appStateArray;
        }

        private AppStateRequest[] convertAppState2DSIAppStateRequest(IDSIAppState[] iDSIAppStateArray) {
            CarplayDSILifecycleController.this.logger.log(10000000, "[%1.convertAppState2DSI]", (Object)LOGCLASS);
            AppStateRequest[] appStateRequestArray = new AppStateRequest[iDSIAppStateArray.length];
            for (int i2 = 0; i2 < iDSIAppStateArray.length; ++i2) {
                appStateRequestArray[i2] = CarplayDSILifecycleController.this.transferObjectFactory.createAppStateRequest(iDSIAppStateArray[i2].getDSIAppStateId(), iDSIAppStateArray[i2].getOwner() == 1, iDSIAppStateArray[i2].getDSISpeechMode());
            }
            return appStateRequestArray;
        }

        private Resource[] convertResource2DSI(IDSIResource[] iDSIResourceArray) {
            CarplayDSILifecycleController.this.logger.log(10000000, "[%1.convertResource2DSI]", (Object)LOGCLASS);
            Resource[] resourceArray = new Resource[iDSIResourceArray.length];
            for (int i2 = 0; i2 < iDSIResourceArray.length; ++i2) {
                resourceArray[i2] = CarplayDSILifecycleController.this.transferObjectFactory.createResource(iDSIResourceArray[i2].getDSIResourceId(), iDSIResourceArray[i2].getDSIResourceOwner());
            }
            return resourceArray;
        }

        private ResourceRequest[] convertResource2DSIResourceRequest(IDSIResource[] iDSIResourceArray, boolean bl) {
            CarplayDSILifecycleController.this.logger.log(10000000, "[%1.convertResource2DSI]", (Object)LOGCLASS);
            ResourceRequest[] resourceRequestArray = new ResourceRequest[iDSIResourceArray.length];
            for (int i2 = 0; i2 < iDSIResourceArray.length; ++i2) {
                int n = iDSIResourceArray[i2].getDSITakeType(bl);
                CarplayDSILifecycleController.this.logger.log(1000000, "[%1.convertResource2DSIResourceRequest] %2 %3", (Object)LOGCLASS, (long)iDSIResourceArray[i2].getResourceId(), (long)n);
                resourceRequestArray[i2] = CarplayDSILifecycleController.this.transferObjectFactory.createResourceRequest(iDSIResourceArray[i2].getDSIResourceId(), iDSIResourceArray[i2].getOwner() == 1 ? n : CarplayUtils.getInvertTransferType(n), iDSIResourceArray[i2].getDSITransferPriority(bl), iDSIResourceArray[i2].getDSITakeConstraint(bl), iDSIResourceArray[i2].getDSIBorrowConstraint(bl), iDSIResourceArray[i2].getDSIUnborrowConstraint(bl));
            }
            return resourceRequestArray;
        }

        private int mapButtonState(int n) {
            switch (n) {
                case 1: {
                    return 0;
                }
                case 2: {
                    return 1;
                }
            }
            CarplayDSILifecycleController.this.logger.log(100000, "[%1.mapButtonState] %2 unknown", (Object)LOGCLASS, (long)n);
            return 1;
        }

        private int mapButtonId(int n) {
            switch (n) {
                case 1: {
                    return 4;
                }
                case 5: {
                    return 12;
                }
                case 4: {
                    return 11;
                }
                case 3: {
                    return 10;
                }
                case 2: {
                    return 9;
                }
                case 7: {
                    return 18;
                }
                case 6: {
                    return 19;
                }
            }
            CarplayDSILifecycleController.this.logger.log(100000, "[%1.mapButtonId] %2 unknown", (Object)LOGCLASS, (long)n);
            return 0;
        }

        private int mapUIId(int n) {
            if (1 == n) {
                return 1;
            }
            if (0 == n) {
                return 0;
            }
            CarplayDSILifecycleController.this.logger.log(100000, "[%1.mapUIId] %2 unknown", (Object)LOGCLASS, (long)n);
            return 0;
        }

        public void callNumber(String string) {
            Buffer buffer = new Buffer();
            buffer.append(DSI_TEL_IDENTIFIER);
            buffer.append(string);
            CarplayDSILifecycleController.this.dsiCarplaySafe.requestUI2(buffer.toString());
        }

        public void endCall() {
            CarplayDSILifecycleController.this.logger.log(1000000, "[%1.endCall] ending carplay call via BUTTON_END_CALL", (Object)LOGCLASS);
            CarplayDSILifecycleController.this.dsiCarplaySafe.postButtonEvent(14, 0);
            CarplayDSILifecycleController.this.dsiCarplaySafe.postButtonEvent(14, 1);
        }
    }

    public static class DSICarplayListenerImpl
    implements DSICarplayListener {
        private static final String LOGCLASS = "DSICarplayListenerImpl";
        private final LogChannel logger;
        private final DispatcherBase dispatcher;
        private final IEventBus eventBus;
        private final IContext context;
        private ICarplayDSIControllerListener dioDSIControllerListener;
        private volatile TrackPlayPositionEvent notifiedPlayPosition;
        private final PlayPositionLogger playPositionLogger;

        private IResource[] convertResource(Resource[] resourceArray) {
            Object[] objectArray = new IResource[resourceArray.length];
            for (int i2 = 0; i2 < resourceArray.length; ++i2) {
                objectArray[i2] = new CarPlayResource(resourceArray[i2]);
            }
            this.logger.log(10000000, "[%1.convertResource] %2", (Object)LOGCLASS, (Object)Arrays2.toString(objectArray));
            return objectArray;
        }

        private IAppState[] convertAppState(AppState[] appStateArray) {
            Object[] objectArray = new IAppState[appStateArray.length];
            boolean bl = false;
            for (int i2 = 0; i2 < appStateArray.length; ++i2) {
                if (appStateArray[i2].getAppStateID() == 1 && appStateArray[i2].getOwner() == 2) {
                    bl = true;
                }
                if (bl && appStateArray[i2].getAppStateID() == 3) continue;
                objectArray[i2] = new CarPlayAppState(appStateArray[i2]);
            }
            this.logger.log(10000000, "[%1.convertAppState] %2", (Object)LOGCLASS, (Object)Arrays2.toString(objectArray));
            return objectArray;
        }

        public DSICarplayListenerImpl(LogChannel logChannel, DispatcherBase dispatcherBase, IEventBus iEventBus, IContext iContext) {
            this.logger = logChannel;
            this.dispatcher = dispatcherBase;
            this.eventBus = iEventBus;
            this.context = iContext;
            this.notifiedPlayPosition = new TrackPlayPositionEvent(-1, -1);
            this.playPositionLogger = new PlayPositionLogger(new PlayPositionLoggerConfiguration().setPlayPositionLogEvent(PlayPositionEvent.STARTUP, new PlayPositionLogEvent(logChannel, 1000000, 3)).setPlayPositionLogEvent(PlayPositionEvent.PLAYBACK_STATE_CHANGED, new PlayPositionLogEvent(logChannel, 1000000, 2)).setPlayPositionLogEvent(PlayPositionEvent.TRACK_CHANGED, new PlayPositionLogEvent(logChannel, 1000000, 3)).setPlayPositionLogEvent(PlayPositionEvent.ILLEGAL_PLAYPOSITION, new PlayPositionLogEvent(logChannel, 10000, 3)).setPlayPositionLogEvent(PlayPositionEvent.TO_LATE_PLAYPOSITION, new PlayPositionLogEvent(logChannel, 10000, 3)));
        }

        public void init() {
            this.dioDSIControllerListener = (ICarplayDSIControllerListener)this.context.get(SmartphoneManager.SmartphoneType.CARPLAY, class$de$audi$app$terminalmode$dsi$carplay$ICarplayDSIControllerListener == null ? (class$de$audi$app$terminalmode$dsi$carplay$ICarplayDSIControllerListener = CarplayDSILifecycleController.class$("de.audi.app.terminalmode.dsi.carplay.ICarplayDSIControllerListener")) : class$de$audi$app$terminalmode$dsi$carplay$ICarplayDSIControllerListener);
        }

        public void updateMode(Resource[] resourceArray, AppState[] appStateArray, int n) {
            if (!this.isValid(n)) {
                this.logger.log(10000000, "<- [%1.updateMode] Invalid.", (Object)LOGCLASS);
                return;
            }
            final IAppState[] iAppStateArray = this.convertAppState(appStateArray);
            final IResource[] iResourceArray = this.convertResource(resourceArray);
            this.dispatcher.execute(new AbstractDispatcherRunnable("digitalIpodOutListener.updateMode"){

                public void run() {
                    if (DSICarplayListenerImpl.this.logger.isDebug()) {
                        DSICarplayListenerImpl.this.logger.log(1000000, "<- [%1.updateMode] %2 %3", (Object)DSICarplayListenerImpl.LOGCLASS, (Object)TerminalModeUtils.logAppStates(iAppStateArray), (Object)TerminalModeUtils.logResources(iResourceArray));
                    }
                    DSICarplayListenerImpl.this.dioDSIControllerListener.updateMode(iAppStateArray, iResourceArray);
                }
            });
        }

        public void responseModeChange(Resource[] resourceArray, AppState[] appStateArray, int n) {
        }

        public void asyncException(int n, String string, int n2) {
            this.logger.log(10000, "<- [%1.asyncException] errCode='%2' msg='%3' requestType='%4'", (Object)LOGCLASS, (Object)String.valueOf(n), (Object)String.valueOf(string), (Object)String.valueOf(n2));
        }

        public void requestBTDeactivation(String string, int n) {
        }

        public void updateTextInputState(final int n, int n2) {
            if (!this.isValid(n2)) {
                this.logger.log(10000000, "<- [%1.updateTextInputState] Invalid.", (Object)LOGCLASS);
                return;
            }
            this.dispatcher.execute(new AbstractDispatcherRunnable("digitalIpodOutListener.updateTextInputState"){

                public void run() {
                    DSICarplayListenerImpl.this.logger.log(1000000, "<- [%1.updateTextInputState] %2", (Object)DSICarplayListenerImpl.LOGCLASS, (long)n);
                    DSICarplayListenerImpl.this.dioDSIControllerListener.updateTextInputState(1 == n);
                }
            });
        }

        public void updateDeviceInfo(DeviceInfo deviceInfo, int n) {
        }

        public void updateTelephonyState(TelephonyState telephonyState, int n) {
            if (this.isValid(n)) {
                PhoneStateChangedEvent phoneStateChangedEvent = new PhoneStateChangedEvent(telephonyState.getSignalStrength(), telephonyState.getRegistrationStatus(), telephonyState.isAirplaneMode(), telephonyState.getMobileOperator());
                this.logger.log(1000000, "<- [%1.updateTelephonyState] %2", (Object)LOGCLASS, (Object)phoneStateChangedEvent);
                this.eventBus.updatePhoneState(phoneStateChangedEvent);
            }
        }

        public void updateNowPlayingData(TrackData trackData, int n) {
            if (this.isValid(n)) {
                TrackDataChangedEvent trackDataChangedEvent = new TrackDataChangedEvent.Builder().setAlbum(trackData.getAlbum()).setArtist(trackData.getArtist()).setComposer(trackData.getComposer()).setDuration(trackData.getDuration()).setGenre(trackData.getGenre()).setTitle(trackData.getTitle()).build();
                this.logger.log(1000000, "<- [%1.updateNowPlayingData] %2", (Object)LOGCLASS, (Object)trackDataChangedEvent);
                this.playPositionLogger.trackChanged();
                this.eventBus.updateNowPlayingData(trackDataChangedEvent);
                this.notifyPlayPosition(new TrackPlayPositionEvent(0, trackData.getDuration() / 1000));
            }
        }

        private void notifyPlayPosition(TrackPlayPositionEvent trackPlayPositionEvent) {
            if (trackPlayPositionEvent.equals(this.notifiedPlayPosition)) {
                return;
            }
            this.notifiedPlayPosition = trackPlayPositionEvent;
            this.eventBus.updatePlayPosition(trackPlayPositionEvent);
        }

        public void updatePlaybackState(PlaybackInfo playbackInfo, int n) {
            if (this.isValid(n)) {
                PlaybackInfoChangedEvent playbackInfoChangedEvent = new PlaybackInfoChangedEvent.Builder().setPlaybackState(this.convert(playbackInfo.getStatus())).build();
                this.logger.log(1000000, "<- [%1.updatePlaybackState] %2", (Object)LOGCLASS, (Object)playbackInfoChangedEvent);
                this.playPositionLogger.playbackStateChanged();
                this.eventBus.updatePlaybackInfo(playbackInfoChangedEvent);
            }
        }

        private PlaybackInfoChangedEvent.PlaybackState convert(int n) {
            switch (n) {
                case 2: {
                    return PlaybackInfoChangedEvent.PlaybackState.PAUSED;
                }
                case 1: {
                    return PlaybackInfoChangedEvent.PlaybackState.PLAYING;
                }
                case 4: {
                    return PlaybackInfoChangedEvent.PlaybackState.SEEKBACKWARD;
                }
                case 3: {
                    return PlaybackInfoChangedEvent.PlaybackState.SEEKBACKWARD;
                }
            }
            return PlaybackInfoChangedEvent.PlaybackState.STOPPED;
        }

        public void updatePlayposition(int n, int n2) {
            if (this.isValid(n2)) {
                this.playPositionLogger.updatePlayPosition(n / 1000, this.notifiedPlayPosition.getTotalTimeOfTrack());
                this.notifyPlayPosition(new TrackPlayPositionEvent(n / 1000, this.notifiedPlayPosition.getTotalTimeOfTrack()));
            }
        }

        public void updateCoverArtUrl(ResourceLocator resourceLocator, int n) {
        }

        public void updateCallState(final CallState[] callStateArray, int n) {
            if (!this.isValid(n)) {
                this.logger.log(10000000, "<- [%1.updateCallState] Invalid.", (Object)LOGCLASS);
                return;
            }
            this.dispatcher.execute(new AbstractDispatcherRunnable("digitalIpodOutListener.updateCallState"){

                public void run() {
                    GList<CallStateChangedEvent> gList = Generics.newArrayListWithCapacity(callStateArray.length);
                    for (int i2 = 0; i2 < callStateArray.length; ++i2) {
                        gList.add(new CallStateChangedEvent(callStateArray[i2]));
                    }
                    DSICarplayListenerImpl.this.logger.log(1000000, "<- [%1.updateCallState]", (Object)DSICarplayListenerImpl.LOGCLASS);
                    DSICarplayListenerImpl.this.eventBus.updateCallState(gList);
                }
            });
        }

        public void duckAudio(final int n, final double d2) {
            this.dispatcher.execute(new AbstractDispatcherRunnable("digitalIpodOutListener.duckAudio"){

                public void run() {
                    DSICarplayListenerImpl.this.logger.log(1000000, "<- [%1.duckAudio]", (Object)DSICarplayListenerImpl.LOGCLASS);
                    DSICarplayListenerImpl.this.dioDSIControllerListener.duckAudio(n, d2);
                }
            });
        }

        public void unduckAudio(final int n) {
            this.dispatcher.execute(new AbstractDispatcherRunnable("digitalIpodOutListener.unduckAudio"){

                public void run() {
                    DSICarplayListenerImpl.this.logger.log(1000000, "<- [%1.unduckAudio] %2", (Object)DSICarplayListenerImpl.LOGCLASS, (long)n);
                    DSICarplayListenerImpl.this.dioDSIControllerListener.unduckAudio(n);
                }
            });
        }

        public void oemAppSelected() {
            this.dispatcher.execute(new AbstractDispatcherRunnable("digitalIpodOutListener.oemAppSelected"){

                public void run() {
                    DSICarplayListenerImpl.this.logger.log(1000000, "<- [%1.oemAppSelected]", (Object)DSICarplayListenerImpl.LOGCLASS);
                    DSICarplayListenerImpl.this.dioDSIControllerListener.oemAppSelected();
                }
            });
        }

        public void updateMainAudioType(final int n, int n2) {
            if (!this.isValid(n2)) {
                this.logger.log(10000000, "<- [%1.updateMainAudioType] Invalid.", (Object)LOGCLASS);
                return;
            }
            this.dispatcher.execute(new AbstractDispatcherRunnable("digitalIpodOutListener.updateMainAudioType"){

                public void run() {
                    DSICarplayListenerImpl.this.logger.log(1000000, "<- [%1.updateMainAudioType] %2", (Object)DSICarplayListenerImpl.LOGCLASS, (long)n);
                    DSICarplayListenerImpl.this.dioDSIControllerListener.updateMainAudioType(n);
                }
            });
        }

        protected boolean isValid(int n) {
            return 1 == n;
        }
    }

    private class TerminalModeDSIKeyEventsController
    implements ITerminalModeDSIKeyEventsController {
        private static final String LOGCLASS = "TerminalModeDSIKeyEventsController";

        private TerminalModeDSIKeyEventsController() {
        }

        public void updateKey(Key key, KeyState keyState) {
            if (TerminalModeUtils.isJoystickMiddleposition(key)) {
                if (null == CarplayDSILifecycleController.this.lastJoystickkey) {
                    return;
                }
                CarplayDSILifecycleController.this.logger.log(1000000, "[%1.updateKey] joystick middle position, release button %2", (Object)LOGCLASS, (Object)CarplayDSILifecycleController.this.lastJoystickkey);
                CarplayDSILifecycleController.this.dsiCarplaySafe.postButtonEvent(this.getKeyId(CarplayDSILifecycleController.this.lastJoystickkey), 1);
                CarplayDSILifecycleController.this.lastJoystickkey = null;
                return;
            }
            int n = this.getKeyId(key);
            if (0 == n) {
                CarplayDSILifecycleController.this.logger.log(1000000, "[%1.updateKey] unknown key id", (Object)LOGCLASS);
                return;
            }
            int n2 = this.getKeyState(keyState);
            CarplayDSILifecycleController.this.logger.log(1000000, "[%1.updateKey] %2 %3", (Object)LOGCLASS, (Object)String.valueOf(n), (long)n2);
            if (TerminalModeUtils.isJoystick(key)) {
                CarplayDSILifecycleController.this.lastJoystickkey = key;
            }
            CarplayDSILifecycleController.this.dsiCarplaySafe.postButtonEvent(n, n2);
        }

        public void updateTouchEvent(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
            Object[] objectArray;
            CarplayDSILifecycleController.this.logger.log(1000000, "[%1.updateTouchEvent] c=%2 x=%3 y=%4", (Object)LOGCLASS, (Object)String.valueOf(n2), (Object)String.valueOf(n4), (Object)String.valueOf(n5));
            org.dsi.ifc.carplay.TouchEvent[] touchEventArray = new org.dsi.ifc.carplay.TouchEvent[n2];
            if (n2 >= 1) {
                touchEventArray[0] = new org.dsi.ifc.carplay.TouchEvent(n4, n5);
            }
            if (n2 >= 2) {
                objectArray = this.calcSecondCorr(n4, n5, n6, n7);
                touchEventArray[1] = new org.dsi.ifc.carplay.TouchEvent(objectArray[0], objectArray[1]);
            }
            if (null != CarplayDSILifecycleController.this.lastFingers && CarplayDSILifecycleController.this.lastFingers.length > touchEventArray.length) {
                objectArray = new org.dsi.ifc.carplay.TouchEvent[CarplayDSILifecycleController.this.lastFingers.length];
                for (int i2 = 0; i2 < CarplayDSILifecycleController.this.lastFingers.length; ++i2) {
                    objectArray[i2] = i2 < touchEventArray.length - 1 ? (int)touchEventArray[i2] : (int)CarplayDSILifecycleController.this.lastFingers[i2];
                }
            } else {
                objectArray = touchEventArray;
            }
            if (CarplayDSILifecycleController.this.logger.isDebug()) {
                if (n2 == 1) {
                    CarplayDSILifecycleController.this.logger.log(1000000, "[%1.updateTouchEvent] %2/%3", (Object)LOGCLASS, (long)objectArray[0].getX(), (long)objectArray[0].getY());
                } else if (n2 >= 2) {
                    Buffer buffer = new Buffer(50);
                    buffer.append(objectArray[0].getX());
                    buffer.append('/');
                    buffer.append(objectArray[0].getY());
                    buffer.append(' ');
                    buffer.append(objectArray[1].getX());
                    buffer.append('/');
                    buffer.append(objectArray[1].getY());
                    CarplayDSILifecycleController.this.logger.log(1000000, "[%1.updateTouchEvent] %2", (Object)LOGCLASS, (Object)buffer.toString());
                }
            }
            if (0 != n2) {
                CarplayDSILifecycleController.access$3402(CarplayDSILifecycleController.this, (org.dsi.ifc.carplay.TouchEvent[])objectArray);
            } else {
                CarplayDSILifecycleController.access$3402(CarplayDSILifecycleController.this, null);
            }
            CarplayDSILifecycleController.this.dsiCarplaySafe.postTouchEvent(this.getDSITouchInputId(n), n2, (org.dsi.ifc.carplay.TouchEvent[])objectArray);
        }

        public void updateTouchEvents(TouchEvent[] touchEventArray) {
            CarplayDSILifecycleController.this.logger.log(1000000, "[%1.updateTouchEvent] c=%2 %3", (Object)LOGCLASS, (Object)Integer.toString(touchEventArray.length), (Object)touchEventArray[0]);
            int n = 0;
            ArrayList arrayList = new ArrayList(touchEventArray.length);
            for (int i2 = 0; i2 < touchEventArray.length; ++i2) {
                if (touchEventArray[i2].isTouchScreen()) {
                    arrayList.add(new org.dsi.ifc.carplay.TouchEvent(touchEventArray[i2].getCurrentX() - CarplayDSILifecycleController.this.configuration.getScreenOffsetX(), touchEventArray[i2].getCurrentY() - CarplayDSILifecycleController.this.configuration.getScreenOffsetY()));
                } else {
                    arrayList.add(new org.dsi.ifc.carplay.TouchEvent(touchEventArray[i2].getCurrentX(), touchEventArray[i2].getCurrentY()));
                }
                if (touchEventArray[i2].getTouchState() == 1) continue;
                ++n;
            }
            Collections.sort(arrayList, new Comparator(){

                public int compare(Object object, Object object2) {
                    org.dsi.ifc.carplay.TouchEvent touchEvent = (org.dsi.ifc.carplay.TouchEvent)object;
                    org.dsi.ifc.carplay.TouchEvent touchEvent2 = (org.dsi.ifc.carplay.TouchEvent)object2;
                    return touchEvent.getX() - touchEvent2.getX();
                }
            });
            if (CarplayDSILifecycleController.this.logger.isDebug()) {
                Buffer buffer = new Buffer(50);
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    org.dsi.ifc.carplay.TouchEvent touchEvent = (org.dsi.ifc.carplay.TouchEvent)iterator.next();
                    buffer.append(touchEvent.getX());
                    buffer.append('/');
                    buffer.append(touchEvent.getY());
                    buffer.append(' ');
                }
                buffer.append('/');
                buffer.append(n);
                CarplayDSILifecycleController.this.logger.log(1000000, "[%1.updateTouchEvent] %2", (Object)LOGCLASS, (Object)buffer.toString());
            }
            CarplayDSILifecycleController.this.dsiCarplaySafe.postTouchEvent(touchEventArray[0].isTouchScreen() ? 1 : 0, n, (org.dsi.ifc.carplay.TouchEvent[])arrayList.toArray(new org.dsi.ifc.carplay.TouchEvent[arrayList.size()]));
        }

        public void updateRotary(int n) {
            CarplayDSILifecycleController.this.logger.log(1000000, "[%1.updateRotary] %2", (Object)LOGCLASS, (long)n);
            CarplayDSILifecycleController.this.dsiCarplaySafe.postRotaryEvent(n);
        }

        private int getKeyState(KeyState keyState) {
            if (keyState.is(KeyState.PRESSED)) {
                return 0;
            }
            if (keyState.is(KeyState.RELEASED)) {
                return 1;
            }
            CarplayDSILifecycleController.this.logger.log(1000000, "[%1.getKeyState] Unsupported key state %2", (Object)LOGCLASS, (Object)keyState);
            return -1;
        }

        private int getKeyId(Key key) {
            if (Key.BACK.is(key)) {
                return 3;
            }
            if (Key.DDS_SELECT.is(key)) {
                return 1;
            }
            if (key.isOneOf(Key.JS_NORTH, Key.SOFTKEY_SOUTHWEST)) {
                return 7;
            }
            if (key.isOneOf(Key.JS_EAST, Key.SOFTKEY_NORTHEAST)) {
                return 6;
            }
            if (key.isOneOf(Key.JS_SOUTH, Key.SOFTKEY_SOUTHEAST)) {
                return 8;
            }
            if (key.isOneOf(Key.JS_WEST, Key.SOFTKEY_NORTHWEST)) {
                return 5;
            }
            if (key.is(Key.SOFTKEY_EAST)) {
                return 17;
            }
            if (key.is(Key.SOFTKEY_WEST)) {
                return 16;
            }
            CarplayDSILifecycleController.this.logger.log(1000000, "[%1.getKeyId] Unsupport %2", (Object)LOGCLASS, (Object)key);
            return 0;
        }

        private int getDSITouchInputId(int n) {
            switch (n) {
                case 2: {
                    return 1;
                }
            }
            return 0;
        }

        private int[] calcSecondCorr(int n, int n2, int n3, int n4) {
            if (n4 > 100) {
                n4 -= 100;
            }
            int n5 = (int)((double)n + Math.acos(n4 / 100) * (double)n4);
            int n6 = (int)((double)n2 + Math.asin(n4 / 100) * (double)n4);
            return new int[]{n5, n6};
        }

        public void updateCharacterEvent(String[] stringArray, int[] nArray) {
            CarplayDSILifecycleController.this.logger.log(1000000, "[%1.updateCharacterEvent]", (Object)LOGCLASS);
            CarplayDSILifecycleController.this.dsiCarplaySafe.postCharacterEvent(stringArray.length, stringArray);
        }
    }
}

