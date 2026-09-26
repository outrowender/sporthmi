.version 50 0 
.class public super [342] 
.super [344] 
.field private [345] [346] 
.field private [347] [348] 
.field private [349] [350] 
.field private [351] [352] 
.field private [353] [354] 
.field private [355] [356] 

.method public [358] : [359] 
    .attribute [357] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [56] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [62] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [360] : [361] 
    .attribute [357] .code stack 5 locals 1 
L0:     aload_1 
L1:     iconst_3 
L2:     bipush 17 
L4:     invokevirtual [22] 
L7:     aload_1 
L8:     instanceof [2] 
L11:    ifeq L110 
L14:    aload_0 
L15:    getfield [23] 
L18:    ifnonnull L96 
L21:    aload_0 
L22:    new [64] 
L25:    dup 
L26:    invokespecial [57] 
L29:    putfield [63] 
L32:    new [65] 
L35:    dup 
L36:    aload_0 
L37:    getfield [23] 
L40:    invokespecial [58] 
L43:    astore_2 
L44:    aload_0 
L45:    getfield [23] 
L48:    aload_2 
L49:    invokevirtual [24] 
L52:    aload_0 
L53:    aload_0 
L54:    getfield [23] 
L57:    invokevirtual [25] 
L60:    aload_0 
L61:    getfield [23] 
L64:    aload_1 
L65:    invokevirtual [26] 
L68:    aload_0 
L69:    aload_1 
L70:    checkcast [2] 
L73:    putfield [66] 
L76:    aload_0 
L77:    getfield [23] 
L80:    aload_1 
L81:    invokevirtual [28] 
L84:    aload_1 
L85:    invokevirtual [29] 
L88:    iconst_0 
L89:    iconst_0 
L90:    invokevirtual [30] 
L93:    goto L130 
L96:    getstatic [5] 
L99:    ldc [6] 
L101:   ldc [7] 
L103:   invokevirtual [31] 
L106:   pop 
L107:   goto L130 
L110:   aload_1 
L111:   instanceof [8] 
L114:   ifeq L125 
L117:   aload_0 
L118:   aload_1 
L119:   checkcast [8] 
L122:   putfield [67] 
L125:   aload_0 
L126:   aload_1 
L127:   invokespecial [59] 
L130:   return 
L131:   nop 
L132:   
    .end code 
.end method 

.method public [362] : [363] 
    .attribute [357] .code stack 5 locals 8 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [60] 
L5:     aload_0 
L6:     getfield [21] 
L9:     ifne L154 
L12:    aload_0 
L13:    getfield [27] 
L16:    invokevirtual [33] 
L19:    istore_2 
L20:    aload_0 
L21:    getfield [27] 
L24:    invokevirtual [34] 
L27:    istore_3 
L28:    iload_2 
L29:    iconst_2 
L30:    idiv 
L31:    istore 4 
L33:    iload_3 
L34:    iconst_2 
L35:    idiv 
L36:    istore 5 
L38:    aload_0 
L39:    getfield [27] 
L42:    iload 4 
L44:    ineg 
L45:    iload 5 
L47:    ineg 
L48:    iconst_0 
L49:    iconst_0 
L50:    invokevirtual [35] 
L53:    aload_0 
L54:    getfield [23] 
L57:    aload_0 
L58:    getfield [23] 
L61:    invokevirtual [36] 
L64:    iload 4 
L66:    iadd 
L67:    invokevirtual [37] 
L70:    aload_0 
L71:    getfield [23] 
L74:    aload_0 
L75:    getfield [23] 
L78:    invokevirtual [38] 
L81:    iload 5 
L83:    iadd 
L84:    invokevirtual [39] 
L87:    ldc [9] 
L89:    iload_2 
L90:    iconst_2 
L91:    irem 
L92:    i2f 
L93:    fmul 
L94:    fstore 6 
L96:    ldc [9] 
L98:    iload_3 
L99:    iconst_2 
L100:   irem 
L101:   i2f 
L102:   fmul 
L103:   fstore 7 
L105:   aload_0 
L106:   getfield [27] 
L109:   invokevirtual [40] 
L112:   checkcast [10] 
L115:   astore 8 
L117:   aload 8 
L119:   fload 6 
L121:   fneg 
L122:   fload 7 
L124:   fneg 
L125:   invokevirtual [41] 
L128:   aload_0 
L129:   getfield [23] 
L132:   invokevirtual [42] 
L135:   checkcast [4] 
L138:   astore 9 
L140:   aload 9 
L142:   fload 6 
L144:   fload 7 
L146:   invokevirtual [43] 
L149:   aload_0 
L150:   iconst_1 
L151:   putfield [62] 
L154:   aload_0 
L155:   invokespecial [61] 
L158:   return 
L159:   nop 
L160:   
    .end code 
