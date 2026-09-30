/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.amfm;

import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd;
import de.esolutions.fw.util.commons.Buffer;

public class SetNotificationAMFM
extends AbstractAMFMCmd {
    private final int[] attributes;

    public SetNotificationAMFM(int[] nArray, AbstractAMFMCmd.Builder builder) {
        super(builder);
        this.attributes = nArray;
        this.setName(new Buffer().append("SetNotificationAMFM(").append(nArray).append(')').toString());
    }

    public void execute() {
        this.logger.log(10000000, "[SetNotificationAMFM.execute] attributes:%1", (Object)this.attributes);
        this.tuner.setNotification(this.attributes);
        this.commandFinished();
    }
}

