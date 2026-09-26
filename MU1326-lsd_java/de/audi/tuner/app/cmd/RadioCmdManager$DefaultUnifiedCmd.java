/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd;

import de.audi.tuner.app.cmd.uni.AbstractUnifiedCmd;
import de.audi.tuner.app.cmd.uni.AbstractUnifiedCmd$Builder;

class RadioCmdManager$DefaultUnifiedCmd
extends AbstractUnifiedCmd {
    RadioCmdManager$DefaultUnifiedCmd(AbstractUnifiedCmd$Builder abstractUnifiedCmd$Builder) {
        super(abstractUnifiedCmd$Builder);
    }

    @Override
    public void execute() {
        throw new IllegalStateException("Calling #execute() for default DAB command no allowed!");
    }
}

