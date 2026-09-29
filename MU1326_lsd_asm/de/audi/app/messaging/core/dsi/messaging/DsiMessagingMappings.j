.version 50 0 
.class public final super [116] 
.super [118] 

.method public annotation [120] : [121] 
    .attribute [119] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [122] : [123] 
    .attribute [119] .code stack 4 locals 4 
L0:     aload_1 
L1:     ifnull L104 
L4:     new [26] 
L7:     dup 
L8:     aload_1 
L9:     arraylength 
L10:    invokespecial [25] 
L13:    astore_2 
L14:    iconst_0 
L15:    istore_3 
L16:    iload_3 
L17:    aload_1 
L18:    arraylength 
L19:    if_icmpge L73 
L22:    aload_1 
L23:    iload_3 
L24:    aaload 
L25:    astore 4 
L27:    aload 4 
L29:    invokevirtual [15] 
L32:    astore 5 
L34:    aload 4 
L36:    invokestatic [3] 
L39:    ifeq L67 
L42:    aload 5 
L44:    invokevirtual [16] 
L47:    iconst_5 
L48:    if_icmpne L67 
L51:    aload 5 
L53:    iconst_1 
L54:    putfield [27] 
L57:    aload_2 
L58:    aload 5 
L60:    invokevirtual [17] 
L63:    invokevirtual [18] 
L66:    pop 
L67:    iinc 3 1 
L70:    goto L16 
L73:    aload_0 
L74:    ifnull L104 
L77:    aload_0 
L78:    invokevirtual [19] 
L81:    ifeq L104 
L84:    aload_2 
L85:    invokevirtual [20] 
L88:    ifne L104 
L91:    aload_0 
L92:    ldc [4] 
L94:    ldc [5] 
L96:    aload_2 
L97:    invokestatic [6] 
L100:   invokevirtual [21] 
L103:   pop 
L104:   aload_1 
L105:   areturn 
L106:   nop 
L107:   nop 
L108:   
    .end code 
.end method 

.method public static [124] : [125] 
    .attribute [119] .code stack 4 locals 0 
