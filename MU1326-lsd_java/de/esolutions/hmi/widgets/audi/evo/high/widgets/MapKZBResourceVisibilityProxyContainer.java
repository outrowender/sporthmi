/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.eal.IMixedListCallback;
import de.esolutions.hmi.widgets.audi.base.eal.MixedListKZBMerger;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;

public class MapKZBResourceVisibilityProxyContainer
extends LayoutContainerController
implements IMixedListCallback {
    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        MixedListKZBMerger.addCallbackListener(this);
        if (!MixedListKZBMerger.kzbMerged) {
            mapOverlayLogCh.log(10000, "MapKZBResourceVisibilityProxyContainer#connected KZB Resource not loaded. Set on screen to false.");
            this.setOnScreen(false);
        }
    }

    @Override
    public void disconnecting() {
        super.disconnecting();
        MixedListKZBMerger.removeCallbackListener(this);
    }

    @Override
    public void kZBMergedCallback(boolean bl) {
        if (bl) {
            mapOverlayLogCh.log(10000, "MapKZBResourceVisibilityProxyContainer#kZBMergedCallback KZB Resource now loaded. Set on screen to true.");
            this.setOnScreen(true);
            this.setCompositesDirty(true);
        }
    }
}

