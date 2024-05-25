INSERT INTO address (id, address_line1, address_line2, city, postal_code) VALUES (1, 'ul. Warszawska 24', 'Mieszkanie 5', 'Warszawa', '00-001');
INSERT INTO address (id, address_line1, address_line2, city, postal_code) VALUES (2, 'ul. Krakowska 56', 'Lokal 12', 'Kraków', '31-002');
INSERT INTO address (id, address_line1, address_line2, city, postal_code) VALUES (3, 'ul. Gdańska 78', 'Apartament 34', 'Gdańsk', '80-001');
INSERT INTO address (id, address_line1, address_line2, city, postal_code) VALUES (4, 'ul. Poznańska 89', 'Dom 7', 'Poznań', '60-001');
INSERT INTO address (id, address_line1, address_line2, city, postal_code) VALUES (5, 'ul. Wrocławska 123', 'Budynek 3', 'Wrocław', '50-001');

INSERT INTO doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id) VALUES (1, 'Jan', 'Kowalski', '555-0100', 'jan.kowalski@example.com', 'DOC001', 'GP', 1);
INSERT INTO doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id) VALUES (2, 'Anna', 'Nowak', '555-0200', 'anna.nowak@example.com', 'DOC002', 'SURGEON', 2);

INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, registered_date, address_id) VALUES (1, 'Alicja', 'Wiśniewska', '555-0300', 'alicja.wisniewska@example.com', 'PAT001', '1990-05-15', '2021-01-01', 3);
INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, registered_date, address_id) VALUES (2, 'Robert', 'Lewandowski', '555-0400', 'robert.lewandowski@example.com', 'PAT002', '1985-07-20', '2022-01-01', 4);
INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, registered_date, address_id) VALUES (3, 'Katarzyna', 'Zielińska', '555-0500', 'katarzyna.zielinska@example.com', 'PAT003', '1992-11-11', '2023-03-15', 5);

INSERT INTO visit (id, description, time, patient_id, doctor_id) VALUES (1, 'Annual Checkup', '2023-09-01 10:00:00', 1, 1);
INSERT INTO visit (id, description, time, patient_id, doctor_id) VALUES (2, 'Follow-up Examination', '2023-09-02 11:00:00', 2, 1);
INSERT INTO visit (id, description, time, patient_id, doctor_id) VALUES (3, 'Routine Dental', '2023-09-03 12:00:00', 1, 2);
INSERT INTO visit (id, description, time, patient_id, doctor_id) VALUES (4, 'Emergency Surgery', '2023-09-04 13:00:00', 2, 2);
INSERT INTO visit (id, description, time, patient_id, doctor_id) VALUES (5, 'General Consultation', '2023-09-05 14:00:00', 3, 1);

INSERT INTO medical_treatment (id, description, type) VALUES (1, 'Ultrasound', 'USG');
INSERT INTO medical_treatment (id, description, type) VALUES (2, 'Electrocardiogram', 'EKG');
INSERT INTO medical_treatment (id, description, type) VALUES (3, 'X-ray', 'RTG');

INSERT INTO visit_medical_treatment (visit_id, medical_treatment_id) VALUES (1, 1);
INSERT INTO visit_medical_treatment (visit_id, medical_treatment_id) VALUES (2, 2);
INSERT INTO visit_medical_treatment (visit_id, medical_treatment_id) VALUES (3, 3);
INSERT INTO visit_medical_treatment (visit_id, medical_treatment_id) VALUES (4, 1);
INSERT INTO visit_medical_treatment (visit_id, medical_treatment_id) VALUES (5, 2);

INSERT INTO doctor_patient (doctor_id, patient_id) VALUES (1, 1);
INSERT INTO doctor_patient (doctor_id, patient_id) VALUES (1, 2);
INSERT INTO doctor_patient (doctor_id, patient_id) VALUES (2, 1);