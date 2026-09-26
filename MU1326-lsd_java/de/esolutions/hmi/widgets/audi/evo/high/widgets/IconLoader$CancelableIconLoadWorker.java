/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.eso.IconExtractor.IconExtractor$Bitmap;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLoader;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLoader$IIconLoadedCallBack;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLoader$IconLoadedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class IconLoader$CancelableIconLoadWorker
implements Runnable {
    final int iconID;
    final Integer id_int;
    private IconExtractor$Bitmap bitmap = null;
    IconLoader$IIconLoadedCallBack iconLoadedCallBack;
    private final boolean cancelJob;
    int pendingRequestAmount = 0;
    List pendingRequests = new ArrayList();
    private final /* synthetic */ IconLoader this$0;

    public IconLoader$CancelableIconLoadWorker(IconLoader iconLoader, int n, Integer n2, IconLoader$IIconLoadedCallBack iconLoader$IIconLoadedCallBack) {
        this(iconLoader, n, n2, false, iconLoader$IIconLoadedCallBack);
    }

    public IconLoader$CancelableIconLoadWorker(IconLoader iconLoader, int n, Integer n2, boolean bl, IconLoader$IIconLoadedCallBack iconLoader$IIconLoadedCallBack) {
        this.this$0 = iconLoader;
        this.iconID = n;
        this.id_int = n2;
        this.pendingRequestAmount = 1;
        this.pendingRequests.add(iconLoader$IIconLoadedCallBack);
        this.iconLoadedCallBack = iconLoader$IIconLoadedCallBack;
        this.cancelJob = bl;
    }

    public boolean isCancelJob() {
        return this.cancelJob;
    }

    public String toString() {
        Buffer buffer = new Buffer().append("IconLoadWorker: iconID = ").append(String.valueOf(this.iconID)).append(" pendingRequestAmount = ").append(" iconLoadedCallBack = ").append(String.valueOf(this.iconLoadedCallBack.hashCode())).append(String.valueOf(this.pendingRequestAmount)).append(" pendingRequests = ").append(String.valueOf(this.pendingRequests.size()));
        buffer.append("[");
        for (int i2 = 0; i2 < this.pendingRequests.size(); ++i2) {
            buffer.append(new StringBuffer().append(" ").append(((Object)this.pendingRequests).hashCode()).append(",").toString());
        }
        buffer.append("]");
        return buffer.toString();
    }

    @Override
    public void run() {
        try {
            this.bitmap = IconLoader.getImage(this.iconID);
        }
        catch (Exception exception) {
            IconLoader.access$300(this.this$0).log(10000, "IconLoadWorker#run Caught exception when getting bitmap with id = %2, message as %1", (Object)exception.getMessage(), (long)this.iconID);
            return;
        }
        IconLoader.access$300(this.this$0).log(-2137614336, "IconLoadWorker#run task information %1", (Object)this);
        int n = this.pendingRequests.size();
        if (n != this.pendingRequestAmount) {
            IconLoader.access$300(this.this$0).log(10000, "IconLoadWorker#run pendingAmount != pendingRequestAmount");
        }
        if (this.pendingRequestAmount > 0) {
            Iterator iterator = this.pendingRequests.iterator();
            while (iterator.hasNext()) {
                IconLoader$IconLoadedEvent iconLoader$IconLoadedEvent = new IconLoader$IconLoadedEvent((IconLoader$IIconLoadedCallBack)iterator.next(), this.iconID, this.id_int, this.bitmap);
                IconLoader.access$400(this.this$0).getHMIService().getEventDispatcher().postEvent(iconLoader$IconLoadedEvent);
            }
        } else {
            IconLoader$IconLoadedEvent iconLoader$IconLoadedEvent = new IconLoader$IconLoadedEvent(this.iconLoadedCallBack, this.iconID, this.id_int, this.bitmap);
            IconLoader.access$400(this.this$0).getHMIService().getEventDispatcher().postEvent(iconLoader$IconLoadedEvent);
        }
    }
}

