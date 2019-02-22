/*
 Navicat Premium Data Transfer

 Source Server         : 10.10.103.61
 Source Server Type    : Oracle
 Source Server Version : 110200
 Source Host           : 10.10.103.61:33008
 Source Schema         : PATIENT

 Target Server Type    : Oracle
 Target Server Version : 110200
 File Encoding         : 65001

 Date: 21/02/2019 19:43:07
*/


-- ----------------------------
-- Table structure for contact_person
-- ----------------------------
create user PATIENT identified by PATIENT
ALTER USER PATIENT quota unlimited on SYSTEM

DROP TABLE "PATIENT"."contact_person";
CREATE TABLE "PATIENT"."contact_person" (
  "contact_person_id" NUMBER NOT NULL ,
  "patient_id" NUMBER ,
  "relationship" VARCHAR2(255 BYTE) ,
  "english_name" VARCHAR2(255 BYTE) ,
  "chinese_name" VARCHAR2(255 BYTE) ,
  "mobile_phone_area_code" NUMBER ,
  "mobile_phone" NUMBER ,
  "other_phone_area_code" NUMBER ,
  "other_phone" NUMBER ,
  "email" VARCHAR2(255 BYTE) ,
  "display_order" NUMBER 
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;
COMMENT ON COLUMN "PATIENT"."contact_person"."patient_id" IS 'Person id（foreign key）';
COMMENT ON COLUMN "PATIENT"."contact_person"."relationship" IS 'relationship';
COMMENT ON COLUMN "PATIENT"."contact_person"."english_name" IS 'English name';
COMMENT ON COLUMN "PATIENT"."contact_person"."chinese_name" IS 'Chinese name';
COMMENT ON COLUMN "PATIENT"."contact_person"."mobile_phone_area_code" IS 'Mobile phone area code';
COMMENT ON COLUMN "PATIENT"."contact_person"."mobile_phone" IS 'Mobile phone';
COMMENT ON COLUMN "PATIENT"."contact_person"."other_phone_area_code" IS 'Other phone area code';
COMMENT ON COLUMN "PATIENT"."contact_person"."other_phone" IS 'Other phone';
COMMENT ON COLUMN "PATIENT"."contact_person"."email" IS 'email';
COMMENT ON COLUMN "PATIENT"."contact_person"."display_order" IS 'Display order';

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE "PATIENT"."patient";
CREATE TABLE "PATIENT"."patient" (
  "patient_id" NUMBER NOT NULL ,
  "document_type" VARCHAR2(255 BYTE) ,
  "document_number" NUMBER ,
  "english_surname" VARCHAR2(255 BYTE) ,
  "english_given_name" VARCHAR2(255 BYTE) ,
  "chinese_name" VARCHAR2(255 BYTE) ,
  "date_or_birth" DATE ,
  "sex" VARCHAR2(255 BYTE) ,
  "mobile_phone_area_code" NUMBER ,
  "mobile_phone" NUMBER ,
  "home_phone_area_code" NUMBER ,
  "home_phone" NUMBER ,
  "room" NUMBER ,
  "floor" NUMBER ,
  "block" VARCHAR2(255 BYTE) ,
  "building" VARCHAR2(255 BYTE) ,
  "estate" VARCHAR2(255 BYTE) ,
  "street" VARCHAR2(255 BYTE) ,
  "region" VARCHAR2(255 BYTE) ,
  "district" VARCHAR2(255 BYTE) 
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;
COMMENT ON COLUMN "PATIENT"."patient"."document_type" IS 'Document type';
COMMENT ON COLUMN "PATIENT"."patient"."document_number" IS 'Document number';
COMMENT ON COLUMN "PATIENT"."patient"."english_surname" IS 'English surname';
COMMENT ON COLUMN "PATIENT"."patient"."english_given_name" IS 'English given name';
COMMENT ON COLUMN "PATIENT"."patient"."chinese_name" IS 'Chinese name';
COMMENT ON COLUMN "PATIENT"."patient"."date_or_birth" IS 'Birth day';
COMMENT ON COLUMN "PATIENT"."patient"."sex" IS 'sex';
COMMENT ON COLUMN "PATIENT"."patient"."mobile_phone_area_code" IS 'Mobile phone area code';
COMMENT ON COLUMN "PATIENT"."patient"."mobile_phone" IS 'Mobile phone';
COMMENT ON COLUMN "PATIENT"."patient"."home_phone_area_code" IS 'Home phone area code';
COMMENT ON COLUMN "PATIENT"."patient"."home_phone" IS 'Home phone';
COMMENT ON COLUMN "PATIENT"."patient"."room" IS 'Room ';
COMMENT ON COLUMN "PATIENT"."patient"."floor" IS 'floor';
COMMENT ON COLUMN "PATIENT"."patient"."block" IS 'block';
COMMENT ON COLUMN "PATIENT"."patient"."building" IS 'building';
COMMENT ON COLUMN "PATIENT"."patient"."estate" IS 'estate';
COMMENT ON COLUMN "PATIENT"."patient"."street" IS 'street';
COMMENT ON COLUMN "PATIENT"."patient"."region" IS 'region';
COMMENT ON COLUMN "PATIENT"."patient"."district" IS 'district';

-- ----------------------------
-- Primary Key structure for table contact_person
-- ----------------------------
ALTER TABLE "PATIENT"."contact_person" ADD CONSTRAINT "SYS_C007038" PRIMARY KEY ("contact_person_id");

-- ----------------------------
-- Checks structure for table contact_person
-- ----------------------------
ALTER TABLE "PATIENT"."contact_person" ADD CONSTRAINT "SYS_C007037" CHECK ("contact_person_id" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table patient
-- ----------------------------
ALTER TABLE "PATIENT"."patient" ADD CONSTRAINT "SYS_C007036" PRIMARY KEY ("patient_id");

-- ----------------------------
-- Checks structure for table patient
-- ----------------------------
ALTER TABLE "PATIENT"."patient" ADD CONSTRAINT "SYS_C007035" CHECK ("patient_id" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Foreign Keys structure for table contact_person
-- ----------------------------
ALTER TABLE "PATIENT"."contact_person" ADD CONSTRAINT "CONTACT_PERSON_PATIENT_ID___FK" FOREIGN KEY ("patient_id") REFERENCES "PATIENT"."patient" ("patient_id") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
