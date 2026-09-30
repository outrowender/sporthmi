/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.li.sc;

import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;

public class POISpellerContext
extends SpellerContext {
    private NavLocation poiContext;
    private NavLocation selectedPOILocation;
    private boolean childrenAvailable;
    private int spellerType;

    public POISpellerContext(int n) {
        super(n);
    }

    public POISpellerContext(POISpellerContext pOISpellerContext) {
        this(pOISpellerContext.getContextID());
        this.poiContext = pOISpellerContext.poiContext;
        this.selectedPOILocation = pOISpellerContext.selectedPOILocation;
        this.childrenAvailable = pOISpellerContext.childrenAvailable;
        this.spellerType = pOISpellerContext.spellerType;
    }

    public NavLocation getPOIContext() {
        return this.poiContext;
    }

    public void setPOIContext(NavLocation navLocation) {
        this.poiContext = navLocation != null ? Util.cloneLocation(navLocation) : null;
    }

    public NavLocation getSelectedPOILocation() {
        return this.selectedPOILocation;
    }

    public void setSelectedPOILocation(NavLocation navLocation) {
        this.selectedPOILocation = Util.cloneLocation(navLocation);
    }

    public void setChildrenAvailable(boolean bl) {
        this.childrenAvailable = bl;
    }

    public void setSpellerType(int n) {
        this.spellerType = n;
    }

    public int getSpellerType() {
        return this.spellerType;
    }

    public void reset() {
        super.reset();
        this.poiContext = null;
        this.spellerType = -1;
        this.selectedPOILocation = null;
        this.childrenAvailable = false;
    }

    public String printStatus() {
        Buffer buffer = new Buffer();
        buffer.append(this).append('\n');
        buffer.append("poiContext: ").append(LocationFormatter.formatLocationShort(this.poiContext)).append('\n');
        buffer.append("spellerType: ").append(this.spellerType).append('\n');
        buffer.append("selectedPOILocation: ").append(LocationFormatter.formatLocationShort(this.selectedPOILocation)).append('\n');
        buffer.append("childrenAvailable: ").append(this.childrenAvailable).append('\n');
        return buffer.toString();
    }
}

