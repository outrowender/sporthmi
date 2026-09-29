/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.kombi;

import de.audi.app.car.common.comp.AbstractCarComponent;
import de.audi.app.car.core.kombi.AbstractSpeedWarningManualComponent;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.metrics.Speed;
import org.dsi.ifc.carkombi.BCSpeedWarningSettings;

class AbstractSpeedWarningManualComponent$SpeedWarningHandler {
    public static final int OFF_KMH;
    public static final int MAX_KMH;
    public static final int STEP_KMH;
    public static final int OFF_MPH;
    public static final int MAX_MPH;
    public static final int STEP_MPH;
    private static final int TEXT_OFF_VISIBLE;
    private static final int TEXT_SPEED_VISIBLE;
    private BCSpeedWarningSettings currentSpeedWarning = new BCSpeedWarningSettings();
    private int changedSpeed;
    private final ModelGroup rotaryLabelsGroup = new ModelGroup();
    private MetricsModelApp currentLimitModel;
    private MetricsModelApp maxLimitModel;
    private RangeModelApp rangeModel;
    private ChoiceModelApp switchTextModel;
    private final /* synthetic */ AbstractSpeedWarningManualComponent this$0;

    AbstractSpeedWarningManualComponent$SpeedWarningHandler(AbstractSpeedWarningManualComponent abstractSpeedWarningManualComponent) {
        this.this$0 = abstractSpeedWarningManualComponent;
    }

    void initModels() {
        this.currentLimitModel = AbstractSpeedWarningManualComponent.access$000(this.this$0, -1440085760);
        Speed speed = new Speed(41025, 1);
        speed.setUseInstanceUnit(true);
        this.currentLimitModel.setMetric(speed);
        this.currentLimitModel.formatChanged();
        this.rangeModel = AbstractSpeedWarningManualComponent.access$100(this.this$0, -1423308544);
        this.maxLimitModel = AbstractSpeedWarningManualComponent.access$200(this.this$0, -1305868032);
        this.switchTextModel = AbstractSpeedWarningManualComponent.access$300(this.this$0, -1339422464);
        this.rangeModel.setValue(20);
        this.rangeModel.setLimits(20, 240, 10);
        this.rangeModel.setMedialPosition(20);
        Speed speed2 = new Speed(28739, 1);
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
            Speed speed2 = bl ? new Speed(28739, 1) : new Speed(5699, 2);
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
        this.this$0.getLogChannel().log(-2137614336, "changeSetting: speed=%1", (long)n2);
        this.updateSpeedValues(n2, this.currentSpeedWarning.getSpeedUnit());
    }

    void resetChangeSetting() {
        this.this$0.getLogChannel().log(-2137614336, "resetChangeSetting: resetting to '%1'", (Object)this.currentSpeedWarning);
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
        this.this$0.getLogChannel().log(-2137614336, "roundSpeedWarningValue: BEFORE rounding (%1)", (long)n);
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
        this.this$0.getLogChannel().log(-2137614336, "roundSpeedWarningValue: AFTER rounding (%1)", (long)n3);
        return n3;
    }
}

