.version 50 0 
.class super [115] 
.super [117] 
.implements [119] 
.field private [120] [121] 
.field private [122] [123] 
.field private [124] [125] 
.field private final synthetic [126] [127] 

.method [129] : [130] 
    .attribute [128] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [20] 
L5:     aload_0 
L6:     invokespecial [16] 
L9:     aload_0 
L10:    invokespecial [17] 
L13:    pop 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method private [131] : [132] 
    .attribute [128] .code stack 2 locals 3 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [9] 
L5:     putfield [22] 
L8:     aload_0 
L9:     getfield [11] 
L12:    astore_1 
L13:    aload_0 
L14:    getfield [9] 
L17:    ifnonnull L30 
L20:    aload_0 
L21:    getfield [8] 
L24:    invokevirtual [12] 
L27:    goto L37 
L30:    aload_0 
L31:    getfield [9] 
L34:    invokevirtual [13] 
L37:    astore_2 
L38:    aload_2 
L39:    ifnonnull L54 
L42:    aload_0 
L43:    aconst_null 
L44:    putfield [21] 
L47:    aload_0 
L48:    aconst_null 
L49:    putfield [23] 
L52:    aload_1 
L53:    areturn 
L54:    aload_2 
L55:    invokevirtual [14] 
L58:    astore_3 
L59:    aload_3 
L60:    ifnull L75 
L63:    aload_0 
L64:    aload_2 
L65:    putfield [21] 
L68:    aload_0 
L69:    aload_3 
L70:    putfield [23] 
L73:    aload_1 
L74:    areturn 
L75:    aload_2 
L76:    invokevirtual [13] 
L79:    astore_2 
L80:    goto L38 
L83:    nop 
L84:    
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [128] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
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

.method public [135] : [136] 
    .attribute [128] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     ifnonnull L15 
