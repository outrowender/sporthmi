/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.careco.BCmEConsumerList;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA0;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA1;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA0;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA1;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA2;
import org.dsi.ifc.careco.BCmECurrentRange;
import org.dsi.ifc.careco.BCmEEnergyFlowComfort;
import org.dsi.ifc.careco.BCmEListUpdateInfo;
import org.dsi.ifc.careco.BCmERangeGainTotal;
import org.dsi.ifc.careco.BCmEViewOptions;
import org.dsi.ifc.careco.EAViewOptions;
import org.dsi.ifc.careco.RangeDataResidualEnergy;
import org.dsi.ifc.careco.RangeDataViewOptions;
import org.dsi.ifc.careco.StartStopListUpdateInfo;
import org.dsi.ifc.careco.StartStopProhibitList;
import org.dsi.ifc.careco.StartStopRestartList;
import org.dsi.ifc.careco.StartStopRestartProhibitList;
import org.dsi.ifc.careco.StartStopViewOptions;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCCurrentRange;

public interface DSICarEcoListener
extends DSIListener {
    public void updateBCmEViewOptions(BCmEViewOptions var1, int var2);

    public void updateBCmEListUpdateInfo(BCmEListUpdateInfo var1, int var2);

    public void updateBCmEConsumption(int var1, int var2, int var3, int var4);

    public void updateBCmELiveTip(int var1, boolean var2, int var3);

    public void responseBCmEConsumerList(BCmEListUpdateInfo var1, BCmEConsumerList[] var2);

    public void acknowledgeBcmeSetFactoryDefault(boolean var1);

    public void updateStartStopProhibitReasonListUpdateInfo(StartStopListUpdateInfo var1, int var2);

    public void responseStartStopProhibitReasonList(StartStopListUpdateInfo var1, StartStopProhibitList[] var2);

    public void updateStartStopRestartReasonListUpdateInfo(StartStopListUpdateInfo var1, int var2);

    public void responseStartStopRestartReasonList(StartStopListUpdateInfo var1, StartStopRestartList[] var2);

    public void updateStartStopRestartProhibitReasonListUpdateInfo(StartStopListUpdateInfo var1, int var2);

    public void responseStartStopRestartProhibitReasonList(StartStopListUpdateInfo var1, StartStopRestartProhibitList[] var2);

    public void updateStartStopState(int var1, int var2);

    public void updateStartStopProhibitReasonListTotalNumberOfElements(int var1, int var2);

    public void updateStartStopRestartReasonListTotalNumberOfElements(int var1, int var2);

    public void updateStartStopRestartProhibitReasonListTotalNumberOfElements(int var1, int var2);

    public void updateStartStopViewOptions(StartStopViewOptions var1, int var2);

    public void updateStartStopCollectedReasons(int var1, int var2);

    public void updateRDViewOptions(RangeDataViewOptions var1, int var2);

    public void updateRDConsumptionMotorway1(CarBCConsumption var1, int var2);

    public void updateRDConsumptionMotorway2(CarBCConsumption var1, int var2);

    public void updateRDConsumptionHighway1(CarBCConsumption var1, int var2);

    public void updateRDConsumptionHighway2(CarBCConsumption var1, int var2);

    public void updateRDConsumptionCountryRoad1(CarBCConsumption var1, int var2);

    public void updateRDConsumptionCountryRoad2(CarBCConsumption var1, int var2);

    public void updateRDConsumptionDistrictRoad1(CarBCConsumption var1, int var2);

    public void updateRDConsumptionDistrictRoad2(CarBCConsumption var1, int var2);

    public void updateRDConsumptionLocalRoad1(CarBCConsumption var1, int var2);

    public void updateRDConsumptionLocalRoad2(CarBCConsumption var1, int var2);

    public void updateRDConsumptionRuralRoad1(CarBCConsumption var1, int var2);

    public void updateRDConsumptionRuralRoad2(CarBCConsumption var1, int var2);

    public void updateRDConsumptionUnclassifiedRoad1(CarBCConsumption var1, int var2);

    public void updateRDConsumptionUnclassifiedRoad2(CarBCConsumption var1, int var2);

    public void updateRDMaxRange1(CarBCCurrentRange var1, int var2);

    public void updateRDMaxRange2(CarBCCurrentRange var1, int var2);

    public void updateRDResidualEnergy1(RangeDataResidualEnergy var1, int var2);

    public void updateRDResidualEnergy2(RangeDataResidualEnergy var1, int var2);

    public void acknowledgeRDSetFactoryDefault(boolean var1);

    public void updateBCmEConsumerListConsumptionUpdateInfo(BCmEListUpdateInfo var1, int var2);

    public void updateBCmEConsumerListRangeUpdateInfo(BCmEListUpdateInfo var1, int var2);

    public void updateBCmEEnergyFlowComfort(BCmEEnergyFlowComfort var1, int var2);

    public void updateBCmERangeGainTotal(BCmERangeGainTotal var1, int var2);

    public void responseBCmEConsumerListConsumptionRA0(BCmEListUpdateInfo var1, BCmEConsumerListConsumptionRA0[] var2);

    public void responseBCmEConsumerListConsumptionRA1(BCmEListUpdateInfo var1, BCmEConsumerListConsumptionRA1[] var2);

    public void responseBCmEConsumerListConsumptionRAF(BCmEListUpdateInfo var1, int[] var2);

    public void responseBCmEConsumerListRangeRA0(BCmEListUpdateInfo var1, BCmEConsumerListRangeRA0[] var2);

    public void responseBCmEConsumerListRangeRA1(BCmEListUpdateInfo var1, BCmEConsumerListRangeRA1[] var2);

    public void responseBCmEConsumerListRangeRA2(BCmEListUpdateInfo var1, BCmEConsumerListRangeRA2[] var2);

    public void responseBCmEConsumerListRangeRAF(BCmEListUpdateInfo var1, int[] var2);

    public void updateBCmECurrentRange(BCmECurrentRange var1, int var2);

    public void updateBCmEConsumerListTotalNumberOfElements(int var1, int var2);

    public void updateBCmEConsumerListConsumptionTotalNumberOfElements(int var1, int var2);

    public void updateBCmEConsumerListRangeTotalNumberOfElements(int var1, int var2);

    public void updateBCmECurrentRangeSOC(int var1, int var2, int var3, int var4);

    public void updateBCmECatalogueRange(int var1, int var2, int var3, int var4);

    public void updateEAViewOptions(EAViewOptions var1, int var2);

    public void updateEASystem(boolean var1, int var2);

    public void updateEAPedalJerk(boolean var1, int var2);

    public void acknowledgeEASetFactoryDefault(boolean var1);

    public void updateEAFreeWheeling(boolean var1, int var2);

    public void updateEAStartStop(boolean var1, int var2);
}

