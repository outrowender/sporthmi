/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.ListCell;

public interface SDSListModelApp
extends HMIModel {
    default public int getCellContentInteger() {
    }

    default public String getCellContentString() {
    }

    default public void setCellIndex(int n) {
    }

    default public int getCellIndex() {
    }

    default public void setRow(int n, ListCell[] listCellArray) {
    }
}

