.version 50 0 
.class public super [138] 
.super [140] 
.field private static final [141] [142] 
.field private [143] [144] 
.field private [145] [146] 

.method public [148] : [149] 
    .attribute [147] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [28] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [31] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public interface [150] : [151] 
    .attribute [147] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [152] : [153] 
    .attribute [147] .code stack 6 locals 2 
L0:     aload_1 
L1:     invokevirtual [21] 
L4:     astore_2 
L5:     iconst_0 
L6:     istore_3 
L7:     iload_3 
L8:     aload_2 
L9:     arraylength 
L10:    if_icmpge L44 
L13:    aload_0 
L14:    getfield [19] 
L17:    ldc [2] 
L19:    ldc [3] 
L21:    aload_2 
L22:    iload_3 
L23:    aaload 
L24:    invokevirtual [22] 
L27:    aload_2 
L28:    iload_3 
L29:    aaload 
L30:    invokevirtual [23] 
L33:    i2l 
L34:    invokevirtual [24] 
L37:    pop 
L38:    iinc 3 1 
L41:    goto L7 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [154] : [155] 
    .attribute [147] .code stack 9 locals 9 
L0:     aload_1 
L1:     invokestatic [4] 
L4:     ifne L13 
L7:     aload_0 
L8:     aconst_null 
L9:     putfield [32] 
L12:    return 
L13:    aload_0 
L14:    getfield [20] 
L17:    invokestatic [4] 
L20:    ifne L29 
L23:    aload_0 
L24:    aload_1 
L25:    putfield [32] 
L28:    return 
L29:    aload_0 
L30:    aload_0 
L31:    getfield [20] 
L34:    invokespecial [29] 
L37:    aload_0 
L38:    aload_1 
L39:    invokespecial [29] 
L42:    aload_0 
L43:    getfield [20] 
L46:    invokevirtual [21] 
L49:    arraylength 
L50:    istore_3 
L51:    aload_1 
L52:    invokevirtual [21] 
L55:    arraylength 
L56:    istore 4 
L58:    aconst_null 
L59:    astore 5 
L61:    iload_2 
L62:    ifeq L257 
L65:    aload_1 
L66:    invokevirtual [21] 
L69:    iconst_0 
L70:    aaload 
L71:    invokevirtual [23] 
L74:    istore 6 
L76:    aload_0 
L77:    getfield [19] 
L80:    aload_0 
L81:    getfield [20] 
L84:    iload 6 
L86:    invokestatic [5] 
L89:    istore 7 
L91:    iload 7 
L93:    ifge L99 
L96:    iload_3 
L97:    istore 7 
L99:    aload_0 
L100:   getfield [19] 
L103:   ldc [2] 
L105:   ldc [6] 
L107:   iload 7 
L109:   i2l 
L110:   invokevirtual [25] 
L113:   pop 
L114:   iconst_0 
L115:   iload 4 
L117:   iload 7 
L119:   iadd 
L120:   bipush 50 
L122:   isub 
L123:   invokestatic [7] 
L126:   istore 8 
L128:   bipush 50 
L130:   iload 4 
L132:   iload 7 
L134:   iadd 
L135:   invokestatic [8] 
L138:   istore 9 
L140:   aload_0 
L141:   getfield [19] 
L144:   ldc [2] 
L146:   ldc [9] 
L148:   iload_3 
L149:   i2l 
L150:   iload 4 
L152:   i2l 
L153:   invokevirtual [26] 
L156:   pop 
L157:   aload_0 
L158:   getfield [19] 
L161:   ldc [2] 
L163:   ldc [10] 
L165:   iload 8 
L167:   i2l 
L168:   iload 7 
L170:   i2l 
L171:   iload 9 
L173:   i2l 
L174:   invokevirtual [27] 
L177:   pop 
L178:   iload 9 
L180:   anewarray [11] 
L183:   astore 5 
L185:   iconst_0 
L186:   istore 10 
L188:   iload 8 
L190:   istore 11 
L192:   iload 11 
L194:   iload 7 
L196:   if_icmpge L223 
L199:   aload 5 
L201:   iload 10 
L203:   iinc 10 1 
L206:   aload_0 
L207:   getfield [20] 
L210:   invokevirtual [21] 
L213:   iload 11 
L215:   aaload 
L216:   aastore 
L217:   iinc 11 1 
L220:   goto L192 
L223:   iconst_0 
L224:   istore 11 
L226:   iload 11 
L228:   iload 4 
L230:   if_icmpge L254 
L233:   aload 5 
L235:   iload 10 
L237:   iinc 10 1 
L240:   aload_1 
L241:   invokevirtual [21] 
L244:   iload 11 
L246:   aaload 
L247:   aastore 
L248:   iinc 11 1 
L251:   goto L226 
L254:   goto L449 
L257:   aload_1 
L258:   invokevirtual [21] 
L261:   iload 4 
L263:   iconst_1 
L264:   isub 
L265:   aaload 
L266:   invokevirtual [23] 
L269:   istore 6 
L271:   aload_0 
L272:   getfield [19] 
L275:   aload_0 
L276:   getfield [20] 
L279:   iload 6 
L281:   invokestatic [5] 
L284:   iconst_1 
L285:   iadd 
L286:   istore 7 
L288:   iload 7 
L290:   ifge L296 
L293:   iconst_0 
L294:   istore 7 
L296:   aload_0 
L297:   getfield [19] 
L300:   ldc [2] 
L302:   ldc [12] 
L304:   iload 7 
L306:   i2l 
L307:   invokevirtual [25] 
L310:   pop 
L311:   bipush 50 
L313:   iload 7 
L315:   iadd 
L316:   iload 4 
L318:   isub 
L319:   istore 8 
L321:   bipush 50 
L323:   iload 4 
L325:   iload_3 
L326:   iadd 
L327:   iload 7 
L329:   isub 
L330:   invokestatic [8] 
L333:   istore 9 
L335:   aload_0 
L336:   getfield [19] 
L339:   ldc [2] 
L341:   ldc [9] 
L343:   iload_3 
L344:   i2l 
L345:   iload 4 
L347:   i2l 
L348:   invokevirtual [26] 
L351:   pop 
L352:   aload_0 
L353:   getfield [19] 
L356:   ldc [2] 
L358:   ldc [10] 
L360:   iload 7 
L362:   i2l 
L363:   iload 8 
L365:   i2l 
L366:   iload 9 
L368:   i2l 
L369:   invokevirtual [27] 
L372:   pop 
L373:   iload 9 
L375:   anewarray [11] 
L378:   astore 5 
L380:   iconst_0 
L381:   istore 10 
L383:   iconst_0 
L384:   istore 11 
L386:   iload 11 
L388:   iload 4 
L390:   if_icmpge L414 
L393:   aload 5 
L395:   iload 10 
L397:   iinc 10 1 
L400:   aload_1 
L401:   invokevirtual [21] 
L404:   iload 11 
L406:   aaload 
L407:   aastore 
L408:   iinc 11 1 
L411:   goto L386 
L414:   iload 7 
L416:   istore 11 
L418:   iload 11 
L420:   iload 8 
L422:   if_icmpge L449 
L425:   aload 5 
L427:   iload 10 
L429:   iinc 10 1 
L432:   aload_0 
L433:   getfield [20] 
L436:   invokevirtual [21] 
L439:   iload 11 
L441:   aaload 
L442:   aastore 
L443:   iinc 11 1 
L446:   goto L418 
L449:   aload_0 
L450:   new [33] 
L453:   dup 
L454:   aload 5 
L456:   iconst_0 
L457:   iconst_0 
L458:   invokespecial [30] 
L461:   putfield [32] 
L464:   aload_0 
L465:   aload_0 
L466:   getfield [20] 
L469:   invokespecial [29] 
L472:   return 
L473:   nop 
L474:   nop 
L475:   nop 
L476:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [34] 
.const [4] = Method [35] [36] 
.const [5] = Method [37] [38] 
.const [6] = String [39] 
.const [7] = Method [40] [41] 
.const [8] = Method [42] [43] 
.const [9] = String [44] 
.const [10] = String [45] 
.const [11] = Class [46] 
.const [12] = String [47] 
.const [13] = Class [48] 
.const [14] = Class [49] 
.const [15] = Class [50] 
.const [16] = Class [51] 
.const [17] = Class [52] 
.const [18] = Class [53] 
.const [19] = Field [54] [55] 
.const [20] = Field [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Method [66] [67] 
.const [26] = Method [68] [69] 
.const [27] = Method [70] [71] 
.const [28] = Method [72] [73] 
.const [29] = Method [74] [75] 
.const [30] = Method [76] [77] 
.const [31] = Field [78] [79] 
.const [32] = Field [80] [81] 
.const [33] = Class [82] 
.const [34] = Utf8 'LIValueListCache#dumpList() - index: %2, entry: %1' 
.const [35] = Class [83] 
.const [36] = NameAndType [84] [85] 
.const [37] = Class [86] 
.const [38] = NameAndType [87] [88] 
.const [39] = Utf8 'LIValueListCache#updateListPatch() - downwards, found anchor in list at %1' 
.const [40] = Class [89] 
.const [41] = NameAndType [90] [91] 
.const [42] = Class [92] 
.const [43] = NameAndType [93] [94] 
.const [44] = Utf8 'LIValueListCache#updateListPatch() - list sizes %1 / %2' 
.const [45] = Utf8 'LIValueListCache#updateListPatch() - old list segment [%1 / %2), complete new length %3' 
.const [46] = Utf8 org/dsi/ifc/navigation/LIValueListElement 
.const [47] = Utf8 'LIValueListCache#updateListPatch() - upwards, found anchor in list at %1' 
.const [48] = Utf8 org/dsi/ifc/navigation/LIValueList 
.const [49] = Utf8 de/audi/tghu/navi/app/li/LIValueListCache 
.const [50] = Utf8 java/lang/Object 
.const [51] = Utf8 de/audi/atip/log/LogChannel 
.const [52] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [53] = Utf8 java/lang/Math 
.const [54] = Class [95] 
.const [55] = NameAndType [96] [97] 
.const [56] = Class [98] 
.const [57] = NameAndType [99] [100] 
.const [58] = Class [101] 
.const [59] = NameAndType [102] [103] 
.const [60] = Class [104] 
.const [61] = NameAndType [105] [106] 
.const [62] = Class [107] 
.const [63] = NameAndType [108] [109] 
.const [64] = Class [110] 
.const [65] = NameAndType [111] [112] 
.const [66] = Class [113] 
.const [67] = NameAndType [114] [115] 
.const [68] = Class [116] 
.const [69] = NameAndType [117] [118] 
.const [70] = Class [119] 
.const [71] = NameAndType [120] [121] 
.const [72] = Class [122] 
.const [73] = NameAndType [123] [124] 
.const [74] = Class [125] 
.const [75] = NameAndType [126] [127] 
.const [76] = Class [128] 
.const [77] = NameAndType [129] [130] 
.const [78] = Class [131] 
.const [79] = NameAndType [132] [133] 
.const [80] = Class [134] 
.const [81] = NameAndType [135] [136] 
.const [82] = Utf8 org/dsi/ifc/navigation/LIValueList 
.const [83] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [84] = Utf8 isListValid 
.const [85] = Utf8 (Lorg/dsi/ifc/navigation/LIValueList;)Z 
.const [86] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [87] = Utf8 getLIValueListElement 
.const [88] = Utf8 (Lde/audi/atip/log/LogChannel;Lorg/dsi/ifc/navigation/LIValueList;I)I 
.const [89] = Utf8 java/lang/Math 
.const [90] = Utf8 max 
.const [91] = Utf8 (II)I 
.const [92] = Utf8 java/lang/Math 
.const [93] = Utf8 min 
.const [94] = Utf8 (II)I 
.const [95] = Utf8 de/audi/tghu/navi/app/li/LIValueListCache 
.const [96] = Utf8 logChannel 
.const [97] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [98] = Utf8 de/audi/tghu/navi/app/li/LIValueListCache 
.const [99] = Utf8 cachedList 
.const [100] = Utf8 Lorg/dsi/ifc/navigation/LIValueList; 
.const [101] = Utf8 org/dsi/ifc/navigation/LIValueList 
.const [102] = Utf8 getList 
.const [103] = Utf8 ()[Lorg/dsi/ifc/navigation/LIValueListElement; 
.const [104] = Utf8 org/dsi/ifc/navigation/LIValueListElement 
.const [105] = Utf8 getData 
.const [106] = Utf8 ()Ljava/lang/String; 
.const [107] = Utf8 org/dsi/ifc/navigation/LIValueListElement 
.const [108] = Utf8 getListIndex 
.const [109] = Utf8 ()I 
.const [110] = Utf8 de/audi/atip/log/LogChannel 
.const [111] = Utf8 log 
.const [112] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [113] = Utf8 de/audi/atip/log/LogChannel 
.const [114] = Utf8 log 
.const [115] = Utf8 (ILjava/lang/String;J)Z 
.const [116] = Utf8 de/audi/atip/log/LogChannel 
.const [117] = Utf8 log 
.const [118] = Utf8 (ILjava/lang/String;JJ)Z 
.const [119] = Utf8 de/audi/atip/log/LogChannel 
.const [120] = Utf8 log 
.const [121] = Utf8 (ILjava/lang/String;JJJ)Z 
.const [122] = Utf8 java/lang/Object 
.const [123] = Utf8 <init> 
.const [124] = Utf8 ()V 
.const [125] = Utf8 de/audi/tghu/navi/app/li/LIValueListCache 
.const [126] = Utf8 dumpList 
.const [127] = Utf8 (Lorg/dsi/ifc/navigation/LIValueList;)V 
.const [128] = Utf8 org/dsi/ifc/navigation/LIValueList 
.const [129] = Utf8 <init> 
.const [130] = Utf8 ([Lorg/dsi/ifc/navigation/LIValueListElement;ZZ)V 
.const [131] = Utf8 de/audi/tghu/navi/app/li/LIValueListCache 
.const [132] = Utf8 logChannel 
.const [133] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [134] = Utf8 de/audi/tghu/navi/app/li/LIValueListCache 
.const [135] = Utf8 cachedList 
.const [136] = Utf8 Lorg/dsi/ifc/navigation/LIValueList; 
.const [137] = Utf8 de/audi/tghu/navi/app/li/LIValueListCache 
.const [138] = Class [137] 
.const [139] = Utf8 java/lang/Object 
.const [140] = Class [139] 
.const [141] = Utf8 PATCH_MAX_SIZE 
.const [142] = Utf8 I 
.const [143] = Utf8 logChannel 
.const [144] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [145] = Utf8 cachedList 
.const [146] = Utf8 Lorg/dsi/ifc/navigation/LIValueList; 
.const [147] = Utf8 Code 
.const [148] = Utf8 <init> 
.const [149] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [150] = Utf8 getCachedList 
.const [151] = Utf8 ()Lorg/dsi/ifc/navigation/LIValueList; 
.const [152] = Utf8 dumpList 
.const [153] = Utf8 (Lorg/dsi/ifc/navigation/LIValueList;)V 
.const [154] = Utf8 updateCache 
.const [155] = Utf8 (Lorg/dsi/ifc/navigation/LIValueList;Z)V 
.end class 
