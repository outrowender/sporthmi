.version 50 0 
.class public super [267] 
.super [269] 
.field static synthetic [270] [271] 

.method private [273] : [274] 
    .attribute [272] .code stack 2 locals 0 
L0:     aload_0 
L1:     ldc [5] 
L3:     invokespecial [54] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [275] : [276] 
    .attribute [272] .code stack 1 locals 0 
L0:     getstatic [6] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [277] : [278] 
    .attribute [272] .code stack 11 locals 8 
L0:     getstatic [7] 
L3:     new [61] 
L6:     dup 
L7:     invokespecial [55] 
L10:    ldc [9] 
L12:    invokevirtual [38] 
L15:    aload_0 
L16:    getfield [39] 
L19:    invokevirtual [38] 
L22:    ldc [10] 
L24:    invokevirtual [38] 
L27:    invokevirtual [40] 
L30:    invokevirtual [41] 
L33:    getstatic [11] 
L36:    ifnull L533 
L39:    getstatic [11] 
L42:    invokevirtual [42] 
L45:    astore_1 
L46:    aconst_null 
L47:    astore 4 
L49:    iconst_1 
L50:    getstatic [12] 
L53:    imul 
L54:    istore_2 
L55:    getstatic [7] 
L58:    new [61] 
L61:    dup 
L62:    invokespecial [55] 
L65:    ldc [13] 
L67:    invokevirtual [38] 
L70:    iload_2 
L71:    invokevirtual [43] 
L74:    ldc [14] 
L76:    invokevirtual [38] 
L79:    invokevirtual [40] 
L82:    invokevirtual [41] 
L85:    iload_2 
L86:    anewarray [15] 
L89:    astore 6 
L91:    ldc [16] 
L93:    astore 5 
L95:    ldc [17] 
L97:    astore_3 
        .catch [18] from L98 to L107 using L110 
L98:    aload_1 
L99:    aload_3 
L100:   invokeinterface [63] 0 
L105:   astore 4 
L107:   goto L117 
L110:   astore 8 
L112:   aload 8 
L114:   invokevirtual [44] 
L117:   aload_0 
L118:   bipush 6 
L120:   iload_2 
L121:   aload 5 
L123:   invokevirtual [45] 
L126:   iconst_0 
L127:   istore 8 
L129:   iload 8 
L131:   iload_2 
L132:   if_icmpge L190 
L135:   aload 6 
L137:   iload 8 
L139:   new [62] 
L142:   dup 
L143:   aload_1 
L144:   aload 4 
L146:   new [64] 
L149:   dup 
L150:   aload_0 
L151:   new [61] 
L154:   dup 
L155:   invokespecial [55] 
L158:   aload 5 
L160:   invokevirtual [38] 
L163:   ldc [20] 
L165:   invokevirtual [38] 
L168:   iload 8 
L170:   invokevirtual [43] 
L173:   invokevirtual [40] 
L176:   iconst_0 
L177:   invokespecial [56] 
L180:   invokespecial [57] 
L183:   aastore 
L184:   iinc 8 1 
L187:   goto L129 
L190:   aload_0 
L191:   bipush 6 
L193:   iload_2 
L194:   aload 5 
L196:   invokevirtual [46] 
L199:   aload_0 
L200:   bipush 7 
L202:   iload_2 
L203:   aload 5 
L205:   invokevirtual [45] 
L208:   iconst_0 
L209:   istore 8 
L211:   iload 8 
L213:   iload_2 
L214:   if_icmpge L231 
L217:   aload 6 
L219:   iload 8 
L221:   aaload 
L222:   invokevirtual [47] 
L225:   iinc 8 1 
L228:   goto L211 
L231:   aload_0 
L232:   bipush 7 
L234:   iload_2 
L235:   aload 5 
L237:   invokevirtual [46] 
L240:   iconst_0 
L241:   istore 8 
L243:   iload 8 
L245:   iload_2 
L246:   if_icmpge L263 
L249:   aload 6 
L251:   iload 8 
L253:   aaload 
L254:   invokevirtual [48] 
L257:   iinc 8 1 
L260:   goto L243 
L263:   ldc [21] 
L265:   astore_3 
        .catch [18] from L266 to L275 using L278 
