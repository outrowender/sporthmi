/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.sdars;

import de.audi.tuner.app.cmd.sdars.AbstractSDARSCmd;
import de.esolutions.fw.util.commons.Buffer;

public class SetNotificationSDARS
extends AbstractSDARSCmd {
    private final int[] attributes;

    public SetNotificationSDARS(int[] nArray, AbstractSDARSCmd.Builder builder) {
        super(builder);
        this.attributes = nArray;
        this.setName(new Buffer().append("SetNotificationSDARS(").append(nArray).append(')').toString());
    }

    public void execute() {
        this.logger.log(10000000, "[SetNotificationSDARS.execute] attributes:%1", (Object)this.attributes);
        this.sdarsTuner.setNotification(this.attributes);
        this.commandFinished();
    }
}

