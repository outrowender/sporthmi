/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.evo.content.data.DataPlayerPlayViewList;
import de.audi.app.media.evo.content.data.DataPlayerPlayViewListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.update.ModelTrigger;

class DataPlayerPlayViewList$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ DataPlayerPlayViewListRow val$selectedRow;
    private final /* synthetic */ DataPlayerPlayViewList this$0;

    DataPlayerPlayViewList$1(DataPlayerPlayViewList dataPlayerPlayViewList, String string, DataPlayerPlayViewListRow dataPlayerPlayViewListRow) {
        this.this$0 = dataPlayerPlayViewList;
        this.val$selectedRow = dataPlayerPlayViewListRow;
        super(string);
    }

    @Override
    public void run() {
        if (!DataPlayerPlayViewList.access$000(this.this$0).isActive()) {
            return;
        }
        PlayingTrack playingTrack = DataPlayerPlayViewList.access$000(this.this$0).getCurrentPlayingTrack();
        SelectedItem selectedItem = this.this$0.getPlayViewListModel().getSelected();
        if (null == selectedItem) {
            DataPlayerPlayViewList.access$100(this.this$0).log(1078071040, "[%1.itemSelected] currentPlayingTrack=%2, selectedTrack=%3", (Object)"DataPlayerPlayViewList", (Object)playingTrack, (Object)this.val$selectedRow);
        }
        if (playingTrack.getEntryID() != this.val$selectedRow.getEntryID() && (null == selectedItem || selectedItem.getUniqueID() != this.val$selectedRow.getUniqueID())) {
            DataPlayerPlayViewList.access$200(this.this$0).log(1078071040, "[%1.itemSelected] New track selected.", (Object)"DataPlayerPlayViewList");
            DataPlayerPlayViewList.access$300(this.this$0, this.val$selectedRow.getEntryID());
            DataPlayerPlayViewList.access$000(this.this$0).playEntry(this.val$selectedRow.getEntryID(), this.val$selectedRow.getTitle(), this.val$selectedRow.isVideo());
        } else {
            DataPlayerPlayViewList.access$400(this.this$0).log(1078071040, "[%1.itemSelected] Playing track selected.", (Object)"DataPlayerPlayViewList");
            this.this$0.getTerminal().getAudioManager().resumeAudio(true);
            if (this.val$selectedRow.isAudio() && DataPlayerPlayViewList.access$500(this.this$0) && playingTrack.getEntryID() == this.val$selectedRow.getEntryID()) {
                this.this$0.getPlayViewListModel().trigger(ModelTrigger.ACTIVATE_NOW_PLAYING);
            }
        }
        if (this.val$selectedRow.isVideo()) {
            DataPlayerPlayViewList.access$600(this.this$0);
        }
    }
}

