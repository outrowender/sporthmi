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
    public static final String FILENAME_NO_TEXTURE = "<no texture>";

    public IINodeImage getInterfaceImage();

    public INode3DImage getImageNode();

    public String getFilename();

    public boolean setModulateColor(int var1);

    public boolean setTexture(IWrappedTexture var1, boolean var2, Object var3);

    public boolean setMaterial(IMaterial var1);

    public IWrappedTexture getTexture();

    public void mirrorX();

    public void mirrorY();

    public void mirrorXY();

    public void releaseTexture();
}

