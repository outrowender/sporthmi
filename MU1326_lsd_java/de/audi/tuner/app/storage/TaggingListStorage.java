/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.storage;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tuner.itunes.TaggingData;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;

public class TaggingListStorage {
    private static final int VERSION = 1;
    private final IStorageAccess storageAccess;
    private final LogChannel lc;

    public TaggingListStorage(IStorageAccess iStorageAccess, LogChannel logChannel) {
        this.storageAccess = iStorageAccess;
        this.lc = logChannel;
    }

    public LinkedList read() {
        StorageDataContainer storageDataContainer = new StorageDataContainer(350);
        storageDataContainer.readAndDeserialize();
        LinkedList linkedList = storageDataContainer.getData();
        storageDataContainer = new StorageDataContainer(360);
        storageDataContainer.readAndDeserialize();
        LinkedList linkedList2 = storageDataContainer.getData();
        for (int i2 = 0; i2 < linkedList2.size(); ++i2) {
            linkedList.add(linkedList2.get(i2));
        }
        return linkedList;
    }

    public void write(LinkedList linkedList) {
        this.lc.log(10000000, "[TaggingListStorage.write]");
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        LinkedList linkedList4 = linkedList2;
        for (int i2 = 0; i2 < linkedList.size(); ++i2) {
            linkedList4.add(linkedList.get(i2));
            if (i2 != 24) continue;
            linkedList4 = linkedList3;
        }
        StorageDataContainer storageDataContainer = new StorageDataContainer(350);
        storageDataContainer.setData(linkedList2);
        storageDataContainer.serializeAndWrite();
        storageDataContainer = new StorageDataContainer(360);
        storageDataContainer.setData(linkedList3);
        storageDataContainer.serializeAndWrite();
    }

    private class StorageDataContainer
    extends AbstractStorageDataContainer {
        private LinkedList list;

        public StorageDataContainer(int n) {
            super(TaggingListStorage.this.storageAccess, 1, 1001, n);
        }

        public LinkedList getData() {
            return this.list;
        }

        public void setData(LinkedList linkedList) {
            this.list = linkedList;
        }

        protected void handleCRC32Error() {
            TaggingListStorage.this.lc.log(100000, "[TaggingListStorage.handleCRC32Error]");
            this.list = new LinkedList();
        }

        protected void handleStorageReadError(Exception exception) {
            TaggingListStorage.this.lc.log(100000, "[TaggingListStorage.handleStorageReadError]");
            this.list = new LinkedList();
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
            TaggingListStorage.this.lc.log(1000000, "[TaggingListStorage.convertContainer] persisted:%1 container:%2", (long)n, (long)n2);
            this.list = new LinkedList();
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(dataOutputStream);
            objectOutputStream.writeObject(this.list);
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            ObjectInputStream objectInputStream = new ObjectInputStream(dataInputStream);
            try {
                this.list = (LinkedList)objectInputStream.readObject();
                int n = 10;
                Iterator iterator = this.list.iterator();
                while (iterator.hasNext()) {
                    TaggingData taggingData = (TaggingData)iterator.next();
                    taggingData.setId(n++);
                }
            }
            catch (ClassNotFoundException classNotFoundException) {
                TaggingListStorage.this.lc.log(10000, "[TaggingListStorage.StorageDataContainer.deserialize]", (Throwable)classNotFoundException);
                throw new IOException("[TaggingListStorage.StorageDataContainer.deserialize]");
            }
        }
    }
}

