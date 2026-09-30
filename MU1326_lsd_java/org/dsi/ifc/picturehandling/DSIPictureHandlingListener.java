/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.picturehandling;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIPictureHandlingListener
extends DSIListener {
    public void indicatePicture(int var1, int var2, ResourceLocator var3, ResourceLocator var4);

    public void finishPictureRequest(int var1);
}

