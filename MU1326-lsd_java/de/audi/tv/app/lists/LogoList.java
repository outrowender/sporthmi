/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tv.app.storage.LogoListStorage;
import de.esolutions.fw.util.commons.LongList;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.tvtuner.LogoInfo;

public class LogoList {
    private final Map logoMap = new HashMap();
    private final LongList favoriteNamePIDs = new LongList();
    private final LogoListStorage storage;

    public LogoList(IStorageAccess iStorageAccess, LogChannel logChannel) {
        this.storage = new LogoListStorage(iStorageAccess, logChannel);
        LogoInfo[] logoInfoArray = this.storage.read();
        for (int i2 = 0; i2 < logoInfoArray.length; ++i2) {
            if (logoInfoArray[i2] == null) continue;
            this.logoMap.put(new Long(logoInfoArray[i2].namePID), logoInfoArray[i2].channelLogo);
        }
    }

    void updateLogoMap(LogoInfo[] logoInfoArray) {
        for (int i2 = 0; i2 < logoInfoArray.length; ++i2) {
            this.logoMap.put(new Long(logoInfoArray[i2].namePID), logoInfoArray[i2].channelLogo);
        }
        this.saveLogoList();
    }

    void addFavoriteNamePids(long[] lArray) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            if (this.favoriteNamePIDs.contains(lArray[i2])) continue;
            this.favoriteNamePIDs.add(lArray[i2]);
        }
        this.saveLogoList();
    }

    void removeFavoriteNamePids(long[] lArray) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.favoriteNamePIDs.removeElement(lArray[i2]);
        }
        this.saveLogoList();
    }

    private void saveLogoList() {
        LogoInfo[] logoInfoArray = new LogoInfo[50];
        int n = 0;
        for (int i2 = 0; i2 < this.favoriteNamePIDs.size(); ++i2) {
            ResourceLocator resourceLocator = (ResourceLocator)this.logoMap.get(new Long(this.favoriteNamePIDs.get(i2)));
            if (resourceLocator == null) continue;
            logoInfoArray[n++] = new LogoInfo(this.favoriteNamePIDs.get(i2), resourceLocator);
        }
        this.storage.write(logoInfoArray);
    }

    ResourceLocator getLogoForNamePID(long l) {
        return (ResourceLocator)this.logoMap.get(new Long(l));
    }

    public void resetToDefault() {
        this.logoMap.clear();
        this.storage.write(new LogoInfo[50]);
    }
}

