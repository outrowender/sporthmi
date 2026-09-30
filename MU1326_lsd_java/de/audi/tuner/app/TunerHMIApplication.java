/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.tuner.app.HmiAppListener;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.ifc.ITunerVariantExt;

public class TunerHMIApplication
implements HMIApplication {
    public static final int HMI_APP_ID = 1;
    private final TunerModels models;
    private final Logger logger;
    private final ITunerVariantExt varExt;
    private HmiAppListener[] listener = new HmiAppListener[0];

    TunerHMIApplication(TunerBasics tunerBasics, ITunerVariantExt iTunerVariantExt) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.varExt = iTunerVariantExt;
    }

    public void addListener(HmiAppListener hmiAppListener) {
        HmiAppListener[] hmiAppListenerArray = new HmiAppListener[this.listener.length + 1];
        System.arraycopy((Object)this.listener, 0, (Object)hmiAppListenerArray, 0, this.listener.length);
        hmiAppListenerArray[this.listener.length] = hmiAppListener;
        this.listener = hmiAppListenerArray;
    }

    public int getId() {
        return 1;
    }

    public ButtonModelApp getVirtualButton(int n) {
        switch (n) {
            case 0: {
                return this.models.getButtonModel(100429);
            }
            case 1: {
                return this.models.getButtonModel(100428);
            }
            case 13: {
                return this.models.getButtonModel(100436);
            }
            case 43: {
                return this.models.getButtonModel(100285);
            }
        }
        int n2 = this.varExt.getVirtualButtonModel(n);
        if (n2 != -1) {
            return this.models.getButtonModel(n2);
        }
        return null;
    }

    public void popupVisible(int n, int n2) {
        this.logger.hmi.log(10000000, "Popup %1 is visible ", (long)n);
    }

    public void popupHidden(int n, int n2) {
        this.logger.hmi.log(10000000, "Popup %1 is hidden ", (long)n);
    }

    public void popupRemoved(int n, int n2) {
        this.logger.hmi.log(10000000, "Popup %1 is removed ", (long)n);
    }

    public void screenVisible(int n, int n2) {
        this.logger.hmi.log(10000000, "[TunerHMIApplication.screenVisible] screen:%1", (long)n);
    }

    public void screenHidden(int n, int n2) {
        this.logger.hmi.log(10000000, "[TunerHMIApplication.screenHidden] screen:%1", (long)n);
    }

    public void screenFadedOut(int n, int n2) {
        for (int i2 = 0; i2 < this.listener.length; ++i2) {
            this.listener[i2].screenFadedOut(n, n2);
        }
    }

    public void screenConnected(int n, int n2) {
    }
}

