/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.util.Util;
import de.esolutions.graphics.eal.api.IMaterial;
import de.esolutions.graphics.eal.api.IProperty;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMIImage;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallCache;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallIconController;

public class PictureWallIconRenderer
extends AbstractRendererHigh {
    private static final String PROPERTY_NAME_HUE = "brightness";
    private static final String PROPERTY_NAME_SATURATION = "saturation";
    private static boolean isMaterialValid;
    private boolean isMaterialPropertyValid;
    private boolean singleMode;
    private static IMaterial materialHueSat;
    private IProperty hue;
    private IProperty sat;
    private static final int STATE_OK = 1;
    private static final int STATE_ERROR = 2;
    private static final int STATE_LISTENING = 3;
    private int renderState = -1;
    private boolean isEmpty = true;
    private float scaleY = 1.0f;
    private float scaleX = 1.0f;
    private int scaleMode = 0;
    private HMIImage displayData;
    private PictureWallIconController controller;
    private IWrappedNode3D nodeGroup1;
    private IWrappedNode3DImage picture;
    private IWrappedNode3DImage backLarge;
    private IWrappedNode3DImage overlayLarge;
    private IWrappedNode3DImage overlaySmall;
    private IWrappedNode3DImage overlaySmallFrame;

    private void applyMaterialTo3DImageNode(IWrappedNode3DImage iWrappedNode3DImage, IMaterial iMaterial) {
        if (iWrappedNode3DImage != null) {
            iWrappedNode3DImage.getImageNode().setMaterial(iMaterial);
        }
    }

    private void applyProperties(RedrawContextHigh redrawContextHigh) {
        this.applyPropertiesNodeGroup1();
    }

    private void applyPropertiesNodeGroup1() {
        float[] fArray = null;
        int n = (int)this.nodeGroup1.getUnscaledWidth();
        int n2 = (int)this.nodeGroup1.getUnscaledHeight();
        fArray = this.calculateScaling(this.controller.getWidth(), this.controller.getHeight(), n, n2);
        this.nodeGroup1.setScale(fArray[0], fArray[1], 1.0f);
        this.nodeGroup1.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        if (this.picture != null) {
            fArray = this.calculateScaling(n, n2, this.picture.getUnscaledWidth(), this.picture.getUnscaledHeight());
            this.picture.setScale(fArray[0], fArray[1], 1.0f);
        }
        if (this.overlaySmall != null) {
            this.overlaySmall.setVisible(false);
            if (this.isEmpty()) {
                this.overlaySmall.setVisible(false);
            }
            int n3 = 20;
            this.overlaySmall.setPosition(n3, 0.0f, 0.0f);
        }
        if (this.backLarge != null) {
            fArray = this.calculateScaling(n, n2, this.backLarge.getUnscaledWidth(), this.backLarge.getUnscaledHeight());
            this.backLarge.setScale(fArray[0], fArray[1], 1.0f);
        }
        if (this.overlayLarge != null) {
            fArray = this.calculateScaling(n, n2, this.overlayLarge.getUnscaledWidth(), this.overlayLarge.getUnscaledHeight());
            this.overlayLarge.setScale(fArray[0], fArray[1], 1.0f);
            this.overlayLarge.setPosition(10.0f, -31.0f, 0.0f);
        }
    }

    private HMIImage calculateDisplayData(Object object) {
        this.isEmpty = false;
        if (this.controller.isConnected() && object instanceof HMIResourceLocator) {
            HMIResourceLocator hMIResourceLocator = (HMIResourceLocator)object;
            return this.getEALManager().getHMIImage(hMIResourceLocator, this.controller.getInitContext().getScreenID(), false);
        }
        this.isEmpty = true;
        return this.getBitmap(0);
    }

    private float[] calculateScaling(int n, int n2, float f2, float f3) {
        if (this.scaleMode == 0) {
            return new float[]{this.scaleX, this.scaleY};
        }
        float f4 = (float)n / f2;
        float f5 = (float)n2 / f3;
        switch (this.scaleMode) {
            case 3: {
                return new float[]{f4, f5};
            }
            case 1: {
                float f6 = Math.min(f4, f5);
                return new float[]{f6, f6};
            }
            case 2: {
                float f7 = Math.max(f4, f5);
                return new float[]{f7, f7};
            }
        }
        logChannel.log(100000, "IconRendererHigh#calculateScaling: unknown scaleMode: %1", (long)this.scaleMode);
        return new float[]{f4, f5};
    }

    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
        if (materialHueSat == null) {
            materialHueSat = this.getEALManager().createMaterial("Prefabs/MaterialLibrary", "Materials/Saturation_Brightness/Saturation_Brightness", 10, -1);
            if (materialHueSat != null && materialHueSat.isValid()) {
                isMaterialValid = true;
            } else {
                pictureWallLogCh.log(10000, "PictureWallIconRenderer#connect Material is null or not valid.");
            }
        }
    }

    private IWrappedNode3DImage createImageNode(IWrappedNode3DImage iWrappedNode3DImage, int n, String string, IWrappedNode3D iWrappedNode3D, int n2) {
        if (iWrappedNode3DImage == null) {
            TextureDescription textureDescription = this.getTextureDescription(n, true);
            if (textureDescription != null) {
                iWrappedNode3DImage = this.getEALManager().createImage3D(iWrappedNode3D, EALManager.createNodeName(string, this), textureDescription, n2, true, (Object)this);
                if (iWrappedNode3DImage != null) {
                    iWrappedNode3DImage.setVisible(false);
                } else {
                    pictureWallLogCh.log(10000, "PictureWallIconRenderer#createImageNode Node with bitmap index %1 could not be created.", (long)n);
                }
            } else {
                pictureWallLogCh.log(10000, "PictureWallIconRenderer#createImageNode Not bitmap available for index %1.", (long)n);
            }
        }
        return iWrappedNode3DImage;
    }

    private void destroyNode() {
        EALManager eALManager = this.getEALManager();
        if (eALManager != null) {
            eALManager.destroy(this.picture);
        }
        this.displayData = null;
        this.picture = null;
    }

    private void destroyOtherNodes() {
        EALManager eALManager = this.getEALManager();
        if (eALManager != null) {
            eALManager.destroy(this.overlayLarge);
            eALManager.destroy(this.overlaySmall);
            eALManager.destroy(this.overlaySmallFrame);
            eALManager.destroy(this.backLarge);
            eALManager.destroy(this.nodeGroup1);
        }
        this.overlayLarge = null;
        this.overlaySmall = null;
        this.overlaySmallFrame = null;
        this.backLarge = null;
        this.nodeGroup1 = null;
    }

    private void destroyProperties() {
        if (this.hue != null) {
            this.hue.dispose();
            this.hue = null;
        }
        if (this.sat != null) {
            this.sat.dispose();
            this.sat = null;
        }
        this.isMaterialPropertyValid = false;
    }

    public void disconnect() {
        pictureWallLogCh.log(10000000, "PictureWallIconRenderer#disconnect", (Object)this.displayData);
        this.destroyProperties();
        this.destroyNode();
        this.destroyOtherNodes();
        if (materialHueSat != null) {
            materialHueSat.dispose();
            materialHueSat = null;
        }
        super.disconnect();
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public PictureWallIconController getController() {
        return this.controller;
    }

    public void imageLoaded(String string) {
        if (this.renderState == 3 && string.equals(this.displayData.getPath())) {
            pictureWallLogCh.log(10000000, "PictureWallIconRenderer#imageLoaded %1", (Object)string);
            this.getAbstractController().setCompositesDirty(true);
        } else {
            pictureWallLogCh.log(10000000, "PictureWallIconRenderer#imageLoaded %1, renderState = %2", (Object)string, (long)this.renderState);
        }
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public PictureWallIconRenderer(PictureWallIconController pictureWallIconController) {
        this.controller = pictureWallIconController;
    }

    public void prepareRedrawContextForChildren(RedrawContext redrawContext, AbstractWidget abstractWidget) {
    }

    public void render(RedrawContext redrawContext) {
        if (!this.dirty) {
            return;
        }
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        if (this.nodeGroup1 == null) {
            this.nodeGroup1 = this.getEALManager().createNode3D(redrawContextHigh.parentNode, EALManager.createNodeName("pw_icon_group1", this), this.controller.getWidth(), this.controller.getHeight(), redrawContext.getNodeIndex());
        } else {
            this.nodeGroup1.setNodeIndex(redrawContext.getNodeIndex());
        }
        HMIImage hMIImage = this.calculateDisplayData(this.controller.getModel());
        if (!Util.equals(this.displayData, hMIImage) || this.renderState == 3) {
            pictureWallLogCh.log(10000000, "PictureWallIconRenderer#render oldValue = %1, newValue = %2", (Object)this.displayData, (Object)hMIImage);
            this.destroyNode();
            this.displayData = hMIImage;
            this.renderNode(this.nodeGroup1);
        }
        this.backLarge = this.createImageNode(this.backLarge, 4, "pw_icon_back", this.nodeGroup1, -1);
        this.overlayLarge = this.createImageNode(this.overlayLarge, 3, "pw_icon_glassOverlay", this.nodeGroup1, 1);
        this.overlaySmall = this.createImageNode(this.overlaySmall, 1, "pw_icon_reflex", this.nodeGroup1, 2);
        this.overlaySmallFrame = this.createImageNode(this.overlaySmallFrame, 7, "pw_icon_frame", this.nodeGroup1, 3);
        boolean bl = !this.isEmpty() && this.renderState == 1;
        this.overlaySmall.setVisible(bl);
        this.overlayLarge.setVisible(bl);
        if (this.overlaySmallFrame != null) {
            boolean bl2 = bl && this.controller.isSmall();
            this.overlaySmallFrame.setVisible(bl2);
        }
        if (this.picture == null) {
            return;
        }
        this.getEALManager().moveToParent(this.nodeGroup1, redrawContextHigh.parentNode);
        this.applyProperties(redrawContextHigh);
    }

    private void renderNode(IWrappedNode3D iWrappedNode3D) {
        this.renderState = 1;
        EALManager eALManager = this.getEALManager();
        PictureWallController pictureWallController = this.controller.getParentController().getParentController();
        PictureWallCache.CachedTexture cachedTexture = pictureWallController.getTexture(this.displayData.getPath());
        if (cachedTexture == null) {
            pictureWallController.requestTexture(this.displayData.getPath(), this.controller.getModelRow(), this);
            this.renderState = 3;
            pictureWallLogCh.log(10000000, "PictureWallIconRenderer#renderNode Texture %1 not in cache.", (Object)this.displayData);
            return;
        }
        IWrappedTexture iWrappedTexture = cachedTexture.data;
        if (iWrappedTexture == null && !cachedTexture.loadingError) {
            pictureWallController.requestTexture(this.displayData.getPath(), this.controller.getModelRow(), this);
            this.renderState = 3;
            pictureWallLogCh.log(10000000, "PictureWallIconRenderer#renderNode Texture %1 in cache, but not loaded.", (Object)this.displayData);
            return;
        }
        if (cachedTexture.loadingError) {
            eALManager.destroy(iWrappedTexture);
            this.renderState = 2;
            pictureWallLogCh.log(1000000, "PictureWallIconRenderer#renderNode Texture not valid.");
            return;
        }
        if (this.picture == null) {
            this.picture = eALManager.createImage3D(iWrappedNode3D, EALManager.createNodeName("picWallIcon", this), iWrappedTexture, 0, true, (Object)this);
        }
        if (this.picture == null) {
            pictureWallLogCh.log(1000000, "PictureWallIconRenderer#renderNode node is null. Can not render %1", (Object)this.displayData);
            this.renderState = 2;
            return;
        }
        this.picture.setTexture(iWrappedTexture, false, this);
        this.applyMaterialTo3DImageNode(this.picture, materialHueSat);
        this.destroyProperties();
        this.hue = this.picture.getNode().getProperty(PROPERTY_NAME_HUE);
        this.sat = this.picture.getNode().getProperty(PROPERTY_NAME_SATURATION);
        this.isMaterialPropertyValid = this.hue.isValid() && this.sat.isValid();
        this.setHueAndSaturation();
        pictureWallLogCh.log(10000000, "PictureWallIconRenderer#renderNode width = %1", (double)this.picture.getUnscaledWidth());
        pictureWallLogCh.log(10000000, "PictureWallIconRenderer#renderNode height = %1", (double)this.picture.getUnscaledHeight());
    }

    public void setHueAndSaturation(boolean bl) {
        this.singleMode = bl;
        this.setHueAndSaturation();
    }

    private void setHueAndSaturation() {
        if (isMaterialValid && this.isMaterialPropertyValid) {
            if (this.singleMode) {
                this.hue.set(0.2f);
                this.sat.set(0.5f);
                this.overlaySmall.setOpacity(0.5f);
                this.overlaySmallFrame.setOpacity(0.5f);
            } else {
                this.hue.set(0.5f);
                this.sat.set(1.0f);
                this.overlaySmall.setOpacity(1.0f);
                this.overlaySmallFrame.setOpacity(1.0f);
            }
        } else {
            pictureWallLogCh.log(10000, "PictureWallIconRenderer#setHueAndSaturation Material could not be applied.");
        }
    }

    public void setScaleMode(int n) {
        this.scaleMode = n;
    }

    public void showLargeOverlay(boolean bl) {
        if (this.backLarge != null && this.overlayLarge != null) {
            this.backLarge.setVisible(bl);
            this.overlayLarge.setVisible(bl);
        }
    }

    public void showSmallOverlay(boolean bl) {
        if (this.overlaySmall != null) {
            this.overlaySmall.setVisible(bl);
        }
    }
}

