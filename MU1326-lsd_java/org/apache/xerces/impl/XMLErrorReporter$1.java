/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl;

import org.apache.xerces.impl.XMLErrorReporter;
import org.apache.xerces.util.ErrorHandlerProxy;
import org.apache.xerces.xni.parser.XMLErrorHandler;

class XMLErrorReporter$1
extends ErrorHandlerProxy {
    private final /* synthetic */ XMLErrorReporter this$0;

    XMLErrorReporter$1(XMLErrorReporter xMLErrorReporter) {
        this.this$0 = xMLErrorReporter;
    }

    @Override
    protected XMLErrorHandler getErrorHandler() {
        return this.this$0.fErrorHandler;
    }
}

