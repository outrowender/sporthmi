/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.poiwarning;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.PersistentState;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
        this.logChannel.log(10000000, "PoiWarningPersistenceHelper#saveItems(int[]) - for key: %1", (long)this.key);
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        Items items = new Items(iStorageAccess, this.logChannel, this.key);
        items.setSelectedPoiCategories(nArray);
        items.serializeAndWrite();
    }

    public void saveItems(LinkedList linkedList) {
        this.logChannel.log(10000000, "PoiWarningPersistenceHelper#saveItems(LinkedList) - for key: %1", (long)this.key);
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
            this.logChannel.log(100000000, "PoiWarningPersistenceHelper#loadItems() - for key: %1", (long)this.key);
        }
        if ((iStorageAccess = this.env.getFramework().getStorageMgr()) == null) {
            return new int[]{-1};
        }
        Items items = new Items(iStorageAccess, this.logChannel, this.key);
        items.readAndDeserialize();
        if (items.getSelectedPoiCategories() != null) {
            return items.getSelectedPoiCategories();
        }
        return new int[]{-1};
    }

    public static class Items
    extends PersistentState {
        public static final int VERSION = 1;
        private int[] serializedItems = new int[]{-1};

        public Items(IStorageAccess iStorageAccess, LogChannel logChannel, int n) {
            super(iStorageAccess, 1, 1004, n, logChannel);
        }

        protected void initWithDefaultValues() {
            this.serializedItems = new int[1];
            this.serializedItems[0] = -1;
        }

        protected void initFromOldKeys(IStorageAccess iStorageAccess) {
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
            this.initWithDefaultValues();
            try {
                if (n > 0) {
                    this.serializedItems = this.deserializeIntArray(dataInputStream);
                }
            }
            catch (IOException iOException) {
                this.getLogChannel().log(10000, "PoiWarningPersistenceHelper.Items#convertContainer - error on converting the persistent state format", (Throwable)iOException);
            }
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            this.serializeIntArray(this.serializedItems, dataOutputStream);
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            this.serializedItems = this.deserializeIntArray(dataInputStream);
        }

        public void setSelectedPoiCategories(int[] nArray) {
            this.serializedItems = nArray;
        }

        public int[] getSelectedPoiCategories() {
            return this.serializedItems;
        }
    }
}

