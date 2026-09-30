/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.concrete;

import de.audi.atip.utils.collections.CopyOnWriteArrayList;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.reactive.observables.BackChannel;
import de.audi.atip.utils.reactive.observables.Observable;
import de.audi.atip.utils.reactive.observables.Observables;
import de.audi.atip.utils.reactive.observables.Pipe;
import de.audi.atip.utils.reactive.observables.Sink;
import de.audi.atip.utils.reactive.observables.Source;
import de.audi.atip.utils.reactive.observables.Subscription;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Combinations {
    private static final Object BUNG = new Object();
    private static final Consumer<Void> STUB = new Consumer<Void>(){

        @Override
        public void accept(Void void_) {
        }

        @Override
        public /* synthetic */ void accept(Object object) {
            this.accept((Void)object);
        }
    };

    public static <A> Observables.Combinable1<A> prepareCombinable(Observable<A> observable) {
        final ArrayCombinable arrayCombinable = new ArrayCombinable();
        arrayCombinable.add(observable, true);
        return new Observables.Combinable1<A>(){

            @Override
            public <B> Observables.Combinable<A, B> combineWith(Observable<B> observable) {
                arrayCombinable.add(observable, true);
                return this.createCombinable();
            }

            @Override
            public <B> Observables.Combinable<A, B> withLatestFrom(Observable<B> observable) {
                arrayCombinable.add(observable, false);
                return this.createCombinable();
            }

            private <B> Observables.Combinable<A, B> createCombinable() {
                return new Observables.Combinable<A, B>(){

                    @Override
                    public <T> Observable<T> using(final Observables.Combinator<A, B, T> combinator) {
                        return arrayCombinable.using(new UnsafeCombinator<T>(){

                            @Override
                            public T combine(Iterator iterator) {
                                return combinator.combine(iterator.next(), iterator.next());
                            }
                        });
                    }

                    @Override
                    public Subscription subscribe(final Observables.Consumer2<A, B> consumer2) {
                        return arrayCombinable.using(new UnsafeCombinator<Void>(){

                            @Override
                            public Void combine(Iterator iterator) {
                                consumer2.accept(iterator.next(), iterator.next());
                                return null;
                            }

                            @Override
                            public /* synthetic */ Object combine(Iterator iterator) {
                                return this.combine(iterator);
                            }
                        }).subscribe(STUB);
                    }

                    @Override
                    public <C> Observables.Combinable3<A, B, C> combineWith(Observable<C> observable) {
                        arrayCombinable.add(observable, true);
                        return this.createCombinable3();
                    }

                    @Override
                    public <C> Observables.Combinable3<A, B, C> withLatestFrom(Observable<C> observable) {
                        arrayCombinable.add(observable, false);
                        return this.createCombinable3();
                    }

                    private <C> Observables.Combinable3<A, B, C> createCombinable3() {
                        return new Observables.Combinable3<A, B, C>(){

                            @Override
                            public <T> Observable<T> using(final Observables.Combinator3<A, B, C, T> combinator3) {
                                return arrayCombinable.using(new UnsafeCombinator<T>(){

                                    @Override
                                    public T combine(Iterator iterator) {
                                        return combinator3.combine(iterator.next(), iterator.next(), iterator.next());
                                    }
                                });
                            }

                            @Override
                            public Subscription subscribe(final Observables.Consumer3<A, B, C> consumer3) {
                                return arrayCombinable.using(new UnsafeCombinator<Void>(){

                                    @Override
                                    public Void combine(Iterator iterator) {
                                        consumer3.accept(iterator.next(), iterator.next(), iterator.next());
                                        return null;
                                    }

                                    @Override
                                    public /* synthetic */ Object combine(Iterator iterator) {
                                        return this.combine(iterator);
                                    }
                                }).subscribe(STUB);
                            }

                            @Override
                            public <D> Observables.Combinable4<A, B, C, D> combineWith(Observable<D> observable) {
                                arrayCombinable.add(observable, true);
                                return this.createCombinable4();
                            }

                            @Override
                            public <D> Observables.Combinable4<A, B, C, D> withLatestFrom(Observable<D> observable) {
                                arrayCombinable.add(observable, false);
                                return this.createCombinable4();
                            }

                            private <D> Observables.Combinable4<A, B, C, D> createCombinable4() {
                                return new Observables.Combinable4<A, B, C, D>(){

                                    @Override
                                    public <T> Observable<T> using(final Observables.Combinator4<A, B, C, D, T> combinator4) {
                                        return arrayCombinable.using(new UnsafeCombinator<T>(){

                                            @Override
                                            public T combine(Iterator iterator) {
                                                return combinator4.combine(iterator.next(), iterator.next(), iterator.next(), iterator.next());
                                            }
                                        });
                                    }

                                    @Override
                                    public Subscription subscribe(final Observables.Consumer4<A, B, C, D> consumer4) {
                                        return arrayCombinable.using(new UnsafeCombinator<Void>(){

                                            @Override
                                            public Void combine(Iterator iterator) {
                                                consumer4.accept(iterator.next(), iterator.next(), iterator.next(), iterator.next());
                                                return null;
                                            }

                                            @Override
                                            public /* synthetic */ Object combine(Iterator iterator) {
                                                return this.combine(iterator);
                                            }
                                        }).subscribe(STUB);
                                    }

                                    @Override
                                    public <E> Observables.Combinable5<A, B, C, D, E> combineWith(Observable<E> observable) {
                                        arrayCombinable.add(observable, true);
                                        return this.createCombinable5();
                                    }

                                    @Override
                                    public <E> Observables.Combinable5<A, B, C, D, E> withLatestFrom(Observable<E> observable) {
                                        arrayCombinable.add(observable, false);
                                        return this.createCombinable5();
                                    }

                                    private <E> Observables.Combinable5<A, B, C, D, E> createCombinable5() {
                                        return new Observables.Combinable5<A, B, C, D, E>(){

                                            @Override
                                            public <T> Observable<T> using(final Observables.Combinator5<A, B, C, D, E, T> combinator5) {
                                                return arrayCombinable.using(new UnsafeCombinator<T>(){

                                                    @Override
                                                    public T combine(Iterator iterator) {
                                                        return combinator5.combine(iterator.next(), iterator.next(), iterator.next(), iterator.next(), iterator.next());
                                                    }
                                                });
                                            }

                                            @Override
                                            public Subscription subscribe(final Observables.Consumer5<A, B, C, D, E> consumer5) {
                                                return arrayCombinable.using(new UnsafeCombinator<Void>(){

                                                    @Override
                                                    public Void combine(Iterator iterator) {
                                                        consumer5.accept(iterator.next(), iterator.next(), iterator.next(), iterator.next(), iterator.next());
                                                        return null;
                                                    }

                                                    @Override
                                                    public /* synthetic */ Object combine(Iterator iterator) {
                                                        return this.combine(iterator);
                                                    }
                                                }).subscribe(STUB);
                                            }
                                        };
                                    }
                                };
                            }
                        };
                    }
                };
            }
        };
    }

    public static <A, B> Observables.Combinable<A, B> combineLatest(Observable<A> observable, Observable<B> observable2) {
        return observable.combineWith(observable2);
    }

    public static <A, B, C> Observables.Combinable3<A, B, C> combineLatest(Observable<A> observable, Observable<B> observable2, Observable<C> observable3) {
        return observable.combineWith(observable2).combineWith(observable3);
    }

    public static <A, B, C, D> Observables.Combinable4<A, B, C, D> combineLatest(Observable<A> observable, Observable<B> observable2, Observable<C> observable3, Observable<D> observable4) {
        return observable.combineWith(observable2).combineWith(observable3).combineWith(observable4);
    }

    public static <A, B, C, D, E> Observables.Combinable5<A, B, C, D, E> combineLatest(Observable<A> observable, Observable<B> observable2, Observable<C> observable3, Observable<D> observable4, Observable<E> observable5) {
        return observable.combineWith(observable2).combineWith(observable3).combineWith(observable4).combineWith(observable5);
    }

    public static <A, B> Observables.Zippable<A, B> zip(Observable<A> observable, Observable<B> observable2) {
        final ArrayZippable arrayZippable = new ArrayZippable(new Observable[]{observable, observable2});
        return new Observables.Zippable<A, B>(){

            @Override
            public <T> Observable<T> using(final Observables.Combinator<A, B, T> combinator) {
                return arrayZippable.using(new ArrayZippable.ArrayCombinator<T>(){

                    @Override
                    public T combine(Object[] objectArray) {
                        return combinator.combine(objectArray[0], objectArray[1]);
                    }
                });
            }

            @Override
            public Subscription subscribe(final Observables.Consumer2<A, B> consumer2) {
                return this.using(new Observables.Combinator<A, B, Void>(){

                    @Override
                    public Void combine(A a2, B b2) {
                        consumer2.accept(a2, b2);
                        return null;
                    }

                    @Override
                    public /* synthetic */ Object combine(Object object, Object object2) {
                        return this.combine(object, object2);
                    }
                }).subscribe(new Consumer<Void>(){

                    @Override
                    public void accept(Void void_) {
                    }

                    @Override
                    public /* synthetic */ void accept(Object object) {
                        this.accept((Void)object);
                    }
                });
            }
        };
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class ArrayZippable {
        private final GList<Observable<?>> pipes;
        private final Object[] lastData;

        public ArrayZippable(Observable<?>[] observableArray) {
            this.pipes = Generics.newArrayList(observableArray);
            this.lastData = new Object[observableArray.length];
            Arrays.fill(this.lastData, BUNG);
        }

        private boolean checkBungs() {
            for (int i2 = 0; i2 < this.lastData.length; ++i2) {
                if (!this.lastData[i2].equals(BUNG)) continue;
                return false;
            }
            return true;
        }

        public <T> Observable<T> using(final ArrayCombinator<T> arrayCombinator) {
            final GList gList = Generics.newArrayList();
            return Pipe.createFromSource(new Source<T>(){

                @Override
                public BackChannel setSink(final Sink<T> sink) {
                    int n = 0;
                    while (n < ArrayZippable.this.pipes.size()) {
                        final int n2 = n++;
                        ((Observable)ArrayZippable.this.pipes.get(n2)).subscribe(new Sink<Object>(){

                            @Override
                            public void closed() {
                                sink.closed();
                            }

                            @Override
                            public void accept(Object object) {
                                ((ArrayZippable)(this).ArrayZippable.this).lastData[n2] = object;
                                if (ArrayZippable.this.checkBungs()) {
                                    sink.accept(arrayCombinator.combine(ArrayZippable.this.lastData));
                                    Arrays.fill(ArrayZippable.this.lastData, BUNG);
                                }
                            }
                        }).addTo(gList);
                    }
                    return new BackChannel(){

                        public void disconnect() {
                            gList.fluent().forEach(new Consumer<Subscription>(){

                                @Override
                                public void accept(Subscription subscription) {
                                    subscription.cancel();
                                }

                                @Override
                                public /* synthetic */ void accept(Object object) {
                                    this.accept((Subscription)object);
                                }
                            });
                        }
                    };
                }
            });
        }

        /*
         * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
         */
        public static interface ArrayCombinator<T> {
            public T combine(Object[] var1);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class ArrayCombinable {
        private final GList<Observable<?>> pipes = Generics.newCopyOnWriteArrayList();
        private final GList<Boolean> notifyOnChange = Generics.newCopyOnWriteArrayList();
        private final List allData = new CopyOnWriteArrayList();
        private boolean gotAllData;

        private ArrayCombinable() {
        }

        public void add(Observable<?> observable, boolean bl) {
            this.pipes.add(observable);
            this.notifyOnChange.add(new Boolean(bl));
            this.allData.add(BUNG);
        }

        private boolean checkBungs() {
            if (this.allData.contains(BUNG)) {
                return false;
            }
            this.gotAllData = true;
            return true;
        }

        public <T> Observable<T> using(final UnsafeCombinator<T> unsafeCombinator) {
            return Pipe.createFromSource(new Source<T>(){

                @Override
                public BackChannel setSink(final Sink<T> sink) {
                    final GList<Subscription> gList = Generics.newArrayList();
                    int n = 0;
                    while (n < ArrayCombinable.this.pipes.size()) {
                        final int n2 = n++;
                        ((Observable)ArrayCombinable.this.pipes.get(n2)).subscribe(new Sink<Object>(){

                            @Override
                            public void closed() {
                                sink.closed();
                            }

                            @Override
                            public void accept(Object object) {
                                ArrayCombinable.this.allData.set(n2, object);
                                if (((Boolean)ArrayCombinable.this.notifyOnChange.get(n2)).booleanValue() && (ArrayCombinable.this.gotAllData || ArrayCombinable.this.checkBungs())) {
                                    sink.accept(unsafeCombinator.combine(ArrayCombinable.this.allData.iterator()));
                                }
                            }
                        }).addTo(gList);
                    }
                    return new BackChannel(){

                        public void disconnect() {
                            gList.fluent().forEach(new Consumer<Subscription>(){

                                @Override
                                public void accept(Subscription subscription) {
                                    subscription.cancel();
                                }

                                @Override
                                public /* synthetic */ void accept(Object object) {
                                    this.accept((Subscription)object);
                                }
                            });
                        }
                    };
                }
            });
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static interface UnsafeCombinator<T> {
        public T combine(Iterator var1);
    }
}

