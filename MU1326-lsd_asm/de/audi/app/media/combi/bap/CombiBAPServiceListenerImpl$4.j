.version 50 0 
.class super [268] 
.super [270] 
.field private final synthetic [271] [272] 
.field private final synthetic [273] [274] 
.field private final synthetic [275] [276] 
.field private final synthetic [277] [278] 

.method [280] : [281] 
    .attribute [279] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [50] 
L5:     aload_0 
L6:     iload_3 
L7:     putfield [51] 
L10:    aload_0 
L11:    iload 4 
L13:    putfield [52] 
L16:    aload_0 
L17:    iload 5 
L19:    putfield [53] 
L22:    aload_0 
L23:    aload_2 
L24:    invokespecial [48] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [282] : [283] 
    .attribute [279] .code stack 7 locals 7 
L0:     aload_0 
L1:     getfield [37] 
L4:     invokestatic [2] 
L7:     ldc [3] 
L9:     ldc [4] 
L11:    ldc [5] 
L13:    aload_0 
L14:    getfield [38] 
L17:    invokestatic [6] 
L20:    aload_0 
L21:    getfield [39] 
L24:    invokestatic [6] 
L27:    aload_0 
L28:    getfield [40] 
L31:    invokestatic [6] 
L34:    invokevirtual [41] 
L37:    aload_0 
L38:    getfield [38] 
L41:    invokestatic [7] 
L44:    istore_1 
L45:    aload_0 
L46:    getfield [37] 
L49:    invokestatic [2] 
L52:    ldc [8] 
L54:    ldc [9] 
L56:    ldc [5] 
L58:    iload_1 
L59:    i2l 
L60:    invokevirtual [42] 
L63:    pop 
L64:    iload_1 
L65:    iconst_m1 
L66:    if_icmpne L103 
L69:    aload_0 
L70:    getfield [37] 
L73:    invokestatic [2] 
L76:    ldc [10] 
L78:    ldc [11] 
L80:    ldc [5] 
L82:    aload_0 
L83:    getfield [38] 
L86:    i2l 
L87:    invokevirtual [42] 
L90:    pop 
L91:    aload_0 
L92:    getfield [37] 
L95:    invokestatic [12] 
L98:    iconst_0 
L99:    invokevirtual [43] 
L102:   return 
L103:   aload_0 
L104:   getfield [37] 
L107:   invokevirtual [44] 
L110:   invokeinterface [54] 0 
L115:   astore_2 
L116:   aload_2 
L117:   invokeinterface [55] 0 
L122:   astore_3 
L123:   aload_3 
L124:   ifnull L176 
L127:   aload_3 
L128:   invokeinterface [56] 0 
L133:   invokeinterface [57] 0 
L138:   iconst_4 
L139:   if_icmpne L176 
L142:   aload_0 
L143:   getfield [37] 
L146:   invokestatic [13] 
L149:   invokeinterface [58] 0 
L154:   ldc [3] 
L156:   ldc [14] 
L158:   ldc [5] 
L160:   invokevirtual [45] 
L163:   pop 
L164:   aload_0 
L165:   getfield [37] 
L168:   invokestatic [12] 
L171:   iconst_0 
L172:   invokevirtual [43] 
L175:   return 
L176:   aload_2 
L177:   iload_1 
L178:   invokeinterface [59] 0 
L183:   astore 4 
L185:   aload 4 
L187:   ifnonnull L222 
L190:   aload_0 
L191:   getfield [37] 
L194:   invokestatic [2] 
L197:   ldc [10] 
L199:   ldc [15] 
L201:   ldc [5] 
L203:   iload_1 
L204:   invokestatic [16] 
L207:   invokevirtual [46] 
L210:   aload_0 
L211:   getfield [37] 
L214:   invokestatic [12] 
L217:   iconst_0 
L218:   invokevirtual [43] 
L221:   return 
L222:   aload 4 
L224:   aload_0 
L225:   getfield [39] 
L228:   aload_0 
L229:   getfield [40] 
L232:   invokeinterface [60] 0 
L237:   istore 5 
L239:   new [61] 
L242:   dup 
L243:   aload 4 
L245:   iload 5 
L247:   invokeinterface [62] 0 
L252:   invokespecial [49] 
L255:   astore 6 
L257:   aload 6 
L259:   ldc [18] 
L261:   getstatic [19] 
L264:   invokevirtual [47] 
L267:   aload 6 
L269:   ldc [20] 
L271:   getstatic [19] 
L274:   invokevirtual [47] 
L277:   aload_0 
L278:   getfield [37] 
L281:   invokevirtual [44] 
L284:   invokeinterface [54] 0 
L289:   aload 6 
L291:   invokeinterface [63] 0 
L296:   istore 7 
L298:   iload 7 
L300:   iconst_1 
L301:   if_icmpeq L339 
L304:   iload 7 
L306:   iconst_2 
L307:   if_icmpeq L339 
L310:   aload_0 
L311:   getfield [37] 
L314:   invokestatic [2] 
L317:   ldc [3] 
L319:   ldc [21] 
L321:   ldc [5] 
L323:   invokevirtual [45] 
L326:   pop 
L327:   aload_0 
L328:   getfield [37] 
L331:   invokestatic [12] 
L334:   iconst_0 
L335:   invokevirtual [43] 
L338:   return 
L339:   aload_0 
L340:   getfield [37] 
L343:   invokevirtual [44] 
L346:   invokeinterface [64] 0 
L351:   invokeinterface [65] 0 
L356:   aload_0 
L357:   getfield [37] 
L360:   invokestatic [12] 
L363:   iconst_1 
L364:   invokevirtual [43] 
L367:   return 
L368:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [66] [67] 
.const [3] = Int 1078071040 
.const [4] = String [68] 
.const [5] = String [69] 
.const [6] = Method [70] [71] 
.const [7] = Method [72] [73] 
.const [8] = Int -2137614336 
.const [9] = String [74] 
.const [10] = Int -1601830656 
.const [11] = String [75] 
.const [12] = Method [76] [77] 
.const [13] = Method [78] [79] 
.const [14] = String [80] 
.const [15] = String [81] 
.const [16] = Method [82] [83] 
.const [17] = Class [84] 
.const [18] = String [85] 
.const [19] = Field [86] [87] 
.const [20] = String [88] 
.const [21] = String [89] 
.const [22] = Class [90] 
.const [23] = Class [91] 
.const [24] = Class [92] 
.const [25] = Class [93] 
.const [26] = Class [94] 
.const [27] = Class [95] 
.const [28] = Class [96] 
.const [29] = Class [97] 
.const [30] = Class [98] 
.const [31] = Class [99] 
.const [32] = Class [100] 
.const [33] = Class [101] 
.const [34] = Class [102] 
.const [35] = Class [103] 
.const [36] = Class [104] 
.const [37] = Field [105] [106] 
.const [38] = Field [107] [108] 
.const [39] = Field [109] [110] 
.const [40] = Field [111] [112] 
.const [41] = Method [113] [114] 
.const [42] = Method [115] [116] 
.const [43] = Method [117] [118] 
.const [44] = Method [119] [120] 
.const [45] = Method [121] [122] 
.const [46] = Method [123] [124] 
.const [47] = Method [125] [126] 
.const [48] = Method [127] [128] 
.const [49] = Method [129] [130] 
.const [50] = Field [131] [132] 
.const [51] = Field [133] [134] 
.const [52] = Field [135] [136] 
.const [53] = Field [137] [138] 
.const [54] = InterfaceMethod [139] [140] 
.const [55] = InterfaceMethod [141] [142] 
.const [56] = InterfaceMethod [143] [144] 
.const [57] = InterfaceMethod [145] [146] 
.const [58] = InterfaceMethod [147] [148] 
.const [59] = InterfaceMethod [149] [150] 
.const [60] = InterfaceMethod [151] [152] 
.const [61] = Class [153] 
.const [62] = InterfaceMethod [154] [155] 
.const [63] = InterfaceMethod [156] [157] 
.const [64] = InterfaceMethod [158] [159] 
.const [65] = InterfaceMethod [160] [161] 
.const [66] = Class [162] 
.const [67] = NameAndType [163] [164] 
.const [68] = Utf8 "[%1.switchSource] sourceType='%2',slotNumber='%3', partitionNumber='%4'." 
.const [69] = Utf8 CombiBAPServiceListenerImpl 
.const [70] = Class [165] 
.const [71] = NameAndType [166] [167] 
.const [72] = Class [168] 
.const [73] = NameAndType [169] [170] 
.const [74] = Utf8 "[%1.switchSource] mediaSourceType='%2'." 
.const [75] = Utf8 "[%1.switchSource] No source type found for '%2'." 
.const [76] = Class [171] 
.const [77] = NameAndType [172] [173] 
.const [78] = Class [174] 
.const [79] = NameAndType [175] [176] 
.const [80] = Utf8 '[%1.onSwitchSource] FilePlayer currently active. Ingore.' 
.const [81] = Utf8 '[%1.switchSource] [%2] Not supported' 
.const [82] = Class [177] 
.const [83] = NameAndType [178] [179] 
.const [84] = Utf8 de/audi/app/media/source/ActivationContext 
.const [85] = Utf8 CLOSE_DRAWER 
.const [86] = Class [180] 
.const [87] = NameAndType [181] [182] 
.const [88] = Utf8 REQUEST_AUDIO_IN_ADVANCE 
.const [89] = Utf8 '[%1.onSwitchSource] Source activation failed.' 
.const [90] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$4 
.const [91] = Utf8 de/audi/app/media/AbstractDispatcherRunnable 
.const [92] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl 
.const [93] = Utf8 java/lang/Integer 
.const [94] = Utf8 de/audi/atip/log/LogChannel 
.const [95] = Utf8 de/audi/app/media/combi/bap/CombiBAPUtils 
.const [96] = Utf8 de/audi/app/media/combi/bap/CombiBAPController 
.const [97] = Utf8 de/audi/app/media/IMediaTerminal 
.const [98] = Utf8 de/audi/app/media/source/ISourceController 
.const [99] = Utf8 de/audi/app/media/source/ISourceSlot 
.const [100] = Utf8 de/audi/app/media/source/ISource 
.const [101] = Utf8 de/audi/app/media/logger/IMediaLogger 
.const [102] = Utf8 de/audi/app/media/logger/LogUtil 
.const [103] = Utf8 java/lang/Boolean 
.const [104] = Utf8 de/audi/app/media/audio/IAudioManager 
.const [105] = Class [183] 
.const [106] = NameAndType [184] [185] 
.const [107] = Class [186] 
.const [108] = NameAndType [187] [188] 
.const [109] = Class [189] 
.const [110] = NameAndType [190] [191] 
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
.const [131] = Class [222] 
.const [132] = NameAndType [223] [224] 
.const [133] = Class [225] 
.const [134] = NameAndType [226] [227] 
.const [135] = Class [228] 
.const [136] = NameAndType [229] [230] 
.const [137] = Class [231] 
.const [138] = NameAndType [232] [233] 
.const [139] = Class [234] 
.const [140] = NameAndType [235] [236] 
.const [141] = Class [237] 
.const [142] = NameAndType [238] [239] 
.const [143] = Class [240] 
.const [144] = NameAndType [241] [242] 
.const [145] = Class [243] 
.const [146] = NameAndType [244] [245] 
.const [147] = Class [246] 
.const [148] = NameAndType [247] [248] 
.const [149] = Class [249] 
.const [150] = NameAndType [250] [251] 
.const [151] = Class [252] 
.const [152] = NameAndType [253] [254] 
.const [153] = Utf8 de/audi/app/media/source/ActivationContext 
.const [154] = Class [255] 
.const [155] = NameAndType [256] [257] 
.const [156] = Class [258] 
.const [157] = NameAndType [259] [260] 
.const [158] = Class [261] 
.const [159] = NameAndType [262] [263] 
.const [160] = Class [264] 
.const [161] = NameAndType [265] [266] 
.const [162] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl 
.const [163] = Utf8 access$000 
.const [164] = Utf8 (Lde/audi/app/media/combi/bap/CombiBAPServiceListenerImpl;)Lde/audi/atip/log/LogChannel; 
.const [165] = Utf8 java/lang/Integer 
.const [166] = Utf8 toString 
.const [167] = Utf8 (I)Ljava/lang/String; 
.const [168] = Utf8 de/audi/app/media/combi/bap/CombiBAPUtils 
.const [169] = Utf8 getMediaSourceTypeOfCombiSourceType 
.const [170] = Utf8 (I)I 
.const [171] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl 
.const [172] = Utf8 access$100 
.const [173] = Utf8 (Lde/audi/app/media/combi/bap/CombiBAPServiceListenerImpl;)Lde/audi/app/media/combi/bap/CombiBAPController; 
.const [174] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl 
.const [175] = Utf8 access$200 
.const [176] = Utf8 (Lde/audi/app/media/combi/bap/CombiBAPServiceListenerImpl;)Lde/audi/app/media/logger/IMediaLogger; 
.const [177] = Utf8 de/audi/app/media/logger/LogUtil 
.const [178] = Utf8 getSourceTypeStr 
.const [179] = Utf8 (I)Ljava/lang/String; 
.const [180] = Utf8 java/lang/Boolean 
.const [181] = Utf8 TRUE 
.const [182] = Utf8 Ljava/lang/Boolean; 
.const [183] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$4 
.const [184] = Utf8 this$0 
.const [185] = Utf8 Lde/audi/app/media/combi/bap/CombiBAPServiceListenerImpl; 
.const [186] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$4 
.const [187] = Utf8 val$pCombiSourceType 
.const [188] = Utf8 I 
.const [189] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$4 
.const [190] = Utf8 val$slotNumber 
.const [191] = Utf8 I 
.const [192] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$4 
.const [193] = Utf8 val$partitionNumber 
.const [194] = Utf8 I 
.const [195] = Utf8 de/audi/atip/log/LogChannel 
.const [196] = Utf8 log 
.const [197] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [198] = Utf8 de/audi/atip/log/LogChannel 
.const [199] = Utf8 log 
.const [200] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [201] = Utf8 de/audi/app/media/combi/bap/CombiBAPController 
.const [202] = Utf8 switchSourceResult 
.const [203] = Utf8 (Z)V 
.const [204] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl 
.const [205] = Utf8 getTerminal 
.const [206] = Utf8 ()Lde/audi/app/media/IMediaTerminal; 
.const [207] = Utf8 de/audi/atip/log/LogChannel 
.const [208] = Utf8 log 
.const [209] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [210] = Utf8 de/audi/atip/log/LogChannel 
.const [211] = Utf8 log 
.const [212] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [213] = Utf8 de/audi/app/media/source/ActivationContext 
.const [214] = Utf8 addParameter 
.const [215] = Utf8 (Ljava/lang/String;Ljava/lang/Object;)V 
.const [216] = Utf8 de/audi/app/media/AbstractDispatcherRunnable 
.const [217] = Utf8 <init> 
.const [218] = Utf8 (Ljava/lang/String;)V 
.const [219] = Utf8 de/audi/app/media/source/ActivationContext 
.const [220] = Utf8 <init> 
.const [221] = Utf8 (Lde/audi/app/media/source/ISourceSlot;)V 
.const [222] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$4 
.const [223] = Utf8 this$0 
.const [224] = Utf8 Lde/audi/app/media/combi/bap/CombiBAPServiceListenerImpl; 
.const [225] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$4 
.const [226] = Utf8 val$pCombiSourceType 
.const [227] = Utf8 I 
.const [228] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$4 
.const [229] = Utf8 val$slotNumber 
.const [230] = Utf8 I 
.const [231] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$4 
.const [232] = Utf8 val$partitionNumber 
.const [233] = Utf8 I 
.const [234] = Utf8 de/audi/app/media/IMediaTerminal 
.const [235] = Utf8 getSourceController 
.const [236] = Utf8 ()Lde/audi/app/media/source/ISourceController; 
.const [237] = Utf8 de/audi/app/media/source/ISourceController 
.const [238] = Utf8 getSelectedSlot 
.const [239] = Utf8 ()Lde/audi/app/media/source/ISourceSlot; 
.const [240] = Utf8 de/audi/app/media/source/ISourceSlot 
.const [241] = Utf8 getSource 
.const [242] = Utf8 ()Lde/audi/app/media/source/ISource; 
.const [243] = Utf8 de/audi/app/media/source/ISource 
.const [244] = Utf8 getType 
.const [245] = Utf8 ()I 
.const [246] = Utf8 de/audi/app/media/logger/IMediaLogger 
.const [247] = Utf8 hmi 
.const [248] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [249] = Utf8 de/audi/app/media/source/ISourceController 
.const [250] = Utf8 getSource 
.const [251] = Utf8 (I)Lde/audi/app/media/source/ISource; 
.const [252] = Utf8 de/audi/app/media/source/ISource 
.const [253] = Utf8 getSlotNumberByPartition 
.const [254] = Utf8 (II)I 
.const [255] = Utf8 de/audi/app/media/source/ISource 
.const [256] = Utf8 getSlot 
.const [257] = Utf8 (I)Lde/audi/app/media/source/ISourceSlot; 
.const [258] = Utf8 de/audi/app/media/source/ISourceController 
.const [259] = Utf8 activateSource 
.const [260] = Utf8 (Lde/audi/app/media/source/IActivationContext;)I 
.const [261] = Utf8 de/audi/app/media/IMediaTerminal 
.const [262] = Utf8 getAudioManager 
.const [263] = Utf8 ()Lde/audi/app/media/audio/IAudioManager; 
.const [264] = Utf8 de/audi/app/media/audio/IAudioManager 
.const [265] = Utf8 requestAudioFocus 
.const [266] = Utf8 ()V 
.const [267] = Utf8 de/audi/app/media/combi/bap/CombiBAPServiceListenerImpl$4 
.const [268] = Class [267] 
.const [269] = Utf8 de/audi/app/media/AbstractDispatcherRunnable 
.const [270] = Class [269] 
.const [271] = Utf8 val$pCombiSourceType 
.const [272] = Utf8 I 
.const [273] = Utf8 val$slotNumber 
.const [274] = Utf8 I 
.const [275] = Utf8 val$partitionNumber 
.const [276] = Utf8 I 
.const [277] = Utf8 this$0 
.const [278] = Utf8 Lde/audi/app/media/combi/bap/CombiBAPServiceListenerImpl; 
.const [279] = Utf8 Code 
.const [280] = Utf8 <init> 
.const [281] = Utf8 (Lde/audi/app/media/combi/bap/CombiBAPServiceListenerImpl;Ljava/lang/String;III)V 
.const [282] = Utf8 run 
.const [283] = Utf8 ()V 
.end class 
