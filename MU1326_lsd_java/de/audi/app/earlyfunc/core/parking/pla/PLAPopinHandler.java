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
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.PDCPLAStatus;

public class PLAPopinHandler
implements IPLAPopinHandler {
    private static final boolean PLA_INACTIVE = false;
    private static final boolean PLA_ACTIVE = true;
    public static final int SCREEN_PLA_NONE = 0;
    public static final int SCREEN_SEARCH_SELECTION = 1;
    public static final int SCREEN_IN_OUT_ACTIVE_OPS_STANDALONE = 2;
    private static final int STATE_ID_PLA_IDLE = 0;
    private static final int STATE_ID_PLA_BIG = 1;
    private static final int STATE_ID_PLA_IN_OUT_ACTIVE_PDC_UNKNOWN = 2;
    private static final int STATE_ID_PLA_IN_OUT_ACTIVE_VPS = 3;
    private static final int STATE_ID_PLA_IN_OUT_ACTIVE_OPS = 4;
    private static final int ACTION_NONE = 0;
    private static final int ACTION_UPDATE_CONTENT = 1;
    private static final int ACTION_HIJACK_PARKING_CONTROLLER = 2;
    private static final int ACTION_RELEASE_PARKING_CONTROLLER = 3;
    private static final int ACTION_SIGNAL_OPS_VPS_STATE = 4;
    private static final int ACTION_SWITCH_SCREEN = 5;
    private final AbstractPlaSMState statePlaIdle = new AbstractPlaSMState(0, 0, false, "STATE_PLA_IDLE"){

        protected void processVpsOpsPopupUpdate(DisplayContent displayContent, boolean bl) {
            PLAPopinHandler.this.switchSreen(this, 0);
            PLAPopinHandler.this.canceledByHMI = false;
            PLAPopinHandler.this.setQueuedDisplayContent(null);
            PLAPopinHandler.this.removePopupRequest(this);
            PLAPopinHandler.this.removeOPSPartialPopupSuppression(this);
        }

        protected void hijackParkingController() {
        }

        protected void releaseParkingController() {
        }
    };
    private final AbstractPlaSMState statePlaBig = new AbstractPlaSMState(1, 1, true, "STATE_PLA_BIG"){

        protected void processVpsOpsPopupUpdate(DisplayContent displayContent, boolean bl) {
            if (PLAPopinHandler.this.controller.hasVPSContent(displayContent)) {
                PLAPopinHandler.this.setQueuedDisplayContent(displayContent);
                int n = this.getPLAReplacementPopupID(displayContent);
                if (bl) {
                    DisplayContent displayContent2 = new DisplayContent();
                    displayContent2.popup = n;
                    displayContent2.view = displayContent.view;
                    displayContent2.screen = displayContent.screen;
                    displayContent2.mode = displayContent.mode;
                    PLAPopinHandler.this.logChannel.log(1000000, "[AbstractPlaSMState('%1')#processVpsOpsPopupUpdate] controller.changeDisplayContent('%2')", (Object)this, (Object)displayContent2);
                    PLAPopinHandler.this.controller.changeDisplayContent(displayContent2, false);
                } else {
                    displayContent.popup = n;
                    PLAPopinHandler.this.logChannel.log(1000000, "[AbstractPlaSMState('%1')#processVpsOpsPopupUpdate] changed DisplayContent for dsi.showParkingPopup() to '%2'", (Object)this, (Object)displayContent);
                }
            } else if (displayContent.popup == 0 || !bl && !PLAPopinHandler.this.controller.hasOPSContent(displayContent)) {
                PLAPopinHandler.this.setQueuedDisplayContent(null);
            }
        }

        protected void hijackParkingController() {
            PLAPopinHandler.this.switchSreen(this, 1);
            PLAPopinHandler.this.setPLAPopupControlActive(this, true);
            PLAPopinHandler.this.application.getFrameworkAccess().getPowerMgr().setExtendedPowerState(140, 0);
            PLAPopinHandler.this.addOPSPartialPopupSuppression(this);
            PLAPopinHandler.this.addPopupRequest(this);
        }

        protected void releaseParkingController() {
            PLAPopinHandler.this.setPLAPopupControlActive(this, false);
            if (PLAPopinHandler.this.canceledByHMI) {
                PLAPopinHandler.this.canceledByHMI = false;
                if (PLAPopinHandler.this.opsActive) {
                    return;
                }
            }
            if (PLAPopinHandler.this.getQueuedDisplayContent() != null) {
                DisplayContent displayContent = PLAPopinHandler.this.getQueuedDisplayContent();
                PLAPopinHandler.this.changeRevokingVPSDisplayContent(displayContent);
                PLAPopinHandler.this.logChannel.log(1000000, "[AbstractPlaSMState('%1')#releaseParkingController] controller.changeDisplayContent('%2','true')", (Object)this, (Object)displayContent);
                PLAPopinHandler.this.controller.changeDisplayContent(displayContent, true);
                PLAPopinHandler.this.setQueuedDisplayContent(null);
            } else {
                PLAPopinHandler.this.removePopupRequest(this);
                PLAPopinHandler.this.removeOPSPartialPopupSuppression(this);
                if (!PLAPopinHandler.this.opsActive) {
                    PLAPopinHandler.this.application.getFrameworkAccess().getPowerMgr().setExtendedPowerState(142, 0);
                }
            }
        }
    };
    private final AbstractPlaSMState statePlaInOutActivePdcUnknown = new AbstractPlaSMState(2, 0, false, "STATE_PLA_IN_OUT_ACTIVE_PDC_UNKNOWN"){

        protected void processVpsOpsPopupUpdate(DisplayContent displayContent, boolean bl) {
        }

        protected void hijackParkingController() {
            PLAPopinHandler.this.setPLAPopupControlActive(this, true);
        }

        protected void releaseParkingController() {
            PLAPopinHandler.this.setPLAPopupControlActive(this, false);
        }
    };
    private final AbstractPlaSMState statePlaInOutActiveVps = new AbstractPlaSMState(3, 0, true, "STATE_PLA_IN_OUT_ACTIVE_VPS"){

        protected void processVpsOpsPopupUpdate(DisplayContent displayContent, boolean bl) {
            if (bl) {
                if (PLAPopinHandler.this.controller.hasVPSContent(displayContent)) {
                    PLAPopinHandler.this.switchSreen(this, 0);
                    PLAPopinHandler.this.removeOPSPartialPopupSuppression(this);
                    PLAPopinHandler.this.removePopupRequest(this);
                }
            } else {
                PLAPopinHandler.this.setPLAPopupControlActive(this, false);
            }
        }

        protected void hijackParkingController() {
        }

        protected void releaseParkingController() {
            PLAPopinHandler.this.setPLAPopupControlActive(this, false);
        }
    };
    private final AbstractPlaSMState statePlaInOutActiveOps = new AbstractPlaSMState(4, 2, true, "STATE_PLA_IN_OUT_ACTIVE_OPS"){

        protected void processVpsOpsPopupUpdate(DisplayContent displayContent, boolean bl) {
            if (PLAPopinHandler.this.controller.hasOPSContent(displayContent) && !PLAPopinHandler.this.controller.hasVPSContent(displayContent)) {
                PLAPopinHandler.this.switchSreen(this, 2);
                PLAPopinHandler.this.addOPSPartialPopupSuppression(this);
                PLAPopinHandler.this.addPopupRequest(this);
            }
        }

        protected void hijackParkingController() {
            PLAPopinHandler.this.setPLAPopupControlActive(this, true);
        }

        protected void releaseParkingController() {
            PLAPopinHandler.this.setPLAPopupControlActive(this, false);
            if (PLAPopinHandler.this.opsActive && PLAPopinHandler.this.canceledByHMI) {
                PLAPopinHandler.this.canceledByHMI = false;
                return;
            }
            PLAPopinHandler.this.removePopupRequest(this);
            PLAPopinHandler.this.removeOPSPartialPopupSuppression(this);
            PLAPopinHandler.this.switchSreen(this, 0);
        }
    };
    private final PlaSMTransition[] plaStateTransitions = new PlaSMTransition[]{new PlaSMTransition(0, 1, new int[]{2, 4}), new PlaSMTransition(1, 0, new int[]{3}), new PlaSMTransition(0, 4, new int[]{2, 4}), new PlaSMTransition(4, 0, new int[]{3}), new PlaSMTransition(0, 3, new int[]{4}), new PlaSMTransition(3, 0, new int[]{0}), new PlaSMTransition(0, 4, new int[]{2, 4}), new PlaSMTransition(4, 0, new int[]{3}), new PlaSMTransition(0, 2, new int[]{2}), new PlaSMTransition(2, 0, new int[]{3}), new PlaSMTransition(1, 4, new int[]{5}), new PlaSMTransition(4, 1, new int[]{5}), new PlaSMTransition(1, 3, new int[]{3, 4}), new PlaSMTransition(3, 1, new int[]{2, 4}), new PlaSMTransition(2, 4, new int[]{2}), new PlaSMTransition(4, 2, new int[]{3}), new PlaSMTransition(2, 3, new int[]{0}), new PlaSMTransition(2, 1, new int[]{2, 4}), new PlaSMTransition(3, 4, new int[]{2, 4}), new PlaSMTransition(4, 3, new int[]{3, 4})};
    private boolean opsActive = false;
    private boolean canceledByHMI = false;
    private DisplayContent lastReceivedParkingPopupContent = new DisplayContent();
    private boolean isContentShown = false;
    private PDCPLAStatus currentPLAState = new PDCPLAStatus();
    private final IParkingSystemController controller;
    private final AbstractParkingSystemPLAComponent plaParkingSystem;
    private AbstractPlaSMState currentPlaSMState;
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

    public void init() {
    }

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
        this.logChannel.log(1000000, "[PLAPopinHandler#setQueuedDsiplayContent] queuedDisplayContent='%2'", (Object)this, (Object)displayContent);
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
        return this.application.getFrameworkAccess().getHMIService().getChoiceModel(2100178).getValue() == 0;
    }

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

    private void setPLAPopupControlActive(AbstractPlaSMState abstractPlaSMState, boolean bl) {
        this.logChannel.log(1000000, "[AbstractPlaSMState('%1')#setPLAPopupControlActive] active='%2'", (Object)abstractPlaSMState, (Object)bl);
        this.controller.notifyParkingSystemActive(this.plaParkingSystem, bl);
    }

    private void addOPSPartialPopupSuppression(AbstractPlaSMState abstractPlaSMState) {
        this.logChannel.log(1000000, "[AbstractPlaSMState('%1')#addOPSPartialPopupSuppression] popupID='%2'", (Object)abstractPlaSMState, (long)this.plaParkingSystem.getPLAPartialPopupID());
        this.controller.addPopupRequestSuppression(new ParkingPopupIdentifier(1, this.plaParkingSystem.getPLAPartialPopupID()), this.plaParkingSystem);
    }

    private void removeOPSPartialPopupSuppression(AbstractPlaSMState abstractPlaSMState) {
        this.logChannel.log(1000000, "[AbstractPlaSMState('%1')#removeOPSPartialPopupSuppression] popupID='%2'", (Object)abstractPlaSMState, (long)this.plaParkingSystem.getPLAPartialPopupID());
        this.controller.removePopupRequestSuppression(new ParkingPopupIdentifier(1, this.plaParkingSystem.getPLAPartialPopupID()), this.plaParkingSystem);
    }

    private void addPopupRequest(AbstractPlaSMState abstractPlaSMState) {
        this.logChannel.log(1000000, "[AbstractPlaSMState('%1')#addPopupRequest] popupID='%2'", (Object)abstractPlaSMState, (Object)this.plaParkingSystem.getHMIPopupID(0));
        this.controller.addPopupRequest(this.plaParkingSystem.getHMIPopupID(0), this.plaParkingSystem);
    }

    private void removePopupRequest(AbstractPlaSMState abstractPlaSMState) {
        this.logChannel.log(1000000, "[AbstractPlaSMState('%1')#removePopupRequest] popupID='%2'", (Object)abstractPlaSMState, (Object)this.plaParkingSystem.getHMIPopupID(0));
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
        this.logChannel.log(1000000, "[PLAPopinHandler#updateMode] mode='%1'", (long)n);
        AbstractPlaSMState abstractPlaSMState = this.determineTargetState(n, bl);
        int[] nArray = this.getActionList(this.currentPlaSMState.getId(), abstractPlaSMState.getId());
        this.logChannel.log(1000000, "[PLAPopinHandler#updateMode] execute actions for transition from currentState='%1' to targetState='%2': actions='%3'", (Object)this.currentPlaSMState, (Object)abstractPlaSMState, (Object)nArray);
        block6: for (int i2 = 0; i2 < nArray.length; ++i2) {
            switch (nArray[i2]) {
                case 5: {
                    this.switchSreen(abstractPlaSMState, abstractPlaSMState.getScreen());
                    continue block6;
                }
                case 2: {
                    abstractPlaSMState.hijackParkingController();
                    continue block6;
                }
                case 3: {
                    this.currentPlaSMState.releaseParkingController();
                    continue block6;
                }
                case 4: {
                    abstractPlaSMState.updateVpsOpsPopup(this.getLastReceivedParkingPopupContent(), this.isContentShown);
                    continue block6;
                }
            }
        }
        this.currentPlaSMState = abstractPlaSMState;
    }

    private void switchSreen(AbstractPlaSMState abstractPlaSMState, int n) {
        this.logChannel.log(1000000, "[AbstractPlaSMState('%1')#switchSreen] screen='%2'", (Object)abstractPlaSMState, (long)n);
        ChoiceModelApp choiceModelApp = this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(2100346);
        choiceModelApp.forceUpdate(false);
        choiceModelApp.setValue(n);
        this.plaParkingSystem.notifyPlaOpsStandaloneVisibleState(n == 2);
    }

    private int[] getActionList(int n, int n2) {
        if (n != n2) {
            for (int i2 = 0; i2 < this.plaStateTransitions.length; ++i2) {
                PlaSMTransition plaSMTransition = this.plaStateTransitions[i2];
                if (plaSMTransition.getSourceState() != n || plaSMTransition.getTargetState() != n2) continue;
                return plaSMTransition.getActions();
            }
        }
        return new int[0];
    }

    private AbstractPlaSMState determineTargetState(int n, boolean bl) {
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

    public void setCanceledByHMI() {
        this.canceledByHMI = true;
    }

    public boolean isPlaInOutActiveOpsStandalone() {
        ChoiceModelApp choiceModelApp = this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(2100346);
        return choiceModelApp.getValue() == 2;
    }

    private class PlaSMTransition {
        private final int sourceState;
        private final int targetState;
        private final int[] actions;

        PlaSMTransition(int n, int n2, int[] nArray) {
            this.sourceState = n;
            this.targetState = n2;
            this.actions = nArray;
        }

        int getSourceState() {
            return this.sourceState;
        }

        int getTargetState() {
            return this.targetState;
        }

        int[] getActions() {
            return this.actions;
        }
    }

    abstract class AbstractPlaSMState {
        private final int id;
        private final String stateName;
        private final int screen;
        private final boolean plaActive;

        AbstractPlaSMState(int n, int n2, boolean bl, String string) {
            this.id = n;
            this.screen = n2;
            this.plaActive = bl;
            this.stateName = string;
        }

        int getId() {
            return this.id;
        }

        private int getScreen() {
            return this.screen;
        }

        private boolean isPlaActive() {
            return this.plaActive;
        }

        private String getStateName() {
            return this.stateName;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(this.getStateName()).append('(').append(this.getId()).append(')');
            return stringBuffer.toString();
        }

        public int getPLAReplacementPopupID(DisplayContent displayContent) {
            return 15;
        }

        public void updateVpsOpsPopup(DisplayContent displayContent, boolean bl) {
            PLAPopinHandler.this.logChannel.log(1000000, "[AbstractPlaSMState('%1')#updateVpsOpsPopup] content='%2' , displayed='%3'", (Object)this, (Object)displayContent, (Object)bl);
            this.processVpsOpsPopupUpdate(displayContent, bl);
        }

        protected abstract void processVpsOpsPopupUpdate(DisplayContent var1, boolean var2);

        protected abstract void hijackParkingController();

        protected abstract void releaseParkingController();
    }
}

