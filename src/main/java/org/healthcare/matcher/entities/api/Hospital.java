package org.healthcare.matcher.entities.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.util.Arrays;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Value
public class Hospital {
    int id;
    String name;
    String countryCode;
    String address;
    String mapLink;
    String contactPersonId;
    String phone;
    Set<String> supportedLanguages;
    Set<String> translatedLanguages;
    String admissionProtocol;
    int familyAccommodationId;
    String comments;

    public static Hospital from(final org.healthcare.matcher.entities.db.Hospital src) {
        if (src == null) {
            return null;
        }
        Set<String> supportedLanguages = Arrays.stream(src.getSupportedLanguages().split(",")).collect(toSet());
        Set<String> translatedLanguages = Arrays.stream(src.getTranslatedLanguages().split(",")).collect(toSet());
        return new Hospital(src.getId(), src.getName(), src.getCountryCode(), src.getAddress(), src.getMapLink(),
                src.getContactPersonId(), src.getPhone(), supportedLanguages, translatedLanguages,
                src.getAdmissionProtocol(), src.getFamilyAccommodationId(), src.getComments());
    }
}
