/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.statemachine;

import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.dispatching.DispatcherBaseAdapter;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.statemachine.Handler;
import de.audi.atip.utils.statemachine.SyncPoint;
import de.audi.atip.utils.statemachine.SyncPoint$Builder$1;
import de.audi.atip.utils.statemachine.SyncronousDispatcher;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.ArrayList;
import java.util.List;

public class SyncPoint$Builder {
    private final List requirements;
    private int messageCode = -1;
    private Handler handler;
    private Runnable callback;
    private IDispatcher dispatcher;
    private LogChannel lc = new SyncPoint$Builder$1(this);
    private String logTag = "unspecified";

    public SyncPoint$Builder() {
        this.dispatcher = new SyncronousDispatcher();
        this.requirements = new ArrayList();
    }

    public SyncPoint$Builder setCallbackMessage(Handler handler, int n) {
        this.handler = handler;
        this.messageCode = n;
        return this;
    }

    public SyncPoint$Builder addRequirement(Object object) {
        this.requirements.add(object);
        return this;
    }

    public SyncPoint$Builder setCallback(Runnable runnable) {
        this.callback = runnable;
        return this;
    }

    public SyncPoint$Builder setDispatcher(DispatcherBase dispatcherBase) {
        this.dispatcher = new DispatcherBaseAdapter(dispatcherBase);
        return this;
    }

    public SyncPoint$Builder setDispatcher(IDispatcher iDispatcher) {
        this.dispatcher = iDispatcher;
        return this;
    }

    public SyncPoint$Builder setLogChannel(LogChannel logChannel) {
        this.lc = logChannel;
        return this;
    }

    public SyncPoint$Builder setName(String string) {
        this.logTag = new StringBuffer().append("SyncPoint[").append(string).append(']').toString();
        return this;
    }

    public SyncPoint build() {
        return new SyncPoint(this.requirements, this.messageCode, this.handler, this.callback, this.dispatcher, this.lc, this.logTag);
    }
}

