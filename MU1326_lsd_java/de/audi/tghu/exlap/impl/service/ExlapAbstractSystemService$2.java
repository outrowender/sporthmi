/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapSystemListener;
import de.audi.tghu.exlap.impl.container.LanguageInfoContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractSystemService;

class ExlapAbstractSystemService$2
implements ListenerIterator {
    private final /* synthetic */ LanguageInfoContainer val$languageInfoProperty;
    private final /* synthetic */ ExlapAbstractSystemService this$0;

    ExlapAbstractSystemService$2(ExlapAbstractSystemService exlapAbstractSystemService, LanguageInfoContainer languageInfoContainer) {
        this.this$0 = exlapAbstractSystemService;
        this.val$languageInfoProperty = languageInfoContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapSystemListener)exlapListener).updateLanguageInfo(this.val$languageInfoProperty);
    }
}

