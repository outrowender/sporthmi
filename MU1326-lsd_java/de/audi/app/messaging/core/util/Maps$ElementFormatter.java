/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.util;

import de.audi.app.messaging.core.util.IFormatter;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Map$Entry;

public class Maps$ElementFormatter
implements IFormatter {
    private final IFormatter keyFormatter;
    private final IFormatter valueFormatter;

    public Maps$ElementFormatter(IFormatter iFormatter, IFormatter iFormatter2) {
        this.keyFormatter = iFormatter;
        this.valueFormatter = iFormatter2;
    }

    @Override
    public String format(Object object) {
        Buffer buffer = new Buffer();
        Map$Entry map$Entry = (Map$Entry)object;
        String string = this.keyFormatter.format(map$Entry.getKey());
        String string2 = this.valueFormatter.format(map$Entry.getValue());
        buffer.append(string);
        buffer.append(" -> ");
        buffer.append(string2);
        return buffer.toString();
    }
}

