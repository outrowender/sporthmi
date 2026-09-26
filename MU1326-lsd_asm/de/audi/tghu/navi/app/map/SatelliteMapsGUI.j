.version 50 0 
.class public super abstract [227] 
.super [229] 
.implements [231] 
.field private [232] [233] 
.field private static final [234] [235] 
.field private static final [236] [237] 
.field private static final [238] [239] 
.field private static final [240] [241] 
.field private static final [242] [243] 
.field private static final [244] [245] 
.field private static final [246] [247] 
.field private static final [248] [249] 
.field private static final [250] [251] 
.field protected final [252] [253] 
.field protected final [254] [255] 
.field private static final [256] [257] 
.field private static final [258] [259] 

.method public [261] : [262] 
    .attribute [260] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     aload_0 
L5:     sipush 1024 
L8:     putfield [40] 
L11:    aload_0 
L12:    aload_1 
L13:    putfield [41] 
L16:    aload_0 
L17:    aload_1 
L18:    invokevirtual [22] 
L21:    putfield [42] 
L24:    aload_0 
L25:    aload_0 
L26:    invokespecial [34] 
L29:    putfield [40] 
L32:    aload_0 
L33:    invokevirtual [24] 
L36:    aload_0 
L37:    ldc [2] 
L39:    invokevirtual [25] 
L42:    iconst_m1 
L43:    getstatic [3] 
L46:    invokeinterface [43] 0 
L51:    return 
L52:    
    .end code 
.end method 

.method protected abstract [263] : [264] 
    .attribute [260] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private [265] : [266] 
    .attribute [260] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     invokevirtual [26] 
L7:     invokeinterface [44] 0 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method private [267] : [268] 
    .attribute [260] .code stack 3 locals 2 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     invokespecial [35] 
L6:     istore_2 
L7:     iload_2 
L8:     tableswitch 1 
            L40 
            L47 
            L61 
            L54 
            default : L61 

L40:    sipush 800 
L43:    istore_1 
L44:    goto L74 
L47:    sipush 1024 
L50:    istore_1 
L51:    goto L74 
L54:    sipush 1440 
L57:    istore_1 
L58:    goto L74 
L61:    aload_0 
L62:    getfield [23] 
L65:    sipush 10000 
L68:    ldc [4] 
L70:    invokevirtual [27] 
L73:    pop 
L74:    iload_1 
L75:    areturn 
L76:    
    .end code 
.end method 

.method public [269] : [270] 
    .attribute [260] .code stack 2 locals 0 
L0:     iload_2 
L1:     ifne L29 
L4:     aload_0 
L5:     getfield [21] 
L8:     invokevirtual [26] 
L11:    invokestatic [5] 
L14:    ifeq L23 
L17:    aload_0 
L18:    aload_1 
L19:    invokespecial [36] 
L22:    areturn 
L23:    aload_0 
L24:    aload_1 
L25:    invokespecial [37] 
L28:    areturn 
L29:    aload_0 
L30:    aload_1 
L31:    invokespecial [38] 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 

.method private [271] : [272] 
    .attribute [260] .code stack 7 locals 5 
L0:     aload_0 
L1:     getfield [20] 
L4:     sipush 420 
L7:     isub 
L8:     iconst_2 
L9:     idiv 
L10:    istore_2 
L11:    bipush 20 
L13:    istore_3 
L14:    iload_2 
L15:    sipush 420 
L18:    iadd 
L19:    istore 4 
L21:    iload_3 
L22:    sipush 200 
L25:    iadd 
L26:    istore 5 
L28:    new [45] 
L31:    dup 
L32:    iload_2 
L33:    iload 4 
L35:    iload_3 
L36:    iload 5 
L38:    iconst_0 
L39:    invokespecial [39] 
L42:    astore 6 
L44:    aload 6 
L46:    areturn 
L47:    nop 
L48:    
    .end code 
.end method 

.method private [273] : [274] 
    .attribute [260] .code stack 7 locals 6 
