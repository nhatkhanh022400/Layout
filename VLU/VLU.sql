CREATE DATABASE VLU
GO

CREATE TABLE AdminAccount
(
	AdminID VARCHAR(10) PRIMARY KEY,
	FirstName NVARCHAR(50) NOT NULL,
	LastName NVARCHAR(50) NOT NULL,
	UserName NVARCHAR(50) NOT NULL,
	PasswordHash VARCHAR(50) NOT NULL,
	Email NVARCHAR(50) NOT NULL,
	ImageAvatar VARBINARY(MAX),
	AccountCreated DATETIME DEFAULT CURRENT_TIMESTAMP
)

CREATE TABLE Department
(
	DepartmentID VARCHAR(10) PRIMARY KEY,
	DepartmentName NVARCHAR(100),
)

CREATE TABLE Learner
(
	LearnerID VARCHAR(10) PRIMARY KEY,
	LearnerName NVARCHAR(100),
	DepartmentID VARCHAR(10) FOREIGN KEY REFERENCES Department(DepartmentID),
	Email NVARCHAR(50) NOT NULL,
	DateOfBirth DATE,
	PhoneNumber CHAR(10),
	ImageAvatar VARCHAR(MAX),
	LearnerCreated DATETIME DEFAULT CURRENT_TIMESTAMP
)

CREATE TABLE OtherCourse
(
	OtherCourseID VARCHAR(10) PRIMARY KEY,
	OtherCourseName NVARCHAR(100),
	LearnerID VARCHAR(10) FOREIGN KEY REFERENCES Learner(LearnerID),
	CertificateImage VARBINARY(MAX),
	StartDate DATE,
	EndDate DATE,
)

CREATE TABLE Mentor
(
	MentorID VARCHAR(10) PRIMARY KEY,
	MentorName NVARCHAR(100),
	MentorPhone CHAR(10),
	MentorEmail NVARCHAR(50),
)

CREATE TABLE Course
(
	CourseID VARCHAR(10) PRIMARY KEY,
	CourseName NVARCHAR(100) NOT NULL,
	MentorID VARCHAR(10) FOREIGN KEY REFERENCES Mentor(MentorID),
	ImageCourse VARBINARY(MAX),
	StartDate DATE,
	EndDate DATE,
	StatusCourse INT DEFAULT '0',
)

CREATE TABLE CourseDetail
(
	CourseDetailID VARCHAR(10) PRIMARY KEY,
	CourseDetailDescription NVARCHAR(MAX) NOT NULL,
	CourseID VARCHAR(10) FOREIGN KEY REFERENCES Course(CourseID),
)

CREATE TABLE CompletedCourse
(
	CompletedCourseID VARCHAR(10) PRIMARY KEY,
	LearnerID VARCHAR(10) FOREIGN KEY REFERENCES Learner(LearnerID),
	CourseID VARCHAR(10) FOREIGN KEY REFERENCES Course(CourseID),
	StartDate DATE,
	EndDate DATE,
)

CREATE TABLE UnFinishedCourse
(
	UnFinishedCourseID VARCHAR(10) PRIMARY KEY,
	LearnerID VARCHAR(10) FOREIGN KEY REFERENCES Learner(LearnerID),
	CourseID VARCHAR(10) FOREIGN KEY REFERENCES Course(CourseID),
)

CREATE TABLE Participation
(
	ParticipationID VARCHAR(10) PRIMARY KEY,
	CourseID VARCHAR(10) FOREIGN KEY REFERENCES Course(CourseID),
	LearnerID VARCHAR(10) FOREIGN KEY REFERENCES Learner(LearnerID),
)

INSERT INTO AdminAccount(AdminID, FirstName, LastName, UserName, PasswordHash, Email)
VALUES ('dwuCL9vhxq', 'Tran', 'Khanh', 'admin', '51216c9fb35f71a3dc52227dbef1a9b3', 'khanh.187it20849@vanlanguni.vn')

alter table Learner
alter column LearnerName NVARCHAR(100) null;

DELETE FROM Course WHERE CourseID = 'yIUdkQFKRC';
DELETE FROM CourseDetail WHERE CourseID = 'yIUdkQFKRC';