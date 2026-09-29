/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.boardbook;

import de.audi.app.car.core.boardbook.BoardbookHandler;
import de.audi.atip.mmicombi.IViewSizeListener;

class BoardbookHandler$ViewSizeHelper
implements IViewSizeListener {
    private final /* synthetic */ BoardbookHandler this$0;

    BoardbookHandler$ViewSizeHelper(BoardbookHandler boardbookHandler) {
        this.this$0 = boardbookHandler;
    }

    @Override
    public void viewSizeChanged(int n) {
        this.this$0.logChannel.log(1078071040, "BoardbookHandler#ViewSizeListener#viewSizeChanged() to %1", (long)n);
        if (BoardbookHandler.access$000(this.this$0) == null) {
            return;
        }
        if (n == 1) {
            this.this$0.logChannel.log(-2137614336, "BoardbookHandler#viewSizeChanged to SMALL. Session paused");
            BoardbookHandler.access$000(this.this$0).pause();
        } else if (n == 2) {
            this.this$0.logChannel.log(-2137614336, "BoardbookHandler#viewSizeChanged to LARGE and Session isPaused: resuming");
            BoardbookHandler.access$000(this.this$0).resume();
        }
    }
}

