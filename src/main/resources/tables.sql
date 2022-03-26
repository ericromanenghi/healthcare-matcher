CREATE TABLE IF NOT EXISTS hospitals (
    id INTEGER NOT NULL PRIMARY KEY,
    name TEXT NOT NULL,
    address TEXT NOT NULL,
    map_link TEXT,
    contact_prson_id INTEGER NOT NULL,
    phone TEXT NOT NULL,
    supported_languages TEXT NOT NULL,
    translated_languages TEXT,
    admission_protocol TEXT,
    famility_accomodation_id INTEGER,
    comments TEXT
);

CREATE TABLE IF NOT EXISTS  famility_accomodations (
    id INTEGER NOT NULL PRIMARY KEY,
    status TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS specialized_units (
    id INTEGER NOT NULL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS hospital_specialized_units_map (
    hospital_id INTEGER NOT NULL,
    unit_id INTEGER NOT NULL,
    active BOOLEAN
);

CREATE TABLE IF NOT EXISTS hospital_capabilities (
    id INTEGER NOT NULL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS hospital_capbilities_map (
    hospital_id INTEGER NOT NULL,
    capability_id INTEGER NOT NULL,
    active BOOLEAN
);

CREATE TABLE IF NOT EXISTS hospital_contacts (
    id INTEGER NOT NULL PRIMARY KEY,
    name TEXT NOT NULL,
    phone TEXT,
    email TEXT,
    commment TEXT
);

CREATE TABLE IF NOT EXISTS hospital_specilized_unit_contact_map (
    hospital_id INTEGER NOT NULL,
    specialized_unit_id INTEGER NOT NULL,
    contact_person_id INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS hospital_availability (
    hospital_id INTEGER NOT NULL,
    availability INTEGER NOT NULL,
    emergency_availability INTEGER NOT NULL,
    comment TEXT
);