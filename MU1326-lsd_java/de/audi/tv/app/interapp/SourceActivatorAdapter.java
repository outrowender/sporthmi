/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.interapp;

import de.audi.atip.interapp.tv.ITVParentActivationService;
import de.audi.atip.log.LogChannel;
import de.audi.tv.app.interapp.ISourceActivator;
import de.audi.tv.app.interapp.SourceActivatorAdapter$1;

public class SourceActivatorAdapter
implements ISourceActivator {
    private final LogChannel lc;
    private final ITVParentActivationService defaultService;
    private ITVParentActivationService service;

    public SourceActivatorAdapter(LogChannel logChannel) {
        this.lc = logChannel;
        this.service = this.defaultService = new SourceActivatorAdapter$1(this, logChannel);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void activate(int n) {
        SourceActivatorAdapter sourceActivatorAdapter = this;
        synchronized (sourceActivatorAdapter) {
            this.lc.log(14808325, "[SourceActivatorAdapter.activate] source %1", (long)n);
            if (n == 0) {
                this.service.activateSource(0);
            } else if (n == 1) {
                this.service.activateSource(1);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addSerivce(ITVParentActivationService iTVParentActivationService) {
        SourceActivatorAdapter sourceActivatorAdapter = this;
        synchronized (sourceActivatorAdapter) {
            this.service = iTVParentActivationService;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeService() {
        SourceActivatorAdapter sourceActivatorAdapter = this;
        synchronized (sourceActivatorAdapter) {
            this.service = this.defaultService;
        }
    }
}

