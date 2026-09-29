/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.allband;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.cmd.allband.AbstractAllBandCmd;
import de.audi.tuner.ifc.ISimpleTuner;
import de.esolutions.fw.util.commons.Buffer;

public class InitSetupCmd
extends AbstractAllBandCmd {
    public InitSetupCmd(IFrameworkAccess iFrameworkAccess, ISimpleTuner iSimpleTuner, LogChannel logChannel) {
        super(iFrameworkAccess, iSimpleTuner, logChannel);
        this.setName(new Buffer().append("InitSetupCmd( ").append(super.getClass().getName()).append(" )"));
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[InitSetupCmd.execute] ");
        this.tuner.initSetup();
        this.commandFinished();
    }
}

