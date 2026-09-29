/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerOpenCloseController;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.SplitGlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerContentManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer.EntertainmentDrawerState;

public class SplitGlassplateRendererHigh
extends AbstractKanziTemplateRenderer
implements GlassplateRenderer {
    private static final String EAL_NODE_NAME;
    private static final int MIN_SDS_GLASSPLATE_HEIGHT;
    private static final int PARKING_DISCLAIMER_Y_OFFSET_OPENED;
    private static final int PARKING_DISCLAIMER_Y_OFFSET_CLOSED;
    private final SplitGlassplateController controller;
    private IWrappedTexture blackBackgroundTexture;
    protected IWrappedNode3D sdsGlassplate = null;
    protected IWrappedNode3D disclaimerGlassplate = null;

    public SplitGlassplateRendererHigh(SplitGlassplateController splitGlassplateController) {
        this.controller = splitGlassplateController;
    }

    @Override
    public void prepareRedrawContextForChildren(RedrawContext redrawContext, AbstractWidget abstractWidget) {
        super.prepareRedrawContextForChildren(redrawContext, abstractWidget);
        if (this.node == null) {
            logChannel3DEngine.log(10000, "CompositeRendererHigh#prepareRedrawContextForChildren: node is null");
            return;
        }
        if (!this.node.isValid()) {
            logChannel3DEngine.log(10000, "CompositeRendererHigh#prepareRedrawContextForChildren: node is invalid");
            return;
        }
        ((RedrawContextHigh)redrawContext).parentNode = this.node;
    }

    private IWrappedTexture getBlackBackgroundTexture() {
        if (this.blackBackgroundTexture != null) {
            return this.blackBackgroundTexture;
        }
        TextureDescription textureDescription = this.getEALManager().createTextureDescription(HMIImageConstantsSystem.black_pixel, false, this.getInitContext().getScreenID());
        if (textureDescription == null) {
            return null;
        }
        this.blackBackgroundTexture = textureDescription.getTexture(this);
        return this.blackBackgroundTexture;
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        int n = this.controller.getX();
        int n2 = this.controller.getY();
        int n3 = this.controller.getWidth();
        int n4 = this.controller.getScreenHeight();
        EntertainmentDrawerOpenCloseController entertainmentDrawerOpenCloseController = (EntertainmentDrawerOpenCloseController)this.controller.getParent();
        EntertainmentDrawerState entertainmentDrawerState = entertainmentDrawerOpenCloseController.getAnimationStates().getCurrentState();
        EntertainmentDrawerState entertainmentDrawerState2 = entertainmentDrawerOpenCloseController.getAnimationStates().getTargetState();
        boolean bl = entertainmentDrawerState.getContent() != null && entertainmentDrawerState.getContent().getGlassplateType() == 1;
        float f2 = (float)n + (float)n3 / 2.0f;
        this.node.setPosition(f2, bl ? 0.0f : (float)n2, 0.0f);
        this.setProperty("gp_contentFBOwidth", SplitGlassplateRendererHigh.getOffscreenWidth());
        this.setProperty("gp_contentFBOheight", SplitGlassplateRendererHigh.getOffscreenHeight());
        logChannel.log(-2137614336, "SplitGlassplateRendererHigh#applyProperties set offscreenFBOSize width: %1, height: %2", (long)SplitGlassplateRendererHigh.getOffscreenWidth(), (long)SplitGlassplateRendererHigh.getOffscreenHeight());
        this.setProperty("gp_width", n3);
        this.setProperty("gp_height", n4);
        this.setProperty("gp_separatorPos", this.controller.getSeparatorPosition());
        this.setProperty("gp_SDS_commandline_small", bl ? 1.0f : 0.0f);
        if (entertainmentDrawerState2 != null && entertainmentDrawerState2.getContent() != null && EntertainmentDrawerContentManager.isAPSAudioSource(entertainmentDrawerState2.getContent().getAudioSource())) {
            this.setProperty("gp_headerOffsetY", 16450);
        } else {
            this.setProperty("gp_headerOffsetY", 0.0f);
        }
        if (entertainmentDrawerState2 != null) {
            this.setProperty("gp_hasHeader", entertainmentDrawerState2.isHeaderVisible());
        } else {
            this.setProperty("gp_hasHeader", 0.0f);
        }
        IWrappedTexture iWrappedTexture = this.getBlackBackgroundTexture();
        ITexture iTexture = iWrappedTexture == null ? null : iWrappedTexture.getTexture();
        this.setProperty("ContentTex", iTexture);
        this.applyPropertiesSDSGlassplate(bl, n3, entertainmentDrawerState);
        this.applyPropertiesParking(n3, entertainmentDrawerState);
    }

    private void applyPropertiesSDSGlassplate(boolean bl, int n, EntertainmentDrawerState entertainmentDrawerState) {
        if (this.sdsGlassplate == null) {
            String string = EALManager.createNodeName("entdrawer_splitglasspane_SDS", this);
            this.sdsGlassplate = this.getEALManager().createTemplateInstanceNode(this.node, string, 0.0f, 0.0f, 6, "Prefabs/generic_glassPlate_entertainmentDrawer_commands", this.getInitContext().getScreenID());
        }
        if (this.sdsGlassplate != null && this.sdsGlassplate.isValid()) {
            this.sdsGlassplate.setVisible(bl && entertainmentDrawerState.getYTranslation() > 41025);
            if (bl) {
                this.propertyCache.setProperty(this.sdsGlassplate, "gp_height", Math.max(entertainmentDrawerState.getYTranslation(), (float)41025));
                this.propertyCache.setProperty(this.sdsGlassplate, "gp_width", (float)n);
            }
        }
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    private void applyPropertiesParking(int n, EntertainmentDrawerState entertainmentDrawerState) {
        int n2 = 0;
        int n3 = 0;
        boolean bl = false;
        AbstractWidgetController abstractWidgetController = this.controller.getDisclaimer();
        if (abstractWidgetController != null && (bl = abstractWidgetController.isVisible())) {
            n2 = (int)((float)(-abstractWidgetController.getHeight()) + (entertainmentDrawerState.getYTranslation() > 41025 ? (int)(-entertainmentDrawerState.getYTranslation() + 65) : 16448));
            n3 = abstractWidgetController.getHeight();
            abstractWidgetController.setBounds(-n / 2, n2, n, abstractWidgetController.getHeight());
        }
        if (this.disclaimerGlassplate == null) {
            this.disclaimerGlassplate = this.getEALManager().createTemplateInstanceNode(this.node, EALManager.createNodeName("entdrawer_splitglasspane_PRK", this), 0.0f, 0.0f, 6, "Prefabs/generic_glassPlate_entertainmentDrawer", this.getInitContext().getScreenID());
            if (this.disclaimerGlassplate != null && this.disclaimerGlassplate.isValid()) {
                this.propertyCache.setProperty(this.disclaimerGlassplate, "gp_SDS_commandline_small", 1.0f);
            }
        }
        if (this.disclaimerGlassplate != null && this.disclaimerGlassplate.isValid()) {
            this.disclaimerGlassplate.setVisible(bl);
            if (bl) {
                this.propertyCache.setProperty(this.disclaimerGlassplate, "gp_width", (float)n);
                this.propertyCache.setProperty(this.disclaimerGlassplate, "gp_height", (float)n3);
                this.disclaimerGlassplate.setPosition(0.0f, n2, 0.0f);
            }
        }
    }

    @Override
    protected String getTemplateNodePath() {
        return "Prefabs/generic_glassPlate_entertainmentDrawer";
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    protected String getEALNodeName() {
        return "entdrawer_splitglasspane";
    }

    @Override
    public void disconnect() {
        EALManager eALManager = this.getEALManager();
        if (eALManager != null) {
            eALManager.destroy(this.sdsGlassplate);
            eALManager.destroy(this.disclaimerGlassplate);
            if (this.blackBackgroundTexture != null) {
                this.blackBackgroundTexture.releaseTexture(true, this);
                this.blackBackgroundTexture = null;
            }
        }
        super.disconnect();
    }

    public void setSDSCommandLineValue(float f2) {
    }

    @Override
    protected int getKzbConstant() {
        return 6;
    }
}

