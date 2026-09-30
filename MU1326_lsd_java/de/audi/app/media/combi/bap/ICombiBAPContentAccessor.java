/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.combi.bap.CombiBAPMediaEntry;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.i18n.I18NString;
import org.dsi.ifc.global.ResourceLocator;

public interface ICombiBAPContentAccessor {
    public static final int LIST_STATE_COMPLETELY_LOADED = 1;
    public static final int LIST_STATE_INCOMPLETE_LOADED = 2;
    public static final int LIST_STATE_LOADING = 3;
    public static final int LIST_STATE_UNKNOW = 4;
    public static final int FILEPLAYER_RINGTONE = 0;
    public static final int FILEPLAYER_BOARDBOOK = 1;

    public void updateCurrentPlayingTrack(int var1, long var2, int var4, int var5, I18NString var6, I18NString var7, I18NString var8, I18NString var9, boolean var10, int var11, ResourceLocator var12);

    public void updateActiveRepeatScope(int var1, boolean var2);

    public void updateBrowseFolder(MediaListEntry[] var1, int var2);

    public void updateListSize(int var1);

    public void updateListState(boolean var1, int var2);

    public void contentAdapterStartupFinished();

    public void updateActiveFileplayerPlaybackType(int var1);

    public void gotoCurrentPlayingTrackResult(boolean var1);

    public void gotoParentFolderResult(boolean var1);

    public void gotoRootFolderResult(boolean var1);

    public void gotoSubFolderResult(boolean var1);

    public void updatePlaybackFolder(boolean var1);

    public void responseList(int var1, int var2, int var3, MediaListEntry[] var4);

    public void getNextListPosResult(boolean var1, CombiBAPMediaEntry var2, CombiBAPMediaEntry var3, int var4);

    public void selectListEntryResult(boolean var1);

    public void updateSeekState(boolean var1);

    public void changeActiveSourceMediaType(int var1);

    public void updateOnlineMusicState(int var1, int var2, int var3);

    public void trackChangeIsComing();

    public void updatePlayPosition(PlayTime var1);
}

