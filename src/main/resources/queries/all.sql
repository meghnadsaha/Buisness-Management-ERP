--drop TABLE users  
 CREATE TABLE users  
 ( user_id VARCHAR(100) NOT  NULL,
 password VARCHAR2(100) NOT NULL,
 roles VARCHAR2 (100) NOT NULL,
 CONSTRAINT user_id_pk PRIMARY KEY (user_id) 
 );
 

 CREATE TABLE VECHILE_MAINTENANCE_COST (
 product_id VARCHAR2(100) NOT NULL,
 product_name VARCHAR2(100) NOT NULL,
 product_cost VARCHAR2 (100) NOT NULL,
 duration_bugibllity VARCHAR2 (100) NOT NULL,
 maintaince_venue VARCHAR2 (100) NOT NULL,
 jcb_mechanics_contact_details VARCHAR2 (100) NOT NULL     
 );
 
 --How to add primary key on existing table 
 --Next we need to add a PRIMARY KEY constraint:

 ALTER TABLE VECHILE_MAINTENANCE_COST 
                     
  ADD (
    CONSTRAINT product_id_pk PRIMARY KEY (product_id)
  );
  
--Finally, we’ll create our SEQUENCE that will be utilized later to actually generate the unique, auto incremented value.
CREATE SEQUENCE vMaintaince_sequence;
SELECT * FROM VECHILE_MAINTENANCE_COST;

 

 CREATE TABLE JCB_ENGINE_PARTS_CATALOGUE (
 product_id VARCHAR2(100) NOT NULL,
product_name VARCHAR2 (100) NOT NULL,
 number_of_product_quantity VARCHAR2(100) NOT NULL,
 number_of_runing_hours VARCHAR2 (100) NOT NULL,
location_name  VARCHAR2 (100) NOT NULL,
CONSTRAINT jcb_product_id_pk PRIMARY KEY (product_id)
 );



CREATE TABLE heavy_weight_vechile_client (
 sNo VARCHAR2(100) NOT NULL,
 client_id VARCHAR2(100) NOT NULL,
 client_name VARCHAR2 (100) NOT NULL,
 client_details VARCHAR2(100) NOT NULL,
 client_address VARCHAR2 (100) NOT NULL,
 purchased_product_id  VARCHAR2 (100) NOT NULL,
CONSTRAINT sno_pk PRIMARY KEY (sNo),
CONSTRAINT FK_purchased_product_id FORE IGN KEY (purchased_product_id)
    REFERENCES JCB_ENGINE_PARTS_CATALOGUE(product_id)
 );
 
 

CREATE TABLE TRANSACTION_HISTORY (
 serial_no VARCHAR2(100) NOT NULL,
 client_id VARCHAR2(100) NOT NULL,
 transaction_method VARCHAR2 (100) NOT NULL,
 paid_amount VARCHAR2(100) NOT NULL,
 due_amount VARCHAR2 (100) NOT NULL,
 total_amount  VARCHAR2 (100) NOT NULL,
  payment_date  VARCHAR2 (100) NOT NULL,
product_id  VARCHAR2 (100) NOT NULL,
CONSTRAINT serial_no_pk PRIMARY KEY (serial_no),

CONSTRAINT FK_product_id FOREIGN KEY (product_id)
    REFERENCES JCB_ENGINE_PARTS_CATALOGUE(product_id)
 --   CONSTRAINT FK_client_id FOREIGN KEY (client_id)
  --REFERENCES heavy_weight_vechile_client(client_id)
 );
 

CREATE TABLE EMPLOYEE_INVENTORY_DETAILS (
 sr_number VARCHAR2(100) NOT NULL,
 driver_no VARCHAR2(100) NOT NULL,
 salary VARCHAR2(100) NOT NULL,
 date_of_joining VARCHAR2 (100) NOT NULL,
 date_of_salary_initiation VARCHAR2(100) NOT NULL,
 food_expenses VARCHAR2 (100) NOT NULL,
 yearly_bonus  VARCHAR2 (100) NOT NULL,
CONSTRAINT sr_number_pk PRIMARY KEY (sr_number)
 );
 


