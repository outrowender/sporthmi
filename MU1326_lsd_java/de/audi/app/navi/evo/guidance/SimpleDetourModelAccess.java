/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.guidance;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.ISimpleDetourModelAccess;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;

public class SimpleDetourModelAccess
implements ISimpleDetourModelAccess {
    private NavigationEnv env;

    public SimpleDetourModelAccess(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
    }

    public void reset(int n) {
        this.env.getRangeModel(400733).setLimits(0, n, 1);
        this.env.getRangeModel(400733).setValue(0);
    }

    public void detourAdded(boolean bl) {
        this.env.getChoiceModel(400749).setValue(bl ? 1 : 0);
    }

    public void refreshDistanceTextfield(int n) {
        Buffer buffer = new Buffer();
        buffer.append(Util.formatDistance(n, 3));
        this.env.getTextfieldModel(400734).setText1(buffer.toString());
    }

    public void updateBlockingAvailable(boolean bl) {
        this.env.getChoiceModel(401315).setValue(bl ? 1 : 0);
    }
}

