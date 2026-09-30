/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelGUI;
import de.esolutions.hmi.widgets.audi.base.HMIImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IImageDecoratorRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ImageDecoratorController;

public class ImageDecoratorRenderer
extends AbstractKanziTemplateRenderer
implements IImageDecoratorRenderer {
    private static final String PROPERTY_NAME_TEXTURE = "Texture";
    private static final String PROPERTY_GI_WIDTH = "gi_width";
    private static final String PROPERTY_GI_HEIGHT = "gi_height";
    private final ImageDecoratorController controller;
    private IWrappedTexture texture = null;
    private int templateType = 0;

    public ImageDecoratorRenderer(ImageDecoratorController imageDecoratorController) {
        this.controller = imageDecoratorController;
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public void disconnect() {
        logImageDecorator.log(10000000, "ImageDecoratorRenderer#disconnect() - Called.");
        super.disconnect();
        this.releaseTexture();
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        int n;
        logImageDecorator.log(10000000, "ImageDecoratorRenderer#applyProperties(RedrawContextHigh) - Called.");
        int n2 = this.controller.getX();
        int n3 = this.controller.getY();
        float f2 = this.controller.getScaleFactor();
        this.node.setPosition(n2, n3, 0.0f);
        this.node.setOpacity(this.controller.getRenderOpacity());
        this.node.setScale(f2, f2, 1.0f);
        if (!this.controller.shouldRender()) {
            logImageDecorator.log(10000000, "ImageDecoratorRenderer#applyProperties() - Controller#shouldRender() returned 'false'. Returning.");
            return;
        }
        this.node.setVisible(true);
        this.releaseTexture();
        if (this.controller.getModel() instanceof ResourceLocatorModelGUI || this.controller.getModel() instanceof HMIResourceLocator) {
            logImageDecorator.log(10000000, "ImageDecoratorRenderer#applyProperties() - Controller states he does have content. Trying to fetch the image from the ResLoc.");
            HMIImage hMIImage = this.getEALManager().getHMIImage(this.controller.getResourceLocator(), this.controller.getInitContext().getScreenID(), false);
            if (hMIImage != null && hMIImage.getPath() != null) {
                this.texture = this.createTextureDescription(hMIImage, true).getTexture(this);
            }
        } else if (this.controller.getModel() instanceof Integer) {
            int n4 = (Integer)this.controller.getModel();
            n = this.controller.getBitmap(n4);
            this.node.setVisible(n != HMIImageConstantsSystem.empty_image);
            this.texture = this.getTextureDescription(n4, false).getTexture(this);
            logImageDecorator.log(10000000, "ImageDecoratorRenderer#applyProperties() - Controller states he does not have content. Trying to fetch image from bitmap array.");
        }
        if (this.texture == null) {
            logImageDecorator.log(100000, "ImageDecoratorRenderer#applyProperties() - The controller has 'shouldRender' set, but no image could be retrieved. No rendering will be done.");
            this.node.setVisible(false);
            return;
        }
        if (this.templateType == 1) {
            int n5 = this.texture.getWidth();
            n = this.texture.getHeight();
            int n6 = this.controller.getWidth();
            int n7 = this.controller.getHeight();
            if (n > n5) {
                int n8 = n5 * n7 / n;
                this.setProperty(PROPERTY_GI_WIDTH, n8);
                this.setProperty(PROPERTY_GI_HEIGHT, n7);
                this.node.setPosition(n2 + (n6 - n8) / 2, n3, 0.0f);
            } else {
                int n9 = n * n6 / n5;
                this.setProperty(PROPERTY_GI_WIDTH, n6);
                this.setProperty(PROPERTY_GI_HEIGHT, n9);
                this.node.setPosition(n2, n3 + (n7 - n9) / 2, 0.0f);
            }
        }
        logImageDecorator.log(10000000, "ImageDecoratorRenderer#applyProperties() - Setting '%1' property and visibility to true now.", (Object)PROPERTY_NAME_TEXTURE);
        this.setProperty(PROPERTY_NAME_TEXTURE, this.texture.getTexture());
    }

    protected String getTemplateNodePath() {
        if (this.templateType == 0) {
            return "Prefabs/imageDecorator";
        }
        return "Prefabs/generic_image";
    }

    protected String getEALNodeName() {
        return "imageDecorator";
    }

    private TextureDescription createTextureDescription(HMIImage hMIImage, boolean bl) {
        if (hMIImage == null) {
            return null;
        }
        return this.getEALManager().createTextureDescription(hMIImage, null, false, bl);
    }

    private void releaseTexture() {
        logImageDecorator.log(10000000, "ImageDecoratorRenderer#releaseTexture() - Called.");
        if (this.texture == null) {
            return;
        }
        this.texture.releaseTexture(true, this);
        this.texture = null;
    }

    protected int getKzbConstant() {
        return 6;
    }

    public void setTemplateType(int n) {
        this.templateType = n;
    }
}

