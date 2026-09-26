.version 50 0 
.class super [157] 
.super [159] 
.implements [161] 
.field private [162] [163] 
.field private [164] [165] 
.field private [166] [167] 
.field private final synthetic [168] [169] 

.method [171] : [172] 
    .attribute [170] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [27] 
L5:     aload_0 
L6:     invokespecial [24] 
L9:     aload_0 
L10:    aload_0 
L11:    getfield [18] 
L14:    invokestatic [2] 
L17:    putfield [28] 
L20:    aload_0 
L21:    iconst_m1 
L22:    putfield [29] 
L25:    aload_0 
L26:    aload_0 
L27:    getfield [18] 
L30:    invokestatic [3] 
L33:    putfield [30] 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [170] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ifne L21 
L7:     aload_0 
L8:     getfield [19] 
L11:    aload_0 
L12:    getfield [18] 
L15:    invokestatic [4] 
L18:    if_icmpeq L25 
L21:    iconst_1 
L22:    goto L26 
L25:    iconst_0 
L26:    areturn 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [170] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokevirtual [22] 
L4:     ifne L15 
L7:     new [31] 
L10:    dup 
L11:    invokespecial [25] 
L14:    athrow 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [30] 
L20:    aload_0 
L21:    aload_0 
L22:    getfield [19] 
L25:    putfield [29] 
L28:    aload_0 
L29:    aload_0 
L30:    getfield [18] 
L33:    aload_0 
L34:    getfield [19] 
L37:    invokestatic [6] 
L40:    putfield [28] 
L43:    aload_0 
L44:    getfield [18] 
L47:    invokestatic [7] 
L50:    aload_0 
L51:    getfield [20] 
L54:    aaload 
L55:    areturn 
L56:    
    .end code 
.end method 

.method public [177] : [178] 
    .attribute [170] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [20] 
