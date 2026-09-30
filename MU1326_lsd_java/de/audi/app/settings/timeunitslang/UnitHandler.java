/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.timeunitslang;

import de.audi.app.settings.SettingsEnv;
import de.audi.app.settings.time.TimeHandler;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.Consumption;
import de.audi.atip.metrics.Distance;
import de.audi.atip.metrics.Pressure;
import de.audi.atip.metrics.Speed;
import de.audi.atip.metrics.Temperature;
import de.audi.atip.metrics.Volume;
import de.audi.atip.power.PowerEventListener;
import org.dsi.ifc.carcomfort.RDKViewOptions;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;
import org.dsi.ifc.global.CarViewOption;

public final class UnitHandler
implements ChoiceListener,
PowerEventListener {
    public static final int STATE_FUNCTIONAL = 0;
    public static final int STATE_INVISIBLE = 1;
    public static final int STATE_DISABLED = 2;
    private volatile UnitmasterViewOptions unitMasterViewOpt;
    private volatile RDKViewOptions rDKviewOptions;
    protected static final int UNIT_INVAILID = -1;
    private final SettingsEnv env;
    private final LogChannel lc;
    private ChoiceModelApp unitsVisibilityModel;
    private ChoiceModelApp unitsDisclaimer;
    private TimeHandler timeHandler;

    public UnitHandler(SettingsEnv settingsEnv, TimeHandler timeHandler) {
        this.env = settingsEnv;
        this.lc = settingsEnv.getFw().getLogChannel("App.Settings.Units");
        this.timeHandler = timeHandler;
        this.init();
    }

    private void init() {
        this.env.getChoiceModel(4016).setChoiceListener(this);
        this.env.getChoiceModel(4018).setChoiceListener(this);
        this.env.getChoiceModel(4019).setChoiceListener(this);
        this.env.getChoiceModel(4017).setChoiceListener(this);
        this.env.getChoiceModel(4014).setChoiceListener(this);
        this.env.getChoiceModel(4015).setChoiceListener(this);
        this.env.getChoiceModel(4020).setChoiceListener(this);
        this.unitsVisibilityModel = this.env.getChoiceModel(1100143);
        this.unitsDisclaimer = this.env.getChoiceModel(1100295);
        this.prefillModels();
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        switch (n) {
            case 4016: {
                this.setDistanceUnit(n2);
                break;
            }
            case 4018: {
                this.setSpeedUnit(n2);
                break;
            }
            case 4019: {
                this.setTemperatureUnit(n2);
                break;
            }
            case 4017: {
                this.setPressureUnit(n2);
                break;
            }
            case 4014: {
                this.setConsumptionPetrolUnit(n2);
                break;
            }
            case 4015: {
                this.setConsumptionElektroUnit(n2);
                break;
            }
            case 4020: {
                this.setVolumeUnit(n2);
                break;
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    private void setTemperatureUnit(int n) {
        this.lc.log(1000000, "UnitHandler#setTemperatureUnit: '%1'", (Object)(n == 0 ? "\u00b0C" : "\u00b0F"));
        int n2 = n == 0 ? 0 : 1;
        this.lc.log(1000000, "UnitHandler#setTemperatureUnit: dsi.setTemperatureUnit(%1)", (long)n2);
        this.env.getDSIManager().getDSI().setTemperatureUnit(n2);
    }

    private void setDistanceUnit(int n) {
        this.lc.log(1000000, "UnitHandler#setDistanceUnit: '%1'", (Object)(n == 0 ? "km" : "mi"));
        int n2 = n == 0 ? 0 : 1;
        this.lc.log(1000000, "UnitHandler#setDistanceUnit: dsi.setDistanceUnit(%1)", (long)n2);
        this.env.getDSIManager().getDSI().setDistanceUnit(n2);
    }

    private void setSpeedUnit(int n) {
        this.lc.log(1000000, "UnitHandler#setSpeedUnit: '%1'", (Object)(n == 0 ? "km/h" : "mph"));
        int n2 = n == 0 ? 0 : 1;
        this.lc.log(1000000, "UnitHandler#setSpeedUnit: dsi.setSpeedUnit( %1 )", (long)n2);
        this.env.getDSIManager().getDSI().setSpeedUnit(n2);
        if (this.env.getVariantMapper().shouldLinkSpeedAndDistance()) {
            this.env.getDSIManager().getDSI().setDistanceUnit(n2 == 0 ? 0 : 1);
        }
    }

    private void setPressureUnit(int n) {
        this.lc.log(1000000, "UnitHandler#setPressureUnit: '%1'", (long)n);
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
        }
        this.lc.log(1000000, "UnitHandler#setPressureUnit: dsi.setPressureUnit(%1)", (long)n2);
        this.env.getDSIManager().getDSI().setPressureUnit(n2);
    }

    private void setVolumeUnit(int n) {
        this.lc.log(1000000, "UnitHandler#setVolumeUnit: '%1'", (long)n);
        int n2 = 2;
        switch (n) {
            case 0: {
                n2 = 2;
                break;
            }
            case 1: {
                n2 = 4;
                break;
            }
            case 2: {
                n2 = 3;
                break;
            }
        }
        this.lc.log(1000000, "UnitHandler#setVolumeUnit: dsi.setVolumeUnit(%1)", (long)n2);
        this.env.getDSIManager().getDSI().setVolumeUnit(n2);
    }

    private void setConsumptionPetrolUnit(int n) {
        this.lc.log(10000000, "UnitHandler#setConsumptionUnit: '%1'", (long)n);
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = 4;
                break;
            }
            case 1: {
                n2 = 3;
                break;
            }
            case 2: {
                n2 = 0;
                break;
            }
            case 3: {
                n2 = 1;
                break;
            }
        }
        this.lc.log(10000000, "UnitHandler#setConsumptionUnit: dsi.setConsumptionPetrolUnit(%1)", (long)n2);
        this.env.getDSIManager().getDSI().setConsumptionPetrolUnit(n2);
    }

    private void setConsumptionElektroUnit(int n) {
        this.lc.log(10000000, "UnitHandler#setConsumptionElektrolUnit: '%1'", (long)n);
        int n2 = 20;
        switch (n) {
            case 0: {
                n2 = 20;
                break;
            }
            case 1: {
                n2 = 18;
                break;
            }
            case 2: {
                n2 = 19;
                break;
            }
            case 3: {
                n2 = 21;
                break;
            }
        }
        this.lc.log(10000000, "UnitHandler#setConsumptionUnit: dsi.setConsumptionElektrolUnit(%1)", (long)n2);
        this.env.getDSIManager().getDSI().setConsumptionElectricUnit(n2);
    }

    public void updateTemperatureUnit(int n) {
        int n2 = 0;
        int n3 = 1;
        if (n == 1) {
            n2 = 1;
            n3 = 2;
        }
        this.env.getChoiceModel(4019).setValue(n2);
        Temperature.setSystemUnit(n3);
        this.env.getMetricsModel(406).formatChanged();
        this.env.getMetricsModel(406).setMetric(this.env.getTemperatureMetric(406));
        this.env.getFw().getMsgDistrib().sendMessage(11);
        this.env.getFw().getLastmodeHandler().getLastmodeStorage().setTemperature(n3, true);
    }

    public void updateDistanceUnit(int n) {
        int n2 = -1;
        int n3 = -1;
        switch (n) {
            case 0: {
                n2 = 0;
                n3 = 1;
                break;
            }
            case 1: {
                n2 = 1;
                n3 = 2;
                break;
            }
        }
        if (n2 != -1) {
            this.env.getChoiceModel(4016).setValue(n2);
            Distance.setSystemUnit(n3);
            this.env.getFw().getMsgDistrib().sendMessage(11);
        }
        this.env.getFw().getLastmodeHandler().getLastmodeStorage().setDistance(n3, true);
    }

    public void updateSpeedUnit(int n) {
        int n2 = 0;
        int n3 = 1;
        if (n == 1) {
            n2 = 1;
            n3 = 2;
        }
        this.env.getChoiceModel(4018).setValue(n2);
        Speed.setSystemUnit(n3);
        this.env.getFw().getMsgDistrib().sendMessage(11);
        this.env.getFw().getLastmodeHandler().getLastmodeStorage().setSpeed(n3, true);
    }

    public void updatePressureUnit(int n) {
        int n2;
        int n3;
        if (n == 1) {
            n3 = 1;
            n2 = 2;
        }
        switch (n) {
            case 1: {
                n3 = 1;
                n2 = 2;
                break;
            }
            case 2: {
                n3 = 2;
                n2 = 3;
                break;
            }
            default: {
                n3 = 0;
                n2 = 1;
            }
        }
        this.env.getChoiceModel(4017).setValue(n3);
        Pressure.setSystemUnit(n2);
        this.env.getFw().getLastmodeHandler().getLastmodeStorage().setPressure(n2, true);
        this.env.getFw().getMsgDistrib().sendMessage(11);
    }

    public void updateVolumeUnit(int n) {
        int n2;
        int n3;
        switch (n) {
            case 4: {
                n3 = 1;
                n2 = 2;
                break;
            }
            case 3: {
                n3 = 2;
                n2 = 3;
                break;
            }
            default: {
                n3 = 0;
                n2 = 1;
            }
        }
        this.env.getChoiceModel(4020).setValue(n3);
        Volume.setSystemUnit(n2);
        this.env.getFw().getLastmodeHandler().getLastmodeStorage().setVolume(n2, true);
        this.env.getFw().getMsgDistrib().sendMessage(11);
    }

    public void updateConsumptionPetrolUnit(int n) {
        int n2 = -1;
        int n3 = -1;
        switch (n) {
            case 4: {
                n2 = 0;
                n3 = 2;
                break;
            }
            case 3: {
                n2 = 1;
                n3 = 3;
                break;
            }
            case 0: {
                n2 = 2;
                n3 = 1;
                break;
            }
            case 1: {
                n2 = 3;
                n3 = 4;
                break;
            }
        }
        if (n2 != -1) {
            this.env.getChoiceModel(4014).setValue(n2);
            Consumption.setSystemUnit(n3);
            this.env.getFw().getLastmodeHandler().getLastmodeStorage().setConsumption(n3, true);
            this.env.getFw().getMsgDistrib().sendMessage(11);
        }
    }

    public void updateConsumptionElectricUnit(int n) {
        int n2 = -1;
        int n3 = -1;
        switch (n) {
            case 20: {
                n2 = 0;
                n3 = 5;
                break;
            }
            case 18: {
                n2 = 1;
                n3 = 6;
                break;
            }
            case 19: {
                n2 = 2;
                n3 = 7;
                break;
            }
            case 21: {
                n2 = 3;
                n3 = 8;
                break;
            }
        }
        if (n2 != -1) {
            this.env.getChoiceModel(4015).setValue(n2);
            Consumption.setSystemUnitElektro(n3);
            this.env.getFw().getLastmodeHandler().getLastmodeStorage().setConsumptionElectro(n3, true);
            this.env.getFw().getMsgDistrib().sendMessage(11);
        }
    }

    public void updateUnitmasterViewOptions(UnitmasterViewOptions unitmasterViewOptions) {
        this.lc.log(1000000, "UnitHandler#updateUnitmasterViewOptions(%1, %2)", (Object)unitmasterViewOptions);
        this.unitMasterViewOpt = unitmasterViewOptions;
        if (this.unitMasterViewOpt != null) {
            if (this.env.getFw().getSysConstManager().getCarFuncAdaptation().isMenuDisplayActivated((short)23)) {
                this.setAvailChoice(1100237, this.unitMasterViewOpt.getDateFormat());
                this.setAvailChoice(1100240, this.unitMasterViewOpt.getClockFormat());
                this.timeHandler.setUnitmasterViewOptions(unitmasterViewOptions);
            } else {
                this.env.getChoiceModel(1100237).setValue(1);
                this.env.getChoiceModel(1100240).setValue(1);
            }
            this.setAvailChoice(1100147, this.unitMasterViewOpt.getDistanceUnit());
            this.setAvailChoice(1100151, this.unitMasterViewOpt.getSpeedUnit());
            this.setAvailChoice(1100153, this.unitMasterViewOpt.getTemperatureUnit());
            this.setAvailChoice(1100145, this.unitMasterViewOpt.getConsumptionPetrolUnit());
            this.setAvailChoice(1100253, this.unitMasterViewOpt.getConsumptionElectricUnit());
            this.setAvailChoice(1100155, this.unitMasterViewOpt.getVolumeUnit());
            this.setPressureAvailChoice();
            this.applyUnitsVisibility();
        }
    }

    private void applyUnitsVisibility() {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(1100143);
        try {
            if (this.env.getFw().getSysConstManager().getCarFuncAdaptation().isMenuDisplayActivated((short)23)) {
                int n = 1;
                if (this.unitMasterViewOpt.getDistanceUnit() != null) {
                    if (this.unitMasterViewOpt.getDistanceUnit().state == 2) {
                        choiceModelApp.setValue(0);
                        return;
                    }
                    if (this.unitMasterViewOpt.getDistanceUnit().state == 1) {
                        n = 2;
                    }
                }
                if (this.unitMasterViewOpt.getSpeedUnit() != null) {
                    if (this.unitMasterViewOpt.getSpeedUnit().state == 2) {
                        choiceModelApp.setValue(0);
                        return;
                    }
                    if (this.unitMasterViewOpt.getSpeedUnit().state == 1) {
                        n = 2;
                    }
                }
                if (this.unitMasterViewOpt.getTemperatureUnit() != null) {
                    if (this.unitMasterViewOpt.getTemperatureUnit().state == 2) {
                        choiceModelApp.setValue(0);
                        return;
                    }
                    if (this.unitMasterViewOpt.getTemperatureUnit().state == 1) {
                        n = 2;
                    }
                }
                if (this.unitMasterViewOpt.getConsumptionPetrolUnit() != null) {
                    if (this.unitMasterViewOpt.getConsumptionPetrolUnit().state == 2) {
                        choiceModelApp.setValue(0);
                        return;
                    }
                    if (this.unitMasterViewOpt.getConsumptionPetrolUnit().state == 1) {
                        n = 2;
                    }
                }
                if (this.unitMasterViewOpt.getConsumptionElectricUnit() != null) {
                    if (this.unitMasterViewOpt.getConsumptionElectricUnit().state == 2) {
                        choiceModelApp.setValue(0);
                        return;
                    }
                    if (this.unitMasterViewOpt.getConsumptionElectricUnit().state == 1) {
                        n = 2;
                    }
                }
                if (this.unitMasterViewOpt.getVolumeUnit() != null) {
                    if (this.unitMasterViewOpt.getVolumeUnit().state == 2) {
                        choiceModelApp.setValue(0);
                        return;
                    }
                    if (this.unitMasterViewOpt.getVolumeUnit().state == 1) {
                        n = 2;
                    }
                }
                choiceModelApp.setValue(n);
            } else {
                choiceModelApp.setValue(1);
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "UnitHandler#applyUnitsVisibility() Exception: ", (Throwable)exception);
            choiceModelApp.setValue(1);
        }
    }

    private void setPressureAvailChoice() {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(1100149);
        if (this.unitMasterViewOpt == null || this.rDKviewOptions == null) {
            choiceModelApp.setValue(1);
            return;
        }
        try {
            if (this.env.getFw().getSysConstManager().getCarFuncAdaptation().isMenuDisplayActivated((short)11)) {
                if (this.unitMasterViewOpt.getPressureUnit().state == 2) {
                    if (this.rDKviewOptions.getTireDisplay().state == 0) {
                        choiceModelApp.setValue(1);
                    } else {
                        choiceModelApp.setValue(0);
                    }
                } else if (this.unitMasterViewOpt.getPressureUnit().state == 1) {
                    if (this.rDKviewOptions.getTireDisplay().state == 0) {
                        choiceModelApp.setValue(1);
                    } else {
                        choiceModelApp.setValue(2);
                    }
                } else {
                    choiceModelApp.setValue(1);
                }
            } else {
                choiceModelApp.setValue(1);
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "UnitHandler#setPressureAvailChoice() Exception: ", (Throwable)exception);
            choiceModelApp.setValue(1);
        }
    }

    public void updateRDKViewOptions(RDKViewOptions rDKViewOptions) {
        this.rDKviewOptions = rDKViewOptions;
        this.setPressureAvailChoice();
    }

    private void setAvailChoice(int n, CarViewOption carViewOption) {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(n);
        if (carViewOption == null) {
            choiceModelApp.setValue(1);
            return;
        }
        if (carViewOption.getState() == 2) {
            choiceModelApp.setValue(0);
        } else if (carViewOption.getState() == 0) {
            choiceModelApp.setValue(1);
        } else {
            choiceModelApp.setValue(2);
        }
    }

    private void prefillModels() {
        CarViewOption carViewOption;
        UnitmasterViewOptions unitmasterViewOptions = new UnitmasterViewOptions();
        unitmasterViewOptions.clockFormat = carViewOption = new CarViewOption(1, 0);
        unitmasterViewOptions.dateFormat = carViewOption;
        unitmasterViewOptions.consumptionElectricUnit = carViewOption;
        unitmasterViewOptions.consumptionGasUnit = carViewOption;
        unitmasterViewOptions.consumptionPetrolUnit = carViewOption;
        unitmasterViewOptions.distanceUnit = carViewOption;
        unitmasterViewOptions.language = carViewOption;
        unitmasterViewOptions.pressureUnit = carViewOption;
        unitmasterViewOptions.speedUnit = carViewOption;
        unitmasterViewOptions.temperatureUnit = carViewOption;
        unitmasterViewOptions.volumeUnit = carViewOption;
        this.updateUnitmasterViewOptions(unitmasterViewOptions);
    }

    public void notifyPowerListenerOnEnterState(int n, int n2) {
    }

    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    public void notifyPowerTriggerAction(int n, int n2) {
    }

    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (this.unitsVisibilityModel.getValue() != 1) {
            if (bl2) {
                this.unitsVisibilityModel.setValue(0);
                this.unitsDisclaimer.setValue(0);
            } else {
                this.unitsVisibilityModel.setValue(2);
                this.unitsDisclaimer.setValue(3);
            }
        }
    }
}

