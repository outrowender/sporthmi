.version 50 0 
.class public super [89] 
.super [91] 
.implements [93] 
.field private static final [94] [95] 
.field private static final [96] [97] 
.field protected final [98] [99] 

.method public [101] : [102] 
    .attribute [100] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [23] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [100] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [17] 
L4:     invokevirtual [18] 
L7:     invokevirtual [19] 
L10:    ifeq L35 
L13:    aload_0 
L14:    getfield [17] 
L17:    invokevirtual [18] 
L20:    ldc [2] 
L22:    ldc [3] 
L24:    aload_2 
L25:    invokestatic [4] 
L28:    iload_1 
L29:    invokestatic [5] 
L32:    invokevirtual [20] 
L35:    iconst_0 
L36:    istore_3 
L37:    iload_1 
L38:    ifeq L51 
L41:    aload_2 
L42:    ifnull L51 
L45:    aload_2 
L46:    iconst_1 
L47:    invokestatic [6] 
L50:    istore_3 
L51:    aload_0 
L52:    getfield [17] 
L55:    ldc [7] 
L57:    invokevirtual [21] 
L60:    iload_3 
L61:    invokeinterface [24] 0 
L66:    iload_1 
L67:    ifeq L74 
L70:    iconst_2 
L71:    goto L75 
L74:    iconst_1 
L75:    istore 4 
L77:    aload_0 
L78:    getfield [17] 
L81:    ldc [8] 
L83:    invokevirtual [21] 
L86:    iload 4 
L88:    invokeinterface [24] 0 
L93:    return 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [100] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     ldc [7] 
L6:     invokevirtual [21] 
L9:     iload_1 
L10:    invokeinterface [24] 0 
L15:    return 
L16:    
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [100] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     ldc [9] 
L6:     invokevirtual [21] 
L9:     iload_1 
L10:    ifeq L17 
L13:    iconst_1 
L14:    goto L18 
L17:    iconst_0 
L18:    invokeinterface [24] 0 
L23:    return 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 14808325 
.const [3] = String [25] 
.const [4] = Method [26] [27] 
.const [5] = Method [28] [29] 
.const [6] = Method [30] [31] 
.const [7] = Int 1360856576 
.const [8] = Int -417528320 
.const [9] = Int -2010970624 
.const [10] = Class [32] 
.const [11] = Class [33] 
.const [12] = Class [34] 
.const [13] = Class [35] 
.const [14] = Class [36] 
.const [15] = Class [37] 
.const [16] = Class [38] 
.const [17] = Field [39] [40] 
.const [18] = Method [41] [42] 
.const [19] = Method [43] [44] 
.const [20] = Method [45] [46] 
.const [21] = Method [47] [48] 
.const [22] = Method [49] [50] 
.const [23] = Field [51] [52] 
.const [24] = InterfaceMethod [53] [54] 
.const [25] = Utf8 '[RouteGuidanceModel] RouteGuidanceStateModelAccess#updateRgActive - currentRoute: %1, isRgActive: %2 ' 
.const [26] = Class [55] 
.const [27] = NameAndType [56] [57] 
.const [28] = Class [58] 
.const [29] = NameAndType [59] [60] 
.const [30] = Class [61] 
.const [31] = NameAndType [62] [63] 
.const [32] = Utf8 de/audi/tghu/navi/app/routeguidance/RouteGuidanceStateModelAccess 
.const [33] = Utf8 java/lang/Object 
.const [34] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [35] = Utf8 de/audi/atip/log/LogChannel 
.const [36] = Utf8 de/audi/tghu/navi/app/util/RouteUtil 
.const [37] = Utf8 java/lang/Boolean 
.const [38] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [39] = Class [64] 
.const [40] = NameAndType [65] [66] 
.const [41] = Class [67] 
.const [42] = NameAndType [68] [69] 
.const [43] = Class [70] 
.const [44] = NameAndType [71] [72] 
.const [45] = Class [73] 
.const [46] = NameAndType [74] [75] 
.const [47] = Class [76] 
.const [48] = NameAndType [77] [78] 
.const [49] = Class [79] 
.const [50] = NameAndType [80] [81] 
.const [51] = Class [82] 
.const [52] = NameAndType [83] [84] 
.const [53] = Class [85] 
.const [54] = NameAndType [86] [87] 
.const [55] = Utf8 de/audi/tghu/navi/app/util/RouteUtil 
.const [56] = Utf8 formatRouteShort 
.const [57] = Utf8 (Lorg/dsi/ifc/navigation/Route;)Ljava/lang/String; 
.const [58] = Utf8 java/lang/Boolean 
.const [59] = Utf8 toString 
.const [60] = Utf8 (Z)Ljava/lang/String; 
.const [61] = Utf8 de/audi/tghu/navi/app/util/RouteUtil 
.const [62] = Utf8 getNumberOfRemainingDestinations 
.const [63] = Utf8 (Lorg/dsi/ifc/navigation/Route;I)I 
.const [64] = Utf8 de/audi/tghu/navi/app/routeguidance/RouteGuidanceStateModelAccess 
.const [65] = Utf8 env 
.const [66] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [67] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [68] = Utf8 getLogChannel 
.const [69] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [70] = Utf8 de/audi/atip/log/LogChannel 
.const [71] = Utf8 isDebug2 
.const [72] = Utf8 ()Z 
.const [73] = Utf8 de/audi/atip/log/LogChannel 
.const [74] = Utf8 log 
.const [75] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [76] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [77] = Utf8 getChoiceModel 
.const [78] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [79] = Utf8 java/lang/Object 
.const [80] = Utf8 <init> 
.const [81] = Utf8 ()V 
.const [82] = Utf8 de/audi/tghu/navi/app/routeguidance/RouteGuidanceStateModelAccess 
.const [83] = Utf8 env 
.const [84] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [85] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [86] = Utf8 setValue 
.const [87] = Utf8 (I)V 
.const [88] = Utf8 de/audi/tghu/navi/app/routeguidance/RouteGuidanceStateModelAccess 
.const [89] = Class [88] 
.const [90] = Utf8 java/lang/Object 
.const [91] = Class [90] 
.const [92] = Utf8 de/audi/tghu/navi/app/routeguidance/IRouteGuidanceStateModelAccess 
.const [93] = Class [92] 
.const [94] = Utf8 RG_STATE_INACTIVE 
.const [95] = Utf8 I 
.const [96] = Utf8 RG_STATE_ACTIVE 
.const [97] = Utf8 I 
.const [98] = Utf8 env 
.const [99] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [100] = Utf8 Code 
.const [101] = Utf8 <init> 
.const [102] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [103] = Utf8 updateRgActive 
.const [104] = Utf8 (ZLorg/dsi/ifc/navigation/Route;)V 
.const [105] = Utf8 updateActiveDestinations 
.const [106] = Utf8 (I)V 
.const [107] = Utf8 setPredictiveRgRunning 
.const [108] = Utf8 (Z)V 
.end class 
