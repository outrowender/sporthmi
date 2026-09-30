/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.update;

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

    public ModelUpdateData put(Key key, Object object) {
        this.map.put(key, object);
        return this;
    }

    public ModelUpdateData put(Key key, int n) {
        this.map.put(key, Util.createInteger(n));
        return this;
    }

    public ModelUpdateData put(Key key, long l) {
        this.map.put(key, Util.createLong(l));
        return this;
    }

    public boolean contains(Key key) {
        return this.map.containsKey(key);
    }

    public Object get(Key key) {
        return this.map.get(key);
    }

    public int getInt(Key key) {
        return (Integer)this.map.get(key);
    }

    public long getLong(Key key) {
        return (Long)this.map.get(key);
    }

    public int size() {
        return this.map.size();
    }

    public Key[] getKeys() {
        return (Key[])this.map.keySet().toArray(new Key[this.map.size()]);
    }

    public static class Key {
        public static final Key INDEX = new Key("KEY_INDEX");
        public static final Key UNIQUEID = new Key("KEY_UNIQUEID");
        public static final Key PARENT_UNIQUEID = new Key("KEY_PARENT_UNIQUEID");
        public static final Key REQUESTID = new Key("KEY_REQUESTID");
        public static final Key COUNT = new Key("KEY_COUNT");
        public static final Key ITEMID = new Key("KEY_ITEMID");
        public static final Key FOCUS_ADVICE = new Key("KEY_FOCUS_ADVICE");
        public static final Key TRIGGER = new Key("KEY_TRIGGER");
        private final String key;

        private Key(String string) {
            this.key = string;
        }

        public String toString() {
            return this.key;
        }
    }
}

