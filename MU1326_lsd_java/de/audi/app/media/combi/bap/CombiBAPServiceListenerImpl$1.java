/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.combi.bap.CombiBAPMediaEntry;
import de.audi.app.media.combi.bap.CombiBAPServiceListenerImpl;
import de.audi.app.media.combi.bap.ICombiBAPContentAdapter;
import de.audi.app.media.content.media.utils.MediaUtils;

class CombiBAPServiceListenerImpl$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$pCombiID;
    private final /* synthetic */ CombiBAPServiceListenerImpl this$0;

    CombiBAPServiceListenerImpl$1(CombiBAPServiceListenerImpl combiBAPServiceListenerImpl, String string, int n) {
        this.this$0 = combiBAPServiceListenerImpl;
        this.val$pCombiID = n;
        super(string);
    }

    @Override
    public void run() {
        CombiBAPServiceListenerImpl.access$000(this.this$0).log(1078071040, "[%1.selectListEntry] combiID='%2'", (Object)"CombiBAPServiceListenerImpl", (long)this.val$pCombiID);
        CombiBAPMediaEntry combiBAPMediaEntry = CombiBAPServiceListenerImpl.access$100(this.this$0).getIdMapper().getEntry(this.val$pCombiID);
        if (combiBAPMediaEntry == null) {
            CombiBAPServiceListenerImpl.access$000(this.this$0).log(-1601830656, "[%1.selectListEntry] No entryInfo found for ID '%2'.", (Object)"CombiBAPServiceListenerImpl", (long)this.val$pCombiID);
            CombiBAPServiceListenerImpl.access$100(this.this$0).selectListEntryResult(false);
            return;
        }
        ICombiBAPContentAdapter iCombiBAPContentAdapter = CombiBAPServiceListenerImpl.access$100(this.this$0).getActiveCombiContentAdapter();
        if (iCombiBAPContentAdapter == null) {
            CombiBAPServiceListenerImpl.access$000(this.this$0).log(1078071040, "[%1.setActiveSourceState] No content adapter active.", (Object)"CombiBAPServiceListenerImpl");
            CombiBAPServiceListenerImpl.access$100(this.this$0).selectListEntryResult(false);
            return;
        }
        if (!MediaUtils.isFileContentType(combiBAPMediaEntry.getEntryContentType())) {
            CombiBAPServiceListenerImpl.access$000(this.this$0).log(1078071040, "[%1.setActiveSourceState] No file selected.", (Object)"CombiBAPServiceListenerImpl");
            CombiBAPServiceListenerImpl.access$100(this.this$0).selectListEntryResult(false);
            return;
        }
        if (combiBAPMediaEntry.isCorrupt() || combiBAPMediaEntry.isDeadLink() || combiBAPMediaEntry.isImportPending() || combiBAPMediaEntry.isNoPlaybackDuringImport() || combiBAPMediaEntry.isProtected()) {
            CombiBAPServiceListenerImpl.access$000(this.this$0).log(1078071040, "[%1.setActiveSourceState] File not selectable.", (Object)"CombiBAPServiceListenerImpl");
            CombiBAPServiceListenerImpl.access$100(this.this$0).selectListEntryResult(false);
            return;
        }
        iCombiBAPContentAdapter.selectListEntry(combiBAPMediaEntry);
    }
}

