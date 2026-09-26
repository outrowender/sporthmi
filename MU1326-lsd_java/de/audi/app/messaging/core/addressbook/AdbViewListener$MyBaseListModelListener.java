/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.addressbook;

import de.audi.app.messaging.core.addressbook.AdbViewListener;
import de.audi.app.messaging.core.addressbook.AdbViewListener$1;
import de.audi.app.messaging.core.addressbook.NavigationLocationListRow;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.organizer.AdbEntry;

class AdbViewListener$MyBaseListModelListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ AdbViewListener this$0;

    private AdbViewListener$MyBaseListModelListener(AdbViewListener adbViewListener) {
        this.this$0 = adbViewListener;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        AdbViewListener.access$100(this.this$0).log(1078071040, "MsgADBViewListener#itemSelected(): modelID = %1", (long)n);
        AdbEntry adbEntry = AdbViewListener.access$200(this.this$0).getMessageOptionsManager().getAdbEntry();
        boolean bl = AdbViewListener.access$300(this.this$0, adbEntry, ((NavigationLocationListRow)evoListRow).getType());
        if (bl) {
            AdbViewListener.access$400(this.this$0).getModelApp(n).fireEvent(n4);
        }
    }

    /* synthetic */ AdbViewListener$MyBaseListModelListener(AdbViewListener adbViewListener, AdbViewListener$1 adbViewListener$1) {
        this(adbViewListener);
    }
}

