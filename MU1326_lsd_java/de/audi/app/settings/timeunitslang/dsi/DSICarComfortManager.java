/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.timeunitslang.dsi;

import de.audi.app.settings.SettingsEnv;
import de.audi.app.settings.timeunitslang.dsi.DsiCarComfortManagerDsiWrapper;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.carcomfort.RDKViewOptions;

public class DSICarComfortManager
extends DsiCarComfortManagerDsiWrapper {
    private SettingsEnv env;
    private LogChannel lc;
    private DSICarComfort dsi;

    public DSICarComfortManager(SettingsEnv settingsEnv) {
        this.env = settingsEnv;
        this.lc = this.env.getFw().getLogChannel("App.Settings.DSI");
    }

    public void setDSI(DSICarComfort dSICarComfort) {
        this.lc.log(10000000, "setDSICarComfort(%1)", (Object)dSICarComfort);
        if (null != dSICarComfort) {
            this.dsi = dSICarComfort;
            this.dsi.setNotification(33, (DSIListener)this);
        } else {
            this.dsi = null;
        }
    }

    public void updateRDKViewOptions(RDKViewOptions rDKViewOptions, int n) {
        this.lc.log(10000000, "updateRDKViewOptions(%1, %2)", (Object)rDKViewOptions, (long)n);
        if (n == 1) {
            this.env.getUnitHandler().updateRDKViewOptions(rDKViewOptions);
        }
    }
}