L266:   aload_1 
L267:   aload_3 
L268:   invokeinterface [63] 0 
L273:   astore 4 
L275:   goto L285 
L278:   astore 8 
L280:   aload 8 
L282:   invokevirtual [44] 
L285:   bipush 25 
L287:   anewarray [15] 
L290:   astore 6 
L292:   iconst_0 
L293:   istore 8 
L295:   iload 8 
L297:   bipush 25 
L299:   if_icmpge L360 
L302:   aload 6 
L304:   iload 8 
L306:   new [62] 
L309:   dup 
L310:   aload_1 
L311:   aload 4 
L313:   new [64] 
L316:   dup 
L317:   aload_0 
L318:   new [61] 
L321:   dup 
L322:   invokespecial [55] 
L325:   ldc [22] 
L327:   invokevirtual [38] 
L330:   iload 8 
L332:   invokevirtual [43] 
L335:   invokevirtual [40] 
L338:   iconst_0 
L339:   invokespecial [56] 
L342:   invokespecial [57] 
L345:   aastore 
L346:   aload 6 
L348:   iload 8 
L350:   aaload 
L351:   invokevirtual [47] 
L354:   iinc 8 1 
L357:   goto L295 
L360:   iconst_1 
L361:   getstatic [12] 
L364:   imul 
L365:   istore_2 
L366:   getstatic [7] 
L369:   new [61] 
L372:   dup 
L373:   invokespecial [55] 
L376:   ldc [13] 
L378:   invokevirtual [38] 
L381:   iload_2 
L382:   invokevirtual [43] 
L385:   ldc [23] 
L387:   invokevirtual [38] 
L390:   invokevirtual [40] 
L393:   invokevirtual [41] 
L396:   iload_2 
L397:   anewarray [24] 
L400:   astore 7 
L402:   aload_0 
L403:   iconst_2 
L404:   iload_2 
L405:   invokevirtual [49] 
L408:   iconst_0 
L409:   istore 8 
L411:   iload 8 
L413:   iload_2 
L414:   if_icmpge L466 
L417:   aload 7 
L419:   iload 8 
L421:   aload_1 
L422:   getstatic [25] 
L425:   ifnonnull L440 
L428:   ldc [26] 
L430:   invokestatic [27] 
L433:   dup 
L434:   putstatic [58] 
L437:   goto L443 
L440:   getstatic [25] 
L443:   invokevirtual [50] 
L446:   new [65] 
L449:   dup 
L450:   invokespecial [59] 
L453:   aconst_null 
L454:   invokeinterface [66] 0 
L459:   aastore 
L460:   iinc 8 1 
L463:   goto L411 
L466:   aload_0 
L467:   iconst_2 
L468:   iload_2 
L469:   invokevirtual [51] 
L472:   aload_0 
L473:   iconst_3 
L474:   iload_2 
L475:   invokevirtual [49] 
L478:   iconst_0 
L479:   istore 8 
L481:   iload 8 
L483:   iload_2 
L484:   if_icmpge L503 
L487:   aload 7 
L489:   iload 8 
L491:   aaload 
L492:   invokeinterface [67] 0 
L497:   iinc 8 1 
L500:   goto L481 
L503:   aload_0 
L504:   iconst_3 
L505:   iload_2 
L506:   invokevirtual [51] 
L509:   iconst_0 
L510:   istore 8 
L512:   iload 8 
L514:   bipush 25 
L516:   if_icmpge L533 
L519:   aload 6 
L521:   iload 8 
L523:   aaload 
L524:   invokevirtual [48] 
L527:   iinc 8 1 
L530:   goto L512 
L533:   return 
L534:   nop 
L535:   nop 
L536:   
    .end code 
.end method 

.method static synthetic [279] : [280] 
    .attribute [272] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [60] 
L9:     dup 
L10:    invokespecial [53] 
L13:    aload_1 
L14:    invokevirtual [37] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method synthetic [281] : [282] 
    .attribute [272] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [52] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [68] [69] 
