.version 50 0 
.class public super [211] 
.super [213] 

.method private [215] : [216] 
    .attribute [214] .code stack 2 locals 0 
L0:     aload_0 
L1:     ldc [2] 
L3:     invokespecial [47] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [217] : [218] 
    .attribute [214] .code stack 1 locals 0 
L0:     getstatic [3] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [219] : [220] 
    .attribute [214] .code stack 11 locals 9 
L0:     getstatic [4] 
L3:     new [52] 
L6:     dup 
L7:     invokespecial [48] 
L10:    ldc [6] 
L12:    invokevirtual [34] 
L15:    aload_0 
L16:    getfield [35] 
L19:    invokevirtual [34] 
L22:    ldc [7] 
L24:    invokevirtual [34] 
L27:    invokevirtual [36] 
L30:    invokevirtual [37] 
L33:    getstatic [8] 
L36:    ifnull L441 
L39:    getstatic [8] 
L42:    invokevirtual [38] 
L45:    astore_1 
L46:    aconst_null 
L47:    astore 4 
L49:    aconst_null 
L50:    astore 5 
L52:    bipush 10 
L54:    getstatic [9] 
L57:    imul 
L58:    istore_2 
L59:    getstatic [4] 
L62:    new [52] 
L65:    dup 
L66:    invokespecial [48] 
L69:    ldc [10] 
L71:    invokevirtual [34] 
L74:    iload_2 
L75:    invokevirtual [39] 
L78:    ldc [11] 
L80:    invokevirtual [34] 
L83:    invokevirtual [36] 
L86:    invokevirtual [37] 
L89:    iload_2 
L90:    anewarray [12] 
L93:    astore 5 
L95:    ldc [13] 
L97:    astore_3 
L98:    aload_0 
L99:    iconst_4 
L100:   iload_2 
L101:   aload_3 
L102:   invokevirtual [40] 
L105:   iconst_0 
L106:   istore 8 
L108:   iload 8 
L110:   iload_2 
L111:   if_icmpge L142 
        .catch [14] from L114 to L126 using L129 
L114:   aload 5 
L116:   iload 8 
L118:   aload_1 
L119:   aload_3 
L120:   invokeinterface [53] 0 
L125:   aastore 
L126:   goto L136 
L129:   astore 9 
L131:   aload 9 
L133:   invokevirtual [41] 
L136:   iinc 8 1 
L139:   goto L108 
L142:   aload_0 
L143:   iconst_4 
L144:   iload_2 
L145:   aload_3 
L146:   invokevirtual [42] 
L149:   new [54] 
L152:   dup 
L153:   invokespecial [49] 
L156:   astore 8 
L158:   aload 8 
L160:   ldc [16] 
L162:   iconst_1 
L163:   anewarray [17] 
L166:   dup 
L167:   iconst_0 
L168:   ldc [18] 
L170:   aastore 
L171:   invokevirtual [43] 
L174:   pop 
L175:   aload 8 
L177:   ldc [19] 
L179:   ldc [20] 
L181:   invokevirtual [43] 
L184:   pop 
L185:   aload_0 
L186:   iconst_5 
L187:   iload_2 
L188:   aload_3 
L189:   invokevirtual [40] 
L192:   iconst_0 
L193:   istore 9 
L195:   iload 9 
L197:   iload_2 
L198:   if_icmpge L220 
L201:   aload 5 
L203:   iload 9 
L205:   aaload 
L206:   aload 8 
L208:   invokeinterface [55] 0 
L213:   pop 
L214:   iinc 9 1 
L217:   goto L195 
L220:   aload_0 
L221:   iconst_5 
L222:   iload_2 
L223:   aload_3 
L224:   invokevirtual [42] 
L227:   iconst_1 
L228:   getstatic [9] 
L231:   imul 
L232:   istore_2 
L233:   getstatic [4] 
L236:   new [52] 
L239:   dup 
L240:   invokespecial [48] 
L243:   ldc [10] 
L245:   invokevirtual [34] 
L248:   iload_2 
L249:   invokevirtual [39] 
L252:   ldc [21] 
L254:   invokevirtual [34] 
L257:   invokevirtual [36] 
L260:   invokevirtual [37] 
L263:   iload_2 
L264:   anewarray [22] 
L267:   astore 7 
L269:   ldc [23] 
L271:   astore 6 
L273:   ldc [13] 
L275:   astore_3 
        .catch [14] from L276 to L285 using L288 
