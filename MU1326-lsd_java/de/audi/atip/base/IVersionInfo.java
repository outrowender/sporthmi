/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.base;

public interface IVersionInfo {
    public static final int INDEX_NAME;
    public static final int INDEX_VERSION;
    public static final int INFORMATION_COUNT;

    default public String getHMIVersion() {
    }

    default public String getTextToolVersion() {
    }

    default public String getTextToolSDSVersion() {
    }

    default public String getOptionDrawerVersion() {
    }

    default public String getDsiIfcVersion() {
    }

    default public String getFrameworkVersion() {
    }

    default public String getKanziVersion() {
    }

    default public String getHudsonBuildTag() {
    }

    default public String getLangDataChecksum() {
    }

    default public String getDiagChecksum() {
    }

    default public String getExtLogsChecksum() {
    }

    default public boolean isOfficialRelease() {
    }

    default public boolean isProductionVersion() {
    }
}

