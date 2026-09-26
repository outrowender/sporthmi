/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.utils;

import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.map.MapFlag;

public class MapPin
extends MapFlag {
    public int index = -1;
    public int type;

    public MapPin(int n, int n2, int n3, int n4) {
        super(n, n2, n3, -1L);
        this.type = n4;
    }

    public MapPin(int n, int n2, int n3, int n4, int n5) {
        super(n, n2, n3, -1L);
        this.index = n4;
        this.type = n5;
    }

    public MapPin(int n, int n2, int n3, int n4, int n5, long l) {
        super(n, n2, n3, l);
        this.index = n4;
        this.type = n5;
    }

    public boolean equals(Object object) {
        if (object instanceof MapPin) {
            MapPin mapPin = (MapPin)object;
            return mapPin.geoX == this.geoX && mapPin.geoY == this.geoY && mapPin.styleIndex == this.styleIndex && mapPin.index == this.index && mapPin.type == this.type;
        }
        return false;
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("geoX:").append(this.geoX);
        buffer.append(", geoY:").append(this.geoY);
        buffer.append(", style:").append(this.styleIndex);
        buffer.append(", index:").append(this.index);
        buffer.append(", type:").append(this.type);
        buffer.append(", handle:").append(this.handle);
        return buffer.toString();
    }

    public int hashCode() {
        Buffer buffer = new Buffer();
        buffer.append("geoX:").append(this.geoX);
        buffer.append(", geoY:").append(this.geoY);
        buffer.append(", style:").append(this.styleIndex);
        buffer.append(", index:").append(this.index);
        buffer.append(", type:").append(this.type);
        return buffer.toString().hashCode();
    }
}

