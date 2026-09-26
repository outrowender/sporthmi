/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.statemachine;

import de.audi.atip.utils.statemachine.Handler$1;
import de.audi.atip.utils.statemachine.Handler$IMessageCodeToStringConverter;

class Handler$DefaulftConverter
implements Handler$IMessageCodeToStringConverter {
    private Handler$DefaulftConverter() {
    }

    @Override
    public String messageCodeToString(int n) {
        return Integer.toString(n);
    }

    /* synthetic */ Handler$DefaulftConverter(Handler$1 handler$1) {
        this();
    }
}

