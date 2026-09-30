/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.core.comfort.IRDKTireDisplay;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.BufferedListModel;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.IntMapper;
import org.dsi.ifc.carcomfort.RDKTireDisplayData;
import org.dsi.ifc.carcomfort.RDKTireInfo;
import org.dsi.ifc.carcomfort.RDKWheelPressures;
import org.dsi.ifc.carcomfort.RDKWheelStates;
import org.dsi.ifc.carcomfort.RDKWheelTemperatures;

public class RDKTireDisplay
implements IRDKTireDisplay {
    private static final int INVALID_PRESSURE_VALUE = 32768;
    private static final int TIRE_GREEN = 0;
    private static final int TIRE_YELLOW = 1;
    private static final int TIRE_RED = 2;
    private static final int TIRE_GREY = 3;
    private final int[][] mapTireStateToColor = new int[][]{{0, 0}, {1, 3}, {2, 1}, {3, 2}, {4, 2}, {5, 3}};
    private final IntMapper mapTireSts = new IntMapper("mapTireSts", this.mapTireStateToColor);
    private static final int LIST_ROWS = 22;
    private static final int ROW_PRESSURE_FR = 0;
    private static final int ROW_PRESSURE_FL = 1;
    private static final int ROW_PRESSURE_RR = 2;
    private static final int ROW_PRESSURE_RL = 3;
    private static final int ROW_PRESSURE_SW = 4;
    private static final int ROW_TEMP_FR = 5;
    private static final int ROW_TEMP_FL = 6;
    private static final int ROW_TEMP_RR = 7;
    private static final int ROW_TEMP_RL = 8;
    private static final int ROW_TEMP_SW = 9;
    private static final int ROW_STATE_FR = 10;
    private static final int ROW_STATE_FL = 11;
    private static final int ROW_STATE_RR = 12;
    private static final int ROW_STATE_RL = 13;
    private static final int ROW_STATE_SW = 14;
    private static final int ROW_PRESSURE_UNIT = 15;
    private static final int ROW_TEMP_UNIT = 16;
    private BufferedListModel tireDataListModel;
    private final LogChannel logChannel;
    private final IFrameworkAccess frameworkAccess;

    public RDKTireDisplay(LogChannel logChannel, IFrameworkAccess iFrameworkAccess) {
        this.logChannel = logChannel;
        this.frameworkAccess = iFrameworkAccess;
    }

    public void initialize() {
        this.logChannel.log(1000000, "[RDKTireDisplay#initialize] called");
        this.tireDataListModel = (BufferedListModel)this.frameworkAccess.getHmiServiceApp().getListModel(600364);
        this.tireDataListModel.setMaxColumns(1);
        this.tireDataListModel.setMaxRows(22);
        for (int i2 = 0; i2 < 22; ++i2) {
            this.tireDataListModel.addRow(IntegerListCell.create(0));
        }
        this.tireDataListModel.setRow(15, IntegerListCell.create(1));
        this.tireDataListModel.setRow(16, IntegerListCell.create(1));
        this.setTireListData(new int[][]{{10, 3}, {11, 3}, {12, 3}, {13, 3}, {14, 3}});
    }

    public void updateDisplayData(RDKTireDisplayData rDKTireDisplayData) {
        this.logChannel.log(1000000, "[RDKTireDisplay#updateDisplayData] called");
        this.updateStateData(rDKTireDisplayData.getWheelStates(), rDKTireDisplayData.getWheelPressures(), rDKTireDisplayData.getWheelTemperatures());
        this.updatePressureData(rDKTireDisplayData.getWheelPressures(), rDKTireDisplayData.getRequiredWheelPressures());
        this.updateTemperatureData(rDKTireDisplayData.getWheelTemperatures());
        this.updateNoPressureCheck(rDKTireDisplayData.getWheelStates().getCollectedState());
    }

    public void updateTireSetupTireList(RDKTireInfo[] rDKTireInfoArray) {
    }

    public void updateTireSetupSelectedTire(int n) {
    }

    public void updateSpeedLimit(int n) {
    }

    public void updateDifferentialPressure(RDKWheelPressures rDKWheelPressures) {
    }

    private void updateNoPressureCheck(int n) {
        if (n == 1) {
            this.frameworkAccess.getHmiServiceApp().getChoiceModel(601257).setValue(0);
        } else {
            this.frameworkAccess.getHmiServiceApp().getChoiceModel(601257).setValue(1);
        }
    }

    private void updatePressureData(RDKWheelPressures rDKWheelPressures, RDKWheelPressures rDKWheelPressures2) {
        int n = 1;
        switch (rDKWheelPressures.getPressureUnit()) {
            case 0: {
                n = 1;
                break;
            }
            case 1: {
                n = 2;
                break;
            }
            case 2: {
                n = 3;
                break;
            }
            default: {
                this.logChannel.log(1000000, "invalid pressure unit: %1, ignore", (long)rDKWheelPressures.getPressureUnit());
                return;
            }
        }
        this.setTireListData(new int[][]{{0, rDKWheelPressures.getFrontRight()}, {1, rDKWheelPressures.getFrontLeft()}, {2, rDKWheelPressures.getRearRight()}, {3, rDKWheelPressures.getRearLeft()}, {4, rDKWheelPressures.getSpareWheel()}, {15, n}});
    }

    private void updateStateData(RDKWheelStates rDKWheelStates, RDKWheelPressures rDKWheelPressures, RDKWheelTemperatures rDKWheelTemperatures) {
        int n = 3;
        int n2 = 3;
        int n3 = 3;
        int n4 = 3;
        int n5 = 3;
        if (rDKWheelStates.getCollectedState() != 1) {
            try {
                n = 32768 == rDKWheelPressures.getFrontRight() ? 3 : this.mapTireSts.getValue(rDKWheelStates.getFrontRight());
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                n = 3;
            }
            try {
                n2 = 32768 == rDKWheelPressures.getFrontLeft() ? 3 : this.mapTireSts.getValue(rDKWheelStates.getFrontLeft());
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                n2 = 3;
            }
            try {
                n3 = 32768 == rDKWheelPressures.getRearRight() ? 3 : this.mapTireSts.getValue(rDKWheelStates.getRearRight());
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                n3 = 3;
            }
            try {
                n4 = 32768 == rDKWheelPressures.getRearLeft() ? 3 : this.mapTireSts.getValue(rDKWheelStates.getRearLeft());
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                n4 = 3;
            }
            try {
                n5 = 32768 == rDKWheelPressures.getSpareWheel() ? 3 : this.mapTireSts.getValue(rDKWheelStates.getSpareWheel());
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                n5 = 3;
            }
        } else {
            this.logChannel.log(1000000, "[RDKTireDisplay#updateStateData] collected state is NOT_DISPLAYED, setting all tire data to INVALID.");
        }
        this.setTireListData(new int[][]{{10, n}, {11, n2}, {12, n3}, {13, n4}, {14, n5}});
    }

    private void updateTemperatureData(RDKWheelTemperatures rDKWheelTemperatures) {
        switch (rDKWheelTemperatures.getTemperatureUnit()) {
            case 0: {
                this.setTireListData(new int[][]{{5, rDKWheelTemperatures.getFrontRight()}, {6, rDKWheelTemperatures.getFrontLeft()}, {7, rDKWheelTemperatures.getRearRight()}, {8, rDKWheelTemperatures.getRearLeft()}, {9, rDKWheelTemperatures.getSpareWheel()}, {16, 1}});
                break;
            }
            case 1: {
                this.setTireListData(new int[][]{{5, rDKWheelTemperatures.getFrontRight()}, {6, rDKWheelTemperatures.getFrontLeft()}, {7, rDKWheelTemperatures.getRearRight()}, {8, rDKWheelTemperatures.getRearLeft()}, {9, rDKWheelTemperatures.getSpareWheel()}, {16, 2}});
                break;
            }
            default: {
                this.logChannel.log(100000, "[RDKTireDisplay#updateTemperatureData] %1 temperature unit: %2, CELSIUS is used", (long)rDKWheelTemperatures.getTemperatureUnit());
                this.setTireListData(new int[][]{{5, rDKWheelTemperatures.getFrontRight()}, {6, rDKWheelTemperatures.getFrontLeft()}, {7, rDKWheelTemperatures.getRearRight()}, {8, rDKWheelTemperatures.getRearLeft()}, {9, rDKWheelTemperatures.getSpareWheel()}, {16, 1}});
                return;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setTireListData(int[][] nArray) {
        try {
            this.tireDataListModel.beginTransaction();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.tireDataListModel.setCell(nArray[i2][0], 0, IntegerListCell.create(nArray[i2][1]));
            }
        }
        catch (Exception exception) {
            this.logChannel.log(1000, "[RDKTireDisplay#tireDataSet] exception occured", (Throwable)exception);
        }
        finally {
            this.tireDataListModel.endTransaction();
        }
    }
}

