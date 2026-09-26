/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.SkinInfoContainer;
import de.audi.tghu.exlap.impl.listener.ExlapSystemEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapSkinInfoWorker;

class ExlapSkinInfoWorker$1
extends ExlapSystemEmptyListener {
    private final /* synthetic */ ExlapSkinInfoWorker this$0;

    ExlapSkinInfoWorker$1(ExlapSkinInfoWorker exlapSkinInfoWorker) {
        this.this$0 = exlapSkinInfoWorker;
    }

    @Override
    public void updateSkinInfo(SkinInfoContainer skinInfoContainer) {
        ExlapSkinInfoWorker.access$000(this.this$0).log(-2137614336, "[new ExlapSystemEmptyListener#updateSkinInfo] received new container: %1", (Object)skinInfoContainer);
        ExlapSkinInfoWorker.access$102(this.this$0, skinInfoContainer);
        if (ExlapSkinInfoWorker.access$200(this.this$0) != -1) {
            ExlapSkinInfoWorker.access$300(this.this$0);
        }
    }
}

