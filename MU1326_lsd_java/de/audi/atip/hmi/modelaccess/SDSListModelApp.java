/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.ListCell;

public interface SDSListModelApp
extends HMIModel {
    public int getCellContentInteger();

    public String getCellContentString();

    public void setCellIndex(int var1);

    public int getCellIndex();

    public void setRow(int var1, ListCell[] var2);
}

