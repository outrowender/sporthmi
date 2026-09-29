/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import org.dsi.ifc.navigation.CombinedRouteListElement;

public interface IRMLListener {
    default public CombinedRouteListElement getOpenedElement() {
    }

    default public void requestItems(int n, int n2, int n3, int n4, int n5) {
    }
}

