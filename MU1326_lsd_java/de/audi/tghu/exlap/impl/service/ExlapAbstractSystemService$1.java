/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapSystemListener;
import de.audi.tghu.exlap.impl.container.SkinInfoContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractSystemService;

class ExlapAbstractSystemService$1
implements ListenerIterator {
    private final /* synthetic */ SkinInfoContainer val$skinInfoProperty;
    private final /* synthetic */ ExlapAbstractSystemService this$0;

    ExlapAbstractSystemService$1(ExlapAbstractSystemService exlapAbstractSystemService, SkinInfoContainer skinInfoContainer) {
        this.this$0 = exlapAbstractSystemService;
        this.val$skinInfoProperty = skinInfoContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapSystemListener)exlapListener).updateSkinInfo(this.val$skinInfoProperty);
    }
}

