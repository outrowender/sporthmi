/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.SkinInfoContainer;
import de.audi.tghu.exlap.impl.listener.ExlapSystemEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapSkinInfoWorker
extends ExlapAbstractWorker {
    private static final int SKIN_INFO_PROPERTY = 5;

    public ExlapSkinInfoWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapSkinInfoWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(5, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapSystemEmptyListener(){

            public void updateSkinInfo(SkinInfoContainer skinInfoContainer) {
                ExlapSkinInfoWorker.this.log.log(10000000, "[new ExlapSystemEmptyListener#updateSkinInfo] received new container: %1", (Object)skinInfoContainer);
                ExlapSkinInfoWorker.this.container = skinInfoContainer;
                if (ExlapSkinInfoWorker.this.interval != -1) {
                    ExlapSkinInfoWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{5};
    }
}

