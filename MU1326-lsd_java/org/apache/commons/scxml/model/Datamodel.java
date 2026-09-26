/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.scxml.model.Data;

public class Datamodel
implements Serializable {
    private static final long serialVersionUID;
    private List data = new ArrayList();

    public final List getData() {
        return this.data;
    }

    public final void addData(Data data) {
        if (data != null) {
            this.data.add(data);
        }
    }
}

