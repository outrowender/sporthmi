.version 50 0 
.class public super [65] 
.super [67] 

.method protected [69] : [70] 
    .attribute [68] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [11] 
L5:     aload_0 
L6:     bipush 6 
L8:     iload_2 
L9:     ifeq L16 
L12:    iconst_1 
L13:    goto L17 
L16:    iconst_0 
L17:    invokevirtual [7] 
L20:    pop 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [71] : [72] 
    .attribute [68] .code stack 5 locals 0 
L0:     new [14] 
L3:     dup 
L4:     aload_0 
L5:     getfield [8] 
L8:     aload_0 
L9:     bipush 6 
L11:    invokevirtual [9] 
L14:    iconst_1 
L15:    if_icmpne L22 
L18:    iconst_1 
L19:    goto L23 
L22:    iconst_0 
L23:    invokespecial [12] 
L26:    areturn 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [73] : [74] 
    .attribute [68] .code stack 4 locals 0 
L0:     aload_0 
L1:     bipush 6 
L3:     aload_0 
L4:     bipush 6 
L6:     invokevirtual [9] 
L9:     ifne L16 
L12:    iconst_1 
L13:    goto L17 
L16:    iconst_0 
L17:    invokevirtual [7] 
L20:    pop 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public static [75] : [76] 
    .attribute [68] .code stack 6 locals 3 
L0:     aload_0 
L1:     ifnonnull L6 
L4:     aconst_null 
L5:     areturn 
L6:     aload_0 
L7:     arraylength 
L8:     anewarray [2] 
L11:    astore_3 
L12:    iconst_0 
L13:    istore 4 
L15:    iload 4 
L17:    aload_0 
L18:    arraylength 
L19:    if_icmpge L76 
L22:    iload_1 
L23:    aload_2 
L24:    new [15] 
L27:    dup 
L28:    aload_0 
L29:    iload 4 
L31:    aaload 
L32:    invokevirtual [10] 
L35:    invokespecial [13] 
L38:    invokeinterface [16] 0 
L43:    if_icmpne L50 
L46:    iconst_1 
L47:    goto L51 
L50:    iconst_0 
L51:    istore 5 
L53:    aload_3 
L54:    iload 4 
L56:    new [14] 
L59:    dup 
L60:    aload_0 
L61:    iload 4 
L63:    aaload 
L64:    iload 5 
L66:    invokespecial [12] 
L69:    aastore 
L70:    iinc 4 1 
L73:    goto L15 
L76:    aload_3 
L77:    areturn 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [17] 
.const [3] = Class [18] 
.const [4] = Class [19] 
.const [5] = Class [20] 
.const [6] = Class [21] 
.const [7] = Method [22] [23] 
.const [8] = Field [24] [25] 
.const [9] = Method [26] [27] 
.const [10] = Method [28] [29] 
.const [11] = Method [30] [31] 
.const [12] = Method [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Class [36] 
.const [15] = Class [37] 
.const [16] = InterfaceMethod [38] [39] 
.const [17] = Utf8 de/audi/app/addressbook/core/vcardexchange/search/organizer/VCardExchangeOrganizerSearchListRow 
.const [18] = Utf8 java/lang/Long 
.const [19] = Utf8 de/audi/app/addressbook/core/common/search/organizer/ADBOrganizerSearchListRow 
.const [20] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [21] = Utf8 java/util/Set 
.const [22] = Class [40] 
.const [23] = NameAndType [41] [42] 
.const [24] = Class [43] 
.const [25] = NameAndType [44] [45] 
.const [26] = Class [46] 
.const [27] = NameAndType [47] [48] 
.const [28] = Class [49] 
.const [29] = NameAndType [50] [51] 
.const [30] = Class [52] 
.const [31] = NameAndType [53] [54] 
.const [32] = Class [55] 
.const [33] = NameAndType [56] [57] 
.const [34] = Class [58] 
.const [35] = NameAndType [59] [60] 
.const [36] = Utf8 de/audi/app/addressbook/core/vcardexchange/search/organizer/VCardExchangeOrganizerSearchListRow 
.const [37] = Utf8 java/lang/Long 
.const [38] = Class [61] 
.const [39] = NameAndType [62] [63] 
.const [40] = Utf8 de/audi/app/addressbook/core/vcardexchange/search/organizer/VCardExchangeOrganizerSearchListRow 
.const [41] = Utf8 setInteger 
.const [42] = Utf8 (II)Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [43] = Utf8 de/audi/app/addressbook/core/vcardexchange/search/organizer/VCardExchangeOrganizerSearchListRow 
.const [44] = Utf8 dataSet 
.const [45] = Utf8 Lorg/dsi/ifc/organizer/DataSet; 
.const [46] = Utf8 de/audi/app/addressbook/core/vcardexchange/search/organizer/VCardExchangeOrganizerSearchListRow 
.const [47] = Utf8 getInteger 
.const [48] = Utf8 (I)I 
.const [49] = Utf8 org/dsi/ifc/organizer/DataSet 
.const [50] = Utf8 getEntryId 
.const [51] = Utf8 ()J 
.const [52] = Utf8 de/audi/app/addressbook/core/common/search/organizer/ADBOrganizerSearchListRow 
.const [53] = Utf8 <init> 
.const [54] = Utf8 (Lorg/dsi/ifc/organizer/DataSet;)V 
.const [55] = Utf8 de/audi/app/addressbook/core/vcardexchange/search/organizer/VCardExchangeOrganizerSearchListRow 
.const [56] = Utf8 <init> 
.const [57] = Utf8 (Lorg/dsi/ifc/organizer/DataSet;Z)V 
.const [58] = Utf8 java/lang/Long 
.const [59] = Utf8 <init> 
.const [60] = Utf8 (J)V 
.const [61] = Utf8 java/util/Set 
.const [62] = Utf8 contains 
.const [63] = Utf8 (Ljava/lang/Object;)Z 
.const [64] = Utf8 de/audi/app/addressbook/core/vcardexchange/search/organizer/VCardExchangeOrganizerSearchListRow 
.const [65] = Class [64] 
.const [66] = Utf8 de/audi/app/addressbook/core/common/search/organizer/ADBOrganizerSearchListRow 
.const [67] = Class [66] 
.const [68] = Utf8 Code 
.const [69] = Utf8 <init> 
.const [70] = Utf8 (Lorg/dsi/ifc/organizer/DataSet;Z)V 
.const [71] = Utf8 copy 
.const [72] = Utf8 ()Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [73] = Utf8 toggleCheckBox 
.const [74] = Utf8 ()V 
.const [75] = Utf8 createFromDataSets 
.const [76] = Utf8 ([Lorg/dsi/ifc/organizer/DataSet;ZLjava/util/Set;)[Lde/audi/app/addressbook/core/vcardexchange/search/organizer/VCardExchangeOrganizerSearchListRow; 
.end class 
