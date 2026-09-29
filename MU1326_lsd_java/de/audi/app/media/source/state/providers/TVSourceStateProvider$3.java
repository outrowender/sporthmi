/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.source.state.providers.TVSourceStateProvider;
import de.audi.atip.util.Util;
import java.util.HashMap;

class TVSourceStateProvider$3
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$tvState;
    private final /* synthetic */ int[] val$sourceListElements;
    private final /* synthetic */ TVSourceStateProvider this$0;

    TVSourceStateProvider$3(TVSourceStateProvider tVSourceStateProvider, String string, int n, int[] nArray) {
        this.this$0 = tVSourceStateProvider;
        this.val$tvState = n;
        this.val$sourceListElements = nArray;
        super(string);
    }

    @Override
    public void run() {
        TVSourceStateProvider.access$000(this.this$0).log(1078071040, "[%1.updateState] %2", (Object)"TVSourceStateProvider", (Object)(0 == this.val$tvState ? "READY" : "NOT READY"));
        if (this.val$sourceListElements != null) {
            HashMap hashMap = new HashMap(this.val$sourceListElements.length);
            block4: for (int i2 = 0; i2 < this.val$sourceListElements.length; ++i2) {
                switch (this.val$sourceListElements[i2]) {
                    case 1: {
                        hashMap.put(Util.createInteger(8), 0 == this.val$tvState ? Boolean.TRUE : Boolean.FALSE);
                        continue block4;
                    }
                    case 0: {
                        hashMap.put(Util.createInteger(7), 0 == this.val$tvState ? Boolean.TRUE : Boolean.FALSE);
                        continue block4;
                    }
                    default: {
                        TVSourceStateProvider.access$000(this.this$0).log(1078071040, "[%1.updateState] Unknown source '%2'", (Object)"TVSourceStateProvider", (long)this.val$tvState);
                    }
                }
            }
            if (!hashMap.isEmpty()) {
                TVSourceStateProvider.access$200(this.this$0).updateSourceAvailability(12, hashMap);
            }
        }
    }
}

