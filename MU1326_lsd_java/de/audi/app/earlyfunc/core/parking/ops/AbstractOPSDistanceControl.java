/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.ops;

import de.audi.app.earlyfunc.core.parking.ops.AbstractParkingSystemOPSComponent;
import de.audi.app.earlyfunc.core.parking.ops.IOPSDistanceControl;
import de.audi.app.earlyfunc.core.parking.ops.IOPSSensorArea;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRear;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesRightLeft;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRear;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelRightLeft;
import org.dsi.ifc.carparkingsystem.PDCWallDetection;
import org.dsi.ifc.carparkingsystem.PDCWallDetectionFrontRear;
import org.dsi.ifc.carparkingsystem.PDCWallDetectionRightLeft;

public abstract class AbstractOPSDistanceControl
implements IOPSDistanceControl {
    public static final int TRAILER_MODEL_ID;
    protected IOPSSensorArea frontArea;
    protected IOPSSensorArea rearArea;
    protected IOPSSensorArea rightArea;
    protected IOPSSensorArea leftArea;
    protected AbstractParkingSystemOPSComponent opsComponent;
    protected IHMIServiceApp hmiService;

    public AbstractOPSDistanceControl(AbstractParkingSystemOPSComponent abstractParkingSystemOPSComponent, IHMIServiceApp iHMIServiceApp) {
        this.opsComponent = abstractParkingSystemOPSComponent;
        this.hmiService = iHMIServiceApp;
    }

    @Override
    public void init() {
        this.frontArea = this.initFrontArea();
        this.rearArea = this.initRearArea();
        this.frontArea.setRear(false);
        this.rearArea.setRear(true);
        this.leftArea = this.initLeftArea();
        this.rightArea = this.initRightArea();
    }

    @Override
    public void activateForOPS() {
        this.getLogChannel().log(-2137614336, "[AbstractOPSDistanceControl#activateForOPS] called");
        if (this.rightArea != null) {
            this.rightArea.disableAllSectors();
        }
        if (this.leftArea != null) {
            this.leftArea.disableAllSectors();
        }
    }

    @Override
    public void activateForOPS360() {
        this.getLogChannel().log(-2137614336, "[AbstractOPSDistanceControl#activateForOPS360] called");
        if (this.rightArea != null) {
            this.rightArea.enableAllSectors();
        }
        if (this.leftArea != null) {
            this.leftArea.enableAllSectors();
        }
    }

    @Override
    public void updateDistancesFront(PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear) {
        this.updateDistanceFrontRear(this.frontArea, pDCDistanceValuesFrontRear);
    }

    @Override
    public void updateDistancesRear(PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear) {
        this.updateDistanceFrontRear(this.rearArea, pDCDistanceValuesFrontRear);
    }

    @Override
    public void updateDistancesLeft(PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft) {
        this.updateDistanceLeftRight(this.leftArea, pDCDistanceValuesRightLeft);
    }

    @Override
    public void updateDistancesRight(PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft) {
        this.updateDistanceLeftRight(this.rightArea, pDCDistanceValuesRightLeft);
    }

    @Override
    public ChoiceModelApp getChoiceModel(int n) {
        return this.hmiService.getChoiceModel(n);
    }

    @Override
    public void applyFrontToStatusLvls(PDCStatusLevelFrontRear pDCStatusLevelFrontRear) {
        this.applyStatusLvlsFrontRear(this.frontArea, pDCStatusLevelFrontRear);
    }

    @Override
    public void applyRearToStatusLvls(PDCStatusLevelFrontRear pDCStatusLevelFrontRear) {
        this.applyStatusLvlsFrontRear(this.rearArea, pDCStatusLevelFrontRear);
    }

    @Override
    public void applyLeftToStatusLvls(PDCStatusLevelRightLeft pDCStatusLevelRightLeft) {
        this.applyStatusLvlsLeftRight(this.leftArea, pDCStatusLevelRightLeft);
    }

    @Override
    public void applyRightToStatusLvls(PDCStatusLevelRightLeft pDCStatusLevelRightLeft) {
        this.applyStatusLvlsLeftRight(this.rightArea, pDCStatusLevelRightLeft);
    }

    private void applyStatusLvlsFrontRear(IOPSSensorArea iOPSSensorArea, PDCStatusLevelFrontRear pDCStatusLevelFrontRear) {
        if (iOPSSensorArea != null) {
            iOPSSensorArea.applyStatusLvls(this.createStatusLvlRearFrontArray(iOPSSensorArea, pDCStatusLevelFrontRear));
        }
    }

    private int[] createStatusLvlRearFrontArray(IOPSSensorArea iOPSSensorArea, PDCStatusLevelFrontRear pDCStatusLevelFrontRear) {
        int[] nArray = new int[4];
        nArray[iOPSSensorArea.getLeftOuterSectorIndex()] = pDCStatusLevelFrontRear.getLeft();
        nArray[iOPSSensorArea.getLeftInnerSectorIndex()] = pDCStatusLevelFrontRear.getLeftMiddle();
        nArray[iOPSSensorArea.getRightInnerSectorIndex()] = pDCStatusLevelFrontRear.getRightMiddle();
        nArray[iOPSSensorArea.getRightOuterSectorIndex()] = pDCStatusLevelFrontRear.getRight();
        return nArray;
    }

    private void applyStatusLvlsLeftRight(IOPSSensorArea iOPSSensorArea, PDCStatusLevelRightLeft pDCStatusLevelRightLeft) {
        if (iOPSSensorArea != null) {
            this.getLogChannel().log(1078071040, "[AbstractOPSDistanceControl#applyStatusLvlsLeftRight] area='%1' , statusLevel='%2' ", (Object)iOPSSensorArea, (Object)pDCStatusLevelRightLeft);
            iOPSSensorArea.applyStatusLvls(this.createStatusLvlLeftRightArray(iOPSSensorArea, pDCStatusLevelRightLeft));
        }
    }

    private int[] createStatusLvlLeftRightArray(IOPSSensorArea iOPSSensorArea, PDCStatusLevelRightLeft pDCStatusLevelRightLeft) {
        int[] nArray = new int[4];
        nArray[iOPSSensorArea.getLeftOuterSectorIndex()] = pDCStatusLevelRightLeft.getFront();
        nArray[iOPSSensorArea.getLeftInnerSectorIndex()] = pDCStatusLevelRightLeft.getFrontMiddle();
        nArray[iOPSSensorArea.getRightInnerSectorIndex()] = pDCStatusLevelRightLeft.getRearMiddle();
        nArray[iOPSSensorArea.getRightOuterSectorIndex()] = pDCStatusLevelRightLeft.getRear();
        return nArray;
    }

    private void updateDistanceFrontRear(IOPSSensorArea iOPSSensorArea, PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear) {
        if (iOPSSensorArea != null) {
            this.getLogChannel().log(1078071040, "[AbstractOPSDistanceControl#updateDistanceFrontRear] area='%1' , distValues='%2' ", (Object)iOPSSensorArea, (Object)pDCDistanceValuesFrontRear);
            iOPSSensorArea.updateDistanceValues(this.createDistanceValuesFrontRearArray(iOPSSensorArea, pDCDistanceValuesFrontRear));
        }
    }

    private int[] createDistanceValuesFrontRearArray(IOPSSensorArea iOPSSensorArea, PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear) {
        int[] nArray = new int[4];
        nArray[iOPSSensorArea.getLeftOuterSectorIndex()] = pDCDistanceValuesFrontRear.getLeft();
        nArray[iOPSSensorArea.getLeftInnerSectorIndex()] = pDCDistanceValuesFrontRear.getLeftMiddle();
        nArray[iOPSSensorArea.getRightInnerSectorIndex()] = pDCDistanceValuesFrontRear.getRightMiddle();
        nArray[iOPSSensorArea.getRightOuterSectorIndex()] = pDCDistanceValuesFrontRear.getRight();
        return nArray;
    }

    private void updateDistanceLeftRight(IOPSSensorArea iOPSSensorArea, PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft) {
        if (iOPSSensorArea != null) {
            this.getLogChannel().log(1078071040, "[AbstractOPSDistanceControl#updateDistanceLeftRight] area='%1' , distValues='%2' ", (Object)iOPSSensorArea, (Object)pDCDistanceValuesRightLeft);
            iOPSSensorArea.updateDistanceValues(this.createDistanceValuesLeftRightArray(iOPSSensorArea, pDCDistanceValuesRightLeft));
        }
    }

    private int[] createDistanceValuesLeftRightArray(IOPSSensorArea iOPSSensorArea, PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft) {
        int[] nArray = new int[4];
        nArray[iOPSSensorArea.getLeftOuterSectorIndex()] = pDCDistanceValuesRightLeft.getFront();
        nArray[iOPSSensorArea.getLeftInnerSectorIndex()] = pDCDistanceValuesRightLeft.getFrontMiddle();
        nArray[iOPSSensorArea.getRightInnerSectorIndex()] = pDCDistanceValuesRightLeft.getRearMiddle();
        nArray[iOPSSensorArea.getRightOuterSectorIndex()] = pDCDistanceValuesRightLeft.getRear();
        return nArray;
    }

    @Override
    public void updateWallFlags(PDCWallDetection pDCWallDetection) {
        this.applyWallFlags(this.frontArea, pDCWallDetection.getSectorsFront());
        this.applyWallFlags(this.rearArea, pDCWallDetection.getSectorsRear());
        this.applyWallFlags(this.leftArea, pDCWallDetection.getSectorsLeft());
        this.applyWallFlags(this.rightArea, pDCWallDetection.getSectorsRight());
    }

    private void applyWallFlags(IOPSSensorArea iOPSSensorArea, PDCWallDetectionFrontRear pDCWallDetectionFrontRear) {
        if (iOPSSensorArea != null && pDCWallDetectionFrontRear != null) {
            boolean[] blArray = new boolean[]{pDCWallDetectionFrontRear.isSector1(), pDCWallDetectionFrontRear.isSector2(), pDCWallDetectionFrontRear.isSector3(), pDCWallDetectionFrontRear.isSector4(), pDCWallDetectionFrontRear.isSector5(), pDCWallDetectionFrontRear.isSector6(), pDCWallDetectionFrontRear.isSector7(), pDCWallDetectionFrontRear.isSector8()};
            iOPSSensorArea.setWallFlags(blArray);
        }
    }

    private void applyWallFlags(IOPSSensorArea iOPSSensorArea, PDCWallDetectionRightLeft pDCWallDetectionRightLeft) {
        if (iOPSSensorArea != null && pDCWallDetectionRightLeft != null) {
            this.getLogChannel().log(1078071040, "[AbstractOPSDistanceControl#applyWallFlags] area='%1' , wallDetection='%2' ", (Object)iOPSSensorArea, (Object)pDCWallDetectionRightLeft);
            boolean[] blArray = new boolean[]{pDCWallDetectionRightLeft.isSector1(), pDCWallDetectionRightLeft.isSector2(), pDCWallDetectionRightLeft.isSector3(), pDCWallDetectionRightLeft.isSector4()};
            iOPSSensorArea.setWallFlags(blArray);
        }
    }

    @Override
    public void setTrailerHitched(boolean bl) {
        this.rearArea.setTrailerHitched(bl);
    }

    public IOPSSensorArea getFrontArea() {
        return this.frontArea;
    }

    public IOPSSensorArea getRearArea() {
        return this.rearArea;
    }

    public IOPSSensorArea getRightArea() {
        return this.rightArea;
    }

    public IOPSSensorArea getLeftArea() {
        return this.leftArea;
    }

    public LogChannel getLogChannel() {
        return this.opsComponent.getLogChannel();
    }

    protected abstract IOPSSensorArea initFrontArea() {
    }

    protected abstract IOPSSensorArea initRearArea() {
    }

    protected abstract IOPSSensorArea initLeftArea() {
    }

    protected abstract IOPSSensorArea initRightArea() {
    }
}

