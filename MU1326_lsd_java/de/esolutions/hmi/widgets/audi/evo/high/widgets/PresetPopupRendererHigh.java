/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractRenderer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.GlassplateRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PartialPopupRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.PresetPopupController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PresetPopupHeadlineController;

public class PresetPopupRendererHigh
extends PartialPopupRendererHigh {
    public PresetPopupRendererHigh(PresetPopupController presetPopupController) {
        super(presetPopupController);
    }

    @Override
    protected void renderNode(RedrawContextHigh redrawContextHigh) {
        IWrappedNode3D iWrappedNode3D = this.getEALManager().createNode3D(this.getEALManager().getPresetPopupNode(), EALManager.createNodeName("presetPopup", ((PresetPopupController)this.controller).getID(), (AbstractRenderer)this), 0.0f, 0.0f);
        this.renderNode(iWrappedNode3D, 0);
        if (this.hasGlassplate()) {
            this.offscreenLayer = this.getEALManager().createLayer(EALManager.createNodeName("PartialPopupGlassplate", this), -10, GlassplateRendererHigh.OFFSCREEN_TEXTURE_WIDTH, GlassplateRendererHigh.OFFSCREEN_TEXTURE_HEIGHT);
        }
    }

    @Override
    protected IWrappedNode3D getParentNode(RedrawContextHigh redrawContextHigh) {
        return this.getEALManager().getPresetPopupNode();
    }

    @Override
    public void prepareRedrawContextForChildren(RedrawContext redrawContext, AbstractWidget abstractWidget) {
        if (abstractWidget instanceof PresetPopupHeadlineController) {
            if (this.node == null) {
                logChannel3DEngine.log(10000, "PresetPopupRendererHigh#prepareRedrawContextForChildren: node is null");
                return;
            }
            if (!this.node.isValid()) {
                logChannel3DEngine.log(10000, "PresetPopupRendererHigh#prepareRedrawContextForChildren: node is invalid");
                return;
            }
            ((RedrawContextHigh)redrawContext).parentNode = this.node;
        } else {
            super.prepareRedrawContextForChildren(redrawContext, abstractWidget);
        }
    }
}

