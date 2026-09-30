/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.BalanceFaderRangesContainer;
import de.audi.tghu.exlap.impl.listener.ExlapSoundEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapBalanceFaderRangesWorker
extends ExlapAbstractWorker {
    private static final int BALANCE_FADER_RANGES_PROPERTY = 46;

    public ExlapBalanceFaderRangesWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapBalanceFaderRangesWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(46, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapSoundEmptyListener(){

            public void updateBalanceFaderRanges(BalanceFaderRangesContainer balanceFaderRangesContainer) {
                ExlapBalanceFaderRangesWorker.this.log.log(10000000, "[new ExlapSoundEmptyListener#updateBalanceFaderRanges] received new container: %1", (Object)balanceFaderRangesContainer);
                ExlapBalanceFaderRangesWorker.this.container = balanceFaderRangesContainer;
                if (ExlapBalanceFaderRangesWorker.this.interval != -1) {
                    ExlapBalanceFaderRangesWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{46};
    }
}

