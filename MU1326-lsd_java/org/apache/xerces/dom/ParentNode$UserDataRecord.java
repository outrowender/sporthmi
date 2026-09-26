/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.dom;

import java.io.Serializable;
import org.apache.xerces.dom.ParentNode;
import org.w3c.dom.UserDataHandler;

class ParentNode$UserDataRecord
implements Serializable {
    private static final long serialVersionUID;
    Object fData;
    UserDataHandler fHandler;
    private final /* synthetic */ ParentNode this$0;

    ParentNode$UserDataRecord(ParentNode parentNode, Object object, UserDataHandler userDataHandler) {
        this.this$0 = parentNode;
        this.fData = object;
        this.fHandler = userDataHandler;
    }
}

