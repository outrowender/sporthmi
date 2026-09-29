.version 50 0 
.class super [119] 
.super [121] 
.implements [123] 
.field [124] [125] 
.field [126] [127] 
.field [128] [129] 
.field final synthetic [130] [131] 

.method [133] : [134] 
    .attribute [132] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [21] 
L9:     aload_0 
L10:    iconst_m1 
L11:    putfield [22] 
L14:    aload_0 
L15:    iconst_m1 
L16:    putfield [23] 
L19:    aload_0 
L20:    aload_1 
L21:    getfield [12] 
L24:    putfield [24] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [132] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     iconst_1 
L5:     iadd 
L6:     aload_0 
L7:     getfield [9] 
L10:    invokevirtual [14] 
L13:    if_icmpge L18 
L16:    iconst_1 
L17:    areturn 
L18:    iconst_0 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [132] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [13] 
L4:     aload_0 
L5:     getfield [9] 
L8:     getfield [12] 
L11:    if_icmpne L54 
        .catch [7] from L14 to L45 using L45 
L14:    aload_0 
L15:    getfield [9] 
L18:    aload_0 
L19:    getfield [10] 
L22:    iconst_1 
L23:    iadd 
L24:    invokevirtual [15] 
L27:    astore_1 
L28:    aload_0 
L29:    aload_0 
L30:    dup 
L31:    getfield [10] 
L34:    iconst_1 
L35:    iadd 
L36:    dup_x1 
L37:    putfield [22] 
L40:    putfield [23] 
L43:    aload_1 
L44:    areturn 
L45:    pop 
L46:    new [25] 
L49:    dup 
L50:    invokespecial [18] 
L53:    athrow 
L54:    new [26] 
L57:    dup 
L58:    invokespecial [19] 
L61:    athrow 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [132] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     aload_0 
L5:     getfield [9] 
L8:     getfield [12] 
L11:    if_icmpne L91 
        .catch [7] from L14 to L29 using L29 
