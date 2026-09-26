/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.StringTokenizer;
import org.dsi.ifc.uota.PackageInfo;

class UotaPkgInfoWrapper {
    static final char SYMBOLIC_NAME_SEPARATOR;
    static final int ISO_CODE_POSITION;
    static final int ISO_CODE_LENGTH;
    static final String PPOI_CATEGORY;
    static final String SYSTEM_CATEGORY;
    static final char NAME_VERSION_SEPARATOR;
    static final String INVALID;
    static final String LICENSE_AVAILABLE;
    static final String LICENSE_NOT_AVAILABLE;
    static final String KEY_LICENSE_VALID;
    static final String KEY_VERSION;
    static final String KEY_ADDITIONAL_INFOS;
    static final String MAP_PREVIEWS_PATH;
    static final String MAP_PREVIEWS_EXTENSION;
    static final String PREVIEW_AVAILABLE_SUFFIX;
    static final String EMPTY_STRING;
    static final String UNDEFINED_RELEASE;
    static final byte DISPLAY_STRING_TYPE_VERSION;
    static final byte DISPLAY_STRING_TYPE_NAME;
    private String pkgCategory;
    private String pkgId;
    private String pkgVersion;
    private boolean licenseAvailable;
    private long size;
    private int type;
    private int pkgPriority;
    private String releaseVersion;
    private int regionISOCode = -1;
    private String additionalInfos;
    private String[] uniqueNames;
    private String[] displayVersions;
    private boolean isPPOI = false;
    private boolean isSystemPackage = false;
    private boolean isTechnicalPackage = false;
    private boolean isValid;
    private int selectionStatus;
    private boolean isAllowedForSelection;
    private boolean displayAsSelected;
    private boolean hidePackageSize;
    private final LogChannel logUota;
    private static volatile boolean isCancelled;

    UotaPkgInfoWrapper(PackageInfo packageInfo, int n, LogChannel logChannel) {
        this.logUota = logChannel;
        this.selectionStatus = n;
        this.isAllowedForSelection = true;
        this.displayAsSelected = false;
        this.hidePackageSize = false;
        if (null == packageInfo) {
            this.pkgId = "INVALID";
            this.pkgVersion = "INVALID";
            this.licenseAvailable = false;
            this.pkgPriority = -129;
            this.size = 0L;
            this.type = -1;
            this.displayVersions = new String[0];
            this.uniqueNames = this.displayVersions;
            this.isValid = false;
        } else {
            this.isValid = true;
            this.pkgId = packageInfo.getSymbolicName();
            if (!this.parseExtras(packageInfo.getExtras())) {
                this.getLogUota().log(10000, "[UotaPkgInfoWrapper].<init>: Failed to parse extras array: %1", (Object)packageInfo);
                this.licenseAvailable = false;
                this.isValid = false;
            }
            this.pkgCategory = packageInfo.getCategory();
            if ("ppoi".equalsIgnoreCase(this.pkgCategory)) {
                this.isPPOI = true;
                if (!this.parsePPOIHierarchyInfo(packageInfo.getHierarchyInfo())) {
                    this.getLogUota().log(10000, "[UotaPkgInfoWrapper].<init>: Failed to parse PPOI hierarchy info: %1", (Object)packageInfo);
                    this.isValid = false;
                }
            } else if ("system".equalsIgnoreCase(this.pkgCategory)) {
                if (!this.parseHierarchyInfo(packageInfo.getHierarchyInfo())) {
                    this.getLogUota().log(10000, "[UotaPkgInfoWrapper].<init>: Failed to parse hierarchy info of system category: %1", (Object)packageInfo);
                    this.isValid = false;
                }
                this.isSystemPackage = true;
            } else {
                if (!this.parseHierarchyInfo(packageInfo.getHierarchyInfo())) {
                    this.getLogUota().log(10000, "[UotaPkgInfoWrapper].<init>: Failed to parse hierarchy info: %1", (Object)packageInfo);
                    this.isValid = false;
                }
                if (null != this.pkgId && this.pkgId.length() >= 16) {
                    try {
                        this.regionISOCode = Integer.parseInt(this.pkgId.substring(14, 16), 16);
                        this.getLogUota().log(14808325, "[UotaPkgInfoWrapper].<init>: region ISO code of package %1 is %2", (Object)this.pkgId, (long)this.regionISOCode);
                    }
                    catch (NumberFormatException numberFormatException) {
                        this.regionISOCode = -1;
                        this.getLogUota().log(10000, "[UotaPkgInfoWrapper].<init>: invalid ISO code of package %1", (Object)this.pkgId);
                    }
                }
            }
            this.pkgVersion = packageInfo.getVersion();
            if (this.pkgVersion == null || this.pkgVersion.length() == 0) {
                this.getLogUota().log(10000, "[UotaPkgInfoWrapper].<init>: Failed to parse package version: %1", (Object)packageInfo);
                this.pkgVersion = "INVALID";
                this.isValid = false;
            }
            this.size = packageInfo.getSize();
            this.type = packageInfo.getType();
            this.isTechnicalPackage = this.type == 1;
            this.pkgPriority = packageInfo.getPriority();
            this.getLogUota().log(-2137614336, "[UotaPkgInfoWrapper]: new package [%1] %2", (Object)new Integer(this.selectionStatus), (Object)this);
        }
    }

