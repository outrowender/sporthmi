/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.service;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.AbstractDSICarVehicleStatesAdapter;
import de.audi.atip.msg.MsgListener;
import org.dsi.ifc.carvehiclestates.OilLevelData;
import org.dsi.ifc.carvehiclestates.OilLevelRefillVolume;
import org.dsi.ifc.global.CarViewOption;

public abstract class AbstractOilLevelComponent
extends AbstractDSICarVehicleStatesAdapter
implements MsgListener {
    public static final short CODING_ID;
    private static final String LOGCHANNEL_NAME;
    private volatile CarViewOption currentViewOptions;
    private volatile OilLevelData currOilLevelData = new OilLevelData(0, new OilLevelRefillVolume(0, 0), 0, false, false);
    private static final int OIL_LEVEL_OK;
    private static final int WARNGRP1_SENSOR_ERROR;
    private static final int WARNGRP1_LEVEL_NOT_PRESENT;
    private static final int WARNGRP1_LEVEL_TOO_HIGH;
    private static final int WARNGRP1_LEVEL_LOW;
    private static final int WARNGRP1_LEVEL_TOO_LOW;
    private static final int WARNGRP1_ENGINE_RUNNING;
    private static final int WARNGRP2_CAR_TILT;
    private static final int WARNGRP2_ENGINE_COLD;
    private static final int WARNGRP2_OILLEVEL;
    private static final int WARNGRP2_OILLEVEL_OK;
    private static final int WARNGRP3_NOT_AVAILABLE;
    private static final int WARNGRP3_SYSTEMERROR;
    private static final String[] WARNING_TEXT;
    private static final int INDEX_UNIT_L;
    private static final int INDEX_UNIT_QT;
    private static String[][] oilRefill;

    public AbstractOilLevelComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.OilLevel");
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getMessageDispatcher().addMessageListener(11, this);
    }

    @Override
    public void deinit() {
        this.getApplication().getMessageDispatcher().removeMessageListener(11, this);
        super.deinit();
    }

    @Override
    protected void initModels() {
    }

    @Override
    protected void deinitModels() {
    }

    @Override
    public void processMsg(int n) {
        this.getLogChannel().log(1078071040, "processMsg(%1) - units changed", (long)n);
        this.unitsChanged();
    }

    @Override
    public void updateOilLevelViewOption(CarViewOption carViewOption, int n) {
        this.getLogChannel().log(1078071040, "updateOilLevelViewOption(%1), valid:%2", (Object)carViewOption, (long)n);
        if (n == 1) {
            this.currentViewOptions = carViewOption;
            this.updateMenuEntryVisibility(carViewOption);
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void updateOilLevelData(OilLevelData oilLevelData, int n) {
        this.getLogChannel().log(1078071040, "updateOilLevelData(%1), valid:%2", (Object)oilLevelData, (long)n);
        if (n != 1) {
            return;
        }
        this.currOilLevelData = oilLevelData;
        int n2 = oilLevelData.getLevel();
        switch (oilLevelData.getWarnings()) {
            case 3: {
                this.getChoiceModel(371788032).setValue(0);
                break;
            }
            case 9: {
                this.getChoiceModel(371788032).setValue(1);
                break;
            }
            case 2: {
                this.getChoiceModel(371788032).setValue(2);
                this.getChoiceModel(338233600).setValue(10);
                break;
            }
            case 0: {
                this.getChoiceModel(371788032).setValue(3);
                this.getLabelModel(355010816).setText(this.getRefillText(oilLevelData));
                break;
            }
            case 1: {
                this.getChoiceModel(371788032).setValue(4);
                this.getChoiceModel(338233600).setValue(0);
                break;
            }
            case 8: {
                this.getChoiceModel(371788032).setValue(5);
                break;
            }
            case 6: {
                this.getChoiceModel(371788032).setValue(6);
                this.getChoiceModel(338233600).setValue(this.segments(n2));
                break;
            }
            case 7: {
                this.getChoiceModel(338233600).setValue(this.segments(n2));
                this.getChoiceModel(371788032).setValue(7);
                break;
            }
            case 10: {
                this.getChoiceModel(371788032).setValue(10);
                break;
            }
            case 11: {
                this.getChoiceModel(371788032).setValue(11);
                break;
            }
            default: {
                this.getChoiceModel(338233600).setValue(this.segments(n2));
                this.getChoiceModel(371788032).setValue(n2 >= 3 ? 9 : 8);
            }
        }
        try {
            this.getLogChannel().log(1078071040, "updateOilLevelData --> %1", (Object)WARNING_TEXT[this.getChoiceModel(371788032).getValue()]);
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            this.getLogChannel().log(1078071040, "updateOilLevelData --> %1, no log-text mapping for value", (long)this.getChoiceModel(371788032).getValue());
        }
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{2})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    private void unitsChanged() {
        if (this.currOilLevelData.getWarnings() == 0) {
            this.getLabelModel(355010816).setText(this.getRefillText(this.currOilLevelData));
            this.getChoiceModel(371788032).setValue(3);
        }
    }

    private String getRefillText(OilLevelData oilLevelData) {
        String string = "<ERROR>";
        int n = oilLevelData.getRefillVolume().getUnit() == 4 ? 1 : 0;
        int n2 = oilLevelData.getRefillVolume().getValue();
        try {
            string = oilRefill[n2][n];
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            this.getLogChannel().log(10000, "getRefillText() quantity %1 out of range", (long)n2);
        }
        return string;
    }

    protected int segments(int n) {
        int n2 = n + 1;
        this.getLogChannel().log(1078071040, "segments(%1)->%2", (long)n, (long)n2);
        return n2;
    }

    protected abstract void updateMenuEntryVisibility(CarViewOption carViewOption) {
    }

    @Override
    public String getName() {
        return "OilLevel";
    }

    static {
        WARNING_TEXT = new String[]{"SENSOR_ERROR(1)", "LEVEL_NOT_PRESENT(1)", "LEVEL_TOO_HIGH(1)", "LEVEL_LOW(1)", "LEVEL_TOO_LOW(1)", "ENGINE_RUNNING(1)", "CAR_TILT(2)", "ENGINE_COLD(2)", "LEVEL_LOW(2)", "LEVEL_OK(2)", "NOT_AVAILABLE", "SYSTEM ERROR"};
        oilRefill = new String[][]{{"0 l", "0 qt"}, {"0,125 l", "1/8 qt"}, {"0,25 l", "1/4 qt"}, {"0,375 l", "3/8 qt"}, {"0,5 l", "1/2 qt"}, {"0,625 l", "5/8 qt"}, {"0,75 l", "3/4 qt"}, {"0,875 l", "7/8 qt"}, {"1 l", "1 qt"}, {"1,125 l", "1 1/8 qt"}, {"1,25 l", "1 1/4 qt"}, {"1,375 l", "1 3/8 qt"}, {"1,5 l", "1 1/2 qt"}, {"1,625 l", "1 5/8 qt"}, {"1,75 l", "1 3/4 qt"}, {"1,875 l", "1 7/8 qt"}, {"2 l", "2 qt"}, {"2,125 l", "2 1/8 qt"}, {"2,25 l", "2 1/4 qt"}, {"2,375 l", "2 3/8 qt"}, {"2,5 l", "2 1/2 qt"}, {"2,625 l", "2 5/8 qt"}, {"2,75 l", "2 3/4 qt"}, {"2,875 l", "2 7/8 qt"}, {"3 l", "3 qt"}, {"3,125 l", "3 1/8 qt"}, {"3,25 l", "3 1/4 qt"}, {"3,375 l", "3 3/8 qt"}, {"3,5 l", "3 1/2 qt"}, {"3,625 l", "3 5/8 qt"}, {"3,75 l", "3 3/4 qt"}, {"3,875 l", "3 7/8 qt"}};
    }
}