L4:     iconst_m1 
L5:     if_icmpne L16 
L8:     new [32] 
L11:    dup 
L12:    invokespecial [26] 
L15:    athrow 
L16:    aload_0 
L17:    getfield [20] 
L20:    aload_0 
L21:    getfield [18] 
L24:    invokestatic [2] 
L27:    if_icmpne L44 
L30:    aload_0 
L31:    getfield [18] 
L34:    invokevirtual [23] 
L37:    pop 
L38:    aload_0 
L39:    iconst_m1 
L40:    putfield [29] 
L43:    return 
L44:    aload_0 
L45:    getfield [20] 
L48:    iconst_1 
L49:    iadd 
L50:    istore_1 
L51:    aload_0 
L52:    getfield [18] 
L55:    invokestatic [2] 
L58:    aload_0 
L59:    getfield [20] 
L62:    if_icmpge L110 
L65:    iload_1 
L66:    aload_0 
L67:    getfield [18] 
L70:    invokestatic [4] 
L73:    if_icmpge L110 
L76:    aload_0 
L77:    getfield [18] 
L80:    invokestatic [7] 
L83:    iload_1 
L84:    aload_0 
L85:    getfield [18] 
L88:    invokestatic [7] 
L91:    aload_0 
L92:    getfield [20] 
L95:    aload_0 
L96:    getfield [18] 
L99:    invokestatic [4] 
L102:   iload_1 
L103:   isub 
L104:   invokestatic [9] 
L107:   goto L194 
L110:   iload_1 
L111:   aload_0 
L112:   getfield [18] 
L115:   invokestatic [4] 
L118:   if_icmpeq L194 
L121:   iload_1 
L122:   aload_0 
L123:   getfield [18] 
L126:   invokestatic [10] 
L129:   if_icmplt L157 
L132:   aload_0 
L133:   getfield [18] 
L136:   invokestatic [7] 
L139:   iload_1 
L140:   iconst_1 
L141:   isub 
L142:   aload_0 
L143:   getfield [18] 
L146:   invokestatic [7] 
L149:   iconst_0 
L150:   aaload 
L151:   aastore 
L152:   iconst_0 
L153:   istore_1 
L154:   goto L110 
L157:   aload_0 
L158:   getfield [18] 
L161:   invokestatic [7] 
L164:   aload_0 
L165:   getfield [18] 
L168:   iload_1 
L169:   invokestatic [11] 
L172:   aload_0 
L173:   getfield [18] 
L176:   invokestatic [7] 
L179:   iload_1 
L180:   aaload 
L181:   aastore 
L182:   aload_0 
L183:   getfield [18] 
L186:   iload_1 
L187:   invokestatic [6] 
L190:   istore_1 
L191:   goto L110 
L194:   aload_0 
L195:   iconst_m1 
L196:   putfield [29] 
L199:   aload_0 
L200:   getfield [18] 
L203:   aload_0 
L204:   getfield [18] 
L207:   aload_0 
L208:   getfield [18] 
L211:   invokestatic [4] 
L214:   invokestatic [11] 
L217:   invokestatic [12] 
L220:   pop 
L221:   aload_0 
L222:   getfield [18] 
L225:   invokestatic [7] 
L228:   aload_0 
L229:   getfield [18] 
L232:   invokestatic [4] 
L235:   aconst_null 
L236:   aastore 
L237:   aload_0 
L238:   getfield [18] 
L241:   iconst_0 
L242:   invokestatic [13] 
L245:   pop 
L246:   aload_0 
L247:   aload_0 
L248:   getfield [18] 
L251:   aload_0 
L252:   getfield [19] 
L255:   invokestatic [11] 
L258:   putfield [28] 
L261:   return 
L262:   nop 
L263:   nop 
L264:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [33] [34] 
.const [3] = Method [35] [36] 
.const [4] = Method [37] [38] 
.const [5] = Class [39] 
.const [6] = Method [40] [41] 
.const [7] = Method [42] [43] 
.const [8] = Class [44] 
.const [9] = Method [45] [46] 
.const [10] = Method [47] [48] 
.const [11] = Method [49] [50] 
.const [12] = Method [51] [52] 
.const [13] = Method [53] [54] 
.const [14] = Class [55] 
.const [15] = Class [56] 
.const [16] = Class [57] 
.const [17] = Class [58] 
.const [18] = Field [59] [60] 
.const [19] = Field [61] [62] 
.const [20] = Field [63] [64] 
.const [21] = Field [65] [66] 
.const [22] = Method [67] [68] 
.const [23] = Method [69] [70] 
.const [24] = Method [71] [72] 
.const [25] = Method [73] [74] 
.const [26] = Method [75] [76] 
.const [27] = Field [77] [78] 
.const [28] = Field [79] [80] 
.const [29] = Field [81] [82] 
.const [30] = Field [83] [84] 
.const [31] = Class [85] 
.const [32] = Class [86] 
.const [33] = Class [87] 
.const [34] = NameAndType [88] [89] 
.const [35] = Class [90] 
.const [36] = NameAndType [91] [92] 
.const [37] = Class [93] 
.const [38] = NameAndType [94] [95] 
.const [39] = Utf8 java/util/NoSuchElementException 
.const [40] = Class [96] 
.const [41] = NameAndType [97] [98] 
.const [42] = Class [99] 
.const [43] = NameAndType [100] [101] 
.const [44] = Utf8 java/lang/IllegalStateException 
.const [45] = Class [102] 
.const [46] = NameAndType [103] [104] 
.const [47] = Class [105] 
.const [48] = NameAndType [106] [107] 
.const [49] = Class [108] 
.const [50] = NameAndType [109] [110] 
.const [51] = Class [111] 
.const [52] = NameAndType [112] [113] 
.const [53] = Class [114] 
.const [54] = NameAndType [115] [116] 
.const [55] = Utf8 de/audi/app/car/core/hybrid/StatisticsMemoryBuffer$1 
.const [56] = Utf8 java/lang/Object 
.const [57] = Utf8 de/audi/app/car/core/hybrid/StatisticsMemoryBuffer 
.const [58] = Utf8 java/lang/System 
.const [59] = Class [117] 
.const [60] = NameAndType [118] [119] 
.const [61] = Class [120] 
.const [62] = NameAndType [121] [122] 
.const [63] = Class [123] 
.const [64] = NameAndType [124] [125] 
.const [65] = Class [126] 
.const [66] = NameAndType [127] [128] 
.const [67] = Class [129] 
.const [68] = NameAndType [130] [131] 
.const [69] = Class [132] 
.const [70] = NameAndType [133] [134] 
.const [71] = Class [135] 
.const [72] = NameAndType [136] [137] 
.const [73] = Class [138] 
.const [74] = NameAndType [139] [140] 
.const [75] = Class [141] 
.const [76] = NameAndType [142] [143] 
.const [77] = Class [144] 
.const [78] = NameAndType [145] [146] 
.const [79] = Class [147] 
.const [80] = NameAndType [148] [149] 
.const [81] = Class [150] 
.const [82] = NameAndType [151] [152] 
.const [83] = Class [153] 
.const [84] = NameAndType [154] [155] 
.const [85] = Utf8 java/util/NoSuchElementException 
.const [86] = Utf8 java/lang/IllegalStateException 
.const [87] = Utf8 de/audi/app/car/core/hybrid/StatisticsMemoryBuffer 
.const [88] = Utf8 access$000 
.const [89] = Utf8 (Lde/audi/app/car/core/hybrid/StatisticsMemoryBuffer;)I 
.const [90] = Utf8 de/audi/app/car/core/hybrid/StatisticsMemoryBuffer 
.const [91] = Utf8 access$100 
.const [92] = Utf8 (Lde/audi/app/car/core/hybrid/StatisticsMemoryBuffer;)Z 
.const [93] = Utf8 de/audi/app/car/core/hybrid/StatisticsMemoryBuffer 
.const [94] = Utf8 access$200 
.const [95] = Utf8 (Lde/audi/app/car/core/hybrid/StatisticsMemoryBuffer;)I 
.const [96] = Utf8 de/audi/app/car/core/hybrid/StatisticsMemoryBuffer 
.const [97] = Utf8 access$300 
.const [98] = Utf8 (Lde/audi/app/car/core/hybrid/StatisticsMemoryBuffer;I)I 
.const [99] = Utf8 de/audi/app/car/core/hybrid/StatisticsMemoryBuffer 
.const [100] = Utf8 access$400 
.const [101] = Utf8 (Lde/audi/app/car/core/hybrid/StatisticsMemoryBuffer;)[Lde/audi/app/car/core/hybrid/IMemoryBufferEntry; 
.const [102] = Utf8 java/lang/System 
.const [103] = Utf8 arraycopy 
.const [104] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [105] = Utf8 de/audi/app/car/core/hybrid/StatisticsMemoryBuffer 
.const [106] = Utf8 access$500 
.const [107] = Utf8 (Lde/audi/app/car/core/hybrid/StatisticsMemoryBuffer;)I 
.const [108] = Utf8 de/audi/app/car/core/hybrid/StatisticsMemoryBuffer 
.const [109] = Utf8 access$600 
.const [110] = Utf8 (Lde/audi/app/car/core/hybrid/StatisticsMemoryBuffer;I)I 
.const [111] = Utf8 de/audi/app/car/core/hybrid/StatisticsMemoryBuffer 
.const [112] = Utf8 access$202 
.const [113] = Utf8 (Lde/audi/app/car/core/hybrid/StatisticsMemoryBuffer;I)I 
.const [114] = Utf8 de/audi/app/car/core/hybrid/StatisticsMemoryBuffer 
.const [115] = Utf8 access$102 
.const [116] = Utf8 (Lde/audi/app/car/core/hybrid/StatisticsMemoryBuffer;Z)Z 
.const [117] = Utf8 de/audi/app/car/core/hybrid/StatisticsMemoryBuffer$1 
.const [118] = Utf8 this$0 
.const [119] = Utf8 Lde/audi/app/car/core/hybrid/StatisticsMemoryBuffer; 
.const [120] = Utf8 de/audi/app/car/core/hybrid/StatisticsMemoryBuffer$1 
.const [121] = Utf8 index 
.const [122] = Utf8 I 
.const [123] = Utf8 de/audi/app/car/core/hybrid/StatisticsMemoryBuffer$1 
.const [124] = Utf8 lastReturnedIndex 
.const [125] = Utf8 I 
.const [126] = Utf8 de/audi/app/car/core/hybrid/StatisticsMemoryBuffer$1 
.const [127] = Utf8 isFirst 
.const [128] = Utf8 Z 
.const [129] = Utf8 de/audi/app/car/core/hybrid/StatisticsMemoryBuffer$1 
.const [130] = Utf8 hasNext 
.const [131] = Utf8 ()Z 
.const [132] = Utf8 de/audi/app/car/core/hybrid/StatisticsMemoryBuffer 
.const [133] = Utf8 dequeue 
.const [134] = Utf8 ()Lde/audi/app/car/core/hybrid/IMemoryBufferEntry; 
.const [135] = Utf8 java/lang/Object 
.const [136] = Utf8 <init> 
.const [137] = Utf8 ()V 
.const [138] = Utf8 java/util/NoSuchElementException 
.const [139] = Utf8 <init> 
.const [140] = Utf8 ()V 
.const [141] = Utf8 java/lang/IllegalStateException 
.const [142] = Utf8 <init> 
.const [143] = Utf8 ()V 
.const [144] = Utf8 de/audi/app/car/core/hybrid/StatisticsMemoryBuffer$1 
.const [145] = Utf8 this$0 
.const [146] = Utf8 Lde/audi/app/car/core/hybrid/StatisticsMemoryBuffer; 
.const [147] = Utf8 de/audi/app/car/core/hybrid/StatisticsMemoryBuffer$1 
.const [148] = Utf8 index 
.const [149] = Utf8 I 
.const [150] = Utf8 de/audi/app/car/core/hybrid/StatisticsMemoryBuffer$1 
.const [151] = Utf8 lastReturnedIndex 
.const [152] = Utf8 I 
.const [153] = Utf8 de/audi/app/car/core/hybrid/StatisticsMemoryBuffer$1 
.const [154] = Utf8 isFirst 
.const [155] = Utf8 Z 
.const [156] = Utf8 de/audi/app/car/core/hybrid/StatisticsMemoryBuffer$1 
.const [157] = Class [156] 
.const [158] = Utf8 java/lang/Object 
.const [159] = Class [158] 
.const [160] = Utf8 java/util/Iterator 
.const [161] = Class [160] 
.const [162] = Utf8 index 
.const [163] = Utf8 I 
.const [164] = Utf8 lastReturnedIndex 
.const [165] = Utf8 I 
.const [166] = Utf8 isFirst 
.const [167] = Utf8 Z 
.const [168] = Utf8 this$0 
.const [169] = Utf8 Lde/audi/app/car/core/hybrid/StatisticsMemoryBuffer; 
.const [170] = Utf8 Code 
.const [171] = Utf8 <init> 
.const [172] = Utf8 (Lde/audi/app/car/core/hybrid/StatisticsMemoryBuffer;)V 
.const [173] = Utf8 hasNext 
.const [174] = Utf8 ()Z 
.const [175] = Utf8 next 
.const [176] = Utf8 ()Ljava/lang/Object; 
.const [177] = Utf8 remove 
.const [178] = Utf8 ()V 
.end class 
