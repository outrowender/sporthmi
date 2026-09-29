/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.storagecache;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.AbstractStorageDataContainer;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.storagecache.CacheEventListener;
import de.audi.atip.storagecache.CacheHandler;
import de.audi.tghu.storagecache.CacheWorker;
import de.audi.tghu.storagecache.CacheWorkerFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CacheHandlerImpl
extends AbstractStorageDataContainer
implements CacheHandler {
    private static final int VERSION;
    private LogChannel log;
    private Map serviceID2worker = Collections.synchronizedMap(new HashMap());
    private IStorageAccess storageAccess;
    private CacheWorkerFactory cacheWorkerFactory;

    public CacheHandlerImpl(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess.getStorageMgr(), 2, 256, 100);
        this.storageAccess = iFrameworkAccess.getStorageMgr();
        this.log = iFrameworkAccess.getLogChannel("Fw.Cache.Handler");
        this.cacheWorkerFactory = new CacheWorkerFactory(2, this.log, this.storageAccess);
        this.readAndDeserialize();
    }

    public synchronized boolean registerService(Object object, String string) {
        if (this.isKnownServiceID(string)) {
            CacheWorker cacheWorker = this.getWorker(string);
            cacheWorker.setService(object);
            return true;
        }
        return false;
    }

    public synchronized CacheWorker getWorker(String string) {
        CacheWorker cacheWorker = (CacheWorker)this.serviceID2worker.get(string);
        if (cacheWorker == null) {
            cacheWorker = this.cacheWorkerFactory.createWorker(string);
            this.serviceID2worker.put(string, cacheWorker);
            this.serializeAndWrite();
        }
        return cacheWorker;
    }

    public boolean isKnownServiceID(String string) {
        return "service_dsi_onlinetraffic".equals(string) || "service_dsi_satellitemaps".equals(string) || "ebnav".equals(string) || "awnavicore".equals(string) || "weatherinmaponlineservice".equals(string) || "service_dsi_poi".equals(string) || "service_dsi_presetlayout".equals(string) || "service_dsi_destimport".equals(string) || "dictation".equals(string) || "service_dsi_operatorcall".equals(string) || "hotspotwlan".equals(string) || "service_core".equals(string) || "online_metadata_service_app".equals(string) || "UpdateOverTheAir".equals(string);
    }

    @Override
    protected void handleCRC32Error() {
        this.log.log(-1601830656, "CacheHandlerImpl.handleCRC32Error()");
    }

    @Override
    protected synchronized void handleStorageReadError(Exception exception) {
        this.log.log(-1601830656, "CacheHandlerImpl.handleStorageReadError(): %1, setting default values", (Throwable)exception);
        this.restoreDefaultValues();
        this.serializeAndWrite();
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.log.log(10000, "CacheHandlerImpl.convertContainer (%1, %2, ...): restore default values", (long)n, (long)n2);
        if (n == 1 && n2 == 2) {
            try {
                this.deserializeV1(dataInputStream);
            }
            catch (IOException iOException) {
                this.restoreDefaultValues();
            }
        } else {
            this.restoreDefaultValues();
        }
    }

    private void restoreDefaultValues() {
        this.serviceID2worker.clear();
        String string = "service_dsi_onlinetraffic";
        CacheWorker cacheWorker = this.cacheWorkerFactory.createWorker(string);
        this.serviceID2worker.put(string, cacheWorker);
        cacheWorker.readAndDeserialize();
        string = "service_dsi_satellitemaps";
        CacheWorker cacheWorker2 = this.cacheWorkerFactory.createWorker(string);
        this.serviceID2worker.put(string, cacheWorker2);
        cacheWorker2.readAndDeserialize();
        string = "ebnav";
        CacheWorker cacheWorker3 = this.cacheWorkerFactory.createWorker(string);
        this.serviceID2worker.put(string, cacheWorker3);
        cacheWorker3.readAndDeserialize();
        string = "awnavicore";
        CacheWorker cacheWorker4 = this.cacheWorkerFactory.createWorker(string);
        this.serviceID2worker.put(string, cacheWorker4);
        cacheWorker4.readAndDeserialize();
        string = "weatherinmaponlineservice";
        CacheWorker cacheWorker5 = this.cacheWorkerFactory.createWorker(string);
        this.serviceID2worker.put(string, cacheWorker5);
        cacheWorker5.readAndDeserialize();
        string = "service_dsi_poi";
        CacheWorker cacheWorker6 = this.cacheWorkerFactory.createWorker(string);
        this.serviceID2worker.put(string, cacheWorker6);
        cacheWorker6.readAndDeserialize();
        string = "service_dsi_presetlayout";
        CacheWorker cacheWorker7 = this.cacheWorkerFactory.createWorker(string);
        this.serviceID2worker.put(string, cacheWorker7);
        cacheWorker7.readAndDeserialize();
        string = "service_dsi_destimport";
        CacheWorker cacheWorker8 = this.cacheWorkerFactory.createWorker(string);
        this.serviceID2worker.put(string, cacheWorker8);
        cacheWorker8.readAndDeserialize();
        string = "dictation";
        CacheWorker cacheWorker9 = this.cacheWorkerFactory.createWorker(string);
        this.serviceID2worker.put(string, cacheWorker9);
        cacheWorker9.readAndDeserialize();
        string = "service_dsi_operatorcall";
        CacheWorker cacheWorker10 = this.cacheWorkerFactory.createWorker(string);
        this.serviceID2worker.put(string, cacheWorker10);
        cacheWorker10.readAndDeserialize();
        string = "hotspotwlan";
        CacheWorker cacheWorker11 = this.cacheWorkerFactory.createWorker(string);
        this.serviceID2worker.put(string, cacheWorker11);
        cacheWorker11.readAndDeserialize();
        string = "service_core";
        CacheWorker cacheWorker12 = this.cacheWorkerFactory.createWorker(string);
        this.serviceID2worker.put(string, cacheWorker12);
        cacheWorker12.readAndDeserialize();
        string = "online_metadata_service_app";
        CacheWorker cacheWorker13 = this.cacheWorkerFactory.createWorker(string);
        this.serviceID2worker.put(string, cacheWorker13);
        cacheWorker13.readAndDeserialize();
        string = "UpdateOverTheAir";
        CacheWorker cacheWorker14 = this.cacheWorkerFactory.createWorker(string);
        this.serviceID2worker.put(string, cacheWorker14);
        cacheWorker14.readAndDeserialize();
    }

    @Override
    protected synchronized void serialize(DataOutputStream dataOutputStream) {
        this.log.log(1078071040, "CacheHandlerImpl.serialize()");
        Set set = this.serviceID2worker.keySet();
        dataOutputStream.writeInt(set.size());
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            CacheWorker cacheWorker = (CacheWorker)this.serviceID2worker.get(iterator.next());
            dataOutputStream.writeUTF(cacheWorker.getServiceID());
        }
    }

    @Override
    protected synchronized void deserialize(DataInputStream dataInputStream) {
        this.log.log(1078071040, "CacheHandlerImpl.deserialize()");
        int n = dataInputStream.readInt();
        this.serviceID2worker.clear();
        for (int i2 = 0; i2 < n; ++i2) {
            String string = dataInputStream.readUTF();
            CacheWorker cacheWorker = this.cacheWorkerFactory.createWorker(string);
            this.serviceID2worker.put(string, cacheWorker);
            cacheWorker.readAndDeserialize();
        }
    }

    protected synchronized void deserializeV1(DataInputStream dataInputStream) {
        this.log.log(1078071040, "CacheHandlerImpl.deserializeV1()");
        int n = dataInputStream.readInt();
        this.serviceID2worker.clear();
        for (int i2 = 0; i2 < n; ++i2) {
            String string = dataInputStream.readUTF();
            CacheWorker cacheWorker = this.cacheWorkerFactory.createWorker(string);
            this.serviceID2worker.put(string, cacheWorker);
            cacheWorker.readAndDeserialize();
        }
    }

    @Override
    public synchronized void addListener(CacheEventListener cacheEventListener) {
        if (cacheEventListener == null) {
            return;
        }
        String[] stringArray = null;
        try {
            stringArray = cacheEventListener.getServiceIDs();
        }
        catch (Exception exception) {
            this.log.log(10000, "CacheEventListener.getServiceIDs() callback error: %1", (Throwable)exception);
        }
        if (stringArray != null) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (!this.isKnownServiceID(stringArray[i2])) continue;
                CacheWorker cacheWorker = this.getWorker(stringArray[i2]);
                cacheWorker.addListener(cacheEventListener);
            }
        }
    }

    @Override
    public synchronized void removeListener(CacheEventListener cacheEventListener) {
        if (cacheEventListener == null) {
            return;
        }
        String[] stringArray = null;
        try {
            stringArray = cacheEventListener.getServiceIDs();
        }
        catch (Exception exception) {
            this.log.log(10000, "CacheEventListener.getServiceIDs() callback error: %1", (Throwable)exception);
        }
        if (stringArray != null) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                CacheWorker cacheWorker = (CacheWorker)this.serviceID2worker.get(stringArray[i2]);
                if (cacheWorker == null) continue;
                cacheWorker.removeListener(cacheEventListener);
            }
        }
    }

    @Override
    public synchronized Object getState(String string, String string2) {
        CacheWorker cacheWorker = (CacheWorker)this.serviceID2worker.get(string);
        if (cacheWorker != null) {
            return cacheWorker.getState(string2);
        }
        return new Integer(-1);
    }
}

