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
    private static final String LOGCLASS = "MediaSDISPlayerSelectionRequest";
    private final ASIHMISyncMediaReply reply;
    private final LogChannel logger;

    public MediaSDISPlayerSelectionRequest(LogChannel logChannel, int n, long l, boolean bl, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        super(n, l, bl, false);
        this.logger = logChannel;
        this.reply = aSIHMISyncMediaReply;
    }

    public void responseSetSelection(boolean bl) {
        this.logger.log(1000000, "[%2.responseSetSelection] '%1'", bl, (Object)LOGCLASS);
        try {
            this.reply.responseSetPlaySelection(bl);
        }
        catch (MethodException methodException) {
            this.logger.log(100000, "[%1.responseSetSelection] '%2'", (Object)LOGCLASS, (Throwable)methodException);
        }
    }
}

