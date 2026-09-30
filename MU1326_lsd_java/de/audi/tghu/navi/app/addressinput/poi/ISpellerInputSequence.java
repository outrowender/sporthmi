/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi;

import de.audi.tghu.navi.app.addressinput.IPreviewMapHandler;
import org.dsi.ifc.navigation.LIValueListElement;

public interface ISpellerInputSequence
extends IPreviewMapHandler {
    public void start();

    public void requestNextResultListWindow(int var1, int var2, int var3);

    public void requestNextResultListWindow(int var1);

    public void requestPreviousResultListWindow(int var1);

    public void selectListElement(LIValueListElement var1);

    public void setInput(String var1);

    public void unrequestItems(int var1, int var2);
}

