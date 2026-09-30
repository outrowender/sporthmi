/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer;

import de.esolutions.fw.util.tracing.filetransfer.IFileTransferManager;
import de.esolutions.fw.util.tracing.filetransfer.IFileTransferSender;

public interface IFileTransferReceiver
extends IFileTransferManager {
    public void setFileTransferSender(IFileTransferSender var1);

    public boolean handleInitExitMessage();

    public boolean handleFileRequestMessage(int var1, String var2, byte var3);

    public boolean handleFileStatusMessage(int var1, String var2, byte var3, long var4, long var6, byte var8, byte[] var9);

    public boolean handleFileTransferMessage(int var1, int var2, byte var3, int var4, byte[] var5);

    public boolean reset(String var1);
}

