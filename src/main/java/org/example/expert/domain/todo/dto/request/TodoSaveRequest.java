package org.example.expert.domain.todo.dto.request;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class TodoSaveRequest {

    @NotBlank
    private String title;
    @NotBlank
    private String contents;
}
