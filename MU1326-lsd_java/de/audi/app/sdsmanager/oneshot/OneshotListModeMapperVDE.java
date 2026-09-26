/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.oneshot;

import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.oneshot.IOneshotListModeMapper;

public class OneshotListModeMapperVDE
implements IOneshotListModeMapper {
    protected int[][] oneshotListModeToOneshotLevel = new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}, {38, 4}};

    @Override
    public int mapToOneshotLevel(int n) {
        return SDSUtils.translate(n, this.oneshotListModeToOneshotLevel);
    }
}

