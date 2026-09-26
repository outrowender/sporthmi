/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.HMIViewGridListener;
import de.audi.app.online.evo.OnlineEvoActionProxyImpl;
import de.audi.tghu.online.app.remotehmi.AbstractHMIViewListener;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;

class OnlineEvoActionProxyImpl$9
extends AbstractRemoteHMITask {
    private final /* synthetic */ int val$rightContentOffsetWithMapDecorator;
    private final /* synthetic */ int val$rightContentOffsetWithImageDecorator;
    private final /* synthetic */ int val$rightContentOffsetWithoutDecorator;
    private final /* synthetic */ OnlineEvoActionProxyImpl this$0;

    OnlineEvoActionProxyImpl$9(OnlineEvoActionProxyImpl onlineEvoActionProxyImpl, String string, int n, int n2, int n3) {
        this.this$0 = onlineEvoActionProxyImpl;
        this.val$rightContentOffsetWithMapDecorator = n;
        this.val$rightContentOffsetWithImageDecorator = n2;
        this.val$rightContentOffsetWithoutDecorator = n3;
        super(string);
    }

    @Override
    public void run() {
        AbstractHMIViewListener abstractHMIViewListener = OnlineEvoActionProxyImpl.access$000(this.this$0).getViewListener(13000);
        if (abstractHMIViewListener instanceof HMIViewGridListener) {
            ((HMIViewGridListener)abstractHMIViewListener).updateLayoutConstants(this.val$rightContentOffsetWithMapDecorator, this.val$rightContentOffsetWithImageDecorator, this.val$rightContentOffsetWithoutDecorator);
        }
    }
}

