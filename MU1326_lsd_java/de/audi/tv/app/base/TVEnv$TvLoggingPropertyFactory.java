/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.reactive.properties.LoggingPropertyFactory
 */
package de.audi.tv.app.base;

import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.reactive.properties.AcceptHook;
import de.audi.atip.utils.reactive.properties.LoggingPropertyFactory;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEnv$TvLoggingPropertyFactory$1;

class TVEnv$TvLoggingPropertyFactory
extends LoggingPropertyFactory {
    private final /* synthetic */ TVEnv this$0;

    protected TVEnv$TvLoggingPropertyFactory(TVEnv tVEnv, LogChannel logChannel, int n) {
        this.this$0 = tVEnv;
        super((AcceptHook)new TVEnv$TvLoggingPropertyFactory$1(tVEnv, logChannel, n));
    }
}

