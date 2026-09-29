/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.dump;

import de.audi.app.car.common.dump.IDumpHandler;
import java.util.HashMap;
import java.util.Map;

public class DumpHandler
implements IDumpHandler {
    private final String name;
    private Map data;

    public DumpHandler(String string) {
        this.name = string;
        this.data = new HashMap();
    }

    @Override
    public void updateData(String string, String string2) {
        this.data.put(string, string2);
    }

    @Override
    public HashMap getData() {
        return (HashMap)this.data;
    }

    @Override
    public String getName() {
        return this.name;
    }
}

