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

public class MediaDSIPlayerRequestCoverArtUrlHandler
extends AbstractQueuedRequestHandler {
    private static final String LOGCLASS = "MediaDSIPlayerRequestCoverArtUrlHandler";

    public MediaDSIPlayerRequestCoverArtUrlHandler(LogChannel logChannel, int n) {
        super(logChannel, true, n);
    }

    protected final String getLogClass() {
        return LOGCLASS;
    }

    protected final boolean sendRequest(IRequestParameter iRequestParameter, DSIBase dSIBase, int n) {
        try {
            long l = ((RequestParameterEntryID)iRequestParameter).getEntryID();
            this.getLogChannel().log(1000000, "[%1.sendRequest] [%3] dsiMediaPlayer.requestCoverArt('%2').", (Object)LOGCLASS, l, (long)n);
            ((DSIMediaPlayer)dSIBase).requestCoverArt(l);
            return true;
        }
        catch (Exception exception) {
            this.getLogChannel().log(100000, "[%1.sendRequest] Error on requesting detail informations: %2", (Object)LOGCLASS, (Throwable)exception);
            return false;
        }
    }
}

