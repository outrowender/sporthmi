/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.evo.setup;

import de.audi.app.data.core.IDataApplication;
import de.audi.app.data.core.setup.AbstractDataSetup;
import java.io.File;

public class DataSetup
extends AbstractDataSetup {
    private static final String PATH_USELOCALNET;

    public DataSetup(IDataApplication iDataApplication) {
        super(iDataApplication);
    }

    @Override
    public void init() {
        super.init();
        File file = new File("/eso/hmi/uselocalnet");
        boolean bl = file.exists();
        this.enableLocalNetMode(bl);
        if (bl) {
            this.dataApplication.getOnline().notifyLocalNetMode();
        }
    }
}

