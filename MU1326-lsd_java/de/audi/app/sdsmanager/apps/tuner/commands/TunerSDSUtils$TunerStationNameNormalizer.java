/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.tuner.commands;

import de.audi.app.sdsmanager.apps.tuner.commands.TunerSDSUtils$1;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashSet;
import java.util.Set;

class TunerSDSUtils$TunerStationNameNormalizer {
    private final Set delChars = new HashSet();

    private TunerSDSUtils$TunerStationNameNormalizer() {
        this.delChars.add(new Character('_'));
        this.delChars.add(new Character('-'));
        this.delChars.add(new Character(' '));
    }

    private String normalize(String string) {
        if (SDSUtils.isEmpty(string)) {
            return "";
        }
        String string2 = string.toLowerCase().trim();
        Buffer buffer = new Buffer();
        int n = string2.length();
        for (int i2 = 0; i2 < n; ++i2) {
            char c2 = string2.charAt(i2);
            if (this.delChars.contains(new Character(c2))) continue;
            buffer.append(c2);
        }
        return buffer.toString();
    }

    /* synthetic */ TunerSDSUtils$TunerStationNameNormalizer(TunerSDSUtils$1 tunerSDSUtils$1) {
        this();
    }

    static /* synthetic */ String access$100(TunerSDSUtils$TunerStationNameNormalizer tunerSDSUtils$TunerStationNameNormalizer, String string) {
        return tunerSDSUtils$TunerStationNameNormalizer.normalize(string);
    }
}

