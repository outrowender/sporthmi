/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

import org.apache.xerces.xni.XMLLocator;

final class ErrorHandlerWrapper$1
implements XMLLocator {
    private final /* synthetic */ String val$fPublicId;
    private final /* synthetic */ String val$fExpandedSystemId;
    private final /* synthetic */ int val$fColumnNumber;
    private final /* synthetic */ int val$fLineNumber;

    ErrorHandlerWrapper$1(String string, String string2, int n, int n2) {
        this.val$fPublicId = string;
        this.val$fExpandedSystemId = string2;
        this.val$fColumnNumber = n;
        this.val$fLineNumber = n2;
    }

    @Override
    public String getPublicId() {
        return this.val$fPublicId;
    }

    @Override
    public String getExpandedSystemId() {
        return this.val$fExpandedSystemId;
    }

    @Override
    public String getBaseSystemId() {
        return null;
    }

    @Override
    public String getLiteralSystemId() {
        return null;
    }

    @Override
    public int getColumnNumber() {
        return this.val$fColumnNumber;
    }

    @Override
    public int getLineNumber() {
        return this.val$fLineNumber;
    }

    @Override
    public int getCharacterOffset() {
        return -1;
    }

    @Override
    public String getEncoding() {
        return null;
    }

    @Override
    public String getXMLVersion() {
        return null;
    }
}

