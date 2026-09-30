/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.collections.Optional;
import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.collections.Predicates;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.generics.Function;
import de.audi.atip.utils.generics.GCollection;
import de.audi.atip.utils.generics.GCollectionWrapper;
import de.audi.atip.utils.generics.GComparator;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.generics.ICollector;
import de.audi.atip.utils.generics.IFluentCollection;
import de.audi.atip.utils.generics.Matcher;
import de.audi.atip.utils.generics.ReduceFunction;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class FluentCollection<T>
implements IFluentCollection<T> {
    private final GCollection<T> collection;

    private FluentCollection(GCollection<T> gCollection) {
        this.collection = Preconditions.checkNotNull(gCollection);
    }

    public static <T> FluentCollection<T> from(Collection collection) {
        return FluentCollection.from(new GCollectionWrapper(collection));
    }

    public static <T> FluentCollection<T> from(GCollection<T> gCollection) {
        return new FluentCollection<T>(Generics.newArrayList(gCollection));
    }

    public static <T> FluentCollection<T> from(T[] TArray) {
        return new FluentCollection<T>(Generics.newArrayList(TArray));
    }

    @Override
    public FluentCollection<T> log(LogChannel logChannel, String string) {
        logChannel.log(10000000, "[FluentCollection.log] %1 %2", (Object)string, (Object)this);
        return this;
    }

    @Override
    public FluentCollection<T> distinctUntilChanged() {
        GList<T> gList = Generics.newArrayListWithCapacity(this.collection.size());
        Object var2_2 = null;
        GIterator<T> gIterator = this.collection.iterator();
        while (gIterator.hasNext()) {
            T t = gIterator.next();
            if (t.equals(var2_2)) continue;
            gList.add(t);
            var2_2 = t;
        }
        return FluentCollection.from(gList);
    }

    @Override
    public IFluentCollection<T> distinct() {
        return FluentCollection.from(new HashSet(this.collection.getBackingCollection()));
    }

    @Override
    public FluentCollection<T> take(int n) {
        return FluentCollection.from(this.toList().subList(0, n));
    }

    @Override
    public FluentCollection<T> filter(Predicate<T> predicate) {
        return FluentCollection.from(Predicates.filter(this.collection, predicate));
    }

    @Override
    public Optional<T> tryFind(Predicate<T> predicate) {
        return Predicates.tryFind(this.collection, predicate);
    }

    public <R> FluentCollection<R> transform(Function<? super T, R> function) {
        return this.map((Function)function);
    }

    @Override
    public <R> FluentCollection<R> map(Function<? super T, R> function) {
        GList<R> gList = Generics.newArrayListWithCapacity(this.collection.size());
        GIterator<T> gIterator = this.collection.iterator();
        while (gIterator.hasNext()) {
            gList.add(function.apply(gIterator.next()));
        }
        return FluentCollection.from(gList);
    }

    @Override
    public <Out> Out reduce(Out Out, ReduceFunction<? super T, Out> reduceFunction) {
        Out Out2 = Out;
        GIterator<T> gIterator = this.collection.iterator();
        while (gIterator.hasNext()) {
            Out2 = reduceFunction.from(Out2, gIterator.next());
        }
        return Out2;
    }

    @Override
    public <R> FluentCollection<R> flatMap(Function<? super T, GCollection<R>> function) {
        GList<R> gList = Generics.newArrayListWithCapacity(this.collection.size());
        GIterator<T> gIterator = this.collection.iterator();
        while (gIterator.hasNext()) {
            gList.addAll(function.apply(gIterator.next()));
        }
        return FluentCollection.from(gList);
    }

    @Override
    public FluentCollection<T> sort(GComparator<T> gComparator) {
        Generics.sort((GList)this.collection, gComparator);
        return FluentCollection.from(this.collection);
    }

    @Override
    public FluentCollection<T> forEach(Consumer<T> consumer) {
        GIterator<T> gIterator = this.collection.iterator();
        while (gIterator.hasNext()) {
            consumer.accept(gIterator.next());
        }
        return this;
    }

    @Override
    public Optional<T> first() {
        return new Optional<Object>((this.collection.isEmpty() ? null : (Object)this.collection.iterator().next()));
    }

    @Override
    public <ResultType> ResultType collect(ICollector<T, ResultType> iCollector) {
        ResultType ResultType = iCollector.createContainer();
        GIterator<T> gIterator = this.collection.iterator();
        while (gIterator.hasNext()) {
            iCollector.add(ResultType, gIterator.next());
        }
        return ResultType;
    }

    @Override
    public <R> FluentCollection<T> retainAll(GCollection<R> gCollection, Matcher<T, R> matcher) {
        GList<T> gList = Generics.newArrayListWithCapacity(this.collection.size());
        GIterator<T> gIterator = this.collection.iterator();
        block0: while (gIterator.hasNext()) {
            T t = gIterator.next();
            GIterator<R> gIterator2 = gCollection.iterator();
            while (gIterator2.hasNext()) {
                R r = gIterator2.next();
                if (!matcher.matches(t, r)) continue;
                gList.add(t);
                continue block0;
            }
        }
        return FluentCollection.from(gList);
    }

    @Override
    public GList<T> toList() {
        return (GList)this.collection;
    }

    @Override
    public List toListCompat() {
        return (List)this.collection.getBackingCollection();
    }

    @Override
    public T[] toArray(T[] TArray) {
        return this.collection.toArray(TArray);
    }

    @Override
    public GIterator<T> iterator() {
        return this.collection.iterator();
    }

    public String toString() {
        return this.collection.toString();
    }

    @Override
    public IFluentCollection.PartitionResult<T> partition(Predicate<T> predicate) {
        final GList<T> gList = Generics.newArrayListWithCapacity(this.collection.size());
        final GList<T> gList2 = Generics.newArrayListWithCapacity(this.collection.size());
        GIterator<T> gIterator = this.collection.iterator();
        while (gIterator.hasNext()) {
            T t = gIterator.next();
            if (predicate.apply(t)) {
                gList.add(t);
                continue;
            }
            gList2.add(t);
        }
        return new IFluentCollection.PartitionResult<T>(){

            @Override
            public GList<T> applied() {
                return gList;
            }

            @Override
            public GList<T> rejected() {
                return gList2;
            }
        };
    }

    @Override
    public /* synthetic */ IFluentCollection forEach(Consumer consumer) {
        return this.forEach(consumer);
    }

    @Override
    public /* synthetic */ IFluentCollection sort(GComparator gComparator) {
        return this.sort(gComparator);
    }

    @Override
    public /* synthetic */ IFluentCollection retainAll(GCollection gCollection, Matcher matcher) {
        return this.retainAll(gCollection, matcher);
    }

    @Override
    public /* synthetic */ IFluentCollection flatMap(Function function) {
        return this.flatMap(function);
    }

    @Override
    public /* synthetic */ IFluentCollection take(int n) {
        return this.take(n);
    }

    @Override
    public /* synthetic */ IFluentCollection map(Function function) {
        return this.map(function);
    }

    @Override
    public /* synthetic */ IFluentCollection log(LogChannel logChannel, String string) {
        return this.log(logChannel, string);
    }

    @Override
    public /* synthetic */ IFluentCollection filter(Predicate predicate) {
        return this.filter(predicate);
    }

    @Override
    public /* synthetic */ IFluentCollection distinctUntilChanged() {
        return this.distinctUntilChanged();
    }
}