L0:     aload_1 
L1:     invokeinterface [46] 0 
L6:     astore_2 
L7:     aload_2 
L8:     invokevirtual [28] 
L11:    aload_2 
L12:    invokevirtual [29] 
L15:    sipush 380 
L18:    isub 
L19:    iconst_2 
L20:    idiv 
L21:    iadd 
L22:    istore_3 
L23:    aload_2 
L24:    invokevirtual [30] 
L27:    bipush 20 
L29:    iadd 
L30:    istore 4 
L32:    iload_3 
L33:    sipush 380 
L36:    iadd 
L37:    istore 5 
L39:    iload 4 
L41:    sipush 200 
L44:    iadd 
L45:    istore 6 
L47:    new [45] 
L50:    dup 
L51:    iload_3 
L52:    iload 5 
L54:    iload 4 
L56:    iload 6 
L58:    iconst_0 
L59:    invokespecial [39] 
L62:    astore 7 
L64:    aload 7 
L66:    areturn 
L67:    nop 
L68:    
    .end code 
.end method 

.method private [275] : [276] 
    .attribute [260] .code stack 7 locals 6 
L0:     aload_1 
L1:     invokeinterface [46] 0 
L6:     astore_2 
L7:     aload_2 
L8:     invokevirtual [28] 
L11:    aload_2 
L12:    invokevirtual [29] 
L15:    sipush 380 
L18:    isub 
L19:    iconst_2 
L20:    idiv 
L21:    iadd 
L22:    istore_3 
L23:    aload_2 
L24:    invokevirtual [30] 
L27:    bipush 20 
L29:    iadd 
L30:    istore 4 
L32:    iload_3 
L33:    sipush 380 
L36:    iadd 
L37:    istore 5 
L39:    iload 4 
L41:    sipush 200 
L44:    iadd 
L45:    istore 6 
L47:    new [45] 
L50:    dup 
L51:    iload_3 
L52:    iload 5 
L54:    iload 4 
L56:    iload 6 
L58:    iconst_0 
L59:    invokespecial [39] 
L62:    astore 7 
L64:    aload 7 
L66:    areturn 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [277] : [278] 
    .attribute [260] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     ldc [7] 
L6:     ldc [8] 
L8:     iload_1 
L9:     invokevirtual [31] 
L12:    pop 
L13:    iload_1 
L14:    ifeq L37 
L17:    aload_0 
L18:    getfield [21] 
L21:    sipush 162 
L24:    invokevirtual [32] 
L27:    bipush 100 
L29:    invokeinterface [47] 0 
L34:    goto L53 
L37:    aload_0 
L38:    getfield [21] 
L41:    sipush 162 
L44:    invokevirtual [32] 
L47:    iconst_0 
L48:    invokeinterface [47] 0 
L53:    return 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public abstract [279] : [280] 
    .attribute [260] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public abstract [281] : [282] 
    .attribute [260] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [283] : [284] 
    .attribute [260] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     invokevirtual [26] 
L7:     invokeinterface [48] 0 
L12:    iload_1 
L13:    invokeinterface [49] 0 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [285] : [286] 
    .attribute [260] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     invokevirtual [26] 
