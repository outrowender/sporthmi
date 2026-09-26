/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.dom;

import java.io.Serializable;
import org.apache.xerces.dom.DocumentImpl;
import org.w3c.dom.events.EventListener;

class DocumentImpl$LEntry
implements Serializable {
    private static final long serialVersionUID;
    String type;
    EventListener listener;
    boolean useCapture;
    private final /* synthetic */ DocumentImpl this$0;

    DocumentImpl$LEntry(DocumentImpl documentImpl, String string, EventListener eventListener, boolean bl) {
        this.this$0 = documentImpl;
        this.type = string;
        this.listener = eventListener;
        this.useCapture = bl;
    }
}

