/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidgetStorageObject;
import de.esolutions.hmi.widgets.audi.base.WidgetPersistenceComparator;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WidgetPersistenceManager {
    public static final int STATE_CLOSED = 0;
    public static final int STATE_OPEN = 1;
    private Map persistenceMap = new TreeMap(new WidgetPersistenceComparator());
    private int[] states;
    private AbstractWidgetStorageObject lastEntryPointer;
    private Map drawerStateMap = new HashMap(32);

    public void readBegin(int[] nArray) {
        this.states = nArray;
        this.lastEntryPointer = null;
        if (nArray == null) {
            AbstractWidget.logChannel.log(100000, "WidgetPersistence#setScreenState screen state null is set - nothing can be stored or read for this screen");
        }
    }

    public int getScreenState() {
        if (this.states != null && this.states.length > 0) {
            return this.states[0];
        }
        AbstractWidget.logChannel.log(100000, "WidgetPersistence#getScreenState screen states is null, or states.length == 0 - return screenState: -1");
        return -1;
    }

    public AbstractWidgetStorageObject read() {
        AbstractWidgetStorageObject abstractWidgetStorageObject = null;
        abstractWidgetStorageObject = this.lastEntryPointer == null ? (AbstractWidgetStorageObject)this.persistenceMap.get(this.states) : this.lastEntryPointer.getNext();
        if (abstractWidgetStorageObject != null) {
            this.lastEntryPointer = abstractWidgetStorageObject;
            return abstractWidgetStorageObject;
        }
        return null;
    }

    public AbstractWidgetStorageObject peek() {
        if (this.lastEntryPointer == null) {
            return (AbstractWidgetStorageObject)this.persistenceMap.get(this.states);
        }
        return this.lastEntryPointer.getNext();
    }

    public void storeBegin(int[] nArray) {
        this.lastEntryPointer = null;
        this.states = nArray;
    }

    public void storeEnd(int[] nArray) {
        if (!this.equalStates(this.states, nArray)) {
            AbstractWidget.logChannel.log(100000, "WidgetPersistence#storeEnd: states are not as expected: expected: %1, but was: %2", (Object)nArray, (Object)this.states);
        }
        this.lastEntryPointer = null;
        this.states = null;
    }

    private boolean equalStates(int[] nArray, int[] nArray2) {
        if (nArray == null) {
            return nArray2 == null;
        }
        if (nArray2 == null) {
            return false;
        }
        return Arrays.equals(nArray, nArray2);
    }

    public void store(AbstractWidgetStorageObject abstractWidgetStorageObject) {
        if (this.states != null) {
            if (this.lastEntryPointer == null) {
                this.persistenceMap.put(this.states, abstractWidgetStorageObject);
            } else {
                this.lastEntryPointer.setNext(abstractWidgetStorageObject);
            }
            this.lastEntryPointer = abstractWidgetStorageObject;
        } else {
            AbstractWidget.logChannel.log(100000, "WidgetPersistence#store cannot store data because states are null");
        }
    }

    public void setDrawerState(int[] nArray, DrawerPersistence drawerPersistence) {
        if (nArray != null) {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                buffer.append(nArray[i2]);
            }
            AbstractWidget.logChannel.log(10000000, "WidgetPersistence#setDrawerState key: %1  drawerpersistence %2", (Object)buffer, (Object)drawerPersistence);
            this.drawerStateMap.put(buffer.toString(), drawerPersistence);
        }
    }

    public DrawerPersistence getDrawerState(int[] nArray) {
        if (nArray != null) {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                buffer.append(nArray[i2]);
            }
            DrawerPersistence drawerPersistence = (DrawerPersistence)this.drawerStateMap.get(buffer.toString());
            AbstractWidget.logChannel.log(10000000, "WidgetPersistence#getDrawerState key: %1  drawerpersistence %2", (Object)buffer, (Object)drawerPersistence);
            return drawerPersistence;
        }
        return null;
    }

    public static class DrawerPersistence {
        int state;
        Comparable focusedIndex;

        public DrawerPersistence(int n, Comparable comparable) {
            this.state = n;
            this.focusedIndex = comparable;
        }

        public int getState() {
            return this.state;
        }

        public void setState(int n) {
            this.state = n;
        }

        public Comparable getFocusedIndex() {
            return this.focusedIndex;
        }

        public void setFocusedIndex(Comparable comparable) {
            this.focusedIndex = comparable;
        }

        public String toString() {
            return "DrawerPersistence state: " + this.state + " focusedIndex: " + this.focusedIndex;
        }
    }
}

