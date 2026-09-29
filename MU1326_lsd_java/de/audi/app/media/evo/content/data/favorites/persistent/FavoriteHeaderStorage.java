/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.favorites.persistent;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.evo.content.data.favorites.persistent.FavoriteHeaderData;
import de.audi.app.media.evo.content.data.favorites.persistent.FavoriteHeaderStorage$1;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.ValueMissingException;
import de.esolutions.fw.util.commons.Buffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class FavoriteHeaderStorage
extends AbstractStorageDataContainer {
    private static final String LOGCLASS;
    private final LogChannel logger;
    public static final int INVALID_PERSISTENT_KEY;
    public static final int MAX_HEADER_DATA;
    private static final int LIST_LAST_USED;
    private volatile ArrayList favoriteHeaderDataList;

    public FavoriteHeaderStorage(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal.getFramework().getStorageMgr(), 0, 1002, 250);
        this.logger = iMediaTerminal.getLogger().main();
    }

    public void loadFavoriteHeader() {
        this.logger.log(1078071040, "[%1.loadFavoriteHeader]", (Object)"FavoriteHeaderStorage");
        this.readAndDeserialize();
    }

    public void saveFavoriteHeader() {
        this.logger.log(1078071040, "[%1.saveFavoriteHeader]", (Object)"FavoriteHeaderStorage");
        this.serializeAndWrite();
    }

    public void resetFavoriteHeader() {
        this.logger.log(1078071040, "[%1.resetFavoriteHeader]", (Object)"FavoriteHeaderStorage");
        this.favoriteHeaderDataList = new ArrayList();
        this.saveFavoriteHeader();
    }

    public int getPersistentKey(int n, String string) {
        this.logger.log(1078071040, "[%1.getPersistentKey] '%2' '%3'", (Object)"FavoriteHeaderStorage", (Object)Integer.toString(n), (Object)string);
        if (null == this.favoriteHeaderDataList) {
            this.logger.log(1078071040, "[%1.getPersistentKey] Empty list.", (Object)"FavoriteHeaderStorage");
            return -1;
        }
        for (int i2 = 0; i2 < this.favoriteHeaderDataList.size(); ++i2) {
            FavoriteHeaderData favoriteHeaderData = (FavoriteHeaderData)this.favoriteHeaderDataList.get(i2);
            if (null == favoriteHeaderData || favoriteHeaderData.getSourceType() != n || !favoriteHeaderData.getMediaId().equals(string)) continue;
            this.serializeAndWrite();
            return favoriteHeaderData.getPersistentKey();
        }
        return -1;
    }

    public int getNewPersistentKey(int n, String string) {
        int n2;
        this.logger.log(1078071040, "[%1.getNewPersistentKey]", (Object)"FavoriteHeaderStorage");
        if (null == this.favoriteHeaderDataList) {
            this.logger.log(1078071040, "[%1.getPersistentKey] Create new header list", (Object)"FavoriteHeaderStorage");
            this.favoriteHeaderDataList = new ArrayList();
        }
        if (this.favoriteHeaderDataList.size() == 10) {
            int n3 = -1;
            FavoriteHeaderData favoriteHeaderData = null;
            for (int i2 = 0; i2 < this.favoriteHeaderDataList.size(); ++i2) {
                FavoriteHeaderData favoriteHeaderData2 = (FavoriteHeaderData)this.favoriteHeaderDataList.get(i2);
                if (null == favoriteHeaderData2 || null != favoriteHeaderData && favoriteHeaderData.getLastUsed() <= favoriteHeaderData2.getLastUsed()) continue;
                favoriteHeaderData = favoriteHeaderData2;
                n3 = i2;
            }
            this.favoriteHeaderDataList.set(n3, new FavoriteHeaderData(favoriteHeaderData.getPersistentKey(), n, string));
            n2 = favoriteHeaderData.getPersistentKey();
        } else {
            n2 = FavoriteHeaderStorage.getPersistentKeyByIndex(this.favoriteHeaderDataList.size());
            this.favoriteHeaderDataList.add(this.favoriteHeaderDataList.size(), new FavoriteHeaderData(n2, n, string));
        }
        this.saveFavoriteHeader();
        return n2;
    }

    public void updateLastUsed(int n) {
        int n2;
        this.logger.log(1078071040, "[%1.updateLastUsed] key='%2'", (Object)"FavoriteHeaderStorage", (long)n);
        ArrayList arrayList = new ArrayList(this.favoriteHeaderDataList);
        Collections.sort(arrayList, new FavoriteHeaderStorage$1(this));
        for (n2 = 0; n2 < arrayList.size(); ++n2) {
            FavoriteHeaderData favoriteHeaderData = (FavoriteHeaderData)arrayList.get(n2);
            if (null == favoriteHeaderData || favoriteHeaderData.getPersistentKey() != n) continue;
            arrayList.remove(n2);
            arrayList.add(0, favoriteHeaderData);
        }
        n2 = 0;
        int n3 = 9;
        while (n2 < arrayList.size()) {
            FavoriteHeaderData favoriteHeaderData = (FavoriteHeaderData)arrayList.get(n2);
            favoriteHeaderData.setLastUsed(n3);
            ++n2;
            --n3;
        }
    }

    @Override
    protected void handleCRC32Error() {
        this.favoriteHeaderDataList = new ArrayList();
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
        if (exception instanceof ValueMissingException) {
            this.favoriteHeaderDataList = new ArrayList();
        }
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        this.logger.log(1078071040, "[%1.serialize]", (Object)"FavoriteHeaderStorage");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(dataOutputStream);
        objectOutputStream.writeObject(this.favoriteHeaderDataList);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        this.logger.log(1078071040, "[%1.deserialize]", (Object)"FavoriteHeaderStorage");
        ObjectInputStream objectInputStream = new ObjectInputStream(dataInputStream);
        try {
            this.favoriteHeaderDataList = (ArrayList)objectInputStream.readObject();
        }
        catch (ClassNotFoundException classNotFoundException) {
            this.logger.log(10000, "[%1.deserialize]", (Object)"FavoriteHeaderStorage", (Throwable)classNotFoundException);
        }
        if (null == this.favoriteHeaderDataList) {
            this.favoriteHeaderDataList = new ArrayList();
        }
        if (this.logger.isDebug()) {
            this.logger.log(-2137614336, "[%1.deserialize] %2", (Object)"FavoriteHeaderStorage", (Object)this.toString());
        }
    }

    public static int getPersistentKeyByIndex(int n) {
        switch (n) {
            case 0: {
                return 260;
            }
            case 1: {
                return 261;
            }
            case 2: {
                return 262;
            }
            case 3: {
                return 263;
            }
            case 4: {
                return 264;
            }
            case 5: {
                return 265;
            }
            case 6: {
                return 266;
            }
            case 7: {
                return 267;
            }
            case 8: {
                return 268;
            }
            case 9: {
                return 269;
            }
        }
        return -1;
    }

    public String toString() {
        if (this.favoriteHeaderDataList == null) {
            return "No header data list.";
        }
        Buffer buffer = new Buffer(70);
        buffer.append("size='");
        buffer.append(this.favoriteHeaderDataList.size());
        buffer.append("' ");
        Iterator iterator = this.favoriteHeaderDataList.iterator();
        while (iterator.hasNext()) {
            FavoriteHeaderData favoriteHeaderData = (FavoriteHeaderData)iterator.next();
            buffer.append("[");
            buffer.append(favoriteHeaderData.toString());
            buffer.append("]\n");
        }
        return buffer.toString();
    }
}

