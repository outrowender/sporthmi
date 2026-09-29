/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.info.readout;

import de.audi.app.info.readout.InfoUrgentPopupHandler;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.tmc.readout.AppTMCReadOut;

public class InfoTMCReadOut
extends AppTMCReadOut {
    public InfoTMCReadOut(LogChannel logChannel, LogChannel logChannel2, InfoEnv infoEnv) {
        super(logChannel, logChannel2, infoEnv);
        this.urgentPopupHandler = new InfoUrgentPopupHandler(this.logChMain, infoEnv);
    }
}

