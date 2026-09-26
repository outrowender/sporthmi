/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.oneshot;

import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.oneshot.IOneshotListModeMapper;

public class OneshotListModeMapperVDEEUNAR
implements IOneshotListModeMapper {
    protected int[][] oneshotListModeToOneshotLevel = new int[][]{{1, 0}, {2, 1}, {3, 2}};

    @Override
    public int mapToOneshotLevel(int n) {
        return SDSUtils.translate(n, this.oneshotListModeToOneshotLevel);
    }
}

