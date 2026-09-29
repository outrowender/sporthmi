/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.kombi;

import de.audi.app.car.core.kombi.CarSDSServiceHandler;
import de.audi.atip.interapp.car.ICarRemainingRangeListener;

class CarSDSServiceHandler$1
implements Runnable {
    private final /* synthetic */ ICarRemainingRangeListener val$listener;
    private final /* synthetic */ CarSDSServiceHandler this$0;

    CarSDSServiceHandler$1(CarSDSServiceHandler carSDSServiceHandler, ICarRemainingRangeListener iCarRemainingRangeListener) {
        this.this$0 = carSDSServiceHandler;
        this.val$listener = iCarRemainingRangeListener;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        Object object = CarSDSServiceHandler.access$000(this.this$0);
        synchronized (object) {
            try {
                this.val$listener.updateRemainingRange(CarSDSServiceHandler.access$300(this.this$0, CarSDSServiceHandler.access$100(this.this$0), CarSDSServiceHandler.access$200(this.this$0)), CarSDSServiceHandler.access$400(this.this$0), CarSDSServiceHandler.access$500(this.this$0));
            }
            catch (Exception exception) {
                CarSDSServiceHandler.access$600(this.this$0).log(1000, "[CarSDSServiceHandler#addRemaningRangeListener] exception occured within the listener", (Throwable)exception);
            }
        }
    }
}

