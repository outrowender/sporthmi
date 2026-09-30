/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.observables;

import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.generics.Function;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.ICollector;
import de.audi.atip.utils.reactive.observables.Observables;
import de.audi.atip.utils.reactive.observables.Sink;
import de.audi.atip.utils.reactive.observables.Subscription;
import de.audi.atip.utils.reactive.operations.Operation;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface Observable<T> {
    public Observable<T> log(LogChannel var1, String var2);

    public Observable<T> distinctUntilChanged();

    public Observable<T> filter(Predicate<T> var1);

    public Observable<T> tee(Consumer<T> var1);

    public <ResultType> Observable<ResultType> map(Function<? super T, ResultType> var1);

    public <ResultType> Observable<ResultType> extendPipelineWith(Operation<T, ResultType> var1);

    public Observable<T> debounce(int var1, IDispatcher var2);

    public Observable<T> async(IDispatcher var1);

    public Observable<T> ensureThread(IDispatcher var1);

    public Observable<GList<T>> buffer(int var1, IDispatcher var2);

    public <B> Observables.Combinable<T, B> combineWith(Observable<B> var1);

    public <B> Observables.Combinable<T, B> withLatestFrom(Observable<B> var1);

    public Subscription redirectTo(Consumer<T> var1);

    public Subscription subscribe(Consumer<T> var1);

    public Subscription subscribe(Sink<? super T> var1);

    public Observable<T> take(int var1);

    public <ResultType> Observable<ResultType> collect(ICollector<T, ResultType> var1);
}

