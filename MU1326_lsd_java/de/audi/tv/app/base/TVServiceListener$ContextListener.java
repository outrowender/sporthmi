/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.interapp.media.IMediaDrawerContextListener;
import de.audi.atip.interapp.media.IMediaDrawerElement;
import de.audi.tv.app.base.TVServiceListener;
import de.audi.tv.app.base.TVServiceListener$1;

class TVServiceListener$ContextListener
implements IMediaDrawerContextListener {
    private final /* synthetic */ TVServiceListener this$0;

    private TVServiceListener$ContextListener(TVServiceListener tVServiceListener) {
        this.this$0 = tVServiceListener;
    }

    @Override
    public void drawerElementSelected(IMediaDrawerElement iMediaDrawerElement) {
        TVServiceListener.access$400(this.this$0).changeFocus(iMediaDrawerElement.getID());
    }

    /* synthetic */ TVServiceListener$ContextListener(TVServiceListener tVServiceListener, TVServiceListener$1 tVServiceListener$1) {
        this(tVServiceListener);
    }
}

