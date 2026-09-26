/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.IReadable;
import de.audi.app.messaging.core.util.Strings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class Readable
implements IReadable {
    private final Iterator speakTaskIterator;

    public Readable(List list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List of tasks is empty.");
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (!(object instanceof String)) {
                throw new IllegalArgumentException(new StringBuffer().append("List element is not a string: ").append(object).toString());
            }
            String string = (String)object;
            if (Strings.isNullOrEmpty(string)) {
                throw new IllegalArgumentException(new StringBuffer().append("List element is null or the empty string: ").append(string).toString());
            }
            arrayList.add(string);
        }
        this.speakTaskIterator = arrayList.iterator();
    }

    public Readable(String string) {
        if (Strings.isNullOrEmpty(string)) {
            throw new IllegalArgumentException("Argument is null or empty.");
        }
        this.speakTaskIterator = Arrays.asList(new String[]{string}).iterator();
    }

    public Readable(String string, String string2) {
        if (Strings.isNullOrEmpty(string) || Strings.isNullOrEmpty(string2)) {
            throw new IllegalArgumentException("Argument is null or empty.");
        }
        this.speakTaskIterator = Arrays.asList(new String[]{string, string2}).iterator();
    }

    @Override
    public boolean hasNextSpeakTask() {
        return this.speakTaskIterator.hasNext();
    }

    @Override
    public String nextSpeakTask() {
        return (String)this.speakTaskIterator.next();
    }
}

