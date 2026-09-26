/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.statemachine;

import de.audi.atip.utils.statemachine.InnerClassInflator;
import java.util.Iterator;

class InnerClassInflator$Expandable {
    private final Object object;
    private final /* synthetic */ InnerClassInflator this$0;

    InnerClassInflator$Expandable(InnerClassInflator innerClassInflator, Object object) {
        this.this$0 = innerClassInflator;
        this.object = object;
    }

    public void expand() {
        Iterator iterator = InnerClassInflator.access$000(this.object.getClass()).iterator();
        while (iterator.hasNext()) {
            Class clazz = (Class)iterator.next();
            Object object = InnerClassInflator.access$100(this.object, clazz);
            InnerClassInflator.access$200(this.this$0).add(object, this.object);
            InnerClassInflator$Expandable innerClassInflator$Expandable = new InnerClassInflator$Expandable(this.this$0, object);
            innerClassInflator$Expandable.expand();
        }
    }
}

