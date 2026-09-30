/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemComponent;
import de.audi.app.earlyfunc.core.parking.IParkingSystemController;
import de.audi.app.earlyfunc.core.parking.pla.IPLAAdditionalInfoHandler;
import de.audi.app.earlyfunc.core.parking.pla.IPLAMessageHandler;
import de.audi.app.earlyfunc.core.parking.pla.IPLAParkingSpotHandler;
import de.audi.app.earlyfunc.core.parking.pla.IPLAPopinHandler;
import de.audi.app.earlyfunc.core.parking.pla.IParkingSpotSelection;
import de.audi.app.earlyfunc.core.parking.pla.PLAAdditionalInfoHandler;
import de.audi.app.earlyfunc.core.parking.pla.PLAInterappCallbackHandler;
import de.audi.app.earlyfunc.core.parking.pla.PLAInterappServiceHandler;
import de.audi.app.earlyfunc.core.parking.pla.PLAMessageHandler;
import de.audi.app.earlyfunc.core.parking.pla.PLAParkingSpotHandler;
import de.audi.app.earlyfunc.core.parking.pla.PLAPopinHandler;
import de.audi.app.earlyfunc.core.parking.pla.PLATestSupportHandler;
import de.audi.atip.hmi.event.DrawerEvent;
import de.audi.atip.hmi.view.IPopupKeyConsuptionStrategy;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.PDCPLABargraph;
import org.dsi.ifc.carparkingsystem.PDCPLAStatus;
import org.dsi.ifc.carparkingsystem.PDCPLASystemState;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;

