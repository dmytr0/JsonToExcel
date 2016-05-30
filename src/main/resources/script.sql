CREATE TABLE visitors (
	visitor_id SERIAL PRIMARY KEY,
	firstName varchar,
	lastName varchar,
	macAddress varchar,
	gender varchar,
	dateOfBirth varchar,
	email varchar,
	phone varchar,
	country varchar,
	city varchar,
	deviceType varchar,
	os varchar,
	vkID varchar,
	facebookID varchar,
	comment varchar
);

CREATE TABLE images (
	image_id SERIAL PRIMARY KEY,
	url varchar,
	visitor_id integer REFERENCES visitors (visitor_id)
);

CREATE TABLE occupation (
	occupation_id SERIAL PRIMARY KEY,
	occupation varchar NOT NULL
);
CREATE TABLE visitor_occupation (
	visitor_id SERIAL REFERENCES visitors (visitor_id),
	occupation_id SERIAL REFERENCES occupation (occupation_id)
);