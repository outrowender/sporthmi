/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.displaymanager.DSIMgnHandler;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.settings.SettingsStorage;

public class AspectRatioAV {
    private static final int ITEM_4_3 = 0;
    private static final int ITEM_16_9 = 1;
    static final int DEFAULT = 1;
    private static final int DISPLAY_ID = 0;
    private static final int CID = 26;
    private static final int SRC_X = 0;
    private static final int SRC_Y = 0;
    private static final int SRC_WIDTH = 0;
    private static final int SRC_HEIGHT = 0;
    private final TVEnv env;
    private final SettingsStorage storage;
    private final DSITV dsi;
    private final DSIMgnHandler displayHandler;
    private volatile int selectedSource = -1;

    AspectRatioAV(TVEnv tVEnv, SettingsStorage settingsStorage, DSITV dSITV) {
        this.env = tVEnv;
        this.storage = settingsStorage;
        this.dsi = dSITV;
        this.displayHandler = new DSIMgnHandler(tVEnv.framework);
        ChoiceModelApp choiceModelApp = tVEnv.getChoiceModel(2600093);
        choiceModelApp.setChoiceListener(new ChoiceListener());
        choiceModelApp.setValue(1);
    }

    final void setSelectedSource(int n) {
        this.selectedSource = n;
        this.restore();
    }

    protected void restore() {
        this.env.lcMain.log(10000000, "[AspectRatioAV.restore]");
        int n = this.storage.loadAspectRatioAV();
        this.setAspectRatio(n);
    }

    protected void resetToDefault() {
        this.setAspectRatio(1);
    }

    private void setAspectRatio(int n) {
        this.env.lcHMI.log(10000000, "[AspectRatioAV.setAspectRatio] ratio:%1", (long)n);
        if (this.selectedSource == 1) {
            switch (n) {
                case 1: {
                    this.dsi.setCropping(this.displayHandler.getCropping(1), 0, 26, 0, 0, 0, 0);
                    break;
                }
                case 0: {
                    this.dsi.setCropping(this.displayHandler.getCropping(0), 0, 26, 0, 0, 0, 0);
                    break;
                }
                default: {
                    throw new IllegalArgumentException(new StringBuffer().append("Invalid ratio selected: ").append(n).toString());
                }
            }
            this.env.getChoiceModel(2600093).setValue(n);
        }
        this.storage.saveAspectRatioAV(n);
    }

    public void enterAVMode() {
        this.restore();
    }

    private class ChoiceListener
    extends DefaultChoiceListener {
        private ChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            if (AspectRatioAV.this.selectedSource == 1) {
                AspectRatioAV.this.setAspectRatio(n2);
            }
        }
    }
}

