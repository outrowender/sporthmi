/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.HMIViewGridListener;
import de.audi.app.online.evo.HMIViewGridListener$1;
import de.audi.app.online.evo.HMIViewGridListener$UpdateDecoratorTask$1;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.remotehmi.util.LogAppender;
import de.audi.remotehmi.util.PreparedImage;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIViewTask;
import de.audi.tghu.online.app.remotehmi.RemoteHMITask;
import java.util.ArrayList;
import java.util.List;

final class HMIViewGridListener$UpdateDecoratorTask
extends AbstractRemoteHMIViewTask {
    private IGrid focusedGrid;
    private int focusedIndex;
    private final /* synthetic */ HMIViewGridListener this$0;

    private HMIViewGridListener$UpdateDecoratorTask(HMIViewGridListener hMIViewGridListener, String string, String string2, IGrid iGrid, int n) {
        this.this$0 = hMIViewGridListener;
        super(string, null, string2);
        this.focusedGrid = iGrid;
        this.focusedIndex = n;
    }

    @Override
    protected LogAppender getParamsForDebugging() {
        return new HMIViewGridListener$UpdateDecoratorTask$1(this);
    }

    @Override
    public void run() {
        List list;
        if (this.focusedGrid != null) {
            Object object;
            HMIViewGridListener.access$100(this.this$0).log(1078071040, "UpdateDecoratorTask#run focusedGridIndex %1", (long)this.focusedIndex);
            list = this.getLazyNeighbourhood(this.focusedIndex);
            PreparedImage preparedImage = this.focusedGrid.getDecoratorImage();
            boolean bl = this.isLazyLoadingNeeded(this.focusedGrid, preparedImage);
            if (bl) {
                PreparedImage preparedImage2;
                list.add(0, preparedImage);
                object = this.focusedGrid.getDetail();
                if (object != null && this.isLazyLoadingNeeded((IGrid)object, preparedImage2 = object.getDecoratorImage())) {
                    list.add(1, preparedImage2);
                }
            }
            if (list.size() > 0) {
                object = new RemoteHMIAction(1337563136);
                ((RemoteHMIAction)object).getParameters().put("propPreparedImage", list);
                HMIViewGridListener.access$200(this.this$0).invokeAction((RemoteHMIAction)object);
            }
            if (bl) {
                return;
            }
        }
        boolean bl = (list = HMIViewGridListener.access$300(this.this$0).getGridList()).getViewType() == 1;
        HMIViewGridListener.access$300(this.this$0).getDecorator().updateValues(this.focusedGrid, list.getReferencePoint(), bl);
        HMIViewGridListener.access$400(this.this$0).flushModelGroup();
    }

    private List getLazyNeighbourhood(int n) {
        int n2;
        ArrayList arrayList = new ArrayList(1);
        IGridList iGridList = HMIViewGridListener.access$300(this.this$0).getGridList();
        int n3 = n - HMIViewGridListener.access$500();
        int n4 = n3 < 0 ? 0 : n3;
        n3 = n + HMIViewGridListener.access$500();
        int n5 = n2 = n3 > iGridList.size() - 1 ? iGridList.size() - 1 : n3;
        if (n2 - n4 < 0) {
            return arrayList;
        }
        for (int i2 = n4; i2 <= n2; ++i2) {
            PreparedImage preparedImage;
            IGrid iGrid;
            if (i2 == n || !this.isLazyLoadingNeeded(iGrid = (IGrid)iGridList.get(i2), preparedImage = iGrid.getDecoratorImage())) continue;
            arrayList.add(preparedImage);
        }
        return arrayList;
    }

    private boolean isLazyLoadingNeeded(IGrid iGrid, PreparedImage preparedImage) {
        String string;
        String string2;
        if (preparedImage != null && preparedImage.isLazy() && ((string2 = iGrid.getDecoratorImageUrl()) == null || string2.length() == 0) && (string = preparedImage.getLocalLocation()) != null && string.length() > 0) {
            HMIViewGridListener.access$600(this.this$0).log(1078071040, "HMIViewGridListener#UpdateDecoratorTask#run: should fetch lazy image: %1", (Object)preparedImage.getRemoteUrl());
            return true;
        }
        return false;
    }

    @Override
    public boolean isCoalescable() {
        return true;
    }

    @Override
    public Long getDelayMillis() {
        return HMIViewGridListener.access$700(this.this$0);
    }

    @Override
    public boolean coalesceWith(RemoteHMITask remoteHMITask) {
        if (!(remoteHMITask instanceof HMIViewGridListener$UpdateDecoratorTask)) {
            return false;
        }
        HMIViewGridListener$UpdateDecoratorTask hMIViewGridListener$UpdateDecoratorTask = (HMIViewGridListener$UpdateDecoratorTask)remoteHMITask;
        HMIViewGridListener.access$800(this.this$0).log(1078071040, "HMIViewGridListener#UpdateDecoratorTask#coalesceWith: avoided update for focusedGrid %1", (Object)hMIViewGridListener$UpdateDecoratorTask.focusedGrid);
        hMIViewGridListener$UpdateDecoratorTask.focusedGrid = this.focusedGrid;
        return true;
    }

    static /* synthetic */ IGrid access$000(HMIViewGridListener$UpdateDecoratorTask hMIViewGridListener$UpdateDecoratorTask) {
        return hMIViewGridListener$UpdateDecoratorTask.focusedGrid;
    }

    /* synthetic */ HMIViewGridListener$UpdateDecoratorTask(HMIViewGridListener hMIViewGridListener, String string, String string2, IGrid iGrid, int n, HMIViewGridListener$1 hMIViewGridListener$1) {
        this(hMIViewGridListener, string, string2, iGrid, n);
    }
}

