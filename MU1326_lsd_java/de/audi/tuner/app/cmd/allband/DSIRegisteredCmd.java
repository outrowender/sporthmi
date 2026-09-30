/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.allband;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.cmd.allband.AbstractAllBandCmd;
import de.audi.tuner.ifc.ISimpleTuner;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.base.DSIBase;

public class DSIRegisteredCmd
extends AbstractAllBandCmd {
    public DSIRegisteredCmd(IFrameworkAccess iFrameworkAccess, ISimpleTuner iSimpleTuner, LogChannel logChannel) {
        super(iFrameworkAccess, iSimpleTuner, logChannel);
        this.setName(new Buffer().append("DSIRegisteredCmd( ").append(iSimpleTuner.getClass().getName()).append(" )"));
    }

    public void execute() {
        this.logExecuteFirstCmd();
        boolean bl = this.tuner.isDsiFound();
        this.logger.log(10000000, "[DSIRegisteredCmd.execute] dsiRegistered:%1", bl);
        if (bl) {
            this.commandFinished();
        }
    }

    protected void commandFinished() {
        this.logFinishFirstCmd();
        super.commandFinished();
    }

    public void dsiRegistered(DSIBase dSIBase) {
        this.logger.log(10000000, "[DSIRegisteredCmd.dsiRegistered] %1", (Object)dSIBase);
        this.commandFinished();
    }
}

