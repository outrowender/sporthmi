/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets.asia;

import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionLineController;

public interface IImageNodeCreator {
    public IWrappedNode3DImage createButtonImageNodeById(IWrappedNode3D var1, ConversionLineController.IButtonItem var2);
}

