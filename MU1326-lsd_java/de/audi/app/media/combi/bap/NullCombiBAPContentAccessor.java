/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.combi.bap.CombiBAPMediaEntry;
import de.audi.app.media.combi.bap.ICombiBAPContentAccessor;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.i18n.I18NString;
import org.dsi.ifc.global.ResourceLocator;

public class NullCombiBAPContentAccessor
implements ICombiBAPContentAccessor {
    @Override
    public void updateCurrentPlayingTrack(int n, long l, int n2, int n3, I18NString i18NString, I18NString i18NString2, I18NString i18NString3, I18NString i18NString4, boolean bl, int n4, ResourceLocator resourceLocator) {
    }

    @Override
    public void updateActiveRepeatScope(int n, boolean bl) {
    }

    @Override
    public void updateBrowseFolder(MediaListEntry[] mediaListEntryArray, int n) {
    }

    @Override
    public void updateListSize(int n) {
    }

    @Override
    public void updateListState(boolean bl, int n) {
    }

    @Override
    public void contentAdapterStartupFinished() {
    }

    @Override
    public void gotoCurrentPlayingTrackResult(boolean bl) {
    }

    @Override
    public void gotoParentFolderResult(boolean bl) {
    }

    @Override
    public void gotoRootFolderResult(boolean bl) {
    }

    @Override
    public void gotoSubFolderResult(boolean bl) {
    }

    @Override
    public void responseList(int n, int n2, int n3, MediaListEntry[] mediaListEntryArray) {
    }

    @Override
    public void getNextListPosResult(boolean bl, CombiBAPMediaEntry combiBAPMediaEntry, CombiBAPMediaEntry combiBAPMediaEntry2, int n) {
    }

    @Override
    public void selectListEntryResult(boolean bl) {
    }

    @Override
    public void updateSeekState(boolean bl) {
    }

    @Override
    public void updatePlaybackFolder(boolean bl) {
    }

    @Override
    public void changeActiveSourceMediaType(int n) {
    }

    @Override
    public void updateActiveFileplayerPlaybackType(int n) {
    }

    @Override
    public void updateOnlineMusicState(int n, int n2, int n3) {
    }

    @Override
    public void trackChangeIsComing() {
    }

    @Override
    public void updatePlayPosition(PlayTime playTime) {
    }
}

