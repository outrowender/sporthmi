/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.HMITerminalEAL;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;

public class StringUtilityEAL
extends StringUtility {
    private IWrappedFont currentFont;

    public StringUtilityEAL(HMITerminalImpl hMITerminalImpl) {
        super(hMITerminalImpl);
    }

    @Override
    public int getCharWidth(char c2) {
        return this.getStringWidth(String.valueOf(c2));
    }

    @Override
    public int getStringWidth(String string) {
        return ((HMITerminalEAL)((Object)this.terminal)).getEALManager().getTextWidth(string, this.currentFont);
    }

    @Override
    protected int getStringWidth(char[] cArray, int n, int n2) {
        String string = String.valueOf(cArray, n, n2);
        return this.getStringWidth(string);
    }

    @Override
    protected int getFontBaseline() {
        return EALManager.getFontHeightUppercase(this.currentFont);
    }

    public void setCurrentFont(IWrappedFont iWrappedFont) {
        this.currentFont = iWrappedFont;
    }
}

