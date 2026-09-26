/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.HMIModel;
import de.esolutions.fw.util.commons.Buffer;
import java.io.PrintStream;

public class ModelException
extends RuntimeException {
    private static final long serialVersionUID;
    private final HMIModel model;

    public ModelException(HMIModel hMIModel) {
        this(hMIModel, null, null);
    }

    public ModelException(HMIModel hMIModel, String string) {
        this(hMIModel, null, string);
    }

    public ModelException(HMIModel hMIModel, Throwable throwable) {
        this(hMIModel, throwable, throwable.toString());
    }

    public ModelException(HMIModel hMIModel, Throwable throwable, String string) {
        super(string, throwable);
        this.model = hMIModel;
    }

    public int getModelID() {
        return this.model.getID();
    }

    @Override
    public String getMessage() {
        return new Buffer().append("[ModelID:").append(this.model.getID()).append("] ").append(super.getMessage()).toString();
    }

    @Override
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        printStream.println(this.model.dumpContent());
    }
}

