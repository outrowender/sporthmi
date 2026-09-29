.version 50 0 
.class public super [219] 
.super [221] 
.implements [223] 
.field protected [224] [225] 
.field protected volatile [226] [227] 

.method public [229] : [230] 
    .attribute [228] .code stack 6 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     iload_3 
L4:     aload 4 
L6:     invokespecial [29] 
L9:     aload 5 
L11:    invokestatic [2] 
L14:    istore 6 
L16:    aload_0 
L17:    iconst_5 
L18:    new [40] 
L21:    dup 
L22:    iload 6 
L24:    iconst_0 
L25:    newarray int 
L27:    invokespecial [30] 
L30:    invokevirtual [14] 
L33:    pop 
L34:    aload_0 
L35:    iconst_0 
L36:    iconst_0 
L37:    invokevirtual [15] 
L40:    pop 
L41:    aload_0 
L42:    iconst_4 
L43:    iconst_1 
L44:    invokevirtual [15] 
L47:    pop 
L48:    aload 4 
L50:    ifnull L65 
L53:    aload_0 
L54:    aload 4 
L56:    invokespecial [31] 
L59:    aload_0 
L60:    aload 4 
L62:    invokespecial [32] 
L65:    return 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method protected annotation [231] : [232] 
    .attribute [228] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [33] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [233] : [234] 
    .attribute [228] .code stack 3 locals 0 
L0:     new [41] 
L3:     dup 
L4:     aload_0 
L5:     invokespecial [34] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public interface [235] : [236] 
    .attribute [228] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [237] : [238] 
    .attribute [228] .code stack 2 locals 1 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [42] 
L5:     aload_0 
L6:     invokevirtual [17] 
L9:     aload_0 
L10:    getfield [18] 
L13:    ifne L31 
L16:    aload_0 
L17:    invokevirtual [19] 
L20:    istore_2 
L21:    aload_0 
L22:    iconst_1 
L23:    putfield [43] 
L26:    aload_0 
L27:    iload_2 
L28:    invokevirtual [20] 
L31:    return 
L32:    
    .end code 
.end method 

.method public synchronized [239] : [240] 
    .attribute [228] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [35] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private synchronized [241] : [242] 
    .attribute [228] .code stack 2 locals 1 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [42] 
L5:     aload_0 
L6:     invokevirtual [17] 
L9:     aload_0 
L10:    getfield [18] 
L13:    ifeq L31 
L16:    aload_0 
L17:    invokevirtual [19] 
L20:    istore_2 
L21:    aload_0 
L22:    iconst_0 
L23:    putfield [43] 
L26:    aload_0 
L27:    iload_2 
L28:    invokespecial [36] 
L31:    return 
L32:    
    .end code 
.end method 

.method public [243] : [244] 
    .attribute [228] .code stack 4 locals 0 
L0:     aload_0 
L1:     bipush 7 
L3:     aload_0 
L4:     getfield [16] 
L7:     iconst_1 
L8:     invokestatic [5] 
L11:    invokevirtual [21] 
L14:    pop 
L15:    return 
L16:    
    .end code 
.end method 

.method public [245] : [246] 
    .attribute [228] .code stack 2 locals 1 
L0:     aload_0 
L1:     bipush 6 
L3:     invokevirtual [22] 
L6:     istore_1 
L7:     aload_0 
L8:     getfield [18] 
L11:    ifeq L17 
L14:    iinc 1 -8 
L17:    iload_1 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [247] : [248] 
    .attribute [228] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [36] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [249] : [250] 
    .attribute [228] .code stack 4 locals 0 
L0:     aload_0 
L1:     bipush 6 
L3:     aload_0 
L4:     getfield [18] 
L7:     ifeq L17 
L10:    iload_1 
L11:    bipush 8 
L13:    iadd 
L14:    goto L18 
L17:    iload_1 
L18:    invokevirtual [15] 
L21:    pop 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public final interface [251] : [252] 
    .attribute [228] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [253] : [254] 
    .attribute [228] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [37] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [255] : [256] 
    .attribute [228] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [23] 
L4:     ifnonnull L9 
L7:     iconst_0 
L8:     areturn 
L9:     aload_0 
L10:    invokevirtual [23] 
L13:    invokevirtual [24] 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [257] : [258] 
    .attribute [228] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [38] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [259] : [260] 
    .attribute [228] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [23] 
