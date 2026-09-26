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
    private static final int INVALID_PRESSURE_VALUE;
    private static final int TIRE_GREEN;
    private static final int TIRE_YELLOW;
    private static final int TIRE_RED;
    private static final int TIRE_GREY;
    private final int[][] mapTireStateToColor = new int[][]{{0, 0}, {1, 3}, {2, 1}, {3, 2}, {4, 2}, {5, 3}};
    private final IntMapper mapTireSts = new IntMapper("mapTireSts", this.mapTireStateToColor);
    private static final int LIST_ROWS;
    private static final int ROW_PRESSURE_FR;
    private static final int ROW_PRESSURE_FL;
    private static final int ROW_PRESSURE_RR;
    private static final int ROW_PRESSURE_RL;
    private static final int ROW_PRESSURE_SW;
    private static final int ROW_TEMP_FR;
    private static final int ROW_TEMP_FL;
    private static final int ROW_TEMP_RR;
    private static final int ROW_TEMP_RL;
    private static final int ROW_TEMP_SW;
    private static final int ROW_STATE_FR;
    private static final int ROW_STATE_FL;
    private static final int ROW_STATE_RR;
    private static final int ROW_STATE_RL;
    private static final int ROW_STATE_SW;
    private static final int ROW_PRESSURE_UNIT;
    private static final int ROW_TEMP_UNIT;
    private BufferedListModel tireDataListModel;
    private final LogChannel logChannel;
    private final IFrameworkAccess frameworkAccess;

    public RDKTireDisplay(LogChannel logChannel, IFrameworkAccess iFrameworkAccess) {
        this.logChannel = logChannel;
        this.frameworkAccess = iFrameworkAccess;
    }

    @Override
    public void initialize() {
        this.logChannel.log(1078071040, "[RDKTireDisplay#initialize] called");
        this.tireDataListModel = (BufferedListModel)this.frameworkAccess.getHmiServiceApp().getListModel(740886784);
        this.tireDataListModel.setMaxColumns(1);
        this.tireDataListModel.setMaxRows(22);
        for (int i2 = 0; i2 < 22; ++i2) {
            this.tireDataListModel.addRow(IntegerListCell.create(0));
        }
        this.tireDataListModel.setRow(15, IntegerListCell.create(1));
        this.tireDataListModel.setRow(16, IntegerListCell.create(1));
        this.setTireListData(new int[][]{{10, 3}, {11, 3}, {12, 3}, {13, 3}, {14, 3}});
    }

    @Override
    public void updateDisplayData(RDKTireDisplayData rDKTireDisplayData) {
        this.logChannel.log(1078071040, "[RDKTireDisplay#updateDisplayData] called");
        this.updateStateData(rDKTireDisplayData.getWheelStates(), rDKTireDisplayData.getWheelPressures(), rDKTireDisplayData.getWheelTemperatures());
        this.updatePressureData(rDKTireDisplayData.getWheelPressures(), rDKTireDisplayData.getRequiredWheelPressures());
        this.updateTemperatureData(rDKTireDisplayData.getWheelTemperatures());
        this.updateNoPressureCheck(rDKTireDisplayData.getWheelStates().getCollectedState());
    }

    @Override
    public void updateTireSetupTireList(RDKTireInfo[] rDKTireInfoArray) {
    }

    @Override
    public void updateTireSetupSelectedTire(int n) {
    }

    @Override
    public void updateSpeedLimit(int n) {
    }

    @Override
    public void updateDifferentialPressure(RDKWheelPressures rDKWheelPressures) {
    }

    private void updateNoPressureCheck(int n) {
        if (n == 1) {
            this.frameworkAccess.getHmiServiceApp().getChoiceModel(-1456731904).setValue(0);
        } else {
            this.frameworkAccess.getHmiServiceApp().getChoiceModel(-1456731904).setValue(1);
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
                this.logChannel.log(1078071040, "invalid pressure unit: %1, ignore", (long)rDKWheelPressures.getPressureUnit());
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
                n = 0x800000 == rDKWheelPressures.getFrontRight() ? 3 : this.mapTireSts.getValue(rDKWheelStates.getFrontRight());
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                n = 3;
            }
            try {
                n2 = 0x800000 == rDKWheelPressures.getFrontLeft() ? 3 : this.mapTireSts.getValue(rDKWheelStates.getFrontLeft());
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                n2 = 3;
            }
            try {
                n3 = 0x800000 == rDKWheelPressures.getRearRight() ? 3 : this.mapTireSts.getValue(rDKWheelStates.getRearRight());
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                n3 = 3;
            }
            try {
                n4 = 0x800000 == rDKWheelPressures.getRearLeft() ? 3 : this.mapTireSts.getValue(rDKWheelStates.getRearLeft());
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                n4 = 3;
            }
            try {
                n5 = 0x800000 == rDKWheelPressures.getSpareWheel() ? 3 : this.mapTireSts.getValue(rDKWheelStates.getSpareWheel());
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                n5 = 3;
            }
        } else {
            this.logChannel.log(1078071040, "[RDKTireDisplay#updateStateData] collected state is NOT_DISPLAYED, setting all tire data to INVALID.");
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
                this.logChannel.log(-1601830656, "[RDKTireDisplay#updateTemperatureData] %1 temperature unit: %2, CELSIUS is used", (long)rDKWheelTemperatures.getTemperatureUnit());
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

