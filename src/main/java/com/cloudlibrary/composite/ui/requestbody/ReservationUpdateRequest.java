package com.cloudlibrary.composite.ui.requestbody;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReservationUpdateRequest {

    private Long orderNum;
    private Long lendingId;
    private Long uid;
    private Long bookId;
    private Long libraryId;
    private String libraryName;
    private LocalDateTime reservationDateTime;
    private LocalDateTime cancelDateTime;

}
