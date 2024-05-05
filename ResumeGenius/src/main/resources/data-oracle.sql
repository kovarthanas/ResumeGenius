INSERT INTO qualifications (qualification, qualification_type) VALUES
('Bachelor of Science', 'Degree'),
('Master of Business Administration', 'Postgraduate'),
('Certified Public Accountant', 'Certification');

INSERT INTO cv (address_line1, address_line2, city, contact_number, created_date, current_designation, dob,
ed_level_id, experience, gender, headline, modified_date, photo_link, sector_id, skill_id,
status_id, user_id)
VALUES ('123 Main St', 'Apt 101', 'Anytown', '123-456-7890', '2024-05-06 08:00:00', 'Software Engineer',
'1990-01-01', '1', 5, 'Male', 'Experienced software engineer', '2024-05-06 08:00:00', 'http://example.com/photo.jpg',
'1', '2', '1', '1');

INSERT INTO user_role (role_name) VALUES
('Admin'),
('User');

INSERT INTO user (user_id, role_id, title, first_name, last_name, email, password_hash, salt_value,
created_date, modified_date, user_status)
VALUES ('1', '1', 'Mr', 'John', 'Doe', 'john@example.com', 'passwordHash123', 'saltValue123',
'2024-05-06 08:00:00', '2024-05-06 08:00:00', 'Active');

INSERT INTO job_sector (sector_name) VALUES
('Technology'),
('Finance'),
('Healthcare');

INSERT INTO job_sector (sector_name) VALUES
('Technology'),
('Finance'),
('Healthcare');
INSERT INTO skills (skill) VALUES
('Java'),
('SQL'),
('Project Management');
