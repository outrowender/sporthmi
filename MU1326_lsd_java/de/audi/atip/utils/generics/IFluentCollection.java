/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.collections.Optional;
import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.generics.Function;
import de.audi.atip.utils.generics.GCollection;
import de.audi.atip.utils.generics.GComparator;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.ICollector;
import de.audi.atip.utils.generics.Matcher;
import de.audi.atip.utils.generics.ReduceFunction;
import java.util.List;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface IFluentCollection<T> {
    public IFluentCollection<T> distinctUntilChanged();

    public IFluentCollection<T> filter(Predicate<T> var1);

    public IFluentCollection<T> log(LogChannel var1, String var2);

    public <ResultType> IFluentCollection<ResultType> map(Function<? super T, ResultType> var1);

    public IFluentCollection<T> take(int var1);

    public <R> IFluentCollection<R> flatMap(Function<? super T, GCollection<R>> var1);

    public IFluentCollection<T> distinct();

    public <R> IFluentCollection<T> retainAll(GCollection<R> var1, Matcher<T, R> var2);

    public IFluentCollection<T> sort(GComparator<T> var1);

    public <Out> Out reduce(Out var1, ReduceFunction<? super T, Out> var2);

    public IFluentCollection<T> forEach(Consumer<T> var1);

    public Optional<T> first();

    public Optional<T> tryFind(Predicate<T> var1);

    public <ResultType> ResultType collect(ICollector<T, ResultType> var1);

    public GList<T> toList();

    public List toListCompat();

    public T[] toArray(T[] var1);

    public GIterator<T> iterator();

    public PartitionResult<T> partition(Predicate<T> var1);

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface PartitionResult<T> {
        public GList<T> applied();

        public GList<T> rejected();
    }
}

