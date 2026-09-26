/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.reactive.properties.NotifyOnAddProperty
 */
package de.audi.atip.utils.reactive.properties;

import de.audi.atip.utils.reactive.observables.BackChannel;
import de.audi.atip.utils.reactive.observables.Sink;
import de.audi.atip.utils.reactive.properties.NotifyOnAddProperty;
import de.audi.atip.utils.reactive.properties.NotifyOnAddProperty$1;

class NotifyOnAddProperty$1$1
implements BackChannel {
    private final /* synthetic */ Sink val$sink;
    private final /* synthetic */ NotifyOnAddProperty$1 this$1;

    NotifyOnAddProperty$1$1(NotifyOnAddProperty$1 notifyOnAddProperty$1, Sink sink) {
        this.this$1 = notifyOnAddProperty$1;
        this.val$sink = sink;
    }

    @Override
    public void disconnect() {
        NotifyOnAddProperty.access$000((NotifyOnAddProperty)NotifyOnAddProperty$1.access$100(this.this$1)).remove(this.val$sink);
    }
}

