/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.combi.bap.CombiBAPMediaEntry;
import de.audi.app.media.combi.bap.ICombiBAPContentAccessor;
import de.audi.app.media.content.IContent;
import de.audi.app.media.source.ISourceSlot;

public interface ICombiBAPContentAdapter {
    default public void init() {
    }

    default public void deinit() {
    }

    default public void activate(IContent iContent, ICombiBAPContentAccessor iCombiBAPContentAccessor) {
    }

    default public void deactivate() {
    }

    default public boolean skip(boolean bl, int n) {
    }

    default public boolean setRepeatScope(int n, boolean bl) {
    }

    default public void gotoCurrentPlayingTrack() {
    }

    default public void gotoParentFolder() {
    }

    default public void gotoRootFolder() {
    }

    default public void gotoSubFolder(CombiBAPMediaEntry combiBAPMediaEntry) {
    }

    default public void requestListByIndex(int n, int n2, int n3) {
    }

    default public void requestListByEntryID(int n, CombiBAPMediaEntry combiBAPMediaEntry, int n2) {
    }

    default public void getNextListPos(CombiBAPMediaEntry combiBAPMediaEntry, int n) {
    }

    default public void selectListEntry(CombiBAPMediaEntry combiBAPMediaEntry) {
    }

    default public void startSeek(boolean bl) {
    }

    default public void stopSeek() {
    }

    default public int getCurrentRepeatScope() {
    }

    default public boolean isMixActive() {
    }

    default public void updateActiveSlot(ISourceSlot iSourceSlot) {
    }
}

