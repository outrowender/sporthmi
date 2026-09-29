.version 50 0 
.class super [123] 
.super [125] 
.implements [127] 
.field final [128] [129] 
.field [130] [131] 
.field [132] [133] 
.field private final synthetic [134] [135] 

.method [137] : [138] 
    .attribute [136] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [19] 
L5:     aload_0 
L6:     invokespecial [16] 
L9:     aload_0 
L10:    iconst_m1 
L11:    putfield [20] 
L14:    aload_0 
L15:    aload_2 
L16:    putfield [21] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [136] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     aload_0 
L5:     getfield [13] 
L8:     arraylength 
L9:     if_icmpge L16 
L12:    iconst_1 
L13:    goto L17 
L16:    iconst_0 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [136] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     aload_0 
L5:     getfield [13] 
L8:     arraylength 
L9:     if_icmplt L20 
L12:    new [23] 
L15:    dup 
L16:    invokespecial [17] 
L19:    athrow 
L20:    aload_0 
L21:    aload_0 
L22:    getfield [14] 
L25:    putfield [20] 
L28:    aload_0 
L29:    getfield [13] 
L32:    aload_0 
L33:    dup 
L34:    getfield [14] 
L37:    dup_x1 
L38:    iconst_1 
L39:    iadd 
L40:    putfield [22] 
L43:    aaload 
L44:    areturn 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [136] .code stack 2 locals 4 
L0:     aload_0 
L1:     getfield [12] 
L4:     ifge L15 
L7:     new [24] 
L10:    dup 
L11:    invokespecial [18] 
L14:    athrow 
L15:    aload_0 
L16:    getfield [13] 
L19:    aload_0 
L20:    getfield [12] 
L23:    aaload 
L24:    astore_1 
L25:    aload_0 
L26:    iconst_m1 
L27:    putfield [20] 
L30:    aload_0 
L31:    getfield [11] 
L34:    invokestatic [4] 
L37:    dup 
L38:    astore_2 
L39:    monitorenter 
        .catch [0] from L40 to L78 using L84 
L40:    aload_0 
L41:    getfield [11] 
L44:    invokestatic [5] 
L47:    invokevirtual [15] 
L50:    astore_3 
L51:    aload_3 
L52:    invokeinterface [25] 0 
L57:    ifeq L79 
L60:    aload_3 
L61:    invokeinterface [26] 0 
L66:    aload_1 
L67:    if_acmpne L51 
L70:    aload_3 
L71:    invokeinterface [27] 0 
L76:    aload_2 
L77:    monitorexit 
L78:    return 
        .catch [0] from L79 to L81 using L84 
L79:    aload_2 
L80:    monitorexit 
L81:    goto L91 
        .catch [0] from L84 to L88 using L84 
