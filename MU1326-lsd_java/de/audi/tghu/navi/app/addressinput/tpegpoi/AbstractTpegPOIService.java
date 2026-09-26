/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.tpegpoi;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.command.Monitor;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.tpegpoi.ITpegPOIManager;
import de.audi.tghu.navi.app.addressinput.tpegpoi.ITpegPOIService;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.util.Util;

public abstract class AbstractTpegPOIService
implements ITpegPOIService {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    protected final ICommandListFactory commandListFactory;
    protected final MapInterface mapInterface;
    protected final IPreviewMap previewMap;
    protected final SpellerStack spellerStack;
    protected ITpegPOIManager inputManager = null;
    protected final Monitor tpegPOICommandListMonitor;

    public AbstractTpegPOIService(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, MapInterface mapInterface, SpellerStack spellerStack) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getPOILogChannel();
        this.commandListFactory = iCommandListFactory;
        this.mapInterface = mapInterface;
        this.previewMap = mapInterface.getPreviewMap();
        this.spellerStack = spellerStack;
        this.tpegPOICommandListMonitor = new Monitor(this.logChannel);
    }

    protected abstract void initTpegPOIInput() {
    }

    @Override
    public void destTpegPOIHKReturn(int n, int n2) {
        this.inputManager.destTpegPOIHKReturn(n, n2);
    }

    @Override
    public void checkIfTpegPOIAvailable() {
    }
}

