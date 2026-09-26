.version 50 0 
.class public super [232] 
.super [234] 
.field private static final [235] [236] 
.field private final [237] [238] 
.field private final [239] [240] 
.field private [241] [242] 
.field private [243] [244] 
.field private [245] [246] 

.method public [248] : [249] 
    .attribute [247] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [32] 
L4:     aload_1 
L5:     ifnull L12 
L8:     aload_2 
L9:     ifnonnull L22 
L12:    new [37] 
L15:    dup 
L16:    ldc [3] 
L18:    invokespecial [33] 
L21:    athrow 
L22:    aload_0 
L23:    aload_2 
L24:    putfield [38] 
L27:    aload_0 
L28:    aload_1 
L29:    putfield [39] 
L32:    aload_0 
L33:    new [40] 
L36:    dup 
L37:    invokespecial [34] 
L40:    putfield [41] 
L43:    aload_0 
L44:    new [40] 
L47:    dup 
L48:    invokespecial [34] 
L51:    putfield [42] 
L54:    aload_0 
L55:    new [40] 
L58:    dup 
L59:    invokespecial [34] 
L62:    putfield [43] 
L65:    return 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [250] : [251] 
    .attribute [247] .code stack 5 locals 4 
L0:     new [40] 
L3:     dup 
L4:     iconst_2 
L5:     invokespecial [35] 
L8:     astore_2 
L9:     aload_1 
L10:    invokeinterface [44] 0 
L15:    invokeinterface [45] 0 
L20:    astore_3 
L21:    aload_3 
L22:    invokeinterface [46] 0 
L27:    ifeq L108 
L30:    aload_3 
L31:    invokeinterface [47] 0 
L36:    checkcast [5] 
L39:    astore 4 
L41:    aload_1 
L42:    aload 4 
L44:    invokeinterface [48] 0 
L49:    checkcast [6] 
L52:    astore 5 
L54:    aload 5 
L56:    aload_0 
L57:    getfield [24] 
L60:    aload 4 
L62:    invokeinterface [48] 0 
L67:    invokevirtual [27] 
L70:    ifne L105 
L73:    aload_0 
L74:    getfield [23] 
L77:    ldc [7] 
L79:    ldc [8] 
L81:    ldc [9] 
L83:    aload 4 
L85:    invokevirtual [28] 
L88:    invokestatic [10] 
L91:    invokevirtual [29] 
L94:    aload_2 
L95:    aload 4 
L97:    aload 5 
L99:    invokeinterface [49] 0 
L104:   pop 
L105:   goto L21 
L108:   aload_0 
L109:   getfield [24] 
L112:   invokeinterface [44] 0 
L117:   invokeinterface [45] 0 
L122:   astore_3 
L123:   aload_3 
L124:   invokeinterface [46] 0 
L129:   ifeq L195 
L132:   aload_3 
L133:   invokeinterface [47] 0 
L138:   checkcast [5] 
L141:   astore 4 
L143:   aload_1 
L144:   aload 4 
L146:   invokeinterface [50] 0 
L151:   ifne L192 
L154:   aload_0 
L155:   getfield [23] 
L158:   ldc [7] 
L160:   ldc [11] 
L162:   ldc [9] 
L164:   aload 4 
L166:   invokevirtual [28] 
L169:   invokestatic [10] 
L172:   invokevirtual [29] 
L175:   aload_2 
L176:   aload 4 
L178:   new [51] 
L181:   dup 
L182:   iconst_0 
L183:   invokespecial [36] 
L186:   invokeinterface [49] 0 
L191:   pop 
L192:   goto L123 
L195:   aload_0 
L196:   aload_1 
L197:   putfield [41] 
L200:   aload_0 
L201:   getfield [22] 
L204:   aload_2 
L205:   invokeinterface [52] 0 
L210:   return 
L211:   nop 
L212:   
    .end code 
.end method 

