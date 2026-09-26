/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd;

import de.audi.tuner.app.cmd.sdars.AbstractSDARSCmd;
import de.audi.tuner.app.cmd.sdars.AbstractSDARSCmd$Builder;

class RadioCmdManager$DefaultSDARSCmd
extends AbstractSDARSCmd {
    RadioCmdManager$DefaultSDARSCmd(AbstractSDARSCmd$Builder abstractSDARSCmd$Builder) {
        super(abstractSDARSCmd$Builder);
    }

    @Override
    public void execute() {
        throw new IllegalStateException("Calling #execute() for default DAB command no allowed!");
    }
}

