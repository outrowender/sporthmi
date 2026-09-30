/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.evo.seat;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.core.seat.AbstractSeatPopinComponent;
import org.dsi.ifc.carseat.SeatViewOptions;

public class SeatPopinComponentEvo
extends AbstractSeatPopinComponent {
    public static final short CODING_ID_1 = 14;
    public static final short CODING_ID_2 = 48;

    public SeatPopinComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void initVisibility() {
    }

    protected void deinitVisibility() {
    }

    public int getID() {
        return 8;
    }

    protected void updateMenuEntryVisibility(SeatViewOptions seatViewOptions) {
    }

    public int getFrontLeftHMIPartialPopinID() {
        return 2100017;
    }

    public int getFrontRightHMIPartialPopinID() {
        return 2100016;
    }

    public int getFrontRightMemoryHMIPartialPopinID() {
        return 2100021;
    }

    public int getFrontLeftMemoryHMIPartialPopinID() {
        return 2100018;
    }

    public int getHMISeatPopupID() {
        return 2100001;
    }

    public int getStandbyPopupID() {
        return 6;
    }
}

