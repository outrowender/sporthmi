/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.map.MapFlag;

public class MapUserFlag {
    public static final int FLAG_TYPE_UNDEFINED;
    public static final int FLAG_TYPE_ONLINE_POI;
    public static final int FLAG_TYPE_REMOTE_HMI;
    public int mIndex;
    public MapFlag mMapFlag;
    public String mName;
    public int mFlagType;

    public MapUserFlag(MapFlag mapFlag, int n, String string) {
        this.mMapFlag = mapFlag;
        this.mIndex = n;
        this.mName = string;
        this.mFlagType = -1;
    }

    public MapUserFlag(MapFlag mapFlag, int n, String string, int n2) {
        this.mMapFlag = mapFlag;
        this.mIndex = n;
        this.mName = string;
        this.mFlagType = n2;
    }

    public MapUserFlag(int n, int n2, int n3, int n4, String string, int n5) {
        this(new MapFlag(n, n2, n3, 0L), n4, string, n5);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append(this.mMapFlag).append(", name: '").append(this.mName).append("', index: ").append(this.mIndex).append(", flagType: ").append(this.mFlagType);
        return buffer.toString();
    }
}

