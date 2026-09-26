/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.playview;

import de.audi.app.media.combi.bap.playview.CombiBAPPlayViewContentAdapter;
import de.audi.app.media.queue.IQueueInterceptor;
import de.audi.app.media.queue.IQueueJob;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import java.util.List;

class CombiBAPPlayViewContentAdapter$1
implements IQueueInterceptor {
    private final /* synthetic */ CombiBAPPlayViewContentAdapter this$0;

    CombiBAPPlayViewContentAdapter$1(CombiBAPPlayViewContentAdapter combiBAPPlayViewContentAdapter) {
        this.this$0 = combiBAPPlayViewContentAdapter;
    }

    @Override
    public void execute(IQueueJob iQueueJob, List list) {
        if (iQueueJob.getType() != 4) {
            return;
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (((IQueueJob)iterator.next()).getType() != 4) continue;
            iterator.remove();
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("CombiBAPPlayViewContentAdapter").append("@").append(this.hashCode());
        return buffer.toString();
    }
}

