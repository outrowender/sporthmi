/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.favorite;

import de.audi.atip.favorite.IFavoriteStorage;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FavoritePersistenceHandlerBase
extends AbstractStorageDataContainer {
    private final LogChannel log;
    private IFavoriteStorage[] favorites;

    public FavoritePersistenceHandlerBase(IStorageAccess iStorageAccess, int n, int n2, int n3, LogChannel logChannel) {
        super(iStorageAccess, n, n2, n3);
        this.log = logChannel;
    }

    void storeFavorites(IFavoriteStorage[] iFavoriteStorageArray) {
        IFavoriteStorage[] iFavoriteStorageArray2 = this.favorites = iFavoriteStorageArray != null ? iFavoriteStorageArray : new IFavoriteStorage[]{};
        if (this.log.isDebug()) {
            for (int i2 = 0; i2 < this.favorites.length; ++i2) {
                this.log.log(-2137614336, "[FavoritePersistenceHandlerBase#storeFavorites] favorites[%2] %1", (Object)this.favorites[i2], (long)i2);
            }
        }
        this.serializeAndWrite();
        this.log.log(-2137614336, "[FavoritePersistenceHandlerBase#storeFavorites] favorite size: %1", (long)this.getSize());
    }

    IFavoriteStorage[] readFavorites() {
        this.readAndDeserialize();
        if (this.log.isDebug() && this.favorites != null) {
            for (int i2 = 0; i2 < this.favorites.length; ++i2) {
                this.log.log(-2137614336, "[FavoritePersistenceHandlerBase#readFavorites] favorites[%2] %1", (Object)this.favorites[i2], (long)i2);
            }
        }
        this.log.log(-2137614336, "[FavoritePersistenceHandlerBase#readFavorites] favorite size: %1", (long)this.getSize());
        return this.favorites;
    }

    @Override
    protected void handleCRC32Error() {
        this.log.log(-1601830656, "[FavoritePersistenceHandlerBase#handleCRC32Error]");
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.log.log(-1601830656, "[FavoritePersistenceHandlerBase#convertContainer] persistedVersion=%1, containerVersion=%2", (long)n, (long)n2);
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        int n = this.favorites.length;
        this.log.log(-2137614336, "[FavoritePersistenceHandlerBase#serialize] favoritesLength=%1", (long)n);
        dataOutputStream.writeInt(n);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(dataOutputStream);
        for (int i2 = 0; i2 < this.favorites.length; ++i2) {
            IFavoriteStorage iFavoriteStorage = this.favorites[i2];
            this.log.log(-2137614336, "[FavoritePersistenceHandlerBase#serialize] favorite=%1", (Object)iFavoriteStorage);
            objectOutputStream.writeObject(iFavoriteStorage);
        }
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        this.log.log(-2137614336, "[FavoritePersistenceHandlerBase#deserialize]");
        int n = dataInputStream.readInt();
        this.log.log(-2137614336, "[FavoritePersistenceHandlerBase#deserialize] arrayLength=%1", (long)n);
        if (n < 0 || n > 50) {
            this.log.log(10000, "[FavoritePersistenceHandlerBase#deserialize] array length not valid: %1", (long)n);
            return;
        }
        this.favorites = new IFavoriteStorage[n];
        ObjectInputStream objectInputStream = new ObjectInputStream(dataInputStream);
        for (int i2 = 0; i2 < n; ++i2) {
            try {
                IFavoriteStorage iFavoriteStorage = (IFavoriteStorage)objectInputStream.readObject();
                this.log.log(-2137614336, "[FavoritePersistenceHandlerBase#deserialize] favorite=%1", (Object)iFavoriteStorage);
                this.favorites[i2] = iFavoriteStorage;
                continue;
            }
            catch (ClassNotFoundException classNotFoundException) {
                this.log.log(10000, "[FavoritePersistenceHandlerBase#deserialize] %1", (Throwable)classNotFoundException);
            }
        }
    }
}

