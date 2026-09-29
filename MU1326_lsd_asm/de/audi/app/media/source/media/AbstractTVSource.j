.version 50 0 
.class public super abstract [242] 
.super [244] 
.field private static final [245] [246] 
.field protected final [247] [248] 
.field private [249] [250] 
.field private [251] [252] 
.field private final [253] [254] 
.field private final [255] [256] 

.method public [258] : [259] 
    .attribute [257] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iload_3 
L3:     aload 4 
L5:     invokespecial [36] 
L8:     aload_0 
L9:     aload_1 
L10:    invokeinterface [40] 0 
L15:    invokeinterface [41] 0 
L20:    putfield [42] 
L23:    aload_0 
L24:    bipush 12 
L26:    invokevirtual [21] 
L29:    aload_0 
L30:    bipush 10 
L32:    invokevirtual [21] 
L35:    aload_0 
L36:    new [43] 
L39:    dup 
L40:    iconst_0 
L41:    invokespecial [37] 
L44:    putfield [44] 
L47:    aload_0 
L48:    aload 5 
L50:    putfield [45] 
L53:    aload_0 
L54:    aload_2 
L55:    putfield [46] 
L58:    return 
L59:    nop 
L60:    
    .end code 
.end method 

.method public abstract [260] : [261] 
    .attribute [257] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [262] : [263] 
    .attribute [257] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [264] : [265] 
    .attribute [257] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [266] : [267] 
    .attribute [257] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [25] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [268] : [269] 
    .attribute [257] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     ldc [5] 
L10:    invokevirtual [26] 
L13:    pop 
L14:    aload_0 
L15:    iconst_1 
L16:    invokevirtual [27] 
L19:    aload_0 
L20:    getfield [23] 
L23:    aload_1 
L24:    iconst_m1 
L25:    iconst_1 
L26:    invokeinterface [47] 0 
L31:    return 
L32:    
    .end code 
.end method 

.method public [270] : [271] 
    .attribute [257] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_2 
L2:     invokevirtual [27] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [272] : [273] 
    .attribute [257] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokevirtual [27] 
L5:     aconst_null 
L6:     aload_0 
L7:     getfield [28] 
L10:    if_acmpeq L22 
L13:    aload_0 
L14:    getfield [28] 
L17:    invokeinterface [49] 0 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public interface [274] : [275] 
    .attribute [257] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [276] : [277] 
    .attribute [257] .code stack 3 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     bipush 19 
L4:     invokevirtual [29] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [278] : [279] 
    .attribute [257] .code stack 4 locals 4 
L0:     bipush 10 
L2:     aload_1 
L3:     invokevirtual [30] 
L6:     if_icmpne L22 
L9:     aload_0 
L10:    aload_1 
L11:    invokevirtual [31] 
L14:    checkcast [6] 
L17:    putfield [48] 
L20:    iconst_1 
L21:    areturn 
L22:    iconst_1 
L23:    aload_1 
L24:    invokevirtual [30] 
L27:    if_icmpne L43 
L30:    aload_0 
L31:    aload_1 
L32:    invokevirtual [31] 
L35:    checkcast [7] 
L38:    putfield [44] 
L41:    iconst_1 
L42:    areturn 
L43:    bipush 12 
L45:    aload_1 
L46:    invokevirtual [30] 
L49:    if_icmpne L178 
L52:    aload_1 
L53:    invokevirtual [31] 
L56:    checkcast [8] 
L59:    invokevirtual [32] 
L62:    istore_2 
L63:    aload_0 
L64:    iload_2 
L65:    invokevirtual [33] 
L68:    aload_0 
L69:    invokevirtual [34] 
L72:    astore_3 
L73:    iload_2 
L74:    ifne L88 
L77:    aload_3 
L78:    invokeinterface [50] 0 
L83:    ifeq L88 
L86:    iconst_0 
L87:    areturn 
L88:    new [43] 
L91:    dup 
L92:    iconst_1 
L93:    invokespecial [37] 
L96:    astore 4 
L98:    iload_2 
L99:    ifeq L119 
L102:   aload 4 
L104:   aload_0 
L105:   iconst_3 
L106:   iconst_0 
L107:   invokevirtual [29] 
L110:   invokeinterface [51] 0 
L115:   pop 
L116:   goto L134 
L119:   aload 4 
L121:   aload_0 
L122:   iconst_0 
L123:   bipush 19 
L125:   invokevirtual [29] 
L128:   invokeinterface [51] 0 
L133:   pop 
L134:   new [52] 
L137:   dup 
L138:   iconst_1 
L139:   invokespecial [38] 
L142:   astore 5 
L144:   aload 5 
L146:   new [53] 
L149:   dup 
L150:   aload_0 
L151:   invokevirtual [35] 
L154:   invokespecial [39] 
L157:   aload 4 
L159:   invokeinterface [54] 0 
L164:   pop 
L165:   aload_0 
L166:   getfield [24] 
L169:   aload 5 
L171:   invokeinterface [55] 0 
L176:   iconst_1 
L177:   areturn 
L178:   iconst_0 
L179:   areturn 
L180:   
    .end code 
