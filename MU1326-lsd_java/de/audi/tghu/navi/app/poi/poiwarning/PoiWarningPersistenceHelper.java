/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.poiwarning;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.poi.poiwarning.PoiWarningPersistenceHelper$Items;
import java.util.Iterator;
import java.util.LinkedList;

public class PoiWarningPersistenceHelper {
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final int key;

    public PoiWarningPersistenceHelper(NavigationEnv navigationEnv, int n) {
        this.env = navigationEnv;
        this.key = n;
        this.logChannel = navigationEnv.getPoiApproachWarningLogChannel();
    }

    public void saveItems(int[] nArray) {
        this.logChannel.log(-2137614336, "PoiWarningPersistenceHelper#saveItems(int[]) - for key: %1", (long)this.key);
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        PoiWarningPersistenceHelper$Items poiWarningPersistenceHelper$Items = new PoiWarningPersistenceHelper$Items(iStorageAccess, this.logChannel, this.key);
        poiWarningPersistenceHelper$Items.setSelectedPoiCategories(nArray);
        poiWarningPersistenceHelper$Items.serializeAndWrite();
    }

    public void saveItems(LinkedList linkedList) {
        this.logChannel.log(-2137614336, "PoiWarningPersistenceHelper#saveItems(LinkedList) - for key: %1", (long)this.key);
        this.saveItems(this.convertLinkedListToArray(linkedList));
    }

    private int[] convertLinkedListToArray(LinkedList linkedList) {
        int[] nArray = new int[linkedList.size()];
        Iterator iterator = linkedList.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            nArray[n] = (Integer)iterator.next();
            ++n;
        }
        return nArray;
    }

    public int[] loadItems() {
        IStorageAccess iStorageAccess;
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "PoiWarningPersistenceHelper#loadItems() - for key: %1", (long)this.key);
        }
        if ((iStorageAccess = this.env.getFramework().getStorageMgr()) == null) {
            return new int[]{-1};
        }
        PoiWarningPersistenceHelper$Items poiWarningPersistenceHelper$Items = new PoiWarningPersistenceHelper$Items(iStorageAccess, this.logChannel, this.key);
        poiWarningPersistenceHelper$Items.readAndDeserialize();
        if (poiWarningPersistenceHelper$Items.getSelectedPoiCategories() != null) {
            return poiWarningPersistenceHelper$Items.getSelectedPoiCategories();
        }
        return new int[]{-1};
    }
}

