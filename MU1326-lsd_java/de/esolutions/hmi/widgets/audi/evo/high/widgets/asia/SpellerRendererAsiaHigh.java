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
import de.esolutions.hmi.widgets.audi.evo.high.widgets.SpellerRendererEuropeHigh$SpellerLayoutContainer;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class SpellerRendererAsiaHigh
extends SpellerRendererEuropeHigh {
    private static final int CLOSE_PREVIEW_BACKGROUND_MODULATE_COLOR_VALUE;
    public static final float OPACITY_FULL;
    public static final float OPACITY_GRAYED_OUT;
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

    @Override
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
        int n = bl ? -1701209794 : -842249154;
        Collection collection = this.layoutData.values();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer = (SpellerRendererEuropeHigh$SpellerLayoutContainer)iterator.next();
            this.setOpacityForSpellerItemIfVisible(spellerRendererEuropeHigh$SpellerLayoutContainer, f2, n);
        }
    }

    private void setOpacityForSpellerItemIfVisible(SpellerRendererEuropeHigh$SpellerLayoutContainer spellerRendererEuropeHigh$SpellerLayoutContainer, float f2, float f3) {
        boolean bl;
        boolean bl2 = bl = !this.controller.isConversionLineFocused() && !(spellerRendererEuropeHigh$SpellerLayoutContainer.getNodeNormal() instanceof IWrappedNode3DText) && !spellerRendererEuropeHigh$SpellerLayoutContainer.getSpellerItem().isEnabled();
        if (bl) {
            SpellerRendererAsiaHigh.setOpacityIfVisible(spellerRendererEuropeHigh$SpellerLayoutContainer.getNodeNormal(), f3);
            SpellerRendererAsiaHigh.setOpacityIfVisible(spellerRendererEuropeHigh$SpellerLayoutContainer.getNodeBig(), f3);
        } else {
            SpellerRendererAsiaHigh.setOpacityIfVisible(spellerRendererEuropeHigh$SpellerLayoutContainer.getNodeNormal(), f2);
            SpellerRendererAsiaHigh.setOpacityIfVisible(spellerRendererEuropeHigh$SpellerLayoutContainer.getNodeBig(), f2);
        }
    }

    private float getOpacityToSet(boolean bl) {
        if (this.controller.isConversionLineFocused()) {
            return -842249154;
        }
        return 1.0f;
    }

    private static void setOpacityIfVisible(IWrappedNode3D iWrappedNode3D, float f2) {
        if (iWrappedNode3D != null && iWrappedNode3D.isVisible()) {
            iWrappedNode3D.setOpacity(f2);
        }
    }

    @Override
    protected void initColors(RedrawContext redrawContext) {
        super.initColors(redrawContext);
        this.closePreviewBackGroundModulateColor = EALManager.createColorCode(-858993409);
        this.nullModulateColor = EALManager.createColorCode(-1);
    }

    @Override
    protected void destroyColors() {
        super.destroyColors();
    }
}

