/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco;

import de.esolutions.fw.comm.core.method.MethodException;
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

public interface DSICarEcoReply {
    public static final String IPL_COMM_UUID = "c0f3be5b-817e-5a0c-b1a2-8c438d97a242";
    public static final String IPL_COMM_INTERFACE_KEY = "cd0ec0e9-11a1-57f4-9385-56d694cbab95";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.23";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.23";

    public void updateBCmEViewOptions(BCmEViewOptions var1, int var2) throws MethodException;

    public void updateBCmEListUpdateInfo(BCmEListUpdateInfo var1, int var2) throws MethodException;

    public void updateBCmEConsumption(int var1, int var2, int var3, int var4) throws MethodException;

    public void updateBCmELiveTip(int var1, boolean var2, int var3) throws MethodException;

    public void responseBCmEConsumerList(BCmEListUpdateInfo var1, BCmEConsumerList[] var2) throws MethodException;

    public void acknowledgeBcmeSetFactoryDefault(boolean var1) throws MethodException;

    public void updateStartStopProhibitReasonListUpdateInfo(StartStopListUpdateInfo var1, int var2) throws MethodException;

    public void responseStartStopProhibitReasonList(StartStopListUpdateInfo var1, StartStopProhibitList[] var2) throws MethodException;

    public void updateStartStopRestartReasonListUpdateInfo(StartStopListUpdateInfo var1, int var2) throws MethodException;

    public void responseStartStopRestartReasonList(StartStopListUpdateInfo var1, StartStopRestartList[] var2) throws MethodException;

    public void updateStartStopRestartProhibitReasonListUpdateInfo(StartStopListUpdateInfo var1, int var2) throws MethodException;

    public void responseStartStopRestartProhibitReasonList(StartStopListUpdateInfo var1, StartStopRestartProhibitList[] var2) throws MethodException;

    public void updateStartStopState(int var1, int var2) throws MethodException;

    public void updateStartStopProhibitReasonListTotalNumberOfElements(int var1, int var2) throws MethodException;

    public void updateStartStopRestartReasonListTotalNumberOfElements(int var1, int var2) throws MethodException;

    public void updateStartStopRestartProhibitReasonListTotalNumberOfElements(int var1, int var2) throws MethodException;

    public void updateStartStopViewOptions(StartStopViewOptions var1, int var2) throws MethodException;

    public void updateStartStopCollectedReasons(int var1, int var2) throws MethodException;

    public void updateRDViewOptions(RangeDataViewOptions var1, int var2) throws MethodException;

    public void updateRDConsumptionMotorway1(CarBCConsumption var1, int var2) throws MethodException;

    public void updateRDConsumptionMotorway2(CarBCConsumption var1, int var2) throws MethodException;

    public void updateRDConsumptionHighway1(CarBCConsumption var1, int var2) throws MethodException;

    public void updateRDConsumptionHighway2(CarBCConsumption var1, int var2) throws MethodException;

    public void updateRDConsumptionCountryRoad1(CarBCConsumption var1, int var2) throws MethodException;

    public void updateRDConsumptionCountryRoad2(CarBCConsumption var1, int var2) throws MethodException;

    public void updateRDConsumptionDistrictRoad1(CarBCConsumption var1, int var2) throws MethodException;

    public void updateRDConsumptionDistrictRoad2(CarBCConsumption var1, int var2) throws MethodException;

    public void updateRDConsumptionLocalRoad1(CarBCConsumption var1, int var2) throws MethodException;

    public void updateRDConsumptionLocalRoad2(CarBCConsumption var1, int var2) throws MethodException;

    public void updateRDConsumptionRuralRoad1(CarBCConsumption var1, int var2) throws MethodException;

    public void updateRDConsumptionRuralRoad2(CarBCConsumption var1, int var2) throws MethodException;

    public void updateRDConsumptionUnclassifiedRoad1(CarBCConsumption var1, int var2) throws MethodException;

    public void updateRDConsumptionUnclassifiedRoad2(CarBCConsumption var1, int var2) throws MethodException;

    public void updateRDMaxRange1(CarBCCurrentRange var1, int var2) throws MethodException;

    public void updateRDMaxRange2(CarBCCurrentRange var1, int var2) throws MethodException;

    public void updateRDResidualEnergy1(RangeDataResidualEnergy var1, int var2) throws MethodException;

    public void updateRDResidualEnergy2(RangeDataResidualEnergy var1, int var2) throws MethodException;

    public void acknowledgeRDSetFactoryDefault(boolean var1) throws MethodException;

    public void updateBCmEConsumerListConsumptionUpdateInfo(BCmEListUpdateInfo var1, int var2) throws MethodException;

    public void updateBCmEConsumerListRangeUpdateInfo(BCmEListUpdateInfo var1, int var2) throws MethodException;

    public void updateBCmEEnergyFlowComfort(BCmEEnergyFlowComfort var1, int var2) throws MethodException;

    public void updateBCmERangeGainTotal(BCmERangeGainTotal var1, int var2) throws MethodException;

    public void responseBCmEConsumerListConsumptionRA0(BCmEListUpdateInfo var1, BCmEConsumerListConsumptionRA0[] var2) throws MethodException;

    public void responseBCmEConsumerListConsumptionRA1(BCmEListUpdateInfo var1, BCmEConsumerListConsumptionRA1[] var2) throws MethodException;

    public void responseBCmEConsumerListConsumptionRAF(BCmEListUpdateInfo var1, int[] var2) throws MethodException;

    public void responseBCmEConsumerListRangeRA0(BCmEListUpdateInfo var1, BCmEConsumerListRangeRA0[] var2) throws MethodException;

    public void responseBCmEConsumerListRangeRA1(BCmEListUpdateInfo var1, BCmEConsumerListRangeRA1[] var2) throws MethodException;

    public void responseBCmEConsumerListRangeRA2(BCmEListUpdateInfo var1, BCmEConsumerListRangeRA2[] var2) throws MethodException;

    public void responseBCmEConsumerListRangeRAF(BCmEListUpdateInfo var1, int[] var2) throws MethodException;

    public void updateBCmECurrentRange(BCmECurrentRange var1, int var2) throws MethodException;

    public void updateBCmEConsumerListTotalNumberOfElements(int var1, int var2) throws MethodException;

    public void updateBCmEConsumerListConsumptionTotalNumberOfElements(int var1, int var2) throws MethodException;

    public void updateBCmEConsumerListRangeTotalNumberOfElements(int var1, int var2) throws MethodException;

    public void updateBCmECurrentRangeSOC(int var1, int var2, int var3, int var4) throws MethodException;

    public void updateBCmECatalogueRange(int var1, int var2, int var3, int var4) throws MethodException;

    public void updateEAViewOptions(EAViewOptions var1, int var2) throws MethodException;

    public void updateEASystem(boolean var1, int var2) throws MethodException;

    public void updateEAPedalJerk(boolean var1, int var2) throws MethodException;

    public void acknowledgeEASetFactoryDefault(boolean var1) throws MethodException;

    public void updateEAFreeWheeling(boolean var1, int var2) throws MethodException;

    public void updateEAStartStop(boolean var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

