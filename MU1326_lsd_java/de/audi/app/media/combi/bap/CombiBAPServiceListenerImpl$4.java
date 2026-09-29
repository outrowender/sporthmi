/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.combi.bap.CombiBAPServiceListenerImpl;
import de.audi.app.media.combi.bap.CombiBAPUtils;
import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceController;
import de.audi.app.media.source.ISourceSlot;

class CombiBAPServiceListenerImpl$4
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$pCombiSourceType;
    private final /* synthetic */ int val$slotNumber;
    private final /* synthetic */ int val$partitionNumber;
    private final /* synthetic */ CombiBAPServiceListenerImpl this$0;

    CombiBAPServiceListenerImpl$4(CombiBAPServiceListenerImpl combiBAPServiceListenerImpl, String string, int n, int n2, int n3) {
        this.this$0 = combiBAPServiceListenerImpl;
        this.val$pCombiSourceType = n;
        this.val$slotNumber = n2;
        this.val$partitionNumber = n3;
        super(string);
    }

    @Override
    public void run() {
        CombiBAPServiceListenerImpl.access$000(this.this$0).log(1078071040, "[%1.switchSource] sourceType='%2',slotNumber='%3', partitionNumber='%4'.", (Object)"CombiBAPServiceListenerImpl", (Object)Integer.toString(this.val$pCombiSourceType), (Object)Integer.toString(this.val$slotNumber), (Object)Integer.toString(this.val$partitionNumber));
        int n = CombiBAPUtils.getMediaSourceTypeOfCombiSourceType(this.val$pCombiSourceType);
        CombiBAPServiceListenerImpl.access$000(this.this$0).log(-2137614336, "[%1.switchSource] mediaSourceType='%2'.", (Object)"CombiBAPServiceListenerImpl", (long)n);
        if (n == -1) {
            CombiBAPServiceListenerImpl.access$000(this.this$0).log(-1601830656, "[%1.switchSource] No source type found for '%2'.", (Object)"CombiBAPServiceListenerImpl", (long)this.val$pCombiSourceType);
            CombiBAPServiceListenerImpl.access$100(this.this$0).switchSourceResult(false);
            return;
        }
        ISourceController iSourceController = this.this$0.getTerminal().getSourceController();
        ISourceSlot iSourceSlot = iSourceController.getSelectedSlot();
        if (iSourceSlot != null && iSourceSlot.getSource().getType() == 4) {
            CombiBAPServiceListenerImpl.access$200(this.this$0).hmi().log(1078071040, "[%1.onSwitchSource] FilePlayer currently active. Ingore.", (Object)"CombiBAPServiceListenerImpl");
            CombiBAPServiceListenerImpl.access$100(this.this$0).switchSourceResult(false);
            return;
        }
        ISource iSource = iSourceController.getSource(n);
        if (iSource == null) {
            CombiBAPServiceListenerImpl.access$000(this.this$0).log(-1601830656, "[%1.switchSource] [%2] Not supported", (Object)"CombiBAPServiceListenerImpl", (Object)LogUtil.getSourceTypeStr(n));
            CombiBAPServiceListenerImpl.access$100(this.this$0).switchSourceResult(false);
            return;
        }
        int n2 = iSource.getSlotNumberByPartition(this.val$slotNumber, this.val$partitionNumber);
        ActivationContext activationContext = new ActivationContext(iSource.getSlot(n2));
        activationContext.addParameter("CLOSE_DRAWER", Boolean.TRUE);
        activationContext.addParameter("REQUEST_AUDIO_IN_ADVANCE", Boolean.TRUE);
        int n3 = this.this$0.getTerminal().getSourceController().activateSource(activationContext);
        if (n3 != 1 && n3 != 2) {
            CombiBAPServiceListenerImpl.access$000(this.this$0).log(1078071040, "[%1.onSwitchSource] Source activation failed.", (Object)"CombiBAPServiceListenerImpl");
            CombiBAPServiceListenerImpl.access$100(this.this$0).switchSourceResult(false);
            return;
        }
        this.this$0.getTerminal().getAudioManager().requestAudioFocus();
        CombiBAPServiceListenerImpl.access$100(this.this$0).switchSourceResult(true);
    }
}

