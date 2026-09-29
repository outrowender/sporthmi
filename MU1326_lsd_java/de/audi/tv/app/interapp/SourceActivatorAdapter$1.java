/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.interapp;

import de.audi.atip.interapp.tv.ITVParentActivationService;
import de.audi.atip.log.LogChannel;
import de.audi.tv.app.interapp.SourceActivatorAdapter;

class SourceActivatorAdapter$1
implements ITVParentActivationService {
    private final /* synthetic */ LogChannel val$lc;
    private final /* synthetic */ SourceActivatorAdapter this$0;

    SourceActivatorAdapter$1(SourceActivatorAdapter sourceActivatorAdapter, LogChannel logChannel) {
        this.this$0 = sourceActivatorAdapter;
        this.val$lc = logChannel;
    }

    @Override
    public void activateSource(int n) {
        this.val$lc.log(1078071040, "[SourceActivatorAdapter.DefaultService.activateSource] source %1", (long)n);
    }
}

