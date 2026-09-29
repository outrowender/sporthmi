/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util.change;

import de.audi.tuner.util.change.ChangeEvent;
import de.audi.tuner.util.change.ChangeListener;
import java.util.LinkedList;
import java.util.List;

public class ChangeHandler {
    private final List listeners = new LinkedList();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addChangeListener(ChangeListener changeListener) {
        List list = this.listeners;
        synchronized (list) {
            if (!this.listeners.contains(changeListener)) {
                this.listeners.add(changeListener);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void signalChange(ChangeEvent changeEvent) {
        LinkedList linkedList = new LinkedList();
        Object object = this.listeners;
        synchronized (object) {
            linkedList.addAll(this.listeners);
        }
        object = linkedList.iterator();
        while (object.hasNext()) {
            ChangeListener changeListener = (ChangeListener)object.next();
            changeListener.stateChanged(changeEvent);
        }
    }
}

