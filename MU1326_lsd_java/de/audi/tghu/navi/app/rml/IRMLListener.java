/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import org.dsi.ifc.navigation.CombinedRouteListElement;

public interface IRMLListener {
    public CombinedRouteListElement getOpenedElement();

    public void requestItems(int var1, int var2, int var3, int var4, int var5);
}

