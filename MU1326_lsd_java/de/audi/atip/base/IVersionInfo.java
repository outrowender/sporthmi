/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.base;

public interface IVersionInfo {
    public static final int INDEX_NAME = 0;
    public static final int INDEX_VERSION = 1;
    public static final int INFORMATION_COUNT = 2;

    public String getHMIVersion();

    public String getTextToolVersion();

    public String getTextToolSDSVersion();

    public String getOptionDrawerVersion();

    public String getDsiIfcVersion();

    public String getFrameworkVersion();

    public String getKanziVersion();

    public String getHudsonBuildTag();

    public String getLangDataChecksum();

    public String getDiagChecksum();

    public String getExtLogsChecksum();

    public boolean isOfficialRelease();

    public boolean isProductionVersion();
}

