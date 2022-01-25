package com.gruntik.foodmatcher.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewModel {

    Long id;
    String reviewTitle;
    String reviewDescription;
    Date reviewDate;
    String photoName;
    String photoURL;

    MultipartFile file;
}
