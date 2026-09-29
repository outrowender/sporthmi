/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

public class WidgetPersistenceManager$DrawerPersistence {
    int state;
    Comparable focusedIndex;

    public WidgetPersistenceManager$DrawerPersistence(int n, Comparable comparable) {
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
        return new StringBuffer().append("DrawerPersistence state: ").append(this.state).append(" focusedIndex: ").append(this.focusedIndex).toString();
    }
}

