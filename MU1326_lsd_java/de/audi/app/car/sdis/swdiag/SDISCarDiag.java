/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.swdiag;

import de.audi.app.car.sdis.CarSportChronoASIProvider;
import de.audi.app.car.sdis.SDISCarManager;
import de.audi.app.car.sdis.mainunit.InterAppSDISDistributor;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.carcomfort.RDKConfiguration;
import org.dsi.ifc.carcomfort.RDKTireDisplayData;
import org.dsi.ifc.carcomfort.RDKViewOptions;
import org.dsi.ifc.carcomfort.RDKWheelPressures;
import org.dsi.ifc.carcomfort.RDKWheelStates;
import org.dsi.ifc.carcomfort.RDKWheelTemperatures;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.TADConfiguration;
import org.dsi.ifc.cardrivingcharacteristics.TADViewOptions;
import org.dsi.ifc.carkombi.BCLongTermGeneralData;
import org.dsi.ifc.carkombi.BCShortTermGeneralData;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.carkombi.SIAOilInspection;
import org.dsi.ifc.carkombi.SIAServiceData;
import org.dsi.ifc.carkombi.SIAViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoSCR;
import org.dsi.ifc.carvehiclestates.KeyData;
import org.dsi.ifc.carvehiclestates.OilLevelData;
import org.dsi.ifc.carvehiclestates.OilLevelRefillVolume;
import org.dsi.ifc.carvehiclestates.VehicleInfoViewOptions;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCCurrentRange;
import org.dsi.ifc.global.CarBCDistance;
import org.dsi.ifc.global.CarBCSpeed;
import org.dsi.ifc.global.CarBCTime;
import org.dsi.ifc.global.CarViewOption;