L276:   aload_1 
L277:   aload_3 
L278:   invokeinterface [53] 0 
L283:   astore 4 
L285:   goto L295 
L288:   astore 9 
L290:   aload 9 
L292:   invokevirtual [41] 
L295:   aload_0 
L296:   bipush 6 
L298:   iload_2 
L299:   aload 6 
L301:   invokevirtual [40] 
L304:   iconst_0 
L305:   istore 9 
L307:   iload 9 
L309:   iload_2 
L310:   if_icmpge L368 
L313:   aload 7 
L315:   iload 9 
L317:   new [56] 
L320:   dup 
L321:   aload_1 
L322:   aload 4 
L324:   new [57] 
L327:   dup 
L328:   aload_0 
L329:   new [52] 
L332:   dup 
L333:   invokespecial [48] 
L336:   aload 6 
L338:   invokevirtual [34] 
L341:   ldc [25] 
L343:   invokevirtual [34] 
L346:   iload 9 
L348:   invokevirtual [39] 
L351:   invokevirtual [36] 
L354:   iconst_0 
L355:   invokespecial [50] 
L358:   invokespecial [51] 
L361:   aastore 
L362:   iinc 9 1 
L365:   goto L307 
L368:   aload_0 
L369:   bipush 6 
L371:   iload_2 
L372:   aload 6 
L374:   invokevirtual [42] 
L377:   aload_0 
L378:   bipush 7 
L380:   iload_2 
L381:   aload 6 
L383:   invokevirtual [40] 
L386:   iconst_0 
L387:   istore 9 
L389:   iload 9 
L391:   iload_2 
L392:   if_icmpge L409 
L395:   aload 7 
L397:   iload 9 
L399:   aaload 
L400:   invokevirtual [44] 
L403:   iinc 9 1 
L406:   goto L389 
L409:   aload_0 
L410:   bipush 7 
L412:   iload_2 
L413:   aload 6 
L415:   invokevirtual [42] 
L418:   iconst_0 
L419:   istore 9 
L421:   iload 9 
L423:   iload_2 
L424:   if_icmpge L441 
L427:   aload 7 
L429:   iload 9 
L431:   aaload 
L432:   invokevirtual [45] 
L435:   iinc 9 1 
L438:   goto L421 
L441:   return 
L442:   nop 
L443:   nop 
L444:   
    .end code 
.end method 

.method synthetic [221] : [222] 
    .attribute [214] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [46] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [58] 
