/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.esolutions.hmi.widgets.audi.base.AbstractWidgetStorageObject;

public class WidgetStorageObject
extends AbstractWidgetStorageObject {
    protected int value;
    protected String string;

    public WidgetStorageObject(int n) {
        this.value = n;
    }

    public WidgetStorageObject(String string) {
        this.string = string;
    }

    public WidgetStorageObject(String string, int n) {
        this.value = n;
        this.string = string;
    }

    public void setValue(int n) {
        this.value = n;
    }

    public int getValue() {
        return this.value;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }
}

