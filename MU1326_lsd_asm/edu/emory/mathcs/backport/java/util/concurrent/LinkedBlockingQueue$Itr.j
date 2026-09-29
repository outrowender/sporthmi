.version 50 0 
.class super [157] 
.super [159] 
.implements [161] 
.field private [162] [163] 
.field private [164] [165] 
.field private [166] [167] 
.field private final synthetic [168] [169] 

.method [171] : [172] 
    .attribute [170] .code stack 2 locals 4 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [25] 
L5:     aload_0 
L6:     invokespecial [21] 
L9:     aload_1 
L10:    invokestatic [2] 
L13:    dup 
L14:    astore_2 
L15:    monitorenter 
L16:    aload_1 
L17:    invokestatic [3] 
L20:    dup 
L21:    astore_3 
L22:    monitorenter 
        .catch [0] from L23 to L54 using L57 
L23:    aload_0 
L24:    aload_1 
L25:    invokestatic [4] 
L28:    getfield [16] 
L31:    putfield [27] 
L34:    aload_0 
L35:    getfield [17] 
L38:    ifnull L52 
L41:    aload_0 
L42:    aload_0 
L43:    getfield [17] 
L46:    getfield [18] 
L49:    putfield [29] 
L52:    aload_3 
L53:    monitorexit 
L54:    goto L64 
        .catch [0] from L57 to L61 using L57 
        .catch [0] from L16 to L66 using L69 
L57:    astore 4 
L59:    aload_3 
L60:    monitorexit 
L61:    aload 4 
L63:    athrow 
L64:    aload_2 
L65:    monitorexit 
L66:    goto L76 
        .catch [0] from L69 to L73 using L69 
L69:    astore 5 
L71:    aload_2 
L72:    monitorexit 
L73:    aload 5 
L75:    athrow 
L76:    return 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [170] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     ifnull L11 
L7:     iconst_1 
L8:     goto L12 
L11:    iconst_0 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [170] .code stack 2 locals 5 
L0:     aload_0 
L1:     getfield [15] 
L4:     invokestatic [2] 
L7:     dup 
L8:     astore_1 
L9:     monitorenter 
L10:    aload_0 
L11:    getfield [15] 
L14:    invokestatic [3] 
L17:    dup 
L18:    astore_2 
L19:    monitorenter 
        .catch [0] from L20 to L80 using L83 
L20:    aload_0 
L21:    getfield [17] 
L24:    ifnonnull L35 
L27:    new [30] 
L30:    dup 
L31:    invokespecial [22] 
L34:    athrow 
L35:    aload_0 
L36:    getfield [19] 
L39:    astore_3 
L40:    aload_0 
L41:    aload_0 
L42:    getfield [17] 
L45:    putfield [31] 
L48:    aload_0 
L49:    aload_0 
L50:    getfield [17] 
L53:    getfield [16] 
L56:    putfield [27] 
L59:    aload_0 
L60:    getfield [17] 
L63:    ifnull L77 
L66:    aload_0 
L67:    aload_0 
L68:    getfield [17] 
L71:    getfield [18] 
L74:    putfield [29] 
L77:    aload_3 
L78:    aload_2 
L79:    monitorexit 
L80:    aload_1 
L81:    monitorexit 
L82:    areturn 
        .catch [0] from L83 to L87 using L83 
        .catch [0] from L10 to L82 using L90 
        .catch [0] from L83 to L94 using L90 
L83:    astore 4 
L85:    aload_2 
L86:    monitorexit 
L87:    aload 4 
L89:    athrow 
L90:    astore 5 
L92:    aload_1 
L93:    monitorexit 
L94:    aload 5 
L96:    athrow 
L97:    nop 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method public [177] : [178] 
    .attribute [170] .code stack 2 locals 10 