L84:    astore 4 
L86:    aload_2 
L87:    monitorexit 
L88:    aload 4 
L90:    athrow 
L91:    return 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [28] 
.const [3] = Class [29] 
.const [4] = Method [30] [31] 
.const [5] = Method [32] [33] 
.const [6] = Class [34] 
.const [7] = Class [35] 
.const [8] = Class [36] 
.const [9] = Class [37] 
.const [10] = Class [38] 
.const [11] = Field [39] [40] 
.const [12] = Field [41] [42] 
.const [13] = Field [43] [44] 
.const [14] = Field [45] [46] 
.const [15] = Method [47] [48] 
.const [16] = Method [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Field [55] [56] 
.const [20] = Field [57] [58] 
.const [21] = Field [59] [60] 
.const [22] = Field [61] [62] 
.const [23] = Class [63] 
.const [24] = Class [64] 
.const [25] = InterfaceMethod [65] [66] 
.const [26] = InterfaceMethod [67] [68] 
.const [27] = InterfaceMethod [69] [70] 
.const [28] = Utf8 java/util/NoSuchElementException 
.const [29] = Utf8 java/lang/IllegalStateException 
.const [30] = Class [71] 
.const [31] = NameAndType [72] [73] 
.const [32] = Class [74] 
.const [33] = NameAndType [75] [76] 
.const [34] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/DelayQueue$Itr 
.const [35] = Utf8 java/lang/Object 
.const [36] = Utf8 java/util/Iterator 
.const [37] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/DelayQueue 
.const [38] = Utf8 edu/emory/mathcs/backport/java/util/PriorityQueue 
.const [39] = Class [77] 
.const [40] = NameAndType [78] [79] 
.const [41] = Class [80] 
.const [42] = NameAndType [81] [82] 
.const [43] = Class [83] 
.const [44] = NameAndType [84] [85] 
.const [45] = Class [86] 
.const [46] = NameAndType [87] [88] 
.const [47] = Class [89] 
.const [48] = NameAndType [90] [91] 
.const [49] = Class [92] 
.const [50] = NameAndType [93] [94] 
.const [51] = Class [95] 
.const [52] = NameAndType [96] [97] 
.const [53] = Class [98] 
.const [54] = NameAndType [99] [100] 
.const [55] = Class [101] 
.const [56] = NameAndType [102] [103] 
.const [57] = Class [104] 
.const [58] = NameAndType [105] [106] 
.const [59] = Class [107] 
.const [60] = NameAndType [108] [109] 
.const [61] = Class [110] 
.const [62] = NameAndType [111] [112] 
.const [63] = Utf8 java/util/NoSuchElementException 
.const [64] = Utf8 java/lang/IllegalStateException 
.const [65] = Class [113] 
.const [66] = NameAndType [114] [115] 
.const [67] = Class [116] 
.const [68] = NameAndType [117] [118] 
.const [69] = Class [119] 
.const [70] = NameAndType [120] [121] 
.const [71] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/DelayQueue 
.const [72] = Utf8 access$000 
.const [73] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/DelayQueue;)Ljava/lang/Object; 
.const [74] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/DelayQueue 
.const [75] = Utf8 access$100 
.const [76] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/DelayQueue;)Ledu/emory/mathcs/backport/java/util/PriorityQueue; 
.const [77] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/DelayQueue$Itr 
.const [78] = Utf8 this$0 
.const [79] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/DelayQueue; 
.const [80] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/DelayQueue$Itr 
.const [81] = Utf8 lastRet 
.const [82] = Utf8 I 
.const [83] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/DelayQueue$Itr 
.const [84] = Utf8 array 
.const [85] = Utf8 [Ljava/lang/Object; 
.const [86] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/DelayQueue$Itr 
.const [87] = Utf8 cursor 
.const [88] = Utf8 I 
.const [89] = Utf8 edu/emory/mathcs/backport/java/util/PriorityQueue 
.const [90] = Utf8 iterator 
.const [91] = Utf8 ()Ljava/util/Iterator; 
.const [92] = Utf8 java/lang/Object 
.const [93] = Utf8 <init> 
.const [94] = Utf8 ()V 
.const [95] = Utf8 java/util/NoSuchElementException 
.const [96] = Utf8 <init> 
.const [97] = Utf8 ()V 
.const [98] = Utf8 java/lang/IllegalStateException 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.const [101] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/DelayQueue$Itr 
.const [102] = Utf8 this$0 
.const [103] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/DelayQueue; 
.const [104] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/DelayQueue$Itr 
.const [105] = Utf8 lastRet 
.const [106] = Utf8 I 
.const [107] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/DelayQueue$Itr 
.const [108] = Utf8 array 
.const [109] = Utf8 [Ljava/lang/Object; 
.const [110] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/DelayQueue$Itr 
.const [111] = Utf8 cursor 
.const [112] = Utf8 I 
.const [113] = Utf8 java/util/Iterator 
.const [114] = Utf8 hasNext 
.const [115] = Utf8 ()Z 
.const [116] = Utf8 java/util/Iterator 
.const [117] = Utf8 next 
.const [118] = Utf8 ()Ljava/lang/Object; 
.const [119] = Utf8 java/util/Iterator 
.const [120] = Utf8 remove 
.const [121] = Utf8 ()V 
.const [122] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/DelayQueue$Itr 
.const [123] = Class [122] 
.const [124] = Utf8 java/lang/Object 
.const [125] = Class [124] 
.const [126] = Utf8 java/util/Iterator 
.const [127] = Class [126] 
.const [128] = Utf8 array 
.const [129] = Utf8 [Ljava/lang/Object; 
.const [130] = Utf8 cursor 
.const [131] = Utf8 I 
.const [132] = Utf8 lastRet 
.const [133] = Utf8 I 
.const [134] = Utf8 this$0 
.const [135] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/DelayQueue; 
.const [136] = Utf8 Code 
.const [137] = Utf8 <init> 
.const [138] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/DelayQueue;[Ljava/lang/Object;)V 
.const [139] = Utf8 hasNext 
.const [140] = Utf8 ()Z 
.const [141] = Utf8 next 
.const [142] = Utf8 ()Ljava/lang/Object; 
.const [143] = Utf8 remove 
.const [144] = Utf8 ()V 
.end class 
