/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.app.customer.uota.UotaPkgInfoWrapper;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class DownloadPackageData {
    public static final String PKG_CATEGORY_SYSTEM;
    public static final String PKG_CATEGORY_NAVDATA;
    private final UotaPkgInfoWrapper[] downloadPackages;
    private final LogChannel logChannel;

    public DownloadPackageData(UotaPkgInfoWrapper[] uotaPkgInfoWrapperArray, LogChannel logChannel) {
        this.downloadPackages = uotaPkgInfoWrapperArray;
        this.logChannel = logChannel;
        if (null == uotaPkgInfoWrapperArray || uotaPkgInfoWrapperArray.length == 0) {
            this.logChannel.log(10000, "[DownloadPackageData].<init>: no download packages found!");
        }
    }

    private UotaPkgInfoWrapper[] getDownloadPackages() {
        if (null == this.downloadPackages) {
            return new UotaPkgInfoWrapper[0];
        }
        return this.downloadPackages;
    }

    private UotaPkgInfoWrapper getDownloadPackage(int n) {
        if (n >= 0 && n < this.getDownloadPackages().length) {
            return this.getDownloadPackages()[n];
        }
        this.logChannel.log(10000, "[DownloadPackageData].getDownloadPackage: incorrect package index %1, array length = %2", (long)n, (long)this.getDownloadPackages().length);
        return null;
    }

    boolean isPPOIPackage(int n) {
        boolean bl = false;
        UotaPkgInfoWrapper uotaPkgInfoWrapper = this.getDownloadPackage(n);
        if (null != uotaPkgInfoWrapper) {
            bl = this.getDownloadPackages()[n].isPPOI();
            this.logChannel.log(-2137614336, "[DownloadPackageData].isPPOIPackage(%1): %2", (Object)Integer.toString(n), (Object)Boolean.toString(bl));
        }
        return bl;
    }

    String getPackageVersion(int n) {
        UotaPkgInfoWrapper uotaPkgInfoWrapper = this.getDownloadPackage(n);
        if (null != uotaPkgInfoWrapper) {
            return uotaPkgInfoWrapper.getDisplayVersion(0);
        }
        return "";
    }

    String getPackageNames(String string) {
        this.logChannel.log(-2137614336, "[DownloadPackageData].getPackageNames(%1)", (Object)string);
        Buffer buffer = new Buffer();
        UotaPkgInfoWrapper[] uotaPkgInfoWrapperArray = this.getDownloadPackages();
        ArrayList arrayList = new ArrayList(uotaPkgInfoWrapperArray.length);
        for (int i2 = 0; i2 < uotaPkgInfoWrapperArray.length; ++i2) {
            UotaPkgInfoWrapper uotaPkgInfoWrapper = uotaPkgInfoWrapperArray[i2];
            if (uotaPkgInfoWrapper.isTechnicalPackage() || !string.equalsIgnoreCase(uotaPkgInfoWrapper.getPkgCategory())) continue;
            arrayList.add(uotaPkgInfoWrapper.getLastName());
        }
        Collections.sort(arrayList);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            if (buffer.length() > 0) {
                buffer.append(", ");
            }
            buffer.append(iterator.next());
        }
        this.logChannel.log(-2137614336, "[DownloadPackageData].getPackageNames:%1", (Object)buffer);
        return buffer.toString();
    }

    String getPackageVersions(String string) {
        this.logChannel.log(-2137614336, "[DownloadPackageData].getPackageVersions(%1)", (Object)string);
        Buffer buffer = new Buffer();
        UotaPkgInfoWrapper[] uotaPkgInfoWrapperArray = this.getDownloadPackages();
        ArrayList arrayList = new ArrayList(1);
        for (int i2 = 0; i2 < uotaPkgInfoWrapperArray.length; ++i2) {
            UotaPkgInfoWrapper uotaPkgInfoWrapper = uotaPkgInfoWrapperArray[i2];
            if (uotaPkgInfoWrapper.isTechnicalPackage() || !string.equalsIgnoreCase(uotaPkgInfoWrapper.getPkgCategory()) || arrayList.contains(uotaPkgInfoWrapper.getLastVersion())) continue;
            arrayList.add(uotaPkgInfoWrapper.getLastVersion());
        }
        Collections.sort(arrayList);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            if (buffer.length() > 0) {
                buffer.append(", ");
            }
            buffer.append(iterator.next());
        }
        this.logChannel.log(-2137614336, "[DownloadPackageData].getPackageVersions:%1", (Object)buffer);
        return buffer.toString();
    }
}

