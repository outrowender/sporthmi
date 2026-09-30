/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.eco;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
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
import org.dsi.ifc.careco.DSICarEco;
import org.dsi.ifc.careco.DSICarEcoListener;
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

public abstract class AbstractDSICarEcoAdapter
extends AbstractCarComponent
implements DSICarEcoListener {
    static /* synthetic */ Class class$org$dsi$ifc$careco$DSICarEcoListener;
    static /* synthetic */ Class class$org$dsi$ifc$careco$DSICarEco;

    public AbstractDSICarEcoAdapter(ICarApplication iCarApplication, String string) {
        super(iCarApplication, string);
    }

    public final DSICarEco getDSI() {
        return (DSICarEco)this.getBaseDSI();
    }

    public String getDSIListenerClassName() {
        return (class$org$dsi$ifc$careco$DSICarEcoListener == null ? (class$org$dsi$ifc$careco$DSICarEcoListener = AbstractDSICarEcoAdapter.class$("org.dsi.ifc.careco.DSICarEcoListener")) : class$org$dsi$ifc$careco$DSICarEcoListener).getName();
    }

    public String getDSIClassName() {
        return (class$org$dsi$ifc$careco$DSICarEco == null ? (class$org$dsi$ifc$careco$DSICarEco = AbstractDSICarEcoAdapter.class$("org.dsi.ifc.careco.DSICarEco")) : class$org$dsi$ifc$careco$DSICarEco).getName();
    }

    public boolean isUsingDSI() {
        return true;
    }

    public void updateBCmEViewOptions(BCmEViewOptions bCmEViewOptions, int n) {
        this.logStub();
    }

    public void updateBCmEListUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) {
        this.logStub();
    }

    public void updateBCmEConsumption(int n, int n2, int n3, int n4) {
        this.logStub();
    }

    public void updateBCmELiveTip(int n, boolean bl, int n2) {
        this.logStub();
    }

    public void responseBCmEConsumerList(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerList[] bCmEConsumerListArray) {
        this.logStub();
    }

    public void acknowledgeBcmeSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void updateStartStopProhibitReasonListUpdateInfo(StartStopListUpdateInfo startStopListUpdateInfo, int n) {
        this.logStub();
    }

    public void responseStartStopProhibitReasonList(StartStopListUpdateInfo startStopListUpdateInfo, StartStopProhibitList[] startStopProhibitListArray) {
        this.logStub();
    }

    public void updateStartStopRestartReasonListUpdateInfo(StartStopListUpdateInfo startStopListUpdateInfo, int n) {
        this.logStub();
    }

    public void responseStartStopRestartReasonList(StartStopListUpdateInfo startStopListUpdateInfo, StartStopRestartList[] startStopRestartListArray) {
        this.logStub();
    }

    public void updateStartStopRestartProhibitReasonListUpdateInfo(StartStopListUpdateInfo startStopListUpdateInfo, int n) {
        this.logStub();
    }

    public void responseStartStopRestartProhibitReasonList(StartStopListUpdateInfo startStopListUpdateInfo, StartStopRestartProhibitList[] startStopRestartProhibitListArray) {
        this.logStub();
    }

    public void updateStartStopState(int n, int n2) {
        this.logStub();
    }

    public void updateStartStopProhibitReasonListTotalNumberOfElements(int n, int n2) {
        this.logStub();
    }

    public void updateStartStopRestartReasonListTotalNumberOfElements(int n, int n2) {
        this.logStub();
    }

    public void updateStartStopRestartProhibitReasonListTotalNumberOfElements(int n, int n2) {
        this.logStub();
    }

    public void updateStartStopViewOptions(StartStopViewOptions startStopViewOptions, int n) {
        this.logStub();
    }

    public void updateRDViewOptions(RangeDataViewOptions rangeDataViewOptions, int n) {
        this.logStub();
    }

    public void updateRDResidualEnergy1(RangeDataResidualEnergy rangeDataResidualEnergy, int n) {
        this.logStub();
    }

    public void updateRDResidualEnergy2(RangeDataResidualEnergy rangeDataResidualEnergy, int n) {
        this.logStub();
    }

    public void acknowledgeRDSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void updateBCmEConsumerListConsumptionUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) {
        this.logStub();
    }

    public void updateBCmEConsumerListRangeUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) {
        this.logStub();
    }

    public void updateBCmEEnergyFlowComfort(BCmEEnergyFlowComfort bCmEEnergyFlowComfort, int n) {
        this.logStub();
    }

    public void updateBCmERangeGainTotal(BCmERangeGainTotal bCmERangeGainTotal, int n) {
        this.logStub();
    }

    public void responseBCmEConsumerListConsumptionRA0(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListConsumptionRA0[] bCmEConsumerListConsumptionRA0Array) {
        this.logStub();
    }

    public void responseBCmEConsumerListConsumptionRA1(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListConsumptionRA1[] bCmEConsumerListConsumptionRA1Array) {
        this.logStub();
    }

    public void responseBCmEConsumerListConsumptionRAF(BCmEListUpdateInfo bCmEListUpdateInfo, int[] nArray) {
        this.logStub();
    }

    public void responseBCmEConsumerListRangeRA0(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA0[] bCmEConsumerListRangeRA0Array) {
        this.logStub();
    }

    public void responseBCmEConsumerListRangeRA1(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA1[] bCmEConsumerListRangeRA1Array) {
        this.logStub();
    }

    public void responseBCmEConsumerListRangeRA2(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA2[] bCmEConsumerListRangeRA2Array) {
        this.logStub();
    }

    public void responseBCmEConsumerListRangeRAF(BCmEListUpdateInfo bCmEListUpdateInfo, int[] nArray) {
        this.logStub();
    }

    public void updateBCmECurrentRange(BCmECurrentRange bCmECurrentRange, int n) {
        this.logStub();
    }

    public void updateBCmEConsumerListTotalNumberOfElements(int n, int n2) {
        this.logStub();
    }

    public void updateBCmEConsumerListConsumptionTotalNumberOfElements(int n, int n2) {
        this.logStub();
    }

    public void updateBCmEConsumerListRangeTotalNumberOfElements(int n, int n2) {
        this.logStub();
    }

    public void updateEAViewOptions(EAViewOptions eAViewOptions, int n) {
        this.logStub();
    }

    public void updateEASystem(boolean bl, int n) {
        this.logStub();
    }

    public void updateEAPedalJerk(boolean bl, int n) {
        this.logStub();
    }

    public void acknowledgeEASetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void updateRDConsumptionMotorway1(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateRDConsumptionMotorway2(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateRDConsumptionHighway1(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateRDConsumptionHighway2(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateRDConsumptionCountryRoad1(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateRDConsumptionCountryRoad2(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateRDConsumptionDistrictRoad1(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateRDConsumptionDistrictRoad2(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateRDConsumptionLocalRoad1(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateRDConsumptionLocalRoad2(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateRDConsumptionRuralRoad1(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateRDConsumptionRuralRoad2(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateRDConsumptionUnclassifiedRoad1(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateRDConsumptionUnclassifiedRoad2(CarBCConsumption carBCConsumption, int n) {
        this.logStub();
    }

    public void updateRDMaxRange1(CarBCCurrentRange carBCCurrentRange, int n) {
        this.logStub();
    }

    public void updateRDMaxRange2(CarBCCurrentRange carBCCurrentRange, int n) {
        this.logStub();
    }

    public void updateBCmECurrentRangeSOC(int n, int n2, int n3, int n4) {
        this.logStub();
    }

    public void updateBCmECatalogueRange(int n, int n2, int n3, int n4) {
        this.logStub();
    }

    public void updateEAFreeWheeling(boolean bl, int n) {
        this.logStub();
    }

    public void updateEAStartStop(boolean bl, int n) {
        this.logStub();
    }

    public void updateStartStopCollectedReasons(int n, int n2) {
        this.logStub();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

