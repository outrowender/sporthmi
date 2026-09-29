/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

final class MultilineTextFieldController$OpEvent
extends ATIPEvent {
    final int iValue;
    final char cValue;
    final String sValue;
    final int type;

    MultilineTextFieldController$OpEvent(ATIPEventListener aTIPEventListener, int n, int n2) {
        super(aTIPEventListener, 19901);
        this.iValue = n;
        this.cValue = '\u0000';
        this.sValue = null;
        this.type = n2;
    }

    MultilineTextFieldController$OpEvent(ATIPEventListener aTIPEventListener, char c2, int n) {
        super(aTIPEventListener, 19901);
        this.iValue = 0;
        this.cValue = c2;
        this.sValue = null;
        this.type = n;
    }

    MultilineTextFieldController$OpEvent(ATIPEventListener aTIPEventListener, String string, int n) {
        super(aTIPEventListener, 19901);
        this.iValue = 0;
        this.cValue = '\u0000';
        this.sValue = string;
        this.type = n;
    }

    public String toString() {
        return new StringBuffer().append("OpEvent [iValue=").append(this.iValue).append(", cValue=").append(this.cValue).append(", sValue=").append(this.sValue).append(", type=").append(this.type).append("]").toString();
    }
}

