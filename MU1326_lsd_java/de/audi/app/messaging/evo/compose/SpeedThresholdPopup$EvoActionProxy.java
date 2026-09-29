/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.evo.compose.SpeedThresholdPopup;
import de.audi.app.messaging.evo.compose.SpeedThresholdPopup$1;
import de.audi.app.messaging.evo.guide.DefaultEvoActionProxy;

final class SpeedThresholdPopup$EvoActionProxy
extends DefaultEvoActionProxy
implements IActionProxySubscriber {
    private final /* synthetic */ SpeedThresholdPopup this$0;

    private SpeedThresholdPopup$EvoActionProxy(SpeedThresholdPopup speedThresholdPopup) {
        this.this$0 = speedThresholdPopup;
    }

    @Override
    public void compositionSpeedThresholdPopupReturn(int n) {
        SpeedThresholdPopup.access$400(this.this$0).log(-2137614336, "[SpeedThresholdPopup#compositionSpeedThresholdPopupReturn]");
        SpeedThresholdPopup.access$500(this.this$0);
    }

    /* synthetic */ SpeedThresholdPopup$EvoActionProxy(SpeedThresholdPopup speedThresholdPopup, SpeedThresholdPopup$1 speedThresholdPopup$1) {
        this(speedThresholdPopup);
    }
}

