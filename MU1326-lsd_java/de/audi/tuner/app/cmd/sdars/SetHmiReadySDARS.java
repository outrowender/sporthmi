/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.sdars;

import de.audi.tuner.app.cmd.sdars.AbstractSDARSCmd;
import de.audi.tuner.app.cmd.sdars.AbstractSDARSCmd$Builder;
import de.esolutions.fw.util.commons.Buffer;

public class SetHmiReadySDARS
extends AbstractSDARSCmd {
    public SetHmiReadySDARS(AbstractSDARSCmd$Builder abstractSDARSCmd$Builder) {
        super(abstractSDARSCmd$Builder);
        this.setName(new Buffer().append("SetHmiReadySDARS()").toString());
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[SetHmiReadySDARS.execute] ");
        this.sdarsTuner.setHmiReady();
        this.commandFinished();
    }
}

