/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.settings.SettingsStorage;

public class AVNorm {
    private static final int ITEM_AUTO = 0;
    private static final int ITEM_PAL = 1;
    private static final int ITEM_NTSC = 2;
    static final int DEFAULT = 0;
    private final TVEnv env;
    private final SettingsStorage storage;
    private final DSITV dsi;

    AVNorm(TVEnv tVEnv, SettingsStorage settingsStorage, DSITV dSITV) {
        this.env = tVEnv;
        this.storage = settingsStorage;
        this.dsi = dSITV;
        ChoiceModelApp choiceModelApp = tVEnv.getChoiceModel(2600099);
        choiceModelApp.setChoiceListener(new ChoiceListener());
        choiceModelApp.setValue(0);
    }

    private void choiceItemSelected(int n) {
        int n2;
        this.env.lcHMI.log(10000000, "[AVNorm.choiceItemSelected] item:%1", (long)n);
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid AV-Norm choice model value: ").append(n).toString());
            }
        }
        this.dsi.setAVNorm(n2);
        this.env.getChoiceModel(2600099).setValue(n);
        this.storage.saveAVNorm(n);
    }

    protected void restore() {
        int n = this.storage.loadAVNorm();
        this.choiceItemSelected(n);
    }

    protected void resetToDefault() {
        this.choiceItemSelected(0);
    }

    public static String toString(int n) {
        switch (n) {
            case 0: {
                return "AVNORM_AUTO";
            }
            case 1: {
                return "AVNORM_PAL";
            }
            case 2: {
                return "AVNORM_NTSC";
            }
        }
        return Integer.toString(n);
    }

    private class ChoiceListener
    extends DefaultChoiceListener {
        private ChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            AVNorm.this.choiceItemSelected(n2);
        }
    }
}

