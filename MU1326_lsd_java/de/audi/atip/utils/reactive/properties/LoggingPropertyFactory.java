/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.properties;

import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.reactive.Disposable;
import de.audi.atip.utils.reactive.properties.AcceptHook;
import de.audi.atip.utils.reactive.properties.NotifyOnAddProperty;
import de.audi.atip.utils.reactive.properties.Property;
import de.audi.atip.utils.reactive.properties.PropertyFactory;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class LoggingPropertyFactory
implements PropertyFactory,
Disposable {
    private final GList<NotifyOnAddProperty<?>> createdProperties = Generics.newArrayList();
    private final AcceptHook<Object> hook;

    public static LoggingPropertyFactory create(LogChannel logChannel, int n) {
        return new LoggingPropertyFactory(LoggingPropertyFactory.createDefaultLoggingHook(logChannel, n));
    }

    public static AcceptHook<Object> createDefaultLoggingHook(final LogChannel logChannel, final int n) {
        return new AcceptHook<Object>(){

            @Override
            public void onAccept(String string, Object object) {
                logChannel.log(n, "[IPropertyHook(%1).onAccept] %2", (Object)string, object);
            }
        };
    }

    public static LoggingPropertyFactory create() {
        return new LoggingPropertyFactory(AcceptHook.STUB);
    }

    protected LoggingPropertyFactory(AcceptHook<Object> acceptHook) {
        this.hook = Preconditions.checkNotNull(acceptHook);
    }

    @Override
    public <T> Property<T> createProperty(String string) {
        NotifyOnAddProperty<Object> notifyOnAddProperty = NotifyOnAddProperty.create(string, this.hook);
        this.createdProperties.add(notifyOnAddProperty);
        return notifyOnAddProperty;
    }

    @Override
    public <T> Property<T> createProperty(String string, T t) {
        Property<T> property = this.createProperty(string);
        property.accept(t);
        return property;
    }

    @Override
    public <T> Property<T> createProperty(String string, LogChannel logChannel, int n) {
        NotifyOnAddProperty<Object> notifyOnAddProperty = NotifyOnAddProperty.create(string, LoggingPropertyFactory.createDefaultLoggingHook(logChannel, n));
        this.createdProperties.add(notifyOnAddProperty);
        return notifyOnAddProperty;
    }

    @Override
    public <T> Property<T> createProperty(String string, T t, LogChannel logChannel, int n) {
        Property<T> property = this.createProperty(string, logChannel, n);
        property.accept(t);
        return property;
    }

    @Override
    public void dispose() {
        GIterator<NotifyOnAddProperty<?>> gIterator = this.createdProperties.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().dispose();
        }
        this.createdProperties.clear();
    }
}

