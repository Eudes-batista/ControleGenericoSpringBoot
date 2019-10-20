package br.com.aprendendo.demo.repository.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Filter {
    private String searchName;
    private SearchType searchType;
}
