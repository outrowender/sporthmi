/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.exlap.Container;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ExlapService;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.app.IExlapWorker;
import org.dsi.ifc.has.DSIHAS;

public abstract class ExlapAbstractWorker
implements IExlapWorker {
    protected final LogChannel log;
    protected int interval = -1;
    protected long lastExecution = 0L;
    protected boolean newData = false;
    protected ExlapDispatcher dispatcher;
    protected DSIHAS dsiHas;
    protected ExlapListener listener;
    protected ExlapService service;
    protected Container container;

    public ExlapAbstractWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        this.log = iFrameworkAccess.getLogChannel("App.Exlap.Worker");
        this.dispatcher = exlapDispatcher;
        this.dsiHas = dSIHAS;
    }

    public void init(ExlapService exlapService) {
        this.service = exlapService;
        this.listener = this.createListener();
        this.registerListener();
    }

    public void stop() {
        this.removeListener();
        this.service = null;
    }

    public int getInterval() {
        return this.interval;
    }

    public void enable(int n) {
        this.interval = n;
        this.trigger();
    }

    public void disable() {
        this.interval = -1;
    }

    public long getLastExecution() {
        return this.lastExecution;
    }

    public boolean hasNewData() {
        return this.newData;
    }

    public void setNewData(boolean bl) {
        this.newData = bl;
    }

    public void setLastExecution(long l) {
        this.lastExecution = l;
    }

    protected void trigger() {
        this.dispatcher.trigger(this);
    }

    protected abstract ExlapListener createListener();

    protected abstract int[] getAttributes();

    public void registerListener() {
        if (this.service != null) {
            this.service.addListener(this.getAttributes(), this.listener);
        }
    }

    public void removeListener() {
        if (this.service != null) {
            this.service.removeListener(this.getAttributes(), this.listener);
        }
    }
}

