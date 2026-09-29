/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.oneshot;

import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.oneshot.IOneshotDestinationTypeMapper;
import de.audi.app.sdsmanager.oneshot.IOneshotFilterStrategy;
import de.audi.app.sdsmanager.oneshot.IOneshotListModeMapper;
import de.audi.app.sdsmanager.oneshot.IOneshotPicklistHandling;
import de.audi.app.sdsmanager.oneshot.OneshotHandler;
import de.audi.atip.hmi.HMIService;
import java.util.HashMap;
import java.util.Map;

public class NaviOneshotHandler
extends OneshotHandler {
    protected int[][] destinationTypeToMaxLevel = new int[][]{{100, 0}, {101, 1}, {102, 2}, {103, 3}, {104, 4}, {10, 2}, {2, 1}, {1, 0}, {22, 0}};
    private final String[] oneshotLevelToDataKeys;

    public NaviOneshotHandler(HMIService hMIService, int n, IOneshotPicklistHandling iOneshotPicklistHandling, IOneshotListModeMapper iOneshotListModeMapper, IOneshotDestinationTypeMapper iOneshotDestinationTypeMapper, IOneshotFilterStrategy iOneshotFilterStrategy, String[] stringArray, int[] nArray) {
        super(hMIService, n, iOneshotPicklistHandling, iOneshotListModeMapper, iOneshotDestinationTypeMapper, iOneshotFilterStrategy, nArray);
        this.oneshotLevelToDataKeys = stringArray;
    }

    public Map createOneshotDataMap(byte by) {
        int n = SDSUtils.translate((int)by, this.destinationTypeToMaxLevel);
        HashMap hashMap = new HashMap(n + 1);
        for (int i2 = 0; i2 <= n && i2 < this.oneshotLevelToDataKeys.length; ++i2) {
            String string = this.oneshotLevelToDataKeys[i2];
            hashMap.put(string, this.oneshotDataStorage[i2]);
        }
        return hashMap;
    }
}

