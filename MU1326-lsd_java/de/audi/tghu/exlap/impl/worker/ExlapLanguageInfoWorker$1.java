/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.LanguageInfoContainer;
import de.audi.tghu.exlap.impl.listener.ExlapSystemEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapLanguageInfoWorker;

class ExlapLanguageInfoWorker$1
extends ExlapSystemEmptyListener {
    private final /* synthetic */ ExlapLanguageInfoWorker this$0;

    ExlapLanguageInfoWorker$1(ExlapLanguageInfoWorker exlapLanguageInfoWorker) {
        this.this$0 = exlapLanguageInfoWorker;
    }

    @Override
    public void updateLanguageInfo(LanguageInfoContainer languageInfoContainer) {
        ExlapLanguageInfoWorker.access$000(this.this$0).log(-2137614336, "[new ExlapSystemEmptyListener#updateLanguageInfo] received new container: %1", (Object)languageInfoContainer);
        ExlapLanguageInfoWorker.access$102(this.this$0, languageInfoContainer);
        if (ExlapLanguageInfoWorker.access$200(this.this$0) != -1) {
            ExlapLanguageInfoWorker.access$300(this.this$0);
        }
    }
}

