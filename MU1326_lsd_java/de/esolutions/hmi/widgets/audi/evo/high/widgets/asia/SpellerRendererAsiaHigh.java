/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets.asia;

import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.SpellerRendererEuropeHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class SpellerRendererAsiaHigh
extends SpellerRendererEuropeHigh {
    private static final int CLOSE_PREVIEW_BACKGROUND_MODULATE_COLOR_VALUE = -3355444;
    public static final float OPACITY_FULL = 1.0f;
    public static final float OPACITY_GRAYED_OUT = 0.2f;
    private final SpellerControllerAsia controller;
    private int closePreviewBackGroundModulateColor;
    private int nullModulateColor;

    public SpellerRendererAsiaHigh(SpellerControllerAsia spellerControllerAsia) {
        super(spellerControllerAsia);
        this.controller = spellerControllerAsia;
    }

    protected Map getLayoutData() {
        return this.layoutData;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        super.applyProperties(redrawContextHigh);
        float f2 = this.getOpacityToSet(this.controller.isConversionLineFocused());
        this.setOpacityForAllVisibleSpellerBandNodes(f2);
        this.setOpacityForSpellerBandCursorNode(f2);
        this.setOpacityForClosePreview(f2);
    }

    private void setOpacityForClosePreview(float f2) {
        IWrappedNode3DImage iWrappedNode3DImage = this.getClosePreviewBackgroundNode();
        iWrappedNode3DImage.setModulateColor(this.getClosePreviewBackGroundModulateColor());
        IWrappedNode3D iWrappedNode3D = this.getClosePreviewButton();
        SpellerRendererAsiaHigh.setOpacityIfVisible(iWrappedNode3D, f2);
    }

    private int getClosePreviewBackGroundModulateColor() {
        if (this.controller.isConversionLineFocused()) {
            return this.closePreviewBackGroundModulateColor;
        }
        return this.nullModulateColor;
    }

    private void setOpacityForSpellerBandCursorNode(float f2) {
        IWrappedNode3D iWrappedNode3D = this.getCursorNode();
        SpellerRendererAsiaHigh.setOpacityIfVisible(iWrappedNode3D, f2);
    }

    private void setOpacityForAllVisibleSpellerBandNodes(float f2) {
        boolean bl = !this.controller.isConversionLineFocused();
        float f3 = bl ? 0.3f : 0.2f;
        Collection collection = this.layoutData.values();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            SpellerRendererEuropeHigh.SpellerLayoutContainer spellerLayoutContainer = (SpellerRendererEuropeHigh.SpellerLayoutContainer)iterator.next();
            this.setOpacityForSpellerItemIfVisible(spellerLayoutContainer, f2, f3);
        }
    }

    private void setOpacityForSpellerItemIfVisible(SpellerRendererEuropeHigh.SpellerLayoutContainer spellerLayoutContainer, float f2, float f3) {
        boolean bl;
        boolean bl2 = bl = !this.controller.isConversionLineFocused() && !(spellerLayoutContainer.getNodeNormal() instanceof IWrappedNode3DText) && !spellerLayoutContainer.getSpellerItem().isEnabled();
        if (bl) {
            SpellerRendererAsiaHigh.setOpacityIfVisible(spellerLayoutContainer.getNodeNormal(), f3);
            SpellerRendererAsiaHigh.setOpacityIfVisible(spellerLayoutContainer.getNodeBig(), f3);
        } else {
            SpellerRendererAsiaHigh.setOpacityIfVisible(spellerLayoutContainer.getNodeNormal(), f2);
            SpellerRendererAsiaHigh.setOpacityIfVisible(spellerLayoutContainer.getNodeBig(), f2);
        }
    }

    private float getOpacityToSet(boolean bl) {
        if (this.controller.isConversionLineFocused()) {
            return 0.2f;
        }
        return 1.0f;
    }

    private static void setOpacityIfVisible(IWrappedNode3D iWrappedNode3D, float f2) {
        if (iWrappedNode3D != null && iWrappedNode3D.isVisible()) {
            iWrappedNode3D.setOpacity(f2);
        }
    }

    protected void initColors(RedrawContext redrawContext) {
        super.initColors(redrawContext);
        this.closePreviewBackGroundModulateColor = EALManager.createColorCode(-3355444);
        this.nullModulateColor = EALManager.createColorCode(-1);
    }

    protected void destroyColors() {
        super.destroyColors();
    }
}

