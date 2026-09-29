/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.api.IINodeImage;
import de.esolutions.graphics.eal.api.IMaterial;
import de.esolutions.graphics.eal.api.INode3DImage;
import de.esolutions.graphics.eal.api.IProperty;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedNode3D;

public class WrappedNode3DImage
extends WrappedNode3D
implements IWrappedNode3DImage {
    private final INode3DImage node;
    private IINodeImage interfaceImage;
    private IWrappedTexture texture;
    private IMaterial material;
    private int color;
    private boolean deleteIfNoCache;
    private Object oldReference;

    public WrappedNode3DImage(INode3DImage iNode3DImage, int n, IWrappedTexture iWrappedTexture, boolean bl, Object object, boolean bl2) {
        super(iNode3DImage, iWrappedTexture.getWidth(), iWrappedTexture.getHeight(), false, n, bl2);
        this.shouldFlipBack = true;
        this.node = iNode3DImage;
        this.texture = iWrappedTexture;
        this.deleteIfNoCache = bl;
        iNode3DImage.rotateX(13379);
        this.storePosition();
        this.setScale(1.0f, 1.0f, 1.0f);
        this.oldReference = object;
    }

    @Override
    public IINodeImage getInterfaceImage() {
        if (this.interfaceImage != null) {
            return this.interfaceImage;
        }
        this.interfaceImage = this.node.getInterfaceImage();
        return this.interfaceImage;
    }

    @Override
    public INode3DImage getImageNode() {
        return this.node;
    }

    @Override
    public float getOriginX() {
        return 0.0f;
    }

    @Override
    public float getOriginY() {
        return this.scaleY * this.unscaledHeight;
    }

    @Override
    protected boolean shouldFlipBack() {
        if (this.texture == null) {
            return false;
        }
        return this.shouldFlipBack && !this.isLtr && this.texture.getDescription().preventRTLFlip();
    }

    @Override
    public String getFilename() {
        if (this.texture == null) {
            return "<no texture>";
        }
        return String.valueOf(this.texture.getDescription().getCacheKey());
    }

    @Override
    public void resetTransformation() {
        super.resetTransformation();
        this.node.rotateX(13379);
        this.storePosition();
        this.node.setModulateColor(-1L);
    }

    @Override
    public void dispose() {
        super.dispose();
        if (this.interfaceImage != null) {
            this.interfaceImage.dispose();
            this.interfaceImage = null;
        }
    }

    @Override
    public boolean setModulateColor(int n) {
        if (this.equalsColor(n)) {
            return true;
        }
        this.storeColor(n);
        return this.node.setModulateColor(n);
    }

    private void storeColor(int n) {
        this.color = n;
    }

    private boolean equalsColor(int n) {
        return this.color == n;
    }

    @Override
    public boolean setMaterial(IMaterial iMaterial) {
        if (this.material != null && this.material.equals(iMaterial)) {
            return true;
        }
        this.material = iMaterial;
        return this.node.setMaterial(iMaterial);
    }

    @Override
    public boolean setTexture(IWrappedTexture iWrappedTexture, boolean bl, Object object) {
        ITexture iTexture;
        if (this.texture != null && this.texture.equals(iWrappedTexture)) {
            this.deleteIfNoCache = bl;
            return true;
        }
        this.releaseTexture();
        this.deleteIfNoCache = bl;
        this.texture = iWrappedTexture;
        if (iWrappedTexture == null) {
            iTexture = null;
        } else {
            iWrappedTexture.getDescription().getCachedTexture(object);
            this.oldReference = object;
            iTexture = iWrappedTexture.getTexture();
        }
        boolean bl2 = this.node.setTexture(iTexture);
        if (bl2) {
            if (iTexture == null) {
                this.unscaledWidth = 0.0f;
                this.unscaledHeight = 0.0f;
            } else {
                this.unscaledWidth = iTexture.getWidth();
                this.unscaledHeight = iTexture.getHeight();
            }
            this.storePosition();
        }
        return bl2;
    }

    @Override
    public IWrappedTexture getTexture() {
        return this.texture;
    }

    @Override
    public void mirrorX() {
        if (this.node != null) {
            this.node.flipX();
        }
    }

    @Override
    public void mirrorY() {
        if (this.node != null) {
            this.node.flipY();
        }
    }

    @Override
    public void mirrorXY() {
        if (this.node != null) {
            this.node.flipXY();
        }
    }

    @Override
    public void releaseTexture() {
        IProperty iProperty = this.node.getProperty("Texture");
        if (iProperty.isValid()) {
            iProperty.setDefault();
        } else {
            logChannel3DEngine.log(10000, "WrappedNode3DImage#releaseTexture property invalid in %1", (Object)this);
        }
        iProperty.dispose();
        if (this.texture != null) {
            this.texture.releaseTexture(this.deleteIfNoCache, this.oldReference);
            this.texture = null;
        }
    }
}