.end method 

.method public [364] : [365] 
    .attribute [357] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [23] 
L4:     invokevirtual [36] 
L7:     aload_0 
L8:     getfield [32] 
L11:    invokevirtual [44] 
L14:    invokestatic [11] 
L17:    istore_1 
L18:    aload_0 
L19:    getfield [23] 
L22:    invokevirtual [36] 
L25:    aload_0 
L26:    getfield [23] 
L29:    invokevirtual [45] 
L32:    iadd 
L33:    aload_0 
L34:    getfield [32] 
L37:    invokevirtual [44] 
L40:    aload_0 
L41:    getfield [32] 
L44:    invokevirtual [46] 
L47:    iadd 
L48:    invokestatic [12] 
L51:    istore_2 
L52:    iload_2 
L53:    iload_1 
L54:    isub 
L55:    areturn 
L56:    
    .end code 
.end method 

.method public [366] : [367] 
    .attribute [357] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [23] 
L4:     invokevirtual [38] 
L7:     aload_0 
L8:     getfield [32] 
L11:    invokevirtual [47] 
L14:    invokestatic [11] 
L17:    istore_1 
L18:    aload_0 
L19:    getfield [23] 
L22:    invokevirtual [38] 
L25:    aload_0 
L26:    getfield [23] 
L29:    invokevirtual [48] 
L32:    iadd 
L33:    aload_0 
L34:    getfield [32] 
L37:    invokevirtual [47] 
L40:    aload_0 
L41:    getfield [32] 
L44:    invokevirtual [49] 
L47:    iadd 
L48:    invokestatic [12] 
L51:    istore_2 
L52:    iload_2 
L53:    iload_1 
L54:    isub 
L55:    areturn 
L56:    
    .end code 
.end method 

.method public interface [368] : [369] 
    .attribute [357] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [50] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [370] : [371] 
    .attribute [357] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [61] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [372] : [373] 
    .attribute [357] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [68] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [374] : [375] 
    .attribute [357] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [51] 
