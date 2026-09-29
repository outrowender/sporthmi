.version 50 0 
.class public super [282] 
.super [284] 
.field private final [285] [286] 
.field private final [287] [288] 
.field private final [289] [290] 

.method public [292] : [293] 
    .attribute [291] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [43] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [52] 
L9:     aload_0 
L10:    new [53] 
L13:    dup 
L14:    invokespecial [44] 
L17:    putfield [54] 
L20:    aload_0 
L21:    new [55] 
L24:    dup 
L25:    invokespecial [45] 
L28:    putfield [56] 
L31:    return 
L32:    
    .end code 
.end method 

.method public [294] : [295] 
    .attribute [291] .code stack 5 locals 1 
L0:     aload_1 
L1:     ifnonnull L23 
L4:     getstatic [4] 
L7:     ldc [5] 
L9:     ldc [6] 
L11:    new [57] 
L14:    dup 
L15:    invokespecial [46] 
L18:    invokevirtual [27] 
L21:    pop 
L22:    return 
L23:    aload_1 
L24:    invokeinterface [58] 0 
L29:    astore_2 
L30:    aload_2 
L31:    ifnonnull L63 
L34:    new [59] 
L37:    dup 
L38:    new [60] 
L41:    dup 
L42:    ldc [10] 
L44:    invokespecial [47] 
L47:    aload_1 
L48:    invokevirtual [28] 
L51:    ldc [11] 
L53:    invokevirtual [29] 
L56:    invokevirtual [30] 
L59:    invokespecial [48] 
L62:    athrow 
L63:    aload_0 
L64:    getfield [25] 
L67:    aload_2 
L68:    invokevirtual [31] 
L71:    ifne L90 
L74:    aload_0 
L75:    getfield [25] 
L78:    aload_2 
L79:    new [61] 
L82:    dup 
L83:    invokespecial [49] 
L86:    invokevirtual [32] 
L89:    pop 
L90:    aload_0 
L91:    getfield [26] 
L94:    aload_1 
L95:    invokevirtual [33] 
L98:    ifeq L120 
L101:   aload_1 
L102:   invokeinterface [62] 0 
L107:   aload_0 
L108:   aload_2 
L109:   invokespecial [50] 
L112:   aload_1 
L113:   invokevirtual [34] 
L116:   pop 
L117:   goto L133 
L120:   getstatic [4] 
L123:   sipush 10000 
L126:   ldc [13] 
L128:   aload_1 
L129:   invokevirtual [35] 
L132:   pop 
L133:   return 
L134:   nop 
L135:   nop 
L136:   
    .end code 
.end method 

.method private [296] : [297] 
    .attribute [291] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     aload_1 
L5:     invokevirtual [36] 
L8:     checkcast [12] 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [298] : [299] 
    .attribute [291] .code stack 2 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [51] 
L5:     ifeq L31 
L8:     aload_0 
L9:     aload_1 
L10:    invokespecial [50] 
L13:    invokevirtual [37] 
L16:    checkcast [14] 
L19:    astore_2 
L20:    aload_0 
L21:    getfield [26] 
L24:    aload_2 
L25:    invokevirtual [38] 
L28:    pop 
L29:    aload_2 
L30:    areturn 
L31:    aload_0 
L32:    getfield [24] 
L35:    aload_1 
L36:    invokestatic [15] 
L39:    areturn 
L40:    
    .end code 
.end method 

.method private [300] : [301] 
    .attribute [291] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     aload_1 
L5:     invokevirtual [31] 
L8:     ifeq L26 
L11:    aload_0 
L12:    aload_1 
L13:    invokespecial [50] 
L16:    invokevirtual [39] 
L19:    ifne L26 
L22:    iconst_1 
L23:    goto L27 
L26:    iconst_0 
L27:    areturn 
L28:    
    .end code 
.end method 

.method public [302] : [303] 
    .attribute [291] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [25] 
