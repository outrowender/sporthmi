/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import de.audi.app.earlyfunc.core.parking.pla.IParkingSpotSelection;
import de.audi.app.earlyfunc.core.parking.pla.PLAInterappCallbackHandler$ParkingSpotConstant;
import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAStatusCallbackListener;
import de.audi.atip.log.LogChannel;

public class PLAInterappCallbackHandler
implements IPLAStatusCallbackListener {
    private final LogChannel logChannel;
    private final IParkingSpotSelection parkingSpotSelection;
    private final PLAInterappCallbackHandler$ParkingSpotConstant[] parkingSpotConstants = new PLAInterappCallbackHandler$ParkingSpotConstant[]{new PLAInterappCallbackHandler$ParkingSpotConstant(this, 1, 4, 3, 2, 8, null), new PLAInterappCallbackHandler$ParkingSpotConstant(this, 2, 1, 4, 3, 9, null), new PLAInterappCallbackHandler$ParkingSpotConstant(this, 1, 3, 5, 4, 10, null), new PLAInterappCallbackHandler$ParkingSpotConstant(this, 2, 0, 6, 5, 11, null), new PLAInterappCallbackHandler$ParkingSpotConstant(this, 1, 5, 1, 0, 6, null), new PLAInterappCallbackHandler$ParkingSpotConstant(this, 2, 2, 2, 1, 7, null)};

    public PLAInterappCallbackHandler(LogChannel logChannel, IParkingSpotSelection iParkingSpotSelection) {
        this.logChannel = logChannel;
        this.parkingSpotSelection = iParkingSpotSelection;
    }

    private void fireSelectionUpdate(int n, int n2, int n3, boolean bl) {
        int n4;
        int n5 = n4 = bl ? this.getDSIPreSelectionForHmiValues(n2, n3) : this.getDSISelectionForHmiValues(n, n2, n3);
        if (-1 != n4) {
            if (this.logChannel.isInfo()) {
                this.logChannel.log(1078071040, "[PLAInterappCallbackHandler#fireSelectionUpdate] -> DSI: value='%1'", (long)n4);
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
            PLAInterappCallbackHandler$ParkingSpotConstant pLAInterappCallbackHandler$ParkingSpotConstant = this.parkingSpotConstants[i2];
            if (PLAInterappCallbackHandler$ParkingSpotConstant.access$100(pLAInterappCallbackHandler$ParkingSpotConstant) != n || PLAInterappCallbackHandler$ParkingSpotConstant.access$200(pLAInterappCallbackHandler$ParkingSpotConstant) != n2) continue;
            return PLAInterappCallbackHandler$ParkingSpotConstant.access$300(pLAInterappCallbackHandler$ParkingSpotConstant);
        }
        return -1;
    }

    private int getDSISelectionForHmiValues(int n, int n2, int n3) {
        for (int i2 = 0; i2 < this.parkingSpotConstants.length; ++i2) {
            PLAInterappCallbackHandler$ParkingSpotConstant pLAInterappCallbackHandler$ParkingSpotConstant = this.parkingSpotConstants[i2];
            if (PLAInterappCallbackHandler$ParkingSpotConstant.access$100(pLAInterappCallbackHandler$ParkingSpotConstant) != n2 || PLAInterappCallbackHandler$ParkingSpotConstant.access$200(pLAInterappCallbackHandler$ParkingSpotConstant) != n3) continue;
            switch (n) {
                case 2: {
                    return PLAInterappCallbackHandler$ParkingSpotConstant.access$400(pLAInterappCallbackHandler$ParkingSpotConstant);
                }
                case 3: {
                    return PLAInterappCallbackHandler$ParkingSpotConstant.access$500(pLAInterappCallbackHandler$ParkingSpotConstant);
                }
            }
        }
        return -1;
    }

    @Override
    public void updateFocusedSpotInSelectionMode(int n, int n2) {
        this.fireSelectionUpdate(2, n, n2, true);
    }

    @Override
    public void updateSelectedSpotInSelectionMode(int n, int n2) {
        this.fireSelectionUpdate(2, n, n2, false);
    }

    @Override
    public void updateFocusedSpotOutSelectionMode(int n, int n2) {
        this.fireSelectionUpdate(3, n, n2, true);
    }

    @Override
    public void updateSelectedSpotOutSelectionMode(int n, int n2) {
        this.fireSelectionUpdate(3, n, n2, false);
    }
}

