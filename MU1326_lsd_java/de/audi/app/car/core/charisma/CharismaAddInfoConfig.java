/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;

public class CharismaAddInfoConfig {
    static final int PERSISTENCE_NAMESPACE;
    private static final int INVISIBLE;
    private static final int VISIBLE;
    public static final int ADD_INFO_COMPASS;
    public static final int ADD_INFO_GPS;
    public static final int ADD_INFO_HEIGHT;
    public static final int ADD_INFO_STEERING_ANGLE;
    public static final int ADD_INFO_LONGITUDINAL_TILT;
    public static final int ADD_INFO_LATERAL_TILT;
    private static final int[] STORAGE_KEYS;
    private final LogChannel logChannel;
    private final IStorageAccess storage;
    private int persistenceKey;
    private final int id;
    private final ChoiceModelApp availableModel;

    public CharismaAddInfoConfig(LogChannel logChannel, IStorageAccess iStorageAccess, int n, ChoiceModelApp choiceModelApp) {
        this.logChannel = logChannel;
        this.storage = iStorageAccess;
        this.persistenceKey = STORAGE_KEYS[n];
        this.id = n;
        this.availableModel = choiceModelApp;
    }

    public boolean readPersistentAdditionalInfo() {
        if (this.storage != null) {
            return this.storage.getBoolean(1006, this.persistenceKey, false);
        }
        return false;
    }

    public void writePersistentAdditionalInfo(boolean bl) {
        if (this.storage != null) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1078071040, "[CharismaAddInfoConfig(Namespace.CAR , persistenceKey='%1')#writePersistentAdditionalInfo] persist '%2':", (Object)new Integer(this.getPersistenceKey()), (Object)(bl ? "true" : "false"));
            }
            this.storage.setBoolean(1006, this.getPersistenceKey(), bl);
        }
    }

    private LogChannel getLogChannel() {
        return this.logChannel;
    }

    public int getPersistenceKey() {
        return this.persistenceKey;
    }

    public void setVisible(boolean bl) {
        this.availableModel.setValue(bl ? 1 : 0);
    }

    public int getId() {
        return this.id;
    }

    static {
        STORAGE_KEYS = new int[]{31, 30, 32, 33, 117, 118};
    }
}

