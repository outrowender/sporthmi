.version 50 0 
.class public super [250] 
.super [252] 
.field protected final [253] [254] 
.field protected [255] [256] 
.field protected [257] [258] 
.field protected [259] [260] 
.field protected [261] [262] 

.method public [264] : [265] 
    .attribute [263] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [47] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [49] 
L9:     aload_0 
L10:    aload_1 
L11:    invokevirtual [24] 
L14:    putfield [50] 
L17:    aload_0 
L18:    aload_1 
L19:    invokevirtual [26] 
L22:    putfield [51] 
L25:    aload_0 
L26:    aload_2 
L27:    putfield [52] 
L30:    aload_0 
L31:    new [53] 
L34:    dup 
L35:    aload_1 
L36:    iload_3 
L37:    invokespecial [48] 
L40:    putfield [54] 
L43:    return 
L44:    
    .end code 
.end method 

.method public synchronized [266] : [267] 
    .attribute [263] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     invokevirtual [30] 
L11:    pop 
L12:    aload_0 
L13:    invokevirtual [31] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [268] : [269] 
    .attribute [263] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     invokevirtual [32] 
L7:     ifeq L23 
L10:    aload_0 
L11:    getfield [25] 
L14:    ldc [5] 
L16:    ldc [6] 
L18:    iload_1 
L19:    invokevirtual [33] 
L22:    pop 
L23:    aload_0 
L24:    invokevirtual [31] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [270] : [271] 
    .attribute [263] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [31] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected synchronized [272] : [273] 
    .attribute [263] .code stack 8 locals 16 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_1 
