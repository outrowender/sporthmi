/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.cmd.allband.AbstractAllBandCmd;

class RadioCmdManager$DefaultAllBandCmd
extends AbstractAllBandCmd {
    RadioCmdManager$DefaultAllBandCmd(IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        super(iFrameworkAccess, null, logChannel);
    }

    @Override
    public void execute() {
        throw new IllegalStateException("Calling #execute() for all band command no allowed!");
    }
}

