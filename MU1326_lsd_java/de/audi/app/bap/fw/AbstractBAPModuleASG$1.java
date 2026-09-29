/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.fw.CommunicationUpListener;

class AbstractBAPModuleASG$1
implements CommunicationUpListener {
    private final /* synthetic */ AbstractBAPModuleASG this$0;

    AbstractBAPModuleASG$1(AbstractBAPModuleASG abstractBAPModuleASG) {
        this.this$0 = abstractBAPModuleASG;
    }

    @Override
    public void communicationUp() {
        this.this$0.onCommunicationUp();
    }
}

