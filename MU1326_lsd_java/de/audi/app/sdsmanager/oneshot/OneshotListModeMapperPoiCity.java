/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.oneshot;

import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.oneshot.IOneshotListModeMapper;

public class OneshotListModeMapperPoiCity
implements IOneshotListModeMapper {
    protected int[][] oneshotListModeToOneshotLevel = new int[][]{{19, 0}, {27, 0}, {20, 1}};

    public int mapToOneshotLevel(int n) {
        return SDSUtils.translate(n, this.oneshotListModeToOneshotLevel);
    }
}

