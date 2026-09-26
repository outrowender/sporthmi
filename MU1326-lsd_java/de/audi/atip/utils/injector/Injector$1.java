/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.injector.Injector
 */
package de.audi.atip.utils.injector;

import de.audi.atip.utils.generics.ReduceFunction;
import de.audi.atip.utils.injector.Injector;
import de.esolutions.fw.util.commons.Buffer;

class Injector$1
implements ReduceFunction {
    private final /* synthetic */ Injector this$0;

    Injector$1(Injector injector) {
        this.this$0 = injector;
    }

    public Buffer from(Buffer buffer, Throwable throwable) {
        Buffer buffer2 = buffer.append(throwable.getMessage()).append("\n");
        return buffer2;
    }

    @Override
    public /* synthetic */ Object from(Object object, Object object2) {
        return this.from((Buffer)object, (Throwable)object2);
    }
}

