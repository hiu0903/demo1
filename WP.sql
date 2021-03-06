PGDMP     *    %                y            WP    13.4    13.4 A               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16987    WP    DATABASE     e   CREATE DATABASE "WP" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Vietnamese_Vietnam.1258';
    DROP DATABASE "WP";
                postgres    false            ?            1259    16988    Booking    TABLE     ?   CREATE TABLE public."Booking" (
    "ID" integer NOT NULL,
    "ServID" integer NOT NULL,
    "Describe" character varying,
    "StartAt" timestamp without time zone NOT NULL
);
    DROP TABLE public."Booking";
       public         heap    postgres    false            ?            1259    16994    Booking_ID_seq    SEQUENCE     ?   CREATE SEQUENCE public."Booking_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public."Booking_ID_seq";
       public          postgres    false    200                       0    0    Booking_ID_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public."Booking_ID_seq" OWNED BY public."Booking"."ID";
          public          postgres    false    201            ?            1259    16996 
   Categories    TABLE     l   CREATE TABLE public."Categories" (
    "ID" integer NOT NULL,
    "Name" character varying(150) NOT NULL
);
     DROP TABLE public."Categories";
       public         heap    postgres    false            ?            1259    16999    Categories_ID_seq    SEQUENCE     ?   CREATE SEQUENCE public."Categories_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public."Categories_ID_seq";
       public          postgres    false    202                       0    0    Categories_ID_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public."Categories_ID_seq" OWNED BY public."Categories"."ID";
          public          postgres    false    203            ?            1259    17001 	   OrdDetail    TABLE     ?   CREATE TABLE public."OrdDetail" (
    "ID" integer NOT NULL,
    "OrdID" integer NOT NULL,
    "ProID" integer NOT NULL,
    "Price" money NOT NULL,
    "Quantity" integer NOT NULL
);
    DROP TABLE public."OrdDetail";
       public         heap    postgres    false            ?            1259    17004    OrdDetail_ID_seq    SEQUENCE     ?   CREATE SEQUENCE public."OrdDetail_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public."OrdDetail_ID_seq";
       public          postgres    false    204            	           0    0    OrdDetail_ID_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public."OrdDetail_ID_seq" OWNED BY public."OrdDetail"."ID";
          public          postgres    false    205            ?            1259    17006    Order    TABLE     ?   CREATE TABLE public."Order" (
    "ID" integer NOT NULL,
    "UID" integer NOT NULL,
    "Address" character varying,
    "Created" timestamp without time zone NOT NULL,
    "Updated" timestamp without time zone NOT NULL
);
    DROP TABLE public."Order";
       public         heap    postgres    false            ?            1259    17012    Order_ID_seq    SEQUENCE     ?   CREATE SEQUENCE public."Order_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public."Order_ID_seq";
       public          postgres    false    206            
           0    0    Order_ID_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public."Order_ID_seq" OWNED BY public."Order"."ID";
          public          postgres    false    207            ?            1259    17014    pet    TABLE     c  CREATE TABLE public.pet (
    petid integer NOT NULL,
    uid integer NOT NULL,
    name character varying(255) NOT NULL,
    birth date NOT NULL,
    breed character varying(100),
    kind character varying(100) NOT NULL,
    added timestamp without time zone NOT NULL,
    updated timestamp without time zone NOT NULL,
    img character varying(255)
);
    DROP TABLE public.pet;
       public         heap    postgres    false            ?            1259    17020    Pet_PetID_seq    SEQUENCE     ?   CREATE SEQUENCE public."Pet_PetID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public."Pet_PetID_seq";
       public          postgres    false    208                       0    0    Pet_PetID_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public."Pet_PetID_seq" OWNED BY public.pet.petid;
          public          postgres    false    209            ?            1259    17022    Product    TABLE     ?  CREATE TABLE public."Product" (
    "ID" integer NOT NULL,
    "CatID" integer NOT NULL,
    "Name" character varying(255) NOT NULL,
    "Brand" character varying(200) NOT NULL,
    "Description" character varying NOT NULL,
    "Price" money NOT NULL,
    "Discount" integer,
    "Unit" character varying(100) NOT NULL,
    "Available" boolean NOT NULL,
    "Created" timestamp without time zone NOT NULL,
    "Updated" timestamp without time zone NOT NULL,
    "IMG" character varying[] NOT NULL
);
    DROP TABLE public."Product";
       public         heap    postgres    false            ?            1259    17028    Product_ID_seq    SEQUENCE     ?   CREATE SEQUENCE public."Product_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public."Product_ID_seq";
       public          postgres    false    210                       0    0    Product_ID_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public."Product_ID_seq" OWNED BY public."Product"."ID";
          public          postgres    false    211            ?            1259    17030    Services    TABLE     ?   CREATE TABLE public."Services" (
    "ID" integer NOT NULL,
    "Name" character varying NOT NULL,
    "Price" money NOT NULL,
    "Unit" character varying NOT NULL,
    "Piority" integer NOT NULL,
    "Description" character varying NOT NULL
);
    DROP TABLE public."Services";
       public         heap    postgres    false            ?            1259    17036    Services_ID_seq    SEQUENCE     ?   CREATE SEQUENCE public."Services_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public."Services_ID_seq";
       public          postgres    false    212                       0    0    Services_ID_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public."Services_ID_seq" OWNED BY public."Services"."ID";
          public          postgres    false    213            ?            1259    17038    user    TABLE       CREATE TABLE public."user" (
    updated timestamp without time zone NOT NULL,
    sex boolean NOT NULL,
    phone character varying NOT NULL,
    name character varying NOT NULL,
    img character varying,
    created timestamp without time zone NOT NULL,
    address character varying NOT NULL,
    password character varying NOT NULL,
    id integer NOT NULL,
    role boolean
);
    DROP TABLE public."user";
       public         heap    postgres    false            ?            1259    17044    user_ID_seq    SEQUENCE     ?   CREATE SEQUENCE public."user_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public."user_ID_seq";
       public          postgres    false    214                       0    0    user_ID_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public."user_ID_seq" OWNED BY public."user".id;
          public          postgres    false    215            R           2604    17046 
   Booking ID    DEFAULT     n   ALTER TABLE ONLY public."Booking" ALTER COLUMN "ID" SET DEFAULT nextval('public."Booking_ID_seq"'::regclass);
 =   ALTER TABLE public."Booking" ALTER COLUMN "ID" DROP DEFAULT;
       public          postgres    false    201    200            S           2604    17047    Categories ID    DEFAULT     t   ALTER TABLE ONLY public."Categories" ALTER COLUMN "ID" SET DEFAULT nextval('public."Categories_ID_seq"'::regclass);
 @   ALTER TABLE public."Categories" ALTER COLUMN "ID" DROP DEFAULT;
       public          postgres    false    203    202            T           2604    17048    OrdDetail ID    DEFAULT     r   ALTER TABLE ONLY public."OrdDetail" ALTER COLUMN "ID" SET DEFAULT nextval('public."OrdDetail_ID_seq"'::regclass);
 ?   ALTER TABLE public."OrdDetail" ALTER COLUMN "ID" DROP DEFAULT;
       public          postgres    false    205    204            U           2604    17049    Order ID    DEFAULT     j   ALTER TABLE ONLY public."Order" ALTER COLUMN "ID" SET DEFAULT nextval('public."Order_ID_seq"'::regclass);
 ;   ALTER TABLE public."Order" ALTER COLUMN "ID" DROP DEFAULT;
       public          postgres    false    207    206            W           2604    17051 
   Product ID    DEFAULT     n   ALTER TABLE ONLY public."Product" ALTER COLUMN "ID" SET DEFAULT nextval('public."Product_ID_seq"'::regclass);
 =   ALTER TABLE public."Product" ALTER COLUMN "ID" DROP DEFAULT;
       public          postgres    false    211    210            X           2604    17052    Services ID    DEFAULT     p   ALTER TABLE ONLY public."Services" ALTER COLUMN "ID" SET DEFAULT nextval('public."Services_ID_seq"'::regclass);
 >   ALTER TABLE public."Services" ALTER COLUMN "ID" DROP DEFAULT;
       public          postgres    false    213    212            V           2604    17050 	   pet petid    DEFAULT     h   ALTER TABLE ONLY public.pet ALTER COLUMN petid SET DEFAULT nextval('public."Pet_PetID_seq"'::regclass);
 8   ALTER TABLE public.pet ALTER COLUMN petid DROP DEFAULT;
       public          postgres    false    209    208            Y           2604    17053    user id    DEFAULT     f   ALTER TABLE ONLY public."user" ALTER COLUMN id SET DEFAULT nextval('public."user_ID_seq"'::regclass);
 8   ALTER TABLE public."user" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    214            ?          0    16988    Booking 
   TABLE DATA           J   COPY public."Booking" ("ID", "ServID", "Describe", "StartAt") FROM stdin;
    public          postgres    false    200   J       ?          0    16996 
   Categories 
   TABLE DATA           4   COPY public."Categories" ("ID", "Name") FROM stdin;
    public          postgres    false    202   #J       ?          0    17001 	   OrdDetail 
   TABLE DATA           R   COPY public."OrdDetail" ("ID", "OrdID", "ProID", "Price", "Quantity") FROM stdin;
    public          postgres    false    204   @J       ?          0    17006    Order 
   TABLE DATA           O   COPY public."Order" ("ID", "UID", "Address", "Created", "Updated") FROM stdin;
    public          postgres    false    206   ]J       ?          0    17022    Product 
   TABLE DATA           ?   COPY public."Product" ("ID", "CatID", "Name", "Brand", "Description", "Price", "Discount", "Unit", "Available", "Created", "Updated", "IMG") FROM stdin;
    public          postgres    false    210   zJ       ?          0    17030    Services 
   TABLE DATA           ]   COPY public."Services" ("ID", "Name", "Price", "Unit", "Piority", "Description") FROM stdin;
    public          postgres    false    212   ?J       ?          0    17014    pet 
   TABLE DATA           X   COPY public.pet (petid, uid, name, birth, breed, kind, added, updated, img) FROM stdin;
    public          postgres    false    208   ?J       ?          0    17038    user 
   TABLE DATA           f   COPY public."user" (updated, sex, phone, name, img, created, address, password, id, role) FROM stdin;
    public          postgres    false    214   K                  0    0    Booking_ID_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public."Booking_ID_seq"', 1, false);
          public          postgres    false    201                       0    0    Categories_ID_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public."Categories_ID_seq"', 1, false);
          public          postgres    false    203                       0    0    OrdDetail_ID_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public."OrdDetail_ID_seq"', 1, false);
          public          postgres    false    205                       0    0    Order_ID_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public."Order_ID_seq"', 1, false);
          public          postgres    false    207                       0    0    Pet_PetID_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public."Pet_PetID_seq"', 52, true);
          public          postgres    false    209                       0    0    Product_ID_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public."Product_ID_seq"', 1, false);
          public          postgres    false    211                       0    0    Services_ID_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public."Services_ID_seq"', 1, false);
          public          postgres    false    213                       0    0    user_ID_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public."user_ID_seq"', 1, true);
          public          postgres    false    215            [           2606    17055    Booking Booking_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public."Booking"
    ADD CONSTRAINT "Booking_pkey" PRIMARY KEY ("ID");
 B   ALTER TABLE ONLY public."Booking" DROP CONSTRAINT "Booking_pkey";
       public            postgres    false    200            ]           2606    17057    Categories Categories_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public."Categories"
    ADD CONSTRAINT "Categories_pkey" PRIMARY KEY ("ID");
 H   ALTER TABLE ONLY public."Categories" DROP CONSTRAINT "Categories_pkey";
       public            postgres    false    202            _           2606    17059    OrdDetail OrdDetail_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public."OrdDetail"
    ADD CONSTRAINT "OrdDetail_pkey" PRIMARY KEY ("ID");
 F   ALTER TABLE ONLY public."OrdDetail" DROP CONSTRAINT "OrdDetail_pkey";
       public            postgres    false    204            a           2606    17061    Order Order_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public."Order"
    ADD CONSTRAINT "Order_pkey" PRIMARY KEY ("ID");
 >   ALTER TABLE ONLY public."Order" DROP CONSTRAINT "Order_pkey";
       public            postgres    false    206            c           2606    17063    pet Pet_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY public.pet
    ADD CONSTRAINT "Pet_pkey" PRIMARY KEY (petid);
 8   ALTER TABLE ONLY public.pet DROP CONSTRAINT "Pet_pkey";
       public            postgres    false    208            e           2606    17065    Product Product_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public."Product"
    ADD CONSTRAINT "Product_pkey" PRIMARY KEY ("ID");
 B   ALTER TABLE ONLY public."Product" DROP CONSTRAINT "Product_pkey";
       public            postgres    false    210            g           2606    17067    Services Services_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public."Services"
    ADD CONSTRAINT "Services_pkey" PRIMARY KEY ("ID");
 D   ALTER TABLE ONLY public."Services" DROP CONSTRAINT "Services_pkey";
       public            postgres    false    212            i           2606    17069    user user_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public."user" DROP CONSTRAINT user_pkey;
       public            postgres    false    214            j           2606    17070    Booking FK_Booking_Serv    FK CONSTRAINT     ?   ALTER TABLE ONLY public."Booking"
    ADD CONSTRAINT "FK_Booking_Serv" FOREIGN KEY ("ServID") REFERENCES public."Services"("ID") ON DELETE CASCADE;
 E   ALTER TABLE ONLY public."Booking" DROP CONSTRAINT "FK_Booking_Serv";
       public          postgres    false    2919    212    200            n           2606    17075    Product FK_Cat_Pro    FK CONSTRAINT     ?   ALTER TABLE ONLY public."Product"
    ADD CONSTRAINT "FK_Cat_Pro" FOREIGN KEY ("CatID") REFERENCES public."Categories"("ID") ON DELETE CASCADE;
 @   ALTER TABLE ONLY public."Product" DROP CONSTRAINT "FK_Cat_Pro";
       public          postgres    false    210    2909    202            k           2606    17080    OrdDetail FK_Detail_Ord    FK CONSTRAINT     ?   ALTER TABLE ONLY public."OrdDetail"
    ADD CONSTRAINT "FK_Detail_Ord" FOREIGN KEY ("OrdID") REFERENCES public."Order"("ID") ON DELETE CASCADE;
 E   ALTER TABLE ONLY public."OrdDetail" DROP CONSTRAINT "FK_Detail_Ord";
       public          postgres    false    2913    204    206            l           2606    17085    Order FK_Ord_User    FK CONSTRAINT     s   ALTER TABLE ONLY public."Order"
    ADD CONSTRAINT "FK_Ord_User" FOREIGN KEY ("UID") REFERENCES public."user"(id);
 ?   ALTER TABLE ONLY public."Order" DROP CONSTRAINT "FK_Ord_User";
       public          postgres    false    214    2921    206            m           2606    17090    pet FK_Pet_User    FK CONSTRAINT        ALTER TABLE ONLY public.pet
    ADD CONSTRAINT "FK_Pet_User" FOREIGN KEY (uid) REFERENCES public."user"(id) ON DELETE CASCADE;
 ;   ALTER TABLE ONLY public.pet DROP CONSTRAINT "FK_Pet_User";
       public          postgres    false    214    2921    208            ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?   =   x?3??4??)?4202?50"?Ĥd???$??o?kh?`hhebje`?gij?S?+F??? ? ?      ?   ?   x?3202?5?"CK+Ss+SS=3s?NKsssc#CΌ????DNN#???9U?UTܽR??r?s=B+<?r2}?JCS??M?K#J?+???s??̊?CK"|+S?S
99K?b???? ??%E     