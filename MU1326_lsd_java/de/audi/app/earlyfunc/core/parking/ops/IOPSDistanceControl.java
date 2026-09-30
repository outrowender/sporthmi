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
    public ChoiceModelApp getChoiceModel(int var1);

    public void init();

    public void activateForOPS();

    public void activateForOPS360();

    public void updateDistancesFront(PDCDistanceValuesFrontRear var1);

    public void updateDistancesRearExt(PDCDistanceValuesFrontRearExt var1);

    public void updateDistancesFrontExt(PDCDistanceValuesFrontRearExt var1);

    public void updateDistancesRear(PDCDistanceValuesFrontRear var1);

    public void updateDistancesLeft(PDCDistanceValuesRightLeft var1);

    public void updateDistancesRight(PDCDistanceValuesRightLeft var1);

    public void applyFrontToStatusLvls(PDCStatusLevelFrontRear var1);

    public void applyRearToStatusLvls(PDCStatusLevelFrontRear var1);

    public void applyFrontExtToStatusLvls(PDCStatusLevelFrontRearExt var1);

    public void applyRearExtToStatusLvls(PDCStatusLevelFrontRearExt var1);

    public void applyLeftToStatusLvls(PDCStatusLevelRightLeft var1);

    public void applyRightToStatusLvls(PDCStatusLevelRightLeft var1);

    public void setTrailerHitched(boolean var1);

    public void updateWallFlags(PDCWallDetection var1);

    public void updatePDCInfo(PDCInfo var1);
}

