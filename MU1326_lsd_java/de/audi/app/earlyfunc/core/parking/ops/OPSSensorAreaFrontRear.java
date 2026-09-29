/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.ops;

import de.audi.app.earlyfunc.core.parking.ops.OPSSector;
import de.audi.app.earlyfunc.core.parking.ops.OPSSensorArea;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public class OPSSensorAreaFrontRear
extends OPSSensorArea {
    private static final int TRAILER_NONE;
    private static final int TRAILER_HITCHED;
    private boolean trailerHitched = false;
    private boolean isRear = false;
    private ChoiceModelApp trailerModel;
    private final ChoiceModelApp errorIconStatusModel;
    public static final int NO_ERROR_ICON;
    public static final int TEMP_NOT_AVAILABLE_ICON;
    public static final int ERROR_ICON;

    public boolean isTrailerHitched() {
        return this.trailerHitched;
    }

    public OPSSensorAreaFrontRear(OPSSector oPSSector, OPSSector oPSSector2, OPSSector oPSSector3, OPSSector oPSSector4, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2) {
        super(oPSSector, oPSSector2, oPSSector3, oPSSector4);
        this.trailerModel = choiceModelApp;
        this.errorIconStatusModel = choiceModelApp2;
    }

    @Override
    protected void updateAreaVisibility(int[] nArray) {
        this.errorStatus = 0;
        for (int i2 = this.getLeftOuterSectorIndex(); i2 <= this.getRightOuterSectorIndex(); ++i2) {
            if (nArray[i2] != 15 && nArray[i2] != 13) continue;
            this.errorStatus = nArray[i2];
            break;
        }
        if (this.isRear && this.trailerHitched) {
            this.isWholeAreaHidden = true;
            this.setErrorIconOverlay(0);
        } else {
            this.isWholeAreaHidden = this.errorStatus > 0;
            this.setErrorIconOverlay(this.errorStatus);
        }
        if (this.isWholeAreaHidden) {
            this.hideAllSectors();
        }
    }

    private void setErrorIconOverlay(int n) {
        int n2 = n == 15 ? 2 : (n == 13 ? 1 : 0);
        if (this.errorIconStatusModel.getValue() != n2) {
            this.errorIconStatusModel.setValue(n2);
        }
    }

    @Override
    public void setTrailerHitched(boolean bl) {
        if (this.isRear) {
            this.handleTrailerHitching(bl);
        }
    }

    private void handleTrailerHitching(boolean bl) {
        if (this.trailerHitched != bl) {
            if (bl) {
                this.trailerModel.setValue(1);
                this.disableAllSectors();
                this.setErrorIconOverlay(0);
            } else {
                this.trailerModel.setValue(0);
                if (this.errorStatus == 0) {
                    this.enableAllSectors();
                } else {
                    this.setErrorIconOverlay(this.errorStatus);
                }
            }
            this.trailerHitched = bl;
        }
    }

    @Override
    public boolean isRear() {
        return this.isRear;
    }

    @Override
    public void setRear(boolean bl) {
        this.isRear = bl;
    }
}

