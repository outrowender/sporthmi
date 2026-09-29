/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.ops;

import de.audi.app.earlyfunc.core.parking.ops.OPSTrackHoseUpdater;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carparkingsystem.PDCSteeringInformation;

public class OPSTrackHoseControl {
    private BaseListModelApp trackHoseModel;
    private OPSTrackHoseUpdater trackHoseUpdater;
    private int wheelbase = 0;
    private final int carModelType;
    private int steeringDirection = 0;
    private int trackDisplay = 0;
    private int radiusFront = 0;
    private int radiusRear = 0;
    private final LogChannel logChannel;

    public OPSTrackHoseControl(BaseListModelApp baseListModelApp, int n, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.trackHoseModel = baseListModelApp;
        this.carModelType = n;
    }

    public final void initializeTrackHoseList() {
        this.trackHoseModel.setLength(1);
        EvoListRow evoListRow = new EvoListRow(1L, 6);
        this.updateTrackHoseRow(evoListRow, true);
        this.trackHoseUpdater = new OPSTrackHoseUpdater(this.trackHoseModel, this.logChannel);
    }

    private final void updateTrackHoseRow(EvoListRow evoListRow, boolean bl) {
        evoListRow.setInteger(0, this.getTrackDisplay());
        evoListRow.setInteger(2, this.getWheelbase());
        evoListRow.setInteger(3, this.getRadiusFront());
        evoListRow.setInteger(4, this.getRadiusRear());
        evoListRow.setInteger(1, this.getSteeringDirection());
        evoListRow.setInteger(5, this.getCarModelType());
        if (bl) {
            this.trackHoseModel.append(evoListRow);
        } else {
            this.trackHoseUpdater.update(evoListRow);
        }
    }

    public void updateSteeringInformation(PDCSteeringInformation pDCSteeringInformation) {
        this.readPDCSteeringInformation(pDCSteeringInformation);
        this.updateTrackHoseRow(this.trackHoseModel.getRowByUniqueID(1L), false);
    }

    private void readPDCSteeringInformation(PDCSteeringInformation pDCSteeringInformation) {
        if (pDCSteeringInformation != null) {
            this.setSteeringDirection(pDCSteeringInformation.direction);
            this.setRadiusFront(pDCSteeringInformation.getRadiusFrontWheel());
            this.setRadiusRear(pDCSteeringInformation.getRadiusRearWheel());
            this.setTrackDisplay(pDCSteeringInformation.getTrackDisplay());
        }
    }

    public int getCarModelType() {
        return this.carModelType;
    }

    private int getSteeringDirection() {
        return this.steeringDirection;
    }

    private void setSteeringDirection(boolean bl) {
        this.steeringDirection = bl ? 0 : 1;
    }

    private int getTrackDisplay() {
        return this.trackDisplay;
    }

    private void setTrackDisplay(int n) {
        this.trackDisplay = n == 1 ? 1 : (n == 2 ? 2 : 0);
    }

    private int getRadiusFront() {
        return this.radiusFront;
    }

    private void setRadiusFront(int n) {
        this.radiusFront = n;
    }

    private int getRadiusRear() {
        return this.radiusRear;
    }

    private void setRadiusRear(int n) {
        this.radiusRear = n;
    }

    public void setWheelbase(int n) {
        this.wheelbase = n;
    }

    public int getWheelbase() {
        return this.wheelbase;
    }
}

