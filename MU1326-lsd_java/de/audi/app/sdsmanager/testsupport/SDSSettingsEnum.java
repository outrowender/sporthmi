/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.testsupport;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.testsupport.ISDSSettingEnumStateListener;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class SDSSettingsEnum {
    public static final SDSSettingsEnum VBI = new SDSSettingsEnum("Voice Barge-In (VBI)", SDSModelAccess.isVoiceBargeInActive());
    public static final SDSSettingsEnum NLU = new SDSSettingsEnum("Nat. Lang. Understanding (NLU/SLM)", SDSModelAccess.getNLUActiveModelValue());
    private static final String BASE_NAME;
    private static Map indexToEnumMap;
    private final String name;
    private volatile boolean activationStatus;
    private final Object activationStatusMutex = new Object();
    private static final LogChannel LC;
    private final Set sdsSettingStateListeners = new HashSet();

    private SDSSettingsEnum(String string, boolean bl) {
        if (indexToEnumMap == null) {
            indexToEnumMap = new HashMap();
        }
        this.name = string;
        this.activationStatus = bl;
        indexToEnumMap.put(new Integer(indexToEnumMap.size()), this);
    }

    public boolean isActive() {
        return this.activationStatus;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean setActivationStatus(boolean bl) {
        Object object = this.activationStatusMutex;
        synchronized (object) {
            if (this.activationStatus == bl) {
                return false;
            }
            this.activationStatus = bl;
        }
        this.updateSDSSettingStateListeners();
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void updateSDSSettingStateListeners() {
        Set set = this.sdsSettingStateListeners;
        synchronized (set) {
            Iterator iterator = this.sdsSettingStateListeners.iterator();
            while (iterator.hasNext()) {
                ISDSSettingEnumStateListener iSDSSettingEnumStateListener = (ISDSSettingEnumStateListener)iterator.next();
                if (iSDSSettingEnumStateListener == null) {
                    LC.log(-1601830656, "SDSSettingsEnum#updateSDSSettingStateListeners: Listener is null => NOP!");
                    continue;
                }
                iSDSSettingEnumStateListener.updateSDSSettingsEnumState(this);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean registerSDSSettingStateListener(ISDSSettingEnumStateListener iSDSSettingEnumStateListener) {
        boolean bl;
        if (iSDSSettingEnumStateListener == null) {
            LC.log(10000, "SDSSettingsEnum#registerSDSSettingStateListener: Listener is null!");
            return false;
        }
        Set set = this.sdsSettingStateListeners;
        synchronized (set) {
            bl = this.sdsSettingStateListeners.add(iSDSSettingEnumStateListener);
        }
        if (bl) {
            LC.log(-2137614336, "SDSSettingsEnum#registerSDSSettingStateListener: Listener %1 added!", (Object)super.getClass().getName());
        } else {
            LC.log(-1601830656, "SDSSettingsEnum#registerSDSSettingStateListener: Listener %1 already contained!", (Object)super.getClass().getName());
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean unregisterSDSSettingStateListener(ISDSSettingEnumStateListener iSDSSettingEnumStateListener) {
        boolean bl;
        if (iSDSSettingEnumStateListener == null) {
            LC.log(10000, "SDSSettingsEnum#unregisterSDSSettingStateListener: Listener is null!");
            return false;
        }
        Set set = this.sdsSettingStateListeners;
        synchronized (set) {
            bl = this.sdsSettingStateListeners.remove(iSDSSettingEnumStateListener);
        }
        if (bl) {
            LC.log(-2137614336, "SDSSettingsEnum#unregisterSDSSettingStateListener: Listener %1 removed!", (Object)super.getClass().getName());
        } else {
            LC.log(-1601830656, "SDSSettingsEnum#unregisterSDSSettingStateListener: Listener %1 was not contained!", (Object)super.getClass().getName());
        }
        return bl;
    }

    static SDSSettingsEnum getSDSSettingByIndex(int n) {
        return (SDSSettingsEnum)indexToEnumMap.get(new Integer(n));
    }

    static int getChannelsSize() {
        return indexToEnumMap.size();
    }

    void toggleActivationStatus() {
        this.setActivationStatus(!this.activationStatus);
    }

    String getChannelName() {
        return this.name;
    }

    public String toString() {
        return new Buffer().append("SDSSetting-").append(this.name).toString();
    }

    static {
        LC = Logger.getMainLog();
    }
}

