/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.uni;

import de.audi.tuner.app.cmd.uni.AbstractUnifiedCmd;
import de.audi.tuner.app.cmd.uni.AbstractUnifiedCmd$Builder;
import de.esolutions.fw.util.commons.Buffer;

public class SetNotificationUni
extends AbstractUnifiedCmd {
    private final int[] attributes;

    public SetNotificationUni(int[] nArray, AbstractUnifiedCmd$Builder abstractUnifiedCmd$Builder) {
        super(abstractUnifiedCmd$Builder);
        this.attributes = nArray;
        this.setName(new Buffer().append("SetNotificationUni(").append(nArray).append(')').toString());
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[SetNotificationUni.execute] attributes:%1", (Object)this.attributes);
        this.unifiedTuner.setNotification(this.attributes);
        this.commandFinished();
    }
}

