/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.dab;

import de.audi.tuner.app.cmd.dab.AbstractDABCmd;
import de.esolutions.fw.util.commons.Buffer;

public class SetNotificationDAB
extends AbstractDABCmd {
    private final int[] attributes;

    public SetNotificationDAB(int[] nArray, AbstractDABCmd.Builder builder) {
        super(builder);
        this.attributes = nArray;
        this.setName(new Buffer().append("SetNotificationDAB(").append(nArray).append(')').toString());
    }

    public void execute() {
        this.logger.log(10000000, "[SetNotificationDAB.execute] attributes:%1", (Object)this.attributes);
        this.dabTuner.setNotification(this.attributes);
        this.commandFinished();
    }
}

