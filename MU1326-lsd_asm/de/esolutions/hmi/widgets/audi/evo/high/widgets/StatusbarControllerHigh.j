.version 50 0 
.class public super [247] 
.super [249] 
.implements [251] 
.implements [253] 
.field private [254] [255] 
.field private [256] [257] 
.field private [258] [259] 
.field private [260] [261] 

.method public [263] : [264] 
    .attribute [262] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [39] 
L4:     aload_0 
L5:     sipush 450 
L8:     putfield [44] 
L11:    aload_0 
L12:    fconst_2 
L13:    putfield [45] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [265] : [266] 
    .attribute [262] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [40] 
L4:     aload_0 
L5:     invokestatic [2] 
L8:     ifne L15 
L11:    iconst_1 
L12:    goto L16 
L15:    iconst_0 
L16:    putfield [46] 
L19:    aload_0 
L20:    invokespecial [41] 
L23:    aload_0 
L24:    getfield [21] 
L27:    invokevirtual [22] 
L30:    aload_0 
L31:    invokevirtual [23] 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [267] : [268] 
    .attribute [262] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [24] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [269] : [270] 
    .attribute [262] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [271] : [272] 
    .attribute [262] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ifnull L47 
L7:     aload_0 
L8:     getfield [21] 
L11:    invokevirtual [22] 
L14:    ifnull L47 
L17:    aload_0 
L18:    getfield [21] 
L21:    invokevirtual [22] 
L24:    invokevirtual [25] 
L27:    ifnull L47 
L30:    aload_0 
L31:    getfield [21] 
L34:    invokevirtual [22] 
L37:    invokevirtual [25] 
L40:    checkcast [3] 
L43:    invokevirtual [26] 
L46:    areturn 
L47:    iconst_0 
L48:    areturn 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [273] : [274] 
    .attribute [262] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     ifne L9 
L7:     iconst_1 
L8:     areturn 
L9:     aload_0 
L10:    iload_1 
L11:    putfield [44] 
L14:    iconst_1 
L15:    areturn 
L16:    
    .end code 
.end method 

.method private [275] : [276] 
    .attribute [262] .code stack 4 locals 1 
L0:     getstatic [4] 
L3:     getstatic [5] 
L6:     invokestatic [6] 
L9:     istore_1 
L10:    aload_0 
L11:    aload_0 
L12:    getfield [27] 
L15:    iconst_2 
L16:    iload_1 
L17:    imul 
L18:    isub 
L19:    putfield [47] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [277] : [278] 
    .attribute [262] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [29] 
L4:     aload_0 
L5:     getfield [30] 
L8:     invokestatic [6] 
L11:    istore_1 
L12:    aload_0 
L13:    aload_0 
L14:    getfield [27] 
L17:    iconst_2 
L18:    iload_1 
L19:    imul 
L20:    isub 
L21:    putfield [47] 
L24:    aload_0 
L25:    getfield [28] 
L28:    areturn 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public interface [279] : [280] 
    .attribute [262] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [281] : [282] 
    .attribute [262] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     ifeq L17 
L7:     aload_0 
L8:     fload_1 
L9:     putfield [45] 
L12:    aload_0 
L13:    iconst_1 
L14:    invokevirtual [31] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public interface [283] : [284] 
    .attribute [262] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public enum [285] : [286] 
    .attribute [262] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [287] : [288] 
    .attribute [262] .code stack 5 locals 2 
L0:     new [48] 
L3:     dup 
L4:     invokespecial [42] 
L7:     astore_1 
L8:     new [49] 
L11:    dup 
L12:    aload_1 
L13:    invokespecial [43] 
L16:    astore_2 
L17:    aload_1 
L18:    aload_2 
L19:    invokevirtual [33] 
L22:    aload_1 
L23:    aload_0 
L24:    invokevirtual [34] 
L27:    aload_0 
L28:    invokevirtual [35] 
L31:    getstatic [9] 
L34:    iadd 
L35:    aload_0 
L36:    invokevirtual [36] 
L39:    getstatic [10] 
L42:    isub 
L43:    bipush 36 
L45:    invokevirtual [37] 
L48:    aload_1 
L49:    iconst_1 
L50:    invokevirtual [38] 
L53:    aload_1 
L54:    areturn 
L55:    nop 
L56:    
    .end code 
.end method 