L4:     invokevirtual [40] 
L7:     invokeinterface [63] 0 
L12:    astore_1 
L13:    aload_1 
L14:    invokeinterface [64] 0 
L19:    ifeq L49 
L22:    aload_1 
L23:    invokeinterface [65] 0 
L28:    checkcast [16] 
L31:    astore_2 
L32:    aload_0 
L33:    getfield [25] 
L36:    aload_2 
L37:    invokevirtual [36] 
L40:    checkcast [12] 
L43:    invokevirtual [41] 
L46:    goto L13 
L49:    aload_0 
L50:    getfield [25] 
L53:    invokevirtual [42] 
L56:    return 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [66] 
.const [3] = Class [67] 
.const [4] = Field [68] [69] 
.const [5] = Int -2137614336 
.const [6] = String [70] 
.const [7] = Class [71] 
.const [8] = Class [72] 
.const [9] = Class [73] 
.const [10] = String [74] 
.const [11] = String [75] 
.const [12] = Class [76] 
.const [13] = String [77] 
.const [14] = Class [78] 
.const [15] = Method [79] [80] 
.const [16] = Class [81] 
.const [17] = Class [82] 
.const [18] = Class [83] 
.const [19] = Class [84] 
.const [20] = Class [85] 
.const [21] = Class [86] 
.const [22] = Class [87] 
.const [23] = Class [88] 
.const [24] = Field [89] [90] 
.const [25] = Field [91] [92] 
.const [26] = Field [93] [94] 
.const [27] = Method [95] [96] 
.const [28] = Method [97] [98] 
.const [29] = Method [99] [100] 
.const [30] = Method [101] [102] 
.const [31] = Method [103] [104] 
.const [32] = Method [105] [106] 
.const [33] = Method [107] [108] 
.const [34] = Method [109] [110] 
.const [35] = Method [111] [112] 
.const [36] = Method [113] [114] 
.const [37] = Method [115] [116] 
.const [38] = Method [117] [118] 
.const [39] = Method [119] [120] 
.const [40] = Method [121] [122] 
.const [41] = Method [123] [124] 
.const [42] = Method [125] [126] 
.const [43] = Method [127] [128] 
.const [44] = Method [129] [130] 
.const [45] = Method [131] [132] 
.const [46] = Method [133] [134] 
.const [47] = Method [135] [136] 
.const [48] = Method [137] [138] 
.const [49] = Method [139] [140] 
.const [50] = Method [141] [142] 
.const [51] = Method [143] [144] 
.const [52] = Field [145] [146] 
.const [53] = Class [147] 
.const [54] = Field [148] [149] 
.const [55] = Class [150] 
.const [56] = Field [151] [152] 
.const [57] = Class [153] 
.const [58] = InterfaceMethod [154] [155] 
.const [59] = Class [156] 
.const [60] = Class [157] 
.const [61] = Class [158] 
.const [62] = InterfaceMethod [159] [160] 
.const [63] = InterfaceMethod [161] [162] 
.const [64] = InterfaceMethod [163] [164] 
.const [65] = InterfaceMethod [165] [166] 
.const [66] = Utf8 java/util/HashMap 
.const [67] = Utf8 java/util/HashSet 
.const [68] = Class [167] 
.const [69] = NameAndType [168] [169] 
.const [70] = Utf8 'ReusableInstanceCache#add: ignored null instance.' 
.const [71] = Utf8 java/lang/Throwable 
.const [72] = Utf8 java/lang/IllegalArgumentException 
.const [73] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [74] = Utf8 "Could not add instance '" 
.const [75] = Utf8 "', type key was null." 
.const [76] = Utf8 java/util/LinkedList 
.const [77] = Utf8 'ReusableInstanceCache#add: Could not add instance (%1), it already exists in the cache.' 
.const [78] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache$IReusable 
.const [79] = Class [170] 
.const [80] = NameAndType [171] [172] 
.const [81] = Utf8 java/lang/String 
.const [82] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache 
.const [83] = Utf8 java/lang/Object 
.const [84] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache$AbstractInstanceFactory 
.const [85] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [86] = Utf8 de/audi/atip/log/LogChannel 
.const [87] = Utf8 java/util/Set 
.const [88] = Utf8 java/util/Iterator 
.const [89] = Class [173] 
.const [90] = NameAndType [174] [175] 
.const [91] = Class [176] 
.const [92] = NameAndType [177] [178] 
.const [93] = Class [179] 
.const [94] = NameAndType [180] [181] 
.const [95] = Class [182] 
.const [96] = NameAndType [183] [184] 
.const [97] = Class [185] 
.const [98] = NameAndType [186] [187] 
.const [99] = Class [188] 
.const [100] = NameAndType [189] [190] 
.const [101] = Class [191] 
.const [102] = NameAndType [192] [193] 
.const [103] = Class [194] 
.const [104] = NameAndType [195] [196] 
.const [105] = Class [197] 
.const [106] = NameAndType [198] [199] 
.const [107] = Class [200] 
.const [108] = NameAndType [201] [202] 
.const [109] = Class [203] 
.const [110] = NameAndType [204] [205] 
.const [111] = Class [206] 
.const [112] = NameAndType [207] [208] 
.const [113] = Class [209] 
.const [114] = NameAndType [210] [211] 
.const [115] = Class [212] 
.const [116] = NameAndType [213] [214] 
.const [117] = Class [215] 
.const [118] = NameAndType [216] [217] 
.const [119] = Class [218] 
.const [120] = NameAndType [219] [220] 
.const [121] = Class [221] 
.const [122] = NameAndType [222] [223] 
.const [123] = Class [224] 
.const [124] = NameAndType [225] [226] 
.const [125] = Class [227] 
.const [126] = NameAndType [228] [229] 
.const [127] = Class [230] 
.const [128] = NameAndType [231] [232] 
.const [129] = Class [233] 
.const [130] = NameAndType [234] [235] 
.const [131] = Class [236] 
.const [132] = NameAndType [237] [238] 
.const [133] = Class [239] 
.const [134] = NameAndType [240] [241] 
.const [135] = Class [242] 
.const [136] = NameAndType [243] [244] 
.const [137] = Class [245] 
.const [138] = NameAndType [246] [247] 
.const [139] = Class [248] 
.const [140] = NameAndType [249] [250] 
.const [141] = Class [251] 
.const [142] = NameAndType [252] [253] 
.const [143] = Class [254] 
.const [144] = NameAndType [255] [256] 
.const [145] = Class [257] 
.const [146] = NameAndType [258] [259] 
.const [147] = Utf8 java/util/HashMap 
.const [148] = Class [260] 
.const [149] = NameAndType [261] [262] 
.const [150] = Utf8 java/util/HashSet 
.const [151] = Class [263] 
.const [152] = NameAndType [264] [265] 
.const [153] = Utf8 java/lang/Throwable 
.const [154] = Class [266] 
.const [155] = NameAndType [267] [268] 
.const [156] = Utf8 java/lang/IllegalArgumentException 
.const [157] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [158] = Utf8 java/util/LinkedList 
.const [159] = Class [269] 
.const [160] = NameAndType [270] [271] 
.const [161] = Class [272] 
.const [162] = NameAndType [273] [274] 
.const [163] = Class [275] 
.const [164] = NameAndType [276] [277] 
.const [165] = Class [278] 
.const [166] = NameAndType [279] [280] 
.const [167] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [168] = Utf8 tpLogChannelInternal 
.const [169] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [170] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache$AbstractInstanceFactory 
.const [171] = Utf8 access$000 
.const [172] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache$AbstractInstanceFactory;Ljava/lang/String;)Lde/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache$IReusable; 
.const [173] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache 
.const [174] = Utf8 factory 
.const [175] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache$AbstractInstanceFactory; 
.const [176] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache 
.const [177] = Utf8 cachedInstancesSortedByClass 
.const [178] = Utf8 Ljava/util/HashMap; 
.const [179] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache 
.const [180] = Utf8 cachedInstances 
.const [181] = Utf8 Ljava/util/HashSet; 
.const [182] = Utf8 de/audi/atip/log/LogChannel 
.const [183] = Utf8 log 
.const [184] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [185] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [186] = Utf8 append 
.const [187] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/Buffer; 
.const [188] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [189] = Utf8 append 
.const [190] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [191] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [192] = Utf8 toString 
.const [193] = Utf8 ()Ljava/lang/String; 
.const [194] = Utf8 java/util/HashMap 
.const [195] = Utf8 containsKey 
.const [196] = Utf8 (Ljava/lang/Object;)Z 
.const [197] = Utf8 java/util/HashMap 
.const [198] = Utf8 put 
.const [199] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [200] = Utf8 java/util/HashSet 
.const [201] = Utf8 add 
.const [202] = Utf8 (Ljava/lang/Object;)Z 
.const [203] = Utf8 java/util/LinkedList 
.const [204] = Utf8 add 
.const [205] = Utf8 (Ljava/lang/Object;)Z 
.const [206] = Utf8 de/audi/atip/log/LogChannel 
.const [207] = Utf8 log 
.const [208] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [209] = Utf8 java/util/HashMap 
.const [210] = Utf8 get 
.const [211] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [212] = Utf8 java/util/LinkedList 
.const [213] = Utf8 removeFirst 
.const [214] = Utf8 ()Ljava/lang/Object; 
.const [215] = Utf8 java/util/HashSet 
.const [216] = Utf8 remove 
.const [217] = Utf8 (Ljava/lang/Object;)Z 
.const [218] = Utf8 java/util/LinkedList 
.const [219] = Utf8 isEmpty 
.const [220] = Utf8 ()Z 
.const [221] = Utf8 java/util/HashMap 
.const [222] = Utf8 keySet 
.const [223] = Utf8 ()Ljava/util/Set; 
.const [224] = Utf8 java/util/LinkedList 
.const [225] = Utf8 clear 
.const [226] = Utf8 ()V 
.const [227] = Utf8 java/util/HashMap 
.const [228] = Utf8 clear 
.const [229] = Utf8 ()V 
.const [230] = Utf8 java/lang/Object 
.const [231] = Utf8 <init> 
.const [232] = Utf8 ()V 
.const [233] = Utf8 java/util/HashMap 
.const [234] = Utf8 <init> 
.const [235] = Utf8 ()V 
.const [236] = Utf8 java/util/HashSet 
.const [237] = Utf8 <init> 
.const [238] = Utf8 ()V 
.const [239] = Utf8 java/lang/Throwable 
.const [240] = Utf8 <init> 
.const [241] = Utf8 ()V 
.const [242] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [243] = Utf8 <init> 
.const [244] = Utf8 (Ljava/lang/String;)V 
.const [245] = Utf8 java/lang/IllegalArgumentException 
.const [246] = Utf8 <init> 
.const [247] = Utf8 (Ljava/lang/String;)V 
.const [248] = Utf8 java/util/LinkedList 
.const [249] = Utf8 <init> 
.const [250] = Utf8 ()V 
.const [251] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache 
.const [252] = Utf8 getCachedInstanceList 
.const [253] = Utf8 (Ljava/lang/String;)Ljava/util/LinkedList; 
.const [254] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache 
.const [255] = Utf8 hasCachedInstance 
.const [256] = Utf8 (Ljava/lang/String;)Z 
.const [257] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache 
.const [258] = Utf8 factory 
.const [259] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache$AbstractInstanceFactory; 
.const [260] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache 
.const [261] = Utf8 cachedInstancesSortedByClass 
.const [262] = Utf8 Ljava/util/HashMap; 
.const [263] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache 
.const [264] = Utf8 cachedInstances 
.const [265] = Utf8 Ljava/util/HashSet; 
.const [266] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache$IReusable 
.const [267] = Utf8 getTypeKey 
.const [268] = Utf8 ()Ljava/lang/String; 
.const [269] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache$IReusable 
.const [270] = Utf8 reset 
.const [271] = Utf8 ()V 
.const [272] = Utf8 java/util/Set 
.const [273] = Utf8 iterator 
.const [274] = Utf8 ()Ljava/util/Iterator; 
.const [275] = Utf8 java/util/Iterator 
.const [276] = Utf8 hasNext 
.const [277] = Utf8 ()Z 
.const [278] = Utf8 java/util/Iterator 
.const [279] = Utf8 next 
.const [280] = Utf8 ()Ljava/lang/Object; 
.const [281] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache 
.const [282] = Class [281] 
.const [283] = Utf8 java/lang/Object 
.const [284] = Class [283] 
.const [285] = Utf8 factory 
.const [286] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache$AbstractInstanceFactory; 
.const [287] = Utf8 cachedInstancesSortedByClass 
.const [288] = Utf8 Ljava/util/HashMap; 
.const [289] = Utf8 cachedInstances 
.const [290] = Utf8 Ljava/util/HashSet; 
.const [291] = Utf8 Code 
.const [292] = Utf8 <init> 
.const [293] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache$AbstractInstanceFactory;)V 
.const [294] = Utf8 collect 
.const [295] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache$IReusable;)V 
.const [296] = Utf8 getCachedInstanceList 
.const [297] = Utf8 (Ljava/lang/String;)Ljava/util/LinkedList; 
.const [298] = Utf8 getOrCreateInstance 
.const [299] = Utf8 (Ljava/lang/String;)Lde/esolutions/hmi/widgets/audi/evo/widgets/ReusableInstanceCache$IReusable; 
.const [300] = Utf8 hasCachedInstance 
.const [301] = Utf8 (Ljava/lang/String;)Z 
.const [302] = Utf8 clear 
.const [303] = Utf8 ()V 
.end class 
