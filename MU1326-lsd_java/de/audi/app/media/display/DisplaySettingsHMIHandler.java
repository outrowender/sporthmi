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
    private static final String LOGCLASS;
    public static final int DEFAULT;
    private static final int MIN;
    private static final int MAX;
    private static final int STEPS;
    private final DisplaySettingManager manager;
    private volatile boolean dsiUpdatePending = true;
    private volatile boolean settingsChanged = false;

    public DisplaySettingsHMIHandler(IMediaTerminal iMediaTerminal, DisplaySettingManager displaySettingManager) {
        super(iMediaTerminal);
        this.manager = displaySettingManager;
    }

    public void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"DisplaySettingsHMIHandler");
        this.getRangeModel(1896809216).setLimits(-120, 120, 10);
        this.getRangeModel(1913586432).setLimits(-120, 120, 10);
        this.getRangeModel(2014249728).setLimits(-120, 120, 10);
        this.getRangeModel(2031026944).setLimits(-120, 120, 10);
        this.getRangeModel(1896809216).setValue(0);
        this.getRangeModel(1913586432).setValue(0);
        this.getRangeModel(2014249728).setValue(0);
        this.getRangeModel(2031026944).setValue(0);
        this.getRangeModel(1896809216).setRangeListener(this);
        this.getRangeModel(1913586432).setRangeListener(this);
        this.getRangeModel(2014249728).setRangeListener(this);
        this.getRangeModel(2031026944).setRangeListener(this);
        this.getRangeModel(2031026944).setStatus(0);
    }

    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"DisplaySettingsHMIHandler");
        this.getRangeModel(1896809216).setRangeListener(null);
        this.getRangeModel(1913586432).setRangeListener(null);
        this.getRangeModel(2014249728).setRangeListener(null);
        this.getRangeModel(2031026944).setRangeListener(null);
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        this.change(n, -n2);
    }

    @Override
    public void increment(int n, int n2, int n3) {
        this.change(n, n2);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 200561: {
                this.logger.hmi().log(1078071040, "[%1.keyTyped] BRIGHTNESS.", (Object)"DisplaySettingsHMIHandler");
                this.getRangeModel(1896809216).fireEvent(n3);
                break;
            }
            case 200562: {
                this.logger.hmi().log(1078071040, "[%1.keyTyped] COLOR.", (Object)"DisplaySettingsHMIHandler");
                this.getRangeModel(1913586432).fireEvent(n3);
                break;
            }
            case 200568: {
                this.logger.hmi().log(1078071040, "[%1.keyTyped] CONSTRAST.", (Object)"DisplaySettingsHMIHandler");
                this.getRangeModel(2014249728).fireEvent(n3);
                break;
            }
            case 200569: {
                this.logger.hmi().log(1078071040, "[%1.keyTyped] TINT.", (Object)"DisplaySettingsHMIHandler");
                this.getRangeModel(2031026944).fireEvent(n3);
                break;
            }
            default: {
                this.logger.hmi().log(-1601830656, "[%1.keyTyped] Undefined key event. modelID='%2'.", (Object)"DisplaySettingsHMIHandler", (long)n);
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    private void change(int n, int n2) {
        if (this.dsiUpdatePending) {
            this.logger.hmi().log(1078071040, "[%1.change] A DSI update is pending: ignore request to change model %1.", (Object)"DisplaySettingsHMIHandler", (long)n);
            return;
        }
        this.dsiUpdatePending = true;
        this.settingsChanged = true;
        switch (n) {
            case 200561: {
                this.logger.hmi().log(1078071040, "[%1.change] BRIGHTNESS (steps='%2').", (Object)"DisplaySettingsHMIHandler", (long)n2);
                this.manager.setBrightness(this.calculateNewValue(this.getRangeModel(1896809216), n2, "BRIGHTNESS"));
                break;
            }
            case 200562: {
                this.logger.hmi().log(1078071040, "[%1.change] COLOUR (steps='%2').", (Object)"DisplaySettingsHMIHandler", (long)n2);
                this.manager.setColor(this.calculateNewValue(this.getRangeModel(1913586432), n2, "COLOR"));
                break;
            }
            case 200568: {
                this.logger.hmi().log(1078071040, "[%1.change] CONTRAST (steps='%2').", (Object)"DisplaySettingsHMIHandler", (long)n2);
                this.manager.setContrast(this.calculateNewValue(this.getRangeModel(2014249728), n2, "CONTRAST"));
                break;
            }
            case 200569: {
                this.logger.hmi().log(1078071040, "[%1.change] TINT (steps='%2').", (Object)"DisplaySettingsHMIHandler", (long)n2);
                this.manager.setTint(this.calculateNewValue(this.getRangeModel(2031026944), n2, "TINT"));
                break;
            }
            default: {
                this.logger.hmi().log(10000, "[%1.change] Unknown model '%2'.", (Object)"DisplaySettingsHMIHandler", (long)n);
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
        this.logger.hmi().log(-2137614336, "[%1.setTintMode] '%2'.", (Object)"DisplaySettingsHMIHandler", (Object)String.valueOf(bl));
        if (bl) {
            this.manager.getRangeModel(2031026944).setStatus(1);
        } else {
            this.manager.getRangeModel(2031026944).setStatus(0);
        }
    }

    public int getBrightness() {
        return this.getRangeModel(1896809216).getValue();
    }

    public void setBrightness(int n) {
        this.logger.hmi().log(1078071040, "[%1.setBrightness] '%2'.", (Object)"DisplaySettingsHMIHandler", (long)n);
        this.getRangeModel(1896809216).setValue(DisplaySettingsHMIHandler.normalize(n, this.getRangeModel(1896809216)));
        this.resetDSIUpdateState();
    }

    public int getColor() {
        return this.getRangeModel(1913586432).getValue();
    }

    public void setColor(int n) {
        this.logger.hmi().log(1078071040, "[%1.setColor] '%2'.", (Object)"DisplaySettingsHMIHandler", (long)n);
        this.getRangeModel(1913586432).setValue(DisplaySettingsHMIHandler.normalize(n, this.getRangeModel(1913586432)));
        this.resetDSIUpdateState();
    }

    public int getContrast() {
        return this.getRangeModel(2014249728).getValue();
    }

    public void setContrast(int n) {
        this.logger.hmi().log(1078071040, "[%1.setContrast] '%2'.", (Object)"DisplaySettingsHMIHandler", (long)n);
        this.getRangeModel(2014249728).setValue(DisplaySettingsHMIHandler.normalize(n, this.getRangeModel(2014249728)));
        this.resetDSIUpdateState();
    }

    public int getTint() {
        return this.getRangeModel(2031026944).getValue();
    }

    public void setTint(int n) {
        this.logger.hmi().log(1078071040, "[%1.setTint] '%2'.", (Object)"DisplaySettingsHMIHandler", (long)n);
        this.getRangeModel(2031026944).setValue(DisplaySettingsHMIHandler.normalize(n, this.getRangeModel(2031026944)));
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
            this.logger.hmi().log(-2137614336, "[%1.calculateNewValue] [%2] Min '%3' reached. ", (Object)"DisplaySettingsHMIHandler", (Object)string, (long)n3);
            return n3;
        }
        if (n > 0 && n2 >= n4) {
            this.logger.hmi().log(-2137614336, "[%1.calculateNewValue] [%2] Max '%3' reached. ", (Object)"DisplaySettingsHMIHandler", (Object)string, (long)n4);
            return n4;
        }
        this.logger.hmi().log(-2137614336, "[%1.calculateNewValue] [%2] '%3' ", (Object)"DisplaySettingsHMIHandler", (Object)string, (long)n2);
        return n2;
    }
}

