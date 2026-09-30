/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.uni;

import de.audi.tuner.app.cmd.uni.AbstractUnifiedCmd;
import de.esolutions.fw.util.commons.Buffer;

public class SetNotificationUni
extends AbstractUnifiedCmd {
    private final int[] attributes;

    public SetNotificationUni(int[] nArray, AbstractUnifiedCmd.Builder builder) {
        super(builder);
        this.attributes = nArray;
        this.setName(new Buffer().append("SetNotificationUni(").append(nArray).append(')').toString());
    }

    public void execute() {
        this.logger.log(10000000, "[SetNotificationUni.execute] attributes:%1", (Object)this.attributes);
        this.unifiedTuner.setNotification(this.attributes);
        this.commandFinished();
    }
}

