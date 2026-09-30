/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer;

import de.esolutions.fw.util.tracing.filetransfer.IFileTransferListener;
import de.esolutions.fw.util.tracing.filetransfer.file.IFile;

public class AbstractFileTransferListener
implements IFileTransferListener {
    public void fileTransferBegin(IFile iFile) {
    }

    public void fileTransferProgress(IFile iFile) {
    }

    public void fileTransferComplete(IFile iFile) {
    }

    public void fileTransferStatus(IFile iFile) {
    }

    public void fileTransferError(IFile iFile) {
    }

    public boolean confirmFileTransfer(IFile iFile) {
        return true;
    }
}

