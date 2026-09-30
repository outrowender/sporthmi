/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.observables;

import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.generics.Function;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.ICollector;
import de.audi.atip.utils.reactive.concrete.Combinations;
import de.audi.atip.utils.reactive.observables.BackChannel;
import de.audi.atip.utils.reactive.observables.Observable;
import de.audi.atip.utils.reactive.observables.Observables;
import de.audi.atip.utils.reactive.observables.Single;
import de.audi.atip.utils.reactive.observables.SingleSource;
import de.audi.atip.utils.reactive.observables.Sink;
import de.audi.atip.utils.reactive.observables.Source;
import de.audi.atip.utils.reactive.observables.Subscription;
import de.audi.atip.utils.reactive.operations.AsyncOperation;
import de.audi.atip.utils.reactive.operations.BufferOverTimeOperation;
import de.audi.atip.utils.reactive.operations.CollectOperation;
import de.audi.atip.utils.reactive.operations.DebounceOperation;
import de.audi.atip.utils.reactive.operations.DistinctUntilChangedOperation;
import de.audi.atip.utils.reactive.operations.EnsureThreadOperation;
import de.audi.atip.utils.reactive.operations.FilterOperation;
import de.audi.atip.utils.reactive.operations.LogOperation;
import de.audi.atip.utils.reactive.operations.MapOperation;
import de.audi.atip.utils.reactive.operations.Operation;
import de.audi.atip.utils.reactive.operations.TakeOperation;
import de.audi.atip.utils.reactive.operations.TeeOperation;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Pipe<T>
implements Observable<T>,
Single<T> {
    private final Source<T> source;

    public static <T> Pipe<T> createFromSource(Source<T> source) {
        return new Pipe<T>(source);
    }

    public static <T> Single<T> createFromSingle(SingleSource<T> singleSource) {
        return new Pipe<T>(singleSource);
    }

    protected Pipe(Source<T> source) {
        this.source = Preconditions.checkNotNull(source);
    }

    @Override
    public <ResultType> Observable<ResultType> extendPipelineWith(final Operation<T, ResultType> operation) {
        return new Pipe<T>(new Source<ResultType>(){

            @Override
            public BackChannel setSink(Sink<ResultType> sink) {
                Sink sink2 = operation.decorateSink(sink);
                return Pipe.this.source.setSink(sink2);
            }
        });
    }

    @Override
    public Subscription subscribe(Sink<? super T> sink) {
        final BackChannel backChannel = this.source.setSink(sink);
        return new Subscription(){

            @Override
            public void cancel() {
                backChannel.disconnect();
            }

            @Override
            public Subscription addTo(GList<Subscription> gList) {
                gList.add(this);
                return this;
            }
        };
    }

    @Override
    public Subscription subscribe(final Consumer<T> consumer) {
        return this.subscribe(new Sink<T>(){

            @Override
            public void accept(T t) {
                consumer.accept(t);
            }

            @Override
            public void closed() {
            }
        });
    }

    @Override
    public Subscription redirectTo(Consumer<T> consumer) {
        return this.subscribe(consumer);
    }

    @Override
    public Observable<T> debounce(int n, IDispatcher iDispatcher) {
        return this.extendPipelineWith(new DebounceOperation(n, iDispatcher));
    }

    @Override
    public Observable<T> async(IDispatcher iDispatcher) {
        return this.extendPipelineWith(new AsyncOperation(iDispatcher));
    }

    @Override
    public Observable<T> ensureThread(IDispatcher iDispatcher) {
        return this.extendPipelineWith(new EnsureThreadOperation(iDispatcher));
    }

    @Override
    public Observable<T> distinctUntilChanged() {
        return this.extendPipelineWith(new DistinctUntilChangedOperation());
    }

    @Override
    public Observable<T> filter(Predicate<T> predicate) {
        return this.extendPipelineWith(new FilterOperation<T>(predicate));
    }

    @Override
    public Observable<T> tee(Consumer<T> consumer) {
        return this.extendPipelineWith(new TeeOperation<T>(consumer));
    }

    @Override
    public <OutType> Observable<OutType> map(Function<? super T, OutType> function) {
        return this.extendPipelineWith(new MapOperation<T, OutType>(function));
    }

    @Override
    public Observable<T> log(LogChannel logChannel, String string) {
        return this.extendPipelineWith(new LogOperation(logChannel, string));
    }

    @Override
    public Observable<T> take(int n) {
        return this.extendPipelineWith(new TakeOperation(n));
    }

    @Override
    public <ResultType> Observable<ResultType> collect(ICollector<T, ResultType> iCollector) {
        return this.extendPipelineWith(new CollectOperation<T, ResultType>(iCollector));
    }

    @Override
    public <B> Observables.Combinable<T, B> combineWith(Observable<B> observable) {
        return Combinations.prepareCombinable(this).combineWith(observable);
    }

    @Override
    public <B> Observables.Combinable<T, B> withLatestFrom(Observable<B> observable) {
        return Combinations.prepareCombinable(this).withLatestFrom(observable);
    }

    @Override
    public Observable<GList<T>> buffer(int n, IDispatcher iDispatcher) {
        return this.extendPipelineWith(new BufferOverTimeOperation(n, iDispatcher));
    }
}

