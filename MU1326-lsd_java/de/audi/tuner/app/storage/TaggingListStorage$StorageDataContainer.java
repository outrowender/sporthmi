/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.storage;

import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.tuner.app.storage.TaggingListStorage;
import de.audi.tuner.itunes.TaggingData;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;

class TaggingListStorage$StorageDataContainer
extends AbstractStorageDataContainer {
    private LinkedList list;
    private final /* synthetic */ TaggingListStorage this$0;

    public TaggingListStorage$StorageDataContainer(TaggingListStorage taggingListStorage, int n) {
        this.this$0 = taggingListStorage;
        super(TaggingListStorage.access$000(taggingListStorage), 1, 1001, n);
    }

    public LinkedList getData() {
        return this.list;
    }

    public void setData(LinkedList linkedList) {
        this.list = linkedList;
    }

    @Override
    protected void handleCRC32Error() {
        TaggingListStorage.access$100(this.this$0).log(-1601830656, "[TaggingListStorage.handleCRC32Error]");
        this.list = new LinkedList();
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
        TaggingListStorage.access$100(this.this$0).log(-1601830656, "[TaggingListStorage.handleStorageReadError]");
        this.list = new LinkedList();
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        TaggingListStorage.access$100(this.this$0).log(1078071040, "[TaggingListStorage.convertContainer] persisted:%1 container:%2", (long)n, (long)n2);
        this.list = new LinkedList();
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(dataOutputStream);
        objectOutputStream.writeObject(this.list);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
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
            TaggingListStorage.access$100(this.this$0).log(10000, "[TaggingListStorage.StorageDataContainer.deserialize]", (Throwable)classNotFoundException);
            throw new IOException("[TaggingListStorage.StorageDataContainer.deserialize]");
        }
    }
}

