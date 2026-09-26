.version 50 0 
.class super [145] 
.super [147] 
.implements [149] 
.field private [150] [151] 
.field private [152] [153] 
.field private [154] [155] 
.field private final synthetic [156] [157] 

.method [159] : [160] 
    .attribute [158] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [25] 
L5:     aload_0 
L6:     invokespecial [21] 
L9:     aload_0 
L10:    iconst_m1 
L11:    putfield [26] 
L14:    aload_1 
L15:    invokestatic [2] 
L18:    ifne L29 
L21:    aload_0 
L22:    iconst_m1 
L23:    putfield [27] 
L26:    goto L50 
L29:    aload_0 
L30:    aload_1 
L31:    invokestatic [3] 
L34:    putfield [27] 
L37:    aload_0 
L38:    aload_1 
L39:    invokestatic [4] 
L42:    aload_1 
L43:    invokestatic [3] 
L46:    aaload 
L47:    putfield [28] 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [161] : [162] 
    .attribute [158] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     iflt L11 
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

.method private [163] : [164] 
    .attribute [158] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     aload_0 
L5:     getfield [13] 
L8:     invokestatic [5] 
L11:    if_icmpne L27 
L14:    aload_0 
L15:    iconst_m1 
L16:    putfield [27] 
L19:    aload_0 
L20:    aconst_null 
L21:    putfield [28] 
L24:    goto L55 
L27:    aload_0 
L28:    aload_0 
L29:    getfield [13] 
L32:    invokestatic [4] 
L35:    aload_0 
L36:    getfield [15] 
L39:    aaload 
L40:    putfield [28] 
L43:    aload_0 
L44:    getfield [16] 
L47:    ifnonnull L55 
L50:    aload_0 
L51:    iconst_m1 
L52:    putfield [27] 
L55:    return 
L56:    
    .end code 
.end method 

.method public [165] : [166] 
    .attribute [158] .code stack 3 locals 4 
L0:     aload_0 
L1:     getfield [13] 
L4:     invokestatic [6] 
L7:     astore_1 
L8:     aload_1 
L9:     invokevirtual [17] 
        .catch [0] from L12 to L61 using L67 
L12:    aload_0 
L13:    getfield [15] 
L16:    ifge L27 
L19:    new [29] 
L22:    dup 
L23:    invokespecial [22] 
L26:    athrow 
L27:    aload_0 
L28:    aload_0 
L29:    getfield [15] 
L32:    putfield [26] 
L35:    aload_0 
L36:    getfield [16] 
L39:    astore_2 
L40:    aload_0 
L41:    aload_0 
L42:    getfield [13] 
L45:    aload_0 
L46:    getfield [15] 
L49:    invokevirtual [18] 
L52:    putfield [27] 
L55:    aload_0 
L56:    invokespecial [23] 
L59:    aload_2 
L60:    astore_3 
L61:    aload_1 
L62:    invokevirtual [19] 
L65:    aload_3 
L66:    areturn 
        .catch [0] from L67 to L69 using L67 
L67:    astore 4 
L69:    aload_1 
L70:    invokevirtual [19] 
L73:    aload 4 
L75:    athrow 
L76:    
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [158] .code stack 3 locals 4 
L0:     aload_0 
L1:     getfield [13] 
L4:     invokestatic [6] 
L7:     astore_1 
L8:     aload_1 
L9:     invokevirtual [17] 
        .catch [0] from L12 to L75 using L82 
L12:    aload_0 
L13:    getfield [14] 
L16:    istore_2 
L17:    iload_2 
L18:    iconst_m1 
L19:    if_icmpne L30 
L22:    new [30] 
L25:    dup 
L26:    invokespecial [24] 
L29:    athrow 
L30:    aload_0 
L31:    iconst_m1 
L32:    putfield [26] 
L35:    aload_0 
L36:    getfield [13] 
L39:    invokestatic [3] 
L42:    istore_3 
L43:    aload_0 
L44:    getfield [13] 
L47:    iload_2 
L48:    invokevirtual [20] 
L51:    aload_0 
L52:    iload_2 
L53:    iload_3 
L54:    if_icmpne L67 
L57:    aload_0 
L58:    getfield [13] 
L61:    invokestatic [3] 
L64:    goto L68 
L67:    iload_2 
L68:    putfield [27] 
L71:    aload_0 
L72:    invokespecial [23] 
L75:    aload_1 
L76:    invokevirtual [19] 
L79:    goto L91 
        .catch [0] from L82 to L84 using L82 
