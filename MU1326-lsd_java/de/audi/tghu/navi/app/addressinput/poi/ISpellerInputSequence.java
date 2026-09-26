/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi;

import de.audi.tghu.navi.app.addressinput.IPreviewMapHandler;
import org.dsi.ifc.navigation.LIValueListElement;

public interface ISpellerInputSequence
extends IPreviewMapHandler {
    default public void start() {
    }

    default public void requestNextResultListWindow(int n, int n2, int n3) {
    }

    default public void requestNextResultListWindow(int n) {
    }

    default public void requestPreviousResultListWindow(int n) {
    }

    default public void selectListElement(LIValueListElement lIValueListElement) {
    }

    default public void setInput(String string) {
    }

    default public void unrequestItems(int n, int n2) {
    }
}