    private boolean parseExtras(String[] stringArray) {
        this.releaseVersion = "";
        this.additionalInfos = "";
        if (null == stringArray || 0 == stringArray.length) {
            this.getLogUota().log(10000, "[UotaPkgInfoWrapper].parseExtras(): Null or empty extras array!");
            return false;
        }
        boolean bl = false;
        for (int i2 = 0; i2 < stringArray.length - 1; i2 += 2) {
            if ("licenseValid".equals(stringArray[i2])) {
                this.getLogUota().log(14808325, "[UotaPkgInfoWrapper].parseExtras(): license info found");
                bl = true;
                this.licenseAvailable = "1".equals(stringArray[i2 + 1]);
                continue;
            }
            if ("pVersion".equals(stringArray[i2])) {
                this.releaseVersion = stringArray[i2 + 1];
                if (!"null".equalsIgnoreCase(this.releaseVersion)) continue;
                this.releaseVersion = "undef";
                continue;
            }
            if (!"additionalInfos".equals(stringArray[i2]) || null == stringArray[i2 + 1] || "null".equalsIgnoreCase(stringArray[i2 + 1])) continue;
            this.additionalInfos = stringArray[i2 + 1];
        }
        if (!bl) {
            this.getLogUota().log(10000, "[UotaPkgInfoWrapper].parseExtras(): Could not find license info!");
        }
        if ("" == this.releaseVersion) {
            this.getLogUota().log(10000, "[UotaPkgInfoWrapper].parseExtras(): Could not find relase version (pVersion)!");
        }
        return bl;
    }

    private boolean parsePPOIHierarchyInfo(String[] stringArray) {
        if (null == stringArray || 0 == stringArray.length) {
            this.getLogUota().log(10000, "[UotaPkgInfoWrapper].parsePPOIHierarchyInfo(): Null or unsupported PPOI hierarchy info!");
            return false;
        }
        this.displayVersions = new String[2];
        this.uniqueNames = new String[2];
        if (null == stringArray[0] || 0 == stringArray[0].length()) {
            this.getLogUota().log(10000, "[UotaPkgInfoWrapper].parsePPOIHierarchyInfo(): Null or empty PPOI name element!");
            this.uniqueNames[0] = "";
            this.displayVersions[0] = "";
            return false;
        }
        if (stringArray.length == 1) {
            this.displayVersions[0] = "";
            this.uniqueNames[0] = stringArray[0];
        } else {
            if (null == stringArray[1] || 0 == stringArray[1].length()) {
                this.getLogUota().log(10000, "[UotaPkgInfoWrapper].parsePPOIHierarchyInfo(): Null or empty PPOI version element!");
                this.uniqueNames[0] = "";
                this.displayVersions[0] = "";
                return false;
            }
            int n = stringArray[1].lastIndexOf(32);
            if (n > 0 && stringArray[1].length() > 1) {
                stringArray[1] = stringArray[1].substring(n + 1);
            }
            this.displayVersions[0] = stringArray[1];
            this.uniqueNames[0] = new Buffer(stringArray[0]).append('#').append(this.displayVersions[0]).toString();
        }
        this.getLogUota().log(-2137614336, "[UotaPkgInfoWrapper].parsePPOIHierarchyInfo(): PPOI: displayVersion=%1, uniqueName=%2", (Object)this.displayVersions[0], (Object)this.uniqueNames[0]);
        return true;
    }

