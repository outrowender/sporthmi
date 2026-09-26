/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu.list;

class DefaultTiledListModelAccess$ListRange
implements Comparable {
    int start;
    int end;

    public DefaultTiledListModelAccess$ListRange() {
    }

    public DefaultTiledListModelAccess$ListRange(int n, int n2) {
        this.start = n;
        this.end = n2;
    }

    public boolean isEmpty() {
        return this.start > this.end;
    }

    public int length() {
        if (this.isEmpty()) {
            return 0;
        }
        return this.end - this.start + 1;
    }

    public void clear() {
        this.end = this.start - 1;
    }

    public void set(int n, int n2) {
        this.start = n;
        this.end = n2;
    }

    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        }
        return new StringBuffer().append("[").append(this.start).append("-").append(this.end).append("]").toString();
    }

    @Override
    public int compareTo(Object object) {
        DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange = (DefaultTiledListModelAccess$ListRange)object;
        return this.start - defaultTiledListModelAccess$ListRange.start;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || !(object instanceof DefaultTiledListModelAccess$ListRange)) {
            return false;
        }
        DefaultTiledListModelAccess$ListRange defaultTiledListModelAccess$ListRange = (DefaultTiledListModelAccess$ListRange)object;
        return this.start == defaultTiledListModelAccess$ListRange.start && this.end == defaultTiledListModelAccess$ListRange.end;
    }
}

