/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview.states;

import de.audi.tghu.navi.app.map.handler.preview.PreviewMapHandlerAbstract;
import de.audi.tghu.navi.app.map.handler.preview.states.PreviewMapStateAbstract;
import org.dsi.ifc.global.NavLocation;

public class PreviewMapStateHidden
extends PreviewMapStateAbstract {
    public PreviewMapStateHidden(PreviewMapHandlerAbstract previewMapHandlerAbstract) {
        super(previewMapHandlerAbstract, null, null);
    }

    public void applyToScreenDetail() {
    }

    public void applyToScreenDetailModels() {
    }

    public void applyToScreenFullMap() {
    }

    public String toString() {
        return "PreviewMapStateHidden()";
    }

    public NavLocation getNavLocationForEnterInMap() {
        return null;
    }
}