L82:    astore 4 
L84:    aload_1 
L85:    invokevirtual [19] 
L88:    aload 4 
L90:    athrow 
L91:    return 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [31] [32] 
.const [3] = Method [33] [34] 
.const [4] = Method [35] [36] 
.const [5] = Method [37] [38] 
.const [6] = Method [39] [40] 
.const [7] = Class [41] 
.const [8] = Class [42] 
.const [9] = Class [43] 
.const [10] = Class [44] 
.const [11] = Class [45] 
.const [12] = Class [46] 
.const [13] = Field [47] [48] 
.const [14] = Field [49] [50] 
.const [15] = Field [51] [52] 
.const [16] = Field [53] [54] 
.const [17] = Method [55] [56] 
.const [18] = Method [57] [58] 
.const [19] = Method [59] [60] 
.const [20] = Method [61] [62] 
.const [21] = Method [63] [64] 
.const [22] = Method [65] [66] 
.const [23] = Method [67] [68] 
.const [24] = Method [69] [70] 
.const [25] = Field [71] [72] 
.const [26] = Field [73] [74] 
.const [27] = Field [75] [76] 
.const [28] = Field [77] [78] 
.const [29] = Class [79] 
.const [30] = Class [80] 
.const [31] = Class [81] 
.const [32] = NameAndType [82] [83] 
.const [33] = Class [84] 
.const [34] = NameAndType [85] [86] 
.const [35] = Class [87] 
.const [36] = NameAndType [88] [89] 
.const [37] = Class [90] 
.const [38] = NameAndType [91] [92] 
.const [39] = Class [93] 
.const [40] = NameAndType [94] [95] 
.const [41] = Utf8 java/util/NoSuchElementException 
.const [42] = Utf8 java/lang/IllegalStateException 
.const [43] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue$Itr 
.const [44] = Utf8 java/lang/Object 
.const [45] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue 
.const [46] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/locks/ReentrantLock 
.const [47] = Class [96] 
.const [48] = NameAndType [97] [98] 
.const [49] = Class [99] 
.const [50] = NameAndType [100] [101] 
.const [51] = Class [102] 
.const [52] = NameAndType [103] [104] 
.const [53] = Class [105] 
.const [54] = NameAndType [106] [107] 
.const [55] = Class [108] 
.const [56] = NameAndType [109] [110] 
.const [57] = Class [111] 
.const [58] = NameAndType [112] [113] 
.const [59] = Class [114] 
.const [60] = NameAndType [115] [116] 
.const [61] = Class [117] 
.const [62] = NameAndType [118] [119] 
.const [63] = Class [120] 
.const [64] = NameAndType [121] [122] 
.const [65] = Class [123] 
.const [66] = NameAndType [124] [125] 
.const [67] = Class [126] 
.const [68] = NameAndType [127] [128] 
.const [69] = Class [129] 
.const [70] = NameAndType [130] [131] 
.const [71] = Class [132] 
.const [72] = NameAndType [133] [134] 
.const [73] = Class [135] 
.const [74] = NameAndType [136] [137] 
.const [75] = Class [138] 
.const [76] = NameAndType [139] [140] 
.const [77] = Class [141] 
.const [78] = NameAndType [142] [143] 
.const [79] = Utf8 java/util/NoSuchElementException 
.const [80] = Utf8 java/lang/IllegalStateException 
.const [81] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue 
.const [82] = Utf8 access$000 
.const [83] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue;)I 
.const [84] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue 
.const [85] = Utf8 access$100 
.const [86] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue;)I 
.const [87] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue 
.const [88] = Utf8 access$200 
.const [89] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue;)[Ljava/lang/Object; 
.const [90] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue 
.const [91] = Utf8 access$300 
.const [92] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue;)I 
.const [93] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue 
.const [94] = Utf8 access$400 
.const [95] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue;)Ledu/emory/mathcs/backport/java/util/concurrent/locks/ReentrantLock; 
.const [96] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue$Itr 
.const [97] = Utf8 this$0 
.const [98] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue; 
.const [99] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue$Itr 
.const [100] = Utf8 lastRet 
.const [101] = Utf8 I 
.const [102] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue$Itr 
.const [103] = Utf8 nextIndex 
.const [104] = Utf8 I 
.const [105] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue$Itr 
.const [106] = Utf8 nextItem 
.const [107] = Utf8 Ljava/lang/Object; 
.const [108] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/locks/ReentrantLock 
.const [109] = Utf8 lock 
.const [110] = Utf8 ()V 
.const [111] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue 
.const [112] = Utf8 inc 
.const [113] = Utf8 (I)I 
.const [114] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/locks/ReentrantLock 
.const [115] = Utf8 unlock 
.const [116] = Utf8 ()V 
.const [117] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue 
.const [118] = Utf8 removeAt 
.const [119] = Utf8 (I)V 
.const [120] = Utf8 java/lang/Object 
.const [121] = Utf8 <init> 
.const [122] = Utf8 ()V 
.const [123] = Utf8 java/util/NoSuchElementException 
.const [124] = Utf8 <init> 
.const [125] = Utf8 ()V 
.const [126] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue$Itr 
.const [127] = Utf8 checkNext 
.const [128] = Utf8 ()V 
.const [129] = Utf8 java/lang/IllegalStateException 
.const [130] = Utf8 <init> 
.const [131] = Utf8 ()V 
.const [132] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue$Itr 
.const [133] = Utf8 this$0 
.const [134] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue; 
.const [135] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue$Itr 
.const [136] = Utf8 lastRet 
.const [137] = Utf8 I 
.const [138] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue$Itr 
.const [139] = Utf8 nextIndex 
.const [140] = Utf8 I 
.const [141] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue$Itr 
.const [142] = Utf8 nextItem 
.const [143] = Utf8 Ljava/lang/Object; 
.const [144] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue$Itr 
.const [145] = Class [144] 
.const [146] = Utf8 java/lang/Object 
.const [147] = Class [146] 
.const [148] = Utf8 java/util/Iterator 
.const [149] = Class [148] 
.const [150] = Utf8 nextIndex 
.const [151] = Utf8 I 
.const [152] = Utf8 nextItem 
.const [153] = Utf8 Ljava/lang/Object; 
.const [154] = Utf8 lastRet 
.const [155] = Utf8 I 
.const [156] = Utf8 this$0 
.const [157] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue; 
.const [158] = Utf8 Code 
.const [159] = Utf8 <init> 
.const [160] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/ArrayBlockingQueue;)V 
.const [161] = Utf8 hasNext 
.const [162] = Utf8 ()Z 
.const [163] = Utf8 checkNext 
.const [164] = Utf8 ()V 
.const [165] = Utf8 next 
.const [166] = Utf8 ()Ljava/lang/Object; 
.const [167] = Utf8 remove 
.const [168] = Utf8 ()V 
.end class 
