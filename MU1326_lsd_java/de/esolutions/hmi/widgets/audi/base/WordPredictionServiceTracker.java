/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.log.LogChannel;
import de.audi.atip.wordprediction.IWordPrediction;
import de.esolutions.hmi.widgets.audi.base.WordPredictionAccess;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class WordPredictionServiceTracker
implements ServiceTrackerCustomizer {
    private final BundleContext bundleContext;
    private volatile ServiceTracker serviceTracker = null;
    private final LogChannel logChan;
    static /* synthetic */ Class class$de$audi$atip$wordprediction$IWordPrediction;

    public WordPredictionServiceTracker(BundleContext bundleContext, LogChannel logChannel) {
        this.bundleContext = bundleContext;
        this.logChan = logChannel;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.getLogChannel().log(1078071040, "[WordPredictionServiceTracker#addingService] service: %1", (Object)(class$de$audi$atip$wordprediction$IWordPrediction == null ? (class$de$audi$atip$wordprediction$IWordPrediction = WordPredictionServiceTracker.class$("de.audi.atip.wordprediction.IWordPrediction")) : class$de$audi$atip$wordprediction$IWordPrediction).getName());
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof IWordPrediction) {
            WordPredictionServiceTracker.setWordPrediction((IWordPrediction)object);
        } else {
            WordPredictionServiceTracker.setWordPrediction(null);
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.getLogChannel().log(1078071040, "[WordPredictionServiceTracker#removedService] service: %1", (Object)(class$de$audi$atip$wordprediction$IWordPrediction == null ? (class$de$audi$atip$wordprediction$IWordPrediction = WordPredictionServiceTracker.class$("de.audi.atip.wordprediction.IWordPrediction")) : class$de$audi$atip$wordprediction$IWordPrediction).getName());
        WordPredictionServiceTracker.setWordPrediction(null);
        this.bundleContext.ungetService(serviceReference);
    }

    public void startTracking() {
        this.getLogChannel().log(1078071040, "[WordPredictionServiceTracker#startTracking] tracking service: %1", (Object)(class$de$audi$atip$wordprediction$IWordPrediction == null ? (class$de$audi$atip$wordprediction$IWordPrediction = WordPredictionServiceTracker.class$("de.audi.atip.wordprediction.IWordPrediction")) : class$de$audi$atip$wordprediction$IWordPrediction).getName());
        this.serviceTracker = new ServiceTracker(this.bundleContext, new String[]{(class$de$audi$atip$wordprediction$IWordPrediction == null ? (class$de$audi$atip$wordprediction$IWordPrediction = WordPredictionServiceTracker.class$("de.audi.atip.wordprediction.IWordPrediction")) : class$de$audi$atip$wordprediction$IWordPrediction).getName()}, (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
    }

    protected final LogChannel getLogChannel() {
        return this.logChan;
    }

    public void stopTracking() {
        this.getLogChannel().log(1078071040, "[WordPredictionServiceTracker#stopTracking] tracking service: %1", (Object)(class$de$audi$atip$wordprediction$IWordPrediction == null ? (class$de$audi$atip$wordprediction$IWordPrediction = WordPredictionServiceTracker.class$("de.audi.atip.wordprediction.IWordPrediction")) : class$de$audi$atip$wordprediction$IWordPrediction).getName());
        if (this.serviceTracker != null) {
            this.serviceTracker.close();
            this.serviceTracker = null;
        }
    }

    private static void setWordPrediction(IWordPrediction iWordPrediction) {
        WordPredictionAccess.setWordPrediction(iWordPrediction);
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

