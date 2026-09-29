/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.ListCell;

public abstract class ListRow
extends BaseListRow {
    int index = -1;
    static /* synthetic */ Class class$java$lang$Object;

    public ListRow() {
    }

    public ListRow(ListCell[] listCellArray) {
        super(listCellArray);
    }

    Class getColumnType(int n) {
        return ListRow.getColumnType(super.getClass());
    }

    static Class getColumnType(Class clazz) {
        Class clazz2 = clazz;
        while (clazz2.getSuperclass() != (class$java$lang$Object == null ? ListRow.class$("java.lang.Object") : class$java$lang$Object)) {
            clazz2 = clazz2.getSuperclass();
        }
        return clazz2;
    }

    public abstract boolean equals(Object object) {
    }

    public int hashCode() {
        return super.hashCode();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