.method public [252] : [253] 
    .attribute [247] .code stack 3 locals 4 
L0:     new [40] 
L3:     dup 
L4:     iconst_2 
L5:     invokespecial [35] 
L8:     astore_2 
L9:     aload_1 
L10:    invokeinterface [44] 0 
L15:    invokeinterface [45] 0 
L20:    astore_3 
L21:    aload_3 
L22:    invokeinterface [46] 0 
L27:    ifeq L87 
L30:    aload_3 
L31:    invokeinterface [47] 0 
L36:    checkcast [5] 
L39:    astore 4 
L41:    aload_1 
L42:    aload 4 
L44:    invokeinterface [48] 0 
L49:    checkcast [13] 
L52:    astore 5 
L54:    aload 5 
L56:    aload_0 
L57:    getfield [25] 
L60:    aload 4 
L62:    invokeinterface [48] 0 
L67:    invokevirtual [30] 
L70:    ifne L84 
L73:    aload_2 
L74:    aload 4 
L76:    aload 5 
L78:    invokeinterface [49] 0 
L83:    pop 
L84:    goto L21 
L87:    aload_0 
L88:    aload_1 
L89:    putfield [42] 
L92:    aload_0 
L93:    getfield [22] 
L96:    iconst_2 
L97:    aload_2 
L98:    invokeinterface [53] 0 
L103:   return 
L104:   
    .end code 
.end method 

.method public [254] : [255] 
    .attribute [247] .code stack 3 locals 4 
