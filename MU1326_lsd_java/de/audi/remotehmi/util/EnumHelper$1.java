/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.util;

import de.audi.remotehmi.util.EnumHelper;
import de.audi.remotehmi.util.EnumParser;

class EnumHelper$1
implements EnumParser {
    private final /* synthetic */ EnumHelper this$0;

    EnumHelper$1(EnumHelper enumHelper) {
        this.this$0 = enumHelper;
    }

    @Override
    public Object parse(String string) {
        return this.parse(string, null);
    }

    @Override
    public Object parse(String string, Object object) {
        if (string == null) {
            return object;
        }
        Object object2 = EnumHelper.access$000(this.this$0).get(string);
        if (object2 == null) {
            return object;
        }
        return object2;
    }
}

