/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.comp;

import de.audi.app.car.sdis.base.AbstractDSICarKombi;
import de.audi.app.car.sdis.base.IDSIObserver;
import de.audi.app.car.sdis.base.ISDISFramework;
import de.audi.app.car.sdis.base.IVisibility;
import de.audi.app.car.sdis.comp.CarKombiComponent$CarStateHandler;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.bc.BCTermGeneralData;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.car.service.SIAOilInspection;
import de.esolutions.fw.comm.asi.hmisync.car.service.SIAServiceData;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carkombi.BCLongTermGeneralData;
import org.dsi.ifc.carkombi.BCShortTermGeneralData;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.carkombi.DSICarKombi;
import org.dsi.ifc.carkombi.SIAViewOptions;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCCurrentRange;
import org.dsi.ifc.global.CarViewOption;

public class CarKombiComponent
extends AbstractDSICarKombi
implements IDSIObserver {
    private static final String LOG_CHANNEL_NAME;
    private static final String[] entryToText;
    private static final int BC_CURRENT_RANGE2_VISIBLITY;
    private static final int BC_CURRENT_RANGE1_VISIBLITY;
    private static final int BC_LONG_TERM_GENERAL_VISIBLITY;
    private static final int BC_LONG_TERM_AVG_CONSUMP2_VISIBLITY;
    private static final int BC_LONG_TERM_AVG_CONSUMP1_VISIBLITY;
    private static final int BC_SHORT_TERM_GENERAL_VISIBLITY;
    private static final int BC_SHORT_TERM_AVG_CONSUMP2_VISIBLITY;
    private static final int BC_SHORT_TERM_AVG_CONSUMP_VISIBLITY;
    private static final int SIA_SERVICE_VISIBILITY;
    private static final int SIA_OIL_VISIBLITY;
    public static final byte[] CODING;
    private static final int[] attributes;
    private final LogChannel logger;
    private DSICarKombi dsi;
    private ISDISFramework baseService;
    private CarKombiComponent$CarStateHandler carStateHandler;
    private ASIHMISyncCarServiceAbstractBaseService toSDIS;
    private ASIHMISyncCarBordComputerAbstractBaseService toSDISBordComputer;
    private int[] latestSentBCVisibility = new int[10];
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombi;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombiListener;

    public CarKombiComponent(ISDISFramework iSDISFramework) {
        super(iSDISFramework.getLogChannel("App.CarSDIS.CarKombi"));
        this.logger = iSDISFramework.getLogChannel("App.CarSDIS.CarKombi");
        this.baseService = iSDISFramework;
        this.toSDIS = this.baseService.getASIDataUpdater().getServiceASI();
        this.toSDISBordComputer = this.baseService.getASIDataUpdater().getBordComputerASI();
        this.carStateHandler = new CarKombiComponent$CarStateHandler(this, this.logger);
    }

    public void init() {
        for (int i2 = 0; i2 < this.latestSentBCVisibility.length; ++i2) {
            this.latestSentBCVisibility[i2] = 0;
        }
        this.notCodedInfo();
        this.carStateHandler.registerCarStates(CODING);
        this.baseService.registerDSI((class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = CarKombiComponent.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi).getName(), (class$org$dsi$ifc$carkombi$DSICarKombiListener == null ? (class$org$dsi$ifc$carkombi$DSICarKombiListener = CarKombiComponent.class$("org.dsi.ifc.carkombi.DSICarKombiListener")) : class$org$dsi$ifc$carkombi$DSICarKombiListener).getName(), this);
    }

    public void deinit() {
        this.baseService.deRegisterDSI((class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = CarKombiComponent.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi).getName());
        this.carStateHandler.deregisterCarStates();
    }

    public void notCodedInfo() {
        int n = 0;
        do {
            if (this.carStateHandler.isActivated(CODING[n])) continue;
            switch (CODING[n]) {
                case 13: {
                    this.sendUpdateSIAOilInspectionVisibilityState(0);
                    this.sendUpdateSIAServiceDataVisibilityState(0);
                    CarKombiComponent$CarStateHandler.access$000(this.carStateHandler, 0, 0);
                    CarKombiComponent$CarStateHandler.access$000(this.carStateHandler, 1, 0);
                    break;
                }
                case 10: {
                    this.sendUpdateBCVisibilityState(0);
                    CarKombiComponent$CarStateHandler.access$000(this.carStateHandler, 2, 0);
                    CarKombiComponent$CarStateHandler.access$000(this.carStateHandler, 3, 0);
                    CarKombiComponent$CarStateHandler.access$000(this.carStateHandler, 4, 0);
                    CarKombiComponent$CarStateHandler.access$000(this.carStateHandler, 8, 0);
                    CarKombiComponent$CarStateHandler.access$000(this.carStateHandler, 9, 0);
                    break;
                }
                default: {
                    this.logger.log(-2137614336, "[notCodedInfo]: %1 not supported.", (long)CODING[n]);
                }
            }
        } while (++n < CODING.length);
    }

    @Override
    public void updateSIAViewOptions(SIAViewOptions sIAViewOptions, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(-2137614336, "[updateSIAViewOptions]: %1", (Object)sIAViewOptions);
        this.saveVisiblityState(1, sIAViewOptions.getServiceData(), (short)13);
        int n2 = CarKombiComponent$CarStateHandler.access$100(this.carStateHandler)[1].getVisibility();
        int n3 = this.carStateHandler.updateMenuEntryVisibility((short)13, n2);
        this.sendUpdateSIAServiceDataVisibilityState(n3);
        this.saveVisiblityState(0, sIAViewOptions.getOilInspection(), (short)13);
        int n4 = CarKombiComponent$CarStateHandler.access$100(this.carStateHandler)[0].getVisibility();
        int n5 = this.carStateHandler.updateMenuEntryVisibility((short)13, n4);
        this.sendUpdateSIAOilInspectionVisibilityState(n5);
    }

    private void sendUpdateSIAServiceDataVisibilityState(int n) {
        try {
            this.logger.log(-2137614336, "Send update to devices -> updateSIAServiceDataVisibilityState: %1", (Object)IVisibility.TEXT_TO_STATE[n]);
            this.toSDIS.updateSIAServiceDataVisibilityState(n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateSIAServiceDataVisibilityState] %1", (Throwable)methodException);
        }
    }

    private void sendUpdateSIAOilInspectionVisibilityState(int n) {
        try {
            this.logger.log(-2137614336, "Send update to devices -> updateSIAOilInspectionVisibilityState: %1", (Object)IVisibility.TEXT_TO_STATE[n]);
            int[] nArray = new int[]{n, n};
            this.toSDIS.updateSIAOilInspectionVisibilityState(nArray);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateSIAOilInspectionVisibilityState] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateSIAServiceData(org.dsi.ifc.carkombi.SIAServiceData sIAServiceData, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(-2137614336, "[updateSIAServiceData]: %1", (Object)sIAServiceData);
        SIAServiceData sIAServiceData2 = new SIAServiceData(sIAServiceData.getDistanceStatus(), sIAServiceData.getDistance(), sIAServiceData.getDistanceUnit(), sIAServiceData.getTimeStatus(), sIAServiceData.getTime());
        try {
            this.logger.log(-2137614336, "Send update to devices -> updateSIAServiceData: %1", (Object)sIAServiceData2);
            this.toSDIS.updateSIAServiceData(sIAServiceData2);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateSIAServiceData] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateSIAOilInspection(org.dsi.ifc.carkombi.SIAOilInspection sIAOilInspection, int n) {
        if (n != 1) {
            return;
        }
        SIAOilInspection sIAOilInspection2 = new SIAOilInspection(sIAOilInspection.getDistanceStatus(), sIAOilInspection.getDistance(), sIAOilInspection.getDistanceUnit(), sIAOilInspection.getTimeStatus(), sIAOilInspection.getTime());
        try {
            this.logger.log(-2137614336, "Send update to devices -> updateSIAOilInspection: %1", (Object)sIAOilInspection2);
            this.toSDIS.updateSIAOilInspection(sIAOilInspection2);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateSIAOilInspection] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateBCViewOptions(BCViewOptions bCViewOptions, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(-2137614336, "[updateBCViewOptions]: %1", (Object)bCViewOptions);
        CarViewOption carViewOption = bCViewOptions.getShortTermAverageConsumption1();
        CarViewOption carViewOption2 = bCViewOptions.getShortTermAverageConsumption2();
        CarViewOption carViewOption3 = bCViewOptions.getShortTermGeneral();
        CarViewOption carViewOption4 = bCViewOptions.getLongTermAverageConsumption1();
        CarViewOption carViewOption5 = bCViewOptions.getLongTermAverageConsumption2();
        CarViewOption carViewOption6 = bCViewOptions.getLongTermGeneral();
        CarViewOption carViewOption7 = bCViewOptions.getCurrentRange1();
        CarViewOption carViewOption8 = bCViewOptions.currentRange2;
        this.saveVisiblityState(2, carViewOption, (short)10);
        this.saveVisiblityState(3, carViewOption2, (short)10);
        this.saveVisiblityState(4, carViewOption3, (short)10);
        this.saveVisiblityState(8, carViewOption7, (short)10);
        this.saveVisiblityState(9, carViewOption8, (short)10);
        this.saveVisiblityState(5, carViewOption4, (short)10);
        this.saveVisiblityState(6, carViewOption5, (short)10);
        this.saveVisiblityState(7, carViewOption6, (short)10);
        this.sendUpdateBCVisibilityState();
    }

    private void sendUpdateBCVisibilityState() {
        try {
            int n = this.carStateHandler.updateMenuEntryVisibility((short)10, CarKombiComponent$CarStateHandler.access$100(this.carStateHandler)[8].getVisibility());
            this.logger.log(-2137614336, "Send update to devices -> updateBCCurrentRange1Visibility: %1", (Object)IVisibility.TEXT_TO_STATE[n]);
            this.toSDISBordComputer.updateBCCurrentRange1Visibility(n);
            int n2 = this.carStateHandler.updateMenuEntryVisibility((short)10, CarKombiComponent$CarStateHandler.access$100(this.carStateHandler)[9].getVisibility());
            this.logger.log(-2137614336, "Send update to devices -> updateBCCurrentRange2Visibility: %1", (Object)IVisibility.TEXT_TO_STATE[n2]);
            this.toSDISBordComputer.updateBCCurrentRange2Visibility(n2);
            int n3 = this.carStateHandler.updateMenuEntryVisibility((short)10, CarKombiComponent$CarStateHandler.access$100(this.carStateHandler)[5].getVisibility());
            this.logger.log(-2137614336, "Send update to devices -> updateBCLongTermAverageConsumption1Visibility: %1", (Object)IVisibility.TEXT_TO_STATE[n3]);
            this.toSDISBordComputer.updateBCLongTermAverageConsumption1Visibility(n3);
            int n4 = this.carStateHandler.updateMenuEntryVisibility((short)10, CarKombiComponent$CarStateHandler.access$100(this.carStateHandler)[6].getVisibility());
            this.logger.log(-2137614336, "Send update to devices -> updateBCLongTermAverageConsumption2Visibility: %1", (Object)IVisibility.TEXT_TO_STATE[n4]);
            this.toSDISBordComputer.updateBCLongTermAverageConsumption2Visibility(n4);
            int n5 = this.carStateHandler.updateMenuEntryVisibility((short)10, CarKombiComponent$CarStateHandler.access$100(this.carStateHandler)[7].getVisibility());
            this.logger.log(-2137614336, "Send update to devices -> updateBCLongTermGeneralVisibility: %1", (Object)IVisibility.TEXT_TO_STATE[n5]);
            this.toSDISBordComputer.updateBCLongTermGeneralVisibility(n5);
            int n6 = this.carStateHandler.updateMenuEntryVisibility((short)10, CarKombiComponent$CarStateHandler.access$100(this.carStateHandler)[2].getVisibility());
            this.logger.log(-2137614336, "Send update to devices -> updateBCShortTermAverageConsumption1Visibility: %1", (Object)IVisibility.TEXT_TO_STATE[n6]);
            this.toSDISBordComputer.updateBCShortTermAverageConsumption1Visibility(n6);
            int n7 = this.carStateHandler.updateMenuEntryVisibility((short)10, CarKombiComponent$CarStateHandler.access$100(this.carStateHandler)[3].getVisibility());
            this.logger.log(-2137614336, "Send update to devices -> updateBCShortTermAverageConsumption2Visibility: %1", (Object)IVisibility.TEXT_TO_STATE[n7]);
            this.toSDISBordComputer.updateBCShortTermAverageConsumption2Visibility(n7);
            int n8 = this.carStateHandler.updateMenuEntryVisibility((short)10, CarKombiComponent$CarStateHandler.access$100(this.carStateHandler)[4].getVisibility());
            this.logger.log(-2137614336, "Send update to devices -> updateBCShortTermGeneralVisibility: %1", (Object)IVisibility.TEXT_TO_STATE[n8]);
            this.toSDISBordComputer.updateBCShortTermGeneralVisibility(n8);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[sendUpdateBCVisibilityState] %1", (Throwable)methodException);
        }
    }

    private void saveVisiblityState(int n, CarViewOption carViewOption, short s) {
        int n2 = this.baseService.updateVisibility(carViewOption, s);
        CarKombiComponent$CarStateHandler.access$100(this.carStateHandler)[n].setVisibility(n2);
    }

    private void sendUpdateBCVisibilityState(int n) {
        this.logger.log(-2137614336, "Send update to devices -> sendUpdateBCVisibilityState: %1", (Object)IVisibility.TEXT_TO_STATE[n]);
        try {
            int n2 = this.latestSentBCVisibility[8] = this.evaluateVisibility(n, CarKombiComponent$CarStateHandler.access$100(this.carStateHandler)[8].getVisibility());
            this.toSDISBordComputer.updateBCCurrentRange1Visibility(n2);
            int n3 = this.latestSentBCVisibility[9] = this.evaluateVisibility(n, CarKombiComponent$CarStateHandler.access$100(this.carStateHandler)[9].getVisibility());
            this.toSDISBordComputer.updateBCCurrentRange2Visibility(n3);
            int n4 = this.latestSentBCVisibility[5] = this.evaluateVisibility(n, CarKombiComponent$CarStateHandler.access$100(this.carStateHandler)[5].getVisibility());
            this.toSDISBordComputer.updateBCLongTermAverageConsumption1Visibility(n4);
            int n5 = this.latestSentBCVisibility[6] = this.evaluateVisibility(n, CarKombiComponent$CarStateHandler.access$100(this.carStateHandler)[6].getVisibility());
            this.toSDISBordComputer.updateBCLongTermAverageConsumption2Visibility(n5);
            int n6 = this.latestSentBCVisibility[7] = this.evaluateVisibility(n, CarKombiComponent$CarStateHandler.access$100(this.carStateHandler)[7].getVisibility());
            this.toSDISBordComputer.updateBCLongTermGeneralVisibility(n6);
            int n7 = this.latestSentBCVisibility[2] = this.evaluateVisibility(n, CarKombiComponent$CarStateHandler.access$100(this.carStateHandler)[2].getVisibility());
            this.toSDISBordComputer.updateBCShortTermAverageConsumption1Visibility(n7);
            int n8 = this.latestSentBCVisibility[3] = this.evaluateVisibility(n, CarKombiComponent$CarStateHandler.access$100(this.carStateHandler)[3].getVisibility());
            this.toSDISBordComputer.updateBCShortTermAverageConsumption2Visibility(n8);
            int n9 = this.latestSentBCVisibility[4] = this.evaluateVisibility(n, CarKombiComponent$CarStateHandler.access$100(this.carStateHandler)[4].getVisibility());
            this.toSDISBordComputer.updateBCShortTermGeneralVisibility(n9);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[sendUpdateBCVisibilityState] %1", (Throwable)methodException);
        }
    }

    private int evaluateVisibility(int n, int n2) {
        if (n2 >= 2) {
            return n;
        }
        return n2;
    }

    @Override
    public void updateBCShortTermAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
        if (n != 1) {
            return;
        }
        FloatBaseType floatBaseType = new FloatBaseType(carBCConsumption.getConsumptionValue(), carBCConsumption.getConsumptionUnit(), carBCConsumption.getState());
        try {
            this.logger.log(-2137614336, "Send update to devices -> updateBCShortTermAverageConsumption1 %1", (Object)carBCConsumption);
            this.toSDISBordComputer.updateBCShortTermAverageConsumption1(floatBaseType);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateBCShortTermAverageConsumption1] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateBCShortTermAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
        if (n != 1) {
            return;
        }
        FloatBaseType floatBaseType = new FloatBaseType(carBCConsumption.getConsumptionValue(), carBCConsumption.getConsumptionUnit(), carBCConsumption.getState());
        try {
            this.logger.log(-2137614336, "Send update to devices -> updateBCShortTermAverageConsumption2: %1", (Object)carBCConsumption);
            this.toSDISBordComputer.updateBCShortTermAverageConsumption2(floatBaseType);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateBCShortTermAverageConsumption2] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateBCShortTermGeneral(BCShortTermGeneralData bCShortTermGeneralData, int n) {
        if (n != 1) {
            return;
        }
        BCTermGeneralData bCTermGeneralData = new BCTermGeneralData();
        bCTermGeneralData.distance = new FloatBaseType((float)bCShortTermGeneralData.getDistance().getDistanceValue(), bCShortTermGeneralData.getDistance().getDistanceUnit(), bCShortTermGeneralData.getDistance().getDistanceValueState());
        bCTermGeneralData.speed = new FloatBaseType(bCShortTermGeneralData.getSpeed().getSpeedValue(), bCShortTermGeneralData.getSpeed().getSpeedUnit(), bCShortTermGeneralData.getSpeed().getSpeedValueState());
        bCTermGeneralData.timeValue = bCShortTermGeneralData.getTimeValue().getTimeValue();
        try {
            this.logger.log(-2137614336, "Send update to devices -> updateBCShortTermGeneral: Distance %1 %2 %3", bCShortTermGeneralData.getDistance().getDistanceValue(), (double)bCShortTermGeneralData.getDistance().getDistanceUnit(), (double)bCShortTermGeneralData.getDistance().getDistanceValueState());
            this.logger.log(-2137614336, "updateBCShortTermGeneral: Speed %1 %2 %3", (double)bCShortTermGeneralData.getSpeed().getSpeedValue(), (double)bCShortTermGeneralData.getSpeed().getSpeedUnit(), (double)bCShortTermGeneralData.getSpeed().getSpeedValueState());
            this.logger.log(-2137614336, "updateBCShortTermGeneral: Time %1 %2", (long)bCShortTermGeneralData.getTimeValue().getTimeValue(), (long)bCShortTermGeneralData.getTimeValue().getState());
            this.toSDISBordComputer.updateBCShortTermGeneral(bCTermGeneralData);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateBCShortTermGeneral] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateBCLongTermAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
        if (n != 1) {
            return;
        }
        FloatBaseType floatBaseType = new FloatBaseType(carBCConsumption.getConsumptionValue(), carBCConsumption.getConsumptionUnit(), carBCConsumption.getState());
        try {
            this.logger.log(-2137614336, "Send update to devices -> updateBCLongTermAverageConsumption1: %1", (Object)carBCConsumption);
            this.toSDISBordComputer.updateBCLongTermAverageConsumption1(floatBaseType);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateBCLongTermAverageConsumption1] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateBCLongTermAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
        if (n != 1) {
            return;
        }
        FloatBaseType floatBaseType = new FloatBaseType(carBCConsumption.getConsumptionValue(), carBCConsumption.getConsumptionUnit(), carBCConsumption.getState());
        try {
            this.logger.log(-2137614336, "Send update to devices -> updateBCLongTermAverageConsumption2: %1", (Object)carBCConsumption);
            this.toSDISBordComputer.updateBCLongTermAverageConsumption2(floatBaseType);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateBCLongTermAverageConsumption2] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateBCLongTermGeneral(BCLongTermGeneralData bCLongTermGeneralData, int n) {
        if (n != 1) {
            return;
        }
        BCTermGeneralData bCTermGeneralData = new BCTermGeneralData();
        bCTermGeneralData.distance = new FloatBaseType((float)bCLongTermGeneralData.getDistance().getDistanceValue(), bCLongTermGeneralData.getDistance().getDistanceUnit(), bCLongTermGeneralData.getDistance().getDistanceValueState());
        bCTermGeneralData.speed = new FloatBaseType(bCLongTermGeneralData.getSpeed().getSpeedValue(), bCLongTermGeneralData.getSpeed().getSpeedUnit(), bCLongTermGeneralData.getSpeed().getSpeedValueState());
        try {
            this.logger.log(-2137614336, "Send update to devices -> updateBCLongTermGeneral: %1", (Object)bCLongTermGeneralData);
            this.toSDISBordComputer.updateBCLongTermGeneral(bCTermGeneralData);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateBCLongTermGeneral] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateBCCurrentRange1(CarBCCurrentRange carBCCurrentRange, int n) {
        if (n != 1) {
            return;
        }
        IntBaseType intBaseType = new IntBaseType(carBCCurrentRange.getCurrentRangeValue(), carBCCurrentRange.getCurrentRangeUnit(), carBCCurrentRange.getState());
        try {
            this.logger.log(-2137614336, "Send update to devices -> updateBCCurrentRange1: %1", (Object)carBCCurrentRange);
            this.toSDISBordComputer.updateBCCurrentRange1(intBaseType);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateBCCurrentRange1] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateBCCurrentRange2(CarBCCurrentRange carBCCurrentRange, int n) {
        if (n != 1) {
            return;
        }
        IntBaseType intBaseType = new IntBaseType(carBCCurrentRange.getCurrentRangeValue(), carBCCurrentRange.getCurrentRangeUnit(), carBCCurrentRange.getState());
        try {
            this.logger.log(-2137614336, "Send update to devices -> updateBCCurrentRange2: %1", (Object)carBCCurrentRange);
            this.toSDISBordComputer.updateBCCurrentRange2(intBaseType);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateBCCurrentRange2] %1", (Throwable)methodException);
        }
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        this.dsi = (DSICarKombi)dSIBase;
        this.dsi.setNotification(attributes, (DSIListener)this);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ISDISFramework access$200(CarKombiComponent carKombiComponent) {
        return carKombiComponent.baseService;
    }

    static /* synthetic */ String[] access$300() {
        return entryToText;
    }

    static /* synthetic */ void access$400(CarKombiComponent carKombiComponent, int n) {
        carKombiComponent.sendUpdateSIAOilInspectionVisibilityState(n);
    }

    static /* synthetic */ void access$500(CarKombiComponent carKombiComponent, int n) {
        carKombiComponent.sendUpdateSIAServiceDataVisibilityState(n);
    }

    static /* synthetic */ int[] access$600(CarKombiComponent carKombiComponent) {
        return carKombiComponent.latestSentBCVisibility;
    }

    static /* synthetic */ void access$700(CarKombiComponent carKombiComponent, int n) {
        carKombiComponent.sendUpdateBCVisibilityState(n);
    }

    static {
        entryToText = new String[]{"SIA_OIL_VISIBLITY", "SIA_OIL_VISIBLITY", "BC_SHORT_TERM_AVG_CONSUMP_VISIBLITY", "BC_SHORT_TERM_AVG_CONSUMP2_VISIBLITY", "BC_SHORT_TERM_GENERAL_VISIBLITY", "BC_LONG_TERM_AVG_CONSUMP1_VISIBLITY", "BC_LONG_TERM_AVG_CONSUMP2_VISIBLITY", "BC_LONG_TERM_GENERAL_VISIBLITY", "BC_CURRENT_RANGE1_VISIBLITY", "BC_CURRENT_RANGE2_VISIBLITY"};
        CODING = new byte[]{13, 10};
        attributes = new int[]{1, 3, 2, 4, 11, 12, 13, 14, 15, 16, 8, 9};
    }
}

