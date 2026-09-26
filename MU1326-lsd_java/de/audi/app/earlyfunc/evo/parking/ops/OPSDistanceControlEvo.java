/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.evo.parking.ops;

import de.audi.app.earlyfunc.core.parking.ops.AbstractOPSDistanceControl;
import de.audi.app.earlyfunc.core.parking.ops.AbstractParkingSystemOPSComponent;
import de.audi.app.earlyfunc.core.parking.ops.IOPSSensorArea;
import de.audi.app.earlyfunc.core.parking.ops.OPSSectorFactory;
import de.audi.app.earlyfunc.core.parking.ops.OPSSensorArea;
import de.audi.app.earlyfunc.core.parking.ops.OPSSensorAreaFrontRear;
import de.audi.atip.hmi.IHMIServiceApp;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRearExt;
import org.dsi.ifc.carparkingsystem.PDCInfo;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRearExt;

public class OPSDistanceControlEvo
extends AbstractOPSDistanceControl {
    public OPSDistanceControlEvo(AbstractParkingSystemOPSComponent abstractParkingSystemOPSComponent, IHMIServiceApp iHMIServiceApp) {
        super(abstractParkingSystemOPSComponent, iHMIServiceApp);
    }

    @Override
    protected IOPSSensorArea initFrontArea() {
        return this.getSensorAreaFrontRear(OPSSectorFactory.FRONTAREA_WITH_CONSTANT_DIST_RANGE);
    }

    @Override
    protected IOPSSensorArea initRearArea() {
        return this.getSensorAreaFrontRear(OPSSectorFactory.REARAREA_WITH_CONSTANT_DIST_RANGE);
    }

    @Override
    protected IOPSSensorArea initLeftArea() {
        return this.getSensorArea(OPSSectorFactory.LEFTAREA_WITH_CONSTANT_DIST_RANGE);
    }

    @Override
    protected IOPSSensorArea initRightArea() {
        return this.getSensorArea(OPSSectorFactory.RIGHTAREA_WITH_CONSTANT_DIST_RANGE);
    }

    private OPSSensorArea getSensorArea(OPSSectorFactory oPSSectorFactory) {
        OPSSensorArea oPSSensorArea = new OPSSensorArea(oPSSectorFactory.createLeftOuterSector(this), oPSSectorFactory.createLeftInnerSector(this), oPSSectorFactory.createRightInnerSector(this), oPSSectorFactory.createRightOuterSector(this));
        oPSSensorArea.enableAllSectors();
        return oPSSensorArea;
    }

    private OPSSensorAreaFrontRear getSensorAreaFrontRear(OPSSectorFactory oPSSectorFactory) {
        OPSSensorAreaFrontRear oPSSensorAreaFrontRear = new OPSSensorAreaFrontRear(oPSSectorFactory.createLeftOuterSector(this), oPSSectorFactory.createLeftInnerSector(this), oPSSectorFactory.createRightInnerSector(this), oPSSectorFactory.createRightOuterSector(this), this.hmiService.getChoiceModel(-1089789952), this.hmiService.getChoiceModel(oPSSectorFactory.getErrorIconStatusModelID()));
        oPSSensorAreaFrontRear.enableAllSectors();
        return oPSSensorAreaFrontRear;
    }

    @Override
    public void updateDistancesRearExt(PDCDistanceValuesFrontRearExt pDCDistanceValuesFrontRearExt) {
    }

    @Override
    public void updateDistancesFrontExt(PDCDistanceValuesFrontRearExt pDCDistanceValuesFrontRearExt) {
    }

    @Override
    public void applyFrontExtToStatusLvls(PDCStatusLevelFrontRearExt pDCStatusLevelFrontRearExt) {
    }

    @Override
    public void applyRearExtToStatusLvls(PDCStatusLevelFrontRearExt pDCStatusLevelFrontRearExt) {
    }

    @Override
    public void updatePDCInfo(PDCInfo pDCInfo) {
    }
}

