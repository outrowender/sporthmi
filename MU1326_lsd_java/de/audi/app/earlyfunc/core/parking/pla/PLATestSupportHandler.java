/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.atip.log.LogChannel;
import de.audi.atip.testsupport.TestSupportDataReceiverEntry;
import de.audi.atip.testsupport.handler.ITestSupportHandler;
import de.audi.atip.testsupport.handler.ITestSupportHandlerNotification;
import de.audi.atip.testsupport.handler.TestSupportHandler;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.carparkingsystem.PDCPLAInstructions;
import org.dsi.ifc.carparkingsystem.PDCPLAParkingSpot;
import org.dsi.ifc.carparkingsystem.PDCPLAStatus;

public class PLATestSupportHandler
implements ITestSupportHandlerNotification {
    private ITestSupportHandler testSupportHandler;
    private String[] testSupportData = new String[]{"", "", "", "", "", "", "", "", "", "", "", ""};
    private volatile boolean testSupportVisible = false;
    private final ICarApplication application;
    private final LogChannel logChannel;
    private volatile PDCPLAStatus plaStatus;
    private volatile int plaMessage;
    private volatile int lastSelected;
    private volatile int lastPreSelected;

    public PLATestSupportHandler(ICarApplication iCarApplication, LogChannel logChannel) {
        this.application = iCarApplication;
        this.logChannel = logChannel;
    }

    protected void init() {
        this.testSupportHandler = new TestSupportHandler("ParkingPLA", true, false, this, this.application.getBundleContext(), this.logChannel);
        this.testSupportHandler.init();
    }

    protected void deinit() {
        this.testSupportHandler.deinit();
    }

    @Override
    public void debugDataVisible(boolean bl) {
        this.testSupportVisible = bl;
        this.updateDebugData();
    }

    @Override
    public void commandEntrySelected(int n) {
    }

    @Override
    public TestSupportDataReceiverEntry[] getCommandEntries() {
        return new TestSupportDataReceiverEntry[0];
    }

    private synchronized void updateDebugData() {
        if (this.testSupportVisible) {
            if (this.plaStatus != null) {
                this.testSupportData[0] = "";
                this.testSupportData[1] = "";
                this.testSupportData[2] = "--- DSI ---";
                this.testSupportData[3] = new StringBuffer().append("PLA Mode        : ").append(PLATestSupportHandler.getDebugPLAMode(this.plaStatus.getMode())).toString();
                this.testSupportData[4] = new StringBuffer().append("Instructions    : ").append(PLATestSupportHandler.getDebugPLAInstructions(this.plaStatus.getInstructions())).toString();
                this.testSupportData[5] = new StringBuffer().append("Parking Spots   : ").append(PLATestSupportHandler.getDebugPLAParkingSpots(this.plaStatus.getParkingSpot())).append(", PreSelection: ").append(PLATestSupportHandler.getDebugPLAPreSelection(this.plaStatus.getPreSelection())).toString();
                this.testSupportData[6] = new StringBuffer().append("Driving Direc.  : ").append(PLATestSupportHandler.getDebugPLADrivingDirection(this.plaStatus.getDrivingDirection())).toString();
                this.testSupportData[7] = new StringBuffer().append("PLA Message     : ").append(this.plaMessage).toString();
                this.testSupportData[8] = "";
                this.testSupportData[9] = "--- HMI ---";
                this.testSupportData[10] = new StringBuffer().append("Last DSI-Calls : selected=").append(this.lastSelected).append(", preSelected=").append(this.lastPreSelected).toString();
            } else {
                this.testSupportData[0] = "";
                this.testSupportData[1] = "";
                this.testSupportData[2] = "--- DSI ---";
                this.testSupportData[3] = "PLA Mode        : PDCPLAStatus not received yet";
                this.testSupportData[4] = "Instructions    : --";
                this.testSupportData[5] = "Parking Spots   : --";
                this.testSupportData[6] = "Driving Direc.  : --";
                this.testSupportData[7] = new StringBuffer().append("PLA Message     : ").append(this.plaMessage).toString();
                this.testSupportData[8] = "";
                this.testSupportData[9] = "--- HMI ---";
                this.testSupportData[10] = new StringBuffer().append("Last DSI-Calls  : selected=").append(this.lastSelected).append(", preSelected=").append(this.lastPreSelected).toString();
            }
            this.testSupportHandler.updateData(this.testSupportData);
        }
    }

    protected static String getDebugPLADrivingDirection(int n) {
        switch (n) {
            case 0: {
                return "no direction";
            }
            case 1: {
                return "PLA POS OK";
            }
            case 2: {
                return "IPA POS OK";
            }
            case 4: {
                return "BACKWARD";
            }
            case 3: {
                return "FORWARD";
            }
        }
        return new StringBuffer().append("Unknown: ").append(n).toString();
    }

    protected static String getDebugPLAInstructions(PDCPLAInstructions pDCPLAInstructions) {
        Buffer buffer = new Buffer(20);
        buffer.append("[").append(" SearchSideLeft: ").append(pDCPLAInstructions.isPlaSearchLeftSide()).append(", ");
        buffer.append(" SearchSideRight: ").append(pDCPLAInstructions.isPlaSearchRightSide()).append(", ");
        buffer.append(" Break: ").append(pDCPLAInstructions.isBrakeSymbol()).append(", ");
        buffer.append("SteeringIntervention: ").append(pDCPLAInstructions.isSteeringInterventionSymbol()).append(", ");
        buffer.append("DeactivationProhibited: ").append(pDCPLAInstructions.isPlaDeactivation()).append(" ]");
        return buffer.toString();
    }

    protected static String getDebugPLAPreSelection(int n) {
        switch (n) {
            case 0: {
                return "no preselection";
            }
            case 3: {
                return "FL";
            }
            case 4: {
                return "FR";
            }
            case 5: {
                return "PL";
            }
            case 6: {
                return "PR";
            }
            case 1: {
                return "BL";
            }
            case 2: {
                return "BR";
            }
        }
        return new StringBuffer().append("Unknown: ").append(n).toString();
    }

    protected static String getDebugPLAParkingSpots(PDCPLAParkingSpot pDCPLAParkingSpot) {
        Buffer buffer = new Buffer(20);
        buffer.append("[");
        if (pDCPLAParkingSpot.forwardParkboxSlotLeftFound) {
            buffer.append(" FL ");
        }
        if (pDCPLAParkingSpot.forwardParkboxSlotRightFound) {
            buffer.append(" FR ");
        }
        if (pDCPLAParkingSpot.backwardParallelToRoadSlotLeftFound) {
            buffer.append(" PL ");
        }
        if (pDCPLAParkingSpot.backwardParallelToRoadSlotRightFound) {
            buffer.append(" PR ");
        }
        if (pDCPLAParkingSpot.backwardParkboxSlotLeftFound) {
            buffer.append(" BL ");
        }
        if (pDCPLAParkingSpot.backwardParkboxSlotRightFound) {
            buffer.append(" BR ");
        }
        buffer.append("]");
        return buffer.toString();
    }

    protected static String getDebugPLAMode(int n) {
        switch (n) {
            case 0: {
                return "IDLE";
            }
            case 1: {
                return "SEARCH";
            }
            case 2: {
                return "PARK IN SELECTION";
            }
            case 3: {
                return "PARK OUT SELECTION";
            }
            case 4: {
                return "PARK IN";
            }
            case 5: {
                return "PARK OUT";
            }
            case 6: {
                return "STANDBY";
            }
            case 7: {
                return "RESUME";
            }
        }
        return new StringBuffer().append("Unknown: ").append(n).toString();
    }

    protected void updateDSIPLAStatus(PDCPLAStatus pDCPLAStatus) {
        this.plaStatus = pDCPLAStatus;
        this.updateDebugData();
    }

    protected void updateDSIPLAMessage(int n) {
        this.plaMessage = n;
        this.updateDebugData();
    }

    protected void updateHMILastSelected(int n) {
        this.lastSelected = n;
        this.updateDebugData();
    }

    protected void updateHMILastPreSelected(int n) {
        this.lastPreSelected = n;
        this.updateDebugData();
    }
}

