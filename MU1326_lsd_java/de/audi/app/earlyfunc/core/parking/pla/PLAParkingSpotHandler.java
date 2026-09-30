/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.core.parking.pla.IPLAParkingSpotHandler;
import de.audi.app.earlyfunc.core.parking.pla.IParkingSpotSelection;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carparkingsystem.PDCPLAInstructions;
import org.dsi.ifc.carparkingsystem.PDCPLAParkingSpot;
import org.dsi.ifc.carparkingsystem.PDCPLAStatus;

public class PLAParkingSpotHandler
implements IPLAParkingSpotHandler,
ChoiceListener {
    public static final int PARKING_SPOT_FRONT_LEFT = 0;
    public static final int PARKING_SPOT_FRONT_RIGHT = 1;
    public static final int PARKING_SPOT_MIDDLE_LEFT = 2;
    public static final int PARKING_SPOT_MIDDLE_RIGHT = 3;
    public static final int PARKING_SPOT_BACK_LEFT = 4;
    public static final int PARKING_SPOT_BACK_RIGHT = 5;
    private static final int OPTION_ICON_POS_DEFAULT = 0;
    private static final int OPTION_ICON_POS_SPECIAL = 1;
    private static final int OPTION_ICON_POS_DEFAULT_PARK_OUT = 2;
    private volatile boolean parkInActive;
    private volatile int preSelection;
    private volatile int currentActiveParkingSpot;
    private volatile PDCPLAStatus currentPLAState = new PDCPLAStatus();
    private final LogChannel logChannel;
    private final ICarApplication application;
    private final IParkingSpotSelection spotSelection;
    private final ParkingSpotConstant[] parkingSpotConstants = new ParkingSpotConstant[]{new ParkingSpotConstant(0, 3, 2, 8), new ParkingSpotConstant(1, 4, 3, 9), new ParkingSpotConstant(2, 5, 4, 10), new ParkingSpotConstant(3, 6, 5, 11), new ParkingSpotConstant(4, 1, 0, 6), new ParkingSpotConstant(5, 2, 1, 7)};

    public PLAParkingSpotHandler(ICarApplication iCarApplication, IParkingSpotSelection iParkingSpotSelection, LogChannel logChannel) {
        this.application = iCarApplication;
        this.logChannel = logChannel;
        this.spotSelection = iParkingSpotSelection;
    }

    public void init() {
        this.application.getFrameworkAccess().getHmiServiceApp().getButtonModel(2100197).setButtonListener(this);
    }

    public void deinit() {
        this.application.getFrameworkAccess().getHmiServiceApp().getButtonModel(2100197).resetListener();
    }

    public synchronized void updateSelectedParkingSpot(int n) {
        this.currentActiveParkingSpot = n;
        this.updateSelectedParkingSpot(n, this.currentPLAState.getMode(), this.currentPLAState.getInstructions());
    }

    public synchronized void updateParkingSpots(PDCPLAStatus pDCPLAStatus) {
        this.logChannel.log(1000000, "[PLAParkingSpotHandler#updateParkingSpots] called");
        this.currentPLAState = pDCPLAStatus;
        this.preSelection = pDCPLAStatus.getPreSelection();
        PDCPLAParkingSpot pDCPLAParkingSpot = pDCPLAStatus.getParkingSpot();
        this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(2100183).setValue(pDCPLAParkingSpot.isForwardParkboxSlotLeftFound() ? 0 : 1);
        this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(2100184).setValue(pDCPLAParkingSpot.isForwardParkboxSlotRightFound() ? 0 : 1);
        this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(2100185).setValue(pDCPLAParkingSpot.isBackwardParallelToRoadSlotLeftFound() ? 0 : 1);
        this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(2100186).setValue(pDCPLAParkingSpot.isBackwardParallelToRoadSlotRightFound() ? 0 : 1);
        this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(2100181).setValue(pDCPLAParkingSpot.isBackwardParkboxSlotLeftFound() ? 0 : 1);
        this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(2100182).setValue(pDCPLAParkingSpot.isBackwardParkboxSlotRightFound() ? 0 : 1);
        switch (pDCPLAStatus.getMode()) {
            case 3: 
            case 5: {
                this.parkInActive = false;
                break;
            }
            default: {
                this.parkInActive = true;
            }
        }
        this.updateSelectedParkingSpot(this.getSelectedSpot(pDCPLAStatus.getPreSelection()), pDCPLAStatus.getMode(), pDCPLAStatus.getInstructions());
    }

    private int getSelectedSpot(int n) {
        if (n == 0) {
            return 255;
        }
        if (n <= 6) {
            return n - 1;
        }
        this.logChannel.log(100000000, "[PLAParkingSpotHandler#getSelectedSpot] PreSelection: %1 is out of range!", (long)n);
        return 255;
    }

    public boolean isActiveParkInSpotLeft() {
        return this.currentActiveParkingSpot == 4 || this.currentActiveParkingSpot == 0 || this.currentActiveParkingSpot == 2;
    }

    private void parkingSpotSelected(int n) {
        int n2 = this.getDSIParkingSpotForHmiIndex(n);
        if (n2 != -1) {
            this.spotSelection.spotSelected(n2);
        } else {
            this.logChannel.log(10000, "[PLAParkingSpotHandler#parkingSpotSelected] cannot find DSI value for HMI index '%1'", (long)n);
        }
    }

    private void parkingSpotPreSelected(int n) {
        int n2 = this.getDSIPreSelectionForHmiIndex(n);
        if (n2 != -1) {
            this.spotSelection.spotPreSelected(n2);
        } else {
            this.logChannel.log(10000, "[PLAParkingSpotHandler#parkingSpotSelected] cannot find DSI value for HMI index '%1'", (long)n);
        }
    }

    private void preSelectedParkingSpotSelected() {
        this.parkingSpotSelected(this.getHmiIndexForPreSelection(this.preSelection));
    }

    public synchronized void itemSelected(int n, int n2, int n3, int n4) {
        this.logChannel.log(1000000, "[PLAParkingSpotHandler#itemSelected] modelID='%1', itemID='%2'", (long)n, (long)n2);
        switch (n) {
            case 2100194: {
                this.parkingSpotSelected(n2);
                break;
            }
        }
    }

    public synchronized void itemFocused(int n, int n2, int n3, int n4) {
        this.logChannel.log(1000000, "[PLAParkingSpotHandler#itemFocused] modelID='%1', itemID='%2'", (long)n, (long)n2);
        switch (n) {
            case 2100194: {
                this.parkingSpotPreSelected(n2);
                break;
            }
        }
    }

    public synchronized void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(1000000, "[PLAParkingSpotHandler#keyPressed] modelID='%1', keyID='%2'", (long)n, (long)n2);
        switch (n) {
            case 2100197: {
                this.preSelectedParkingSpotSelected();
                break;
            }
        }
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    private int getHmiIndexForPreSelection(int n) {
        for (int i2 = 0; i2 < this.parkingSpotConstants.length; ++i2) {
            ParkingSpotConstant parkingSpotConstant = this.parkingSpotConstants[i2];
            if (parkingSpotConstant.getPreSelectionDSIValue() != n) continue;
            return parkingSpotConstant.getHmiSelectionValue();
        }
        return -1;
    }

    private int getHmiIndexForSelection(int n) {
        for (int i2 = 0; i2 < this.parkingSpotConstants.length; ++i2) {
            ParkingSpotConstant parkingSpotConstant = this.parkingSpotConstants[i2];
            if (!(this.parkInActive ? parkingSpotConstant.getParkInDSIValue() == n : parkingSpotConstant.getParkOutDSIValue() == n)) continue;
            return parkingSpotConstant.getHmiSelectionValue();
        }
        return -1;
    }

    private int getDSIParkingSpotForHmiIndex(int n) {
        for (int i2 = 0; i2 < this.parkingSpotConstants.length; ++i2) {
            ParkingSpotConstant parkingSpotConstant = this.parkingSpotConstants[i2];
            if (parkingSpotConstant.getHmiSelectionValue() != n) continue;
            if (this.parkInActive) {
                return parkingSpotConstant.getParkInDSIValue();
            }
            return parkingSpotConstant.getParkOutDSIValue();
        }
        return -1;
    }

    private int getDSIPreSelectionForHmiIndex(int n) {
        for (int i2 = 0; i2 < this.parkingSpotConstants.length; ++i2) {
            ParkingSpotConstant parkingSpotConstant = this.parkingSpotConstants[i2];
            if (parkingSpotConstant.getHmiSelectionValue() != n) continue;
            return parkingSpotConstant.getPreSelectionDSIValue();
        }
        return -1;
    }

    private void updateSelectedParkingSpot(int n, int n2, PDCPLAInstructions pDCPLAInstructions) {
        int n3 = this.getHmiIndexForSelection(n);
        this.logChannel.log(1000000, "[PLAParkingSpotHandler#updateSelectedParkingSpot] dsiSpot='%1', hmiSelection='%2'", (long)n, (long)n3);
        this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(2100194).setValue(n3);
        boolean bl = this.currentPLAState.getInstructions() != null && !this.currentPLAState.getInstructions().plaSearchRightSide && this.currentPLAState.getInstructions().plaSearchLeftSide;
        int n4 = bl ? 1 : 0;
        this.updateOptionIconPosition(n3, n2, n4);
    }

    private void updateOptionIconPosition(int n, int n2, int n3) {
        if (n2 != 0) {
            int n4 = this.getOptionIconPosition(n, n2, n3);
            ChoiceModelApp choiceModelApp = this.application.getFrameworkAccess().getHmiServiceApp().getChoiceModel(2100351);
            this.logChannel.log(10000000, "[PLAParkingSpotHandler#updateOptionIconPosition] move option icon to %1 position: model='%2' , position='%3'", (Object)(n4 == 1 ? "special" : (n4 == 2 ? "default_park_out" : "default")), (long)choiceModelApp.getID(), (long)n4);
            choiceModelApp.setValue(n4);
        }
    }

    private int getOptionIconPosition(int n, int n2, int n3) {
        if (n2 == 4) {
            if (n == 4 || n == 0 || n == 2) {
                return 1;
            }
            return 0;
        }
        if (n2 == 5 || n2 == 3) {
            return 2;
        }
        return n3;
    }

    private class ParkingSpotConstant {
        private final int hmiSelectionValue;
        private final int preSelectionDSIValue;
        private final int parkInDSIValue;
        private final int parkOutDSIValue;

        ParkingSpotConstant(int n, int n2, int n3, int n4) {
            this.hmiSelectionValue = n;
            this.preSelectionDSIValue = n2;
            this.parkInDSIValue = n3;
            this.parkOutDSIValue = n4;
        }

        int getHmiSelectionValue() {
            return this.hmiSelectionValue;
        }

        int getPreSelectionDSIValue() {
            return this.preSelectionDSIValue;
        }

        int getParkInDSIValue() {
            return this.parkInDSIValue;
        }

        int getParkOutDSIValue() {
            return this.parkOutDSIValue;
        }
    }
}

