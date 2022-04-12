-- If not created yet, create a database called scrumlords
ROLLBACK;

BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, apartments;

DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) UNIQUE NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE apartments (
	property_id serial,
	-- user_id int NOT NULL,
	address_line_1 varchar(150) NOT NULL,
	address_line_2 varchar(150),
	city varchar(250) NOT NULL,
	state varchar(250) NOT NULL,
	zip decimal NOT NULL,
	price decimal NOT NULL,
	picture text,
	available date NOT NULL,
	num_bedrooms decimal,
	num_bathrooms decimal,
	square_feet int,
	short_description text,
	long_description text,
	
	CONSTRAINT PK_apartments PRIMARY KEY (property_id)
	-- CONSTRAINT FK_apartments_users FOREIGN KEY (user_id) REFERENCES users(user_id)
);
-- Maybe additional fields for timestamp and user input
-- Maybe foriegn key of user_id (linker table?)

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO apartments (
			address_line_1,
			address_line_2,
			city,
			state,
			zip,
			price,
			picture,
			available,
			num_bedrooms,
			num_bathrooms,
			square_feet,
			short_description,
			long_description)
VALUES ('15 Main St.', 
		'Apt. 2',
		'Mapleville', 
		'VT',
		12343,
		1200, 
		'www.google.com', 
		'08/01/2022',
		3,
		2,
		1500,
		'Charming North-End newly constructed duplex unit.',
		'Located on quiet dead-end street\, 
		centrally located to downtown\, greenbelt, and foothills. Application submittal 
		required prior to scheduling walk-through.');
		

INSERT INTO apartments (
			address_line_1,
			
			city,
			state,
			zip,
			price,
			picture,
			available,
			num_bedrooms,
			num_bathrooms,
			square_feet,
			short_description,
			long_description)
VALUES ('433 N. Village Ave', 
		
		'Rockville Center', 
		'NY',
		11343,
		3200, 
		'www.google.com', 
		'12/1/2022',
		3,
		2,
		1800,
		'Available December 1st, 2021 No Pets! 3 bedroom apartment 2nd floor 
		including utilities & high speed internet available ! 1 GB/second ! 
		Parking on the drive way for max 2 cars!',
		
		'This Cute & Cozy Dont Overlook This Hidden Gem!! Close Proximity 
		To Smith Haven Mall, Suffolk Community College, Stony Brook 
		Hospital/University & Route 25A. THIS WILL NOT LAST AGAIN!! Extensive 
		background check and credit references! No pets no exceptions! 
		Required 1 month broker fees 1 month security, paystubs required!! 
		1 year lease $6,000 to move in! Call to schedule a showing');


INSERT INTO apartments (
			address_line_1,
			
			city,
			state,
			zip,
			price,
			picture,
			available,
			num_bedrooms,
			num_bathrooms,
			square_feet,
			short_description,
			long_description)
VALUES ('44 Powell Ave.', 
		
		'Smithtown', 
		'UT',
		98745,
		1700, 
		'www.google.com', 
		'06/01/2022',
		1,
		1,
		900,
		'1 bedroom apartment on second floor with separate living room and 
		eat in kitchen with walk in pantry, Private rear entry and driveway parking.',
		
		'No pets and no smoking. $1700 includes all utilities. Additional fee for AC in 
		summer months. Wifi and cable is the responsibility of the tenant. Available 
		June 5th. 1 month security, 1 month broker fee and first months rent due upfront. 
		Email agent to schedule a showing. HomeSmart Premier Living Realty');
		

INSERT INTO apartments (
			address_line_1,
			
			city,
			state,
			zip,
			price,
			picture,
			available,
			num_bedrooms,
			num_bathrooms,
			square_feet,
			short_description,
			long_description)
VALUES ('155 Prince St.', 
		
		'Archer', 
		'VA',
		45832,
		1200, 
		'www.google.com', 
		'08/01/2022',
		2,
		1,
		2600,
		'Georgeous ,spotless,2nd floor 2 br apartment, just paint it, windows 
		all around with loots of sunlight, washer and dryer.',
		
		'Safe and quiet neiborhoot, close to Adelphi and Hofstra univercities,
		close to Roosvelt field mall and Nassau courts. Close to LIJ ,Winthrop 
		hospitals. You pay 50% of the utilities. Available now. NO SMOKING,NO PETS.Please call Lisa');


INSERT INTO apartments (
			address_line_1,
			
			city,
			state,
			zip,
			price,
			picture,
			available,
			num_bedrooms,
			num_bathrooms,
			square_feet,
			short_description,
			long_description)
VALUES ('37 Hempstead Ave.', 
		
		'Shirley', 
		'TX',
		68741,
		1200, 
		'www.google.com', 
		'05/15/2022',
		1,
		1,
		700,
		'Fairfield at Smithtown Apartment Rental Lovely Ground Level Studio, One Bath Unit. ',
		
		'Rent Includes Heat and Hot Water. Newly Renovated Apartment Rental. Close to Town and 
		Smithtown Train Station! Nestled in a Quaint Residential setting with a short Distance 
		to many Shops, Great Restaurants! Current Special $1000 Security Deposit with Approved Credit. Fairfield 
		at Smithtown offers the Standard of Excellence and Service! This is a cozy community nestled 
		in a park like setting with gorgeous, comfortable modern interiors. Locally we are a short drive 
		to shopping and very close distance to Smithtown historic quaint Village and the Smithtown train station! 
		Pricing may include current special, is subject to change without notice restrictions apply—call for 
		details. All layouts, dimensions and interior finishes are approximate and for display. Call/email/visit with 
		Leasing Agent for full unit details. Equal Housing Opportunity owner/management.');
		

INSERT INTO apartments (
			address_line_1,
			address_line_2,
			city,
			state,
			zip,
			price,
			picture,
			available,
			num_bedrooms,
			num_bathrooms,
			square_feet,
			short_description,
			long_description)
VALUES ('28 Berkshire Rd.', 
		'Apt. 301',
		'West Sayville', 
		'NY',
		78954,
		1200, 
		'www.google.com', 
		'06/01/2022',
		1,
		1,
		1000,
		'Located minutes from Smith Haven Mall, movies, shops, restaurants, 
		and Stony Brook university and Hospital. Our convenient location puts 
		you close to all major high way and LIRR. The BUS station to Stony Brook 
		Hospital and university is nearby.',
		
		'Nice Neighborhood with Security area. Utilities Included No Smoking/No Pets private 
		driveway, separate entrance and more! This is located down the blocks from Stony 
		Brook Hospital and Stony Brook University . Perfect for GRAD Student or Medical 
		Residents. Not good for big family.
		
		Includes all utilities/WiFi. We are looking for long term tenants who can 
		appreciate a place like this and are willing to treat it with care. Serious 
		inquiries only, Pictures on request. You must be able to verify your employment, 
		income and have current references. Subject to credit check.
		
		1 Year lease minimum - First Month Rent . 1 Month Security Deposit at lease 
		signing. Subject to credit check.
		
		THERE ARE NO BROKER FEES - NO SMOKING - NO PETS - SERIOUS INQUIRIES ONLY');


INSERT INTO apartments (
			address_line_1,
			
			city,
			state,
			zip,
			price,
			picture,
			available,
			num_bedrooms,
			num_bathrooms,
			square_feet,
			short_description,
			long_description)
VALUES ('71 Wampum St.', 
		
		'Stamford', 
		'CT',
		59748,
		1200, 
		'www.google.com', 
		'07/01/2022',
		4,
		2,
		1288,
		'A very unique and special property. Located in the mid ridges of 
		Stamford and is situated on .86 of acre. This property was home to 
		a well renowned Excavating company.',
		
		'The yard is still active. Grandfather Contractor yard all began 
		in 1946 and the residence was rebuilt in 1977. The trucks were station 
		on the property, with a two Bay garage with office it can hold two ten 
		wheelers. The home is a cape colonial and consists of 4 bedrooms and 3 
		full baths and comes with a guest suite or it could be used for a work 
		office space. The property is a perfect fit for a contractor that is looking 
		to station all their commercial vehicles. Zoning approval is under review. 
		Submit all offers and addendum of vehicles and its usage. 
		
		This property can also be sub-divided. If contractors yard is not suitable 
		for the interested buyer. Call for more details. Provide your own due diligence. 
		Zoning approval will still be required.');
		

INSERT INTO apartments (
			address_line_1,
			address_line_2,
			city,
			state,
			zip,
			price,
			picture,
			available,
			num_bedrooms,
			num_bathrooms,
			square_feet,
			short_description,
			long_description)
VALUES ('108 Copper St.', 
		'Apt. 202',
		'South Ozone Park', 
		'CO',
		24879,
		4325, 
		'www.google.com', 
		'09/01/2022',
		3,
		2,
		1248,
		'We believe elevating where you live is about blending it seamlessly 
		with how you live. We go to great lengths designing amenities and 
		choosing locations that put everything within reach. ',
		
		'Where you live, is where you come alive. In an area flourishing with 
		convenience, entertainment and possibility, Avalon offers luxury 
		Huntington Station apartments for rent. Walking into our refreshing 
		smoke-free community, you will find thoughtfully designed one-, two- and 
		three- bedroom apartment homes. Imagine entertaining in your contemporary 
		kitchen with cherry or espresso cabinetry, tile backsplashes, and stainless 
		steel appliances. Select homes also offer granite or quartz kitchen and 
		bath countertops. Picture living your life effortlessly, with 
		amenities that include a state-of-the-art fitness center, swimming pool, 
		and easy access to the LIRR Huntington Station. This is not just 
		apartment living. This is living up.
		
		-Balcony -3rd Floor');

--- USER SETUP (Do Not Modify)
DROP USER IF EXISTS final_capstone_owner;
DROP USER IF EXISTS final_capstone_appuser;

DROP USER IF EXISTS final_capstone_owner;
DROP USER IF EXISTS final_capstone_appuser;

CREATE USER final_capstone_owner
WITH PASSWORD 'finalcapstone';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO final_capstone_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_owner;

CREATE USER final_capstone_appuser
WITH PASSWORD 'finalcapstone';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO final_capstone_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_appuser;

COMMIT TRANSACTION;
