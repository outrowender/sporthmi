/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.cmd.AbstractRadioCmd;
import de.audi.tuner.app.cmd.NullRadioCmdManager;

class NullRadioCmdManager$NullRadioCmd
extends AbstractRadioCmd {
    private final /* synthetic */ NullRadioCmdManager this$0;

    NullRadioCmdManager$NullRadioCmd(NullRadioCmdManager nullRadioCmdManager, IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        this.this$0 = nullRadioCmdManager;
        super(iFrameworkAccess, logChannel, -1);
    }

    @Override
    public void execute() {
        NullRadioCmdManager.access$000(this.this$0);
    }
}

