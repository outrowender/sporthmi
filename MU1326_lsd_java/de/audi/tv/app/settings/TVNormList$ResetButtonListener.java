/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tv.app.settings.TVNormList;
import de.audi.tv.app.settings.TVNormList$1;

class TVNormList$ResetButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ TVNormList this$0;

    private TVNormList$ResetButtonListener(TVNormList tVNormList) {
        this.this$0 = tVNormList;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        TVNormList.access$200((TVNormList)this.this$0).lcHMI.log(1078071040, "[TVNormList.ResetButtonListener.keyPressed] Reset to default requested.");
        TVNormList.access$300(this.this$0, 254);
        TVNormList.access$200(this.this$0).getBaseListModel(1454122752).fireEvent(n3);
    }

    /* synthetic */ TVNormList$ResetButtonListener(TVNormList tVNormList, TVNormList$1 tVNormList$1) {
        this(tVNormList);
    }
}

