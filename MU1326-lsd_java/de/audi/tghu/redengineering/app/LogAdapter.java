/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.redengineering.app;

import de.audi.atip.log.ISLOGSink;
import de.audi.atip.log.IStandardConsoleLogSink;
import de.audi.atip.log.ITraceClientLogSink;
import de.audi.atip.log.LogSink;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.redengineering.app.EngineeringEnv;
import de.audi.tghu.redengineering.app.LogAdapter$LogAdapterHMIHandler;
import de.audi.tghu.redengineering.app.LogAdapter$LogChannelCategory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogAdapter {
    private final LogAdapter$LogAdapterHMIHandler hmi;
    private LogSink activeSink;
    private Map cats;
    private LogSink[] logSinks;
    private Map backupConfig;
    private final EngineeringEnv engineeringEnv;

    public LogAdapter(EngineeringEnv engineeringEnv) {
        this.engineeringEnv = engineeringEnv;
        this.hmi = new LogAdapter$LogAdapterHMIHandler(this, this, engineeringEnv);
        this.logSinks = this.getLogSinks();
        for (int i2 = 0; i2 < this.logSinks.length; ++i2) {
            if (!(this.logSinks[i2] instanceof IStandardConsoleLogSink)) continue;
            this.activeSink = this.logSinks[i2];
            break;
        }
    }

    private final EngineeringEnv getEngineeringEnv() {
        return this.engineeringEnv;
    }

    void storeEngState(int n) {
        IStorageAccess iStorageAccess = this.getEngineeringEnv().getStorageMgr();
        if (iStorageAccess != null) {
            iStorageAccess.setInt(262, 10, n);
        }
    }

    private Map getLogChannels() {
        return this.getEngineeringEnv().getLogChannelAdmin().getAvailableChannels();
    }

    private LogSink[] getLogSinks() {
        List list = this.getEngineeringEnv().getLogChannelAdmin().getAllLogSinks();
        return (LogSink[])list.toArray(new LogSink[0]);
    }

    private Map getLogChannelCategories() {
        if (this.cats == null) {
            Map map = this.getLogChannels();
            String[] stringArray = (String[])map.keySet().toArray(new String[0]);
            HashMap hashMap = new HashMap(map.size());
            if (stringArray != null) {
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    LogAdapter$LogChannelCategory logAdapter$LogChannelCategory;
                    int n;
                    int n2;
                    if (stringArray[i2] == null || (n2 = stringArray[i2].indexOf(46, (n = stringArray[i2].indexOf(46)) + 1)) == -1) continue;
                    String string = stringArray[i2].substring(0, n2);
                    if (!hashMap.containsKey(string)) {
                        logAdapter$LogChannelCategory = new LogAdapter$LogChannelCategory(null);
                        logAdapter$LogChannelCategory.addChannel(stringArray[i2]);
                        hashMap.put(string, logAdapter$LogChannelCategory);
                        continue;
                    }
                    logAdapter$LogChannelCategory = (LogAdapter$LogChannelCategory)hashMap.get(string);
                    logAdapter$LogChannelCategory.addChannel(stringArray[i2]);
                }
            }
            this.cats = hashMap;
        }
        return this.cats;
    }

    private void setLogSinkSelction(int n) {
        if (this.logSinks == null) {
            this.logSinks = this.getLogSinks();
        }
        block0 : switch (n) {
            case 0: {
                for (int i2 = 0; i2 < this.logSinks.length; ++i2) {
                    if (!(this.logSinks[i2] instanceof IStandardConsoleLogSink)) continue;
                    this.activeSink = this.logSinks[i2];
                    break block0;
                }
                break;
            }
            case 1: {
                for (int i3 = 0; i3 < this.logSinks.length; ++i3) {
                    if (!(this.logSinks[i3] instanceof ITraceClientLogSink)) continue;
                    this.activeSink = this.logSinks[i3];
                    break block0;
                }
                break;
            }
            case 2: {
                for (int i4 = 0; i4 < this.logSinks.length; ++i4) {
                    if (!(this.logSinks[i4] instanceof ISLOGSink)) continue;
                    this.activeSink = this.logSinks[i4];
                    break block0;
                }
                break;
            }
        }
    }

    private void switchOperationState(boolean bl) {
        if (this.activeSink != null) {
            if (bl) {
                if (this.backupConfig != null) {
                    this.activeSink.setConfiguration(this.backupConfig);
                }
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("all", new Integer(0));
                this.backupConfig = this.activeSink.getConfiguration();
                this.activeSink.setConfiguration(hashMap);
            }
        }
    }

    private void removeAllFlag(Map map) {
        if (map.containsKey("all")) {
            map.remove("all");
        }
    }

    private void enableChannel(String string) {
        Map map = this.activeSink.getConfiguration();
        this.removeAllFlag(map);
        if (map.containsKey(string)) {
            map.remove(string);
        }
        map.put(string, new Integer(14808325));
        this.activeSink.setConfiguration(map);
        this.hmi.setOperationStateChoice(1);
    }

    private void disableChannel(String string) {
        Map map = this.activeSink.getConfiguration();
        if (map.containsKey(string)) {
            map.remove(string);
        }
        this.activeSink.setConfiguration(map);
    }

    private void enableCategory(String string) {
        LogAdapter$LogChannelCategory logAdapter$LogChannelCategory = (LogAdapter$LogChannelCategory)this.getLogChannelCategories().get(string);
        if (logAdapter$LogChannelCategory != null) {
            String[] stringArray = logAdapter$LogChannelCategory.getLogChannels();
            Map map = this.activeSink.getConfiguration();
            this.removeAllFlag(map);
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (map.containsKey(stringArray[i2])) {
                    map.remove(stringArray[i2]);
                }
                map.put(stringArray[i2], new Integer(14808325));
            }
            this.activeSink.setConfiguration(map);
            this.hmi.setOperationStateChoice(1);
        }
    }

    private void disableCategory(String string) {
        LogAdapter$LogChannelCategory logAdapter$LogChannelCategory = (LogAdapter$LogChannelCategory)this.getLogChannelCategories().get(string);
        if (logAdapter$LogChannelCategory != null) {
            String[] stringArray = logAdapter$LogChannelCategory.getLogChannels();
            Map map = this.activeSink.getConfiguration();
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (!map.containsKey(stringArray[i2])) continue;
                map.remove(stringArray[i2]);
            }
            this.activeSink.setConfiguration(map);
        }
    }

    static /* synthetic */ void access$000(LogAdapter logAdapter, int n) {
        logAdapter.setLogSinkSelction(n);
    }

    static /* synthetic */ void access$100(LogAdapter logAdapter, boolean bl) {
        logAdapter.switchOperationState(bl);
    }

    static /* synthetic */ void access$200(LogAdapter logAdapter, String string) {
        logAdapter.enableCategory(string);
    }

    static /* synthetic */ void access$300(LogAdapter logAdapter, String string) {
        logAdapter.disableCategory(string);
    }

    static /* synthetic */ void access$400(LogAdapter logAdapter, String string) {
        logAdapter.enableChannel(string);
    }

    static /* synthetic */ void access$500(LogAdapter logAdapter, String string) {
        logAdapter.disableChannel(string);
    }

    static /* synthetic */ Map access$600(LogAdapter logAdapter) {
        return logAdapter.getLogChannelCategories();
    }

    static /* synthetic */ Map access$700(LogAdapter logAdapter) {
        return logAdapter.getLogChannels();
    }
}

