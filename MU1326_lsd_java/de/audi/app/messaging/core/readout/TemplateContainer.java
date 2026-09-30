/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.util.Maps;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Map;

public final class TemplateContainer {
    private final Map templateMap = new HashMap();

    public synchronized void put(Object object, String string) {
        if (object == null || string == null) {
            throw new IllegalArgumentException("Arguments must not be null.");
        }
        if (this.templateMap.containsKey(object)) {
            throw new IllegalArgumentException("Cannot add another item with key: " + object);
        }
        this.templateMap.put(object, string);
    }

    public synchronized String getTemplate(Object object) {
        return (String)this.templateMap.get(object);
    }

    public synchronized void clear() {
        this.templateMap.clear();
    }

    public synchronized String toString() {
        Buffer buffer = new Buffer(4096);
        buffer.append("TemplateContainer {templateMap = ");
        buffer.append(Maps.toMultiLineString(this.templateMap));
        buffer.append('}');
        return buffer.toString();
    }
}