L0:     aload_0 
L1:     getfield [20] 
L4:     ifnonnull L15 
L7:     new [32] 
L10:    dup 
L11:    invokespecial [23] 
L14:    athrow 
L15:    aload_0 
L16:    getfield [15] 
L19:    invokestatic [2] 
L22:    dup 
L23:    astore_1 
L24:    monitorenter 
L25:    aload_0 
L26:    getfield [15] 
L29:    invokestatic [3] 
L32:    dup 
L33:    astore_2 
L34:    monitorenter 
L35:    aload_0 
L36:    getfield [20] 
L39:    astore_3 
L40:    aload_0 
L41:    aconst_null 
L42:    putfield [31] 
L45:    aload_0 
L46:    getfield [15] 
L49:    invokestatic [4] 
L52:    astore 4 
L54:    aload_0 
L55:    getfield [15] 
L58:    invokestatic [4] 
L61:    getfield [16] 
L64:    astore 5 
L66:    aload 5 
L68:    ifnull L91 
L71:    aload 5 
L73:    aload_3 
L74:    if_acmpeq L91 
L77:    aload 5 
L79:    astore 4 
L81:    aload 5 
L83:    getfield [16] 
L86:    astore 5 
L88:    goto L66 
L91:    aload 5 
L93:    aload_3 
L94:    if_acmpne L185 
L97:    aload 5 
L99:    aconst_null 
L100:   putfield [28] 
L103:   aload 4 
L105:   aload 5 
L107:   getfield [16] 
L110:   putfield [26] 
L113:   aload_0 
L114:   getfield [15] 
L117:   invokestatic [7] 
L120:   aload 5 
L122:   if_acmpne L135 
L125:   aload_0 
L126:   getfield [15] 
L129:   aload 4 
L131:   invokestatic [8] 
L134:   pop 
L135:   aload_0 
L136:   dup 
L137:   astore 7 
L139:   monitorenter 
        .catch [0] from L140 to L152 using L155 
L140:   aload_0 
L141:   getfield [15] 
L144:   invokestatic [9] 
L147:   istore 6 
L149:   aload 7 
L151:   monitorexit 
L152:   goto L163 
        .catch [0] from L155 to L160 using L155 
        .catch [0] from L35 to L187 using L190 
L155:   astore 8 
L157:   aload 7 
L159:   monitorexit 
L160:   aload 8 
L162:   athrow 
L163:   iload 6 
L165:   aload_0 
L166:   getfield [15] 
L169:   invokestatic [10] 
L172:   if_icmpne L185 
L175:   aload_0 
L176:   getfield [15] 
L179:   invokestatic [2] 
L182:   invokespecial [24] 
L185:   aload_2 
L186:   monitorexit 
L187:   goto L197 
        .catch [0] from L190 to L194 using L190 
        .catch [0] from L25 to L199 using L202 
L190:   astore 9 
L192:   aload_2 
L193:   monitorexit 
L194:   aload 9 
L196:   athrow 
L197:   aload_1 
L198:   monitorexit 
L199:   goto L209 
        .catch [0] from L202 to L206 using L202 
