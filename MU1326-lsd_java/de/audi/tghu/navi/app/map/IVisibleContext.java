/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.map.IContext;
import org.dsi.ifc.map.Rect;

public interface IVisibleContext
extends IContext {
    default public void showLandmark(float f2) {
    }

    default public Rect getVisibleArea() {
    }
}

