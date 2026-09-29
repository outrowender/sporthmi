/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.tuner.app.sdars.seek.MusicHandler;
import de.audi.tuner.app.sdars.seek.MusicHandler$1;
import de.audi.tuner.app.sdars.seek.MusicHandler$MusicSeekRow;

class MusicHandler$MusicSeekListControllerButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ MusicHandler this$0;

    private MusicHandler$MusicSeekListControllerButtonListener(MusicHandler musicHandler) {
        this.this$0 = musicHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 100699: {
                this.setAllEntriesMarked(true);
                break;
            }
            case 100697: {
                this.setAllEntriesMarked(false);
                break;
            }
            case 100698: {
                this.deleteMarkedEntries();
                break;
            }
        }
    }

    private void setAllEntriesMarked(boolean bl) {
        BaseListModelApp baseListModelApp = MusicHandler.access$1300(this.this$0);
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            MusicHandler$MusicSeekRow musicHandler$MusicSeekRow = (MusicHandler$MusicSeekRow)baseListModelApp.getRow(i2);
            MusicHandler.access$1412(this.this$0, musicHandler$MusicSeekRow.setMarkingCheckboxSelected(bl));
            baseListModelApp.setRow(i2, musicHandler$MusicSeekRow);
        }
        MusicHandler.access$1500(this.this$0);
    }

    private void deleteMarkedEntries() {
        BaseListModelApp baseListModelApp = MusicHandler.access$1300(this.this$0);
        int[] nArray = new int[baseListModelApp.getLength()];
        int n = 0;
        int n2 = baseListModelApp.getLength();
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            MusicHandler$MusicSeekRow musicHandler$MusicSeekRow = (MusicHandler$MusicSeekRow)baseListModelApp.getRow(i2);
            if (!musicHandler$MusicSeekRow.isMarkingCheckboxSelected()) continue;
            nArray[n++] = musicHandler$MusicSeekRow.getSeekID();
        }
        int[] nArray2 = new int[n];
        System.arraycopy((Object)nArray, 0, (Object)nArray2, 0, n);
        MusicHandler.access$1600(this.this$0, nArray2);
        if (n2 == n) {
            baseListModelApp.fireEvent(0);
            MusicHandler.access$1700(this.this$0).showPartialPopup(4);
        }
    }

    /* synthetic */ MusicHandler$MusicSeekListControllerButtonListener(MusicHandler musicHandler, MusicHandler$1 musicHandler$1) {
        this(musicHandler);
    }
}

