/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.combi.mapcontrol;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.hmi.view.ScreenData;
import de.esolutions.hmi.widgets.audi.base.widgets.ModelStubController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CombiMapController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CombiMapScreen;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CombiMapScreenRenderer;
import org.osgi.framework.BundleContext;

public class HMIKombiMapControlActivator
extends AbstractActivator {
    private static final int COMBI_MAP_SCREEN_ID = 123456789;
    private static final int DISPLAYTYPE_UNDEFINED = 0;
    private static final int DISPlAYTYPE_LVDS = 1;
    private static final int DISPLAYTYPE_H264_MOST = 2;

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        if (this.getFramework().getKombiType() == 4 || this.getFramework().getSysConst(541) == 2 || this.getFramework().getSysConst(541) == 1) {
            this.showCombiMapControlScreen();
        }
    }

    private void showCombiMapControlScreen() {
        CombiMapScreen combiMapScreen = new CombiMapScreen(123456789);
        combiMapScreen.setRenderer(new CombiMapScreenRenderer());
        CombiMapController combiMapController = new CombiMapController();
        combiMapController.setModelID(168);
        ModelStubController modelStubController = new ModelStubController();
        modelStubController.setModelID(402521);
        combiMapController.add(modelStubController);
        if (this.getFramework().getKombiType() == 4) {
            combiMapController.setKombiTerminal(0);
            combiMapController.setDisplayType(1);
        } else if (this.getFramework().getSysConst(541) == 2) {
            combiMapController.setKombiTerminal(1);
            combiMapController.setDisplayType(1);
        } else {
            combiMapController.setKombiTerminal(1);
            combiMapController.setDisplayType(2);
        }
        combiMapScreen.setDisplayController(combiMapController);
        HMITerminal hMITerminal = this.framework.getHMITerminalRegistry().getTerminal(1);
        combiMapScreen.setTerminal(hMITerminal);
        combiMapScreen.setColorPalettes(new int[][]{{-1, -1, -1, -1, -1, -1, -1, -1, -1}});
        combiMapScreen.setColorIndices(new int[]{0});
        combiMapScreen.setViews(new int[]{168, 402521}, new HMIView[][]{{combiMapController}, {modelStubController}});
        ScreenData screenData = new ScreenData(123456789, true, false, null, false, combiMapScreen, null, null, -1L, -1L, 0, 0, 0, null);
        this.framework.getHMITerminalRegistry().getTerminalContext(1).getScreenManager().showScreen(screenData);
    }
}

