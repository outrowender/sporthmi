/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview.states;

import de.audi.tghu.navi.app.map.handler.preview.PreviewMapHandlerAbstract;
import de.audi.tghu.navi.app.map.handler.preview.states.PreviewMapStateAbstract;
import org.dsi.ifc.global.NavLocation;

public class PreviewMapStateDummy
extends PreviewMapStateAbstract {
    protected PreviewMapStateDummy(PreviewMapHandlerAbstract previewMapHandlerAbstract) {
        super(previewMapHandlerAbstract, null, null);
    }

    @Override
    public void applyToScreenDetail() {
    }

    @Override
    public void applyToScreenDetailModels() {
    }

    @Override
    public void applyToScreenFullMap() {
    }

    @Override
    public NavLocation getNavLocationForEnterInMap() {
        return null;
    }
}

