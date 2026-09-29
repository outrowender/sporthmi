.version 50 0 
.class public super [162] 
.super [164] 
.implements [166] 
.field private final [167] [168] 
.field private final [169] [170] 
.field private final [171] [172] 

.method public [174] : [175] 
    .attribute [173] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [28] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [31] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [32] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [33] 
L19:    aload_0 
L20:    aload_3 
L21:    invokevirtual [18] 
L24:    invokespecial [29] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [176] : [177] 
    .attribute [173] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     aload_0 
L5:     getfield [16] 
L8:     invokevirtual [19] 
L11:    invokeinterface [34] 0 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public final [178] : [179] 
    .attribute [173] .code stack 6 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [15] 
L5:     aload_0 
L6:     getfield [16] 
L9:     invokevirtual [19] 
L12:    invokeinterface [34] 0 
L17:    if_icmpeq L87 
L20:    aload_0 
L21:    getfield [15] 
L24:    invokevirtual [20] 
L27:    ldc [2] 
L29:    ldc [3] 
L31:    new [35] 
L34:    dup 
L35:    invokespecial [30] 
L38:    aload_0 
L39:    getfield [16] 
L42:    invokevirtual [21] 
L45:    ldc [5] 
L47:    invokevirtual [22] 
L50:    invokevirtual [23] 
L53:    iload_1 
L54:    i2l 
L55:    invokevirtual [24] 
L58:    pop 
L59:    aload_0 
L60:    getfield [15] 
L63:    aload_0 
L64:    getfield [16] 
L67:    invokevirtual [19] 
L70:    iload_1 
L71:    invokeinterface [36] 0 
L76:    aload_0 
L77:    getfield [17] 
L80:    iload_1 
L81:    invokevirtual [25] 
L84:    goto L102 
L87:    aload_0 
L88:    getfield [15] 
L91:    invokevirtual [20] 
L94:    ldc [2] 
L96:    ldc [6] 
L98:    invokevirtual [26] 
L101:   pop 
L102:   return 
L103:   nop 
L104:   
    .end code 
.end method 

.method public [180] : [181] 
    .attribute [173] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     invokevirtual [20] 
