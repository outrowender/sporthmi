/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import de.audi.app.earlyfunc.core.parking.pla.IParkingSpotSelection;
import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAStatusCallbackListener;
import de.audi.atip.log.LogChannel;

public class PLAInterappCallbackHandler
implements IPLAStatusCallbackListener {
    private final LogChannel logChannel;
    private final IParkingSpotSelection parkingSpotSelection;
    private final ParkingSpotConstant[] parkingSpotConstants = new ParkingSpotConstant[]{new ParkingSpotConstant(1, 4, 3, 2, 8), new ParkingSpotConstant(2, 1, 4, 3, 9), new ParkingSpotConstant(1, 3, 5, 4, 10), new ParkingSpotConstant(2, 0, 6, 5, 11), new ParkingSpotConstant(1, 5, 1, 0, 6), new ParkingSpotConstant(2, 2, 2, 1, 7)};

    public PLAInterappCallbackHandler(LogChannel logChannel, IParkingSpotSelection iParkingSpotSelection) {
        this.logChannel = logChannel;
        this.parkingSpotSelection = iParkingSpotSelection;
    }

    private void fireSelectionUpdate(int n, int n2, int n3, boolean bl) {
        int n4;
        int n5 = n4 = bl ? this.getDSIPreSelectionForHmiValues(n2, n3) : this.getDSISelectionForHmiValues(n, n2, n3);
        if (-1 != n4) {
            if (this.logChannel.isInfo()) {
                this.logChannel.log(1000000, "[PLAInterappCallbackHandler#fireSelectionUpdate] -> DSI: value='%1'", (long)n4);
            }
            if (bl) {
                this.parkingSpotSelection.spotPreSelected(n4);
            } else {
                this.parkingSpotSelection.spotSelected(n4);
            }
        } else {
            this.logChannel.log(10000, "[PLAInterappCallbackHandler#fireSelectionUpdate] Cannot find DSI value for HMI parameters: mode='%1' activeSide='%2', parkingSpot='%3'", (long)n, (long)n2, (long)n3);
        }
    }

    private int getDSIPreSelectionForHmiValues(int n, int n2) {
        for (int i2 = 0; i2 < this.parkingSpotConstants.length; ++i2) {
            ParkingSpotConstant parkingSpotConstant = this.parkingSpotConstants[i2];
            if (parkingSpotConstant.getHmiActiveSideValue() != n || parkingSpotConstant.getHmiParkingSpotValue() != n2) continue;
            return parkingSpotConstant.getPreSelectionDSIValue();
        }
        return -1;
    }

    private int getDSISelectionForHmiValues(int n, int n2, int n3) {
        for (int i2 = 0; i2 < this.parkingSpotConstants.length; ++i2) {
            ParkingSpotConstant parkingSpotConstant = this.parkingSpotConstants[i2];
            if (parkingSpotConstant.getHmiActiveSideValue() != n2 || parkingSpotConstant.getHmiParkingSpotValue() != n3) continue;
            switch (n) {
                case 2: {
                    return parkingSpotConstant.getParkInDSIValue();
                }
                case 3: {
                    return parkingSpotConstant.getParkOutDSIValue();
                }
            }
        }
        return -1;
    }

    public void updateFocusedSpotInSelectionMode(int n, int n2) {
        this.fireSelectionUpdate(2, n, n2, true);
    }

    public void updateSelectedSpotInSelectionMode(int n, int n2) {
        this.fireSelectionUpdate(2, n, n2, false);
    }

    public void updateFocusedSpotOutSelectionMode(int n, int n2) {
        this.fireSelectionUpdate(3, n, n2, true);
    }

    public void updateSelectedSpotOutSelectionMode(int n, int n2) {
        this.fireSelectionUpdate(3, n, n2, false);
    }

    private class ParkingSpotConstant {
        private final int hmiActiveSideValue;
        private final int hmiParkingSpotValue;
        private final int preSelectionDSIValue;
        private final int parkInDSIValue;
        private final int parkOutDSIValue;

        private ParkingSpotConstant(int n, int n2, int n3, int n4, int n5) {
            this.hmiActiveSideValue = n;
            this.hmiParkingSpotValue = n2;
            this.preSelectionDSIValue = n3;
            this.parkInDSIValue = n4;
            this.parkOutDSIValue = n5;
        }

        private int getHmiActiveSideValue() {
            return this.hmiActiveSideValue;
        }

        private int getHmiParkingSpotValue() {
            return this.hmiParkingSpotValue;
        }

        private int getPreSelectionDSIValue() {
            return this.preSelectionDSIValue;
        }

        private int getParkInDSIValue() {
            return this.parkInDSIValue;
        }

        private int getParkOutDSIValue() {
            return this.parkOutDSIValue;
        }
    }
}

