/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.reactive.properties.AcceptHook;
import de.audi.tv.app.base.TVEnv;

class TVEnv$TvLoggingPropertyFactory$1
implements AcceptHook {
    private final /* synthetic */ TVEnv val$this$0;
    private final /* synthetic */ LogChannel val$lc;
    private final /* synthetic */ int val$level;

    TVEnv$TvLoggingPropertyFactory$1(TVEnv tVEnv, LogChannel logChannel, int n) {
        this.val$this$0 = tVEnv;
        this.val$lc = logChannel;
        this.val$level = n;
    }

    @Override
    public void onAccept(String string, Object object) {
        this.val$lc.log(this.val$level, "[TvProperty %1.onAccept] %2", (Object)string, object);
    }
}

