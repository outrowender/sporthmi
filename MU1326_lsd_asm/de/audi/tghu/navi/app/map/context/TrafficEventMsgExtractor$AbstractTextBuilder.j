.version 50 0 
.class super abstract [163] 
.super [165] 
.field protected [166] [167] 
.field protected [168] [169] 
.field private final synthetic [170] [171] 

.method public [173] : [174] 
    .attribute [172] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [34] 
L5:     aload_0 
L6:     invokespecial [32] 
L9:     aload_0 
L10:    iload_3 
L11:    putfield [35] 
L14:    aload_0 
L15:    iload_2 
L16:    putfield [36] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [172] .code stack 3 locals 0 
L0:     aload_1 
L1:     getfield [19] 
L4:     ifnonnull L28 
L7:     aload_0 
L8:     getfield [18] 
L11:    invokestatic [2] 
L14:    invokevirtual [20] 
L17:    sipush 10000 
L20:    ldc [3] 
L22:    invokevirtual [21] 
L25:    pop 
L26:    iconst_0 
L27:    areturn 
L28:    iconst_1 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [177] : [178] 
    .attribute [172] .code stack 4 locals 7 
L0:     aload_1 
L1:     ifnonnull L7 
L4:     ldc [4] 
L6:     areturn 
L7:     iload_2 
L8:     iconst_5 
L9:     if_icmpge L14 
L12:    aload_1 
L13:    areturn 
L14:    iload_2 
L15:    aload_1 
L16:    invokevirtual [22] 
L19:    if_icmplt L24 
L22:    aload_1 
L23:    areturn 
L24:    new [37] 
L27:    dup 
L28:    aload_1 
L29:    invokespecial [33] 
L32:    astore 4 
L34:    iconst_0 
L35:    istore 5 
L37:    iconst_0 
L38:    istore 6 
L40:    iconst_0 
L41:    istore 7 
L43:    iload 7 
L45:    aload 4 
L47:    invokevirtual [23] 
L50:    if_icmpge L280 
L53:    aload 4 
L55:    iload 7 
L57:    invokevirtual [24] 
L60:    bipush 10 
L62:    if_icmpne L74 
L65:    iload 7 
L67:    iconst_1 
L68:    iadd 
L69:    istore 6 
L71:    iconst_1 
L72:    istore 5 
L74:    iload 7 
L76:    iload 6 
L78:    iload_2 
L79:    iadd 
L80:    iconst_1 
L81:    isub 
L82:    if_icmple L274 
L85:    iload 5 
L87:    ifne L255 
L90:    iload 7 
L92:    iload 6 
L94:    isub 
L95:    iconst_1 
L96:    isub 
L97:    istore 8 
L99:    aload_3 
L100:   invokestatic [6] 
L103:   astore 9 
L105:   aload 9 
L107:   aload 4 
L109:   iload 6 
L111:   iload 7 
L113:   invokevirtual [25] 
L116:   invokevirtual [26] 
L119:   aload 9 
L121:   invokevirtual [27] 
L124:   istore 10 
L126:   iload 10 
L128:   iload 8 
L130:   iconst_1 
L131:   iadd 
L132:   if_icmpne L162 
L135:   aload 4 
L137:   iload 6 
L139:   iload 10 
L141:   iadd 
L142:   invokevirtual [24] 
L145:   invokestatic [7] 
L148:   ifne L162 
L151:   aload 9 
L153:   iload 10 
L155:   iconst_1 
L156:   isub 
L157:   invokevirtual [28] 
L160:   istore 10 
L162:   iload 10 
L164:   iconst_m1 
L165:   if_icmpeq L200 
L168:   iload 10 
L170:   iload 8 
L172:   iconst_1 
L173:   iadd 
L174:   if_icmpne L200 
L177:   aload 4 
L179:   iload 6 
L181:   iload 10 
L183:   iadd 
L184:   ldc [8] 
L186:   invokevirtual [29] 
L189:   pop 
L190:   iload 6 
L192:   iload 10 
L194:   iadd 
L195:   istore 6 
L197:   goto L252 
L200:   iload 10 
L202:   iconst_m1 
L203:   if_icmpeq L236 
L206:   iload 10 
L208:   ifeq L236 
L211:   aload 4 
L213:   iload 6 
L215:   iload 10 
L217:   iadd 
L218:   bipush 10 
L220:   invokevirtual [30] 
L223:   pop 
L224:   iload 6 
L226:   iload 10 
L228:   iadd 
L229:   iconst_1 
L230:   iadd 
L231:   istore 6 
L233:   goto L252 
L236:   aload 4 
L238:   iload 7 
L240:   bipush 10 
L242:   invokevirtual [30] 
L245:   pop 
L246:   iload 7 
L248:   iconst_1 
L249:   iadd 
L250:   istore 6 
L252:   goto L274 
L255:   aload 4 
L257:   iload 7 
L259:   bipush 10 
L261:   invokevirtual [30] 
L264:   pop 
L265:   iload 7 
L267:   iconst_1 
L268:   iadd 
L269:   istore 6 
L271:   iconst_0 
L272:   istore 5 
L274:   iinc 7 1 
L277:   goto L43 
L280:   aload 4 
L282:   invokevirtual [31] 
L285:   areturn 
L286:   nop 
L287:   nop 
L288:   
    .end code 
