/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.IPreviewMapHandler;
import de.audi.tghu.navi.app.addressinput.IRestorable;
import org.dsi.ifc.navigation.LIValueListElement;

public interface IMatchspellerInputSequence
extends IRestorable,
IPreviewMapHandler {
    public void start(boolean var1);

    public void requestNextResultListWindow(int var1, int var2);

    public void requestPreviousResultListWindow(int var1);

    public void addCharacter(String var1);

    public void addCharacter(String var1, int var2, boolean var3);

    public void undoCharacter();

    public void deleteAllCharacters();

    public void selectListElement(LIValueListElement var1, boolean var2);

    public CommandList getSelectListElementCommandList(LIValueListElement var1, boolean var2);

    public void selectElementByIdentifier(String var1);

    public void unrequestItems(int var1, int var2);
}

