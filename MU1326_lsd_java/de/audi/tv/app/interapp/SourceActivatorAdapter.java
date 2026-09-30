/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.interapp;

import de.audi.atip.interapp.tv.ITVParentActivationService;
import de.audi.atip.log.LogChannel;
import de.audi.tv.app.interapp.ISourceActivator;

public class SourceActivatorAdapter
implements ISourceActivator {
    private final LogChannel lc;
    private final ITVParentActivationService defaultService;
    private ITVParentActivationService service;

    public SourceActivatorAdapter(final LogChannel logChannel) {
        this.lc = logChannel;
        this.service = this.defaultService = new ITVParentActivationService(){

            public void activateSource(int n) {
                logChannel.log(1000000, "[SourceActivatorAdapter.DefaultService.activateSource] source %1", (long)n);
            }
        };
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void activate(int n) {
        SourceActivatorAdapter sourceActivatorAdapter = this;
        synchronized (sourceActivatorAdapter) {
            this.lc.log(100000000, "[SourceActivatorAdapter.activate] source %1", (long)n);
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

