/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview.states;

import de.audi.tghu.navi.app.map.handler.preview.PreviewMapHandlerAbstract;
import de.audi.tghu.navi.app.map.handler.preview.states.PreviewMapStateRoute;

public class PreviewMapStateRouteRgActive
extends PreviewMapStateRoute {
    public PreviewMapStateRouteRgActive(PreviewMapHandlerAbstract previewMapHandlerAbstract, boolean bl) {
        super(previewMapHandlerAbstract, bl, previewMapHandlerAbstract.getMapForPreview().getNavigationEnv().getContainer().isRgActive());
    }

    @Override
    public void applyToScreenDetail() {
        this.rgActive = this.getMapForPreview().getNavigationEnv().getContainer().isRgActive();
        super.applyToScreenDetail();
    }

    @Override
    public void applyToScreenFullMap() {
        super.applyToScreenFullMap();
    }

    @Override
    public String toString() {
        return "PreviewMapStateRouteRgActive()";
    }

    @Override
    public boolean isRefreshRequiredOnUpdateRgActive() {
        return true;
    }
}

