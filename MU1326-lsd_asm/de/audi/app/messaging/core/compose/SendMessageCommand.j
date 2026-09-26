.version 50 0 
.class final super [312] 
.super [314] 
.field private final [315] [316] 
.field private final [317] [318] 
.field private final [319] [320] 
.field private final [321] [322] 
.field private final [323] [324] 
.field private final [325] [326] 
.field private [327] [328] 
.field private final [329] [330] 
.field private volatile [331] [332] 
.field private volatile [333] [334] 
.field private volatile [335] [336] 

.method [338] : [339] 
    .attribute [337] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [52] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [57] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [58] 
L15:    aload_0 
L16:    aconst_null 
L17:    putfield [59] 
L20:    aload_0 
L21:    aload_2 
L22:    invokevirtual [29] 
L25:    aload_0 
L26:    iload 4 
L28:    putfield [60] 
L31:    aload_0 
L32:    aload_3 
L33:    putfield [61] 
L36:    aload_0 
L37:    iload 5 
L39:    putfield [62] 
L42:    aload_0 
L43:    aload 6 
L45:    putfield [63] 
L48:    aload_0 
L49:    aload 7 
L51:    putfield [64] 
L54:    aload_0 
L55:    aload 8 
L57:    putfield [65] 
L60:    aload_0 
L61:    aload 9 
L63:    putfield [66] 
L66:    aload_0 
L67:    iload 10 
L69:    putfield [67] 
L72:    return 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public interface [340] : [341] 
    .attribute [337] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [342] : [343] 
    .attribute [337] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [344] : [345] 
    .attribute [337] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [346] : [347] 
    .attribute [337] .code stack 2 locals 0 
L0:     ldc_w [1] 
L3:     freturn 
L4:     
    .end code 
.end method 

.method protected [348] : [349] 
    .attribute [337] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [39] 
L11:    pop 
L12:    aload_0 
L13:    getfield [26] 
L16:    ifeq L27 
L19:    aload_0 
L20:    iconst_1 
L21:    invokevirtual [40] 
L24:    goto L41 
L27:    aload_0 
L28:    new [68] 
L31:    dup 
L32:    aload_0 
L33:    ldc [5] 
L35:    invokespecial [53] 
L38:    invokevirtual [41] 
L41:    aconst_null 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [350] : [351] 
    .attribute [337] .code stack 1 locals 0 
L0:     aconst_null 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [352] : [353] 
    .attribute [337] .code stack 8 locals 1 
        .catch [8] from L0 to L47 using L50 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [6] 
L6:     ldc [7] 
L8:     invokevirtual [39] 
L11:    pop 
L12:    aload_0 
L13:    getfield [42] 
L16:    aload_0 
L17:    getfield [30] 
L20:    aload_0 
L21:    getfield [32] 
L24:    aload_0 
L25:    getfield [33] 
L28:    aload_0 
L29:    getfield [34] 
L32:    aload_0 
L33:    getfield [35] 
L36:    aload_0 
L37:    getfield [36] 
L40:    aload_0 
L41:    getfield [37] 
L44:    invokevirtual [43] 
L47:    goto L63 
L50:    astore_1 
L51:    aload_0 
L52:    ldc [7] 
L54:    aload_1 
L55:    invokevirtual [44] 
L58:    aload_0 
L59:    aload_1 
L60:    invokevirtual [41] 
L63:    return 
L64:    
    .end code 
.end method 

.method public [354] : [355] 
    .attribute [337] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [6] 
L6:     ldc [9] 
L8:     iload_1 
L9:     i2l 
L10:    iload_2 
L11:    i2l 
L12:    invokevirtual [45] 
L15:    pop 
L16:    aload_0 
L17:    iload_1 
L18:    putfield [58] 
L21:    aload_0 
L22:    iconst_1 
L23:    putfield [57] 
L26:    aload_0 
L27:    iconst_0 
L28:    invokevirtual [40] 
L31:    return 
L32:    
    .end code 
