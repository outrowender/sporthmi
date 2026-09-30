/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.persistence;

import de.audi.app.media.actionproxy.ActionProxyDispatcherImpl;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.persistence.IMediaPersistence;
import de.audi.app.media.persistence.MediaPersistenceStorageData;
import de.audi.app.media.persistence.MediaStorage;
import de.audi.app.media.persistence.PersistenceKeyInt;
import de.audi.app.media.persistence.PersistenceKeyString;
import de.audi.app.media.persistence.PersistentData;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import java.util.HashMap;

public class MediaPersistenceImpl
implements IMediaPersistence {
    private static final String LOGCLASS = "MediaPersistenceImpl";
    private final LogChannel logger;
    private final MediaStorage mediaStorage;
    private final HashMap registeredKeys;
    private final MediaPersistenceStorageData mediaPersistenceStorageData;

    public MediaPersistenceImpl(IMediaLogger iMediaLogger, IStorageAccess iStorageAccess, ActionProxyDispatcherImpl actionProxyDispatcherImpl) {
        this.logger = iMediaLogger.main();
        this.mediaStorage = new MediaStorage(iMediaLogger, iStorageAccess, actionProxyDispatcherImpl);
        this.registeredKeys = new HashMap();
        this.mediaPersistenceStorageData = new MediaPersistenceStorageData(iMediaLogger, iStorageAccess);
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.mediaPersistenceStorageData.init();
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.mediaPersistenceStorageData.deinit();
    }

    public void setGlobalStringProperty(String string, String string2) {
        this.logger.log(1000000, "[%1.setGlobalStringProperty] key='%2' value='%3'", (Object)LOGCLASS, (Object)string, (Object)string2);
        PersistenceKeyString persistenceKeyString = (PersistenceKeyString)this.registeredKeys.get(string);
        if (null == persistenceKeyString) {
            this.logger.log(10000, "[%1.setGlobalStringProperty] Key '%2' is not registered.", (Object)LOGCLASS, (Object)string);
            return;
        }
        if (persistenceKeyString.isDirectAccess()) {
            this.mediaStorage.persistString(persistenceKeyString.getDirectAccessKey(), string2);
        } else {
            this.mediaPersistenceStorageData.put(string, new PersistentData(string2));
        }
    }

    public void setGlobalIntProperty(String string, int n) {
        this.logger.log(1000000, "[%1.setGlobalIntProperty] key='%2' value='%3'", (Object)LOGCLASS, (Object)string, (Object)String.valueOf(n));
        PersistenceKeyInt persistenceKeyInt = (PersistenceKeyInt)this.registeredKeys.get(string);
        if (null == persistenceKeyInt) {
            this.logger.log(10000, "[%1.setGlobalIntProperty] Key '%2' not registered.", (Object)LOGCLASS, (Object)string);
            return;
        }
        if (persistenceKeyInt.isDirectAccess()) {
            this.mediaStorage.persist(persistenceKeyInt.getDirectAccessKey(), n);
        } else {
            this.mediaPersistenceStorageData.put(string, new PersistentData(n));
        }
    }

    public String getGlobalStringProperty(String string) {
        this.logger.log(1000000, "[%1.getGlobalStringProperty] key='%2'", (Object)LOGCLASS, (Object)string);
        PersistenceKeyString persistenceKeyString = (PersistenceKeyString)this.registeredKeys.get(string);
        if (null == persistenceKeyString) {
            this.logger.log(10000, "[%1.getGlobalStringProperty] Key '%2' is not registered.", (Object)LOGCLASS, (Object)string);
            return "";
        }
        if (persistenceKeyString.isDirectAccess()) {
            return this.mediaStorage.loadString(persistenceKeyString.getDirectAccessKey(), persistenceKeyString.getDefaultValue());
        }
        return this.getStringValue(string, persistenceKeyString);
    }

    public int getGlobalIntProperty(String string) {
        if ("GLOBAL_KEY_DVDV_REGIONCODE_CHANGES_LEFT".equals(string)) {
            return this.mediaStorage.getRegionCodeChangesLeft();
        }
        this.logger.log(1000000, "[%1.getGlobalIntProperty] key='%2'", (Object)LOGCLASS, (Object)string);
        PersistenceKeyInt persistenceKeyInt = (PersistenceKeyInt)this.registeredKeys.get(string);
        if (null == persistenceKeyInt) {
            this.logger.log(10000, "[%1.getGlobalIntProperty] Key '%2' not registered.", (Object)LOGCLASS, (Object)string);
            return -1;
        }
        if (persistenceKeyInt.isDirectAccess()) {
            return this.mediaStorage.load(persistenceKeyInt.getDirectAccessKey(), persistenceKeyInt.getDefaultValue(), persistenceKeyInt.getMinValue(), persistenceKeyInt.getMaxValue());
        }
        return this.getIntValue(string);
    }

    private String getStringValue(String string, PersistenceKeyString persistenceKeyString) {
        this.logger.log(1000000, "[%1.getStringKey]", (Object)LOGCLASS);
        PersistentData persistentData = this.mediaPersistenceStorageData.get(string);
        if (null == persistentData || null == persistentData.getString(persistenceKeyString.getDefaultValue())) {
            this.logger.log(1000000, "[%1.getIntKey] No stored value for '%2'", (Object)LOGCLASS, (Object)string);
            return persistenceKeyString.getDefaultValue();
        }
        return persistentData.getString(persistenceKeyString.getDefaultValue());
    }

    private int getIntValue(String string) {
        PersistenceKeyInt persistenceKeyInt = (PersistenceKeyInt)this.registeredKeys.get(string);
        if (null == persistenceKeyInt) {
            this.logger.log(10000, "[%1.getIntKey] Key '%2' not registered.", (Object)LOGCLASS, (Object)string);
            return -1;
        }
        PersistentData persistentData = this.mediaPersistenceStorageData.get(string);
        if (null == persistentData) {
            this.logger.log(1000000, "[%1.getIntKey] No stored value for '%2'", (Object)LOGCLASS, (Object)string);
            return persistenceKeyInt.getDefaultValue();
        }
        int n = persistentData.getInt(persistenceKeyInt.getDefaultValue());
        if (n < persistenceKeyInt.getMinValue() || n > persistenceKeyInt.getMaxValue()) {
            this.logger.log(100000, "[MediaPersistenceImpl.getIntValue] Key '%1' out of valid range [%2,%3] -> %4.", (Object)string, (Object)new Integer(persistenceKeyInt.getMinValue()), (Object)new Integer(persistenceKeyInt.getMaxValue()), (Object)new Integer(persistenceKeyInt.getDefaultValue()));
            return persistenceKeyInt.getDefaultValue();
        }
        return n;
    }

    private int getStorageKey(String string) {
        this.logger.log(10000000, "[%1.getStorageKey]", (Object)LOGCLASS);
        if ("GLOBAL_KEY_DVDV_PM_LEVEL".equals(string)) {
            return 29;
        }
        if ("GLOBAL_KEY_DVDV_PM_PASSWORD".equals(string)) {
            return 19;
        }
        if ("GLOBAL_KEY_LAST_ACTIVE_SOURCE".equals(string)) {
            return 210;
        }
        if ("GLOBAL_KEY_LAST_ACTIVE_SLOT".equals(string)) {
            return 200;
        }
        if ("GLOBAL_KEY_IOS_AUTOSTART".equals(string)) {
            return 600;
        }
        this.logger.log(10000000, "[%1.getStorageKey] directkey for '%2' not found.", (Object)LOGCLASS, (Object)string);
        return -1;
    }

    public void setLocalProperty(int n, ISourceSlot iSourceSlot, int n2, Object object) {
    }

    public Object getLocalProperty(int n, ISourceSlot iSourceSlot, int n2, Object object) {
        return null;
    }

    public MediaStorage getStorage() {
        return this.mediaStorage;
    }

    public void registerIntProperty(String string, int n, int n2, int n3) {
        this.logger.log(1000000, "[%1.registerIntProperty] key='%2'", (Object)LOGCLASS, (Object)string);
        this.registeredKeys.put(string, new PersistenceKeyInt(this.getStorageKey(string), n, n2, n3));
    }

    public void registerStringProperty(String string, String string2) {
        this.logger.log(1000000, "[%1.registerStringProperty] key='%2'", (Object)LOGCLASS, (Object)string);
        this.registeredKeys.put(string, new PersistenceKeyString(this.getStorageKey(string), string2));
    }
}

