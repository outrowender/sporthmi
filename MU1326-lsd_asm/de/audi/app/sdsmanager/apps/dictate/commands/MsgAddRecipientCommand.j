.version 50 0 
.class public super [331] 
.super [333] 
.field public static final [334] [335] 
.field public static final [336] [337] 
.field public static final [338] [339] 
.field private final [340] [341] 
.field private final [342] [343] 
.field private final [344] [345] 
.field private final [346] [347] 
.field private final [348] [349] 
.field private final [350] [351] 

.method public [353] : [354] 
    .attribute [352] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [61] 
L7:     aload_0 
L8:     aload 4 
L10:    putfield [62] 
L13:    aload_0 
L14:    aload 5 
L16:    putfield [63] 
L19:    aload_0 
L20:    aload 6 
L22:    putfield [64] 
L25:    aload_0 
L26:    aload 7 
L28:    putfield [65] 
L31:    aload_0 
L32:    aload 8 
L34:    putfield [66] 
L37:    aload_0 
L38:    aload 9 
L40:    iconst_0 
L41:    invokestatic [2] 
L44:    putfield [67] 
L47:    return 
L48:    
    .end code 
.end method 

.method public [355] : [356] 
    .attribute [352] .code stack 8 locals 11 
L0:     invokestatic [3] 
L3:     istore_1 
L4:     aload_0 
L5:     getfield [49] 
L8:     ldc [4] 
L10:    ldc [5] 
L12:    aload_0 
L13:    invokevirtual [50] 
L16:    iload_1 
L17:    i2l 
L18:    invokevirtual [51] 
L21:    pop 
L22:    iload_1 
L23:    getstatic [6] 
L26:    invokestatic [7] 
L29:    astore_2 
L30:    aload_2 
L31:    iconst_0 
L32:    iaload 
L33:    istore_3 
L34:    ldc [8] 
L36:    astore 4 
L38:    iload_3 
L39:    ifne L52 
L42:    aload_0 
L43:    getfield [44] 
L46:    invokeinterface [68] 0 
L51:    istore_3 
L52:    iload_3 
L53:    lookupswitch 
            1 : L80 
            2 : L94 
            default : L395 

L80:    aload_0 
L81:    getfield [45] 
L84:    invokeinterface [69] 0 
L89:    astore 4 
L91:    goto L413 
L94:    aload_0 
L95:    getfield [48] 
L98:    tableswitch 0 
            L124 
            L266 
            L175 
            default : L371 