.end method 

.method protected abstract [280] : [281] 
    .attribute [257] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [56] 
.const [3] = Int 1078071040 
.const [4] = String [57] 
.const [5] = String [58] 
.const [6] = Class [59] 
.const [7] = Class [60] 
.const [8] = Class [61] 
.const [9] = Class [62] 
.const [10] = Class [63] 
.const [11] = Class [64] 
.const [12] = Class [65] 
.const [13] = Class [66] 
.const [14] = Class [67] 
.const [15] = Class [68] 
.const [16] = Class [69] 
.const [17] = Class [70] 
.const [18] = Class [71] 
.const [19] = Class [72] 
.const [20] = Field [73] [74] 
.const [21] = Method [75] [76] 
.const [22] = Field [77] [78] 
.const [23] = Field [79] [80] 
.const [24] = Field [81] [82] 
.const [25] = Method [83] [84] 
.const [26] = Method [85] [86] 
.const [27] = Method [87] [88] 
.const [28] = Field [89] [90] 
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
.const [40] = InterfaceMethod [113] [114] 
.const [41] = InterfaceMethod [115] [116] 
.const [42] = Field [117] [118] 
.const [43] = Class [119] 
.const [44] = Field [120] [121] 
.const [45] = Field [122] [123] 
.const [46] = Field [124] [125] 
.const [47] = InterfaceMethod [126] [127] 
.const [48] = Field [128] [129] 
.const [49] = InterfaceMethod [130] [131] 
.const [50] = InterfaceMethod [132] [133] 
.const [51] = InterfaceMethod [134] [135] 
.const [52] = Class [136] 
.const [53] = Class [137] 
.const [54] = InterfaceMethod [138] [139] 
.const [55] = InterfaceMethod [140] [141] 
.const [56] = Utf8 java/util/ArrayList 
.const [57] = Utf8 '[%1.activate]' 
.const [58] = Utf8 AbstractTVSource 
.const [59] = Utf8 de/audi/atip/interapp/tv/ITVService 
.const [60] = Utf8 java/util/List 
.const [61] = Utf8 java/lang/Boolean 
.const [62] = Utf8 java/util/HashMap 
.const [63] = Utf8 java/lang/Integer 
.const [64] = Utf8 de/audi/app/media/source/media/AbstractTVSource 
.const [65] = Utf8 de/audi/app/media/source/AbstractSource 
.const [66] = Utf8 de/audi/app/media/IMediaTerminal 
.const [67] = Utf8 de/audi/app/media/logger/IMediaLogger 
.const [68] = Utf8 de/audi/atip/log/LogChannel 
.const [69] = Utf8 de/audi/app/media/source/ISourceActivationCallbackHandler 
.const [70] = Utf8 de/audi/app/media/source/state/SourceStateUpdate 
.const [71] = Utf8 java/util/Map 
.const [72] = Utf8 de/audi/app/media/source/state/ISourceStateUpdater 
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
.const [119] = Utf8 java/util/ArrayList 
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
.const [130] = Class [226] 
.const [131] = NameAndType [227] [228] 
.const [132] = Class [229] 
.const [133] = NameAndType [230] [231] 
.const [134] = Class [232] 
.const [135] = NameAndType [233] [234] 
.const [136] = Utf8 java/util/HashMap 
.const [137] = Utf8 java/lang/Integer 
.const [138] = Class [235] 
.const [139] = NameAndType [236] [237] 
.const [140] = Class [238] 
.const [141] = NameAndType [239] [240] 
.const [142] = Utf8 de/audi/app/media/source/media/AbstractTVSource 
.const [143] = Utf8 logger 
.const [144] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [145] = Utf8 de/audi/app/media/source/media/AbstractTVSource 
.const [146] = Utf8 addUpdateType 
.const [147] = Utf8 (I)V 
.const [148] = Utf8 de/audi/app/media/source/media/AbstractTVSource 
.const [149] = Utf8 slotList 
.const [150] = Utf8 Ljava/util/List; 
.const [151] = Utf8 de/audi/app/media/source/media/AbstractTVSource 
.const [152] = Utf8 sourceActivationCallbackHandler 
.const [153] = Utf8 Lde/audi/app/media/source/ISourceActivationCallbackHandler; 
.const [154] = Utf8 de/audi/app/media/source/media/AbstractTVSource 
.const [155] = Utf8 updater 
.const [156] = Utf8 Lde/audi/app/media/source/state/ISourceStateUpdater; 
.const [157] = Utf8 de/audi/app/media/source/media/AbstractTVSource 
.const [158] = Utf8 isAvailable 
.const [159] = Utf8 ()Z 
.const [160] = Utf8 de/audi/atip/log/LogChannel 
.const [161] = Utf8 log 
.const [162] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [163] = Utf8 de/audi/app/media/source/media/AbstractTVSource 
.const [164] = Utf8 setActiveState 
.const [165] = Utf8 (I)V 
.const [166] = Utf8 de/audi/app/media/source/media/AbstractTVSource 
.const [167] = Utf8 tvService 
.const [168] = Utf8 Lde/audi/atip/interapp/tv/ITVService; 
.const [169] = Utf8 de/audi/app/media/source/media/AbstractTVSource 
.const [170] = Utf8 createSlot 
.const [171] = Utf8 (II)Lde/audi/app/media/source/MediaSourceSlot; 
.const [172] = Utf8 de/audi/app/media/source/state/SourceStateUpdate 
.const [173] = Utf8 getType 
.const [174] = Utf8 ()I 
.const [175] = Utf8 de/audi/app/media/source/state/SourceStateUpdate 
.const [176] = Utf8 getUpdate 
.const [177] = Utf8 ()Ljava/lang/Object; 
.const [178] = Utf8 java/lang/Boolean 
.const [179] = Utf8 booleanValue 
.const [180] = Utf8 ()Z 
.const [181] = Utf8 de/audi/app/media/source/media/AbstractTVSource 
.const [182] = Utf8 setAvailable 
.const [183] = Utf8 (Z)V 
.const [184] = Utf8 de/audi/app/media/source/media/AbstractTVSource 
.const [185] = Utf8 getSlots 
.const [186] = Utf8 ()Ljava/util/List; 
.const [187] = Utf8 de/audi/app/media/source/media/AbstractTVSource 
.const [188] = Utf8 getType 
.const [189] = Utf8 ()I 
.const [190] = Utf8 de/audi/app/media/source/AbstractSource 
.const [191] = Utf8 <init> 
.const [192] = Utf8 (Lde/audi/app/media/IMediaTerminal;ILjava/lang/String;)V 
.const [193] = Utf8 java/util/ArrayList 
.const [194] = Utf8 <init> 
.const [195] = Utf8 (I)V 
.const [196] = Utf8 java/util/HashMap 
.const [197] = Utf8 <init> 
.const [198] = Utf8 (I)V 
.const [199] = Utf8 java/lang/Integer 
.const [200] = Utf8 <init> 
.const [201] = Utf8 (I)V 
.const [202] = Utf8 de/audi/app/media/IMediaTerminal 
.const [203] = Utf8 getLogger 
.const [204] = Utf8 ()Lde/audi/app/media/logger/IMediaLogger; 
.const [205] = Utf8 de/audi/app/media/logger/IMediaLogger 
.const [206] = Utf8 main 
.const [207] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [208] = Utf8 de/audi/app/media/source/media/AbstractTVSource 
.const [209] = Utf8 logger 
.const [210] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [211] = Utf8 de/audi/app/media/source/media/AbstractTVSource 
.const [212] = Utf8 slotList 
.const [213] = Utf8 Ljava/util/List; 
.const [214] = Utf8 de/audi/app/media/source/media/AbstractTVSource 
.const [215] = Utf8 sourceActivationCallbackHandler 
.const [216] = Utf8 Lde/audi/app/media/source/ISourceActivationCallbackHandler; 
.const [217] = Utf8 de/audi/app/media/source/media/AbstractTVSource 
.const [218] = Utf8 updater 
.const [219] = Utf8 Lde/audi/app/media/source/state/ISourceStateUpdater; 
.const [220] = Utf8 de/audi/app/media/source/ISourceActivationCallbackHandler 
.const [221] = Utf8 sourceDeviceActivated 
.const [222] = Utf8 (Lde/audi/app/media/source/ISourceSlot;IZ)V 
.const [223] = Utf8 de/audi/app/media/source/media/AbstractTVSource 
.const [224] = Utf8 tvService 
.const [225] = Utf8 Lde/audi/atip/interapp/tv/ITVService; 
.const [226] = Utf8 de/audi/atip/interapp/tv/ITVService 
.const [227] = Utf8 deactivate 
.const [228] = Utf8 ()V 
.const [229] = Utf8 java/util/List 
.const [230] = Utf8 isEmpty 
.const [231] = Utf8 ()Z 
.const [232] = Utf8 java/util/List 
.const [233] = Utf8 add 
.const [234] = Utf8 (Ljava/lang/Object;)Z 
.const [235] = Utf8 java/util/Map 
.const [236] = Utf8 put 
.const [237] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [238] = Utf8 de/audi/app/media/source/state/ISourceStateUpdater 
.const [239] = Utf8 updateSourceSlots 
.const [240] = Utf8 (Ljava/util/Map;)V 
.const [241] = Utf8 de/audi/app/media/source/media/AbstractTVSource 
.const [242] = Class [241] 
.const [243] = Utf8 de/audi/app/media/source/AbstractSource 
.const [244] = Class [243] 
.const [245] = Utf8 LOGCLASS 
.const [246] = Utf8 Ljava/lang/String; 
.const [247] = Utf8 logger 
.const [248] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [249] = Utf8 tvService 
.const [250] = Utf8 Lde/audi/atip/interapp/tv/ITVService; 
.const [251] = Utf8 slotList 
.const [252] = Utf8 Ljava/util/List; 
.const [253] = Utf8 updater 
.const [254] = Utf8 Lde/audi/app/media/source/state/ISourceStateUpdater; 
.const [255] = Utf8 sourceActivationCallbackHandler 
.const [256] = Utf8 Lde/audi/app/media/source/ISourceActivationCallbackHandler; 
.const [257] = Utf8 Code 
.const [258] = Utf8 <init> 
.const [259] = Utf8 (Lde/audi/app/media/IMediaTerminal;Lde/audi/app/media/source/state/ISourceStateUpdater;ILjava/lang/String;Lde/audi/app/media/source/ISourceActivationCallbackHandler;)V 
.const [260] = Utf8 getExternalSourceType 
.const [261] = Utf8 ()I 
.const [262] = Utf8 pausePlaybackOnDeactivation 
.const [263] = Utf8 ()Z 
.const [264] = Utf8 getAudioConnection 
.const [265] = Utf8 (Lde/audi/app/media/source/ISourceSlot;)I 
.const [266] = Utf8 isActivateable 
.const [267] = Utf8 (Lde/audi/app/media/source/ISourceSlot;)Z 
.const [268] = Utf8 activate 
.const [269] = Utf8 (Lde/audi/app/media/source/ISourceSlot;)V 
.const [270] = Utf8 sourceActivated 
.const [271] = Utf8 (Lde/audi/app/media/source/ISourceSlot;)V 
.const [272] = Utf8 deactivateSourceDevice 
.const [273] = Utf8 ()V 
.const [274] = Utf8 getSlots 
.const [275] = Utf8 ()Ljava/util/List; 
.const [276] = Utf8 getDefaultEmptySlot 
.const [277] = Utf8 (I)Lde/audi/app/media/source/ISourceSlot; 
.const [278] = Utf8 processSourceStateUpdate 
.const [279] = Utf8 (Lde/audi/app/media/source/state/SourceStateUpdate;)Z 
.const [280] = Utf8 createSlot 
.const [281] = Utf8 (II)Lde/audi/app/media/source/MediaSourceSlot; 
.end class 
