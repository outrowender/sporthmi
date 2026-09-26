.version 50 0 
.class public super [216] 
.super [218] 
.field private [219] [220] 
.field private [221] [222] 
.field private [223] [224] 

.method public [226] : [227] 
    .attribute [225] .code stack 3 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [30] 
L5:     aload_0 
L6:     iconst_3 
L7:     putfield [33] 
L10:    aload_1 
L11:    sipush 176 
L14:    invokevirtual [12] 
L17:    astore_3 
L18:    aload_3 
L19:    ifnull L46 
L22:    aload_3 
L23:    invokeinterface [34] 0 
L28:    iconst_1 
L29:    if_icmple L46 
L32:    aload_0 
L33:    aload_3 
L34:    iconst_1 
L35:    invokeinterface [35] 0 
L40:    putfield [36] 
L43:    goto L51 
L46:    aload_0 
L47:    aconst_null 
L48:    putfield [36] 
L51:    aload_0 
L52:    iload_2 
L53:    putfield [33] 
L56:    aload_0 
L57:    aload_1 
L58:    ldc [2] 
L60:    invokevirtual [14] 
L63:    putfield [37] 
L66:    return 
L67:    nop 
L68:    
    .end code 
.end method 

.method private interface [228] : [229] 
    .attribute [225] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected interface [230] : [231] 
    .attribute [225] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [232] : [233] 
    .attribute [225] .code stack 6 locals 7 
L0:     new [38] 
L3:     dup 
L4:     invokespecial [31] 
L7:     astore 5 
L9:     aload_0 
L10:    invokevirtual [16] 
L13:    istore 6 
L15:    aload_0 
L16:    invokevirtual [17] 
L19:    istore 7 
L21:    iload 4 
L23:    ifeq L33 
L26:    aload_0 
L27:    invokevirtual [18] 
L30:    goto L37 
L33:    aload_0 
L34:    invokevirtual [19] 
L37:    istore 8 
L39:    iload 4 
L41:    ifeq L51 
L44:    aload_0 
L45:    invokevirtual [20] 
L48:    goto L55 
L51:    aload_0 
L52:    invokevirtual [21] 
L55:    istore 9 
L57:    aload_0 
L58:    invokevirtual [22] 
L61:    istore 10 
L63:    aload_0 
L64:    invokevirtual [23] 
L67:    istore 11 
L69:    aload 5 
L71:    iload 8 
L73:    aload_0 
L74:    invokevirtual [24] 
L77:    isub 
L78:    putfield [39] 
L81:    aload 5 
L83:    iload 11 
L85:    aload_0 
L86:    invokevirtual [25] 
L89:    isub 
L90:    putfield [40] 
L93:    aload 5 
L95:    iload 6 
L97:    iload 8 
L99:    isub 
L100:   iload 9 
L102:   isub 
L103:   putfield [41] 
L106:   aload 5 
L108:   iload 7 
L110:   iload 11 
L112:   isub 
L113:   iload 10 
L115:   isub 
L116:   putfield [42] 
L119:   aload_0 
L120:   getfield [26] 
L123:   invokevirtual [27] 
L126:   invokeinterface [43] 0 
L131:   ifeq L153 
L134:   aload 5 
L136:   sipush 408 
L139:   putfield [41] 
L142:   aload 5 
L144:   sipush 448 
L147:   putfield [42] 
L150:   goto L184 
L153:   aload_0 
L154:   getfield [26] 
L157:   invokevirtual [27] 
L160:   invokeinterface [44] 0 
L165:   ifeq L184 
L168:   aload 5 
L170:   sipush 800 
L173:   putfield [41] 
L176:   aload 5 
L178:   sipush 298 
L181:   putfield [42] 
L184:   aload_0 
L185:   invokespecial [32] 
L188:   ldc [4] 
L190:   ldc [5] 
L192:   aload 5 
L194:   iload_1 
L195:   i2l 
L196:   invokevirtual [28] 
L199:   pop 
L200:   aload 5 
L202:   areturn 
L203:   nop 
L204:   
    .end code 
