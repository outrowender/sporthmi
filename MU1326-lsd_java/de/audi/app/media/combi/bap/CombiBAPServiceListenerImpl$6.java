/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.combi.bap.CombiBAPMediaEntry;
import de.audi.app.media.combi.bap.CombiBAPServiceListenerImpl;
import de.audi.app.media.combi.bap.ICombiBAPContentAdapter;
import de.audi.app.media.content.media.utils.MediaUtils;

class CombiBAPServiceListenerImpl$6
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$pLocationType;
    private final /* synthetic */ int val$pCombiID;
    private final /* synthetic */ CombiBAPServiceListenerImpl this$0;

    CombiBAPServiceListenerImpl$6(CombiBAPServiceListenerImpl combiBAPServiceListenerImpl, String string, int n, int n2) {
        this.this$0 = combiBAPServiceListenerImpl;
        this.val$pLocationType = n;
        this.val$pCombiID = n2;
        super(string);
    }

    @Override
    public void run() {
        CombiBAPServiceListenerImpl.access$000(this.this$0).log(1078071040, "[%1.goTo] locationType='%2',combiID='%3'.", (Object)"CombiBAPServiceListenerImpl", (long)this.val$pLocationType, (long)this.val$pCombiID);
        ICombiBAPContentAdapter iCombiBAPContentAdapter = CombiBAPServiceListenerImpl.access$100(this.this$0).getActiveCombiContentAdapter();
        if (iCombiBAPContentAdapter == null) {
            CombiBAPServiceListenerImpl.access$000(this.this$0).log(1078071040, "[%1.goTo] No active combi content adapter.", (Object)"CombiBAPServiceListenerImpl");
            switch (this.val$pLocationType) {
                case 0: {
                    CombiBAPServiceListenerImpl.access$100(this.this$0).gotoCurrentPlayingTrackResult(false);
                    break;
                }
                case 2: {
                    CombiBAPServiceListenerImpl.access$100(this.this$0).gotoParentFolderResult(false);
                    break;
                }
                case 1: {
                    CombiBAPServiceListenerImpl.access$100(this.this$0).gotoRootFolderResult(false);
                    break;
                }
                case 4: {
                    CombiBAPServiceListenerImpl.access$100(this.this$0).gotoSubFolderResult(false);
                    break;
                }
            }
            return;
        }
        switch (this.val$pLocationType) {
            case 0: {
                iCombiBAPContentAdapter.gotoCurrentPlayingTrack();
                break;
            }
            case 2: {
                iCombiBAPContentAdapter.gotoParentFolder();
                break;
            }
            case 1: {
                iCombiBAPContentAdapter.gotoRootFolder();
                break;
            }
            case 4: {
                CombiBAPMediaEntry combiBAPMediaEntry = CombiBAPServiceListenerImpl.access$100(this.this$0).getIdMapper().getEntry(this.val$pCombiID);
                if (combiBAPMediaEntry == null) {
                    CombiBAPServiceListenerImpl.access$000(this.this$0).log(-1601830656, "[%1.goTo] No entryInfo found for combiID '%2'.", (Object)"CombiBAPServiceListenerImpl", (long)this.val$pCombiID);
                    CombiBAPServiceListenerImpl.access$100(this.this$0).gotoSubFolderResult(false);
                    return;
                }
                if (!MediaUtils.isFolderContentType(combiBAPMediaEntry.getEntryContentType())) {
                    CombiBAPServiceListenerImpl.access$000(this.this$0).log(-1601830656, "[%1.goTo] '%2' is no folder ('%3').", (Object)"CombiBAPServiceListenerImpl", (Object)new Integer(this.val$pCombiID), (Object)combiBAPMediaEntry);
                    CombiBAPServiceListenerImpl.access$100(this.this$0).gotoSubFolderResult(false);
                    return;
                }
                iCombiBAPContentAdapter.gotoSubFolder(combiBAPMediaEntry);
                break;
            }
        }
    }
}

