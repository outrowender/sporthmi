.version 50 0 
.class public super [247] 
.super [249] 
.field private final [250] [251] 
.field private final [252] [253] 
.field private final [254] [255] 
.field private final [256] [257] 
.field private final [258] [259] 
.field private static final [260] [261] 

.method public [263] : [264] 
    .attribute [262] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     bipush -2 
L5:     bipush -2 
L7:     iload_3 
L8:     invokespecial [43] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [265] : [266] 
    .attribute [262] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     bipush -2 
L5:     bipush -2 
L7:     iconst_0 
L8:     invokespecial [43] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [267] : [268] 
    .attribute [262] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     iload_3 
L4:     iload 4 
L6:     iconst_0 
L7:     invokespecial [43] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [269] : [270] 
    .attribute [262] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [44] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [48] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [49] 
L14:    aload_0 
L15:    iload 5 
L17:    putfield [50] 
L20:    aload_0 
L21:    iload_3 
L22:    putfield [51] 
L25:    aload_0 
L26:    iload 4 
L28:    putfield [52] 
L31:    return 
L32:    
    .end code 
.end method 

.method public [271] : [272] 
    .attribute [262] .code stack 9 locals 8 
L0:     aload_0 
L1:     getfield [28] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_0 
L9:     getfield [25] 
L12:    i2l 
L13:    invokevirtual [29] 
L16:    pop 
L17:    iconst_0 
L18:    istore_1 
L19:    aload_0 
L20:    getfield [30] 
L23:    invokevirtual [31] 
L26:    astore_2 
L27:    aload_2 
L28:    ifnull L47 
L31:    aload_2 
L32:    invokevirtual [32] 
L35:    ifnull L47 
L38:    aload_2 
L39:    invokevirtual [32] 
L42:    arraylength 
L43:    istore_1 
L44:    goto L59 
L47:    aload_0 
L48:    invokevirtual [33] 
L51:    ldc [4] 
L53:    invokeinterface [53] 0 
L58:    return 
L59:    aload_0 
L60:    getfield [30] 
L63:    invokevirtual [34] 
L66:    dup 
L67:    astore_3 
L68:    ifnonnull L83 
L71:    aload_0 
L72:    invokevirtual [33] 
L75:    ldc [5] 
L77:    invokeinterface [53] 0 
L82:    return 
L83:    aload_0 
L84:    getfield [24] 
L87:    invokeinterface [54] 0 
L92:    astore 4 
L94:    aload_0 
L95:    getfield [28] 
L98:    ldc [2] 
L100:   ldc [6] 
L102:   iload_1 
L103:   i2l 
L104:   invokevirtual [29] 
L107:   pop 
L108:   iload_1 
L109:   aload_0 
L110:   getfield [25] 
L113:   if_icmpge L120 
L116:   iconst_1 
L117:   goto L121 
L120:   iconst_0 
L121:   istore 5 
L123:   aload_3 
L124:   invokevirtual [35] 
L127:   iconst_1 
L128:   if_icmpeq L135 
L131:   iconst_1 
L132:   goto L136 
L135:   iconst_0 
L136:   istore 6 
L138:   aload_3 
L139:   invokevirtual [35] 
L142:   iconst_3 
L143:   if_icmpeq L150 
L146:   iconst_1 
L147:   goto L151 
L150:   iconst_0 
L151:   istore 7 
L153:   aload_3 
L154:   invokevirtual [36] 
L157:   aload_0 
L158:   getfield [25] 
L161:   if_icmplt L168 
L164:   iconst_1 
L165:   goto L169 
L168:   iconst_0 
L169:   istore 8 
L171:   aload_0 
L172:   getfield [28] 
L175:   ldc [2] 
L177:   ldc [7] 
L179:   iload 5 
L181:   iload 6 
L183:   iload 7 
L185:   invokevirtual [37] 
L188:   iload 5 
L190:   ifeq L203 
L193:   iload 6 
L195:   ifeq L203 
L198:   iload 7 
L200:   ifne L218 
L203:   iload 5 
L205:   ifeq L315 
L208:   iload 7 
L210:   ifne L315 
L213:   iload 8 
L215:   ifeq L315 
L218:   iload_1 
L219:   ifne L254 
L222:   aload_0 
L223:   getfield [28] 
L226:   ldc [2] 
L228:   ldc [6] 
L230:   iload_1 
L231:   i2l 
L232:   invokevirtual [29] 
L235:   pop 
L236:   aload 4 
L238:   new [55] 
L241:   dup 
L242:   iload_1 
L243:   iconst_1 
L244:   invokespecial [45] 
L247:   invokevirtual [38] 
L250:   pop 
L251:   goto L279 
L254:   aload 4 
L256:   new [55] 
L259:   dup 
L260:   aload_2 
L261:   invokevirtual [32] 
L264:   iload_1 
L265:   iconst_1 
L266:   isub 
L267:   aaload 
L268:   invokevirtual [39] 
L271:   iconst_1 
L272:   invokespecial [45] 
L275:   invokevirtual [38] 
L278:   pop 
L279:   aload 4 
L281:   new [56] 
L284:   dup 
L285:   aload_0 
L286:   getfield [23] 
L289:   aload_0 
L290:   getfield [24] 
L293:   aload_0 
L294:   getfield [26] 
L297:   aload_0 
L298:   getfield [27] 
L301:   aload_0 
L302:   getfield [25] 
L305:   invokespecial [43] 
L308:   invokevirtual [38] 
L311:   pop 
L312:   goto L441 
L315:   aload_0 
L316:   getfield [28] 
L319:   invokevirtual [40] 
L322:   ifeq L352 
L325:   aload_0 
L326:   getfield [28] 
L329:   ldc [10] 
L331:   ldc [11] 
L333:   aload_0 
L334:   getfield [26] 
L337:   i2l 
L338:   aload_0 
L339:   getfield [27] 
L342:   i2l 
L343:   aload_0 
L344:   getfield [25] 
L347:   i2l 
L348:   invokevirtual [41] 
L351:   pop 
L352:   aload_0 
L353:   getfield [26] 
L356:   bipush -2 
L358:   if_icmpeq L370 
L361:   aload_0 
L362:   getfield [27] 
L365:   bipush -2 
L367:   if_icmpne L390 
L370:   aload 4 
L372:   new [57] 
L375:   dup 
L376:   aload_0 
L377:   getfield [23] 
L380:   invokespecial [46] 
L383:   invokevirtual [38] 
L386:   pop 
L387:   goto L441 
L390:   aload_0 
L391:   getfield [28] 
L394:   invokevirtual [40] 
L397:   ifeq L416 
L400:   aload_0 
L401:   getfield [28] 
L404:   ldc [10] 
L406:   ldc [13] 
L408:   aload_0 
L409:   getfield [23] 
L412:   invokevirtual [42] 
L415:   pop 
L416:   aload 4 
L418:   new [57] 
L421:   dup 
L422:   aload_0 
L423:   getfield [23] 
L426:   aload_0 
L427:   getfield [26] 
L430:   aload_0 
L431:   getfield [27] 
L434:   invokespecial [47] 
L437:   invokevirtual [38] 
L440:   pop 
L441:   aload_0 
L442:   invokevirtual [33] 
L445:   aload 4 
L447:   invokeinterface [58] 0 
L452:   return 
L453:   nop 
L454:   nop 
L455:   nop 
L456:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [59] 
.const [4] = String [60] 
.const [5] = String [61] 
.const [6] = String [62] 
.const [7] = String [63] 
.const [8] = Class [64] 
.const [9] = Class [65] 
.const [10] = Int 14808325 
.const [11] = String [66] 
.const [12] = Class [67] 
.const [13] = String [68] 
.const [14] = Class [69] 
.const [15] = Class [70] 
.const [16] = Class [71] 
.const [17] = Class [72] 
.const [18] = Class [73] 
.const [19] = Class [74] 
.const [20] = Class [75] 
.const [21] = Class [76] 
.const [22] = Class [77] 
.const [23] = Field [78] [79] 
.const [24] = Field [80] [81] 
.const [25] = Field [82] [83] 
.const [26] = Field [84] [85] 
.const [27] = Field [86] [87] 
.const [28] = Field [88] [89] 
.const [29] = Method [90] [91] 
.const [30] = Field [92] [93] 
.const [31] = Method [94] [95] 
.const [32] = Method [96] [97] 
.const [33] = Method [98] [99] 
.const [34] = Method [100] [101] 
.const [35] = Method [102] [103] 
.const [36] = Method [104] [105] 
.const [37] = Method [106] [107] 
.const [38] = Method [108] [109] 
.const [39] = Method [110] [111] 
.const [40] = Method [112] [113] 
.const [41] = Method [114] [115] 
.const [42] = Method [116] [117] 
.const [43] = Method [118] [119] 
.const [44] = Method [120] [121] 
.const [45] = Method [122] [123] 
.const [46] = Method [124] [125] 
.const [47] = Method [126] [127] 
.const [48] = Field [128] [129] 
.const [49] = Field [130] [131] 
.const [50] = Field [132] [133] 
.const [51] = Field [134] [135] 
.const [52] = Field [136] [137] 
.const [53] = InterfaceMethod [138] [139] 
.const [54] = InterfaceMethod [140] [141] 
.const [55] = Class [142] 
.const [56] = Class [143] 
.const [57] = Class [144] 
.const [58] = InterfaceMethod [145] [146] 
.const [59] = Utf8 'ModelUpdateFullListWithWaitCommand#execute - maxResults: %1' 
.const [60] = Utf8 'ModelUpdateFullListWithWaitCommand#execute - valueList or valueList.getList() is null' 
.const [61] = Utf8 'ModelUpdateFullListWithWaitCommand#execute - getPoiSubstringSearchStatus() is null' 
.const [62] = Utf8 'ModelUpdateFullListWithWaitCommand#execute - valueListSize = %1' 
.const [63] = Utf8 'ModelUpdateFullListWithWaitCommand#execute - isValueListTooSmall = %1, searchIsNotCanceled = %2, searchisNotFinished = %3' 
.const [64] = Utf8 de/audi/tghu/navi/app/addressinput/commands/LISPRequestValueListByListIndexCommand 
.const [65] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitCommand 
.const [66] = Utf8 'ModelUpdateFullListWithWaitCommand#execute - requestID = %1, startIndex = %2, minimumResults = %3' 
.const [67] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateResultListCommand 
.const [68] = Utf8 'modelAccess: %1' 
.const [69] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [70] = Utf8 de/audi/atip/log/LogChannel 
.const [71] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [72] = Utf8 org/dsi/ifc/navigation/LIValueList 
.const [73] = Utf8 de/audi/tghu/command/ICommandList 
.const [74] = Utf8 de/audi/tghu/command/ICommandListFactory 
.const [75] = Utf8 org/dsi/ifc/navigation/ValueListStatus 
.const [76] = Utf8 de/audi/tghu/command/CommandList 
.const [77] = Utf8 org/dsi/ifc/navigation/LIValueListElement 
.const [78] = Class [147] 
.const [79] = NameAndType [148] [149] 
.const [80] = Class [150] 
.const [81] = NameAndType [151] [152] 
.const [82] = Class [153] 
.const [83] = NameAndType [154] [155] 
.const [84] = Class [156] 
.const [85] = NameAndType [157] [158] 
.const [86] = Class [159] 
.const [87] = NameAndType [160] [161] 
.const [88] = Class [162] 
.const [89] = NameAndType [163] [164] 
.const [90] = Class [165] 
.const [91] = NameAndType [166] [167] 
.const [92] = Class [168] 
.const [93] = NameAndType [169] [170] 
.const [94] = Class [171] 
.const [95] = NameAndType [172] [173] 
.const [96] = Class [174] 
.const [97] = NameAndType [175] [176] 
.const [98] = Class [177] 
.const [99] = NameAndType [178] [179] 
.const [100] = Class [180] 
.const [101] = NameAndType [181] [182] 
.const [102] = Class [183] 
.const [103] = NameAndType [184] [185] 
.const [104] = Class [186] 
.const [105] = NameAndType [187] [188] 
.const [106] = Class [189] 
.const [107] = NameAndType [190] [191] 
.const [108] = Class [192] 
.const [109] = NameAndType [193] [194] 
.const [110] = Class [195] 
.const [111] = NameAndType [196] [197] 
.const [112] = Class [198] 
.const [113] = NameAndType [199] [200] 
.const [114] = Class [201] 
.const [115] = NameAndType [202] [203] 
.const [116] = Class [204] 
.const [117] = NameAndType [205] [206] 
.const [118] = Class [207] 
.const [119] = NameAndType [208] [209] 
.const [120] = Class [210] 
.const [121] = NameAndType [211] [212] 
.const [122] = Class [213] 
.const [123] = NameAndType [214] [215] 
.const [124] = Class [216] 
.const [125] = NameAndType [217] [218] 
.const [126] = Class [219] 
.const [127] = NameAndType [220] [221] 
.const [128] = Class [222] 
.const [129] = NameAndType [223] [224] 
.const [130] = Class [225] 
.const [131] = NameAndType [226] [227] 
.const [132] = Class [228] 
.const [133] = NameAndType [229] [230] 
.const [134] = Class [231] 
.const [135] = NameAndType [232] [233] 
.const [136] = Class [234] 
.const [137] = NameAndType [235] [236] 
.const [138] = Class [237] 
.const [139] = NameAndType [238] [239] 
.const [140] = Class [240] 
.const [141] = NameAndType [241] [242] 
.const [142] = Utf8 de/audi/tghu/navi/app/addressinput/commands/LISPRequestValueListByListIndexCommand 
.const [143] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitCommand 
.const [144] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateResultListCommand 
.const [145] = Class [243] 
.const [146] = NameAndType [244] [245] 
.const [147] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitCommand 
.const [148] = Utf8 modelAccess 
.const [149] = Utf8 Lde/audi/tghu/navi/app/addressinput/IMatchspellerModelAccess; 
.const [150] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitCommand 
.const [151] = Utf8 commandListFactory 
.const [152] = Utf8 Lde/audi/tghu/command/ICommandListFactory; 
.const [153] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitCommand 
.const [154] = Utf8 minimumResultsToGoOn 
.const [155] = Utf8 I 
.const [156] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitCommand 
.const [157] = Utf8 requestID 
.const [158] = Utf8 I 
.const [159] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitCommand 
.const [160] = Utf8 startIndex 
.const [161] = Utf8 I 
.const [162] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitCommand 
.const [163] = Utf8 logger 
.const [164] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [165] = Utf8 de/audi/atip/log/LogChannel 
.const [166] = Utf8 log 
.const [167] = Utf8 (ILjava/lang/String;J)Z 
.const [168] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitCommand 
.const [169] = Utf8 dsiResponseContainer 
.const [170] = Utf8 Lde/audi/tghu/navi/app/command/DSIResponseContainer; 
.const [171] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [172] = Utf8 getLispValueList 
.const [173] = Utf8 ()Lorg/dsi/ifc/navigation/LIValueList; 
.const [174] = Utf8 org/dsi/ifc/navigation/LIValueList 
.const [175] = Utf8 getList 
.const [176] = Utf8 ()[Lorg/dsi/ifc/navigation/LIValueListElement; 
.const [177] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitCommand 
.const [178] = Utf8 getCommandList 
.const [179] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [180] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [181] = Utf8 getPoiSubstringSearchStatus 
.const [182] = Utf8 ()Lorg/dsi/ifc/navigation/ValueListStatus; 
.const [183] = Utf8 org/dsi/ifc/navigation/ValueListStatus 
.const [184] = Utf8 getStatus 
.const [185] = Utf8 ()I 
.const [186] = Utf8 org/dsi/ifc/navigation/ValueListStatus 
.const [187] = Utf8 getNumberOfAvailableItems 
.const [188] = Utf8 ()I 
.const [189] = Utf8 de/audi/atip/log/LogChannel 
.const [190] = Utf8 log 
.const [191] = Utf8 (ILjava/lang/String;ZZZ)V 
.const [192] = Utf8 de/audi/tghu/command/CommandList 
.const [193] = Utf8 add 
.const [194] = Utf8 (Lde/audi/tghu/command/Command;)Lde/audi/tghu/command/ICommandList; 
.const [195] = Utf8 org/dsi/ifc/navigation/LIValueListElement 
.const [196] = Utf8 getListIndex 
.const [197] = Utf8 ()I 
.const [198] = Utf8 de/audi/atip/log/LogChannel 
.const [199] = Utf8 isDebug2 
.const [200] = Utf8 ()Z 
.const [201] = Utf8 de/audi/atip/log/LogChannel 
.const [202] = Utf8 log 
.const [203] = Utf8 (ILjava/lang/String;JJJ)Z 
.const [204] = Utf8 de/audi/atip/log/LogChannel 
.const [205] = Utf8 log 
.const [206] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [207] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitCommand 
.const [208] = Utf8 <init> 
.const [209] = Utf8 (Lde/audi/tghu/navi/app/addressinput/IMatchspellerModelAccess;Lde/audi/tghu/command/ICommandListFactory;III)V 
.const [210] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [211] = Utf8 <init> 
.const [212] = Utf8 ()V 
.const [213] = Utf8 de/audi/tghu/navi/app/addressinput/commands/LISPRequestValueListByListIndexCommand 
.const [214] = Utf8 <init> 
.const [215] = Utf8 (IZ)V 
.const [216] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateResultListCommand 
.const [217] = Utf8 <init> 
.const [218] = Utf8 (Lde/audi/tghu/navi/app/addressinput/IMatchspellerModelAccess;)V 
.const [219] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateResultListCommand 
.const [220] = Utf8 <init> 
.const [221] = Utf8 (Lde/audi/tghu/navi/app/addressinput/IMatchspellerModelAccess;II)V 
.const [222] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitCommand 
.const [223] = Utf8 modelAccess 
.const [224] = Utf8 Lde/audi/tghu/navi/app/addressinput/IMatchspellerModelAccess; 
.const [225] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitCommand 
.const [226] = Utf8 commandListFactory 
.const [227] = Utf8 Lde/audi/tghu/command/ICommandListFactory; 
.const [228] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitCommand 
.const [229] = Utf8 minimumResultsToGoOn 
.const [230] = Utf8 I 
.const [231] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitCommand 
.const [232] = Utf8 requestID 
.const [233] = Utf8 I 
.const [234] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitCommand 
.const [235] = Utf8 startIndex 
.const [236] = Utf8 I 
.const [237] = Utf8 de/audi/tghu/command/ICommandList 
.const [238] = Utf8 commandAborted 
.const [239] = Utf8 (Ljava/lang/String;)V 
.const [240] = Utf8 de/audi/tghu/command/ICommandListFactory 
.const [241] = Utf8 createCommandList 
.const [242] = Utf8 ()Lde/audi/tghu/command/CommandList; 
.const [243] = Utf8 de/audi/tghu/command/ICommandList 
.const [244] = Utf8 commandFinishedWithPostSequence 
.const [245] = Utf8 (Lde/audi/tghu/command/CommandList;)V 
.const [246] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/ModelUpdateFullListWithWaitCommand 
.const [247] = Class [246] 
.const [248] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [249] = Class [248] 
.const [250] = Utf8 modelAccess 
.const [251] = Utf8 Lde/audi/tghu/navi/app/addressinput/IMatchspellerModelAccess; 
.const [252] = Utf8 commandListFactory 
.const [253] = Utf8 Lde/audi/tghu/command/ICommandListFactory; 
.const [254] = Utf8 minimumResultsToGoOn 
.const [255] = Utf8 I 
.const [256] = Utf8 requestID 
.const [257] = Utf8 I 
.const [258] = Utf8 startIndex 
.const [259] = Utf8 I 
.const [260] = Utf8 NO_MAX 
.const [261] = Utf8 I 
.const [262] = Utf8 Code 
.const [263] = Utf8 <init> 
.const [264] = Utf8 (Lde/audi/tghu/navi/app/addressinput/IMatchspellerModelAccess;Lde/audi/tghu/command/ICommandListFactory;I)V 
.const [265] = Utf8 <init> 
.const [266] = Utf8 (Lde/audi/tghu/navi/app/addressinput/IMatchspellerModelAccess;Lde/audi/tghu/command/ICommandListFactory;)V 
.const [267] = Utf8 <init> 
.const [268] = Utf8 (Lde/audi/tghu/navi/app/addressinput/IMatchspellerModelAccess;Lde/audi/tghu/command/ICommandListFactory;II)V 
.const [269] = Utf8 <init> 
.const [270] = Utf8 (Lde/audi/tghu/navi/app/addressinput/IMatchspellerModelAccess;Lde/audi/tghu/command/ICommandListFactory;III)V 
.const [271] = Utf8 execute 
.const [272] = Utf8 ()V 
.end class 
