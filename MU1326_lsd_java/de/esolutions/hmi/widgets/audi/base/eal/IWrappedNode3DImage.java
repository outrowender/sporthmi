/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.api.IINodeImage;
import de.esolutions.graphics.eal.api.IMaterial;
import de.esolutions.graphics.eal.api.INode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;

public interface IWrappedNode3DImage
extends IWrappedNode3D {
    public static final String FILENAME_NO_TEXTURE;

    default public IINodeImage getInterfaceImage() {
    }

    default public INode3DImage getImageNode() {
    }

    default public String getFilename() {
    }

    default public boolean setModulateColor(int n) {
    }

    default public boolean setTexture(IWrappedTexture iWrappedTexture, boolean bl, Object object) {
    }

    default public boolean setMaterial(IMaterial iMaterial) {
    }

    default public IWrappedTexture getTexture() {
    }

    default public void mirrorX() {
    }

    default public void mirrorY() {
    }

    default public void mirrorXY() {
    }

    default public void releaseTexture() {
    }
}