.const [3] = Class [70] 
.const [4] = Class [71] 
.const [5] = String [72] 
.const [6] = Field [73] [74] 
.const [7] = Field [75] [76] 
.const [8] = Class [77] 
.const [9] = String [78] 
.const [10] = String [79] 
.const [11] = Field [80] [81] 
.const [12] = Field [82] [83] 
.const [13] = String [84] 
.const [14] = String [85] 
.const [15] = Class [86] 
.const [16] = String [87] 
.const [17] = String [88] 
.const [18] = Class [89] 
.const [19] = Class [90] 
.const [20] = String [91] 
.const [21] = String [92] 
.const [22] = String [93] 
.const [23] = String [94] 
.const [24] = Class [95] 
.const [25] = Field [96] [97] 
.const [26] = String [98] 
.const [27] = Method [99] [100] 
.const [28] = Class [101] 
.const [29] = Class [102] 
.const [30] = Class [103] 
.const [31] = Class [104] 
.const [32] = Class [105] 
.const [33] = Class [106] 
.const [34] = Class [107] 
.const [35] = Class [108] 
.const [36] = Class [109] 
.const [37] = Method [110] [111] 
.const [38] = Method [112] [113] 
.const [39] = Field [114] [115] 
.const [40] = Method [116] [117] 
.const [41] = Method [118] [119] 
.const [42] = Method [120] [121] 
.const [43] = Method [122] [123] 
.const [44] = Method [124] [125] 
.const [45] = Method [126] [127] 
.const [46] = Method [128] [129] 
.const [47] = Method [130] [131] 
.const [48] = Method [132] [133] 
.const [49] = Method [134] [135] 
.const [50] = Method [136] [137] 
.const [51] = Method [138] [139] 
.const [52] = Method [140] [141] 
.const [53] = Method [142] [143] 
.const [54] = Method [144] [145] 
.const [55] = Method [146] [147] 
.const [56] = Method [148] [149] 
.const [57] = Method [150] [151] 
.const [58] = Field [152] [153] 
.const [59] = Method [154] [155] 
.const [60] = Class [156] 
.const [61] = Class [157] 
.const [62] = Class [158] 
.const [63] = InterfaceMethod [159] [160] 
.const [64] = Class [161] 
.const [65] = Class [162] 
.const [66] = InterfaceMethod [163] [164] 
.const [67] = InterfaceMethod [165] [166] 
.const [68] = Class [167] 
.const [69] = NameAndType [168] [169] 
.const [70] = Utf8 java/lang/ClassNotFoundException 
.const [71] = Utf8 java/lang/NoClassDefFoundError 
.const [72] = Utf8 'MMI3g Wildcard Suite' 
.const [73] = Class [170] 
.const [74] = NameAndType [171] [172] 
.const [75] = Class [173] 
.const [76] = NameAndType [174] [175] 
.const [77] = Utf8 java/lang/StringBuffer 
.const [78] = Utf8 'run ' 
.const [79] = Utf8 ' tests' 
.const [80] = Class [176] 
.const [81] = NameAndType [177] [178] 
.const [82] = Class [179] 
.const [83] = NameAndType [180] [181] 
.const [84] = Utf8 'benchmark ' 
.const [85] = Utf8 ' wildcard tracker' 
.const [86] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [87] = Utf8 'mx wildcard DSIListener tracker' 
.const [88] = Utf8 '(& (objectClass = org.dsi.ifc.*.DSIListener) (DEVICE_NAME = *))' 
.const [89] = Utf8 org/osgi/framework/InvalidSyntaxException 
.const [90] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/WildcardBenchmarkSuite$DummyServiceTrackerCustomizer 
.const [91] = Utf8 ' no' 
.const [92] = Utf8 '(& (objectClass = *.TestService) (DEVICE_NAME = *))' 
.const [93] = Utf8 'tracker no' 
.const [94] = Utf8 ' service registrations' 
.const [95] = Utf8 org/osgi/framework/ServiceRegistration 
.const [96] = Class [182] 
.const [97] = NameAndType [183] [184] 
.const [98] = Utf8 'de.dreisoft.lsd.benchmark.mmi3g.BenchmarkTestService' 
.const [99] = Class [185] 
.const [100] = NameAndType [186] [187] 
.const [101] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/BenchmarkTestService 
.const [102] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/WildcardBenchmarkSuite 
.const [103] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/MMI3gBenchmarkSuite 
.const [104] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/WildcardBenchmarkSuite$Suite 
.const [105] = Utf8 java/lang/Class 
.const [106] = Utf8 java/lang/System 
.const [107] = Utf8 java/io/PrintStream 
.const [108] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/BenchmarkBundle 
.const [109] = Utf8 org/osgi/framework/BundleContext 
.const [110] = Class [188] 
.const [111] = NameAndType [189] [190] 
.const [112] = Class [191] 
.const [113] = NameAndType [192] [193] 
.const [114] = Class [194] 
.const [115] = NameAndType [195] [196] 
.const [116] = Class [197] 
.const [117] = NameAndType [198] [199] 
.const [118] = Class [200] 
.const [119] = NameAndType [201] [202] 
.const [120] = Class [203] 
.const [121] = NameAndType [204] [205] 
.const [122] = Class [206] 
.const [123] = NameAndType [207] [208] 
.const [124] = Class [209] 
.const [125] = NameAndType [210] [211] 
.const [126] = Class [212] 
.const [127] = NameAndType [213] [214] 
.const [128] = Class [215] 
.const [129] = NameAndType [216] [217] 
.const [130] = Class [218] 
.const [131] = NameAndType [219] [220] 
.const [132] = Class [221] 
.const [133] = NameAndType [222] [223] 
.const [134] = Class [224] 
.const [135] = NameAndType [225] [226] 
.const [136] = Class [227] 
.const [137] = NameAndType [228] [229] 
.const [138] = Class [230] 
.const [139] = NameAndType [231] [232] 
.const [140] = Class [233] 
.const [141] = NameAndType [234] [235] 
.const [142] = Class [236] 
.const [143] = NameAndType [237] [238] 
.const [144] = Class [239] 
.const [145] = NameAndType [240] [241] 
.const [146] = Class [242] 
.const [147] = NameAndType [243] [244] 
.const [148] = Class [245] 
.const [149] = NameAndType [246] [247] 
.const [150] = Class [248] 
.const [151] = NameAndType [249] [250] 
.const [152] = Class [251] 
.const [153] = NameAndType [252] [253] 
.const [154] = Class [254] 
.const [155] = NameAndType [255] [256] 
.const [156] = Utf8 java/lang/NoClassDefFoundError 
.const [157] = Utf8 java/lang/StringBuffer 
.const [158] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [159] = Class [257] 
.const [160] = NameAndType [258] [259] 
.const [161] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/WildcardBenchmarkSuite$DummyServiceTrackerCustomizer 
.const [162] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/BenchmarkTestService 
.const [163] = Class [260] 
.const [164] = NameAndType [261] [262] 
.const [165] = Class [263] 
.const [166] = NameAndType [264] [265] 
.const [167] = Utf8 java/lang/Class 
.const [168] = Utf8 forName 
.const [169] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [170] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/WildcardBenchmarkSuite$Suite 
.const [171] = Utf8 instance 
.const [172] = Utf8 Lde/dreisoft/lsd/benchmark/mmi3g/WildcardBenchmarkSuite; 
.const [173] = Utf8 java/lang/System 
.const [174] = Utf8 out 
.const [175] = Utf8 Ljava/io/PrintStream; 
.const [176] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/WildcardBenchmarkSuite 
.const [177] = Utf8 bundle 
.const [178] = Utf8 Lde/dreisoft/lsd/benchmark/mmi3g/BenchmarkBundle; 
.const [179] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/WildcardBenchmarkSuite 
.const [180] = Utf8 SAMPLE_MULTIPLIER 
.const [181] = Utf8 I 
.const [182] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/WildcardBenchmarkSuite 
.const [183] = Utf8 class$de$dreisoft$lsd$benchmark$mmi3g$BenchmarkTestService 
.const [184] = Utf8 Ljava/lang/Class; 
.const [185] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/WildcardBenchmarkSuite 
.const [186] = Utf8 class$ 
.const [187] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [188] = Utf8 java/lang/NoClassDefFoundError 
.const [189] = Utf8 initCause 
.const [190] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [191] = Utf8 java/lang/StringBuffer 
.const [192] = Utf8 append 
.const [193] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [194] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/WildcardBenchmarkSuite 
.const [195] = Utf8 name 
.const [196] = Utf8 Ljava/lang/String; 
.const [197] = Utf8 java/lang/StringBuffer 
.const [198] = Utf8 toString 
.const [199] = Utf8 ()Ljava/lang/String; 
.const [200] = Utf8 java/io/PrintStream 
.const [201] = Utf8 println 
.const [202] = Utf8 (Ljava/lang/String;)V 
.const [203] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/BenchmarkBundle 
.const [204] = Utf8 getContext 
.const [205] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [206] = Utf8 java/lang/StringBuffer 
.const [207] = Utf8 append 
.const [208] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [209] = Utf8 org/osgi/framework/InvalidSyntaxException 
.const [210] = Utf8 printStackTrace 
.const [211] = Utf8 ()V 
.const [212] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/WildcardBenchmarkSuite 
.const [213] = Utf8 setStartTag 
.const [214] = Utf8 (IILjava/lang/String;)V 
.const [215] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/WildcardBenchmarkSuite 
.const [216] = Utf8 setEndTag 
.const [217] = Utf8 (IILjava/lang/String;)V 
.const [218] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [219] = Utf8 'open' 
.const [220] = Utf8 ()V 
.const [221] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [222] = Utf8 close 
.const [223] = Utf8 ()V 
.const [224] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/WildcardBenchmarkSuite 
.const [225] = Utf8 setStartTag 
.const [226] = Utf8 (II)V 
.const [227] = Utf8 java/lang/Class 
.const [228] = Utf8 getName 
.const [229] = Utf8 ()Ljava/lang/String; 
.const [230] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/WildcardBenchmarkSuite 
.const [231] = Utf8 setEndTag 
.const [232] = Utf8 (II)V 
.const [233] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/WildcardBenchmarkSuite 
.const [234] = Utf8 <init> 
.const [235] = Utf8 ()V 
.const [236] = Utf8 java/lang/NoClassDefFoundError 
.const [237] = Utf8 <init> 
.const [238] = Utf8 ()V 
.const [239] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/MMI3gBenchmarkSuite 
.const [240] = Utf8 <init> 
.const [241] = Utf8 (Ljava/lang/String;)V 
.const [242] = Utf8 java/lang/StringBuffer 
.const [243] = Utf8 <init> 
.const [244] = Utf8 ()V 
.const [245] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/WildcardBenchmarkSuite$DummyServiceTrackerCustomizer 
.const [246] = Utf8 <init> 
.const [247] = Utf8 (Lde/dreisoft/lsd/benchmark/mmi3g/WildcardBenchmarkSuite;Ljava/lang/String;Z)V 
.const [248] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [249] = Utf8 <init> 
.const [250] = Utf8 (Lorg/osgi/framework/BundleContext;Lorg/osgi/framework/Filter;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [251] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/WildcardBenchmarkSuite 
.const [252] = Utf8 class$de$dreisoft$lsd$benchmark$mmi3g$BenchmarkTestService 
.const [253] = Utf8 Ljava/lang/Class; 
.const [254] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/BenchmarkTestService 
.const [255] = Utf8 <init> 
.const [256] = Utf8 ()V 
.const [257] = Utf8 org/osgi/framework/BundleContext 
.const [258] = Utf8 createFilter 
.const [259] = Utf8 (Ljava/lang/String;)Lorg/osgi/framework/Filter; 
.const [260] = Utf8 org/osgi/framework/BundleContext 
.const [261] = Utf8 registerService 
.const [262] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [263] = Utf8 org/osgi/framework/ServiceRegistration 
.const [264] = Utf8 unregister 
.const [265] = Utf8 ()V 
.const [266] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/WildcardBenchmarkSuite 
.const [267] = Class [266] 
.const [268] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/MMI3gBenchmarkSuite 
.const [269] = Class [268] 
.const [270] = Utf8 class$de$dreisoft$lsd$benchmark$mmi3g$BenchmarkTestService 
.const [271] = Utf8 Ljava/lang/Class; 
.const [272] = Utf8 Code 
.const [273] = Utf8 <init> 
.const [274] = Utf8 ()V 
.const [275] = Utf8 getInstance 
.const [276] = Utf8 ()Lde/dreisoft/lsd/benchmark/mmi3g/WildcardBenchmarkSuite; 
.const [277] = Utf8 runTests 
.const [278] = Utf8 ()V 
.const [279] = Utf8 class$ 
.const [280] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [281] = Utf8 <init> 
.const [282] = Utf8 (Lde/dreisoft/lsd/benchmark/mmi3g/WildcardBenchmarkSuite$1;)V 
.end class 
