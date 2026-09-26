/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.callstacks;

import de.audi.app.phone.core.callstacks.AbstractCallStackEntryRow;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import org.dsi.ifc.telephoneng.CallStackEntry;

public class TelEvoCallStackRow
extends AbstractCallStackEntryRow {
    public static final int MAX_COLUMNS;

    public TelEvoCallStackRow(CallStackEntry callStackEntry, LogChannel logChannel, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        super(new ListCell[10], callStackEntry, logChannel, iGlobalTelephoneStateStruct);
        this.cells[7] = this.getPropertyCell(this.cells);
    }

    private PropertyListCell getPropertyCell(ListCell[] listCellArray) {
        ArrayList arrayList = new ArrayList(3);
        boolean bl = this.callStackEntry != null && this.callStackEntry.getClNumber() != null && this.callStackEntry.getClNumber().length() > 0;
        arrayList.add(new Integer(bl ? -2040561860 : -1708374768));
        if (this.callStackEntry != null && this.callStackEntry.getClEntryOrigin() == 1) {
            arrayList.add(new Integer(-1704199780));
        }
        if (this.callStackEntry != null && this.callStackEntry.getAdbEntryID() > 0L) {
            arrayList.add(new Integer(553997474));
        }
        int[] nArray = new int[arrayList.size()];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            nArray[i2] = (Integer)arrayList.get(i2);
        }
        return new PropertyListCell(-1635178174, nArray);
    }
}

