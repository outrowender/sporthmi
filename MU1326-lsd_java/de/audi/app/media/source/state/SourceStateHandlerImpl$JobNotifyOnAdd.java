/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state;

import de.audi.app.media.source.state.RegisteredSource;
import de.audi.app.media.source.state.SourceStateHandlerImpl;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;

class SourceStateHandlerImpl$JobNotifyOnAdd
implements Runnable {
    private final RegisteredSource registeredSource;
    private final /* synthetic */ SourceStateHandlerImpl this$0;

    public SourceStateHandlerImpl$JobNotifyOnAdd(SourceStateHandlerImpl sourceStateHandlerImpl, RegisteredSource registeredSource) {
        this.this$0 = sourceStateHandlerImpl;
        this.registeredSource = registeredSource;
    }

    @Override
    public void run() {
        if (this.registeredSource.getSource().getSlots().isEmpty()) {
            SourceStateHandlerImpl.access$000(this.this$0).log(1078071040, "[%1.onAddSourceSlotListener] [%2] No slots available.", (Object)"SourceStateHandlerImpl", (Object)this.registeredSource.getSource());
            return;
        }
        SourceStateHandlerImpl.access$000(this.this$0).log(1078071040, "[%1.onAddSourceSlotListener] [%2]", (Object)"SourceStateHandlerImpl", (Object)this.registeredSource.getSource());
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.registeredSource);
        SourceStateHandlerImpl.access$100(this.this$0, arrayList);
    }

    public String toString() {
        return new Buffer().append("SourceStateHandlerImpl.addSourceSlotListener('").append(this.registeredSource.getSource()).append("')").toString();
    }
}

