CMS  表设计

1、新闻内容表  t_cms_content

id title summary click_num content order_flag create_date update_date from from_url site_id

create table t_cms_content(
  id int(4) primary key ,
  title varchar(60),
  summary varchar(100),
  click_num int(4),
  content longtext,
  order_flag int(4),
  create_date datetime,
  update_date datetime,
  fromname  varchar(60),
  from_url varchar(100),
  site_id  int(4)

);


2、 网站栏目表 t_cms_column 

id column_name parent_id site_id  order_flag create_date


create table t_cms_column(
  id int(4) primary key ,
  column_name varchar(60),
  order_flag int(4),
  parent_id int(4),
  create_date datetime,
  site_id int(4)

);


3、站点表  t_cms_site

id site_name domain  create_date site_desc keywords

create table t_cms_site(
  id int(4) primary key ,
  site_name varchar(60),
  domain varchar(100),
  create_date datetime,
keywords varchar(300),
site_desc varchar(1000)
);

4、站点logo表 t_cms_sitelogo

site_id logo_name logo_path tag_path

create table t_cms_sitelogo(
  site_id int(4),
  logo_name varchar(60),
  tag_path varchar(100),
logo_path varchar(100)
);



5、站点水印表 t_cms_sitemark

site_id  mark_type mark_position mark_word  mark_picture

create table t_cms_sitemark(
  site_id int(4),
  mark_type tinyint(1),
  mark_position tinyint(1),
mark_word  varchar(30),
mark_picture varchar(100)
);


6、新闻内容扩展字段 t_cms_contentattr
content_id line_values

create table t_cms_contentattr(
  content_id int(4),
  line_values varchar(5000)
);

7、字段模型表  t_cms_module
id module_name 

create table t_cms_module(
  id int(4),
  module_name varchar(60)
);

8、模型字段   t_cms_moduleitem

id module_id item_name item_type 

create table t_cms_moduleitem(
  id int(4),
 module_id int(4),
  item_name  varchar(60),
item_type  tinyint(1)
);

8、新闻附件表 t_cms_contentfile

id content_id file_path file_name 


create table t_cms_contentfile(
  id int(4),
 content_id int(4),
  file_name varchar(60),
file_path varchar(100)
);
 