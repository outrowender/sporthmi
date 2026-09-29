/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.modelaccess.HMIModelApp;

public interface ListModelApp
extends HMIModelApp {
    public static final int NO_SELECTION;

    default public void setCell(int n, int n2, ListCell listCell) {
    }

    default public ListCell getCell(int n, int n2) {
    }

    default public Class getColumnType(int n) {
    }

    default public int getLength() {
    }

    default public int getLengthOnTransaction() {
    }

    default public void setListListener(ListListener listListener) {
    }

    default public void setMaxColumns(int n) {
    }

    default public int getMaxColumns() {
    }

    default public void setMaxRows(int n) {
    }

    default public int getMaxRows() {
    }

    default public void setRow(int n, BaseListRow baseListRow) {
    }

    default public void setRow(int n, ListCell listCell) {
    }

    default public void setRow(int n, ListCell[] listCellArray) {
    }

    default public boolean getRow(int n, ListCell[] listCellArray) {
    }

    default public BaseListRow getRow(int n) {
    }

    default public BaseListRow getRowOnTransaction(int n) {
    }

    default public void setSelected(int n) {
    }

    default public int getSelected() {
    }

    default public void addRow(BaseListRow baseListRow) {
    }

    default public void addRow(ListCell listCell) {
    }

    default public void addRow(ListCell[] listCellArray) {
    }

    default public void clear() {
    }

    default public void insertRow(int n, BaseListRow baseListRow) {
    }

    default public void insertRow(int n, ListCell listCell) {
    }

    default public void insertRow(int n, ListCell[] listCellArray) {
    }

    default public void removeRow(int n) {
    }
}

