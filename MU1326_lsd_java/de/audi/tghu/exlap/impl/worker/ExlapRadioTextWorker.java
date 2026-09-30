/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.RadioTextContainer;
import de.audi.tghu.exlap.impl.listener.ExlapRadioEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapRadioTextWorker
extends ExlapAbstractWorker {
    private static final int RADIO_TEXT_PROPERTY = 49;

    public ExlapRadioTextWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapRadioTextWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(49, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapRadioEmptyListener(){

            public void updateRadioText(RadioTextContainer radioTextContainer) {
                ExlapRadioTextWorker.this.log.log(10000000, "[new ExlapRadioEmptyListener#updateRadioText] received new container: %1", (Object)radioTextContainer);
                ExlapRadioTextWorker.this.container = radioTextContainer;
                if (ExlapRadioTextWorker.this.interval != -1) {
                    ExlapRadioTextWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{49};
    }
}

