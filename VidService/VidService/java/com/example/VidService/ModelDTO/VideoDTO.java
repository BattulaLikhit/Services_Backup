package com.example.VidService.ModelDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDTO {
    private Long videoid;
    private String videourl;
    private Long courseId;  
}
