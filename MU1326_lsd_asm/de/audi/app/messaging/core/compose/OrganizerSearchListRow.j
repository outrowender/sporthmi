.version 50 0 
.class public super [53] 
.super [55] 
.field protected [56] [57] 

.method protected [59] : [60] 
    .attribute [58] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [9] 
L5:     aload_0 
L6:     iload_2 
L7:     putfield [11] 
L10:    aload_0 
L11:    iconst_0 
L12:    aload_1 
L13:    iload_2 
L14:    invokestatic [2] 
L17:    ifeq L24 
L20:    iconst_1 
L21:    goto L25 
L24:    iconst_0 
L25:    invokevirtual [7] 
L28:    pop 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [61] : [62] 
    .attribute [58] .code stack 4 locals 0 
L0:     new [12] 
L3:     dup 
L4:     aload_0 
L5:     getfield [8] 
L8:     aload_0 
L9:     getfield [6] 
L12:    invokespecial [10] 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public static [63] : [64] 
    .attribute [58] .code stack 6 locals 2 
L0:     aload_0 
L1:     ifnonnull L6 
L4:     aconst_null 
L5:     areturn 
L6:     aload_0 
L7:     arraylength 
L8:     anewarray [3] 
L11:    astore_2 
L12:    iconst_0 
L13:    istore_3 
L14:    iload_3 
L15:    aload_0 
L16:    arraylength 
L17:    if_icmpge L40 
L20:    aload_2 
L21:    iload_3 
L22:    new [12] 
L25:    dup 
L26:    aload_0 
L27:    iload_3 
L28:    aaload 
L29:    iload_1 
L30:    invokespecial [10] 
L33:    aastore 
L34:    iinc 3 1 
L37:    goto L14 
L40:    aload_2 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [13] [14] 
.const [3] = Class [15] 
.const [4] = Class [16] 
.const [5] = Class [17] 
.const [6] = Field [18] [19] 
.const [7] = Method [20] [21] 
.const [8] = Field [22] [23] 
.const [9] = Method [24] [25] 
.const [10] = Method [26] [27] 
.const [11] = Field [28] [29] 
.const [12] = Class [30] 
.const [13] = Class [31] 
.const [14] = NameAndType [32] [33] 
.const [15] = Utf8 de/audi/app/messaging/core/compose/OrganizerSearchListRow 
.const [16] = Utf8 de/audi/app/addressbook/core/common/search/organizer/ADBOrganizerSearchListRow 
.const [17] = Utf8 de/audi/app/addressbook/core/common/ADBUtils 
.const [18] = Class [34] 
.const [19] = NameAndType [35] [36] 
.const [20] = Class [37] 
.const [21] = NameAndType [38] [39] 
.const [22] = Class [40] 
.const [23] = NameAndType [41] [42] 
.const [24] = Class [43] 
.const [25] = NameAndType [44] [45] 
.const [26] = Class [46] 
.const [27] = NameAndType [47] [48] 
.const [28] = Class [49] 
.const [29] = NameAndType [50] [51] 
.const [30] = Utf8 de/audi/app/messaging/core/compose/OrganizerSearchListRow 
.const [31] = Utf8 de/audi/app/addressbook/core/common/ADBUtils 
.const [32] = Utf8 hasRelevantData 
.const [33] = Utf8 (Lorg/dsi/ifc/organizer/DataSet;I)Z 
.const [34] = Utf8 de/audi/app/messaging/core/compose/OrganizerSearchListRow 
.const [35] = Utf8 adbMode 
.const [36] = Utf8 I 
.const [37] = Utf8 de/audi/app/messaging/core/compose/OrganizerSearchListRow 
.const [38] = Utf8 setInteger 
.const [39] = Utf8 (II)Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [40] = Utf8 de/audi/app/messaging/core/compose/OrganizerSearchListRow 
.const [41] = Utf8 dataSet 
.const [42] = Utf8 Lorg/dsi/ifc/organizer/DataSet; 
.const [43] = Utf8 de/audi/app/addressbook/core/common/search/organizer/ADBOrganizerSearchListRow 
.const [44] = Utf8 <init> 
.const [45] = Utf8 (Lorg/dsi/ifc/organizer/DataSet;)V 
.const [46] = Utf8 de/audi/app/messaging/core/compose/OrganizerSearchListRow 
.const [47] = Utf8 <init> 
.const [48] = Utf8 (Lorg/dsi/ifc/organizer/DataSet;I)V 
.const [49] = Utf8 de/audi/app/messaging/core/compose/OrganizerSearchListRow 
.const [50] = Utf8 adbMode 
.const [51] = Utf8 I 
.const [52] = Utf8 de/audi/app/messaging/core/compose/OrganizerSearchListRow 
.const [53] = Class [52] 
.const [54] = Utf8 de/audi/app/addressbook/core/common/search/organizer/ADBOrganizerSearchListRow 
.const [55] = Class [54] 
.const [56] = Utf8 adbMode 
.const [57] = Utf8 I 
.const [58] = Utf8 Code 
.const [59] = Utf8 <init> 
.const [60] = Utf8 (Lorg/dsi/ifc/organizer/DataSet;I)V 
.const [61] = Utf8 copy 
.const [62] = Utf8 ()Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [63] = Utf8 createFromDataSets 
.const [64] = Utf8 ([Lorg/dsi/ifc/organizer/DataSet;I)[Lde/audi/app/messaging/core/compose/OrganizerSearchListRow; 
.end class 
