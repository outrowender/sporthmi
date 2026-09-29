/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.dsi.carplay.AbstractDSICarplayEnum;

public class SiriAction
extends AbstractDSICarplayEnum {
    public static final SiriAction SIRIACTION_PREWARM = new SiriAction(0, "SIRIACTION_PREWARM");
    public static final SiriAction SIRIACTION_STOP = new SiriAction(2, "SIRIACTION_STOP");
    public static final SiriAction SIRIACTION_START = new SiriAction(1, "SIRIACTION_START");

    protected SiriAction(int n, String string) {
        super(n, string);
    }
}

