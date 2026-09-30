/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.agent;

import de.audi.atip.agent.IASICall;
import de.audi.atip.agent.IASIProvider;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.NullLogChannel;
import de.esolutions.fw.comm.core.IStub;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractASIProvider
implements IASIProvider {
    private final String name;
    private final LogChannel log;
    private final List stubs;

    public AbstractASIProvider(String string, LogChannel logChannel) {
        this.name = string;
        this.log = logChannel != null ? logChannel : NullLogChannel.getInstance();
        this.stubs = new ArrayList();
    }

    public synchronized void attachStub(IStub iStub) {
        this.getLog().log(10000000, "attachStub(%1)", (Object)iStub);
        this.stubs.add(iStub);
    }

    public synchronized void detachStub(IStub iStub) {
        this.getLog().log(10000000, "detachStub(%1)", (Object)iStub);
        this.stubs.remove(iStub);
    }

    protected final LogChannel getLog() {
        return this.log;
    }

    public final String toString() {
        return this.name + "ASIProvider";
    }

    protected final synchronized List getStubs() {
        return new ArrayList(this.stubs);
    }

    protected final void broadcast(IASICall iASICall) {
        Iterator iterator = this.getStubs().iterator();
        while (iterator.hasNext()) {
            try {
                iASICall.call(((IStub)iterator.next()).getReplyProxyFrontend());
            }
            catch (Exception exception) {
                this.getLog().log(100000, "%1.broadcast() call %2 failed!", (Object)this, (Object)iASICall, (Object)exception);
            }
        }
    }
}

