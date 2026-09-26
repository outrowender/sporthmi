/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.map.utils.MapPin;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocationWgs84;

public class AbstractMap$MapState {
    public float zoomlevel = 32959;
    public int mapOrientation = 2;
    public NavLocationWgs84 position = null;
    public boolean showPOI = false;
    public boolean showTMC = false;
    public MapPin[] pins = null;

    public String toString() {
        Buffer buffer = new Buffer(150);
        buffer.append("zoomLevel:").append(this.zoomlevel).append(", position:").append(this.position).append(", showPOI:").append(this.showPOI).append(", showTMC:").append(this.showTMC).append(", mapOrientation:").append(this.mapOrientation);
        return buffer.toString();
    }
}

