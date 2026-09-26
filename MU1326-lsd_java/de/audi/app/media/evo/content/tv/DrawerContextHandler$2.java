/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.tv;

import de.audi.app.media.evo.content.tv.DrawerContextHandler;
import de.audi.atip.interapp.media.IMediaDrawerContextListener;
import de.audi.atip.interapp.media.IMediaDrawerElement;

class DrawerContextHandler$2
implements IMediaDrawerContextListener {
    private final /* synthetic */ DrawerContextHandler this$0;

    DrawerContextHandler$2(DrawerContextHandler drawerContextHandler) {
        this.this$0 = drawerContextHandler;
    }

    @Override
    public void drawerElementSelected(IMediaDrawerElement iMediaDrawerElement) {
        this.this$0.logger.log(1078071040, "[IMediaDrawerContextListener.drawerElementSelected]");
    }
}

