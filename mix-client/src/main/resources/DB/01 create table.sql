drop table if exists pro_data;
create table pro_data
(
  id         int not null,
  area_id    int,
  data_dt    varchar(20),
  data_value numeric,
  constraint pk_pro_data primary key (id, area_id, data_dt)
);

drop table if exists pro_data_type;
create table pro_data_type
(
  id         int not null,
  name       varchar(100),
  p_id       int null,
  p_name     varchar(100),
  show_order integer,
  constraint pk_adm_sys_param primary key (id)
);

INSERT INTO public.pro_data_type (id, name,p_id,p_name, show_order) VALUES (687, '+12白银装备增幅券',1,'增幅券', 1);
INSERT INTO public.pro_data_type (id, name,p_id,p_name, show_order) VALUES (690, '+12翡翠装备增幅券',1,'增幅券', 1);
INSERT INTO public.pro_data_type (id, name,p_id,p_name, show_order) VALUES (691, '+12钻石装备增幅券',1,'增幅券', 1);
INSERT INTO public.pro_data_type (id, name,p_id,p_name, show_order) VALUES (689, '+12铂金装备增幅券',1,'增幅券', 1);
INSERT INTO public.pro_data_type (id, name,p_id,p_name, show_order) VALUES (686, '+12青铜装备增幅券',1,'增幅券', 1);
INSERT INTO public.pro_data_type (id, name,p_id,p_name, show_order) VALUES (688, '+12黄金装备增幅券',1,'增幅券', 1);
INSERT INTO public.pro_data_type (id, name,p_id,p_name, show_order) VALUES (685, '+12黑铁装备增幅券',1,'增幅券', 1);
INSERT INTO public.pro_data_type (id, name,p_id,p_name, show_order) VALUES (672, '+7翡翠装备增幅券',1,'增幅券', 1);
INSERT INTO public.pro_data_type (id, name,p_id,p_name, show_order) VALUES (673, '+7钻石装备增幅券',1,'增幅券', 1);
INSERT INTO public.pro_data_type (id, name,p_id,p_name, show_order) VALUES (671, '+7铂金装备增幅券',1,'增幅券', 1);
INSERT INTO public.pro_data_type (id, name,p_id,p_name, show_order) VALUES (670, '+7黄金装备增幅券',1,'增幅券', 1);
INSERT INTO public.pro_data_type (id, name,p_id,p_name, show_order) VALUES (927, '光之偶像荷鲁斯 卡片',2,'卡片', 1);
INSERT INTO public.pro_data_type (id, name,p_id,p_name, show_order) VALUES (757, '安徒恩的心脏 卡片',2,'卡片', 1);
INSERT INTO public.pro_data_type (id, name,p_id,p_name, show_order) VALUES (913, '格拉古尔 卡片',2,'卡片', 1);
INSERT INTO public.pro_data_type (id, name,p_id,p_name, show_order) VALUES (925, '第七之米斯特尔 卡片',2,'卡片', 1);
INSERT INTO public.pro_data_type (id, name,p_id,p_name, show_order) VALUES (755, '黑烟之克雷斯 卡片',2,'卡片', 1);
INSERT INTO public.pro_data_type (id, name,p_id,p_name, show_order) VALUES (725, '魂:牛头械王卡片',2,'卡片', 1);
INSERT INTO public.pro_data_type (id, name, show_order) VALUES (1281, '变异的扭转书', 1);
INSERT INTO public.pro_data_type (id, name, show_order) VALUES (1416, '天命英雄宝物礼盒', 1);
INSERT INTO public.pro_data_type (id, name, show_order) VALUES (1415, '天命英雄特别宝物礼盒', 1);
INSERT INTO public.pro_data_type (id, name, show_order) VALUES (1414, '天命英雄特别称号礼盒', 1);
INSERT INTO public.pro_data_type (id, name, show_order) VALUES (716, '异界气息净化书', 1);
INSERT INTO public.pro_data_type (id, name, show_order) VALUES (698, '强烈之痕迹', 1);
INSERT INTO public.pro_data_type (id, name, show_order) VALUES (694, '数据芯片', 1);
INSERT INTO public.pro_data_type (id, name, show_order) VALUES (692, '无尽的永恒', 1);
INSERT INTO public.pro_data_type (id, name, show_order) VALUES (699, '无色小晶块', 1);
INSERT INTO public.pro_data_type (id, name, show_order) VALUES (1213, '次元光辉', 1);
INSERT INTO public.pro_data_type (id, name, show_order) VALUES (696, '浓缩的异界精髓', 1);
INSERT INTO public.pro_data_type (id, name, show_order) VALUES (697, '浓缩的纯洁之骸', 1);
INSERT INTO public.pro_data_type (id, name, show_order) VALUES (646, '深渊派对挑战书', 1);
INSERT INTO public.pro_data_type (id, name, show_order) VALUES (695, '矛盾的结晶体', 1);
INSERT INTO public.pro_data_type (id, name, show_order) VALUES (647, '装备强化保护券', 1);
INSERT INTO public.pro_data_type (id, name, show_order) VALUES (1185, '诞生之芽', 1);
INSERT INTO public.pro_data_type (id, name, show_order) VALUES (704, '金色小晶块', 1);
INSERT INTO public.pro_data_type (id, name, show_order) VALUES (693, '魔刹石', 1);
INSERT INTO public.pro_data_type (id, name, show_order) VALUES (1184, '黑曜石', 1);



drop table if exists pro_area;
create table pro_area
(
  area_id    int not null,
  name       varchar(100),
  show_order integer,
  constraint pk_pro_area primary key (area_id)
);

insert into pro_area
values ('35', '新跨区1区'),
       ('36', '新跨区2区'),
       ('37', '新跨区3A区'),
       ('38', '新跨区3B区'),
       ('39', '新跨区4区'),
       ('40', '新跨区5区'),
       ('41', '新跨区6区'),
       ('42', '新跨区7区'),
       ('43', '新跨区8区');