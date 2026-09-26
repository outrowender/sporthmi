/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.FunctionWheelHandler;
import de.audi.tuner.app.amfm.FunctionWheelHandler$1;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;

class FunctionWheelHandler$DsiDownListener
extends AMFMDsiDownInfo {
    private final /* synthetic */ FunctionWheelHandler this$0;

    private FunctionWheelHandler$DsiDownListener(FunctionWheelHandler functionWheelHandler) {
        this.this$0 = functionWheelHandler;
    }

    @Override
    public void preTuneAction(AMFMStation aMFMStation, boolean bl) {
        FunctionWheelHandler.access$1400(this.this$0, aMFMStation);
    }

    /* synthetic */ FunctionWheelHandler$DsiDownListener(FunctionWheelHandler functionWheelHandler, FunctionWheelHandler$1 functionWheelHandler$1) {
        this(functionWheelHandler);
    }
}

