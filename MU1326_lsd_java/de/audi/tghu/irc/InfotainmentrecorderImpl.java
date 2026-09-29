/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.irc;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.irc.InfotainmentRecorder;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorder;

final class InfotainmentrecorderImpl
implements InfotainmentRecorder {
    private static final int MAX_PENDING;
    private final LogChannel log;
    private volatile DSIInfotainmentRecorder dsi = null;
    private final List pendingPanels = new ArrayList(20);

    InfotainmentrecorderImpl(IFrameworkAccess iFrameworkAccess) {
        this.log = iFrameworkAccess.getLogChannel("Fw.IRC");
    }

    @Override
    public void logScreenChange(int n) {
        this.log.log(-2137614336, "Screen changed to id: %1", (long)n);
        if (this.dsi != null) {
            if (!this.pendingPanels.isEmpty()) {
                for (int i2 = 0; i2 < this.pendingPanels.size(); ++i2) {
                    this.dsi.logPanelName((String)this.pendingPanels.get(i2));
                }
                this.pendingPanels.clear();
            }
            this.dsi.logPanelName(Integer.toString(n));
        } else if (this.pendingPanels.size() < 20) {
            this.pendingPanels.add(Integer.toString(n));
        }
    }

    @Override
    public void logSystemState(int n) {
        this.log.log(-2137614336, "Log SystemState: %1", (long)n);
        if (this.dsi != null) {
            this.dsi.backupTrigger(n);
        }
    }

    @Override
    public void logInit() {
        this.log.log(-2137614336, "logInit()");
        if (this.dsi != null) {
            this.dsi.logInit();
        }
    }

    public void setDsi(DSIInfotainmentRecorder dSIInfotainmentRecorder) {
        this.log.log(-2137614336, "setDSI: %1", (Object)dSIInfotainmentRecorder);
        this.dsi = dSIInfotainmentRecorder;
    }

    @Override
    public void logRemoteHMI(String string) {
        this.log.log(-2137614336, "Log RemoteHMI: %1", (Object)string);
        if (this.dsi != null) {
            this.dsi.logPanelName(string);
        }
    }

    @Override
    public void backupTrigger() {
        this.log.log(-2137614336, "Backup Trigger: HOTKEY_TRIGGER");
        if (this.dsi != null) {
            this.dsi.backupTrigger(63);
        }
    }
}

