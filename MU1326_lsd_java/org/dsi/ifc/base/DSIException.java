/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.base;

import java.io.PrintStream;
import java.io.PrintWriter;

public class DSIException
extends RuntimeException {
    private static final long serialVersionUID = -7777198285166341255L;
    private String params;
    private Throwable cause;

    public DSIException(String string, Throwable throwable, String string2) {
        super(string);
        this.cause = throwable;
        this.params = string2;
    }

    public String getMessage() {
        if (this.cause == null) {
            return super.getMessage();
        }
        return super.getMessage() + " (" + this.cause.toString() + ")";
    }

    public void printStackTrace() {
        this.printStackTrace(System.err);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void printStackTrace(PrintStream printStream) {
        PrintStream printStream2 = printStream;
        synchronized (printStream2) {
            if (this.cause != null) {
                printStream.print(this.getClass().getName() + ": ");
                this.cause.printStackTrace(printStream);
            } else {
                super.printStackTrace(printStream);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void printStackTrace(PrintWriter printWriter) {
        PrintWriter printWriter2 = printWriter;
        synchronized (printWriter2) {
            if (this.cause != null) {
                printWriter.print(this.getClass().getName() + ": ");
                this.cause.printStackTrace(printWriter);
            } else {
                super.printStackTrace(printWriter);
            }
        }
    }

    public String getCallParams() {
        return this.params;
    }

    public Throwable getCause() {
        return this.cause;
    }
}

