/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.persistence;

import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.persistence.PersistentData;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.storage.ValueMissingException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class MediaPersistenceStorageData
extends AbstractStorageDataContainer {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private volatile HashMap mediaPersistence;

    public MediaPersistenceStorageData(IMediaLogger iMediaLogger, IStorageAccess iStorageAccess) {
        super(iStorageAccess, 0, 1002, 270);
        this.logger = iMediaLogger.main();
    }

    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"MediaPersistenceStorageData");
        this.readAndDeserialize();
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"MediaPersistenceStorageData");
        this.serializeAndWrite();
    }

    @Override
    protected void handleCRC32Error() {
        this.logger.log(1078071040, "[%1.handleCRC32Error]", (Object)"MediaPersistenceStorageData");
        this.mediaPersistence = new HashMap();
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
        if (exception instanceof ValueMissingException) {
            this.logger.log(1078071040, "[%1.handleStorageReadError] Value missing, create new one.", (Object)"MediaPersistenceStorageData");
            this.mediaPersistence = new HashMap();
            return;
        }
        this.logger.log(10000, "[%1.handleStorageReadError]", (Object)"MediaPersistenceStorageData", (Throwable)exception);
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        this.logger.log(1078071040, "[%1.serialize]", (Object)"MediaPersistenceStorageData");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(dataOutputStream);
        objectOutputStream.writeObject(this.mediaPersistence);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        this.logger.log(1078071040, "[%1.deserialize]", (Object)"MediaPersistenceStorageData");
        ObjectInputStream objectInputStream = new ObjectInputStream(dataInputStream);
        try {
            this.mediaPersistence = (HashMap)objectInputStream.readObject();
        }
        catch (ClassNotFoundException classNotFoundException) {
            this.logger.log(10000, "[%1.deserialize] %2", (Object)"MediaPersistenceStorageData", (Throwable)classNotFoundException);
        }
    }

    public PersistentData get(String string) {
        return (PersistentData)this.mediaPersistence.get(string);
    }

    public PersistentData put(String string, PersistentData persistentData) {
        PersistentData persistentData2 = (PersistentData)this.mediaPersistence.put(string, persistentData);
        this.serializeAndWrite();
        return persistentData2;
    }
}

