/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.ListRowComparator;
import de.audi.atip.hmi.modelaccess.HMIModelApp;

public interface AbstractListModelApp
extends HMIModelApp {
    default public void setRowsPerScreen(int n) {
    }

    default public void jumpToStartOfListSupported(boolean bl) {
    }

    default public void jumpToEndOfListSupported(boolean bl) {
    }

    default public void clear() {
    }

    default public boolean setFocusedCursorPosition(ListRow listRow, int n) {
    }

    default public void setMaxColumns(int n) {
    }

    default public ListRow getRow(ListRowComparator listRowComparator) {
    }

    default public ListRow[] getRows(ListRowComparator listRowComparator) {
    }

    default public ListRow getFirstRow() {
    }

    default public ListRow getLastRow() {
    }

    default public ListRow getPreviousRow(ListRow listRow) {
    }

    default public ListRow getNextRow(ListRow listRow) {
    }

    default public ListRow getVisibleRow(int n) {
    }

    default public boolean contains(ListRow listRow) {
    }

    default public void enableFastScrolling(boolean bl) {
    }

    default public void setListLength(int n) {
    }

    default public int getListLength() {
    }

    default public int getVisibleRowsCount() {
    }
}

