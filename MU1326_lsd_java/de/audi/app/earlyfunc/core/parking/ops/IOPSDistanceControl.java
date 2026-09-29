/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.ops;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRear;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRearExt;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesRightLeft;
import org.dsi.ifc.carparkingsystem.PDCInfo;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRear;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRearExt;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelRightLeft;
import org.dsi.ifc.carparkingsystem.PDCWallDetection;

public interface IOPSDistanceControl {
    default public ChoiceModelApp getChoiceModel(int n) {
    }

    default public void init() {
    }

    default public void activateForOPS() {
    }

    default public void activateForOPS360() {
    }

    default public void updateDistancesFront(PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear) {
    }

    default public void updateDistancesRearExt(PDCDistanceValuesFrontRearExt pDCDistanceValuesFrontRearExt) {
    }

    default public void updateDistancesFrontExt(PDCDistanceValuesFrontRearExt pDCDistanceValuesFrontRearExt) {
    }

    default public void updateDistancesRear(PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear) {
    }

    default public void updateDistancesLeft(PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft) {
    }

    default public void updateDistancesRight(PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft) {
    }

    default public void applyFrontToStatusLvls(PDCStatusLevelFrontRear pDCStatusLevelFrontRear) {
    }

    default public void applyRearToStatusLvls(PDCStatusLevelFrontRear pDCStatusLevelFrontRear) {
    }

    default public void applyFrontExtToStatusLvls(PDCStatusLevelFrontRearExt pDCStatusLevelFrontRearExt) {
    }

    default public void applyRearExtToStatusLvls(PDCStatusLevelFrontRearExt pDCStatusLevelFrontRearExt) {
    }

    default public void applyLeftToStatusLvls(PDCStatusLevelRightLeft pDCStatusLevelRightLeft) {
    }

    default public void applyRightToStatusLvls(PDCStatusLevelRightLeft pDCStatusLevelRightLeft) {
    }

    default public void setTrailerHitched(boolean bl) {
    }

    default public void updateWallFlags(PDCWallDetection pDCWallDetection) {
    }

    default public void updatePDCInfo(PDCInfo pDCInfo) {
    }
}