.end method 

.method public abstract [179] : [180] 
    .attribute [172] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [38] [39] 
.const [3] = String [40] 
.const [4] = String [41] 
.const [5] = Class [42] 
.const [6] = Method [43] [44] 
.const [7] = Method [45] [46] 
.const [8] = String [47] 
.const [9] = Class [48] 
.const [10] = Class [49] 
.const [11] = Class [50] 
.const [12] = Class [51] 
.const [13] = Class [52] 
.const [14] = Class [53] 
.const [15] = Class [54] 
.const [16] = Class [55] 
.const [17] = Class [56] 
.const [18] = Field [57] [58] 
.const [19] = Field [59] [60] 
.const [20] = Method [61] [62] 
.const [21] = Method [63] [64] 
.const [22] = Method [65] [66] 
.const [23] = Method [67] [68] 
.const [24] = Method [69] [70] 
.const [25] = Method [71] [72] 
.const [26] = Method [73] [74] 
.const [27] = Method [75] [76] 
.const [28] = Method [77] [78] 
.const [29] = Method [79] [80] 
.const [30] = Method [81] [82] 
.const [31] = Method [83] [84] 
.const [32] = Method [85] [86] 
.const [33] = Method [87] [88] 
.const [34] = Field [89] [90] 
.const [35] = Field [91] [92] 
.const [36] = Field [93] [94] 
.const [37] = Class [95] 
.const [38] = Class [96] 
.const [39] = NameAndType [97] [98] 
.const [40] = Utf8 'AbstractTextBuilder#validateTmcMessage(), TmcMessage.eventText is null!' 
.const [41] = Utf8 '' 
.const [42] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [43] = Class [99] 
.const [44] = NameAndType [100] [101] 
.const [45] = Class [102] 
.const [46] = NameAndType [103] [104] 
.const [47] = Utf8 '\n' 
.const [48] = Utf8 de/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor$AbstractTextBuilder 
.const [49] = Utf8 java/lang/Object 
.const [50] = Utf8 org/dsi/ifc/tmc/TmcMessage 
.const [51] = Utf8 de/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor 
.const [52] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [53] = Utf8 de/audi/atip/log/LogChannel 
.const [54] = Utf8 java/lang/String 
.const [55] = Utf8 java/text/BreakIterator 
.const [56] = Utf8 java/lang/Character 
.const [57] = Class [105] 
.const [58] = NameAndType [106] [107] 
.const [59] = Class [108] 
.const [60] = NameAndType [109] [110] 
.const [61] = Class [111] 
.const [62] = NameAndType [112] [113] 
.const [63] = Class [114] 
.const [64] = NameAndType [115] [116] 
.const [65] = Class [117] 
.const [66] = NameAndType [118] [119] 
.const [67] = Class [120] 
.const [68] = NameAndType [121] [122] 
.const [69] = Class [123] 
.const [70] = NameAndType [124] [125] 
.const [71] = Class [126] 
.const [72] = NameAndType [127] [128] 
.const [73] = Class [129] 
.const [74] = NameAndType [130] [131] 
.const [75] = Class [132] 
.const [76] = NameAndType [133] [134] 
.const [77] = Class [135] 
.const [78] = NameAndType [136] [137] 
.const [79] = Class [138] 
.const [80] = NameAndType [139] [140] 
.const [81] = Class [141] 
.const [82] = NameAndType [142] [143] 
.const [83] = Class [144] 
.const [84] = NameAndType [145] [146] 
.const [85] = Class [147] 
.const [86] = NameAndType [148] [149] 
.const [87] = Class [150] 
.const [88] = NameAndType [151] [152] 
.const [89] = Class [153] 
.const [90] = NameAndType [154] [155] 
.const [91] = Class [156] 
.const [92] = NameAndType [157] [158] 
.const [93] = Class [159] 
.const [94] = NameAndType [160] [161] 
.const [95] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [96] = Utf8 de/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor 
.const [97] = Utf8 access$000 
.const [98] = Utf8 (Lde/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor;)Lde/audi/tghu/navi/app/NavigationEnv; 
.const [99] = Utf8 java/text/BreakIterator 
.const [100] = Utf8 getLineInstance 
.const [101] = Utf8 (Ljava/util/Locale;)Ljava/text/BreakIterator; 
.const [102] = Utf8 java/lang/Character 
.const [103] = Utf8 isWhitespace 
.const [104] = Utf8 (C)Z 
.const [105] = Utf8 de/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor$AbstractTextBuilder 
.const [106] = Utf8 this$0 
.const [107] = Utf8 Lde/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor; 
.const [108] = Utf8 org/dsi/ifc/tmc/TmcMessage 
.const [109] = Utf8 eventText 
.const [110] = Utf8 [Ljava/lang/String; 
.const [111] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [112] = Utf8 getLogChannel 
.const [113] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [114] = Utf8 de/audi/atip/log/LogChannel 
.const [115] = Utf8 log 
.const [116] = Utf8 (ILjava/lang/String;)Z 
.const [117] = Utf8 java/lang/String 
.const [118] = Utf8 length 
.const [119] = Utf8 ()I 
.const [120] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [121] = Utf8 length 
.const [122] = Utf8 ()I 
.const [123] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [124] = Utf8 charAt 
.const [125] = Utf8 (I)C 
.const [126] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [127] = Utf8 substring 
.const [128] = Utf8 (II)Ljava/lang/String; 
.const [129] = Utf8 java/text/BreakIterator 
.const [130] = Utf8 setText 
.const [131] = Utf8 (Ljava/lang/String;)V 
.const [132] = Utf8 java/text/BreakIterator 
.const [133] = Utf8 last 
.const [134] = Utf8 ()I 
.const [135] = Utf8 java/text/BreakIterator 
.const [136] = Utf8 preceding 
.const [137] = Utf8 (I)I 
.const [138] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [139] = Utf8 insert 
.const [140] = Utf8 (ILjava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [141] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [142] = Utf8 insert 
.const [143] = Utf8 (IC)Lde/esolutions/fw/util/commons/Buffer; 
.const [144] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [145] = Utf8 toString 
.const [146] = Utf8 ()Ljava/lang/String; 
.const [147] = Utf8 java/lang/Object 
.const [148] = Utf8 <init> 
.const [149] = Utf8 ()V 
.const [150] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [151] = Utf8 <init> 
.const [152] = Utf8 (Ljava/lang/String;)V 
.const [153] = Utf8 de/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor$AbstractTextBuilder 
.const [154] = Utf8 this$0 
.const [155] = Utf8 Lde/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor; 
.const [156] = Utf8 de/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor$AbstractTextBuilder 
.const [157] = Utf8 mMaxCntAsia 
.const [158] = Utf8 I 
.const [159] = Utf8 de/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor$AbstractTextBuilder 
.const [160] = Utf8 mMaxCntEnglish 
.const [161] = Utf8 I 
.const [162] = Utf8 de/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor$AbstractTextBuilder 
.const [163] = Class [162] 
.const [164] = Utf8 java/lang/Object 
.const [165] = Class [164] 
.const [166] = Utf8 mMaxCntAsia 
.const [167] = Utf8 I 
.const [168] = Utf8 mMaxCntEnglish 
.const [169] = Utf8 I 
.const [170] = Utf8 this$0 
.const [171] = Utf8 Lde/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor; 
.const [172] = Utf8 Code 
.const [173] = Utf8 <init> 
.const [174] = Utf8 (Lde/audi/tghu/navi/app/map/context/TrafficEventMsgExtractor;II)V 
.const [175] = Utf8 validateTmcMessage 
.const [176] = Utf8 (Lorg/dsi/ifc/tmc/TmcMessage;)Z 
.const [177] = Utf8 wordWrap 
.const [178] = Utf8 (Ljava/lang/String;ILjava/util/Locale;)Ljava/lang/String; 
.const [179] = Utf8 buildText 
.const [180] = Utf8 (Lorg/dsi/ifc/tmc/TmcMessage;)Ljava/lang/String; 
.end class 