L3:     ifnonnull L7 
L6:     return 
L7:     aload_0 
L8:     getfield [23] 
L11:    invokevirtual [34] 
L14:    invokevirtual [35] 
L17:    istore_2 
L18:    aload_0 
L19:    getfield [27] 
L22:    invokevirtual [32] 
L25:    ifeq L42 
L28:    aload_0 
L29:    getfield [27] 
L32:    ldc [5] 
L34:    ldc [7] 
L36:    iload_2 
L37:    aload_1 
L38:    invokevirtual [36] 
L41:    pop 
L42:    aload_0 
L43:    getfield [28] 
L46:    invokeinterface [55] 0 
L51:    astore_3 
L52:    aload_3 
L53:    invokestatic [8] 
L56:    istore 4 
L58:    iload 4 
L60:    ifgt L76 
L63:    aload_0 
L64:    getfield [27] 
L67:    ldc [9] 
L69:    ldc [10] 
L71:    invokevirtual [30] 
L74:    pop 
L75:    return 
L76:    aload_3 
L77:    invokestatic [11] 
L80:    istore 5 
L82:    aload_1 
L83:    getfield [37] 
L86:    istore 6 
L88:    aload_1 
L89:    getfield [38] 
L92:    lstore 7 
L94:    iconst_1 
L95:    istore 9 
L97:    iconst_1 
L98:    istore 10 
L100:   aload_0 
L101:   getfield [23] 
L104:   invokevirtual [34] 
L107:   invokevirtual [39] 
L110:   astore 11 
L112:   iload 5 
L114:   istore 12 
L116:   iload 12 
L118:   iload 4 
L120:   if_icmpge L362 
L123:   iload_2 
L124:   ifeq L332 
L127:   iload 12 
L129:   iload 5 
L131:   if_icmpeq L290 
L134:   aload 11 
L136:   ifnull L269 
L139:   iload 12 
L141:   aload 11 
L143:   arraylength 
L144:   if_icmpge L269 
L147:   aload 11 
L149:   iload 12 
L151:   aaload 
L152:   invokevirtual [40] 
L155:   istore 13 
L157:   iload 9 
L159:   iload 13 
L161:   iflt L168 
L164:   iconst_1 
L165:   goto L169 
L168:   iconst_0 
L169:   iand 
L170:   istore 9 
L172:   iload 12 
L174:   iconst_1 
L175:   iadd 
L176:   aload 11 
L178:   arraylength 
L179:   if_icmpge L195 
L182:   aload 11 
L184:   iload 12 
L186:   iconst_1 
L187:   iadd 
L188:   aaload 
L189:   invokevirtual [40] 
L192:   goto L196 
L195:   iconst_0 
L196:   istore 14 
L198:   lload 7 
L200:   iload 13 
L202:   iload 14 
L204:   isub 
L205:   i2l 
L206:   ladd 
L207:   lstore 7 
L209:   aload 11 
L211:   iload 12 
L213:   aaload 
L214:   invokevirtual [41] 
L217:   istore 15 
L219:   aload 11 
L221:   iload 12 
L223:   aaload 
L224:   invokevirtual [42] 
L227:   istore 16 
L229:   iload 10 
L231:   iload 16 
L233:   iflt L252 
L236:   iload 15 
L238:   iflt L252 
L241:   iload 16 
L243:   iload 15 
L245:   if_icmplt L252 
L248:   iconst_1 
L249:   goto L253 
L252:   iconst_0 
L253:   iand 
L254:   istore 10 
L256:   iload 6 
L258:   iload 16 
L260:   iload 15 
L262:   isub 
L263:   iadd 
L264:   istore 6 
L266:   goto L338 
L269:   aload_0 
L270:   getfield [27] 
L273:   ldc [9] 
L275:   ldc [12] 
L277:   invokevirtual [30] 
L280:   pop 
L281:   iconst_0 
L282:   istore 9 
L284:   iconst_0 
L285:   istore 10 
L287:   goto L338 
L290:   iload 9 
L292:   aload_1 
L293:   getfield [43] 
L296:   ifeq L310 
L299:   lload 7 
L301:   lconst_0 
L302:   lcmp 
L303:   iflt L310 
L306:   iconst_1 
L307:   goto L311 
L310:   iconst_0 
L311:   iand 
L312:   istore 9 
L314:   iload 10 
L316:   iload 6 
L318:   iflt L325 
L321:   iconst_1 
L322:   goto L326 
L325:   iconst_0 
L326:   iand 
L327:   istore 10 
L329:   goto L338 
L332:   iconst_0 
L333:   istore 9 
L335:   iconst_0 
L336:   istore 10 
L338:   aload_0 
L339:   getfield [29] 
L342:   iload 12 
L344:   iload_2 
L345:   iload 9 
L347:   lload 7 
L349:   iload 10 
L351:   iload 6 
L353:   invokevirtual [44] 
L356:   iinc 12 1 
L359:   goto L116 
L362:   return 
L363:   nop 
L364:   
    .end code 
.end method 

.method public [274] : [275] 
    .attribute [263] .code stack 3 locals 9 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_1 
L3:     ifnonnull L8 
L6:     iconst_0 
L7:     areturn 
L8:     aload_0 
L9:     getfield [28] 
L12:    invokeinterface [56] 0 
L17:    astore_2 
L18:    aload_2 
L19:    invokestatic [8] 
L22:    istore_3 
L23:    iconst_0 
L24:    istore 4 
L26:    iload_3 
L27:    ifle L130 
L30:    aload_2 
L31:    invokestatic [11] 
L34:    istore 5 
L36:    aload_1 
L37:    getfield [37] 
L40:    istore 4 
L42:    aload_0 
L43:    getfield [23] 
L46:    invokevirtual [34] 
L49:    invokevirtual [39] 
L52:    astore 6 
L54:    iload 5 
L56:    iconst_1 
L57:    iadd 
L58:    istore 7 
L60:    iload 7 
L62:    iload_3 
L63:    if_icmpge L130 
L66:    aload 6 
L68:    ifnull L112 
L71:    iload 7 
L73:    aload 6 
L75:    arraylength 
L76:    if_icmpge L112 
L79:    aload 6 
L81:    iload 7 
L83:    aaload 
L84:    invokevirtual [41] 
L87:    istore 8 
L89:    aload 6 
L91:    iload 7 
L93:    aaload 
L94:    invokevirtual [42] 
L97:    istore 9 
L99:    iload 4 
L101:   iload 9 
L103:   iload 8 
L105:   isub 
L106:   iadd 
L107:   istore 4 
L109:   goto L124 
L112:   aload_0 
L113:   getfield [27] 
L116:   ldc [9] 
L118:   ldc [13] 
L120:   invokevirtual [30] 
L123:   pop 
L124:   iinc 7 1 
L127:   goto L60 
L130:   iload 4 
L132:   areturn 
L133:   nop 
L134:   nop 
L135:   nop 
L136:   
    .end code 
