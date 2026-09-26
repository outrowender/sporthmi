.version 50 0 
.class public super [297] 
.super [299] 
.field public static final [300] [301] 
.field private final [302] [303] 
.field private [304] [305] 
.field private final [306] [307] 

.method public [309] : [310] 
    .attribute [308] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [62] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [67] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [68] 
L14:    aload_0 
L15:    iconst_0 
L16:    putfield [69] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [311] : [312] 
    .attribute [308] .code stack 8 locals 17 
L0:     aload_1 
L1:     invokevirtual [38] 
L4:     astore_2 
L5:     aload_2 
L6:     instanceof [2] 
L9:     ifeq L13 
L12:    return 
L13:    aload_2 
L14:    instanceof [3] 
L17:    ifne L34 
L20:    aload_0 
L21:    getfield [35] 
L24:    sipush 10000 
L27:    ldc [4] 
L29:    invokevirtual [39] 
L32:    pop 
L33:    return 
L34:    aload_2 
L35:    checkcast [3] 
L38:    astore_3 
L39:    aload_3 
L40:    dup 
L41:    astore 4 
L43:    monitorenter 
L44:    aload_0 
L45:    getfield [35] 
L48:    ldc [5] 
L50:    ldc [6] 
L52:    aload_3 
L53:    invokevirtual [40] 
L56:    pop 
L57:    aload_3 
L58:    invokevirtual [41] 
L61:    invokevirtual [42] 
L64:    invokeinterface [70] 0 
L69:    lstore 5 
L71:    aload_3 
L72:    invokevirtual [43] 
L75:    ifeq L411 
L78:    aload_3 
L79:    invokevirtual [44] 
L82:    astore 7 
L84:    aload 7 
L86:    invokevirtual [45] 
L89:    lstore 8 
L91:    aload_3 
L92:    invokevirtual [46] 
L95:    iconst_1 
L96:    iadd 
L97:    istore 10 
L99:    aload_3 
L100:   invokevirtual [47] 
L103:   istore 11 
L105:   aload_0 
L106:   getfield [35] 
L109:   ldc [5] 
L111:   ldc [7] 
L113:   aload 7 
L115:   iload 10 
L117:   i2l 
L118:   iload 11 
L120:   i2l 
L121:   invokevirtual [48] 
L124:   pop 
L125:   aload_3 
L126:   invokevirtual [41] 
L129:   invokevirtual [42] 
L132:   invokeinterface [70] 0 
L137:   lstore 12 
        .catch [8] from L139 to L144 using L147 
L139:   aload 7 
L141:   invokevirtual [49] 
L144:   goto L172 
L147:   astore 14 
L149:   aload_0 
L150:   getfield [35] 
L153:   ldc [9] 
L155:   ldc [10] 
L157:   aload 7 
L159:   aload_3 
L160:   invokevirtual [50] 
L163:   aload_3 
L164:   aload 14 
L166:   invokevirtual [51] 
L169:   goto L411 
L172:   aload_0 
L173:   iconst_0 
L174:   putfield [69] 
L177:   lload 8 
L179:   ldc2_w [73] 
L182:   lcmp 
L183:   ifne L213 
L186:   aload_3 
L187:   invokevirtual [52] 
L190:   ifeq L408 
        .catch [11] from L193 to L197 using L200 
L193:   aload_3 
L194:   invokespecial [63] 
L197:   goto L206 
L200:   astore 14 
L202:   invokestatic [12] 
L205:   pop 
L206:   aload_0 
L207:   invokespecial [64] 
L210:   goto L186 
L213:   iconst_1 
L214:   istore 14 
L216:   aload_3 
L217:   invokevirtual [52] 
L220:   ifeq L408 
L223:   iload 14 
L225:   ifeq L374 
L228:   lload 12 
L230:   lload 8 
L232:   ladd 
L233:   lconst_1 
L234:   ladd 
L235:   aload_3 
L236:   invokevirtual [41] 
L239:   invokevirtual [42] 
L242:   invokeinterface [70] 0 
L247:   lsub 
L248:   lstore 15 
L250:   lload 15 
L252:   lconst_0 
L253:   lcmp 
L254:   ifle L279 
        .catch [11] from L257 to L263 using L266 