.end method 

.method public [234] : [235] 
    .attribute [225] .code stack 5 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     iload_3 
L4:     iconst_1 
L5:     invokevirtual [29] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [45] 
.const [3] = Class [46] 
.const [4] = Int -2137614336 
.const [5] = String [47] 
.const [6] = Class [48] 
.const [7] = Class [49] 
.const [8] = Class [50] 
.const [9] = Class [51] 
.const [10] = Class [52] 
.const [11] = Class [53] 
.const [12] = Method [54] [55] 
.const [13] = Field [56] [57] 
.const [14] = Method [58] [59] 
.const [15] = Field [60] [61] 
.const [16] = Method [62] [63] 
.const [17] = Method [64] [65] 
.const [18] = Method [66] [67] 
.const [19] = Method [68] [69] 
.const [20] = Method [70] [71] 
.const [21] = Method [72] [73] 
.const [22] = Method [74] [75] 
.const [23] = Method [76] [77] 
.const [24] = Method [78] [79] 
.const [25] = Method [80] [81] 
.const [26] = Field [82] [83] 
.const [27] = Method [84] [85] 
.const [28] = Method [86] [87] 
.const [29] = Method [88] [89] 
.const [30] = Method [90] [91] 
.const [31] = Method [92] [93] 
.const [32] = Method [94] [95] 
.const [33] = Field [96] [97] 
.const [34] = InterfaceMethod [98] [99] 
.const [35] = InterfaceMethod [100] [101] 
.const [36] = Field [102] [103] 
.const [37] = Field [104] [105] 
.const [38] = Class [106] 
.const [39] = Field [107] [108] 
.const [40] = Field [109] [110] 
.const [41] = Field [111] [112] 
.const [42] = Field [113] [114] 
.const [43] = InterfaceMethod [115] [116] 
.const [44] = InterfaceMethod [117] [118] 
.const [45] = Utf8 'App.Map.GUI.Kombi' 
.const [46] = Utf8 org/dsi/ifc/map/Rect 
.const [47] = Utf8 'LayoutProviderG22Kombi#getVisibleArea() - contextId = %2 -> %1' 
.const [48] = Utf8 de/audi/tghu/navi/app/map/gui/layout/LayoutProviderG22Kombi 
.const [49] = Utf8 de/audi/tghu/navi/app/map/gui/layout/AbstractLayoutProvider 
.const [50] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [51] = Utf8 de/audi/atip/hmi/modelaccess/ListModelApp 
.const [52] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [53] = Utf8 de/audi/atip/log/LogChannel 
.const [54] = Class [119] 
.const [55] = NameAndType [120] [121] 
.const [56] = Class [122] 
.const [57] = NameAndType [123] [124] 
.const [58] = Class [125] 
.const [59] = NameAndType [126] [127] 
.const [60] = Class [128] 
.const [61] = NameAndType [129] [130] 
.const [62] = Class [131] 
.const [63] = NameAndType [132] [133] 
.const [64] = Class [134] 
.const [65] = NameAndType [135] [136] 
.const [66] = Class [137] 
.const [67] = NameAndType [138] [139] 
.const [68] = Class [140] 
.const [69] = NameAndType [141] [142] 
.const [70] = Class [143] 
.const [71] = NameAndType [144] [145] 
.const [72] = Class [146] 
.const [73] = NameAndType [147] [148] 
.const [74] = Class [149] 
.const [75] = NameAndType [150] [151] 
.const [76] = Class [152] 
.const [77] = NameAndType [153] [154] 
.const [78] = Class [155] 
.const [79] = NameAndType [156] [157] 
.const [80] = Class [158] 
.const [81] = NameAndType [159] [160] 
.const [82] = Class [161] 
.const [83] = NameAndType [162] [163] 
.const [84] = Class [164] 
.const [85] = NameAndType [165] [166] 
.const [86] = Class [167] 
.const [87] = NameAndType [168] [169] 
.const [88] = Class [170] 
.const [89] = NameAndType [171] [172] 
.const [90] = Class [173] 
.const [91] = NameAndType [174] [175] 
.const [92] = Class [176] 
.const [93] = NameAndType [177] [178] 
.const [94] = Class [179] 
.const [95] = NameAndType [180] [181] 
.const [96] = Class [182] 
.const [97] = NameAndType [183] [184] 
.const [98] = Class [185] 
.const [99] = NameAndType [186] [187] 
.const [100] = Class [188] 
.const [101] = NameAndType [189] [190] 
.const [102] = Class [191] 
.const [103] = NameAndType [192] [193] 
.const [104] = Class [194] 
.const [105] = NameAndType [195] [196] 
.const [106] = Utf8 org/dsi/ifc/map/Rect 
.const [107] = Class [197] 
.const [108] = NameAndType [198] [199] 
.const [109] = Class [200] 
.const [110] = NameAndType [201] [202] 
.const [111] = Class [203] 
.const [112] = NameAndType [204] [205] 
.const [113] = Class [206] 
.const [114] = NameAndType [207] [208] 
.const [115] = Class [209] 
.const [116] = NameAndType [210] [211] 
.const [117] = Class [212] 
.const [118] = NameAndType [213] [214] 
.const [119] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [120] = Utf8 getListModel 
.const [121] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ListModelApp; 
.const [122] = Utf8 de/audi/tghu/navi/app/map/gui/layout/LayoutProviderG22Kombi 
.const [123] = Utf8 mScreenLayout 
.const [124] = Utf8 Lde/audi/atip/hmi/model/BaseListRow; 
.const [125] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [126] = Utf8 getLogChannel 
.const [127] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [128] = Utf8 de/audi/tghu/navi/app/map/gui/layout/LayoutProviderG22Kombi 
.const [129] = Utf8 logger 
.const [130] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [131] = Utf8 de/audi/tghu/navi/app/map/gui/layout/LayoutProviderG22Kombi 
.const [132] = Utf8 getScreenWidth 
.const [133] = Utf8 ()I 
.const [134] = Utf8 de/audi/tghu/navi/app/map/gui/layout/LayoutProviderG22Kombi 
.const [135] = Utf8 getScreenHeight 
.const [136] = Utf8 ()I 
.const [137] = Utf8 de/audi/tghu/navi/app/map/gui/layout/LayoutProviderG22Kombi 
.const [138] = Utf8 getDistanceTubeLeftKb 
.const [139] = Utf8 ()I 
.const [140] = Utf8 de/audi/tghu/navi/app/map/gui/layout/LayoutProviderG22Kombi 
.const [141] = Utf8 getDistanceTubeLeft 
.const [142] = Utf8 ()I 
.const [143] = Utf8 de/audi/tghu/navi/app/map/gui/layout/LayoutProviderG22Kombi 
.const [144] = Utf8 getDistanceTubeRightKb 
.const [145] = Utf8 ()I 
.const [146] = Utf8 de/audi/tghu/navi/app/map/gui/layout/LayoutProviderG22Kombi 
.const [147] = Utf8 getDistanceTubeRight 
.const [148] = Utf8 ()I 
.const [149] = Utf8 de/audi/tghu/navi/app/map/gui/layout/LayoutProviderG22Kombi 
.const [150] = Utf8 getDistanceInfolineBottom 
.const [151] = Utf8 ()I 
.const [152] = Utf8 de/audi/tghu/navi/app/map/gui/layout/LayoutProviderG22Kombi 
.const [153] = Utf8 getDistanceReiterlineTop 
.const [154] = Utf8 ()I 
.const [155] = Utf8 de/audi/tghu/navi/app/map/gui/layout/LayoutProviderG22Kombi 
.const [156] = Utf8 getMapOffsetLeft 
.const [157] = Utf8 ()I 
.const [158] = Utf8 de/audi/tghu/navi/app/map/gui/layout/LayoutProviderG22Kombi 
.const [159] = Utf8 getMapOffsetTop 
.const [160] = Utf8 ()I 
.const [161] = Utf8 de/audi/tghu/navi/app/map/gui/layout/LayoutProviderG22Kombi 
.const [162] = Utf8 env 
.const [163] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [164] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [165] = Utf8 getFramework 
.const [166] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [167] = Utf8 de/audi/atip/log/LogChannel 
.const [168] = Utf8 log 
.const [169] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [170] = Utf8 de/audi/tghu/navi/app/map/gui/layout/LayoutProviderG22Kombi 
.const [171] = Utf8 getVisibleArea 
.const [172] = Utf8 (IZZZ)Lorg/dsi/ifc/map/Rect; 
.const [173] = Utf8 de/audi/tghu/navi/app/map/gui/layout/AbstractLayoutProvider 
.const [174] = Utf8 <init> 
.const [175] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [176] = Utf8 org/dsi/ifc/map/Rect 
.const [177] = Utf8 <init> 
.const [178] = Utf8 ()V 
.const [179] = Utf8 de/audi/tghu/navi/app/map/gui/layout/LayoutProviderG22Kombi 
.const [180] = Utf8 getLogger 
.const [181] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [182] = Utf8 de/audi/tghu/navi/app/map/gui/layout/LayoutProviderG22Kombi 
.const [183] = Utf8 kombiType 
.const [184] = Utf8 I 
.const [185] = Utf8 de/audi/atip/hmi/modelaccess/ListModelApp 
.const [186] = Utf8 getLength 
.const [187] = Utf8 ()I 
.const [188] = Utf8 de/audi/atip/hmi/modelaccess/ListModelApp 
.const [189] = Utf8 getRow 
.const [190] = Utf8 (I)Lde/audi/atip/hmi/model/BaseListRow; 
.const [191] = Utf8 de/audi/tghu/navi/app/map/gui/layout/LayoutProviderG22Kombi 
.const [192] = Utf8 mScreenLayout 
.const [193] = Utf8 Lde/audi/atip/hmi/model/BaseListRow; 
.const [194] = Utf8 de/audi/tghu/navi/app/map/gui/layout/LayoutProviderG22Kombi 
.const [195] = Utf8 logger 
.const [196] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [197] = Utf8 org/dsi/ifc/map/Rect 
.const [198] = Utf8 kordX 
.const [199] = Utf8 I 
.const [200] = Utf8 org/dsi/ifc/map/Rect 
.const [201] = Utf8 kordY 
.const [202] = Utf8 I 
.const [203] = Utf8 org/dsi/ifc/map/Rect 
.const [204] = Utf8 diffX 
.const [205] = Utf8 I 
.const [206] = Utf8 org/dsi/ifc/map/Rect 
.const [207] = Utf8 diffY 
.const [208] = Utf8 I 
.const [209] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [210] = Utf8 isPorscheHigh 
.const [211] = Utf8 ()Z 
.const [212] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [213] = Utf8 isBentley 
.const [214] = Utf8 ()Z 
.const [215] = Utf8 de/audi/tghu/navi/app/map/gui/layout/LayoutProviderG22Kombi 
.const [216] = Class [215] 
.const [217] = Utf8 de/audi/tghu/navi/app/map/gui/layout/AbstractLayoutProvider 
.const [218] = Class [217] 
.const [219] = Utf8 logger 
.const [220] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [221] = Utf8 mScreenLayout 
.const [222] = Utf8 Lde/audi/atip/hmi/model/BaseListRow; 
.const [223] = Utf8 kombiType 
.const [224] = Utf8 I 
.const [225] = Utf8 Code 
.const [226] = Utf8 <init> 
.const [227] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;I)V 
.const [228] = Utf8 getLogger 
.const [229] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [230] = Utf8 getListRow 
.const [231] = Utf8 ()Lde/audi/atip/hmi/model/BaseListRow; 
.const [232] = Utf8 getVisibleArea 
.const [233] = Utf8 (IZZZ)Lorg/dsi/ifc/map/Rect; 
.const [234] = Utf8 getVisibleArea 
.const [235] = Utf8 (IZZ)Lorg/dsi/ifc/map/Rect; 
.end class 
