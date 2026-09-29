/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.HMIViewGridListener;
import de.audi.atip.interapp.online.IGridListRow;
import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;

class HMIViewGridListener$4
extends AbstractRemoteHMITask {
    private final /* synthetic */ int val$itemId;
    private final /* synthetic */ int val$subitemId;
    private final /* synthetic */ IGridListRow val$row;
    private final /* synthetic */ boolean val$firedByMenuController;
    private final /* synthetic */ HMIViewGridListener this$0;

    HMIViewGridListener$4(HMIViewGridListener hMIViewGridListener, String string, LogAppender logAppender, int n, int n2, IGridListRow iGridListRow, boolean bl) {
        this.this$0 = hMIViewGridListener;
        this.val$itemId = n;
        this.val$subitemId = n2;
        this.val$row = iGridListRow;
        this.val$firedByMenuController = bl;
        super(string, logAppender);
    }

    @Override
    public void run() {
        HMIViewGridListener.access$1000(this.this$0, this.val$itemId, this.val$subitemId, this.val$row, this.val$firedByMenuController);
    }
}