L4:     instanceof [13] 
L7:     ifeq L78 
L10:    aload_0 
L11:    getfield [51] 
L14:    checkcast [13] 
L17:    invokeinterface [69] 0 
L22:    istore_1 
L23:    aload_0 
L24:    getfield [52] 
L27:    iload_1 
L28:    if_icmpeq L78 
L31:    aload_0 
L32:    iload_1 
L33:    putfield [70] 
L36:    getstatic [5] 
L39:    ldc [14] 
L41:    ldc [15] 
L43:    aload_0 
L44:    getfield [52] 
L47:    i2l 
L48:    invokevirtual [53] 
L51:    pop 
L52:    aload_0 
L53:    getfield [23] 
L56:    invokevirtual [42] 
L59:    checkcast [4] 
L62:    aload_0 
L63:    getfield [52] 
L66:    i2f 
L67:    invokevirtual [54] 
L70:    aload_0 
L71:    getfield [23] 
L74:    iconst_1 
L75:    invokevirtual [55] 
L78:    return 
L79:    nop 
L80:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [71] 
.const [3] = Class [72] 
.const [4] = Class [73] 
.const [5] = Field [74] [75] 
.const [6] = Int -1601830656 
.const [7] = String [76] 
.const [8] = Class [77] 
.const [9] = Int 63 
.const [10] = Class [78] 
.const [11] = Method [79] [80] 
.const [12] = Method [81] [82] 
.const [13] = Class [83] 
.const [14] = Int -2137614336 
.const [15] = String [84] 
.const [16] = Class [85] 
.const [17] = Class [86] 
.const [18] = Class [87] 
.const [19] = Class [88] 
.const [20] = Class [89] 
.const [21] = Field [90] [91] 
.const [22] = Method [92] [93] 
.const [23] = Field [94] [95] 
.const [24] = Method [96] [97] 
.const [25] = Method [98] [99] 
.const [26] = Method [100] [101] 
.const [27] = Field [102] [103] 
.const [28] = Method [104] [105] 
.const [29] = Method [106] [107] 
.const [30] = Method [108] [109] 
.const [31] = Method [110] [111] 
.const [32] = Field [112] [113] 
.const [33] = Method [114] [115] 
.const [34] = Method [116] [117] 
.const [35] = Method [118] [119] 
.const [36] = Method [120] [121] 
.const [37] = Method [122] [123] 
.const [38] = Method [124] [125] 
.const [39] = Method [126] [127] 
.const [40] = Method [128] [129] 
.const [41] = Method [130] [131] 
.const [42] = Method [132] [133] 
.const [43] = Method [134] [135] 
.const [44] = Method [136] [137] 
.const [45] = Method [138] [139] 
.const [46] = Method [140] [141] 
.const [47] = Method [142] [143] 
.const [48] = Method [144] [145] 
.const [49] = Method [146] [147] 
.const [50] = Field [148] [149] 
.const [51] = Field [150] [151] 
.const [52] = Field [152] [153] 
.const [53] = Method [154] [155] 
.const [54] = Method [156] [157] 
.const [55] = Method [158] [159] 
.const [56] = Method [160] [161] 
.const [57] = Method [162] [163] 
.const [58] = Method [164] [165] 
.const [59] = Method [166] [167] 
.const [60] = Method [168] [169] 
.const [61] = Method [170] [171] 
.const [62] = Field [172] [173] 
.const [63] = Field [174] [175] 
.const [64] = Class [176] 
.const [65] = Class [177] 
.const [66] = Field [178] [179] 
.const [67] = Field [180] [181] 
.const [68] = Field [182] [183] 
.const [69] = InterfaceMethod [184] [185] 
.const [70] = Field [186] [187] 
.const [71] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconController 
.const [72] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController 
.const [73] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/CompositeRendererHigh 
.const [74] = Class [188] 
.const [75] = NameAndType [189] [190] 
.const [76] = Utf8 'SideBarOrientationWidget#add Compass icon was already added to the widget.' 
.const [77] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LabelController 
.const [78] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/IconRendererHigh 
.const [79] = Class [191] 
.const [80] = NameAndType [192] [193] 
.const [81] = Class [194] 
.const [82] = NameAndType [195] [196] 
.const [83] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelGUI 
.const [84] = Utf8 'SideBarOrientationWidget#updateValue Orientation changed: orientation = %1' 
.const [85] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/SideBarOrientationWidget 
.const [86] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController 
.const [87] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [88] = Utf8 de/audi/atip/log/LogChannel 
.const [89] = Utf8 java/lang/Math 
.const [90] = Class [197] 
.const [91] = NameAndType [198] [199] 
.const [92] = Class [200] 
.const [93] = NameAndType [201] [202] 
.const [94] = Class [203] 
.const [95] = NameAndType [204] [205] 
.const [96] = Class [206] 
.const [97] = NameAndType [207] [208] 
.const [98] = Class [209] 
.const [99] = NameAndType [210] [211] 
.const [100] = Class [212] 
.const [101] = NameAndType [213] [214] 
.const [102] = Class [215] 
.const [103] = NameAndType [216] [217] 
.const [104] = Class [218] 
.const [105] = NameAndType [219] [220] 
.const [106] = Class [221] 
.const [107] = NameAndType [222] [223] 
.const [108] = Class [224] 
.const [109] = NameAndType [225] [226] 
.const [110] = Class [227] 
.const [111] = NameAndType [228] [229] 
.const [112] = Class [230] 
.const [113] = NameAndType [231] [232] 
.const [114] = Class [233] 
.const [115] = NameAndType [234] [235] 
.const [116] = Class [236] 
.const [117] = NameAndType [237] [238] 
.const [118] = Class [239] 
.const [119] = NameAndType [240] [241] 
.const [120] = Class [242] 
.const [121] = NameAndType [243] [244] 
.const [122] = Class [245] 
.const [123] = NameAndType [246] [247] 
.const [124] = Class [248] 
.const [125] = NameAndType [249] [250] 
.const [126] = Class [251] 
.const [127] = NameAndType [252] [253] 
.const [128] = Class [254] 
.const [129] = NameAndType [255] [256] 
.const [130] = Class [257] 
.const [131] = NameAndType [258] [259] 
.const [132] = Class [260] 
.const [133] = NameAndType [261] [262] 
.const [134] = Class [263] 
.const [135] = NameAndType [264] [265] 
.const [136] = Class [266] 
.const [137] = NameAndType [267] [268] 
.const [138] = Class [269] 
.const [139] = NameAndType [270] [271] 
.const [140] = Class [272] 
.const [141] = NameAndType [273] [274] 
.const [142] = Class [275] 
.const [143] = NameAndType [276] [277] 
.const [144] = Class [278] 
.const [145] = NameAndType [279] [280] 
.const [146] = Class [281] 
.const [147] = NameAndType [282] [283] 
.const [148] = Class [284] 
.const [149] = NameAndType [285] [286] 
.const [150] = Class [287] 
.const [151] = NameAndType [288] [289] 
.const [152] = Class [290] 
.const [153] = NameAndType [291] [292] 
.const [154] = Class [293] 
.const [155] = NameAndType [294] [295] 
.const [156] = Class [296] 
.const [157] = NameAndType [297] [298] 
.const [158] = Class [299] 
.const [159] = NameAndType [300] [301] 
.const [160] = Class [302] 
.const [161] = NameAndType [303] [304] 
.const [162] = Class [305] 
.const [163] = NameAndType [306] [307] 
.const [164] = Class [308] 
.const [165] = NameAndType [309] [310] 
.const [166] = Class [311] 
.const [167] = NameAndType [312] [313] 
.const [168] = Class [314] 
.const [169] = NameAndType [315] [316] 
.const [170] = Class [317] 
.const [171] = NameAndType [318] [319] 
.const [172] = Class [320] 
.const [173] = NameAndType [321] [322] 
.const [174] = Class [323] 
.const [175] = NameAndType [324] [325] 
.const [176] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController 
.const [177] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/CompositeRendererHigh 
.const [178] = Class [326] 
.const [179] = NameAndType [327] [328] 
.const [180] = Class [329] 
.const [181] = NameAndType [330] [331] 
.const [182] = Class [332] 
.const [183] = NameAndType [333] [334] 
.const [184] = Class [335] 
.const [185] = NameAndType [336] [337] 
.const [186] = Class [338] 
.const [187] = NameAndType [339] [340] 
.const [188] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/SideBarOrientationWidget 
.const [189] = Utf8 sideBarLogChannel 
.const [190] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [191] = Utf8 java/lang/Math 
.const [192] = Utf8 min 
.const [193] = Utf8 (II)I 
.const [194] = Utf8 java/lang/Math 
.const [195] = Utf8 max 
.const [196] = Utf8 (II)I 
.const [197] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/SideBarOrientationWidget 
.const [198] = Utf8 isSetUp 
.const [199] = Utf8 Z 
.const [200] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [201] = Utf8 setChainedAction 
.const [202] = Utf8 (II)V 
.const [203] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/SideBarOrientationWidget 
.const [204] = Utf8 intermediateRotationNode 
.const [205] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController; 
.const [206] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController 
.const [207] = Utf8 setRenderer 
.const [208] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/CompositeRenderer;)V 
.const [209] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/SideBarOrientationWidget 
.const [210] = Utf8 add 
.const [211] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/AbstractWidget;)V 
.const [212] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController 
.const [213] = Utf8 add 
.const [214] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/AbstractWidget;)V 
.const [215] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/SideBarOrientationWidget 
.const [216] = Utf8 compassIcon 
.const [217] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/IconController; 
.const [218] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [219] = Utf8 getX 
.const [220] = Utf8 ()I 
.const [221] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [222] = Utf8 getY 
.const [223] = Utf8 ()I 
.const [224] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController 
.const [225] = Utf8 setBounds 
.const [226] = Utf8 (IIII)V 
.const [227] = Utf8 de/audi/atip/log/LogChannel 
.const [228] = Utf8 log 
.const [229] = Utf8 (ILjava/lang/String;)Z 
.const [230] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/SideBarOrientationWidget 
.const [231] = Utf8 northLabel 
.const [232] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/LabelController; 
.const [233] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconController 
.const [234] = Utf8 getPreferredWidth 
.const [235] = Utf8 ()I 
.const [236] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconController 
.const [237] = Utf8 getPreferredHeight 
.const [238] = Utf8 ()I 
.const [239] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconController 
.const [240] = Utf8 setBounds 
.const [241] = Utf8 (IIII)V 
.const [242] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController 
.const [243] = Utf8 getX 
.const [244] = Utf8 ()I 
.const [245] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController 
.const [246] = Utf8 setX 
.const [247] = Utf8 (I)V 
.const [248] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController 
.const [249] = Utf8 getY 
.const [250] = Utf8 ()I 
.const [251] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController 
.const [252] = Utf8 setY 
.const [253] = Utf8 (I)V 
.const [254] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconController 
.const [255] = Utf8 getRenderer 
.const [256] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/widgets/IRenderer; 
.const [257] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/IconRendererHigh 
.const [258] = Utf8 setFloatingPointOffset 
.const [259] = Utf8 (FF)V 
.const [260] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController 
.const [261] = Utf8 getRenderer 
.const [262] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/widgets/IRenderer; 
.const [263] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/CompositeRendererHigh 
.const [264] = Utf8 setFloatingPointOffset 
.const [265] = Utf8 (FF)V 
.const [266] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LabelController 
.const [267] = Utf8 getX 
.const [268] = Utf8 ()I 
.const [269] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController 
.const [270] = Utf8 getPreferredWidth 
.const [271] = Utf8 ()I 
.const [272] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LabelController 
.const [273] = Utf8 getPreferredWidth 
.const [274] = Utf8 ()I 
.const [275] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LabelController 
.const [276] = Utf8 getY 
.const [277] = Utf8 ()I 
.const [278] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController 
.const [279] = Utf8 getPreferredHeight 
.const [280] = Utf8 ()I 
.const [281] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LabelController 
.const [282] = Utf8 getPreferredHeight 
.const [283] = Utf8 ()I 
.const [284] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/SideBarOrientationWidget 
.const [285] = Utf8 renderer 
.const [286] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/CompositeRenderer; 
.const [287] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/SideBarOrientationWidget 
.const [288] = Utf8 model 
.const [289] = Utf8 Ljava/lang/Object; 
.const [290] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/SideBarOrientationWidget 
.const [291] = Utf8 orientation 
.const [292] = Utf8 I 
.const [293] = Utf8 de/audi/atip/log/LogChannel 
.const [294] = Utf8 log 
.const [295] = Utf8 (ILjava/lang/String;J)Z 
.const [296] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/CompositeRendererHigh 
.const [297] = Utf8 setRotationZ 
.const [298] = Utf8 (F)V 
.const [299] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController 
.const [300] = Utf8 setCompositesDirty 
.const [301] = Utf8 (Z)V 
.const [302] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController 
.const [303] = Utf8 <init> 
.const [304] = Utf8 ()V 
.const [305] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController 
.const [306] = Utf8 <init> 
.const [307] = Utf8 ()V 
.const [308] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/CompositeRendererHigh 
.const [309] = Utf8 <init> 
.const [310] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController;)V 
.const [311] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController 
.const [312] = Utf8 add 
.const [313] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/AbstractWidget;)V 
.const [314] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController 
.const [315] = Utf8 connected 
.const [316] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/InitializationContext;)V 
.const [317] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/SideBarOrientationWidget 
.const [318] = Utf8 updateValue 
.const [319] = Utf8 ()V 
.const [320] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/SideBarOrientationWidget 
.const [321] = Utf8 isSetUp 
.const [322] = Utf8 Z 
.const [323] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/SideBarOrientationWidget 
.const [324] = Utf8 intermediateRotationNode 
.const [325] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController; 
.const [326] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/SideBarOrientationWidget 
.const [327] = Utf8 compassIcon 
.const [328] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/IconController; 
.const [329] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/SideBarOrientationWidget 
.const [330] = Utf8 northLabel 
.const [331] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/LabelController; 
.const [332] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/SideBarOrientationWidget 
.const [333] = Utf8 renderer 
.const [334] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/CompositeRenderer; 
.const [335] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelGUI 
.const [336] = Utf8 getValue 
.const [337] = Utf8 ()I 
.const [338] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/SideBarOrientationWidget 
.const [339] = Utf8 orientation 
.const [340] = Utf8 I 
.const [341] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/SideBarOrientationWidget 
.const [342] = Class [341] 
.const [343] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController 
.const [344] = Class [343] 
.const [345] = Utf8 intermediateRotationNode 
.const [346] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/LayoutContainerController; 
.const [347] = Utf8 compassIcon 
.const [348] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/IconController; 
.const [349] = Utf8 northLabel 
.const [350] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/LabelController; 
.const [351] = Utf8 renderer 
.const [352] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/CompositeRenderer; 
.const [353] = Utf8 orientation 
.const [354] = Utf8 I 
.const [355] = Utf8 isSetUp 
.const [356] = Utf8 Z 
.const [357] = Utf8 Code 
.const [358] = Utf8 <init> 
.const [359] = Utf8 ()V 
.const [360] = Utf8 add 
.const [361] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/AbstractWidget;)V 
.const [362] = Utf8 connected 
.const [363] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/InitializationContext;)V 
.const [364] = Utf8 getPreferredWidth 
.const [365] = Utf8 ()I 
.const [366] = Utf8 getPreferredHeight 
.const [367] = Utf8 ()I 
.const [368] = Utf8 getRenderer 
.const [369] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/widgets/IRenderer; 
.const [370] = Utf8 processModelUpdateEvent 
.const [371] = Utf8 (Lde/audi/atip/hmi/event/ModelUpdateEvent;)V 
.const [372] = Utf8 setRenderer 
.const [373] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/CompositeRenderer;)V 
.const [374] = Utf8 updateValue 
.const [375] = Utf8 ()V 
.end class 
