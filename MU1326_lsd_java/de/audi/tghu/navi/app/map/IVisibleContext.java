/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.map.IContext;
import org.dsi.ifc.map.Rect;

public interface IVisibleContext
extends IContext {
    public void showLandmark(float var1);

    public Rect getVisibleArea();
}

