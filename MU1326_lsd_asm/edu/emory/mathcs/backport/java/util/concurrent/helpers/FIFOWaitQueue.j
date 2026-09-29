.version 50 0 
.class public super [91] 
.super [93] 
.implements [95] 
.field private static final [96] [97] 
.field protected transient [98] [99] 
.field protected transient [100] [101] 

.method public [103] : [104] 
    .attribute [102] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [16] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [17] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [102] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     ifnonnull L20 
L7:     aload_0 
L8:     aload_0 
L9:     aload_1 
L10:    dup_x1 
L11:    putfield [17] 
L14:    putfield [16] 
L17:    goto L33 
L20:    aload_0 
L21:    getfield [9] 
L24:    aload_1 
L25:    putfield [18] 
L28:    aload_0 
L29:    aload_1 
L30:    putfield [17] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [102] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [8] 
L4:     ifnonnull L9 
L7:     aconst_null 
L8:     areturn 
L9:     aload_0 
L10:    getfield [8] 
L13:    astore_1 
L14:    aload_0 
L15:    aload_1 
L16:    getfield [10] 
L19:    putfield [16] 
L22:    aload_0 
L23:    getfield [8] 
L26:    ifnonnull L34 
L29:    aload_0 
L30:    aconst_null 
L31:    putfield [17] 
L34:    aload_1 
L35:    aconst_null 
L36:    putfield [18] 
L39:    aload_1 
L40:    areturn 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [102] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [8] 
L5:     putfield [18] 
L8:     aload_0 
L9:     aload_1 
L10:    putfield [16] 
L13:    aload_0 
L14:    getfield [9] 
L17:    ifnonnull L25 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [17] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [111] : [112] 
    .attribute [102] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
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

.method public [113] : [114] 
    .attribute [102] .code stack 1 locals 2 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     getfield [8] 
