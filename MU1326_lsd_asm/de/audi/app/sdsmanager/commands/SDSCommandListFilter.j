.version 50 0 
.class public super [155] 
.super [157] 
.field private static final [158] [159] 
.field private final [160] [161] 
.field private [162] [163] 

.method public [165] : [166] 
    .attribute [164] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     aload_0 
L5:     invokestatic [2] 
L8:     putfield [35] 
L11:    aload_0 
L12:    aload_1 
L13:    putfield [36] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [164] .code stack 7 locals 12 
L0:     aload_0 
L1:     getfield [26] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     ldc [5] 
L10:    aload_1 
L11:    checkcast [6] 
L14:    invokevirtual [28] 
L17:    invokevirtual [29] 
L20:    iconst_0 
L21:    istore_3 
L22:    iconst_0 
L23:    istore 4 
L25:    aload_1 
L26:    checkcast [6] 
L29:    astore 5 
L31:    aload 5 
L33:    invokevirtual [30] 
L36:    astore 6 
L38:    aload 6 
L40:    invokeinterface [37] 0 
L45:    astore 7 
L47:    aload 7 
L49:    invokeinterface [38] 0 
L54:    ifeq L102 
L57:    iload_3 
L58:    ifne L102 
L61:    iload 4 
L63:    ifne L102 
L66:    aload 7 
L68:    invokeinterface [39] 0 
L73:    astore 8 
L75:    aload 8 
L77:    instanceof [7] 
L80:    ifeq L88 
L83:    iconst_1 
L84:    istore_3 
L85:    goto L99 
L88:    aload 8 
L90:    instanceof [8] 
L93:    ifeq L99 
L96:    iconst_1 
L97:    istore 4 
L99:    goto L47 
L102:   iload_3 
L103:   ifne L111 
L106:   iload 4 
L108:   ifeq L402 
L111:   aload_0 
L112:   getfield [27] 
L115:   invokeinterface [40] 0 
L120:   istore 8 
L122:   aload_0 
L123:   getfield [26] 
L126:   ldc [3] 
L128:   ldc [9] 
L130:   ldc [5] 
L132:   iload 8 
L134:   i2l 
L135:   invokevirtual [31] 
L138:   pop 
L139:   iload 8 
L141:   iconst_1 
L142:   isub 
L143:   istore 9 
L145:   iload 9 
L147:   iflt L402 
L150:   aload_0 
L151:   getfield [27] 
L154:   iload 9 
L156:   invokeinterface [41] 0 
L161:   checkcast [6] 
L164:   astore 10 
L166:   aload 10 
L168:   invokevirtual [28] 
L171:   astore 11 
L173:   aload_0 
L174:   getfield [26] 
L177:   ldc [3] 
L179:   ldc [10] 
L181:   ldc [5] 
L183:   aload 11 
L185:   iload 9 
L187:   i2l 
L188:   invokevirtual [32] 
L191:   aload 10 
L193:   invokevirtual [30] 
L196:   invokeinterface [37] 0 
L201:   astore 7 
L203:   aload 7 
L205:   invokeinterface [38] 0 
L210:   ifeq L378 
L213:   aload_0 
L214:   getfield [26] 
L217:   ldc [3] 
L219:   ldc [11] 
L221:   ldc [5] 
L223:   aload 11 
L225:   iload 9 
L227:   i2l 
L228:   invokevirtual [32] 
L231:   aload 7 
L233:   invokeinterface [39] 0 
L238:   checkcast [12] 
L241:   astore 12 
L243:   aload 12 
L245:   instanceof [8] 
L248:   ifeq L259 
L251:   iload_3 
L252:   ifeq L259 
L255:   iconst_1 
L256:   goto L260 
L259:   iconst_0 
L260:   istore 13 
L262:   iload 13 
L264:   ifeq L287 
L267:   aload_0 
L268:   getfield [26] 
L271:   ldc [3] 
L273:   ldc [13] 
L275:   ldc [5] 
L277:   iload 9 
L279:   i2l 
L280:   invokevirtual [31] 
L283:   pop 
L284:   goto L402 
L287:   aload 12 
L289:   instanceof [7] 
L292:   ifeq L299 
L295:   iload_3 
L296:   ifne L312 
L299:   aload 12 
L301:   instanceof [8] 
L304:   ifeq L316 
L307:   iload 4 
L309:   ifeq L316 
L312:   iconst_1 
L313:   goto L317 
L316:   iconst_0 
L317:   istore 14 
L319:   iload 14 
L321:   ifeq L357 
L324:   aload_0 
L325:   getfield [26] 
L328:   ldc [3] 
L330:   ldc [14] 
L332:   ldc [5] 
L334:   aload 11 
L336:   iload 9 
L338:   i2l 
L339:   invokevirtual [32] 
L342:   aload_0 
L343:   getfield [27] 
L346:   iload 9 
L348:   invokeinterface [42] 0 
L353:   pop 
L354:   goto L375 
L357:   aload_0 
L358:   getfield [26] 
L361:   ldc [15] 
L363:   ldc [16] 
L365:   ldc [5] 
L367:   aload 11 
L369:   iload 9 
L371:   i2l 
L372:   invokevirtual [32] 
L375:   goto L396 
L378:   aload_0 
L379:   getfield [26] 
L382:   ldc [15] 
L384:   ldc [17] 
L386:   ldc [5] 
L388:   aload 11 
L390:   iload 9 
L392:   i2l 
L393:   invokevirtual [32] 
L396:   iinc 9 -1 
L399:   goto L145 
L402:   aload_0 
L403:   aload_1 
L404:   checkcast [18] 
L407:   iload_2 
L408:   invokespecial [34] 
L411:   return 
L412:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [43] [44] 
.const [3] = Int 1078071040 
.const [4] = String [45] 
.const [5] = String [46] 
.const [6] = Class [47] 
.const [7] = Class [48] 
.const [8] = Class [49] 
.const [9] = String [50] 
.const [10] = String [51] 
.const [11] = String [52] 
.const [12] = Class [53] 
.const [13] = String [54] 
.const [14] = String [55] 
.const [15] = Int -1601830656 
.const [16] = String [56] 
.const [17] = String [57] 
.const [18] = Class [58] 
.const [19] = Class [59] 
.const [20] = Class [60] 
.const [21] = Class [61] 
.const [22] = Class [62] 
.const [23] = Class [63] 
.const [24] = Class [64] 
.const [25] = Class [65] 
.const [26] = Field [66] [67] 
.const [27] = Field [68] [69] 
.const [28] = Method [70] [71] 
.const [29] = Method [72] [73] 
.const [30] = Method [74] [75] 
.const [31] = Method [76] [77] 
.const [32] = Method [78] [79] 
.const [33] = Method [80] [81] 
.const [34] = Method [82] [83] 
.const [35] = Field [84] [85] 
.const [36] = Field [86] [87] 
.const [37] = InterfaceMethod [88] [89] 
.const [38] = InterfaceMethod [90] [91] 
.const [39] = InterfaceMethod [92] [93] 
.const [40] = InterfaceMethod [94] [95] 
.const [41] = InterfaceMethod [96] [97] 
.const [42] = InterfaceMethod [98] [99] 
.const [43] = Class [100] 
.const [44] = NameAndType [101] [102] 
.const [45] = Utf8 '[%1.enqueue] %2' 
.const [46] = Utf8 SDSCommandListFilter 
.const [47] = Utf8 de/audi/tghu/command/CommandList 
.const [48] = Utf8 de/audi/app/sdsmanager/commands/CommandSetGrammarContext 
.const [49] = Utf8 de/audi/app/sdsmanager/commands/CommandRecognition 
.const [50] = Utf8 '[%1.enqueue] commandListQueueLength=%2, checking if queued job is available!' 
.const [51] = Utf8 '[%1.enqueue] Checking command list %2 (#%3)!' 
.const [52] = Utf8 '[%1.enqueue] Checking first command of command list %2 (#%3)!' 
.const [53] = Utf8 de/audi/tghu/command/Command 
.const [54] = Utf8 '[%1.enqueue] Stopping filter because of recognition job at queue position %2!' 
.const [55] = Utf8 '[%1.enqueue] Removing command list %2 (#%3)!' 
.const [56] = Utf8 '[%1.enqueue] Keeping command list %2 (#%3)!' 
.const [57] = Utf8 '[%1.enqueue] command list %2 (#%3) is empty!' 
.const [58] = Utf8 de/esolutions/fw/util/commons/job/Job 
.const [59] = Utf8 de/audi/app/sdsmanager/commands/SDSCommandListFilter 
.const [60] = Utf8 de/esolutions/fw/util/commons/job/BaseJobFilter 
.const [61] = Utf8 de/audi/app/sdsmanager/common/Logger 
.const [62] = Utf8 de/audi/atip/log/LogChannel 
.const [63] = Utf8 java/util/Collection 
.const [64] = Utf8 java/util/Iterator 
.const [65] = Utf8 java/util/List 
.const [66] = Class [103] 
.const [67] = NameAndType [104] [105] 
.const [68] = Class [106] 
.const [69] = NameAndType [107] [108] 
.const [70] = Class [109] 
.const [71] = NameAndType [110] [111] 
.const [72] = Class [112] 
.const [73] = NameAndType [113] [114] 
.const [74] = Class [115] 
.const [75] = NameAndType [116] [117] 
.const [76] = Class [118] 
.const [77] = NameAndType [119] [120] 
.const [78] = Class [121] 
.const [79] = NameAndType [122] [123] 
.const [80] = Class [124] 
.const [81] = NameAndType [125] [126] 
.const [82] = Class [127] 
.const [83] = NameAndType [128] [129] 
.const [84] = Class [130] 
.const [85] = NameAndType [131] [132] 
.const [86] = Class [133] 
.const [87] = NameAndType [134] [135] 
.const [88] = Class [136] 
.const [89] = NameAndType [137] [138] 
.const [90] = Class [139] 
.const [91] = NameAndType [140] [141] 
.const [92] = Class [142] 
.const [93] = NameAndType [143] [144] 
.const [94] = Class [145] 
.const [95] = NameAndType [146] [147] 
.const [96] = Class [148] 
.const [97] = NameAndType [149] [150] 
.const [98] = Class [151] 
.const [99] = NameAndType [152] [153] 
.const [100] = Utf8 de/audi/app/sdsmanager/common/Logger 
.const [101] = Utf8 getCommandLog 
.const [102] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [103] = Utf8 de/audi/app/sdsmanager/commands/SDSCommandListFilter 
.const [104] = Utf8 lc 
.const [105] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [106] = Utf8 de/audi/app/sdsmanager/commands/SDSCommandListFilter 
.const [107] = Utf8 commandListQueue 
.const [108] = Utf8 Ljava/util/List; 
.const [109] = Utf8 de/audi/tghu/command/CommandList 
.const [110] = Utf8 getName 
.const [111] = Utf8 ()Ljava/lang/String; 
.const [112] = Utf8 de/audi/atip/log/LogChannel 
.const [113] = Utf8 log 
.const [114] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [115] = Utf8 de/audi/tghu/command/CommandList 
.const [116] = Utf8 getCommands 
.const [117] = Utf8 ()Ljava/util/Collection; 
.const [118] = Utf8 de/audi/atip/log/LogChannel 
.const [119] = Utf8 log 
.const [120] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [121] = Utf8 de/audi/atip/log/LogChannel 
.const [122] = Utf8 log 
.const [123] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;J)V 
.const [124] = Utf8 de/esolutions/fw/util/commons/job/BaseJobFilter 
.const [125] = Utf8 <init> 
.const [126] = Utf8 ()V 
.const [127] = Utf8 de/esolutions/fw/util/commons/job/BaseJobFilter 
.const [128] = Utf8 enqueue 
.const [129] = Utf8 (Lde/esolutions/fw/util/commons/job/Job;I)V 
.const [130] = Utf8 de/audi/app/sdsmanager/commands/SDSCommandListFilter 
.const [131] = Utf8 lc 
.const [132] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [133] = Utf8 de/audi/app/sdsmanager/commands/SDSCommandListFilter 
.const [134] = Utf8 commandListQueue 
.const [135] = Utf8 Ljava/util/List; 
.const [136] = Utf8 java/util/Collection 
.const [137] = Utf8 iterator 
.const [138] = Utf8 ()Ljava/util/Iterator; 
.const [139] = Utf8 java/util/Iterator 
.const [140] = Utf8 hasNext 
.const [141] = Utf8 ()Z 
.const [142] = Utf8 java/util/Iterator 
.const [143] = Utf8 next 
.const [144] = Utf8 ()Ljava/lang/Object; 
.const [145] = Utf8 java/util/List 
.const [146] = Utf8 size 
.const [147] = Utf8 ()I 
.const [148] = Utf8 java/util/List 
.const [149] = Utf8 get 
.const [150] = Utf8 (I)Ljava/lang/Object; 
.const [151] = Utf8 java/util/List 
.const [152] = Utf8 remove 
.const [153] = Utf8 (I)Ljava/lang/Object; 
.const [154] = Utf8 de/audi/app/sdsmanager/commands/SDSCommandListFilter 
.const [155] = Class [154] 
.const [156] = Utf8 de/esolutions/fw/util/commons/job/BaseJobFilter 
.const [157] = Class [156] 
.const [158] = Utf8 LOGCLASS 
.const [159] = Utf8 Ljava/lang/String; 
.const [160] = Utf8 commandListQueue 
.const [161] = Utf8 Ljava/util/List; 
.const [162] = Utf8 lc 
.const [163] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [164] = Utf8 Code 
.const [165] = Utf8 <init> 
.const [166] = Utf8 (Ljava/util/List;)V 
.const [167] = Utf8 enqueue 
.const [168] = Utf8 (Ljava/lang/Object;I)V 
.end class 
