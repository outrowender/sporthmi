.version 50 0 
.class super [95] 
.super [97] 
.implements [99] 
.field private final synthetic [100] [101] 

.method public [103] : [104] 
    .attribute [102] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [23] 
L5:     aload_0 
L6:     aload_2 
L7:     aload_3 
L8:     getstatic [2] 
L11:    ifnonnull L26 
L14:    ldc [3] 
L16:    invokestatic [4] 
L19:    dup 
L20:    putstatic [21] 
L23:    goto L29 
L26:    getstatic [2] 
L29:    invokespecial [22] 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method protected [105] : [106] 
    .attribute [102] .code stack 2 locals 0 
L0:     aload_1 
L1:     checkcast [5] 
L4:     aload_0 
L5:     invokeinterface [24] 0 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected enum [107] : [108] 
    .attribute [102] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [102] .code stack 5 locals 0 
L0:     iload_1 
L1:     tableswitch 0 
            L57 
            L72 
            L32 
            L42 
            default : L82 

L32:    aload_0 
L33:    getfield [15] 
L36:    invokevirtual [16] 
L39:    goto L96 
L42:    aload_0 
L43:    getfield [17] 
L46:    ldc [6] 
L48:    ldc [7] 
L50:    invokevirtual [18] 
L53:    pop 
L54:    goto L96 
L57:    aload_0 
L58:    getfield [17] 
L61:    ldc [6] 
L63:    ldc [8] 
L65:    invokevirtual [18] 
L68:    pop 
L69:    goto L96 
L72:    aload_0 
L73:    getfield [15] 
L76:    invokevirtual [19] 
L79:    goto L96 
L82:    aload_0 
L83:    getfield [17] 
L86:    ldc [9] 
L88:    ldc [10] 
L90:    iload_1 
L91:    i2l 
L92:    invokevirtual [20] 
L95:    pop 
L96:    return 
L97:    nop 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [25] [26] 
.const [3] = String [27] 
.const [4] = Method [28] [29] 
.const [5] = Class [30] 
.const [6] = Int -2137614336 
.const [7] = String [31] 
.const [8] = String [32] 
.const [9] = Int -1601830656 
.const [10] = String [33] 
.const [11] = Class [34] 
.const [12] = Class [35] 
.const [13] = Class [36] 
.const [14] = Class [37] 
.const [15] = Field [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Field [42] [43] 
.const [18] = Method [44] [45] 
.const [19] = Method [46] [47] 
.const [20] = Method [48] [49] 
.const [21] = Field [50] [51] 
.const [22] = Method [52] [53] 
.const [23] = Field [54] [55] 
.const [24] = InterfaceMethod [56] [57] 
.const [25] = Class [58] 
.const [26] = NameAndType [59] [60] 
.const [27] = Utf8 'de.audi.atip.mmicombi.IViewSizeManager' 
.const [28] = Class [61] 
.const [29] = NameAndType [62] [63] 
.const [30] = Utf8 de/audi/atip/mmicombi/IViewSizeManager 
.const [31] = Utf8 '[AbstractTelStageChangeListener.ViewSizeServiceTrackerListener#viewSizeChanged] VIEW_SIZE_LOGICAL_POPUP --> NOP!' 
.const [32] = Utf8 '[AbstractTelStageChangeListener.ViewSizeServiceTrackerListener#viewSizeChanged] VIEW_SIZE_NO_CHANGE --> NOP!' 
.const [33] = Utf8 '[AbstractTelStageChangeListener.ViewSizeServiceTrackerListener#viewSizeChanged] unknown view size %1' 
.const [34] = Utf8 de/audi/app/phone/evo/util/AbstractTelStageChangeListener$ViewSizeServiceTrackerListener 
.const [35] = Utf8 de/audi/app/phone/core/util/AbstractTelServiceTracker 
.const [36] = Utf8 de/audi/app/phone/evo/util/AbstractTelStageChangeListener 
.const [37] = Utf8 de/audi/atip/log/LogChannel 
.const [38] = Class [64] 
.const [39] = NameAndType [65] [66] 
.const [40] = Class [67] 
.const [41] = NameAndType [68] [69] 
.const [42] = Class [70] 
.const [43] = NameAndType [71] [72] 
.const [44] = Class [73] 
.const [45] = NameAndType [74] [75] 
.const [46] = Class [76] 
.const [47] = NameAndType [77] [78] 
.const [48] = Class [79] 
.const [49] = NameAndType [80] [81] 
.const [50] = Class [82] 
.const [51] = NameAndType [83] [84] 
.const [52] = Class [85] 
.const [53] = NameAndType [86] [87] 
.const [54] = Class [88] 
.const [55] = NameAndType [89] [90] 
.const [56] = Class [91] 
.const [57] = NameAndType [92] [93] 
.const [58] = Utf8 de/audi/app/phone/evo/util/AbstractTelStageChangeListener 
.const [59] = Utf8 class$de$audi$atip$mmicombi$IViewSizeManager 
.const [60] = Utf8 Ljava/lang/Class; 
.const [61] = Utf8 de/audi/app/phone/evo/util/AbstractTelStageChangeListener 
.const [62] = Utf8 class$ 
.const [63] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [64] = Utf8 de/audi/app/phone/evo/util/AbstractTelStageChangeListener$ViewSizeServiceTrackerListener 
.const [65] = Utf8 this$0 
.const [66] = Utf8 Lde/audi/app/phone/evo/util/AbstractTelStageChangeListener; 
.const [67] = Utf8 de/audi/app/phone/evo/util/AbstractTelStageChangeListener 
.const [68] = Utf8 largeStateShown 
.const [69] = Utf8 ()V 
.const [70] = Utf8 de/audi/app/phone/evo/util/AbstractTelStageChangeListener$ViewSizeServiceTrackerListener 
.const [71] = Utf8 log 
.const [72] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [73] = Utf8 de/audi/atip/log/LogChannel 
.const [74] = Utf8 log 
.const [75] = Utf8 (ILjava/lang/String;)Z 
.const [76] = Utf8 de/audi/app/phone/evo/util/AbstractTelStageChangeListener 
.const [77] = Utf8 smallStageShown 
.const [78] = Utf8 ()V 
.const [79] = Utf8 de/audi/atip/log/LogChannel 
.const [80] = Utf8 log 
.const [81] = Utf8 (ILjava/lang/String;J)Z 
.const [82] = Utf8 de/audi/app/phone/evo/util/AbstractTelStageChangeListener 
.const [83] = Utf8 class$de$audi$atip$mmicombi$IViewSizeManager 
.const [84] = Utf8 Ljava/lang/Class; 
.const [85] = Utf8 de/audi/app/phone/core/util/AbstractTelServiceTracker 
.const [86] = Utf8 <init> 
.const [87] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;Ljava/lang/Class;)V 
.const [88] = Utf8 de/audi/app/phone/evo/util/AbstractTelStageChangeListener$ViewSizeServiceTrackerListener 
.const [89] = Utf8 this$0 
.const [90] = Utf8 Lde/audi/app/phone/evo/util/AbstractTelStageChangeListener; 
.const [91] = Utf8 de/audi/atip/mmicombi/IViewSizeManager 
.const [92] = Utf8 addViewSizeListener 
.const [93] = Utf8 (Lde/audi/atip/mmicombi/IViewSizeListener;)V 
.const [94] = Utf8 de/audi/app/phone/evo/util/AbstractTelStageChangeListener$ViewSizeServiceTrackerListener 
.const [95] = Class [94] 
.const [96] = Utf8 de/audi/app/phone/core/util/AbstractTelServiceTracker 
.const [97] = Class [96] 
.const [98] = Utf8 de/audi/atip/mmicombi/IViewSizeListener 
.const [99] = Class [98] 
.const [100] = Utf8 this$0 
.const [101] = Utf8 Lde/audi/app/phone/evo/util/AbstractTelStageChangeListener; 
.const [102] = Utf8 Code 
.const [103] = Utf8 <init> 
.const [104] = Utf8 (Lde/audi/app/phone/evo/util/AbstractTelStageChangeListener;Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;)V 
.const [105] = Utf8 serviceAvailable 
.const [106] = Utf8 (Ljava/lang/Object;)V 
.const [107] = Utf8 serviceRemoved 
.const [108] = Utf8 (Ljava/lang/Object;)V 
.const [109] = Utf8 viewSizeChanged 
.const [110] = Utf8 (I)V 
.end class 