L124:   aload_0 
L125:   getfield [46] 
L128:   invokevirtual [52] 
L131:   invokeinterface [70] 0 
L136:   astore 5 
L138:   aload_0 
L139:   getfield [49] 
L142:   ldc [4] 
L144:   ldc [9] 
L146:   aload_0 
L147:   invokevirtual [50] 
L150:   aload 5 
L152:   invokevirtual [53] 
L155:   aload 5 
L157:   ifnonnull L165 
L160:   ldc [8] 
L162:   goto L170 
L165:   aload 5 
L167:   getfield [54] 
L170:   astore 4 
L172:   goto L392 
L175:   aload_0 
L176:   getfield [55] 
L179:   invokeinterface [71] 0 
L184:   istore 6 
L186:   aload_0 
L187:   getfield [55] 
L190:   invokeinterface [72] 0 
L195:   istore 7 
L197:   aload_0 
L198:   getfield [49] 
L201:   ldc [4] 
L203:   ldc [10] 
L205:   aload_0 
L206:   invokevirtual [50] 
L209:   iload 6 
L211:   i2l 
L212:   iload 7 
L214:   i2l 
L215:   invokevirtual [56] 
L218:   pop 
L219:   aload_0 
L220:   getfield [46] 
L223:   invokevirtual [57] 
L226:   invokeinterface [73] 0 
L231:   astore 8 
L233:   aload 8 
L235:   iload 7 
L237:   iload 6 
L239:   invokeinterface [74] 0 
L244:   astore 9 
L246:   aload 9 
L248:   ifnonnull L256 
L251:   ldc [8] 
L253:   goto L261 
L256:   aload 9 
L258:   getfield [54] 
L261:   astore 4 
L263:   goto L392 
L266:   aload_0 
L267:   getfield [49] 
L270:   ldc [4] 
L272:   ldc [11] 
L274:   aload_0 
L275:   invokevirtual [50] 
L278:   invokevirtual [58] 
L281:   pop 
L282:   aload_0 
L283:   getfield [47] 
L286:   iconst_0 
L287:   invokeinterface [75] 0 
L292:   astore 10 
L294:   aload 10 
L296:   invokestatic [12] 
L299:   ifeq L321 
L302:   aload_0 
L303:   getfield [49] 
L306:   ldc [13] 
L308:   ldc [14] 
L310:   aload_0 
L311:   invokevirtual [50] 
L314:   invokevirtual [58] 
L317:   pop 
L318:   goto L392 
L321:   aload 10 
L323:   iconst_0 
L324:   iconst_0 
L325:   invokeinterface [76] 0 
L330:   astore 11 
L332:   aload_0 
L333:   getfield [49] 
L336:   ldc [4] 
L338:   ldc [15] 
L340:   aload_0 
L341:   invokevirtual [50] 
L344:   aload 11 
L346:   invokevirtual [53] 
L349:   aload 11 
L351:   ifnonnull L359 
L354:   ldc [8] 
L356:   goto L366 
L359:   aload 11 
L361:   invokeinterface [77] 0 
L366:   astore 4 
L368:   goto L392 
L371:   aload_0 
L372:   getfield [49] 
L375:   ldc [13] 
L377:   ldc [16] 
L379:   aload_0 
L380:   invokevirtual [50] 
L383:   aload_0 
L384:   getfield [48] 
L387:   i2l 
L388:   invokevirtual [51] 
L391:   pop 
L392:   goto L413 
L395:   aload_0 
L396:   getfield [49] 
L399:   ldc [13] 
L401:   ldc [17] 
L403:   aload_0 
L404:   invokevirtual [50] 
L407:   iload_3 
L408:   i2l 
L409:   invokevirtual [51] 
L412:   pop 
L413:   aload 4 
L415:   invokestatic [18] 
L418:   ifeq L444 
L421:   aload_0 
L422:   getfield [49] 
L425:   ldc [13] 
L427:   ldc [19] 
L429:   aload_0 
L430:   invokevirtual [50] 
L433:   invokevirtual [58] 
L436:   pop 
L437:   aload_0 
L438:   ldc [20] 
L440:   invokevirtual [59] 
L443:   return 
L444:   aload_0 
L445:   getfield [49] 
L448:   ldc [4] 
L450:   ldc [21] 
L452:   aload_0 
L453:   invokevirtual [50] 
L456:   aload 4 
L458:   invokevirtual [53] 
L461:   invokestatic [22] 
L464:   astore 5 
L466:   aload_0 
L467:   getfield [46] 
L470:   invokevirtual [57] 
L473:   invokeinterface [78] 0 
L478:   lstore 6 
L480:   aload_0 
L481:   getfield [49] 
L484:   ldc [4] 
L486:   ldc [23] 
L488:   aload_0 
L489:   invokevirtual [50] 
L492:   aload 5 
L494:   lload 6 
L496:   invokevirtual [60] 
L499:   aload_0 
L500:   getfield [43] 
L503:   iconst_1 
L504:   aload 4 
L506:   lload 6 
L508:   aload 5 
L510:   invokeinterface [79] 0 
L515:   aload_0 
L516:   ldc [24] 
L518:   invokevirtual [59] 
L521:   return 
L522:   nop 
L523:   nop 
L524:   
    .end code 
.end method 

.method public [357] : [358] 
    .attribute [352] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [49] 
