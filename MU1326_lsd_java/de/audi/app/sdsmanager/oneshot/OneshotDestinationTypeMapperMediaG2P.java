/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.oneshot;

import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.oneshot.IOneshotDestinationTypeMapper;

public class OneshotDestinationTypeMapperMediaG2P
implements IOneshotDestinationTypeMapper {
    protected int[][] oneshotDestinationTypeMapping = new int[][]{{0, 2}};

    public int mapToOneshotLevel(int n) {
        return SDSUtils.translate(n, this.oneshotDestinationTypeMapping);
    }
}

