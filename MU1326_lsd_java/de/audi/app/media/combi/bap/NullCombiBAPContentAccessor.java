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
    public void updateCurrentPlayingTrack(int n, long l, int n2, int n3, I18NString i18NString, I18NString i18NString2, I18NString i18NString3, I18NString i18NString4, boolean bl, int n4, ResourceLocator resourceLocator) {
    }

    public void updateActiveRepeatScope(int n, boolean bl) {
    }

    public void updateBrowseFolder(MediaListEntry[] mediaListEntryArray, int n) {
    }

    public void updateListSize(int n) {
    }

    public void updateListState(boolean bl, int n) {
    }

    public void contentAdapterStartupFinished() {
    }

    public void gotoCurrentPlayingTrackResult(boolean bl) {
    }

    public void gotoParentFolderResult(boolean bl) {
    }

    public void gotoRootFolderResult(boolean bl) {
    }

    public void gotoSubFolderResult(boolean bl) {
    }

    public void responseList(int n, int n2, int n3, MediaListEntry[] mediaListEntryArray) {
    }

    public void getNextListPosResult(boolean bl, CombiBAPMediaEntry combiBAPMediaEntry, CombiBAPMediaEntry combiBAPMediaEntry2, int n) {
    }

    public void selectListEntryResult(boolean bl) {
    }

    public void updateSeekState(boolean bl) {
    }

    public void updatePlaybackFolder(boolean bl) {
    }

    public void changeActiveSourceMediaType(int n) {
    }

    public void updateActiveFileplayerPlaybackType(int n) {
    }

    public void updateOnlineMusicState(int n, int n2, int n3) {
    }

    public void trackChangeIsComing() {
    }

    public void updatePlayPosition(PlayTime playTime) {
    }
}

