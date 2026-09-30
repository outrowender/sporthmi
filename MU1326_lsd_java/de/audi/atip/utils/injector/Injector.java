/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.injector;

import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.generics.GCopyOnWriteList;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.GMap;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.generics.ReduceFunction;
import de.audi.atip.utils.injector.IInjector;
import de.esolutions.fw.util.commons.Buffer;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantLock;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Injector
implements IInjector {
    public static final Object DEFAULT_SCOPE = "DEFAULT_SCOPE";
    private static final boolean DBG = false;
    private final GMap<Object, GMap<Class, IFactory>> scopes = Generics.newHashMap();
    private final Stack stack = new Stack();
    private final GCopyOnWriteList<Class> implicitBindings = Generics.newCopyOnWriteArrayList();
    private boolean threadUnsafe;
    private final ReentrantLock lock = new ReentrantLock();
    static /* synthetic */ Class class$de$audi$atip$utils$injector$IInjector;

    public static IInjector createInjector(IConfig iConfig) {
        return new Injector(iConfig, false, false);
    }

    public static IInjector createInjector(IConfig iConfig, boolean bl) {
        return new Injector(iConfig, bl, false);
    }

    public static IInjector createSingleThreadInjector(IConfig iConfig) {
        return new Injector(iConfig, false, true);
    }

    @Override
    public <T> T getInstance(Class clazz) {
        return this.getInstanceOrThrow(DEFAULT_SCOPE, clazz);
    }

    @Override
    public <T> T getInstance(Object object, Class clazz) {
        return this.getInstanceOrThrow(object, clazz);
    }

    private <T> T getInstanceOrThrow(Object object, Class clazz) {
        try {
            return (T)this.getInstanceInternal(object, clazz);
        }
        catch (Exception exception) {
            Object object2;
            GList<Exception> gList = Generics.newArrayList();
            for (object2 = exception; object2 != null; object2 = ((Throwable)object2).getCause()) {
                gList.add((Exception)object2);
            }
            object2 = gList.fluent().reduce(new Buffer(), new ReduceFunction<Throwable, Buffer>(){

                @Override
                public Buffer from(Buffer buffer, Throwable throwable) {
                    Buffer buffer2 = buffer.append(throwable.getMessage()).append("\n");
                    return buffer2;
                }

                @Override
                public /* synthetic */ Object from(Object object, Object object2) {
                    return this.from((Buffer)object, (Throwable)object2);
                }
            }).toString();
            throw new RuntimeException((String)object2);
        }
    }

    private Object getInstanceInternal(Object object, Class clazz) {
        if (!this.threadUnsafe) {
            this.lock.lock();
        }
        try {
            Object object2;
            if (this.stack.contains(clazz)) {
                throw new RuntimeException(new StringBuffer().append("Cyclic dependency on ").append(clazz).append("! Stack: ").append(this.stack.toString()).toString());
            }
            this.stack.push(clazz);
            IFactory iFactory = this.getFactoryForScopeOrDefault(object, clazz);
            if (iFactory != null) {
                object2 = iFactory.get(clazz, object);
            } else {
                object2 = Injector.instantiate(clazz, this, object);
                this.implicitBindings.addIfAbsent(clazz);
            }
            this.stack.pop();
            Object object3 = Preconditions.checkNotNull(object2);
            return object3;
        }
        catch (Exception exception) {
            this.stack.clear();
            throw new RuntimeException(new StringBuffer().append(clazz).append(" could not be instantiated for ").append(object).toString(), exception);
        }
        finally {
            if (!this.threadUnsafe) {
                this.lock.unlock();
            }
        }
    }

    private IFactory getFactoryForScopeOrDefault(Object object, Class clazz) {
        IFactory iFactory = this.scopes.get(object).get(clazz);
        if (iFactory != null) {
            return iFactory;
        }
        return this.scopes.get(DEFAULT_SCOPE).get(clazz);
    }

    private Injector(IConfig iConfig, boolean bl, boolean bl2) {
        this.threadUnsafe = bl2;
        this.scopes.put(DEFAULT_SCOPE, Generics.newHashMap());
        this.scopes.get(DEFAULT_SCOPE).put(class$de$audi$atip$utils$injector$IInjector == null ? (class$de$audi$atip$utils$injector$IInjector = Injector.class$("de.audi.atip.utils.injector.IInjector")) : class$de$audi$atip$utils$injector$IInjector, new IFactory(){

            public Object get(Class clazz, Object object) {
                return Injector.this;
            }
        });
        Binder binder = new Binder();
        iConfig.configure(binder);
        this.readConfig(binder);
    }

    private void readConfig(Binder binder) {
        Iterator iterator = binder.getBindings().iterator();
        while (iterator.hasNext()) {
            this.addBinding((Binding)iterator.next());
        }
    }

    private void addBinding(Binding binding) {
        if (binding.instance != null) {
            this.bindToInstance(binding);
        } else if (binding.isSingleton) {
            this.bindAsSingleton(binding);
        } else {
            throw new UnsupportedOperationException(new StringBuffer().append("Error while trying to add binding ").append(binding).append(": cannot instantiate non-singleton objects, yet. Only singletons!").toString());
        }
    }

    private void bindAsSingleton(Binding binding) {
        SingletonFactory singletonFactory = new SingletonFactory(binding);
        GMap<Class, IFactory> gMap = this.getOrCreateScope(binding);
        if (gMap.put(binding.clazz, singletonFactory) != null) {
            throw new RuntimeException(new StringBuffer().append("Binding for ").append(binding.clazz).append(" already existed!").toString());
        }
        if (!binding.boundToClazz.equals(binding.clazz) && gMap.put(binding.boundToClazz, singletonFactory) != null) {
            throw new RuntimeException(new StringBuffer().append("Binding for ").append(binding.boundToClazz).append(" already existed!").toString());
        }
    }

    private GMap<Class, IFactory> getOrCreateScope(Binding binding) {
        GMap<Class, IFactory> gMap = this.scopes.get(binding.scope);
        if (gMap == null) {
            gMap = Generics.newHashMap();
            this.scopes.put(binding.scope, gMap);
        }
        return gMap;
    }

    private void bindToInstance(final Binding binding) {
        this.getOrCreateScope(binding).put(binding.clazz, new IFactory(){

            public Object get(Class clazz, Object object) {
                return binding.instance;
            }
        });
    }

    private static Object instantiate(Class clazz, Injector injector, Object object) throws Exception {
        Constructor[] constructorArray = clazz.getConstructors();
        if (constructorArray.length == 0) {
            if (clazz.isInterface()) {
                throw new RuntimeException(new StringBuffer().append(clazz).append(" was not bound for scope ").append(object).toString());
            }
            throw new RuntimeException(new StringBuffer().append(clazz).append(" has no public constructors!").toString());
        }
        if (constructorArray[0].getParameterTypes().length == 0) {
            return Injector.instantiateWithDefaultConstructor(constructorArray[0]);
        }
        return Injector.instantiateWithConstructorInjection(constructorArray[0], injector, object);
    }

    private static Object instantiateWithDefaultConstructor(Constructor constructor) throws Exception {
        return constructor.newInstance(new Object[0]);
    }

    private static Object instantiateWithConstructorInjection(Constructor constructor, Injector injector, Object object) throws Exception {
        Object[] objectArray = new Object[constructor.getParameterTypes().length];
        for (int i2 = 0; i2 < constructor.getParameterTypes().length; ++i2) {
            Class clazz = constructor.getParameterTypes()[i2];
            objectArray[i2] = injector.getInstanceInternal(object, clazz);
        }
        return constructor.newInstance(objectArray);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    public static class Binder {
        private final List bindings = new ArrayList();

        public Binding bind(Class clazz) {
            Binding binding = new Binding().bind(clazz);
            this.bindings.add(binding);
            return binding;
        }

        public Binding forScope(Object object) {
            Binding binding = new Binding().forScope(object);
            this.bindings.add(binding);
            return binding;
        }

        List getBindings() {
            return this.bindings;
        }
    }

    public static class Binding {
        private Class clazz;
        private Class boundToClazz;
        private boolean isSingleton;
        private Object instance = null;
        private IProvider provider = null;
        private Object scope = DEFAULT_SCOPE;

        public Binding bind(Class clazz) {
            this.clazz = clazz;
            this.boundToClazz = clazz;
            return this;
        }

        public Binding to(Class clazz) {
            this.boundToClazz = clazz;
            return this;
        }

        public Binding toProvider(IProvider iProvider) {
            this.provider = iProvider;
            return this;
        }

        public void asSingleton() {
            this.isSingleton = true;
        }

        public void toInstance(Object object) {
            this.instance = Preconditions.checkNotNull(object);
        }

        public Binding forScope(Object object) {
            this.scope = object;
            return this;
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append("Binding [clazz=");
            buffer.append(this.clazz);
            buffer.append(", boundToClazz=");
            buffer.append(this.boundToClazz);
            buffer.append(", isSingleton=");
            buffer.append(this.isSingleton);
            buffer.append(", instance=");
            buffer.append(this.instance);
            buffer.append(", provider=");
            buffer.append(this.provider);
            buffer.append(", scope=");
            buffer.append(this.scope);
            buffer.append("]");
            return buffer.toString();
        }
    }

    public static interface IConfig {
        public void configure(Binder var1);
    }

    private static interface IFactory {
        public Object get(Class var1, Object var2) throws Exception;
    }

    public static interface IProvider {
        public Object provide(IInjector var1, Object var2) throws Exception;
    }

    private final class SingletonFactory
    implements IFactory {
        private final IProvider provider;
        private Object object;

        private SingletonFactory(Binding binding) {
            this.provider = binding.provider != null ? binding.provider : new ConstructorInjectionProvider(binding);
        }

        public Object get(Class clazz, Object object) throws Exception {
            if (this.object == null) {
                this.object = this.provider.provide(Injector.this, object);
            }
            return this.object;
        }
    }

    private static final class ConstructorInjectionProvider
    implements IProvider {
        private final Binding binding;

        private ConstructorInjectionProvider(Binding binding) {
            this.binding = binding;
        }

        public Object provide(IInjector iInjector, Object object) throws Exception {
            try {
                return Injector.instantiate(this.binding.boundToClazz, (Injector)iInjector, object);
            }
            catch (Exception exception) {
                if (this.binding.boundToClazz.equals(this.binding.clazz)) {
                    throw new Exception(new StringBuffer().append("Cannot provide ").append(this.binding.boundToClazz).toString(), exception);
                }
                throw new Exception(new StringBuffer().append("Cannot provide ").append(this.binding.clazz).append(" bound to ").append(this.binding.boundToClazz).toString(), exception);
            }
        }
    }
}

