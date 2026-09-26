.version 50 0 
.class super [130] 
.super [132] 
.field private final synthetic [133] [134] 

.method public [136] : [137] 
    .attribute [135] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [35] 
L5:     aload_0 
L6:     aload_1 
L7:     iload_2 
L8:     iload_3 
L9:     invokespecial [34] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [138] : [139] 
    .attribute [135] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [26] 
L4:     invokestatic [2] 
L7:     invokevirtual [27] 
L10:    ldc [3] 
L12:    ldc [4] 
L14:    aload_1 
L15:    invokevirtual [28] 
L18:    pop 
L19:    ldc [5] 
L21:    astore_2 
L22:    aload_1 
L23:    getfield [29] 
L26:    lconst_0 
L27:    lcmp 
L28:    ifne L199 
L31:    aload_1 
L32:    getfield [30] 
L35:    ifnull L318 
L38:    aload_1 
L39:    getfield [30] 
L42:    arraylength 
L43:    iconst_1 
L44:    if_icmpne L86 
L47:    ldc [6] 
L49:    iconst_3 
L50:    anewarray [7] 
L53:    dup 
L54:    iconst_0 
L55:    aload_1 
L56:    getfield [31] 
L59:    l2i 
L60:    iconst_5 
L61:    invokestatic [8] 
L64:    aastore 
L65:    dup 
L66:    iconst_1 
L67:    ldc [9] 
L69:    aastore 
L70:    dup 
L71:    iconst_2 
L72:    aload_1 
L73:    getfield [30] 
L76:    iconst_0 
L77:    aaload 
L78:    aastore 
L79:    invokestatic [10] 
L82:    astore_2 
L83:    goto L318 
L86:    aload_1 
L87:    getfield [30] 
L90:    arraylength 
L91:    iconst_2 
L92:    if_icmpne L318 
L95:    aload_1 
L96:    getfield [30] 
L99:    iconst_0 
L100:   aaload 
L101:   invokestatic [11] 
L104:   ifne L160 
L107:   ldc [12] 
L109:   iconst_5 
L110:   anewarray [7] 
L113:   dup 
L114:   iconst_0 
L115:   aload_1 
L116:   getfield [31] 
L119:   l2i 
L120:   iconst_5 
L121:   invokestatic [8] 
L124:   aastore 
L125:   dup 
L126:   iconst_1 
L127:   ldc [9] 
L129:   aastore 
L130:   dup 
L131:   iconst_2 
L132:   aload_1 
L133:   getfield [30] 
L136:   iconst_1 
L137:   aaload 
L138:   aastore 
L139:   dup 
L140:   iconst_3 
L141:   ldc [13] 
L143:   aastore 
L144:   dup 
L145:   iconst_4 
L146:   aload_1 
L147:   getfield [30] 
L150:   iconst_0 
L151:   aaload 
L152:   aastore 
L153:   invokestatic [10] 
L156:   astore_2 
L157:   goto L318 
L160:   ldc [6] 
L162:   iconst_3 
L163:   anewarray [7] 
L166:   dup 
L167:   iconst_0 
L168:   aload_1 
L169:   getfield [31] 
L172:   l2i 
L173:   iconst_5 
L174:   invokestatic [8] 
L177:   aastore 
L178:   dup 
L179:   iconst_1 
L180:   ldc [9] 
L182:   aastore 
L183:   dup 
L184:   iconst_2 
L185:   aload_1 
L186:   getfield [30] 
L189:   iconst_1 
L190:   aaload 
L191:   aastore 
L192:   invokestatic [10] 
L195:   astore_2 
L196:   goto L318 
L199:   aload_1 
L200:   getfield [29] 
L203:   lconst_0 
L204:   lcmp 
L205:   ifle L318 
L208:   aload_1 
L209:   getfield [30] 
L212:   ifnull L318 
L215:   aload_1 
L216:   getfield [30] 
L219:   arraylength 
L220:   ifne L270 
L223:   ldc [14] 
L225:   iconst_4 
L226:   anewarray [7] 
L229:   dup 
L230:   iconst_0 
L231:   aload_1 
L232:   getfield [31] 
L235:   l2i 
L236:   iconst_5 
L237:   invokestatic [8] 
L240:   aastore 
L241:   dup 
L242:   iconst_1 
L243:   ldc [9] 
L245:   aastore 
L246:   dup 
L247:   iconst_2 
L248:   aload_1 
L249:   getfield [29] 
L252:   l2i 
L253:   iconst_5 
L254:   invokestatic [8] 
L257:   aastore 
L258:   dup 
L259:   iconst_3 
L260:   ldc [15] 
L262:   aastore 
L263:   invokestatic [10] 
L266:   astore_2 
L267:   goto L318 
L270:   ldc [14] 
L272:   iconst_4 
L273:   anewarray [7] 
L276:   dup 
L277:   iconst_0 
L278:   aload_1 
L279:   getfield [31] 
L282:   l2i 
L283:   iconst_5 
L284:   invokestatic [8] 
L287:   aastore 
L288:   dup 
L289:   iconst_1 
L290:   ldc [9] 
L292:   aastore 
L293:   dup 
L294:   iconst_2 
L295:   aload_1 
L296:   getfield [29] 
L299:   l2i 
L300:   iconst_5 
L301:   invokestatic [8] 
L304:   aastore 
L305:   dup 
L306:   iconst_3 
L307:   aload_1 
L308:   getfield [30] 
L311:   iconst_0 
L312:   aaload 
L313:   aastore 
L314:   invokestatic [10] 
L317:   astore_2 
L318:   aload_0 
L319:   aload_2 
L320:   aload_0 
L321:   getfield [32] 
L324:   getstatic [16] 
L327:   invokevirtual [33] 
L330:   astore_2 
L331:   aload_2 
L332:   areturn 
L333:   nop 
L334:   nop 
L335:   nop 
L336:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [36] [37] 
.const [3] = Int -2137614336 
.const [4] = String [38] 
.const [5] = String [39] 
.const [6] = String [40] 
.const [7] = Class [41] 
.const [8] = Method [42] [43] 
.const [9] = String [44] 
.const [10] = Method [45] [46] 
.const [11] = Method [47] [48] 
.const [12] = String [49] 
.const [13] = String [50] 
.const [14] = String [51] 
.const [15] = String [52] 
.const [16] = Field [53] [54] 
.const [17] = Class [55] 
.const [18] = Class [56] 
.const [19] = Class [57] 
.const [20] = Class [58] 
.const [21] = Class [59] 
.const [22] = Class [60] 
.const [23] = Class [61] 
.const [24] = Class [62] 
.const [25] = Class [63] 
.const [26] = Field [64] [65] 
.const [27] = Method [66] [67] 
.const [28] = Method [68] [69] 
.const [29] = Field [70] [71] 
.const [30] = Field [72] [73] 
.const [31] = Field [74] [75] 
.const [32] = Field [76] [77] 
.const [33] = Method [78] [79] 
.const [34] = Method [80] [81] 
.const [35] = Field [82] [83] 
.const [36] = Class [84] 
.const [37] = NameAndType [85] [86] 
.const [38] = Utf8 'TextBuilder_Simplified_Chinese#buildText(), TmcMessage: (%1)' 
.const [39] = Utf8 '' 
.const [40] = Utf8 '%1%2 %3' 
.const [41] = Utf8 java/lang/String 
.const [42] = Class [87] 
.const [43] = NameAndType [88] [89] 
.const [44] = Utf8 '\u540e' 
.const [45] = Class [90] 
.const [46] = NameAndType [91] [92] 
.const [47] = Class [93] 
.const [48] = NameAndType [94] [95] 
.const [49] = Utf8 '%1%2 %3 %4%5' 
.const [50] = Utf8 '\u5f15\u8d77' 
.const [51] = Utf8 '%1%2 %3%4' 
.const [52] = Utf8 '\u4ea4\u901a\u62e5\u5835' 
.const [53] = Class [96] 
.const [54] = NameAndType [97] [98] 
.const [55] = Utf8 de/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor$TextBuilder_Simplified_Chinese 
.const [56] = Utf8 de/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor$AbstractTextBuilder 
.const [57] = Utf8 de/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor 
.const [58] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [59] = Utf8 de/audi/atip/log/LogChannel 
.const [60] = Utf8 org/dsi/ifc/tmc/TmcMessage 
.const [61] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [62] = Utf8 de/audi/atip/util/StringUtilities 
.const [63] = Utf8 java/util/Locale 
.const [64] = Class [99] 
.const [65] = NameAndType [100] [101] 
.const [66] = Class [102] 
.const [67] = NameAndType [103] [104] 
.const [68] = Class [105] 
.const [69] = NameAndType [106] [107] 
.const [70] = Class [108] 
.const [71] = NameAndType [109] [110] 
.const [72] = Class [111] 
.const [73] = NameAndType [112] [113] 
.const [74] = Class [114] 
.const [75] = NameAndType [115] [116] 
.const [76] = Class [117] 
.const [77] = NameAndType [118] [119] 
.const [78] = Class [120] 
.const [79] = NameAndType [121] [122] 
.const [80] = Class [123] 
.const [81] = NameAndType [124] [125] 
.const [82] = Class [126] 
.const [83] = NameAndType [127] [128] 
.const [84] = Utf8 de/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor 
.const [85] = Utf8 access$000 
.const [86] = Utf8 (Lde/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor;)Lde/audi/tghu/navi/app/NavigationEnv; 
.const [87] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [88] = Utf8 formatDistance 
.const [89] = Utf8 (II)Ljava/lang/String; 
.const [90] = Utf8 de/audi/atip/util/StringUtilities 
.const [91] = Utf8 formatMessage 
.const [92] = Utf8 (Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String; 
.const [93] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [94] = Utf8 isEmpty 
.const [95] = Utf8 (Ljava/lang/String;)Z 
.const [96] = Utf8 java/util/Locale 
.const [97] = Utf8 CHINA 
.const [98] = Utf8 Ljava/util/Locale; 
.const [99] = Utf8 de/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor$TextBuilder_Simplified_Chinese 
.const [100] = Utf8 this$0 
.const [101] = Utf8 Lde/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor; 
.const [102] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [103] = Utf8 getLogChannel 
.const [104] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [105] = Utf8 de/audi/atip/log/LogChannel 
.const [106] = Utf8 log 
.const [107] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [108] = Utf8 org/dsi/ifc/tmc/TmcMessage 
.const [109] = Utf8 affectedRoadLength 
.const [110] = Utf8 J 
.const [111] = Utf8 org/dsi/ifc/tmc/TmcMessage 
.const [112] = Utf8 eventText 
.const [113] = Utf8 [Ljava/lang/String; 
.const [114] = Utf8 org/dsi/ifc/tmc/TmcMessage 
.const [115] = Utf8 distanceToEvent 
.const [116] = Utf8 J 
.const [117] = Utf8 de/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor$TextBuilder_Simplified_Chinese 
.const [118] = Utf8 mMaxCntAsia 
.const [119] = Utf8 I 
.const [120] = Utf8 de/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor$TextBuilder_Simplified_Chinese 
.const [121] = Utf8 wordWrap 
.const [122] = Utf8 (Ljava/lang/String;ILjava/util/Locale;)Ljava/lang/String; 
.const [123] = Utf8 de/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor$AbstractTextBuilder 
.const [124] = Utf8 <init> 
.const [125] = Utf8 (Lde/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor;II)V 
.const [126] = Utf8 de/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor$TextBuilder_Simplified_Chinese 
.const [127] = Utf8 this$0 
.const [128] = Utf8 Lde/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor; 
.const [129] = Utf8 de/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor$TextBuilder_Simplified_Chinese 
.const [130] = Class [129] 
.const [131] = Utf8 de/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor$AbstractTextBuilder 
.const [132] = Class [131] 
.const [133] = Utf8 this$0 
.const [134] = Utf8 Lde/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor; 
.const [135] = Utf8 Code 
.const [136] = Utf8 <init> 
.const [137] = Utf8 (Lde/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor;II)V 
.const [138] = Utf8 buildText 
.const [139] = Utf8 (Lorg/dsi/ifc/tmc/TmcMessage;)Ljava/lang/String; 
.end class 
