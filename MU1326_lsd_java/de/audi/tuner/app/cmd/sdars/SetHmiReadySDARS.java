/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.sdars;

import de.audi.tuner.app.cmd.sdars.AbstractSDARSCmd;
import de.esolutions.fw.util.commons.Buffer;

public class SetHmiReadySDARS
extends AbstractSDARSCmd {
    public SetHmiReadySDARS(AbstractSDARSCmd.Builder builder) {
        super(builder);
        this.setName(new Buffer().append("SetHmiReadySDARS()").toString());
    }

    public void execute() {
        this.logger.log(10000000, "[SetHmiReadySDARS.execute] ");
        this.sdarsTuner.setHmiReady();
        this.commandFinished();
    }
}

