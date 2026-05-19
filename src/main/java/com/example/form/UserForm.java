package com.example.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserForm {
    @NotBlank(message = "名前は必須項目です")
    private String name;
    @NotNull(message = "年齢は必須項目です")
    private Integer age;
    @NotBlank(message = "コメントは必須項目です")
    private String comment;
}