L0:     new [40] 
L3:     dup 
L4:     iconst_2 
L5:     invokespecial [35] 
L8:     astore_2 
L9:     aload_1 
L10:    invokeinterface [44] 0 
L15:    invokeinterface [45] 0 
L20:    astore_3 
L21:    aload_3 
L22:    invokeinterface [46] 0 
L27:    ifeq L87 
L30:    aload_3 
L31:    invokeinterface [47] 0 
L36:    checkcast [5] 
L39:    astore 4 
L41:    aload_1 
L42:    aload 4 
L44:    invokeinterface [48] 0 
L49:    checkcast [5] 
L52:    astore 5 
L54:    aload 5 
L56:    aload_0 
L57:    getfield [26] 
L60:    aload 4 
L62:    invokeinterface [48] 0 
L67:    invokevirtual [31] 
L70:    ifne L84 
L73:    aload_2 
L74:    aload 4 
L76:    aload 5 
L78:    invokeinterface [49] 0 
L83:    pop 
L84:    goto L21 
L87:    aload_0 
L88:    aload_1 
L89:    putfield [43] 
L92:    aload_0 
L93:    getfield [22] 
L96:    aload_2 
L97:    invokeinterface [54] 0 
L102:   return 
L103:   nop 
L104:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [55] 
.const [3] = String [56] 
.const [4] = Class [57] 
.const [5] = Class [58] 
.const [6] = Class [59] 
.const [7] = Int -2137614336 
.const [8] = String [60] 
.const [9] = String [61] 
.const [10] = Method [62] [63] 
.const [11] = String [64] 
.const [12] = Class [65] 
.const [13] = Class [66] 
.const [14] = Class [67] 
.const [15] = Class [68] 
.const [16] = Class [69] 
.const [17] = Class [70] 
.const [18] = Class [71] 
.const [19] = Class [72] 
.const [20] = Class [73] 
.const [21] = Class [74] 
.const [22] = Field [75] [76] 
.const [23] = Field [77] [78] 
.const [24] = Field [79] [80] 
.const [25] = Field [81] [82] 
.const [26] = Field [83] [84] 
.const [27] = Method [85] [86] 
.const [28] = Method [87] [88] 
.const [29] = Method [89] [90] 
.const [30] = Method [91] [92] 
.const [31] = Method [93] [94] 
.const [32] = Method [95] [96] 
.const [33] = Method [97] [98] 
.const [34] = Method [99] [100] 
.const [35] = Method [101] [102] 
.const [36] = Method [103] [104] 
.const [37] = Class [105] 
.const [38] = Field [106] [107] 
.const [39] = Field [108] [109] 
.const [40] = Class [110] 
.const [41] = Field [111] [112] 
.const [42] = Field [113] [114] 
.const [43] = Field [115] [116] 
.const [44] = InterfaceMethod [117] [118] 
.const [45] = InterfaceMethod [119] [120] 
.const [46] = InterfaceMethod [121] [122] 
.const [47] = InterfaceMethod [123] [124] 
.const [48] = InterfaceMethod [125] [126] 
.const [49] = InterfaceMethod [127] [128] 
.const [50] = InterfaceMethod [129] [130] 
.const [51] = Class [131] 
.const [52] = InterfaceMethod [132] [133] 
.const [53] = InterfaceMethod [134] [135] 
.const [54] = InterfaceMethod [136] [137] 
.const [55] = Utf8 java/lang/IllegalArgumentException 
.const [56] = Utf8 'Parameter cannot be null' 
.const [57] = Utf8 java/util/HashMap 
.const [58] = Utf8 java/lang/Integer 
.const [59] = Utf8 java/util/List 
.const [60] = Utf8 '[%1.updateSourceSlots] [%2] Changed' 
.const [61] = Utf8 MediaListSourceStateDiffer 
.const [62] = Class [138] 
.const [63] = NameAndType [139] [140] 
.const [64] = Utf8 '[%1.updateSourceSlots] [%2] Removed' 
.const [65] = Utf8 java/util/ArrayList 
.const [66] = Utf8 java/lang/Boolean 
.const [67] = Utf8 de/audi/app/media/source/state/providers/MediaListSourceStateDiffer 
.const [68] = Utf8 java/lang/Object 
.const [69] = Utf8 java/util/Map 
.const [70] = Utf8 java/util/Set 
.const [71] = Utf8 java/util/Iterator 
.const [72] = Utf8 de/audi/app/media/logger/LogUtil 
.const [73] = Utf8 de/audi/atip/log/LogChannel 
.const [74] = Utf8 de/audi/app/media/source/state/ISourceStateUpdater 
.const [75] = Class [141] 
.const [76] = NameAndType [142] [143] 
.const [77] = Class [144] 
.const [78] = NameAndType [145] [146] 
.const [79] = Class [147] 
.const [80] = NameAndType [148] [149] 
.const [81] = Class [150] 
.const [82] = NameAndType [151] [152] 
.const [83] = Class [153] 
.const [84] = NameAndType [154] [155] 
.const [85] = Class [156] 
.const [86] = NameAndType [157] [158] 
.const [87] = Class [159] 
.const [88] = NameAndType [160] [161] 
.const [89] = Class [162] 
.const [90] = NameAndType [163] [164] 
.const [91] = Class [165] 
.const [92] = NameAndType [166] [167] 
.const [93] = Class [168] 
.const [94] = NameAndType [169] [170] 
.const [95] = Class [171] 
.const [96] = NameAndType [172] [173] 
.const [97] = Class [174] 
.const [98] = NameAndType [175] [176] 
.const [99] = Class [177] 
.const [100] = NameAndType [178] [179] 
.const [101] = Class [180] 
.const [102] = NameAndType [181] [182] 
.const [103] = Class [183] 
.const [104] = NameAndType [184] [185] 
.const [105] = Utf8 java/lang/IllegalArgumentException 
.const [106] = Class [186] 
.const [107] = NameAndType [187] [188] 
.const [108] = Class [189] 
.const [109] = NameAndType [190] [191] 
.const [110] = Utf8 java/util/HashMap 
.const [111] = Class [192] 
.const [112] = NameAndType [193] [194] 
.const [113] = Class [195] 
.const [114] = NameAndType [196] [197] 
.const [115] = Class [198] 
.const [116] = NameAndType [199] [200] 
.const [117] = Class [201] 
.const [118] = NameAndType [202] [203] 
.const [119] = Class [204] 
.const [120] = NameAndType [205] [206] 
.const [121] = Class [207] 
.const [122] = NameAndType [208] [209] 
.const [123] = Class [210] 
.const [124] = NameAndType [211] [212] 
.const [125] = Class [213] 
.const [126] = NameAndType [214] [215] 
.const [127] = Class [216] 
.const [128] = NameAndType [217] [218] 
.const [129] = Class [219] 
.const [130] = NameAndType [220] [221] 
.const [131] = Utf8 java/util/ArrayList 
.const [132] = Class [222] 
.const [133] = NameAndType [223] [224] 
.const [134] = Class [225] 
.const [135] = NameAndType [226] [227] 
.const [136] = Class [228] 
.const [137] = NameAndType [229] [230] 
.const [138] = Utf8 de/audi/app/media/logger/LogUtil 
.const [139] = Utf8 getSourceTypeStr 
.const [140] = Utf8 (I)Ljava/lang/String; 
.const [141] = Utf8 de/audi/app/media/source/state/providers/MediaListSourceStateDiffer 
.const [142] = Utf8 sourceStateUpdater 
.const [143] = Utf8 Lde/audi/app/media/source/state/ISourceStateUpdater; 
.const [144] = Utf8 de/audi/app/media/source/state/providers/MediaListSourceStateDiffer 
.const [145] = Utf8 logger 
.const [146] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [147] = Utf8 de/audi/app/media/source/state/providers/MediaListSourceStateDiffer 
.const [148] = Utf8 lastSourcesSlotListMap 
.const [149] = Utf8 Ljava/util/Map; 
.const [150] = Utf8 de/audi/app/media/source/state/providers/MediaListSourceStateDiffer 
.const [151] = Utf8 lastSourceTypeToAvailability 
.const [152] = Utf8 Ljava/util/Map; 
.const [153] = Utf8 de/audi/app/media/source/state/providers/MediaListSourceStateDiffer 
.const [154] = Utf8 lastSourceTypeToNumberOfSlots 
.const [155] = Utf8 Ljava/util/Map; 
.const [156] = Utf8 java/lang/Object 
.const [157] = Utf8 equals 
.const [158] = Utf8 (Ljava/lang/Object;)Z 
.const [159] = Utf8 java/lang/Integer 
.const [160] = Utf8 intValue 
.const [161] = Utf8 ()I 
.const [162] = Utf8 de/audi/atip/log/LogChannel 
.const [163] = Utf8 log 
.const [164] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [165] = Utf8 java/lang/Boolean 
.const [166] = Utf8 equals 
.const [167] = Utf8 (Ljava/lang/Object;)Z 
.const [168] = Utf8 java/lang/Integer 
.const [169] = Utf8 equals 
.const [170] = Utf8 (Ljava/lang/Object;)Z 
.const [171] = Utf8 java/lang/Object 
.const [172] = Utf8 <init> 
.const [173] = Utf8 ()V 
.const [174] = Utf8 java/lang/IllegalArgumentException 
.const [175] = Utf8 <init> 
.const [176] = Utf8 (Ljava/lang/String;)V 
.const [177] = Utf8 java/util/HashMap 
.const [178] = Utf8 <init> 
.const [179] = Utf8 ()V 
.const [180] = Utf8 java/util/HashMap 
.const [181] = Utf8 <init> 
.const [182] = Utf8 (I)V 
.const [183] = Utf8 java/util/ArrayList 
.const [184] = Utf8 <init> 
.const [185] = Utf8 (I)V 
.const [186] = Utf8 de/audi/app/media/source/state/providers/MediaListSourceStateDiffer 
.const [187] = Utf8 sourceStateUpdater 
.const [188] = Utf8 Lde/audi/app/media/source/state/ISourceStateUpdater; 
.const [189] = Utf8 de/audi/app/media/source/state/providers/MediaListSourceStateDiffer 
.const [190] = Utf8 logger 
.const [191] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [192] = Utf8 de/audi/app/media/source/state/providers/MediaListSourceStateDiffer 
.const [193] = Utf8 lastSourcesSlotListMap 
.const [194] = Utf8 Ljava/util/Map; 
.const [195] = Utf8 de/audi/app/media/source/state/providers/MediaListSourceStateDiffer 
.const [196] = Utf8 lastSourceTypeToAvailability 
.const [197] = Utf8 Ljava/util/Map; 
.const [198] = Utf8 de/audi/app/media/source/state/providers/MediaListSourceStateDiffer 
.const [199] = Utf8 lastSourceTypeToNumberOfSlots 
.const [200] = Utf8 Ljava/util/Map; 
.const [201] = Utf8 java/util/Map 
.const [202] = Utf8 keySet 
.const [203] = Utf8 ()Ljava/util/Set; 
.const [204] = Utf8 java/util/Set 
.const [205] = Utf8 iterator 
.const [206] = Utf8 ()Ljava/util/Iterator; 
.const [207] = Utf8 java/util/Iterator 
.const [208] = Utf8 hasNext 
.const [209] = Utf8 ()Z 
.const [210] = Utf8 java/util/Iterator 
.const [211] = Utf8 next 
.const [212] = Utf8 ()Ljava/lang/Object; 
.const [213] = Utf8 java/util/Map 
.const [214] = Utf8 get 
.const [215] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [216] = Utf8 java/util/Map 
.const [217] = Utf8 put 
.const [218] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [219] = Utf8 java/util/Map 
.const [220] = Utf8 containsKey 
.const [221] = Utf8 (Ljava/lang/Object;)Z 
.const [222] = Utf8 de/audi/app/media/source/state/ISourceStateUpdater 
.const [223] = Utf8 updateSourceSlots 
.const [224] = Utf8 (Ljava/util/Map;)V 
.const [225] = Utf8 de/audi/app/media/source/state/ISourceStateUpdater 
.const [226] = Utf8 updateSourceAvailability 
.const [227] = Utf8 (ILjava/util/Map;)V 
.const [228] = Utf8 de/audi/app/media/source/state/ISourceStateUpdater 
.const [229] = Utf8 updateNumberOfSlots 
.const [230] = Utf8 (Ljava/util/Map;)V 
.const [231] = Utf8 de/audi/app/media/source/state/providers/MediaListSourceStateDiffer 
.const [232] = Class [231] 
.const [233] = Utf8 java/lang/Object 
.const [234] = Class [233] 
.const [235] = Utf8 LOGCLASS 
.const [236] = Utf8 Ljava/lang/String; 
.const [237] = Utf8 logger 
.const [238] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [239] = Utf8 sourceStateUpdater 
.const [240] = Utf8 Lde/audi/app/media/source/state/ISourceStateUpdater; 
.const [241] = Utf8 lastSourcesSlotListMap 
.const [242] = Utf8 Ljava/util/Map; 
.const [243] = Utf8 lastSourceTypeToAvailability 
.const [244] = Utf8 Ljava/util/Map; 
.const [245] = Utf8 lastSourceTypeToNumberOfSlots 
.const [246] = Utf8 Ljava/util/Map; 
.const [247] = Utf8 Code 
.const [248] = Utf8 <init> 
.const [249] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/app/media/source/state/ISourceStateUpdater;)V 
.const [250] = Utf8 updateSourceSlots 
.const [251] = Utf8 (Ljava/util/Map;)V 
.const [252] = Utf8 updateSourceAvailability 
.const [253] = Utf8 (Ljava/util/Map;)V 
.const [254] = Utf8 updateNumberOfSlots 
.const [255] = Utf8 (Ljava/util/Map;)V 
.end class 
