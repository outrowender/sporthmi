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
    public static final short CODING_ID;
    private static final String LOGCHANNEL_NAME;
    private volatile ACCViewOptions currViewOptions;
    private static final int SPEED_LIMIT_OFFSET_LITTLE_UPPER_SPEED;
    private static final int SPEED_LIMIT_OFFSET_MUCH_UPPER_SPEED;
    private static final int SPEED_LIMIT_OFFSET_OFF;
    private static final int SPEED_LIMIT_OFFSET_LITTLE;
    private static final int SPEED_LIMIT_OFFSET_MUCH;
    private volatile int speedLimitOffset = 0;

    public AbstractACCComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.ACC");
    }

    @Override
    protected void initModels() {
        this.getChoiceModel(1529481472).setChoiceListener(this);
        this.getChoiceModel(1646921984).setChoiceListener(this);
        this.getChoiceModel(1495927040).setChoiceListener(this);
        this.getChoiceModel(1579813120).setChoiceListener(this);
        this.getChoiceModel(1613367552).setChoiceListener(this);
        this.getChoiceModel(1680476416).setChoiceListener(this);
        this.getChoiceModel(640682240).setChoiceListener(this);
    }

    @Override
    protected void deinitModels() {
        this.getChoiceModel(1529481472).resetListener();
        this.getChoiceModel(1646921984).resetListener();
        this.getChoiceModel(1495927040).resetListener();
        this.getChoiceModel(1579813120).resetListener();
        this.getChoiceModel(1613367552).resetListener();
        this.getChoiceModel(1680476416).resetListener();
        this.getChoiceModel(640682240).resetListener();
    }

    private void itemSelectedDriveProgram(int n) {
        this.getLogChannel().log(1078071040, "dsi.setACCDrivingProgram(%1)", (long)n);
        this.getDSI().setACCDrivingProgram(n);
    }

    private void itemSelectedTimeGap(int n) {
        this.getLogChannel().log(1078071040, "dsi.setACCTimeGap(%1)", (long)n);
        this.getDSI().setACCTimeGap(n);
    }

    private void itemSelectedCurveAssist(boolean bl) {
        this.getLogChannel().log(1078071040, "dsi.setACCCurveAssist(%1)", bl);
        this.getDSI().setACCCurveAssist(bl);
    }

    private void itemSelectedSpeedLimitAdoption(boolean bl) {
        this.getLogChannel().log(1078071040, "dsi.setACCSpeedLimitAdoption(%1)", bl);
        this.getDSI().setACCSpeedLimitAdoption(bl);
    }

    private void itemSelectedTrafficJamAssist(boolean bl) {
        this.getLogChannel().log(1078071040, "dsi.setACCTrafficJamAssist(%1)", bl);
        this.getDSI().setACCTrafficJamAssist(bl);
    }

    private void itemSelectedLastDistance(boolean bl) {
        this.getLogChannel().log(1078071040, "dsi.setACCDefaultMode(%1)", bl ? 1L : 0L);
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
        this.getLogChannel().log(1078071040, "dsi.setACCSpeedLimitOffset(%1)", (long)this.speedLimitOffset);
        this.getDSI().setACCSpeedLimitOffset(this.speedLimitOffset);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
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

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{24}, new int[]{27, 28, 47, 50, 49, 29})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    public ACCViewOptions getViewOptions() {
        return this.currViewOptions;
    }

    @Override
    public void updateACCViewOptions(ACCViewOptions aCCViewOptions, int n) {
        this.getLogChannel().log(1078071040, "updateACCViewOptions: aCCViewOptions=%1, valid=%2", (Object)aCCViewOptions, (long)n);
        if (n == 1) {
            this.currViewOptions = aCCViewOptions;
            this.updateMenuEntryVisibility(this.currViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void updateACCDrivingProgram(int n, int n2) {
        this.getLogChannel().log(1078071040, "updateACCDrivingProgram: aCCDrivingProgram=%1, valid=%2", (long)n, (long)n2);
        if (n2 == 1) {
            this.getChoiceModel(1529481472).setValue(n);
        }
    }

    @Override
    public void updateACCTimeGap(int n, int n2) {
        this.getLogChannel().log(1078071040, "updateACCTimeGap: aCCTimeGap=%1, valid=%2", (long)n, (long)n2);
        if (n2 == 1) {
            this.getChoiceModel(1646921984).setValue(n);
        }
    }

    @Override
    public void updateACCCurveAssist(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "updateACCCurveAssist: state=%1, valid=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(1495927040).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void updateACCSpeedLimitAdoption(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "updateACCSpeedLimitAdoption: state=%1, valid=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(1579813120).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void updateACCSpeedLimitOffset(int n, int n2) {
        this.getLogChannel().log(1078071040, "updateACCSpeedLimitOffset: offset=%1, valid=%2", (long)n, (long)n2);
        if (n2 == 1) {
            this.speedLimitOffset = n;
            int n3 = this.speedLimitOffset == 0 ? 0 : (this.speedLimitOffset == 1 ? 1 : (this.speedLimitOffset == 2 ? 1 : 2));
            this.getChoiceModel(1613367552).setValue(n3);
        }
    }

    @Override
    public void updateACCDefaultMode(int n, int n2) {
        this.getLogChannel().log(1078071040, "updateACCDefaultMode: aCCDefaultMode=%1, valid=%2", (long)n, (long)n2);
        if (n2 == 1) {
            this.getChoiceModel(640682240).setValue(n);
        }
    }

    @Override
    public void updateACCTrafficJamAssist(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "updateACCTrafficJamAssist: state=%1, valid=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(1680476416).setValue(bl ? 1 : 0);
        }
    }

    protected abstract void updateMenuEntryVisibility(ACCViewOptions aCCViewOptions) {
    }

    @Override
    public String getName() {
        return "Adaptive Cruise Control";
    }
}

