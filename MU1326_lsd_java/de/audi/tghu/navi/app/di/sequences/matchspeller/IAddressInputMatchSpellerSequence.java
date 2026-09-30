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
    public static final int WINDOWSIZE_DEFAULT = -1;
    public static final int WINDOWSIZE_FAST = 5;

    public CommandList getStartCommandList(String var1);

    public void requestNextResultListWindow(int var1, int var2);

    public void requestPreviousResultListWindow(int var1);

    public void addCharacter(String var1);

    public void addCharacter(String var1, int var2, boolean var3);

    public void undoCharacter();

    public void deleteAllCharacters();

    public void unrequestItems(int var1, int var2);

    public void showLocationInPreviewMap(IPreviewMap var1, LIValueListElement var2);

    public void hidePreviewMap(IPreviewMap var1);
}

