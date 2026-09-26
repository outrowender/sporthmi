/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsi;

import de.audi.app.sdsmanager.dictation.dsi.DsiOnlineDictationAccess;
import de.audi.app.sdsmanager.dictation.osgi.AbstractTrackerCustomizer;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.online.DSIOnlineDictation;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

class DsiOnlineDictationAccess$2
extends AbstractTrackerCustomizer {
    private final /* synthetic */ DsiOnlineDictationAccess this$0;

    DsiOnlineDictationAccess$2(DsiOnlineDictationAccess dsiOnlineDictationAccess, LogChannel logChannel, BundleContext bundleContext) {
        this.this$0 = dsiOnlineDictationAccess;
        super(logChannel, bundleContext);
    }

    @Override
    public void addService(ServiceReference serviceReference, Object object) {
        DsiOnlineDictationAccess.access$400(this.this$0, (DSIOnlineDictation)object);
    }

    @Override
    public void removeService(ServiceReference serviceReference, Object object) {
        DsiOnlineDictationAccess.access$400(this.this$0, null);
    }
}

