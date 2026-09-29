.version 50 0 
.class final super [71] 
.super [73] 
.field final synthetic [74] [75] 

.method [77] : [78] 
    .attribute [76] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [15] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [79] : [80] 
    .attribute [76] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [11] 
L4:     invokevirtual [12] 
L7:     iload_3 
L8:     if_icmpge L28 
L11:    aload_0 
L12:    getfield [11] 
L15:    iload_3 
L16:    aload_0 
L17:    getfield [11] 
L20:    invokevirtual [12] 
L23:    isub 
L24:    invokestatic [5] 
L27:    pop 
L28:    iload_3 
L29:    aload_0 
L30:    getfield [11] 
L33:    invokestatic [6] 
L36:    arraylength 
L37:    aload_0 
L38:    getfield [11] 
L41:    invokestatic [7] 
L44:    isub 
L45:    if_icmple L67 
L48:    aload_0 
L49:    getfield [11] 
L52:    invokestatic [6] 
L55:    arraylength 
L56:    aload_0 
L57:    getfield [11] 
L60:    invokestatic [7] 
L63:    isub 
L64:    goto L68 
L67:    iload_3 
L68:    istore 4 
L70:    aload_1 
L71:    iload_2 
L72:    aload_0 
L73:    getfield [11] 
L76:    invokestatic [6] 
L79:    aload_0 
L80:    getfield [11] 
L83:    invokestatic [7] 
L86:    iload 4 
L88:    invokestatic [9] 
L91:    iload 4 
L93:    iload_3 
L94:    if_icmpge L131 
L97:    aload_1 
L98:    iload_2 
L99:    iload 4 
L101:   iadd 
L102:   aload_0 
L103:   getfield [11] 
L106:   invokestatic [6] 
L109:   iconst_0 
L110:   iload_3 
L111:   iload 4 
L113:   isub 
L114:   invokestatic [9] 
L117:   aload_0 
L118:   getfield [11] 
L121:   iload_3 
L122:   iload 4 
L124:   isub 
L125:   invokestatic [10] 
L128:   goto L144 
L131:   aload_0 
L132:   getfield [11] 
L135:   dup 
L136:   invokestatic [7] 
L139:   iload_3 
L140:   iadd 
L141:   invokestatic [10] 
L144:   return 
L145:   nop 
L146:   nop 
L147:   nop 
L148:   
    .end code 
.end method 

.method public [81] : [82] 
    .attribute [76] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_0 
L3:     aload_1 
L4:     arraylength 
L5:     invokevirtual [13] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [83] : [84] 
    .attribute [76] .code stack 4 locals 1 
L0:     iconst_1 
L1:     newarray byte 
L3:     astore_2 
L4:     aload_2 
L5:     iconst_0 
L6:     iload_1 
L7:     i2b 
L8:     bastore 
L9:     aload_0 
L10:    aload_2 
L11:    iconst_0 
L12:    iconst_1 
L13:    invokevirtual [13] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [16] 
.const [3] = Class [17] 
.const [4] = Class [18] 
.const [5] = Method [19] [20] 
.const [6] = Method [21] [22] 
.const [7] = Method [23] [24] 
.const [8] = Class [25] 
.const [9] = Method [26] [27] 
.const [10] = Method [28] [29] 
.const [11] = Field [30] [31] 
.const [12] = Method [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Field [38] [39] 
.const [16] = Utf8 com/ibm/j9/ssl/StreamQueue$2 
.const [17] = Utf8 java/io/OutputStream 
.const [18] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [19] = Class [40] 
.const [20] = NameAndType [41] [42] 
.const [21] = Class [43] 
.const [22] = NameAndType [44] [45] 
.const [23] = Class [46] 
.const [24] = NameAndType [47] [48] 
.const [25] = Utf8 java/lang/System 
.const [26] = Class [49] 
.const [27] = NameAndType [50] [51] 
.const [28] = Class [52] 
.const [29] = NameAndType [53] [54] 
.const [30] = Class [55] 
.const [31] = NameAndType [56] [57] 
.const [32] = Class [58] 
.const [33] = NameAndType [59] [60] 
.const [34] = Class [61] 
.const [35] = NameAndType [62] [63] 
.const [36] = Class [64] 
.const [37] = NameAndType [65] [66] 
.const [38] = Class [67] 
.const [39] = NameAndType [68] [69] 
.const [40] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [41] = Utf8 access$3 
.const [42] = Utf8 (Lcom/ibm/j9/ssl/StreamQueue;I)I 
.const [43] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [44] = Utf8 access$0 
.const [45] = Utf8 (Lcom/ibm/j9/ssl/StreamQueue;)[B 
.const [46] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [47] = Utf8 access$4 
.const [48] = Utf8 (Lcom/ibm/j9/ssl/StreamQueue;)I 
.const [49] = Utf8 java/lang/System 
.const [50] = Utf8 arraycopy 
.const [51] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [52] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [53] = Utf8 access$5 
.const [54] = Utf8 (Lcom/ibm/j9/ssl/StreamQueue;I)V 
.const [55] = Utf8 com/ibm/j9/ssl/StreamQueue$2 
.const [56] = Utf8 this$0 
.const [57] = Utf8 Lcom/ibm/j9/ssl/StreamQueue; 
.const [58] = Utf8 com/ibm/j9/ssl/StreamQueue 
.const [59] = Utf8 getUnusedCapacity 
.const [60] = Utf8 ()I 
.const [61] = Utf8 com/ibm/j9/ssl/StreamQueue$2 
.const [62] = Utf8 write 
.const [63] = Utf8 ([BII)V 
.const [64] = Utf8 java/io/OutputStream 
.const [65] = Utf8 <init> 
.const [66] = Utf8 ()V 
.const [67] = Utf8 com/ibm/j9/ssl/StreamQueue$2 
.const [68] = Utf8 this$0 
.const [69] = Utf8 Lcom/ibm/j9/ssl/StreamQueue; 
.const [70] = Utf8 com/ibm/j9/ssl/StreamQueue$2 
.const [71] = Class [70] 
.const [72] = Utf8 java/io/OutputStream 
.const [73] = Class [72] 
.const [74] = Utf8 this$0 
.const [75] = Utf8 Lcom/ibm/j9/ssl/StreamQueue; 
.const [76] = Utf8 Code 
.const [77] = Utf8 <init> 
.const [78] = Utf8 (Lcom/ibm/j9/ssl/StreamQueue;)V 
.const [79] = Utf8 write 
.const [80] = Utf8 ([BII)V 
.const [81] = Utf8 write 
.const [82] = Utf8 ([B)V 
.const [83] = Utf8 write 
.const [84] = Utf8 (I)V 
.end class 
