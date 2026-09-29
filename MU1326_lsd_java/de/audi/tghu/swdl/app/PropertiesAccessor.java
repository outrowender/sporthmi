/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app;

public class PropertiesAccessor {
    public static boolean isSimulateSWDL() {
        return Boolean.getBoolean("SimulateSWDL");
    }

    public static String getSwdlDataDir() {
        return System.getProperty("SwdlDataDir");
    }
}

