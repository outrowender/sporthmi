/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.core.parking.IParkingSystemController;
import de.audi.app.earlyfunc.core.parking.ParkingPopupIdentifier;
import de.audi.app.earlyfunc.core.parking.pla.AbstractParkingSystemPLAComponent;
import de.audi.app.earlyfunc.core.parking.pla.IPLAInterappServiceHandler;
import de.audi.app.earlyfunc.core.parking.pla.IPLAPopinHandler;
import de.audi.app.earlyfunc.core.parking.pla.PLAInterappStatus;
import de.audi.app.earlyfunc.core.parking.pla.PLAPopinHandler$1;
import de.audi.app.earlyfunc.core.parking.pla.PLAPopinHandler$2;
import de.audi.app.earlyfunc.core.parking.pla.PLAPopinHandler$3;
import de.audi.app.earlyfunc.core.parking.pla.PLAPopinHandler$4;
import de.audi.app.earlyfunc.core.parking.pla.PLAPopinHandler$5;
import de.audi.app.earlyfunc.core.parking.pla.PLAPopinHandler$AbstractPlaSMState;
import de.audi.app.earlyfunc.core.parking.pla.PLAPopinHandler$PlaSMTransition;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.PDCPLAStatus;

public class PLAPopinHandler
implements IPLAPopinHandler {
    private static final boolean PLA_INACTIVE;
    private static final boolean PLA_ACTIVE;
    public static final int SCREEN_PLA_NONE;
    public static final int SCREEN_SEARCH_SELECTION;
    public static final int SCREEN_IN_OUT_ACTIVE_OPS_STANDALONE;
    private static final int STATE_ID_PLA_IDLE;
    private static final int STATE_ID_PLA_BIG;
    private static final int STATE_ID_PLA_IN_OUT_ACTIVE_PDC_UNKNOWN;
    private static final int STATE_ID_PLA_IN_OUT_ACTIVE_VPS;
    private static final int STATE_ID_PLA_IN_OUT_ACTIVE_OPS;
    private static final int ACTION_NONE;
    private static final int ACTION_UPDATE_CONTENT;
    private static final int ACTION_HIJACK_PARKING_CONTROLLER;
    private static final int ACTION_RELEASE_PARKING_CONTROLLER;
    private static final int ACTION_SIGNAL_OPS_VPS_STATE;
    private static final int ACTION_SWITCH_SCREEN;
    private final PLAPopinHandler$AbstractPlaSMState statePlaIdle = new PLAPopinHandler$1(this, 0, 0, false, "STATE_PLA_IDLE");
    private final PLAPopinHandler$AbstractPlaSMState statePlaBig = new PLAPopinHandler$2(this, 1, 1, true, "STATE_PLA_BIG");
    private final PLAPopinHandler$AbstractPlaSMState statePlaInOutActivePdcUnknown = new PLAPopinHandler$3(this, 2, 0, false, "STATE_PLA_IN_OUT_ACTIVE_PDC_UNKNOWN");
    private final PLAPopinHandler$AbstractPlaSMState statePlaInOutActiveVps = new PLAPopinHandler$4(this, 3, 0, true, "STATE_PLA_IN_OUT_ACTIVE_VPS");
    private final PLAPopinHandler$AbstractPlaSMState statePlaInOutActiveOps = new PLAPopinHandler$5(this, 4, 2, true, "STATE_PLA_IN_OUT_ACTIVE_OPS");
    private final PLAPopinHandler$PlaSMTransition[] plaStateTransitions = new PLAPopinHandler$PlaSMTransition[]{new PLAPopinHandler$PlaSMTransition(this, 0, 1, new int[]{2, 4}), new PLAPopinHandler$PlaSMTransition(this, 1, 0, new int[]{3}), new PLAPopinHandler$PlaSMTransition(this, 0, 4, new int[]{2, 4}), new PLAPopinHandler$PlaSMTransition(this, 4, 0, new int[]{3}), new PLAPopinHandler$PlaSMTransition(this, 0, 3, new int[]{4}), new PLAPopinHandler$PlaSMTransition(this, 3, 0, new int[]{0}), new PLAPopinHandler$PlaSMTransition(this, 0, 4, new int[]{2, 4}), new PLAPopinHandler$PlaSMTransition(this, 4, 0, new int[]{3}), new PLAPopinHandler$PlaSMTransition(this, 0, 2, new int[]{2}), new PLAPopinHandler$PlaSMTransition(this, 2, 0, new int[]{3}), new PLAPopinHandler$PlaSMTransition(this, 1, 4, new int[]{5}), new PLAPopinHandler$PlaSMTransition(this, 4, 1, new int[]{5}), new PLAPopinHandler$PlaSMTransition(this, 1, 3, new int[]{3, 4}), new PLAPopinHandler$PlaSMTransition(this, 3, 1, new int[]{2, 4}), new PLAPopinHandler$PlaSMTransition(this, 2, 4, new int[]{2}), new PLAPopinHandler$PlaSMTransition(this, 4, 2, new int[]{3}), new PLAPopinHandler$PlaSMTransition(this, 2, 3, new int[]{0}), new PLAPopinHandler$PlaSMTransition(this, 2, 1, new int[]{2, 4}), new PLAPopinHandler$PlaSMTransition(this, 3, 4, new int[]{2, 4}), new PLAPopinHandler$PlaSMTransition(this, 4, 3, new int[]{3, 4})};
    private boolean opsActive = false;
    private boolean canceledByHMI = false;
    private DisplayContent lastReceivedParkingPopupContent = new DisplayContent();
    private boolean isContentShown = false;
    private PDCPLAStatus currentPLAState = new PDCPLAStatus();
    private final IParkingSystemController controller;
    private final AbstractParkingSystemPLAComponent plaParkingSystem;
    private PLAPopinHandler$AbstractPlaSMState currentPlaSMState;
    private final LogChannel logChannel;
    private final ICarApplication application;
    private final IPLAInterappServiceHandler plaWidgetComHandler;
    private DisplayContent queuedDisplayContent = null;

    public PLAPopinHandler(IParkingSystemController iParkingSystemController, AbstractParkingSystemPLAComponent abstractParkingSystemPLAComponent, LogChannel logChannel, ICarApplication iCarApplication, IPLAInterappServiceHandler iPLAInterappServiceHandler) {
        this.logChannel = logChannel;
        this.controller = iParkingSystemController;
        this.plaParkingSystem = abstractParkingSystemPLAComponent;
        this.application = iCarApplication;
        this.plaWidgetComHandler = iPLAInterappServiceHandler;
        this.currentPlaSMState = this.statePlaIdle;
    }

    @Override
    public void init() {
    }

    @Override
    public void deinit() {
    }

    private PDCPLAStatus getCurrentPLAState() {
        return this.currentPLAState;
    }

    private void setCurrentPLAState(PDCPLAStatus pDCPLAStatus) {
        this.currentPLAState = pDCPLAStatus;
    }

    private DisplayContent getQueuedDisplayContent() {
        return this.queuedDisplayContent;
    }

    private void setQueuedDisplayContent(DisplayContent displayContent) {
        this.logChannel.log(1078071040, "[PLAPopinHandler#setQueuedDsiplayContent] queuedDisplayContent='%2'", (Object)this, (Object)displayContent);
        this.queuedDisplayContent = displayContent != null ? new DisplayContent(displayContent.getPopup(), displayContent.getScreen(), displayContent.getView(), displayContent.getMode()) : displayContent;
    }

    private void changeRevokingVPSDisplayContent(DisplayContent displayContent) {
        if (this.getCurrentPLAState().mode == 4 || this.getCurrentPLAState().mode == 5) {
            displayContent.popup = 16;
        } else if (this.getCurrentPLAState().mode == 0) {
            displayContent.popup = 8;
        }
        displayContent.view = 1;
        displayContent.mode = 1;
        displayContent.screen = this.isTopViewAvailable() ? 2 : 1;
    }

    private boolean isTopViewAvailable() {
        return this.application.getFrameworkAccess().getHMIService().getChoiceModel(-771022848).getValue() == 0;
    }

    @Override
    public void updateVpsOpsPopup(DisplayContent displayContent, boolean bl) {
        this.setLastReceivedParkingPopupContent(displayContent, bl);
        PDCPLAStatus pDCPLAStatus = this.getCurrentPLAState();
        boolean bl2 = this.updatePLAWidgetState(this.opsActive, pDCPLAStatus);
        switch (pDCPLAStatus.getMode()) {
            case 0: 
            case 4: 
            case 5: {
                this.updateMode(pDCPLAStatus.getMode(), false);
                break;
            }
            default: {
                this.updateMode(pDCPLAStatus.getMode(), bl2);
            }
        }
        this.currentPlaSMState.updateVpsOpsPopup(displayContent, bl);
    }

    @Override
    public void updatePDCPLAStatus(PDCPLAStatus pDCPLAStatus) {
        this.setCurrentPLAState(pDCPLAStatus);
        boolean bl = this.updatePLAWidgetState(this.isOpsActive(), pDCPLAStatus);
        switch (pDCPLAStatus.getMode()) {
            case 0: 
            case 4: 
            case 5: {
                this.updateMode(pDCPLAStatus.getMode(), false);
                break;
            }
            default: {
                this.updateMode(pDCPLAStatus.getMode(), bl);
            }
        }
    }

    private boolean isOpsActive() {
        return this.opsActive;
    }

    private void setOpsActive(boolean bl) {
        this.opsActive = bl;
    }

    private boolean updatePLAWidgetState(boolean bl, PDCPLAStatus pDCPLAStatus) {
        int n = pDCPLAStatus.getMode();
        if (n == 0) {
            this.plaWidgetComHandler.updatePLAStatusIdleMode();
        } else if (n == 6) {
            this.plaWidgetComHandler.updatePLAStatusStandbyMode(new PLAInterappStatus(pDCPLAStatus, bl));
        } else if (n == 1) {
            this.plaWidgetComHandler.updatePLAStatusSearchMode(new PLAInterappStatus(pDCPLAStatus, bl));
        } else if (n == 2) {
            this.plaWidgetComHandler.updatePLAStatusInSelectionMode(new PLAInterappStatus(pDCPLAStatus, bl));
        } else if (n == 3) {
            this.plaWidgetComHandler.updatePLAStatusOutSelectionMode(new PLAInterappStatus(pDCPLAStatus, bl));
        } else if (n == 4) {
            this.plaWidgetComHandler.updatePLAStatusParkInActive(new PLAInterappStatus(pDCPLAStatus, bl));
        } else if (n == 5) {
            this.plaWidgetComHandler.updatePLAStatusParkOutActive(new PLAInterappStatus(pDCPLAStatus, bl));
        } else {
            return false;
        }
        return true;
    }

    private void setPLAPopupControlActive(PLAPopinHandler$AbstractPlaSMState pLAPopinHandler$AbstractPlaSMState, boolean bl) {
        this.logChannel.log(1078071040, "[AbstractPlaSMState('%1')#setPLAPopupControlActive] active='%2'", (Object)pLAPopinHandler$AbstractPlaSMState, (Object)bl);
        this.controller.notifyParkingSystemActive(this.plaParkingSystem, bl);
    }

    private void addOPSPartialPopupSuppression(PLAPopinHandler$AbstractPlaSMState pLAPopinHandler$AbstractPlaSMState) {
        this.logChannel.log(1078071040, "[AbstractPlaSMState('%1')#addOPSPartialPopupSuppression] popupID='%2'", (Object)pLAPopinHandler$AbstractPlaSMState, (long)this.plaParkingSystem.getPLAPartialPopupID());
        this.controller.addPopupRequestSuppression(new ParkingPopupIdentifier(1, this.plaParkingSystem.getPLAPartialPopupID()), this.plaParkingSystem);
    }

    private void removeOPSPartialPopupSuppression(PLAPopinHandler$AbstractPlaSMState pLAPopinHandler$AbstractPlaSMState) {
        this.logChannel.log(1078071040, "[AbstractPlaSMState('%1')#removeOPSPartialPopupSuppression] popupID='%2'", (Object)pLAPopinHandler$AbstractPlaSMState, (long)this.plaParkingSystem.getPLAPartialPopupID());
        this.controller.removePopupRequestSuppression(new ParkingPopupIdentifier(1, this.plaParkingSystem.getPLAPartialPopupID()), this.plaParkingSystem);
    }

    private void addPopupRequest(PLAPopinHandler$AbstractPlaSMState pLAPopinHandler$AbstractPlaSMState) {
        this.logChannel.log(1078071040, "[AbstractPlaSMState('%1')#addPopupRequest] popupID='%2'", (Object)pLAPopinHandler$AbstractPlaSMState, (Object)this.plaParkingSystem.getHMIPopupID(0));
        this.controller.addPopupRequest(this.plaParkingSystem.getHMIPopupID(0), this.plaParkingSystem);
    }

    private void removePopupRequest(PLAPopinHandler$AbstractPlaSMState pLAPopinHandler$AbstractPlaSMState) {
        this.logChannel.log(1078071040, "[AbstractPlaSMState('%1')#removePopupRequest] popupID='%2'", (Object)pLAPopinHandler$AbstractPlaSMState, (Object)this.plaParkingSystem.getHMIPopupID(0));
        this.controller.removePopupRequest(this.plaParkingSystem.getHMIPopupID(0), this.plaParkingSystem);
    }

    private DisplayContent getLastReceivedParkingPopupContent() {
        return this.lastReceivedParkingPopupContent;
    }

    private void setLastReceivedParkingPopupContent(DisplayContent displayContent, boolean bl) {
        this.isContentShown = bl;
        if (displayContent != null) {
            this.lastReceivedParkingPopupContent = new DisplayContent(displayContent.getPopup(), displayContent.getScreen(), displayContent.getView(), displayContent.getMode());
            this.setOpsActive(this.controller.hasOPSContent(displayContent));
        } else {
            this.lastReceivedParkingPopupContent = new DisplayContent();
            this.setOpsActive(false);
        }
    }

    private void updateMode(int n, boolean bl) {
        this.logChannel.log(1078071040, "[PLAPopinHandler#updateMode] mode='%1'", (long)n);
        PLAPopinHandler$AbstractPlaSMState pLAPopinHandler$AbstractPlaSMState = this.determineTargetState(n, bl);
        int[] nArray = this.getActionList(this.currentPlaSMState.getId(), pLAPopinHandler$AbstractPlaSMState.getId());
        this.logChannel.log(1078071040, "[PLAPopinHandler#updateMode] execute actions for transition from currentState='%1' to targetState='%2': actions='%3'", (Object)this.currentPlaSMState, (Object)pLAPopinHandler$AbstractPlaSMState, (Object)nArray);
        block6: for (int i2 = 0; i2 < nArray.length; ++i2) {
            switch (nArray[i2]) {
                case 5: {
                    this.switchSreen(pLAPopinHandler$AbstractPlaSMState, PLAPopinHandler$AbstractPlaSMState.access$1400(pLAPopinHandler$AbstractPlaSMState));
                    continue block6;
                }
                case 2: {
                    pLAPopinHandler$AbstractPlaSMState.hijackParkingController();
                    continue block6;
                }
                case 3: {
                    this.currentPlaSMState.releaseParkingController();
                    continue block6;
                }
                case 4: {
                    pLAPopinHandler$AbstractPlaSMState.updateVpsOpsPopup(this.getLastReceivedParkingPopupContent(), this.isContentShown);
                    continue block6;
                }
            }
        }
        this.currentPlaSMState = pLAPopinHandler$AbstractPlaSMState;
    }

    private void switchSreen(PLAPopinHandler$AbstractPlaSMState pLAPopinHandler$AbstractPlaSMState, int n) {
        this.logChannel.log(1078071040, "[AbstractPlaSMState('%1')#switchSreen] screen='%2'", (Object)pLAPopinHandler$AbstractPlaSMState, (long)n);
        ChoiceModelApp choiceModelApp = this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(2047614976);
        choiceModelApp.forceUpdate(false);
        choiceModelApp.setValue(n);
        this.plaParkingSystem.notifyPlaOpsStandaloneVisibleState(n == 2);
    }

    private int[] getActionList(int n, int n2) {
        if (n != n2) {
            for (int i2 = 0; i2 < this.plaStateTransitions.length; ++i2) {
                PLAPopinHandler$PlaSMTransition pLAPopinHandler$PlaSMTransition = this.plaStateTransitions[i2];
                if (pLAPopinHandler$PlaSMTransition.getSourceState() != n || pLAPopinHandler$PlaSMTransition.getTargetState() != n2) continue;
                return pLAPopinHandler$PlaSMTransition.getActions();
            }
        }
        return new int[0];
    }

    private PLAPopinHandler$AbstractPlaSMState determineTargetState(int n, boolean bl) {
        if (bl) {
            return this.statePlaBig;
        }
        if (n == 4 || n == 5) {
            if (this.controller.hasVPSContent(this.getLastReceivedParkingPopupContent()) || this.getQueuedDisplayContent() != null) {
                return this.statePlaInOutActiveVps;
            }
            if (this.controller.hasOPSContent(this.getLastReceivedParkingPopupContent())) {
                return this.statePlaInOutActiveOps;
            }
            return this.statePlaInOutActivePdcUnknown;
        }
        return this.statePlaIdle;
    }

    @Override
    public void setCanceledByHMI() {
        this.canceledByHMI = true;
    }

    @Override
    public boolean isPlaInOutActiveOpsStandalone() {
        ChoiceModelApp choiceModelApp = this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(2047614976);
        return choiceModelApp.getValue() == 2;
    }

    static /* synthetic */ void access$000(PLAPopinHandler pLAPopinHandler, PLAPopinHandler$AbstractPlaSMState abstractPlaSMState, int n) {
        pLAPopinHandler.switchSreen(abstractPlaSMState, n);
    }

    static /* synthetic */ boolean access$102(PLAPopinHandler pLAPopinHandler, boolean bl) {
        pLAPopinHandler.canceledByHMI = bl;
        return pLAPopinHandler.canceledByHMI;
    }

    static /* synthetic */ void access$200(PLAPopinHandler pLAPopinHandler, DisplayContent displayContent) {
        pLAPopinHandler.setQueuedDisplayContent(displayContent);
    }

    static /* synthetic */ void access$300(PLAPopinHandler pLAPopinHandler, PLAPopinHandler$AbstractPlaSMState abstractPlaSMState) {
        pLAPopinHandler.removePopupRequest(abstractPlaSMState);
    }

    static /* synthetic */ void access$400(PLAPopinHandler pLAPopinHandler, PLAPopinHandler$AbstractPlaSMState abstractPlaSMState) {
        pLAPopinHandler.removeOPSPartialPopupSuppression(abstractPlaSMState);
    }

    static /* synthetic */ IParkingSystemController access$500(PLAPopinHandler pLAPopinHandler) {
        return pLAPopinHandler.controller;
    }

    static /* synthetic */ LogChannel access$600(PLAPopinHandler pLAPopinHandler) {
        return pLAPopinHandler.logChannel;
    }

    static /* synthetic */ void access$700(PLAPopinHandler pLAPopinHandler, PLAPopinHandler$AbstractPlaSMState abstractPlaSMState, boolean bl) {
        pLAPopinHandler.setPLAPopupControlActive(abstractPlaSMState, bl);
    }

    static /* synthetic */ ICarApplication access$800(PLAPopinHandler pLAPopinHandler) {
        return pLAPopinHandler.application;
    }

    static /* synthetic */ void access$900(PLAPopinHandler pLAPopinHandler, PLAPopinHandler$AbstractPlaSMState abstractPlaSMState) {
        pLAPopinHandler.addOPSPartialPopupSuppression(abstractPlaSMState);
    }

    static /* synthetic */ void access$1000(PLAPopinHandler pLAPopinHandler, PLAPopinHandler$AbstractPlaSMState abstractPlaSMState) {
        pLAPopinHandler.addPopupRequest(abstractPlaSMState);
    }

    static /* synthetic */ boolean access$100(PLAPopinHandler pLAPopinHandler) {
        return pLAPopinHandler.canceledByHMI;
    }

    static /* synthetic */ boolean access$1100(PLAPopinHandler pLAPopinHandler) {
        return pLAPopinHandler.opsActive;
    }

    static /* synthetic */ DisplayContent access$1200(PLAPopinHandler pLAPopinHandler) {
        return pLAPopinHandler.getQueuedDisplayContent();
    }

    static /* synthetic */ void access$1300(PLAPopinHandler pLAPopinHandler, DisplayContent displayContent) {
        pLAPopinHandler.changeRevokingVPSDisplayContent(displayContent);
    }
}