L7:     invokeinterface [48] 0 
L12:    iload_1 
L13:    invokeinterface [50] 0 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1680147968 
.const [3] = Field [51] [52] 
.const [4] = String [53] 
.const [5] = Method [54] [55] 
.const [6] = Class [56] 
.const [7] = Int -2137614336 
.const [8] = String [57] 
.const [9] = Class [58] 
.const [10] = Class [59] 
.const [11] = Class [60] 
.const [12] = Class [61] 
.const [13] = Class [62] 
.const [14] = Class [63] 
.const [15] = Class [64] 
.const [16] = Class [65] 
.const [17] = Class [66] 
.const [18] = Class [67] 
.const [19] = Class [68] 
.const [20] = Field [69] [70] 
.const [21] = Field [71] [72] 
.const [22] = Method [73] [74] 
.const [23] = Field [75] [76] 
.const [24] = Method [77] [78] 
.const [25] = Method [79] [80] 
.const [26] = Method [81] [82] 
.const [27] = Method [83] [84] 
.const [28] = Method [85] [86] 
.const [29] = Method [87] [88] 
.const [30] = Method [89] [90] 
.const [31] = Method [91] [92] 
.const [32] = Method [93] [94] 
.const [33] = Method [95] [96] 
.const [34] = Method [97] [98] 
.const [35] = Method [99] [100] 
.const [36] = Method [101] [102] 
.const [37] = Method [103] [104] 
.const [38] = Method [105] [106] 
.const [39] = Method [107] [108] 
.const [40] = Field [109] [110] 
.const [41] = Field [111] [112] 
.const [42] = Field [113] [114] 
.const [43] = InterfaceMethod [115] [116] 
.const [44] = InterfaceMethod [117] [118] 
.const [45] = Class [119] 
.const [46] = InterfaceMethod [120] [121] 
.const [47] = InterfaceMethod [122] [123] 
.const [48] = InterfaceMethod [124] [125] 
.const [49] = InterfaceMethod [126] [127] 
.const [50] = InterfaceMethod [128] [129] 
.const [51] = Class [130] 
.const [52] = NameAndType [131] [132] 
.const [53] = Utf8 'SatelliteMapsGUI#screen resolution is wrong' 
.const [54] = Class [133] 
.const [55] = NameAndType [134] [135] 
.const [56] = Utf8 org/dsi/ifc/global/NavRectangle 
.const [57] = Utf8 'SatelliteMapsGUI#setSatelliteMapsProviderLogo() show %1' 
.const [58] = Utf8 de/audi/tghu/navi/app/map/SatelliteMapsGUI 
.const [59] = Utf8 java/lang/Object 
.const [60] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [61] = Utf8 de/audi/atip/hmi/modelaccess/ResourceLocatorModelApp 
.const [62] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [63] = Utf8 de/audi/atip/log/LogChannel 
.const [64] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [65] = Utf8 de/audi/tghu/navi/app/map/IVisibleContext 
.const [66] = Utf8 org/dsi/ifc/map/Rect 
.const [67] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [68] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [69] = Class [136] 
.const [70] = NameAndType [137] [138] 
.const [71] = Class [139] 
.const [72] = NameAndType [140] [141] 
.const [73] = Class [142] 
.const [74] = NameAndType [143] [144] 
.const [75] = Class [145] 
.const [76] = NameAndType [146] [147] 
.const [77] = Class [148] 
.const [78] = NameAndType [149] [150] 
.const [79] = Class [151] 
.const [80] = NameAndType [152] [153] 
.const [81] = Class [154] 
.const [82] = NameAndType [155] [156] 
.const [83] = Class [157] 
.const [84] = NameAndType [158] [159] 
.const [85] = Class [160] 
.const [86] = NameAndType [161] [162] 
.const [87] = Class [163] 
.const [88] = NameAndType [164] [165] 
.const [89] = Class [166] 
.const [90] = NameAndType [167] [168] 
.const [91] = Class [169] 
.const [92] = NameAndType [170] [171] 
.const [93] = Class [172] 
.const [94] = NameAndType [173] [174] 
.const [95] = Class [175] 
.const [96] = NameAndType [176] [177] 
.const [97] = Class [178] 
.const [98] = NameAndType [179] [180] 
.const [99] = Class [181] 
.const [100] = NameAndType [182] [183] 
.const [101] = Class [184] 
.const [102] = NameAndType [185] [186] 
.const [103] = Class [187] 
.const [104] = NameAndType [188] [189] 
.const [105] = Class [190] 
.const [106] = NameAndType [191] [192] 
.const [107] = Class [193] 
.const [108] = NameAndType [194] [195] 
.const [109] = Class [196] 
.const [110] = NameAndType [197] [198] 
.const [111] = Class [199] 
.const [112] = NameAndType [200] [201] 
.const [113] = Class [202] 
.const [114] = NameAndType [203] [204] 
.const [115] = Class [205] 
.const [116] = NameAndType [206] [207] 
.const [117] = Class [208] 
.const [118] = NameAndType [209] [210] 
.const [119] = Utf8 org/dsi/ifc/global/NavRectangle 
.const [120] = Class [211] 
.const [121] = NameAndType [212] [213] 
.const [122] = Class [214] 
.const [123] = NameAndType [215] [216] 
.const [124] = Class [217] 
.const [125] = NameAndType [218] [219] 
.const [126] = Class [220] 
.const [127] = NameAndType [221] [222] 
.const [128] = Class [223] 
.const [129] = NameAndType [224] [225] 
.const [130] = Utf8 de/audi/atip/hmi/modelaccess/ResourceLocatorModelApp 
.const [131] = Utf8 UNDEFINED_URI 
.const [132] = Utf8 Ljava/lang/String; 
.const [133] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [134] = Utf8 isClusterMMI 
.const [135] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)Z 
.const [136] = Utf8 de/audi/tghu/navi/app/map/SatelliteMapsGUI 
.const [137] = Utf8 MAIN_SCREEN_WIDTH 
.const [138] = Utf8 I 
.const [139] = Utf8 de/audi/tghu/navi/app/map/SatelliteMapsGUI 
.const [140] = Utf8 env 
.const [141] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [142] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [143] = Utf8 getMapMainLogChannel 
.const [144] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [145] = Utf8 de/audi/tghu/navi/app/map/SatelliteMapsGUI 
.const [146] = Utf8 logger 
.const [147] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [148] = Utf8 de/audi/tghu/navi/app/map/SatelliteMapsGUI 
.const [149] = Utf8 setDynamicProviderIconConcept 
.const [150] = Utf8 ()V 
.const [151] = Utf8 de/audi/tghu/navi/app/map/SatelliteMapsGUI 
.const [152] = Utf8 getSatelliteMapResourceLocator 
.const [153] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ResourceLocatorModelApp; 
.const [154] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [155] = Utf8 getFramework 
.const [156] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [157] = Utf8 de/audi/atip/log/LogChannel 
.const [158] = Utf8 log 
.const [159] = Utf8 (ILjava/lang/String;)Z 
.const [160] = Utf8 org/dsi/ifc/map/Rect 
.const [161] = Utf8 getKordX 
.const [162] = Utf8 ()I 
.const [163] = Utf8 org/dsi/ifc/map/Rect 
.const [164] = Utf8 getDiffX 
.const [165] = Utf8 ()I 
.const [166] = Utf8 org/dsi/ifc/map/Rect 
.const [167] = Utf8 getKordY 
.const [168] = Utf8 ()I 
.const [169] = Utf8 de/audi/atip/log/LogChannel 
.const [170] = Utf8 log 
.const [171] = Utf8 (ILjava/lang/String;Z)Z 
.const [172] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [173] = Utf8 getChoiceModel 
.const [174] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [175] = Utf8 java/lang/Object 
.const [176] = Utf8 <init> 
.const [177] = Utf8 ()V 
.const [178] = Utf8 de/audi/tghu/navi/app/map/SatelliteMapsGUI 
.const [179] = Utf8 retrieveScreenWidth 
.const [180] = Utf8 ()I 
.const [181] = Utf8 de/audi/tghu/navi/app/map/SatelliteMapsGUI 
.const [182] = Utf8 getScreenResolution 
.const [183] = Utf8 ()I 
.const [184] = Utf8 de/audi/tghu/navi/app/map/SatelliteMapsGUI 
.const [185] = Utf8 mmiClusterMapCopyRightLogoPosition 
.const [186] = Utf8 (Lde/audi/tghu/navi/app/map/IVisibleContext;)Lorg/dsi/ifc/global/NavRectangle; 
.const [187] = Utf8 de/audi/tghu/navi/app/map/SatelliteMapsGUI 
.const [188] = Utf8 stdMapCopyRightLogoPosition 
.const [189] = Utf8 (Lde/audi/tghu/navi/app/map/IVisibleContext;)Lorg/dsi/ifc/global/NavRectangle; 
.const [190] = Utf8 de/audi/tghu/navi/app/map/SatelliteMapsGUI 
.const [191] = Utf8 kombiMapCopyRightLogoPosition 
.const [192] = Utf8 (Lde/audi/tghu/navi/app/map/IVisibleContext;)Lorg/dsi/ifc/global/NavRectangle; 
.const [193] = Utf8 org/dsi/ifc/global/NavRectangle 
.const [194] = Utf8 <init> 
.const [195] = Utf8 (IIIIZ)V 
.const [196] = Utf8 de/audi/tghu/navi/app/map/SatelliteMapsGUI 
.const [197] = Utf8 MAIN_SCREEN_WIDTH 
.const [198] = Utf8 I 
.const [199] = Utf8 de/audi/tghu/navi/app/map/SatelliteMapsGUI 
.const [200] = Utf8 env 
.const [201] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [202] = Utf8 de/audi/tghu/navi/app/map/SatelliteMapsGUI 
.const [203] = Utf8 logger 
.const [204] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [205] = Utf8 de/audi/atip/hmi/modelaccess/ResourceLocatorModelApp 
.const [206] = Utf8 setResourceLocator 
.const [207] = Utf8 (ILjava/lang/String;)V 
.const [208] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [209] = Utf8 getScreenRes 
.const [210] = Utf8 ()I 
.const [211] = Utf8 de/audi/tghu/navi/app/map/IVisibleContext 
.const [212] = Utf8 getVisibleArea 
.const [213] = Utf8 ()Lorg/dsi/ifc/map/Rect; 
.const [214] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [215] = Utf8 setValue 
.const [216] = Utf8 (I)V 
.const [217] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [218] = Utf8 getHmiServiceApp 
.const [219] = Utf8 ()Lde/audi/atip/hmi/IHMIServiceApp; 
.const [220] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [221] = Utf8 getResourceLocatorModel 
.const [222] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ResourceLocatorModelApp; 
.const [223] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [224] = Utf8 getChoiceModel 
.const [225] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [226] = Utf8 de/audi/tghu/navi/app/map/SatelliteMapsGUI 
.const [227] = Class [226] 
.const [228] = Utf8 java/lang/Object 
.const [229] = Class [228] 
.const [230] = Utf8 de/audi/tghu/navi/app/map/ISatelliteMapsGUI 
.const [231] = Class [230] 
.const [232] = Utf8 MAIN_SCREEN_WIDTH 
.const [233] = Utf8 I 
.const [234] = Utf8 STD_MAP_OFFSET_Y 
.const [235] = Utf8 I 
.const [236] = Utf8 STD_MAP_LOGO_LENGTH 
.const [237] = Utf8 I 
.const [238] = Utf8 STD_MAP_LOGO_HEIGHT 
.const [239] = Utf8 I 
.const [240] = Utf8 MMI_CLUSTER_MAP_OFFSET_Y 
.const [241] = Utf8 I 
.const [242] = Utf8 MMI_CLUSTER_MAP_LOGO_LENGTH 
.const [243] = Utf8 I 
.const [244] = Utf8 MMI_CLUSTER_MAP_LOGO_HEIGHT 
.const [245] = Utf8 I 
.const [246] = Utf8 KMOBI_MAP_OFFSET_Y 
.const [247] = Utf8 I 
.const [248] = Utf8 KOMBI_MAP_LOGO_LENGTH 
.const [249] = Utf8 I 
.const [250] = Utf8 KOMBI_MAP_LOGO_HEIGHT 
.const [251] = Utf8 I 
.const [252] = Utf8 env 
.const [253] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [254] = Utf8 logger 
.const [255] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [256] = Utf8 SATMAPS_NOT_ACTIVE 
.const [257] = Utf8 I 
.const [258] = Utf8 SATMAPS_ACTIVE 
.const [259] = Utf8 I 
.const [260] = Utf8 Code 
.const [261] = Utf8 <init> 
.const [262] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [263] = Utf8 setDynamicProviderIconConcept 
.const [264] = Utf8 ()V 
.const [265] = Utf8 getScreenResolution 
.const [266] = Utf8 ()I 
.const [267] = Utf8 retrieveScreenWidth 
.const [268] = Utf8 ()I 
.const [269] = Utf8 getCopyRightLogoPosition 
.const [270] = Utf8 (Lde/audi/tghu/navi/app/map/IVisibleContext;I)Lorg/dsi/ifc/global/NavRectangle; 
.const [271] = Utf8 stdMapCopyRightLogoPosition 
.const [272] = Utf8 (Lde/audi/tghu/navi/app/map/IVisibleContext;)Lorg/dsi/ifc/global/NavRectangle; 
.const [273] = Utf8 mmiClusterMapCopyRightLogoPosition 
.const [274] = Utf8 (Lde/audi/tghu/navi/app/map/IVisibleContext;)Lorg/dsi/ifc/global/NavRectangle; 
.const [275] = Utf8 kombiMapCopyRightLogoPosition 
.const [276] = Utf8 (Lde/audi/tghu/navi/app/map/IVisibleContext;)Lorg/dsi/ifc/global/NavRectangle; 
.const [277] = Utf8 setSatelliteMapsProviderLogo 
.const [278] = Utf8 (Z)V 
.const [279] = Utf8 showFunctionCurrentlyNotAvailableHelpTextWithTimeout 
.const [280] = Utf8 ()V 
.const [281] = Utf8 redrawFunctionCurrentlyNotAvailableHelpTextWithTimeout 
.const [282] = Utf8 ()V 
.const [283] = Utf8 getSatelliteMapResourceLocator 
.const [284] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ResourceLocatorModelApp; 
.const [285] = Utf8 getSatelliteMapChoiceModel 
.const [286] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.end class 
