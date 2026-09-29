/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.log;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.atip.log.LogChannelFactory;
import de.audi.atip.log.LogServAdmin;
import de.audi.atip.log.LogSink;
import de.audi.atip.log.NullLogServImpl;
import de.audi.tghu.log.LogServImpl;
import de.audi.tghu.log.StandardConsoleSink;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class LogActivator
extends AbstractFrameworkActivator
implements ServiceTrackerCustomizer {
    private static final boolean STD_CONSOLE_SINK_ACTIVE;
    private ServiceTracker tracker;
    private Object service;
    private LogSink stdConsoleSink;
    static /* synthetic */ Class class$de$audi$atip$log$LogSink;

    public LogActivator() {
        super("FwLog");
    }

    public LogChannelFactory getLogService() {
        return (LogChannelFactory)this.service;
    }

    private LogServAdmin getLogServAdmin() {
        return (LogServAdmin)this.service;
    }

    @Override
    protected void startInternal(BundleContext bundleContext) {
        this.service = Boolean.getBoolean("DISABLE_LOGGING") ? NullLogServImpl.getInstance() : new LogServImpl(this.framework);
        this.tracker = new ServiceTracker(this.getBundleContext(), (class$de$audi$atip$log$LogSink == null ? (class$de$audi$atip$log$LogSink = LogActivator.class$("de.audi.atip.log.LogSink")) : class$de$audi$atip$log$LogSink).getName(), (ServiceTrackerCustomizer)this);
        this.tracker.open();
        this.stdConsoleSink = new StandardConsoleSink();
        this.getLogServAdmin().addLogSink(this.stdConsoleSink);
        this.stdConsoleSink.setConfiguration(LogServImpl.decodeLogConfig(System.getProperty("LOG")));
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.getLogServAdmin().removeLogSink(this.stdConsoleSink);
        if (this.tracker != null) {
            this.tracker.close();
            this.tracker = null;
        }
        super.stop(bundleContext);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getBundleContext().getService(serviceReference);
        if (!(object instanceof LogSink)) {
            return null;
        }
        this.getLogServAdmin().addLogSink((LogSink)object);
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (!(object instanceof LogSink)) {
            return;
        }
        this.getLogServAdmin().removeLogSink((LogSink)object);
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

