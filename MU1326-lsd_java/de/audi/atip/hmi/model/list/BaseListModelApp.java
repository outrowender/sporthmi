/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.list;

import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import java.util.List;

public interface BaseListModelApp
extends HMIModelApp {
    public static final int INDEX_NO_SELECTION;

    default public void trigger(ModelTrigger modelTrigger) {
    }

    default public MenuModelApp getMenu() {
    }

    default public void setLength(int n) {
    }

    default public int getLength() {
    }

    default public int getIndexForUniqueID(long l) {
    }

    default public boolean contains(long l) {
    }

    default public EvoListRow getRow(int n) {
    }

    default public EvoListRow getRowByUniqueID(long l) {
    }

    default public void setRow(int n, EvoListRow evoListRow) {
    }

    default public void setRows(int n, int n2, EvoListRow[] evoListRowArray) {
    }

    default public void clearRows(int n, int n2) {
    }

    default public void clearRow(int n) {
    }

    default public void clearAll() {
    }

    default public void setSelectedIndex(int n) {
    }

    default public boolean setSelectedUniqueID(long l) {
    }

    default public SelectedItem getSelected() {
    }

    default public void insertBefore(long l, EvoListRow evoListRow) {
    }

    default public void insertBefore(long l, EvoListRow[] evoListRowArray) {
    }

    default public void insertAfter(long l, EvoListRow evoListRow) {
    }

    default public void insertAfter(long l, EvoListRow[] evoListRowArray) {
    }

    default public void insertAfterAndOpen(long l, EvoListRow[] evoListRowArray) {
    }

    default public void append(EvoListRow evoListRow) {
    }

    default public void append(EvoListRow[] evoListRowArray) {
    }

    default public void remove(EvoListRow evoListRow) {
    }

    default public void remove(long l) {
    }

    default public void remove(EvoListRow[] evoListRowArray) {
    }

    default public void remove(long[] lArray) {
    }

    default public void removeByIndex(int n) {
    }

    default public void removeAndClose(long l, int n) {
    }

    default public void removeAll() {
    }

    default public BaseListModelApp getCopy() {
    }

    default public BaseListModelApp getEmptyCopy() {
    }

    default public BaseListModelApp getEmptyCopyWithoutEvents() {
    }

    default public void update(BaseListModelApp baseListModelApp) {
    }

    default public void updateModelWithPendingEvents(BaseListModelApp baseListModelApp) {
    }

    default public void setListener(BaseListModelListener baseListModelListener) {
    }

    default public List asList() {
    }

    default public void setRowsWithoutEvent(int n, int n2, EvoListRow[] evoListRowArray) {
    }
}

