/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.displaymanager.DSIMgnHandler;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.settings.AspectRatioAV$ChoiceListener;
import de.audi.tv.app.settings.SettingsStorage;

public class AspectRatioAV {
    private static final int ITEM_4_3;
    private static final int ITEM_16_9;
    static final int DEFAULT;
    private static final int DISPLAY_ID;
    private static final int CID;
    private static final int SRC_X;
    private static final int SRC_Y;
    private static final int SRC_WIDTH;
    private static final int SRC_HEIGHT;
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
        ChoiceModelApp choiceModelApp = tVEnv.getChoiceModel(-1649662208);
        choiceModelApp.setChoiceListener(new AspectRatioAV$ChoiceListener(this, null));
        choiceModelApp.setValue(1);
    }

    final void setSelectedSource(int n) {
        this.selectedSource = n;
        this.restore();
    }

    protected void restore() {
        this.env.lcMain.log(-2137614336, "[AspectRatioAV.restore]");
        int n = this.storage.loadAspectRatioAV();
        this.setAspectRatio(n);
    }

    protected void resetToDefault() {
        this.setAspectRatio(1);
    }

    private void setAspectRatio(int n) {
        this.env.lcHMI.log(-2137614336, "[AspectRatioAV.setAspectRatio] ratio:%1", (long)n);
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
            this.env.getChoiceModel(-1649662208).setValue(n);
        }
        this.storage.saveAspectRatioAV(n);
    }

    public void enterAVMode() {
        this.restore();
    }

    static /* synthetic */ int access$100(AspectRatioAV aspectRatioAV) {
        return aspectRatioAV.selectedSource;
    }

    static /* synthetic */ void access$200(AspectRatioAV aspectRatioAV, int n) {
        aspectRatioAV.setAspectRatio(n);
    }
}

