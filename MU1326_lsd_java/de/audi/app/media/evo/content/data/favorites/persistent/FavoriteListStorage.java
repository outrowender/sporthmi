/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites.persistent;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.evo.content.data.favorites.FavoritesList;
import de.audi.app.media.evo.content.data.favorites.MediaFavorite;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.ValueMissingException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FavoriteListStorage
extends AbstractStorageDataContainer {
    private static final String LOGCLASS = "FavoriteListStorage";
    private final LogChannel logger;
    private volatile FavoritesList favoritesList;

    public FavoriteListStorage(IMediaTerminal iMediaTerminal, int n) {
        super(iMediaTerminal.getFramework().getStorageMgr(), 0, 1002, n);
        this.logger = iMediaTerminal.getLogger().main();
    }

    protected void handleCRC32Error() {
        this.logger.log(1000000, "[%1.handleCRC32Error]", (Object)LOGCLASS);
        this.favoritesList = new FavoritesList(this.logger);
    }

    protected void handleStorageReadError(Exception exception) {
        this.logger.log(1000000, "[%1.handleStorageReadError]", (Object)LOGCLASS);
        if (exception instanceof ValueMissingException) {
            this.favoritesList = new FavoritesList(this.logger);
        }
    }

    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.logger.log(1000000, "[%1.convertContainer]", (Object)LOGCLASS);
    }

    protected void serialize(DataOutputStream dataOutputStream) throws IOException {
        this.logger.log(1000000, "[%1.serialize]", (Object)LOGCLASS);
        List list = this.favoritesList.getFavoritesList();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(dataOutputStream);
        ArrayList arrayList = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            MediaFavorite mediaFavorite = (MediaFavorite)iterator.next();
            arrayList.add(mediaFavorite.getSerializableData());
        }
        objectOutputStream.writeObject(arrayList);
    }

    protected void deserialize(DataInputStream dataInputStream) throws IOException {
        this.logger.log(1000000, "[%1.deserialize]", (Object)LOGCLASS);
        this.favoritesList = new FavoritesList(this.logger);
        ObjectInputStream objectInputStream = new ObjectInputStream(dataInputStream);
        try {
            ArrayList arrayList = (ArrayList)objectInputStream.readObject();
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                Object object = arrayList.get(i2);
                MediaFavorite mediaFavorite = MediaFavorite.deserializeData(this.logger, object);
                if (null == mediaFavorite || !mediaFavorite.validateMediaFavoriteData()) continue;
                this.favoritesList.addFavorite(mediaFavorite);
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            this.logger.log(10000, "[%1.deserialize]", (Object)LOGCLASS, (Throwable)classNotFoundException);
        }
    }

    public void setFavoriteList(FavoritesList favoritesList) {
        this.logger.log(1000000, "[%1.setFavoriteList]", (Object)LOGCLASS);
        boolean bl = null != this.favoritesList && this.favoritesList.getListSize() > 0 && favoritesList.getListSize() == 0;
        this.favoritesList = favoritesList;
        if (bl || favoritesList.getListSize() > 0) {
            this.serializeAndWrite();
        }
    }

    public FavoritesList getFavoriteList() {
        this.logger.log(1000000, "[%1.getFavoriteList]", (Object)LOGCLASS);
        if (null == this.favoritesList) {
            this.readAndDeserialize();
        }
        if (null == this.favoritesList) {
            this.favoritesList = new FavoritesList(this.logger);
        }
        return this.favoritesList;
    }

    public int getPersistentKey() {
        return this.getKey();
    }

    public void clearList() {
        this.logger.log(1000000, "[%1.clearList]", (Object)LOGCLASS);
        this.favoritesList = new FavoritesList(this.logger);
        this.serializeAndWrite();
    }
}

