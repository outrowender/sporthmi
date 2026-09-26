/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.amfm;

import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd;
import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd$Builder;
import de.esolutions.fw.util.commons.Buffer;

public class SetNotificationAMFM
extends AbstractAMFMCmd {
    private final int[] attributes;

    public SetNotificationAMFM(int[] nArray, AbstractAMFMCmd$Builder abstractAMFMCmd$Builder) {
        super(abstractAMFMCmd$Builder);
        this.attributes = nArray;
        this.setName(new Buffer().append("SetNotificationAMFM(").append(nArray).append(')').toString());
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[SetNotificationAMFM.execute] attributes:%1", (Object)this.attributes);
        this.tuner.setNotification(this.attributes);
        this.commandFinished();
    }
}

