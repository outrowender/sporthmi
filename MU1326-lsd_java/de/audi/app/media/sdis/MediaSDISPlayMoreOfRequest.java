/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.selection.IDataSelectionContext;
import de.audi.app.media.selection.ISelectionListener;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaReply;
import de.esolutions.fw.comm.core.method.MethodException;

public class MediaSDISPlayMoreOfRequest
implements ISelectionListener {
    private static final String LOGCLASS;
    private final ASIHMISyncMediaReply reply;
    private final LogChannel logger;
    private final int category;
    private final long entryId;

    public MediaSDISPlayMoreOfRequest(LogChannel logChannel, long l, int n, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.logger = logChannel;
        this.reply = aSIHMISyncMediaReply;
        this.category = n;
        this.entryId = l;
    }

    @Override
    public void notifySelectionChanged(IDataSelectionContext iDataSelectionContext, boolean bl) {
        try {
            this.reply.responsePlayMoreFrom(this.entryId, this.category, bl ? 0 : 1);
        }
        catch (MethodException methodException) {
            this.logger.log(-1601830656, "[%1.responsePlayMoreFrom] '%2'", (Object)"MediaSDISPlayMoreOfRequest", (Throwable)methodException);
        }
    }
}

