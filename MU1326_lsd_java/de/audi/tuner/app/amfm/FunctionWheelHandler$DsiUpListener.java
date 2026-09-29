/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.FunctionWheelHandler;
import de.audi.tuner.app.amfm.FunctionWheelHandler$1;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import org.dsi.ifc.radio.WavebandInfo;

class FunctionWheelHandler$DsiUpListener
extends AMFMDsiUpInfo {
    private final /* synthetic */ FunctionWheelHandler this$0;

    private FunctionWheelHandler$DsiUpListener(FunctionWheelHandler functionWheelHandler) {
        this.this$0 = functionWheelHandler;
    }

    @Override
    public void updateSelectedStation(AMFMStation aMFMStation) {
        FunctionWheelHandler.access$1400(this.this$0, aMFMStation);
    }

    @Override
    public void updateSeekStation(AMFMStation aMFMStation) {
        FunctionWheelHandler.access$1400(this.this$0, aMFMStation);
    }

    @Override
    public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray) {
        FunctionWheelHandler.access$1500(this.this$0, wavebandInfoArray);
    }

    /* synthetic */ FunctionWheelHandler$DsiUpListener(FunctionWheelHandler functionWheelHandler, FunctionWheelHandler$1 functionWheelHandler$1) {
        this(functionWheelHandler);
    }
}