.end method 

.method public [356] : [357] 
    .attribute [337] .code stack 9 locals 0 
L0:     iload_2 
L1:     aload_0 
L2:     getfield [30] 
L5:     if_icmpne L21 
L8:     aload_0 
L9:     aload_1 
L10:    putfield [59] 
L13:    aload_0 
L14:    iconst_0 
L15:    invokevirtual [40] 
L18:    goto L38 
L21:    aload_0 
L22:    aload_1 
L23:    iload_2 
L24:    iload_3 
L25:    aload 4 
L27:    aload 5 
L29:    aload 6 
L31:    aload 7 
L33:    iload 8 
L35:    invokespecial [54] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [358] : [359] 
    .attribute [337] .code stack 7 locals 5 
L0:     aload_0 
L1:     getfield [27] 
L4:     ifeq L11 
L7:     iconst_1 
L8:     goto L12 
L11:    iconst_0 
L12:    istore_2 
L13:    aload_0 
L14:    getfield [28] 
L17:    ifnull L24 
L20:    iconst_1 
L21:    goto L25 
L24:    iconst_0 
L25:    istore_3 
L26:    aload_0 
L27:    getfield [26] 
L30:    ifeq L45 
L33:    iload_2 
L34:    ifne L41 
L37:    iload_3 
L38:    ifeq L45 
L41:    iconst_1 
L42:    goto L46 
L45:    iconst_0 
L46:    istore 4 
L48:    iload_1 
L49:    ifne L57 
L52:    iload 4 
L54:    ifeq L61 
L57:    iconst_1 
L58:    goto L62 
L61:    iconst_0 
L62:    istore 5 
L64:    aload_0 
L65:    getfield [38] 
L68:    invokevirtual [46] 
L71:    ifeq L217 
L74:    new [69] 
L77:    dup 
L78:    invokespecial [55] 
L81:    astore 6 
L83:    aload 6 
L85:    ldc [11] 
L87:    invokevirtual [47] 
L90:    pop 
L91:    aload 6 
L93:    ldc [12] 
L95:    invokevirtual [47] 
L98:    iload_1 
L99:    invokevirtual [48] 
L102:   ldc [13] 
L104:   invokevirtual [47] 
L107:   pop 
L108:   aload 6 
L110:   ldc [14] 
L112:   invokevirtual [47] 
L115:   aload_0 
L116:   getfield [26] 
L119:   invokevirtual [48] 
L122:   ldc [13] 
L124:   invokevirtual [47] 
L127:   pop 
L128:   aload 6 
L130:   ldc [15] 
L132:   invokevirtual [47] 
L135:   aload_0 
L136:   getfield [27] 
L139:   invokevirtual [49] 
L142:   ldc [13] 
L144:   invokevirtual [47] 
L147:   pop 
L148:   aload 6 
L150:   ldc [16] 
L152:   invokevirtual [47] 
L155:   aload_0 
L156:   getfield [28] 
L159:   invokestatic [17] 
L162:   invokevirtual [47] 
L165:   ldc [13] 
L167:   invokevirtual [47] 
L170:   pop 
L171:   aload 6 
L173:   ldc [18] 
L175:   invokevirtual [47] 
L178:   iload 4 
L180:   invokevirtual [48] 
L183:   ldc [13] 
L185:   invokevirtual [47] 
L188:   pop 
L189:   aload 6 
L191:   ldc [19] 
L193:   invokevirtual [47] 
L196:   iload 5 
L198:   invokevirtual [48] 
L201:   pop 
L202:   aload_0 
L203:   getfield [38] 
L206:   ldc [6] 
L208:   aload 6 
L210:   invokevirtual [50] 
L213:   invokevirtual [39] 
L216:   pop 
L217:   iload 5 
L219:   ifeq L243 
L222:   aload_0 
L223:   new [70] 
L226:   dup 
L227:   aload_0 
L228:   aload_0 
L229:   getfield [27] 
L232:   aload_0 
L233:   getfield [28] 
L236:   aconst_null 
L237:   invokespecial [56] 
L240:   invokevirtual [51] 
L243:   return 
L244:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [72] 
.const [4] = Class [73] 
.const [5] = String [74] 
.const [6] = Int -2137614336 
.const [7] = String [75] 
.const [8] = Class [76] 
.const [9] = String [77] 
.const [10] = Class [78] 
.const [11] = String [79] 
.const [12] = String [80] 
.const [13] = String [81] 
.const [14] = String [82] 
.const [15] = String [83] 
.const [16] = String [84] 
.const [17] = Method [85] [86] 
.const [18] = String [87] 
.const [19] = String [88] 
.const [20] = Class [89] 
.const [21] = Class [90] 
.const [22] = Class [91] 
.const [23] = Class [92] 
.const [24] = Class [93] 
.const [25] = Class [94] 
.const [26] = Field [95] [96] 
.const [27] = Field [97] [98] 
.const [28] = Field [99] [100] 
.const [29] = Method [101] [102] 
.const [30] = Field [103] [104] 
.const [31] = Field [105] [106] 
.const [32] = Field [107] [108] 
.const [33] = Field [109] [110] 
.const [34] = Field [111] [112] 
.const [35] = Field [113] [114] 
.const [36] = Field [115] [116] 
.const [37] = Field [117] [118] 
.const [38] = Field [119] [120] 
.const [39] = Method [121] [122] 
.const [40] = Method [123] [124] 
.const [41] = Method [125] [126] 
.const [42] = Field [127] [128] 
.const [43] = Method [129] [130] 
.const [44] = Method [131] [132] 
.const [45] = Method [133] [134] 
.const [46] = Method [135] [136] 
.const [47] = Method [137] [138] 
.const [48] = Method [139] [140] 
.const [49] = Method [141] [142] 
.const [50] = Method [143] [144] 
.const [51] = Method [145] [146] 
.const [52] = Method [147] [148] 
.const [53] = Method [149] [150] 
.const [54] = Method [151] [152] 
.const [55] = Method [153] [154] 
.const [56] = Method [155] [156] 
.const [57] = Field [157] [158] 
.const [58] = Field [159] [160] 
.const [59] = Field [161] [162] 
.const [60] = Field [163] [164] 
.const [61] = Field [165] [166] 
.const [62] = Field [167] [168] 
.const [63] = Field [169] [170] 
.const [64] = Field [171] [172] 
.const [65] = Field [173] [174] 
.const [66] = Field [175] [176] 
.const [67] = Field [177] [178] 
.const [68] = Class [179] 
.const [69] = Class [180] 
.const [70] = Class [181] 
.const [71] = Int -386072576 
.const [72] = Utf8 '[SendMessageCommand#canceled]' 
.const [73] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand$SendMessageCommandStoppedBeforeDSIResponseException 
.const [74] = Utf8 'Command list canceled before a response was received.' 
.const [75] = Utf8 '[SendMessageCommand#execute]' 
.const [76] = Utf8 java/lang/Exception 
.const [77] = Utf8 '[SendMessageCommand#sendMessageResponse] result = %1, requestId = %2' 
.const [78] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [79] = Utf8 '[SendMessageCommand#setResultIfDone] ' 
.const [80] = Utf8 'terminateUnconditionally = ' 
.const [81] = Utf8 ', ' 
.const [82] = Utf8 'hasResponse = ' 
.const [83] = Utf8 'resultCode = ' 
.const [84] = Utf8 'indicationResultCodes = ' 
.const [85] = Class [182] 
.const [86] = NameAndType [183] [184] 
.const [87] = Utf8 'isDone = ' 
.const [88] = Utf8 'terminate = ' 
.const [89] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand$Result 
.const [90] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [91] = Utf8 de/audi/app/messaging/core/dsi/messaging/AbstractDsiMessagingCommand 
.const [92] = Utf8 de/audi/atip/log/LogChannel 
.const [93] = Utf8 de/audi/app/messaging/core/dsi/messaging/DsiMessagingAccess 
.const [94] = Utf8 de/audi/app/messaging/core/util/Arrays 
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
.const [113] = Class [212] 
.const [114] = NameAndType [213] [214] 
.const [115] = Class [215] 
.const [116] = NameAndType [216] [217] 
.const [117] = Class [218] 
.const [118] = NameAndType [219] [220] 
.const [119] = Class [221] 
.const [120] = NameAndType [222] [223] 
.const [121] = Class [224] 
.const [122] = NameAndType [225] [226] 
.const [123] = Class [227] 
.const [124] = NameAndType [228] [229] 
.const [125] = Class [230] 
.const [126] = NameAndType [231] [232] 
.const [127] = Class [233] 
.const [128] = NameAndType [234] [235] 
.const [129] = Class [236] 
.const [130] = NameAndType [237] [238] 
.const [131] = Class [239] 
.const [132] = NameAndType [240] [241] 
.const [133] = Class [242] 
.const [134] = NameAndType [243] [244] 
.const [135] = Class [245] 
.const [136] = NameAndType [246] [247] 
.const [137] = Class [248] 
.const [138] = NameAndType [249] [250] 
.const [139] = Class [251] 
.const [140] = NameAndType [252] [253] 
.const [141] = Class [254] 
.const [142] = NameAndType [255] [256] 
.const [143] = Class [257] 
.const [144] = NameAndType [258] [259] 
.const [145] = Class [260] 
.const [146] = NameAndType [261] [262] 
.const [147] = Class [263] 
.const [148] = NameAndType [264] [265] 
.const [149] = Class [266] 
.const [150] = NameAndType [267] [268] 
.const [151] = Class [269] 
.const [152] = NameAndType [270] [271] 
.const [153] = Class [272] 
.const [154] = NameAndType [273] [274] 
.const [155] = Class [275] 
.const [156] = NameAndType [276] [277] 
.const [157] = Class [278] 
.const [158] = NameAndType [279] [280] 
.const [159] = Class [281] 
.const [160] = NameAndType [282] [283] 
.const [161] = Class [284] 
.const [162] = NameAndType [285] [286] 
.const [163] = Class [287] 
.const [164] = NameAndType [288] [289] 
.const [165] = Class [290] 
.const [166] = NameAndType [291] [292] 
.const [167] = Class [293] 
.const [168] = NameAndType [294] [295] 
.const [169] = Class [296] 
.const [170] = NameAndType [297] [298] 
.const [171] = Class [299] 
.const [172] = NameAndType [300] [301] 
.const [173] = Class [302] 
.const [174] = NameAndType [303] [304] 
.const [175] = Class [305] 
.const [176] = NameAndType [306] [307] 
.const [177] = Class [308] 
.const [178] = NameAndType [309] [310] 
.const [179] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand$SendMessageCommandStoppedBeforeDSIResponseException 
.const [180] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [181] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand$Result 
.const [182] = Utf8 de/audi/app/messaging/core/util/Arrays 
.const [183] = Utf8 toString 
.const [184] = Utf8 ([I)Ljava/lang/String; 
.const [185] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [186] = Utf8 hasResponse 
.const [187] = Utf8 Z 
.const [188] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [189] = Utf8 resultCode 
.const [190] = Utf8 I 
.const [191] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [192] = Utf8 indicationResultCodes 
.const [193] = Utf8 [I 
.const [194] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [195] = Utf8 setCommandCallback 
.const [196] = Utf8 (Lde/audi/app/messaging/core/commands/ICommandCallback;)V 
.const [197] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [198] = Utf8 requestId 
.const [199] = Utf8 I 
.const [200] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [201] = Utf8 draftId 
.const [202] = Utf8 Ljava/lang/String; 
.const [203] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [204] = Utf8 type 
.const [205] = Utf8 I 
.const [206] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [207] = Utf8 recipients 
.const [208] = Utf8 Lorg/dsi/ifc/messaging/RecipientList; 
.const [209] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [210] = Utf8 subject 
.const [211] = Utf8 Ljava/lang/String; 
.const [212] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [213] = Utf8 message 
.const [214] = Utf8 Ljava/lang/String; 
.const [215] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [216] = Utf8 attachments 
.const [217] = Utf8 [Lorg/dsi/ifc/messaging/AttachmentInformation; 
.const [218] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [219] = Utf8 messagingAccountID 
.const [220] = Utf8 I 
.const [221] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [222] = Utf8 logger 
.const [223] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [224] = Utf8 de/audi/atip/log/LogChannel 
.const [225] = Utf8 log 
.const [226] = Utf8 (ILjava/lang/String;)Z 
.const [227] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [228] = Utf8 setResultIfDone 
.const [229] = Utf8 (Z)V 
.const [230] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [231] = Utf8 setExceptionCause 
.const [232] = Utf8 (Ljava/lang/Throwable;)V 
.const [233] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [234] = Utf8 dsiMessagingAccess 
.const [235] = Utf8 Lde/audi/app/messaging/core/dsi/messaging/DsiMessagingAccess; 
.const [236] = Utf8 de/audi/app/messaging/core/dsi/messaging/DsiMessagingAccess 
.const [237] = Utf8 sendMessageRequest 
.const [238] = Utf8 (IILorg/dsi/ifc/messaging/RecipientList;Ljava/lang/String;Ljava/lang/String;[Lorg/dsi/ifc/messaging/AttachmentInformation;I)V 
.const [239] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [240] = Utf8 logException 
.const [241] = Utf8 (Ljava/lang/String;Ljava/lang/Exception;)V 
.const [242] = Utf8 de/audi/atip/log/LogChannel 
.const [243] = Utf8 log 
.const [244] = Utf8 (ILjava/lang/String;JJ)Z 
.const [245] = Utf8 de/audi/atip/log/LogChannel 
.const [246] = Utf8 isDebug 
.const [247] = Utf8 ()Z 
.const [248] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [249] = Utf8 append 
.const [250] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [251] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [252] = Utf8 append 
.const [253] = Utf8 (Z)Lde/esolutions/fw/util/commons/Buffer; 
.const [254] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [255] = Utf8 append 
.const [256] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [257] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [258] = Utf8 toString 
.const [259] = Utf8 ()Ljava/lang/String; 
.const [260] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [261] = Utf8 setResult 
.const [262] = Utf8 (Ljava/lang/Object;)V 
.const [263] = Utf8 de/audi/app/messaging/core/dsi/messaging/AbstractDsiMessagingCommand 
.const [264] = Utf8 <init> 
.const [265] = Utf8 (Lde/audi/app/messaging/core/application/AbstractMsgApplication;)V 
.const [266] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand$SendMessageCommandStoppedBeforeDSIResponseException 
.const [267] = Utf8 <init> 
.const [268] = Utf8 (Lde/audi/app/messaging/core/compose/SendMessageCommand;Ljava/lang/String;)V 
.const [269] = Utf8 de/audi/app/messaging/core/dsi/messaging/AbstractDsiMessagingCommand 
.const [270] = Utf8 indicateSendMessage 
.const [271] = Utf8 ([IIILorg/dsi/ifc/messaging/RecipientList;Ljava/lang/String;Ljava/lang/String;[Lorg/dsi/ifc/messaging/AttachmentInformation;I)V 
.const [272] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [273] = Utf8 <init> 
.const [274] = Utf8 ()V 
.const [275] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand$Result 
.const [276] = Utf8 <init> 
.const [277] = Utf8 (Lde/audi/app/messaging/core/compose/SendMessageCommand;I[ILde/audi/app/messaging/core/compose/SendMessageCommand$1;)V 
.const [278] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [279] = Utf8 hasResponse 
.const [280] = Utf8 Z 
.const [281] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [282] = Utf8 resultCode 
.const [283] = Utf8 I 
.const [284] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [285] = Utf8 indicationResultCodes 
.const [286] = Utf8 [I 
.const [287] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [288] = Utf8 requestId 
.const [289] = Utf8 I 
.const [290] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [291] = Utf8 draftId 
.const [292] = Utf8 Ljava/lang/String; 
.const [293] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [294] = Utf8 type 
.const [295] = Utf8 I 
.const [296] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [297] = Utf8 recipients 
.const [298] = Utf8 Lorg/dsi/ifc/messaging/RecipientList; 
.const [299] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [300] = Utf8 subject 
.const [301] = Utf8 Ljava/lang/String; 
.const [302] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [303] = Utf8 message 
.const [304] = Utf8 Ljava/lang/String; 
.const [305] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [306] = Utf8 attachments 
.const [307] = Utf8 [Lorg/dsi/ifc/messaging/AttachmentInformation; 
.const [308] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [309] = Utf8 messagingAccountID 
.const [310] = Utf8 I 
.const [311] = Utf8 de/audi/app/messaging/core/compose/SendMessageCommand 
.const [312] = Class [311] 
.const [313] = Utf8 de/audi/app/messaging/core/dsi/messaging/AbstractDsiMessagingCommand 
.const [314] = Class [313] 
.const [315] = Utf8 draftId 
.const [316] = Utf8 Ljava/lang/String; 
.const [317] = Utf8 requestId 
.const [318] = Utf8 I 
.const [319] = Utf8 type 
.const [320] = Utf8 I 
.const [321] = Utf8 recipients 
.const [322] = Utf8 Lorg/dsi/ifc/messaging/RecipientList; 
.const [323] = Utf8 subject 
.const [324] = Utf8 Ljava/lang/String; 
.const [325] = Utf8 message 
.const [326] = Utf8 Ljava/lang/String; 
.const [327] = Utf8 attachments 
.const [328] = Utf8 [Lorg/dsi/ifc/messaging/AttachmentInformation; 
.const [329] = Utf8 messagingAccountID 
.const [330] = Utf8 I 
.const [331] = Utf8 hasResponse 
.const [332] = Utf8 Z 
.const [333] = Utf8 resultCode 
.const [334] = Utf8 I 
.const [335] = Utf8 indicationResultCodes 
.const [336] = Utf8 [I 
.const [337] = Utf8 Code 
.const [338] = Utf8 <init> 
.const [339] = Utf8 (Lde/audi/app/messaging/core/application/AbstractMsgApplication;Lde/audi/app/messaging/core/commands/ICommandCallback;Ljava/lang/String;IILorg/dsi/ifc/messaging/RecipientList;Ljava/lang/String;Ljava/lang/String;[Lorg/dsi/ifc/messaging/AttachmentInformation;I)V 
.const [340] = Utf8 getRequestId 
.const [341] = Utf8 ()I 
.const [342] = Utf8 getDraftId 
.const [343] = Utf8 ()Ljava/lang/String; 
.const [344] = Utf8 getRecipients 
.const [345] = Utf8 ()Lorg/dsi/ifc/messaging/RecipientList; 
.const [346] = Utf8 getTimeout 
.const [347] = Utf8 ()J 
.const [348] = Utf8 canceled 
.const [349] = Utf8 ()Lde/audi/tghu/command/Command; 
.const [350] = Utf8 getErrorCommand 
.const [351] = Utf8 ()Lde/audi/tghu/command/Command; 
.const [352] = Utf8 execute 
.const [353] = Utf8 ()V 
.const [354] = Utf8 sendMessageResponse 
.const [355] = Utf8 (II)V 
.const [356] = Utf8 indicateSendMessage 
.const [357] = Utf8 ([IIILorg/dsi/ifc/messaging/RecipientList;Ljava/lang/String;Ljava/lang/String;[Lorg/dsi/ifc/messaging/AttachmentInformation;I)V 
.const [358] = Utf8 setResultIfDone 
.const [359] = Utf8 (Z)V 
.end class 
