/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.tv;

import de.audi.atip.interapp.media.IMediaDrawerContextListener;
import de.audi.atip.interapp.media.IMediaDrawerElement;
import de.audi.atip.log.LogChannel;

public class NullMediaDrawerContextListener
implements IMediaDrawerContextListener {
    private static final String LOGCLASS = "NullMediaDrawerContextListener";
    private final LogChannel logger;

    public NullMediaDrawerContextListener(LogChannel logChannel) {
        this.logger = logChannel;
    }

    public void drawerElementSelected(IMediaDrawerElement iMediaDrawerElement) {
        this.logger.log(1000000, "[%1.drawerElementSelected]", (Object)LOGCLASS);
    }
}

