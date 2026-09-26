/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rsdb;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tuner.app.rsdb.LogoDatabase;
import de.audi.tuner.app.rsdb.LogoDatabase$1;

class LogoDatabase$ChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ LogoDatabase this$0;

    private LogoDatabase$ChoiceListener(LogoDatabase logoDatabase) {
        this.this$0 = logoDatabase;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        int n5 = LogoDatabase.access$500(this.this$0).getValue() == 1 ? 0 : 1;
        LogoDatabase.access$600(this.this$0, n5);
    }

    /* synthetic */ LogoDatabase$ChoiceListener(LogoDatabase logoDatabase, LogoDatabase$1 logoDatabase$1) {
        this(logoDatabase);
    }
}

