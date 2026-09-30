/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.combi.bap.CombiBAPMediaEntry;
import de.audi.app.media.combi.bap.ICombiBAPContentAccessor;
import de.audi.app.media.content.IContent;
import de.audi.app.media.source.ISourceSlot;

public interface ICombiBAPContentAdapter {
    public void init();

    public void deinit();

    public void activate(IContent var1, ICombiBAPContentAccessor var2);

    public void deactivate();

    public boolean skip(boolean var1, int var2);

    public boolean setRepeatScope(int var1, boolean var2);

    public void gotoCurrentPlayingTrack();

    public void gotoParentFolder();

    public void gotoRootFolder();

    public void gotoSubFolder(CombiBAPMediaEntry var1);

    public void requestListByIndex(int var1, int var2, int var3);

    public void requestListByEntryID(int var1, CombiBAPMediaEntry var2, int var3);

    public void getNextListPos(CombiBAPMediaEntry var1, int var2);

    public void selectListEntry(CombiBAPMediaEntry var1);

    public void startSeek(boolean var1);

    public void stopSeek();

    public int getCurrentRepeatScope();

    public boolean isMixActive();

    public void updateActiveSlot(ISourceSlot var1);
}

