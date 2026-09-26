.version 50 0 
.class public super [164] 
.super [166] 
.field private [167] [168] 
.field private [169] [170] 

.method public [172] : [173] 
    .attribute [171] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [37] 
L4:     aload_0 
L5:     new [39] 
L8:     dup 
L9:     invokespecial [38] 
L12:    putfield [40] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [174] : [175] 
    .attribute [171] .code stack 4 locals 3 
L0:     invokestatic [3] 
L3:     invokevirtual [25] 
L6:     lstore_1 
L7:     lload_1 
L8:     ldc_w [1] 
L11:    ldiv 
L12:    l2i 
L13:    istore_3 
L14:    iload_3 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public [176] : [177] 
    .attribute [171] .code stack 5 locals 5 
L0:     bipush 64 
L2:     istore_2 
L3:     bipush 8 
L5:     istore_3 
L6:     iconst_0 
L7:     istore 4 
L9:     iload_1 
L10:    iload_2 
L11:    if_icmpge L25 
L14:    iload_1 
L15:    istore_2 
L16:    iload_2 
L17:    bipush 8 
L19:    if_icmpge L25 
L22:    bipush 8 
L24:    istore_2 
L25:    getstatic [4] 
L28:    ldc [5] 
L30:    invokevirtual [26] 
L33:    getstatic [4] 
L36:    ldc [6] 
L38:    invokevirtual [27] 
L41:    getstatic [4] 
L44:    iload_1 
L45:    invokevirtual [28] 
L48:    getstatic [4] 
L51:    ldc [7] 
L53:    invokevirtual [27] 
L56:    getstatic [4] 
L59:    aload_0 
L60:    invokevirtual [29] 
L63:    invokevirtual [28] 
L66:    getstatic [4] 
L69:    ldc [8] 
L71:    invokevirtual [27] 
L74:    getstatic [4] 
L77:    iload_2 
L78:    invokevirtual [28] 
L81:    iload_2 
L82:    sipush 1024 
L85:    imul 
L86:    istore_2 
        .catch [11] from L87 to L156 using L162 
L87:    iload_2 
L88:    newarray byte 
L90:    astore 5 
L92:    aload_0 
L93:    getfield [24] 
L96:    aload 5 
L98:    invokevirtual [30] 
L101:   pop 
L102:   aload_0 
L103:   dup 
L104:   getfield [31] 
L107:   iload_2 
L108:   i2l 
L109:   ladd 
L110:   putfield [41] 
L113:   aload_0 
L114:   invokevirtual [29] 
L117:   istore 6 
L119:   iload 6 
L121:   iload_1 
L122:   if_icmpge L159 
L125:   getstatic [4] 
L128:   ldc [9] 
L130:   invokevirtual [27] 
L133:   getstatic [4] 
L136:   iload 6 
L138:   invokevirtual [28] 
L141:   invokestatic [10] 
L144:   aload_0 
L145:   invokevirtual [29] 
L148:   istore 6 
L150:   iload 6 
L152:   iload_1 
L153:   if_icmpge L159 
L156:   goto L277 
L159:   goto L87 
L162:   astore 5 
L164:   iload 4 
L166:   ifne L244 
L169:   invokestatic [10] 
L172:   iconst_1 
L173:   istore 4 
L175:   aload_0 
L176:   invokevirtual [29] 
L179:   iload_1 
L180:   if_icmpge L186 
L183:   goto L277 
L186:   getstatic [4] 
L189:   ldc [12] 
L191:   invokevirtual [27] 
L194:   getstatic [4] 
L197:   aload_0 
L198:   getfield [31] 
L201:   ldc_w [1] 
L204:   ldiv 
L205:   invokevirtual [32] 
L208:   getstatic [4] 
L211:   ldc [13] 
L213:   invokevirtual [27] 
L216:   getstatic [4] 
L219:   iload_2 
L220:   invokevirtual [33] 
L223:   getstatic [4] 
L226:   ldc [14] 
L228:   invokevirtual [27] 
L231:   getstatic [4] 
L234:   aload_0 
L235:   invokevirtual [29] 
L238:   invokevirtual [28] 
L241:   goto L274 
L244:   iload_2 
L245:   iconst_2 
L246:   idiv 
L247:   istore_2 
L248:   iload_2 
L249:   iload_3 
L250:   if_icmpge L256 
L253:   goto L277 
L256:   iconst_0 
L257:   istore 4 
L259:   getstatic [4] 
L262:   ldc [15] 
L264:   invokevirtual [27] 
L267:   getstatic [4] 
L270:   iload_2 
L271:   invokevirtual [28] 
L274:   goto L87 
L277:   getstatic [4] 
L280:   ldc [16] 
L282:   invokevirtual [26] 
L285:   getstatic [4] 
L288:   ldc [7] 
L290:   invokevirtual [27] 
L293:   getstatic [4] 
L296:   aload_0 
L297:   invokevirtual [29] 
L300:   invokevirtual [28] 
L303:   getstatic [4] 
L306:   ldc [17] 
L308:   invokevirtual [27] 
L311:   getstatic [4] 
L314:   aload_0 
L315:   getfield [31] 
L318:   invokevirtual [32] 
L321:   getstatic [4] 
L324:   invokevirtual [34] 
L327:   return 
L328:   
    .end code 
