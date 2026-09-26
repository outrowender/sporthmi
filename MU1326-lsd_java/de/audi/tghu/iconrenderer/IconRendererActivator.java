/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.iconrenderer;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.iconrenderer.IconRenderer;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.iconhandling.DSIIconExtractor;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class IconRendererActivator
extends AbstractFrameworkActivator
implements ServiceTrackerCustomizer {
    private ServiceRegistration sRegIconRendererListener;
    private ServiceRegistration sRegRenderingInfoProv;
    private ServiceTracker iconRendererTracker;
    private LogChannel logCh;
    private IconRenderer iconRenderer = null;
    static /* synthetic */ Class class$org$dsi$ifc$iconhandling$DSIIconExtractorListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$iconhandling$DSIIconExtractor;
    static /* synthetic */ Class class$de$audi$atip$interapp$icon$RenderingInfoProvider;

    public IconRendererActivator() {
        super("IconRenderer");
    }

    public IconRenderer getService() {
        return this.iconRenderer;
    }

    private void registerServices() {
        this.logCh.log(-2137614336, "[IconRendererActivator#registerServices] Register listener for DSIIconrenderer.");
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$iconhandling$DSIIconExtractorListener == null ? (class$org$dsi$ifc$iconhandling$DSIIconExtractorListener = IconRendererActivator.class$("org.dsi.ifc.iconhandling.DSIIconExtractorListener")) : class$org$dsi$ifc$iconhandling$DSIIconExtractorListener).getName());
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        this.sRegIconRendererListener = this.getBundleContext().registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = IconRendererActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.getService(), (Dictionary)hashtable);
    }

    private void initTrackers() {
        this.iconRendererTracker = new ServiceTracker(this.getBundleContext(), (class$org$dsi$ifc$iconhandling$DSIIconExtractor == null ? (class$org$dsi$ifc$iconhandling$DSIIconExtractor = IconRendererActivator.class$("org.dsi.ifc.iconhandling.DSIIconExtractor")) : class$org$dsi$ifc$iconhandling$DSIIconExtractor).getName(), (ServiceTrackerCustomizer)this);
        this.iconRendererTracker.open();
    }

    @Override
    protected void startInternal(BundleContext bundleContext) {
        this.logCh = this.framework.getLogChannel("Fw.IconRenderer");
        this.iconRenderer = new IconRenderer(this.logCh);
        this.logCh.log(-2137614336, "[IconRendererActivator#start] called");
        this.registerServices();
        this.initTrackers();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (this.iconRendererTracker != null) {
            this.iconRendererTracker.close();
            this.iconRendererTracker = null;
        }
        if (this.sRegIconRendererListener != null) {
            this.sRegIconRendererListener.unregister();
            this.sRegIconRendererListener = null;
        }
        if (this.sRegRenderingInfoProv != null) {
            this.sRegRenderingInfoProv.unregister();
            this.sRegRenderingInfoProv = null;
        }
        super.stop(bundleContext);
    }

    private void addIconRendererService(ServiceReference serviceReference) {
        this.logCh.log(-2137614336, "[IconRendererActivator#addIconRendererService] Icon renderer DSI was found.");
        DSIIconExtractor dSIIconExtractor = (DSIIconExtractor)this.getBundleContext().getService(serviceReference);
        boolean bl = Boolean.getBoolean("UseIconExtractor");
        if (bl) {
            this.getService().setDSIIconrenderer(dSIIconExtractor);
        }
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$de$audi$atip$interapp$icon$RenderingInfoProvider == null ? (class$de$audi$atip$interapp$icon$RenderingInfoProvider = IconRendererActivator.class$("de.audi.atip.interapp.icon.RenderingInfoProvider")) : class$de$audi$atip$interapp$icon$RenderingInfoProvider).getName());
        this.sRegRenderingInfoProv = this.getBundleContext().registerService((class$de$audi$atip$interapp$icon$RenderingInfoProvider == null ? (class$de$audi$atip$interapp$icon$RenderingInfoProvider = IconRendererActivator.class$("de.audi.atip.interapp.icon.RenderingInfoProvider")) : class$de$audi$atip$interapp$icon$RenderingInfoProvider).getName(), (Object)this.getService(), (Dictionary)hashtable);
    }

    private void removeIconRendererService(ServiceReference serviceReference) {
        this.getBundleContext().ungetService(serviceReference);
        this.getService().setDSIIconrenderer(null);
        if (this.sRegRenderingInfoProv != null) {
            this.sRegRenderingInfoProv.unregister();
            this.sRegRenderingInfoProv = null;
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.logCh.log(-2137614336, "[IconRendererActivator#addingService] Called.");
        String string = (String)serviceReference.getProperty("DEVICE_NAME");
        if ((class$org$dsi$ifc$iconhandling$DSIIconExtractor == null ? (class$org$dsi$ifc$iconhandling$DSIIconExtractor = IconRendererActivator.class$("org.dsi.ifc.iconhandling.DSIIconExtractor")) : class$org$dsi$ifc$iconhandling$DSIIconExtractor).getName().equals(string)) {
            this.addIconRendererService(serviceReference);
        }
        return string;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.logCh.log(-2137614336, "[IconRendererActivator#removedService] Called.");
        String string = (String)serviceReference.getProperty("DEVICE_NAME");
        if ((class$org$dsi$ifc$iconhandling$DSIIconExtractor == null ? (class$org$dsi$ifc$iconhandling$DSIIconExtractor = IconRendererActivator.class$("org.dsi.ifc.iconhandling.DSIIconExtractor")) : class$org$dsi$ifc$iconhandling$DSIIconExtractor).getName().equals(string)) {
            this.removeIconRendererService(serviceReference);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

