/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.content.media.AbstractPlayerSelectionRequest;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaReply;
import de.esolutions.fw.comm.core.method.MethodException;

public class MediaSDISPlayerSelectionRequest
extends AbstractPlayerSelectionRequest {
    private static final String LOGCLASS;
    private final ASIHMISyncMediaReply reply;
    private final LogChannel logger;

    public MediaSDISPlayerSelectionRequest(LogChannel logChannel, int n, long l, boolean bl, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        super(n, l, bl, false);
        this.logger = logChannel;
        this.reply = aSIHMISyncMediaReply;
    }

    @Override
    public void responseSetSelection(boolean bl) {
        this.logger.log(1078071040, "[%2.responseSetSelection] '%1'", bl, (Object)"MediaSDISPlayerSelectionRequest");
        try {
            this.reply.responseSetPlaySelection(bl);
        }
        catch (MethodException methodException) {
            this.logger.log(-1601830656, "[%1.responseSetSelection] '%2'", (Object)"MediaSDISPlayerSelectionRequest", (Throwable)methodException);
        }
    }
}