L4:     ldc [4] 
L6:     ldc [25] 
L8:     aload_0 
L9:     invokevirtual [50] 
L12:    iload_1 
L13:    i2l 
L14:    invokevirtual [51] 
L17:    pop 
L18:    aload_0 
L19:    iload_1 
L20:    ifne L28 
L23:    ldc [24] 
L25:    goto L30 
L28:    ldc [20] 
L30:    invokevirtual [59] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [80] [81] 
.const [3] = Method [82] [83] 
.const [4] = Int -2137614336 
.const [5] = String [84] 
.const [6] = Field [85] [86] 
.const [7] = Method [87] [88] 
.const [8] = String [89] 
.const [9] = String [90] 
.const [10] = String [91] 
.const [11] = String [92] 
.const [12] = Method [93] [94] 
.const [13] = Int -1601830656 
.const [14] = String [95] 
.const [15] = String [96] 
.const [16] = String [97] 
.const [17] = String [98] 
.const [18] = Method [99] [100] 
.const [19] = String [101] 
.const [20] = Int -115080960 
.const [21] = String [102] 
.const [22] = Method [103] [104] 
.const [23] = String [105] 
.const [24] = Int -131858176 
.const [25] = String [106] 
.const [26] = Class [107] 
.const [27] = Class [108] 
.const [28] = Class [109] 
.const [29] = Class [110] 
.const [30] = Class [111] 
.const [31] = Class [112] 
.const [32] = Class [113] 
.const [33] = Class [114] 
.const [34] = Class [115] 
.const [35] = Class [116] 
.const [36] = Class [117] 
.const [37] = Class [118] 
.const [38] = Class [119] 
.const [39] = Class [120] 
.const [40] = Class [121] 
.const [41] = Class [122] 
.const [42] = Class [123] 
.const [43] = Field [124] [125] 
.const [44] = Field [126] [127] 
.const [45] = Field [128] [129] 
.const [46] = Field [130] [131] 
.const [47] = Field [132] [133] 
.const [48] = Field [134] [135] 
.const [49] = Field [136] [137] 
.const [50] = Method [138] [139] 
.const [51] = Method [140] [141] 
.const [52] = Method [142] [143] 
.const [53] = Method [144] [145] 
.const [54] = Field [146] [147] 
.const [55] = Field [148] [149] 
.const [56] = Method [150] [151] 
.const [57] = Method [152] [153] 
.const [58] = Method [154] [155] 
.const [59] = Method [156] [157] 
.const [60] = Method [158] [159] 
.const [61] = Method [160] [161] 
.const [62] = Field [162] [163] 
.const [63] = Field [164] [165] 
.const [64] = Field [166] [167] 
.const [65] = Field [168] [169] 
.const [66] = Field [170] [171] 
.const [67] = Field [172] [173] 
.const [68] = InterfaceMethod [174] [175] 
.const [69] = InterfaceMethod [176] [177] 
.const [70] = InterfaceMethod [178] [179] 
.const [71] = InterfaceMethod [180] [181] 
.const [72] = InterfaceMethod [182] [183] 
.const [73] = InterfaceMethod [184] [185] 
.const [74] = InterfaceMethod [186] [187] 
.const [75] = InterfaceMethod [188] [189] 
.const [76] = InterfaceMethod [190] [191] 
.const [77] = InterfaceMethod [192] [193] 
.const [78] = InterfaceMethod [194] [195] 
.const [79] = InterfaceMethod [196] [197] 
.const [80] = Class [198] 
.const [81] = NameAndType [199] [200] 
.const [82] = Class [201] 
.const [83] = NameAndType [202] [203] 
.const [84] = Utf8 '%1#execute: messageType=%2!' 
.const [85] = Class [204] 
.const [86] = NameAndType [205] [206] 
.const [87] = Class [207] 
.const [88] = NameAndType [208] [209] 
.const [89] = Utf8 '' 
.const [90] = Utf8 '%1#execute: details=%2!' 
.const [91] = Utf8 '%1#execute: selectedRow=%2, selectedModel=%3!' 
.const [92] = Utf8 '%1#execute: get spoken email-address!' 
.const [93] = Class [210] 
.const [94] = NameAndType [211] [212] 
.const [95] = Utf8 '%1#execute: picklist is empty!' 
.const [96] = Utf8 '%1#execute: slot=%2!' 
.const [97] = Utf8 '%1#execute: Unhandled source %2!' 
.const [98] = Utf8 '%1#execute: message type %2 is unknown!' 
.const [99] = Class [213] 
.const [100] = NameAndType [214] [215] 
.const [101] = Utf8 '%1#execute: No recipient found, sending ERROR!' 
.const [102] = Utf8 '%1#execute: recipient=%2!' 
.const [103] = Class [216] 
.const [104] = NameAndType [217] [218] 
.const [105] = Utf8 '%1#execute: combinedName=%2, entryID=%3!' 
.const [106] = Utf8 '%1#responseAddRecipient: result=%2' 
.const [107] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgAddRecipientCommand 
.const [108] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [109] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [110] = Utf8 de/audi/app/sdsmanager/SDSModelAccess 
.const [111] = Utf8 de/audi/atip/log/LogChannel 
.const [112] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MessageDictateSDSUtils 
.const [113] = Utf8 de/audi/app/sdsmanager/apps/dictate/MessageDictationHandler 
.const [114] = Utf8 de/audi/atip/phone/ITelServiceSDS 
.const [115] = Utf8 de/audi/app/sdsmanager/apps/SDSAppFactory 
.const [116] = Utf8 de/audi/atip/interapp/ADBSDSService$EmailAddressDetails 
.const [117] = Utf8 de/audi/app/sdsmanager/apps/SDSHandlerService 
.const [118] = Utf8 de/audi/app/sdsmanager/apps/adb/AddressBookSDSHandler 
.const [119] = Utf8 de/audi/atip/interapp/ADBSDSService 
.const [120] = Utf8 de/audi/app/sdsmanager/nbest/NBestStorageAccess 
.const [121] = Utf8 de/audi/app/sdsmanager/nbest/IPicklist 
.const [122] = Utf8 de/audi/app/sdsmanager/nbest/IPicklistSlot 
.const [123] = Utf8 de/audi/atip/interapp/IMessagingDictationService 
.const [124] = Class [219] 
.const [125] = NameAndType [220] [221] 
.const [126] = Class [222] 
.const [127] = NameAndType [223] [224] 
.const [128] = Class [225] 
.const [129] = NameAndType [226] [227] 
.const [130] = Class [228] 
.const [131] = NameAndType [229] [230] 
.const [132] = Class [231] 
.const [133] = NameAndType [232] [233] 
.const [134] = Class [234] 
.const [135] = NameAndType [235] [236] 
.const [136] = Class [237] 
.const [137] = NameAndType [238] [239] 
.const [138] = Class [240] 
.const [139] = NameAndType [241] [242] 
.const [140] = Class [243] 
.const [141] = NameAndType [244] [245] 
.const [142] = Class [246] 
.const [143] = NameAndType [247] [248] 
.const [144] = Class [249] 
.const [145] = NameAndType [250] [251] 
.const [146] = Class [252] 
.const [147] = NameAndType [253] [254] 
.const [148] = Class [255] 
.const [149] = NameAndType [256] [257] 
.const [150] = Class [258] 
.const [151] = NameAndType [259] [260] 
.const [152] = Class [261] 
.const [153] = NameAndType [262] [263] 
.const [154] = Class [264] 
.const [155] = NameAndType [265] [266] 
.const [156] = Class [267] 
.const [157] = NameAndType [268] [269] 
.const [158] = Class [270] 
.const [159] = NameAndType [271] [272] 
.const [160] = Class [273] 
.const [161] = NameAndType [274] [275] 
.const [162] = Class [276] 
.const [163] = NameAndType [277] [278] 
.const [164] = Class [279] 
.const [165] = NameAndType [280] [281] 
.const [166] = Class [282] 
.const [167] = NameAndType [283] [284] 
.const [168] = Class [285] 
.const [169] = NameAndType [286] [287] 
.const [170] = Class [288] 
.const [171] = NameAndType [289] [290] 
.const [172] = Class [291] 
.const [173] = NameAndType [292] [293] 
.const [174] = Class [294] 
.const [175] = NameAndType [295] [296] 
.const [176] = Class [297] 
.const [177] = NameAndType [298] [299] 
.const [178] = Class [300] 
.const [179] = NameAndType [301] [302] 
.const [180] = Class [303] 
.const [181] = NameAndType [304] [305] 
.const [182] = Class [306] 
.const [183] = NameAndType [307] [308] 
.const [184] = Class [309] 
.const [185] = NameAndType [310] [311] 
.const [186] = Class [312] 
.const [187] = NameAndType [313] [314] 
.const [188] = Class [315] 
.const [189] = NameAndType [316] [317] 
.const [190] = Class [318] 
.const [191] = NameAndType [319] [320] 
.const [192] = Class [321] 
.const [193] = NameAndType [322] [323] 
.const [194] = Class [324] 
.const [195] = NameAndType [325] [326] 
.const [196] = Class [327] 
.const [197] = NameAndType [328] [329] 
.const [198] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [199] = Utf8 retrieveInteger 
.const [200] = Utf8 ([Lde/audi/app/sdsmanager/syscall/ISystemCallParameter;I)I 
.const [201] = Utf8 de/audi/app/sdsmanager/SDSModelAccess 
.const [202] = Utf8 getMsgDictateModel 
.const [203] = Utf8 ()I 
.const [204] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MessageDictateSDSUtils 
.const [205] = Utf8 MESSAGE_PARAMETER_2_TYPE_AND_COMPOSITION_MODE 
.const [206] = Utf8 [[I 
.const [207] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [208] = Utf8 translateMulti 
.const [209] = Utf8 (I[[I)[I 
.const [210] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [211] = Utf8 isEmpty 
.const [212] = Utf8 (Lde/audi/app/sdsmanager/nbest/IPicklist;)Z 
.const [213] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [214] = Utf8 isEmpty 
.const [215] = Utf8 (Ljava/lang/String;)Z 
.const [216] = Utf8 de/audi/app/sdsmanager/SDSModelAccess 
.const [217] = Utf8 getADBEntryNameModel 
.const [218] = Utf8 ()Ljava/lang/String; 
.const [219] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgAddRecipientCommand 
.const [220] = Utf8 messagingService 
.const [221] = Utf8 Lde/audi/atip/interapp/IMessagingDictationService; 
.const [222] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgAddRecipientCommand 
.const [223] = Utf8 messageHandler 
.const [224] = Utf8 Lde/audi/app/sdsmanager/apps/dictate/MessageDictationHandler; 
.const [225] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgAddRecipientCommand 
.const [226] = Utf8 phoneService 
.const [227] = Utf8 Lde/audi/atip/phone/ITelServiceSDS; 
.const [228] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgAddRecipientCommand 
.const [229] = Utf8 factory 
.const [230] = Utf8 Lde/audi/app/sdsmanager/apps/SDSAppFactory; 
.const [231] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgAddRecipientCommand 
.const [232] = Utf8 nBest 
.const [233] = Utf8 Lde/audi/app/sdsmanager/nbest/NBestStorageAccess; 
.const [234] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgAddRecipientCommand 
.const [235] = Utf8 source 
.const [236] = Utf8 I 
.const [237] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [238] = Utf8 logger 
.const [239] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [240] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgAddRecipientCommand 
.const [241] = Utf8 getName 
.const [242] = Utf8 ()Ljava/lang/String; 
.const [243] = Utf8 de/audi/atip/log/LogChannel 
.const [244] = Utf8 log 
.const [245] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [246] = Utf8 de/audi/app/sdsmanager/apps/SDSAppFactory 
.const [247] = Utf8 getSDSHandlerMessageDictation 
.const [248] = Utf8 ()Lde/audi/app/sdsmanager/apps/dictate/MessageDictationHandler; 
.const [249] = Utf8 de/audi/atip/log/LogChannel 
.const [250] = Utf8 log 
.const [251] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [252] = Utf8 de/audi/atip/interapp/ADBSDSService$EmailAddressDetails 
.const [253] = Utf8 email 
.const [254] = Utf8 Ljava/lang/String; 
.const [255] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [256] = Utf8 sdsHandlerService 
.const [257] = Utf8 Lde/audi/app/sdsmanager/apps/SDSHandlerService; 
.const [258] = Utf8 de/audi/atip/log/LogChannel 
.const [259] = Utf8 log 
.const [260] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [261] = Utf8 de/audi/app/sdsmanager/apps/SDSAppFactory 
.const [262] = Utf8 getSDSHandlerADB 
.const [263] = Utf8 ()Lde/audi/app/sdsmanager/apps/adb/AddressBookSDSHandler; 
.const [264] = Utf8 de/audi/atip/log/LogChannel 
.const [265] = Utf8 log 
.const [266] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [267] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgAddRecipientCommand 
.const [268] = Utf8 sendResult 
.const [269] = Utf8 (I)V 
.const [270] = Utf8 de/audi/atip/log/LogChannel 
.const [271] = Utf8 log 
.const [272] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;J)V 
.const [273] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [274] = Utf8 <init> 
.const [275] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;)V 
.const [276] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgAddRecipientCommand 
.const [277] = Utf8 messagingService 
.const [278] = Utf8 Lde/audi/atip/interapp/IMessagingDictationService; 
.const [279] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgAddRecipientCommand 
.const [280] = Utf8 messageHandler 
.const [281] = Utf8 Lde/audi/app/sdsmanager/apps/dictate/MessageDictationHandler; 
.const [282] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgAddRecipientCommand 
.const [283] = Utf8 phoneService 
.const [284] = Utf8 Lde/audi/atip/phone/ITelServiceSDS; 
.const [285] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgAddRecipientCommand 
.const [286] = Utf8 factory 
.const [287] = Utf8 Lde/audi/app/sdsmanager/apps/SDSAppFactory; 
.const [288] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgAddRecipientCommand 
.const [289] = Utf8 nBest 
.const [290] = Utf8 Lde/audi/app/sdsmanager/nbest/NBestStorageAccess; 
.const [291] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgAddRecipientCommand 
.const [292] = Utf8 source 
.const [293] = Utf8 I 
.const [294] = Utf8 de/audi/app/sdsmanager/apps/dictate/MessageDictationHandler 
.const [295] = Utf8 getMessageType 
.const [296] = Utf8 ()I 
.const [297] = Utf8 de/audi/atip/phone/ITelServiceSDS 
.const [298] = Utf8 getNumberSpellerContent 
.const [299] = Utf8 ()Ljava/lang/String; 
.const [300] = Utf8 de/audi/app/sdsmanager/apps/dictate/MessageDictationHandler 
.const [301] = Utf8 getEmailAddressDetails 
.const [302] = Utf8 ()Lde/audi/atip/interapp/ADBSDSService$EmailAddressDetails; 
.const [303] = Utf8 de/audi/app/sdsmanager/apps/SDSHandlerService 
.const [304] = Utf8 getSelectedRow 
.const [305] = Utf8 ()I 
.const [306] = Utf8 de/audi/app/sdsmanager/apps/SDSHandlerService 
.const [307] = Utf8 getSelectedModel 
.const [308] = Utf8 ()I 
.const [309] = Utf8 de/audi/app/sdsmanager/apps/adb/AddressBookSDSHandler 
.const [310] = Utf8 getADBService 
.const [311] = Utf8 ()Lde/audi/atip/interapp/ADBSDSService; 
.const [312] = Utf8 de/audi/atip/interapp/ADBSDSService 
.const [313] = Utf8 getEmailAddressDetails 
.const [314] = Utf8 (II)Lde/audi/atip/interapp/ADBSDSService$EmailAddressDetails; 
.const [315] = Utf8 de/audi/app/sdsmanager/nbest/NBestStorageAccess 
.const [316] = Utf8 getMatchingPicklist 
.const [317] = Utf8 (B)Lde/audi/app/sdsmanager/nbest/IPicklist; 
.const [318] = Utf8 de/audi/app/sdsmanager/nbest/IPicklist 
.const [319] = Utf8 getSlot 
.const [320] = Utf8 (II)Lde/audi/app/sdsmanager/nbest/IPicklistSlot; 
.const [321] = Utf8 de/audi/app/sdsmanager/nbest/IPicklistSlot 
.const [322] = Utf8 getText 
.const [323] = Utf8 ()Ljava/lang/String; 
.const [324] = Utf8 de/audi/app/sdsmanager/apps/adb/AddressBookSDSHandler 
.const [325] = Utf8 getCurrentEntryID 
.const [326] = Utf8 ()J 
.const [327] = Utf8 de/audi/atip/interapp/IMessagingDictationService 
.const [328] = Utf8 requestAddRecipient 
.const [329] = Utf8 (ILjava/lang/String;JLjava/lang/String;)V 
.const [330] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgAddRecipientCommand 
.const [331] = Class [330] 
.const [332] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [333] = Class [332] 
.const [334] = Utf8 MSG_SOURCE_LIST 
.const [335] = Utf8 I 
.const [336] = Utf8 MSG_SOURCE_NBEST 
.const [337] = Utf8 I 
.const [338] = Utf8 MSG_SOURCE_DETAIL_LINE_SELECT 
.const [339] = Utf8 I 
.const [340] = Utf8 messagingService 
.const [341] = Utf8 Lde/audi/atip/interapp/IMessagingDictationService; 
.const [342] = Utf8 messageHandler 
.const [343] = Utf8 Lde/audi/app/sdsmanager/apps/dictate/MessageDictationHandler; 
.const [344] = Utf8 phoneService 
.const [345] = Utf8 Lde/audi/atip/phone/ITelServiceSDS; 
.const [346] = Utf8 factory 
.const [347] = Utf8 Lde/audi/app/sdsmanager/apps/SDSAppFactory; 
.const [348] = Utf8 nBest 
.const [349] = Utf8 Lde/audi/app/sdsmanager/nbest/NBestStorageAccess; 
.const [350] = Utf8 source 
.const [351] = Utf8 I 
.const [352] = Utf8 Code 
.const [353] = Utf8 <init> 
.const [354] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;Lde/audi/atip/interapp/IMessagingDictationService;Lde/audi/app/sdsmanager/apps/dictate/MessageDictationHandler;Lde/audi/atip/phone/ITelServiceSDS;Lde/audi/app/sdsmanager/apps/SDSAppFactory;Lde/audi/app/sdsmanager/nbest/NBestStorageAccess;[Lde/audi/app/sdsmanager/syscall/ISystemCallParameter;)V 
.const [355] = Utf8 execute 
.const [356] = Utf8 ()V 
.const [357] = Utf8 responseAddRecipient 
.const [358] = Utf8 (I)V 
.end class 
