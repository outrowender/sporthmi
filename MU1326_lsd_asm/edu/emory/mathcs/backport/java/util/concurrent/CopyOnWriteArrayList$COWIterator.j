.version 50 0 
.class super [59] 
.super [61] 
.implements [63] 
.field final [64] [65] 
.field [66] [67] 

.method [69] : [70] 
    .attribute [68] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [9] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [12] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [13] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [71] : [72] 
    .attribute [68] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     aload_0 
L5:     getfield [7] 
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

.method public [73] : [74] 
    .attribute [68] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     ifle L11 
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

.method public interface [75] : [76] 
    .attribute [68] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [77] : [78] 
    .attribute [68] .code stack 5 locals 1 
        .catch [2] from L0 to L16 using L17 
L0:     aload_0 
L1:     getfield [7] 
L4:     aload_0 
L5:     dup 
L6:     getfield [8] 
L9:     dup_x1 
L10:    iconst_1 
L11:    iadd 
L12:    putfield [13] 
L15:    aaload 
L16:    areturn 
L17:    astore_1 
L18:    aload_0 
L19:    dup 
L20:    getfield [8] 
L23:    iconst_1 
L24:    isub 
L25:    putfield [13] 
L28:    new [14] 
L31:    dup 
L32:    invokespecial [10] 
L35:    athrow 
L36:    
    .end code 
.end method 

.method public [79] : [80] 
    .attribute [68] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     iconst_1 
L5:     isub 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [81] : [82] 
    .attribute [68] .code stack 4 locals 1 
        .catch [2] from L0 to L16 using L17 
L0:     aload_0 
L1:     getfield [7] 
L4:     aload_0 
L5:     dup 
L6:     getfield [8] 
L9:     iconst_1 
L10:    isub 
L11:    dup_x1 
L12:    putfield [13] 
L15:    aaload 
L16:    areturn 
L17:    astore_1 
L18:    aload_0 
L19:    dup 
L20:    getfield [8] 
L23:    iconst_1 
L24:    iadd 
L25:    putfield [13] 
L28:    new [14] 
L31:    dup 
L32:    invokespecial [10] 
L35:    athrow 
L36:    
    .end code 
.end method 

.method public [83] : [84] 
    .attribute [68] .code stack 2 locals 0 
L0:     new [15] 
L3:     dup 
L4:     invokespecial [11] 
L7:     athrow 
L8:     
    .end code 
.end method 

.method public [85] : [86] 
    .attribute [68] .code stack 2 locals 0 
L0:     new [15] 
L3:     dup 
L4:     invokespecial [11] 
L7:     athrow 
L8:     
    .end code 
.end method 

.method public [87] : [88] 
    .attribute [68] .code stack 2 locals 0 
L0:     new [15] 
L3:     dup 
L4:     invokespecial [11] 
L7:     athrow 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [16] 
.const [3] = Class [17] 
.const [4] = Class [18] 
.const [5] = Class [19] 
.const [6] = Class [20] 
.const [7] = Field [21] [22] 
.const [8] = Field [23] [24] 
.const [9] = Method [25] [26] 
.const [10] = Method [27] [28] 
.const [11] = Method [29] [30] 
.const [12] = Field [31] [32] 
.const [13] = Field [33] [34] 
.const [14] = Class [35] 
.const [15] = Class [36] 
.const [16] = Utf8 java/lang/IndexOutOfBoundsException 
.const [17] = Utf8 java/util/NoSuchElementException 
.const [18] = Utf8 java/lang/UnsupportedOperationException 
.const [19] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/CopyOnWriteArrayList$COWIterator 
.const [20] = Utf8 java/lang/Object 
.const [21] = Class [37] 
.const [22] = NameAndType [38] [39] 
.const [23] = Class [40] 
.const [24] = NameAndType [41] [42] 
.const [25] = Class [43] 
.const [26] = NameAndType [44] [45] 
.const [27] = Class [46] 
.const [28] = NameAndType [47] [48] 
.const [29] = Class [49] 
.const [30] = NameAndType [50] [51] 
.const [31] = Class [52] 
.const [32] = NameAndType [53] [54] 
.const [33] = Class [55] 
.const [34] = NameAndType [56] [57] 
.const [35] = Utf8 java/util/NoSuchElementException 
.const [36] = Utf8 java/lang/UnsupportedOperationException 
.const [37] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/CopyOnWriteArrayList$COWIterator 
.const [38] = Utf8 array 
.const [39] = Utf8 [Ljava/lang/Object; 
.const [40] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/CopyOnWriteArrayList$COWIterator 
.const [41] = Utf8 cursor 
.const [42] = Utf8 I 
.const [43] = Utf8 java/lang/Object 
.const [44] = Utf8 <init> 
.const [45] = Utf8 ()V 
.const [46] = Utf8 java/util/NoSuchElementException 
.const [47] = Utf8 <init> 
.const [48] = Utf8 ()V 
.const [49] = Utf8 java/lang/UnsupportedOperationException 
.const [50] = Utf8 <init> 
.const [51] = Utf8 ()V 
.const [52] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/CopyOnWriteArrayList$COWIterator 
.const [53] = Utf8 array 
.const [54] = Utf8 [Ljava/lang/Object; 
.const [55] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/CopyOnWriteArrayList$COWIterator 
.const [56] = Utf8 cursor 
.const [57] = Utf8 I 
.const [58] = Utf8 edu/emory/mathcs/backport/java/util/concurrent/CopyOnWriteArrayList$COWIterator 
.const [59] = Class [58] 
.const [60] = Utf8 java/lang/Object 
.const [61] = Class [60] 
.const [62] = Utf8 java/util/ListIterator 
.const [63] = Class [62] 
.const [64] = Utf8 array 
.const [65] = Utf8 [Ljava/lang/Object; 
.const [66] = Utf8 cursor 
.const [67] = Utf8 I 
.const [68] = Utf8 Code 
.const [69] = Utf8 <init> 
.const [70] = Utf8 ([Ljava/lang/Object;I)V 
.const [71] = Utf8 hasNext 
.const [72] = Utf8 ()Z 
.const [73] = Utf8 hasPrevious 
.const [74] = Utf8 ()Z 
.const [75] = Utf8 nextIndex 
.const [76] = Utf8 ()I 
.const [77] = Utf8 next 
.const [78] = Utf8 ()Ljava/lang/Object; 
.const [79] = Utf8 previousIndex 
.const [80] = Utf8 ()I 
.const [81] = Utf8 previous 
.const [82] = Utf8 ()Ljava/lang/Object; 
.const [83] = Utf8 add 
.const [84] = Utf8 (Ljava/lang/Object;)V 
.const [85] = Utf8 set 
.const [86] = Utf8 (Ljava/lang/Object;)V 
.const [87] = Utf8 remove 
.const [88] = Utf8 ()V 
.end class 