L7:     new [24] 
L10:    dup 
L11:    invokespecial [18] 
L14:    athrow 
L15:    aload_0 
L16:    invokespecial [17] 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [128] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [10] 
L4:     astore_1 
L5:     aload_1 
L6:     ifnonnull L17 
L9:     new [25] 
L12:    dup 
L13:    invokespecial [19] 
L16:    athrow 
L17:    aload_1 
L18:    aconst_null 
L19:    invokevirtual [15] 
L22:    aload_0 
L23:    aconst_null 
L24:    putfield [22] 
L27:    return 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [26] 
.const [3] = Class [27] 
.const [4] = Class [28] 
.const [5] = Class [29] 
.const [6] = Class [30] 
.const [7] = Class [31] 
.const [8] = Field [32] [33] 
.const [9] = Field [34] [35] 
.const [10] = Field [36] [37] 
.const [11] = Field [38] [39] 
.const [12] = Method [40] [41] 
.const [13] = Method [42] [43] 
.const [14] = Method [44] [45] 
.const [15] = Method [46] [47] 
.const [16] = Method [48] [49] 
.const [17] = Method [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Field [56] [57] 
.const [21] = Field [58] [59] 
.const [22] = Field [60] [61] 
.const [23] = Field [62] [63] 
.const [24] = Class [64] 
.const [25] = Class [65] 
.const [26] = Utf8 java/util/NoSuchElementException 
.const [27] = Utf8 java/lang/IllegalStateException 
.const [28] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Itr 
.const [29] = Utf8 java/lang/Object 
.const [30] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node 
.const [31] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue 
.const [32] = Class [66] 
.const [33] = NameAndType [67] [68] 
.const [34] = Class [69] 
.const [35] = NameAndType [70] [71] 
.const [36] = Class [72] 
.const [37] = NameAndType [73] [74] 
.const [38] = Class [75] 
.const [39] = NameAndType [76] [77] 
.const [40] = Class [78] 
.const [41] = NameAndType [79] [80] 
.const [42] = Class [81] 
.const [43] = NameAndType [82] [83] 
.const [44] = Class [84] 
.const [45] = NameAndType [85] [86] 
.const [46] = Class [87] 
.const [47] = NameAndType [88] [89] 
.const [48] = Class [90] 
.const [49] = NameAndType [91] [92] 
.const [50] = Class [93] 
.const [51] = NameAndType [94] [95] 
.const [52] = Class [96] 
.const [53] = NameAndType [97] [98] 
.const [54] = Class [99] 
.const [55] = NameAndType [100] [101] 
.const [56] = Class [102] 
.const [57] = NameAndType [103] [104] 
.const [58] = Class [105] 
.const [59] = NameAndType [106] [107] 
.const [60] = Class [108] 
.const [61] = NameAndType [109] [110] 
.const [62] = Class [111] 
.const [63] = NameAndType [112] [113] 
.const [64] = Utf8 java/util/NoSuchElementException 
.const [65] = Utf8 java/lang/IllegalStateException 
.const [66] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Itr 
.const [67] = Utf8 this$0 
.const [68] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue; 
.const [69] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Itr 
.const [70] = Utf8 nextNode 
.const [71] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node; 
.const [72] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Itr 
.const [73] = Utf8 lastRet 
.const [74] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node; 
.const [75] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Itr 
.const [76] = Utf8 nextItem 
.const [77] = Utf8 Ljava/lang/Object; 
.const [78] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue 
.const [79] = Utf8 first 
.const [80] = Utf8 ()Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node; 
.const [81] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node 
.const [82] = Utf8 getNext 
.const [83] = Utf8 ()Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node; 
.const [84] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node 
.const [85] = Utf8 getItem 
.const [86] = Utf8 ()Ljava/lang/Object; 
.const [87] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node 
.const [88] = Utf8 setItem 
.const [89] = Utf8 (Ljava/lang/Object;)V 
.const [90] = Utf8 java/lang/Object 
.const [91] = Utf8 <init> 
.const [92] = Utf8 ()V 
.const [93] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Itr 
.const [94] = Utf8 advance 
.const [95] = Utf8 ()Ljava/lang/Object; 
.const [96] = Utf8 java/util/NoSuchElementException 
.const [97] = Utf8 <init> 
.const [98] = Utf8 ()V 
.const [99] = Utf8 java/lang/IllegalStateException 
.const [100] = Utf8 <init> 
.const [101] = Utf8 ()V 
.const [102] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Itr 
.const [103] = Utf8 this$0 
.const [104] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue; 
.const [105] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Itr 
.const [106] = Utf8 nextNode 
.const [107] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node; 
.const [108] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Itr 
.const [109] = Utf8 lastRet 
.const [110] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node; 
.const [111] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Itr 
.const [112] = Utf8 nextItem 
.const [113] = Utf8 Ljava/lang/Object; 
.const [114] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Itr 
.const [115] = Class [114] 
.const [116] = Utf8 java/lang/Object 
.const [117] = Class [116] 
.const [118] = Utf8 java/util/Iterator 
.const [119] = Class [118] 
.const [120] = Utf8 nextNode 
.const [121] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node; 
.const [122] = Utf8 nextItem 
.const [123] = Utf8 Ljava/lang/Object; 
.const [124] = Utf8 lastRet 
.const [125] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue$Node; 
.const [126] = Utf8 this$0 
.const [127] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue; 
.const [128] = Utf8 Code 
.const [129] = Utf8 <init> 
.const [130] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/ConcurrentLinkedQueue;)V 
.const [131] = Utf8 advance 
.const [132] = Utf8 ()Ljava/lang/Object; 
.const [133] = Utf8 hasNext 
.const [134] = Utf8 ()Z 
.const [135] = Utf8 next 
.const [136] = Utf8 ()Ljava/lang/Object; 
.const [137] = Utf8 remove 
.const [138] = Utf8 ()V 
.end class 
