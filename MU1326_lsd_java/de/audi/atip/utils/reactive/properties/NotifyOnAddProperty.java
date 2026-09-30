/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.properties;

import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.generics.Function;
import de.audi.atip.utils.generics.GCopyOnWriteList;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.generics.ICollector;
import de.audi.atip.utils.reactive.Disposable;
import de.audi.atip.utils.reactive.observables.BackChannel;
import de.audi.atip.utils.reactive.observables.Observable;
import de.audi.atip.utils.reactive.observables.Observables;
import de.audi.atip.utils.reactive.observables.Pipe;
import de.audi.atip.utils.reactive.observables.Sink;
import de.audi.atip.utils.reactive.observables.Source;
import de.audi.atip.utils.reactive.observables.Subscription;
import de.audi.atip.utils.reactive.operations.Operation;
import de.audi.atip.utils.reactive.properties.AcceptHook;
import de.audi.atip.utils.reactive.properties.Property;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class NotifyOnAddProperty<T>
implements Consumer<T>,
Property<T>,
Disposable {
    private final AcceptHook<? super T> hook;
    private final String tag;
    private final GCopyOnWriteList<Sink<T>> sinks = Generics.newCopyOnWriteList();
    protected volatile T data;

    public static <T> NotifyOnAddProperty<T> create(String string, AcceptHook<? super T> acceptHook) {
        return new NotifyOnAddProperty<T>(string, acceptHook);
    }

    public static <T> Property<T> createAnonymous() {
        return new NotifyOnAddProperty<Object>("", AcceptHook.STUB);
    }

    protected NotifyOnAddProperty(String string, AcceptHook<? super T> acceptHook) {
        this.tag = Preconditions.checkNotNull(string);
        this.hook = Preconditions.checkNotNull(acceptHook);
    }

    @Override
    public final void accept(T t) {
        this.data = t;
        this.hook.onAccept(this.tag, t);
        if (!this.sinks.isEmpty()) {
            GIterator gIterator = this.sinks.iterator();
            while (gIterator.hasNext()) {
                ((Sink)gIterator.next()).accept(t);
            }
        }
    }

    @Override
    public final T get() {
        return this.data;
    }

    @Override
    public final Observable<T> observeNonSticky() {
        return Pipe.createFromSource(new Source<T>(){

            @Override
            public BackChannel setSink(final Sink<T> sink) {
                NotifyOnAddProperty.this.sinks.add(sink);
                return new BackChannel(){

                    public void disconnect() {
                        NotifyOnAddProperty.this.sinks.remove(sink);
                    }
                };
            }
        });
    }

    private Observable<T> createObservable() {
        return Pipe.createFromSource(new Source<T>(){

            @Override
            public BackChannel setSink(final Sink<T> sink) {
                NotifyOnAddProperty.this.sinks.add(sink);
                if (NotifyOnAddProperty.this.data != null) {
                    sink.accept(NotifyOnAddProperty.this.data);
                }
                return new BackChannel(){

                    public void disconnect() {
                        NotifyOnAddProperty.this.sinks.remove(sink);
                    }
                };
            }
        });
    }

    @Override
    public final Observable<T> observe() {
        return this.createObservable();
    }

    @Override
    public final String getTag() {
        return this.tag;
    }

    public String toString() {
        return new StringBuffer().append("Property [").append(this.tag).append(", data=").append(this.data).append("]").toString();
    }

    @Override
    public void dispose() {
        this.sinks.clear();
    }

    @Override
    public Observable<T> log(LogChannel logChannel, String string) {
        return this.createObservable().log(logChannel, string);
    }

    @Override
    public Observable<T> distinctUntilChanged() {
        return this.createObservable().distinctUntilChanged();
    }

    @Override
    public Observable<T> filter(Predicate<T> predicate) {
        return this.createObservable().filter(predicate);
    }

    @Override
    public <ResultType> Observable<ResultType> map(Function<? super T, ResultType> function) {
        return this.createObservable().map(function);
    }

    @Override
    public <ResultType> Observable<ResultType> extendPipelineWith(Operation<T, ResultType> operation) {
        return this.createObservable().extendPipelineWith(operation);
    }

    @Override
    public Observable<T> debounce(int n, IDispatcher iDispatcher) {
        return this.createObservable().debounce(n, iDispatcher);
    }

    @Override
    public Observable<T> async(IDispatcher iDispatcher) {
        return this.createObservable().async(iDispatcher);
    }

    @Override
    public Observable<T> ensureThread(IDispatcher iDispatcher) {
        return this.createObservable().ensureThread(iDispatcher);
    }

    @Override
    public Observable<T> tee(Consumer<T> consumer) {
        return this.createObservable().tee(consumer);
    }

    @Override
    public Observable<GList<T>> buffer(int n, IDispatcher iDispatcher) {
        return this.createObservable().buffer(n, iDispatcher);
    }

    @Override
    public <B> Observables.Combinable<T, B> combineWith(Observable<B> observable) {
        return this.createObservable().combineWith(observable);
    }

    @Override
    public <B> Observables.Combinable<T, B> withLatestFrom(Observable<B> observable) {
        return this.createObservable().withLatestFrom(observable);
    }

    @Override
    public Subscription redirectTo(Consumer<T> consumer) {
        return this.createObservable().redirectTo(consumer);
    }

    @Override
    public Observable<T> take(int n) {
        return this.createObservable().take(n);
    }

    @Override
    public <ResultType> Observable<ResultType> collect(ICollector<T, ResultType> iCollector) {
        return this.createObservable().collect(iCollector);
    }

    @Override
    public Subscription subscribe(Consumer<T> consumer) {
        return this.createObservable().subscribe(consumer);
    }

    @Override
    public Subscription subscribe(Sink<? super T> sink) {
        return this.createObservable().subscribe(sink);
    }
}

