/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.ValueMissingException;
import de.audi.tghu.swdl.app.customer.uota.BaseUpdateOverTheAirController;
import de.audi.tghu.swdl.app.customer.uota.UotaPkgInfoWrapper;
import de.esolutions.fw.util.commons.StringUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

class IgnoredPackagesStorageContainer
extends AbstractStorageDataContainer {
    private final BaseUpdateOverTheAirController uotaController;
    private static final char PKG_IDS_DELIMETER = ',';
    private static final char PKG_ID_PARTS_DELIMETER = '_';
    private static final int P_VERSION_LENGTH = 4;
    static final String INCORRECT_P_VERSION = "-1";
    private static final int CONTAINER_VERSION = 2;
    private static final int RELEASE_PACKAGE_ID = 0;
    private static final int RELEASE_PACKAGE_WITHOUT_LICENSE_ID = -1;
    private Map ignoredReleasePackagesMap;

    IgnoredPackagesStorageContainer(BaseUpdateOverTheAirController baseUpdateOverTheAirController) {
        super(baseUpdateOverTheAirController.getSwdlEnv().getStorageManager(), 2, 257, 6);
        this.uotaController = baseUpdateOverTheAirController;
        this.readIgnoredPackagesFromPersistence();
    }

    synchronized void updateLastInstalledReleaseVersion(String string) {
        if (!(null == string || "undef".equals(string) || (string = string.trim()).compareTo(this.getHighestInstalledReleaseVersion()) <= 0 && string.length() != 0)) {
            this.getUotaController().getSwdlEnv().getStorageManager().setString(257, 7, string);
        }
    }

    synchronized String getHighestInstalledReleaseVersion() {
        return this.getUotaController().getSwdlEnv().getStorageManager().getString(257, 7, "");
    }

    /*
     * Enabled aggressive block sorting
     */
    synchronized void updateInstalledPackageIds(String string) {
        String string2;
        if (string.length() <= 0) {
            this.getLogUota().log(1000000, "[IgnoredPackagesStorageContainer].updateInstalledPackageIds(): reset installed package IDs!");
            this.getUotaController().getSwdlEnv().getStorageManager().setString(257, 5007, "");
            return;
        }
        this.getLogUota().log(10000, "[IgnoredPackagesStorageContainer].updateInstalledPackageIds(%1)", (Object)string);
        String[] stringArray = this.getInstalledPackageIDs();
        if (stringArray.length > 0) {
            String string3 = this.getPVersion(stringArray[0]);
            String string4 = this.getPVersion(string);
            if (INCORRECT_P_VERSION.equals(string4)) {
                this.getLogUota().log(10000, "[IgnoredPackagesStorageContainer].updateInstalledPackageVersions(): incorrect packageID:%1", (Object)string);
                return;
            }
            if (string3.compareTo(string4) < 0) {
                string2 = string;
            } else {
                if (!string3.equals(string4)) {
                    this.getLogUota().log(10000, "[IgnoredPackagesStorageContainer].updateInstalledPackageVersions(): new package ID belongs to a previuos release!");
                    return;
                }
                Object[] objectArray = new String[stringArray.length + 1];
                System.arraycopy((Object)stringArray, 0, (Object)objectArray, 0, stringArray.length);
                objectArray[objectArray.length - 1] = string;
                string2 = StringUtils.toString(objectArray, ',');
            }
        } else {
            string2 = string;
        }
        if (string2.length() <= 0) return;
        this.getUotaController().getSwdlEnv().getStorageManager().setString(257, 5007, string2.toString());
    }

    String getPVersionOfInstalledPackages() {
        this.getLogUota().log(10000000, "[IgnoredPackagesStorageContainer].getPVersionOfInstalledPackages()");
        String[] stringArray = this.getInstalledPackageIDs();
        if (stringArray.length > 0) {
            return this.getPVersion(stringArray[0]);
        }
        return INCORRECT_P_VERSION;
    }

    synchronized int getNumberOfInstalledPackages() {
        return this.getInstalledPackageIDs().length;
    }

    synchronized int getNumberOfInstalledPackages(String string) {
        int n = 0;
        String[] stringArray = this.getInstalledPackageIDs();
        if (stringArray.length > 0) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                String string2 = this.getPVersion(stringArray[i2]);
                if (INCORRECT_P_VERSION.equals(string2) || string2.compareTo(string) < 0) continue;
                ++n;
            }
        }
        return n;
    }

    String getPVersion(String string) {
        String string2;
        int n = 0;
        if (string != null) {
            n = string.indexOf(95);
        }
        if (n > 0 && (string2 = string.substring(0, n)).length() > 4) {
            String string3 = string2.substring(string2.length() - 4);
            this.getLogUota().log(10000000, "[IgnoredPackagesStorageContainer].getPVersion(%1): %2", (Object)string, (Object)string3);
            return string3;
        }
        this.getLogUota().log(10000, "[IgnoredPackagesStorageContainer].getPVersions(%1): incorrect format of a package ID!", (Object)string);
        return INCORRECT_P_VERSION;
    }

    synchronized String[] getInstalledPackageIDs() {
        this.getLogUota().log(10000000, "[IgnoredPackagesStorageContainer].getInstalledPackageIDs()");
        String string = this.getUotaController().getSwdlEnv().getStorageManager().getString(257, 5007, "");
        if (string.length() > 0) {
            String[] stringArray;
            ArrayList arrayList = new ArrayList(3);
            StringTokenizer stringTokenizer = new StringTokenizer(string, new Character(',').toString());
            while (stringTokenizer.hasMoreTokens()) {
                stringArray = stringTokenizer.nextToken().trim();
                if (stringArray.length() <= 0) continue;
                arrayList.add(stringArray);
            }
            stringArray = new String[arrayList.size()];
            System.arraycopy((Object)arrayList.toArray(), 0, (Object)stringArray, 0, arrayList.size());
            return stringArray;
        }
        return new String[0];
    }

    synchronized void addToIgnoreList(UotaPkgInfoWrapper uotaPkgInfoWrapper) {
        if (null == uotaPkgInfoWrapper || !uotaPkgInfoWrapper.isValid()) {
            this.getLogUota().log(10000, "[IgnoredPackagesStorageContainer].addToIgnoreList(%1): Invalid package info!", (Object)uotaPkgInfoWrapper);
            return;
        }
        if (null == this.ignoredReleasePackagesMap) {
            this.getLogUota().log(10000, "[IgnoredPackagesStorageContainer].addToIgnoreList(): Ignoring packages without reading the ignore list!");
            return;
        }
        this.getLogUota().log(1000000, "[IgnoredPackagesStorageContainer].addToIgnoreList(): Adding to ignore list: %1", (Object)uotaPkgInfoWrapper);
        this.ignoredReleasePackagesMap.put(uotaPkgInfoWrapper.getPkgId(), uotaPkgInfoWrapper.getReleaseVersion());
    }

    synchronized void addReleaseVersionToIgnoreList(String string, boolean bl) {
        if (null == string || string.length() == 0) {
            this.getLogUota().log(10000, "[IgnoredPackagesStorageContainer].addReleaseVersionToIgnoreList(%1): Invalid release version info!", (Object)string);
            return;
        }
        if (null == this.ignoredReleasePackagesMap) {
            this.getLogUota().log(10000, "[IgnoredPackagesStorageContainer].addReleaseVersionToIgnoreList(): Ignoring packages without reading the ignore list!");
            return;
        }
        this.getLogUota().log(1000000, "[IgnoredPackagesStorageContainer].addReleaseVersionToIgnoreList(): Adding release to ignore list: %1", (Object)string);
        this.ignoredReleasePackagesMap.put(Integer.toString(bl ? 0 : -1), string);
        this.storeIgnoredPackagesToPersistence();
    }

    synchronized boolean isReleaseIgnoredByUser(UotaPkgInfoWrapper uotaPkgInfoWrapper) {
        String string;
        this.getLogUota().log(10000000, "[IgnoredPackagesStorageContainer].isReleaseIgnoredByUser(%1)", (Object)uotaPkgInfoWrapper);
        if (null != this.ignoredReleasePackagesMap && null != (string = (String)this.ignoredReleasePackagesMap.get(Integer.toString(uotaPkgInfoWrapper.isLicenseAvailable() ? 0 : -1))) && string.length() > 0) {
            boolean bl = uotaPkgInfoWrapper.getReleaseVersion().compareTo(string) <= 0;
            this.getLogUota().log(10000000, "[IgnoredPackagesStorageContainer] ignored release version is %1, package release version is %2,  ignore=%3", (Object)string, (Object)uotaPkgInfoWrapper.getReleaseVersion(), (Object)new Boolean(bl));
            return bl;
        }
        return false;
    }

    synchronized boolean isUpdatePackageIgnoredByUser(UotaPkgInfoWrapper uotaPkgInfoWrapper) {
        String string;
        this.getLogUota().log(10000000, "[IgnoredPackagesStorageContainer].isUpdatePackageIgnoredByUser(%1)", (Object)uotaPkgInfoWrapper);
        if (null != this.ignoredReleasePackagesMap && null != (string = (String)this.ignoredReleasePackagesMap.get(uotaPkgInfoWrapper.getPkgId())) && string.length() > 0) {
            boolean bl = uotaPkgInfoWrapper.getReleaseVersion().compareTo(string) <= 0;
            this.getLogUota().log(10000000, "[IgnoredPackagesStorageContainer] ignored package version is %1, current package version is %2,  ignore=%3", (Object)string, (Object)uotaPkgInfoWrapper.getReleaseVersion(), (Object)new Boolean(bl));
            return bl;
        }
        return false;
    }

    synchronized boolean isHighestReleaseAlreadyIsntalled(UotaPkgInfoWrapper uotaPkgInfoWrapper) {
        this.getLogUota().log(10000000, "[IgnoredPackagesStorageContainer].isReleaseAlreadyIntalled(%1)", (Object)uotaPkgInfoWrapper);
        return uotaPkgInfoWrapper.getReleaseVersion().compareTo(this.getUotaController().getSwdlEnv().getStorageManager().getString(257, 7, "")) <= 0;
    }

    synchronized void cleanUpAlreadyInstalledHighestRelease() {
        this.getLogUota().log(10000000, "[IgnoredPackagesStorageContainer].cleanUpAlreadyInstalledHighestRelease()");
        this.getUotaController().getSwdlEnv().getStorageManager().setString(257, 7, "");
    }

    synchronized void storeIgnoredPackagesToPersistence() {
        if (null == this.ignoredReleasePackagesMap) {
            this.getLogUota().log(100000, "[IgnoredPackagesStorageContainer].storeIgnoredPackagesToPersistence(): Write requested but no read performed before. Ignoring request!");
        } else {
            this.serializeAndWrite();
        }
    }

    Map getIgnoredPackagesMap() {
        this.readIgnoredPackagesFromPersistence();
        return this.ignoredReleasePackagesMap;
    }

    private void readIgnoredPackagesFromPersistence() {
        this.getLogUota().log(10000000, "[IgnoredPackagesStorageContainer].readIgnoredPackagesFromPersistence()");
        if (null == this.ignoredReleasePackagesMap) {
            this.readAndDeserialize();
        } else {
            this.getLogUota().log(10000000, "[IgnoredPackagesStorageContainer].readIgnoredPackagesFromPersistence(): Data already read from persistence. Ignoring request!");
        }
    }

    void cleanupIgnoredPackages() {
        this.getLogUota().log(100000, "[IgnoredPackagesStorageContainer].cleanupIgnoredPackages(): Cleanup of persisted data requested!");
        this.ignoredReleasePackagesMap = new HashMap();
        this.serializeAndWrite();
    }

    void removeFromIgnoredPackage(int n) {
        this.getLogUota().log(100000, "[IgnoredPackagesStorageContainer].removeFromIgnoredPackage(): Removing pkg %2 from the ignored list!", (long)n);
        this.readIgnoredPackagesFromPersistence();
        if (null != this.ignoredReleasePackagesMap) {
            this.ignoredReleasePackagesMap.remove(Integer.toString(n));
            this.serializeAndWrite();
        }
    }

    protected void handleCRC32Error() {
        this.getLogUota().log(10000, "[IgnoredPackagesStorageContainer].handleCRC32Error(): Failed to read user selection!");
        this.ignoredReleasePackagesMap = new HashMap();
    }

    protected void handleStorageReadError(Exception exception) {
        if (exception instanceof ValueMissingException) {
            this.getLogUota().log(1000000, "[IgnoredPackagesStorageContainer].handleStorageReadError(): No ignored packages persisted yet!");
        } else {
            this.getLogUota().log(10000, "[IgnoredPackagesStorageContainer].handleStorageReadError(): Failed to read user selection!");
        }
        this.ignoredReleasePackagesMap = new HashMap();
    }

    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
    }

    protected void serialize(DataOutputStream dataOutputStream) throws IOException {
        if (null == this.ignoredReleasePackagesMap) {
            this.getLogUota().log(100000, "[IgnoredPackagesStorageContainer].serialize(): Null ignoredReleasePackagesMap, nothing to persist!");
            return;
        }
        this.serializeStringArray(this.mapToArray(), dataOutputStream);
    }

    protected void deserialize(DataInputStream dataInputStream) throws IOException {
        this.getLogUota().log(10000000, "[IgnoredPackagesStorageContainer].deserialize(): Reading the user ignored release/packages from persistence");
        String[] stringArray = this.deserializeStringArray(dataInputStream);
        if (stringArray != null) {
            this.ignoredReleasePackagesMap = new HashMap(stringArray.length / 2);
            try {
                for (int i2 = 0; i2 < stringArray.length; i2 += 2) {
                    this.ignoredReleasePackagesMap.put(stringArray[i2], stringArray[i2 + 1]);
                }
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                this.getLogUota().log(10000, "[IgnoredPackagesStorageContainer].deserialize(): the IgnoredPackagesStorageContainer is corrupted!");
            }
        } else {
            this.getLogUota().log(10000000, "[IgnoredPackagesStorageContainer].deserialize(): the string array is not exist!");
        }
    }

    private BaseUpdateOverTheAirController getUotaController() {
        return this.uotaController;
    }

    private LogChannel getLogUota() {
        return this.getUotaController().getLogUota();
    }

    private String[] mapToArray() {
        String[] stringArray = new String[]{};
        this.getLogUota().log(10000000, "[IgnoredPackagesStorageContainer].mapToArray(): convert ignoredReleasePackagesMap to a string array");
        if (null != this.ignoredReleasePackagesMap && this.ignoredReleasePackagesMap.size() > 0) {
            stringArray = new String[this.ignoredReleasePackagesMap.size() * 2];
            int n = 0;
            Iterator iterator = this.ignoredReleasePackagesMap.keySet().iterator();
            while (iterator.hasNext()) {
                String string = (String)iterator.next();
                String string2 = (String)this.ignoredReleasePackagesMap.get(string);
                stringArray[n++] = string;
                stringArray[n++] = string2;
            }
        }
        this.getLogUota().log(10000000, "[IgnoredPackagesStorageContainer].mapToArray(): array length=%1", (long)stringArray.length);
        return stringArray;
    }
}

