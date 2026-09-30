/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.generics.ICollector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Collectors {
    public static final <T> ICollector<T, GList<T>> createArrayListCollector() {
        return new ICollector<T, GList<T>>(){

            @Override
            public GList<T> createContainer() {
                return Generics.newArrayList();
            }

            @Override
            public void add(GList<T> gList, T t) {
                gList.add(t);
            }

            @Override
            public /* synthetic */ void add(Object object, Object object2) {
                this.add((GList)object, object2);
            }

            @Override
            public /* synthetic */ Object createContainer() {
                return this.createContainer();
            }
        };
    }
}

