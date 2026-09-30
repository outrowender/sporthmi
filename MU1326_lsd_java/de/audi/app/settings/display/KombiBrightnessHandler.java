/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.display;

import de.audi.app.settings.SettingsEnv;
import de.audi.app.settings.display.KombiBrightnessDsiWrapper;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carkombi.DSICarKombi;

public class KombiBrightnessHandler
extends KombiBrightnessDsiWrapper {
    private final SettingsEnv env;
    private final LogChannel lc;
    private DSICarKombi dsi;
    private volatile int brightness = 50;

    public KombiBrightnessHandler(SettingsEnv settingsEnv) {
        this.env = settingsEnv;
        this.lc = settingsEnv.getFw().getLogChannel("App.Settings.KombiDisplay");
    }

    public void setBrightness(int n) {
        DSICarKombi dSICarKombi = this.dsi;
        if (dSICarKombi != null) {
            this.brightness = n;
            dSICarKombi.setDCBrightness(this.brightness);
            this.env.getFw().getLastmodeHandler().getLastmodeStorage().setKombiBrightness(this.brightness, true);
        }
    }

    public int getBrightness() {
        return this.brightness;
    }

    public void updateDCBrightness(int n, int n2) {
    }

    public void setDSI(DSIBase dSIBase) {
        this.lc.log(100000, "setDSI( %1 )", (Object)dSIBase);
        if (dSIBase == null) {
            this.dsi = null;
            this.lc.log(10000, "KombiBrightnessHandler: DSICarKombi provider is NULL!");
        } else if (dSIBase instanceof DSICarKombi) {
            this.dsi = (DSICarKombi)dSIBase;
            this.brightness = this.env.getFw().getLastmodeHandler().getLastmodeStorage().getKombiBrightness();
        } else {
            this.lc.log(100000, "setDSI( %1 ) failed! wrong class!", (Object)dSIBase);
        }
    }

    public int[] getAutoNotifications() {
        this.lc.log(1000000, "getAutoNotifications()");
        return new int[]{83};
    }

    public void asyncException(int n, String string, int n2) {
        this.lc.log(10000, "asyncException( %2, %1, %3 )", (Object)string, (long)n, (long)n2);
    }
}

