/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.menu.focus;

public class FocusAdvice {
    public static final FocusAdvice KEEP_POSITION = new FocusAdvice("KeepPosition");
    public static final FocusAdvice VIEWPORT_FIRST_POSITION = new FocusAdvice("FirstPosition");
    public static final FocusAdvice VIEWPORT_SECOND_POSITION = new FocusAdvice("SecondPosition");
    public static final FocusAdvice VIEWPORT_LAST_POSITION = new FocusAdvice("LastPosition");
    private final String name;

    protected FocusAdvice(String string) {
        this.name = string;
    }

    public final String getName() {
        return this.name;
    }

    public String toString() {
        return this.getClass().getName() + "#" + this.name;
    }
}