L7:     ldc [2] 
L9:     ldc [7] 
L11:    invokevirtual [26] 
L14:    pop 
L15:    aload_0 
L16:    aload_0 
L17:    getfield [15] 
L20:    invokevirtual [27] 
L23:    sipush 4479 
L26:    invokeinterface [37] 0 
L31:    invokespecial [29] 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [38] 
.const [4] = Class [39] 
.const [5] = String [40] 
.const [6] = String [41] 
.const [7] = String [42] 
.const [8] = Class [43] 
.const [9] = Class [44] 
.const [10] = Class [45] 
.const [11] = Class [46] 
.const [12] = Class [47] 
.const [13] = Class [48] 
.const [14] = Class [49] 
.const [15] = Field [50] [51] 
.const [16] = Field [52] [53] 
.const [17] = Field [54] [55] 
.const [18] = Method [56] [57] 
.const [19] = Method [58] [59] 
.const [20] = Method [60] [61] 
.const [21] = Method [62] [63] 
.const [22] = Method [64] [65] 
.const [23] = Method [66] [67] 
.const [24] = Method [68] [69] 
.const [25] = Method [70] [71] 
.const [26] = Method [72] [73] 
.const [27] = Method [74] [75] 
.const [28] = Method [76] [77] 
.const [29] = Method [78] [79] 
.const [30] = Method [80] [81] 
.const [31] = Field [82] [83] 
.const [32] = Field [84] [85] 
.const [33] = Field [86] [87] 
.const [34] = InterfaceMethod [88] [89] 
.const [35] = Class [90] 
.const [36] = InterfaceMethod [91] [92] 
.const [37] = InterfaceMethod [93] [94] 
.const [38] = Utf8 'AlternativeRouteState#setAlternativeRouteState - change model state from Model = %1 to %2' 
.const [39] = Utf8 java/lang/StringBuffer 
.const [40] = Utf8 '' 
.const [41] = Utf8 'AlternativeRouteState#setAlternativeRouteState - model has already the given state' 
.const [42] = Utf8 'AlternativeRouteState#resetSettings() - set default settings' 
.const [43] = Utf8 de/audi/tghu/navi/app/routeguidance/AlternativeRouteStateManager 
.const [44] = Utf8 java/lang/Object 
.const [45] = Utf8 de/audi/tghu/navi/app/routeguidance/AlternativeRouteStatePersitenceHelper 
.const [46] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [47] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [48] = Utf8 de/audi/atip/log/LogChannel 
.const [49] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [50] = Class [95] 
.const [51] = NameAndType [96] [97] 
.const [52] = Class [98] 
.const [53] = NameAndType [99] [100] 
.const [54] = Class [101] 
.const [55] = NameAndType [102] [103] 
.const [56] = Class [104] 
.const [57] = NameAndType [105] [106] 
.const [58] = Class [107] 
.const [59] = NameAndType [108] [109] 
.const [60] = Class [110] 
.const [61] = NameAndType [111] [112] 
.const [62] = Class [113] 
.const [63] = NameAndType [114] [115] 
.const [64] = Class [116] 
.const [65] = NameAndType [117] [118] 
.const [66] = Class [119] 
.const [67] = NameAndType [120] [121] 
.const [68] = Class [122] 
.const [69] = NameAndType [123] [124] 
.const [70] = Class [125] 
.const [71] = NameAndType [126] [127] 
.const [72] = Class [128] 
.const [73] = NameAndType [129] [130] 
.const [74] = Class [131] 
.const [75] = NameAndType [132] [133] 
.const [76] = Class [134] 
.const [77] = NameAndType [135] [136] 
.const [78] = Class [137] 
.const [79] = NameAndType [138] [139] 
.const [80] = Class [140] 
.const [81] = NameAndType [141] [142] 
.const [82] = Class [143] 
.const [83] = NameAndType [144] [145] 
.const [84] = Class [146] 
.const [85] = NameAndType [147] [148] 
.const [86] = Class [149] 
.const [87] = NameAndType [150] [151] 
.const [88] = Class [152] 
.const [89] = NameAndType [153] [154] 
.const [90] = Utf8 java/lang/StringBuffer 
.const [91] = Class [155] 
.const [92] = NameAndType [156] [157] 
.const [93] = Class [158] 
.const [94] = NameAndType [159] [160] 
.const [95] = Utf8 de/audi/tghu/navi/app/routeguidance/AlternativeRouteStateManager 
.const [96] = Utf8 env 
.const [97] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [98] = Utf8 de/audi/tghu/navi/app/routeguidance/AlternativeRouteStateManager 
.const [99] = Utf8 modelID 
.const [100] = Utf8 I 
.const [101] = Utf8 de/audi/tghu/navi/app/routeguidance/AlternativeRouteStateManager 
.const [102] = Utf8 persitenceHelper 
.const [103] = Utf8 Lde/audi/tghu/navi/app/routeguidance/AlternativeRouteStatePersitenceHelper; 
.const [104] = Utf8 de/audi/tghu/navi/app/routeguidance/AlternativeRouteStatePersitenceHelper 
.const [105] = Utf8 loadAlternativeRouteState 
.const [106] = Utf8 ()I 
.const [107] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [108] = Utf8 getChoiceModel 
.const [109] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [110] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [111] = Utf8 getLogChannel 
.const [112] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [113] = Utf8 java/lang/StringBuffer 
.const [114] = Utf8 append 
.const [115] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [116] = Utf8 java/lang/StringBuffer 
.const [117] = Utf8 append 
.const [118] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [119] = Utf8 java/lang/StringBuffer 
.const [120] = Utf8 toString 
.const [121] = Utf8 ()Ljava/lang/String; 
.const [122] = Utf8 de/audi/atip/log/LogChannel 
.const [123] = Utf8 log 
.const [124] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [125] = Utf8 de/audi/tghu/navi/app/routeguidance/AlternativeRouteStatePersitenceHelper 
.const [126] = Utf8 persistAlternativeRouteState 
.const [127] = Utf8 (I)V 
.const [128] = Utf8 de/audi/atip/log/LogChannel 
.const [129] = Utf8 log 
.const [130] = Utf8 (ILjava/lang/String;)Z 
.const [131] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [132] = Utf8 getFramework 
.const [133] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [134] = Utf8 java/lang/Object 
.const [135] = Utf8 <init> 
.const [136] = Utf8 ()V 
.const [137] = Utf8 de/audi/tghu/navi/app/routeguidance/AlternativeRouteStateManager 
.const [138] = Utf8 setAlternativeRouteState 
.const [139] = Utf8 (I)V 
.const [140] = Utf8 java/lang/StringBuffer 
.const [141] = Utf8 <init> 
.const [142] = Utf8 ()V 
.const [143] = Utf8 de/audi/tghu/navi/app/routeguidance/AlternativeRouteStateManager 
.const [144] = Utf8 env 
.const [145] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [146] = Utf8 de/audi/tghu/navi/app/routeguidance/AlternativeRouteStateManager 
.const [147] = Utf8 modelID 
.const [148] = Utf8 I 
.const [149] = Utf8 de/audi/tghu/navi/app/routeguidance/AlternativeRouteStateManager 
.const [150] = Utf8 persitenceHelper 
.const [151] = Utf8 Lde/audi/tghu/navi/app/routeguidance/AlternativeRouteStatePersitenceHelper; 
.const [152] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [153] = Utf8 getValue 
.const [154] = Utf8 ()I 
.const [155] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [156] = Utf8 setValue 
.const [157] = Utf8 (I)V 
.const [158] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [159] = Utf8 getSysConst 
.const [160] = Utf8 (I)I 
.const [161] = Utf8 de/audi/tghu/navi/app/routeguidance/AlternativeRouteStateManager 
.const [162] = Class [161] 
.const [163] = Utf8 java/lang/Object 
.const [164] = Class [163] 
.const [165] = Utf8 de/audi/tghu/navi/app/routeguidance/IAlternativeRouteStateManager 
.const [166] = Class [165] 
.const [167] = Utf8 env 
.const [168] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [169] = Utf8 modelID 
.const [170] = Utf8 I 
.const [171] = Utf8 persitenceHelper 
.const [172] = Utf8 Lde/audi/tghu/navi/app/routeguidance/AlternativeRouteStatePersitenceHelper; 
.const [173] = Utf8 Code 
.const [174] = Utf8 <init> 
.const [175] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;ILde/audi/tghu/navi/app/routeguidance/AlternativeRouteStatePersitenceHelper;)V 
.const [176] = Utf8 getAlternativeRouteState 
.const [177] = Utf8 ()I 
.const [178] = Utf8 setAlternativeRouteState 
.const [179] = Utf8 (I)V 
.const [180] = Utf8 resetSettings 
.const [181] = Utf8 ()V 
.end class 
