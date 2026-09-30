/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAStatus;
import org.dsi.ifc.carparkingsystem.PDCPLAStatus;

public class PLAInterappStatus
implements IPLAStatus {
    private static final int PLA_DEFAULT_ACTIVESIDE = 2;
    private static final int[] DSI_TO_INTERAPP_DRIVINGDIRECTION_CONSTANT = new int[]{0, 1, -1, 2, 3};
    private static final int[] DSI_TO_INTERAPP_PRESELECTION_CONSTANT = new int[]{-1, 5, 2, 4, 1, 3, 0};
    protected int activeSide;
    protected boolean systemActiveOPS;
    protected int drivingDirection;
    protected boolean brakeSymbol;
    protected boolean posOKSymbol;
    protected int steeringInterventionSymbol;
    protected boolean interactionProhibited;
    protected boolean backwardParallelToRoadSlotFound;
    protected boolean forwardParkboxSlotFound;
    protected boolean backwardParkboxSlotFound;
    protected int preSelection;

    public PLAInterappStatus() {
        this(0, false, 0, false, false, 0, false, false, false, false, 0);
    }

    public PLAInterappStatus(int n, boolean bl, int n2, boolean bl2, boolean bl3, int n3, boolean bl4) {
        this(n, bl, n2, bl2, bl3, n3, bl4, false, false, false, 0);
    }

    public PLAInterappStatus(int n, boolean bl, int n2, boolean bl2, boolean bl3, int n3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, int n4) {
        this.activeSide = n;
        this.systemActiveOPS = bl;
        this.drivingDirection = n2;
        this.brakeSymbol = bl2;
        this.posOKSymbol = bl3;
        this.steeringInterventionSymbol = n3;
        this.interactionProhibited = bl4;
        this.backwardParallelToRoadSlotFound = bl5;
        this.forwardParkboxSlotFound = bl6;
        this.backwardParkboxSlotFound = bl7;
        this.preSelection = n4;
    }

    public PLAInterappStatus(PDCPLAStatus pDCPLAStatus, boolean bl) {
        if (pDCPLAStatus != null) {
            int n = 2;
            n = pDCPLAStatus.instructions.isPlaSearchLeftSide() && !pDCPLAStatus.instructions.isPlaSearchRightSide() ? 1 : (!pDCPLAStatus.instructions.isPlaSearchLeftSide() && pDCPLAStatus.instructions.isPlaSearchRightSide() ? 2 : 2);
            this.activeSide = n;
            this.systemActiveOPS = bl;
            int n2 = DSI_TO_INTERAPP_DRIVINGDIRECTION_CONSTANT[pDCPLAStatus.drivingDirection];
            this.brakeSymbol = pDCPLAStatus.instructions.isBrakeSymbol();
            this.drivingDirection = this.brakeSymbol ? (1 == n2 ? 0 : n2) : (-1 == n2 ? 0 : n2);
            boolean bl2 = this.posOKSymbol = 2 == pDCPLAStatus.getMode() && 1 == n2;
            this.steeringInterventionSymbol = pDCPLAStatus.instructions.isSteeringInterventionSymbol() ? (4 == pDCPLAStatus.getMode() || 5 == pDCPLAStatus.getMode() ? 2 : 1) : 0;
            this.interactionProhibited = pDCPLAStatus.instructions.isPlaDeactivation();
            this.backwardParallelToRoadSlotFound = 1 == this.activeSide && pDCPLAStatus.parkingSpot.isBackwardParallelToRoadSlotLeftFound() || 2 == this.activeSide && pDCPLAStatus.parkingSpot.isBackwardParallelToRoadSlotRightFound();
            this.forwardParkboxSlotFound = 1 == this.activeSide && pDCPLAStatus.parkingSpot.isForwardParkboxSlotLeftFound() || 2 == this.activeSide && pDCPLAStatus.parkingSpot.isForwardParkboxSlotRightFound();
            this.backwardParkboxSlotFound = 1 == this.activeSide && pDCPLAStatus.parkingSpot.isBackwardParkboxSlotLeftFound() || 2 == this.activeSide && pDCPLAStatus.parkingSpot.isBackwardParkboxSlotRightFound();
            this.preSelection = DSI_TO_INTERAPP_PRESELECTION_CONSTANT[pDCPLAStatus.preSelection];
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2250);
        stringBuffer.append("PLAInterappStatus(activeSide=");
        stringBuffer.append(this.activeSide);
        stringBuffer.append(", systemActiveOPS=");
        stringBuffer.append(this.systemActiveOPS);
        stringBuffer.append(", backwardParkboxSlotFound=");
        stringBuffer.append(this.backwardParkboxSlotFound);
        stringBuffer.append(", forwardParkboxSlotFound=");
        stringBuffer.append(this.forwardParkboxSlotFound);
        stringBuffer.append(", backwardParallelToRoadSlotFound=");
        stringBuffer.append(this.backwardParallelToRoadSlotFound);
        stringBuffer.append(", preSelection=");
        stringBuffer.append(this.preSelection);
        stringBuffer.append(", drivingDirection=");
        stringBuffer.append(this.drivingDirection);
        stringBuffer.append(", brakeSymbol=");
        stringBuffer.append(this.brakeSymbol);
        stringBuffer.append(", posOKSymbol=");
        stringBuffer.append(this.posOKSymbol);
        stringBuffer.append(", steeringInterventionSymbol=");
        stringBuffer.append(this.steeringInterventionSymbol);
        stringBuffer.append(", interactionProhibited=");
        stringBuffer.append(this.interactionProhibited);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.activeSide;
        n = 31 * n + (this.brakeSymbol ? 1231 : 1237);
        n = 31 * n + (this.posOKSymbol ? 1231 : 1237);
        n = 31 * n + this.drivingDirection;
        n = 31 * n + (this.interactionProhibited ? 1231 : 1237);
        n = 31 * n + this.steeringInterventionSymbol;
        n = 31 * n + (this.systemActiveOPS ? 1231 : 1237);
        n = 31 * n + (this.backwardParallelToRoadSlotFound ? 1231 : 1237);
        n = 31 * n + (this.backwardParkboxSlotFound ? 1231 : 1237);
        n = 31 * n + (this.forwardParkboxSlotFound ? 1231 : 1237);
        n = 31 * n + this.preSelection;
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        PLAInterappStatus pLAInterappStatus = (PLAInterappStatus)object;
        return this.activeSide == pLAInterappStatus.activeSide && this.brakeSymbol == pLAInterappStatus.brakeSymbol && this.posOKSymbol == pLAInterappStatus.posOKSymbol && this.drivingDirection == pLAInterappStatus.drivingDirection && this.interactionProhibited == pLAInterappStatus.interactionProhibited && this.steeringInterventionSymbol == pLAInterappStatus.steeringInterventionSymbol && this.systemActiveOPS == pLAInterappStatus.systemActiveOPS && this.backwardParallelToRoadSlotFound == pLAInterappStatus.backwardParallelToRoadSlotFound && this.backwardParkboxSlotFound == pLAInterappStatus.backwardParkboxSlotFound && this.forwardParkboxSlotFound == pLAInterappStatus.forwardParkboxSlotFound && this.preSelection == pLAInterappStatus.preSelection;
    }

    public int getActiveSide() {
        return this.activeSide;
    }

    public boolean isSystemActiveOPS() {
        return this.systemActiveOPS;
    }

    public int getDrivingDirection() {
        return this.drivingDirection;
    }

    public boolean isBrakeSymbol() {
        return this.brakeSymbol;
    }

    public boolean isPosOKSymbol() {
        return this.posOKSymbol;
    }

    public int getSteeringInterventionSymbol() {
        return this.steeringInterventionSymbol;
    }

    public boolean isInteractionProhibited() {
        return this.interactionProhibited;
    }

    public boolean isBackwardParallelToRoadSlotFound() {
        return this.backwardParallelToRoadSlotFound;
    }

    public boolean isForwardParkboxSlotFound() {
        return this.forwardParkboxSlotFound;
    }

    public boolean isBackwardParkboxSlotFound() {
        return this.backwardParkboxSlotFound;
    }

    public int getPreSelection() {
        return this.preSelection;
    }
}

