/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.cdda;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.evo.content.cdda.CDDAPlayerPlayViewList;
import de.audi.app.media.evo.content.cdda.CDDAPlayerPlayViewListRow;
import de.audi.atip.hmi.model.update.ModelTrigger;

class CDDAPlayerPlayViewList$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ CDDAPlayerPlayViewListRow val$row;
    private final /* synthetic */ CDDAPlayerPlayViewList this$0;

    CDDAPlayerPlayViewList$1(CDDAPlayerPlayViewList cDDAPlayerPlayViewList, String string, CDDAPlayerPlayViewListRow cDDAPlayerPlayViewListRow) {
        this.this$0 = cDDAPlayerPlayViewList;
        this.val$row = cDDAPlayerPlayViewListRow;
        super(string);
    }

    @Override
    public void run() {
        PlayingTrack playingTrack = CDDAPlayerPlayViewList.access$000(this.this$0).getCurrentPlayingTrack();
        if (playingTrack.getEntryID() != this.val$row.getEntryID()) {
            CDDAPlayerPlayViewList.access$100(this.this$0, this.val$row.getEntryID());
            CDDAPlayerPlayViewList.access$000(this.this$0).playEntry(this.val$row.getEntryID(), this.val$row.getTitle());
        } else {
            this.this$0.getTerminal().getAudioManager().resumeAudio(true);
            if (CDDAPlayerPlayViewList.access$200(this.this$0)) {
                this.this$0.getPlayViewListModel().trigger(ModelTrigger.ACTIVATE_NOW_PLAYING);
            }
        }
    }
}

