/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi;

import de.audi.app.media.dsi.IRequestHandler;
import de.audi.app.media.dsi.IRequestParameter;
import de.audi.atip.log.LogChannel;
import java.util.Iterator;
import java.util.LinkedList;
import org.dsi.ifc.base.DSIBase;

public abstract class AbstractQueuedRequestHandler
implements IRequestHandler {
    private IRequestParameter currentRunningRequest;
    private final LinkedList requestQueue = new LinkedList();
    private final Object mutex = new Object();
    private final boolean queueFilterOptions;
    private final LogChannel dsiLogChannel;
    private final int dsiInstanceID;
    private volatile DSIBase dsiService;

    protected abstract boolean sendRequest(IRequestParameter var1, DSIBase var2, int var3);

    protected abstract String getLogClass();

    public AbstractQueuedRequestHandler(LogChannel logChannel, boolean bl, int n) {
        if (logChannel == null) {
            throw new IllegalArgumentException("Logchannel is missing.");
        }
        this.dsiLogChannel = logChannel;
        this.queueFilterOptions = bl;
        this.dsiInstanceID = n;
    }

    public void setDSI(DSIBase dSIBase) {
        this.dsiLogChannel.log(1000000, "[%1.setDSI] [%3] '%2'", (Object)this.getLogClass(), (Object)dSIBase, (long)this.dsiInstanceID);
        this.dsiService = dSIBase;
    }

    private DSIBase getDSI() {
        return this.dsiService;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reset() {
        this.dsiLogChannel.log(1000000, "[%1.reset] [%2]", (Object)this.getLogClass(), (long)this.dsiInstanceID);
        Object object = this.mutex;
        synchronized (object) {
            this.currentRunningRequest = null;
            this.requestQueue.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void discard(int n) {
        this.dsiLogChannel.log(1000000, "[%1.discard] [%3] clientID='%2'", (Object)this.getLogClass(), (long)n, (long)this.dsiInstanceID);
        Object object = this.mutex;
        synchronized (object) {
            if (this.currentRunningRequest != null && this.currentRunningRequest.getClientID() == n) {
                this.dsiLogChannel.log(1000000, "[%1.discard] [%2] Running request marked outdated.", (Object)this.getLogClass(), (long)this.dsiInstanceID);
                this.currentRunningRequest.setOutDated(true);
            }
            Iterator iterator = this.requestQueue.iterator();
            while (iterator.hasNext()) {
                IRequestParameter iRequestParameter = (IRequestParameter)iterator.next();
                if (iRequestParameter.getClientID() != n) continue;
                this.dsiLogChannel.log(1000000, "[%1.discard] [%3] Remove '%2'", (Object)this.getLogClass(), (Object)iRequestParameter, (long)this.dsiInstanceID);
                iterator.remove();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public IRequestParameter dataResponded() {
        IRequestParameter iRequestParameter;
        this.dsiLogChannel.log(1000000, "[%1.dataResponded] [%2]", (Object)this.getLogClass(), (long)this.dsiInstanceID);
        Object object = this.mutex;
        synchronized (object) {
            iRequestParameter = this.currentRunningRequest;
            if (this.currentRunningRequest == null) {
                this.dsiLogChannel.log(1000000, "[%1.dataResponded] [%2] No assigned request exist.", (Object)this.getLogClass(), (long)this.dsiInstanceID);
                return null;
            }
            if (this.requestQueue.isEmpty()) {
                this.currentRunningRequest = null;
                return iRequestParameter;
            }
            Object object2 = this.requestQueue.iterator();
            while (object2.hasNext()) {
                IRequestParameter iRequestParameter2 = (IRequestParameter)object2.next();
                if (iRequestParameter2.getClientID() != iRequestParameter.getClientID()) continue;
                this.dsiLogChannel.log(1000000, "[%1.dataResponded] [%3] Queued request for client '%2' exists. Outdated.", (Object)this.getLogClass(), (long)iRequestParameter.getClientID(), (long)this.dsiInstanceID);
                iRequestParameter.setOutDated(true);
                break;
            }
            this.currentRunningRequest = (IRequestParameter)this.requestQueue.removeFirst();
            this.dsiLogChannel.log(1000000, "[%1.dataResponded] [%3] Queued request '%2' available. ", (Object)this.getLogClass(), (Object)this.currentRunningRequest, (long)this.dsiInstanceID);
            object2 = this.getDSI();
            if (object2 == null) {
                this.dsiLogChannel.log(1000000, "[%1.request] [%2] DSI service not available.", (Object)this.getLogClass(), (long)this.dsiInstanceID);
                this.dataResponded();
            } else if (!this.sendRequest(this.currentRunningRequest, (DSIBase)object2, this.dsiInstanceID)) {
                this.dsiLogChannel.log(1000000, "[%1.request] [%3] Send '%2' failed.", (Object)this.getLogClass(), (Object)this.currentRunningRequest, (long)this.dsiInstanceID);
                this.dataResponded();
            }
        }
        return iRequestParameter;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean request(IRequestParameter iRequestParameter) {
        if (iRequestParameter == null) {
            throw new IllegalArgumentException("Request parameter must be defined.");
        }
        DSIBase dSIBase = this.getDSI();
        if (dSIBase == null) {
            this.dsiLogChannel.log(1000000, "[%1.request] [%2] DSI service not available.", (Object)this.getLogClass(), (long)this.dsiInstanceID);
            return false;
        }
        this.dsiLogChannel.log(1000000, "[%1.request] [%3] '%2'", (Object)this.getLogClass(), (Object)iRequestParameter, (long)this.dsiInstanceID);
        Object object = this.mutex;
        synchronized (object) {
            if (this.currentRunningRequest != null) {
                this.dsiLogChannel.log(1000000, "[%1.request] [%3] '%2' currently running.", (Object)this.getLogClass(), (Object)this.currentRunningRequest, (long)this.dsiInstanceID);
                if (this.queueFilterOptions && this.isRequestRunning(iRequestParameter)) {
                    this.dsiLogChannel.log(1000000, "[%1.request] [%2] New already running.", (Object)this.getLogClass(), (long)this.dsiInstanceID);
                    if (iRequestParameter.isRetry()) {
                        this.currentRunningRequest.setOutDated(false);
                        return this.sendChecked(iRequestParameter, dSIBase);
                    }
                    if (this.currentRunningRequest.isOutdated()) {
                        this.dsiLogChannel.log(1000000, "[%1.request] [%2] Remove outdated flag.", (Object)this.getLogClass(), (long)this.dsiInstanceID);
                        this.currentRunningRequest.setOutDated(false);
                    }
                    this.dsiLogChannel.log(1000000, "[%1.request] [%3] Remove possible queued requests for client '%2'.", (Object)this.getLogClass(), (long)iRequestParameter.getClientID(), (long)this.dsiInstanceID);
                    Iterator iterator = this.requestQueue.iterator();
                    while (iterator.hasNext()) {
                        IRequestParameter iRequestParameter2 = (IRequestParameter)iterator.next();
                        if (iRequestParameter2.getClientID() != iRequestParameter.getClientID()) continue;
                        this.dsiLogChannel.log(1000000, "[%1.request] [%3] Remove '%2'.", (Object)this.getLogClass(), (Object)iRequestParameter2, (long)this.dsiInstanceID);
                        iterator.remove();
                    }
                    return true;
                }
                if (this.queueFilterOptions) {
                    Iterator iterator = this.requestQueue.iterator();
                    while (iterator.hasNext()) {
                        IRequestParameter iRequestParameter3 = (IRequestParameter)iterator.next();
                        if (!((Object)iRequestParameter3).equals(iRequestParameter)) continue;
                        this.dsiLogChannel.log(1000000, "[%1.request] [%2] Already queued. Remove it.", (Object)this.getLogClass(), (long)this.dsiInstanceID);
                        iterator.remove();
                    }
                }
                this.dsiLogChannel.log(1000000, "[%1.request] [%3] Queue '%2'.", (Object)this.getLogClass(), (Object)iRequestParameter, (long)this.dsiInstanceID);
                this.requestQueue.add(iRequestParameter);
                this.dsiLogChannel.log(10000000, "[%1.request] queue length:%2", (Object)this.getLogClass(), (long)this.requestQueue.size());
                return true;
            }
            return this.sendChecked(iRequestParameter, dSIBase);
        }
    }

    private boolean sendChecked(IRequestParameter iRequestParameter, DSIBase dSIBase) {
        this.currentRunningRequest = iRequestParameter;
        if (!this.sendRequest(this.currentRunningRequest, dSIBase, this.dsiInstanceID)) {
            this.dsiLogChannel.log(1000000, "[%1.request] [%3] Send request '%2' failed.", (Object)this.getLogClass(), (Object)this.currentRunningRequest, (long)this.dsiInstanceID);
            this.dataResponded();
            return false;
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isRequestRunning(IRequestParameter iRequestParameter) {
        if (iRequestParameter == null) {
            throw new IllegalArgumentException("Missing argument.");
        }
        Object object = this.mutex;
        synchronized (object) {
            if (this.currentRunningRequest == null) {
                return false;
            }
            return ((Object)this.currentRunningRequest).equals(iRequestParameter);
        }
    }

    protected final LogChannel getLogChannel() {
        return this.dsiLogChannel;
    }
}

