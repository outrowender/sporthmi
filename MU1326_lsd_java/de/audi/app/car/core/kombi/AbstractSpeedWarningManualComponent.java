/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.kombi;

import de.audi.app.car.common.adapter.AbstractDSICarKombiAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.metrics.Speed;
import org.dsi.ifc.carkombi.BCSpeedWarningSettings;
import org.dsi.ifc.carkombi.BCViewOptions;

public abstract class AbstractSpeedWarningManualComponent
extends AbstractDSICarKombiAdapter
implements RangeListener,
ChoiceListener {
    public static final short CODING_ID = 10;
    private static final String LOGCHANNEL_NAME = "App.Car.SpeedWarning.Manual";
    private volatile BCViewOptions currentViewOptions;
    private final SpeedWarningHandler handler = new SpeedWarningHandler();

    public AbstractSpeedWarningManualComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.getRangeModel(600747).setRangeListener(this);
        this.getChoiceModel(601442).setChoiceListener(this);
        this.handler.initModels();
    }

    protected void deinitModels() {
        this.handler.deinitModels();
        this.getRangeModel(600747).resetListener();
        this.getChoiceModel(601442).resetListener();
    }

    protected synchronized void saveCurrentSpeedSetting() {
        BCSpeedWarningSettings bCSpeedWarningSettings = this.handler.getChangedSpeedWarning();
        this.getLogChannel().log(1000000, "dsi.setBCSpeedWarning(%1)", (Object)bCSpeedWarningSettings);
        this.getDSI().setBCSpeedWarning(bCSpeedWarningSettings);
    }

    protected synchronized void resetSpeedSetting() {
        this.handler.resetChangeSetting();
    }

    public void updateBCViewOptions(BCViewOptions bCViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateBCViewOptions: '%1', valid='%2'", (Object)(bCViewOptions != null ? this.formatViewOptionsLog(bCViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && bCViewOptions != null) {
            this.currentViewOptions = bCViewOptions;
            this.updateMenuEntryVisibility(this.currentViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    public synchronized void updateBCSpeedWarning(BCSpeedWarningSettings bCSpeedWarningSettings, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateBCSpeedWarning: '%1', valid='%2'", (Object)bCSpeedWarningSettings, (long)n);
        }
        if (n == 1) {
            this.handler.setCurrentSpeedWarning(bCSpeedWarningSettings);
        }
    }

    public void updateBCLifeTipsDisplay(boolean bl, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateBCLifeTipsDisplay: enable='%1', valid='%2'", bl, (long)n);
        }
        if (n == 1) {
            this.getChoiceModel(601442).setValue(bl ? 1 : 0);
        }
    }

    public void keyPressed(int n, int n2, int n3) {
        this.getLogChannel().log(1000000, "keyPressed: model='%1'", (long)n);
        switch (n) {
            case 600747: {
                this.getRangeModel(600747).fireEvent(n3);
                break;
            }
        }
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.getLogChannel().log(1000000, "itemSelected: model='%1' , itemID='%2'", (long)n, (long)n2);
        switch (n) {
            case 601442: {
                this.setBCLiveTips(n2 == 1);
                break;
            }
            default: {
                this.logModelData("itemSelected:", n, n2, false);
            }
        }
    }

    public void decrement(int n, int n2, int n3) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "decrement: model=%1, steps=%2", (long)n, (long)n2);
        }
        if (n == 600747) {
            this.handler.changeSetting(-n2);
        }
    }

    public void increment(int n, int n2, int n3) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "increment: model=%1, steps=%2", (long)n, (long)n2);
        }
        if (n == 600747) {
            this.handler.changeSetting(n2);
        }
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{4}, new int[]{33, 21})};
    }

    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    protected abstract void updateMenuEntryVisibility(BCViewOptions var1);

    public String getName() {
        return "SpeedWarningManual";
    }

    private void setBCLiveTips(boolean bl) {
        this.getLogChannel().log(1000000, "dsi.setBCLifeTipsDisplay(%1)", bl);
        this.getDSI().setBCLifeTipsDisplay(bl);
    }

    class SpeedWarningHandler {
        public static final int OFF_KMH = 20;
        public static final int MAX_KMH = 240;
        public static final int STEP_KMH = 10;
        public static final int OFF_MPH = 15;
        public static final int MAX_MPH = 150;
        public static final int STEP_MPH = 5;
        private static final int TEXT_OFF_VISIBLE = 0;
        private static final int TEXT_SPEED_VISIBLE = 1;
        private BCSpeedWarningSettings currentSpeedWarning = new BCSpeedWarningSettings();
        private int changedSpeed;
        private final ModelGroup rotaryLabelsGroup = new ModelGroup();
        private MetricsModelApp currentLimitModel;
        private MetricsModelApp maxLimitModel;
        private RangeModelApp rangeModel;
        private ChoiceModelApp switchTextModel;

        SpeedWarningHandler() {
        }

        void initModels() {
            this.currentLimitModel = AbstractSpeedWarningManualComponent.this.getMetricsModel(600746);
            Speed speed = new Speed(20.0f, 1);
            speed.setUseInstanceUnit(true);
            this.currentLimitModel.setMetric(speed);
            this.currentLimitModel.formatChanged();
            this.rangeModel = AbstractSpeedWarningManualComponent.this.getRangeModel(600747);
            this.maxLimitModel = AbstractSpeedWarningManualComponent.this.getMetricsModel(600754);
            this.switchTextModel = AbstractSpeedWarningManualComponent.this.getChoiceModel(600752);
            this.rangeModel.setValue(20);
            this.rangeModel.setLimits(20, 240, 10);
            this.rangeModel.setMedialPosition(20);
            Speed speed2 = new Speed(240.0f, 1);
            speed2.setUseInstanceUnit(true);
            this.maxLimitModel.setMetric(speed2);
            this.maxLimitModel.formatChanged();
            this.rotaryLabelsGroup.add(this.currentLimitModel);
            this.rotaryLabelsGroup.add(this.rangeModel);
            this.rotaryLabelsGroup.add(this.maxLimitModel);
            this.rotaryLabelsGroup.add(this.switchTextModel);
        }

        void deinitModels() {
            this.rotaryLabelsGroup.removeAll();
        }

        void setCurrentSpeedWarning(BCSpeedWarningSettings bCSpeedWarningSettings) {
            bCSpeedWarningSettings.speedValue = this.roundSpeedWarningValue(bCSpeedWarningSettings.getSpeedValue(), bCSpeedWarningSettings.getSpeedUnit(), bCSpeedWarningSettings.state);
            boolean bl = bCSpeedWarningSettings.getSpeedUnit() == 0;
            Speed speed = new Speed(bCSpeedWarningSettings.getSpeedValue(), bl ? 1 : 2);
            speed.setUseInstanceUnit(true);
            this.currentLimitModel.setMetric(speed);
            if (this.currentSpeedWarning.getSpeedUnit() != bCSpeedWarningSettings.getSpeedUnit()) {
                Speed speed2 = bl ? new Speed(240.0f, 1) : new Speed(150.0f, 2);
                speed2.setUseInstanceUnit(true);
                this.maxLimitModel.setMetric(speed2);
                this.maxLimitModel.formatChanged();
                this.currentLimitModel.formatChanged();
                this.rangeModel.setLimits(bl ? 20 : 15, bl ? 240 : 150, bl ? 10 : 5);
                this.rangeModel.setMedialPosition(bl ? 20 : 15);
            }
            this.updateSpeedValues(bCSpeedWarningSettings.getSpeedValue(), bCSpeedWarningSettings.getSpeedUnit());
            this.currentSpeedWarning = bCSpeedWarningSettings;
        }

        void changeSetting(int n) {
            boolean bl = this.currentSpeedWarning.getSpeedUnit() == 0;
            int n2 = AbstractCarComponent.clip(this.changedSpeed + n, bl ? 20 : 15, bl ? 240 : 150);
            AbstractSpeedWarningManualComponent.this.getLogChannel().log(10000000, "changeSetting: speed=%1", (long)n2);
            this.updateSpeedValues(n2, this.currentSpeedWarning.getSpeedUnit());
        }

        void resetChangeSetting() {
            AbstractSpeedWarningManualComponent.this.getLogChannel().log(10000000, "resetChangeSetting: resetting to '%1'", (Object)this.currentSpeedWarning);
            this.updateSpeedValues(this.currentSpeedWarning.getSpeedValue(), this.currentSpeedWarning.getSpeedUnit());
        }

        private void updateSpeedValues(int n, int n2) {
            boolean bl;
            this.changedSpeed = n;
            this.rangeModel.setValue(n);
            boolean bl2 = bl = n2 == 0;
            if (bl && n > 20 || !bl && n > 15) {
                this.switchTextModel.setValue(1);
            } else {
                this.switchTextModel.setValue(0);
            }
            this.rotaryLabelsGroup.flush();
        }

        BCSpeedWarningSettings getChangedSpeedWarning() {
            BCSpeedWarningSettings bCSpeedWarningSettings = new BCSpeedWarningSettings();
            bCSpeedWarningSettings.speedUnit = this.currentSpeedWarning.getSpeedUnit();
            if (this.currentSpeedWarning.getSpeedUnit() == 0 && this.changedSpeed > 240) {
                bCSpeedWarningSettings.speedValue = 240;
                bCSpeedWarningSettings.state = true;
            } else if (this.currentSpeedWarning.getSpeedUnit() == 0 && this.changedSpeed <= 20) {
                bCSpeedWarningSettings.speedValue = 0;
                bCSpeedWarningSettings.state = false;
            } else if (this.currentSpeedWarning.getSpeedUnit() == 1 && this.changedSpeed > 150) {
                bCSpeedWarningSettings.speedValue = 150;
                bCSpeedWarningSettings.state = true;
            } else if (this.currentSpeedWarning.getSpeedUnit() == 1 && this.changedSpeed <= 15) {
                bCSpeedWarningSettings.speedValue = 0;
                bCSpeedWarningSettings.state = false;
            } else {
                bCSpeedWarningSettings.speedValue = this.changedSpeed;
                bCSpeedWarningSettings.state = true;
            }
            return bCSpeedWarningSettings;
        }

        private int roundSpeedWarningValue(int n, int n2, boolean bl) {
            AbstractSpeedWarningManualComponent.this.getLogChannel().log(10000000, "roundSpeedWarningValue: BEFORE rounding (%1)", (long)n);
            int n3 = n;
            if (n2 == 1) {
                if (!bl) {
                    n3 = 15;
                } else if (n <= 15) {
                    n3 = 15;
                } else if (n > 150) {
                    n3 = 150;
                } else {
                    int n4 = n % 5;
                    if (n4 != 0) {
                        n3 = n4 <= 2 ? n - n4 : n + (5 - n4);
                    }
                }
            } else if (n2 == 0) {
                if (!bl) {
                    n3 = 20;
                } else if (n <= 20) {
                    n3 = 20;
                } else if (n > 240) {
                    n3 = 240;
                } else {
                    int n5 = n % 10;
                    if (n5 != 0) {
                        n3 = n5 <= 4 ? n - n5 : n + (10 - n5);
                    }
                }
            }
            AbstractSpeedWarningManualComponent.this.getLogChannel().log(10000000, "roundSpeedWarningValue: AFTER rounding (%1)", (long)n3);
            return n3;
        }
    }
}

