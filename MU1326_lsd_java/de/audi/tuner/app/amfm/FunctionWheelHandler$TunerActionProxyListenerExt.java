/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.FunctionWheelHandler;
import de.audi.tuner.app.amfm.FunctionWheelHandler$1;
import de.audi.tuner.app.ap.TunerActionProxyListener;

class FunctionWheelHandler$TunerActionProxyListenerExt
extends TunerActionProxyListener {
    private final /* synthetic */ FunctionWheelHandler this$0;

    private FunctionWheelHandler$TunerActionProxyListenerExt(FunctionWheelHandler functionWheelHandler) {
        this.this$0 = functionWheelHandler;
    }

    @Override
    public void manualTuneLeft() {
        FunctionWheelHandler.access$800(this.this$0).cancel();
        if (FunctionWheelHandler.access$1900(this.this$0) != null) {
            FunctionWheelHandler.access$1400(this.this$0, new AMFMStation(FunctionWheelHandler.access$1900(this.this$0)));
            FunctionWheelHandler.access$1902(this.this$0, null);
        }
    }

    /* synthetic */ FunctionWheelHandler$TunerActionProxyListenerExt(FunctionWheelHandler functionWheelHandler, FunctionWheelHandler$1 functionWheelHandler$1) {
        this(functionWheelHandler);
    }
}

