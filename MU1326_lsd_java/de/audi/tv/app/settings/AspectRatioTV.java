/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.displaymanager.Cropping;
import de.audi.atip.interapp.displaymanager.DSIMgnHandler;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.settings.SettingsStorage;

public class AspectRatioTV {
    private static final int DSI_4_3 = 1;
    private static final int ITEM_AUTO = 0;
    private static final int ITEM_4_3 = 1;
    private static final int ITEM_16_9 = 2;
    static final int DEFAULT = 0;
    private static final int DISPLAY_ID = 0;
    private int cid = 26;
    private static final int SRC_X = 0;
    private static final int SRC_Y = 0;
    private static final int SRC_WIDTH = 0;
    private static final int SRC_HEIGHT = 0;
    private volatile int videoFormat;
    private final Object mutex = new Object();
    private volatile boolean isInTerminalMode;
    private final TVEnv env;
    private final SettingsStorage storage;
    private final DSITV dsi;
    private final DSIMgnHandler displayHandler;
    private final ChoiceModelApp ratioChoice;
    private volatile int selectedSource = -1;

    AspectRatioTV(TVEnv tVEnv, SettingsStorage settingsStorage, DSITV dSITV) {
        this.env = tVEnv;
        this.storage = settingsStorage;
        this.dsi = dSITV;
        this.displayHandler = new DSIMgnHandler(tVEnv.framework);
        this.ratioChoice = tVEnv.getChoiceModel(2600085);
        this.ratioChoice.setChoiceListener(new ChoiceListener());
        this.ratioChoice.setValue(0);
    }

    final void setSelectedSource(int n) {
        this.selectedSource = n;
        this.ratioChoice.setValue(this.storage.loadAspectRatioTV());
        this.restore();
    }

    protected void restore() {
        this.env.lcMain.log(10000000, "[AspectRatioTV.restore]");
        int n = this.storage.loadAspectRatioTV();
        this.setAspectRatio(n);
    }

    protected void resetToDefault() {
        this.setAspectRatio(0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setAspectRatio(int n) {
        this.env.lcHMI.log(10000000, "[AspectRatioTV.setAspectRatio] ratio:%1", (long)n);
        this.storage.saveAspectRatioTV(n);
        if (this.selectedSource == 0) {
            Object object = this.mutex;
            synchronized (object) {
                this.ratioChoice.setValue(n);
                this.setCropping();
            }
        }
    }

    public void setCropping() {
        Cropping cropping;
        if (this.selectedSource != 0) {
            return;
        }
        if (this.isInTerminalMode) {
            this.env.lcMain.log(10000000, "[AspectRatioTV.setCropping]update video format to 15:9 for terminal mode.");
            cropping = this.displayHandler.getCropping(2);
        } else {
            switch (this.ratioChoice.getValue()) {
                case 2: {
                    cropping = this.displayHandler.getCropping(1);
                    break;
                }
                case 1: {
                    cropping = this.displayHandler.getCropping(0);
                    break;
                }
                default: {
                    cropping = this.videoFormat == 1 ? this.displayHandler.getCropping(0) : this.displayHandler.getCropping(1);
                }
            }
        }
        this.dsi.setCropping(cropping, 0, this.cid, 0, 0, 0, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void update(int n) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.videoFormat != n) {
                this.videoFormat = n;
                if (this.ratioChoice.getValue() == 0) {
                    this.setCropping();
                }
            }
        }
    }

    public void enterTerminalMode() {
        this.isInTerminalMode = true;
        this.cid = 31;
        this.dsi.setCropping(this.displayHandler.getCropping(2), 0, this.cid, 0, 0, 0, 0);
    }

    public void enterTVMode() {
        this.isInTerminalMode = false;
        this.cid = 26;
        this.restore();
    }

    public void onPowerStateStandby() {
        if (this.isInTerminalMode) {
            this.enterTVMode();
        }
    }

    private class ChoiceListener
    extends DefaultChoiceListener {
        private ChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            if (AspectRatioTV.this.selectedSource == 0) {
                AspectRatioTV.this.setAspectRatio(n2);
            }
        }
    }
}

