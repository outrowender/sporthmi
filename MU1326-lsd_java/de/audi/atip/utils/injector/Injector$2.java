/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.injector.Injector
 */
package de.audi.atip.utils.injector;

import de.audi.atip.utils.injector.Injector;
import de.audi.atip.utils.injector.Injector$IFactory;

class Injector$2
implements Injector$IFactory {
    private final /* synthetic */ Injector this$0;

    Injector$2(Injector injector) {
        this.this$0 = injector;
    }

    @Override
    public Object get(Class clazz, Object object) {
        return this.this$0;
    }
}

