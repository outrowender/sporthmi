/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.EntryListRow;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.messaging.ListChangedInformation;

final class ListDataRequest {
    static final int REQUEST_ID_NONE;
    static final int MODEL_REQUEST_ID_NONE;
    private final int requestId;
    private final int modelRequestId;
    private final int offset;
    private final int length;
    private final boolean hasListChanged;
    private final ListChangedInformation listChangedInformation;
    private final EntryListRow focusedRow;
    private final FocusAdvice focusAdvice;

    ListDataRequest(int n, int n2, int n3, int n4, boolean bl, ListChangedInformation listChangedInformation, EntryListRow entryListRow, FocusAdvice focusAdvice) {
        this.requestId = n;
        this.modelRequestId = n2;
        this.offset = n3;
        this.length = n4;
        this.hasListChanged = bl;
        this.listChangedInformation = listChangedInformation;
        this.focusedRow = entryListRow;
        this.focusAdvice = focusAdvice;
    }

    int getRequestId() {
        return this.requestId;
    }

    int getModelRequestId() {
        return this.modelRequestId;
    }

    int getOffset() {
        return this.offset;
    }

    int getLength() {
        return this.length;
    }

    boolean hasListChanged() {
        return this.hasListChanged;
    }

    ListChangedInformation getListChangedInformation() {
        return this.listChangedInformation;
    }

    EntryListRow getFocusedRow() {
        return this.focusedRow;
    }

    FocusAdvice getFocusAdvice() {
        return this.focusAdvice;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("ListDataRequest {requestId = ");
        buffer.append(this.getRequestId());
        buffer.append(", modelRequestId = ");
        buffer.append(this.getModelRequestId());
        buffer.append(", offset = ");
        buffer.append(this.getOffset());
        buffer.append(", length = ");
        buffer.append(this.getLength());
        buffer.append(", hasListChanged = ");
        buffer.append(this.hasListChanged());
        buffer.append(", listChangeInformation = ");
        buffer.append(this.getListChangedInformation());
        buffer.append(", focusedRow = ");
        buffer.append(this.getFocusedRow());
        buffer.append(", focusAdvice = ");
        buffer.append(this.getFocusAdvice());
        buffer.append('}');
        return buffer.toString();
    }
}

