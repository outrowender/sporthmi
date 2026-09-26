/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.dvdvideo;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.evo.content.dvdvideo.DVDVideoPlayerPlayViewListRow;
import de.audi.app.media.evo.content.dvdvideo.DVDVideoPlayerViewList;

class DVDVideoPlayerViewList$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ DVDVideoPlayerPlayViewListRow val$selectedRow;
    private final /* synthetic */ DVDVideoPlayerViewList this$0;

    DVDVideoPlayerViewList$1(DVDVideoPlayerViewList dVDVideoPlayerViewList, String string, DVDVideoPlayerPlayViewListRow dVDVideoPlayerPlayViewListRow) {
        this.this$0 = dVDVideoPlayerViewList;
        this.val$selectedRow = dVDVideoPlayerPlayViewListRow;
        super(string);
    }

    @Override
    public void run() {
        PlayingTrack playingTrack = DVDVideoPlayerViewList.access$000(this.this$0).getCurrentPlayingTrack();
        if (playingTrack.getEntryID() != this.val$selectedRow.getEntryID()) {
            DVDVideoPlayerViewList.access$100(this.this$0);
            DVDVideoPlayerViewList.access$200(this.this$0, this.val$selectedRow.getEntryID());
            DVDVideoPlayerViewList.access$000(this.this$0).playEntry(this.val$selectedRow.getEntryID());
        } else {
            this.this$0.getTerminal().getAudioManager().resumeAudio(true);
        }
        DVDVideoPlayerViewList.access$300(this.this$0);
    }
}