L6:     astore_2 
L7:     aload_2 
L8:     ifnull L29 
L11:    aload_2 
L12:    getfield [11] 
L15:    ifeq L21 
L18:    iinc 1 1 
L21:    aload_2 
L22:    getfield [10] 
L25:    astore_2 
L26:    goto L7 
L29:    iload_1 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [102] .code stack 2 locals 3 
L0:     new [19] 
L3:     dup 
L4:     invokespecial [14] 
L7:     astore_1 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    getfield [8] 
L14:    astore_3 
L15:    aload_3 
L16:    ifnull L45 
L19:    aload_3 
L20:    getfield [11] 
L23:    ifeq L37 
L26:    aload_1 
L27:    aload_3 
L28:    getfield [12] 
L31:    invokeinterface [20] 0 
L36:    pop 
L37:    aload_3 
L38:    getfield [10] 
L41:    astore_3 
L42:    goto L15 
L45:    aload_1 
L46:    areturn 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [102] .code stack 2 locals 1 
L0:     aload_1 
L1:     ifnonnull L12 
L4:     new [21] 
L7:     dup 
L8:     invokespecial [15] 
L11:    athrow 
L12:    aload_0 
L13:    getfield [8] 
L16:    astore_2 
L17:    aload_2 
L18:    ifnull L46 
L21:    aload_2 
L22:    getfield [11] 
L25:    ifeq L38 
L28:    aload_2 
L29:    getfield [12] 
L32:    aload_1 
L33:    if_acmpne L38 
L36:    iconst_1 
L37:    areturn 
L38:    aload_2 
L39:    getfield [10] 
L42:    astore_2 
L43:    goto L17 
L46:    iconst_0 
L47:    areturn 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [22] 
.const [3] = Class [23] 
.const [4] = Class [24] 
.const [5] = Class [25] 
.const [6] = Class [26] 
.const [7] = Class [27] 
.const [8] = Field [28] [29] 
.const [9] = Field [30] [31] 
.const [10] = Field [32] [33] 
.const [11] = Field [34] [35] 
.const [12] = Field [36] [37] 
.const [13] = Method [38] [39] 
.const [14] = Method [40] [41] 
.const [15] = Method [42] [43] 
.const [16] = Field [44] [45] 
.const [17] = Field [46] [47] 
.const [18] = Field [48] [49] 
.const [19] = Class [50] 
.const [20] = InterfaceMethod [51] [52] 
.const [21] = Class [53] 
.const [22] = Utf8 java/util/ArrayList 
.const [23] = Utf8 java/lang/NullPointerException 
.const [24] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/FIFOWaitQueue 
.const [25] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue 
.const [26] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode 
.const [27] = Utf8 java/util/List 
.const [28] = Class [54] 
.const [29] = NameAndType [55] [56] 
.const [30] = Class [57] 
.const [31] = NameAndType [58] [59] 
.const [32] = Class [60] 
.const [33] = NameAndType [61] [62] 
.const [34] = Class [63] 
.const [35] = NameAndType [64] [65] 
.const [36] = Class [66] 
.const [37] = NameAndType [67] [68] 
.const [38] = Class [69] 
.const [39] = NameAndType [70] [71] 
.const [40] = Class [72] 
.const [41] = NameAndType [73] [74] 
.const [42] = Class [75] 
.const [43] = NameAndType [76] [77] 
.const [44] = Class [78] 
.const [45] = NameAndType [79] [80] 
.const [46] = Class [81] 
.const [47] = NameAndType [82] [83] 
.const [48] = Class [84] 
.const [49] = NameAndType [85] [86] 
.const [50] = Utf8 java/util/ArrayList 
.const [51] = Class [87] 
.const [52] = NameAndType [88] [89] 
.const [53] = Utf8 java/lang/NullPointerException 
.const [54] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/FIFOWaitQueue 
.const [55] = Utf8 head_ 
.const [56] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode; 
.const [57] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/FIFOWaitQueue 
.const [58] = Utf8 tail_ 
.const [59] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode; 
.const [60] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode 
.const [61] = Utf8 next 
.const [62] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode; 
.const [63] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode 
.const [64] = Utf8 waiting 
.const [65] = Utf8 Z 
.const [66] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode 
.const [67] = Utf8 owner 
.const [68] = Utf8 Ljava/lang/Thread; 
.const [69] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue 
.const [70] = Utf8 <init> 
.const [71] = Utf8 ()V 
.const [72] = Utf8 java/util/ArrayList 
.const [73] = Utf8 <init> 
.const [74] = Utf8 ()V 
.const [75] = Utf8 java/lang/NullPointerException 
.const [76] = Utf8 <init> 
.const [77] = Utf8 ()V 
.const [78] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/FIFOWaitQueue 
.const [79] = Utf8 head_ 
.const [80] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode; 
.const [81] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/FIFOWaitQueue 
.const [82] = Utf8 tail_ 
.const [83] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode; 
.const [84] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode 
.const [85] = Utf8 next 
.const [86] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode; 
.const [87] = Utf8 java/util/List 
.const [88] = Utf8 add 
.const [89] = Utf8 (Ljava/lang/Object;)Z 
.const [90] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/FIFOWaitQueue 
.const [91] = Class [90] 
.const [92] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue 
.const [93] = Class [92] 
.const [94] = Utf8 java/io/Serializable 
.const [95] = Class [94] 
.const [96] = Utf8 serialVersionUID 
.const [97] = Utf8 J 
.const [98] = Utf8 head_ 
.const [99] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode; 
.const [100] = Utf8 tail_ 
.const [101] = Utf8 Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode; 
.const [102] = Utf8 Code 
.const [103] = Utf8 <init> 
.const [104] = Utf8 ()V 
.const [105] = Utf8 insert 
.const [106] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode;)V 
.const [107] = Utf8 extract 
.const [108] = Utf8 ()Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode; 
.const [109] = Utf8 putBack 
.const [110] = Utf8 (Ledu/emory/mathcs/backport/java/util/concurrent/helpers/WaitQueue$WaitNode;)V 
.const [111] = Utf8 hasNodes 
.const [112] = Utf8 ()Z 
.const [113] = Utf8 getLength 
.const [114] = Utf8 ()I 
.const [115] = Utf8 getWaitingThreads 
.const [116] = Utf8 ()Ljava/util/Collection; 
.const [117] = Utf8 isWaiting 
.const [118] = Utf8 (Ljava/lang/Thread;)Z 
.end class 
