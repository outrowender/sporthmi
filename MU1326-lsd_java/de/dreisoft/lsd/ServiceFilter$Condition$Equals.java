/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.ServiceFilter$Condition$Comparison;
import java.util.Dictionary;

public class ServiceFilter$Condition$Equals
extends ServiceFilter$Condition$Comparison {
    @Override
    public boolean hasDestinctServiceInterfaces() {
        return this.isDestinctObjectClassProp;
    }

    @Override
    public boolean isFulfilled(Dictionary dictionary) {
        if (this.isObjectClassProp) {
            String[] stringArray = (String[])dictionary.get(this.property);
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (!this.value.equals(stringArray[i2])) continue;
                return true;
            }
            return false;
        }
        Object object = dictionary.get(this.property);
        if (object == null) {
            return false;
        }
        return this.value.equals(object.toString());
    }

    @Override
    public boolean isServiceInterfaceList() {
        return this.isDestinctObjectClassProp;
    }
}

