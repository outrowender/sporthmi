/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi.evo;

import de.audi.atip.hmi.HMIBundle;
import de.audi.atip.hmi.view.IDrawerController;
import de.audi.tghu.fwhmi.HMIRegistry;
import de.audi.tghu.fwhmi.evo.FwHMIEvo;
import de.audi.tghu.hmi.evo.IDrawerControllerEvo;
import org.osgi.framework.BundleContext;

public class HMIRegistryEvo
extends HMIRegistry {
    public HMIRegistryEvo(BundleContext bundleContext, FwHMIEvo fwHMIEvo) {
        super(bundleContext, fwHMIEvo);
    }

    public IDrawerControllerEvo[] getSelectionDrawers(int n, int n2) {
        IDrawerControllerEvo[] iDrawerControllerEvoArray = null;
        HMIBundle hMIBundle = this.getHMIBundle(n2 * 100000);
        if (hMIBundle != null) {
            this.log.log(10000000, "HMIRegistryEvo.getSelectionDrawers(): hmiBundle == %1", (Object)hMIBundle);
            long l = this.getFramework().getMonotonicTime();
            iDrawerControllerEvoArray = this.toEvo(hMIBundle.getSelectionDrawers(n));
            this.log.log(10000000, "HMIRegistryEvo.getSelectionDrawers moduledID(%1) creating drawers took: %2", (long)n2, this.getFramework().getMonotonicTime() - l);
            if (iDrawerControllerEvoArray == null && n2 != 0) {
                this.log.log(10000, "HMIRegistryEvo.getSelectionDrawers(): selectionDrawers (%1) not found ", (long)n2);
            }
        } else {
            this.log.log(10000, "HMIRegistryEvo.getSelectionDrawers(): No HMIBundle for moduleID %1 ", (long)n2);
        }
        this.log.log(10000000, "HMIRegistryEvo.getSelectionDrawers(): returning %1 ", iDrawerControllerEvoArray);
        return iDrawerControllerEvoArray;
    }

    public IDrawerControllerEvo[] getOptionDrawers(int n, int n2) {
        IDrawerControllerEvo[] iDrawerControllerEvoArray = null;
        HMIBundle hMIBundle = this.getHMIBundle(n2 * 100000);
        if (hMIBundle != null) {
            this.log.log(10000000, "HMIRegistryEvo.getOptionDrawers(): hmiBundle == %1", (Object)hMIBundle);
            long l = this.getFramework().getMonotonicTime();
            iDrawerControllerEvoArray = this.toEvo(hMIBundle.getOptionDrawers(n));
            this.log.log(10000000, "HMIRegistryEvo.getOptionDrawers moduledID(%1) creating drawers took: %2", (long)n2, this.getFramework().getMonotonicTime() - l);
            if (iDrawerControllerEvoArray == null) {
                this.log.log(10000, "HMIRegistryEvo.getOptionDrawers(): optionDrawers (%1) not found ", (long)n2);
            }
        } else {
            this.log.log(10000, "HMIRegistryEvo.getOptionDrawers(): No HMIBundle for moduleID %1 ", (long)n2);
        }
        this.log.log(10000000, "HMIRegistryEvo.getOptionDrawers(): returning %1 ", iDrawerControllerEvoArray);
        return iDrawerControllerEvoArray;
    }

    private IDrawerControllerEvo[] toEvo(IDrawerController[] iDrawerControllerArray) {
        IDrawerControllerEvo[] iDrawerControllerEvoArray = null;
        if (null != iDrawerControllerArray) {
            iDrawerControllerEvoArray = new IDrawerControllerEvo[iDrawerControllerArray.length];
            System.arraycopy((Object)iDrawerControllerArray, 0, (Object)iDrawerControllerEvoArray, 0, iDrawerControllerArray.length);
        }
        return iDrawerControllerEvoArray;
    }
}

