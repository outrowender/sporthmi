/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.dsi;

import de.audi.app.media.source.MediaSourceSlot;
import org.dsi.ifc.media.DatabaseSpace;
import org.dsi.ifc.media.ListEntry;

public interface IMediaRecorderListener {
    default public void sourceSlotActivated(MediaSourceSlot mediaSourceSlot) {
    }

    default public void responseSetSelection(int n, boolean bl) {
    }

    default public void updateDatabaseSpace(DatabaseSpace databaseSpace) {
    }

    default public void updateDeletionProgress(long l) {
    }

    default public void updateDeletionStatus(int n) {
    }

    default public void updateImportProgress(long l, ListEntry listEntry) {
    }

    default public void updateImportStatus(int n) {
    }

    default public void updateImportSummary(long l, long l2, long l3, long l4, long l5, long l6) {
    }

    default public void responseSetEncodingQuality(int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void dsiServiceRemoved() {
    }
}

