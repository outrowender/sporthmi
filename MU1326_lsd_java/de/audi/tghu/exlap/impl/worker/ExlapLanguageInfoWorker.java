/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.LanguageInfoContainer;
import de.audi.tghu.exlap.impl.listener.ExlapSystemEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapLanguageInfoWorker
extends ExlapAbstractWorker {
    private static final int LANGUAGE_INFO_PROPERTY = 6;

    public ExlapLanguageInfoWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapLanguageInfoWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(6, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapSystemEmptyListener(){

            public void updateLanguageInfo(LanguageInfoContainer languageInfoContainer) {
                ExlapLanguageInfoWorker.this.log.log(10000000, "[new ExlapSystemEmptyListener#updateLanguageInfo] received new container: %1", (Object)languageInfoContainer);
                ExlapLanguageInfoWorker.this.container = languageInfoContainer;
                if (ExlapLanguageInfoWorker.this.interval != -1) {
                    ExlapLanguageInfoWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{6};
    }
}

