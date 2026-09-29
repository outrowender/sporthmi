/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.core.comfort.LGIDataDispatcher;
import org.dsi.ifc.carcomfort.RGSLocalHazardInformation;

class LGIDataDispatcher$1
implements Runnable {
    private final /* synthetic */ RGSLocalHazardInformation val$data;
    private final /* synthetic */ LGIDataDispatcher this$0;

    LGIDataDispatcher$1(LGIDataDispatcher lGIDataDispatcher, RGSLocalHazardInformation rGSLocalHazardInformation) {
        this.this$0 = lGIDataDispatcher;
        this.val$data = rGSLocalHazardInformation;
    }

    @Override
    public void run() {
        try {
            LGIDataDispatcher.access$000(this.this$0).log(1078071040, "DSICarComfort#setRGSLocalHazardInformation(%1)", (Object)this.val$data);
            LGIDataDispatcher.access$100(this.this$0).setRGSLocalHazardInformation(this.val$data);
            Thread.sleep(0);
        }
        catch (InterruptedException interruptedException) {
            LGIDataDispatcher.access$000(this.this$0).log(10000, "LGIDataDispatcher#setRGSLocalHazardInformation() - %1", (Throwable)interruptedException);
        }
    }
}

