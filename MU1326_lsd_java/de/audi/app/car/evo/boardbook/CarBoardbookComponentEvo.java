/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.boardbook;

import de.audi.app.car.common.ap.IActionProxyListener;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.boardbook.AbstractCarBoardbookComponent;
import de.audi.app.car.evo.boardbook.BoardbookHandlerEvo;
import de.audi.atip.interapp.phone.ITelState;
import java.util.Map;

public class CarBoardbookComponentEvo
extends AbstractCarBoardbookComponent
implements IActionProxyListener {
    public static final String LOGCLASS = (class$de$audi$app$car$evo$boardbook$CarBoardbookComponentEvo == null ? (class$de$audi$app$car$evo$boardbook$CarBoardbookComponentEvo = CarBoardbookComponentEvo.class$("de.audi.app.car.evo.boardbook.CarBoardbookComponentEvo")) : class$de$audi$app$car$evo$boardbook$CarBoardbookComponentEvo).getName();
    static /* synthetic */ Class class$de$audi$app$car$evo$boardbook$CarBoardbookComponentEvo;

    public CarBoardbookComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(1, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(2, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(3, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(4, this);
        this.boardbookHandler = new BoardbookHandlerEvo(this.getLogChannel(), this.getApplication().getFrameworkAccess().getHMIService(), this.getApplication());
        this.boardbookHandler.indicateBoardbookAvailable(false);
    }

    @Override
    public int getID() {
        return 30;
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 1: {
                this.boardbookHandler.setVideoLoading(false);
                this.getLogChannel().log(1078071040, "%1#actionproxyCallPerformed() BrowserScreen entered", (Object)LOGCLASS);
                this.startBoardbook();
                break;
            }
            case 2: {
                if (!this.boardbookHandler.isVideoLoading()) {
                    this.getLogChannel().log(1078071040, "%1#actionproxyCallPerformed() BrowserScreen left", (Object)LOGCLASS);
                    this.boardbookHandler.setVideoLoading(false);
                    this.stopBoardbook();
                    break;
                }
                this.boardbookHandler.setVideoLoading(false);
                this.getLogChannel().log(1078071040, "%1#actionproxyCallPerformed() BrowserVideoScreen left -> cancel video loading", (Object)LOGCLASS);
                this.stopMediaPlayback();
                break;
            }
            case 4: {
                this.boardbookHandler.setVideoLoading(false);
                this.getLogChannel().log(1078071040, "%1#actionproxyCallPerformed() BrowserVideoScreen left", (Object)LOGCLASS);
                this.stopMediaPlayback();
                break;
            }
            case 3: {
                this.getLogChannel().log(1078071040, "%1#actionproxyCallPerformed() BrowserVideoScreen entered", (Object)LOGCLASS);
                this.boardbookHandler.setVideoLoading(false);
                break;
            }
            default: {
                this.boardbookHandler.setVideoLoading(false);
                throw new IllegalArgumentException(new StringBuffer().append(LOGCLASS).append("#actionproxyCallPerformed() Unknown actionproxy call").toString());
            }
        }
    }

    @Override
    public void updateTelState(int n, ITelState iTelState) {
        boolean bl;
        if (n == 2 && (bl = iTelState.isIncomingCallPresent())) {
            super.returntoVideoOverView();
            this.getLogChannel().log(1078071040, "CarBoardbookComponentEvo#updateTelState() Returning to VideoOverView");
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

