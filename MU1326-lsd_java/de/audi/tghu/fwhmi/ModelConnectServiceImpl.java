/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.hmi.view.IModelConnectService;
import de.audi.atip.hmi.view.ITerminalContext;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.log.LogChannel;
import java.util.AbstractList;
import java.util.ArrayList;

public class ModelConnectServiceImpl
implements IModelConnectService {
    private Object unconnectedMonitor = new Object();
    private AbstractList unconnectedModelIDs = new ArrayList(10);
    private AbstractList unconnectedModelIDsSurviveScreenChange = new ArrayList(10);
    private AbstractList unconnectedViews = new ArrayList(10);
    private AbstractList unconnectedViewsSurviveScreenChange = new ArrayList(10);
    private ITerminalContext terminalContext;
    LogChannel logModelConnect;

    public ModelConnectServiceImpl(ITerminalContext iTerminalContext) {
        this.terminalContext = iTerminalContext;
        this.logModelConnect = iTerminalContext.getFramework().getLogChannel("Fw.HMIService.ModelConnect");
    }

    private ITerminalContext getTerminalContext() {
        return this.terminalContext;
    }

    private HMIService getHMIService() {
        return this.terminalContext.getHMIService();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void addToUnconnectedIDs(int n, boolean bl) {
        Object object = this.unconnectedMonitor;
        synchronized (object) {
            this.logModelConnect.log(-2137614336, "ModelConnectService.addToUnconnectedIDs(): id  == %1 ", (long)n);
            if (bl) {
                this.unconnectedModelIDsSurviveScreenChange.add(new Integer(n));
            } else {
                this.unconnectedModelIDs.add(new Integer(n));
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void removeFromUnconnectedIDs(int n, boolean bl) {
        Object object = this.unconnectedMonitor;
        synchronized (object) {
            this.logModelConnect.log(-2137614336, "ModelConnectService.removeFromUnconnectedIDs(): id  == %1 ", (long)n);
            if (bl) {
                this.unconnectedModelIDsSurviveScreenChange.remove(new Integer(n));
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void addToUnconnectedViews(HMIView hMIView, boolean bl) {
        Object object = this.unconnectedMonitor;
        synchronized (object) {
            this.logModelConnect.log(-2137614336, "ModelConnectService.addToUnconnectedViews(): view  == %1 ", (Object)hMIView);
            if (bl) {
                this.unconnectedViewsSurviveScreenChange.add(hMIView);
            } else {
                this.unconnectedViews.add(hMIView);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void removeFromUnconnectedViews(HMIView hMIView, boolean bl) {
        Object object = this.unconnectedMonitor;
        synchronized (object) {
            this.logModelConnect.log(-2137614336, "ModelConnectService.removeFromUnconnectedViews(): view  == %1 ", (Object)hMIView);
            if (bl) {
                this.unconnectedViewsSurviveScreenChange.remove(hMIView);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clearUnconnectedItems(boolean bl) {
        Object object = this.unconnectedMonitor;
        synchronized (object) {
            if (bl) {
                this.unconnectedViewsSurviveScreenChange.clear();
                this.unconnectedModelIDsSurviveScreenChange.clear();
            }
            this.unconnectedViews.clear();
            this.unconnectedModelIDs.clear();
        }
    }

    @Override
    public void checkForPostConnecting(HMIApplication hMIApplication) {
        HMIModel hMIModel;
        int n;
        HMIView hMIView;
        int n2;
        int n3 = hMIApplication.getId();
        int n4 = this.unconnectedViews.size();
        for (n2 = 0; n2 < n4; ++n2) {
            hMIView = (HMIView)this.unconnectedViews.get(n2);
            n = hMIView.getModelID();
            if (n / -1601830656 != n3 || (hMIModel = this.getHMIService().getModel(hMIView.getModelID())) == null) continue;
            this.logModelConnect.log(-2137614336, "ModelConnectService: postConnecting: view = %1 model =%2 ", (Object)hMIView, (Object)hMIModel);
            hMIView.setModel(hMIModel);
            hMIModel.addReference();
            hMIModel.deferredConnected();
            this.unconnectedViews.remove(n2);
            --n4;
            --n2;
        }
        n4 = this.unconnectedViewsSurviveScreenChange.size();
        for (n2 = 0; n2 < n4; ++n2) {
            hMIView = (HMIView)this.unconnectedViewsSurviveScreenChange.get(n2);
            n = hMIView.getModelID();
            if (n / -1601830656 != n3 || (hMIModel = this.getHMIService().getModel(hMIView.getModelID())) == null) continue;
            this.logModelConnect.log(-2137614336, "ModelConnectService: postConnecting: view = %1 model =%2 ", (Object)hMIView, (Object)hMIModel);
            hMIView.setModel(hMIModel);
            hMIModel.addReference();
            hMIModel.deferredConnected();
            this.unconnectedViewsSurviveScreenChange.remove(n2);
            --n4;
            --n2;
        }
        n4 = this.unconnectedModelIDs.size();
        for (n2 = 0; n2 < n4; ++n2) {
            HMIModel hMIModel2;
            int n5 = (Integer)this.unconnectedModelIDs.get(n2);
            if (n5 / -1601830656 != n3 || (hMIModel2 = this.getHMIService().getModel(n5)) == null) continue;
            this.logModelConnect.log(-2137614336, "ModelConnectService.checkForPostConnecting(): id == %2 model = %1 ", (Object)hMIModel2, (long)n5);
            hMIModel2.addReference();
            hMIModel2.deferredConnected();
            this.unconnectedModelIDs.remove(n2);
            --n4;
            --n2;
        }
        n4 = this.unconnectedModelIDsSurviveScreenChange.size();
        for (n2 = 0; n2 < n4; ++n2) {
            HMIModel hMIModel3;
            int n6 = (Integer)this.unconnectedModelIDsSurviveScreenChange.get(n2);
            if (n6 / -1601830656 != n3 || (hMIModel3 = this.getHMIService().getModel(n6)) == null) continue;
            this.logModelConnect.log(-2137614336, "ModelConnectService.checkForPostConnecting(): id == %2 model = %1 ", (Object)hMIModel3, (long)n6);
            hMIModel3.addReference();
            hMIModel3.deferredConnected();
            this.unconnectedModelIDsSurviveScreenChange.remove(n2);
            --n4;
            --n2;
        }
    }

    @Override
    public void modifiyModelReference(Screen screen, boolean bl, boolean bl2) {
        this.modifiyModelReference(screen.getViews(), screen.getConditionIDs(), screen.getReplacementIDs(), bl, bl2);
    }

    @Override
    public void modifiyModelReference(HMIView[] hMIViewArray, int[] nArray, int[] nArray2, boolean bl, boolean bl2) {
        this.modifyModelReferenceInViews(hMIViewArray, bl, bl2);
        this.modifyModelReferenceInConditions(nArray, bl, bl2);
        this.modifyModelReferenceInReplacements(nArray2, bl, bl2);
    }

    @Override
    public void modifyModelReference(HMIView hMIView, boolean bl, boolean bl2) {
        this.modifyModelReferenceInView(hMIView, bl, bl2);
    }

    private void modifyModelReferenceInConditions(int[] nArray, boolean bl, boolean bl2) {
        if (nArray != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (nArray[i2] == 0 || nArray[i2] == -1) continue;
                HMIModel hMIModel = this.getTerminalContext().getModel(nArray[i2]);
                if (hMIModel != null) {
                    this.logModelConnect.log(-2137614336, "ModelConnectService.modifyScreenReferenceInConditions(): conditions[i] == %2 model = %1 ", (Object)hMIModel, (long)nArray[i2]);
                    if (bl) {
                        hMIModel.addReference();
                        continue;
                    }
                    hMIModel.removeReference();
                    continue;
                }
                if (bl) {
                    this.addToUnconnectedIDs(nArray[i2], bl2);
                    continue;
                }
                this.removeFromUnconnectedIDs(nArray[i2], bl2);
            }
        }
    }

    private void modifyModelReferenceInReplacements(int[] nArray, boolean bl, boolean bl2) {
        if (nArray != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (nArray[i2] == 0) continue;
                HMIModel hMIModel = this.getTerminalContext().getModel(nArray[i2]);
                if (hMIModel != null) {
                    this.logModelConnect.log(-2137614336, "ModelConnectService.modifyScreenReferenceInReplacements(): replacements[i] = %2 model = %1", (Object)hMIModel, (long)nArray[i2]);
                    if (bl) {
                        hMIModel.addReference();
                        continue;
                    }
                    hMIModel.removeReference();
                    continue;
                }
                if (bl) {
                    this.addToUnconnectedIDs(nArray[i2], bl2);
                    continue;
                }
                this.removeFromUnconnectedIDs(nArray[i2], bl2);
            }
        }
    }

    private void modifyModelReferenceInViews(HMIView[] hMIViewArray, boolean bl, boolean bl2) {
        if (hMIViewArray != null) {
            for (int i2 = 0; i2 < hMIViewArray.length; ++i2) {
                this.modifyModelReference(hMIViewArray[i2], bl, bl2);
            }
        }
    }

    private void modifyModelReferenceInView(HMIView hMIView, boolean bl, boolean bl2) {
        if (hMIView != null) {
            HMIModel hMIModel = this.getTerminalContext().getModel(hMIView.getModelID());
            if (hMIModel != null) {
                this.logModelConnect.log(-2137614336, "ModelConnectService.modifyScreenReferenceInView(): view == %1 model == %2 ", (Object)hMIView, (Object)hMIModel);
                if (bl) {
                    hMIView.setModel(hMIModel);
                    hMIModel.addReference();
                } else {
                    hMIView.setModel(null);
                    hMIModel.removeReference();
                }
            } else if (bl) {
                this.addToUnconnectedViews(hMIView, bl2);
            } else {
                this.removeFromUnconnectedViews(hMIView, bl2);
            }
        }
    }
}

