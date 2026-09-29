/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.evo.seat;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.core.seat.AbstractSeatPopinComponent;
import org.dsi.ifc.carseat.SeatViewOptions;

public class SeatPopinComponentEvo
extends AbstractSeatPopinComponent {
    public static final short CODING_ID_1;
    public static final short CODING_ID_2;

    public SeatPopinComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    @Override
    protected void initVisibility() {
    }

    @Override
    protected void deinitVisibility() {
    }

    @Override
    public int getID() {
        return 8;
    }

    @Override
    protected void updateMenuEntryVisibility(SeatViewOptions seatViewOptions) {
    }

    @Override
    public int getFrontLeftHMIPartialPopinID() {
        return 822812672;
    }

    @Override
    public int getFrontRightHMIPartialPopinID() {
        return 806035456;
    }

    @Override
    public int getFrontRightMemoryHMIPartialPopinID() {
        return 889921536;
    }

    @Override
    public int getFrontLeftMemoryHMIPartialPopinID() {
        return 839589888;
    }

    @Override
    public int getHMISeatPopupID() {
        return 554377216;
    }

    @Override
    public int getStandbyPopupID() {
        return 6;
    }
}

