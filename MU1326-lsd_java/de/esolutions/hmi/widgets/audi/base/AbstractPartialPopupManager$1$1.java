/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.hmi.view.IPartialPopupListener;
import de.esolutions.hmi.widgets.audi.base.AbstractPartialPopupManager;
import de.esolutions.hmi.widgets.audi.base.AbstractPartialPopupManager$1;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import java.util.ArrayList;

class AbstractPartialPopupManager$1$1
implements Runnable {
    private final /* synthetic */ IPartialPopupListener val$ppListener;
    private final /* synthetic */ AbstractPartialPopupManager$1 this$1;

    AbstractPartialPopupManager$1$1(AbstractPartialPopupManager$1 abstractPartialPopupManager$1, IPartialPopupListener iPartialPopupListener) {
        this.this$1 = abstractPartialPopupManager$1;
        this.val$ppListener = iPartialPopupListener;
    }

    @Override
    public void run() {
        int[] nArray;
        if (this.val$ppListener != null && (nArray = this.val$ppListener.getPPIDsForCallbacks()) != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                int n = nArray[i2];
                Integer n2 = new Integer(n);
                ArrayList arrayList = (ArrayList)AbstractPartialPopupManager.access$100(AbstractPartialPopupManager$1.access$000(this.this$1)).get(n2);
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                    AbstractPartialPopupManager.access$100(AbstractPartialPopupManager$1.access$000(this.this$1)).put(n2, arrayList);
                }
                if (arrayList.contains(this.val$ppListener)) continue;
                IWidgetLogChannel.logChannelPopups.log(-2137614336, "PartialPopupManager#addingService add(ppListener): %1", (Object)this.val$ppListener);
                arrayList.add(this.val$ppListener);
                this.val$ppListener.partialPopupListenerRegistered(n, AbstractPartialPopupManager$1.access$000((AbstractPartialPopupManager$1)this.this$1).terminal.getTerminalID(), AbstractPartialPopupManager$1.access$200(this.this$1, n));
            }
        }
    }
}

