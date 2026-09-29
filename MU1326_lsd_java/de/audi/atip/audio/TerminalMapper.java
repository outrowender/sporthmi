/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.audio;

public final class TerminalMapper {
    public static final int OLD_CONN_LIMIT;

    public static int toAudioTerminal(int n) {
        switch (n) {
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                return 2;
            }
        }
        return 1;
    }

    public static int toHmiTerminal(int n) {
        switch (n) {
            case 0: 
            case 1: {
                return 0;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 2: {
                return 2;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Unknown audio terminal: ").append(n).toString());
    }

    private TerminalMapper() {
        throw new IllegalAccessError();
    }
}

