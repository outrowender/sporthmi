/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer;

public interface IFileTransferSender {
    public boolean sendFileRequest(int var1, String var2, byte var3);

    public boolean sendFileStatus(int var1, String var2, byte var3, long var4, long var6, byte var8, byte[] var9);

    public boolean sendFileTransfer(int var1, int var2, byte var3, int var4, byte[] var5);
}

