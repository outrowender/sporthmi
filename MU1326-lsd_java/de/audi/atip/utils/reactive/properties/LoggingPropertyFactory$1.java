/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.properties;

import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.reactive.properties.AcceptHook;

final class LoggingPropertyFactory$1
implements AcceptHook {
    private final /* synthetic */ LogChannel val$lc;
    private final /* synthetic */ int val$level;

    LoggingPropertyFactory$1(LogChannel logChannel, int n) {
        this.val$lc = logChannel;
        this.val$level = n;
    }

    @Override
    public void onAccept(String string, Object object) {
        this.val$lc.log(this.val$level, "[IPropertyHook(%1).onAccept] %2", (Object)string, object);
    }
}

