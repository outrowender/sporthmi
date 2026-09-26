/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.storagecache;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.storagecache.CacheWorker;
import de.audi.tghu.storagecache.OnlineServiceCacheWorker;
import de.audi.tghu.storagecache.PresetLayoutCacheWorker;

public class CacheWorkerFactory {
    private int version = 1;
    private LogChannel log;
    private IStorageAccess storageAccess;

    public CacheWorkerFactory(int n, LogChannel logChannel, IStorageAccess iStorageAccess) {
        this.version = n;
        this.log = logChannel;
        this.storageAccess = iStorageAccess;
    }

    public CacheWorker createWorker(String string) {
        if ("service_dsi_onlinetraffic".equals(string)) {
            return new OnlineServiceCacheWorker(this.log, this.storageAccess, this.version, 256, 130, string);
        }
        if ("service_dsi_satellitemaps".equals(string)) {
            return new OnlineServiceCacheWorker(this.log, this.storageAccess, this.version, 256, 120, string);
        }
        if ("ebnav".equals(string)) {
            return new OnlineServiceCacheWorker(this.log, this.storageAccess, this.version, 256, 260, string);
        }
        if ("awnavicore".equals(string)) {
            return new OnlineServiceCacheWorker(this.log, this.storageAccess, this.version, 256, 260, string);
        }
        if ("weatherinmaponlineservice".equals(string)) {
            return new OnlineServiceCacheWorker(this.log, this.storageAccess, this.version, 256, 110, string);
        }
        if ("service_dsi_poi".equals(string)) {
            return new OnlineServiceCacheWorker(this.log, this.storageAccess, this.version, 256, 140, string);
        }
        if ("service_dsi_presetlayout".equals(string)) {
            return new PresetLayoutCacheWorker(this.log, this.storageAccess, this.version, 256, 150, string);
        }
        if ("service_dsi_destimport".equals(string)) {
            return new OnlineServiceCacheWorker(this.log, this.storageAccess, this.version, 256, 170, string);
        }
        if ("dictation".equals(string)) {
            return new OnlineServiceCacheWorker(this.log, this.storageAccess, this.version, 256, 180, string);
        }
        if ("service_dsi_operatorcall".equals(string)) {
            return new OnlineServiceCacheWorker(this.log, this.storageAccess, this.version, 256, 190, string);
        }
        if ("hotspotwlan".equals(string)) {
            return new OnlineServiceCacheWorker(this.log, this.storageAccess, this.version, 256, 200, string);
        }
        if ("service_core".equals(string)) {
            return new OnlineServiceCacheWorker(this.log, this.storageAccess, this.version, 256, 210, string);
        }
        if ("online_metadata_service_app".equals(string)) {
            return new OnlineServiceCacheWorker(this.log, this.storageAccess, this.version, 256, 230, string);
        }
        if ("UpdateOverTheAir".equals(string)) {
            return new OnlineServiceCacheWorker(this.log, this.storageAccess, this.version, 256, 240, string);
        }
        return null;
    }
}

