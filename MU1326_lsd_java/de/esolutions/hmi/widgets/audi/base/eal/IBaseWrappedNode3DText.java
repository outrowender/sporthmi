/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.api.IINodeText;
import de.esolutions.graphics.eal.api.INode3DText;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;

public interface IBaseWrappedNode3DText
extends IWrappedNode3D {
    default public IINodeText getInterfaceText() {
    }

    default public INode3DText getTextNode() {
    }

    default public String getText() {
    }
}

