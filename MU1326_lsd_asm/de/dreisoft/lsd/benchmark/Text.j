.version 50 0 
.class public final super [45] 
.super [47] 

.method public annotation [49] : [50] 
    .attribute [48] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [51] : [52] 
    .attribute [48] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [6] 
L4:     iload_1 
L5:     if_icmpge L18 
L8:     aload_0 
L9:     bipush 32 
L11:    invokevirtual [7] 
L14:    pop 
L15:    goto L0 
L18:    aload_0 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public static [53] : [54] 
    .attribute [48] .code stack 2 locals 2 
L0:     lload_1 
L1:     invokestatic [2] 
L4:     astore 4 
L6:     iload_3 
L7:     aload 4 
L9:     invokevirtual [8] 
L12:    isub 
L13:    istore 5 
L15:    iload 5 
L17:    ifle L33 
L20:    aload_0 
L21:    bipush 32 
L23:    invokevirtual [7] 
L26:    pop 
L27:    iinc 5 -1 
L30:    goto L15 
L33:    aload_0 
L34:    aload 4 
L36:    invokevirtual [9] 
L39:    areturn 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [11] [12] 
.const [3] = Class [13] 
.const [4] = Class [14] 
.const [5] = Class [15] 
.const [6] = Method [16] [17] 
.const [7] = Method [18] [19] 
.const [8] = Method [20] [21] 
.const [9] = Method [22] [23] 
.const [10] = Method [24] [25] 
.const [11] = Class [26] 
.const [12] = NameAndType [27] [28] 
.const [13] = Utf8 java/lang/Object 
.const [14] = Utf8 java/lang/StringBuffer 
.const [15] = Utf8 java/lang/String 
.const [16] = Class [29] 
.const [17] = NameAndType [30] [31] 
.const [18] = Class [32] 
.const [19] = NameAndType [33] [34] 
.const [20] = Class [35] 
.const [21] = NameAndType [36] [37] 
.const [22] = Class [38] 
.const [23] = NameAndType [39] [40] 
.const [24] = Class [41] 
.const [25] = NameAndType [42] [43] 
.const [26] = Utf8 java/lang/String 
.const [27] = Utf8 valueOf 
.const [28] = Utf8 (J)Ljava/lang/String; 
.const [29] = Utf8 java/lang/StringBuffer 
.const [30] = Utf8 length 
.const [31] = Utf8 ()I 
.const [32] = Utf8 java/lang/StringBuffer 
.const [33] = Utf8 append 
.const [34] = Utf8 (C)Ljava/lang/StringBuffer; 
.const [35] = Utf8 java/lang/String 
.const [36] = Utf8 length 
.const [37] = Utf8 ()I 
.const [38] = Utf8 java/lang/StringBuffer 
.const [39] = Utf8 append 
.const [40] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [41] = Utf8 java/lang/Object 
.const [42] = Utf8 <init> 
.const [43] = Utf8 ()V 
.const [44] = Utf8 de/dreisoft/lsd/benchmark/Text 
.const [45] = Class [44] 
.const [46] = Utf8 java/lang/Object 
.const [47] = Class [46] 
.const [48] = Utf8 Code 
.const [49] = Utf8 <init> 
.const [50] = Utf8 ()V 
.const [51] = Utf8 fillWithSpace 
.const [52] = Utf8 (Ljava/lang/StringBuffer;I)Ljava/lang/StringBuffer; 
.const [53] = Utf8 appendFixedNumber 
.const [54] = Utf8 (Ljava/lang/StringBuffer;JI)Ljava/lang/StringBuffer; 
.end class 
