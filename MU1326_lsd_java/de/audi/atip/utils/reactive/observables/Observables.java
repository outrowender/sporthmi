/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.observables;

import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.generics.GCollection;
import de.audi.atip.utils.reactive.bindings.ModelBindings;
import de.audi.atip.utils.reactive.bindings.SilentModelBindings;
import de.audi.atip.utils.reactive.concrete.Combinations;
import de.audi.atip.utils.reactive.observables.Observable;
import de.audi.atip.utils.reactive.observables.Pipe;
import de.audi.atip.utils.reactive.observables.Single;
import de.audi.atip.utils.reactive.observables.SingleSource;
import de.audi.atip.utils.reactive.observables.Sink;
import de.audi.atip.utils.reactive.observables.Source;
import de.audi.atip.utils.reactive.observables.Subscription;
import de.audi.atip.utils.reactive.properties.LoggingPropertyFactory;
import de.audi.atip.utils.reactive.properties.PropertyFactory;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Observables {
    public static PropertyFactory createPropertyFactory(LogChannel logChannel, int n, String string) {
        return LoggingPropertyFactory.create(logChannel, n);
    }

    public static ModelBindings createModelBindings() {
        return SilentModelBindings.create();
    }

    public static <T> Observable<T> emitOnceFrom(GCollection<T> gCollection) {
        return Observables.emitOnceFrom(gCollection.getBackingCollection());
    }

    public static <T> Observable<T> emitOnceFrom(final Collection collection) {
        return Observables.createFromSingle(new SingleSource<T>(){

            @Override
            protected void onSinkConnected(Sink<T> sink) {
                Iterator iterator = Collections.unmodifiableCollection(collection).iterator();
                while (iterator.hasNext()) {
                    sink.accept(iterator.next());
                }
                sink.closed();
            }
        });
    }

    public static <T> Observable<T> emitElementsOnce(T[] TArray) {
        return Observables.emitOnceFrom(Arrays.asList(TArray));
    }

    public static <T> Observable<T> createFromSource(Source<T> source) {
        return Pipe.createFromSource(source);
    }

    public static <T> Single<T> createFromSingle(SingleSource<T> singleSource) {
        return Pipe.createFromSingle(singleSource);
    }

    public static <A, B> Combinable<A, B> combineLatest(Observable<A> observable, Observable<B> observable2) {
        return Combinations.combineLatest(observable, observable2);
    }

    public static <A, B, C> Combinable3<A, B, C> combineLatest(Observable<A> observable, Observable<B> observable2, Observable<C> observable3) {
        return Combinations.combineLatest(observable, observable2, observable3);
    }

    public static <A, B, C, D> Combinable4<A, B, C, D> combineLatest(Observable<A> observable, Observable<B> observable2, Observable<C> observable3, Observable<D> observable4) {
        return Combinations.combineLatest(observable, observable2, observable3, observable4);
    }

    public static <A, B, C, D, E> Combinable5<A, B, C, D, E> combineLatest(Observable<A> observable, Observable<B> observable2, Observable<C> observable3, Observable<D> observable4, Observable<E> observable5) {
        return Combinations.combineLatest(observable, observable2, observable3, observable4, observable5);
    }

    public static <A, B> Zippable<A, B> zip(Observable<A> observable, Observable<B> observable2) {
        return Combinations.zip(observable, observable2);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface Zippable<A, B> {
        public <T> Observable<T> using(Combinator<A, B, T> var1);

        public Subscription subscribe(Consumer2<A, B> var1);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface Consumer2<A, B> {
        public void accept(A var1, B var2);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface Consumer3<A, B, C> {
        public void accept(A var1, B var2, C var3);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface Consumer4<A, B, C, D> {
        public void accept(A var1, B var2, C var3, D var4);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface Consumer5<A, B, C, D, E> {
        public void accept(A var1, B var2, C var3, D var4, E var5);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface Combinable<A, B> {
        public <T> Observable<T> using(Combinator<A, B, T> var1);

        public Subscription subscribe(Consumer2<A, B> var1);

        public <C> Combinable3<A, B, C> combineWith(Observable<C> var1);

        public <C> Combinable3<A, B, C> withLatestFrom(Observable<C> var1);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface Combinator<A, B, T> {
        public T combine(A var1, B var2);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface Combinable1<A> {
        public <B> Combinable<A, B> combineWith(Observable<B> var1);

        public <B> Combinable<A, B> withLatestFrom(Observable<B> var1);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface Combinable3<A, B, C> {
        public <T> Observable<T> using(Combinator3<A, B, C, T> var1);

        public Subscription subscribe(Consumer3<A, B, C> var1);

        public <D> Combinable4<A, B, C, D> combineWith(Observable<D> var1);

        public <D> Combinable4<A, B, C, D> withLatestFrom(Observable<D> var1);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface Combinable4<A, B, C, D> {
        public <T> Observable<T> using(Combinator4<A, B, C, D, T> var1);

        public Subscription subscribe(Consumer4<A, B, C, D> var1);

        public <E> Combinable5<A, B, C, D, E> combineWith(Observable<E> var1);

        public <E> Combinable5<A, B, C, D, E> withLatestFrom(Observable<E> var1);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface Combinable5<A, B, C, D, E> {
        public <T> Observable<T> using(Combinator5<A, B, C, D, E, T> var1);

        public Subscription subscribe(Consumer5<A, B, C, D, E> var1);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface Combinator3<A, B, C, T> {
        public T combine(A var1, B var2, C var3);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface Combinator4<A, B, C, D, T> {
        public T combine(A var1, B var2, C var3, D var4);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface Combinator5<A, B, C, D, E, T> {
        public T combine(A var1, B var2, C var3, D var4, E var5);
    }
}

