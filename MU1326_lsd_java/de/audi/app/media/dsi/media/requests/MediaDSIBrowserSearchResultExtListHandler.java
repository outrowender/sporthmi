/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media.requests;

import de.audi.app.media.dsi.AbstractQueuedRequestHandler;
import de.audi.app.media.dsi.IRequestParameter;
import de.audi.app.media.dsi.media.requests.RequestParameterList;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.MethodCall;
import org.dsi.ifc.base.DSIBase;

public class MediaDSIBrowserSearchResultExtListHandler
extends AbstractQueuedRequestHandler {
    private static final String LOGCLASS;

    public MediaDSIBrowserSearchResultExtListHandler(LogChannel logChannel, int n) {
        super(logChannel, true, n);
    }

    @Override
    protected boolean sendRequest(IRequestParameter iRequestParameter, DSIBase dSIBase, int n) {
        try {
            RequestParameterList requestParameterList = (RequestParameterList)iRequestParameter;
            new MethodCall(dSIBase, "requestSearchListExt").arg(requestParameterList.getEntryID()).arg(requestParameterList.getIndex()).arg(requestParameterList.getCount()).call();
            return true;
        }
        catch (Exception exception) {
            this.getLogChannel().log(-1601830656, "[%1.sendRequest] Error on requesting list: %2", (Object)"MediaDSIBrowserSearchResultExtListHandler", (Throwable)exception);
            return false;
        }
    }

    @Override
    protected String getLogClass() {
        return "MediaDSIBrowserSearchResultExtListHandler";
    }
}

