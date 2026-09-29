.version 50 0 
.class super [81] 
.super [83] 
.implements [85] 
.field final [86] [87] 
.field [88] [89] 
.field [90] [91] 
.field [92] [93] 

.method [95] : [96] 
    .attribute [94] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [13] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [14] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [15] 
L19:    aload_0 
L20:    iload 4 
L22:    putfield [16] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [97] : [98] 
    .attribute [94] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     aload_0 
L5:     getfield [8] 
L8:     if_icmpge L15 
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

.method public [99] : [100] 
    .attribute [94] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     aload_0 
L5:     getfield [7] 
L8:     if_icmple L15 
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

.method public [101] : [102] 
    .attribute [94] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     aload_0 
L5:     getfield [7] 
L8:     isub 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [94] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     aload_0 
L5:     getfield [8] 
L8:     if_icmpne L19 
L11:    new [17] 
L14:    dup 
L15:    invokespecial [11] 
L18:    athrow 
L19:    aload_0 
L20:    getfield [6] 
L23:    aload_0 
L24:    dup 
L25:    getfield [9] 
L28:    dup_x1 
L29:    iconst_1 
L30:    iadd 
L31:    putfield [16] 
L34:    aaload 
L35:    areturn 
L36:    
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [94] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     aload_0 
L5:     getfield [7] 
L8:     isub 
L9:     iconst_1 
L10:    isub 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [94] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     aload_0 
L5:     getfield [7] 
L8:     if_icmpne L19 
L11:    new [17] 
L14:    dup 
L15:    invokespecial [11] 
L18:    athrow 
L19:    aload_0 
L20:    getfield [6] 
L23:    aload_0 
L24:    dup 
L25:    getfield [9] 
L28:    iconst_1 
L29:    isub 
L30:    dup_x1 
L31:    putfield [16] 
L34:    aaload 
L35:    areturn 
L36:    
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [94] .code stack 2 locals 0 
L0:     new [18] 
L3:     dup 
L4:     invokespecial [12] 
L7:     athrow 
L8:     
    .end code 
.end method 

.method public [111] : [112] 
    .attribute [94] .code stack 2 locals 0 
L0:     new [18] 
L3:     dup 
L4:     invokespecial [12] 
L7:     athrow 
L8:     
    .end code 
.end method 

.method public [113] : [114] 
    .attribute [94] .code stack 2 locals 0 
L0:     new [18] 
L3:     dup 
L4:     invokespecial [12] 
L7:     athrow 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [19] 
.const [3] = Class [20] 
.const [4] = Class [21] 
.const [5] = Class [22] 
.const [6] = Field [23] [24] 
.const [7] = Field [25] [26] 
.const [8] = Field [27] [28] 
.const [9] = Field [29] [30] 
.const [10] = Method [31] [32] 
.const [11] = Method [33] [34] 
.const [12] = Method [35] [36] 
.const [13] = Field [37] [38] 
.const [14] = Field [39] [40] 
.const [15] = Field [41] [42] 
.const [16] = Field [43] [44] 
.const [17] = Class [45] 
.const [18] = Class [46] 
.const [19] = Utf8 java/util/NoSuchElementException 
.const [20] = Utf8 java/lang/UnsupportedOperationException 
.const [21] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/CopyOnWriteArrayList$COWSubIterator 
.const [22] = Utf8 java/lang/Object 
.const [23] = Class [47] 
.const [24] = NameAndType [48] [49] 
.const [25] = Class [50] 
.const [26] = NameAndType [51] [52] 
.const [27] = Class [53] 
.const [28] = NameAndType [54] [55] 
.const [29] = Class [56] 
.const [30] = NameAndType [57] [58] 
.const [31] = Class [59] 
.const [32] = NameAndType [60] [61] 
.const [33] = Class [62] 
.const [34] = NameAndType [63] [64] 
.const [35] = Class [65] 
.const [36] = NameAndType [66] [67] 
.const [37] = Class [68] 
.const [38] = NameAndType [69] [70] 
.const [39] = Class [71] 
.const [40] = NameAndType [72] [73] 
.const [41] = Class [74] 
.const [42] = NameAndType [75] [76] 
.const [43] = Class [77] 
.const [44] = NameAndType [78] [79] 
.const [45] = Utf8 java/util/NoSuchElementException 
.const [46] = Utf8 java/lang/UnsupportedOperationException 
.const [47] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/CopyOnWriteArrayList$COWSubIterator 
.const [48] = Utf8 array 
.const [49] = Utf8 [Ljava/lang/Object; 
.const [50] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/CopyOnWriteArrayList$COWSubIterator 
.const [51] = Utf8 first 
.const [52] = Utf8 I 
.const [53] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/CopyOnWriteArrayList$COWSubIterator 
.const [54] = Utf8 last 
.const [55] = Utf8 I 
.const [56] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/CopyOnWriteArrayList$COWSubIterator 
.const [57] = Utf8 cursor 
.const [58] = Utf8 I 
.const [59] = Utf8 java/lang/Object 
.const [60] = Utf8 <init> 
.const [61] = Utf8 ()V 
.const [62] = Utf8 java/util/NoSuchElementException 
.const [63] = Utf8 <init> 
.const [64] = Utf8 ()V 
.const [65] = Utf8 java/lang/UnsupportedOperationException 
.const [66] = Utf8 <init> 
.const [67] = Utf8 ()V 
.const [68] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/CopyOnWriteArrayList$COWSubIterator 
.const [69] = Utf8 array 
.const [70] = Utf8 [Ljava/lang/Object; 
.const [71] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/CopyOnWriteArrayList$COWSubIterator 
.const [72] = Utf8 first 
.const [73] = Utf8 I 
.const [74] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/CopyOnWriteArrayList$COWSubIterator 
.const [75] = Utf8 last 
.const [76] = Utf8 I 
.const [77] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/CopyOnWriteArrayList$COWSubIterator 
.const [78] = Utf8 cursor 
.const [79] = Utf8 I 
.const [80] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/CopyOnWriteArrayList$COWSubIterator 
.const [81] = Class [80] 
.const [82] = Utf8 java/lang/Object 
.const [83] = Class [82] 
.const [84] = Utf8 java/util/ListIterator 
.const [85] = Class [84] 
.const [86] = Utf8 array 
.const [87] = Utf8 [Ljava/lang/Object; 
.const [88] = Utf8 cursor 
.const [89] = Utf8 I 
.const [90] = Utf8 first 
.const [91] = Utf8 I 
.const [92] = Utf8 last 
.const [93] = Utf8 I 
.const [94] = Utf8 Code 
.const [95] = Utf8 <init> 
.const [96] = Utf8 ([Ljava/lang/Object;III)V 
.const [97] = Utf8 hasNext 
.const [98] = Utf8 ()Z 
.const [99] = Utf8 hasPrevious 
.const [100] = Utf8 ()Z 
.const [101] = Utf8 nextIndex 
.const [102] = Utf8 ()I 
.const [103] = Utf8 next 
.const [104] = Utf8 ()Ljava/lang/Object; 
.const [105] = Utf8 previousIndex 
.const [106] = Utf8 ()I 
.const [107] = Utf8 previous 
.const [108] = Utf8 ()Ljava/lang/Object; 
.const [109] = Utf8 add 
.const [110] = Utf8 (Ljava/lang/Object;)V 
.const [111] = Utf8 set 
.const [112] = Utf8 (Ljava/lang/Object;)V 
.const [113] = Utf8 remove 
.const [114] = Utf8 ()V 
.end class 
