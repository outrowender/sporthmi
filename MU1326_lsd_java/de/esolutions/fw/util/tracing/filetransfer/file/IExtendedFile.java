/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer.file;

import de.esolutions.fw.util.tracing.filetransfer.FileTransferError;
import de.esolutions.fw.util.tracing.filetransfer.file.IFile;

public interface IExtendedFile
extends IFile {
    public void setPath(String var1);

    public void setFlag(byte var1);

    public void setUserFlag(byte var1);

    public byte getUserFlag();

    public void setTimestamp(long var1);

    public void setHashType(byte var1);

    public void setHash(byte[] var1);

    public void setSize(long var1);

    public void setCompleteSize(long var1);

    public void setError(FileTransferError var1);

    public void setValidHash(boolean var1);
}

