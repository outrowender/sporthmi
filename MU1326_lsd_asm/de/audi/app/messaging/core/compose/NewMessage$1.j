.version 50 0 
.class final super [47] 
.super [49] 
.implements [51] 

.method annotation [53] : [54] 
    .attribute [52] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [11] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [55] : [56] 
    .attribute [52] .code stack 1 locals 3 
L0:     aload_1 
L1:     invokevirtual [7] 
L4:     invokevirtual [8] 
L7:     ifne L14 
L10:    iconst_1 
L11:    goto L15 
L14:    iconst_0 
L15:    istore_2 
L16:    aload_1 
L17:    invokevirtual [9] 
L20:    invokestatic [2] 
L23:    ifne L30 
L26:    iconst_1 
L27:    goto L31 
L30:    iconst_0 
L31:    istore_3 
L32:    aload_1 
L33:    invokevirtual [10] 
L36:    arraylength 
L37:    ifle L44 
L40:    iconst_1 
L41:    goto L45 
L44:    iconst_0 
L45:    istore 4 
L47:    iload_2 
L48:    ifeq L64 
L51:    iload_3 
L52:    ifne L60 
L55:    iload 4 
L57:    ifeq L64 
L60:    iconst_1 
L61:    goto L65 
L64:    iconst_0 
L65:    areturn 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [12] [13] 
.const [3] = Class [14] 
.const [4] = Class [15] 
.const [5] = Class [16] 
.const [6] = Class [17] 
.const [7] = Method [18] [19] 
.const [8] = Method [20] [21] 
.const [9] = Method [22] [23] 
.const [10] = Method [24] [25] 
.const [11] = Method [26] [27] 
.const [12] = Class [28] 
.const [13] = NameAndType [29] [30] 
.const [14] = Utf8 java/lang/Object 
.const [15] = Utf8 de/audi/app/messaging/core/compose/NewMessage 
.const [16] = Utf8 de/audi/app/messaging/core/compose/SelectedRecipientList 
.const [17] = Utf8 de/audi/app/messaging/core/util/Strings 
.const [18] = Class [31] 
.const [19] = NameAndType [32] [33] 
.const [20] = Class [34] 
.const [21] = NameAndType [35] [36] 
.const [22] = Class [37] 
.const [23] = NameAndType [38] [39] 
.const [24] = Class [40] 
.const [25] = NameAndType [41] [42] 
.const [26] = Class [43] 
.const [27] = NameAndType [44] [45] 
.const [28] = Utf8 de/audi/app/messaging/core/util/Strings 
.const [29] = Utf8 isNullOrEmpty 
.const [30] = Utf8 (Ljava/lang/String;)Z 
.const [31] = Utf8 de/audi/app/messaging/core/compose/NewMessage 
.const [32] = Utf8 getSelectedRecipientList 
.const [33] = Utf8 ()Lde/audi/app/messaging/core/compose/SelectedRecipientList; 
.const [34] = Utf8 de/audi/app/messaging/core/compose/SelectedRecipientList 
.const [35] = Utf8 isEmpty 
.const [36] = Utf8 ()Z 
.const [37] = Utf8 de/audi/app/messaging/core/compose/NewMessage 
.const [38] = Utf8 getBody 
.const [39] = Utf8 ()Ljava/lang/String; 
.const [40] = Utf8 de/audi/app/messaging/core/compose/NewMessage 
.const [41] = Utf8 getAttachments 
.const [42] = Utf8 ()[Lorg/dsi/ifc/messaging/AttachmentInformation; 
.const [43] = Utf8 java/lang/Object 
.const [44] = Utf8 <init> 
.const [45] = Utf8 ()V 
.const [46] = Utf8 de/audi/app/messaging/core/compose/NewMessage$1 
.const [47] = Class [46] 
.const [48] = Utf8 java/lang/Object 
.const [49] = Class [48] 
.const [50] = Utf8 de/audi/app/messaging/core/compose/ICompositionValidator 
.const [51] = Class [50] 
.const [52] = Utf8 Code 
.const [53] = Utf8 <init> 
.const [54] = Utf8 ()V 
.const [55] = Utf8 isValid 
.const [56] = Utf8 (Lde/audi/app/messaging/core/compose/NewMessage;)Z 
.end class 
