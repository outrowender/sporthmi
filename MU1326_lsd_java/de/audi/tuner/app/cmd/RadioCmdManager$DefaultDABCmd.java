/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd;

import de.audi.tuner.app.cmd.dab.AbstractDABCmd;
import de.audi.tuner.app.cmd.dab.AbstractDABCmd$Builder;

class RadioCmdManager$DefaultDABCmd
extends AbstractDABCmd {
    RadioCmdManager$DefaultDABCmd(AbstractDABCmd$Builder abstractDABCmd$Builder) {
        super(abstractDABCmd$Builder);
    }

    @Override
    public void execute() {
        throw new IllegalStateException("Calling #execute() for default DAB command no allowed!");
    }
}

