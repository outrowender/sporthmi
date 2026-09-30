/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.eal.IMixedListCallback;
import de.esolutions.hmi.widgets.audi.base.eal.MixedListKZBMerger;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.MapOverlayPlateRenderer;

public class MapOverlayPlateController
extends AbstractWidgetController
implements IMixedListCallback {
    private MapOverlayPlateRenderer renderer;

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        MixedListKZBMerger.addCallbackListener(this);
    }

    public void disconnecting() {
        MixedListKZBMerger.removeCallbackListener(this);
        super.disconnecting();
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(MapOverlayPlateRenderer mapOverlayPlateRenderer) {
        this.renderer = mapOverlayPlateRenderer;
    }

    public void kZBMergedCallback(boolean bl) {
        mixedListItemLogCh.log(10000000, "MapOverlayPlateController#kZBMergedCallback success: %1", bl);
        if (bl) {
            this.setCompositesDirty(true);
            this.triggerRepaint();
        }
    }
}