.end method 

.method public [178] : [179] 
    .attribute [171] .code stack 5 locals 0 
L0:     getstatic [4] 
L3:     ldc [18] 
L5:     invokevirtual [26] 
L8:     aload_0 
L9:     getfield [24] 
L12:    invokevirtual [35] 
L15:    aload_0 
L16:    new [39] 
L19:    dup 
L20:    invokespecial [38] 
L23:    putfield [40] 
L26:    aload_0 
L27:    lconst_0 
L28:    putfield [41] 
L31:    invokestatic [10] 
L34:    getstatic [4] 
L37:    ldc [7] 
L39:    invokevirtual [27] 
L42:    getstatic [4] 
L45:    invokestatic [3] 
L48:    invokevirtual [25] 
L51:    ldc_w [1] 
L54:    ldiv 
L55:    invokevirtual [36] 
L58:    return 
L59:    nop 
L60:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [43] 
.const [3] = Method [44] [45] 
.const [4] = Field [46] [47] 
.const [5] = String [48] 
.const [6] = String [49] 
.const [7] = String [50] 
.const [8] = String [51] 
.const [9] = String [52] 
.const [10] = Method [53] [54] 
.const [11] = Class [55] 
.const [12] = String [56] 
.const [13] = String [57] 
.const [14] = String [58] 
.const [15] = String [59] 
.const [16] = String [60] 
.const [17] = String [61] 
.const [18] = String [62] 
.const [19] = Class [63] 
.const [20] = Class [64] 
.const [21] = Class [65] 
.const [22] = Class [66] 
.const [23] = Class [67] 
.const [24] = Field [68] [69] 
.const [25] = Method [70] [71] 
.const [26] = Method [72] [73] 
.const [27] = Method [74] [75] 
.const [28] = Method [76] [77] 
.const [29] = Method [78] [79] 
.const [30] = Method [80] [81] 
.const [31] = Field [82] [83] 
.const [32] = Method [84] [85] 
.const [33] = Method [86] [87] 
.const [34] = Method [88] [89] 
.const [35] = Method [90] [91] 
.const [36] = Method [92] [93] 
.const [37] = Method [94] [95] 
.const [38] = Method [96] [97] 
.const [39] = Class [98] 
.const [40] = Field [99] [100] 
.const [41] = Field [101] [102] 
.const [42] = Int 262144 
.const [43] = Utf8 java/util/ArrayList 
.const [44] = Class [103] 
.const [45] = NameAndType [104] [105] 
.const [46] = Class [106] 
.const [47] = NameAndType [107] [108] 
.const [48] = Utf8 '----------> FLOATER STARTED <----------' 
.const [49] = Utf8 'minFreeKiB requested: ' 
.const [50] = Utf8 'free: ' 
.const [51] = Utf8 'size: ' 
.const [52] = Utf8 'FLOATER: almost done. final GC: free=' 
.const [53] = Class [109] 
.const [54] = NameAndType [110] [111] 
.const [55] = Utf8 java/lang/Throwable 
.const [56] = Utf8 'FLOATER: GC. wasted=' 
.const [57] = Utf8 ', blockSize=' 
.const [58] = Utf8 ', freeHeap=' 
.const [59] = Utf8 'FLOATER: new size=' 
.const [60] = Utf8 '----------> FLOATER DONE <----------' 
.const [61] = Utf8 'floater is wasting ' 
.const [62] = Utf8 '----------> FLUSHING <----------' 
.const [63] = Utf8 de/esolutions/fw/util/commons/error/Floater 
.const [64] = Utf8 java/lang/Object 
.const [65] = Utf8 java/lang/Runtime 
.const [66] = Utf8 java/lang/System 
.const [67] = Utf8 java/io/PrintStream 
.const [68] = Class [112] 
.const [69] = NameAndType [113] [114] 
.const [70] = Class [115] 
.const [71] = NameAndType [116] [117] 
.const [72] = Class [118] 
.const [73] = NameAndType [119] [120] 
.const [74] = Class [121] 
.const [75] = NameAndType [122] [123] 
.const [76] = Class [124] 
.const [77] = NameAndType [125] [126] 
.const [78] = Class [127] 
.const [79] = NameAndType [128] [129] 
.const [80] = Class [130] 
.const [81] = NameAndType [131] [132] 
.const [82] = Class [133] 
.const [83] = NameAndType [134] [135] 
.const [84] = Class [136] 
.const [85] = NameAndType [137] [138] 
.const [86] = Class [139] 
.const [87] = NameAndType [140] [141] 
.const [88] = Class [142] 
.const [89] = NameAndType [143] [144] 
.const [90] = Class [145] 
.const [91] = NameAndType [146] [147] 
.const [92] = Class [148] 
.const [93] = NameAndType [149] [150] 
.const [94] = Class [151] 
.const [95] = NameAndType [152] [153] 
.const [96] = Class [154] 
.const [97] = NameAndType [155] [156] 
.const [98] = Utf8 java/util/ArrayList 
.const [99] = Class [157] 
.const [100] = NameAndType [158] [159] 
.const [101] = Class [160] 
.const [102] = NameAndType [161] [162] 
.const [103] = Utf8 java/lang/Runtime 
.const [104] = Utf8 getRuntime 
.const [105] = Utf8 ()Ljava/lang/Runtime; 
.const [106] = Utf8 java/lang/System 
.const [107] = Utf8 out 
.const [108] = Utf8 Ljava/io/PrintStream; 
.const [109] = Utf8 java/lang/System 
.const [110] = Utf8 gc 
.const [111] = Utf8 ()V 
.const [112] = Utf8 de/esolutions/fw/util/commons/error/Floater 
.const [113] = Utf8 nuggets 
.const [114] = Utf8 Ljava/util/ArrayList; 
.const [115] = Utf8 java/lang/Runtime 
.const [116] = Utf8 freeMemory 
.const [117] = Utf8 ()J 
.const [118] = Utf8 java/io/PrintStream 
.const [119] = Utf8 println 
.const [120] = Utf8 (Ljava/lang/String;)V 
.const [121] = Utf8 java/io/PrintStream 
.const [122] = Utf8 print 
.const [123] = Utf8 (Ljava/lang/String;)V 
.const [124] = Utf8 java/io/PrintStream 
.const [125] = Utf8 println 
.const [126] = Utf8 (I)V 
.const [127] = Utf8 de/esolutions/fw/util/commons/error/Floater 
.const [128] = Utf8 freeKiB 
.const [129] = Utf8 ()I 
.const [130] = Utf8 java/util/ArrayList 
.const [131] = Utf8 add 
.const [132] = Utf8 (Ljava/lang/Object;)Z 
.const [133] = Utf8 de/esolutions/fw/util/commons/error/Floater 
.const [134] = Utf8 totalSize 
.const [135] = Utf8 J 
.const [136] = Utf8 java/io/PrintStream 
.const [137] = Utf8 print 
.const [138] = Utf8 (J)V 
.const [139] = Utf8 java/io/PrintStream 
.const [140] = Utf8 print 
.const [141] = Utf8 (I)V 
.const [142] = Utf8 java/io/PrintStream 
.const [143] = Utf8 println 
.const [144] = Utf8 ()V 
.const [145] = Utf8 java/util/ArrayList 
.const [146] = Utf8 clear 
.const [147] = Utf8 ()V 
.const [148] = Utf8 java/io/PrintStream 
.const [149] = Utf8 println 
.const [150] = Utf8 (J)V 
.const [151] = Utf8 java/lang/Object 
.const [152] = Utf8 <init> 
.const [153] = Utf8 ()V 
.const [154] = Utf8 java/util/ArrayList 
.const [155] = Utf8 <init> 
.const [156] = Utf8 ()V 
.const [157] = Utf8 de/esolutions/fw/util/commons/error/Floater 
.const [158] = Utf8 nuggets 
.const [159] = Utf8 Ljava/util/ArrayList; 
.const [160] = Utf8 de/esolutions/fw/util/commons/error/Floater 
.const [161] = Utf8 totalSize 
.const [162] = Utf8 J 
.const [163] = Utf8 de/esolutions/fw/util/commons/error/Floater 
.const [164] = Class [163] 
.const [165] = Utf8 java/lang/Object 
.const [166] = Class [165] 
.const [167] = Utf8 totalSize 
.const [168] = Utf8 J 
.const [169] = Utf8 nuggets 
.const [170] = Utf8 Ljava/util/ArrayList; 
.const [171] = Utf8 Code 
.const [172] = Utf8 <init> 
.const [173] = Utf8 ()V 
.const [174] = Utf8 freeKiB 
.const [175] = Utf8 ()I 
.const [176] = Utf8 waste 
.const [177] = Utf8 (I)V 
.const [178] = Utf8 flush 
.const [179] = Utf8 ()V 
.end class 
