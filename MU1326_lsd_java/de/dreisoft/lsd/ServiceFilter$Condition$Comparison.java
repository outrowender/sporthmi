/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.ServiceFilter$Condition;
import de.dreisoft.lsd.ServiceFilter$Condition$WildcardValue;

public abstract class ServiceFilter$Condition$Comparison
extends ServiceFilter$Condition {
    protected boolean isObjectClassProp = false;
    protected boolean isDestinctObjectClassProp = false;
    protected String property;
    protected Object value;

    public ServiceFilter$Condition$Comparison() {
        super(null);
    }

    public void setProperty(String string) {
        this.property = string;
        if (this.property.equals("objectClass")) {
            this.isObjectClassProp = true;
            this.isDestinctObjectClassProp = true;
        }
    }

    public void setValue(Object object) {
        this.value = object;
        if (this.value instanceof ServiceFilter$Condition$WildcardValue) {
            this.isDestinctObjectClassProp = false;
        }
    }

    public String getServiceInterface() {
        if (this.isDestinctObjectClassProp) {
            return (String)this.value;
        }
        return null;
    }

    @Override
    public boolean isServiceInterfaceList() {
        return false;
    }
}

