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

public class MediaDSIBrowserSearchResultListHandler
extends AbstractQueuedRequestHandler {
    private static final String LOGCLASS;

    public MediaDSIBrowserSearchResultListHandler(LogChannel logChannel, int n) {
        super(logChannel, true, n);
    }

    @Override
    protected boolean sendRequest(IRequestParameter iRequestParameter, DSIBase dSIBase, int n) {
        try {
            RequestParameterList requestParameterList = (RequestParameterList)iRequestParameter;
            ((DSIMediaBrowser)dSIBase).requestSearchList(requestParameterList.getEntryID(), requestParameterList.getIndex(), requestParameterList.getCount());
            return true;
        }
        catch (Exception exception) {
            this.getLogChannel().log(-1601830656, "[%1.sendRequest] Error on requesting list: %2", (Object)"MediaDSIBrowserSearchResultListHandler", (Throwable)exception);
            return false;
        }
    }

    @Override
    protected String getLogClass() {
        return "MediaDSIBrowserSearchResultListHandler";
    }
}

