/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLoader$CancelableIconLoadWorker;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLoader$IconLoadQueue;
import java.util.List;

class IconLoader$IconLoadQueue$1
extends BaseJobFilter {
    private final /* synthetic */ IconLoader$IconLoadQueue this$0;

    IconLoader$IconLoadQueue$1(IconLoader$IconLoadQueue iconLoader$IconLoadQueue) {
        this.this$0 = iconLoader$IconLoadQueue;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void enqueue(Job job, int n) {
        IconLoader$CancelableIconLoadWorker iconLoader$CancelableIconLoadWorker = (IconLoader$CancelableIconLoadWorker)job.getPayload();
        boolean bl = iconLoader$CancelableIconLoadWorker.isCancelJob();
        IconLoader$IconLoadQueue iconLoader$IconLoadQueue = this.this$0;
        synchronized (iconLoader$IconLoadQueue) {
            List list = IconLoader$IconLoadQueue.access$000(this.this$0);
            boolean bl2 = !bl;
            for (int i2 = 0; i2 < list.size(); ++i2) {
                Job job2 = IconLoader$IconLoadQueue.access$100(this.this$0, i2);
                IconLoader$CancelableIconLoadWorker iconLoader$CancelableIconLoadWorker2 = (IconLoader$CancelableIconLoadWorker)job2.getPayload();
                if (iconLoader$CancelableIconLoadWorker2.iconID == iconLoader$CancelableIconLoadWorker.iconID) {
                    List list2 = iconLoader$CancelableIconLoadWorker2.pendingRequests;
                    synchronized (list2) {
                        if (bl) {
                            iconLoader$CancelableIconLoadWorker2.pendingRequests.remove(iconLoader$CancelableIconLoadWorker.iconLoadedCallBack);
                            --iconLoader$CancelableIconLoadWorker2.pendingRequestAmount;
                        } else {
                            iconLoader$CancelableIconLoadWorker2.pendingRequests.add(iconLoader$CancelableIconLoadWorker.iconLoadedCallBack);
                            ++iconLoader$CancelableIconLoadWorker2.pendingRequestAmount;
                        }
                    }
                    bl2 = false;
                    break;
                }
                IWidgetLogChannel.iconLabelLogCh.log(1078071040, "IconLoadQueue: EnqueueFilter update to old job [%1] ", (Object)iconLoader$CancelableIconLoadWorker2.toString());
            }
            if (bl2) {
                long l = IconLoader$IconLoadQueue.access$200(this.this$0).getCurrentTime();
                job.setPosted(l);
                list.add(job);
                IWidgetLogChannel.iconLabelLogCh.log(1078071040, "IconLoadQueue: EnqueueFilter insert new job [%1] ", (Object)job.toString());
            }
            super.notifyAll();
        }
    }

    public String toString() {
        return "IconLoadQueue: EnqueueFilter";
    }
}

