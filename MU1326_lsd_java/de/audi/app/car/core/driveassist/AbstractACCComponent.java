/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.driveassist;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.driveassist.AbstractDSICarDriverAssistanceAdapter;
import de.audi.atip.hmi.model.ChoiceListener;
import org.dsi.ifc.cardriverassistance.ACCViewOptions;

public abstract class AbstractACCComponent
extends AbstractDSICarDriverAssistanceAdapter
implements ChoiceListener {
    public static final short CODING_ID = 0;
    private static final String LOGCHANNEL_NAME = "App.Car.ACC";
    private volatile ACCViewOptions currViewOptions;
    private static final int SPEED_LIMIT_OFFSET_LITTLE_UPPER_SPEED = 10;
    private static final int SPEED_LIMIT_OFFSET_MUCH_UPPER_SPEED = 20;
    private static final int SPEED_LIMIT_OFFSET_OFF = 0;
    private static final int SPEED_LIMIT_OFFSET_LITTLE = 1;
    private static final int SPEED_LIMIT_OFFSET_MUCH = 2;
    private volatile int speedLimitOffset = 0;

    public AbstractACCComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.getChoiceModel(600667).setChoiceListener(this);
        this.getChoiceModel(600674).setChoiceListener(this);
        this.getChoiceModel(600665).setChoiceListener(this);
        this.getChoiceModel(600670).setChoiceListener(this);
        this.getChoiceModel(600672).setChoiceListener(this);
        this.getChoiceModel(600676).setChoiceListener(this);
        this.getChoiceModel(602150).setChoiceListener(this);
    }

    protected void deinitModels() {
        this.getChoiceModel(600667).resetListener();
        this.getChoiceModel(600674).resetListener();
        this.getChoiceModel(600665).resetListener();
        this.getChoiceModel(600670).resetListener();
        this.getChoiceModel(600672).resetListener();
        this.getChoiceModel(600676).resetListener();
        this.getChoiceModel(602150).resetListener();
    }

    private void itemSelectedDriveProgram(int n) {
        this.getLogChannel().log(1000000, "dsi.setACCDrivingProgram(%1)", (long)n);
        this.getDSI().setACCDrivingProgram(n);
    }

    private void itemSelectedTimeGap(int n) {
        this.getLogChannel().log(1000000, "dsi.setACCTimeGap(%1)", (long)n);
        this.getDSI().setACCTimeGap(n);
    }

    private void itemSelectedCurveAssist(boolean bl) {
        this.getLogChannel().log(1000000, "dsi.setACCCurveAssist(%1)", bl);
        this.getDSI().setACCCurveAssist(bl);
    }

    private void itemSelectedSpeedLimitAdoption(boolean bl) {
        this.getLogChannel().log(1000000, "dsi.setACCSpeedLimitAdoption(%1)", bl);
        this.getDSI().setACCSpeedLimitAdoption(bl);
    }

    private void itemSelectedTrafficJamAssist(boolean bl) {
        this.getLogChannel().log(1000000, "dsi.setACCTrafficJamAssist(%1)", bl);
        this.getDSI().setACCTrafficJamAssist(bl);
    }

    private void itemSelectedLastDistance(boolean bl) {
        this.getLogChannel().log(1000000, "dsi.setACCDefaultMode(%1)", bl ? 1L : 0L);
        this.getDSI().setACCDefaultMode(bl ? 1 : 0);
    }

    private void itemSelectedSpeedLimitOffset(int n) {
        switch (n) {
            case 0: {
                this.speedLimitOffset = 0;
                break;
            }
            case 1: {
                this.speedLimitOffset = 1;
                break;
            }
            case 2: {
                this.speedLimitOffset = 3;
                break;
            }
            default: {
                this.speedLimitOffset = 0;
            }
        }
        this.getLogChannel().log(1000000, "dsi.setACCSpeedLimitOffset(%1)", (long)this.speedLimitOffset);
        this.getDSI().setACCSpeedLimitOffset(this.speedLimitOffset);
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logModelData("itemSelected:", n, n2, true);
        switch (n) {
            case 600674: {
                this.itemSelectedTimeGap(n2);
                break;
            }
            case 600667: {
                this.itemSelectedDriveProgram(n2);
                break;
            }
            case 600665: {
                this.itemSelectedCurveAssist(n2 == 1);
                break;
            }
            case 600670: {
                this.itemSelectedSpeedLimitAdoption(n2 == 1);
                break;
            }
            case 600672: {
                this.itemSelectedSpeedLimitOffset(n2);
                break;
            }
            case 600676: {
                this.itemSelectedTrafficJamAssist(n2 == 1);
                break;
            }
            case 602150: {
                this.itemSelectedLastDistance(n2 == 1);
                break;
            }
            default: {
                this.logModelData("itemSelected:", n, n2, false);
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{24}, new int[]{27, 28, 47, 50, 49, 29})};
    }

    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    public ACCViewOptions getViewOptions() {
        return this.currViewOptions;
    }

    public void updateACCViewOptions(ACCViewOptions aCCViewOptions, int n) {
        this.getLogChannel().log(1000000, "updateACCViewOptions: aCCViewOptions=%1, valid=%2", (Object)aCCViewOptions, (long)n);
        if (n == 1) {
            this.currViewOptions = aCCViewOptions;
            this.updateMenuEntryVisibility(this.currViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateACCDrivingProgram(int n, int n2) {
        this.getLogChannel().log(1000000, "updateACCDrivingProgram: aCCDrivingProgram=%1, valid=%2", (long)n, (long)n2);
        if (n2 == 1) {
            this.getChoiceModel(600667).setValue(n);
        }
    }

    public void updateACCTimeGap(int n, int n2) {
        this.getLogChannel().log(1000000, "updateACCTimeGap: aCCTimeGap=%1, valid=%2", (long)n, (long)n2);
        if (n2 == 1) {
            this.getChoiceModel(600674).setValue(n);
        }
    }

    public void updateACCCurveAssist(boolean bl, int n) {
        this.getLogChannel().log(1000000, "updateACCCurveAssist: state=%1, valid=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(600665).setValue(bl ? 1 : 0);
        }
    }

    public void updateACCSpeedLimitAdoption(boolean bl, int n) {
        this.getLogChannel().log(1000000, "updateACCSpeedLimitAdoption: state=%1, valid=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(600670).setValue(bl ? 1 : 0);
        }
    }

    public void updateACCSpeedLimitOffset(int n, int n2) {
        this.getLogChannel().log(1000000, "updateACCSpeedLimitOffset: offset=%1, valid=%2", (long)n, (long)n2);
        if (n2 == 1) {
            this.speedLimitOffset = n;
            int n3 = this.speedLimitOffset == 0 ? 0 : (this.speedLimitOffset == 1 ? 1 : (this.speedLimitOffset == 2 ? 1 : 2));
            this.getChoiceModel(600672).setValue(n3);
        }
    }

    public void updateACCDefaultMode(int n, int n2) {
        this.getLogChannel().log(1000000, "updateACCDefaultMode: aCCDefaultMode=%1, valid=%2", (long)n, (long)n2);
        if (n2 == 1) {
            this.getChoiceModel(602150).setValue(n);
        }
    }

    public void updateACCTrafficJamAssist(boolean bl, int n) {
        this.getLogChannel().log(1000000, "updateACCTrafficJamAssist: state=%1, valid=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(600676).setValue(bl ? 1 : 0);
        }
    }

    protected abstract void updateMenuEntryVisibility(ACCViewOptions var1);

    public String getName() {
        return "Adaptive Cruise Control";
    }
}

