/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media.requests;

import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.dsi.AbstractQueuedRequestHandler;
import de.audi.app.media.dsi.IRequestParameter;
import de.audi.app.media.dsi.media.PlayViewExceptionController;
import de.audi.app.media.dsi.media.requests.RequestParameterList;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.media.DSIMediaPlayer;

public class MediaDSIPlayerRequestListHandler
extends AbstractQueuedRequestHandler {
    private static final String LOGCLASS;
    private PlayViewExceptionController exceptionController;

    public MediaDSIPlayerRequestListHandler(LogChannel logChannel, int n, PlayViewExceptionController playViewExceptionController) {
        super(logChannel, true, n);
        this.exceptionController = playViewExceptionController;
    }

    @Override
    protected String getLogClass() {
        return "MediaDSIPlayerRequestListHandler";
    }

    @Override
    protected final boolean sendRequest(IRequestParameter iRequestParameter, DSIBase dSIBase, int n) {
        try {
            RequestParameterList requestParameterList = (RequestParameterList)iRequestParameter;
            if (this.getLogChannel().isInfo()) {
                Buffer buffer = new Buffer();
                buffer.append("'").append(requestParameterList.getEntryID()).append("','").append(requestParameterList.getIndex()).append("','").append(requestParameterList.getCount()).append("','");
                buffer.append(MediaUtils.getPlayViewClientIDToStr(requestParameterList.getClientID())).append("'");
                this.getLogChannel().log(1078071040, "[%1.sendRequest] [%3] dsiMediaPlayer.requestPlayView(%2)", (Object)"MediaDSIPlayerRequestListHandler", (Object)buffer, (long)n);
            }
            if (!iRequestParameter.isRetry()) {
                this.exceptionController.addRequest(requestParameterList.getEntryID(), requestParameterList.getIndex(), requestParameterList.getCount(), requestParameterList.getClientID());
            }
            ((DSIMediaPlayer)dSIBase).requestPlayView(requestParameterList.getEntryID(), requestParameterList.getIndex(), requestParameterList.getCount(), requestParameterList.getClientID());
            return true;
        }
        catch (Exception exception) {
            this.getLogChannel().log(-1601830656, "[%1.sendRequest] Error on requesting list: %2", (Object)"MediaDSIPlayerRequestListHandler", (Throwable)exception);
            return false;
        }
    }
}