.end method 

.method public [276] : [277] 
    .attribute [263] .code stack 4 locals 8 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_1 
L3:     ifnonnull L8 
L6:     lconst_0 
L7:     freturn 
L8:     aload_0 
L9:     getfield [28] 
L12:    invokeinterface [56] 0 
L17:    astore_2 
L18:    aload_2 
L19:    invokestatic [8] 
L22:    istore_3 
L23:    lconst_0 
L24:    lstore 4 
L26:    iload_3 
L27:    ifle L91 
L30:    aload_2 
L31:    invokestatic [11] 
L34:    istore 6 
L36:    aload_1 
L37:    getfield [45] 
L40:    lstore 4 
L42:    aload_0 
L43:    getfield [23] 
L46:    invokevirtual [34] 
L49:    invokevirtual [39] 
L52:    astore 7 
L54:    iload 6 
L56:    iconst_1 
L57:    iadd 
L58:    istore 8 
L60:    aload 7 
L62:    ifnull L91 
L65:    iload 8 
L67:    aload 7 
L69:    arraylength 
L70:    if_icmpge L91 
L73:    lload 4 
L75:    aload 7 
L77:    iload 8 
L79:    aaload 
L80:    invokevirtual [40] 
L83:    sipush 1000 
L86:    idiv 
L87:    i2l 
L88:    ladd 
L89:    lstore 4 
L91:    lload 4 
L93:    freturn 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method public [278] : [279] 
    .attribute [263] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     invokevirtual [46] 
