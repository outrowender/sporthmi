/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

final class GetArrayJob
extends Command {
    private ArrayHandler arrayHandler;
    private GetArrayIndication indication;

    public GetArrayJob(LogChannel logChannel, ArrayHandler arrayHandler, GetArrayIndication getArrayIndication) {
        super(logChannel);
        this.arrayHandler = arrayHandler;
        this.indication = getArrayIndication;
    }

    public GetArrayIndication getIndication() {
        return this.indication;
    }

    public int getJobID() {
        return this.indication.getArrayHeader().getJobID();
    }

    public void notifyStatusReceived() {
        this.getCommandList().commandFinished();
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[GetArrayJob#execute] jobID=%1", (long)this.getJobID());
        this.arrayHandler.requestListElements(this.indication);
    }
}

