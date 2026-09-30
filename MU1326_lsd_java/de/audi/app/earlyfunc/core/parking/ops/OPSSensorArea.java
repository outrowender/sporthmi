/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.ops;

import de.audi.app.earlyfunc.core.parking.ops.IOPSSensorArea;
import de.audi.app.earlyfunc.core.parking.ops.OPSSector;
import de.audi.atip.hmi.model.ModelGroup;
import java.util.ArrayList;
import java.util.Iterator;

public class OPSSensorArea
implements IOPSSensorArea {
    private int leftOuterSectorIndex;
    private int leftInnerSectorIndex;
    private int rightInnerSectorIndex;
    private int rightOuterSectorIndex;
    private final ModelGroup modelGrp = new ModelGroup();
    private final ArrayList sectors = new ArrayList(4);
    protected boolean isWholeAreaHidden = true;
    protected int errorStatus = 0;

    public OPSSensorArea(OPSSector oPSSector, OPSSector oPSSector2, OPSSector oPSSector3, OPSSector oPSSector4) {
        this.sectors.add(oPSSector);
        this.leftOuterSectorIndex = this.sectors.indexOf(oPSSector);
        this.sectors.add(oPSSector2);
        this.leftInnerSectorIndex = this.sectors.indexOf(oPSSector2);
        this.sectors.add(oPSSector3);
        this.rightInnerSectorIndex = this.sectors.indexOf(oPSSector3);
        this.sectors.add(oPSSector4);
        this.rightOuterSectorIndex = this.sectors.indexOf(oPSSector4);
        this.initModelGroup();
    }

    private void initModelGroup() {
        Iterator iterator = this.sectors.iterator();
        while (iterator.hasNext()) {
            OPSSector oPSSector = (OPSSector)iterator.next();
            this.modelGrp.add(oPSSector.getDistanceModel());
            this.modelGrp.add(oPSSector.getStatusModel());
        }
    }

    public void updateDistanceValues(int[] nArray) {
        for (int i2 = this.leftOuterSectorIndex; i2 <= this.rightOuterSectorIndex; ++i2) {
            ((OPSSector)this.sectors.get(i2)).applyDistanceValue(nArray[i2]);
        }
        if (this.isWholeAreaHidden) {
            this.hideAllSectors();
        }
        this.modelGrp.flush();
    }

    public void applyStatusLvls(int[] nArray) {
        this.applyAllSectorsToStatus(nArray);
        this.updateAreaVisibility(nArray);
        this.modelGrp.flush();
    }

    private void applyAllSectorsToStatus(int[] nArray) {
        for (int i2 = this.leftOuterSectorIndex; i2 <= this.rightOuterSectorIndex; ++i2) {
            ((OPSSector)this.sectors.get(i2)).applyCurrentStatusLvl(nArray[i2]);
        }
    }

    public void disableAllSectors() {
        this.isWholeAreaHidden = true;
        this.hideAllSectors();
        this.modelGrp.flush();
    }

    public void enableAllSectors() {
        if (this.isWholeAreaHidden) {
            this.isWholeAreaHidden = false;
            this.showAllSectors();
            this.modelGrp.flush();
        }
    }

    public void hideAllSectors() {
        Iterator iterator = this.sectors.iterator();
        while (iterator.hasNext()) {
            ((OPSSector)iterator.next()).hide();
        }
    }

    private void showAllSectors() {
        Iterator iterator = this.sectors.iterator();
        while (iterator.hasNext()) {
            ((OPSSector)iterator.next()).show();
        }
    }

    protected void updateAreaVisibility(int[] nArray) {
        if (this.isWholeAreaHidden) {
            this.hideAllSectors();
        }
    }

    public int getLeftOuterSectorIndex() {
        return this.leftOuterSectorIndex;
    }

    public int getLeftInnerSectorIndex() {
        return this.leftInnerSectorIndex;
    }

    public int getRightInnerSectorIndex() {
        return this.rightInnerSectorIndex;
    }

    public int getRightOuterSectorIndex() {
        return this.rightOuterSectorIndex;
    }

    public boolean isRear() {
        return false;
    }

    public String toString() {
        return "OPSSensorArea";
    }

    public void setRear(boolean bl) {
    }

    public void setTrailerHitched(boolean bl) {
    }

    public void setWallFlags(boolean[] blArray) {
    }

    public void setLimitedFunctionality(boolean bl) {
    }
}