L202:   astore 10 
L204:   aload_1 
L205:   monitorexit 
L206:   aload 10 
L208:   athrow 
L209:   return 
L210:   nop 
L211:   nop 
L212:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [33] [34] 
.const [3] = Method [35] [36] 
.const [4] = Method [37] [38] 
.const [5] = Class [39] 
.const [6] = Class [40] 
.const [7] = Method [41] [42] 
.const [8] = Method [43] [44] 
.const [9] = Method [45] [46] 
.const [10] = Method [47] [48] 
.const [11] = Class [49] 
.const [12] = Class [50] 
.const [13] = Class [51] 
.const [14] = Class [52] 
.const [15] = Field [53] [54] 
.const [16] = Field [55] [56] 
.const [17] = Field [57] [58] 
.const [18] = Field [59] [60] 
.const [19] = Field [61] [62] 
.const [20] = Field [63] [64] 
.const [21] = Method [65] [66] 
.const [22] = Method [67] [68] 
.const [23] = Method [69] [70] 
.const [24] = Method [71] [72] 
.const [25] = Field [73] [74] 
.const [26] = Field [75] [76] 
.const [27] = Field [77] [78] 
.const [28] = Field [79] [80] 
.const [29] = Field [81] [82] 
.const [30] = Class [83] 
.const [31] = Field [84] [85] 
.const [32] = Class [86] 
.const [33] = Class [87] 
.const [34] = NameAndType [88] [89] 
.const [35] = Class [90] 
.const [36] = NameAndType [91] [92] 
.const [37] = Class [93] 
.const [38] = NameAndType [94] [95] 
.const [39] = Utf8 java/util/NoSuchElementException 
.const [40] = Utf8 java/lang/IllegalStateException 
.const [41] = Class [96] 
.const [42] = NameAndType [97] [98] 
.const [43] = Class [99] 
.const [44] = NameAndType [100] [101] 
.const [45] = Class [102] 
.const [46] = NameAndType [103] [104] 
.const [47] = Class [105] 
.const [48] = NameAndType [106] [107] 
.const [49] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Itr 
.const [50] = Utf8 java/lang/Object 
.const [51] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Node 
.const [52] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue 
.const [53] = Class [108] 
.const [54] = NameAndType [109] [110] 
.const [55] = Class [111] 
.const [56] = NameAndType [112] [113] 
.const [57] = Class [114] 
.const [58] = NameAndType [115] [116] 
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
.const [83] = Utf8 java/util/NoSuchElementException 
.const [84] = Class [153] 
.const [85] = NameAndType [154] [155] 
.const [86] = Utf8 java/lang/IllegalStateException 
.const [87] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue 
.const [88] = Utf8 access$100 
.const [89] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue;)Ljava/lang/Object; 
.const [90] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue 
.const [91] = Utf8 access$200 
.const [92] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue;)Ljava/lang/Object; 
.const [93] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue 
.const [94] = Utf8 access$300 
.const [95] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue;)Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Node; 
.const [96] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue 
.const [97] = Utf8 access$400 
.const [98] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue;)Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Node; 
.const [99] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue 
.const [100] = Utf8 access$402 
.const [101] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue;Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Node;)Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Node; 
.const [102] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue 
.const [103] = Utf8 access$510 
.const [104] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue;)I 
.const [105] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue 
.const [106] = Utf8 access$600 
.const [107] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue;)I 
.const [108] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Itr 
.const [109] = Utf8 this$0 
.const [110] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue; 
.const [111] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Node 
.const [112] = Utf8 next 
.const [113] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Node; 
.const [114] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Itr 
.const [115] = Utf8 current 
.const [116] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Node; 
.const [117] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Node 
.const [118] = Utf8 item 
.const [119] = Utf8 Ljava/lang/Object; 
.const [120] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Itr 
.const [121] = Utf8 currentElement 
.const [122] = Utf8 Ljava/lang/Object; 
.const [123] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Itr 
.const [124] = Utf8 lastRet 
.const [125] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Node; 
.const [126] = Utf8 java/lang/Object 
.const [127] = Utf8 <init> 
.const [128] = Utf8 ()V 
.const [129] = Utf8 java/util/NoSuchElementException 
.const [130] = Utf8 <init> 
.const [131] = Utf8 ()V 
.const [132] = Utf8 java/lang/IllegalStateException 
.const [133] = Utf8 <init> 
.const [134] = Utf8 ()V 
.const [135] = Utf8 java/lang/Object 
.const [136] = Utf8 notifyAll 
.const [137] = Utf8 ()V 
.const [138] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Itr 
.const [139] = Utf8 this$0 
.const [140] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue; 
.const [141] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Node 
.const [142] = Utf8 next 
.const [143] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Node; 
.const [144] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Itr 
.const [145] = Utf8 current 
.const [146] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Node; 
.const [147] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Node 
.const [148] = Utf8 item 
.const [149] = Utf8 Ljava/lang/Object; 
.const [150] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Itr 
.const [151] = Utf8 currentElement 
.const [152] = Utf8 Ljava/lang/Object; 
.const [153] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Itr 
.const [154] = Utf8 lastRet 
.const [155] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Node; 
.const [156] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Itr 
.const [157] = Class [156] 
.const [158] = Utf8 java/lang/Object 
.const [159] = Class [158] 
.const [160] = Utf8 java/util/Iterator 
.const [161] = Class [160] 
.const [162] = Utf8 current 
.const [163] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Node; 
.const [164] = Utf8 lastRet 
.const [165] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue$Node; 
.const [166] = Utf8 currentElement 
.const [167] = Utf8 Ljava/lang/Object; 
.const [168] = Utf8 this$0 
.const [169] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue; 
.const [170] = Utf8 Code 
.const [171] = Utf8 <init> 
.const [172] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/LinkedBlockingQueue;)V 
.const [173] = Utf8 hasNext 
.const [174] = Utf8 ()Z 
.const [175] = Utf8 next 
.const [176] = Utf8 ()Ljava/lang/Object; 
.const [177] = Utf8 remove 
.const [178] = Utf8 ()V 
.end class 