public abstract class AbstractParkingSystemPLAComponent
extends AbstractParkingSystemComponent
implements IParkingSpotSelection {
    private volatile boolean systemActive;
    private volatile PDCPLAStatus plaStatus;
    private IPLAParkingSpotHandler parkingSpotHandler;
    private IPLAMessageHandler messageHandler;
    private IPLAPopinHandler popinHandler;
    private IPLAAdditionalInfoHandler additionalInfoHandler;
    private static final int PLA_HMI_STATE_OFF = 0;
    private static final int PLA_HMI_STATE_STANDBY = 1;
    private static final int PLA_HMI_STATE_SEARCH_ACTIVE = 2;
    private static final int PLA_HMI_STATE_PARKIN_SELECTION = 3;
    private static final int PLA_HMI_STATE_PARKOUT_SELECTION = 4;
    private static final int PLA_HMI_STATE_PARKIN_ACTIVE = 5;
    private static final int PLA_HMI_STATE_PARKOUT_ACTIVE = 6;
    private static final int PLA_HMI_STATE_RESUME = 7;
    private PLATestSupportHandler testSupportHandler;
    private PLAInterappServiceHandler plaWidgetComService;
    private static final int DRAWER_VISIBLE = 0;
    private static final int DRAWER_INVISIBLE = 1;

    public AbstractParkingSystemPLAComponent(ICarApplication iCarApplication, IParkingSystemController iParkingSystemController) {
        super(iCarApplication, iParkingSystemController, "App.EarlyFunc.Parking.PLA");
    }

    public void init() {
        this.testSupportHandler = new PLATestSupportHandler(this.getApplication(), this.getLogChannel());
        this.testSupportHandler.init();
        this.parkingSpotHandler = new PLAParkingSpotHandler(this.getApplication(), this, this.getLogChannel());
        this.parkingSpotHandler.init();
        this.messageHandler = new PLAMessageHandler(this.getApplication(), this.controller, this, this.getLogChannel(), this.getDefaultMessagePartialPopupID(), this.getSplitscreenCenteredMessagePartialPopupID(), this.getSingleLineMessagePartialPopupID(), this.getOPSStandaloneLeftMessagePartialPopupID(), this.getOPSStandaloneRightMessagePartialPopupID(), this.getStartParkOutMessagePartialPopupID());
        this.messageHandler.init();
        this.plaWidgetComService = new PLAInterappServiceHandler(this.getApplication(), this.getLogChannel(), new PLAInterappCallbackHandler(this.getLogChannel(), this));
        this.plaWidgetComService.init();
        this.popinHandler = new PLAPopinHandler(this.controller, this, this.getLogChannel(), this.getApplication(), this.plaWidgetComService);
        this.popinHandler.init();
        this.additionalInfoHandler = new PLAAdditionalInfoHandler(this.getApplication(), this.getLogChannel());
        this.additionalInfoHandler.init();
        super.init();
        this.controller.getPartialPopupHandler().registerPopup(this.getPLAPartialPopupID());
        this.controller.registerParkingSystemComponent(this);
    }

    public void deinit() {
        this.controller.unregisterParkingSystemComponent(this);
        this.resetKeyConsumptionStrategy();
        this.setExtendedPowerState(false);
        this.additionalInfoHandler.deinit();
        this.popinHandler.deinit();
        this.plaWidgetComService.deinit();
        this.parkingSpotHandler.deinit();
        this.messageHandler.deinit();
        super.deinit();
        this.testSupportHandler.deinit();
    }

    protected void initModels() {
    }

    protected void deinitModels() {
    }

    public String getName() {
        return "Parking system PLA";
    }

    public int[] getDSIAttributes() {
        return new int[0];
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[0], new int[]{54, 59, 60, 61, 62})};
    }

    protected abstract int getDefaultMessagePartialPopupID();

    protected abstract int getSplitscreenCenteredMessagePartialPopupID();

    protected abstract int getSingleLineMessagePartialPopupID();

    protected abstract int getOPSStandaloneLeftMessagePartialPopupID();

    protected abstract int getOPSStandaloneRightMessagePartialPopupID();

    protected abstract int getStartParkOutMessagePartialPopupID();

    protected abstract int getPLAPartialPopupID();

    public abstract IPopupKeyConsuptionStrategy getPLAPopupConsumptionStrategy(boolean var1);

    public abstract IPopupKeyConsuptionStrategy getDefaultPLAPopupConsumptionStrategy();

    public void setActive(boolean bl, DisplayContent displayContent) {
        this.getLogChannel().log(10000000, "[AbstractParkingSystemPLAComponent#setActive] active=%1, displayContent=%2", bl, (Object)displayContent);
        this.updateCurrentDisplayContent(displayContent, true);
    }

    public int[] getSupportedDSIPopupIDs() {
        return new int[]{1, 2, 3, 4, 7, 8, 10, 11, 13, 14, 15, 16, 17, 18};
    }

    public int getParkingSystemID() {
        return 16;
    }

    public void updatePDCPLAMessage(int n, int n2) {
        this.getLogChannel().log(1000000, "---> dsiListener.updatePDCPLAMessage(%1, %2)", (long)n, (long)n2);
        if (n2 == 1) {
            this.messageHandler.showMessage(n);
            this.testSupportHandler.updateDSIPLAMessage(n);
        }
    }

    public void updatePDCPLAStatus(PDCPLAStatus pDCPLAStatus, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "---> dsiListener.updatePDCPLAStatus(%1, %2)", (Object)(pDCPLAStatus != null ? this.formatViewOptionsLog(pDCPLAStatus.toString()) : "null"), (long)n);
        }
        if (n == 1) {
            this.plaStatus = pDCPLAStatus;
            if (pDCPLAStatus != null && (this.systemActive || 0 != pDCPLAStatus.getMode())) {
                this.setPLAState(pDCPLAStatus);
                boolean bl = pDCPLAStatus.getInstructions().isPlaDeactivation();
                this.systemActive = 0 != pDCPLAStatus.getMode();
                if (this.systemActive) {
                    this.blockUserInteraction(bl);
                } else {
                    this.resetKeyConsumptionStrategy();
                }
                this.popinHandler.updatePDCPLAStatus(pDCPLAStatus);
                this.parkingSpotHandler.updateParkingSpots(pDCPLAStatus);
                this.additionalInfoHandler.updatePLAStatus(pDCPLAStatus);
                this.setExtendedPowerState(bl);
                if (bl) {
                    this.controller.setHighProtocol(true, new int[]{1}, true);
                } else {
                    this.controller.setHighProtocol(false, null, true);
                }
                this.testSupportHandler.updateDSIPLAStatus(pDCPLAStatus);
            } else {
                this.resetKeyConsumptionStrategy();
                this.setExtendedPowerState(false);
                this.controller.setHighProtocol(false, null, true);
            }
            this.messageHandler.updateMessage();
        }
    }

    private void blockUserInteraction(boolean bl) {
        Object object;
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractParkingSystemPLAComponent#blockUserInteraction] blocking user interaction '%1'", bl);
        }
        try {
            object = this.getPLAPopupConsumptionStrategy(bl);
            this.getLogChannel().log(1000000, "[AbstractParkingSystemPLAComponent#blockUserInteraction] Set PopupKeyConsumptionStrategy: %1", object);
            this.getApplication().getFrameworkAccess().getHmiServiceApp().setPopupKeyConsuptionStrategy((IPopupKeyConsuptionStrategy)object);
        }
        catch (Exception exception) {
            this.getLogChannel().log(10000, "[AbstractParkingSystemPLAComponent#blockUserInteraction] Exception occured during lock/unlock usage", (Throwable)exception);
        }
        if (bl) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[AbstractParkingSystemPLAComponent#blockUserInteraction] Close OptionDrawer.");
            }
            object = this.getApplication().getFrameworkAccess().getHMIService();
            DrawerEvent drawerEvent = new DrawerEvent(object.getRootWindow(0), 2);
            object.getEventDispatcher().postEvent(drawerEvent);
        }
    }

    private void resetKeyConsumptionStrategy() {
        IPopupKeyConsuptionStrategy iPopupKeyConsuptionStrategy = this.getDefaultPLAPopupConsumptionStrategy();
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractParkingSystemPLAComponent#resetKeyConsumptionStrategy] PopupKeyConsumptionStrategy: %1", (Object)iPopupKeyConsuptionStrategy);
        }
        try {
            this.getApplication().getFrameworkAccess().getHmiServiceApp().setPopupKeyConsuptionStrategy(iPopupKeyConsuptionStrategy);
        }
        catch (Exception exception) {
            this.getLogChannel().log(10000, "[AbstractParkingSystemPLAComponent#resetKeyConsumptionStrategy] Exception occured!", (Throwable)exception);
        }
    }

    private void setExtendedPowerState(boolean bl) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractParkingSystemPLAComponent#setExtendedPowerState] setExtendedPowerState: %1", bl ? 150L : 151L);
        }
        try {
            this.getApplication().getFrameworkAccess().getPowerMgr().setExtendedPowerState(bl ? 150 : 151, 0);
        }
        catch (Exception exception) {
            this.getLogChannel().log(10000, "[AbstractParkingSystemPLAComponent#setExtendedPowerState] Exception occured during setting extended power state", (Throwable)exception);
        }
    }

    private void setPLAState(PDCPLAStatus pDCPLAStatus) {
        int n = 0;
        switch (pDCPLAStatus.mode) {
            case 0: {
                n = 0;
                break;
            }
            case 6: {
                n = 1;
                break;
            }
            case 1: {
                n = 2;
                break;
            }
            case 2: {
                n = 3;
                break;
            }
            case 3: {
                n = 4;
                break;
            }
            case 4: {
                n = 5;
                break;
            }
            case 5: {
                n = 6;
                break;
            }
            case 7: {
                n = 7;
                break;
            }
            default: {
                n = 0;
            }
        }
        this.getChoiceModel(3916).setValue(n);
    }

    public void updatePDCPLABargraph(PDCPLABargraph pDCPLABargraph, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "---> dsiListener.updatePDCPLABargraph(%1, %2)", (Object)pDCPLABargraph, (long)n);
        }
    }

    public void updatePDCPLAParkmodeSelection(int n, int n2) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "---> dsiListener.updatePDCPLAParkmodeSelection(%1, %2)", (long)n, (long)n2);
        }
        if (n2 == 1) {
            this.parkingSpotHandler.updateSelectedParkingSpot(n);
            this.notifyPlaOpsStandaloneVisibleState(this.popinHandler.isPlaInOutActiveOpsStandalone());
        }
    }

    public void updatePDCPLASystemState(PDCPLASystemState pDCPLASystemState, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "---> dsiListener.updatePDCPLASystemState(%1, %2)", (Object)pDCPLASystemState, (long)n);
        }
    }

    public void updateParkingSystemViewOptions(ParkingSystemViewOptions parkingSystemViewOptions, int n) {
        super.updateParkingSystemViewOptions(parkingSystemViewOptions, n);
    }

    protected void dsiAvailable(boolean bl) {
        if (!bl) {
            this.getLogChannel().log(1000000, "[AbstractParkingSystemPLAComponent#dsiAvailable] dsi not available, remove possible userInteraction-blocking");
            this.resetKeyConsumptionStrategy();
            this.setExtendedPowerState(false);
        }
    }

    public void spotPreSelected(int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "<--- dsi.setPDCPLAPreSelection(%1)", (long)n);
        }
        if (this.getDSI() != null) {
            this.getDSI().setPDCPLAPreSelection(n);
            this.testSupportHandler.updateHMILastPreSelected(n);
        }
    }

    public void spotSelected(int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "<--- dsi.setPDCPLAParkMode(%1)", (long)n);
        }
        if (this.getDSI() != null) {
            this.getDSI().setPDCPLAParkMode(n);
            this.testSupportHandler.updateHMILastSelected(n);
        }
    }

    public int getCurrentPlaMode() {
        return null != this.plaStatus ? this.plaStatus.mode : 0;
    }

    public void updateCurrentDisplayContent(DisplayContent displayContent, boolean bl) {
        this.popinHandler.updateVpsOpsPopup(displayContent, bl);
    }

    public void canceledByHMI() {
        PDCPLASystemState pDCPLASystemState = new PDCPLASystemState(false, false);
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "<--- dsi.setPDCPLASystemState(%1)", (Object)pDCPLASystemState);
        }
        if (this.getDSI() != null) {
            this.popinHandler.setCanceledByHMI();
            this.getDSI().setPDCPLASystemState(pDCPLASystemState);
        }
    }

    public void notifyPlaOpsStandaloneVisibleState(boolean bl) {
        if (bl) {
            this.messageHandler.setPlaOpsStandaloneState(this.parkingSpotHandler.isActiveParkInSpotLeft() ? 1 : 2);
        } else {
            this.messageHandler.setPlaOpsStandaloneState(0);
        }
        this.messageHandler.updateMessage();
    }

    public void notifyOPSActive(boolean bl) {
        this.messageHandler.updateMessage();
    }

    public boolean isSystemActive() {
        return this.systemActive;
    }
}

