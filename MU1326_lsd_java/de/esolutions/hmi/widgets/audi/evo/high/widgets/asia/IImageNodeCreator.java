/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets.asia;

import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionLineController$IButtonItem;

public interface IImageNodeCreator {
    default public IWrappedNode3DImage createButtonImageNodeById(IWrappedNode3D iWrappedNode3D, ConversionLineController$IButtonItem conversionLineController$IButtonItem) {
    }
}