L257:   aload_3 
L258:   lload 15 
L260:   invokespecial [65] 
L263:   goto L272 
L266:   astore 17 
L268:   invokestatic [12] 
L271:   pop 
L272:   aload_0 
L273:   invokespecial [64] 
L276:   goto L371 
L279:   aload_0 
L280:   getfield [36] 
L283:   ifnull L318 
L286:   aload_0 
L287:   getfield [36] 
L290:   invokeinterface [71] 0 
L295:   ifne L318 
L298:   aload_0 
L299:   getfield [35] 
L302:   ldc [9] 
L304:   ldc [13] 
L306:   aload 7 
L308:   invokevirtual [40] 
L311:   pop 
L312:   iconst_0 
L313:   istore 14 
L315:   goto L371 
L318:   new [72] 
L321:   dup 
L322:   invokespecial [66] 
L325:   ldc [15] 
L327:   invokevirtual [53] 
L330:   aload 7 
L332:   invokevirtual [54] 
L335:   ldc [16] 
L337:   invokevirtual [53] 
L340:   invokevirtual [55] 
L343:   astore 17 
L345:   aload_0 
L346:   getfield [35] 
L349:   sipush 10000 
L352:   ldc [17] 
L354:   aload 17 
L356:   invokevirtual [40] 
L359:   pop 
L360:   aload_3 
L361:   aload 17 
L363:   ldc [18] 
L365:   invokevirtual [56] 
L368:   goto L408 
L371:   goto L216 
L374:   aload_0 
L375:   getfield [35] 
L378:   ldc [9] 
L380:   ldc [19] 
L382:   aload 7 
L384:   invokevirtual [40] 
L387:   pop 
        .catch [11] from L388 to L392 using L395 
L388:   aload_3 
L389:   invokespecial [63] 
L392:   goto L401 
L395:   astore 15 
L397:   invokestatic [12] 
L400:   pop 
L401:   aload_0 
L402:   invokespecial [64] 
L405:   goto L216 
L408:   goto L71 
L411:   aload_3 
L412:   invokevirtual [57] 
L415:   istore 7 
L417:   iload 7 
L419:   lookupswitch 
            1 : L444 
            2 : L460 
            default : L477 

L444:   aload_0 
L445:   getfield [35] 
L448:   ldc [5] 
L450:   ldc [20] 
L452:   aload_3 
L453:   invokevirtual [40] 
L456:   pop 
L457:   goto L477 
L460:   aload_0 
L461:   getfield [35] 
L464:   sipush 10000 
L467:   ldc [21] 
L469:   aload_3 
L470:   invokevirtual [40] 
L473:   pop 
L474:   goto L477 
L477:   iload 7 
L479:   iconst_1 
L480:   if_icmpeq L489 
L483:   iload 7 
L485:   iconst_2 
L486:   if_icmpne L521 
        .catch [8] from L489 to L503 using L506 
        .catch [0] from L44 to L574 using L577 
L489:   aload_3 
L490:   invokevirtual [58] 
L493:   ifnull L503 
L496:   aload_3 
L497:   invokevirtual [58] 
L500:   invokevirtual [49] 
L503:   goto L521 
L506:   astore 8 
L508:   aload_0 
L509:   getfield [35] 
L512:   sipush 10000 
L515:   ldc [22] 
L517:   invokevirtual [39] 
L520:   pop 
L521:   aload_3 
L522:   invokevirtual [41] 
L525:   invokevirtual [42] 
L528:   invokeinterface [70] 0 
L533:   lstore 8 
L535:   lload 8 
L537:   lload 5 
L539:   lsub 
L540:   lstore 10 
L542:   lload 5 
L544:   aload_3 
L545:   invokevirtual [59] 
L548:   lsub 
L549:   lstore 12 
L551:   aload_0 
L552:   getfield [35] 
L555:   ldc [5] 
L557:   ldc [23] 
L559:   aload_3 
L560:   invokevirtual [60] 
L563:   lload 10 
L565:   lload 12 
L567:   invokevirtual [48] 
L570:   pop 
L571:   aload 4 
L573:   monitorexit 
L574:   goto L585 
        .catch [0] from L577 to L582 using L577 
