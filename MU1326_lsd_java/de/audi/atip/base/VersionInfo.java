/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.base;

import de.audi.atip.base.IVersionInfo;

final class VersionInfo
implements IVersionInfo {
    private String hmiVersion;
    private String textToolVersion;
    private String textToolSDSVersion;
    private String optionDrawerVersion;
    private String dsiIfcVersion;
    private String frameworkVersion;
    private String kanziVersion;

    VersionInfo() {
    }

    public String getHMIVersion() {
        if (this.hmiVersion == null) {
            this.hmiVersion = System.getProperty("HMI_Version", "???");
        }
        return this.hmiVersion;
    }

    public String getTextToolVersion() {
        if (this.textToolVersion == null) {
            this.textToolVersion = System.getProperty("TextToolVersionGUI", "???");
        }
        return this.textToolVersion;
    }

    public String getTextToolSDSVersion() {
        if (this.textToolSDSVersion == null) {
            this.textToolSDSVersion = System.getProperty("TextToolVersionSDS", "???");
        }
        return this.textToolSDSVersion;
    }

    public String getOptionDrawerVersion() {
        if (this.optionDrawerVersion == null) {
            this.optionDrawerVersion = System.getProperty("OptionDrawerVersion", "???");
        }
        return this.optionDrawerVersion;
    }

    public String getDsiIfcVersion() {
        if (this.dsiIfcVersion == null) {
            this.dsiIfcVersion = System.getProperty("DSI_IFC_Version", "???");
        }
        return this.dsiIfcVersion;
    }

    public String getFrameworkVersion() {
        if (this.frameworkVersion == null) {
            this.frameworkVersion = System.getProperty("Framwork_Version", "???");
        }
        return this.frameworkVersion;
    }

    public String getKanziVersion() {
        if (this.kanziVersion == null) {
            this.kanziVersion = System.getProperty("Kanzi_Version", "???");
        }
        return this.kanziVersion;
    }

    public String getHudsonBuildTag() {
        return System.getProperty("HUDSON_BUILD_TAG", "???");
    }

    public boolean isOfficialRelease() {
        return Boolean.getBoolean("Official_Release");
    }

    public boolean isProductionVersion() {
        return Boolean.getBoolean("IS_PRODUCTION_MODE");
    }

    public String getLangDataChecksum() {
        return System.getProperty("checksum_lang_data", "");
    }

    public String getDiagChecksum() {
        return System.getProperty("checksum_diag_jar", "");
    }

    public String getExtLogsChecksum() {
        return System.getProperty("checksum_ext_logs", "");
    }
}

