/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;

public interface IAddressInputAsiaSpecificSequence {
    public void addStroke(String var1);

    public void undoStroke();

    public void touchPadInputModeChanged(int var1);

    public void requestValidHanziCharsWindow(int var1, int var2, int var3);

    public void nonAlphaNumTPCharsChanged(int var1, int var2, String var3, MatchspellerModelApp var4);
}

