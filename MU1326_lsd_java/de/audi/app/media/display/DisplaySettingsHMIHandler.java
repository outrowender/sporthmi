/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.display;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.display.DisplaySettingManager;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.modelaccess.RangeModelApp;

public class DisplaySettingsHMIHandler
extends AbstractMediaTerminalComponent
implements RangeListener {
    private static final String LOGCLASS = "DisplaySettingsHMIHandler";
    public static final int DEFAULT = 0;
    private static final int MIN = -120;
    private static final int MAX = 120;
    private static final int STEPS = 10;
    private final DisplaySettingManager manager;
    private volatile boolean dsiUpdatePending = true;
    private volatile boolean settingsChanged = false;

    public DisplaySettingsHMIHandler(IMediaTerminal iMediaTerminal, DisplaySettingManager displaySettingManager) {
        super(iMediaTerminal);
        this.manager = displaySettingManager;
    }

    public void init() {
        this.logger.main().log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.getRangeModel(200561).setLimits(-120, 120, 10);
        this.getRangeModel(200562).setLimits(-120, 120, 10);
        this.getRangeModel(200568).setLimits(-120, 120, 10);
        this.getRangeModel(200569).setLimits(-120, 120, 10);
        this.getRangeModel(200561).setValue(0);
        this.getRangeModel(200562).setValue(0);
        this.getRangeModel(200568).setValue(0);
        this.getRangeModel(200569).setValue(0);
        this.getRangeModel(200561).setRangeListener(this);
        this.getRangeModel(200562).setRangeListener(this);
        this.getRangeModel(200568).setRangeListener(this);
        this.getRangeModel(200569).setRangeListener(this);
        this.getRangeModel(200569).setStatus(0);
    }

    public void deinit() {
        this.logger.main().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.getRangeModel(200561).setRangeListener(null);
        this.getRangeModel(200562).setRangeListener(null);
        this.getRangeModel(200568).setRangeListener(null);
        this.getRangeModel(200569).setRangeListener(null);
    }

    public void decrement(int n, int n2, int n3) {
        this.change(n, -n2);
    }

    public void increment(int n, int n2, int n3) {
        this.change(n, n2);
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 200561: {
                this.logger.hmi().log(1000000, "[%1.keyTyped] BRIGHTNESS.", (Object)LOGCLASS);
                this.getRangeModel(200561).fireEvent(n3);
                break;
            }
            case 200562: {
                this.logger.hmi().log(1000000, "[%1.keyTyped] COLOR.", (Object)LOGCLASS);
                this.getRangeModel(200562).fireEvent(n3);
                break;
            }
            case 200568: {
                this.logger.hmi().log(1000000, "[%1.keyTyped] CONSTRAST.", (Object)LOGCLASS);
                this.getRangeModel(200568).fireEvent(n3);
                break;
            }
            case 200569: {
                this.logger.hmi().log(1000000, "[%1.keyTyped] TINT.", (Object)LOGCLASS);
                this.getRangeModel(200569).fireEvent(n3);
                break;
            }
            default: {
                this.logger.hmi().log(100000, "[%1.keyTyped] Undefined key event. modelID='%2'.", (Object)LOGCLASS, (long)n);
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    private void change(int n, int n2) {
        if (this.dsiUpdatePending) {
            this.logger.hmi().log(1000000, "[%1.change] A DSI update is pending: ignore request to change model %1.", (Object)LOGCLASS, (long)n);
            return;
        }
        this.dsiUpdatePending = true;
        this.settingsChanged = true;
        switch (n) {
            case 200561: {
                this.logger.hmi().log(1000000, "[%1.change] BRIGHTNESS (steps='%2').", (Object)LOGCLASS, (long)n2);
                this.manager.setBrightness(this.calculateNewValue(this.getRangeModel(200561), n2, "BRIGHTNESS"));
                break;
            }
            case 200562: {
                this.logger.hmi().log(1000000, "[%1.change] COLOUR (steps='%2').", (Object)LOGCLASS, (long)n2);
                this.manager.setColor(this.calculateNewValue(this.getRangeModel(200562), n2, "COLOR"));
                break;
            }
            case 200568: {
                this.logger.hmi().log(1000000, "[%1.change] CONTRAST (steps='%2').", (Object)LOGCLASS, (long)n2);
                this.manager.setContrast(this.calculateNewValue(this.getRangeModel(200568), n2, "CONTRAST"));
                break;
            }
            case 200569: {
                this.logger.hmi().log(1000000, "[%1.change] TINT (steps='%2').", (Object)LOGCLASS, (long)n2);
                this.manager.setTint(this.calculateNewValue(this.getRangeModel(200569), n2, "TINT"));
                break;
            }
            default: {
                this.logger.hmi().log(10000, "[%1.change] Unknown model '%2'.", (Object)LOGCLASS, (long)n);
            }
        }
    }

    private static int normalize(int n, RangeModelApp rangeModelApp) {
        int n2 = rangeModelApp.getStep();
        int n3 = (int)Math.floor(n / n2);
        return n3 * n2;
    }

    protected void resetDSIUpdateState() {
        this.dsiUpdatePending = false;
    }

    void setTintMode(boolean bl) {
        this.logger.hmi().log(10000000, "[%1.setTintMode] '%2'.", (Object)LOGCLASS, (Object)String.valueOf(bl));
        if (bl) {
            this.manager.getRangeModel(200569).setStatus(1);
        } else {
            this.manager.getRangeModel(200569).setStatus(0);
        }
    }

    public int getBrightness() {
        return this.getRangeModel(200561).getValue();
    }

    public void setBrightness(int n) {
        this.logger.hmi().log(1000000, "[%1.setBrightness] '%2'.", (Object)LOGCLASS, (long)n);
        this.getRangeModel(200561).setValue(DisplaySettingsHMIHandler.normalize(n, this.getRangeModel(200561)));
        this.resetDSIUpdateState();
    }

    public int getColor() {
        return this.getRangeModel(200562).getValue();
    }

    public void setColor(int n) {
        this.logger.hmi().log(1000000, "[%1.setColor] '%2'.", (Object)LOGCLASS, (long)n);
        this.getRangeModel(200562).setValue(DisplaySettingsHMIHandler.normalize(n, this.getRangeModel(200562)));
        this.resetDSIUpdateState();
    }

    public int getContrast() {
        return this.getRangeModel(200568).getValue();
    }

    public void setContrast(int n) {
        this.logger.hmi().log(1000000, "[%1.setContrast] '%2'.", (Object)LOGCLASS, (long)n);
        this.getRangeModel(200568).setValue(DisplaySettingsHMIHandler.normalize(n, this.getRangeModel(200568)));
        this.resetDSIUpdateState();
    }

    public int getTint() {
        return this.getRangeModel(200569).getValue();
    }

    public void setTint(int n) {
        this.logger.hmi().log(1000000, "[%1.setTint] '%2'.", (Object)LOGCLASS, (long)n);
        this.getRangeModel(200569).setValue(DisplaySettingsHMIHandler.normalize(n, this.getRangeModel(200569)));
        this.resetDSIUpdateState();
    }

    boolean haveSettingsChanged() {
        if (this.settingsChanged) {
            this.settingsChanged = false;
            return true;
        }
        return false;
    }

    private int calculateNewValue(RangeModelApp rangeModelApp, int n, String string) {
        int n2 = rangeModelApp.getValue() + n;
        int n3 = rangeModelApp.getMinimum();
        int n4 = rangeModelApp.getMaximum();
        if (n < 0 && n2 <= n3) {
            this.logger.hmi().log(10000000, "[%1.calculateNewValue] [%2] Min '%3' reached. ", (Object)LOGCLASS, (Object)string, (long)n3);
            return n3;
        }
        if (n > 0 && n2 >= n4) {
            this.logger.hmi().log(10000000, "[%1.calculateNewValue] [%2] Max '%3' reached. ", (Object)LOGCLASS, (Object)string, (long)n4);
            return n4;
        }
        this.logger.hmi().log(10000000, "[%1.calculateNewValue] [%2] '%3' ", (Object)LOGCLASS, (Object)string, (long)n2);
        return n2;
    }
}

