/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.storagecache;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.storagecache.CacheEventListener;
import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CacheWorker
extends AbstractStorageDataContainer {
    protected LogChannel log;
    protected String serviceID;
    protected Object service;
    protected Map token2Subscriber = Collections.synchronizedMap(new HashMap());

    public CacheWorker(LogChannel logChannel, IStorageAccess iStorageAccess, int n, int n2, int n3, String string) {
        super(iStorageAccess, n, n2, n3);
        this.serviceID = string;
        this.log = logChannel;
    }

    public String getServiceID() {
        return this.serviceID;
    }

    public Object getService() {
        return this.service;
    }

    public void setService(Object object) {
        this.log.log(-2137614336, "[CacheWorker#setService] service: %1 serviceID: %2", object, (Object)this.serviceID);
        this.service = object;
        if (object != null) {
            try {
                this.registerWorkerAsServiceListener(object);
            }
            catch (Exception exception) {
                this.log.log(-2137614336, "[CacheWorker#setService] serviceID: %1", (Object)this.serviceID, (Throwable)exception);
            }
        }
    }

    @Override
    protected void handleCRC32Error() {
        this.log.log(-1601830656, "CacheWorker.handleCRC32Error() serviceID: %1", (Object)this.serviceID);
    }

    @Override
    protected void handleStorageReadError(Exception exception) {
        this.log.log(-1601830656, "CacheHandlerImpl.handleStorageReadError(): serviceID: %1", (Object)this.serviceID, (Throwable)exception);
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.log.log(-1601830656, "CacheHandlerImpl.convertContainer(): %1 persistedVersion: %2, containerVersion: %3", (Object)this.serviceID, (long)n, (long)n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addListener(CacheEventListener cacheEventListener) {
        String[] stringArray = null;
        try {
            stringArray = cacheEventListener.getTokens(this.serviceID);
        }
        catch (Exception exception) {
            this.log.log(10000, "CacheEventListener.getTokens() callback error", (Throwable)exception);
        }
        if (stringArray != null) {
            this.registerCacheEventListener(cacheEventListener);
            Map map = this.token2Subscriber;
            synchronized (map) {
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    List list = (List)this.token2Subscriber.get(stringArray[i2]);
                    if (list == null) {
                        list = new ArrayList();
                        this.token2Subscriber.put(stringArray[i2], list);
                    }
                    this.log.log(14808325, "CacheWorker#addListener(%2): new listener for %1 added.", (Object)stringArray[i2], (Object)this.serviceID);
                    list.add(cacheEventListener);
                    try {
                        cacheEventListener.updateToken(this.serviceID, stringArray[i2], this.getState(stringArray[i2]));
                        continue;
                    }
                    catch (Exception exception) {
                        this.log.log(10000, "CacheEventListener.updateToken() callback error", (Throwable)exception);
                    }
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeListener(CacheEventListener cacheEventListener) {
        String[] stringArray = null;
        try {
            stringArray = cacheEventListener.getTokens(this.serviceID);
        }
        catch (Exception exception) {
            this.log.log(10000, "CacheEventListener.getTokens() callback error", (Throwable)exception);
        }
        if (stringArray != null) {
            Map map = this.token2Subscriber;
            synchronized (map) {
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    List list = (List)this.token2Subscriber.get(stringArray[i2]);
                    if (list == null) continue;
                    list.remove(cacheEventListener);
                }
            }
        }
    }

    public abstract Object getState(String string) {
    }

    protected abstract void registerWorkerAsServiceListener(Object object) {
    }

    protected abstract void registerCacheEventListener(CacheEventListener cacheEventListener) {
    }
}

