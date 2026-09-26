.version 50 0 
.class super [123] 
.super [125] 
.implements [127] 
.field private [128] [129] 
.field private [130] [131] 
.field private [132] [133] 
.field private final synthetic [134] [135] 

.method private [137] : [138] 
    .attribute [136] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [21] 
L5:     aload_0 
L6:     invokespecial [17] 
L9:     aload_0 
L10:    aload_0 
L11:    getfield [12] 
L14:    invokestatic [2] 
L17:    putfield [22] 
L20:    aload_0 
L21:    aload_0 
L22:    getfield [12] 
L25:    invokestatic [3] 
L28:    putfield [23] 
L31:    aload_0 
L32:    iconst_m1 
L33:    putfield [24] 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [136] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     aload_0 
L5:     getfield [14] 
L8:     if_icmpeq L15 
L11:    iconst_1 
L12:    goto L16 
L15:    iconst_0 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [136] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [13] 
L4:     aload_0 
L5:     getfield [14] 
L8:     if_icmpne L19 
L11:    new [25] 
L14:    dup 
L15:    invokespecial [18] 
L18:    athrow 
L19:    aload_0 
L20:    getfield [12] 
L23:    invokestatic [5] 
L26:    aload_0 
L27:    getfield [13] 
L30:    aaload 
L31:    astore_1 
L32:    aload_0 
L33:    getfield [12] 
L36:    invokestatic [3] 
L39:    aload_0 
L40:    getfield [14] 
L43:    if_icmpne L50 
L46:    aload_1 
L47:    ifnonnull L58 
L50:    new [26] 
L53:    dup 
L54:    invokespecial [19] 
L57:    athrow 
L58:    aload_0 
L59:    aload_0 
L60:    getfield [13] 
L63:    putfield [24] 
L66:    aload_0 
L67:    aload_0 
L68:    getfield [13] 
L71:    iconst_1 
L72:    iadd 
L73:    aload_0 
L74:    getfield [12] 
L77:    invokestatic [5] 
L80:    arraylength 
L81:    iconst_1 
L82:    isub 
L83:    iand 
L84:    putfield [22] 
L87:    aload_1 
L88:    areturn 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [136] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ifge L15 
L7:     new [27] 
L10:    dup 
L11:    invokespecial [20] 
L14:    athrow 
L15:    aload_0 
L16:    getfield [12] 
L19:    aload_0 
L20:    getfield [15] 
L23:    invokestatic [8] 
L26:    ifeq L61 
L29:    aload_0 
L30:    aload_0 
L31:    getfield [13] 
L34:    iconst_1 
L35:    isub 
L36:    aload_0 
L37:    getfield [12] 
L40:    invokestatic [5] 
L43:    arraylength 
L44:    iconst_1 
L45:    isub 
L46:    iand 
L47:    putfield [22] 
L50:    aload_0 
L51:    aload_0 
L52:    getfield [12] 
L55:    invokestatic [3] 
L58:    putfield [23] 
L61:    aload_0 
L62:    iconst_m1 
L63:    putfield [24] 
L66:    return 
L67:    nop 
L68:    
    .end code 
.end method 

.method synthetic [145] : [146] 
    .attribute [136] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [16] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [28] [29] 
