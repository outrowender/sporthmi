/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.transfer;

import de.esolutions.fw.util.commons.Buffer;

public class EvoTransferState {
    private volatile long numberOfImportedFiles = 0L;
    private volatile long numberOfFilesTotalToImport = 1L;
    private volatile long numberOfErroneousFiles = 1L;
    private volatile boolean allItemsSuccessfullyImported = false;
    private volatile boolean isAbortedByUser = false;
    private volatile boolean jukeboxFull = false;
    private volatile boolean delete = false;
    private volatile boolean waitingForUserAction = false;
    private volatile boolean recopy = false;

    public void reset() {
        this.numberOfImportedFiles = 0L;
        this.numberOfFilesTotalToImport = 1L;
        this.numberOfErroneousFiles = 1L;
        this.allItemsSuccessfullyImported = false;
        this.isAbortedByUser = false;
        this.jukeboxFull = false;
        this.delete = false;
        this.waitingForUserAction = false;
        this.recopy = false;
    }

    protected long getNumberOfImportedFiles() {
        return this.numberOfImportedFiles;
    }

    protected long getNumberOfFilesTotalToImport() {
        return this.numberOfFilesTotalToImport;
    }

    protected long getNumberOfErroneousFiles() {
        return this.numberOfErroneousFiles;
    }

    protected boolean isAllItemsSuccessfullyImported() {
        return this.allItemsSuccessfullyImported;
    }

    protected boolean isRecopy() {
        return this.recopy;
    }

    protected boolean isAbortedByUser() {
        return this.isAbortedByUser;
    }

    protected boolean isJukeboxFull() {
        return this.jukeboxFull;
    }

    protected boolean isWaitingForUserAction() {
        return this.waitingForUserAction;
    }

    protected void setWaitingForUserAction(boolean bl) {
        this.waitingForUserAction = bl;
    }

    protected void setNumberOfImportedFiles(long l) {
        this.numberOfImportedFiles = l;
    }

    protected void setNumberOfFilesTotalToImport(long l) {
        this.numberOfFilesTotalToImport = l;
    }

    protected void setNumberOfErroneousFiles(long l) {
        this.numberOfErroneousFiles = l;
    }

    protected void setAllItemsSuccessfullyImported(boolean bl) {
        this.allItemsSuccessfullyImported = bl;
    }

    protected void setRecopy(boolean bl) {
        this.recopy = bl;
    }

    protected void setAbortedByUser(boolean bl) {
        this.isAbortedByUser = bl;
    }

    protected void setJukeboxFull(boolean bl) {
        this.jukeboxFull = bl;
    }

    protected boolean isDelete() {
        return this.delete;
    }

    protected void setDelete(boolean bl) {
        this.delete = bl;
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append("EvoTransferState [numberOfImportedFiles=");
        buffer.append(this.numberOfImportedFiles);
        buffer.append(", numberOfFilesTotalToImport=");
        buffer.append(this.numberOfFilesTotalToImport);
        buffer.append(", numberOfErroneousFiles=");
        buffer.append(this.numberOfErroneousFiles);
        buffer.append(", allItemsSuccessfullyImported=");
        buffer.append(this.allItemsSuccessfullyImported);
        buffer.append(", recopy=");
        buffer.append(this.recopy);
        buffer.append(", isAbortedByUser=");
        buffer.append(this.isAbortedByUser);
        buffer.append(", jukeboxFull=");
        buffer.append(this.jukeboxFull);
        buffer.append(", delete=");
        buffer.append(this.delete);
        buffer.append(", waitingForUserAction=");
        buffer.append(this.waitingForUserAction);
        buffer.append("]");
        return buffer.toString();
    }
}

