/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.di.sequences.IAddressInputSequence;
import org.dsi.ifc.navigation.LIValueListElement;

public interface IAddressInputMatchSpellerSequence
extends IAddressInputSequence {
    public static final int WINDOWSIZE_DEFAULT;
    public static final int WINDOWSIZE_FAST;

    default public CommandList getStartCommandList(String string) {
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

    default public void unrequestItems(int n, int n2) {
    }

    default public void showLocationInPreviewMap(IPreviewMap iPreviewMap, LIValueListElement lIValueListElement) {
    }

    default public void hidePreviewMap(IPreviewMap iPreviewMap) {
    }
}

