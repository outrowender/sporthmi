/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.sdis.MediaSDISSourceHandler;
import de.audi.app.media.sdis.SelectionData;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.ISource;

class MediaSDISSourceHandler$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$pSourceType;
    private final /* synthetic */ int val$pSlotIdx;
    private final /* synthetic */ SelectionData val$pSelData;
    private final /* synthetic */ MediaSDISSourceHandler this$0;

    MediaSDISSourceHandler$1(MediaSDISSourceHandler mediaSDISSourceHandler, String string, int n, int n2, SelectionData selectionData) {
        this.this$0 = mediaSDISSourceHandler;
        this.val$pSourceType = n;
        this.val$pSlotIdx = n2;
        this.val$pSelData = selectionData;
        super(string);
    }

    @Override
    public void run() {
        MediaSDISSourceHandler.access$000(this.this$0).log(1078071040, "[%1.onActivate] '%2','%3'", (Object)"MediaSDISSourceHandler", (long)this.val$pSourceType, (long)this.val$pSlotIdx);
        ISource iSource = MediaSDISSourceHandler.access$100(this.this$0).getSourceController().getSource(this.val$pSourceType);
        if (iSource == null) {
            MediaSDISSourceHandler.access$000(this.this$0).log(1078071040, "[%1.onActivate] Source not available.", (Object)"MediaSDISSourceHandler");
            return;
        }
        ActivationContext activationContext = new ActivationContext(iSource.getSlot(this.val$pSlotIdx));
        if (this.val$pSelData != null) {
            activationContext.addParameter("SETPLAYSELECTION_BROWSERID", new Integer(this.val$pSelData.getBrowserInstance()));
            activationContext.addParameter("SETPLAYSELECTION_TRACKID", new Long(this.val$pSelData.getTrackID()));
        }
        MediaSDISSourceHandler.access$100(this.this$0).getSourceController().activateSource(activationContext);
    }
}

