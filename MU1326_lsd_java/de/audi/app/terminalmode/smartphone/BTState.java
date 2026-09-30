/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone;

import de.audi.app.terminalmode.util.Enum;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class BTState
extends Enum<BTState> {
    public static final BTState UNKNOWN = new BTState("UNKNOWN");
    public static final BTState OFF = new BTState("OFF");
    public static final BTState ON = new BTState("ON");

    private BTState(String string) {
        super(string);
    }
}

