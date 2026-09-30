/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.driveassist;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.driveassist.AbstractDSICarDriverAssistanceAdapter;
import de.audi.app.car.core.app.RangeModelWatcherTimer;
import de.audi.atip.hmi.model.RangeListener;
import org.dsi.ifc.cardriverassistance.SWAViewOptions;

public abstract class AbstractSWAComponent
extends AbstractDSICarDriverAssistanceAdapter
implements RangeListener {
    public static final short CODING_ID = 5;
    private static final String LOGCHANNEL_NAME = "App.Car.SWA";
    private volatile SWAViewOptions currViewOptions;
    private static final int RNG_MIN_BRIGHTNESS = 0;
    private static final int RNG_MAX_BRIGHTNESS = 4;
    private static final int RNG_STEP_BRIGHTNESS = 1;
    private static final int ROTARY_5STEP = 0;
    private static final int ROTARY_6STEP = 1;
    private RangeModelWatcherTimer swaBrightnessRangeModelTimer;
    private static final int VALUE_NOTHING_REQUESTED = -2;
    private static final int VALUE_SYSTEM_OFF = -1;
    private volatile int valueRequested = -2;
    private volatile int currentBrightness = 0;
    private volatile int currentSystemState = 0;

    public AbstractSWAComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.swaBrightnessRangeModelTimer = new RangeModelWatcherTimer("SWA_BRIGHTNESS_RANGE", this.getRangeModel(600405), 1000L, this.getLogChannel());
        this.getRangeModel(600405).setRangeListener(this);
        this.getRangeModel(600405).setLimits(0, 4, 1);
    }

    protected void deinitModels() {
        this.getRangeModel(600405).resetListener();
    }

    private void selectSWASystemType(boolean bl) {
        this.getChoiceModel(600406).setValue(bl ? 1 : 0);
        this.getRangeModel(600405).setLimits(bl ? -1 : 0, 4, 1);
        if (!bl) {
            this.currentSystemState = 1;
        }
    }

    public void decrement(int n, int n2, int n3) {
        this.increment(n, -n2, n3);
    }

    public void increment(int n, int n2, int n3) {
        String string = n2 >= 0 ? "increment:" : "decrement:";
        this.logModelData(string, n, n2, true);
        if (n == 600405) {
            int n4 = AbstractSWAComponent.clip(this.getRangeModel(n).getValue() + n2, this.getRangeModel(n).getMinimum(), this.getRangeModel(n).getMaximum());
            this.getLogChannel().log(1000000, "%1 new value = %2", (Object)string, (long)n4);
            this.swaBrightnessRangeModelTimer.setTempValue(n4);
            if (this.currViewOptions != null && this.currViewOptions.getSystem() != null && this.currViewOptions.getSystem().getState() != 0) {
                if (n4 == -1) {
                    this.getLogChannel().log(1000000, "%1 dsi.setSWASystem OFF (%2)", (Object)string, 0L);
                    this.getDSI().setSWASystem(0);
                } else if (this.currentSystemState == 0 || this.valueRequested == -1) {
                    this.getLogChannel().log(1000000, "%1 dsi.setSWASystem ON (%2)", (Object)string, 1L);
                    this.getDSI().setSWASystem(1);
                }
            }
            if (n4 > -1) {
                if ((this.currentSystemState == 0 || this.valueRequested == -1) && n4 == 0 && this.currentBrightness == 0) {
                    this.getLogChannel().log(10000000, "%1 switching from OFF to MIN_BRIGHTNESS -> don't send dsi.setSWABrightness", (Object)string);
                } else {
                    this.getLogChannel().log(1000000, "%1 dsi.setSWABrightness(%2)", (Object)string, (long)n4);
                    this.getDSI().setSWABrightness(n4);
                }
            }
            this.valueRequested = n4;
        }
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logModelData("keyPressed:", n, n2, true);
        switch (n) {
            case 600405: {
                this.getRangeModel(600405).fireEvent(n3);
                break;
            }
            default: {
                this.logModelData("keyPressed:", n, n2, false);
            }
        }
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{4, 6})};
    }

    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    public SWAViewOptions getViewOptions() {
        return this.currViewOptions;
    }

    public void updateSWAViewOptions(SWAViewOptions sWAViewOptions, int n) {
        this.getLogChannel().log(1000000, "updateSWAViewOptions: swaViewOptions=%1, validFlag=%2", (Object)sWAViewOptions, (long)n);
        if (n == 1) {
            this.currViewOptions = sWAViewOptions;
            this.selectSWASystemType(this.currViewOptions.getSystem().getState() != 0);
            this.updateMenuEntryVisibility(this.currViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateSWABrightness(int n, int n2) {
        this.getLogChannel().log(1000000, "updateSWABrightness: sWABrightness=%1, validFlag=%2", (long)n, (long)n2);
        if (n2 == 1) {
            if (n >= 0 && n <= 4) {
                this.currentBrightness = n;
            } else {
                this.currentBrightness = 0;
                this.getLogChannel().log(100000, "updateSWABrightness value invalid: %1, using %2", (long)n, (long)this.currentBrightness);
            }
            if (this.currentSystemState != 0 || this.getRangeModel(600405).getMinimum() == 0) {
                this.swaBrightnessRangeModelTimer.setValidValue(this.currentBrightness);
            }
        }
    }

    public void updateSWASystem(int n, int n2) {
        this.getLogChannel().log(1000000, "updateSWASystem: sWASystem=%1, validFlag=%2", (long)n, (long)n2);
        if (n2 == 1) {
            this.getLogChannel().log(10000000, "updateSWASystem: valueRequested=%1, currentSystemState=%2, currentBrightness=%3", (long)this.valueRequested, (long)this.currentSystemState, (long)this.currentBrightness);
            if (n == 0) {
                this.getLogChannel().log(1000000, "set brightness model value to %1", -1L);
                this.swaBrightnessRangeModelTimer.setValidValue(-1);
            } else if (n == 1) {
                this.getLogChannel().log(1000000, "set brightness model value to %1", (long)this.currentBrightness);
                this.swaBrightnessRangeModelTimer.setValidValue(this.currentBrightness);
            }
            this.currentSystemState = n;
        }
    }

    protected abstract void updateMenuEntryVisibility(SWAViewOptions var1);

    public String getName() {
        return "SWA / Audi Side Assist";
    }
}

