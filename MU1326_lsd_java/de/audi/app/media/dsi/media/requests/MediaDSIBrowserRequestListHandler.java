/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media.requests;

import de.audi.app.media.dsi.AbstractQueuedRequestHandler;
import de.audi.app.media.dsi.IRequestParameter;
import de.audi.app.media.dsi.media.requests.RequestParameterList;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.media.DSIMediaBrowser;

public class MediaDSIBrowserRequestListHandler
extends AbstractQueuedRequestHandler {
    private static final String LOGCLASS;

    public MediaDSIBrowserRequestListHandler(LogChannel logChannel, int n) {
        super(logChannel, true, n);
    }

    @Override
    protected String getLogClass() {
        return "MediaDSIBrowserRequestListHandler";
    }

    @Override
    protected final boolean sendRequest(IRequestParameter iRequestParameter, DSIBase dSIBase, int n) {
        try {
            RequestParameterList requestParameterList = (RequestParameterList)iRequestParameter;
            this.getLogChannel().log(1078071040, "[%1.sendRequest] [%3] dsiMediaBrowser.requestList('%2').", (Object)"MediaDSIBrowserRequestListHandler", (Object)requestParameterList, (long)n);
            ((DSIMediaBrowser)dSIBase).requestList(requestParameterList.getEntryID(), requestParameterList.getContentType(), requestParameterList.getIndex(), requestParameterList.getCount());
            return true;
        }
        catch (Exception exception) {
            this.getLogChannel().log(-1601830656, "[%1.sendRequest] Error on requesting list: %2", (Object)"MediaDSIBrowserRequestListHandler", (Throwable)exception);
            return false;
        }
    }
}

