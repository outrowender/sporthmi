/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd;

import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd;
import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd$Builder;

class RadioCmdManager$DefaultAMFMCmd
extends AbstractAMFMCmd {
    RadioCmdManager$DefaultAMFMCmd(AbstractAMFMCmd$Builder abstractAMFMCmd$Builder) {
        super(abstractAMFMCmd$Builder);
    }

    @Override
    public void execute() {
        throw new IllegalStateException("Calling #execute() for AM/FM command no allowed!");
    }
}

