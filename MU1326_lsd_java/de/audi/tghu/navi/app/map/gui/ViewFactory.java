/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.IMapPartialPopupHandler;
import de.audi.tghu.navi.app.map.IMapPropertyProvider;
import de.audi.tghu.navi.app.map.gui.IAsiaMapContentView;
import de.audi.tghu.navi.app.map.gui.IMapContentView;
import de.audi.tghu.navi.app.map.gui.MainMapView;
import de.audi.tghu.navi.app.map.gui.MapOptionView;
import de.audi.tghu.navi.app.map.gui.MapSetupView;
import de.audi.tghu.navi.app.map.gui.SemidynRGView;
import de.audi.tghu.navi.app.map.gui.views.AsiaMapContentView;
import de.audi.tghu.navi.app.map.gui.views.AsiaMapContentViewCluster;
import de.audi.tghu.navi.app.map.gui.views.RouteBriefingView;
import de.audi.tghu.navi.app.map.gui.views.RubberbandView;
import de.audi.tghu.navi.app.util.Util;

public class ViewFactory {
    public static final int GOOGLE_3D_CITY_MODEL_NOT_VISIBLE = 0;
    public static final int GOOGLE_3D_CITY_MODEL_VISIBLE = 1;
    protected final NavigationEnv env;
    private final IMapPropertyProvider mapPropertyProvider;
    protected IMapPartialPopupHandler mapPartialPopupHandler;
    protected SemidynRGView semidynView;
    private MainMapView mainMapView;
    private MapSetupView setupView;
    private MapOptionView mapOptionView;
    private RouteBriefingView routeBriefingView;
    private AsiaMapContentView asiaMapContentView;
    private RubberbandView rubberbandView;

    public ViewFactory(NavigationEnv navigationEnv, IMapPropertyProvider iMapPropertyProvider, IMapPartialPopupHandler iMapPartialPopupHandler) {
        this.env = navigationEnv;
        this.mapPropertyProvider = iMapPropertyProvider;
        this.mapPartialPopupHandler = iMapPartialPopupHandler;
        this.getRubberbandView();
    }

    public IMapContentView createMapContentViewMain() {
        this.env.getChoiceModel(402027).setValue(Util.isGoogle3dCityModelAvailable() ? 1 : 0);
        return new IMapContentView(){

            public BaseListModelApp getStandardList() {
                return ViewFactory.this.env.getBaseListModel(401352);
            }

            public BaseListModelApp getStandardListLevel2() {
                return ViewFactory.this.env.getBaseListModel(402748);
            }

            public BaseListModelApp getStandardListLevel3() {
                return ViewFactory.this.env.getBaseListModel(402749);
            }

            public ChoiceModelApp getCheckAllStandard() {
                return ViewFactory.this.env.getChoiceModel(400787);
            }

            public BaseListModelApp getKMLLayersList() {
                return ViewFactory.this.env.getBaseListModel(402571);
            }

            public BaseListModelApp getPPOIList() {
                return ViewFactory.this.env.getBaseListModel(401350);
            }

            public void setMyAudiAvailable(boolean bl) {
                ViewFactory.this.env.getChoiceModel(401575).setValue(bl ? 1 : 0);
            }
        };
    }

    public IMapContentView createMapContentViewCluster() {
        return new IMapContentView(){

            public BaseListModelApp getStandardList() {
                return ViewFactory.this.env.getBaseListModel(401128);
            }

            public BaseListModelApp getStandardListLevel2() {
                return ViewFactory.this.env.getBaseListModel(402750);
            }

            public BaseListModelApp getStandardListLevel3() {
                return ViewFactory.this.env.getBaseListModel(402751);
            }

            public ChoiceModelApp getCheckAllStandard() {
                return ViewFactory.this.env.getChoiceModel(401127);
            }

            public BaseListModelApp getKMLLayersList() {
                return ViewFactory.this.env.getBaseListModel(401349);
            }

            public BaseListModelApp getPPOIList() {
                return ViewFactory.this.env.getBaseListModel(401351);
            }

            public void setMyAudiAvailable(boolean bl) {
                ViewFactory.this.env.getChoiceModel(401576).setValue(bl ? 1 : 0);
            }
        };
    }

    public IAsiaMapContentView createAsiaMapContentView() {
        return new AsiaMapContentView(this.env);
    }

    public IAsiaMapContentView createAsiaMapContentViewCluster() {
        return new AsiaMapContentViewCluster(this.env);
    }

    public SemidynRGView getSemidynRGView() {
        if (this.semidynView == null) {
            this.semidynView = new SemidynRGView(this.env, this.mapPartialPopupHandler);
        }
        return this.semidynView;
    }

    public MainMapView getMainMapView() {
        if (this.mainMapView == null) {
            this.mainMapView = new MainMapView(this.env, this.mapPropertyProvider);
        }
        return this.mainMapView;
    }

    public MapSetupView getMapSetupView() {
        if (this.setupView == null) {
            this.setupView = new MapSetupView(this.env, Util.isClusterMapFPK(this.env.getFramework()), Util.isClusterRGI(this.env.getFramework()), Util.isClusterMMI(this.env.getFramework()), Util.isHURegionNAR(), Util.isMapInMapAvailable(this.env.getFramework()));
        }
        return this.setupView;
    }

    public MapOptionView getMapOptionView() {
        if (this.mapOptionView == null) {
            this.mapOptionView = new MapOptionView(this.env);
        }
        return this.mapOptionView;
    }

    public RouteBriefingView getRouteBriefingView() {
        if (this.routeBriefingView == null) {
            this.routeBriefingView = new RouteBriefingView(this.env);
        }
        return this.routeBriefingView;
    }

    public AsiaMapContentView getAsiaMapContentView() {
        if (this.asiaMapContentView == null) {
            this.asiaMapContentView = new AsiaMapContentView(this.env);
        }
        return this.asiaMapContentView;
    }

    public RubberbandView getRubberbandView() {
        if (this.rubberbandView == null) {
            this.rubberbandView = new RubberbandView(this.env);
        }
        return this.rubberbandView;
    }
}

