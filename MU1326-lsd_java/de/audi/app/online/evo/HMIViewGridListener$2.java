/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.HMIViewGridListener;
import de.audi.atip.interapp.online.IGridListRow;
import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;

class HMIViewGridListener$2
extends AbstractRemoteHMITask {
    private final /* synthetic */ int val$itemId;
    private final /* synthetic */ int val$subitemId;
    private final /* synthetic */ IGridListRow val$row;
    private final /* synthetic */ HMIViewGridListener this$0;

    HMIViewGridListener$2(HMIViewGridListener hMIViewGridListener, String string, LogAppender logAppender, int n, int n2, IGridListRow iGridListRow) {
        this.this$0 = hMIViewGridListener;
        this.val$itemId = n;
        this.val$subitemId = n2;
        this.val$row = iGridListRow;
        super(string, logAppender);
    }

    @Override
    public void run() {
        HMIViewGridListener.access$900(this.this$0, this.val$itemId, this.val$subitemId, this.val$row);
    }
}

