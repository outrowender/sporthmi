/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.util.Util;
import de.esolutions.graphics.eal.api.ITextureShared;
import de.esolutions.hmi.widgets.audi.base.HMIImage;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureFrameController;

public class PictureFrameRenderer
extends AbstractKanziTemplateRenderer
implements AnimationListener {
    private static final String PROPERTY_TEXTURE;
    private int currentValue = -1;
    private HMIResourceLocator currentHMIResourceLocator;
    private IWrappedTexture contentTexture;
    private PictureFrameController controller;
    private AbstractAnimation updateAnimation;

    @Override
    public void animate(int n, float f2, int n2) {
        this.updateSharedTexture();
        this.controller.setCompositesDirty(true);
    }

    @Override
    public void animationFinished(int n, int n2) {
    }

    @Override
    public void animationStarted(int n, int n2) {
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        int n = this.controller.getX();
        int n2 = this.controller.getY();
        int n3 = this.controller.getWidth();
        int n4 = this.controller.getHeight();
        this.node.setPosition(n, n2, 0.0f);
        this.setProperty("gp_width", n3);
        this.setProperty("gp_height", n4);
        this.node.setOpacity(this.controller.getRenderOpacity());
        this.node.setVisible(this.controller.isVisible() && this.controller.isVisibleOnCurrentStage());
        if (pictureFrameLogCh.isDebug()) {
            pictureFrameLogCh.log(-2137614336, "PictureFrameRenderer#applyProperties x = %1, y = %2", (long)n, (long)n2);
            pictureFrameLogCh.log(-2137614336, "PictureFrameRenderer#applyProperties width = %1, height = %2", (long)n3, (long)n4);
            pictureFrameLogCh.log(-2137614336, "PictureFrameRenderer#applyProperties visible = %1, visibleOnCurrentStage = %2", this.controller.isVisible(), this.controller.isVisibleOnCurrentStage());
        }
        if (this.contentTexture != null) {
            this.setProperty("ContentTex", this.contentTexture.getTexture());
        } else {
            mapOverlayLogCh.log(10000, "PictureFrameRenderer#applyProperties Texture is null (%1) or not valid.", this.contentTexture == null);
        }
    }

    @Override
    public void disconnect() {
        this.stopUpdateAnimation();
        this.getEALManager().destroy(this.contentTexture);
        super.disconnect();
        this.contentTexture = null;
        this.currentValue = -1;
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    protected String getEALNodeName() {
        return "pictureFrame";
    }

    @Override
    protected String getTemplateNodePath() {
        switch (this.controller.getType()) {
            case 0: 
            case 2: {
                return "Prefabs/w140_image_border";
            }
            case 1: {
                return "Prefabs/w142_streetviewFrame";
            }
            case 3: {
                return "Prefabs/w140_kanban";
            }
        }
        pictureFrameLogCh.log(10000, "PictureFrameRenderer#getTemplateNodePath No case defined for type = %1.", (long)this.controller.getType());
        return null;
    }

    public PictureFrameRenderer(PictureFrameController pictureFrameController) {
        this.controller = pictureFrameController;
    }

    @Override
    public void render(RedrawContext redrawContext) {
        pictureFrameLogCh.log(-2137614336, "PictureFrameRenderer#render");
        if (this.controller.isUpdateFromDisplayable()) {
            if (this.contentTexture == null) {
                long l = System.currentTimeMillis();
                TextureDescription textureDescription = this.getEALManager().createTextureDescription(EALManager.createNodeName("PictureFrameTexture", this), this.controller.getWidth(), this.controller.getHeight());
                this.contentTexture = textureDescription.getTexture(this);
                long l2 = System.currentTimeMillis();
                if (this.contentTexture != null) {
                    pictureFrameLogCh.log(-2137614336, "PictureFrameRenderer#render Create new shared texture took %1 ms. Width = %2, height = %3.", l2 - l, (long)this.controller.getWidth(), (long)this.controller.getHeight());
                    this.updateSharedTexture();
                    if (this.controller.isVisible()) {
                        this.startUpdateAnimation();
                    }
                } else {
                    mapOverlayLogCh.log(10000, "PictureFrameRenderer#render Shared texture could not be created.");
                }
            }
        } else if (this.controller.getType() == 0) {
            HMIResourceLocator hMIResourceLocator;
            if (this.controller.getModel() instanceof HMIResourceLocator && !Util.equals(this.currentHMIResourceLocator, hMIResourceLocator = (HMIResourceLocator)this.controller.getModel())) {
                if (this.contentTexture != null) {
                    this.getEALManager().destroy(this.contentTexture);
                }
                this.currentHMIResourceLocator = hMIResourceLocator;
                pictureFrameLogCh.log(-2137614336, "PictureFrameRenderer#render HMMResourceLocator is: %1.", (Object)hMIResourceLocator.toString());
                HMIImage hMIImage = null;
                if (hMIResourceLocator.getStatus() == 1) {
                    hMIImage = this.getBitmap(0);
                    mapOverlayLogCh.log(10000, "PictureFrameRenderer#render HMIResourceLocator is not valid.");
                } else {
                    hMIImage = this.getEALManager().getHMIImage(hMIResourceLocator, this.controller.getInitContext().getScreenID(), false);
                }
                if (hMIImage != null) {
                    pictureFrameLogCh.log(-2137614336, "PictureFrameRenderer#render Load bitmap with path = %1", (Object)hMIImage);
                    TextureDescription textureDescription = this.getEALManager().createTextureDescription(hMIImage, null, false);
                    this.contentTexture = textureDescription.getTexture(this);
                } else {
                    mapOverlayLogCh.log(10000, "PictureFrameRenderer#render Error creating bitmap from HMIResourceLocator.");
                }
            }
        } else if (this.controller.getType() == 0) {
            int n = this.controller.getValue();
            if (n != this.currentValue) {
                this.currentValue = n;
                EALManager eALManager = this.getEALManager();
                eALManager.destroy(this.contentTexture);
                TextureDescription textureDescription = this.getEALManager().createTextureDescription(this.getBitmap(n), null, false);
                this.contentTexture = textureDescription.getTexture(this);
            } else {
                pictureFrameLogCh.log(-2137614336, "PictureFrameRenderer#render Value = %1 not changed.", (long)n);
            }
        } else {
            pictureFrameLogCh.log(-2137614336, "PictureFrameRenderer#render Unknown type: %1", (long)this.controller.getType());
        }
        super.render(redrawContext);
    }

    public void setVisible(boolean bl) {
        pictureFrameLogCh.log(-2137614336, "PictureFrameRenderer#setVisible visible = %1", bl);
        if (bl) {
            this.startUpdateAnimation();
        } else {
            this.stopUpdateAnimation();
        }
    }

    private void startUpdateAnimation() {
        if (!this.controller.isConnected()) {
            return;
        }
        pictureFrameLogCh.log(-2137614336, "PictureFrameRenderer#startUpdateAnimation Widget is visible = %1", this.controller.isVisible());
        if (this.updateAnimation == null) {
            this.updateAnimation = (AbstractAnimation)this.getTerminal().getIAnimationController().getIAnimation(1);
            this.updateAnimation.addListener(this);
            this.updateAnimation.setBlockRepaint(false);
        }
        if (!this.updateAnimation.isAnimating()) {
            this.updateAnimation.startEndlessAnimation(this.controller.getUpdateInterval(), this.controller);
        }
    }

    private void stopUpdateAnimation() {
        if (!this.controller.isConnected()) {
            return;
        }
        if (this.updateAnimation != null && this.updateAnimation.isAnimating()) {
            this.updateAnimation.stopAnimation();
        }
        this.updateAnimation = null;
    }

    private void updateSharedTexture() {
        if (this.controller.isUpdateFromDisplayable() && this.contentTexture instanceof ITextureShared) {
            ITextureShared iTextureShared = (ITextureShared)((Object)this.contentTexture);
            if (this.controller.useCaptureRect()) {
                int[] nArray = this.controller.getCaptureRect();
                iTextureShared.updateFromDisplayable(this.controller.getDisplayableID(), nArray[0], nArray[1], nArray[2], nArray[3]);
            } else {
                iTextureShared.updateFromDisplayable(this.controller.getDisplayableID());
            }
            pictureFrameLogCh.log(-2137614336, "PictureFrameRenderer#updateSharedTexture Update texture from displayable with ID = %1.", (long)this.controller.getDisplayableID());
        }
    }

    @Override
    protected int getKzbConstant() {
        return 6;
    }
}

