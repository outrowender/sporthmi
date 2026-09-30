/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.keyevents;

import de.audi.app.terminalmode.util.Enum;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class KeyState
extends Enum<KeyState> {
    public static final KeyState PRESSED = new KeyState("PRESSED");
    public static final KeyState LONGPRESSED = new KeyState("LONGPRESSED");
    public static final KeyState RELEASED = new KeyState("RELEASED");
    static /* synthetic */ Class class$de$audi$app$terminalmode$keyevents$KeyState;

    private KeyState(String string) {
        super(string);
    }

    public static KeyState valueOf(String string) throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException {
        return (KeyState)(class$de$audi$app$terminalmode$keyevents$KeyState == null ? (class$de$audi$app$terminalmode$keyevents$KeyState = KeyState.class$("de.audi.app.terminalmode.keyevents.KeyState")) : class$de$audi$app$terminalmode$keyevents$KeyState).getField(string).get(null);
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

