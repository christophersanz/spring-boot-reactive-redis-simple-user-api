package com.habeebcycle.demo.api.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
@Setter
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 7156526077883281623L;

    @Id
    private String id;
    private Date date;
    private String message;

    public User(Date date, String message) {
        this.date = date;
        this.message = message;
    }
}