L577:   astore 18 
L579:   aload 4 
L581:   monitorexit 
L582:   aload 18 
L584:   athrow 
L585:   return 
L586:   nop 
L587:   nop 
L588:   
    .end code 
.end method 

.method private [313] : [314] 
    .attribute [308] .code stack 5 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [37] 
L5:     iconst_1 
L6:     iadd 
L7:     putfield [69] 
L10:    aload_0 
L11:    getfield [37] 
L14:    iconst_5 
L15:    if_icmplt L35 
L18:    aload_0 
L19:    getfield [35] 
L22:    ldc [9] 
L24:    ldc [24] 
L26:    aload_0 
L27:    getfield [37] 
L30:    i2l 
L31:    invokevirtual [61] 
L34:    pop 
L35:    return 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [75] 
.const [3] = Class [76] 
.const [4] = String [77] 
.const [5] = Int 1078071040 
.const [6] = String [78] 
.const [7] = String [79] 
.const [8] = Class [80] 
.const [9] = Int -1601830656 
.const [10] = String [81] 
.const [11] = Class [82] 
.const [12] = Method [83] [84] 
.const [13] = String [85] 
.const [14] = Class [86] 
.const [15] = String [87] 
.const [16] = String [88] 
.const [17] = String [89] 
.const [18] = String [90] 
.const [19] = String [91] 
.const [20] = String [92] 
.const [21] = String [93] 
.const [22] = String [94] 
.const [23] = String [95] 
.const [24] = String [96] 
.const [25] = Class [97] 
.const [26] = Class [98] 
.const [27] = Class [99] 
.const [28] = Class [100] 
.const [29] = Class [101] 
.const [30] = Class [102] 
.const [31] = Class [103] 
.const [32] = Class [104] 
.const [33] = Class [105] 
.const [34] = Class [106] 
.const [35] = Field [107] [108] 
.const [36] = Field [109] [110] 
.const [37] = Field [111] [112] 
.const [38] = Method [113] [114] 
.const [39] = Method [115] [116] 
.const [40] = Method [117] [118] 
.const [41] = Method [119] [120] 
.const [42] = Method [121] [122] 
.const [43] = Method [123] [124] 
.const [44] = Method [125] [126] 
.const [45] = Method [127] [128] 
.const [46] = Method [129] [130] 
.const [47] = Method [131] [132] 
.const [48] = Method [133] [134] 
.const [49] = Method [135] [136] 
.const [50] = Method [137] [138] 
.const [51] = Method [139] [140] 
.const [52] = Method [141] [142] 
.const [53] = Method [143] [144] 
.const [54] = Method [145] [146] 
.const [55] = Method [147] [148] 
.const [56] = Method [149] [150] 
.const [57] = Method [151] [152] 
.const [58] = Method [153] [154] 
.const [59] = Method [155] [156] 
.const [60] = Method [157] [158] 
.const [61] = Method [159] [160] 
.const [62] = Method [161] [162] 
.const [63] = Method [163] [164] 
.const [64] = Method [165] [166] 
.const [65] = Method [167] [168] 
.const [66] = Method [169] [170] 
.const [67] = Field [171] [172] 
.const [68] = Field [173] [174] 
.const [69] = Field [175] [176] 
.const [70] = InterfaceMethod [177] [178] 
.const [71] = InterfaceMethod [179] [180] 
.const [72] = Class [181] 
.const [73] = Long -1L 
.const [75] = Utf8 de/audi/tghu/command/CommandListNull 
.const [76] = Utf8 de/audi/tghu/command/CommandList 
.const [77] = Utf8 'CommandListInterceptor#execute() - given job is no commandlist!!! ' 
.const [78] = Utf8 'CommandListInterceptor#execute() - Starting execution of %1 ' 
.const [79] = Utf8 "CommandListInterceptor#execute() - Execute command %2 of %3: '%1'  " 
.const [80] = Utf8 java/lang/Exception 
.const [81] = Utf8 'CommandListInterceptor#execute() - Failed to execute command: %1! Aborting active command list %2! ' 
.const [82] = Utf8 java/lang/InterruptedException 
.const [83] = Class [182] 
.const [84] = NameAndType [183] [184] 
.const [85] = Utf8 "CommandListInterceptor#execute() - time is up for '%1', but application seems to be not operable any longer!" 
.const [86] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [87] = Utf8 "Command '" 
.const [88] = Utf8 "' did not respond in time" 
.const [89] = Utf8 'CommandListInterceptor#execute() - %1! ' 
.const [90] = Utf8 timeout 
.const [91] = Utf8 "CommandListInterceptor#execute() - timeouts currently disabled for '%1'!" 
.const [92] = Utf8 'CommandListInterceptor#execute() - Active command list %1 has been stopped!' 
.const [93] = Utf8 'CommandListInterceptor#execute() - Active command list %1 has been aborted! ' 
.const [94] = Utf8 'CommandListInterceptor#execute() - Failed to execute error command!' 
.const [95] = Utf8 "CommandListInterceptor#execute() - '%1' [execution time: %2 ms, queue time: %3 ms] " 
.const [96] = Utf8 'CommandListInterceptor#checkWakeUpCount() - counted %1 wake-ups during wait!' 
.const [97] = Utf8 de/audi/tghu/command/CommandListInterceptor 
.const [98] = Utf8 de/esolutions/fw/util/commons/job/BaseInterceptor 
.const [99] = Utf8 de/esolutions/fw/util/commons/job/Job 
.const [100] = Utf8 de/audi/atip/log/LogChannel 
.const [101] = Utf8 de/audi/tghu/command/CommandListManager 
.const [102] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [103] = Utf8 de/audi/tghu/command/Command 
.const [104] = Utf8 java/lang/Object 
.const [105] = Utf8 java/lang/Thread 
.const [106] = Utf8 de/audi/tghu/command/ICommandListSupplier 
.const [107] = Class [185] 
.const [108] = NameAndType [186] [187] 
.const [109] = Class [188] 
.const [110] = NameAndType [189] [190] 
.const [111] = Class [191] 
.const [112] = NameAndType [192] [193] 
.const [113] = Class [194] 
.const [114] = NameAndType [195] [196] 
.const [115] = Class [197] 
.const [116] = NameAndType [198] [199] 
.const [117] = Class [200] 
.const [118] = NameAndType [201] [202] 
.const [119] = Class [203] 
.const [120] = NameAndType [204] [205] 
.const [121] = Class [206] 
.const [122] = NameAndType [207] [208] 
.const [123] = Class [209] 
.const [124] = NameAndType [210] [211] 
.const [125] = Class [212] 
.const [126] = NameAndType [213] [214] 
.const [127] = Class [215] 
.const [128] = NameAndType [216] [217] 
.const [129] = Class [218] 
.const [130] = NameAndType [219] [220] 
.const [131] = Class [221] 
.const [132] = NameAndType [222] [223] 
.const [133] = Class [224] 
.const [134] = NameAndType [225] [226] 
.const [135] = Class [227] 
.const [136] = NameAndType [228] [229] 
.const [137] = Class [230] 
.const [138] = NameAndType [231] [232] 
.const [139] = Class [233] 
.const [140] = NameAndType [234] [235] 
.const [141] = Class [236] 
.const [142] = NameAndType [237] [238] 
.const [143] = Class [239] 
.const [144] = NameAndType [240] [241] 
.const [145] = Class [242] 
.const [146] = NameAndType [243] [244] 
.const [147] = Class [245] 
.const [148] = NameAndType [246] [247] 
.const [149] = Class [248] 
.const [150] = NameAndType [249] [250] 
.const [151] = Class [251] 
.const [152] = NameAndType [252] [253] 
.const [153] = Class [254] 
.const [154] = NameAndType [255] [256] 
.const [155] = Class [257] 
.const [156] = NameAndType [258] [259] 
.const [157] = Class [260] 
.const [158] = NameAndType [261] [262] 
.const [159] = Class [263] 
.const [160] = NameAndType [264] [265] 
.const [161] = Class [266] 
.const [162] = NameAndType [267] [268] 
.const [163] = Class [269] 
.const [164] = NameAndType [270] [271] 
.const [165] = Class [272] 
.const [166] = NameAndType [273] [274] 
.const [167] = Class [275] 
.const [168] = NameAndType [276] [277] 
.const [169] = Class [278] 
.const [170] = NameAndType [279] [280] 
.const [171] = Class [281] 
.const [172] = NameAndType [282] [283] 
.const [173] = Class [284] 
.const [174] = NameAndType [285] [286] 
.const [175] = Class [287] 
.const [176] = NameAndType [288] [289] 
.const [177] = Class [290] 
.const [178] = NameAndType [291] [292] 
.const [179] = Class [293] 
.const [180] = NameAndType [294] [295] 
.const [181] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [182] = Utf8 java/lang/Thread 
.const [183] = Utf8 interrupted 
.const [184] = Utf8 ()Z 
.const [185] = Utf8 de/audi/tghu/command/CommandListInterceptor 
.const [186] = Utf8 logChannel 
.const [187] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [188] = Utf8 de/audi/tghu/command/CommandListInterceptor 
.const [189] = Utf8 supplier 
.const [190] = Utf8 Lde/audi/tghu/command/ICommandListSupplier; 
.const [191] = Utf8 de/audi/tghu/command/CommandListInterceptor 
.const [192] = Utf8 wakeUpCount 
.const [193] = Utf8 I 
.const [194] = Utf8 de/esolutions/fw/util/commons/job/Job 
.const [195] = Utf8 getPayload 
.const [196] = Utf8 ()Ljava/lang/Object; 
.const [197] = Utf8 de/audi/atip/log/LogChannel 
.const [198] = Utf8 log 
.const [199] = Utf8 (ILjava/lang/String;)Z 
.const [200] = Utf8 de/audi/atip/log/LogChannel 
.const [201] = Utf8 log 
.const [202] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [203] = Utf8 de/audi/tghu/command/CommandList 
.const [204] = Utf8 getManager 
.const [205] = Utf8 ()Lde/audi/tghu/command/CommandListManager; 
.const [206] = Utf8 de/audi/tghu/command/CommandListManager 
.const [207] = Utf8 getFramework 
.const [208] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [209] = Utf8 de/audi/tghu/command/CommandList 
.const [210] = Utf8 hasNext 
.const [211] = Utf8 ()Z 
.const [212] = Utf8 de/audi/tghu/command/CommandList 
.const [213] = Utf8 next 
.const [214] = Utf8 ()Lde/audi/tghu/command/Command; 
.const [215] = Utf8 de/audi/tghu/command/Command 
.const [216] = Utf8 getTimeout 
.const [217] = Utf8 ()J 
.const [218] = Utf8 de/audi/tghu/command/CommandList 
.const [219] = Utf8 getPos 
.const [220] = Utf8 ()I 
.const [221] = Utf8 de/audi/tghu/command/CommandList 
.const [222] = Utf8 size 
.const [223] = Utf8 ()I 
.const [224] = Utf8 de/audi/atip/log/LogChannel 
.const [225] = Utf8 log 
.const [226] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [227] = Utf8 de/audi/tghu/command/Command 
.const [228] = Utf8 execute 
.const [229] = Utf8 ()V 
.const [230] = Utf8 de/audi/atip/log/LogChannel 
.const [231] = Utf8 log 
.const [232] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [233] = Utf8 de/audi/tghu/command/CommandList 
.const [234] = Utf8 commandAborted 
.const [235] = Utf8 (Ljava/lang/Exception;)V 
.const [236] = Utf8 de/audi/tghu/command/CommandList 
.const [237] = Utf8 hasActiveCommand 
.const [238] = Utf8 ()Z 
.const [239] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [240] = Utf8 append 
.const [241] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [242] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [243] = Utf8 append 
.const [244] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/Buffer; 
.const [245] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [246] = Utf8 toString 
.const [247] = Utf8 ()Ljava/lang/String; 
.const [248] = Utf8 de/audi/tghu/command/CommandList 
.const [249] = Utf8 commandAborted 
.const [250] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [251] = Utf8 de/audi/tghu/command/CommandList 
.const [252] = Utf8 getStatus 
.const [253] = Utf8 ()I 
.const [254] = Utf8 de/audi/tghu/command/CommandList 
.const [255] = Utf8 getErrorCommand 
.const [256] = Utf8 ()Lde/audi/tghu/command/Command; 
.const [257] = Utf8 de/audi/tghu/command/CommandList 
.const [258] = Utf8 getQueuingTime 
.const [259] = Utf8 ()J 
.const [260] = Utf8 de/audi/tghu/command/CommandList 
.const [261] = Utf8 getName 
.const [262] = Utf8 ()Ljava/lang/String; 
.const [263] = Utf8 de/audi/atip/log/LogChannel 
.const [264] = Utf8 log 
.const [265] = Utf8 (ILjava/lang/String;J)Z 
.const [266] = Utf8 de/esolutions/fw/util/commons/job/BaseInterceptor 
.const [267] = Utf8 <init> 
.const [268] = Utf8 ()V 
.const [269] = Utf8 java/lang/Object 
.const [270] = Utf8 wait 
.const [271] = Utf8 ()V 
.const [272] = Utf8 de/audi/tghu/command/CommandListInterceptor 
.const [273] = Utf8 checkWakeUpCount 
.const [274] = Utf8 ()V 
.const [275] = Utf8 java/lang/Object 
.const [276] = Utf8 wait 
.const [277] = Utf8 (J)V 
.const [278] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [279] = Utf8 <init> 
.const [280] = Utf8 ()V 
.const [281] = Utf8 de/audi/tghu/command/CommandListInterceptor 
.const [282] = Utf8 logChannel 
.const [283] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [284] = Utf8 de/audi/tghu/command/CommandListInterceptor 
.const [285] = Utf8 supplier 
.const [286] = Utf8 Lde/audi/tghu/command/ICommandListSupplier; 
.const [287] = Utf8 de/audi/tghu/command/CommandListInterceptor 
.const [288] = Utf8 wakeUpCount 
.const [289] = Utf8 I 
.const [290] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [291] = Utf8 getMonotonicTime 
.const [292] = Utf8 ()J 
.const [293] = Utf8 de/audi/tghu/command/ICommandListSupplier 
.const [294] = Utf8 isApplicationOperable 
.const [295] = Utf8 ()Z 
.const [296] = Utf8 de/audi/tghu/command/CommandListInterceptor 
.const [297] = Class [296] 
.const [298] = Utf8 de/esolutions/fw/util/commons/job/BaseInterceptor 
.const [299] = Class [298] 
.const [300] = Utf8 WAKEUPS_THRESHOLD 
.const [301] = Utf8 I 
.const [302] = Utf8 logChannel 
.const [303] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [304] = Utf8 wakeUpCount 
.const [305] = Utf8 I 
.const [306] = Utf8 supplier 
.const [307] = Utf8 Lde/audi/tghu/command/ICommandListSupplier; 
.const [308] = Utf8 Code 
.const [309] = Utf8 <init> 
.const [310] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/tghu/command/ICommandListSupplier;)V 
.const [311] = Utf8 execute 
.const [312] = Utf8 (Lde/esolutions/fw/util/commons/job/Job;)V 
.const [313] = Utf8 checkWakeUpCount 
.const [314] = Utf8 ()V 
.end class 
