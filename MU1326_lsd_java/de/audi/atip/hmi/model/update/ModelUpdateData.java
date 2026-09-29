/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.update;

import de.audi.atip.hmi.model.update.ModelUpdateData$Key;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Map;

public class ModelUpdateData {
    private final Map map = new HashMap();
    private final int updateType;

    public static ModelUpdateData obtain(int n) {
        return new ModelUpdateData(n);
    }

    ModelUpdateData(int n) {
        this.updateType = n;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("Model update data ");
        buffer.append(this.map.toString());
        return buffer.toString();
    }

    public int getUpdateType() {
        return this.updateType;
    }

    public ModelUpdateData put(ModelUpdateData$Key modelUpdateData$Key, Object object) {
        this.map.put(modelUpdateData$Key, object);
        return this;
    }

    public ModelUpdateData put(ModelUpdateData$Key modelUpdateData$Key, int n) {
        this.map.put(modelUpdateData$Key, Util.createInteger(n));
        return this;
    }

    public ModelUpdateData put(ModelUpdateData$Key modelUpdateData$Key, long l) {
        this.map.put(modelUpdateData$Key, Util.createLong(l));
        return this;
    }

    public boolean contains(ModelUpdateData$Key modelUpdateData$Key) {
        return this.map.containsKey(modelUpdateData$Key);
    }

    public Object get(ModelUpdateData$Key modelUpdateData$Key) {
        return this.map.get(modelUpdateData$Key);
    }

    public int getInt(ModelUpdateData$Key modelUpdateData$Key) {
        return (Integer)this.map.get(modelUpdateData$Key);
    }

    public long getLong(ModelUpdateData$Key modelUpdateData$Key) {
        return (Long)this.map.get(modelUpdateData$Key);
    }

    public int size() {
        return this.map.size();
    }

    public ModelUpdateData$Key[] getKeys() {
        return (ModelUpdateData$Key[])this.map.keySet().toArray(new ModelUpdateData$Key[this.map.size()]);
    }
}

