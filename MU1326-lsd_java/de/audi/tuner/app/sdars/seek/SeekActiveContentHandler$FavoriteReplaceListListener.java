/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.sdars.seek.MusicHandler$MusicSeekRow;
import de.audi.tuner.app.sdars.seek.SeekActiveContentHandler;
import de.audi.tuner.app.sdars.seek.SeekActiveContentHandler$1;
import de.audi.tuner.app.sdars.seek.SelectedTeamRow;

class SeekActiveContentHandler$FavoriteReplaceListListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ SeekActiveContentHandler this$0;

    private SeekActiveContentHandler$FavoriteReplaceListListener(SeekActiveContentHandler seekActiveContentHandler) {
        this.this$0 = seekActiveContentHandler;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        SeekActiveContentHandler.access$800(this.this$0).getBaseListModel(-1903623936).setSelectedIndex(n2);
        SeekActiveContentHandler.access$800(this.this$0).getBaseListModel(-1903623936).fireEvent(n4);
        SeekActiveContentHandler.access$700(this.this$0).hidePartialPopup(19);
        SeekActiveContentHandler.access$700(this.this$0).hidePartialPopup(20);
        if (SeekActiveContentHandler.access$1600(this.this$0) != null) {
            if (SeekActiveContentHandler.access$1600(this.this$0).getTypeOfContent() == 1) {
                MusicHandler$MusicSeekRow musicHandler$MusicSeekRow = (MusicHandler$MusicSeekRow)evoListRow;
                SeekActiveContentHandler.access$1400(this.this$0).manageSeek2(1, musicHandler$MusicSeekRow.getSeekID(), -1, 3);
                SeekActiveContentHandler.access$700(this.this$0).showPartialPopup(SeekActiveContentHandler.access$1200(this.this$0));
            } else if (SeekActiveContentHandler.access$1600(this.this$0).getTypeOfContent() == 3) {
                SelectedTeamRow selectedTeamRow = (SelectedTeamRow)evoListRow;
                SeekActiveContentHandler.access$1400(this.this$0).manageSeek2(3, selectedTeamRow.getTeamID(), selectedTeamRow.getLeagueId(), 3);
                SeekActiveContentHandler.access$700(this.this$0).showPartialPopup(15);
            }
            SeekActiveContentHandler.access$1602(this.this$0, null);
        }
    }

    /* synthetic */ SeekActiveContentHandler$FavoriteReplaceListListener(SeekActiveContentHandler seekActiveContentHandler, SeekActiveContentHandler$1 seekActiveContentHandler$1) {
        this(seekActiveContentHandler);
    }
}