.const [3] = Field [59] [60] 
.const [4] = Field [61] [62] 
.const [5] = Class [63] 
.const [6] = String [64] 
.const [7] = String [65] 
.const [8] = Field [66] [67] 
.const [9] = Field [68] [69] 
.const [10] = String [70] 
.const [11] = String [71] 
.const [12] = Class [72] 
.const [13] = String [73] 
.const [14] = Class [74] 
.const [15] = Class [75] 
.const [16] = String [76] 
.const [17] = Class [77] 
.const [18] = String [78] 
.const [19] = String [79] 
.const [20] = String [80] 
.const [21] = String [81] 
.const [22] = Class [82] 
.const [23] = String [83] 
.const [24] = Class [84] 
.const [25] = String [85] 
.const [26] = Class [86] 
.const [27] = Class [87] 
.const [28] = Class [88] 
.const [29] = Class [89] 
.const [30] = Class [90] 
.const [31] = Class [91] 
.const [32] = Class [92] 
.const [33] = Class [93] 
.const [34] = Method [94] [95] 
.const [35] = Field [96] [97] 
.const [36] = Method [98] [99] 
.const [37] = Method [100] [101] 
.const [38] = Method [102] [103] 
.const [39] = Method [104] [105] 
.const [40] = Method [106] [107] 
.const [41] = Method [108] [109] 
.const [42] = Method [110] [111] 
.const [43] = Method [112] [113] 
.const [44] = Method [114] [115] 
.const [45] = Method [116] [117] 
.const [46] = Method [118] [119] 
.const [47] = Method [120] [121] 
.const [48] = Method [122] [123] 
.const [49] = Method [124] [125] 
.const [50] = Method [126] [127] 
.const [51] = Method [128] [129] 
.const [52] = Class [130] 
.const [53] = InterfaceMethod [131] [132] 
.const [54] = Class [133] 
.const [55] = InterfaceMethod [134] [135] 
.const [56] = Class [136] 
.const [57] = Class [137] 
.const [58] = Utf8 'MMI3g Filter Suite' 
.const [59] = Class [138] 
.const [60] = NameAndType [139] [140] 
.const [61] = Class [141] 
.const [62] = NameAndType [142] [143] 
.const [63] = Utf8 java/lang/StringBuffer 
.const [64] = Utf8 'run ' 
.const [65] = Utf8 ' tests' 
.const [66] = Class [144] 
.const [67] = NameAndType [145] [146] 
.const [68] = Class [147] 
.const [69] = NameAndType [148] [149] 
.const [70] = Utf8 'benchmark ' 
.const [71] = Utf8 ' filter' 
.const [72] = Utf8 org/osgi/framework/Filter 
.const [73] = Utf8 '(& (objectClass = org.dsi.ifc.base.DSIListener) (|(DEVICE_NAME = org.dsi.ifc.mediaplayer.DSIMediaPlayerListener)  (DEVICE_NAME = org.dsi.ifc.tvtuner.DSITVTunerListener)  (DEVICE_NAME = org.dsi.ifc.amfmtuner.DSIAmFmTunerListener)  (DEVICE_NAME = org.dsi.ifc.audiomanagement.DSIAudioManagementListener)  (DEVICE_NAME = org.dsi.ifc.sound.DSISoundListener)))' 
.const [74] = Utf8 org/osgi/framework/InvalidSyntaxException 
.const [75] = Utf8 java/util/Hashtable 
.const [76] = Utf8 objectClass 
.const [77] = Utf8 java/lang/String 
.const [78] = Utf8 'org.dsi.ifc.base.DSIListener' 
.const [79] = Utf8 DEVICE_NAME 
.const [80] = Utf8 'org.dsi.ifc.mediaplayer.DSIMediaPlayerListener' 
.const [81] = Utf8 ' filtered trackers' 
.const [82] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [83] = Utf8 'mx filtered DSIListener tracker' 
.const [84] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/FilterBenchmarkSuite$DummyServiceTrackerCustomizer 
.const [85] = Utf8 ' no' 
.const [86] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/FilterBenchmarkSuite 
.const [87] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/MMI3gBenchmarkSuite 
.const [88] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/FilterBenchmarkSuite$Suite 
.const [89] = Utf8 java/lang/System 
.const [90] = Utf8 java/io/PrintStream 
.const [91] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/BenchmarkBundle 
.const [92] = Utf8 org/osgi/framework/BundleContext 
.const [93] = Utf8 java/util/Dictionary 
.const [94] = Class [150] 
.const [95] = NameAndType [151] [152] 
.const [96] = Class [153] 
.const [97] = NameAndType [154] [155] 
.const [98] = Class [156] 
.const [99] = NameAndType [157] [158] 
.const [100] = Class [159] 
.const [101] = NameAndType [160] [161] 
.const [102] = Class [162] 
.const [103] = NameAndType [163] [164] 
.const [104] = Class [165] 
.const [105] = NameAndType [166] [167] 
.const [106] = Class [168] 
.const [107] = NameAndType [169] [170] 
.const [108] = Class [171] 
.const [109] = NameAndType [172] [173] 
.const [110] = Class [174] 
.const [111] = NameAndType [175] [176] 
.const [112] = Class [177] 
.const [113] = NameAndType [178] [179] 
.const [114] = Class [180] 
.const [115] = NameAndType [181] [182] 
.const [116] = Class [183] 
.const [117] = NameAndType [184] [185] 
.const [118] = Class [186] 
.const [119] = NameAndType [187] [188] 
.const [120] = Class [189] 
.const [121] = NameAndType [190] [191] 
.const [122] = Class [192] 
.const [123] = NameAndType [193] [194] 
.const [124] = Class [195] 
.const [125] = NameAndType [196] [197] 
.const [126] = Class [198] 
.const [127] = NameAndType [199] [200] 
.const [128] = Class [201] 
.const [129] = NameAndType [202] [203] 
.const [130] = Utf8 java/lang/StringBuffer 
.const [131] = Class [204] 
.const [132] = NameAndType [205] [206] 
.const [133] = Utf8 java/util/Hashtable 
.const [134] = Class [207] 
.const [135] = NameAndType [208] [209] 
.const [136] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [137] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/FilterBenchmarkSuite$DummyServiceTrackerCustomizer 
.const [138] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/FilterBenchmarkSuite$Suite 
.const [139] = Utf8 instance 
.const [140] = Utf8 Lde/dreisoft/lsd/benchmark/mmi3g/FilterBenchmarkSuite; 
.const [141] = Utf8 java/lang/System 
.const [142] = Utf8 out 
.const [143] = Utf8 Ljava/io/PrintStream; 
.const [144] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/FilterBenchmarkSuite 
.const [145] = Utf8 bundle 
.const [146] = Utf8 Lde/dreisoft/lsd/benchmark/mmi3g/BenchmarkBundle; 
.const [147] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/FilterBenchmarkSuite 
.const [148] = Utf8 SAMPLE_MULTIPLIER 
.const [149] = Utf8 I 
.const [150] = Utf8 java/lang/StringBuffer 
.const [151] = Utf8 append 
.const [152] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [153] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/FilterBenchmarkSuite 
.const [154] = Utf8 name 
.const [155] = Utf8 Ljava/lang/String; 
.const [156] = Utf8 java/lang/StringBuffer 
.const [157] = Utf8 toString 
.const [158] = Utf8 ()Ljava/lang/String; 
.const [159] = Utf8 java/io/PrintStream 
.const [160] = Utf8 println 
.const [161] = Utf8 (Ljava/lang/String;)V 
.const [162] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/BenchmarkBundle 
.const [163] = Utf8 getContext 
.const [164] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [165] = Utf8 java/lang/StringBuffer 
.const [166] = Utf8 append 
.const [167] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [168] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/FilterBenchmarkSuite 
.const [169] = Utf8 setStartTag 
.const [170] = Utf8 (IILjava/lang/String;)V 
.const [171] = Utf8 org/osgi/framework/InvalidSyntaxException 
.const [172] = Utf8 printStackTrace 
.const [173] = Utf8 ()V 
.const [174] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/FilterBenchmarkSuite 
.const [175] = Utf8 setEndTag 
.const [176] = Utf8 (IILjava/lang/String;)V 
.const [177] = Utf8 java/util/Dictionary 
.const [178] = Utf8 put 
.const [179] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [180] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [181] = Utf8 'open' 
.const [182] = Utf8 ()V 
.const [183] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [184] = Utf8 close 
.const [185] = Utf8 ()V 
.const [186] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/FilterBenchmarkSuite 
.const [187] = Utf8 <init> 
.const [188] = Utf8 ()V 
.const [189] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/MMI3gBenchmarkSuite 
.const [190] = Utf8 <init> 
.const [191] = Utf8 (Ljava/lang/String;)V 
.const [192] = Utf8 java/lang/StringBuffer 
.const [193] = Utf8 <init> 
.const [194] = Utf8 ()V 
.const [195] = Utf8 java/util/Hashtable 
.const [196] = Utf8 <init> 
.const [197] = Utf8 ()V 
.const [198] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/FilterBenchmarkSuite$DummyServiceTrackerCustomizer 
.const [199] = Utf8 <init> 
.const [200] = Utf8 (Lde/dreisoft/lsd/benchmark/mmi3g/FilterBenchmarkSuite;Ljava/lang/String;Z)V 
.const [201] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [202] = Utf8 <init> 
.const [203] = Utf8 (Lorg/osgi/framework/BundleContext;Lorg/osgi/framework/Filter;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [204] = Utf8 org/osgi/framework/BundleContext 
.const [205] = Utf8 createFilter 
.const [206] = Utf8 (Ljava/lang/String;)Lorg/osgi/framework/Filter; 
.const [207] = Utf8 org/osgi/framework/Filter 
.const [208] = Utf8 match 
.const [209] = Utf8 (Ljava/util/Dictionary;)Z 
.const [210] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/FilterBenchmarkSuite 
.const [211] = Class [210] 
.const [212] = Utf8 de/dreisoft/lsd/benchmark/mmi3g/MMI3gBenchmarkSuite 
.const [213] = Class [212] 
.const [214] = Utf8 Code 
.const [215] = Utf8 <init> 
.const [216] = Utf8 ()V 
.const [217] = Utf8 getInstance 
.const [218] = Utf8 ()Lde/dreisoft/lsd/benchmark/mmi3g/FilterBenchmarkSuite; 
.const [219] = Utf8 runTests 
.const [220] = Utf8 ()V 
.const [221] = Utf8 <init> 
.const [222] = Utf8 (Lde/dreisoft/lsd/benchmark/mmi3g/FilterBenchmarkSuite$1;)V 
.end class 
