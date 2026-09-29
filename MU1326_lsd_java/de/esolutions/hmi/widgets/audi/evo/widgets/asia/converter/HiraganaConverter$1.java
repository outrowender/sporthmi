/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.HiraganaConverter;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.IFreetextConverter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class HiraganaConverter$1
implements IFreetextConverter {
    List kanjis = Collections.EMPTY_LIST;

    HiraganaConverter$1() {
    }

    @Override
    public List getPossibleConversions(String string, int n) {
        if (string == null || string.length() == 0 || n <= 0) {
            this.kanjis = Collections.EMPTY_LIST;
        } else {
            this.kanjis = Arrays.asList(HiraganaConverter.access$000().transcode(string));
            if (this.kanjis.size() > n) {
                Object[] objectArray = new String[n];
                System.arraycopy((Object)this.kanjis.toArray(), 0, (Object)objectArray, 0, n);
                this.kanjis = Arrays.asList(objectArray);
            }
        }
        return this.kanjis;
    }

    @Override
    public int getNumberOfConversions() {
        return this.kanjis.size();
    }

    @Override
    public String getValidCharacters(String string) {
        return null;
    }
}

