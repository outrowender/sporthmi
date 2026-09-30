/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.tv;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.media.evo.content.tv.DrawerContextListRow;
import de.audi.app.media.evo.content.tv.NullMediaDrawerContextListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.interapp.media.IMediaDrawerContext;
import de.audi.atip.interapp.media.IMediaDrawerContextListener;
import de.audi.atip.interapp.media.IMediaDrawerElement;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DrawerContextHandler
extends AbstractMediaTerminalComponent
implements IMediaDrawerContext,
BaseListModelListener,
IDiagnosisCommandProvider {
    private static final String LOGCLASS = "DrawerContextHandler";
    protected static final int STATE_INACTIVE = 0;
    protected static final int STATE_ACTIVE = 1;
    protected final IMediaDrawerContextListener nullDrawerContextListener;
    protected final LogChannel logger;
    protected final BaseListModelApp drawerContextListModel;
    protected volatile IMediaDrawerContextListener drawerContextListener;
    protected int state;

    public DrawerContextHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.logger = iMediaTerminal.getLogger().main();
        this.drawerContextListModel = this.getBaseListModel(200597);
        this.nullDrawerContextListener = new NullMediaDrawerContextListener(iMediaTerminal.getLogger().main());
        iMediaTerminal.getDiagnosisManager().addCommandProvider(-1, this);
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.state = 0;
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
    }

    public void activate() {
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
        this.state = 1;
        this.drawerContextListModel.setListener(this);
    }

    public void deactivate() {
        this.logger.log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.getChoiceModel(200628).setValue(0);
        this.state = 0;
        this.drawerContextListModel.removeAll();
        this.drawerContextListModel.resetListener();
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logger.log(1000000, "[%1.itemSelected]", (Object)LOGCLASS);
        DrawerContextListRow drawerContextListRow = (DrawerContextListRow)evoListRow;
        IMediaDrawerElement iMediaDrawerElement = drawerContextListRow.getMediaDrawerElement();
        this.drawerContextListModel.setSelectedUniqueID(iMediaDrawerElement.getID());
        this.getChoiceModel(200628).setValue(drawerContextListRow.getCategoryId());
        this.drawerContextListener.drawerElementSelected(iMediaDrawerElement);
        this.drawerContextListModel.fireEvent(n4);
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setDrawerElements(List list, IMediaDrawerContextListener iMediaDrawerContextListener) {
        this.logger.log(1000000, "[%1.setDrawerElements]", (Object)LOGCLASS);
        if (this.state == 0) {
            this.logger.log(1000000, "[%1.setDrawerElements] TV not active source ignore", (Object)LOGCLASS);
            return;
        }
        this.drawerContextListener = null == iMediaDrawerContextListener ? this.nullDrawerContextListener : iMediaDrawerContextListener;
        if (null == list || list.isEmpty()) {
            this.logger.log(1000000, "[%1.setDrawerElements] List empty.", (Object)LOGCLASS);
            this.drawerContextListModel.removeAll();
            this.drawerContextListModel.trigger(ModelTrigger.CLOSE_SELECTION_DRAWER);
            return;
        }
        BaseListModelApp baseListModelApp = this.drawerContextListModel.getCopy();
        try {
            baseListModelApp.removeAll();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                IMediaDrawerElement iMediaDrawerElement = (IMediaDrawerElement)iterator.next();
                DrawerContextListRow drawerContextListRow = new DrawerContextListRow(iMediaDrawerElement);
                baseListModelApp.append(drawerContextListRow);
                if (iMediaDrawerElement.isSelected()) {
                    baseListModelApp.setSelectedUniqueID(iMediaDrawerElement.getID());
                    this.getChoiceModel(200628).setValue(drawerContextListRow.getCategoryId());
                }
                if (!iMediaDrawerElement.isFocused() || baseListModelApp.getMenu() == null) continue;
                baseListModelApp.getMenu().setFocusedItem(baseListModelApp.getID(), FocusAdvice.KEEP_POSITION, iMediaDrawerElement.getID());
            }
        }
        finally {
            this.drawerContextListModel.update(baseListModelApp);
            if (baseListModelApp.getLength() <= 0) {
                this.drawerContextListModel.trigger(ModelTrigger.CLOSE_SELECTION_DRAWER);
            }
        }
    }

    public String[] getDiagKeys() {
        return new String[]{"setDrawerElements"};
    }

    public void executeDiagCommand(String string, String[] stringArray) {
        if ("setDrawerElements".equals(string)) {
            ArrayList arrayList = new ArrayList(stringArray.length);
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                final int n = Integer.parseInt(stringArray[i2]);
                arrayList.add(new IMediaDrawerElement(){
                    int id;
                    {
                        this.id = n;
                    }

                    public String getName() {
                        return null;
                    }

                    public int getID() {
                        return this.id;
                    }

                    public int getIconID() {
                        return 0;
                    }

                    public boolean isSelected() {
                        return false;
                    }

                    public boolean isFocused() {
                        return false;
                    }
                });
            }
            this.setDrawerElements(arrayList, new IMediaDrawerContextListener(){

                public void drawerElementSelected(IMediaDrawerElement iMediaDrawerElement) {
                    DrawerContextHandler.this.logger.log(1000000, "[IMediaDrawerContextListener.drawerElementSelected]");
                }
            });
        }
    }
}

