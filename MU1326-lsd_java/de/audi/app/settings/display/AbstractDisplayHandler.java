/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.display;

import de.audi.app.settings.SettingsEnv;
import de.audi.app.settings.display.KombiBrightnessHandler;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.view.IDisplayManager;
import de.audi.atip.log.LogChannel;

public abstract class AbstractDisplayHandler
implements RangeListener,
ButtonListener {
    protected int rangeBrightnessMin;
    protected int rangeBrightnessMax;
    protected int rangeBrightnessMedial;
    protected int rangeBrightnessStep;
    protected final SettingsEnv env;
    protected LogChannel lc;
    private RangeModelApp brightnessRangeModel;
    private RangeModelApp kombiBrightnessRangeModel;
    private ButtonModelApp switchOffButtonModel;
    private int SWITCH_OFF_BUTTON_MODEL_ID;
    private KombiBrightnessHandler kombiBrightnessHandler;

    public AbstractDisplayHandler(SettingsEnv settingsEnv, KombiBrightnessHandler kombiBrightnessHandler) {
        this.env = settingsEnv;
        this.lc = this.env.getFw().getLogChannel("App.Settings.Display");
        this.kombiBrightnessHandler = kombiBrightnessHandler;
        this.init();
    }

    protected void init() {
        this.initBrightnessConstants();
        this.brightnessRangeModel = this.env.getRangeModel(-1261891584);
        this.brightnessRangeModel.setLimits(this.rangeBrightnessMin, this.rangeBrightnessMax, this.rangeBrightnessStep, this.rangeBrightnessMedial);
        this.brightnessRangeModel.setValue(this.brightnessValueToModelValue(this.readBrightnessFromPersistence()));
        this.brightnessRangeModel.setRangeListener(this);
        this.brightnessRangeModel.setButtonListener(this);
        this.kombiBrightnessRangeModel = this.env.getRangeModel(399118336);
        this.kombiBrightnessRangeModel.setLimits(this.rangeBrightnessMin, this.rangeBrightnessMax, this.rangeBrightnessStep, this.rangeBrightnessMedial);
        if (this.kombiBrightnessHandler != null) {
            this.kombiBrightnessRangeModel.setValue(this.brightnessValueToModelValue(this.kombiBrightnessHandler.getBrightness()));
        }
        this.kombiBrightnessRangeModel.setRangeListener(this);
        this.kombiBrightnessRangeModel.setButtonListener(this);
        this.SWITCH_OFF_BUTTON_MODEL_ID = this.env.getFw().isPorsche() ? 4110 : (this.env.getFw().isPGen2() ? 4110 : -1228337152);
        this.switchOffButtonModel = this.env.getButtonModel(this.SWITCH_OFF_BUTTON_MODEL_ID);
        this.switchOffButtonModel.setButtonListener(this);
    }

    @Override
    public final void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public final void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public final void keyTyped(int n, int n2, int n3) {
        if (n == -1261891584) {
            this.lc.log(1078071040, "rotary display brightness pressed");
            this.env.getRangeModel(n).fireEvent(n3);
        } else if (n == 399118336) {
            this.lc.log(1078071040, "rotary kombi brightness pressed");
            this.env.getRangeModel(n).fireEvent(n3);
        } else if (n == this.SWITCH_OFF_BUTTON_MODEL_ID) {
            this.lc.log(1078071040, "button switch off display pressed");
            this.env.getFw().getPowerMgr().displayButtonTyped(n3, 33);
            this.env.getButtonModel(n).fireEvent(n3);
        }
    }

    @Override
    public final void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public final void increment(int n, int n2, int n3) {
        this.lc.log(1078071040, "increment model '%1', steps: '%2'", (long)n, (long)n2);
        switch (n) {
            case 1100212: {
                IDisplayManager iDisplayManager = this.env.getFw().getHMIService().getDisplayManager();
                int n4 = this.clip(this.env.getRangeModel(n).getValue() + n2, this.rangeBrightnessMin, this.rangeBrightnessMax);
                int n5 = this.modelValueToBrightnessValue(n4);
                this.lc.log(1078071040, "setBrightness() model:%1 brightness:%2", (long)n4, (long)n5);
                iDisplayManager.setDisplayBrightness(n3, n5);
                this.writeBrigthnessToPersistence(n5);
                this.env.getRangeModel(n).setValue(n4);
                break;
            }
            case 1100311: {
                int n6 = this.clip(this.env.getRangeModel(n).getValue() + n2, this.rangeBrightnessMin, this.rangeBrightnessMax);
                int n7 = this.modelValueToBrightnessValue(n6);
                this.lc.log(1078071040, "setBrightness() model:%1 brightness:%2", (long)n6, (long)n7);
                this.kombiBrightnessHandler.setBrightness(n7);
                this.env.getRangeModel(n).setValue(n6);
                break;
            }
        }
    }

    @Override
    public final void decrement(int n, int n2, int n3) {
        this.increment(n, -n2, n3);
    }

    private final int clip(int n, int n2, int n3) {
        return n < n2 ? n2 : (n > n3 ? n3 : n);
    }

    private final int readBrightnessFromPersistence() {
        int n = this.env.getFw().getLastmodeHandler().getLastmodeStorage().getBrightness();
        this.lc.log(1078071040, "readBrightnessFromPersistence() brightness=%1", (long)n);
        return n;
    }

    private final void writeBrigthnessToPersistence(int n) {
        this.lc.log(1078071040, "writeBrigthnessToPersistence(%1)", (long)n);
        this.env.getFw().getLastmodeHandler().getLastmodeStorage().setBrightness(n, true);
    }

    public int getRangeBrightnessStep() {
        return this.rangeBrightnessStep;
    }

    protected abstract int modelValueToBrightnessValue(int n) {
    }

    protected abstract int brightnessValueToModelValue(int n) {
    }

    protected abstract void initBrightnessConstants() {
    }
}

