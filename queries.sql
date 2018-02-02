DROP TABLE BOOKING_INFO CASCADE CONSTRAINT;

CREATE TABLE BOOKING_INFO(
     Booking_Id number,
     cust_email varchar2(10),
     no_of_passengers number,
     class_type varchar2(10),
     total_fare number(10,2),
     seat_number number,
     CreditCard_info varchar2(12),
     src_city varchar2(10),
     dest_city varchar2(10)
);

DROP sequence book_id_seq;

create sequence book_id_seq start with 1000;

create sequence seat_id_seq 
     start with 1 
     increment by 1
     maxvalue 500
     cycle;


select * from BOOKING_INFO;






