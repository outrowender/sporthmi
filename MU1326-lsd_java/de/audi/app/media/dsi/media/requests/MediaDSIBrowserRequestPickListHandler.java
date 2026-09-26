/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media.requests;

import de.audi.app.media.dsi.AbstractQueuedRequestHandler;
import de.audi.app.media.dsi.IRequestParameter;
import de.audi.app.media.dsi.media.requests.RequestPickListParameterList;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.media.DSIMediaBrowser;

public class MediaDSIBrowserRequestPickListHandler
extends AbstractQueuedRequestHandler {
    private static final String LOGCLASS;

    public MediaDSIBrowserRequestPickListHandler(LogChannel logChannel, int n) {
        super(logChannel, true, n);
    }

    @Override
    protected String getLogClass() {
        return "MediaDSIBrowserRequestPickListHandler";
    }

    @Override
    protected final boolean sendRequest(IRequestParameter iRequestParameter, DSIBase dSIBase, int n) {
        try {
            RequestPickListParameterList requestPickListParameterList = (RequestPickListParameterList)iRequestParameter;
            this.getLogChannel().log(1078071040, "[%1.sendRequest] [%3] dsiMediaBrowser.requestPickList('%2').", (Object)"MediaDSIBrowserRequestPickListHandler", (Object)requestPickListParameterList, (long)n);
            ((DSIMediaBrowser)dSIBase).requestPickList(requestPickListParameterList.getEntryIDs());
            return true;
        }
        catch (Exception exception) {
            this.getLogChannel().log(-1601830656, "[%1.sendRequest] Error on requesting pick list: %2", (Object)"MediaDSIBrowserRequestPickListHandler", (Throwable)exception);
            return false;
        }
    }
}

