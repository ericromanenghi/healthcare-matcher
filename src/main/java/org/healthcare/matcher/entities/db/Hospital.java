package org.healthcare.matcher.entities.db;

import lombok.Value;

@Value
public class Hospital {
    int id;
    String name;
    String countryCode;
    String address;
    String mapLink;
    String contactPersonId;
    String phone;
    String supportedLanguages;
    String translatedLanguages;
    String admissionProtocol;
    int familyAccommodationId;
    String comments;
}
