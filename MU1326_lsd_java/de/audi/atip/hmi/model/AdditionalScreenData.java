/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AdditionalScreenData {
    public static final int CURSOR_POSITION = 1;
    public static final int STAY_ON_FOCUSED_ELEMENT = 2;
    private HashMap data = new HashMap();

    public void addData(int n, Object object) {
        if (object == null) {
            throw new NullPointerException("data in AdditionalScreenData#addData cannot be null");
        }
        this.data.put(new Integer(n), object);
    }

    public Object getData(int n) {
        return this.data.get(new Integer(n));
    }

    public String toString() {
        Buffer buffer = new Buffer(60);
        buffer.append("AdditionalScreenData(");
        try {
            Iterator iterator = this.data.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry)iterator.next();
                buffer.append("(key: ").append(entry.getKey()).append(", value:").append(entry.getValue()).append(")");
            }
        }
        catch (Exception exception) {
            buffer.append("exception occured");
        }
        buffer.append(")");
        return buffer.toString();
    }
}

