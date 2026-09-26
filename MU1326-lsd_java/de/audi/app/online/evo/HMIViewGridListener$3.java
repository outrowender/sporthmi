/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.HMIViewGridListener;
import de.audi.atip.interapp.online.IGridListRow;
import de.audi.remotehmi.util.LogAppender;
import de.esolutions.fw.util.commons.Buffer;

class HMIViewGridListener$3
implements LogAppender {
    private final /* synthetic */ int val$itemId;
    private final /* synthetic */ int val$subitemId;
    private final /* synthetic */ IGridListRow val$row;
    private final /* synthetic */ HMIViewGridListener this$0;

    HMIViewGridListener$3(HMIViewGridListener hMIViewGridListener, int n, int n2, IGridListRow iGridListRow) {
        this.this$0 = hMIViewGridListener;
        this.val$itemId = n;
        this.val$subitemId = n2;
        this.val$row = iGridListRow;
    }

    @Override
    public void appendTo(Buffer buffer) {
        buffer.append("itemId:").append(this.val$itemId);
        buffer.append(", subitemId:").append(this.val$subitemId);
        buffer.append(", row:").append(this.val$row);
    }

    @Override
    public int getEstimatedLength() {
        return 32;
    }
}

