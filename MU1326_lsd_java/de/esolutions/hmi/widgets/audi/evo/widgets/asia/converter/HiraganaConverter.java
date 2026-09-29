/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.awtce.jpstr.JapaneseStringConversion
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter;

import de.awtce.jpstr.JapaneseStringConversion;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.CharacterConverter;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.HiraganaConverter$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.ICharacterConverter;

class HiraganaConverter
extends CharacterConverter
implements ICharacterConverter {
    private static final JapaneseStringConversion japaneseStringConversion = new JapaneseStringConversion();

    HiraganaConverter() {
        super(new HiraganaConverter$1());
    }

    static /* synthetic */ JapaneseStringConversion access$000() {
        return japaneseStringConversion;
    }
}