.const [3] = Method [30] [31] 
.const [4] = Class [32] 
.const [5] = Method [33] [34] 
.const [6] = Class [35] 
.const [7] = Class [36] 
.const [8] = Method [37] [38] 
.const [9] = Class [39] 
.const [10] = Class [40] 
.const [11] = Class [41] 
.const [12] = Field [42] [43] 
.const [13] = Field [44] [45] 
.const [14] = Field [46] [47] 
.const [15] = Field [48] [49] 
.const [16] = Method [50] [51] 
.const [17] = Method [52] [53] 
.const [18] = Method [54] [55] 
.const [19] = Method [56] [57] 
.const [20] = Method [58] [59] 
.const [21] = Field [60] [61] 
.const [22] = Field [62] [63] 
.const [23] = Field [64] [65] 
.const [24] = Field [66] [67] 
.const [25] = Class [68] 
.const [26] = Class [69] 
.const [27] = Class [70] 
.const [28] = Class [71] 
.const [29] = NameAndType [72] [73] 
.const [30] = Class [74] 
.const [31] = NameAndType [75] [76] 
.const [32] = Utf8 java/util/NoSuchElementException 
.const [33] = Class [77] 
.const [34] = NameAndType [78] [79] 
.const [35] = Utf8 java/util/ConcurrentModificationException 
.const [36] = Utf8 java/lang/IllegalStateException 
.const [37] = Class [80] 
.const [38] = NameAndType [81] [82] 
.const [39] = Utf8 edu/emory/mathcs/backport/java/util/ArrayDeque$DeqIterator 
.const [40] = Utf8 java/lang/Object 
.const [41] = Utf8 edu/emory/mathcs/backport/java/util/ArrayDeque 
.const [42] = Class [83] 
.const [43] = NameAndType [84] [85] 
.const [44] = Class [86] 
.const [45] = NameAndType [87] [88] 
.const [46] = Class [89] 
.const [47] = NameAndType [90] [91] 
.const [48] = Class [92] 
.const [49] = NameAndType [93] [94] 
.const [50] = Class [95] 
.const [51] = NameAndType [96] [97] 
.const [52] = Class [98] 
.const [53] = NameAndType [99] [100] 
.const [54] = Class [101] 
.const [55] = NameAndType [102] [103] 
.const [56] = Class [104] 
.const [57] = NameAndType [105] [106] 
.const [58] = Class [107] 
.const [59] = NameAndType [108] [109] 
.const [60] = Class [110] 
.const [61] = NameAndType [111] [112] 
.const [62] = Class [113] 
.const [63] = NameAndType [114] [115] 
.const [64] = Class [116] 
.const [65] = NameAndType [117] [118] 
.const [66] = Class [119] 
.const [67] = NameAndType [120] [121] 
.const [68] = Utf8 java/util/NoSuchElementException 
.const [69] = Utf8 java/util/ConcurrentModificationException 
.const [70] = Utf8 java/lang/IllegalStateException 
.const [71] = Utf8 edu/emory/mathcs/backport/java/util/ArrayDeque 
.const [72] = Utf8 access$200 
.const [73] = Utf8 (Ledu/emory/mathcs/backport/java/util/ArrayDeque;)I 
.const [74] = Utf8 edu/emory/mathcs/backport/java/util/ArrayDeque 
.const [75] = Utf8 access$300 
.const [76] = Utf8 (Ledu/emory/mathcs/backport/java/util/ArrayDeque;)I 
.const [77] = Utf8 edu/emory/mathcs/backport/java/util/ArrayDeque 
.const [78] = Utf8 access$400 
.const [79] = Utf8 (Ledu/emory/mathcs/backport/java/util/ArrayDeque;)[Ljava/lang/Object; 
.const [80] = Utf8 edu/emory/mathcs/backport/java/util/ArrayDeque 
.const [81] = Utf8 access$500 
.const [82] = Utf8 (Ledu/emory/mathcs/backport/java/util/ArrayDeque;I)Z 
.const [83] = Utf8 edu/emory/mathcs/backport/java/util/ArrayDeque$DeqIterator 
.const [84] = Utf8 this$0 
.const [85] = Utf8 Ledu/emory/mathcs/backport/java/util/ArrayDeque; 
.const [86] = Utf8 edu/emory/mathcs/backport/java/util/ArrayDeque$DeqIterator 
.const [87] = Utf8 cursor 
.const [88] = Utf8 I 
.const [89] = Utf8 edu/emory/mathcs/backport/java/util/ArrayDeque$DeqIterator 
.const [90] = Utf8 fence 
.const [91] = Utf8 I 
.const [92] = Utf8 edu/emory/mathcs/backport/java/util/ArrayDeque$DeqIterator 
.const [93] = Utf8 lastRet 
.const [94] = Utf8 I 
.const [95] = Utf8 edu/emory/mathcs/backport/java/util/ArrayDeque$DeqIterator 
.const [96] = Utf8 <init> 
.const [97] = Utf8 (Ledu/emory/mathcs/backport/java/util/ArrayDeque;)V 
.const [98] = Utf8 java/lang/Object 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.const [101] = Utf8 java/util/NoSuchElementException 
.const [102] = Utf8 <init> 
.const [103] = Utf8 ()V 
.const [104] = Utf8 java/util/ConcurrentModificationException 
.const [105] = Utf8 <init> 
.const [106] = Utf8 ()V 
.const [107] = Utf8 java/lang/IllegalStateException 
.const [108] = Utf8 <init> 
.const [109] = Utf8 ()V 
.const [110] = Utf8 edu/emory/mathcs/backport/java/util/ArrayDeque$DeqIterator 
.const [111] = Utf8 this$0 
.const [112] = Utf8 Ledu/emory/mathcs/backport/java/util/ArrayDeque; 
.const [113] = Utf8 edu/emory/mathcs/backport/java/util/ArrayDeque$DeqIterator 
.const [114] = Utf8 cursor 
.const [115] = Utf8 I 
.const [116] = Utf8 edu/emory/mathcs/backport/java/util/ArrayDeque$DeqIterator 
.const [117] = Utf8 fence 
.const [118] = Utf8 I 
.const [119] = Utf8 edu/emory/mathcs/backport/java/util/ArrayDeque$DeqIterator 
.const [120] = Utf8 lastRet 
.const [121] = Utf8 I 
.const [122] = Utf8 edu/emory/mathcs/backport/java/util/ArrayDeque$DeqIterator 
.const [123] = Class [122] 
.const [124] = Utf8 java/lang/Object 
.const [125] = Class [124] 
.const [126] = Utf8 java/util/Iterator 
.const [127] = Class [126] 
.const [128] = Utf8 cursor 
.const [129] = Utf8 I 
.const [130] = Utf8 fence 
.const [131] = Utf8 I 
.const [132] = Utf8 lastRet 
.const [133] = Utf8 I 
.const [134] = Utf8 this$0 
.const [135] = Utf8 Ledu/emory/mathcs/backport/java/util/ArrayDeque; 
.const [136] = Utf8 Code 
.const [137] = Utf8 <init> 
.const [138] = Utf8 (Ledu/emory/mathcs/backport/java/util/ArrayDeque;)V 
.const [139] = Utf8 hasNext 
.const [140] = Utf8 ()Z 
.const [141] = Utf8 next 
.const [142] = Utf8 ()Ljava/lang/Object; 
.const [143] = Utf8 remove 
.const [144] = Utf8 ()V 
.const [145] = Utf8 <init> 
.const [146] = Utf8 (Ledu/emory/mathcs/backport/java/util/ArrayDeque;Ledu/emory/mathcs/backport/java/util/ArrayDeque$1;)V 
.end class 
