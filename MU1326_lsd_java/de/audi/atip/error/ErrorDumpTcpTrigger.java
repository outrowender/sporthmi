/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.error;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ErrorDumpTcpTrigger
implements Runnable {
    private final IFrameworkAccess framework;
    private final LogChannel logCh;
    private int port;
    private volatile ServerSocket serverSocket;

    public ErrorDumpTcpTrigger(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.logCh = iFrameworkAccess.getLogChannel("Fw.Error.Trigger");
    }

    public final String toString() {
        return "ErrorDumpTcpTrigger:" + this.port;
    }

    public void start() {
        Integer n = Integer.getInteger("ErrorDumpTriggerPort");
        if (n != null) {
            this.port = n;
            System.out.println("Open ErrorDump Trigger Port on " + this.port);
            this.framework.getHMIThreadPool().execute(this);
        }
    }

    public void stop() {
        if (this.serverSocket != null) {
            this.logCh.log(1000000, "Closing ErrorDump Trigger Port on %1", (long)this.port);
            try {
                this.serverSocket.close();
                this.serverSocket = null;
            }
            catch (IOException iOException) {
                this.logCh.log(100000, "Closing ErrorDump Trigger Port failed!", (Throwable)iOException);
            }
        }
    }

    public void run() {
        int n = 0;
        Thread.currentThread().setName(Thread.currentThread().getName() + this);
        try {
            this.serverSocket = new ServerSocket(this.port, 50, InetAddress.getByName(null));
            this.logCh.log(1000000, "ErrorDump Trigger waiting for client on port %1", (long)this.serverSocket.getLocalPort());
        }
        catch (IOException iOException) {
            this.logCh.log(100000, "ErrorDump Trigger failed to create Server Socket", (Throwable)iOException);
            return;
        }
        while (this.serverSocket != null) {
            try {
                Socket socket = this.serverSocket.accept();
                this.logCh.log(10000000, "ErrorDump Trigger accepted %1:%2", (Object)socket.getInetAddress(), (long)socket.getPort());
                n = 0;
                this.framework.getErrorMgr().handleError(null, "error dump triggered manually", 0, 0, 4);
                try {
                    socket.getOutputStream().write("ErrorDump written!\r\n\r\n".getBytes());
                    socket.close();
                }
                catch (Exception exception) {
                    this.logCh.log(100000, "ErrorDump Trigger failed to close client socket", (Throwable)exception);
                }
            }
            catch (IOException iOException) {
                if (++n > 5) {
                    this.logCh.log(100000, "ErrorDump Trigger too many failures", (Throwable)iOException);
                    this.stop();
                    return;
                }
                try {
                    Thread.sleep(1000L);
                }
                catch (InterruptedException interruptedException) {
                    Thread.interrupted();
                }
            }
        }
    }
}