    private boolean parseHierarchyInfo(String[] stringArray) {
        if (null == stringArray || 0 == stringArray.length) {
            this.getLogUota().log(10000, "[UotaPkgInfoWrapper].parseHierarchyInfo(): Null or empty hierarchy info!");
            return false;
        }
        this.displayVersions = new String[stringArray.length];
        this.uniqueNames = new String[stringArray.length];
        boolean bl = true;
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string = stringArray[i2];
            if (null == string || 0 == string.length()) {
                this.getLogUota().log(10000, "[UotaPkgInfoWrapper].parseHierarchyInfo(): Null or empty hierarchy element at index=%1 !", (long)i2);
                this.uniqueNames[i2] = "";
                this.displayVersions[i2] = "";
                bl = false;
                continue;
            }
            int n = string.indexOf("\\n");
            if (n < 0) {
                this.displayVersions[i2] = "";
                this.uniqueNames[i2] = string;
                if (0 != i2) continue;
                this.getLogUota().log(10000, "[UotaPkgInfoWrapper].parseHierarchyInfo(): No version found at index 0!");
                bl = false;
                continue;
            }
            this.displayVersions[i2] = string.substring(n + "\\n".length());
            this.uniqueNames[i2] = new Buffer(string.substring(0, n)).append('#').append(this.displayVersions[i2]).toString();
        }
        return bl;
    }

    String getDisplayString(byte by) {
        String[] stringArray;
        switch (by) {
            case 0: {
                stringArray = this.displayVersions;
                break;
            }
            case 1: {
                stringArray = this.uniqueNames;
                break;
            }
            default: {
                stringArray = null;
            }
        }
        Buffer buffer = new Buffer();
        if (null != stringArray) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (stringArray[i2] == null || stringArray[i2].length() <= 0) continue;
                if (i2 > 0) {
                    buffer.append('>');
                }
                buffer.append(stringArray[i2]);
            }
        }
        return buffer.toString();
    }

    static UotaPkgInfoWrapper[] toArray(PackageInfo[] packageInfoArray, int[] nArray, boolean bl, LogChannel logChannel) {
        if (null == packageInfoArray || null == nArray) {
            logChannel.log(10000, "[UotaPkgInfoWrapper].toArray(): Null update packages or selection info!");
            return null;
        }
        if (packageInfoArray.length != nArray.length) {
            logChannel.log(10000, "[UotaPkgInfoWrapper].toArray(): Array length mismatch!");
            return null;
        }
        UotaPkgInfoWrapper[] uotaPkgInfoWrapperArray = new UotaPkgInfoWrapper[packageInfoArray.length];
        for (int i2 = 0; i2 < packageInfoArray.length; ++i2) {
            uotaPkgInfoWrapperArray[i2] = new UotaPkgInfoWrapper(packageInfoArray[i2], nArray[i2], logChannel);
            if (bl) {
                uotaPkgInfoWrapperArray[i2].setHidePackageSize();
            }
            if (!isCancelled) continue;
            isCancelled = false;
            return null;
        }
        return uotaPkgInfoWrapperArray;
    }

    static void cancelProcessPackages(boolean bl) {
        isCancelled = bl;
    }

    public String toString() {
        Buffer buffer = new Buffer(256);
        buffer.append("[isValid=").append(this.isValid).append("][pkgId=").append(this.pkgId).append("][pkgVersion=").append(this.pkgVersion).append("][priority=").append(this.pkgPriority).append("][licenseAvailable=").append(this.licenseAvailable).append("][size=").append(this.size).append("][type=").append(this.type).append("][displayNames=").append(this.getDisplayString((byte)1)).append("][displayVersions=").append(this.getDisplayString((byte)0)).append("][isSelected=").append(this.isSelected()).append("][isHidden=").append(this.isHidden()).append("][isUpToDate=").append(this.isUpToDate()).append("][isAutoSelected=").append(this.isAutoSelected()).append(']');
        return buffer.toString();
    }

    boolean isSelected() {
        return 0 != (1 & this.selectionStatus);
    }

    boolean isHidden() {
        return 0 != (8 & this.selectionStatus);
    }

    boolean isUpToDate() {
        return 0 != (2 & this.selectionStatus);
    }

    boolean isAutoSelected() {
        return 0 != (4 & this.selectionStatus);
    }

    boolean isSelectable() {
        return !this.isHidden() && !this.isUpToDate() && !this.isAutoSelected();
    }

    void setSelectionStatus(int n) {
        this.selectionStatus = n;
    }

    int getSelectionStatus() {
        return this.selectionStatus;
    }

    void setDisplayAsSelected(boolean bl) {
        this.displayAsSelected = bl;
    }

    boolean displayAsSelected() {
        return this.displayAsSelected;
    }

    void setAllowedForSelection(boolean bl) {
        this.isAllowedForSelection = bl;
    }

    boolean isAllowedForSelection() {
        return this.isAllowedForSelection;
    }

    boolean hidePackageSize() {
        return this.hidePackageSize;
    }

    void setHidePackageSize() {
        if (this.isRestrictionAllowed()) {
            this.hidePackageSize = true;
        }
    }

    boolean isRestrictionAllowed() {
        return !this.isHidden() && !this.isSystemPackage() && !this.isPPOI() && !this.isTechnicalPackage();
    }

    String getPkgCategory() {
        return this.pkgCategory;
    }

    String getPkgVersion() {
        return this.pkgVersion;
    }

    String getPkgId() {
        return this.pkgId;
    }

    int getRegionISOCode() {
        return this.regionISOCode;
    }

    boolean isLicenseAvailable() {
        return this.licenseAvailable;
    }

    boolean isPPOI() {
        return this.isPPOI;
    }

    boolean isSystemPackage() {
        return this.isSystemPackage;
    }

    boolean isTechnicalPackage() {
        return this.isTechnicalPackage;
    }

    boolean isBusinessPackage() {
        return 0 == this.getType();
    }

    int getPriority() {
        return this.pkgPriority;
    }

    boolean isSysProposalPackage() {
        return this.getPriority() >= 2000 && this.getPriority() <= 1000;
    }

    long getSize() {
        return this.size;
    }

    int getType() {
        return this.type;
    }

    String[] getUniqueNames() {
        return this.uniqueNames;
    }

    String getDisplayName(int n) {
        String string = this.uniqueNames[n];
        int n2 = string.indexOf(35);
        if (n2 > 0) {
            return string.substring(0, n2);
        }
        return string;
    }

    String getUniqueName(int n) {
        if (n < this.uniqueNames.length) {
            return this.uniqueNames[n];
        }
        return null;
    }

    String getLastName() {
        if (null != this.uniqueNames) {
            for (int i2 = this.uniqueNames.length - 1; i2 >= 0; --i2) {
                int n;
                if (this.uniqueNames[i2] == null || "".equals(this.uniqueNames[i2])) continue;
                String string = this.uniqueNames[i2];
                if (string != null && (n = string.indexOf(35)) > 0) {
                    string = string.substring(n + 1);
                }
                return string;
            }
        }
        return "";
    }

    String getLastVersion() {
        if (null != this.displayVersions) {
            for (int i2 = this.displayVersions.length - 1; i2 >= 0; --i2) {
                if (this.displayVersions[i2] == null || "".equals(this.displayVersions[i2])) continue;
                return this.displayVersions[i2];
            }
        }
        return "";
    }

    String[] getDisplayVersions() {
        return this.displayVersions;
    }

    String getDisplayVersion(int n) {
        return this.displayVersions[n];
    }

    String getNumericVersion() {
        String string = "";
        if (null != this.displayVersions) {
            String string2 = null;
            for (int i2 = 0; i2 < this.displayVersions.length; ++i2) {
                if (this.displayVersions[i2] == null || this.displayVersions[i2].length() <= 0) continue;
                string2 = this.displayVersions[i2].trim();
            }
            if (null != string2) {
                StringTokenizer stringTokenizer = new StringTokenizer(string2, " /t");
                while (stringTokenizer.hasMoreTokens()) {
                    string = stringTokenizer.nextToken();
                }
            }
        }
        return string;
    }

    String getReleaseVersion() {
        return this.releaseVersion;
    }

    String getAdditionalInfos() {
        return this.additionalInfos;
    }

    boolean isValid() {
        return this.isValid;
    }

    private LogChannel getLogUota() {
        return this.logUota;
    }

    static {
        MAP_PREVIEWS_PATH = System.getProperty("UotaMapPreviewsDir", "/mnt/ota/system/mappreviews");
        MAP_PREVIEWS_EXTENSION = System.getProperty("UotaMapPreviewsExt", ".png");
        isCancelled = false;
    }
}

