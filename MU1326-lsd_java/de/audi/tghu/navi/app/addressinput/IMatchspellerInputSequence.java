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
    default public void start(boolean bl) {
    }

    default public void requestNextResultListWindow(int n, int n2) {
    }

    default public void requestPreviousResultListWindow(int n) {
    }

    default public void addCharacter(String string) {
    }

    default public void addCharacter(String string, int n, boolean bl) {
    }

    default public void undoCharacter() {
    }

    default public void deleteAllCharacters() {
    }

    default public void selectListElement(LIValueListElement lIValueListElement, boolean bl) {
    }

    default public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement, boolean bl) {
    }

    default public void selectElementByIdentifier(String string) {
    }

    default public void unrequestItems(int n, int n2) {
    }
}

