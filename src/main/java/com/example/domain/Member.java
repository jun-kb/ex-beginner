package com.example.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Member {
    private Integer id;
    private String name;
    private Integer age;
    private Integer depId;
}
