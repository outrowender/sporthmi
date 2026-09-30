/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.core.comfort.IRDKTireDisplay;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.BufferedListModel;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.MetricsListCell;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.Pressure;
import de.audi.atip.metrics.Speed;
import de.audi.atip.metrics.Temperature;
import org.dsi.ifc.carcomfort.RDKTireDisplayData;
import org.dsi.ifc.carcomfort.RDKTireInfo;
import org.dsi.ifc.carcomfort.RDKWheelPressures;
import org.dsi.ifc.carcomfort.RDKWheelStates;
import org.dsi.ifc.carcomfort.RDKWheelTemperatures;

public class DefaultRDKTireDisplay
implements IRDKTireDisplay {
    protected static final int INVALID_VALUE = -1;
    private static final int INVALID_PRESSURE_VALUE = 32768;
    protected static final int L0_ROW_ACTUAL_PRESSURE_FL = 0;
    protected static final int L0_ROW_ACTUAL_PRESSURE_FR = 1;
    protected static final int L0_ROW_ACTUAL_PRESSURE_RL = 2;
    protected static final int L0_ROW_ACTUAL_PRESSURE_RR = 3;
    protected static final int L0_ROW_ACTUAL_PRESSURE_SW = 4;
    protected static final int L0_ROW_TARGET_PRESSURE_FL = 5;
    protected static final int L0_ROW_TARGET_PRESSURE_FR = 6;
    protected static final int L0_ROW_TARGET_PRESSURE_RL = 7;
    protected static final int L0_ROW_TARGET_PRESSURE_RR = 8;
    protected static final int L0_ROW_TARGET_PRESSURE_SW = 9;
    protected static final int TIRE_PRESSURE_MONITOR_DATA_LIST_SIZE = 10;
    protected static final int L1_ROW_ACTUAL_TEMPERATURE_FL = 0;
    protected static final int L1_ROW_ACTUAL_TEMPERATURE_FR = 1;
    protected static final int L1_ROW_ACTUAL_TEMPERATURE_RL = 2;
    protected static final int L1_ROW_ACTUAL_TEMPERATURE_RR = 3;
    protected static final int L1_ROW_ACTUAL_TEMPERATURE_SW = 4;
    protected static final int TIRE_TEMPERATURE_MONITOR_DATA_LIST_SIZE = 5;
    protected static final int L2_ROW_STATE_FL = 0;
    protected static final int L2_ROW_STATE_FR = 1;
    protected static final int L2_ROW_STATE_RL = 2;
    protected static final int L2_ROW_STATE_RR = 3;
    protected static final int L2_ROW_STATE_SW = 4;
    protected static final int TIRE_STATE_MONITOR_DATA_LIST_SIZE = 5;
    private static final int RDK_WHEELSTATE_OK = 0;
    private static final int RDK_WHEELSTATE_NOT_DISPLAYED = 1;
    private static final int RDK_WHEELSTATE_LOW_WARNING = 2;
    private static final int RDK_WHEELSTATE_HARD_WARNING = 3;
    private static final int RDK_WHEELSTATE_BREAKDOWN = 4;
    private static final int RDK_WHEELSTATE_UNKNOWN = 5;
    private static final int RDK_WHEELSTATE_WHEELCHANGED = 6;
    private static final int RDK_WHEELSTATE_PARTLOADOBSERVED = 7;
    private static final int RDK_WHEELSTATE_FULLLOADOBSERVED = 8;
    private static final int RDK_WHEELSTATE_FASTFORPRESSURE = 9;
    private static final int RDK_WHEELSTATE_FASTFORWHEEL = 10;
    private static final int RDK_WHEELSTATE_CHANGE_SWITCH_PRESS_LONGER = 11;
    private static final int RDK_WHEELSTATE_SWITCH_PRESS_LONGER = 12;
    private static final int RDK_WHEELSTATE_CHANGE_PRESS_LONGER = 13;
    private static final int RDK_WHEELSTATE_NOT_OK = 14;
    private static final int RDK_WHEELSTATE_LEARNING_ABOVE_SPEEDLEVEL = 15;
    private static final int RDK_WHEELSTATE_LEARNING_STATE = 16;
    private static final int RDK_WHEELSTATE_RACETRACK_MODE = 17;
    private static final int RDK_WHEELSTATE_LEARNING_REQUIRED = 18;
    private static final int RDK_WHEELSTATE_LEARNING_MODE = 19;
    private static final int RDK_WHEELSTATE_CUSTOM_MODE = 20;
    private static final int RDK_WHEELSTATE_OVER_TEMPERATURE = 21;
    private static final int RDK_WHEELSTATE_OVER_PRESSURE = 22;
    private static final int RDK_WHEELSTATE_PRESSURE_STORED = 23;
    private static final int RDK_WHEELSTATE_BATTERY_LOW = 24;
    private static final int RDK_WHEELTYPE_UNKNOWN = 0;
    private static final int RDK_WHEELTYPE_WINTER = 1;
    private static final int RDK_WHEELTYPE_SUMMER = 2;
    private static final int RDK_WHEELTYPE_ALLSEASON = 3;
    private static final int RDK_WHEELTYPE_CUSTOM = 4;
    private static final int TIRE_SELECTION_DATA_LIST_COLUMN_POSITION = 0;
    private static final int TIRE_SELECTION_DATA_LIST_COLUMN_VENDORNAME = 1;
    private static final int TIRE_SELECTION_DATA_LIST_COLUMN_WHEELSIZE = 2;
    private static final int TIRE_SELECTION_DATA_LIST_COLUMN_WHEELTYPE = 3;
    private static final int TIRE_SELECTION_DATA_LIST_COLUMN_SELECTION = 4;
    private final int[] wheelStateDSIMappingTable = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    protected final IFrameworkAccess frameworkAccess;
    protected final LogChannel logChannel;
    protected BufferedListModel tirePressureMonitorDataListModel;
    protected BufferedListModel tireTemperatureMonitorDataListModel;
    protected BufferedListModel tireStateMonitorDataListModel;
    protected MetricsModelApp tirePressureActualFLMetricsModel;
    protected MetricsModelApp tirePressureActualFRMetricsModel;
    protected MetricsModelApp tirePressureActualRLMetricsModel;
    protected MetricsModelApp tirePressureActualRRMetricsModel;
    protected MetricsModelApp tirePressureActualSWMetricsModel;
    protected MetricsModelApp tirePressureRequiredFLMetricsModel;
    protected MetricsModelApp tirePressureRequiredFRMetricsModel;
    protected MetricsModelApp tirePressureRequiredRLMetricsModel;
    protected MetricsModelApp tirePressureRequiredRRMetricsModel;
    protected MetricsModelApp tirePressureRequiredSWMetricsModel;
    protected MetricsModelApp tirePressureDifferenceFLMetricsModel;
    protected MetricsModelApp tirePressureDifferenceFRMetricsModel;
    protected MetricsModelApp tirePressureDifferenceRLMetricsModel;
    protected MetricsModelApp tirePressureDifferenceRRMetricsModel;
    protected MetricsModelApp tirePressureDifferenceSWMetricsModel;
    protected ChoiceModelApp tirePressureStateFLChoiceModel;
    protected ChoiceModelApp tirePressureStateFRChoiceModel;
    protected ChoiceModelApp tirePressureStateRLChoiceModel;
    protected ChoiceModelApp tirePressureStateRRChoiceModel;
    protected ChoiceModelApp tirePressureStateSWChoiceModel;
    protected ChoiceModelApp tireCollectedStateChoiceModel;
    protected BaseListModelApp tireSelectionDataListModel;
    protected ChoiceModelApp tireSelectionDataListSelectionChoiceModel;
    protected LabelModelApp wheelSizeDataLabelModel;
    protected ChoiceModelApp wheelTypeDataChoiceModel;
    protected MetricsModelApp tireInfoSpeedLimit1MetricsModel;
    protected MetricsModelApp tireInfoSpeedLimit2MetricsModel;
    protected MetricsModelApp tireInfoSpeedLimit3MetricsModel;
    protected MetricsModelApp tireInfoFrontPressure1MetricsModel;
    protected MetricsModelApp tireInfoFrontPressure2MetricsModel;
    protected MetricsModelApp tireInfoFrontPressure3MetricsModel;
    protected MetricsModelApp tireInfoFrontPressure4MetricsModel;
    protected MetricsModelApp tireInfoRearPressure1MetricsModel;
    protected MetricsModelApp tireInfoRearPressure2MetricsModel;
    protected MetricsModelApp tireInfoRearPressure3MetricsModel;
    protected MetricsModelApp tireInfoRearPressure4MetricsModel;
    protected volatile RDKTireInfo[] currentTireList;
    protected volatile int currentTireSelectionHMIValue = -1;
    protected volatile int currentTireSelectionDSIValue = -1;
    private boolean useInstanceUnit = false;

    public DefaultRDKTireDisplay(IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        this.frameworkAccess = iFrameworkAccess;
        this.logChannel = logChannel;
    }

    public boolean isUseInstanceUnit() {
        return this.useInstanceUnit;
    }

    public void setUseInstanceUnit(boolean bl) {
        this.useInstanceUnit = bl;
    }

    public RDKTireInfo getSelectedTireInfo() {
        if (null != this.currentTireList && 0 < this.currentTireList.length && -1 != this.currentTireSelectionHMIValue && 0 <= this.currentTireSelectionHMIValue && this.currentTireSelectionHMIValue < this.currentTireList.length) {
            return this.currentTireList[this.currentTireSelectionHMIValue];
        }
        return null;
    }

    protected void updateCollectedStateData(int n) {
        this.tireCollectedStateChoiceModel.setValue(n);
        this.frameworkAccess.getHmiServiceApp().getChoiceModel(601257).setValue(1 == n ? 0 : 1);
    }

    protected void updatePressureData(RDKWheelPressures rDKWheelPressures, RDKWheelPressures rDKWheelPressures2) {
        int n = this.getPressureUnitValue(rDKWheelPressures.getPressureUnit());
        if (-1 == n) {
            this.logChannel.log(100000, "[DefaultRDKTireDisplay#updatePressureData] Invalid actual pressure unit: %1, update ignored.", (long)rDKWheelPressures.getPressureUnit());
            return;
        }
        int n2 = this.getPressureUnitValue(rDKWheelPressures2.getPressureUnit());
        if (-1 == n2) {
            this.logChannel.log(100000, "[DefaultRDKTireDisplay#updatePressureData] Invalid target pressure unit: %1, update ignored.", (long)rDKWheelPressures2.getPressureUnit());
            return;
        }
        Pressure pressure = this.calculatePressure(rDKWheelPressures.getFrontLeft(), n);
        pressure.setMetricValid(32768 != rDKWheelPressures.getFrontLeft());
        Pressure pressure2 = this.calculatePressure(rDKWheelPressures.getFrontRight(), n);
        pressure2.setMetricValid(32768 != rDKWheelPressures.getFrontRight());
        Pressure pressure3 = this.calculatePressure(rDKWheelPressures.getRearLeft(), n);
        pressure3.setMetricValid(32768 != rDKWheelPressures.getRearLeft());
        Pressure pressure4 = this.calculatePressure(rDKWheelPressures.getRearRight(), n);
        pressure4.setMetricValid(32768 != rDKWheelPressures.getRearRight());
        Pressure pressure5 = this.calculatePressure(rDKWheelPressures.getSpareWheel(), n);
        pressure5.setMetricValid(32768 != rDKWheelPressures.getSpareWheel());
        Pressure pressure6 = this.calculatePressure(rDKWheelPressures2.getFrontLeft(), n2);
        pressure6.setMetricValid(32768 != rDKWheelPressures2.getFrontLeft());
        Pressure pressure7 = this.calculatePressure(rDKWheelPressures2.getFrontRight(), n2);
        pressure7.setMetricValid(32768 != rDKWheelPressures2.getFrontRight());
        Pressure pressure8 = this.calculatePressure(rDKWheelPressures2.getRearLeft(), n2);
        pressure8.setMetricValid(32768 != rDKWheelPressures2.getRearLeft());
        Pressure pressure9 = this.calculatePressure(rDKWheelPressures2.getRearRight(), n2);
        pressure9.setMetricValid(32768 != rDKWheelPressures2.getRearRight());
        Pressure pressure10 = this.calculatePressure(rDKWheelPressures2.getSpareWheel(), n2);
        pressure10.setMetricValid(32768 != rDKWheelPressures2.getSpareWheel());
        this.setListData(this.tirePressureMonitorDataListModel, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new AbstractMetrics[]{pressure, pressure2, pressure3, pressure4, pressure5, pressure6, pressure7, pressure8, pressure9, pressure10});
        this.tirePressureActualFLMetricsModel.setMetric(pressure);
        this.tirePressureActualFRMetricsModel.setMetric(pressure2);
        this.tirePressureActualRLMetricsModel.setMetric(pressure3);
        this.tirePressureActualRRMetricsModel.setMetric(pressure4);
        this.tirePressureActualSWMetricsModel.setMetric(pressure5);
        this.tirePressureRequiredFLMetricsModel.setMetric(pressure6);
        this.tirePressureRequiredFRMetricsModel.setMetric(pressure7);
        this.tirePressureRequiredRLMetricsModel.setMetric(pressure8);
        this.tirePressureRequiredRRMetricsModel.setMetric(pressure9);
        this.tirePressureRequiredSWMetricsModel.setMetric(pressure10);
    }

    protected void updateDifferentialPressureData(RDKWheelPressures rDKWheelPressures) {
        int n = this.getPressureUnitValue(rDKWheelPressures.getPressureUnit());
        if (-1 == n) {
            this.logChannel.log(100000, "[DefaultRDKTireDisplay#updatePressureData] Invalid pressure unit: %1, update ignored.", (long)rDKWheelPressures.getPressureUnit());
            return;
        }
        Pressure pressure = this.calculatePressure(rDKWheelPressures.getFrontLeft(), n);
        pressure.setMetricValid(32768 != rDKWheelPressures.getFrontLeft());
        Pressure pressure2 = this.calculatePressure(rDKWheelPressures.getFrontRight(), n);
        pressure2.setMetricValid(32768 != rDKWheelPressures.getFrontRight());
        Pressure pressure3 = this.calculatePressure(rDKWheelPressures.getRearLeft(), n);
        pressure3.setMetricValid(32768 != rDKWheelPressures.getRearLeft());
        Pressure pressure4 = this.calculatePressure(rDKWheelPressures.getRearRight(), n);
        pressure4.setMetricValid(32768 != rDKWheelPressures.getRearRight());
        Pressure pressure5 = this.calculatePressure(rDKWheelPressures.getSpareWheel(), n);
        pressure5.setMetricValid(32768 != rDKWheelPressures.getSpareWheel());
        this.tirePressureDifferenceFLMetricsModel.setMetric(pressure);
        this.tirePressureDifferenceFRMetricsModel.setMetric(pressure2);
        this.tirePressureDifferenceRLMetricsModel.setMetric(pressure3);
        this.tirePressureDifferenceRRMetricsModel.setMetric(pressure4);
        this.tirePressureDifferenceSWMetricsModel.setMetric(pressure5);
    }

    protected void updateStateData(RDKWheelStates rDKWheelStates) {
        int n = this.getWheelStateValue(rDKWheelStates.getFrontLeft());
        int n2 = this.getWheelStateValue(rDKWheelStates.getFrontRight());
        int n3 = this.getWheelStateValue(rDKWheelStates.getRearLeft());
        int n4 = this.getWheelStateValue(rDKWheelStates.getRearRight());
        int n5 = this.getWheelStateValue(rDKWheelStates.getSpareWheel());
        this.setListData(this.tireStateMonitorDataListModel, new int[][]{{0, n}, {1, n2}, {2, n3}, {3, n4}, {4, n5}});
        this.tirePressureStateFLChoiceModel.setValue(n);
        this.tirePressureStateFRChoiceModel.setValue(n2);
        this.tirePressureStateRLChoiceModel.setValue(n3);
        this.tirePressureStateRRChoiceModel.setValue(n4);
        this.tirePressureStateSWChoiceModel.setValue(n5);
    }

    protected void updateTemperatureData(RDKWheelTemperatures rDKWheelTemperatures) {
        int n = this.getTemperatureUnitValue(rDKWheelTemperatures.getTemperatureUnit());
        if (-1 == n) {
            this.logChannel.log(100000, "[DefaultRDKTireDisplay#updateTemperatureData] Invalid temperature unit: %1, update ignored.", (long)rDKWheelTemperatures.getTemperatureUnit());
            return;
        }
        Temperature temperature = this.calculateTemperature(rDKWheelTemperatures.getFrontLeft(), n);
        Temperature temperature2 = this.calculateTemperature(rDKWheelTemperatures.getFrontRight(), n);
        Temperature temperature3 = this.calculateTemperature(rDKWheelTemperatures.getRearLeft(), n);
        Temperature temperature4 = this.calculateTemperature(rDKWheelTemperatures.getRearRight(), n);
        Temperature temperature5 = this.calculateTemperature(rDKWheelTemperatures.getSpareWheel(), n);
        this.setListData(this.tireTemperatureMonitorDataListModel, new int[]{0, 1, 2, 3, 4}, new AbstractMetrics[]{temperature, temperature2, temperature3, temperature4, temperature5});
    }

    protected void updateColdTirePressuresData(RDKTireInfo rDKTireInfo) {
        int n = this.getSpeedUnitValue(rDKTireInfo.getSpeedLimit1().getSpeedUnit());
        if (-1 == n) {
            this.logChannel.log(100000, "[DefaultRDKTireDisplay#updateColdTirePressuresData] Invalid temperature unit: %1, update ignored.", (long)rDKTireInfo.getSpeedLimit1().getSpeedUnit());
            return;
        }
        int n2 = this.getSpeedUnitValue(rDKTireInfo.getSpeedLimit2().getSpeedUnit());
        if (-1 == n2) {
            this.logChannel.log(100000, "[DefaultRDKTireDisplay#updateColdTirePressuresData] Invalid temperature unit: %1, update ignored.", (long)rDKTireInfo.getSpeedLimit2().getSpeedUnit());
            return;
        }
        int n3 = this.getSpeedUnitValue(rDKTireInfo.getSpeedLimit3().getSpeedUnit());
        if (-1 == n3) {
            this.logChannel.log(100000, "[DefaultRDKTireDisplay#updateColdTirePressuresData] Invalid temperature unit: %1, update ignored.", (long)rDKTireInfo.getSpeedLimit3().getSpeedUnit());
            return;
        }
        int n4 = this.getPressureUnitValue(rDKTireInfo.getPressureUnit());
        if (-1 == n4) {
            this.logChannel.log(100000, "[DefaultRDKTireDisplay#updateColdTirePressuresData] Invalid pressure unit: %1, update ignored.", (long)rDKTireInfo.getPressureUnit());
            return;
        }
        Speed speed = this.calculateSpeed(rDKTireInfo.getSpeedLimit1().getSpeedValue(), n);
        int n5 = 0 == rDKTireInfo.getSpeedLimit1().getState() && 0 != rDKTireInfo.getSpeedLimit1().getSpeedValue() ? 1 : 0;
        Speed speed2 = this.calculateSpeed(rDKTireInfo.getSpeedLimit2().getSpeedValue(), n2);
        int n6 = 0 == rDKTireInfo.getSpeedLimit2().getState() && 0 != rDKTireInfo.getSpeedLimit2().getSpeedValue() ? 1 : 0;
        Speed speed3 = this.calculateSpeed(rDKTireInfo.getSpeedLimit3().getSpeedValue(), n3);
        int n7 = 0 == rDKTireInfo.getSpeedLimit3().getState() && 0 != rDKTireInfo.getSpeedLimit3().getSpeedValue() ? 1 : 0;
        this.tireInfoSpeedLimit1MetricsModel.setMetric(speed);
        this.tireInfoSpeedLimit1MetricsModel.setStatus(n5);
        this.tireInfoSpeedLimit2MetricsModel.setMetric(speed2);
        this.tireInfoSpeedLimit2MetricsModel.setStatus(n6);
        this.tireInfoSpeedLimit3MetricsModel.setMetric(speed3);
        this.tireInfoSpeedLimit3MetricsModel.setStatus(n7);
        Pressure pressure = this.calculatePressure(rDKTireInfo.getFrontPressure1(), n4);
        Pressure pressure2 = this.calculatePressure(rDKTireInfo.getFrontPressure2(), n4);
        Pressure pressure3 = this.calculatePressure(rDKTireInfo.getFrontPressure3(), n4);
        Pressure pressure4 = this.calculatePressure(rDKTireInfo.getFrontPressure4(), n4);
        Pressure pressure5 = this.calculatePressure(rDKTireInfo.getRearPressure1(), n4);
        Pressure pressure6 = this.calculatePressure(rDKTireInfo.getRearPressure2(), n4);
        Pressure pressure7 = this.calculatePressure(rDKTireInfo.getRearPressure3(), n4);
        Pressure pressure8 = this.calculatePressure(rDKTireInfo.getRearPressure4(), n4);
        this.tireInfoFrontPressure1MetricsModel.setMetric(pressure);
        this.tireInfoFrontPressure2MetricsModel.setMetric(pressure2);
        this.tireInfoFrontPressure3MetricsModel.setMetric(pressure3);
        this.tireInfoFrontPressure4MetricsModel.setMetric(pressure4);
        this.tireInfoRearPressure1MetricsModel.setMetric(pressure5);
        this.tireInfoRearPressure2MetricsModel.setMetric(pressure6);
        this.tireInfoRearPressure3MetricsModel.setMetric(pressure7);
        this.tireInfoRearPressure4MetricsModel.setMetric(pressure8);
    }

    protected void updateTireSelectionData(RDKTireInfo[] rDKTireInfoArray) {
        if (null != rDKTireInfoArray && 0 < rDKTireInfoArray.length) {
            try {
                this.tireSelectionDataListModel.setLength(rDKTireInfoArray.length);
                for (int i2 = 0; i2 < rDKTireInfoArray.length; ++i2) {
                    EvoListRow evoListRow;
                    if (i2 < rDKTireInfoArray.length) {
                        evoListRow = new EvoListRow(i2, 5);
                        evoListRow.setInteger(0, rDKTireInfoArray[i2].getPosition());
                        evoListRow.setText(1, rDKTireInfoArray[i2].getVendorName());
                        evoListRow.setText(2, rDKTireInfoArray[i2].getWheelSize());
                        evoListRow.setInteger(3, this.getWheelTypeValue(rDKTireInfoArray[i2].getWheelType()));
                        evoListRow.setInteger(4, 0);
                        this.tireSelectionDataListModel.setRow(i2, evoListRow);
                        continue;
                    }
                    evoListRow = new EvoListRow(i2, 5);
                    evoListRow.setInteger(0, i2);
                    evoListRow.setText(1, "");
                    evoListRow.setText(2, "");
                    evoListRow.setInteger(3, 0);
                    evoListRow.setInteger(4, 0);
                    this.tireSelectionDataListModel.setRow(i2, evoListRow);
                }
            }
            catch (Exception exception) {
                this.logChannel.log(1000, "[DefaultRDKTireDisplay#updateTireSelectionData] exception occured!", (Throwable)exception);
            }
        } else if (0 == rDKTireInfoArray.length) {
            this.tireSelectionDataListModel.setLength(0);
        } else {
            this.logChannel.log(100000, "[DefaultRDKTireDisplay#updateTireSelectionData] Invalid list size: %1", (long)rDKTireInfoArray.length);
        }
    }

    protected int getWheelStateValue(int n) {
        return this.wheelStateDSIMappingTable[n];
    }

    protected int getWheelTypeValue(int n) {
        switch (n) {
            case 255: {
                return 0;
            }
            case 0: {
                return 1;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 3;
            }
            case 3: {
                return 4;
            }
        }
        return 0;
    }

    protected int getPressureUnitValue(int n) {
        switch (n) {
            case 0: {
                return 1;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 3;
            }
        }
        return -1;
    }

    protected int getSpeedUnitValue(int n) {
        switch (n) {
            case 0: {
                return 1;
            }
            case 1: {
                return 2;
            }
        }
        return -1;
    }

    protected int getTemperatureUnitValue(int n) {
        switch (n) {
            case 0: {
                return 1;
            }
            case 1: {
                return 2;
            }
        }
        return -1;
    }

    protected Pressure calculatePressure(int n, int n2) {
        switch (n2) {
            case 1: {
                float f2 = (float)n * 0.1f;
                Pressure pressure = new Pressure(f2, n2);
                pressure.setUseInstanceUnit(this.useInstanceUnit);
                return pressure;
            }
            case 2: {
                float f3 = (float)Math.round((float)n / 2.0f / 0.5f) * 0.5f;
                Pressure pressure = new Pressure(f3, n2);
                pressure.setUseInstanceUnit(this.useInstanceUnit);
                return pressure;
            }
            case 3: {
                float f4 = n * 10;
                Pressure pressure = new Pressure(f4, n2);
                pressure.setUseInstanceUnit(this.useInstanceUnit);
                return pressure;
            }
        }
        return null;
    }

    protected Pressure calculatePressureDifference(int n, int n2, int n3) {
        int n4 = n2 - n;
        switch (n3) {
            case 1: {
                float f2 = (float)n4 * 0.1f;
                Pressure pressure = new Pressure(f2, n3);
                pressure.setUseInstanceUnit(this.useInstanceUnit);
                return pressure;
            }
            case 2: {
                float f3 = (float)Math.round((float)n4 / 2.0f / 0.5f) * 0.5f;
                Pressure pressure = new Pressure(f3, n3);
                pressure.setUseInstanceUnit(this.useInstanceUnit);
                return pressure;
            }
            case 3: {
                float f4 = n4 * 10;
                Pressure pressure = new Pressure(f4, n3);
                pressure.setUseInstanceUnit(this.useInstanceUnit);
                return pressure;
            }
        }
        return null;
    }

    protected Temperature calculateTemperature(int n, int n2) {
        switch (n2) {
            case 1: {
                Temperature temperature = new Temperature(n, n2);
                temperature.setUseInstanceUnit(this.useInstanceUnit);
                return temperature;
            }
            case 2: {
                Temperature temperature = new Temperature(n, n2);
                temperature.setUseInstanceUnit(this.useInstanceUnit);
                return temperature;
            }
        }
        return null;
    }

    protected Speed calculateSpeed(int n, int n2) {
        Speed speed;
        switch (n2) {
            case 1: 
            case 2: {
                speed = new Speed(n, n2);
                speed.setUseInstanceUnit(this.useInstanceUnit);
                break;
            }
            default: {
                speed = null;
            }
        }
        return speed;
    }

    public void initialize() {
        int n;
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1000000, "[DefaultRDKTireDisplay#initialize] called.");
        }
        this.tirePressureMonitorDataListModel = (BufferedListModel)this.frameworkAccess.getHmiServiceApp().getListModel(601689);
        this.tirePressureMonitorDataListModel.setMaxColumns(1);
        this.tirePressureMonitorDataListModel.setMaxRows(10);
        for (n = 0; n < 10; ++n) {
            this.tirePressureMonitorDataListModel.addRow(new MetricsListCell(new Pressure(0.0f, 1)));
        }
        this.tirePressureActualFLMetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(601970);
        this.tirePressureActualFLMetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tirePressureActualFRMetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(601976);
        this.tirePressureActualFRMetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tirePressureActualRLMetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(602394);
        this.tirePressureActualRLMetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tirePressureActualRRMetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(602363);
        this.tirePressureActualRRMetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tirePressureActualSWMetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(601972);
        this.tirePressureActualSWMetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tirePressureRequiredFLMetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(601975);
        this.tirePressureRequiredFLMetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tirePressureRequiredFRMetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(601973);
        this.tirePressureRequiredFRMetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tirePressureRequiredRLMetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(601978);
        this.tirePressureRequiredRLMetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tirePressureRequiredRRMetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(601974);
        this.tirePressureRequiredRRMetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tirePressureRequiredSWMetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(601979);
        this.tirePressureRequiredSWMetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tirePressureDifferenceFLMetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(601953);
        this.tirePressureDifferenceFLMetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tirePressureDifferenceFRMetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(602380);
        this.tirePressureDifferenceFRMetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tirePressureDifferenceRLMetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(601960);
        this.tirePressureDifferenceRLMetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tirePressureDifferenceRRMetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(602360);
        this.tirePressureDifferenceRRMetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tirePressureDifferenceSWMetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(601957);
        this.tirePressureDifferenceSWMetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tirePressureStateFLChoiceModel = this.frameworkAccess.getHmiServiceApp().getChoiceModel(602375);
        this.tirePressureStateFLChoiceModel.setValue(5);
        this.tirePressureStateFRChoiceModel = this.frameworkAccess.getHmiServiceApp().getChoiceModel(602362);
        this.tirePressureStateFRChoiceModel.setValue(5);
        this.tirePressureStateRLChoiceModel = this.frameworkAccess.getHmiServiceApp().getChoiceModel(601959);
        this.tirePressureStateRLChoiceModel.setValue(5);
        this.tirePressureStateRRChoiceModel = this.frameworkAccess.getHmiServiceApp().getChoiceModel(601954);
        this.tirePressureStateRRChoiceModel.setValue(5);
        this.tirePressureStateSWChoiceModel = this.frameworkAccess.getHmiServiceApp().getChoiceModel(601958);
        this.tirePressureStateSWChoiceModel.setValue(5);
        this.tireCollectedStateChoiceModel = this.frameworkAccess.getHmiServiceApp().getChoiceModel(601984);
        this.tireCollectedStateChoiceModel.setValue(5);
        this.tireTemperatureMonitorDataListModel = (BufferedListModel)this.frameworkAccess.getHmiServiceApp().getListModel(601699);
        this.tireTemperatureMonitorDataListModel.setMaxColumns(1);
        this.tireTemperatureMonitorDataListModel.setMaxRows(5);
        for (n = 0; n < 5; ++n) {
            this.tireTemperatureMonitorDataListModel.addRow(new MetricsListCell(new Temperature(0.0f, 1)));
        }
        this.tireStateMonitorDataListModel = (BufferedListModel)this.frameworkAccess.getHmiServiceApp().getListModel(601692);
        this.tireStateMonitorDataListModel.setMaxColumns(1);
        this.tireStateMonitorDataListModel.setMaxRows(5);
        for (n = 0; n < 5; ++n) {
            this.tireStateMonitorDataListModel.addRow(IntegerListCell.create(5));
        }
        this.tireInfoSpeedLimit1MetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(601694);
        this.tireInfoSpeedLimit1MetricsModel.setMetric(new Speed(0.0f, 1));
        this.tireInfoSpeedLimit2MetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(601700);
        this.tireInfoSpeedLimit2MetricsModel.setMetric(new Speed(0.0f, 1));
        this.tireInfoSpeedLimit3MetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(601690);
        this.tireInfoSpeedLimit3MetricsModel.setMetric(new Speed(0.0f, 1));
        this.tireInfoFrontPressure1MetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(601696);
        this.tireInfoFrontPressure1MetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tireInfoFrontPressure2MetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(601695);
        this.tireInfoFrontPressure2MetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tireInfoFrontPressure3MetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(601698);
        this.tireInfoFrontPressure3MetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tireInfoFrontPressure4MetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(602370);
        this.tireInfoFrontPressure4MetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tireInfoRearPressure1MetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(601693);
        this.tireInfoRearPressure1MetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tireInfoRearPressure2MetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(601697);
        this.tireInfoRearPressure2MetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tireInfoRearPressure3MetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(601691);
        this.tireInfoRearPressure3MetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tireInfoRearPressure4MetricsModel = this.frameworkAccess.getHmiServiceApp().getMetricsModel(601947);
        this.tireInfoRearPressure4MetricsModel.setMetric(new Pressure(0.0f, 1));
        this.tireSelectionDataListModel = this.frameworkAccess.getHmiServiceApp().getBaseListModel(601718);
        this.tireSelectionDataListModel.setLength(0);
        this.tireSelectionDataListSelectionChoiceModel = this.frameworkAccess.getHmiServiceApp().getChoiceModel(601688);
        this.tireSelectionDataListSelectionChoiceModel.setValue(-1);
        this.wheelSizeDataLabelModel = this.frameworkAccess.getHmiServiceApp().getLabelModel(601684);
        this.wheelTypeDataChoiceModel = this.frameworkAccess.getHmiServiceApp().getChoiceModel(601685);
    }

    public void updateDisplayData(RDKTireDisplayData rDKTireDisplayData) {
        if (null != rDKTireDisplayData) {
            this.updateCollectedStateData(rDKTireDisplayData.getWheelStates().getCollectedState());
            this.updatePressureData(rDKTireDisplayData.getWheelPressures(), rDKTireDisplayData.getRequiredWheelPressures());
            this.updateStateData(rDKTireDisplayData.getWheelStates());
            this.updateTemperatureData(rDKTireDisplayData.getWheelTemperatures());
        } else {
            this.logChannel.log(1000, "[DefaultRDKTireDisplay#updateDisplayData] dataContainer='null'.");
        }
    }

    public void updateTireSetupTireList(RDKTireInfo[] rDKTireInfoArray) {
        if (null == rDKTireInfoArray || 0 == rDKTireInfoArray.length) {
            this.currentTireList = new RDKTireInfo[0];
            this.currentTireSelectionHMIValue = -1;
        } else {
            this.currentTireList = rDKTireInfoArray;
        }
        this.updateTireSelectionData(rDKTireInfoArray);
        this.updateTireSetupSelectedTire(this.currentTireSelectionDSIValue);
    }

    public void updateTireSetupSelectedTire(int n) {
        if (-1 == n) {
            return;
        }
        this.currentTireSelectionDSIValue = n;
        int n2 = -1;
        if (null != this.currentTireList) {
            for (int i2 = 0; i2 < this.currentTireList.length; ++i2) {
                if (n != this.currentTireList[i2].getPosition()) continue;
                n2 = i2;
                break;
            }
        }
        this.currentTireSelectionHMIValue = n2;
        if (-1 == n2) {
            this.logChannel.log(100000, "[DefaultRDKTireDisplay#updateTireSetupSelectedTire] Invalid position: '%1'", (long)n);
            return;
        }
        if (null != this.currentTireList) {
            if (0 <= this.currentTireSelectionHMIValue && this.currentTireSelectionHMIValue < this.currentTireList.length) {
                this.updateColdTirePressuresData(this.currentTireList[this.currentTireSelectionHMIValue]);
                this.setSelectedIndexForTireSelectionData(this.currentTireSelectionHMIValue);
                this.wheelSizeDataLabelModel.setText(this.currentTireList[this.currentTireSelectionHMIValue].getWheelSize());
                this.wheelTypeDataChoiceModel.setValue(this.getWheelTypeValue(this.currentTireList[this.currentTireSelectionHMIValue].getWheelType()));
            } else if (0 == this.currentTireList.length) {
                this.setSelectedIndexForTireSelectionData(-1);
            } else {
                this.logChannel.log(1000, "[DefaultRDKTireDisplay#updateTireSetupSelectedTire] selection out of bound: position='%1', tireListSize='%2'", (long)this.currentTireSelectionHMIValue, (long)this.currentTireList.length);
            }
        } else {
            this.logChannel.log(1000, "[DefaultRDKTireDisplay#updateTireSetupSelectedTire] currentTireList='null'.");
        }
    }

    public void updateSpeedLimit(int n) {
    }

    public void updateDifferentialPressure(RDKWheelPressures rDKWheelPressures) {
        if (null != rDKWheelPressures) {
            this.updateDifferentialPressureData(rDKWheelPressures);
        } else {
            this.logChannel.log(1000, "[DefaultRDKTireDisplay#updateDifferentialPressure] wheelPressures='null'.");
        }
    }

    private void setSelectedIndexForTireSelectionData(int n) {
        if (null != this.currentTireList) {
            int n2;
            if (-1 <= n && n < this.currentTireList.length) {
                n2 = n;
            } else if (0 == this.currentTireList.length) {
                n2 = -1;
            } else {
                this.logChannel.log(1000, "[DefaultRDKTireDisplay#setSelectedIndexForTireSelectionData] index out of bound: index='%1', tireListSize='%2'", (long)this.currentTireSelectionHMIValue, (long)this.currentTireList.length);
                return;
            }
            if (null != this.tireSelectionDataListModel) {
                this.tireSelectionDataListModel.setSelectedIndex(n2);
                for (int i2 = 0; i2 < this.currentTireList.length; ++i2) {
                    EvoListRow evoListRow = this.tireSelectionDataListModel.getRow(i2);
                    if (null == evoListRow) continue;
                    evoListRow.setInteger(4, i2 == n2 ? 1 : 0);
                    this.tireSelectionDataListModel.setRow(i2, evoListRow);
                }
            }
            if (null != this.tireSelectionDataListSelectionChoiceModel) {
                this.tireSelectionDataListSelectionChoiceModel.setValue(n2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void setListData(BufferedListModel bufferedListModel, int[][] nArray) {
        try {
            bufferedListModel.beginTransaction();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                bufferedListModel.setCell(nArray[i2][0], 0, IntegerListCell.create(nArray[i2][1]));
            }
        }
        catch (Exception exception) {
            this.logChannel.log(1000, "[DefaultRDKTireDisplay#setTireListData] exception occured!", (Throwable)exception);
        }
        finally {
            bufferedListModel.endTransaction();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void setListData(BufferedListModel bufferedListModel, int[] nArray, AbstractMetrics[] abstractMetricsArray) {
        if (nArray.length != abstractMetricsArray.length) {
            return;
        }
        try {
            bufferedListModel.beginTransaction();
            for (int i2 = 0; i2 < abstractMetricsArray.length; ++i2) {
                bufferedListModel.setCell(nArray[i2], 0, new MetricsListCell(abstractMetricsArray[i2]));
            }
        }
        catch (Exception exception) {
            this.logChannel.log(1000, "[DefaultRDKTireDisplay#setTireListData] exception occured!", (Throwable)exception);
        }
        finally {
            bufferedListModel.endTransaction();
        }
    }
}

