/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.audi.tghu.hmi.evo.ICarCodingHelper;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.I3DCarListener;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.Car3DResourceHandler;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.EALPropertyCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedLayer;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateRenderer;

public class GlassplateRendererHigh
extends AbstractKanziTemplateRenderer
implements GlassplateRenderer,
I3DCarListener {
    public static final int OFFSCREEN_TEXTURE_WIDTH = GlassplateRendererHigh.getOffscreenWidth();
    public static final int OFFSCREEN_TEXTURE_HEIGHT = GlassplateRendererHigh.getOffscreenHeight();
    private static final String EAL_NODE_NAME;
    private static final String EAL_NODE_NAME_SEPARATOR;
    private static final String SPORTSKIN_PROPERTY;
    private static final String texture_translation;
    private static final float CAR_DARKENING_FACTOR;
    private static IWrappedTexture emptyTexture;
    private static IWrappedTexture blackBackgroundTexture;
    private final GlassplateController controller;
    private IWrappedNode3D separatorNode;
    private IWrappedLayer offscreenLayer;
    private IWrappedNode3D offsetNode;
    private IWrappedNode3DText scdTextNode;
    private int scdTextColor;

    public GlassplateRendererHigh(GlassplateController glassplateController) {
        this.controller = glassplateController;
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        float f2;
        int n;
        Object object;
        int n2 = this.controller.getX();
        int n3 = this.controller.getY();
        int n4 = this.controller.getWidth();
        int n5 = this.controller.getHeight();
        float f3 = this.controller.getSdsNumbersVisible() * (float)this.controller.getActiveSdsNumbersWidth();
        int n6 = Math.round(f3 / 2.0f);
        this.node.setPosition(n2 - n6, n3, 0.0f);
        this.propertyCache.setProperty(this.node, "gp_contentFBOwidth", (float)GlassplateRendererHigh.getOffscreenWidth());
        this.propertyCache.setProperty(this.node, "gp_contentFBOheight", (float)GlassplateRendererHigh.getOffscreenHeight());
        logChannel.log(-2137614336, "GlassplateRendererHigh#applyProperties set offscreenFBOSize width: %1, height: %2", (long)GlassplateRendererHigh.getOffscreenWidth(), (long)GlassplateRendererHigh.getOffscreenHeight());
        this.propertyCache.setProperty(this.node, "gp_SDS_column_width", (float)this.controller.getActiveSdsNumbersWidth());
        this.propertyCache.setProperty(this.node, "gp_width", (float)n4);
        this.propertyCache.setProperty(this.node, "gp_height", (float)n5);
        this.propertyCache.setProperty(this.node, "gp_scale", this.controller.getPropertyScale());
        this.propertyCache.setProperty(this.node, "gp_minimize", this.controller.getMinimized());
        this.propertyCache.setProperty(this.node, "gp_SDS_state", this.controller.getSdsNumbersVisible());
        this.propertyCache.setProperty(this.node, "gp_selectionDrawer_available", this.controller.isSelectionDrawerIconVisible() ? 1.0f : 0.0f);
        this.propertyCache.setProperty(this.node, "gp_opacity", 1.0f);
        if (emptyTexture == null && (object = this.getEALManager().createTextureDescription(HMIImageConstantsSystem.empty_image, false, this.getInitContext().getScreenID())) != null) {
            emptyTexture = object.getTexture(this);
        }
        if ((object = this.getBackgroundTexture()) == null) {
            n = AbstractWidget.isVariantStd();
            this.propertyCache.setProperty(this.node, "gp_unknownBG", n != 0 ? 0.0f : 1.0f);
            this.propertyCache.setProperty(this.node, "background", emptyTexture.getTexture());
        } else {
            this.propertyCache.setProperty(this.node, "gp_unknownBG", 0.0f);
            this.propertyCache.setProperty(this.node, "background", object.getTexture());
        }
        this.propertyCache.setProperty(this.node, "gp_SDS_commandline_small", this.controller.isScdExtensionVisible() ? 1.0f : 0.0f);
        if (this.controller.getSCDText() != null) {
            if (this.scdTextNode == null) {
                this.scdTextNode = this.getEALManager().createText3D(this.node, "SCDTextNode", this.controller.getSCDText(), this.getInheritedFont());
                float f4 = this.scdTextNode.getScaleX() * 1899850303;
                f2 = this.scdTextNode.getScaleY() * 1899850303;
                float f5 = this.scdTextNode.getScaleZ();
                this.scdTextNode.setScale(f4, f2, f5);
            } else {
                this.scdTextNode.setText(this.controller.getSCDText(), this.getInheritedFont());
            }
            n = Math.round((float)this.controller.getWidth() - this.scdTextNode.getWidth()) / 2;
            if (this.controller.getSdsNumbersVisible() > 0.0f) {
                n += this.controller.getActiveSdsNumbersWidth();
            }
            this.scdTextNode.setPosition(n, 8425283, 0.0f);
            this.scdTextNode.setVisible(true);
            this.scdTextColor = EALManager.createColorCode(-1);
            this.scdTextNode.getInterfaceText().setColor(this.scdTextColor);
        } else if (this.scdTextNode != null) {
            this.scdTextNode.setVisible(false);
        }
        this.node.setOpacity(this.controller.getRenderOpacity());
        if (this.separatorNode == null) {
            this.separatorNode = this.createSeparatorNode(this.node);
        }
        if (this.separatorNode != null) {
            if (this.controller.getSeparatorVisible()) {
                this.separatorNode.setPosition(f3, this.controller.getSeparatorYPosition(), 0.0f);
                this.separatorNode.setOpacity(this.controller.getRenderOpacity());
                this.propertyCache.setProperty(this.separatorNode, "gp_width", (float)n4);
                this.propertyCache.setProperty(this.separatorNode, "gp_height", (float)n5);
            } else {
                this.separatorNode.setOpacity(0.0f);
            }
        }
        if (this.offscreenLayer == null) {
            IWrappedLayer iWrappedLayer = redrawContextHigh.offscreenLayer;
            if (iWrappedLayer == null) {
                logChannel.log(10000, "GlassplateRendererHigh#applyProperties No offscreen layer found");
            } else {
                IWrappedTexture iWrappedTexture = iWrappedLayer.getViewport().enableOffscreen();
                if (iWrappedTexture == null) {
                    logChannel.log(10000, "GlassplateRendererHigh#applyProperties Could not get offscreen texture");
                    this.propertyCache.setProperty(this.node, "ContentTex", emptyTexture.getTexture());
                } else {
                    this.propertyCache.setProperty(this.node, "ContentTex", iWrappedTexture.getTexture());
                    this.offscreenLayer = iWrappedLayer;
                }
                this.offsetNode = redrawContextHigh.parentNodeSecondary;
            }
        }
        if (null != this.offscreenLayer && this.offscreenLayer.getNode().getOpacity() != this.controller.getOffScreenOpacity()) {
            this.offscreenLayer.getNode().setOpacity(this.controller.getOffScreenOpacity());
            this.offscreenLayer.getViewport().getLink().invalidateObject();
            this.offscreenLayer.setInvalid(true);
        }
        if (null != this.offscreenLayer && this.offscreenLayer.isInvalid()) {
            this.setPropertyWithoutChangeCheck("gp_invalidate", true);
            this.offscreenLayer.setInvalid(false);
        }
        if (this.offsetNode != null) {
            this.offsetNode.setPosition(-n2, -n3, 0.0f);
        }
        Car3DResourceHandler car3DResourceHandler = this.getEALManager().getCar3DResourceHandler();
        f2 = this.getTerminal().getLayout().getIntegerConstant(111);
        if (car3DResourceHandler != null) {
            f2 = car3DResourceHandler.getGridPosition();
        }
        if (!this.controller.isOptionGlassPlate() && car3DResourceHandler != null && car3DResourceHandler.isVisible()) {
            this.propertyCache.setProperty(this.node, "gp_unknownBG", (float)63);
            if (car3DResourceHandler.getMode() == 0) {
                this.propertyCache.setProperty(this.node, "background", emptyTexture.getTexture());
            }
            if (this.isLTR() || this.isArabicAndNotA3()) {
                ITexture iTexture = car3DResourceHandler.getTexture();
                if (iTexture == null) {
                    iTexture = emptyTexture.getTexture();
                }
                this.propertyCache.setProperty(this.node, "ContentTexFlexible", iTexture);
                this.update3DCarTexturePosition();
            }
        } else {
            this.propertyCache.setProperty(this.node, "ContentTexFlexible", emptyTexture.getTexture());
        }
        if (!this.controller.isOptionGlassPlate()) {
            this.propertyCache.setProperty(this.node, "screenWidth", (float)this.getTerminal().getLayout().getDistance(1));
            this.propertyCache.setProperty(this.node, "screenHeight", (float)this.getTerminal().getLayout().getDistance(2));
            this.propertyCache.setProperty(this.node, "gp_gridSizeX", (float)this.getTerminal().getLayout().getDistance(228));
            if (EALPropertyCache.isPropertyAvailable(this.node.getNode(), "gp_gridOffsetX")) {
                this.propertyCache.setProperty(this.node, "gp_gridOffsetX", f2);
            }
        }
        if (this.isSportskinSmallStage()) {
            this.propertyCache.setProperty(this.node, "gp_stageBig", 0.0f);
        } else {
            this.propertyCache.setProperty(this.node, "gp_stageBig", 1.0f);
        }
    }

    protected boolean isArabicAndNotA3() {
        return !this.isLTR() && !this.isA3();
    }

    protected boolean isA3() {
        ICarCodingHelper iCarCodingHelper;
        HMITerminalImpl hMITerminalImpl = this.getTerminal();
        if (hMITerminalImpl != null && (iCarCodingHelper = hMITerminalImpl.getCarCodingHelper()) != null) {
            return iCarCodingHelper.isA3();
        }
        return false;
    }

    private void update3DCarTexturePosition() {
        Car3DResourceHandler car3DResourceHandler = this.getEALManager().getCar3DResourceHandler();
        float f2 = car3DResourceHandler.getGridPosition();
        if (car3DResourceHandler != null && car3DResourceHandler.isVisible()) {
            int n = this.controller.getX() != 0 ? this.controller.getX() : this.controller.getParent().getX();
            int n2 = this.controller.getWidth();
            float f3 = (float)n + (float)n2 / 2.0f;
            this.propertyCache.setProperty(this.node, "gp_textureOffset_X", car3DResourceHandler.getLayerPosX(f3));
            this.propertyCache.setProperty(this.node, "gp_textureOffset_Y", car3DResourceHandler.getLayerPosY());
            this.propertyCache.setProperty(this.node, "gp_textureSize_X", car3DResourceHandler.getLayerWidth());
            this.propertyCache.setProperty(this.node, "gp_textureSize_Y", car3DResourceHandler.getLayerHeight());
            this.propertyCache.setProperty(this.node, "gp_unknownBG", 1.0f - 63 * car3DResourceHandler.getOpacity());
            this.propertyCache.setProperty(this.node, "gp_gridOffsetX", f2);
        }
    }

    @Override
    public void contentChanged() {
        if (this.node != null) {
            this.setPropertyWithoutChangeCheck("gp_invalidate", true);
            this.update3DCarTexturePosition();
        }
    }

    private IWrappedTexture getBackgroundTexture() {
        if (this.controller.getPropertyOpacity() == 16448) {
            return this.getBlackBackgroundTexture();
        }
        return this.getEALManager().getBackgroundTexture();
    }

    private IWrappedTexture getBlackBackgroundTexture() {
        if (blackBackgroundTexture != null) {
            return blackBackgroundTexture;
        }
        TextureDescription textureDescription = this.getEALManager().createTextureDescription(HMIImageConstantsSystem.black_pixel, false, this.getInitContext().getScreenID());
        if (textureDescription == null) {
            return null;
        }
        blackBackgroundTexture = textureDescription.createTexture();
        return blackBackgroundTexture;
    }

    @Override
    protected String getTemplateNodePath() {
        if (this.controller.isOptionGlassPlate()) {
            return "Prefabs/generic_glassPlate_optionsDrawer";
        }
        return "Prefabs/generic_glassPlate";
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    protected String getEALNodeName() {
        return "glassPlate";
    }

    private IWrappedNode3D createSeparatorNode(IWrappedNode3D iWrappedNode3D) {
        return this.getEALManager().createTemplateInstanceNode(iWrappedNode3D, EALManager.createNodeName("glassplate_separator", this), 0.0f, 0.0f, this.getKzbConstant(), "Prefabs/generic_glassPlate_separator", this.getInitContext().getScreenID());
    }

    @Override
    public void connect(InitializationContext initializationContext) {
        Car3DResourceHandler car3DResourceHandler;
        super.connect(initializationContext);
        if (!this.controller.isOptionGlassPlate() && (car3DResourceHandler = this.getEALManager().getCar3DResourceHandler()) != null) {
            car3DResourceHandler.registerRefractionGlassplate(this);
        }
    }

    @Override
    public void disconnect() {
        Car3DResourceHandler car3DResourceHandler = this.getEALManager().getCar3DResourceHandler();
        if (car3DResourceHandler != null) {
            car3DResourceHandler.unRegisterRefractionGlassplate(this);
        }
        if (this.offscreenLayer != null) {
            this.offscreenLayer.getNode().setOpacity(1.0f);
            this.offscreenLayer.getViewport().disableOffscreen();
            this.offscreenLayer = null;
        }
        if (this.separatorNode != null) {
            this.getEALManager().destroy(this.separatorNode);
            this.separatorNode = null;
        }
        if (this.scdTextNode != null) {
            this.getEALManager().destroy(this.scdTextNode);
            this.scdTextNode = null;
        }
        this.offsetNode = null;
        super.disconnect();
    }

    private boolean isSportskinSmallStage() {
        return this.controller.getTerminalImpl().getViewSizeManager().isSportskinSmallStage();
    }

    @Override
    protected int getKzbConstant() {
        return 6;
    }

    @Override
    public void prepareRedrawContextForChildren(RedrawContext redrawContext, AbstractWidget abstractWidget) {
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        redrawContextHigh.parentNode = this.node;
    }
}