L14:    aload_0 
L15:    getfield [9] 
L18:    aload_0 
L19:    getfield [11] 
L22:    invokevirtual [16] 
L25:    pop 
L26:    goto L38 
L29:    pop 
L30:    new [27] 
L33:    dup 
L34:    invokespecial [20] 
L37:    athrow 
L38:    aload_0 
L39:    getfield [9] 
L42:    getfield [12] 
L45:    aload_0 
L46:    getfield [13] 
L49:    if_icmpeq L62 
L52:    aload_0 
L53:    dup 
L54:    getfield [13] 
L57:    iconst_1 
L58:    iadd 
L59:    putfield [24] 
L62:    aload_0 
L63:    getfield [10] 
L66:    aload_0 
L67:    getfield [11] 
L70:    if_icmpne L83 
L73:    aload_0 
L74:    dup 
L75:    getfield [10] 
L78:    iconst_1 
L79:    isub 
L80:    putfield [22] 
L83:    aload_0 
L84:    iconst_m1 
L85:    putfield [23] 
L88:    goto L99 
L91:    new [26] 
L94:    dup 
L95:    invokespecial [19] 
L98:    athrow 
L99:    return 
L100:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [28] 
.const [3] = Class [29] 
.const [4] = Class [30] 
.const [5] = Class [31] 
.const [6] = Class [32] 
.const [7] = Class [33] 
.const [8] = Class [34] 
.const [9] = Field [35] [36] 
.const [10] = Field [37] [38] 
.const [11] = Field [39] [40] 
.const [12] = Field [41] [42] 
.const [13] = Field [43] [44] 
.const [14] = Method [45] [46] 
.const [15] = Method [47] [48] 
.const [16] = Method [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Field [59] [60] 
.const [22] = Field [61] [62] 
.const [23] = Field [63] [64] 
.const [24] = Field [65] [66] 
.const [25] = Class [67] 
.const [26] = Class [68] 
.const [27] = Class [69] 
.const [28] = Utf8 java/util/AbstractList$SimpleListIterator 
.const [29] = Utf8 java/lang/Object 
.const [30] = Utf8 java/util/AbstractList 
.const [31] = Utf8 java/util/NoSuchElementException 
.const [32] = Utf8 java/util/ConcurrentModificationException 
.const [33] = Utf8 java/lang/IndexOutOfBoundsException 
.const [34] = Utf8 java/lang/IllegalStateException 
.const [35] = Class [70] 
.const [36] = NameAndType [71] [72] 
.const [37] = Class [73] 
.const [38] = NameAndType [74] [75] 
.const [39] = Class [76] 
.const [40] = NameAndType [77] [78] 
.const [41] = Class [79] 
.const [42] = NameAndType [80] [81] 
.const [43] = Class [82] 
.const [44] = NameAndType [83] [84] 
.const [45] = Class [85] 
.const [46] = NameAndType [86] [87] 
.const [47] = Class [88] 
.const [48] = NameAndType [89] [90] 
.const [49] = Class [91] 
.const [50] = NameAndType [92] [93] 
.const [51] = Class [94] 
.const [52] = NameAndType [95] [96] 
.const [53] = Class [97] 
.const [54] = NameAndType [98] [99] 
.const [55] = Class [100] 
.const [56] = NameAndType [101] [102] 
.const [57] = Class [103] 
.const [58] = NameAndType [104] [105] 
.const [59] = Class [106] 
.const [60] = NameAndType [107] [108] 
.const [61] = Class [109] 
.const [62] = NameAndType [110] [111] 
.const [63] = Class [112] 
.const [64] = NameAndType [113] [114] 
.const [65] = Class [115] 
.const [66] = NameAndType [116] [117] 
.const [67] = Utf8 java/util/NoSuchElementException 
.const [68] = Utf8 java/util/ConcurrentModificationException 
.const [69] = Utf8 java/lang/IllegalStateException 
.const [70] = Utf8 java/util/AbstractList$SimpleListIterator 
.const [71] = Utf8 this$0 
.const [72] = Utf8 Ljava/util/AbstractList; 
.const [73] = Utf8 java/util/AbstractList$SimpleListIterator 
.const [74] = Utf8 pos 
.const [75] = Utf8 I 
.const [76] = Utf8 java/util/AbstractList$SimpleListIterator 
.const [77] = Utf8 lastPosition 
.const [78] = Utf8 I 
.const [79] = Utf8 java/util/AbstractList 
.const [80] = Utf8 modCount 
.const [81] = Utf8 I 
.const [82] = Utf8 java/util/AbstractList$SimpleListIterator 
.const [83] = Utf8 expectedModCount 
.const [84] = Utf8 I 
.const [85] = Utf8 java/util/AbstractList 
.const [86] = Utf8 size 
.const [87] = Utf8 ()I 
.const [88] = Utf8 java/util/AbstractList 
.const [89] = Utf8 get 
.const [90] = Utf8 (I)Ljava/lang/Object; 
.const [91] = Utf8 java/util/AbstractList 
.const [92] = Utf8 remove 
.const [93] = Utf8 (I)Ljava/lang/Object; 
.const [94] = Utf8 java/lang/Object 
.const [95] = Utf8 <init> 
.const [96] = Utf8 ()V 
.const [97] = Utf8 java/util/NoSuchElementException 
.const [98] = Utf8 <init> 
.const [99] = Utf8 ()V 
.const [100] = Utf8 java/util/ConcurrentModificationException 
.const [101] = Utf8 <init> 
.const [102] = Utf8 ()V 
.const [103] = Utf8 java/lang/IllegalStateException 
.const [104] = Utf8 <init> 
.const [105] = Utf8 ()V 
.const [106] = Utf8 java/util/AbstractList$SimpleListIterator 
.const [107] = Utf8 this$0 
.const [108] = Utf8 Ljava/util/AbstractList; 
.const [109] = Utf8 java/util/AbstractList$SimpleListIterator 
.const [110] = Utf8 pos 
.const [111] = Utf8 I 
.const [112] = Utf8 java/util/AbstractList$SimpleListIterator 
.const [113] = Utf8 lastPosition 
.const [114] = Utf8 I 
.const [115] = Utf8 java/util/AbstractList$SimpleListIterator 
.const [116] = Utf8 expectedModCount 
.const [117] = Utf8 I 
.const [118] = Utf8 java/util/AbstractList$SimpleListIterator 
.const [119] = Class [118] 
.const [120] = Utf8 java/lang/Object 
.const [121] = Class [120] 
.const [122] = Utf8 java/util/Iterator 
.const [123] = Class [122] 
.const [124] = Utf8 pos 
.const [125] = Utf8 I 
.const [126] = Utf8 expectedModCount 
.const [127] = Utf8 I 
.const [128] = Utf8 lastPosition 
.const [129] = Utf8 I 
.const [130] = Utf8 this$0 
.const [131] = Utf8 Ljava/util/AbstractList; 
.const [132] = Utf8 Code 
.const [133] = Utf8 <init> 
.const [134] = Utf8 (Ljava/util/AbstractList;)V 
.const [135] = Utf8 hasNext 
.const [136] = Utf8 ()Z 
.const [137] = Utf8 next 
.const [138] = Utf8 ()Ljava/lang/Object; 
.const [139] = Utf8 remove 
.const [140] = Utf8 ()V 
.end class 
