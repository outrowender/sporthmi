.version 50 0 
.class super [232] 
.super [234] 
.field private final synthetic [235] [236] 
.field private final synthetic [237] [238] 
.field private final synthetic [239] [240] 
.field private final synthetic [241] [242] 
.field private final synthetic [243] [244] 
.field private final synthetic [245] [246] 

.method [248] : [249] 
    .attribute [247] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [49] 
L5:     aload_0 
L6:     iload_3 
L7:     putfield [50] 
L10:    aload_0 
L11:    iload 4 
L13:    putfield [51] 
L16:    aload_0 
L17:    iload 5 
L19:    putfield [52] 
L22:    aload_0 
L23:    iload 6 
L25:    putfield [53] 
L28:    aload_0 
L29:    iload 7 
L31:    putfield [54] 
L34:    aload_0 
L35:    aload_2 
L36:    invokespecial [47] 
L39:    return 
L40:    
    .end code 
.end method 

.method public [250] : [251] 
    .attribute [247] .code stack 6 locals 12 
L0:     aload_0 
L1:     getfield [36] 
L4:     invokestatic [2] 
L7:     invokeinterface [55] 0 
L12:    invokeinterface [56] 0 
L17:    lookupswitch 
            2 : L44 
            4 : L55 
            default : L66 

L44:    sipush 1024 
L47:    istore_1 
L48:    sipush 480 
L51:    istore_2 
L52:    goto L74 
L55:    sipush 1440 
L58:    istore_1 
L59:    sipush 540 
L62:    istore_2 
L63:    goto L74 
L66:    sipush 800 
L69:    istore_1 
L70:    sipush 480 
L73:    istore_2 
L74:    aload_0 
L75:    getfield [37] 
L78:    i2f 
L79:    aload_0 
L80:    getfield [38] 
L83:    i2f 
L84:    fdiv 
L85:    fstore_3 
L86:    aload_0 
L87:    getfield [36] 
L90:    invokestatic [3] 
L93:    iconst_5 
L94:    if_icmpeq L188 
L97:    aload_0 
L98:    getfield [36] 
L101:   invokestatic [2] 
L104:   invokeinterface [57] 0 
L109:   invokeinterface [58] 0 
L114:   aload_0 
L115:   getfield [36] 
L118:   invokestatic [2] 
L121:   sipush 170 
L124:   iconst_0 
L125:   iconst_0 
L126:   iconst_5 
L127:   invokevirtual [42] 
L130:   istore 4 
L132:   iload 4 
L134:   tableswitch 1 
            L182 
            L176 
            L170 
            L164 
            default : L188 

