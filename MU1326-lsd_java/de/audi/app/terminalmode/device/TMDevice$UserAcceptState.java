/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.util.Enum;

public class TMDevice$UserAcceptState
extends Enum {
    public static final TMDevice$UserAcceptState INITIAL = new TMDevice$UserAcceptState("INITIAL");
    public static final TMDevice$UserAcceptState TM_SELECTED = new TMDevice$UserAcceptState("TM_SELECTED");
    public static final TMDevice$UserAcceptState NATIVE_SELECTED = new TMDevice$UserAcceptState("NATIVE_SELECTED");
    public static final TMDevice$UserAcceptState DISCLAIMER_ACCEPTED = new TMDevice$UserAcceptState("DISCLAIMER_ACCEPTED");
    public static final TMDevice$UserAcceptState NATIVE = new TMDevice$UserAcceptState("NATIVE");

    private TMDevice$UserAcceptState(String string) {
        super(string);
    }

    public static TMDevice$UserAcceptState valueOf(String string) {
        return (TMDevice$UserAcceptState)(TMDevice.class$de$audi$app$terminalmode$device$TMDevice$UserAcceptState == null ? (TMDevice.class$de$audi$app$terminalmode$device$TMDevice$UserAcceptState = TMDevice.class$("de.audi.app.terminalmode.device.TMDevice$UserAcceptState")) : TMDevice.class$de$audi$app$terminalmode$device$TMDevice$UserAcceptState).getField(string).get(null);
    }
}

