/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.awtce.jpstr.JapaneseStringConversion
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter;

import de.awtce.jpstr.JapaneseStringConversion;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.CharacterConverter;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.ICharacterConverter;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.IFreetextConverter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class HiraganaConverter
extends CharacterConverter
implements ICharacterConverter {
    private static final JapaneseStringConversion japaneseStringConversion = new JapaneseStringConversion();

    HiraganaConverter() {
        super(new IFreetextConverter(){
            List kanjis = Collections.EMPTY_LIST;

            public List getPossibleConversions(String string, int n) {
                if (string == null || string.length() == 0 || n <= 0) {
                    this.kanjis = Collections.EMPTY_LIST;
                } else {
                    this.kanjis = Arrays.asList(japaneseStringConversion.transcode(string));
                    if (this.kanjis.size() > n) {
                        Object[] objectArray = new String[n];
                        System.arraycopy((Object)this.kanjis.toArray(), 0, (Object)objectArray, 0, n);
                        this.kanjis = Arrays.asList(objectArray);
                    }
                }
                return this.kanjis;
            }

            public int getNumberOfConversions() {
                return this.kanjis.size();
            }

            public String getValidCharacters(String string) {
                return null;
            }
        });
    }
}

