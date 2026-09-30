/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.evo.setup;

import de.audi.app.data.core.IDataApplication;
import de.audi.app.data.core.setup.AbstractDataSetup;
import java.io.File;

public class DataSetup
extends AbstractDataSetup {
    private static final String PATH_USELOCALNET = "/eso/hmi/uselocalnet";

    public DataSetup(IDataApplication iDataApplication) {
        super(iDataApplication);
    }

    public void init() {
        super.init();
        File file = new File(PATH_USELOCALNET);
        boolean bl = file.exists();
        this.enableLocalNetMode(bl);
        if (bl) {
            this.dataApplication.getOnline().notifyLocalNetMode();
        }
    }
}

