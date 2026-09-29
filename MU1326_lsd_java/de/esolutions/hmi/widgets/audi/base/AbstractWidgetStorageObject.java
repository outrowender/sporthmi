/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

public class AbstractWidgetStorageObject {
    private AbstractWidgetStorageObject next = null;

    public void setNext(AbstractWidgetStorageObject abstractWidgetStorageObject) {
        this.next = abstractWidgetStorageObject;
    }

    public AbstractWidgetStorageObject getNext() {
        return this.next;
    }

    public boolean hasNext() {
        return this.next != null;
    }
}

