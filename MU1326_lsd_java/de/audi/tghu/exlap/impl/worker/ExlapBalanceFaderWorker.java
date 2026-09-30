/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.BalanceFaderContainer;
import de.audi.tghu.exlap.impl.listener.ExlapSoundEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapBalanceFaderWorker
extends ExlapAbstractWorker {
    private static final int BALANCE_FADER_PROPERTY = 45;

    public ExlapBalanceFaderWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapBalanceFaderWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(45, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapSoundEmptyListener(){

            public void updateBalanceFader(BalanceFaderContainer balanceFaderContainer) {
                ExlapBalanceFaderWorker.this.log.log(10000000, "[new ExlapSoundEmptyListener#updateBalanceFader] received new container: %1", (Object)balanceFaderContainer);
                ExlapBalanceFaderWorker.this.container = balanceFaderContainer;
                if (ExlapBalanceFaderWorker.this.interval != -1) {
                    ExlapBalanceFaderWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{45};
    }
}