.method protected [289] : [290] 
    .attribute [262] .code stack 5 locals 2 
L0:     new [48] 
L3:     dup 
L4:     invokespecial [42] 
L7:     astore_1 
L8:     new [49] 
L11:    dup 
L12:    aload_1 
L13:    invokespecial [43] 
L16:    astore_2 
L17:    aload_1 
L18:    aload_2 
L19:    invokevirtual [33] 
L22:    aload_1 
L23:    aload_0 
L24:    invokevirtual [34] 
L27:    getstatic [10] 
L30:    iadd 
L31:    aload_0 
L32:    invokevirtual [35] 
L35:    getstatic [9] 
L38:    iadd 
L39:    aload_0 
L40:    invokevirtual [36] 
L43:    getstatic [11] 
L46:    invokevirtual [37] 
L49:    aload_1 
L50:    iconst_1 
L51:    invokevirtual [38] 
L54:    aload_1 
L55:    areturn 
L56:    
    .end code 
.end method 

.method protected [291] : [292] 
    .attribute [262] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [50] [51] 
.const [3] = Class [52] 
.const [4] = Field [53] [54] 
.const [5] = Field [55] [56] 
.const [6] = Method [57] [58] 
.const [7] = Class [59] 
.const [8] = Class [60] 
.const [9] = Field [61] [62] 
.const [10] = Field [63] [64] 
.const [11] = Field [65] [66] 
.const [12] = Class [67] 
.const [13] = Class [68] 
.const [14] = Class [69] 
.const [15] = Class [70] 
.const [16] = Class [71] 
.const [17] = Class [72] 
.const [18] = Field [73] [74] 
.const [19] = Field [75] [76] 
.const [20] = Field [77] [78] 
.const [21] = Field [79] [80] 
.const [22] = Method [81] [82] 
.const [23] = Method [83] [84] 
.const [24] = Method [85] [86] 
.const [25] = Method [87] [88] 
.const [26] = Method [89] [90] 
.const [27] = Field [91] [92] 
.const [28] = Field [93] [94] 
.const [29] = Field [95] [96] 
.const [30] = Field [97] [98] 
.const [31] = Method [99] [100] 
.const [32] = Field [101] [102] 
.const [33] = Method [103] [104] 
.const [34] = Method [105] [106] 
.const [35] = Method [107] [108] 
.const [36] = Method [109] [110] 
.const [37] = Method [111] [112] 
.const [38] = Method [113] [114] 
.const [39] = Method [115] [116] 
.const [40] = Method [117] [118] 
.const [41] = Method [119] [120] 
.const [42] = Method [121] [122] 
.const [43] = Method [123] [124] 
.const [44] = Field [125] [126] 
.const [45] = Field [127] [128] 
.const [46] = Field [129] [130] 
.const [47] = Field [131] [132] 
.const [48] = Class [133] 
.const [49] = Class [134] 
.const [50] = Class [135] 
.const [51] = NameAndType [136] [137] 
.const [52] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/EntertainmentDrawerOpenCloseController 
.const [53] = Class [138] 
.const [54] = NameAndType [139] [140] 
.const [55] = Class [141] 
.const [56] = NameAndType [142] [143] 
.const [57] = Class [144] 
.const [58] = NameAndType [145] [146] 
.const [59] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController 
.const [60] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/CompositeRendererHigh 
.const [61] = Class [147] 
.const [62] = NameAndType [148] [149] 
.const [63] = Class [150] 
.const [64] = NameAndType [151] [152] 
.const [65] = Class [153] 
.const [66] = NameAndType [154] [155] 
.const [67] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [68] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractStatusBarController 
.const [69] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [70] = Utf8 de/esolutions/hmi/widgets/audi/base/HMITerminalImpl 
.const [71] = Utf8 de/esolutions/hmi/widgets/audi/base/WidgetRegistry 
.const [72] = Utf8 java/lang/Math 
.const [73] = Class [156] 
.const [74] = NameAndType [157] [158] 
.const [75] = Class [159] 
.const [76] = NameAndType [160] [161] 
.const [77] = Class [162] 
.const [78] = NameAndType [163] [164] 
.const [79] = Class [165] 
.const [80] = NameAndType [166] [167] 
.const [81] = Class [168] 
.const [82] = NameAndType [169] [170] 
.const [83] = Class [171] 
.const [84] = NameAndType [172] [173] 
.const [85] = Class [174] 
.const [86] = NameAndType [175] [176] 
.const [87] = Class [177] 
.const [88] = NameAndType [178] [179] 
.const [89] = Class [180] 
.const [90] = NameAndType [181] [182] 
.const [91] = Class [183] 
.const [92] = NameAndType [184] [185] 
.const [93] = Class [186] 
.const [94] = NameAndType [187] [188] 
.const [95] = Class [189] 
.const [96] = NameAndType [190] [191] 
.const [97] = Class [192] 
.const [98] = NameAndType [193] [194] 
.const [99] = Class [195] 
.const [100] = NameAndType [196] [197] 
.const [101] = Class [198] 
.const [102] = NameAndType [199] [200] 
.const [103] = Class [201] 
.const [104] = NameAndType [202] [203] 
.const [105] = Class [204] 
.const [106] = NameAndType [205] [206] 
.const [107] = Class [207] 
.const [108] = NameAndType [208] [209] 
.const [109] = Class [210] 
.const [110] = NameAndType [211] [212] 
.const [111] = Class [213] 
.const [112] = NameAndType [214] [215] 
.const [113] = Class [216] 
.const [114] = NameAndType [217] [218] 
.const [115] = Class [219] 
.const [116] = NameAndType [220] [221] 
.const [117] = Class [222] 
.const [118] = NameAndType [223] [224] 
.const [119] = Class [225] 
.const [120] = NameAndType [226] [227] 
.const [121] = Class [228] 
.const [122] = NameAndType [229] [230] 
.const [123] = Class [231] 
.const [124] = NameAndType [232] [233] 
.const [125] = Class [234] 
.const [126] = NameAndType [235] [236] 
.const [127] = Class [237] 
.const [128] = NameAndType [238] [239] 
.const [129] = Class [240] 
.const [130] = NameAndType [241] [242] 
.const [131] = Class [243] 
.const [132] = NameAndType [244] [245] 
.const [133] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController 
.const [134] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/CompositeRendererHigh 
.const [135] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [136] = Utf8 isScreenResolution400 
.const [137] = Utf8 ()Z 
.const [138] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [139] = Utf8 leftGroupMinWidth 
.const [140] = Utf8 I 
.const [141] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [142] = Utf8 rightGroupMinWidth 
.const [143] = Utf8 I 
.const [144] = Utf8 java/lang/Math 
.const [145] = Utf8 max 
.const [146] = Utf8 (II)I 
.const [147] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [148] = Utf8 yOffsetIcon 
.const [149] = Utf8 I 
.const [150] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [151] = Utf8 gapScreenBorder 
.const [152] = Utf8 I 
.const [153] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [154] = Utf8 containerHeight 
.const [155] = Utf8 I 
.const [156] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [157] = Utf8 currentGapWidth 
.const [158] = Utf8 I 
.const [159] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [160] = Utf8 gapHeight 
.const [161] = Utf8 F 
.const [162] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [163] = Utf8 entertainmentDrawerAvailable 
.const [164] = Utf8 Z 
.const [165] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [166] = Utf8 terminal 
.const [167] = Utf8 Lde/esolutions/hmi/widgets/audi/base/HMITerminalImpl; 
.const [168] = Utf8 de/esolutions/hmi/widgets/audi/base/HMITerminalImpl 
.const [169] = Utf8 getWidgetRegistry 
.const [170] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/WidgetRegistry; 
.const [171] = Utf8 de/esolutions/hmi/widgets/audi/base/WidgetRegistry 
.const [172] = Utf8 setStatusbarGapEventHandler 
.const [173] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/IStatusbarGapEventHandler;)V 
.const [174] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [175] = Utf8 updateContent 
.const [176] = Utf8 ()V 
.const [177] = Utf8 de/esolutions/hmi/widgets/audi/base/WidgetRegistry 
.const [178] = Utf8 getEntertainmentDrawerGapEventHandler 
.const [179] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/IEntertainmentDrawerGapEventHandler; 
.const [180] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/EntertainmentDrawerOpenCloseController 
.const [181] = Utf8 getMinWidth 
.const [182] = Utf8 ()I 
.const [183] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [184] = Utf8 width 
.const [185] = Utf8 I 
.const [186] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [187] = Utf8 maxGapWidth 
.const [188] = Utf8 I 
.const [189] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [190] = Utf8 neededLeftGroupSpace 
.const [191] = Utf8 I 
.const [192] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [193] = Utf8 neededRightGroupSpace 
.const [194] = Utf8 I 
.const [195] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [196] = Utf8 setCompositesDirty 
.const [197] = Utf8 (Z)V 
.const [198] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [199] = Utf8 scaleFactor 
.const [200] = Utf8 F 
.const [201] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController 
.const [202] = Utf8 setRenderer 
.const [203] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/CompositeRenderer;)V 
.const [204] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [205] = Utf8 getX 
.const [206] = Utf8 ()I 
.const [207] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [208] = Utf8 getY 
.const [209] = Utf8 ()I 
.const [210] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [211] = Utf8 getWidth 
.const [212] = Utf8 ()I 
.const [213] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController 
.const [214] = Utf8 setBounds 
.const [215] = Utf8 (IIII)V 
.const [216] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController 
.const [217] = Utf8 setHasDynamicLayout 
.const [218] = Utf8 (Z)V 
.const [219] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractStatusBarController 
.const [220] = Utf8 <init> 
.const [221] = Utf8 ()V 
.const [222] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractStatusBarController 
.const [223] = Utf8 initializeWidget 
.const [224] = Utf8 ()V 
.const [225] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [226] = Utf8 calculateMaxGapWidth 
.const [227] = Utf8 ()V 
.const [228] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController 
.const [229] = Utf8 <init> 
.const [230] = Utf8 ()V 
.const [231] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/CompositeRendererHigh 
.const [232] = Utf8 <init> 
.const [233] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController;)V 
.const [234] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [235] = Utf8 currentGapWidth 
.const [236] = Utf8 I 
.const [237] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [238] = Utf8 gapHeight 
.const [239] = Utf8 F 
.const [240] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [241] = Utf8 entertainmentDrawerAvailable 
.const [242] = Utf8 Z 
.const [243] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [244] = Utf8 maxGapWidth 
.const [245] = Utf8 I 
.const [246] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/StatusbarControllerHigh 
.const [247] = Class [246] 
.const [248] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractStatusBarController 
.const [249] = Class [248] 
.const [250] = Utf8 de/esolutions/hmi/widgets/audi/base/IStatusbarGapEventHandler 
.const [251] = Class [250] 
.const [252] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/LayoutContainer 
.const [253] = Class [252] 
.const [254] = Utf8 currentGapWidth 
.const [255] = Utf8 I 
.const [256] = Utf8 maxGapWidth 
.const [257] = Utf8 I 
.const [258] = Utf8 gapHeight 
.const [259] = Utf8 F 
.const [260] = Utf8 entertainmentDrawerAvailable 
.const [261] = Utf8 Z 
.const [262] = Utf8 Code 
.const [263] = Utf8 <init> 
.const [264] = Utf8 ()V 
.const [265] = Utf8 initializeWidget 
.const [266] = Utf8 ()V 
.const [267] = Utf8 invalidateLayout 
.const [268] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/AbstractWidget;)V 
.const [269] = Utf8 getCurrentGapWidth 
.const [270] = Utf8 ()I 
.const [271] = Utf8 getMinGapWidth 
.const [272] = Utf8 ()I 
.const [273] = Utf8 setGapWidth 
.const [274] = Utf8 (IZ)Z 
.const [275] = Utf8 calculateMaxGapWidth 
.const [276] = Utf8 ()V 
.const [277] = Utf8 getMaxGapWidth 
.const [278] = Utf8 ()I 
.const [279] = Utf8 getGapHeight 
.const [280] = Utf8 ()F 
.const [281] = Utf8 setGapHeight 
.const [282] = Utf8 (F)V 
.const [283] = Utf8 getScaleFactor 
.const [284] = Utf8 ()F 
.const [285] = Utf8 setScaleFactor 
.const [286] = Utf8 (F)V 
.const [287] = Utf8 getRightGroupContainer 
.const [288] = Utf8 ()Lde/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController; 
.const [289] = Utf8 getLeftGroupContainer 
.const [290] = Utf8 ()Lde/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController; 
.const [291] = Utf8 isViewSizeChanging 
.const [292] = Utf8 ()Z 
.end class 
