/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.fw;

import de.esolutions.fw.util.config.fw.SystemConfig;
import java.util.HashSet;

public class SystemConfigLint {
    private SystemConfig config;

    private SystemConfigLint(SystemConfig systemConfig) {
        this.config = systemConfig;
    }

    private boolean lint() {
        String[] stringArray = this.config.getAllNodeNames();
        int n = stringArray.length;
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < n; ++i2) {
            if (hashSet.add(stringArray[i2])) continue;
            System.out.println("ERROR: Duplicate node name: " + stringArray[i2]);
            return false;
        }
        String[] stringArray2 = this.config.getAllProcNames();
        int n2 = stringArray2.length;
        HashSet hashSet2 = new HashSet();
        for (int i3 = 0; i3 < n2; ++i3) {
            if (hashSet2.add(stringArray2[i3])) continue;
            System.out.println("ERROR: Duplicate proc name: " + stringArray2[i3]);
            return false;
        }
        HashSet hashSet3 = new HashSet();
        for (int i4 = 0; i4 < n2; ++i4) {
            Integer n3 = this.config.mapIdProc(stringArray2[i4]);
            if (n3 == null) {
                System.out.println("ERROR: No ID for proc name: " + stringArray2[i4]);
                return false;
            }
            if (hashSet3.add(n3)) continue;
            System.out.println("Duplicate proc id: " + n3 + " in proc name: " + stringArray2[i4]);
            return false;
        }
        System.out.println("OK");
        return true;
    }

    public static void main(String[] stringArray) {
        SystemConfig systemConfig = SystemConfig.getInstance();
        if (!systemConfig.isValid()) {
            System.out.println("ERROR reading config: " + systemConfig.getFailString());
            return;
        }
        SystemConfigLint systemConfigLint = new SystemConfigLint(systemConfig);
        boolean bl = systemConfigLint.lint();
        if (bl) {
            System.exit(0);
        } else {
            System.exit(1);
        }
    }
}