L6:     istore_1 
L7:     iload_1 
L8:     i2l 
L9:     freturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [57] 
.const [3] = Int -2137614336 
.const [4] = String [58] 
.const [5] = Int 14808325 
.const [6] = String [59] 
.const [7] = String [60] 
.const [8] = Method [61] [62] 
.const [9] = Int -1601830656 
.const [10] = String [63] 
.const [11] = Method [64] [65] 
.const [12] = String [66] 
.const [13] = String [67] 
.const [14] = Class [68] 
.const [15] = Class [69] 
.const [16] = Class [70] 
.const [17] = Class [71] 
.const [18] = Class [72] 
.const [19] = Class [73] 
.const [20] = Class [74] 
.const [21] = Class [75] 
.const [22] = Class [76] 
.const [23] = Field [77] [78] 
.const [24] = Method [79] [80] 
.const [25] = Field [81] [82] 
.const [26] = Method [83] [84] 
.const [27] = Field [85] [86] 
.const [28] = Field [87] [88] 
.const [29] = Field [89] [90] 
.const [30] = Method [91] [92] 
.const [31] = Method [93] [94] 
.const [32] = Method [95] [96] 
.const [33] = Method [97] [98] 
.const [34] = Method [99] [100] 
.const [35] = Method [101] [102] 
.const [36] = Method [103] [104] 
.const [37] = Field [105] [106] 
.const [38] = Field [107] [108] 
.const [39] = Method [109] [110] 
.const [40] = Method [111] [112] 
.const [41] = Method [113] [114] 
.const [42] = Method [115] [116] 
.const [43] = Field [117] [118] 
.const [44] = Method [119] [120] 
.const [45] = Field [121] [122] 
.const [46] = Method [123] [124] 
.const [47] = Method [125] [126] 
.const [48] = Method [127] [128] 
.const [49] = Field [129] [130] 
.const [50] = Field [131] [132] 
.const [51] = Field [133] [134] 
.const [52] = Field [135] [136] 
.const [53] = Class [137] 
.const [54] = Field [138] [139] 
.const [55] = InterfaceMethod [140] [141] 
.const [56] = InterfaceMethod [142] [143] 
.const [57] = Utf8 de/audi/tghu/navi/app/rp/RouteplanUtilAudi 
.const [58] = Utf8 'Routeplan#unitsChanged()' 
.const [59] = Utf8 'Routeplan#updateRgActive( %1 )' 
.const [60] = Utf8 'RouteplanAudi#refreshTripData() - rgActive: %1, tripData: %2' 
.const [61] = Class [144] 
.const [62] = NameAndType [145] [146] 
.const [63] = Utf8 'RouteplanAudi#refreshRouteData() - onRoadRoute length is 0!' 
.const [64] = Class [147] 
.const [65] = NameAndType [148] [149] 
.const [66] = Utf8 'RouteplanAudi#refreshRouteData() - rgDestinationInfo array too small!' 
.const [67] = Utf8 'RouteplanAudi#getDistanceToFinalDestination() - rgDestinationInfo array too small!' 
.const [68] = Utf8 de/audi/tghu/navi/app/rp/Routeplan 
.const [69] = Utf8 java/lang/Object 
.const [70] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [71] = Utf8 de/audi/atip/log/LogChannel 
.const [72] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [73] = Utf8 de/audi/tghu/navi/app/routeguidance/IRouteManager 
.const [74] = Utf8 de/audi/tghu/navi/app/util/RouteUtil 
.const [75] = Utf8 de/audi/tghu/navi/app/rp/TripHandler$TripData 
.const [76] = Utf8 org/dsi/ifc/navigation/NavRouteListData 
.const [77] = Class [150] 
.const [78] = NameAndType [151] [152] 
.const [79] = Class [153] 
.const [80] = NameAndType [154] [155] 
.const [81] = Class [156] 
.const [82] = NameAndType [157] [158] 
.const [83] = Class [159] 
.const [84] = NameAndType [160] [161] 
.const [85] = Class [162] 
.const [86] = NameAndType [163] [164] 
.const [87] = Class [165] 
.const [88] = NameAndType [166] [167] 
.const [89] = Class [168] 
.const [90] = NameAndType [169] [170] 
.const [91] = Class [171] 
.const [92] = NameAndType [172] [173] 
.const [93] = Class [174] 
.const [94] = NameAndType [175] [176] 
.const [95] = Class [177] 
.const [96] = NameAndType [178] [179] 
.const [97] = Class [180] 
.const [98] = NameAndType [181] [182] 
.const [99] = Class [183] 
.const [100] = NameAndType [184] [185] 
.const [101] = Class [186] 
.const [102] = NameAndType [187] [188] 
.const [103] = Class [189] 
.const [104] = NameAndType [190] [191] 
.const [105] = Class [192] 
.const [106] = NameAndType [193] [194] 
.const [107] = Class [195] 
.const [108] = NameAndType [196] [197] 
.const [109] = Class [198] 
.const [110] = NameAndType [199] [200] 
.const [111] = Class [201] 
.const [112] = NameAndType [202] [203] 
.const [113] = Class [204] 
.const [114] = NameAndType [205] [206] 
.const [115] = Class [207] 
.const [116] = NameAndType [208] [209] 
.const [117] = Class [210] 
.const [118] = NameAndType [211] [212] 
.const [119] = Class [213] 
.const [120] = NameAndType [214] [215] 
.const [121] = Class [216] 
.const [122] = NameAndType [217] [218] 
.const [123] = Class [219] 
.const [124] = NameAndType [220] [221] 
.const [125] = Class [222] 
.const [126] = NameAndType [223] [224] 
.const [127] = Class [225] 
.const [128] = NameAndType [226] [227] 
.const [129] = Class [228] 
.const [130] = NameAndType [229] [230] 
.const [131] = Class [231] 
.const [132] = NameAndType [232] [233] 
.const [133] = Class [234] 
.const [134] = NameAndType [235] [236] 
.const [135] = Class [237] 
.const [136] = NameAndType [238] [239] 
.const [137] = Utf8 de/audi/tghu/navi/app/rp/RouteplanUtilAudi 
.const [138] = Class [240] 
.const [139] = NameAndType [241] [242] 
.const [140] = Class [243] 
.const [141] = NameAndType [244] [245] 
.const [142] = Class [246] 
.const [143] = NameAndType [247] [248] 
.const [144] = Utf8 de/audi/tghu/navi/app/util/RouteUtil 
.const [145] = Utf8 getRouteLength 
.const [146] = Utf8 (Lorg/dsi/ifc/navigation/Route;)I 
.const [147] = Utf8 de/audi/tghu/navi/app/util/RouteUtil 
.const [148] = Utf8 getIndexOfCurrentDestination 
.const [149] = Utf8 (Lorg/dsi/ifc/navigation/Route;)I 
.const [150] = Utf8 de/audi/tghu/navi/app/rp/Routeplan 
.const [151] = Utf8 env 
.const [152] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [153] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [154] = Utf8 getLogChannel 
.const [155] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [156] = Utf8 de/audi/tghu/navi/app/rp/Routeplan 
.const [157] = Utf8 mainLogChannel 
.const [158] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [159] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [160] = Utf8 getGuidanceLogChannel 
.const [161] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [162] = Utf8 de/audi/tghu/navi/app/rp/Routeplan 
.const [163] = Utf8 guidanceLogChannel 
.const [164] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [165] = Utf8 de/audi/tghu/navi/app/rp/Routeplan 
.const [166] = Utf8 manager 
.const [167] = Utf8 Lde/audi/tghu/navi/app/routeguidance/IRouteManager; 
.const [168] = Utf8 de/audi/tghu/navi/app/rp/Routeplan 
.const [169] = Utf8 routeplanUtil 
.const [170] = Utf8 Lde/audi/tghu/navi/app/rp/RouteplanUtilAudi; 
.const [171] = Utf8 de/audi/atip/log/LogChannel 
.const [172] = Utf8 log 
.const [173] = Utf8 (ILjava/lang/String;)Z 
.const [174] = Utf8 de/audi/tghu/navi/app/rp/Routeplan 
.const [175] = Utf8 refreshTripData 
.const [176] = Utf8 ()V 
.const [177] = Utf8 de/audi/atip/log/LogChannel 
.const [178] = Utf8 isDebug2 
.const [179] = Utf8 ()Z 
.const [180] = Utf8 de/audi/atip/log/LogChannel 
.const [181] = Utf8 log 
.const [182] = Utf8 (ILjava/lang/String;Z)Z 
.const [183] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [184] = Utf8 getContainer 
.const [185] = Utf8 ()Lde/audi/tghu/navi/app/command/DSIResponseContainer; 
.const [186] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [187] = Utf8 isRgActive 
.const [188] = Utf8 ()Z 
.const [189] = Utf8 de/audi/atip/log/LogChannel 
.const [190] = Utf8 log 
.const [191] = Utf8 (ILjava/lang/String;ZLjava/lang/Object;)Z 
.const [192] = Utf8 de/audi/tghu/navi/app/rp/TripHandler$TripData 
.const [193] = Utf8 distanceToNextDestination 
.const [194] = Utf8 I 
.const [195] = Utf8 de/audi/tghu/navi/app/rp/TripHandler$TripData 
.const [196] = Utf8 etaToNextDestination 
.const [197] = Utf8 J 
.const [198] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [199] = Utf8 getRgDestinationInfo 
.const [200] = Utf8 ()[Lorg/dsi/ifc/navigation/NavRouteListData; 
.const [201] = Utf8 org/dsi/ifc/navigation/NavRouteListData 
.const [202] = Utf8 getRemainingTravelTime 
.const [203] = Utf8 ()I 
.const [204] = Utf8 org/dsi/ifc/navigation/NavRouteListData 
.const [205] = Utf8 getEndDistance 
.const [206] = Utf8 ()I 
.const [207] = Utf8 org/dsi/ifc/navigation/NavRouteListData 
.const [208] = Utf8 getStartDistance 
.const [209] = Utf8 ()I 
.const [210] = Utf8 de/audi/tghu/navi/app/rp/TripHandler$TripData 
.const [211] = Utf8 etaValid 
.const [212] = Utf8 Z 
.const [213] = Utf8 de/audi/tghu/navi/app/rp/RouteplanUtilAudi 
.const [214] = Utf8 refreshRouteDestinationData 
.const [215] = Utf8 (IZZJZI)V 
.const [216] = Utf8 de/audi/tghu/navi/app/rp/TripHandler$TripData 
.const [217] = Utf8 timeToNextDestination 
.const [218] = Utf8 J 
.const [219] = Utf8 de/audi/tghu/navi/app/rp/Routeplan 
.const [220] = Utf8 getDistanceToFinalDestination 
.const [221] = Utf8 ()I 
.const [222] = Utf8 java/lang/Object 
.const [223] = Utf8 <init> 
.const [224] = Utf8 ()V 
.const [225] = Utf8 de/audi/tghu/navi/app/rp/RouteplanUtilAudi 
.const [226] = Utf8 <init> 
.const [227] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;I)V 
.const [228] = Utf8 de/audi/tghu/navi/app/rp/Routeplan 
.const [229] = Utf8 env 
.const [230] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [231] = Utf8 de/audi/tghu/navi/app/rp/Routeplan 
.const [232] = Utf8 mainLogChannel 
.const [233] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [234] = Utf8 de/audi/tghu/navi/app/rp/Routeplan 
.const [235] = Utf8 guidanceLogChannel 
.const [236] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [237] = Utf8 de/audi/tghu/navi/app/rp/Routeplan 
.const [238] = Utf8 manager 
.const [239] = Utf8 Lde/audi/tghu/navi/app/routeguidance/IRouteManager; 
.const [240] = Utf8 de/audi/tghu/navi/app/rp/Routeplan 
.const [241] = Utf8 routeplanUtil 
.const [242] = Utf8 Lde/audi/tghu/navi/app/rp/RouteplanUtilAudi; 
.const [243] = Utf8 de/audi/tghu/navi/app/routeguidance/IRouteManager 
.const [244] = Utf8 getFilteredRoute 
.const [245] = Utf8 ()Lorg/dsi/ifc/navigation/Route; 
.const [246] = Utf8 de/audi/tghu/navi/app/routeguidance/IRouteManager 
.const [247] = Utf8 getRoute 
.const [248] = Utf8 ()Lorg/dsi/ifc/navigation/Route; 
.const [249] = Utf8 de/audi/tghu/navi/app/rp/Routeplan 
.const [250] = Class [249] 
.const [251] = Utf8 java/lang/Object 
.const [252] = Class [251] 
.const [253] = Utf8 env 
.const [254] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [255] = Utf8 mainLogChannel 
.const [256] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [257] = Utf8 guidanceLogChannel 
.const [258] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [259] = Utf8 manager 
.const [260] = Utf8 Lde/audi/tghu/navi/app/routeguidance/IRouteManager; 
.const [261] = Utf8 routeplanUtil 
.const [262] = Utf8 Lde/audi/tghu/navi/app/rp/RouteplanUtilAudi; 
.const [263] = Utf8 Code 
.const [264] = Utf8 <init> 
.const [265] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/routeguidance/IRouteManager;I)V 
.const [266] = Utf8 unitsChanged 
.const [267] = Utf8 ()V 
.const [268] = Utf8 updateRgActive 
.const [269] = Utf8 (Z)V 
.const [270] = Utf8 updateRgDestinationInfo 
.const [271] = Utf8 ([Lorg/dsi/ifc/navigation/NavRouteListData;)V 
.const [272] = Utf8 refreshTripData 
.const [273] = Utf8 ()V 
.const [274] = Utf8 getDistanceToFinalDestination 
.const [275] = Utf8 ()I 
.const [276] = Utf8 getTimeToFinalDestination 
.const [277] = Utf8 ()J 
.const [278] = Utf8 getTMCDistanceToDestination 
.const [279] = Utf8 ()J 
.end class 
