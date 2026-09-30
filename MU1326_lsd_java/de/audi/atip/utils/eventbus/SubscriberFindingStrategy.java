/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.eventbus;

import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.GPair;
import java.lang.reflect.Method;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
interface SubscriberFindingStrategy {
    public GList<GPair<Class, Method>> findAllSubscribers(Object var1);
}

