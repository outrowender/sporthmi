/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.exlap.Container;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.worker.ExlapSkinInfoWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapSkinInfoWorker
extends ExlapAbstractWorker {
    private static final int SKIN_INFO_PROPERTY;

    public ExlapSkinInfoWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapSkinInfoWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(5, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapSkinInfoWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{5};
    }

    static /* synthetic */ LogChannel access$000(ExlapSkinInfoWorker exlapSkinInfoWorker) {
        return exlapSkinInfoWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapSkinInfoWorker exlapSkinInfoWorker, Container container) {
        exlapSkinInfoWorker.container = container;
        return exlapSkinInfoWorker.container;
    }

    static /* synthetic */ int access$200(ExlapSkinInfoWorker exlapSkinInfoWorker) {
        return exlapSkinInfoWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapSkinInfoWorker exlapSkinInfoWorker) {
        exlapSkinInfoWorker.trigger();
    }
}

