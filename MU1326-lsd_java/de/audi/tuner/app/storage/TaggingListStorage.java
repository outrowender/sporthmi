/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.storage;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tuner.app.storage.TaggingListStorage$StorageDataContainer;
import java.util.LinkedList;

public class TaggingListStorage {
    private static final int VERSION;
    private final IStorageAccess storageAccess;
    private final LogChannel lc;

    public TaggingListStorage(IStorageAccess iStorageAccess, LogChannel logChannel) {
        this.storageAccess = iStorageAccess;
        this.lc = logChannel;
    }

    public LinkedList read() {
        TaggingListStorage$StorageDataContainer taggingListStorage$StorageDataContainer = new TaggingListStorage$StorageDataContainer(this, 350);
        taggingListStorage$StorageDataContainer.readAndDeserialize();
        LinkedList linkedList = taggingListStorage$StorageDataContainer.getData();
        taggingListStorage$StorageDataContainer = new TaggingListStorage$StorageDataContainer(this, 360);
        taggingListStorage$StorageDataContainer.readAndDeserialize();
        LinkedList linkedList2 = taggingListStorage$StorageDataContainer.getData();
        for (int i2 = 0; i2 < linkedList2.size(); ++i2) {
            linkedList.add(linkedList2.get(i2));
        }
        return linkedList;
    }

    public void write(LinkedList linkedList) {
        this.lc.log(-2137614336, "[TaggingListStorage.write]");
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        LinkedList linkedList4 = linkedList2;
        for (int i2 = 0; i2 < linkedList.size(); ++i2) {
            linkedList4.add(linkedList.get(i2));
            if (i2 != 24) continue;
            linkedList4 = linkedList3;
        }
        TaggingListStorage$StorageDataContainer taggingListStorage$StorageDataContainer = new TaggingListStorage$StorageDataContainer(this, 350);
        taggingListStorage$StorageDataContainer.setData(linkedList2);
        taggingListStorage$StorageDataContainer.serializeAndWrite();
        taggingListStorage$StorageDataContainer = new TaggingListStorage$StorageDataContainer(this, 360);
        taggingListStorage$StorageDataContainer.setData(linkedList3);
        taggingListStorage$StorageDataContainer.serializeAndWrite();
    }

    static /* synthetic */ IStorageAccess access$000(TaggingListStorage taggingListStorage) {
        return taggingListStorage.storageAccess;
    }

    static /* synthetic */ LogChannel access$100(TaggingListStorage taggingListStorage) {
        return taggingListStorage.lc;
    }
}