L164:   ldc [4] 
L166:   fstore_3 
L167:   goto L188 
L170:   ldc [5] 
L172:   fstore_3 
L173:   goto L188 
L176:   ldc [6] 
L178:   fstore_3 
L179:   goto L188 
L182:   ldc [7] 
L184:   fstore_3 
L185:   goto L188 
L188:   iload_1 
L189:   i2f 
L190:   fstore 4 
L192:   iload_2 
L193:   i2f 
L194:   fstore 5 
L196:   fload 4 
L198:   fload_3 
L199:   fdiv 
L200:   fload 5 
L202:   fcmpl 
L203:   ifle L215 
L206:   fload 5 
L208:   fload_3 
L209:   fmul 
L210:   fstore 4 
L212:   goto L221 
L215:   fload 4 
L217:   fload_3 
L218:   fdiv 
L219:   fstore 5 
L221:   iload_1 
L222:   i2f 
L223:   fload 4 
L225:   fsub 
L226:   fconst_2 
L227:   fdiv 
L228:   f2i 
L229:   istore 6 
L231:   iload_2 
L232:   i2f 
L233:   fload 5 
L235:   fsub 
L236:   fconst_2 
L237:   fdiv 
L238:   f2i 
L239:   istore 7 
L241:   aload_0 
L242:   getfield [39] 
L245:   i2f 
L246:   aload_0 
L247:   getfield [37] 
L250:   i2f 
L251:   fdiv 
L252:   fstore 8 
L254:   aload_0 
L255:   getfield [40] 
L258:   i2f 
L259:   aload_0 
L260:   getfield [38] 
L263:   i2f 
L264:   fdiv 
L265:   fstore 9 
L267:   fload 8 
L269:   fload 4 
L271:   fmul 
L272:   invokestatic [8] 
L275:   iload 6 
L277:   iadd 
L278:   istore 10 
L280:   fload 9 
L282:   fload 5 
L284:   fmul 
L285:   invokestatic [8] 
L288:   iload 7 
L290:   iadd 
L291:   istore 11 
L293:   aload_0 
L294:   getfield [36] 
L297:   invokestatic [9] 
L300:   invokevirtual [43] 
L303:   ifeq L444 
L306:   new [59] 
L309:   dup 
L310:   invokespecial [48] 
L313:   astore 12 
L315:   aload 12 
L317:   aload_0 
L318:   getfield [41] 
L321:   ifeq L329 
L324:   ldc [11] 
L326:   goto L331 
L329:   ldc [12] 
L331:   invokevirtual [44] 
L334:   ldc [13] 
L336:   invokevirtual [44] 
L339:   aload_0 
L340:   getfield [39] 
L343:   invokevirtual [45] 
L346:   ldc [14] 
L348:   invokevirtual [44] 
L351:   aload_0 
L352:   getfield [40] 
L355:   invokevirtual [45] 
L358:   ldc [15] 
L360:   invokevirtual [44] 
L363:   aload_0 
L364:   getfield [37] 
L367:   invokevirtual [45] 
L370:   ldc [16] 
L372:   invokevirtual [44] 
L375:   aload_0 
L376:   getfield [38] 
L379:   invokevirtual [45] 
L382:   ldc [17] 
L384:   invokevirtual [44] 
L387:   iload_1 
L388:   invokevirtual [45] 
L391:   ldc [18] 
L393:   invokevirtual [44] 
L396:   iload_2 
L397:   invokevirtual [45] 
L400:   ldc [19] 
L402:   invokevirtual [44] 
L405:   iload 10 
L407:   invokevirtual [45] 
L410:   ldc [20] 
L412:   invokevirtual [44] 
L415:   iload 11 
L417:   invokevirtual [45] 
L420:   ldc [21] 
L422:   invokevirtual [44] 
L425:   pop 
L426:   aload_0 
L427:   getfield [36] 
L430:   invokestatic [9] 
L433:   ldc [22] 
L435:   ldc [23] 
L437:   ldc [24] 
L439:   aload 12 
L441:   invokevirtual [46] 
L444:   aload_0 
L445:   getfield [36] 
L448:   invokestatic [25] 
L451:   aload_0 
L452:   getfield [41] 
L455:   ifeq L462 
L458:   iconst_1 
L459:   goto L463 
L462:   iconst_0 
L463:   iload 10 
L465:   iload 11 
L467:   invokeinterface [60] 0 
L472:   return 
L473:   nop 
L474:   nop 
L475:   nop 
L476:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [61] [62] 
.const [3] = Method [63] [64] 
.const [4] = Int 1717966400 
.const [5] = Int 1914488639 
.const [6] = Int 965665599 
.const [7] = Int -1414878657 
.const [8] = Method [65] [66] 
.const [9] = Method [67] [68] 
.const [10] = Class [69] 
.const [11] = String [70] 
.const [12] = String [71] 
.const [13] = String [72] 
.const [14] = String [73] 
.const [15] = String [74] 
.const [16] = String [75] 
.const [17] = String [76] 
.const [18] = String [77] 
.const [19] = String [78] 
.const [20] = String [79] 
.const [21] = String [80] 
.const [22] = Int 1078071040 
.const [23] = String [81] 
.const [24] = String [82] 
.const [25] = Method [83] [84] 
.const [26] = Class [85] 
.const [27] = Class [86] 
.const [28] = Class [87] 
.const [29] = Class [88] 
.const [30] = Class [89] 
.const [31] = Class [90] 
.const [32] = Class [91] 
.const [33] = Class [92] 
.const [34] = Class [93] 
.const [35] = Class [94] 
.const [36] = Field [95] [96] 
.const [37] = Field [97] [98] 
.const [38] = Field [99] [100] 
.const [39] = Field [101] [102] 
.const [40] = Field [103] [104] 
.const [41] = Field [105] [106] 
.const [42] = Method [107] [108] 
.const [43] = Method [109] [110] 
.const [44] = Method [111] [112] 
.const [45] = Method [113] [114] 
.const [46] = Method [115] [116] 
.const [47] = Method [117] [118] 
.const [48] = Method [119] [120] 
.const [49] = Field [121] [122] 
.const [50] = Field [123] [124] 
.const [51] = Field [125] [126] 
.const [52] = Field [127] [128] 
.const [53] = Field [129] [130] 
.const [54] = Field [131] [132] 
.const [55] = InterfaceMethod [133] [134] 
.const [56] = InterfaceMethod [135] [136] 
.const [57] = InterfaceMethod [137] [138] 
.const [58] = InterfaceMethod [139] [140] 
.const [59] = Class [141] 
.const [60] = InterfaceMethod [142] [143] 
.const [61] = Class [144] 
.const [62] = NameAndType [145] [146] 
.const [63] = Class [147] 
.const [64] = NameAndType [148] [149] 
.const [65] = Class [150] 
.const [66] = NameAndType [151] [152] 
.const [67] = Class [153] 
.const [68] = NameAndType [154] [155] 
.const [69] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [70] = Utf8 CLICK_ACTIVE 
.const [71] = Utf8 CLICK 
.const [72] = Utf8 ",rX='" 
.const [73] = Utf8 "',rY='" 
.const [74] = Utf8 "',rResX='" 
.const [75] = Utf8 "',rResY='" 
.const [76] = Utf8 "',resX='" 
.const [77] = Utf8 "',resY='" 
.const [78] = Utf8 "',x='" 
.const [79] = Utf8 "',y='" 
.const [80] = Utf8 "'" 
.const [81] = Utf8 '[%1.ontouchEvent] %2' 
.const [82] = Utf8 MediaSDISContentHandler 
.const [83] = Class [156] 
.const [84] = NameAndType [157] [158] 
.const [85] = Utf8 de/audi/app/media/sdis/MediaSDISContentHandler$11 
.const [86] = Utf8 de/audi/app/media/AbstractDispatcherRunnable 
.const [87] = Utf8 de/audi/app/media/sdis/MediaSDISContentHandler 
.const [88] = Utf8 de/audi/app/media/IMediaTerminal 
.const [89] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [90] = Utf8 de/audi/app/media/persistence/IMediaPersistence 
.const [91] = Utf8 de/audi/app/media/persistence/MediaStorage 
.const [92] = Utf8 java/lang/Math 
.const [93] = Utf8 de/audi/atip/log/LogChannel 
.const [94] = Utf8 de/audi/app/media/content/media/IPlayer 
.const [95] = Class [159] 
.const [96] = NameAndType [160] [161] 
.const [97] = Class [162] 
.const [98] = NameAndType [163] [164] 
.const [99] = Class [165] 
.const [100] = NameAndType [166] [167] 
.const [101] = Class [168] 
.const [102] = NameAndType [169] [170] 
.const [103] = Class [171] 
.const [104] = NameAndType [172] [173] 
.const [105] = Class [174] 
.const [106] = NameAndType [175] [176] 
.const [107] = Class [177] 
.const [108] = NameAndType [178] [179] 
.const [109] = Class [180] 
.const [110] = NameAndType [181] [182] 
.const [111] = Class [183] 
.const [112] = NameAndType [184] [185] 
.const [113] = Class [186] 
.const [114] = NameAndType [187] [188] 
.const [115] = Class [189] 
.const [116] = NameAndType [190] [191] 
.const [117] = Class [192] 
.const [118] = NameAndType [193] [194] 
.const [119] = Class [195] 
.const [120] = NameAndType [196] [197] 
.const [121] = Class [198] 
.const [122] = NameAndType [199] [200] 
.const [123] = Class [201] 
.const [124] = NameAndType [202] [203] 
.const [125] = Class [204] 
.const [126] = NameAndType [205] [206] 
.const [127] = Class [207] 
.const [128] = NameAndType [208] [209] 
.const [129] = Class [210] 
.const [130] = NameAndType [211] [212] 
.const [131] = Class [213] 
.const [132] = NameAndType [214] [215] 
.const [133] = Class [216] 
.const [134] = NameAndType [217] [218] 
.const [135] = Class [219] 
.const [136] = NameAndType [220] [221] 
.const [137] = Class [222] 
.const [138] = NameAndType [223] [224] 
.const [139] = Class [225] 
.const [140] = NameAndType [226] [227] 
.const [141] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [142] = Class [228] 
.const [143] = NameAndType [229] [230] 
.const [144] = Utf8 de/audi/app/media/sdis/MediaSDISContentHandler 
.const [145] = Utf8 access$200 
.const [146] = Utf8 (Lde/audi/app/media/sdis/MediaSDISContentHandler;)Lde/audi/app/media/IMediaTerminal; 
.const [147] = Utf8 de/audi/app/media/sdis/MediaSDISContentHandler 
.const [148] = Utf8 access$300 
.const [149] = Utf8 (Lde/audi/app/media/sdis/MediaSDISContentHandler;)I 
.const [150] = Utf8 java/lang/Math 
.const [151] = Utf8 round 
.const [152] = Utf8 (F)I 
.const [153] = Utf8 de/audi/app/media/sdis/MediaSDISContentHandler 
.const [154] = Utf8 access$000 
.const [155] = Utf8 (Lde/audi/app/media/sdis/MediaSDISContentHandler;)Lde/audi/atip/log/LogChannel; 
.const [156] = Utf8 de/audi/app/media/sdis/MediaSDISContentHandler 
.const [157] = Utf8 access$100 
.const [158] = Utf8 (Lde/audi/app/media/sdis/MediaSDISContentHandler;)Lde/audi/app/media/content/media/IPlayer; 
.const [159] = Utf8 de/audi/app/media/sdis/MediaSDISContentHandler$11 
.const [160] = Utf8 this$0 
.const [161] = Utf8 Lde/audi/app/media/sdis/MediaSDISContentHandler; 
.const [162] = Utf8 de/audi/app/media/sdis/MediaSDISContentHandler$11 
.const [163] = Utf8 val$pScreenX 
.const [164] = Utf8 I 
.const [165] = Utf8 de/audi/app/media/sdis/MediaSDISContentHandler$11 
.const [166] = Utf8 val$pScreenY 
.const [167] = Utf8 I 
.const [168] = Utf8 de/audi/app/media/sdis/MediaSDISContentHandler$11 
.const [169] = Utf8 val$pX 
.const [170] = Utf8 I 
.const [171] = Utf8 de/audi/app/media/sdis/MediaSDISContentHandler$11 
.const [172] = Utf8 val$pY 
.const [173] = Utf8 I 
.const [174] = Utf8 de/audi/app/media/sdis/MediaSDISContentHandler$11 
.const [175] = Utf8 val$pSelectAndActivate 
.const [176] = Utf8 Z 
.const [177] = Utf8 de/audi/app/media/persistence/MediaStorage 
.const [178] = Utf8 load 
.const [179] = Utf8 (Lde/audi/app/media/IMediaTerminal;IIII)I 
.const [180] = Utf8 de/audi/atip/log/LogChannel 
.const [181] = Utf8 isInfo 
.const [182] = Utf8 ()Z 
.const [183] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [184] = Utf8 append 
.const [185] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [186] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [187] = Utf8 append 
.const [188] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [189] = Utf8 de/audi/atip/log/LogChannel 
.const [190] = Utf8 log 
.const [191] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [192] = Utf8 de/audi/app/media/AbstractDispatcherRunnable 
.const [193] = Utf8 <init> 
.const [194] = Utf8 (Ljava/lang/String;)V 
.const [195] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [196] = Utf8 <init> 
.const [197] = Utf8 ()V 
.const [198] = Utf8 de/audi/app/media/sdis/MediaSDISContentHandler$11 
.const [199] = Utf8 this$0 
.const [200] = Utf8 Lde/audi/app/media/sdis/MediaSDISContentHandler; 
.const [201] = Utf8 de/audi/app/media/sdis/MediaSDISContentHandler$11 
.const [202] = Utf8 val$pScreenX 
.const [203] = Utf8 I 
.const [204] = Utf8 de/audi/app/media/sdis/MediaSDISContentHandler$11 
.const [205] = Utf8 val$pScreenY 
.const [206] = Utf8 I 
.const [207] = Utf8 de/audi/app/media/sdis/MediaSDISContentHandler$11 
.const [208] = Utf8 val$pX 
.const [209] = Utf8 I 
.const [210] = Utf8 de/audi/app/media/sdis/MediaSDISContentHandler$11 
.const [211] = Utf8 val$pY 
.const [212] = Utf8 I 
.const [213] = Utf8 de/audi/app/media/sdis/MediaSDISContentHandler$11 
.const [214] = Utf8 val$pSelectAndActivate 
.const [215] = Utf8 Z 
.const [216] = Utf8 de/audi/app/media/IMediaTerminal 
.const [217] = Utf8 getFramework 
.const [218] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [219] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [220] = Utf8 getScreenRes 
.const [221] = Utf8 ()I 
.const [222] = Utf8 de/audi/app/media/IMediaTerminal 
.const [223] = Utf8 getMediaPersistence 
.const [224] = Utf8 ()Lde/audi/app/media/persistence/IMediaPersistence; 
.const [225] = Utf8 de/audi/app/media/persistence/IMediaPersistence 
.const [226] = Utf8 getStorage 
.const [227] = Utf8 ()Lde/audi/app/media/persistence/MediaStorage; 
.const [228] = Utf8 de/audi/app/media/content/media/IPlayer 
.const [229] = Utf8 touchEvent 
.const [230] = Utf8 (III)V 
.const [231] = Utf8 de/audi/app/media/sdis/MediaSDISContentHandler$11 
.const [232] = Class [231] 
.const [233] = Utf8 de/audi/app/media/AbstractDispatcherRunnable 
.const [234] = Class [233] 
.const [235] = Utf8 val$pScreenX 
.const [236] = Utf8 I 
.const [237] = Utf8 val$pScreenY 
.const [238] = Utf8 I 
.const [239] = Utf8 val$pX 
.const [240] = Utf8 I 
.const [241] = Utf8 val$pY 
.const [242] = Utf8 I 
.const [243] = Utf8 val$pSelectAndActivate 
.const [244] = Utf8 Z 
.const [245] = Utf8 this$0 
.const [246] = Utf8 Lde/audi/app/media/sdis/MediaSDISContentHandler; 
.const [247] = Utf8 Code 
.const [248] = Utf8 <init> 
.const [249] = Utf8 (Lde/audi/app/media/sdis/MediaSDISContentHandler;Ljava/lang/String;IIIIZ)V 
.const [250] = Utf8 run 
.const [251] = Utf8 ()V 
.end class 
