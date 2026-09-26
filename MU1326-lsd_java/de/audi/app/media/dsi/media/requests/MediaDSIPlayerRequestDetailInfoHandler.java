/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media.requests;

import de.audi.app.media.dsi.AbstractQueuedRequestHandler;
import de.audi.app.media.dsi.IRequestParameter;
import de.audi.app.media.dsi.media.requests.RequestParameterEntryID;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.media.DSIMediaPlayer;

public class MediaDSIPlayerRequestDetailInfoHandler
extends AbstractQueuedRequestHandler {
    private static final String LOGCLASS;

    public MediaDSIPlayerRequestDetailInfoHandler(LogChannel logChannel, int n) {
        super(logChannel, true, n);
    }

    @Override
    protected String getLogClass() {
        return "MediaDSIPlayerRequestDetailInfoHandler";
    }

    @Override
    protected final boolean sendRequest(IRequestParameter iRequestParameter, DSIBase dSIBase, int n) {
        try {
            RequestParameterEntryID requestParameterEntryID = (RequestParameterEntryID)iRequestParameter;
            this.getLogChannel().log(1078071040, "[%1.sendRequest] [%3] dsiMediaPlayer.requestDetailInfo('%2')", (Object)"MediaDSIPlayerRequestDetailInfoHandler", (Object)requestParameterEntryID, (long)n);
            ((DSIMediaPlayer)dSIBase).requestDetailInfo(requestParameterEntryID.getEntryID());
            return true;
        }
        catch (Exception exception) {
            this.getLogChannel().log(-1601830656, "[%1.sendRequest] Error on requesting list: %2", (Object)"MediaDSIPlayerRequestDetailInfoHandler", (Throwable)exception);
            return false;
        }
    }
}

