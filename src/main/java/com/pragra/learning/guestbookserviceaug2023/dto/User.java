package com.pragra.learning.guestbookserviceaug2023.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private String login;
    private int id;
    private String avatar_url;
}
