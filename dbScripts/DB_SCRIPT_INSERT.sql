INSERT INTO `outreach_vfs`.`location`
(`city`, `state`, `country`)
VALUES
('Coimbatore','Tamil Nadu','India'),
('Kolkata','West Bengal','India');

INSERT INTO `outreach_vfs`.`business_unit`
(`buss_unit_name`, `location_id`)
VALUE
('Insurance-CCC',1),
('Insurance-KNC',2);

INSERT INTO `outreach_vfs`.`event_beneficiary`
(`description`)
VALUES
('KMCH Group of Hospitals'),
('OOTY Higher Secondary School');

INSERT INTO `outreach_vfs`.`event_council`
(`council_name`,`location_id`)
VALUES
('COUNCIL ABC', 1),
('COUNCIL DEF', 2);

INSERT INTO `outreach_vfs`.`role_lookup`
(`description`)
VALUES
('Admin'), ('POC'), ('Volunteer');

INSERT INTO `outreach_vfs`.`feedback_options`
(`description`)
VALUES
('Unexpected Family commitment'),('Unexpected official work'),
('Event was not what I expected'),('Didnot recieve further information about event'),
('Incorrectly registered'),('Donot wish to disclose');

INSERT INTO `outreach_vfs`.`rating`
(`description`)
VALUES
('Very Good'), ('Good'), ('Neutral'), ('Poor'), ('Very Poor');

INSERT INTO `outreach_vfs`.`iiep_category`
(`description`)
VALUES
('IIEP 1'), ('IIEP 2'), ('IIEP 3'), ('IIEP 4'), ('IIEP 5');


INSERT INTO `outreach_vfs`.`status`
(`description`)
VALUES
('Active'), ('UnRegistered'), ('Registered'), ('Failed To Attend'), ('Completed'), ('Attended');

INSERT INTO `outreach_vfs`.`project`
(`description`)
VALUES
('Donation or Distribution'), ('Be a Teacher'), ('Community Program');

INSERT INTO `outreach_vfs`.`category`
(`description`)
VALUES
('Essentials or relief'), ('Multiple Subjects'), ('Other Community Programs'), ('English'), ('Other Subject');

INSERT INTO `outreach_vfs`.`employee`
(`employee_id`,
`emp_first_name`,
`emp_last_name`,
`emp_email`,
`Contact`,
`emp_location_id`,
`business_unit_id`,
`evnt_volunteer_hours`,
`role_id`,
`password`,
`employee_status_id`)
VALUES
(512641,
'Logeshwara', 'Raja K', ' logeshwararaja.k@cognizant.com','8056245629',1,1,8,1,'logesh',1);

INSERT INTO `outreach_vfs`.`event`
(`id`,`month`,`evnt_base_location_id`,`evnt_benef_id`,
`evnt_name`,
`venue_address`,
`project_id`,
`category_id`,
`evnt_description`,
`evnt_date`,
`event_poc's`,
`total_volunteers`,
`total_volunteer_hrs`,
`total_travel_hrs`,
`overall_volunteer_hrs`,
`lives_impacted`,
`iiep_category_id`,
`event_council_id`,
`created_by_id`)
VALUES
(123456, 'JAN',1,2,'Be A teacher','705, Serangoon Road, Singapore, Singapore, Singapore-328127',
1,1,'Teach various subjects to the students in Kamarajar Illam',current_date(),'512641,512642',
10,20,10,30,100,4,1,519847),
('EVNT00046103', 'JAN',1,2,'Be A teacher','705, Serangoon Road, Singapore, Singapore, Singapore-328127',
1,1,'Teach various subjects to the students in Kamarajar Illam',current_date(),'512641,512642',
10,20,10,30,100,4,1,519847);

INSERT INTO `outreach_vfs`.`event_details`
(`evnt_id`,`employee_id`,`volunteer_hrs`,`travel_hrs`,`participation_status_id`,
`feedback_status_id`,`created_by_id`)
VALUES
(123456,512641,2,1,2,2,512641),
(123456,512641,2,1,4,2,512641),
(123456,512641,2,1,6,2,512641),
(123456,512641,2,1,2,2,512641),
(123456,512641,2,1,4,2,512641),
(123456,512641,2,1,6,2,512641);

INSERT INTO `outreach_vfs`.`event_details`
(`evnt_id`,`employee_id`,`volunteer_hrs`,`travel_hrs`,`participation_status_id`,
`feedback_status_id`,`created_by_id`)
VALUES
('EVNT00046103',512641,2,1,2,2,512641),
('EVNT00046103',512641,2,1,4,2,512641),
('EVNT00046103',512641,2,1,6,2,512641),
('EVNT00046103',512641,2,1,2,2,512641),
('EVNT00046103',512641,2,1,4,2,512641),
('EVNT00046103',512641,2,1,6,2,512641);


INSERT INTO `outreach_vfs`.`feedback`
(`event_detail_id`,`rating`,`feedback_option_id`,`like_feedback`,`improve_feedback`,`admin_feedback`,
`update_id`)
VALUES
(1,1,1,'Enjoyed it','Food Taste','Looking into it', 512641),
(2,2,2,'Enjoyed it','Food Taste','Looking into it', 512641),
(3,3,3,'Enjoyed it','Food Taste','Looking into it', 512641),
(4,4,4,'Enjoyed it','Food Taste','Looking into it', 512641),
(5,5,5,'Enjoyed it','Food Taste','Looking into it', 512641),
(6,1,1,'Enjoyed it','Food Taste','Looking into it', 512641),
(7,2,2,'Enjoyed it','Food Taste','Looking into it', 512641),
(8,3,3,'Enjoyed it','Food Taste','Looking into it', 512641),
(9,4,4,'Enjoyed it','Food Taste','Looking into it', 512641),
(10,5,5,'Enjoyed it','Food Taste','Looking into it', 512641),
(11,1,1,'Enjoyed it','Food Taste','Looking into it', 512641),
(12,2,2,'Enjoyed it','Food Taste','Looking into it', 512641),
(13,3,3,'Enjoyed it','Food Taste','Looking into it', 512641),
(14,4,4,'Enjoyed it','Food Taste','Looking into it', 512641);
