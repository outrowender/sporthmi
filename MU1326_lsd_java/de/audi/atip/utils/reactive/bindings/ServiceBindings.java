/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.bindings;

import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.reactive.Disposable;
import de.audi.atip.utils.reactive.bindings.IServiceBindings;
import de.audi.atip.utils.reactive.observables.Observable;
import de.audi.atip.utils.reactive.properties.LoggingPropertyFactory;
import de.audi.atip.utils.reactive.properties.Property;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ServiceBindings
implements Disposable,
IServiceBindings {
    private final IServiceWrappingStrategy wrappingStrategy;
    private final BundleContext bundleContext;
    private final LoggingPropertyFactory propertyFactory;
    private final GList<ServiceTracker> trackers = Generics.newArrayList();

    public static ServiceBindings create(BundleContext bundleContext, IServiceWrappingStrategy iServiceWrappingStrategy) {
        return new ServiceBindings(bundleContext, iServiceWrappingStrategy);
    }

    public static IServiceBindings create(BundleContext bundleContext) {
        return new ServiceBindings(bundleContext, new IServiceWrappingStrategy(){

            public Object wrap(String string, Object object) {
                return object;
            }
        });
    }

    private ServiceBindings(BundleContext bundleContext, IServiceWrappingStrategy iServiceWrappingStrategy) {
        this.wrappingStrategy = Preconditions.checkNotNull(iServiceWrappingStrategy);
        this.bundleContext = Preconditions.checkNotNull(bundleContext);
        this.propertyFactory = LoggingPropertyFactory.create();
    }

    @Override
    public <T> Observable<T> track(Class clazz, final T t, final Predicate<ServiceReference> predicate) {
        final Property<T> property = this.propertyFactory.createProperty(clazz.getName());
        property.accept(t);
        ServiceTracker serviceTracker = new ServiceTracker(this.bundleContext, clazz.getName(), new ServiceTrackerCustomizer(){

            @Override
            public void removedService(ServiceReference serviceReference, Object object) {
                ServiceBindings.this.bundleContext.ungetService(serviceReference);
                property.accept(t);
            }

            @Override
            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            @Override
            public Object addingService(ServiceReference serviceReference) {
                Object t2 = this.getAndWrap(serviceReference);
                if (predicate.apply(serviceReference)) {
                    property.accept(t2);
                }
                return t2;
            }

            private T getAndWrap(ServiceReference serviceReference) {
                Object object = ServiceBindings.this.bundleContext.getService(serviceReference);
                String[] stringArray = (String[])serviceReference.getProperty("objectClass");
                if (stringArray.length == 1) {
                    return ServiceBindings.this.wrappingStrategy.wrap(stringArray[0], object);
                }
                return object;
            }
        });
        serviceTracker.open();
        this.trackers.add(serviceTracker);
        return property.observe();
    }

    @Override
    public <T> Observable<T> track(Class clazz, T t) {
        return this.track(clazz, t, new Predicate<ServiceReference>(){

            @Override
            public boolean apply(ServiceReference serviceReference) {
                return true;
            }

            @Override
            public /* synthetic */ boolean apply(Object object) {
                return this.apply((ServiceReference)object);
            }
        });
    }

    @Override
    public void dispose() {
        this.propertyFactory.dispose();
        this.trackers.fluent().forEach(new Consumer<ServiceTracker>(){

            @Override
            public void accept(ServiceTracker serviceTracker) {
                serviceTracker.close();
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((ServiceTracker)object);
            }
        });
    }

    public static interface IServiceWrappingStrategy {
        public Object wrap(String var1, Object var2);
    }
}