L0:     aload_1 
L1:     ifnull L41 
L4:     aload_1 
L5:     invokevirtual [22] 
L8:     iconst_5 
L9:     if_icmpne L41 
L12:    aload_1 
L13:    iconst_1 
L14:    putfield [28] 
L17:    aload_0 
L18:    ifnull L41 
L21:    aload_0 
L22:    invokevirtual [19] 
L25:    ifeq L41 
L28:    aload_0 
L29:    ldc [4] 
L31:    ldc [7] 
L33:    aload_1 
L34:    invokevirtual [23] 
L37:    invokevirtual [21] 
L40:    pop 
L41:    aload_1 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [29] 
.const [3] = Method [30] [31] 
.const [4] = Int 1078071040 
.const [5] = String [32] 
.const [6] = Method [33] [34] 
.const [7] = String [35] 
.const [8] = Class [36] 
.const [9] = Class [37] 
.const [10] = Class [38] 
.const [11] = Class [39] 
.const [12] = Class [40] 
.const [13] = Class [41] 
.const [14] = Class [42] 
.const [15] = Method [43] [44] 
.const [16] = Method [45] [46] 
.const [17] = Method [47] [48] 
.const [18] = Method [49] [50] 
.const [19] = Method [51] [52] 
.const [20] = Method [53] [54] 
.const [21] = Method [55] [56] 
.const [22] = Method [57] [58] 
.const [23] = Method [59] [60] 
.const [24] = Method [61] [62] 
.const [25] = Method [63] [64] 
.const [26] = Class [65] 
.const [27] = Field [66] [67] 
.const [28] = Field [68] [69] 
.const [29] = Utf8 java/util/ArrayList 
.const [30] = Class [70] 
.const [31] = NameAndType [71] [72] 
.const [32] = Utf8 '[DsiMessagingMappings#mmsToSms] Mapped MessageListEntry instances from MMS to SMS, list of affected message IDs: %1' 
.const [33] = Class [73] 
.const [34] = NameAndType [74] [75] 
.const [35] = Utf8 '[DsiMessagingMappings#mmsToSms] Mapped MessageDetails instance from MMS to SMS, affected message ID: %1' 
.const [36] = Utf8 java/lang/Object 
.const [37] = Utf8 org/dsi/ifc/messaging/ListEntry 
.const [38] = Utf8 de/audi/app/messaging/core/util/ListEntries 
.const [39] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [40] = Utf8 de/audi/atip/log/LogChannel 
.const [41] = Utf8 de/audi/app/messaging/core/util/Collections 
.const [42] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [43] = Class [76] 
.const [44] = NameAndType [77] [78] 
.const [45] = Class [79] 
.const [46] = NameAndType [80] [81] 
.const [47] = Class [82] 
.const [48] = NameAndType [83] [84] 
.const [49] = Class [85] 
.const [50] = NameAndType [86] [87] 
.const [51] = Class [88] 
.const [52] = NameAndType [89] [90] 
.const [53] = Class [91] 
.const [54] = NameAndType [92] [93] 
.const [55] = Class [94] 
.const [56] = NameAndType [95] [96] 
.const [57] = Class [97] 
.const [58] = NameAndType [98] [99] 
.const [59] = Class [100] 
.const [60] = NameAndType [101] [102] 
.const [61] = Class [103] 
.const [62] = NameAndType [104] [105] 
.const [63] = Class [106] 
.const [64] = NameAndType [107] [108] 
.const [65] = Utf8 java/util/ArrayList 
.const [66] = Class [109] 
.const [67] = NameAndType [110] [111] 
.const [68] = Class [112] 
.const [69] = NameAndType [113] [114] 
.const [70] = Utf8 de/audi/app/messaging/core/util/ListEntries 
.const [71] = Utf8 isMessage 
.const [72] = Utf8 (Lorg/dsi/ifc/messaging/ListEntry;)Z 
.const [73] = Utf8 de/audi/app/messaging/core/util/Collections 
.const [74] = Utf8 toString 
.const [75] = Utf8 (Ljava/util/Collection;)Ljava/lang/String; 
.const [76] = Utf8 org/dsi/ifc/messaging/ListEntry 
.const [77] = Utf8 getMessageListEntry 
.const [78] = Utf8 ()Lorg/dsi/ifc/messaging/MessageListEntry; 
.const [79] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [80] = Utf8 getType 
.const [81] = Utf8 ()I 
.const [82] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [83] = Utf8 getMessageID 
.const [84] = Utf8 ()Ljava/lang/String; 
.const [85] = Utf8 java/util/ArrayList 
.const [86] = Utf8 add 
.const [87] = Utf8 (Ljava/lang/Object;)Z 
.const [88] = Utf8 de/audi/atip/log/LogChannel 
.const [89] = Utf8 isInfo 
.const [90] = Utf8 ()Z 
.const [91] = Utf8 java/util/ArrayList 
.const [92] = Utf8 isEmpty 
.const [93] = Utf8 ()Z 
.const [94] = Utf8 de/audi/atip/log/LogChannel 
.const [95] = Utf8 log 
.const [96] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [97] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [98] = Utf8 getType 
.const [99] = Utf8 ()I 
.const [100] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [101] = Utf8 getMessageID 
.const [102] = Utf8 ()Ljava/lang/String; 
.const [103] = Utf8 java/lang/Object 
.const [104] = Utf8 <init> 
.const [105] = Utf8 ()V 
.const [106] = Utf8 java/util/ArrayList 
.const [107] = Utf8 <init> 
.const [108] = Utf8 (I)V 
.const [109] = Utf8 org/dsi/ifc/messaging/MessageListEntry 
.const [110] = Utf8 type 
.const [111] = Utf8 I 
.const [112] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [113] = Utf8 type 
.const [114] = Utf8 I 
.const [115] = Utf8 de/audi/app/messaging/core/dsi/messaging/DsiMessagingMappings 
.const [116] = Class [115] 
.const [117] = Utf8 java/lang/Object 
.const [118] = Class [117] 
.const [119] = Utf8 Code 
.const [120] = Utf8 <init> 
.const [121] = Utf8 ()V 
.const [122] = Utf8 mmsToSms 
.const [123] = Utf8 (Lde/audi/atip/log/LogChannel;[Lorg/dsi/ifc/messaging/ListEntry;)[Lorg/dsi/ifc/messaging/ListEntry; 
.const [124] = Utf8 mmsToSms 
.const [125] = Utf8 (Lde/audi/atip/log/LogChannel;Lorg/dsi/ifc/messaging/MessageDetails;)Lorg/dsi/ifc/messaging/MessageDetails; 
.end class 