L4:     ifnonnull L9 
L7:     iconst_0 
L8:     areturn 
L9:     aload_0 
L10:    invokevirtual [23] 
L13:    invokevirtual [25] 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public synchronized [261] : [262] 
    .attribute [228] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [32] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private synchronized [263] : [264] 
    .attribute [228] .code stack 3 locals 2 
L0:     aload_1 
L1:     aload_0 
L2:     invokespecial [38] 
L5:     aload_0 
L6:     invokespecial [37] 
L9:     invokestatic [6] 
L12:    istore_2 
L13:    iload_2 
L14:    aload_1 
L15:    getfield [26] 
L18:    invokestatic [7] 
L21:    istore_3 
L22:    aload_0 
L23:    iload_3 
L24:    invokespecial [36] 
L27:    return 
L28:    
    .end code 
.end method 

.method public synchronized [265] : [266] 
    .attribute [228] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [31] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private synchronized [267] : [268] 
    .attribute [228] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokespecial [39] 
L4:     ifne L32 
L7:     aload_1 
L8:     invokevirtual [27] 
L11:    aload_1 
L12:    invokevirtual [28] 
L15:    aload_0 
L16:    invokespecial [38] 
L19:    aload_0 
L20:    invokespecial [37] 
L23:    invokestatic [8] 
L26:    istore_2 
L27:    aload_0 
L28:    iload_2 
L29:    invokespecial [35] 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [44] [45] 
.const [3] = Class [46] 
.const [4] = Class [47] 
.const [5] = Method [48] [49] 
.const [6] = Method [50] [51] 
.const [7] = Method [52] [53] 
.const [8] = Method [54] [55] 
.const [9] = Class [56] 
.const [10] = Class [57] 
.const [11] = Class [58] 
.const [12] = Class [59] 
.const [13] = Class [60] 
.const [14] = Method [61] [62] 
.const [15] = Method [63] [64] 
.const [16] = Field [65] [66] 
.const [17] = Method [67] [68] 
.const [18] = Field [69] [70] 
.const [19] = Method [71] [72] 
.const [20] = Method [73] [74] 
.const [21] = Method [75] [76] 
.const [22] = Method [77] [78] 
.const [23] = Method [79] [80] 
.const [24] = Method [81] [82] 
.const [25] = Method [83] [84] 
.const [26] = Field [85] [86] 
.const [27] = Method [87] [88] 
.const [28] = Method [89] [90] 
.const [29] = Method [91] [92] 
.const [30] = Method [93] [94] 
.const [31] = Method [95] [96] 
.const [32] = Method [97] [98] 
.const [33] = Method [99] [100] 
.const [34] = Method [101] [102] 
.const [35] = Method [103] [104] 
.const [36] = Method [105] [106] 
.const [37] = Method [107] [108] 
.const [38] = Method [109] [110] 
.const [39] = Method [111] [112] 
.const [40] = Class [113] 
.const [41] = Class [114] 
.const [42] = Field [115] [116] 
.const [43] = Field [117] [118] 
.const [44] = Class [119] 
.const [45] = NameAndType [120] [121] 
.const [46] = Utf8 de/audi/atip/hmi/model/PropertyListCell 
.const [47] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [48] = Class [122] 
.const [49] = NameAndType [123] [124] 
.const [50] = Class [125] 
.const [51] = NameAndType [126] [127] 
.const [52] = Class [128] 
.const [53] = NameAndType [129] [130] 
.const [54] = Class [131] 
.const [55] = NameAndType [132] [133] 
.const [56] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesListRow 
.const [57] = Utf8 de/audi/app/navi/evo/addressinput/poi/PoiScreensEvo 
.const [58] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [59] = Utf8 org/dsi/ifc/navigation/LIValueListElement 
.const [60] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [61] = Class [134] 
.const [62] = NameAndType [135] [136] 
.const [63] = Class [137] 
.const [64] = NameAndType [138] [139] 
.const [65] = Class [140] 
.const [66] = NameAndType [141] [142] 
.const [67] = Class [143] 
.const [68] = NameAndType [144] [145] 
.const [69] = Class [146] 
.const [70] = NameAndType [147] [148] 
.const [71] = Class [149] 
.const [72] = NameAndType [150] [151] 
.const [73] = Class [152] 
.const [74] = NameAndType [153] [154] 
.const [75] = Class [155] 
.const [76] = NameAndType [156] [157] 
.const [77] = Class [158] 
.const [78] = NameAndType [159] [160] 
.const [79] = Class [161] 
.const [80] = NameAndType [162] [163] 
.const [81] = Class [164] 
.const [82] = NameAndType [165] [166] 
.const [83] = Class [167] 
.const [84] = NameAndType [168] [169] 
.const [85] = Class [170] 
.const [86] = NameAndType [171] [172] 
.const [87] = Class [173] 
.const [88] = NameAndType [174] [175] 
.const [89] = Class [176] 
.const [90] = NameAndType [177] [178] 
.const [91] = Class [179] 
.const [92] = NameAndType [180] [181] 
.const [93] = Class [182] 
.const [94] = NameAndType [183] [184] 
.const [95] = Class [185] 
.const [96] = NameAndType [186] [187] 
.const [97] = Class [188] 
.const [98] = NameAndType [189] [190] 
.const [99] = Class [191] 
.const [100] = NameAndType [192] [193] 
.const [101] = Class [194] 
.const [102] = NameAndType [195] [196] 
.const [103] = Class [197] 
.const [104] = NameAndType [198] [199] 
.const [105] = Class [200] 
.const [106] = NameAndType [201] [202] 
.const [107] = Class [203] 
.const [108] = NameAndType [204] [205] 
.const [109] = Class [206] 
.const [110] = NameAndType [207] [208] 
.const [111] = Class [209] 
.const [112] = NameAndType [210] [211] 
.const [113] = Utf8 de/audi/atip/hmi/model/PropertyListCell 
.const [114] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [115] = Class [212] 
.const [116] = NameAndType [213] [214] 
.const [117] = Class [215] 
.const [118] = NameAndType [216] [217] 
.const [119] = Utf8 de/audi/app/navi/evo/addressinput/poi/PoiScreensEvo 
.const [120] = Utf8 getCategoryPropertyForActivePoiContext 
.const [121] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)I 
.const [122] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [123] = Utf8 formatDistance 
.const [124] = Utf8 (II)Ljava/lang/String; 
.const [125] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [126] = Utf8 computeAbsoluteDirection 
.const [127] = Utf8 (Lorg/dsi/ifc/navigation/PosPosition;II)I 
.const [128] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [129] = Utf8 convertRotatingDirection 
.const [130] = Utf8 (II)I 
.const [131] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [132] = Utf8 computeAirDistance 
.const [133] = Utf8 (IIII)I 
.const [134] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [135] = Utf8 setPropertyCell 
.const [136] = Utf8 (ILde/audi/atip/hmi/model/PropertyListCell;)Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [137] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [138] = Utf8 setInteger 
.const [139] = Utf8 (II)Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [140] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [141] = Utf8 distance 
.const [142] = Utf8 I 
.const [143] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [144] = Utf8 reformatDistance 
.const [145] = Utf8 ()V 
.const [146] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [147] = Utf8 flagRRD 
.const [148] = Utf8 Z 
.const [149] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [150] = Utf8 getDirection 
.const [151] = Utf8 ()I 
.const [152] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [153] = Utf8 setDirection 
.const [154] = Utf8 (I)V 
.const [155] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [156] = Utf8 setText 
.const [157] = Utf8 (ILjava/lang/String;)Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [158] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [159] = Utf8 getInteger 
.const [160] = Utf8 (I)I 
.const [161] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [162] = Utf8 getElement 
.const [163] = Utf8 ()Lorg/dsi/ifc/navigation/LIValueListElement; 
.const [164] = Utf8 org/dsi/ifc/navigation/LIValueListElement 
.const [165] = Utf8 getLatitude 
.const [166] = Utf8 ()I 
.const [167] = Utf8 org/dsi/ifc/navigation/LIValueListElement 
.const [168] = Utf8 getLongitude 
.const [169] = Utf8 ()I 
.const [170] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [171] = Utf8 directionAngle 
.const [172] = Utf8 I 
.const [173] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [174] = Utf8 getLongitude 
.const [175] = Utf8 ()I 
.const [176] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [177] = Utf8 getLatitude 
.const [178] = Utf8 ()I 
.const [179] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesListRow 
.const [180] = Utf8 <init> 
.const [181] = Utf8 (Lde/audi/tghu/navi/app/IconHandler;Lorg/dsi/ifc/navigation/LIValueListElement;ILorg/dsi/ifc/navigation/PosPosition;)V 
.const [182] = Utf8 de/audi/atip/hmi/model/PropertyListCell 
.const [183] = Utf8 <init> 
.const [184] = Utf8 (I[I)V 
.const [185] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [186] = Utf8 doUpdateAirDistance 
.const [187] = Utf8 (Lorg/dsi/ifc/navigation/PosPosition;)V 
.const [188] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [189] = Utf8 doUpdateDirection 
.const [190] = Utf8 (Lorg/dsi/ifc/navigation/PosPosition;)V 
.const [191] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesListRow 
.const [192] = Utf8 <init> 
.const [193] = Utf8 (Lde/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesListRow;)V 
.const [194] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [195] = Utf8 <init> 
.const [196] = Utf8 (Lde/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesListRow;)V 
.const [197] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [198] = Utf8 doSetAirDistance 
.const [199] = Utf8 (I)V 
.const [200] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [201] = Utf8 doSetDirection 
.const [202] = Utf8 (I)V 
.const [203] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [204] = Utf8 doGetLatitude 
.const [205] = Utf8 ()I 
.const [206] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [207] = Utf8 doGetLongitude 
.const [208] = Utf8 ()I 
.const [209] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [210] = Utf8 isMarkedAsRRD 
.const [211] = Utf8 ()Z 
.const [212] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [213] = Utf8 distance 
.const [214] = Utf8 I 
.const [215] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [216] = Utf8 flagRRD 
.const [217] = Utf8 Z 
.const [218] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesParentListRow 
.const [219] = Class [218] 
.const [220] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesListRow 
.const [221] = Class [220] 
.const [222] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/DistanceDifferentiationRow 
.const [223] = Class [222] 
.const [224] = Utf8 distance 
.const [225] = Utf8 I 
.const [226] = Utf8 flagRRD 
.const [227] = Utf8 Z 
.const [228] = Utf8 Code 
.const [229] = Utf8 <init> 
.const [230] = Utf8 (Lde/audi/tghu/navi/app/IconHandler;Lorg/dsi/ifc/navigation/LIValueListElement;ILorg/dsi/ifc/navigation/PosPosition;Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [231] = Utf8 <init> 
.const [232] = Utf8 (Lde/audi/app/navi/evo/addressinput/poi/listbuilders/PoiIconedParentCategoriesListRow;)V 
.const [233] = Utf8 copy 
.const [234] = Utf8 ()Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [235] = Utf8 getDistance 
.const [236] = Utf8 ()I 
.const [237] = Utf8 setRRDDistance 
.const [238] = Utf8 (I)V 
.const [239] = Utf8 setAirDistance 
.const [240] = Utf8 (I)V 
.const [241] = Utf8 doSetAirDistance 
.const [242] = Utf8 (I)V 
.const [243] = Utf8 reformatDistance 
.const [244] = Utf8 ()V 
.const [245] = Utf8 getDirection 
.const [246] = Utf8 ()I 
.const [247] = Utf8 setDirection 
.const [248] = Utf8 (I)V 
.const [249] = Utf8 doSetDirection 
.const [250] = Utf8 (I)V 
.const [251] = Utf8 isMarkedAsRRD 
.const [252] = Utf8 ()Z 
.const [253] = Utf8 getLatitude 
.const [254] = Utf8 ()I 
.const [255] = Utf8 doGetLatitude 
.const [256] = Utf8 ()I 
.const [257] = Utf8 getLongitude 
.const [258] = Utf8 ()I 
.const [259] = Utf8 doGetLongitude 
.const [260] = Utf8 ()I 
.const [261] = Utf8 updateDirection 
.const [262] = Utf8 (Lorg/dsi/ifc/navigation/PosPosition;)V 
.const [263] = Utf8 doUpdateDirection 
.const [264] = Utf8 (Lorg/dsi/ifc/navigation/PosPosition;)V 
.const [265] = Utf8 updateAirDistance 
.const [266] = Utf8 (Lorg/dsi/ifc/navigation/PosPosition;)V 
.const [267] = Utf8 doUpdateAirDistance 
.const [268] = Utf8 (Lorg/dsi/ifc/navigation/PosPosition;)V 
.end class 