public class SDISCarDiag
extends AbstractSwDiagnosis {
    private final LogChannel logger;
    private final IFrameworkAccess framework;
    private InterAppSDISDistributor updater;
    private SDISCarManager manager;
    private RDKTireDisplayData data;

    public SDISCarDiag(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.logger = this.framework.getLogChannel("App.CarSDIS.Diag");
    }

    public void init(InterAppSDISDistributor interAppSDISDistributor) {
        this.updater = interAppSDISDistributor;
        this.initRDKStructure();
    }

    private void initRDKStructure() {
        this.data = new RDKTireDisplayData();
        this.data.wheelTemperatures = new RDKWheelTemperatures();
        this.data.requiredWheelPressures = new RDKWheelPressures();
        this.data.wheelStates = new RDKWheelStates();
        this.data.wheelPressures = new RDKWheelPressures();
    }

    public void setCarManager(SDISCarManager sDISCarManager) {
        this.manager = sDISCarManager;
    }

    public String getName() {
        return "CarSDISDiag";
    }

    public int getId() {
        return 12345;
    }

    public void cmdUpdateOilLevel_Level_Warning(int n, int n2) {
        if (this.manager.getCarVehicleStateComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        OilLevelData oilLevelData = new OilLevelData(n, new OilLevelRefillVolume(5, 0), n2, false, false);
        this.manager.getCarVehicleStateComponent().updateOilLevelData(oilLevelData, 1);
    }

    public void cmdUpdateOilLevel_Refill_Unit(int n, int n2) {
        if (this.manager.getCarVehicleStateComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        OilLevelData oilLevelData = new OilLevelData(0, new OilLevelRefillVolume(n, n2), 0, false, false);
        this.manager.getCarVehicleStateComponent().updateOilLevelData(oilLevelData, 1);
    }

    public void cmdUpdateOilViewOption(int n, int n2) {
        if (this.manager.getCarVehicleStateComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        this.manager.getCarVehicleStateComponent().updateOilLevelViewOption(new CarViewOption(n, n2), 1);
    }

    public void cmdUpdateVin(String string) {
        if (this.manager.getCarVehicleStateComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        this.manager.getCarVehicleStateComponent().updateVINData(string, 1);
    }

    public void cmdUpdateVinViewOption(int n, int n2) {
        if (this.manager.getCarVehicleStateComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        this.manager.getCarVehicleStateComponent().updateVINViewOption(new CarViewOption(n, n2), 1);
    }

    public void cmdUpdateAdblue_Value_State_Unit_Tank_Min_Max(int n, int n2, int n3, int n4, float f2, float f3) {
        if (this.manager.getCarVehicleStateComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        DynamicVehicleInfoSCR dynamicVehicleInfoSCR = new DynamicVehicleInfoSCR();
        dynamicVehicleInfoSCR.level = (byte)n;
        dynamicVehicleInfoSCR.status = n2;
        dynamicVehicleInfoSCR.volumeUnit = n3;
        dynamicVehicleInfoSCR.rangeUnit = n3;
        dynamicVehicleInfoSCR.tankVolume = n4;
        dynamicVehicleInfoSCR.refillLevelMin = f2;
        dynamicVehicleInfoSCR.refillLevelMax = f3;
        this.manager.getCarVehicleStateComponent().updateDynamicVehicleInfoSCR(dynamicVehicleInfoSCR, 1);
    }

    public void cmdUpdateAdblueViewOption(int n, int n2) {
        if (this.manager.getCarVehicleStateComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        VehicleInfoViewOptions vehicleInfoViewOptions = new VehicleInfoViewOptions();
        vehicleInfoViewOptions.scrInfo = new CarViewOption(n, n2);
        this.manager.getCarVehicleStateComponent().updateVehicleInfoViewOptions(vehicleInfoViewOptions, 1);
    }

    public void cmdUpdateRDK(int n, int n2, int n3, int n4) {
        if (this.manager.getCarComfortComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        RDKTireDisplayData rDKTireDisplayData = new RDKTireDisplayData();
        rDKTireDisplayData.requiredWheelPressures = new RDKWheelPressures();
        rDKTireDisplayData.wheelPressures = new RDKWheelPressures(0, n, n2, n3, n4, 1);
        rDKTireDisplayData.wheelStates = new RDKWheelStates();
        rDKTireDisplayData.wheelTemperatures = new RDKWheelTemperatures();
        this.manager.getCarComfortComponent().updateRDKTireDisplay(rDKTireDisplayData, 1);
    }

    public void cmdUpdateRDKViewOption(int n, int n2) {
        if (this.manager.getCarComfortComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        RDKViewOptions rDKViewOptions = new RDKViewOptions();
        rDKViewOptions.configuration = new RDKConfiguration();
        rDKViewOptions.configuration.system = 1;
        rDKViewOptions.tireDisplay = new CarViewOption(n, n2);
        this.manager.getCarComfortComponent().updateRDKViewOptions(rDKViewOptions, 1);
    }

    public void cmdUpdateKeyData(int n) {
        if (this.manager.getCarVehicleStateComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        KeyData keyData = new KeyData();
        keyData.actualValue = n;
        this.manager.getCarVehicleStateComponent().updateKeyData(keyData, 1);
    }

    public void cmdUpdateKeyDataViewOption(int n, int n2) {
        if (this.manager.getCarVehicleStateComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        CarViewOption carViewOption = new CarViewOption(n, n2);
        this.manager.getCarVehicleStateComponent().updateKeyViewOption(carViewOption, 1);
    }

    public void cmdUpdateSIA(int n, int n2) {
        if (this.manager.getCarKombiComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        SIAServiceData sIAServiceData = new SIAServiceData();
        sIAServiceData.distanceStatus = 2;
        sIAServiceData.timeStatus = 2;
        sIAServiceData.time = n;
        sIAServiceData.distance = n2;
        this.manager.getCarKombiComponent().updateSIAServiceData(sIAServiceData, 1);
    }

    public void cmdUpdateSIAOilInspection(int n, int n2) {
        if (this.manager.getCarKombiComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        SIAOilInspection sIAOilInspection = new SIAOilInspection();
        sIAOilInspection.distanceStatus = 2;
        sIAOilInspection.timeStatus = 2;
        sIAOilInspection.time = n;
        sIAOilInspection.distance = n2;
        this.manager.getCarKombiComponent().updateSIAOilInspection(sIAOilInspection, 1);
    }

    public void cmdUpdateSIAViewOption(int n, int n2) {
        CarViewOption carViewOption;
        if (this.manager.getCarKombiComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        SIAViewOptions sIAViewOptions = new SIAViewOptions();
        sIAViewOptions.oilInspection = carViewOption = new CarViewOption(n, n2);
        sIAViewOptions.serviceData = carViewOption;
        this.manager.getCarKombiComponent().updateSIAViewOptions(sIAViewOptions, 1);
    }

    public void cmdUpdateTADConfiguration(int n, int n2, int n3) {
        TADConfiguration tADConfiguration;
        if (this.manager.getCarDrivingCharacteristicsComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        TADViewOptions tADViewOptions = new TADViewOptions();
        tADViewOptions.configuration = tADConfiguration = new TADConfiguration(n3, n, n2, 0, 0, 0, true, true);
        tADViewOptions.angleDisplay = new CarViewOption(2, 0);
        this.manager.getCarDrivingCharacteristicsComponent().updateTADViewOptions(tADViewOptions, 1);
    }

    public void cmdUpdateTADPitch(float f2) {
        if (this.manager.getCarDrivingCharacteristicsComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        this.manager.getCarDrivingCharacteristicsComponent().updateTADCurrentPitchAngle(f2, 1);
    }

    public void cmdUpdateTADRoll(float f2) {
        if (this.manager.getCarDrivingCharacteristicsComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        this.manager.getCarDrivingCharacteristicsComponent().updateTADCurrentRollAngle(f2, 1);
    }

    public void cmdUpdateTADViewOption(boolean bl, boolean bl2) {
        if (this.manager.getCarDrivingCharacteristicsComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        TADViewOptions tADViewOptions = new TADViewOptions();
        tADViewOptions.configuration = new TADConfiguration();
        tADViewOptions.configuration.pitchAngleInstallation = bl2;
        tADViewOptions.configuration.rollAngleInstallation = bl;
        this.manager.getCarDrivingCharacteristicsComponent().updateTADViewOptions(tADViewOptions, 1);
    }

    public void cmdUpdateAirSuspension(int n) {
        if (this.manager.getCarDrivingCharacteristicsComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        this.manager.getCarDrivingCharacteristicsComponent().updateSuspensionControlCurrentLevel(n, 1);
    }

    public void cmdUpdateAirSuspensionViewOption(int n, int n2) {
        CarViewOption carViewOption;
        if (this.manager.getCarDrivingCharacteristicsComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        SuspensionControlViewOptions suspensionControlViewOptions = new SuspensionControlViewOptions();
        suspensionControlViewOptions.heightInfo = carViewOption = new CarViewOption(n, n2);
        this.manager.getCarDrivingCharacteristicsComponent().updateSuspensionControlViewOptions(suspensionControlViewOptions, 1);
    }

    public void cmdUpdateSpeed(int n, int n2) {
        if (this.manager.getCarVehicleStateComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        CarBCSpeed carBCSpeed = new CarBCSpeed(1, n, n2);
        DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent = new DynamicVehicleInfoHighFrequent();
        dynamicVehicleInfoHighFrequent.vehicleSpeed = carBCSpeed;
        this.manager.getCarVehicleStateComponent().updateDynamicVehicleInfoHighFrequent(dynamicVehicleInfoHighFrequent, 1);
    }

    public void cmdUpdateSpeedViewOption(int n, int n2) {
        CarViewOption carViewOption;
        if (this.manager.getCarVehicleStateComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions = new DynamicVehicleInfoHighFrequentViewOptions();
        dynamicVehicleInfoHighFrequentViewOptions.vehicleSpeed = carViewOption = new CarViewOption(n, n2);
        this.manager.getCarVehicleStateComponent().updateDynamicVehicleInfoHighFrequentViewOptions(dynamicVehicleInfoHighFrequentViewOptions, 1);
    }

    public void cmdUpdateWheelPressure(int n, int n2, int n3, int n4, int n5) {
        if (this.manager.getCarComfortComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        this.data.wheelPressures = new RDKWheelPressures(n5, n, n2, n3, n4, 0);
        this.manager.getCarComfortComponent().updateRDKTireDisplay(this.data, 1);
    }

    public void cmdUpdateWheelTemperature(int n, int n2, int n3, int n4, int n5) {
        if (this.manager.getCarComfortComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        this.data.wheelTemperatures = new RDKWheelTemperatures(n5, n, n2, n3, n4, 0);
        this.manager.getCarComfortComponent().updateRDKTireDisplay(this.data, 1);
    }

    public void cmdUpdateWheelState(int n, int n2, int n3, int n4, int n5) {
        if (this.manager.getCarComfortComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        this.data.wheelStates = new RDKWheelStates(n, n2, n3, n4, n5, 0);
        this.manager.getCarComfortComponent().updateRDKTireDisplay(this.data, 1);
    }

    public void cmdUpdateDriveSelectProfile(int n) {
        if (this.manager.getCarDrivingCharacteristicsComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        this.manager.getCarDrivingCharacteristicsComponent().updateCharismaActiveProfile(n, 1);
    }

    public void cmdUpdateDriveSelectProfileViewOption(int n, int n2) {
        if (this.manager.getCarDrivingCharacteristicsComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        CarViewOption carViewOption = new CarViewOption(n, n2);
        CharismaViewOptions charismaViewOptions = new CharismaViewOptions();
        charismaViewOptions.activeProfile = carViewOption;
        this.manager.getCarDrivingCharacteristicsComponent().updateCharismaViewOptions(charismaViewOptions, 1);
    }

    public void cmdUpdateBC() {
        if (this.manager.getCarKombiComponent() == null) {
            this.logger.log(100000, "Component is null -> check coding!");
            return;
        }
        CarViewOption carViewOption = new CarViewOption(2, 0);
        BCViewOptions bCViewOptions = new BCViewOptions();
        bCViewOptions.currentRange1 = carViewOption;
        bCViewOptions.currentRange2 = carViewOption;
        bCViewOptions.shortTermAverageConsumption1 = carViewOption;
        bCViewOptions.shortTermAverageConsumption2 = carViewOption;
        bCViewOptions.shortTermGeneral = carViewOption;
        bCViewOptions.longTermAverageConsumption1 = carViewOption;
        bCViewOptions.longTermAverageConsumption2 = carViewOption;
        bCViewOptions.longTermGeneral = carViewOption;
        this.manager.getCarKombiComponent().updateBCViewOptions(bCViewOptions, 1);
        this.manager.getCarKombiComponent().updateBCShortTermAverageConsumption1(new CarBCConsumption(0, 10.0f, 0), 1);
        this.manager.getCarKombiComponent().updateBCShortTermAverageConsumption2(new CarBCConsumption(0, 20.0f, 0), 1);
        this.manager.getCarKombiComponent().updateBCLongTermAverageConsumption1(new CarBCConsumption(0, 150.0f, 0), 1);
        this.manager.getCarKombiComponent().updateBCLongTermAverageConsumption2(new CarBCConsumption(0, 250.0f, 0), 1);
        BCLongTermGeneralData bCLongTermGeneralData = new BCLongTermGeneralData(new CarBCDistance(0, 500.0, 0), new CarBCSpeed(0, 120.0f, 0), new CarBCTime(1, 123456));
        this.manager.getCarKombiComponent().updateBCLongTermGeneral(bCLongTermGeneralData, 1);
        BCShortTermGeneralData bCShortTermGeneralData = new BCShortTermGeneralData(new CarBCDistance(0, 500.0, 0), new CarBCSpeed(0, 120.0f, 0), new CarBCTime(1, 123456));
        this.manager.getCarKombiComponent().updateBCShortTermGeneral(bCShortTermGeneralData, 1);
        this.manager.getCarKombiComponent().updateBCCurrentRange1(new CarBCCurrentRange(0, 100, 0), 1);
        this.manager.getCarKombiComponent().updateBCCurrentRange2(new CarBCCurrentRange(0, 200, 0), 1);
    }

    public void cmdSetAllVisibile() {
        this.cmdUpdateVinViewOption(2, 0);
        this.cmdUpdateKeyDataViewOption(2, 0);
        this.cmdUpdateOilViewOption(2, 0);
        this.cmdUpdateAdblueViewOption(2, 0);
        this.cmdUpdateRDKViewOption(2, 0);
        this.cmdUpdateSIAViewOption(2, 0);
        this.cmdUpdateSpeedViewOption(2, 0);
        this.cmdUpdateAirSuspensionViewOption(2, 0);
        this.cmdUpdateTADViewOption(true, true);
        this.cmdUpdateDriveSelectProfileViewOption(2, 0);
    }

    public void cmdSetAllValues() {
        this.cmdUpdateVin("WVWZZZ1JZ3W386752");
        this.cmdUpdateKeyData(2);
        this.cmdUpdateOilLevel_Level_Warning(50, 4);
        this.cmdUpdateAdblue_Value_State_Unit_Tank_Min_Max(50, 0, 0, 24, 1.0f, 2.0f);
        this.cmdUpdateRDK(2, 2, 2, 2);
        this.cmdUpdateSIA(365, 2000);
        this.cmdUpdateSpeed(100, 0);
        this.cmdUpdateAirSuspension(50);
        this.cmdUpdateTADPitch(10.0f);
        this.cmdUpdateTADRoll(10.0f);
        this.cmdUpdateDriveSelectProfile(3);
        this.cmdUpdateWheelPressure(10, 15, 20, 25, 0);
        this.cmdUpdateWheelTemperature(70, 75, 80, 85, 0);
        this.cmdUpdateWheelState(0, 0, 1, 2, 3);
    }

    public void cmdSimulateAll() {
        this.cmdSetAllVisibile();
        this.cmdSetAllValues();
    }

    public void cmdSportChronoSetRecord(int n) {
        ASIHMISyncCarSportChronoReplyProxy aSIHMISyncCarSportChronoReplyProxy = new ASIHMISyncCarSportChronoReplyProxy();
        try {
            ((CarSportChronoASIProvider)this.manager.getSDISBase().getASIDataUpdater().getSportChronoASI()).setRecord(n, aSIHMISyncCarSportChronoReplyProxy);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[SDISCarDiag#cmdSportChronoSetRecord] Exception: %1", (Throwable)methodException);
        }
    }
}

