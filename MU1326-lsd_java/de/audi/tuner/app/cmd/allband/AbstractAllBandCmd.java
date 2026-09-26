/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.allband;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.cmd.AbstractRadioCmd;
import de.audi.tuner.app.cmd.allband.AllBandCmdListener;
import de.audi.tuner.ifc.ISimpleTuner;
import org.dsi.ifc.base.DSIBase;

public abstract class AbstractAllBandCmd
extends AbstractRadioCmd
implements AllBandCmdListener {
    protected final ISimpleTuner tuner;

    protected AbstractAllBandCmd(IFrameworkAccess iFrameworkAccess, ISimpleTuner iSimpleTuner, LogChannel logChannel) {
        super(iFrameworkAccess, logChannel, 5);
        this.tuner = iSimpleTuner;
    }

    public final boolean supports(ISimpleTuner iSimpleTuner) {
        if (this.tuner == null || iSimpleTuner == null) {
            return false;
        }
        return this.tuner.equals(iSimpleTuner);
    }

    @Override
    public void dsiRegistered(DSIBase dSIBase) {
    }
}

