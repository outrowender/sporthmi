/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.online;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

class OnlinePOIResultList$ResultElement {
    PoiOnlineSearchValuelistElement element;
    private int styleType;
    private NavLocation transformedLocation;

    public OnlinePOIResultList$ResultElement(PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement, int n) {
        this.element = poiOnlineSearchValuelistElement;
        this.styleType = n;
        this.transformedLocation = null;
    }

    public NavLocation getTransformedLocation() {
        return this.transformedLocation;
    }

    public void setTransformedLocation(NavLocation navLocation) {
        this.transformedLocation = navLocation;
    }

    public PoiOnlineSearchValuelistElement getElement() {
        return this.element;
    }

    public int getStyleType() {
        return this.styleType;
    }
}

