package ru.itis.flux.entries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DataSample {
    private Long id;
    private String title;
    private String url;
    private String from;

}
