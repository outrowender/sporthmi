/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.TerminalModeUtils
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.TerminalModeUtils;
import de.audi.app.terminalmode.dsi.IAppState;
import de.audi.app.terminalmode.dsi.IDSIAppState;
import de.audi.app.terminalmode.dsi.IDSIResource;
import de.audi.app.terminalmode.dsi.IResource;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController$1;
import de.audi.app.terminalmode.dsi.carplay.CarplayUtils;
import de.audi.app.terminalmode.dsi.carplay.ICarplayDSIController;
import de.audi.app.terminalmode.dsi.carplay.SiriAction;
import de.audi.app.terminalmode.events.DefaultEventListener;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.ResourceRequest;
import org.dsi.ifc.carplay.ServiceConfiguration;

class CarplayDSILifecycleController$CarplayDSIController
extends DefaultEventListener
implements ICarplayDSIController {
    private static final String DSI_TEL_IDENTIFIER;
    private static final String LOGCLASS;
    private final /* synthetic */ CarplayDSILifecycleController this$0;

    private CarplayDSILifecycleController$CarplayDSIController(CarplayDSILifecycleController carplayDSILifecycleController) {
        this.this$0 = carplayDSILifecycleController;
    }

    @Override
    public void responseUpdateMainAudioType(int n) {
        CarplayDSILifecycleController.access$200(this.this$0).log(1078071040, "[%1.responseUpdateMainAudioType]", (Object)"CarplayDSIController");
        CarplayDSILifecycleController.access$300(this.this$0).responseUpdateMainAudioType(n);
    }

    public void deinit() {
        CarplayDSILifecycleController.access$400(this.this$0).getEventBus().unregisterListener(this);
    }

    public void init() {
        CarplayDSILifecycleController.access$400(this.this$0).getEventBus().registerListener(this);
    }

    @Override
    public void startService(IDSIAppState[] iDSIAppStateArray, IDSIResource[] iDSIResourceArray) {
        CarplayDSILifecycleController.access$500(this.this$0).log(1078071040, "[%1.startService] %2 %3", (Object)"CarplayDSIController", (Object)TerminalModeUtils.logAppStates((IAppState[])iDSIAppStateArray), (Object)TerminalModeUtils.logResources((IResource[])iDSIResourceArray));
        ResourceRequest[] resourceRequestArray = this.convertResource2DSIResourceRequest(iDSIResourceArray, true);
        AppStateRequest[] appStateRequestArray = this.convertAppState2DSIAppStateRequest(iDSIAppStateArray);
        int n = 0;
        if (CarplayDSILifecycleController.access$600(this.this$0).hasKnob()) {
            n |= 1;
        }
        if (CarplayDSILifecycleController.access$600(this.this$0).hasTouchpad()) {
            n |= 8;
        }
        if (CarplayDSILifecycleController.access$600(this.this$0).hasTouchscreenHigh()) {
            n |= 4;
        }
        if (CarplayDSILifecycleController.access$600(this.this$0).hasTouchscreenLow()) {
            n |= 2;
        }
        ServiceConfiguration serviceConfiguration = new ServiceConfiguration();
        serviceConfiguration.initialAppState = appStateRequestArray;
        serviceConfiguration.initialResources = resourceRequestArray;
        serviceConfiguration.screenResolution = CarplayDSILifecycleController.access$600(this.this$0).getDSICarPlayScreenResolution();
        serviceConfiguration.xOffset = CarplayDSILifecycleController.access$600(this.this$0).getScreenOffsetX();
        serviceConfiguration.yOffset = CarplayDSILifecycleController.access$600(this.this$0).getScreenOffsetY();
        serviceConfiguration.displayName = CarplayDSILifecycleController.access$600(this.this$0).getScreenName();
        serviceConfiguration.useRightHandDrive = CarplayDSILifecycleController.access$600(this.this$0).isRightHandDrive();
        serviceConfiguration.touchpadXResolution = CarplayDSILifecycleController.access$600(this.this$0).getTouchPadResolutionX();
        serviceConfiguration.touchpadYResolution = CarplayDSILifecycleController.access$600(this.this$0).getTouchPadResolutionY();
        serviceConfiguration.bluetoothIdentities = new String[0];
        serviceConfiguration.startInNightMode = CarplayDSILifecycleController.access$400(this.this$0).getNightDayModeHandler().getRequestedNightMode();
        serviceConfiguration.physicalDisplayHeight = CarplayDSILifecycleController.access$600(this.this$0).getCarPlayPhysicalDisplayHeight();
        serviceConfiguration.physicalDisplayWidth = CarplayDSILifecycleController.access$600(this.this$0).getCarPlayPhysicalDisplayWidth();
        serviceConfiguration.inputFeatures = n;
        if (3 == CarplayDSILifecycleController.access$600(this.this$0).getDSICarPlayScreenResolution()) {
            serviceConfiguration.xResolution = CarplayDSILifecycleController.access$600(this.this$0).getWindowResolutionX();
            serviceConfiguration.yResolution = CarplayDSILifecycleController.access$600(this.this$0).getWindowResolutionY();
        }
        CarplayDSILifecycleController.access$300(this.this$0).startService(serviceConfiguration);
        if (CarplayDSILifecycleController.access$700(this.this$0).isDebug2()) {
            CarplayDSILifecycleController.access$800(this.this$0).log(14808325, "[%1.startService] %3 -- %2", (Object)"CarplayDSIController", (Object)CarplayUtils.logModeRequest(resourceRequestArray, appStateRequestArray), (Object)serviceConfiguration);
        }
    }

    @Override
    public void stopService() {
        CarplayDSILifecycleController.access$900(this.this$0).log(1078071040, "[%1.stopService]", (Object)"CarplayDSIController");
    }

    @Override
    public void postButtonEvent(int n, int n2) {
        CarplayDSILifecycleController.access$1000(this.this$0).log(1078071040, "[%1.requestButtonEvent] %2 %3", (Object)"CarplayDSIController", (long)n, (long)n2);
        CarplayDSILifecycleController.access$300(this.this$0).postButtonEvent(this.mapButtonId(n), this.mapButtonState(n2));
    }

    @Override
    public void postDSICarplayButtonEvent(int n, int n2) {
        CarplayDSILifecycleController.access$300(this.this$0).postButtonEvent(n, n2);
    }

    @Override
    public void responseBTDeactivation() {
        CarplayDSILifecycleController.access$1100(this.this$0).log(1078071040, "[%1.responseBTDeactivation]", (Object)"CarplayDSIController");
        CarplayDSILifecycleController.access$300(this.this$0).responseBTDeactivation();
    }

    @Override
    public void requestUI(int n) {
        CarplayDSILifecycleController.access$1200(this.this$0).log(1078071040, "[%1.requestUI]", (Object)"CarplayDSIController");
        CarplayDSILifecycleController.access$300(this.this$0).requestUI(this.mapUIId(n));
    }

    @Override
    public void requestModeChange(IDSIAppState[] iDSIAppStateArray, IDSIResource[] iDSIResourceArray, String string) {
        CarplayDSILifecycleController.access$1300(this.this$0).log(1078071040, "[%1.requestModeChange] %2 %3", (Object)"CarplayDSIController", (Object)TerminalModeUtils.logAppStates((IAppState[])iDSIAppStateArray), (Object)TerminalModeUtils.logResources((IResource[])iDSIResourceArray));
        ResourceRequest[] resourceRequestArray = this.convertResource2DSIResourceRequest(iDSIResourceArray, false);
        AppStateRequest[] appStateRequestArray = this.convertAppState2DSIAppStateRequest(iDSIAppStateArray);
        CarplayDSILifecycleController.access$300(this.this$0).requestModeChange(resourceRequestArray, appStateRequestArray, string);
        if (CarplayDSILifecycleController.access$1400(this.this$0).isDebug2()) {
            CarplayDSILifecycleController.access$1500(this.this$0).log(14808325, "[%1.requestModeChange] %2", (Object)"CarplayDSIController", (Object)CarplayUtils.logModeRequest(resourceRequestArray, appStateRequestArray));
        }
    }

    @Override
    public void responseUpdateMode(IDSIResource[] iDSIResourceArray, IDSIAppState[] iDSIAppStateArray) {
        CarplayDSILifecycleController.access$1600(this.this$0).log(1078071040, "[%1.responseModeChange] %2 %3", (Object)"CarplayDSIController", (Object)TerminalModeUtils.logAppStates((IAppState[])iDSIAppStateArray), (Object)TerminalModeUtils.logResources((IResource[])iDSIResourceArray));
        CarplayDSILifecycleController.access$300(this.this$0).responseUpdateMode(this.convertResource2DSI(iDSIResourceArray), this.convertAppState2DSI(iDSIAppStateArray));
    }

    @Override
    public void requestSIRIAction(SiriAction siriAction) {
        CarplayDSILifecycleController.access$1700(this.this$0).log(1078071040, "[%1.requestSIRIAction] %2", (Object)"CarplayDSIController", (Object)siriAction);
        CarplayDSILifecycleController.access$300(this.this$0).requestSIRIAction(siriAction);
    }

    @Override
    public void requestNightMode(boolean bl) {
        CarplayDSILifecycleController.access$1800(this.this$0).log(1078071040, "[%1.requestNightMode] %2", (Object)"CarplayDSIController", (Object)Boolean.toString(bl));
        CarplayDSILifecycleController.access$300(this.this$0).requestNightMode(bl);
    }

    private AppState[] convertAppState2DSI(IDSIAppState[] iDSIAppStateArray) {
        CarplayDSILifecycleController.access$1900(this.this$0).log(-2137614336, "[%1.convertAppState2DSI]", (Object)"CarplayDSIController");
        AppState[] appStateArray = new AppState[iDSIAppStateArray.length];
        for (int i2 = 0; i2 < iDSIAppStateArray.length; ++i2) {
            appStateArray[i2] = CarplayDSILifecycleController.access$2000(this.this$0).createAppState(iDSIAppStateArray[i2].getDSIAppStateId(), iDSIAppStateArray[i2].getDSIOwner(), iDSIAppStateArray[i2].getDSISpeechMode());
        }
        return appStateArray;
    }

    private AppStateRequest[] convertAppState2DSIAppStateRequest(IDSIAppState[] iDSIAppStateArray) {
        CarplayDSILifecycleController.access$2100(this.this$0).log(-2137614336, "[%1.convertAppState2DSI]", (Object)"CarplayDSIController");
        AppStateRequest[] appStateRequestArray = new AppStateRequest[iDSIAppStateArray.length];
        for (int i2 = 0; i2 < iDSIAppStateArray.length; ++i2) {
            appStateRequestArray[i2] = CarplayDSILifecycleController.access$2000(this.this$0).createAppStateRequest(iDSIAppStateArray[i2].getDSIAppStateId(), iDSIAppStateArray[i2].getOwner() == 1, iDSIAppStateArray[i2].getDSISpeechMode());
        }
        return appStateRequestArray;
    }

    private Resource[] convertResource2DSI(IDSIResource[] iDSIResourceArray) {
        CarplayDSILifecycleController.access$2200(this.this$0).log(-2137614336, "[%1.convertResource2DSI]", (Object)"CarplayDSIController");
        Resource[] resourceArray = new Resource[iDSIResourceArray.length];
        for (int i2 = 0; i2 < iDSIResourceArray.length; ++i2) {
            resourceArray[i2] = CarplayDSILifecycleController.access$2000(this.this$0).createResource(iDSIResourceArray[i2].getDSIResourceId(), iDSIResourceArray[i2].getDSIResourceOwner());
        }
        return resourceArray;
    }

    private ResourceRequest[] convertResource2DSIResourceRequest(IDSIResource[] iDSIResourceArray, boolean bl) {
        CarplayDSILifecycleController.access$2300(this.this$0).log(-2137614336, "[%1.convertResource2DSI]", (Object)"CarplayDSIController");
        ResourceRequest[] resourceRequestArray = new ResourceRequest[iDSIResourceArray.length];
        for (int i2 = 0; i2 < iDSIResourceArray.length; ++i2) {
            int n = iDSIResourceArray[i2].getDSITakeType(bl);
            CarplayDSILifecycleController.access$2400(this.this$0).log(1078071040, "[%1.convertResource2DSIResourceRequest] %2 %3", (Object)"CarplayDSIController", (long)iDSIResourceArray[i2].getResourceId(), (long)n);
            resourceRequestArray[i2] = CarplayDSILifecycleController.access$2000(this.this$0).createResourceRequest(iDSIResourceArray[i2].getDSIResourceId(), iDSIResourceArray[i2].getOwner() == 1 ? n : CarplayUtils.getInvertTransferType(n), iDSIResourceArray[i2].getDSITransferPriority(bl), iDSIResourceArray[i2].getDSITakeConstraint(bl), iDSIResourceArray[i2].getDSIBorrowConstraint(bl), iDSIResourceArray[i2].getDSIUnborrowConstraint(bl));
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
        CarplayDSILifecycleController.access$2500(this.this$0).log(-1601830656, "[%1.mapButtonState] %2 unknown", (Object)"CarplayDSIController", (long)n);
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
        CarplayDSILifecycleController.access$2600(this.this$0).log(-1601830656, "[%1.mapButtonId] %2 unknown", (Object)"CarplayDSIController", (long)n);
        return 0;
    }

    private int mapUIId(int n) {
        if (1 == n) {
            return 1;
        }
        if (0 == n) {
            return 0;
        }
        CarplayDSILifecycleController.access$2700(this.this$0).log(-1601830656, "[%1.mapUIId] %2 unknown", (Object)"CarplayDSIController", (long)n);
        return 0;
    }

    @Override
    public void callNumber(String string) {
        Buffer buffer = new Buffer();
        buffer.append("tel:");
        buffer.append(string);
        CarplayDSILifecycleController.access$300(this.this$0).requestUI2(buffer.toString());
    }

    @Override
    public void endCall() {
        CarplayDSILifecycleController.access$2800(this.this$0).log(1078071040, "[%1.endCall] ending carplay call via BUTTON_END_CALL", (Object)"CarplayDSIController");
        CarplayDSILifecycleController.access$300(this.this$0).postButtonEvent(14, 0);
        CarplayDSILifecycleController.access$300(this.this$0).postButtonEvent(14, 1);
    }

    /* synthetic */ CarplayDSILifecycleController$CarplayDSIController(CarplayDSILifecycleController carplayDSILifecycleController, CarplayDSILifecycleController$1 carplayDSILifecycleController$1) {
        this(carplayDSILifecycleController);
    }
}

