package com.cloudlibrary.composite.ui.requestbody;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookStatusUpdateRequest {
    private String bookStatus;
}
