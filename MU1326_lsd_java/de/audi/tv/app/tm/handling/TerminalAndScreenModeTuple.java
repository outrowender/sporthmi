/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm.handling;

import de.audi.atip.utils.generics.Function;
import de.audi.atip.utils.reactive.observables.Observables$Combinator;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeTuple$1;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeTuple$2;
import de.esolutions.fw.util.commons.Buffer;

public class TerminalAndScreenModeTuple {
    public static final Observables$Combinator TERMINALMODE_SCREENMODE_COMBINATOR = new TerminalAndScreenModeTuple$1();
    public static final Function EXTRACT_TERMINALMODE_FUNCTION = new TerminalAndScreenModeTuple$2();
    public final int terminalMode;
    public final int screenMode;
    static /* synthetic */ Class class$de$audi$tv$app$tm$handling$TerminalAndScreenModeTuple;

    public TerminalAndScreenModeTuple(int n, int n2) {
        this.terminalMode = n;
        this.screenMode = n2;
    }

    public int hashCode() {
        return this.terminalMode ^ this.screenMode;
    }

    public boolean equals(Object object) {
        if (object != null && object.getClass().equals(class$de$audi$tv$app$tm$handling$TerminalAndScreenModeTuple == null ? (class$de$audi$tv$app$tm$handling$TerminalAndScreenModeTuple = TerminalAndScreenModeTuple.class$("de.audi.tv.app.tm.handling.TerminalAndScreenModeTuple")) : class$de$audi$tv$app$tm$handling$TerminalAndScreenModeTuple)) {
            TerminalAndScreenModeTuple terminalAndScreenModeTuple = (TerminalAndScreenModeTuple)object;
            return this.terminalMode == terminalAndScreenModeTuple.terminalMode && this.screenMode == terminalAndScreenModeTuple.screenMode;
        }
        return false;
    }

    public String toString() {
        return new Buffer(16).append("tm ").append(this.terminalMode).append(" - sm ").append(this.screenMode).toString();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

