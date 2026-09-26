/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.DefaultMessageListener;
import de.audi.tv.app.base.TVAppCommon;
import de.audi.tv.app.base.TVAppCommon$1;

class TVAppCommon$ResetListener
extends DefaultMessageListener {
    private final /* synthetic */ TVAppCommon this$0;

    private TVAppCommon$ResetListener(TVAppCommon tVAppCommon) {
        this.this$0 = tVAppCommon;
    }

    @Override
    public void reset(boolean bl, boolean bl2) {
        this.this$0.resetSettings(bl, bl2);
    }

    /* synthetic */ TVAppCommon$ResetListener(TVAppCommon tVAppCommon, TVAppCommon$1 tVAppCommon$1) {
        this(tVAppCommon);
    }
}

